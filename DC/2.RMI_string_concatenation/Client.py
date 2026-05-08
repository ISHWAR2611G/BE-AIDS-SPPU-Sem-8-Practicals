import xmlrpc.client


# Connect to server
server = xmlrpc.client.ServerProxy("http://localhost:8000")


# User input
str1 = input("Enter first string: ")
str2 = input("Enter second string: ")


# Remote method call
result = server.concatenate(str1, str2)


# Display result
print("Concatenated String:", result)