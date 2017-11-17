#!/bin/bash
clear
echo "Compiling ..."
sudo javac -d bin -sourcepath src -cp lib/mysql-connector.jar src/main/Main.java
clear
echo "Supermarket Management System"
echo "Author Minh"
echo "Version 1.0"
echo ""
echo "App running ..."
sudo java -cp bin:lib/mysql-connector.jar main.Main
clear
echo "bye"
