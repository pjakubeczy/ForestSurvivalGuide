package sk.studio.beco.forestsurvivalguide;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");
        toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        ImageView navImage = findViewById(R.id.nav_image_view);

        Calendar c = Calendar.getInstance();
        int actualMonth = c.get(Calendar.MONTH);
        if (actualMonth < 3 || actualMonth == 12) {         // dec,jan,feb - zima
            navImage.setImageResource(R.drawable.nav_drawer_image_winter);
        } else if (actualMonth > 2 && actualMonth < 6) {    // mar,apr,maj - jar
            navImage.setImageResource(R.drawable.nav_drawer_image_spring);
        } else if (actualMonth > 5 && actualMonth < 9) {    //jun,jul,aug  - leto
            navImage.setImageResource(R.drawable.nav_drawer_image_summer);
        } else {                                            //sep,okt,nov  - jesen
            navImage.setImageResource(R.drawable.nav_drawer_image_autumn);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            Toast.makeText(this, "Milujem Danku, tukol si na " + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == R.id.info) {
            startActivity(new Intent(this, InfoActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
