
# 2. mapper.py for Character Count

# (Part A: Character counting in text file)

# When examiner asks character count, just replace mapper.py with this:

# #!/usr/bin/env python3

import sys


for line in sys.stdin:
    
    line = line.strip().lower()
    
    
    for ch in line:
        
        if ch != " ":
            
            print(ch, 1)