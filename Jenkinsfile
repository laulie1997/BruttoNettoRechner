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
        }
    }
}
