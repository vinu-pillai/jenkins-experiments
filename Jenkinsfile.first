pipeline {
    agent any
    
    environment { 
        Demo = 'first'
    }

    stages {
        stage('Display Build ID') {
            steps {
                echo "This is build number $BUILD_NUMBER of $DEMO demo, oye lenee hai!?"
                echo "This is build id $BUILD_ID of $DEMO demo, oye lenee hai!?"
                echo "This is build tag $BUILD_TAG of $DEMO demo, oye lenee hai!?"
                echo "This is build url $BUILD_URL of $DEMO demo, oye lenee hai!?"
                echo "This is executor numbner $EXECUTOR_NUMBER of $DEMO demo, oye lenee hai!?"
                echo "This is java home $JAVA_HOME of $DEMO demo, oye lenee hai!?"
                echo "This is jenkins url $JENKINS_URL of $DEMO demo, oye lenee hai!?"
                echo "This is job name $JOB_NAME of $DEMO demo, oye lenee hai!?"
                echo "This is node name $NODE_NAME of $DEMO demo, oye lenee hai!?"
                echo "This is workspace $WORKSPACE of $DEMO demo, oye lenee hai!?"
                echo "Oye bhai kitneee lega ab.!!??"
            }
        }
    }
}
