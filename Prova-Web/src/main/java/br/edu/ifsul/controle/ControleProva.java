/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;



import br.edu.ifsul.dao.ProvaDao;
import br.edu.ifsul.modelo.Nota;
import br.edu.ifsul.modelo.Prova;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Meu computador
 */
@Named(value = "controleProva")
@ViewScoped
public class ControleProva implements Serializable{
    @EJB
    private ProvaDao<Prova> dao;
    private Prova objeto;
    private Nota nota;
    private Boolean novoNota;

    public ControleProva() {
    }

 
    
    
   
    public String listar(){
        return "/privado/Prova/listar?faces-redirect=true";
    }
    
    
    public void novo(){
        
        objeto = new Prova();
    }
    
    public void novoNota(){
        nota = new Nota();
       
    }
    
    public void alterar(Object id){
        try {
            objeto = dao.getObjectByID(id);
            
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }
    }
    public void alterarNota(int valor){
        nota = objeto.getNotas().get(valor);
    }
    
    public void excluir(Object id){
        try {
            objeto = dao.getObjectByID(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao remover objeto: " + Util.getMensagemErro(e));
        }
    }
    public void excluirNota(int valor){
        objeto.removerNota(valor);
        Util.mensagemInformacao("Nota removida com sucesso!");
    }
    
    public void salvar(){
        try {
            
            if (objeto.getId() == null){
                
                dao.persist(objeto);
            } else {
                
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao salvar objeto: " + Util.getMensagemErro(e));
        }
    }
    public void salvarNota(){
       if(novoNota){
           objeto.adicionarNota(nota);
       }
       Util.mensagemInformacao("Nota adicionada ou alterada com sucesso!");
    }

    
    
    
}
