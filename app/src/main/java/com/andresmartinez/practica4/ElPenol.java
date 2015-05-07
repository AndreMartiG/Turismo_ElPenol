package com.andresmartinez.practica4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class ElPenol extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_penol);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_el_penol, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_hotels) {
            Intent i = new Intent(this, Hoteles.class);
            startActivity(i);
        }

        if (id == R.id.action_bars) {
            Intent i = new Intent(this, Bares.class);
            startActivity(i);
        }

        if (id == R.id.action_turismo) {
            Intent i = new Intent(this, Turismo.class);
            startActivity(i);
        }

        if (id == R.id.action_infodemogr) {
            Intent i = new Intent(this, Demograf.class);
            startActivity(i);
        }

        if (id == R.id.action_about) {
            Intent i = new Intent(this, About.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
