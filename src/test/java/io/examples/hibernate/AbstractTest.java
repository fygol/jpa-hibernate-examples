package io.examples.hibernate;

import org.junit.After;
import org.junit.Before;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.function.Consumer;

public abstract class AbstractTest {
    protected EntityManagerFactory emf;

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("test");
    }

    @After
    public void tearDown() {
        emf.close();
    }

    protected void transaction(Consumer<EntityManager> fn) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        fn.accept(em);
        em.getTransaction().commit();
        em.close();
    }
}
