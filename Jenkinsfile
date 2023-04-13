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
                C:
                cd %RepositorioSelenium%
                mvn clean test
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