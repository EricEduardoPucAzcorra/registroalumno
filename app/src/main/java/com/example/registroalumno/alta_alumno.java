package com.example.registroalumno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.registroalumno.almacen.almacen;

public class alta_alumno extends AppCompatActivity {
    private Button nuevo, eliminar, verR;
    TextView contenido;

    private almacen ram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_alumno);
        contenido= findViewById(R.id.txtCdatos);
        nuevo = findViewById(R.id.btnNuevo);
        eliminar = findViewById(R.id.btnEliminar);
        verR = findViewById(R.id.btnCregistrados);
        String resultado;

        //unidad 2
        ram= almacen.getInstanciaAlmacen();


        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            resultado=extras.get("dato").toString();
            contenido.setText(resultado);
        }
        //unidad 2
        //eliminar , ver
        nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Intent principal = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(principal);*/
                finish();
            }
        });//fin de nuevo
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //logica para eliminar a un registro
                int posicionInicial = contenido.getText().toString().indexOf("[") +1;
                int posicionFinal= contenido.getText().toString().indexOf("]",posicionInicial);
                String resultado= contenido.getText().toString().substring(posicionInicial,posicionFinal); //*le estoy diciendo que
                // me traiga el valor qu entre los corchetes//*
                ram.setEliminarRegistro(Integer.valueOf(resultado));

                Toast.makeText(getApplicationContext(),"se ha eliminado al registro con exito", Toast.LENGTH_SHORT).show();

                Intent verRegistros = new Intent(getApplicationContext(),registros.class);
                startActivity(verRegistros);
                finish();


            }
        });//fin de elimnar

        verR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent verRegistros = new Intent(getApplicationContext(),registros.class);
                startActivity(verRegistros);
                finish();
            }
        });
    }
}