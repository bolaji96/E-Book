package joshua.e_book;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class Modules_CSS extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    //Declare the LinearLayout to be referenced in this Java class
    private LinearLayout container;
    public static final String FRAGMENT_PDF_READER = "PDF_Renderer";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules__css);
        // Set a Toolbar to replace the ActionBar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Find our LinearLayout
        container = (LinearLayout)findViewById(R.id.fragment_layout);
        //Declare and assign the DrawerLayout in this Java file to the DrawerLayout in the layout file of this class
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        // Tie DrawerLayout events to the ActionBarToggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //The name of the file to displayed once this class is called from the Main Activity
        String filename = "css_tutorial.pdf";
        //Handles passing parameters/arguments from activities to fragments, and in this case,
        // it passes the name of the file to be displayed to
        // fragment_fragment_cs.xml
        Bundle bundle = new Bundle();
        bundle.putString("file", filename);
        fragment_CSS fragInfo = new fragment_CSS();
        fragInfo.setArguments(bundle);
        //Calls the fragment - fragment_fragment_cs.xml to be loaded into the Layout of this activity
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_layout, fragInfo);
        ft.commit();
        //Sets the visibility of the Layout the fragment is loaded into to visible
        container.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.modules__cs, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        //Fragment fragment = null;
        //IF statements to handle the selection of chapters from the navigation drawer
        if (id == R.id.CSS_Overview) {
            //The name of the file to displayed once this class is called from the Main Activity
            String filename = "css_overview.pdf";
            //Handles passing parameters/arguments from activities to fragments, and in this case,
            // it passes the name of the file to be displayed to
            // fragment_fragment_cs.xml
            Bundle bundle = new Bundle();
            bundle.putString("file",filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        } else if (id == R.id.CSS_Syntax) {
            //The name of the file to displayed once this class is called from the Main Activity
            String filename = "css_syntax.pdf";
            //Handles passing parameters/arguments from activities to fragments, and in this case,
            // it passes the name of the file to be displayed to
            // fragment_fragment_cs.xml
            Bundle bundle = new Bundle();
            bundle.putString("file",filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        } else if (id == R.id.CSS_Inclusion) {
            //The name of the file to displayed once this class is called from the Main Activity
            String filename = "css_inclusion.pdf";
            //Handles passing parameters/arguments from activities to fragments, and in this case,
            // it passes the name of the file to be displayed to
            // fragment_fragment_cs.xml
            Bundle bundle = new Bundle();
            bundle.putString("file",filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        } else if (id == R.id.CSS_MeasurementUnits) {
            //The name of the file to displayed once this class is called from the Main Activity
            String filename = "css_measurementunits.pdf";
            //Handles passing parameters/arguments from activities to fragments, and in this case,
            // it passes the name of the file to be displayed to
            // fragment_fragment_cs.xml
            Bundle bundle = new Bundle();
            bundle.putString("file",filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        }
        else if (id == R.id.CSS_Colors) {
            //The name of the file to displayed once this class is called from the Main Activity
            String filename = "css_color.pdf";
            //Handles passing parameters/arguments from activities to fragments, and in this case,
            // it passes the name of the file to be displayed to
            // fragment_fragment_cs.xml
            Bundle bundle = new Bundle();
            bundle.putString("file",filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        }
        else if (id == R.id.CSS_Background) {
            //The name of the file to displayed once this class is called from the Main Activity
            String filename = "css_background.pdf";
            //Handles passing parameters/arguments from activities to fragments, and in this case,
            // it passes the name of the file to be displayed to
            // fragment_fragment_cs.xml
            Bundle bundle = new Bundle();
            bundle.putString("file",filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        }
        else if (id == R.id.CSS_Fonts) {
            //The name of the file to displayed once this class is called from the Main Activity
            String filename = "css_fonts.pdf";
            //Handles passing parameters/arguments from activities to fragments, and in this case,
            // it passes the name of the file to be displayed to
            // fragment_fragment_cs.xml
            Bundle bundle = new Bundle();
            bundle.putString("file",filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        }
        else if (id == R.id.CSS_Text) {
            //The name of the file to displayed once this class is called from the Main Activity
            String filename = "css_text.pdf";
            //Handles passing parameters/arguments from activities to fragments, and in this case,
            // it passes the name of the file to be displayed to
            // fragment_fragment_cs.xml
            Bundle bundle = new Bundle();
            bundle.putString("file",filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        }
        else if (id == R.id.CSS_Images) {
            //The name of the file to displayed once this class is called from the Main Activity
            String filename = "css_images.pdf";
            //Handles passing parameters/arguments from activities to fragments, and in this case,
            // it passes the name of the file to be displayed to
            // fragment_fragment_cs.xml
            Bundle bundle = new Bundle();
            bundle.putString("file",filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        }        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
