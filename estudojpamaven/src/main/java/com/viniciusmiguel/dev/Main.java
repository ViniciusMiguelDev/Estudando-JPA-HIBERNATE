package com.viniciusmiguel.dev;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.viniciusmiguel.dominio.Pessoa;

public class Main {
    public static void main(String[] args) {
        // Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
        // Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
        // Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        Pessoa p = em.find(Pessoa.class, 2);
        System.out.println(p);

        p = em.find(Pessoa.class, 2);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        
        // em.getTransaction().begin();
        // em.persist(p1);
        // em.persist(p2);
        // em.persist(p3);
        // em.getTransaction().commit();
        System.out.println("Pronto!");
        em.close();
        emf.close();
    }
}