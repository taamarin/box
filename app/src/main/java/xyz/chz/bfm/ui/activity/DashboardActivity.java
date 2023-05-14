package xyz.chz.bfm.ui.activity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import xyz.chz.bfm.databinding.ActivityDashboardBinding;
import xyz.chz.bfm.ui.activity.base.BaseActivity;
import xyz.chz.bfm.util.module.TermUtil;

public class DashboardActivity extends BaseActivity {

    ActivityDashboardBinding binding;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.wb.loadUrl("http://" + TermUtil.getLinkController() + "/ui/#/proxies");
        WebSettings ws = binding.wb.getSettings();
        ws.setAppCacheMaxSize(5 * 1024 * 1024);
        ws.setDomStorageEnabled(true);
        ws.setDatabaseEnabled(true);
        ws.setJavaScriptEnabled(true);
        ws.setCacheMode(2);
        binding.wb.setWebViewClient(new WebViewClient());
    }
}
