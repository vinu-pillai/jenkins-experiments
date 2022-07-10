pipeline {
    agent any
    environment {
        RELEASE='22.01'
    }
    stages {
        stage('Build') {
            //agent any
            environment {
                LOG_LEVEL='INFO'
            }

            parallel {
                stage('linux-x64') {
                    steps {
                        echo "Building release ${RELEASE} for ${STAGE_NAME} with log level ${LOG_LEVEL} on agent $NODE_NAME"
                    }
                }
                stage('windows-x86'){
                    steps {
                        echo "Building release ${RELEASE} for ${STAGE_NAME} with log level ${LOG_LEVEL} on agent $NODE_NAME"
                    }
                }
                stage('ubuntu-x86'){
                    steps {
                        echo "Building release ${RELEASE} for ${STAGE_NAME} with log level ${LOG_LEVEL} on agent $NODE_NAME"
                    }
                }
            }
            
        }
        stage('Test'){
            steps {
                echo "Testing. I can see ${RELEASE}!!"
            }
        }
        stage('Deploy') {
            input {
                message 'Sure you wanna deploy?'
                ok 'Proceed!'
                parameters {
                    string(name: 'TARGET_ENVIRONMENT', defaultValue: 'PROD', description:'Target deplyment infra')
                }
            }
            steps {
                echo "Deploying release #${RELEASE} to environment ${1TARGET_ENVIRONMENT}"
            }
        }
    }
    post {
        // always {
        //     echo "Print it! whether deployment is SUCCESS or FAILURE, just print it!"
        // }
        cleanup {
            echo "Looks clean now!?"
        }
        success {
            echo "I am successfull"
        }
        failure {
            echo "Without failure how will your learn?"
        }
    }
}