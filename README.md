# DOG BREEDS API  🐶
In this repository you will find an api of dog breeds. The relational model was built as follows:

![](./DOG_BREE_API_MER.png)  

This project has an architecture based on microservices. It is important to say that this dog breed api consumes or communicates with an external service (api) called countries-api whose task is to find the country of origin of a specific breed. This api has different layers: 

- Domain layer.
- Persistence layer.
- Service layer.
- Rest layer.  

To run the project you can clone this repository and run the following commands in the terminal.  

 - ./gradle build : generate the build / libs folder with the project's JAR
 - ./gradle run : run the project
 - ./gradle test : run all tests

Finally access the browser or a tool to be able to make requests. This project has different endpoints.

####EndPoints: dog breed 

--- 

    Find by id dog breed : GET

 http://localhost:8000/api/v1.0/dogbreeds/ID

    Find all dog breeds : GET

http://localhost:8000/api/v1.0/dogbreeds/ 

    Delete by id dog breed : DELETE

http://localhost:8000/api/v1.0/dogbreeds/ID

    Save a dog breed : POST

http://localhost:8000/api/v1.0/dogbreeds/ 

    Update by id a dog breed : PUT

http://localhost:8000/api/v1.0/dogbreeds/ID 

####EndPoints: dog breed colors

--- 

    Find by id color : GET

http://localhost:8000/api/v1.0/colors/ID

    Find all colors : GET

http://localhost:8000/api/v1.0/colors/ 

####EndPoints: dog breed natures

--- 

    Find by id nature : GET

http://localhost:8000/api/v1.0/natures/ID

    Find all natures : GET

http://localhost:8000/api/v1.0/natures/ 







