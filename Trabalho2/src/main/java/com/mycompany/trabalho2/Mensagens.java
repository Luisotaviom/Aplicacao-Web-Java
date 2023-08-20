/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho2;

/**
 *
 * @author User
 */
public class Mensagens {

    public Mensagens(int id, String mensagem, String user) {
        this.id = id;
        this.mensagem = mensagem;
        this.user = user;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
        public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
   
    private int id;
    private String mensagem;
    private String user;


}
