pipeline {
    agent any

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-21-openjdk-amd64'
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
        SONARQUBE_SERVER = 'SonarQubeServer'   // Jenkins SonarQube name
        PROJECT_KEY = 'evolve-tech'
        SONAR_ORG = 'evolve'
    }

    tools {
        maven 'Maven3' // Change to your actual Maven tool name in Jenkins
    }

    stages {

        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/umamahesh571/evolve-tech-b4.git', branch: 'main'
            }
        }

        stage('Verify Java & Maven') {
            steps {
                sh 'java -version'
                sh 'mvn -version'
            }
        }

        stage('Build Application') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('SonarQube Scan') {
            steps {
                withSonarQubeEnv("${SONARQUBE_SERVER}") {
                    sh """
                        mvn sonar:sonar \
                          -Dsonar.projectKey=${PROJECT_KEY} \
                          -Dsonar.organization=${SONAR_ORG} \
                          -Dsonar.host.url=$SONAR_HOST_URL \
                          -Dsonar.login=$SONAR_AUTH_TOKEN
                    """
                }
            }
        }
    }

    post {
        success {
            echo '✅ Build and SonarQube scan completed successfully.'
        }
        failure {
            echo '❌ Pipeline failed. Please check errors.'
        }
    }
}
