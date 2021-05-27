/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;


import br.edu.ifsul.modelo.Nota;
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
public class TestePersistirNota {
     public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prova-ModelPU");
        EntityManager em = emf.createEntityManager();
        Nota nota = new Nota();
        nota.setAluno("henrique");
        nota.setNota(10.00);
        nota.setProva(em.find(Prova.class, 1));

       
   
        em.getTransaction().begin();
        em.persist(nota);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
