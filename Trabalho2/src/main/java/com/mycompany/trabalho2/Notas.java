/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho2;

/**
 *
 * @author User
 */
public class Notas {


    Notas(int aInt, String string, String string0, String string1, String string2, String string3, String string4) {
        throw new UnsupportedOperationException("Not supported yet."); 
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public float getEx1() {
        return ex1;
    }

    public void setEx1(float ex1) {
        this.ex1 = ex1;
    }

    public float getEx2() {
        return ex2;
    }

    public void setEx2(float ex2) {
        this.ex2 = ex2;
    }

    public float getEx3() {
        return ex3;
    }

    public void setEx3(float ex3) {
        this.ex3 = ex3;
    }

    public float getEx4() {
        return ex4;
    }

    public void setEx4(float ex4) {
        this.ex4 = ex4;
    }

    public float getT1() {
        return t1;
    }

    public void setT1(float t1) {
        this.t1 = t1;
    }

    public float getT2() {
        return t2;
    }

    public void setT2(float t2) {
        this.t2 = t2;
    }
    private int id;
    private String user;
    private float ex1;
    private float ex2;
    private float ex3;
    private float ex4;
    private float t1;
    private float t2;
    
    public Notas(int id, String user, float ex1, float ex2, float ex3, float ex4, float t1, float t2) {
        this.id = id;
        this.user = user;
        this.ex1 = ex1;
        this.ex2 = ex2;
        this.ex3 = ex3;
        this.ex4 = ex4;
        this.t1 = t1;
        this.t2 = t2;
    }
}

