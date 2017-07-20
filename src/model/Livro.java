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
public class Livro extends Exemplar
{
    private String autor;
    private int anoPublicacao;
    private int edicao;

    public Livro(String nmAutor, int anoPublicacao, int edicao){
        //super();
        setAutor(nmAutor);
        setAnoPublicacao(anoPublicacao);
        setEdicao(edicao);
    }

    public Livro(){
        super();
        setAutor("");
        setAnoPublicacao(0);
        setEdicao(0);
    }
    
    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
