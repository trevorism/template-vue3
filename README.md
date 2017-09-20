# gcloud
Template for google app engine services

##Prerequisites
* Java 8
* Gradle
* Gcloud SDK

#Steps for creating a new GAE service

* Identify the name of the gae project `$PROJECT` 
* Identify the name of the service `$SERVICE`
* Check out this project
* Replace gcloud-project with `$SERVICE` in
    * RootController.groovy
    * appengine-web.xml
    * settings.gradle
* Update appengine-web.xml `<application>$PROJECT</application>`
* Update this README.md


The prior steps are encoded in a powershell script

`New-WebApi -projectName $PROJECT -serviceName $SERVICE`

## Google app engine setup
Download the GCloud SDK

How to create in gcloud:
* gcloud projects create trevorism-eventhub
* gcloud config set project trevorism-eventhub
* gcloud app create
* gradle clean build appengineDeploy

In the portal
* Set up a service account through API Manager