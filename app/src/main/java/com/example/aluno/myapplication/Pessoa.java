package com.example.aluno.myapplication;

import com.orm.SugarRecord;

public class Pessoa extends SugarRecord{

    private String nome;
    private String email;

    public Pessoa(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




}