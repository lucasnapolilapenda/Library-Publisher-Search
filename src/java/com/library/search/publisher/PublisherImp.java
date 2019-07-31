package com.library.search.publisher;

/** Library Solos Rest.
 * @author Lucas Napoli
 * @author https://github.com/lucasnapolilapenda/SoapServer
 * @version 1.1
 * @since 1.0
 */



import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
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
    public String getPublisherInfo(Publisher publisher) {
        try {
            if (isAuthenticated()) {
                return PublisherRepository.getInstance(context).searchPublisher(publisher);
            } else {
                return "Problems with the Publisher Service, contact the administrator";
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return  "Problems with the Publisher Service, contact the administrator";
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