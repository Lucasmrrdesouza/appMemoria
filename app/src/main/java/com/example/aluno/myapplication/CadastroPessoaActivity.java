package com.example.aluno.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.orm.SchemaGenerator;
import com.orm.SugarContext;
import com.orm.SugarDb;

import java.util.List;

public class CadastroPessoaActivity extends AppCompatActivity {


    private EditText nome;
    private EditText email;
    private Button cadastrar;

    private TextView pessoas;
    private Button listarPessoas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pessoa);




        nome = (EditText) findViewById(R.id.etNome);
        email= (EditText) findViewById(R.id.etEmail);
        cadastrar = (Button) findViewById(R.id.btnCadastrar);
        pessoas = (TextView) findViewById(R.id.tvPessoas);
        listarPessoas = (Button) findViewById(R.id.btnListarPessoas);


        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(CadastroPessoaActivity.this, "Salvando pessoa...", Toast.LENGTH_SHORT).show();
                // Receber os dados dos campos de texto

                String n = nome.getText().toString();
                String e = email.getText().toString();

                //Cria um objeto de pessoa
                Pessoa p = new Pessoa();
                p.setNome(n);
                p.setEmail(e);

                //Salvar o banco de dados

                p.save();

                //Limpar os campos

                nome.setText("");
                email.setText("");

            }
        });

        listarPessoas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                List<Pessoa> listaDePessoas= Pessoa.listAll(Pessoa.class);

                String lista = "";

                for (Pessoa p: listaDePessoas) {
                    lista = lista + p.getNome()+"\n";
                }

                pessoas.setText(lista);

            }
        });


    }
}
