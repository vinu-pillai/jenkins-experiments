def call() {
    pipeline {
        agent any
        environment {
            MODULE='m1'
        }
        stages {
            stage('Verify') {
                steps {
                    echo "Module: ${MODULE}"
                    sh 'git version'
                }
            }
        }
    }
}