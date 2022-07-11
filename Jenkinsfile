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
                echo "${JENKINS_HOME}"
            }
        }
        stage('Build') {
            steps {
                echo "Building version: ${VERSION} with suffix: ${VERSION_RC}"
                sh 'dotnet build -p:VersionPrefix="${VERSION}" --version-suffix "${VERSION_RC}" ./src/Pi.Web/Pi.Web.csproj'
            }
        }
        stage('Unit Test') {
            steps {
                dir('./src') {
                    sh '''
                    dotnet test --logger "trx;LogFileName=Pi.Math.trx" Pi.Math.Tests/Pi.Math.Tests.csproj
                    dotnet test --logger "trx;LogFileName=Pi.Runtime.trx" Pi.Runtime.Tests/Pi.Runtime.Tests.csproj
                    '''
                    //mstest testResultsFile:"**/*.trx", keepLongStdio: true
                }
            }
        }
        stage('Smoke Test'){
            steps {
                //sh 'dotnet src/Pi.Web/bin/debug/netcoreapp3.1/Pi.Web.dll'
                sh 'dotnet /data/workspace/initial-pipeline/src/Pi.Web/bin/Debug/netcoreapp3.1/Pi.Web.dll'
            }
        }
    }


}