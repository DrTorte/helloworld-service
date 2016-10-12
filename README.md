### This project is currently being migrated to AWS.

### Please proceed with the following steps to start using it in its new location.
1. Access the link below in a new tab or page.

	(http://10.61.0.24/bitbucket/projects/HEL/repos/hello/browse)

2. Click on "Fork" at the left-hand corner of the page then follow its instructions to fork the AWS repository.
3. Click on the "Clone" link at the left-hand corner of your AWS fork's page then copy the exposed address.
4. Make your local repo URL point to AWS.

	```
	cd /path/to/my/local/copy
	git config --get remote.origin.url
	git remote set-url origin <address_from_step_3>
	git config --get remote.origin.url
	git checkout ci
	git branch
	```

5. Merge your local copy with the repo's one.

	```
	git pull
	```

6. Commit then push your local changes.

	```
	git add --all
	git status
	git commit -m "My comments go here..."
	git push
	```

7. At this point, you should be able to use your repository normally on AWS the same way you've been using on skydev03.
