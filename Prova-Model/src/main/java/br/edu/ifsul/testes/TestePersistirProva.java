/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;


import br.edu.ifsul.modelo.Prova;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Meu computador
 */
public class TestePersistirProva {
     public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prova-ModelPU");
        EntityManager em = emf.createEntityManager();
        Prova prova = new Prova();
        prova.setDescricao("é uma prova");
        prova.setConteudo("dificil");
        prova.setDataProva(new GregorianCalendar(2020, Calendar.SEPTEMBER, 10));
        prova.setMediaGeral(00.00);
        prova.setProfessor("lucios");
        
       
   
        em.getTransaction().begin();
        em.persist(prova);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
