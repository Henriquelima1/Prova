/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;






import br.edu.ifsul.modelo.Prova;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Meu computador
 */
@Stateful
public class ProvaDao<TIPO> extends DAOGenerico<Prova> implements Serializable  {

    public ProvaDao() {
        super();
        classePersistente = Prova.class;
    }

    
}
