package xyz.chz.bfm.ui.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBar;
import com.google.android.material.snackbar.Snackbar;
import xyz.chz.bfm.R;
import xyz.chz.bfm.adapters.AppListAdapter;
import xyz.chz.bfm.ui.activity.base.BaseActivity;
import xyz.chz.bfm.databinding.ActivityAppListBinding;

import xyz.chz.bfm.util.LinearLayoutManagerFix;
import rikka.recyclerview.RecyclerViewKt;

public class AppListActivity extends BaseActivity {
    private SearchView searchView;
    private AppListAdapter appListAdapter;

    private SearchView.OnQueryTextListener searchListener;
    public ActivityAppListBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAppListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setAppBar(binding.appBar, binding.toolbar);
        binding.appBar.setRaised(true);
        binding.toolbar.setNavigationOnClickListener(view -> onBackPressed());
        ActionBar bar = getSupportActionBar();
        assert bar != null;
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle(R.string.applist_title);
        bar.setSubtitle(R.string.applist_subtitle);
        appListAdapter = new AppListAdapter(this);
        appListAdapter.setHasStableIds(true);
        binding.recyclerView.setAdapter(appListAdapter);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManagerFix(this));
        RecyclerViewKt.addFastScroller(binding.recyclerView, binding.recyclerView);
        RecyclerViewKt.fixEdgeEffect(binding.recyclerView, false, true);
        binding.swipeRefreshLayout.setOnRefreshListener(() -> appListAdapter.refresh());

        searchListener =
            new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    appListAdapter.getFilter().filter(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    appListAdapter.getFilter().filter(newText);
                    return false;
                }
            };
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (appListAdapter.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        appListAdapter.onCreateOptionsMenu(menu, getMenuInflater());
        searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setOnQueryTextListener(searchListener);
        return super.onCreateOptionsMenu(menu);
    }

    public void onDataReady() {
        runOnUiThread(
            () -> {
                binding.progress.setIndeterminate(false);
                binding.swipeRefreshLayout.setRefreshing(false);
                String queryStr = searchView != null ? searchView.getQuery().toString() : "";
                appListAdapter.getFilter().filter(queryStr);
            });
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (appListAdapter.onContextItemSelected(item)) {
            return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (appListAdapter.onBackPressed()) {
            super.onBackPressed();
        }
    }

    public void makeSnackBar(String text, @Snackbar.Duration int duration) {
        Snackbar.make(binding.snackbar, text, duration).show();
    }

    public void makeSnackBar(@StringRes int text, @Snackbar.Duration int duration) {
        Snackbar.make(binding.snackbar, text, duration).show();
    }
}
