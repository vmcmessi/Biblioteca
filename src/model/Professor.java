/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Beatriz
 */
public class Professor extends Usuario
{
    private LocalDate dataAdmissao;
 
    public Professor() { 
        super();
        setDataAdmissao(LocalDate.MIN);
    }
    
    public Professor(LocalDate dtAdmissao) { 
        super();
        setDataAdmissao(dtAdmissao);
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dtAdmissao) {
        this.dataAdmissao = dtAdmissao;
    }
    
    @Override
    public int limiteEmprestimos() {
        return 5;
    }   
}