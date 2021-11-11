public class NetworkingMain {
    // Main networking concepts:
    // Host: Equivalent to a machine
    // Client/server: communication model where two applications communicate through a network
    // Comms protocol: TCP, UDP, etc
    // IP: internet protocol: way to identify a host over a network of hosts interconnected
    // Most of the internet use the TCP/IP protocol, but you can use TCP/IP in an intranet as well
    // Port: multiple different applications in the same host need to communicate with other apps (either as client or servers),
    //       so each is designed a port, so when data comes through network, it knows where to redirect it
    // Socket: An endpoint in a two-way communication. There is the client socket and the server socket.
    //         Multiple clients connect to a server using the same ip/port, but each has its own socket

    // When the client and server are on the same host, usually the ip address 127.0.0.1, which is referred as localhost,
    // is used to identify the host

    // Steps in a client/server TCP communication (two-way connection, with tight coupling):
    // 1. Client opens a connection to server
    // 2. Client send requests to server
    // 3. Server sends a response to client
    // 4. Client closes the connection with server
    // Steps 2 and 3 usually may be repeated indefinitely while client and server are communicating

    // Steps in a UDP communication (one-way connection, client does not receive response, message may be lost, speed is prioritized)

    // java.net package is the package used to handle networking communications in java
    // it has a low-level api (where you as a developer need to handle sockets, etc) and a high-level api (where much of the internal stuff is handled)
        // classes used in the low-level api: Socker, ServerSocket, DatagramSocket
        // classes used in the high-level api: URI, URL, HttpURLConnection


    // in the high-level api, you just need to use uri and url
    // uri: universal resource identifier - might not provide enough information to access the resource it identifies
        // usually a relative path
    // url: universal resource locator - includes information about how to access the resource it identifies
        // needs to be an absolute path

    // recommended practice on java.net classes: use uri until you want to actually access a resource, and then convert it to a url

    // example: http://www.google.com.br/
    // http is the 'scheme, (other examples: http, file, ftp)
    // this is a 'url', or a 'http uri'
}
