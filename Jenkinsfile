pipeline {
   parameters {
      booleanParam(defaultValue: false, description: 'Clean workspace?', name: 'cleanWorkspace')
      booleanParam(defaultValue: false, description: 'Whether or not to output a watsonSwing.jar artifact', name: 'buildWatsonSwingJar')
      booleanParam(defaultValue: false, description: 'Whether or not to output an rms-db-tool.jar artifact', name: 'buildImportExportDBFatJar')
      booleanParam(defaultValue: true, description: 'Whether to run unit tests', name: 'runUnitTests')
      booleanParam(defaultValue: false, description: 'Whether to run integration tests', name: 'runIntegrationTests')
      booleanParam(defaultValue: false, description: 'Whether to run sonar', name: 'runSonar')
      string(defaultValue: 'master', description: 'Which node to run builds on', name: 'buildNodeLabel')
   }
   agent {
      node {
         label params.buildNodeLabel
      }
   }
   options {
      buildDiscarder(logRotator(numToKeepStr: '5'))
      disableConcurrentBuilds()
      timestamps()
      skipDefaultCheckout(params.cleanWorkspace)
   }
   triggers {
      pollSCM('H/2 * * * *')
   }
   environment {
      GRADLE_OPTS = getGradleOpts(params)
   }
   stages {
      stage('Clean Workspace') {
            when {
               environment name: 'cleanWorkspace', value: "true"
            }
            steps {
               cleanWs()
               checkout scm
            }
      }
      stage('Build') {
         steps {
            gradlew('clean', 'install', '-x', 'test', '-Pgradle.cache.push=true')
         }
      }
      stage('Archive Artifacts') {
         when {
            expression { !params.runIntegrationTests || !params.runSonar }
         }
         steps {
            archiveArtifacts getArtifacts(params)
         }
      }
      stage('Unit Tests') {
         when {
            expression { params.runUnitTests }
         }
         steps {
            gradlew('test')
         }
         post {
            always {
               junit testResults: '**/build/test-results/**/*.xml', healthScaleFactor: 1.0
            }
         }
      }
      stage('Integration Tests') {
         when {
            expression { params.runIntegrationTests }
         }
         steps {
            gradlew('integrationTest')
         }
         post {
            always {
               junit testResults: '**/build/test-results/**/*.xml', healthScaleFactor: 1.0
            }
         }
      }
      stage('Sonar Analysis') {
         when {
            expression { params.runSonar }
         }
         steps {
            gradlew('sonarqube')
         }
      }
   }
   post {
      success {
         tagBuild(params)
      }
      fixed {
         sendEmail()
      }
      failure {
         sendEmail()
      }
   }
}
def getArtifacts(params) {
   def artifacts = 'application-web/build/libs/unifocus-rms.war, interfaces/legacy/build/libs/rms-interfaces.jar'
   if (params.buildWatsonSwingJar) {
      artifacts += ', watson-swing/build/libs/watsonSwing.jar'
   }
   if (params.buildImportExportDBFatJar) {
      artifacts += ', import-export-db/build/libs/rms-db-tool.jar'
   }
   echo "Artifacts = ${artifacts}"
   return artifacts
}
def getGradleOpts(params) {
   def gradleOpts = "-Xms2048m -Xmx12288m -Xss512m -XX:+UseG1GC -XX:+UseStringDeduplication -DjacocoDisabled=true -Dorg.gradle.daemon=false -Dorg.gradle.caching=true"
   if (params.buildWatsonSwingJar) {
      gradleOpts += " -DbuildWatsonSwingJar"
   }
   if (params.buildImportExportDBFatJar) {
      gradleOpts += " -DbuildImportExportDBFatJar"
   }
   return gradleOpts.trim()
}
def tagBuild(params) {
   if (params.enableBuildTagging) {
      sshagent(credentials: ['93205061-ab67-4e9c-b3f3-b97b3c0d5720']) {
         sh "git tag -a -f -m jenkins-${env.JOB_NAME}-build-${env.BUILD_NUMBER} ${env.JOB_NAME}-build-${env.BUILD_NUMBER}"
         sh 'git push origin --tags'
      }
   }
}
def sendEmail() {
   emailext(
      to: 'build-watchers@unifocus.com',
      subject: '$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS!',
      body: '''$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS:
Check console output at $BUILD_URL to view the results.''',
      replyTo: 'jenkins@unifocus.com',
      mimeType: 'text/html',
      attachLog: true,
      recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']])
}
def gradlew(String... args) {
   sh 'chmod +x ./gradlew'
   sh "./gradlew --no-watch-fs --no-daemon --build-cache --stacktrace -Pgradle.cache.push=true ${args.join(' ')}"
}