package com.example;

import javax.persistence.EntityManager;

public class PlanetCrudService {
    private final EntityManager em;

    public PlanetCrudService(EntityManager em) {
        this.em = em;
    }

    public Planet create(Planet planet) {
        em.getTransaction().begin();
        em.persist(planet);
        em.getTransaction().commit();
        return planet;
    }

    public Planet read(String id) {
        return em.find(Planet.class, id);
    }

    public Planet update(Planet planet) {
        em.getTransaction().begin();
        Planet updated = em.merge(planet);
        em.getTransaction().commit();
        return updated;
    }

    public void delete(String id) {
        em.getTransaction().begin();
        Planet planet = em.find(Planet.class, id);
        if (planet != null) em.remove(planet);
        em.getTransaction().commit();
    }
}

