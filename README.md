# formatting Regeln
Videos:  
http://www.youtube.com/watch?v=SWYqp7iY_Tc  
http://www.youtube.com/watch?v=E8TXME3bzNs

**bitte in jede Woche Ordner auch ein README.md hinfügen für Zustand jedes Blatt und darauf nach Fortschritten schreiben**

Beispiel:
  ```
  - aufgabe 1
  - [ ] a
  - [x] b implementieren
  - [ ] c checken
  ```
  - aufgabe 1
  - [ ] a
  - [x] b implementieren
  - [ ] c checken
# Repo in IntelliJ öffnen
![](https://github.com/Paralian/OOP/blob/master/images/1.png?raw=true)
![alt text](https://github.com/Paralian/OOP/blob/master/images/2.png?raw=true)

Oder wenn du von GIT Bash schon geclone hast, kannst du mit `File - Open` wie unten gezeigt:  
![](https://github.com/Paralian/OOP/blob/master/images/3.png?raw=true)

Folder Structure so wie hier aussehen:  
![](https://github.com/Paralian/OOP/blob/master/images/4.png?raw=true)

# branching
  - Zum deinem eigenen branch einrichten:  
`git checkout -b branchname` (`-b` erstellt branchname falls es noch nicht existiert, nach der erste Erstellung kannst du einfach `git checkout branchname` benutzen)
  - Files in deinem Branch verarbeiten
  - Commit stellen wie immer
  - Zum master mergen:
```git checkout master
git pull origin master
git merge branchname OR git merge --no-ff --no-commit branchname
git push origin master
```
# Hilfreiche Commands
Code | Function
------------ | -------------
`cd /drive/folder/of/repo` | Moves HEAD to the folder, alternatively right-click > GIT Bash here
`git touch filename.ext` | creates filename.ext
`git touch .gitignore`|creates ignore list, inside .gitignore write any filename.ext or /path to whitelist the files/directories from `git add`  |  
`git status`|returns status of current commit
`git add .`|
`git commit -m 'comment'`|add files to the staging area then commits the changes with 'comment'.</br>Can be combined into a single command by using </br>`git config --global alias.alias_name '!line1 && line2'`
`git branch newname`|creates a new branch to work on, avoiding changes to the master branch
`git checkout branchname`|switch to branchname
`git checkout -b branch-name`|creates new branch if !exists
`git checkout branchname filename.ext`| pulls filename.ext from branchname
`git remote add origin link.com/user.name/repo.git`|
`git push -u origin branchname`| pushes the branchname branch
`git merge --no-ff --no-commit branchname`| Merge from branchname to HEAD without committing, allowing user to modify the merged files however they want
