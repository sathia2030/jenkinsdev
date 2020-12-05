pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building Started'
                withMaven(maven: 'Maven3.6.3'){
                	bat 'mvn clean package'
                }
                 echo 'Building Completed'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing Started'
                bat 'mvn test'
                echo 'Testing Completed'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying'
            }
        }
    }
}