package xyz.chz.bfm.ui.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Html;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

import java.io.UnsupportedEncodingException;

import xyz.chz.bfm.R;
import xyz.chz.bfm.databinding.ActivityMainBinding;
import xyz.chz.bfm.ui.activity.ConfigActivity;
import xyz.chz.bfm.ui.activity.DashboardActivity;
import xyz.chz.bfm.ui.activity.MainActivity;
import xyz.chz.bfm.ui.activity.base.BaseActivity;
import xyz.chz.bfm.util.CheckUpdate;
import xyz.chz.bfm.util.GlideHelper;
import xyz.chz.bfm.util.HttpGetter;
import xyz.chz.bfm.util.NavUtil;
import xyz.chz.bfm.service.MyTileService;
import xyz.chz.bfm.util.module.ProxyUtil;
import xyz.chz.bfm.util.module.TermUtil;
import rikka.core.res.ResourcesKt;

public class MainActivity extends BaseActivity {
    ActivityMainBinding binding;
    
    private SharedPreferences sp;
    private Thread t;
    private String bb;
    
    private String mm = "";
    private String format = "";
    private String mode = "";
    private String vpnGet = "";
    private String cc = "";
    private String tls = "";
    private String network = "";
    private String sni = "";
    private String cdn = "";
    private String limit = "";
    
    @Override
    public void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sp = getSharedPreferences("CHZPrefCustom", 0);
        binding.proxy.setOnClickListener(
                v -> {
                    setProxyCard("loading");
                    v.setClickable(false);
                    if (BaseActivity.isProxying) {
                        ProxyUtil.stop(isSucceed -> {
                            runOnUiThread(
                                    () -> {
                                        if (isSucceed) {
                                            setProxyCard("disabled");
                                            BaseActivity.isProxying = false;
                                        } else {
                                            setProxyCard("error");
                                            BaseActivity.isProxying = true;
                                        }
                                        v.setClickable(true);
                                    });
                        });
                    } else {
                        ProxyUtil.start(isSucceed -> {
                            runOnUiThread(
                                    () -> {
                                        if (isSucceed) {
                                            setProxyCard("enabled");
                                            BaseActivity.isProxying = true;
                                        } else {
                                            setProxyCard("error");
                                            BaseActivity.isProxying = false;
                                        }
                                        v.setClickable(true);
                                    });
                        });
                    }
                });
        binding.settings.setOnClickListener(
                v -> {
                    settingCall();
                });
        binding.apps.setOnClickListener(new StartActivityListener(AppListActivity.class));
        binding.dashboard.setOnClickListener(new StartActivityListener(DashboardActivity.class));
        t =
                new Thread() {
                    
                    @Override
                    public void run() {
                        try {
                            while (!isInterrupted()) {
                                Thread.sleep(1500);
                                runOnUiThread(
                                        new Runnable() {
                                            @Override
                                            public void run() {
                                                bb = ProxyUtil.isReadLog();
                                                binding.logStatus.setText(
                                                        Html.fromHtml(
                                                                bb.replaceAll(
                                                                                "\\[Info\\]",
                                                                                "<font color=\"#58869e\">[Info] </font>")
                                                                        .replaceAll(
                                                                                "\\[Debug\\]",
                                                                                "<font color=\"#156238\">[Debug] </font>")
                                                                        .replaceAll(
                                                                                "\\[Error\\]",
                                                                                "<font color=\"#8e2e41\">[Error] </font>")
                                                                        .replaceAll(
                                                                                "\\[Warning\\]",
                                                                                "<font color=\"#fe9a01\">[Warning] </font>")
                                                                        .replaceAll("\n", "<br>")));
                                                if (sp.getBoolean("cbScroLog", false)) {
                                                    binding.svLOG.fullScroll(View.FOCUS_DOWN);
                                                }
                                            }
                                        });
                            }
                        } catch (InterruptedException e) {
                        }
                    }
                };
        if (sp.getBoolean("cbLog", false)) {
            t.start();
        }
        
