package xyz.chz.bfm.util;

import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public final class MagiskHelper {
    private static final String TAG = "BoxForMagisk.MagiskHelper";
    public static final boolean IS_MAGISK_LITE = "lite".equals(execRootCmd("magisk -v | grep -o lite"));

    public static String execRootCmd(String cmd) {
        StringBuilder result = new StringBuilder();

        try {
            Process process = Runtime.getRuntime().exec("su");
            DataOutputStream dos = new DataOutputStream(process.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            Log.i(TAG, cmd);
            dos.writeBytes(cmd + "\n");
            dos.flush();
            dos.writeBytes("exit\n");
            dos.flush();

            String line;
            while ((line = reader.readLine()) != null) {
                Log.d("result", line);
                result.append(line).append('\n');
            }

            process.waitFor();
            dos.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result.toString().trim();
    }

    public static int execRootCmdSilent(String cmd) {
        int result = -1;

        try {
            Process process = Runtime.getRuntime().exec("su");
            DataOutputStream dos = new DataOutputStream(process.getOutputStream());

            Log.i(TAG, cmd);
            dos.writeBytes(cmd + "\n");
            dos.flush();
            dos.writeBytes("exit\n");
            dos.flush();

            process.waitFor();
            result = process.exitValue();

            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void execRootCmdVoid(String cmd, Callback callback) {
        try {
            Process process = Runtime.getRuntime().exec("su -c " + cmd);
            Log.i(TAG, cmd);
            process.waitFor();
            callback.onResult(process.exitValue() == 0);
        } catch (Exception e) {
            e.printStackTrace();
            callback.onResult(false);
        }
    }

    public interface Callback {
        void onResult(boolean isSucceed);
    }
}