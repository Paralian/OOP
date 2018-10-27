# hilfreiche Kommandozeiles
@quick_notes.md  
Videos:  
http://www.youtube.com/watch?v=SWYqp7iY_Tc  
http://www.youtube.com/watch?v=E8TXME3bzNs

# to-do:  
bitte in jede Woche Ordner auch ein README.md hinfügen für Zustand jedes Blatt und darauf nach Fortschritten schreiben
Beispiel:
`* todo example`
-   todo example
# Repo in IntelliJ öffnen
![](https://github.com/Paralian/OOP/blob/master/images/1.png?raw=true)
![alt text](https://github.com/Paralian/OOP/blob/master/images/2.png?raw=true)

Oder wenn du von GIT Bash schon geclone hast, kannst du mit `File - New - Project from Existing Sources` wie unten gezeigt:  
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
git merge test
git push origin master
```
