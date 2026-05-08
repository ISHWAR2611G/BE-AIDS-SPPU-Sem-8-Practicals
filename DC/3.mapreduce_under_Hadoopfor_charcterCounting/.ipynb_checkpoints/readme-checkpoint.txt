> Design a distributed application using MapReduce under Hadoop for:

### a) Character counting in text file

### b) Word count in text file

---

# Folder Structure

MapReduce_Practical/
│
├── input.txt
├── wordcount_mapper.py
├── charcount_mapper.py
└── reducer.py


# Step 1: Start Hadoop

Open terminal:         ssh localhost

Then:   start-all.sh

# Step 2: Check Hadoop UI

Open browser:      localhost:9870


If UI opens → Hadoop running.


# Step 3: Create Files

gedit input.txt
gedit wordcount_mapper.py
gedit charcount_mapper.py
gedit reducer.py

# Step 4: Verify Files

ls


You should see:
input.txt
wordcount_mapper.py
charcount_mapper.py
reducer.py

Check contents:
cat input.txt
cat wordcount_mapper.py
cat charcount_mapper.py
cat reducer.py


# Part B: Word Count

# Step 5: Local Testing

## Mapper test

cat input.txt | python3 wordcount_mapper.py

## Mapper + Reducer test

cat input.txt | python3 wordcount_mapper.py | sort | python3 reducer.py

If output is correct → code is correct.


# Step 6: Upload file to HDFS

Create folder:   hdfs dfs -mkdir /input

Upload:   hdfs dfs -put input.txt /input

Check:     hdfs dfs -ls /input


# Step 7: Remove old output

hdfs dfs -rm -r /word_output
(ignore first time)


# Step 8: Run Word Count

hadoop jar ~/hadoop-3.3.1/share/hadoop/tools/lib/hadoop-streaming-3.3.1.jar \
-file wordcount_mapper.py -mapper wordcount_mapper.py \
-file reducer.py -reducer reducer.py \
-input /input/input.txt \
-output /word_output


# Step 9: View Output

hdfs dfs -cat /word_output/part-00000

Example:
big 2
data 2
hadoop 2
hello 3
world 1


# Part A: Character Count

# Step 10: Local Testing

## Mapper test
cat input.txt | python3 charcount_mapper.py


## Mapper + Reducer test

cat input.txt | python3 charcount_mapper.py | sort | python3 reducer.py


# Step 11: Remove old output

hdfs dfs -rm -r /char_output
(ignore first time)


# Step 12: Run Character Count

hadoop jar ~/hadoop-3.3.1/share/hadoop/tools/lib/hadoop-streaming-3.3.1.jar \
-file charcount_mapper.py -mapper charcount_mapper.py \
-file reducer.py -reducer reducer.py \
-input /input/input.txt \
-output /char_output



# Step 13: View Output

hdfs dfs -cat /char_output/part-00000


Example:
a 5
b 2
d 3
h 4
o 6


# Exam Viva Flow

Input File
   ↓
Mapper
   ↓
Shuffle + Sort
   ↓
Reducer
   ↓
HDFS Output

