/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._usjt_psc_sistema;

/**
 *
 * @author Usuario
 */
public class Pessoa {
    private int codigo;
    private String email, password;
    
    public Pessoa (String email, String password)   {
        this.email = email;
        this.password = password;
    }
    
    public int getCodigo()  {
        return codigo;
    }

    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPassword (String password)   {
        if (this.password.equals(password)) {
            System.out.println("Senha idêntica à atual.");
        }
        this.password = password;
    }
}