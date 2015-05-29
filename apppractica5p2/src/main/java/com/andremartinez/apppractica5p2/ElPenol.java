package com.andremartinez.apppractica5p2;

import android.content.Intent;
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

        if (findViewById(R.id.contenidoFragment) == null) {    //fragment_container: esta en el modo portrate
            //Carga la lista en "fragment_container"
            getSupportFragmentManager().beginTransaction()
                    .replace(android.R.id.content, fragment, null).commit();
        }

        else {      //Si esta en modo landscape carga la lista en "tituloFragment"
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.tituloFragment, fragment, null).commit();
        }
    }

    @Override
    public void onTituloSelected(int position) {
        // TODO Auto-generated method stub

        // Comprobamos si tenemos disponible el Fragment de
        // contenido
        ContenidoFragment contFragment = (ContenidoFragment) getSupportFragmentManager()
                .findFragmentById(R.id.contenidoFragment);

        if (contFragment != null) {
            // Si está disponible, estamos en la versión de 2 paneles
            contFragment.land_c = true;
            contFragment.actualizarContenido(position);
            //segun esto el metodo "actualizarContenido()" solo se usa en el modo landscape

        } else {
            // Si no está disponible, estamos en el layout
            // del FrameLayout, y tenemos que cambiar los Fragment
            contFragment = new ContenidoFragment();
            Bundle args = new Bundle();

            // Establecemos la posición que hemos elegido
            args.putInt(ContenidoFragment.POSICION, position);
            contFragment.setArguments(args);
            contFragment.land_c = false;

            // Reemplazamos el Fragment que había por el nuevo
            getSupportFragmentManager().beginTransaction()
                    .replace(android.R.id.content, contFragment)
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
        if (id == R.id.action_lista) {          //Para regresar a la lista en el modo portrate
            ListaFragment fragment = new ListaFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(android.R.id.content, fragment, null).commit();
        }

        if (id == R.id.action_about) {
            Intent i = new Intent(this, About.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
