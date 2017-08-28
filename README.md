# EvaluationTest
###Keywords:
 ***Spring boot, HTML, AngularJS***
 
## ABout the service

Invoice service is used to Submit an Invoice by a Merchant and saves it in the DB


##Instructions to run locally
1. Download source code from GitHub repository
https://github.com/ashalini24/EvaluationTest.git
2. run the InvoiceApplication.java
3. Inside Postman,

http://localhost:8080/api/invoice

Body:

{           
  "name": "shalini",    
  "email":"testing1@gmail.com",   
  "duedate": null,      
  "invoicetransactionEntityList":
  [  
    {                 
      "description":"invoice1",     
      "amount": "100"          
    }      
  ]  
}


 
