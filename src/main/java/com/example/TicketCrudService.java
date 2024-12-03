package com.example;

import javax.persistence.EntityManager;

public class TicketCrudService {
    private final EntityManager em;

    public TicketCrudService(EntityManager em) {
        this.em = em;
    }

    // Створення квитка
    public Ticket create(Ticket ticket) {
        if (ticket.getClient() == null || ticket.getFromPlanet() == null || ticket.getToPlanet() == null) {
            throw new IllegalArgumentException("Client, fromPlanet, and toPlanet must not be null");
        }

        em.getTransaction().begin();
        em.persist(ticket);
        em.getTransaction().commit();
        return ticket;
    }

    // Читання квитка за ID
    public Ticket read(Long id) {
        return em.find(Ticket.class, id);
    }

    // Оновлення квитка
    public Ticket update(Ticket ticket) {
        em.getTransaction().begin();
        Ticket updated = em.merge(ticket);
        em.getTransaction().commit();
        return updated;
    }

    // Видалення квитка за ID
    public void delete(Long id) {
        em.getTransaction().begin();
        Ticket ticket = em.find(Ticket.class, id);
        if (ticket != null) em.remove(ticket);
        em.getTransaction().commit();
    }
}
