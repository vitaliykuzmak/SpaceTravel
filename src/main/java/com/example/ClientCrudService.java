package com.example;

import javax.persistence.EntityManager;

public class ClientCrudService {
    private final EntityManager em;

    public ClientCrudService(EntityManager em) {
        this.em = em;
    }

    public Client create(Client client) {
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
        return client;
    }

    public Client read(Long id) {
        return em.find(Client.class, id);
    }

    public Client update(Client client) {
        em.getTransaction().begin();
        Client updated = em.merge(client);
        em.getTransaction().commit();
        return updated;
    }

    public void delete(Long id) {
        em.getTransaction().begin();
        Client client = em.find(Client.class, id);
        if (client != null) em.remove(client);
        em.getTransaction().commit();
    }
}
