package xyz.chz.bfm.ui.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import androidx.appcompat.app.ActionBar;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.yaml.snakeyaml.Yaml;
import xyz.chz.bfm.R;
import xyz.chz.bfm.databinding.ActivityConfigBinding;
import xyz.chz.bfm.ui.activity.ConfigActivity;
import xyz.chz.bfm.ui.activity.base.BaseActivity;
import xyz.chz.bfm.util.module.ProxyUtil;
import xyz.chz.bfm.util.module.TermUtil;
// import xyz.chz.bfm.ui.activity.base.MyEdittext;

@Deprecated
public class ConfigActivity extends BaseActivity {
    public ActivityConfigBinding binding;

    private String A1, A2, A3, A4;
    private String B1;
    String filename = "";
    String filepath = "";
    String filecontent = "";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfigBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setAppBar(binding.appBar, binding.toolbar);
        binding.appBar.setRaised(true);
        binding.toolbar.setNavigationOnClickListener(view -> onBackPressed());
        ActionBar bar = getSupportActionBar();
        assert bar != null;
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle(R.string.config_title);
        bar.setSubtitle(R.string.config_summary);

        try {
            A1 = new String(TermUtil.getConf("clash", true).getBytes("ISO-8859-1"), "UTF-8");
            A2 = new String(TermUtil.getConf("sing-box", false).getBytes("ISO-8859-1"), "UTF-8");
            A3 = new String(TermUtil.getConf("xray", false).getBytes("ISO-8859-1"), "UTF-8");
            A4 = new String(TermUtil.getConf("v2fly", false).getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        filename = "output.txt";
        filepath = "gg";
        if (ProxyUtil.getCore().contains("cla")) {
            binding.conf.setText(A1);
        } else if (ProxyUtil.getCore().contains("sing")) {
            binding.conf.setText(A2);
        } else if (ProxyUtil.getCore().contains("xr")) {
            binding.conf.setText(A3);
        } else {
            binding.conf.setText(A4);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu arg0) {
        getMenuInflater().inflate(R.menu.menu_config, arg0);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem arg0) {
        // TODO: Implement this method
        switch (arg0.getItemId()) {
            case R.id.save:
                saver();
                break;
        }
        return true;
    }

    private void saver() {
        filecontent = binding.conf.getText().toString();
        //    if (!filecontent.equals("")) {
        File exFile = new File(getExternalFilesDir(filepath), filename);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(exFile);
            if (ProxyUtil.getCore().contains("cla")) {
                fos.write(binding.conf.getText().toString().getBytes());
                TermUtil.setConf("clash", true);
                Toast.makeText(this, "Config saved", Toast.LENGTH_SHORT).show();
            } else if (ProxyUtil.getCore().contains("sing")) {
                fos.write(filecontent.getBytes());
                if (isJSONValid(binding.conf.getText().toString())) {
                    TermUtil.setConf("sing-box", false);
                    Toast.makeText(this, "Config saved", Toast.LENGTH_SHORT).show();
                }
            } else if (ProxyUtil.getCore().contains("xr")) {
                fos.write(filecontent.getBytes());
                if (isJSONValid(binding.conf.getText().toString())) {
                    TermUtil.setConf("xray", false);
                    Toast.makeText(this, "Config saved", Toast.LENGTH_SHORT).show();
                }
            } else {
                fos.write(filecontent.getBytes());
                if (isJSONValid(binding.conf.getText().toString())) {
                    TermUtil.setConf("v2fly", false);
                    Toast.makeText(this, "Config saved", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        //    }
    }

    private String ClashSave(String in) {
        try {
            String ret = "";
            Yaml yaml = new Yaml();
            HashMap hm = yaml.load(in);
            Map<String, Object> map = (Map<String, Object>) yaml.load(in);

            JSONObject jsonObject = new JSONObject(map);

            ret =
                    convertToYaml(jsonObject.toString())
                            .replaceAll("null", "")
                            .replaceAll("---", "")
                            .replaceAll("\"\"", "");
            return ret;
        } catch (Exception e) {
            //   return e.getMessage();
            new AlertDialog.Builder(this)
                    .setMessage(e.getMessage().toString())
                    .setPositiveButton(android.R.string.ok, (dialog, which) -> {})
                    .show();
        }
        return "";
    }

    private String convertToJson(String yamlString) {
        try {
            Yaml yaml = new Yaml();
            Map<String, Object> map = (Map<String, Object>) yaml.load(yamlString);

            JSONObject jsonObject = new JSONObject(map);
            String aku = jsonObject.get("proxies").toString();
            if (aku.equals("null")) {
                jsonObject.remove("proxies");
                jsonObject.put("proxies", "");
                return jsonObject.toString(2);
            } else {
                return jsonObject.toString(2);
            }
        } catch (Exception e) {
            Toast.makeText(this, e.getCause().toString(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    private String convertToYaml(String in) {
        try {
            ObjectMapper om = new ObjectMapper();
            YAMLMapper ym = new YAMLMapper();
            JsonNode jn = om.readTree(in);
            String output =
                    ym.writer()
                            .without(YAMLGenerator.Feature.WRITE_DOC_START_MARKER)
                            .writeValueAsString(jn);
            return output;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }

    public boolean isJSONValid(String test) {
        try {
            new JSONObject(test);
        } catch (JSONException ex) {

            try {
                new JSONArray(test);
            } catch (JSONException ex1) {
                new AlertDialog.Builder(this)
                        .setMessage("" + ex1.getMessage())
                        .setPositiveButton(android.R.string.ok, (dialog, which) -> {})
                        .show();
                return false;
            }
        }
        return true;
    }

    private boolean IsExRW() {
        // TODO: Implement this method
        String exAv = Environment.getExternalStorageState();
        if (exAv.equals(Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
