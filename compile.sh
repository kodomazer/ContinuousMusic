#!/bin/bash
for f in src/*.java 
do 	echo  
	echo --------------------------------------------------
	echo javac -d bin/ -cp bin/  $f
done  