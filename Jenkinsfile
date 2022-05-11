pipeline {
    agent any
    triggers {
        cron('@hourly')
        pollSCM('* * * * *')
    }
    options {
        buildDiscarder(logRotator(daysToKeepStr: '30'))
        disableConcurrentBuilds()
    }
    tools {
        maven '3.8.5'
        jdk '1.8.0'
    }
    stages {
        stage ('Checkout') {
            steps {
                git url: 'https://github.com/srikanthkoshika123/QA_Automation.git', branch: "master"
            }
        }
        stage('Run integration tests') {
            steps {
                sh "mvn clean test"
            }
        }
    }
    post {
        always {
            archiveArtifacts "target/**/*"
            junit "target/**/surefire-reports/*.xml,target/**/failsafe-reports/*.xml"
        }
    }
}
