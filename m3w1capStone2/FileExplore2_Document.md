FileExplore2.java
---
FileExplore2.java companies files:
* FileMkdir.java
* FileRW.java
* FileBRW.java
* FileIOS.java
* FileBufferIOS.java

### Description
To demonstrate the java class file operation, using java.io Class File. 
Code executed `FileExplore2.java` via console screen. 
Shown display of menu for items selection.

### Design Aspect
#### FileExplore2.java
This is `Main` file, using `switch case` pointing to other object files to execute other operation.  
Run User Interface on console to display the menu.  
using ArrayList for rescusively print the directories.

On terminal to execute:   
`% javac -d build/classes src/file/exp/*.java `  
`% cd build/classes`   
`% java file.exp.FileExplore2 /Users/antw/ntuc/cp2/FileExplore2/TestFolder`   

#### FileMkdir.java
Using java `mkdirs()`, to create new directory on `TestFolder`.
#### FileRW.java
Using java `FileWriter` and `FileReader` to create new file, add text, and read file.
#### FileBRW.java
Using java `BufferedWriter`, `BufferedReader`, `FileWriter` and `FileReader` to create new file, add text, and read file.
#### FileIOS.java
Using java `FileInputStream` and `FileOutputStream` to create new file, add text, and read file.
#### FileBufferIOS.java
Using java `BufferedInputStream`,`BufferedOutputStream`,`FileInputStream` and `FileOutputStream` to create new file, add text, and read file.
### Terminals run and shown:
```
 ********************************************************************************************* 

	 *** Demonstrate of java.io. Class File *** 

	Root Directory for File Operations ::: /Users/antw/ntuc/cp2/FileExplore2/TestFolder
 	                                       ---------------------------------------

 ********************************************************************************************* 
 	Following are the options :: 
 
		0 >> Directory Listing
 
		1 >> Create Directory 
 
		31 >> Create File thru FileWriter & FileReader
 
		32 >> Create File thru BufferedWriter & BufferReader
 
		33 >> Create File thru FileInputStream & FileOutputStream
 
		34 >> Create File thru BufferedInputStream & BufferedOutputStream
 
		99 >> Exit 

 ********************************************************************************************* 
 Enter a numer to carry out the operation  :   0
 ============================================================================================
		 Option Selected : 		Directory Listing
[
  |------ >> test1501.txt, 
  |------ >> .DS_Store, 
  |------ >> Level1, 
  |--------- >> .DS_Store, 
  |--------- >> Level2, 
  |------------ >> Sammple.txt]
 ============================================================================================
 Press any key to continue.....
```
### Issues yet to resolve
- Directories list has been added with previous operation.
### Scope for improvement
- To Create Directory tree,
- To Change Directory,
- To Display File,
- To Copy File,
- To Rename File,
- To Delete File,
- To Delete Folder or Folders.

