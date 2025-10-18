pipeline {
    agent any

    environment {
        // Add Maven to PATH so Jenkins can find it
        PATH = "/Users/harshrajsingh/apache-maven-3.9.11/bin:${env.PATH}"
    }

    stages {
        stage('Env Check') {
            steps {
                echo "Checking environment..."
                sh 'echo $PATH'
                sh 'which mvn'
                sh 'java -version'
            }
        }

        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/rajharsh1433/AutomationSelf.git'
            }
        }

        stage('Build & Test') {
            steps {
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
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
