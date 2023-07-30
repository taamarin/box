package xyz.chz.bfm.util;

import xyz.chz.bfm.ConfigManager;
import xyz.chz.bfm.util.HttpGetter;

public class CheckUpdate {

    public static boolean check() {
        try {
            int versiWeb =
                    Integer.parseInt(
                            HttpGetter.get(
                                    "https://raw.githubusercontent.com/taamarin/box_for_magisk/master/update.json",
                                    "versionCode"));
            int versiNow = Integer.parseInt(ConfigManager.getModuleVersionCode());

            if (versiNow < versiWeb) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static String getVer() {
        try {
            return HttpGetter.get(
                    "https://raw.githubusercontent.com/taamarin/box_for_magisk/master/update.json",
                    "versionCode");
        } catch (Exception e) {
            return null;
        }
    }
}
