# Jenkins Closing Task
In this task we have 2 sections:
-  Create a Java Application (Managed by Gradle).
-  Create a Jenkins CI/CD pipeline Job to Build and Deploy (Run) the application on a new instance.


## ✨Java Application- Features:
1-  Reads the “Breaking News” from YNet new service:
http://www.ynet.co.il/Integration/StoryRss2.xml.

2-  When connecting to the Web App, the App parses and Presents the Breaking.
News XML in an HTML Table Format.

>This Java Application in a Spring boot web app managed with gradle,
containing 3 classes:
--Run:Main class.
--Controller:Contains the method that is responsible for storing the HTML string ant connecting it to the viewed HTML page.
--FeedHandler:Responsible for reading the feeds from the given URL and converting it to an HTML format.

## Run the app
Build a jar file and run it from the command line:

```sh
git clone https://github.com/SewarDarawshe/JenkinsClosingTask.git
cd gradleRSSproject
./gradlew  build
java -jar ./build/libs/gradleRSSproject-1.0-SNAPSHOT.jar
```
now you can access the app using : http://localhost:1999/  .

![Screenshot](https://github.com/SewarDrawhe/JenkinsClosingTask/blob/master/RSS.PNG)



## ✨Jenkins CI/CD pipeline Job:
 This pipeline clones the project ,builds and runs it, and sends a slack notification.



Now simply connect the pipeline to the github repository and import the Jenkinsfile . 
you should see in the stage view that the pipeline passed the stages :

![Screenshot](https://github.com/SewarDrawhe/JenkinsClosingTask/blob/master/jenkinsStageview.PNG)


> This pipeline sends a slack notification,if you're intrested in sending one into your own slack channel, you have to setup the slack plugin pefore you run the jenkins file,
use this link for more detailes :https://kunzleigh.com/creating-a-slack-notifier-using-jenkins-pipeline/

![Screenshot](https://github.com/SewarDrawhe/JenkinsClosingTask/blob/master/slackNoti.PNG)


