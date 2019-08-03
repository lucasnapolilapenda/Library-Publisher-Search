package com.library.search.publisher;

/**
 *
 * @author Lucas Napoli
 * V1.0
 * Library Microservices
 * Service Publisher Search
 */


import javax.xml.ws.WebServiceContext;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class PublisherRepository {

        private ConcurrentHashMap<Integer, Publisher> map;

        public PublisherRepository() {
            map = new ConcurrentHashMap<Integer, Publisher>();
        }

        private static PublisherRepository instance = null;

    /**
     * Instance Creation
     * @param context Web service context
     * @return Context
     */

        public static PublisherRepository getInstance(WebServiceContext context){
            return instance == null && context != null?
                    (instance = new PublisherRepository()): instance;
        }

    /**
     * Search Publishers
     * @param publisher Publisher info Object
     * @return String with info
     */


        public String searchPublisher(Publisher publisher) {
            ArrayList<Publisher> publisherArrayList = new DataBaseManager().repoReader();
            Integer id = 0;
            System.out.println(publisher.getPublisherName());
                for (Publisher p : publisherArrayList) {
                    System.out.println(p.publishername);
                    System.out.println(publisher.publishername+"OK");
                    if (p.getPublisherName().equals(publisher.getPublisherName())) {
                        id++;
                        map.put(id, p);
                    }
                }
                System.out.println(map.get(1));
            if (map.get(1) != null){
                String publisher1 = "Name: " + map.get(1).getPublisherName() +
                                    " Company: " + map.get(1).getPublishingCompany() +
                                    " Address: " + map.get(1).getAddress();
                return publisher1;
            }
            else {
                return "No publisher associated has been found";
            }
        }



        // Method to return an Publisher Object or Array is case of being necessary
    /*
        public object searchPublisherObject(Publisher publisher) throws Exception {
        ArrayList<Publisher> publisherArrayList = new DataBaseManager().repoReader();
        Integer id = 0;
        if (publisher.getPublisherName() != null) {
            for (Publisher p : publisherArrayList) {
                if (p.getPublisherName().equals(publisher.getPublisherName())) {
                    id++;
                    map.put(id, p);
                }
            }
        }

        if (map.get(1) == null){
            return publisherArrayList;
        }



        Set<Integer> ids = map.keySet();
        ArrayList<Publisher> finalPublisherList = new ArrayList<>();
        for (Integer aux : ids) {
            finalPublisherList.add(map.get(aux).clone());
        }
        map.clear();
        return finalPublisherList;
    }
     */





}
