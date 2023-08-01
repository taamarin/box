package xyz.chz.bfm.ui.activity.base;

import android.app.AlertDialog;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import androidx.annotation.NonNull;
import xyz.chz.bfm.R;
import xyz.chz.bfm.ConfigManager;
import xyz.chz.bfm.util.NavUtil;
import xyz.chz.bfm.util.module.ProxyUtil;
import xyz.chz.bfm.util.theme.ThemeUtil;
import rikka.core.res.ResourcesKt;
import rikka.material.app.MaterialActivity;

import java.util.HashSet;

public class BaseActivity extends MaterialActivity {
    public static final String MODULE_VERSION_CODE = ConfigManager.getModuleVersionCode();
    public static final String MODULE_VERSION = ConfigManager.getModuleVersion();
    public static final HashSet<String> UIDS = ProxyUtil.getAppidList();
    public static boolean whiteListMode = ProxyUtil.isWhiteListMode();
    public static boolean isProxying = ProxyUtil.isProxying();

    @Override
    public void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ("".equals(MODULE_VERSION_CODE)) {
            // module install check
            new AlertDialog.Builder(this)
                .setMessage(R.string.need_install_module)
                .setPositiveButton(
                    android.R.string.ok,
                    (dialog, id) -> {
                        NavUtil.startURL(this, getString(R.string.module_repo_url));
                        finish();
                    })
                .setCancelable(false)
                .show();
        } else {
            if (Integer.parseInt(MODULE_VERSION_CODE)
                    < Integer.parseInt(getString(R.string.min_module_version))) {
                // module version check
                new AlertDialog.Builder(this)
                    .setMessage(
                        String.format(
                            getString(R.string.need_update_module),
                            getString(R.string.min_module_version)))
                    .setPositiveButton(
                        android.R.string.ok,
                        (dialog, id) -> {
                            NavUtil.startURL(this, getString(R.string.module_repo_url));
                            finish();
                        })
                    .setCancelable(false)
                    .show();
            }
        }
    }

    @Override
    public void onApplyUserThemeResource(Resources.Theme theme, boolean isDecorView) {
        theme.applyStyle(ThemeUtil.getNightThemeStyleRes(this), true);
        theme.applyStyle(ThemeUtil.getColorThemeStyleRes(), true);
    }

    @Override
    public String computeUserThemeKey() {
        return ThemeUtil.getColorTheme() + ThemeUtil.getNightTheme(this);
    }

    @Override
    public void onApplyTranslucentSystemBars() {
        super.onApplyTranslucentSystemBars();
        Window window = getWindow();
        window.setStatusBarColor(Color.TRANSPARENT);

        window.getDecorView()
            .post(
                () -> {
                    if (window.getDecorView()
                                    .getRootWindowInsets()
                                    .getSystemWindowInsetBottom()
                            >= Resources.getSystem().getDisplayMetrics().density * 40) {
                        window.setNavigationBarColor(
                                ResourcesKt.resolveColor(
                                                        getTheme(),
                                                        android.R.attr.navigationBarColor)
                                                & 0x00ffffff
                                        | -0x20000000);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                            window.setNavigationBarContrastEnforced(false);
                        }
                    } else {
                        window.setNavigationBarColor(Color.TRANSPARENT);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                            window.setNavigationBarContrastEnforced(true);
                        }
                    }
                });
    }
}
