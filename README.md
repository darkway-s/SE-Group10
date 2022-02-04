# SE-Group10 Decide
This project is using the java maven build tool to have a neat way of structuring everything and automate testing. 

## Strucute and implementation
All classes are implemented in [/src/test/java/com/group/decide](/src/test/java/com/group/decide). 
A full class diagram can be found [here](https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1&title=decide.drawio.svg#Uhttps%3A%2F%2Fdrive.google.com%2Fuc%3Fid%3D1KWa893xuObUJYNH05qSMQeP5j4YMa4E8%26export%3Ddownload).

The parameters for the CMV are implemented as methods in the ConditionsMetVector class.



### Continuous integration
GitHub Actions are integrated to automatically build and test our code when a PR is created. This is a good way to avoid any faulty code being merged with the main branch. 

Our implementation of the CI is based on GitHubs maven template and can be found in the [.github/workflows](.github/workflows) folder.

### Git workflow
Some standards are set to make everything clear.  
Branch-naming: issue/nr

## How to run
```
$ mvn compile
$ mvn exec:java -D"exec.mainClass"="com.group10.decide.LaunchInterceptorProgram"
```

## How to run tests
This maven project is comes with a test suit that can be tested with the following command:
```
$ mvn test
```
All unit tests in the suite are located in the [/src/test/java/com/group/decide](/src/test/java/com/group/decide) and each java class has their own test class. 

## Statement of contribution
We decided that the LIC requirements was a good way to split the work between us. Therefore, we assigned 3 requirements each with approximate the same level of difficulty. 

On top of that, we also needed some other part for the program to work well which are listed bellow. 
| Name | Tasks |
| --- | --- |
| Amanda |  |
| Chiyi | |
| Ludwig | |
| Sebastian | |
| Şefik | |

## Essence
We have had a discussion of our state of work. The conclusion of our discussion can be found [here.](https://docs.google.com/document/d/1F2XvOlAA5KcxmcbASf5P0KabFuRd7MKCWuzxflHKIb8/edit)
