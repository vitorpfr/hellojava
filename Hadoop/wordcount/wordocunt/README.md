This is a Hadoop example running WordCount, a class that count the words in documents.
https://hadoop.apache.org/docs/r1.2.1/mapred_tutorial.html#Example%3a+WordCount+v2.0

## Install and configure Hadoop
https://techblost.com/how-to-install-hadoop-on-mac-with-homebrew/

## Start/stop Hadoop
(Make sure $HADOOP_HOME is set to the right path, in my case /usr/local/Cellar/hadoop/3.3.3)
- Start
$HADOOP_HOME/sbin/start-all.sh

- Check current JVM processes running
jps

- Stop
$HADOOP_HOME/sbin/stop-all.sh

How to Access Hadoop web interfaces (Hadoop Health)
NameNode                  : http://localhost:9870
NodeManager               : http://localhost:8042
Resource Manager (Yarn)   : http://localhost:8088/cluster

## Example Hadoop commands
hadoop fs -mkdir -p /sales/data
hadoop fs -put /Users/raghunathan.bakkianathan/Work/testData.csv /sales/data
hadoop fs -ls /sales/data

## Run a simple example
(if necessary to cleanup the output from a previous run)
hdfs dfs -rm -r /wordcount/output/

Build jar and move to a folder (also move the input files there)
./gradlew build

- If directories do not exist in hdfs:
hdfs dfs -mkdir /wordcount/
hdfs dfs -mkdir /wordcount/input/

- Navigate to files directory
hdfs dfs -put file01 /wordcount/input/
hdfs dfs -put file02 /wordcount/input/

- Check that files are there 
hdfs dfs -ls /wordcount/
hdfs dfs -cat /wordcount/input/file01
hdfs dfs -cat /wordcount/input/file02

- Run the application (hadoop jar jarlocalpath classname inputfileonhdfs outputfileonhdfs):
hadoop jar wordcount-1.0-SNAPSHOT.jar WordCount /wordcount/input /wordcount/output

(/input folder contais all the input files that will be processed)
(time taken to run in a single node: 28 sec)

- Check output
hdfs dfs -ls /wordcount/output
hdfs dfs -cat /wordcount/output/part-00000

## Run a more complex example (Amazon Reviews for Sentiment Analysis)
https://www.kaggle.com/datasets/bittlingmayer/amazonreviews?resource=download
hdfs dfs -mkdir /wordcount/amazon/
hdfs dfs -mkdir /wordcount/amazon/input/
hdfs dfs -put amazon/test.ft.txt /wordcount/amazon/input
hdfs dfs -put amazon/train.ft.txt /wordcount/amazon/input
hdfs dfs -ls /wordcount/amazon/input/
hadoop jar wordcount-1.0-SNAPSHOT.jar WordCount /wordcount/amazon/input /wordcount/amazon/output

(time taken to run in a single node: 4 min 36 sec)  

hdfs dfs -ls /wordcount/amazon/output
hdfs dfs -cat /wordcount/amazon/output/part-00000