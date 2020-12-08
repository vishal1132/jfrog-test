pipeline {
    agent any
    parameters {
        choice(
            name: 'CHOICE',
            choices: ['one', 'two', 'three'],
            description: ''
        )
        booleanParam(name: 'pushArtifact', defaultValue: true, description: 'Should this artifact be pushed to jfrog artifactory?')
    }
    stages {
        stage('PreBuild') {
            steps {
                echo "Choice: ${params.CHOICE}"
                sh "echo Choice: ${params.CHOICE}"
                sh 'echo Choice: $CHOICE'
                echo "string chosen is equal to ${SOME}"
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
                echo 'Now checking if the deploytoartifactory is set to true'
                when {
                    environment name: 'pushArtifact', value: 'true'
                }
                rtUpload (
                    serverId: 'jfrog-testing-docker-server',
                    spec: '''{
                        "files": [
                            {
                                "pattern": "**/*.war",
                                "target": "example-repo-local/"
                            }
                        ]
                    }'''
                )
            }
        }
    }
}

//jfrog-testing-docker-server