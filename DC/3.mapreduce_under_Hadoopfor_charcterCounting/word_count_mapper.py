
# 1. mapper.py for Word Count

# (Part B: Counting occurrences of every word)

# #!/usr/bin/env python3

import sys


for line in sys.stdin:
    
    line = line.strip()
    
    words = line.lower().split()
    
    
    for word in words:
        
        print(word, 1)

# Example input:

# Hello Hadoop
# Hello Big Data

# Output:

# hello 1
# hadoop 1
# hello 1
# big 1
# data 1
