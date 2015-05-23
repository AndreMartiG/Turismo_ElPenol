package com.andremartinez.apppractica5p2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ContenidoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    public static final String POSICION = "position";
    int position = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (savedInstanceState != null){
            position = savedInstanceState.getInt("position");
        }
        return inflater.inflate(R.layout.fragment_contenido, container, false);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(POSICION, position);
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        if (args != null){
            actualizarContenido(args.getInt(POSICION));
        } else if (position != -1){
            actualizarContenido(position);
        }
    }

    public void actualizarContenido(int position){

        /*Esta es la funcion en la que reemplazo los fragment
        * en la linea que esta actualmente sin comentar, el nuevo fragment se superpone a la lista y el modo portrate funciona
        * en la linea que esta comentada, el modo lanscape funciona hasta seleccionar la primera opcion
        * la app genera error al seleccionar la segunda opcion. El modo portrate no funciona con esta linea*/

        if (position == 0) {
            Fraginicio fragment = new Fraginicio();
            this.getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, fragment, null).commit();

          /*  this.getFragmentManager().beginTransaction()
                    .replace(R.id.contenidoFragment, fragment, null).commit();*/
        }

        if (position == 1) {
            Fraghoteles fragment = new Fraghoteles();
            this.getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, fragment, null).commit();    //El nuevo Fragment ocupa toda la pantalla

            /*  this.getFragmentManager().beginTransaction()                        // El modo portrate no funciona y el modo lanscape funciona hasta
                    .replace(R.id.contenidoFragment, fragment, null).commit();*/    //seleccionar la segunda opcion.
        }

        if (position == 2) {
            Fragbares fragment = new Fragbares();
            this.getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, fragment, null).commit();

            /*  this.getFragmentManager().beginTransaction()
                    .replace(R.id.contenidoFragment, fragment, null).commit();*/
        }

        if (position == 3) {
            Fragturismo fragment = new Fragturismo();
            this.getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, fragment, null).commit();

            /*  this.getFragmentManager().beginTransaction()
                    .replace(R.id.contenidoFragment, fragment, null).commit();*/
        }

        if (position == 4) {
            Fragdemograf fragment = new Fragdemograf();
            this.getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, fragment, null).commit();

            /*  this.getFragmentManager().beginTransaction()
                    .replace(R.id.contenidoFragment, fragment, null).commit();*/
        }

        this.position = position;
    }
}
