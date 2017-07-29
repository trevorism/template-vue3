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