pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/rajharsh1433/AutomationSelf.git'
            }
        }

        stage('Build & Test') {
            steps {
                // Run Maven tests for Selenium
                sh 'mvn clean test'
            }
        }

        stage('Archive Reports') {
            steps {
                // Publish JUnit test reports
                junit 'target/surefire-reports/*.xml'
            }
        }
    }

    post {
        always {
            echo 'Build completed'
        }
    }
}
