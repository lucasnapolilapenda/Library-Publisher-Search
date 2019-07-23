package com.library.search.publisher;

public class Publisher implements Cloneable {
    String publisherName;
    String publishingCompany;
    String address;

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Publisher clone() {
        Publisher p = new Publisher();
        p.setPublisherName(this.publisherName);
        p.setAddress(this.address);
        p.setPublishingCompany(this.publishingCompany);
        return p;
    }
}
