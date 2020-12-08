pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'make build'
            }
        }
        stage('AfterBuild') {
            when {
              expression {
                currentBuild.result == null || currentBuild.result == 'SUCCESS' 
              }
            }
            steps {
                echo 'Build Successful'
            }
        }
        // stage('AfterAfterBuild') {
        //     failure {
        //         mail to: 'vishal.sharma@blackngreen.com', subject: 'The Pipeline failed :(', body: 'The pipeline build got failed'
        //     }
        // }
     }
}