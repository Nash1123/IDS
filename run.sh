#!usr/bin/env bash

# Program:
# Insight Data Science Code Challenge	
# History:
# 2015/07/10	Nash First release
# hsuhang2001@gmail.com

# To install jre in the environment, run the script below (now comment out):
# sudo apt-get install default-jre

# To compile the .java to .class file, run the scripts below (now comment out):
# javac ./src/WordsTweeted.java
# javac ./src/MedianUnique.java

# After installing jre and compiling the .java file. 
# Run the scripts below to read the input file tweets.txt in tweet_input folder.
# And write the output to ft1.txt and ft2.txt in tweet_output folder. 
java -cp ./src WordsTweeted ./tweet_input/tweets.txt ./tweet_output/ft1.txt
java -cp ./src MedianUnique ./tweet_input/tweets.txt ./tweet_output/ft2.txt
