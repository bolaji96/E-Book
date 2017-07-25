package joshua.e_book;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener {
//Declare all the classes needed in this Java file
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    ArrayList moduleList;
    TextView textView;
    private NavigationView nvDrawer;
    private RecyclerView recyclerView;
    private ComputerScienceModulesAdapter adapter;
    // Make sure to be using android.support.v7.app.ActionBarDrawerToggle version.
    // The android.support.v4.app.ActionBarDrawerToggle has been deprecated.
    private ActionBarDrawerToggle drawerToggle;
    SliderLayout mDemoSlider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Find our drawer view
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        // Setup drawer view
        setupDrawerContent(nvDrawer);
        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();

        // Tie DrawerLayout events to the ActionBarToggle
        mDrawer.addDrawerListener(drawerToggle);
        //Find our slider layout
        mDemoSlider = (SliderLayout)findViewById(R.id.slider);
        //Find our recycler view
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_modules);
       //Setup our arraylist
        moduleList = new ArrayList<>();
        //Setup our adapter
        adapter = new ComputerScienceModulesAdapter(this, moduleList);
        //Find our text vuew
        textView = (TextView)findViewById(R.id.moduleTextView);
        //Design our Recycler view in runtime
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new MainActivity.GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //populate the recycler view with icons and texts
        prepareModules();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_modules);
        //Add the adapter to the recycler view
        recyclerView.setAdapter(adapter);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("1", R.drawable.css_banner);
        file_maps.put("2",R.drawable.html_banner);
        file_maps.put("3",R.drawable.javascript_banner);
        file_maps.put("4",R.drawable.php_banner);
        //file_maps.put("5",R.drawable.banner5);


        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    //  .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                            //.setOnSliderClickListener(this);
                    .setOnSliderClickListener(this);


            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new ChildAnimationExample());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener();
    }

    private void prepareModules() {
        int[] moduleImages = { R.drawable.php_file_format_icon,R.drawable.cssv2,
                R.drawable.html_flat_icon,R.drawable.javascript_icon, R.drawable.coming_soon};

        ComputerScienceModules a = new ComputerScienceModules("Learn CSS", moduleImages[1]);
        moduleList.add(a);

        a = new ComputerScienceModules("Learn HTML", moduleImages[2]);
        moduleList.add(a);

        a = new ComputerScienceModules("Learn Javascript", moduleImages[3]);
        moduleList.add(a);

        a = new ComputerScienceModules("Learn PHP", moduleImages[0]);
        moduleList.add(a);

        a = new ComputerScienceModules("Need Help?", moduleImages[4]);
        moduleList.add(a);

        a = new ComputerScienceModules("Video Tutorials", moduleImages[4]);
        moduleList.add(a);

        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(new ComputerScienceModulesAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                if (position == 0) {
                    startActivity(new Intent(MainActivity.this, Modules_CSS.class));
                }

                else if (position == 1) {
                    startActivity(new Intent(MainActivity.this, module_html.class));
                }
                else if (position == 2) {
                    startActivity(new Intent(MainActivity.this, module_javascript.class));
                }
                else if (position == 3) {

                    startActivity(new Intent(MainActivity.this, module_php.class));
                }
                else if (position == 4) {

                    startActivity(new Intent(MainActivity.this, signin.class));
                }
                else {
                    Toast.makeText(MainActivity.this, "Out of bounds", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onItemLongClick(int position, View v) {
                // Log.d(TAG, "onItemLongClick pos = " + position);
            }
        });
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }


    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open,  R.string.drawer_close);
    }

    private void setupDrawerContent(NavigationView nvDrawer) {
        nvDrawer.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    private void selectDrawerItem(MenuItem menuItem) {
// Create a new fragment and specify the fragment to show based on nav item clicked
        switch(menuItem.getItemId()) {
            case R.id.nav_first_fragment:
                startActivity(new Intent(MainActivity.this, Modules_CSS.class));
                break;
            case R.id.nav_second_fragment:
                startActivity(new Intent(MainActivity.this, module_html.class));
                break;
            case R.id.nav_third_fragment:
                startActivity(new Intent(MainActivity.this, module_javascript.class));
                break;
            case R.id.nav_fourth_fragment:
                startActivity(new Intent(MainActivity.this, module_php.class));
                break;
            case R.id.signin:
                startActivity(new Intent(MainActivity.this, signin.class));
                break;
            default:
                //fragmentClass = FirstFragment.class;
        }

        try {
            //fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawer.closeDrawers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
