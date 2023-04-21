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
                archiveArtifacts allowEmptyArchive: true, artifacts: '*.png', fingerprint: true, followSymlinks: false, onlyIfSuccessful: true
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}