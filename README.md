# KaiburrTask1
Task 1. Java REST API example.<br>
Implement an application in java which provides a REST API with endpoints for searching,
creating and deleting “server” objects:<br>
● GET servers. Should return all the servers if no parameters are passed. When server id
is passed as a parameter - return a single server or 404 if there’s no such a server.<br>
● PUT a server. The server object is passed as a json-encoded message body. Here’s an
example:<br>
{<br>
“name”: ”my centos”,<br>
“id”: “123”,<br>
“language”:”java”,<br>
“framework”:”django”<br>
}<br>
● DELETE a server. The parameter is a server ID.<br>
● GET (find) servers by name. The parameter is a string. Must check if a server name
contains this string and return one or more servers found. Return 404 if nothing is found.
“Server” objects should be stored in MongoDB database.<br>
Be sure that you can show how your application responds to requests using postman, curl or
any other HTTP client.<br>
