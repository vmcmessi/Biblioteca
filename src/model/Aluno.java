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
public class Aluno extends Usuario{

    private int matricula;
    
    public Aluno(){
        setMatricula(0);
    }
    
    public Aluno(int numeroMatricula) {
        setMatricula(numeroMatricula);
    }
    
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public int limiteEmprestimos() {
        return 3;
    } 
}
