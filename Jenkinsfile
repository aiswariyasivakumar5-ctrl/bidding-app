pipeline {
    agent any

    environment {
        IMAGE_NAME = "bidding-app"
    }

    stages {

        stage('Clone') {
            steps {
                git 'https://github.com/your-username/bidding-app.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t %IMAGE_NAME% .'
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                bat 'kubectl apply -f k8s-deployment.yaml'
                bat 'kubectl apply -f k8s-service.yaml'
            }
        }
    }
}