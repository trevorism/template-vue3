# gcloud
![Jenkins](https://img.shields.io/jenkins/build/http/trevorism-build.eastus.cloudapp.azure.com/gcloud)
![Jenkins Coverage](https://img.shields.io/jenkins/coverage/jacoco/http/trevorism-build.eastus.cloudapp.azure.com/gcloud)
![GitHub last commit](https://img.shields.io/github/last-commit/trevorism/gcloud)
![GitHub language count](https://img.shields.io/github/languages/count/trevorism/gcloud)
![GitHub top language](https://img.shields.io/github/languages/top/trevorism/gcloud)


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

## Google cloud project setup
* Go to the Gcloud console console.cloud.google.com
* Create a new project
* Configure the subdomain and update DNS
* Create project in github
* Update New-WebApi POSH script to generate a project
* Start jenkins using click.trevorism.com