        Glide.with(binding.appIcon)
                .load(GlideHelper.wrapApplicationInfoForIconLoader(getApplicationInfo()))
                .into(binding.appIcon);
        if ("".equals(MODULE_VERSION_CODE)) {
            setProxyCard("");
        } else if (BaseActivity.isProxying) {
            setProxyCard("enabled");
            binding.appsSummary.setText(
                    String.format(
                            getString(R.string.app_count_in_list),
                            UIDS.size(),
                            whiteListMode
                            ? getString(R.string.whitelist)
                            : getString(R.string.blacklist)));
        } else {
            setProxyCard("disabled");
            binding.appsSummary.setText(
                    String.format(
                            getString(R.string.app_count_in_list),
                            UIDS.size(),
                            whiteListMode
                            ? getString(R.string.whitelist)
                            : getString(R.string.blacklist)));
        }
        if (sp.getBoolean("cbLog", false)) {
            binding.lllog.setVisibility(View.VISIBLE);
        } else {
            binding.lllog.setVisibility(View.GONE);
        }
        if (ProxyUtil.getCore().contains("clash") || ProxyUtil.getCore().contains("sing-box")) {
            binding.dashboard.setVisibility(View.VISIBLE);
        } else {
            binding.dashboard.setVisibility(View.GONE);
        }

