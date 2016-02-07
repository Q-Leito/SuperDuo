package com.freedom_mobile.alexandria.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.freedom_mobile.alexandria.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            startFragmentTransaction();
        }
    }

    private void startFragmentTransaction() {
        Bundle arguments = new Bundle();
        arguments.putString(BookDetailFragment.EAN_KEY,
                getIntent().getStringExtra(BookDetailFragment.EAN_KEY));
        BookDetailFragment detailFragment = new BookDetailFragment();
        detailFragment.setArguments(arguments);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.detail_container, detailFragment)
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        switch (itemId) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
