#!/bin/bash
for f in src/*.java 
do	echo javac -d bin/ -cp bin/  $f
done  