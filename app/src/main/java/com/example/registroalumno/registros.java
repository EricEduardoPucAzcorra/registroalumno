package com.example.registroalumno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.registroalumno.almacen.almacen;

import java.util.ArrayList;

public class registros extends AppCompatActivity {
    ListView contenedor;
    private ArrayAdapter<String> adaptador;

    private almacen datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);

        contenedor= findViewById(R.id.lista_alumnos);

        datos=almacen.getInstanciaAlmacen();

        //------------------------------
        contenedor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String dato = (String) contenedor.getItemAtPosition(position);
                //ejecuta nueva actividad
                Bundle b = new Bundle();
                b.putString("dato",dato);
                Intent NuevoAlumno = new Intent( getApplicationContext(),alta_alumno.class);
                NuevoAlumno.putExtras(b);
                startActivity(NuevoAlumno);
                finish();


            }

        });
        //-----------------------
        traerAlumnos();
    }

    private void traerAlumnos(){
        ArrayList filas = datos.getRegistros();
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, filas);
        contenedor.setAdapter(adaptador);
    }

}