#!/bin/bash
for f in src/*.java 
do 	echo  
	echo --------------------------------------------------
	echo $f
	echo  
	echo javac -sourcepath src/  -d bin/ -cp bin/ $f
	echo  
javac -sourcepath src/  -d bin/ -cp bin/ $f
	echo compiled
done 