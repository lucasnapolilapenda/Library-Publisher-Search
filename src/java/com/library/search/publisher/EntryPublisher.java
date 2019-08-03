package com.library.search.publisher;

/**
 *
 * @author Lucas Napoli
 * V1.0
 * Library Microservices
 * Service Publisher Search
 */

import javax.xml.ws.Endpoint;

/**
 * To manage the endpoint
 */

public class EntryPublisher {

    /**
     * To manage the endpoint
     * @param args argument to be main
     */
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8092/publishers/", new PublisherImp());
    }
}
