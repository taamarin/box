package xyz.chz.bfm.ui.activity.base;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import xyz.chz.bfm.R;
import xyz.chz.bfm.databinding.ActivityListBinding;
import xyz.chz.bfm.util.LinearLayoutManagerFix;
import rikka.recyclerview.RecyclerViewKt;

public abstract class ListActivity extends BaseActivity {
    protected ActivityListBinding binding;
    protected SearchView searchView;
    private SearchView.OnQueryTextListener mSearchListener;
    private BaseAdapter<?> adapter = null;

    @Override
    public void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setAppBar(binding.appBar, binding.toolbar);
        binding.getRoot().bringChildToFront(binding.appBar);
        binding.toolbar.setNavigationOnClickListener(view -> onBackPressed());
        binding.recyclerView
                .getBorderViewDelegate()
                .setBorderVisibilityChangedListener(
                        (top, oldTop, bottom, oldBottom) -> binding.appBar.setRaised(!top));
        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setDisplayHomeAsUpEnabled(true);
        }
        adapter = createAdapter();
        adapter.setHasStableIds(true);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManagerFix(this));
        RecyclerViewKt.addFastScroller(binding.recyclerView, binding.recyclerView);
        RecyclerViewKt.fixEdgeEffect(binding.recyclerView, false, true);
        binding.progress.setVisibilityAfterHide(View.GONE);
        mSearchListener =
                new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        adapter.getFilter().filter(query);
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        adapter.getFilter().filter(newText);
                        return false;
                    }
                };
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setOnQueryTextListener(mSearchListener);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        if (searchView.isIconified()) {
            super.onBackPressed();
        } else {
            searchView.setIconified(true);
        }
    }

    protected abstract static class BaseAdapter<T extends RecyclerView.ViewHolder>
            extends RecyclerView.Adapter<T> implements Filterable {}

    protected abstract BaseAdapter<?> createAdapter();
}
