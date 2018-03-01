package com.example.alumnom.agenda12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class listcontact extends AppCompatActivity {

    ListView lv1;
    TextView tv6, tv7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listcontact);

        lv1 = (ListView)findViewById(R.id.lv1);
    }
    public void recuperar(View v){
        String nomArchivo = tv6.getText().toString();
        nomArchivo = nomArchivo.replace('/','-');

        boolean encontrado = false;
        String []archivos = fileList(); // El metodo fileList() devuelve todos los ficheros de la aplicaccion.
        for (int i = 0; i< archivos.length; i++)
        {
            if(nomArchivo.equals(archivos[i]))
            {
                encontrado = true;
            }

            if(encontrado)
            {
                try {
                    InputStreamReader archivo = new InputStreamReader(openFileInput(nomArchivo));
                    BufferedReader br = new BufferedReader(archivo);
                    String linea = br.readLine();
                    String todo = "";
                    while(linea!=null)
                    {
                        todo +=linea+"\n";
                        linea = br.readLine();
                    }
                    br.close();
                    archivo.close();
                    tv7.setText(todo);
                }catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "Imposible de abrir", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    public void mostrarListadoFicheros(View v)
    {
        String []archivos = fileList(); // El metodo fileList() devuelve todos los ficheros de la aplicaccion.
        String listado="";
        for (int i = 0; i<archivos.length; i++)
        {
            listado += archivos[i]+"\n";

        }
        tv7.setText(listado);
    }

}
