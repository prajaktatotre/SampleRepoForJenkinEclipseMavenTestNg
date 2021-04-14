pipeline {
    agent any

    tools {
        maven "MAVEN_3.8.1" // You need to add a maven with name "3.8.1" in the Global Tools Configuration page
    }

    stages {
        stage("Build") {
            steps {
                sh "mvn -version"
                sh "mvn clean install"
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}