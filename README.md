collegeBoard-assignment
=======================

collegeBoard-assignment

Author : Malaya Pant
Email  : malayapant@gmail.com
==============================
This is java application that uses binary search algorithm to correctly guess a user
selected integer number between 1 - 100.
**************************************
Prerquisites: Required are following 
*************************************

1.Java java sdk 1.5/jre 1.5 or higher
 
2.ant lib junit4.1.jar [ placed in lib folder]

3.All files in files under src folder

4.All files under tests folder.  

5.Apache Ant(TM) version 1.9.4 or any other compatible one. 

6.build.xml in root path.


********************************************************
          Running the application
********************************************************

1.To build/compile and Run applcation execute following command from the location where build.xml is put
==========================================================================================================

ant runme
============================================================================================================

This above command will build and run the jar files


2.To run jUnit test execute following command from the location where build.xml is put.

==========================================================================================================
ant junit	  
==========================================================================================================

This command will run jUnit test and will generate an XML test report file at location testreport/TEST-CorrectNumberCheckerTest


3.To run jar file as standalone outside of ant ,execute following command

==========================================================================================================
java -jar /numjar/numgame.jar

==========================================================================================================
