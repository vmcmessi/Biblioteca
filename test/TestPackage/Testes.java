/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPackage;

import model.Aluno;
import model.Biblioteca;
import model.TipoMaterial;
import model.Livro;
import model.MaterialDigital;
import model.Professor;
import model.Revista;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Victor
 */
public class Testes {
    
    public Testes() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test(expected= Exception.class)
    public void testNomeVazioLivro() throws Exception {
        Livro exe = new Livro();
        Biblioteca biblio = new Biblioteca();
        exe.setNome("");
        exe.setAnoPublicacao(Integer.parseInt("2017"));

        biblio.incluirObra(exe);
    }
    
    @Test(expected=Exception.class)
    public void testNomeNullRevista() throws Exception {
        Revista exe = new Revista();
        Biblioteca biblio = new Biblioteca();
        exe.setDataPublicacao(LocalDate.MIN);

        biblio.incluirObra(exe);
    }
    
    @Test(expected=Exception.class)
    public void testNomeNullMaterialDigital() throws Exception {
        MaterialDigital exe = new MaterialDigital();
        Biblioteca biblio = new Biblioteca();
        exe.setAnoPublicacao(Integer.parseInt("2017"));
        exe.setTipoMaterial(TipoMaterial.AUDIO);

        biblio.incluirObra(exe);
    }
    
    @Test(expected=Exception.class)
    public void testAnoNullLivro() throws Exception {
        Livro exe = new Livro();
        Biblioteca biblio = new Biblioteca();
        exe.setNome("Teste");

        biblio.incluirObra(exe);
    }
    
    @Test(expected=Exception.class)
    public void testDataNullRevista() throws Exception {
        Revista exe = new Revista();
        Biblioteca biblio = new Biblioteca();
        exe.setNome("Teste");

        biblio.incluirObra(exe);
    }
    
    @Test(expected=Exception.class)
    public void testAnoNullMaterialDigital() throws Exception {
        MaterialDigital exe = new MaterialDigital();
        Biblioteca biblio = new Biblioteca();
        exe.setNome("Teste");
        exe.setTipoMaterial(TipoMaterial.AUDIO);

        biblio.incluirObra(exe);
    }
        
    @Test(expected=Exception.class)
    public void testNomeNullAluno() throws Exception {
        Aluno exe = new Aluno();
        Biblioteca biblio = new Biblioteca();
        exe.setMatricula(Integer.MAX_VALUE);

        biblio.incluirUsuario(exe);
    }
    
    @Test(expected=Exception.class)
    public void testNomeNullProfessor() throws Exception {
        Professor exe = new Professor();
        Biblioteca biblio = new Biblioteca();
        exe.setDataAdmissao(LocalDate.MIN);

        biblio.incluirUsuario(exe);
    }
    
    @Test(expected=Exception.class)
    public void testMatriculaNullAluno() throws Exception {
        Aluno exe = new Aluno();
        Biblioteca biblio = new Biblioteca();
        exe.setNome("Teste");

        biblio.incluirUsuario(exe);
    }
    
    @Test(expected=Exception.class)
    public void testDataNullProfessor() throws Exception {
        Professor exe = new Professor();
        Biblioteca biblio = new Biblioteca();
        exe.setNome("Teste");

        biblio.incluirUsuario(exe);
    }


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
