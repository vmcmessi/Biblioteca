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
public class Emprestimo {
    private Usuario usuario;
    private Exemplar obra;
    private LocalDate data;
    private SituacaoDoEmprestimo situacaoEmprestimo;

    public Emprestimo(Usuario usuario, Exemplar obra, LocalDate dtEmprestimo,SituacaoDoEmprestimo situacaoEmprestimo)
    {
        setUsuario(usuario);
        setObra(obra);
        setData(dtEmprestimo);
        setSituacaoEmprestimo(situacaoEmprestimo);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Exemplar getObra() {
        return obra;
    }

    public void setObra(Exemplar obra) {
        this.obra = obra;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public SituacaoDoEmprestimo getSituacaoEmprestimo() {
        return situacaoEmprestimo;
    }

    public void setSituacaoEmprestimo(SituacaoDoEmprestimo situacaoEmprestimo) {
        this.situacaoEmprestimo = situacaoEmprestimo;
    }
}
