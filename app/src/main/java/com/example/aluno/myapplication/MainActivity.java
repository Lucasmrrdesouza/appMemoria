package com.example.aluno.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView titulo;
    private Button jogar;
    private Button importancia;
    private Button desenvolvimento;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jogar = (Button) findViewById(R.id.buttonJogar);
        importancia = (Button) findViewById(R.id.buttonImportancia);
        desenvolvimento = (Button) findViewById(R.id.buttonDesenvolvimento);
        titulo = (TextView) findViewById(R.id.textViewTitulo);

        jogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(MainActivity.this,Jogar.class));

                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Houve um erro durante a execução. Tente novamente!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        importancia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(MainActivity.this,Importancia.class));


                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Houve um erro durante a execução. Tente novamente!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        desenvolvimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(MainActivity.this,Desenvolvimento.class));



                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Houve um erro durante a execução. Tente novamente!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
