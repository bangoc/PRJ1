#!/bin/bash
clear
echo "compiling ..."
sudo javac -d bin -sourcepath src -cp lib/mysql-connector.jar src/main/Main.java
clear
echo "app running ..."
sudo java -cp bin:lib/mysql-connector.jar main.Main
clear
echo "bye"
