# LibrarySearchPublisher

LibrarySearchPublicher is a part of the project Library Micro Services. This module is a server that sends publisher info
SOAP service

## Installation

Project created in Maven, all the dependencies are in a .pom document.

Compile the code but first check the Server Url in the following class:

```
public class EntryPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8092/publishers/", new PublisherImp());
    }
}    

    

```
Update URL depending on server configuration

Additonally update the txt repo in:
```
    public class DataBaseManager {
    .......
        public ArrayList<Book> repoReader () {
            ......
                            String fXmlFile = "src/main/webapp/WEB-INF/publishers.xml";

```

## Contributing
Academic Project for McGill University. No contributing is requested. 

## License
[MIT](https://choosealicense.com/licenses/mit/)