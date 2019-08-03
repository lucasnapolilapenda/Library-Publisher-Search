package com.library.search.publisher;

import javax.xml.ws.WebFault;

@WebFault(name ="Fault", targetNamespace = "com.library.search.publisher")
public class Fault extends Exception {

    public Fault(String string) {
        super(string);
    }

    public Fault (String string, Throwable cause) {
        super (string, cause);
    }
}
