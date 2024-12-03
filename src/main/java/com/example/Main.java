package com.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // Ініціалізація EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("spacetravel");
        EntityManager em = emf.createEntityManager();

        ClientCrudService clientService = new ClientCrudService(em);
        PlanetCrudService planetService = new PlanetCrudService(em);
        TicketCrudService ticketService = new TicketCrudService(em);

        // Додати клієнта
        Client client = new Client("John Doe");
        clientService.create(client);

        // Додати планети
        Planet earth = new Planet("EARTH", "Earth");
        Planet mars = new Planet("MARS", "Mars");
        planetService.create(earth);
        planetService.create(mars);

        // Створити квиток
        Ticket ticket = new Ticket(client, earth, mars);
        ticketService.create(ticket);

        // Прочитати квиток
        Ticket readTicket = ticketService.read(ticket.getId());
        System.out.println("Read Ticket: " + readTicket);

        // Оновити квиток
        readTicket.setToPlanet(earth);
        ticketService.update(readTicket);

        // Видалити квиток
        ticketService.delete(readTicket.getId());

        // Закриття EntityManager
        em.close();
        emf.close();
    }
}

