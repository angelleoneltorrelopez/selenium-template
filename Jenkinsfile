pipeline {
    agent any

    tools {
        nodejs 'node'
        maven 'maven'
        jdk 'jdk'
    }

    stages {
        stage('Install') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                bat '''
                mvn clean install
                '''
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}