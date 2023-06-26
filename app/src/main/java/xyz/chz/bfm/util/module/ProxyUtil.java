package xyz.chz.bfm.util.module;

import android.util.Log;

import xyz.chz.bfm.util.MagiskHelper;

import java.util.HashSet;

public class ProxyUtil {
    public static final String TAG = "ProxyUtil";
    
    public static boolean isWhiteListMode() {
        return "whitelist"
                .equals(
                        MagiskHelper.execRootCmd(
                                "grep 'proxy_mode' /data/adb/box/settings.ini | sed 's/^.*=//' | sed 's/\"//g'"));
    }
    
    public static HashSet<String> getAppidList() {
        HashSet<String> s = new HashSet<>();
        String cmd =
                "grep 'packages_list' /data/adb/box/settings.ini | sed 's/^.*=//' | sed 's/(//g' | sed 's/)//g' | awk 'END{print}'";
        String result = MagiskHelper.execRootCmd(cmd);
        if ("".equals(result)) {
            return s;
        }
        String[] appIds = result.split(" ");
        for (String i : appIds) {
            s.add(i);
        }
        return s;
    }
    
    public static boolean setAppidList() {
        return MagiskHelper.execRootCmdSilent(
                "sed -i 's/packages_list=.*/packages_list=()/;' /data/adb/box/settings.ini")
                != -1;
    }
    
    public static boolean setAppidList(HashSet<String> s, String mode) {
        if (s.size() == 0) {
            return setAppidList();
        }
        StringBuilder cmd = new StringBuilder("sed -i 's/packages_list=.*/packages_list=( ");
        // cmd.append(mode).append("\\n");
        for (String i : s) {
            cmd.append(i).append(" ");
        }
        cmd.append(")/;' /data/adb/box/settings.ini");
        return MagiskHelper.execRootCmdSilent(cmd.toString().trim()) != -1;
    }
    
    public static String getCore() {
        return MagiskHelper.execRootCmd(
                "grep 'bin_name=' /data/adb/box/settings.ini | sed 's/^.*=//g'");
    }
    
    public static boolean setCore(String x) {
        return MagiskHelper.execRootCmdSilent(
                "sed -i 's/bin_name=.*/bin_name=" + x + "/;' /data/adb/box/settings.ini")
                != -1;
    }
    
    public static boolean isWL() {
        return MagiskHelper.execRootCmdSilent(
                "sed -i 's/proxy_mode=.*/proxy_mode=\"whitelist\"/;' /data/adb/box/settings.ini")
                != -1;
    }
    
    public static boolean isBL() {
        return MagiskHelper.execRootCmdSilent(
                "sed -i 's/proxy_mode=.*/proxy_mode=\"blacklist\"/;' /data/adb/box/settings.ini")
                != -1;
    }
    
    // sed '0,/bin_name.*/s//bin_name=$c/' /data/adb/box/settings.ini
    
    public static String isReadLog() {
        return MagiskHelper.execRootCmd("cat /data/adb/box/run/runs.log");
    }
    
    public static boolean restartBFMService() {
        return MagiskHelper.execRootCmdSilent("/data/adb/box/scripts/box.service restart") != -1;
    }
    
    public static boolean startBFMService() {
        return MagiskHelper.execRootCmdSilent("/data/adb/box/scripts/box.service start") != -1;
    }
    
    public static boolean stopBFMService() {
        return MagiskHelper.execRootCmdSilent("/data/adb/box/scripts/box.service stop") != -1;
    }
    
    public static boolean renewBoxIptables() {
        return MagiskHelper.execRootCmdSilent("/data/adb/box/scripts/box.iptables renew") != -1;
    }
    
    public static boolean enableBoxIptables() {
        return MagiskHelper.execRootCmdSilent("/data/adb/box/scripts/box.iptables enable") != -1;
    }
    
    public static boolean disableBoxIptables() {
        return MagiskHelper.execRootCmdSilent("/data/adb/box/scripts/box.iptables disable") != -1;
    }
    
    public static void start(MagiskHelper.Callback callback) {
        new Thread(
                () -> {
                    String cmd =
                            "/data/adb/box/scripts/box.service start && /data/adb/box/scripts/box.iptables enable";
                    MagiskHelper.execRootCmdVoid(cmd, callback);
                })
                .start();
    }
    
    public static void stop(MagiskHelper.Callback callback) {
        new Thread(
                () -> {
                    String cmd =
                            "/data/adb/box/scripts/box.iptables disable && /data/adb/box/scripts/box.service stop";
                    MagiskHelper.execRootCmdVoid(cmd, callback);
                })
                .start();
    }
    
    public static boolean isProxying() {
        return MagiskHelper.execRootCmdSilent(
                "if [ -f /data/adb/box/run/box.pid ] ; then exit 1;fi")
                == 1;
    }
    
    public static boolean isOff() {
        int i = MagiskHelper.execRootCmdSilent(
                "if [ -f /data/adb/modules/box_for_root/disable ] ; then exit 1;fi");
        Log.d(TAG, "isOff: " + i);
        return i == 1;
    }
}
