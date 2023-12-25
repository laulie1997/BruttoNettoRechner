pipeline {
    agent any


    stages {
        stage('Checkout') {
            steps {
                // Checkout the source code from your version control system
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Use the Gradle Wrapper to build the project
                bat "gradlew clean build"
            }
        }
    }

    post {
        success {
            // Archive the JAR file as a build artifact
            archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
        }
    }
}
