## Spring Boot and Elastic Search
This project demonstrates usage of Spring Boot and Elastic Search as primary data store.
In this demo, I was trying to experiment and do some benchmarks with inserting "a lot" of data
into Elastic Search and query them in some moment. I'm using single Elastic Search node.

## Getting started
For starting the project you should install Elastic Search on your local computer or 
install it using Docker (I prefer using Docker Images/Containers).

Steps:
1. Open terminal, navigate to project directory and run command: `mvn clean install -DskipTests`
2. Run command: `docker-compose build`
3. Run command: `docker-compose up -d`. This command will start Elasic Search as Docker service
4. Run Spring Boot project

### Benchmarks
1. Counting calls (319991)   
Response time - first request: 630ms  
Response time - other requests: ~12ms

2. Search calls by note start part  
Response time - first request: 186ms  

3. Search calls by note end part  
Response time - first request: 700ms  
Response time - other requests: ~60ms

4. Search calls by customer primary identifier (100 records)  
Response time - first request: 153ms  
Response time - other requests: ~70ms  

4.1. Search calls by customer primary identifier (500 records)  
Response time - first request: 116ms  
Response time - other requests: ~90ms  

4.2. Search calls by customer primary identifier (10 000 records)  
Response time - first request: 221ms  
Response time - other requests: ~200ms

5.1. Search calls by product category name (100 records)  
Response time - first request: 74ms  
Response time - other requests: ~40ms  

5.2. Search calls by product category name (500 records)  
Response time - first request: 79ms  
Response time - other requests: ~65ms  

5.3. Search calls by product category name (10 000 records)  
Response time - first request: 202ms  
Response time - other requests: ~190ms


### Author
Heril Muratović  
Software Engineer  

Mobile: +38269657962  
E-mail: hedzaprog@gmail.com  
Skype: hedza06  
Twitter: hedzakirk  
LinkedIn: https://www.linkedin.com/in/heril-muratovi%C4%87-021097132/  
StackOverflow: https://stackoverflow.com/users/4078505/heril-muratovic  

