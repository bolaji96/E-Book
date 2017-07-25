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

public class module_php extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_php);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        container = (LinearLayout)findViewById(R.id.php_fragment_layout);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        String filename = "php_tutorial.pdf";
        Bundle bundle = new Bundle();
        bundle.putString("file", filename);
        fragment_CSS fragInfo = new fragment_CSS();
        fragInfo.setArguments(bundle);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.php_fragment_layout, fragInfo);
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
        getMenuInflater().inflate(R.menu.module_php, menu);
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

        if (id == R.id.PHP_Introduction) {
            String filename = "php_introduction.pdf";
            Bundle bundle = new Bundle();
            bundle.putString("file", filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.php_fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        } else if (id == R.id.PHP_EnvironmentalSetup) {
            String filename = "php_environmentalsetup.pdf";
            Bundle bundle = new Bundle();
            bundle.putString("file", filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.php_fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        } else if (id == R.id.PHP_SyntaxOverview) {
            String filename = "php_syntaxoverview.pdf";
            Bundle bundle = new Bundle();
            bundle.putString("file", filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.php_fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        } else if (id == R.id.PHP_VariableTypes) {
            String filename = "php_variabletypes.pdf";
            Bundle bundle = new Bundle();
            bundle.putString("file", filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.php_fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        } else if (id == R.id.PHP_Constants) {
            String filename = "php_constants.pdf";
            Bundle bundle = new Bundle();
            bundle.putString("file", filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.php_fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        } else if (id == R.id.PHP_OperatorTypes) {
            String filename = "php_operatortypes.pdf";
            Bundle bundle = new Bundle();
            bundle.putString("file", filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.php_fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        }else if (id == R.id.PHP_DecisionMaking) {
            String filename = "php_decisionmaking.pdf";
            Bundle bundle = new Bundle();
            bundle.putString("file", filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.php_fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        }else if (id == R.id.PHP_LoopTypes) {
            String filename = "php_looptypes.pdf";
            Bundle bundle = new Bundle();
            bundle.putString("file", filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.php_fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        }else if (id == R.id.PHP_Arrays) {
            String filename = "php_arrays.pdf";
            Bundle bundle = new Bundle();
            bundle.putString("file", filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.php_fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        }else if (id == R.id.PHP_Strings) {
            String filename = "php_strings.pdf";
            Bundle bundle = new Bundle();
            bundle.putString("file", filename);
            fragment_CSS fragInfo = new fragment_CSS();
            fragInfo.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.php_fragment_layout, fragInfo);
            ft.commit();
            container.setVisibility(View.VISIBLE);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
