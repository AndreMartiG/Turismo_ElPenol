package com.andremartinez.apppractica5p2;

import android.app.Activity;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class ListaFragment extends ListFragment {

    onTituloSelectedListener mCallback;

    public interface onTituloSelectedListener{          //Interface que permite comunicar el ListFragment Con el otro Fragment
        public void onTituloSelected(int posicion);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(getActivity(),      //Establece el ArrayAdapter en la lista para cargar las acciones
                android.R.layout.simple_list_item_1, Contenido.titulos));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (onTituloSelectedListener) activity;
        } catch (ClassCastException e){
            Log.d("ClassCastException",
                    "La Actividad debe implementar esta Interfaz");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){ //Llama al método y le pasa la Posición del elemento pulsado
        super.onListItemClick(l, v, position, id);
        mCallback.onTituloSelected(position);
        //noinspection SimplifiableIfStatement

    }

}
