package com.example.gahallon.app2;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

public class DatabasePlants extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SectionsPageAdapter mSectionsPageAdapter;
    private TextView toolbar_title;
    private ViewPager mViewPager;
    private String selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_plants);
        Log.d(TAG, "onCreate: Starting.");

        TextView toolbar_title = findViewById(R.id.toolbar_title);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            selectedItem = extras.getString("key");
            //The key argument here must match that used in the other activity
        }

        toolbar_title.setText(selectedItem.toUpperCase());

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
//        Toast.makeText(this, selectedItem, Toast.LENGTH_SHORT).show();
        if (selectedItem.contentEquals("Lagundi")) {

            adapter.addFragment(new Tab1FragmentLagundi(), "Usage");
            adapter.addFragment(new Tab2FragmentLagundi(), "General");
            adapter.addFragment(new Tab3FragmentLagundi(), "Gallery");
        }
        else if (selectedItem.contentEquals("Bawang")) {

            adapter.addFragment(new Tab1FragmentBawang(), "Usage");
            adapter.addFragment(new Tab2FragmentBawang(), "General");
            adapter.addFragment(new Tab3FragmentBawang(), "Gallery");
        }
        else if (selectedItem.contentEquals("Akapulko")) {

            adapter.addFragment(new Tab1FragmentAkapulko(), "Usage");
            adapter.addFragment(new Tab2FragmentAkapulko(), "General");
            adapter.addFragment(new Tab3FragmentAkapulko(), "Gallery");
        }
        else if (selectedItem.contentEquals("Niyog-niyogan")) {

            adapter.addFragment(new Tab1FragmentNiyogNiyogan(), "Usage");
            adapter.addFragment(new Tab2FragmentNiyogNiyogan(), "General");
            adapter.addFragment(new Tab3FragmentNiyogNiyogan(), "Gallery");
        }
        else if (selectedItem.contentEquals("Tsaang Gubat")) {

            adapter.addFragment(new Tab1FragmentTsaang(), "Usage");
            adapter.addFragment(new Tab2FragmentTsaang(), "General");
            adapter.addFragment(new Tab3FragmentTsaang(), "Gallery");
        }
        else if (selectedItem.contentEquals("Ampalaya")) {

            adapter.addFragment(new Tab1FragmentAmapalaya(), "Usage");
            adapter.addFragment(new Tab2FragmentAmpalaya(), "General");
            adapter.addFragment(new Tab3FragmentAmpalaya(), "Gallery");
        }
        else if (selectedItem.contentEquals("Pansit-pansitan")) {

            adapter.addFragment(new Tab1FragmentPansit(), "Usage");
            adapter.addFragment(new Tab2FragmentPansit(), "General");
            adapter.addFragment(new Tab3FragmentPansit(), "Gallery");
        }
        else if (selectedItem.contentEquals("Bayabas")) {

            adapter.addFragment(new Tab1FragmentBayabas(), "Usage");
            adapter.addFragment(new Tab3FragmentBayabas(), "Gallery");
        }
        else if (selectedItem.contentEquals("Yerba Buena")) {


            adapter.addFragment(new Tab1FragmentYerba(), "Usage");
            adapter.addFragment(new Tab2FragmentYerba(), "General");
            adapter.addFragment(new Tab3FragmentYerba(), "Gallery");
        }
        else if (selectedItem.contentEquals("Sambong")) {


            adapter.addFragment(new Tab1FragmentSambong(), "Usage");
            adapter.addFragment(new Tab2FragmentSambong(), "General");
            adapter.addFragment(new Tab3FragmentSambong(), "Gallery");
        }



        viewPager.setAdapter(adapter);
    }

}
