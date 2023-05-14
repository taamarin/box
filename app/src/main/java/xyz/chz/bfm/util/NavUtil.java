package xyz.chz.bfm.util;

import android.net.Uri;
import xyz.chz.bfm.ui.activity.base.BaseActivity;
import rikka.core.res.ResourcesKt;
import rikka.core.util.ResourceUtils;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsIntent;

public final class NavUtil {

    public static void startURL(BaseActivity activity, Uri uri) {
        CustomTabsIntent.Builder customTabsIntent = new CustomTabsIntent.Builder();
        customTabsIntent.setShowTitle(true);
        CustomTabColorSchemeParams params = new CustomTabColorSchemeParams.Builder()
                .setToolbarColor(ResourcesKt.resolveColor(activity.getTheme(), android.R.attr.colorBackground))
                .setNavigationBarColor(ResourcesKt.resolveColor(activity.getTheme(), android.R.attr.navigationBarColor))
                .setNavigationBarDividerColor(0)
                .build();
        customTabsIntent.setDefaultColorSchemeParams(params);
        boolean night = ResourceUtils.isNightMode(activity.getResources().getConfiguration());
        customTabsIntent.setColorScheme(night ? CustomTabsIntent.COLOR_SCHEME_DARK : CustomTabsIntent.COLOR_SCHEME_LIGHT);
        customTabsIntent.build().launchUrl(activity, uri);
    }

    public static void startURL(BaseActivity activity, String url) {
        startURL(activity, Uri.parse(url));
    }
}
