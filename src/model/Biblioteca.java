package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 *
 * @author Beatriz
 */
public class Biblioteca
{
    private ArrayList<Usuario> usuarios;
    private ArrayList<Exemplar> exemplares;
    private ArrayList<Emprestimo> emprestimos;

    public Biblioteca() {
        usuarios = new ArrayList<>();
        exemplares = new ArrayList<>();
        emprestimos = new ArrayList<>();
    }

    public void incluirUsuario(Usuario usuario) throws Exception
    {
        //Valida o tipo do usuário
        String nome = usuario.getNome();
        if (nome == null || nome.isEmpty()) {
            throw new Exception("O nome é obrigatório");
        }
        
        if(usuario instanceof Professor) {
            if(((Professor)usuario).getDataAdmissao() == null || ((Professor)usuario).getDataAdmissao() == LocalDate.MIN ) {
                throw new Exception("A data é obrigatória");
            }
        } else if(usuario instanceof Aluno) {
            if(((Aluno)usuario).getMatricula() == 0){
                throw new Exception("O matrícula é obrigatório!");
            }
        }
        usuarios.add(usuario);
    }
    
    public void incluirObra(Exemplar exemplar) throws Exception
    {
        String nome;
        if(exemplar instanceof Livro){
            nome = ((Livro)exemplar).getNome();
            //Valida o Livro
            if (nome == null || nome.isEmpty()) {
                throw new Exception("O nome é obrigatório!");
            }
            else if(((Livro)exemplar).getAnoPublicacao() == 0) {
                throw new Exception("O ano de publicação é obrigatório");
            }
        }
        else if(exemplar instanceof MaterialDigital) {
            nome = ((MaterialDigital)exemplar).getNome();
            //Valida o material digital
            if (nome == null || nome.isEmpty()) {
                throw new Exception("O nome é obrigatório!");
            }
            else if(((MaterialDigital)exemplar).getAnoPublicacao() == 0) {
                throw new Exception("O ano de publicação é obrigatório");
            }
            else if(((MaterialDigital)exemplar).getTipoMaterial() == null) {
                throw new Exception("O tipo do material é obrigatório");
            }
        }else if(exemplar instanceof Revista){
            nome = ((Revista)exemplar).getNome();
            //valida a revista
            if (nome == null || nome.isEmpty()) {
                throw new Exception("O nome é obrigatório!");
            }
            else if(((Revista)exemplar).getDataPublicacao()== null || ((Revista)exemplar).getDataPublicacao()== LocalDate.MIN){
                throw new Exception("A data de publicação é obrigatória");
            }
            
        }
        exemplares.add(exemplar);
    }
    
    public void devolver(Exemplar obra) throws Exception{
        Emprestimo emprestimo = null;
        for (Emprestimo e : emprestimos) {
            if(e.getObra().equals(obra)){
                emprestimo = e;
            }
        }
        
        if (emprestimo != null && emprestimo.getSituacaoEmprestimo() == SituacaoDoEmprestimo.LOCADO){
            emprestimo.setSituacaoEmprestimo(SituacaoDoEmprestimo.DEVOLVIDO);
        } else {
            throw new Exception("Este exemplar não foi alocado");
        }
    }
    
    public void realizarEmprestimo(Exemplar obra, Usuario usuario, LocalDate dataEmprestimo) throws Exception
    {
        //valida se a obra já não foi emprestada
        for (Emprestimo e : emprestimos) {
            if (e.getObra().equals(obra) && e.getSituacaoEmprestimo() == SituacaoDoEmprestimo.LOCADO) {
                throw new Exception("A obra " + obra.getNome() + " não se encontra a disposição");
            }
        }
        //valida o limite de empréstimos
        Collection<Emprestimo> emprestimosDoUsuario = new HashSet<>();
        if (emprestimos != null && usuario != null) {
            for (Emprestimo e : emprestimos) {
                if (e.getUsuario().equals(usuario) && e.getSituacaoEmprestimo().equals(SituacaoDoEmprestimo.LOCADO)) {
                    emprestimosDoUsuario.add(e);
                }
            }
        }
        //verifica se passou o limite
        if ((emprestimosDoUsuario.size() + 1) > usuario.limiteEmprestimos()) {
            throw new Exception("O usuário atingiu o limite de emprestimos");
        }else{
            //cria o novo empréstimo
            Emprestimo e = new Emprestimo(usuario,obra,LocalDate.now(),SituacaoDoEmprestimo.LOCADO);
            emprestimos.add(e);
        }
    }
    
    public Double calcularValorEmprestimo(Exemplar obra) throws Exception
    {
        if (emprestimos != null && obra != null)
        {
            for (Emprestimo e : emprestimos)
            {
                if (e.getObra().equals(obra) && e.getSituacaoEmprestimo().equals(SituacaoDoEmprestimo.LOCADO)) {
                    
                    Calendar cal = Calendar.getInstance();
                    
                    LocalDate date = LocalDate.now();
                    
                    cal.set(Calendar.DAY_OF_MONTH, date.getDayOfMonth());
                    cal.set(Calendar.MONTH, date.getMonthValue());
                    cal.set(Calendar.YEAR, date.getYear());
                    Date dataFim = cal.getTime();

                    date = e.getData();
                    cal.set(Calendar.DAY_OF_MONTH, date.getDayOfMonth());
                    cal.set(Calendar.MONTH, date.getMonthValue());
                    cal.set(Calendar.YEAR, date.getYear());
                    Date dataInicio = cal.getTime();
                    
                    long days = dataFim.getTime() - dataInicio.getTime();
                   
                    return (days / 1000 / 60 / 60 / 24) * 1.0;
                }
            }
        }
        
        throw new Exception("Este exemplar não foi alocado");
    }
        
    public ArrayList<Exemplar> listarObrasEmEmprestimo()
    {
        ArrayList<Exemplar> exemplarEmEmprestimo = new ArrayList<>();
        for (Emprestimo e : emprestimos){
            if (e.getSituacaoEmprestimo() == SituacaoDoEmprestimo.LOCADO){
                exemplarEmEmprestimo.add(e.getObra());
            }
        }
        return exemplarEmEmprestimo;
    }
        
    public ArrayList<Exemplar> listarObrasPorNome(String titulo)
    {
        ArrayList<Exemplar> ExemplarTitulo = new ArrayList<>();
        for(Exemplar obra : exemplares){
            if(obra.getNome().contains(titulo)){
                ExemplarTitulo.add(obra);
            }
        }
        return ExemplarTitulo;
    }
    
    public ArrayList<Usuario> usuarios(){
        return usuarios;
    }
    
    public ArrayList<Exemplar> listarObrasNaoDevolvidas()
    {
        ArrayList<Exemplar> obrasEmEmprestimo = new ArrayList<>();
        for(Emprestimo emprestimo : emprestimos){
            if(emprestimo.getSituacaoEmprestimo() == SituacaoDoEmprestimo.LOCADO){
                obrasEmEmprestimo.add(emprestimo.getObra());
            }
        }
        
        ArrayList<Exemplar> retorno = new ArrayList<>();
        
        for(Exemplar obra : exemplares)
        {
            if(!obrasEmEmprestimo.contains(obra)){
                retorno.add(obra);
            }
        }
        return retorno;
    }
}