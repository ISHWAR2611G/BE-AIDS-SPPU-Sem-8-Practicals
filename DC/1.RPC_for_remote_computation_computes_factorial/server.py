# ------------------------------------------
# RPC SERVER : FACTORIAL CALCULATION
# ------------------------------------------

from xmlrpc.server import SimpleXMLRPCServer


# Function to calculate factorial
def factorial(n):

    if n < 0:
        return "Factorial not possible"

    elif n == 0 or n == 1:
        return 1

    else:
        return n * factorial(n - 1)


# Create XML-RPC Server
server = SimpleXMLRPCServer(
    ("localhost", 8000)
)


# Register remote function
server.register_function(
    factorial,
    "factorial"
)


print("RPC Server started on port 8000...")


# Start server
server.serve_forever()