package xyz.chz.bfm;

import xyz.chz.bfm.adapters.AppListAdapter;
import xyz.chz.bfm.util.MagiskHelper;
import xyz.chz.bfm.util.module.ProxyUtil;

import java.util.HashSet;

public class ConfigManager {

    public static String getModuleVersionCode() {
        String cmd = "cat /data/adb/modules/box_for_root/module.prop | grep '^versionCode='";
        if (MagiskHelper.IS_MAGISK_LITE) {
            cmd = "cat /data/adb/lite_modules/box_for_root/module.prop | grep '^versionCode='";
        }
        String result = MagiskHelper.execRootCmd(cmd);
        return "".equals(result) ? "" : result.split("=")[1];
    }

    public static String getModuleVersion() {
        String cmd = "cat /data/adb/modules/box_for_root/module.prop | grep '^version='";
        if (MagiskHelper.IS_MAGISK_LITE) {
            cmd = "cat /data/adb/lite_modules/box_for_root/module.prop | grep '^version='";
        }
        String result = MagiskHelper.execRootCmd(cmd);
        return "".equals(result) ? "" : result.split("=")[1];
    }
}
