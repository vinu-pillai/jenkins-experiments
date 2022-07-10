pipeline {
    agent any
    environment {
        RELEASE='22.01'
    }
    stages {
        stage('Build') {
            agent any
            environment {
                LOG_LEVEL='INFO'
            }
            steps{
                echo "Building release ${RELEASE} with log level ${LOG_LEVEL}..."
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
                echo "Deploying release #${RELEASE} to environment ${TARGET_ENVIRONMENT}"
            }
        }
    }
    post {
        always {
            echo "Print it! whether deployment is SUCCESS or FAILURE, just print it!"
        }
    }
}