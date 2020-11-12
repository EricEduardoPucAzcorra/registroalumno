package com.example.registroalumno;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.registroalumno.almacen.almacen;

import java.util.ArrayList;

import static android.icu.text.DisplayContext.LENGTH_SHORT;

public class MainActivity extends Activity {
    //relacion entre interfaz grafica y logica(grafica:xml y logica :java)
    //definimos los controles con la que vamos a interactuar.
    private EditText nombre, apellido;

    private Button registrar, ver, cerrar;
    //declaramos un vector , con un tamaño de 4 elementos.
    private String alumnos[]=new String[4];

    private String imprimir;
    //-------------//definimo el array a utiliza para las listas.-----
    ArrayList fila;
//varianble de la veces en la que la lista interactuara
    private  int veces=0;
//finicion de la clase almacenara ram a utilizar.
    almacen datos;

    //unidad 2
    //definir variables para los controles a utilizar-
    private Spinner spPaises;
    private CheckBox chkIngles;
    private RadioButton rdMujer, rdHombre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //union logica y grafica.
        nombre = findViewById(R.id.edtxtCnombre);
        apellido=findViewById(R.id.edtxtCapellido);
        registrar = findViewById(R.id.btnCRegistrar);
        ver = findViewById(R.id.btnCver);
        cerrar= findViewById(R.id.btnCcerrar);
        //defino la relacion de la vairiable datos con la instancia almacen.
        datos= almacen.getInstanciaAlmacen();

        //unidad2
        spPaises=findViewById(R.id.spCPaises);
        chkIngles=findViewById(R.id.chkCIngles);
        rdHombre = findViewById(R.id.rdCButtonHombre);
        rdMujer = findViewById(R.id.rdCButtonMujer);

        //unidad 2

        //Establecer los datos del spiner
        //para establecer los datos en el spiner
        spPaises.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,getPaises()));



        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //para un alert se utliza el toast.
                //Toast.makeText(getApplicationContext(),"Mi primer mensaje",Toast.LENGTH_SHORT).show();

                //con el ciclio for estoy recoriendo_todo mi areglo de alumnos

                //logica definida inicio

                /*for(int cont=0;cont<=alumnos.length;cont++){

                    if(alumnos.length -1 >= cont) {
                        //la intruccion del if es para saber si hemos pasado el limite/tamaño del vector.
                        if (alumnos[cont] == null){
                            //si la posicion del vector es nulo, entoces puedo insertar.
                            alumnos[cont] = nombre.getText().toString();
                            ///le digo que el nombre me lo deje basio
                            nombre.setText("");
                            //para interumpir el ciclio.
                            break;
                        }

                    } else{
                        Toast.makeText(getApplicationContext(),"Ya no tengo espacio suficiente.",Toast.LENGTH_SHORT).show();
                    }


                }*/

                //logica terminada
                //unidad2
                //defino la variable para obtener el valor de ciudad, sexo y si habla ingle.
                String pais="", sexo, ingles="";
                //dice    que el use obtendra el valor que esta capturado en el spiner.
                pais=spPaises.getSelectedItem().toString();
                //capturar valor del idioma, comprobar la elecion del usuario, en cuato al idioma se refiera.
                if (chkIngles.isChecked()) {
                    ingles = "SI";
                }else{
                    ingles="NO";
                }
                //radioButton si es mujer o hombre
                if (rdHombre.isChecked() && rdMujer.isChecked()==false){
                    sexo ="Hombre";
                } else if( rdHombre.isChecked()==false && rdMujer.isChecked()){
                    sexo="Mujer";
                }else{
                    sexo="";
                }
                //nuevo
                fila = new ArrayList();
                fila.add(veces);
                fila.add(nombre.getText().toString());
                fila.add(apellido.getText().toString());
                fila.add(pais);
                fila.add(sexo);
                fila.add(ingles);

                datos.setRegistro(veces,fila);

                veces = veces + 1;

                //imprimir("El alumno fue registrado");
                Toast.makeText(getApplicationContext(),"El alumno fue registrado",Toast.LENGTH_SHORT).show();


            }

            private void show() {
            }
        });//fin de click registrar



        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Mostrar todos los registros",Toast.LENGTH_SHORT).show();

                /*for (int i=0; i <= alumnos.length -1; i++ ){
                    Toast.makeText(getApplicationContext(),alumnos[i],Toast.LENGTH_SHORT).show();
                }*/

                Intent ver = new Intent(getApplicationContext(),registros.class);
                startActivity(ver);

            }
        });//fin de click ver registros


        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });///fin de click cerrar app

    }
    //aray para establecer los datos en el spiner.
    private  String[]  getPaises(){
        String paises[]=new String[6];
        paises[0]="Argentina";
        paises[1]="Mexico";
        paises[2]="New York";
        paises[3]="EUA";
        paises[4]="Honduras";
        paises[5]="Cuba";
        //me retorna el array
        return paises;
    }//fin del metodo del spiner
}