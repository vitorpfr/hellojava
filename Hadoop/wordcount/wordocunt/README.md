https://hadoop.apache.org/docs/r1.2.1/mapred_tutorial.html#Example%3a+WordCount+v2.0

### Instructions to run
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

- Check output
hdfs dfs -ls /wordcount/output
hdfs dfs -cat /wordcount/output/part-00000