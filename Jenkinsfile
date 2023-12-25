pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Gradle Build
                    bat 'gradle clean build'
                }
            }
           post {
               success {
                   // Archive the JAR file as a build artifact
                   archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
               }
           }
    }
}
