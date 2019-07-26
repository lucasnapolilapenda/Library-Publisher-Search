package com.library.search.publisher;

import javax.xml.ws.Endpoint;

public class EntryPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8092/publishers/", new PublisherImp());
    }
}
