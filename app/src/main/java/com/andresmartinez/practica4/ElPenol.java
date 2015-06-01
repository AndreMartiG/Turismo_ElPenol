package com.andresmartinez.practica4;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class ElPenol extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_penol);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fraginicio fragment = new Fraginicio();
        fragmentTransaction.replace(android.R.id.content, fragment).commit();

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

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_start) {
            Fraginicio fragment = new Fraginicio();
            fragmentTransaction.replace(android.R.id.content, fragment).commit();
        }

        if (id == R.id.action_hotels) {
            Fraghoteles fragment = new Fraghoteles();
            fragmentTransaction.replace(android.R.id.content, fragment).commit();
        }

        if (id == R.id.action_bars) {
            Fragbares fragment = new Fragbares();
            fragmentTransaction.replace(android.R.id.content, fragment).commit();
        }

        if (id == R.id.action_turismo) {
            Fragturismo fragment = new Fragturismo();
            fragmentTransaction.replace(android.R.id.content, fragment).commit();
        }

        if (id == R.id.action_infodemogr) {
            Fragdemograf fragment = new Fragdemograf();
            fragmentTransaction.replace(android.R.id.content, fragment).commit();
        }

        if (id == R.id.action_ubicac) {
            Intent i = new Intent(this, MapsElPenol.class);
            startActivity(i);
        }

        if (id == R.id.action_about) {
            Intent i = new Intent(this, About.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
