### This project is currently being migrated to AWS.

### Please proceed with the following steps to start using it in its new location.
1. Open [this link](http://10.61.0.24/bitbucket/projects/HEL/repos/hello/browse "New AWS URL") in a new tab or page.
2. Login to the AWS Bitbucket.
3. Click on "Fork" at the left-hand corner of the page then click on "Fork repository".
4. Click on the "Clone" link at the left-hand corner of your AWS fork's page then copy the exposed address.
5. Make your local repo URL point to AWS.

	```
	cd /path/to/my/local/copy
	git config --get remote.origin.url
	git remote set-url origin <address_from_step_3>
	git config --get remote.origin.url
	git checkout ci
	git branch
	```

6. Merge your local copy with the repo's one.

	```
	git pull
	```

7. Commit then push your local changes.

	```
	git add --all
	git status
	git commit -m "My comments go here..."
	git push
	```

8. At this point, you should be able to use your repository normally on AWS the same way you've been using on skydev03.
