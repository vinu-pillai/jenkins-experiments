pipeline {
    agent any
    
    environment { 
        Demo = 'first'
    }

    stages {
        stage('Display Build ID') {
            steps {
                echo "This is build number $BUILD_NUMBER of $DEMO demo, oye lenee hai!?"
            }
        }
    }
}
