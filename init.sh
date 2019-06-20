#!/bin/bash -x

# ------ variables

artifact="helloworld-service-1.4-SNAPSHOT.war"
application="helloworld-service"
baseAppsFolder="/usr/local/apps"
appFolder="$baseAppsFolder/$application"
executable="$JAVA_HOME/bin/java"

echo ""
echo "Starting  $application..."
echo ""

cd $appFolder

echo "executing command: $executable -jar $appFolder/$artifact"
$executable -jar $appFolder/$artifact
