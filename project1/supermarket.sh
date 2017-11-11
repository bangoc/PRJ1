#!/bin/bash
clear
sudo javac -d bin -sourcepath src -cp lib/mysql-connector.jar src/main/Main.java
echo "app running ..."
sudo java -cp bin:lib/mysql-connector.jar main.Main
echo "build finish"
