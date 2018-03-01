package com.example.alumnom.agenda12;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.OutputStreamWriter;

public class addcontact extends AppCompatActivity {
    private EditText et1, et2;
    private Button btn3, btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontact);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        Button btn = (Button) findViewById(R.id.btn4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    //vamos a guardar los contactos con el numero y nombre
    public void guardar(View v)
    {
        String nomArchivo = et1.getText().toString();
        nomArchivo = nomArchivo.replace('/','-');
        try{
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(nomArchivo, Activity.MODE_PRIVATE));
            archivo.write(et2.getText().toString());
            archivo.flush();
            archivo.close();
            Toast.makeText(getApplicationContext(), "Contacto Guardado", Toast.LENGTH_LONG).show();
        }catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "Introduce Datos Correctos", Toast.LENGTH_LONG).show();
        }
        et1.setText("");
        et2.setText("");
    }



    }

