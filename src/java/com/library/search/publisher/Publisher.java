package com.library.search.publisher;

/**
 *
 * @author Lucas Napoli
 * V1.0
 * Library Microservices
 * Service Publisher Search
 */


/**
 * Class to manage Publisher Object
 */

public class Publisher implements Cloneable {
    String publishername;
    String publishingcompany;
    String address;

    public String getPublisherName() {
        return publishername;
    }

    public void setPublisherName(String publisherName) {
        this.publishername = publisherName;
    }

    public String getPublishingCompany() {
        return publishingcompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingcompany = publishingCompany;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Publisher clone() {
        Publisher p = new Publisher();
        p.setPublisherName(this.publishername);
        p.setAddress(this.address);
        p.setPublishingCompany(this.publishingcompany);
        return p;
    }
}
