#!/bin/bash

echo "creating a release branch from the X commit...\n"
git checkout -b release-ca5ea5bf552a98148ff367613aedcc4101c9eb21 ca5ea5bf552a98148ff367613aedcc4101c9eb21

echo "accessing the new branch...\n"
git push --set-upstream origin release-ca5ea5bf552a98148ff367613aedcc4101c9eb21

echo "creating the release using the new branch...\n"
mvn -B -Darguments=-DbambooBuildNumber=00 -DbranchName="release-ca5ea5bf552a98148ff367613aedcc4101c9eb21" release:clean release:prepare release:perform -Pprofile-master

if ($? -eq 0) do;
	echo "release successful. cleaning up the release branch...\n"
	git checkout ci
	git branch -d release-ca5ea5bf552a98148ff367613aedcc4101c9eb21
	git push --set-upstream origin ci
	git push origin --delete release-ca5ea5bf552a98148ff367613aedcc4101c9eb21
fi

