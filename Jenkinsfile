pipeline {
    agent any

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-21-openjdk-amd64'
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
        SONARQUBE_SERVER = 'SonarQube' // Name configured in Jenkins > Manage Jenkins > Global Tool Config
        PROJECT_KEY = 'evolve-tech'
        SONAR_ORG = 'evolve'
    }

    tools {
        maven 'maven-latest'  // Name from Jenkins tool config (update if you used a different name)
    }

    stages {

        stage('Checkout') {
            steps {
                git url: '', branch: 'main'
            }
        }

        stage('Java & Maven Versions') {
            steps {
                sh 'java -version'
                sh 'mvn -version'
            }
        }

        stage('Code Quality - SonarQube Scan') {
            steps {
                withSonarQubeEnv("${SONARQUBE_SERVER}") {
                    sh """
                        mvn clean verify sonar:sonar \
                          -Dsonar.projectKey=${PROJECT_KEY} \
                          -Dsonar.organization=${SONAR_ORG} \
                          -Dsonar.host.url=$SONAR_HOST_URL \
                          -Dsonar.login=$SONAR_AUTH_TOKEN
                    """
                }
            }
        }

        stage('Build Jar') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
    }

    post {
        success {
            echo '✅ Build and SonarQube analysis completed successfully.'
        }
        failure {
            echo '❌ Build failed. Please check logs.'
        }
    }
}
