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
public class Revista extends Exemplar
{
    private LocalDate dataPublicacao;
    private int edicao;

     public Revista() {
        setDataPublicacao(LocalDate.MIN);
        setEdicao(0);
    }
    
    public Revista(LocalDate dtPublicacao, int edicao) {
        setDataPublicacao(dtPublicacao);
        setEdicao(edicao);
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}