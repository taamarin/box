package xyz.chz.bfm.util.theme;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.ColorRes;
import androidx.annotation.StyleRes;

import java.util.HashMap;
import java.util.Map;

import xyz.chz.bfm.App;
import xyz.chz.bfm.R;
import rikka.core.util.ResourceUtils;
import rikka.material.app.DayNightDelegate;

public final class ThemeUtil {
    private static final SharedPreferences preferences = App.getPreferences();

    public static final String MODE_NIGHT_FOLLOW_SYSTEM = "MODE_NIGHT_FOLLOW_SYSTEM";
    public static final String MODE_NIGHT_NO = "MODE_NIGHT_NO";
    public static final String MODE_NIGHT_YES = "MODE_NIGHT_YES";

    private static final String THEME_DEFAULT = "DEFAULT";
    private static final String THEME_BLACK = "BLACK";

    private static final Map<String, Integer> colorThemeMap = new HashMap<>();

    static {
        colorThemeMap.put("COLOR_PRIMARY", R.style.ThemeOverlay_color_primary);
        colorThemeMap.put("MATERIAL_RED", R.style.ThemeOverlay_material_red);
        colorThemeMap.put("MATERIAL_PINK", R.style.ThemeOverlay_material_pink);
        colorThemeMap.put("MATERIAL_PURPLE", R.style.ThemeOverlay_material_purple);
        colorThemeMap.put("MATERIAL_DEEP_PURPLE", R.style.ThemeOverlay_material_deep_purple);
        colorThemeMap.put("MATERIAL_INDIGO", R.style.ThemeOverlay_material_indigo);
        colorThemeMap.put("MATERIAL_BLUE", R.style.ThemeOverlay_material_blue);
        colorThemeMap.put("MATERIAL_LIGHT_BLUE", R.style.ThemeOverlay_material_light_blue);
        colorThemeMap.put("MATERIAL_CYAN", R.style.ThemeOverlay_material_cyan);
        colorThemeMap.put("MATERIAL_TEAL", R.style.ThemeOverlay_material_teal);
        colorThemeMap.put("MATERIAL_GREEN", R.style.ThemeOverlay_material_green);
        colorThemeMap.put("MATERIAL_LIGHT_GREEN", R.style.ThemeOverlay_material_light_green);
        colorThemeMap.put("MATERIAL_LIME", R.style.ThemeOverlay_material_lime);
        colorThemeMap.put("MATERIAL_YELLOW", R.style.ThemeOverlay_material_yellow);
        colorThemeMap.put("MATERIAL_AMBER", R.style.ThemeOverlay_material_amber);
        colorThemeMap.put("MATERIAL_ORANGE", R.style.ThemeOverlay_material_orange);
        colorThemeMap.put("MATERIAL_DEEP_ORANGE", R.style.ThemeOverlay_material_deep_orange);
        colorThemeMap.put("MATERIAL_BROWN", R.style.ThemeOverlay_material_brown);
        colorThemeMap.put("MATERIAL_GREY", R.style.ThemeOverlay_material_grey);
        colorThemeMap.put("MATERIAL_BLUE_GREY", R.style.ThemeOverlay_material_blue_grey);
    }

    private static boolean isBlackNightTheme() {
        return preferences.getBoolean("black_dark_theme", false);
    }

    public static String getNightTheme(Context context) {
        if (isBlackNightTheme() && ResourceUtils.isNightMode(context.getResources().getConfiguration())) {
            return THEME_BLACK;
        }
        return THEME_DEFAULT;
    }

    @StyleRes
    public static int getNightThemeStyleRes(Context context) {
        switch (getNightTheme(context)) {
            case THEME_BLACK:
                return R.style.ThemeOverlay_Black;
            case THEME_DEFAULT:
            default:
                return R.style.ThemeOverlay;
        }
    }

    public static String getColorTheme() {
        return preferences.getString("theme_color", "COLOR_PRIMARY");
    }

    @StyleRes
    public static int getColorThemeStyleRes() {
        Integer theme = colorThemeMap.get(getColorTheme());
        if (theme == null) {
            return R.style.ThemeOverlay_color_primary;
        }
        return theme;
    }

    public enum CustomThemeColors {
        COLOR_PRIMARY(R.color.color_primary),
        MATERIAL_RED(R.color.material_red),
        MATERIAL_PINK(R.color.material_pink),
        MATERIAL_PURPLE(R.color.material_purple),
        MATERIAL_DEEP_PURPLE(R.color.material_deep_purple),
        MATERIAL_INDIGO(R.color.material_indigo),
        MATERIAL_BLUE(R.color.material_blue),
        MATERIAL_LIGHT_BLUE(R.color.material_light_blue),
        MATERIAL_CYAN(R.color.material_cyan),
        MATERIAL_TEAL(R.color.material_teal),
        MATERIAL_GREEN(R.color.material_green),
        MATERIAL_LIGHT_GREEN(R.color.material_light_green),
        MATERIAL_LIME(R.color.material_lime),
        MATERIAL_YELLOW(R.color.material_yellow),
        MATERIAL_AMBER(R.color.material_amber),
        MATERIAL_ORANGE(R.color.material_orange),
        MATERIAL_DEEP_ORANGE(R.color.material_deep_orange),
        MATERIAL_BROWN(R.color.material_brown),
        MATERIAL_GREY(R.color.material_grey),
        MATERIAL_BLUE_GREY(R.color.material_blue_grey);

        @ColorRes
        private final int resourceId;

        CustomThemeColors(@ColorRes int resourceId) {
            this.resourceId = resourceId;
        }

        @ColorRes
        public int getResourceId() {
            return resourceId;
        }
    }

    public static int getDarkTheme(String mode) {
        switch (mode) {
            case MODE_NIGHT_FOLLOW_SYSTEM:
            default:
                return DayNightDelegate.MODE_NIGHT_FOLLOW_SYSTEM;
            case MODE_NIGHT_YES:
                return DayNightDelegate.MODE_NIGHT_YES;
            case MODE_NIGHT_NO:
                return DayNightDelegate.MODE_NIGHT_NO;
        }
    }

    public static int getDarkTheme() {
        return getDarkTheme(preferences.getString("dark_theme", MODE_NIGHT_FOLLOW_SYSTEM));
    }
}