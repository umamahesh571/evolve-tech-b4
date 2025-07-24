pipeline {
    agent any

    tools {
        maven 'Maven 3'
        jdk 'jdk21'
    }

    environment {
        SONAR_TOKEN = credentials('sonar-token')
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/umamahesh571/evolve-tech.git', branch: 'main'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn sonar:sonar -Dsonar.projectKey=evolve-tech -Dsonar.host.url=http://<SONAR_URL>:9000 -Dsonar.login=$SONAR_TOKEN'
                }
            }
        }
    }
}