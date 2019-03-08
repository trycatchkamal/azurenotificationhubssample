# azurenotificationhubssample
sample for https://github.com/trycatchkamal/azure-notificationhubs-java-backend

Demostrates how to use azure-notificationhub-java-backend in a server api built using spring framework. 
Application assumes that azure notification hub infrastructure is used to push notifications to different platforms

## Running locally
Before we can run the application, few configuration properties has to be set in [properties](/src/main/resources/application.properties)

Run the application and access `http://localhost:8080/api/droid` or `http://localhost:8080/api/apple`

Refresh the endpoint to push the notifications!
