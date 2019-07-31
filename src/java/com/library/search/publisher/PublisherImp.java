package com.library.search.publisher;

/** Library Solos Rest.
 * @author Lucas Napoli
 * @author https://github.com/lucasnapolilapenda/SoapServer
 * @version 1.1
 * @since 1.0
 */



import javax.annotation.Resource;
import javax.jws.WebService;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Represents all services implementation
 */
@WebService(endpointInterface = "com.library.search.publisher.PublisherInterface")

public class PublisherImp implements PublisherInterface {

    @Resource
    WebServiceContext context;


    /**
     * @return returns java.lang.String
     * List of books
     */
    @Override
    public String getPublisherInfo(Publisher publisher) throws Exception {
        if (isAuthenticated()) {
            return new PublisherRepository().searchPublisher(publisher);
       } else {
            throw new HTTPException(401);
       }
    }

    private boolean isAuthenticated() {
        MessageContext messageContext = context.getMessageContext();
        Map httpHeaders = (Map) messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
        List userNameList = (List) httpHeaders.get("username");
        List passwordList = (List) httpHeaders.get("password");
        if (userNameList.contains("book-service") && passwordList.contains("book-service-secure-password-1234"))
        return true;
        else
        return false;
    }
}