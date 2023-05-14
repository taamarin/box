package xyz.chz.bfm.util;

import android.content.ClipData;
import android.content.Context;
import android.content.ClipboardManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import android.os.Build.VERSION;

public class HttpGetter {
    public static String get(String link, String what) {
        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(4000);
            try (BufferedReader reader =
                    new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                for (String line; (line = reader.readLine()) != null; ) {
                    result.append(line);
                }
            }
            JSONObject geo = new JSONObject(result.toString());
            StringBuffer sb = new StringBuffer();
            sb.append(geo.getString(what));
            conn.disconnect();
            return sb.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static String getConfig(String link) {
        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            try (BufferedReader reader =
                    new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                for (String line; (line = reader.readLine()) != null; ) {
                    result.append(line).append("\n");
                }
            }
            conn.disconnect();
            return result.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static String geoo() {
        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL("http://ip-api.com/json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(4000);
            try (BufferedReader reader =
                    new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                for (String line; (line = reader.readLine()) != null; ) {
                    result.append(line);
                }
            }
            JSONObject geo = new JSONObject(result.toString());
            StringBuffer sb = new StringBuffer();
            sb.append("\n").append("ISP: ").append(geo.getString("isp"));
            sb.append("\n").append("Time Zone: ").append(geo.getString("timezone"));
            sb.append("\n").append("Country Code: ").append(geo.getString("countryCode"));
            sb.append("\n").append("Country: ").append(geo.getString("country"));
            sb.append("\n").append("Region: ").append(geo.getString("regionName"));
            sb.append("\n").append("City: ").append(geo.getString("city"));

            conn.disconnect();
            return sb.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static void copyToClipboard(Context context, String str) {
        if (VERSION.SDK_INT >= 11) {
            ((ClipboardManager) context.getSystemService("clipboard"))
                    .setPrimaryClip(ClipData.newPlainText("log", str));
        } else {
            ((android.text.ClipboardManager) context.getSystemService("clipboard")).setText(str);
        }
    }
}
