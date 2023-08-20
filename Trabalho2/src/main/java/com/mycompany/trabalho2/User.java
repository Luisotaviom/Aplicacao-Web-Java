
package com.mycompany.trabalho2;

import javax.servlet.http.HttpSession;


public class User {

    User(int aInt, String string, String string0, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private int id;
    private String nome;
    private String celular;
    private String data_nascimento;
    private String email;
    private String senha;
    

    public User(int id, String nome, String celular, String data_nascimento, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.celular = celular;
        this.data_nascimento = data_nascimento;
        this.email = email;
        this.senha = senha;
    }

}