        /*    try {
            Toast.makeText(this, ProxyUtil.getCore() , 0).show();
        }catch(Exception e) {
            Toast.makeText(this, ""+ e, 0).show();
        }*/
    }
    
    private void setProxyCard(String status) {
        int cardBackgroundColor;
        switch (status) {
            case "enabled":
                binding.proxy.setCardBackgroundColor(Color.parseColor("#6FA251"));
                binding.statusTitle.setText(R.string.enabled);
                binding.statusIcon.setImageResource(R.drawable.ic_check_circle);
                binding.statusSummary.setText(MODULE_VERSION);
                break;
            case "disabled":
                binding.proxy.setCardBackgroundColor(Color.parseColor("#87AFC7"));
                binding.statusTitle.setText(R.string.disabled);
                binding.statusIcon.setImageResource(R.drawable.ic_error);
                binding.statusSummary.setText(MODULE_VERSION);
                break;
            case "loading":
                binding.proxy.setCardBackgroundColor(Color.parseColor("#478FEC"));
                binding.statusTitle.setText(R.string.loading);
                binding.statusIcon.setImageResource(R.drawable.ic_check_circle);
                binding.statusSummary.setText(MODULE_VERSION);
                break;
            case "error":
                binding.proxy.setCardBackgroundColor(Color.parseColor("#F35E5E"));
                binding.statusTitle.setText(R.string.error);
                binding.statusIcon.setImageResource(R.drawable.ic_info);
                binding.statusSummary.setText(MODULE_VERSION);
                break;
            default:
                binding.proxy.setCardBackgroundColor(Color.parseColor("#26B545"));
                binding.statusTitle.setText(R.string.disabled);
                binding.statusIcon.setImageResource(R.drawable.ic_info);
                binding.statusSummary.setText(R.string.install_required);
        }
    }
    
    private void settingCall() {
        final String[] strArr = {"clash", "sing-box", "xray", "v2fly"};
        final String[] strArrProc = {"off", "strict", "always"};
        final String[] strNetworkMode = {"tproxy", "redirect", "mixed"};
        final String[] strProxyMode = {"tun", "whitelist", "blacklist"};
        final String[] strCronJob = {"@daily", "@weekly", "@monthly"};
        
        View inflate = LayoutInflater.from(this).inflate(R.layout.setting_dialog, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(inflate);
        
        Button btncnf = inflate.findViewById(R.id.btnConfig);
        btncnf.setOnClickListener(new StartActivityListener(ConfigActivity.class));
        Button btnModule = inflate.findViewById(R.id.checkModule);
        btnModule.setOnClickListener(
                v -> {
                    if (CheckUpdate.check()) {
                        new AlertDialog.Builder(this)
                                .setTitle(getString(R.string.update))
                                .setMessage(
                                        String.format(
                                                getString(R.string.updatesum),
                                                CheckUpdate.getVer()))
                                .setPositiveButton(
                                        android.R.string.ok,
                                        (dialog, which) -> {
                                            TermUtil.getUpdate();
                                        })
                                .show();
                    } else {
                        Toast.makeText(this, "no update found!", Toast.LENGTH_SHORT).show();
                    }
                });
        
        Spinner spin = inflate.findViewById(R.id.coreSelector);
        
        //    CLASH
        TextView clashSetTV = inflate.findViewById(R.id.clash1);
        LinearLayout llc1 = inflate.findViewById(R.id.clash2);
        LinearLayout llc4 = inflate.findViewById(R.id.clash5);
        LinearLayout llc5 = inflate.findViewById(R.id.clash6);
        LinearLayout llc6 = inflate.findViewById(R.id.clash7);
        
        //   UI
        CheckBox cbLog = inflate.findViewById(R.id.showLog);
        cbLog.setChecked(sp.getBoolean("cbLog", false));
        
        cbLog.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            sp.edit().putBoolean("cbLog", isChecked).apply();
            binding.lllog.setVisibility(isChecked ? View.VISIBLE : View.GONE);
        });

        // CheckBox cbLog = inflate.findViewById(R.id.showLog);
        // cbLog.setChecked(sp.getBoolean("cbLog", false));
        
        // cbLog.setOnCheckedChangeListener(
                // new CompoundButton.OnCheckedChangeListener() {
                    // @Override
                    // public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        // if (z) {
                            // sp.edit().putBoolean("cbLog", true).apply();
                            // binding.lllog.setVisibility(View.VISIBLE);
                        // } else {
                            // sp.edit().putBoolean("cbLog", false).apply();
                            // binding.lllog.setVisibility(View.GONE);
                        // }
                    // }
                // });
        
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367048, strArr);
        arrayAdapter.setDropDownViewResource(17367049);
        spin.setEnabled(!BaseActivity.isProxying);
        spin.setAdapter((SpinnerAdapter) arrayAdapter);
        if (ProxyUtil.getCore().contains("clash")) {
            spin.setSelection(0);
        } else if (ProxyUtil.getCore().contains("sing-box")) {
            spin.setSelection(1);
        } else if (ProxyUtil.getCore().contains("xray")) {
            spin.setSelection(2);
        } else {
            spin.setSelection(3);
        }
        spin.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(
                            AdapterView<?> adapterView, View view, int i, long j) {
                        if (i == 0) {
                            ProxyUtil.setCore("\"clash\"");
                            clashSetTV.setVisibility(View.VISIBLE);
                            llc1.setVisibility(View.VISIBLE);
                            llc4.setVisibility(View.VISIBLE);
                            llc5.setVisibility(View.VISIBLE);
                            llc6.setVisibility(View.VISIBLE);
                            binding.dashboard.setVisibility(View.VISIBLE);
                        } else if (i == 1) {
                            ProxyUtil.setCore("\"sing-box\"");
                            clashSetTV.setVisibility(View.GONE);
                            llc1.setVisibility(View.GONE);
                            llc4.setVisibility(View.GONE);
                            llc5.setVisibility(View.GONE);
                            llc6.setVisibility(View.GONE);
                            binding.dashboard.setVisibility(View.VISIBLE);
                        } else if (i == 2) {
                            ProxyUtil.setCore("\"xray\"");
                            clashSetTV.setVisibility(View.GONE);
                            llc1.setVisibility(View.GONE);
                            llc4.setVisibility(View.GONE);
                            llc5.setVisibility(View.GONE);
                            llc6.setVisibility(View.GONE);
                            binding.dashboard.setVisibility(View.GONE);
                        } else {
                            ProxyUtil.setCore("\"v2fly\"");
                            clashSetTV.setVisibility(View.GONE);
                            llc1.setVisibility(View.GONE);
                            llc4.setVisibility(View.GONE);
                            llc5.setVisibility(View.GONE);
                            llc6.setVisibility(View.GONE);
                            binding.dashboard.setVisibility(View.GONE);
                        }
                        builder.setView(inflate);
                    }
                    
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                });
        
        Spinner spNM = inflate.findViewById(R.id.spNetworkMode);
        ArrayAdapter nmAdapter = new ArrayAdapter(this, 17367048, strNetworkMode);
        nmAdapter.setDropDownViewResource(17367049);
        //   spin.setEnabled(!BaseActivity.isProxying);
        spNM.setAdapter((SpinnerAdapter) nmAdapter);
        
        if (TermUtil.getNetworkMode().contains("tpro")) {
            spNM.setSelection(0);
        } else if (TermUtil.getNetworkMode().contains("redir")) {
            spNM.setSelection(1);
        } else {
            spNM.setSelection(2);
        }
        
        spNM.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(
                            AdapterView<?> adapterView, View view, int i, long j) {
                        if (i == 0) {
                            TermUtil.setNetworkMode("tproxy");
                        } else if (i == 1) {
                            TermUtil.setNetworkMode("redirect");
                        } else {
                            TermUtil.setNetworkMode("mixed");
                        }
                        builder.setView(inflate);
                    }
                    
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                });

        Spinner spProxyMode = inflate.findViewById(R.id.spProxyMode);
        ArrayAdapter ProxyModeAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, strProxyMode);
        ProxyModeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spProxyMode.setAdapter((SpinnerAdapter) ProxyModeAdapter);
        
        if (TermUtil.getProxyMode().contains("tun")) {
            spProxyMode.setSelection(0);
        } else if (TermUtil.getProxyMode().contains("whitelist")) {
            spProxyMode.setSelection(1);
        } else {
            spProxyMode.setSelection(2);
        }
        
        spProxyMode.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(
                            AdapterView<?> adapterView, View view, int i, long j) {
                        if (i == 0) {
                            TermUtil.setProxyMode("tun");
                        } else if (i == 1) {
                            TermUtil.setProxyMode("whitelist");
                        } else {
                            TermUtil.setProxyMode("blacklist");
                        }
                        builder.setView(inflate);
                    }
        
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                });

        Spinner spCronJob = inflate.findViewById(R.id.spCronJob);
        ArrayAdapter CronJobAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, strCronJob);
        CronJobAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCronJob.setAdapter((SpinnerAdapter) CronJobAdapter);
        
        if (TermUtil.getCronJob().contains("@daily")) {
            spCronJob.setSelection(0);
        } else if (TermUtil.getCronJob().contains("@weekly")) {
            spCronJob.setSelection(1);
        } else {
            spCronJob.setSelection(2);
        }
        
        spCronJob.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(
                            AdapterView<?> adapterView, View view, int i, long j) {
                        if (i == 0) {
                            TermUtil.setCronJob("@daily");
                        } else if (i == 1) {
                            TermUtil.setCronJob("@weekly");
                        } else {
                            TermUtil.setCronJob("@monthly");
                        }
                        builder.setView(inflate);
                    }
        
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                });

        //   CLASH CHECKBOX
        CheckBox cbFakeIp = inflate.findViewById(R.id.fake_ip);
        cbFakeIp.setChecked(TermUtil.getFakeIp());
        
        cbFakeIp.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        if (z) {
                            TermUtil.setFakeIp("fake-ip");
                        } else {
                            TermUtil.setFakeIp("redir-host");
                        }
                    }
                });

        CheckBox cbUnified = inflate.findViewById(R.id.unified_delay);
        cbUnified.setChecked(TermUtil.getUnified());
        
        cbUnified.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        if (z) {
                            TermUtil.setUnified("true");
                        } else {
                            TermUtil.setUnified("false");
                        }
                    }
                });
        
        CheckBox cbGeodata = inflate.findViewById(R.id.geodata_mod);
        cbGeodata.setChecked(TermUtil.getGeodata());
        
        cbGeodata.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        if (z) {
                            TermUtil.setGeodata("true");
                        } else {
                            TermUtil.setGeodata("false");
                        }
                    }
                });
        
        CheckBox cbSniffer = inflate.findViewById(R.id.snifferrs);
        cbSniffer.setChecked(TermUtil.getSniffer());
        
        cbSniffer.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        if (z) {
                            TermUtil.setSniffer("true");
                        } else {
                            TermUtil.setSniffer("false");
                        }
                    }
                });
        
        CheckBox cbPort = inflate.findViewById(R.id.port_detect);
        cbPort.setChecked(TermUtil.getPortDetect());
        
        cbPort.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        if (z) {
                            TermUtil.setPortDetect("true");
                        } else {
                            TermUtil.setPortDetect("false");
                        }
                    }
                });

        CheckBox cbQuic = inflate.findViewById(R.id.quic);
        cbQuic.setChecked(TermUtil.getQuic());
        
        cbQuic.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        if (z) {
                            TermUtil.setQuic("enable");
                        } else {
                            TermUtil.setQuic("disable");
                        }
                    }
                });

        CheckBox cbIpv6 = inflate.findViewById(R.id.ipv6);
        cbIpv6.setChecked(TermUtil.getIpv6());
        
        cbIpv6.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        if (z) {
                            TermUtil.setIpv6("true");
                        } else {
                            TermUtil.setIpv6("false");
                        }
                    }
                });

        CheckBox cbCron = inflate.findViewById(R.id.cron);
        cbCron.setChecked(Boolean.parseBoolean(TermUtil.getCron()));
        
        cbCron.setOnCheckedChangeListener(
            new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        TermUtil.setCron("true");
                    } else {
                        TermUtil.setCron("false");
                    }
                }
            });

        CheckBox cbGeo = inflate.findViewById(R.id.geo);
        cbGeo.setChecked(Boolean.parseBoolean(TermUtil.getGeo()));
        
        cbGeo.setOnCheckedChangeListener(
            new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        TermUtil.setGeo("true");
                    } else {
                        TermUtil.setGeo("false");
                    }
                }
            });

        CheckBox cbCgr = inflate.findViewById(R.id.cgr);
        cbCgr.setChecked(Boolean.parseBoolean(TermUtil.getCgr()));
        
        cbCgr.setOnCheckedChangeListener(
            new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        TermUtil.setCgr("true");
                    } else {
                        TermUtil.setCgr("false");
                    }
                }
            });

        CheckBox cbSubs = inflate.findViewById(R.id.subs);
        cbSubs.setChecked(Boolean.parseBoolean(TermUtil.getSubs()));
        
        cbSubs.setOnCheckedChangeListener(
            new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        TermUtil.setSubs("true");
                    } else {
                        TermUtil.setSubs("false");
                    }
                }
            });

        Spinner arSpin = inflate.findViewById(R.id.spFindProc);
        ArrayAdapter arprocAdapter = new ArrayAdapter(this, 17367048, strArrProc);
        arprocAdapter.setDropDownViewResource(17367049);
        arSpin.setAdapter((SpinnerAdapter) arprocAdapter);
        
        if ("off".equals(TermUtil.getFindProc())) {
            arSpin.setSelection(0);
        } else if ("strict".equals(TermUtil.getFindProc())) {
            arSpin.setSelection(1);
        } else {
            arSpin.setSelection(2);
        }
        arSpin.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(
                            AdapterView<?> adapterView, View view, int i, long j) {
                        if (i == 0) {
                            TermUtil.setFindProc("off");
                        } else if (i == 1) {
                            TermUtil.setFindProc("strict");
                        } else {
                            TermUtil.setFindProc("always");
                        }
                        builder.setView(inflate);
                    }
                    
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                });
        
        Button btnIp = inflate.findViewById(R.id.checkIp);
        btnIp.setOnClickListener(
                v -> {
                    dialogIP();
                });

        Button btnAbt = inflate.findViewById(R.id.aboutApp);
        btnAbt.setOnClickListener(
                v -> {
                    dialogAbout();
                });
        
        final AlertDialog create = builder.create();
        create.show();
        create.getWindow()
                .setLayout((int) (getResources().getDisplayMetrics().widthPixels * 0.8d), -2);
    }
    
    private class StartActivityListener implements View.OnClickListener {
        Class<?> clazz;
        
        StartActivityListener(Class<?> clazz) {
            this.clazz = clazz;
        }
        
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, clazz);
            startActivity(intent);
        }
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        binding.appsSummary.setText(
                String.format(
                        getString(R.string.app_count_in_list),
                        UIDS.size(),
                        whiteListMode
                        ? getString(R.string.whitelist)
                        : getString(R.string.blacklist)));

        /*   if (CheckUpdate.check()) {
            binding.updaterSummary.setText(
                    String.format(getString(R.string.updatesum), CheckUpdate.getVer()));
            binding.updater.setVisibility(View.VISIBLE);
        } else {
            binding.updater.setVisibility(View.GONE);
        }*/
    }
    
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        TermUtil.close();
    }
    
    @Override
    protected void onPause() {
        super.onPause();
    }
    
    private void dialogIP() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.ip_dialog, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(inflate);
        
        TextView tv = inflate.findViewById(R.id.tvGeo);
        tv.setText(HttpGetter.geoo());
        
        final AlertDialog create = builder.create();
        create.show();
        create.getWindow()
                .setLayout((int) (getResources().getDisplayMetrics().widthPixels * 0.8d), -2);
    }

    private void dialogAbout() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.about_dialog, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(inflate);
        
        TextView tv = inflate.findViewById(R.id.tvAbout);
        tv.setText(
                "App: t.me/chetoosz\nModule: t.me/taamarin");
        
        final AlertDialog create = builder.create();
        create.show();
        create.getWindow()
                .setLayout((int) (getResources().getDisplayMetrics().widthPixels * 0.8d), -2);
    }
    
    private void fcSpin(String[] arr, Spinner spin) {
        ArrayAdapter ad = new ArrayAdapter(this, 17367048, arr);
        ad.setDropDownViewResource(17367049);
        spin.setAdapter((SpinnerAdapter) ad);
    }
}
