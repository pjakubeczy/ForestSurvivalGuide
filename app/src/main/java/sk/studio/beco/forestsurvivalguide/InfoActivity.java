package sk.studio.beco.forestsurvivalguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class InfoActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        setTitle("Info");
        toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();


        if(id == R.id.action_settings){
            Toast.makeText(this,"Milujem Danku, tukol si na " + item.getTitle(), Toast.LENGTH_SHORT).show();
            return  true;
        }

        if (id == R.id.info){
            startActivity(new Intent(this,InfoActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
