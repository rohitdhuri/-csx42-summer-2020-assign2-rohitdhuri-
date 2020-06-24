# CSX42: Assignment 2
## Name: Rohit Mahendra Dhuri

-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on this project.


Note: build.xml is present in [channelpopularity/src](./channelpopularity/src/) folder.

## Instruction to clean:

```commandline
ant -buildfile channelpopularity/src/build.xml clean
```

Description: It cleans up all the .class files that were generated when you
compiled your code.

## Instructions to compile:

```commandline
ant -buildfile channelpopularity/src/build.xml all
```
The above command compiles your code and generates .class files inside the BUILD folder.

## Instructions to run:

```commandline
ant -buildfile channelpopularity/src/build.xml run -Dinput="input.txt" -Doutput="output.txt" -Dmetrics="metrics.txt"
```
Note: Arguments accept the absolute path of the files.


## Description:
1. Assumption
Absolute path of the input file is provided.
All the operations that need to be performed are according to the given input format.
There are no spaces before or after the comma character.
Views, Likes and Dislikes are integers. 
Advertisement length is an integer.

2. Data Structures
Hashmaps have been used for storing video names with their respective details.
Strings have been used as buffers.

3. Code Working
Input file is read and processed one line at a time. After an operation is performed, popularity score is updated and according to that the state is switched. This continues until the last line in input file.


## Academic Honesty statement:

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [06/24/2020]


