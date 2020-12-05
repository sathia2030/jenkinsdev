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
                	sh 'mvn clean package'
                }
                 echo 'Building Completed'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing Started'
                sh 'mvn test'
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