pipeline {
    agent any

    tools {
        maven 'Maven_3.9.6'
        jdk 'Java_17'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Ejecutar Pruebas') {
            steps {
                // Ejecutamos exactamente el comando que te funcionó en la terminal
                bat "mvn clean test -Dheadless=true"
            }
        }
    }

    post {
        always {
            script {
                // Generamos el reporte de Allure automáticamente
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }
}