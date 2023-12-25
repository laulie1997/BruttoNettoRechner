pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Gradle Build
                    sh 'gradle clean build'
                }
            }
        }
    }
}
