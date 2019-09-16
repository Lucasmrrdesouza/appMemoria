package com.example.aluno.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.orm.SchemaGenerator;
import com.orm.SugarContext;
import com.orm.SugarDb;

public class MainActivity extends AppCompatActivity {

    private TextView titulo;
    private Button jogar;
    private Button importancia;
    private Button desenvolvimento;
    private Button cadastro;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SugarContext.init(getApplicationContext());
        SchemaGenerator schemaGenerator = new SchemaGenerator(this);
        schemaGenerator.createDatabase(new SugarDb(this).getDB());


        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.CAMERA},0);
        }





        jogar = (Button) findViewById(R.id.buttonJogar);
        importancia = (Button) findViewById(R.id.buttonImportancia);
        desenvolvimento = (Button) findViewById(R.id.buttonDesenvolvimento);
        titulo = (TextView) findViewById(R.id.textViewTitulo);
        cadastro = (Button) findViewById(R.id.btnTelaCadastrar);

        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (MainActivity.this, CadastroPessoaActivity.class));
            }
        });


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
