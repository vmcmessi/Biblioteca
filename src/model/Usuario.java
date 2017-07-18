/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Beatriz
 */
public abstract class Usuario
{
    private String nome;
    
    public Usuario() { }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public abstract int limiteEmprestimos();
}
