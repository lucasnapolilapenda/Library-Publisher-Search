package com.library.search.publisher;

/** Library Solos Rest.
 * @author Lucas Napoli
 * @author https://github.com/lucasnapolilapenda/SoapServer
 * @version 1.1
 * @since 1.0
 */



import javax.jws.WebService;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;

/**
 * Represents all services implementation
 */
@WebService(endpointInterface = "com.library.search.publisher.PublisherImp")

public class PublisherImp implements PublisherInterface {

    @Context
    private UriInfo context;

    /**
     * @return returns java.lang.String
     * List of books
     */
    @Override
    public String getPublisherInfo(Publisher publisher) throws Exception {
            return new PublisherRepository().searchPublisher(publisher);
    }
}