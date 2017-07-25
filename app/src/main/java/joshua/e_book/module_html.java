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

public class module_html extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_html);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        container = (LinearLayout)findViewById(R.id.html_fragment_layout);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        String filename = "html_tutorial.pdf";
        Bundle bundle = new Bundle();
        bundle.putString("file", filename);
        fragment_CSS fragInfo = new fragment_CSS();
        fragInfo.setArguments(bundle);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.html_fragment_layout, fragInfo);
        ft.commit();
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
        getMenuInflater().inflate(R.menu.module_html, menu);
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

        if (id == R.id.HTML_Overview) {
            String filename = "html_overview.pdf";
            Bundle bundle = new Bundle();
            bundle.putString("file",filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.html_fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        } else if (id == R.id.HTML_BasicTags) {
            String filename = "html_overview.pdf";
            Bundle bundle = new Bundle();
            bundle.putString("file",filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.html_fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        } else if (id == R.id.HTML_Elements) {
            String filename = "html_elements.pdf";
            Bundle bundle = new Bundle();
            bundle.putString("file",filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.html_fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        } else if (id == R.id.HTML_Attributes) {
            String filename = "html_attributes.pdf";
            Bundle bundle = new Bundle();
            bundle.putString("file",filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.html_fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        } else if (id == R.id.HTML_Formatting) {
            String filename = "html_formatting.pdf";
            Bundle bundle = new Bundle();
            bundle.putString("file",filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.html_fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        } else if (id == R.id.HTML_PhraseTags) {
            String filename = "html_phrasetags.pdf";
            Bundle bundle = new Bundle();
            bundle.putString("file",filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.html_fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        }
        else if (id == R.id.HTML_MetaTags) {
            String filename = "html_metatags.pdf";
            Bundle bundle = new Bundle();
            bundle.putString("file",filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.html_fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        }
        else if (id == R.id.HTML_Comments) {
            String filename = "html_comments.pdf";
            Bundle bundle = new Bundle();
            bundle.putString("file",filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.html_fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        }
        else if (id == R.id.HTML_Images) {
            String filename = "html_images.pdf";
            Bundle bundle = new Bundle();
            bundle.putString("file",filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.html_fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        }
        else if (id == R.id.HTML_Tables) {
            String filename = "html_tables.pdf";
            Bundle bundle = new Bundle();
            bundle.putString("file",filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.html_fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        }
        else if (id == R.id.HTML_Lists) {

        }
        else if (id == R.id.HTML_TextLinks) {

        }
        else if (id == R.id.HTML_ImageLinks) {

        }else if (id == R.id.HTML_EmailLinks) {

        }else if (id == R.id.HTML_Frames) {

        }else if (id == R.id.HTML_IFrames) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
