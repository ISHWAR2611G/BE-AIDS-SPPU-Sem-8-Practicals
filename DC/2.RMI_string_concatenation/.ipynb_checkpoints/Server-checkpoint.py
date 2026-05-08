from xmlrpc.server import SimpleXMLRPCServer


# Remote function
def concatenate(str1, str2):
    return str1 + str2


# Create server
server = SimpleXMLRPCServer(("localhost", 8000))

# Register function
server.register_function(concatenate, "concatenate")

print("Server is running on port 8000...")

# Start server
server.serve_forever()