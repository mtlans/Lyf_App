package com.example.gahallon.app2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;


public class Database extends AppCompatActivity {
    private ViewStub stubGrid;
    private ViewStub stubList;
    private ListView listView;
    private GridView gridView;

    private List<Product> productList;
    private ArrayAdapter<Product> itemsAdapter;
    private int currentViewMode = 0;
    Global sharedData = Global.getInstance();

    static final int VIEW_MODE_LISTVIEW = 0;
    static final int VIEW_MODE_GRIDVIEW = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_database);
        Toolbar toolbar = findViewById(R.id.databasetoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("BROWSE");
        stubList = (ViewStub) findViewById(R.id.stub_list);
        stubGrid = (ViewStub) findViewById(R.id.stub_grid);


        //Inflate ViewStub before get view

        stubList.inflate();
        stubGrid.inflate();

        listView = (ListView) findViewById(R.id.mylistview);
        gridView = (GridView) findViewById(R.id.mygridview);

        //get list of product
        getProductList();

        //Get current view mode in share reference
        SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
        currentViewMode = sharedPreferences.getInt("currentViewMode", VIEW_MODE_LISTVIEW);//Default is view listview
        //Register item lick
        listView.setOnItemClickListener(onItemClick);
        gridView.setOnItemClickListener(onItemClick);

        switchView();

    }

    private void switchView() {

        if(VIEW_MODE_LISTVIEW == currentViewMode) {
            //Display listview
            stubList.setVisibility(View.VISIBLE);
            //Hide gridview
            stubGrid.setVisibility(View.GONE);
        } else {
            //Hide listview
            stubList.setVisibility(View.GONE);
            //Display gridview
            stubGrid.setVisibility(View.VISIBLE);
        }
        setAdapters();
    }

    private void setAdapters() {
        if(VIEW_MODE_LISTVIEW == currentViewMode) {
            ListViewAdapter itemsAdapter =new ListViewAdapter (this, R.layout.list_item, productList);
            listView.setAdapter(itemsAdapter);
        } else {
            GridViewAdapter itemsAdapter =new GridViewAdapter (this, R.layout.grid_item, productList);
            gridView.setAdapter(itemsAdapter);
        }
    }

    public List<Product> getProductList() {
        //pseudo code to get product, replace your code to get real product here
        productList = new ArrayList<>();
        productList.add(new Product(R.drawable.akapulko, "Akapulko", "Ringworm Bush", "Senna alata"));
        productList.add(new Product(R.drawable.ampalaya, "Ampalaya", "Bitter Gourd", "Momordica charantia"));
        productList.add(new Product(R.drawable.bawang, "Bawang", "Garlic", "Allium sativum"));
        productList.add(new Product(R.drawable.bayabas, "Bayabas", "Guava", "Psidium guajava"));
        productList.add(new Product(R.drawable.lagundi, "Lagundi", "5-leaved Chaste Tree", "Vitex negundo"));
        productList.add(new Product(R.drawable.niyogniyogan, "Niyog-niyogan", "Chinese Honey Suckle", "Quisqualis indica"));
        productList.add(new Product(R.drawable.pansitpansitan, "Pansit-pansitan", "Peperomia", "Peperomia pellucida"));
        productList.add(new Product(R.drawable.sambong, "Sambong", "Sambong", "Blumea balsamifera"));
        productList.add(new Product(R.drawable.tsaanggubat, "Tsaang Gubat", "Philippine Tea Tree", "Carmona retusa"));
        productList.add(new Product(R.drawable.yerbabuena, "Yerba Buena", "Peppermint", "Mentha x cordifolia"));

        return productList;
    }

    AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Do any thing when user click to item
//            Toast.makeText(getApplicationContext(), productList.get(position).getTitle() + " - " + productList.get(position).getDescription(), Toast.LENGTH_SHORT).show();
            String selectedItem = productList.get(position).getTitle();
            Intent intent = new Intent(Database.this, DatabasePlants.class);
            intent.putExtra("key", selectedItem);
            sharedData.setSelectedItem(selectedItem);
            startActivity(intent);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_menu_1:
                if(VIEW_MODE_LISTVIEW == currentViewMode) {
                    currentViewMode = VIEW_MODE_GRIDVIEW;
                } else {
                    currentViewMode = VIEW_MODE_LISTVIEW;
                }
                //Switch view
                switchView();
                //Save view mode in share reference
                SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("currentViewMode", currentViewMode);
                editor.commit();

                break;
        }
        return true;
    }

}
