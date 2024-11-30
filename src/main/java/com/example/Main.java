package com.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("spacetravel");
        EntityManager em = emf.createEntityManager();

        // ClientCRUDService
        ClientCrudService clientService = new ClientCrudService(em);
        Client newClient = new Client("Test Client");
        clientService.create(newClient);

        Client client = clientService.read(newClient.getId());
        System.out.println("Read Client: " + client);

        client.setName("Updated Client");
        clientService.update(client);

        clientService.delete(client.getId());

        // PlanetCRUDService
        PlanetCrudService planetService = new PlanetCrudService(em);
        Planet newPlanet = new Planet("PLT01", "Test Planet");
        planetService.create(newPlanet);

        Planet planet = planetService.read(newPlanet.getId());
        System.out.println("Read Planet: " + planet);

        planet.setName("Updated Planet");
        planetService.update(planet);

        planetService.delete(planet.getId());

        em.close();
        emf.close();
    }
}
