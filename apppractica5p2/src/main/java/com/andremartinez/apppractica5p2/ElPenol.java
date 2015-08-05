package com.andremartinez.apppractica5p2;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;


public class ElPenol extends FragmentActivity implements    //Esta es la actividad principal "MainActivity"
        ListaFragment.onTituloSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListaFragment fragment = new ListaFragment();
        setContentView(R.layout.activity_el_penol);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            //Carga la lista en "fragmPort"
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.framePort, fragment).commit();
        }

        else {      //Si esta en modo landscape carga la lista en "framList"
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameList, fragment, null).commit();
        }
    }

    @Override
    public void onTituloSelected(int position) {
        // TODO Auto-generated method stub

        // Comprobamos si tenemos disponible el Fragment de
        // contenido
       /* ContenidoFragment contFragment = (ContenidoFragment) getSupportFragmentManager()
                .findFragmentById(R.id.frameCont);*/

        ContenidoFragment contFragment = new ContenidoFragment();
        Bundle args = new Bundle();

        // Establecemos la posición que hemos elegido
        args.putInt(ContenidoFragment.POSICION, position);
        contFragment.setArguments(args);


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Si está disponible, estamos en la versión de 2 paneles
            contFragment.landscap = true;

            // Reemplazamos el Fragment que había por el nuevo
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameCont, contFragment)
                    .commit();

        } else {
            // Si no está disponible, estamos en el layout
            // del FrameLayout, y tenemos que cambiar los Fragment
            contFragment.landscap = false;

            // Reemplazamos el Fragment que había por el nuevo
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.framePort, contFragment)
                    .commit();
        }
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
        if (id == R.id.action_lista && getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                  //Para regresar a la lista en el modo portrate
            ListaFragment fragment = new ListaFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.framePort, fragment).commit();
        }

        if (id == R.id.action_about) {
            Intent i = new Intent(this, About.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
