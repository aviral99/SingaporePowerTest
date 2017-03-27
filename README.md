# SingaporePowerTest
This project is the pre-interview test for Singapore Power i-Grad programme. 

To run the program simply run KeypadInterface.java in any IDE or Command Line. Make sure you have WordsRTF.RTF diciotnaty file in the same folder as the program.
Choose the different operations and have fun testing the program.

To test the KeypadTests.java in Eclipse -Download JUnit and Hamcrest libraries. Found at junit.jar and hamcrest-core.jar files from https://github.com/junit-team/junit4/wiki/Download-and-Install .
After downloading, go to Eclipse>Right Click Project Folder>Build Path>Configure Build Path>Libraries>Add External Jars and select dowloaded jars. You can now test KeypadTests.java in eclipse and see the results. 

# Highlights:
Program uses String representation for keypad sequences. This allows the user to use the program for keypad sequences which occur in a number greater than "2,147,483,647". Program uses efficient data structures like hashmap and trees for fast computation. Program checks user input for any incorrect data and returns "-1"

# Some thoughts:
I have used a treemap from java to store the dictionary words. This can achieve search a word in dictionary in O(log n) time. We can also use hashtable to store the words and search in O(1) time but it shall take more program memory.
