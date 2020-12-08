pipeline {
    agent any
    parameters {
        choice(
            name: 'CHOICE',
            choices: ['one', 'two', 'three'],
            description: ''
        )
    }
    stages {
        stage('PreBuild') {
            steps {
                echo "Choice: ${params.CHOICE}"
                sh "echo Choice: ${params.CHOICE}"
                sh 'echo Choice: $CHOICE'
            }
        }
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
     }
}