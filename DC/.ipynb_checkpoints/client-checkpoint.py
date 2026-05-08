# ------------------------------------------
# RPC CLIENT
# ------------------------------------------

import xmlrpc.client


# Connect to server
server = xmlrpc.client.ServerProxy(
    "http://localhost:8000"
)


# User input
number = int(
    input("Enter an integer: ")
)


# Remote procedure call
result = server.factorial(number)


# Display result
print("Factorial =", result)