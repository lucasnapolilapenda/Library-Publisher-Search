package com.library.search.publisher;

/**
 *
 * @author Lucas Napoli
 * V1.0
 * Library Microservices
 * Service Publisher Search
 */

import javax.xml.ws.WebFault;

/**
 *Class to manage the fault
 */

@WebFault(name ="Fault", targetNamespace = "com.library.search.publisher")
public class Fault extends Exception {

    public Fault(String string) {
        super(string);
    }

    public Fault (String string, Throwable cause) {
        super (string, cause);
    }
}
