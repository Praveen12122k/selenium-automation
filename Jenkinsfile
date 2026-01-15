pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Praveen12122k/selenium-automation.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean compile'  // or 'sh' if Linux/macOS
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'          // or 'sh' if Linux/macOS
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
    }
}
