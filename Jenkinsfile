pipeline {
    agent any
    environment {
        VERSION = "0.1.0"
        VERSION_RC = "rc.1"
    }
    stages {
        stage('Audit tools') {
            steps {
                sh '''
                git version
                docker version
                dotnet --list-sdks
                dotnet --list-runtimes
                '''
            }
        }
    }


}