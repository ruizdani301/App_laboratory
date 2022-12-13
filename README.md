# ***App_laboratory***
  This project present through API REST services, the ability to control a laboratory appointment schedule.  
  A CRUD was implemented for this purpose.
  
  ### Distribution of the tables
![image](https://user-images.githubusercontent.com/81341089/205459243-f827dc83-cfbb-4451-bd80-de46482c7739.png)


  
   ### Directories
     this path src/main/java/laboratory contains 4 folders contoller, entity, repository, service. I will explain below.
    
   #### contoller:
        contains the endpoints that allow the client's request to be communicated with the model.

   #### entity:
        contains the models of the tables in the database
    
   #### service:
       contain the implementation and business logic.
       
   ## to run the crud on table "test" the following paths are used
#### method GET
- /api/controller/test - Return a test list
- /api/controller/test/{id} - Return a specific test
#### method post
- /api/controller/test
#### method put
- /api/controller/test/{id}
#### method delete
- /api/controller/test/{id}

 ## to run the crud on table "affiliates" the following paths are used
#### method GET
- /api/controller/affiliate -  Return a affiliate list
- /api/controller/affiliate/{id} -  Return a specific affiliate
#### method post
- /api/controller/affiliate/
#### method put
- /api/controller/affiliate/{id}
#### method delete
- /api/controller/affiliate/{id}

 ## to run the crud on table "appointments" the following paths are used
#### method GET
- /api/controller/appointment/ -  Return a appointment list 
- /api/controller/appointment/{id} - Return a specific appointment
- /api/controller/appointment/affiliates/{id} - Return all the appointments of one affiliate 
- /api/controller/appointment/group/{DATE} - Return all the affiliates with an appointments in specific date
#### method post
- /api/controller/appointment
#### method put
- /api/controller/appointment/{id}
#### method delete
- /api/controller/appointment/{id}
      
  ### technologies
      in ubuntu 22.04
      - mysql       version 8.0.31
      - Java        version 17.0.4.1
      - Spring Boot version 2.7.5
    
  Author

* **Daniel Ruiz Linkedin** - [DanielRuiz](https://www.linkedin.com/in/daniel-ruiz)
  
