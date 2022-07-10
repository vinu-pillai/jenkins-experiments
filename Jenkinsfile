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
                echo "Testing. I can see ${RELEASE}, but not leg level ${LOG_LEVEL}"
            }
        }
    }
}