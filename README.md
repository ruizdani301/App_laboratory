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
- /api/controller/test/listall
- /api/controller/test/getone/{id}
#### method post
- /api/controller/test/add
#### method put
- /api/controller/test/update/{id}
#### method delete
- /api/controller/test/delete/{id}

 ## to run the crud on table "affiliates" the following paths are used
#### method GET
- /api/controller/affiliate/listall
- /api/controller/affiliate/getone/{id}
#### method post
- /api/controller/affiliate/add
#### method put
- /api/controller/affiliate/update/{id}
#### method delete
- /api/controller/affiliate/delete/{id}

 ## to run the crud on table "appointments" the following paths are used
#### method GET
- /api/controller/appointment/listall
- /api/controller/appointment/getone/{id}
- /api/controller/appointment/affiliates/{id} - Return all the appointments of one affiliate
- /api/controller/appointment/group/{DATE} - Return all the affiliates with an appointments in specific date
#### method post
- /api/controller/appointment/add
#### method put
- /api/controller/appointment/update/{id}
#### method delete
- /api/controller/appointment/delete/{id}
      
  ### technologies
      in ubuntu 22.04
      - mysql       version 8.0.31
      - Java        version 17.0.4.1
      - Spring Boot version 2.7.5
    
  Author

* **Daniel Ruiz Linkedin** - [DanielRuiz](https://www.linkedin.com/in/daniel-ruiz)
  
