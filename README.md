Socket Programming:
    It is a way to enable communication between processes across network.

    It is used to create applications that communicate over a network. 

    for example: web servers, chat servers, web browsers.

Socket : 
    It is an endpoint in a network communication. It is created by OS
    and using it apps can send and receive data.

    It comprises protocol, address, port.

    protocol : 
        The set of rules that a network has to follow to transfer the data.
        
        for example: http for web page or json, smtp for email, ftp for file.
    
    address :
        It is to identify a specific machine in a network.
    
    port:
        A machine can run many apps.
        It is used to identify a specific app in a machine.

TCP/IP stack:
    In a network, data distribution can happen across five different layers.
    Application --> Transport --> network --> Data link --> physical

    Application layer:
        End user apps like swiggy, rapido, uber, zomato.
    Transport layer:
        details of this layer lies in OS. iT uses tcp or udp.
        tcp : reliable, acknowledgement for data received.
        udp : unreliable, fast. 
    network layer:
        It defines the routing in a network.
    data link layer:
        Error detection.
    physical layer:
        wires and towers.

On top of tcp connection we can send http request and response.
Without tcp connection the http request and response cannot work.
on top of tcp other application layer protocol that depends on tcp works.
To establish a tcp connection we need 3 way handshake.

3 way handshake:
    SYN : the client initiates a communication with the server by sending 
            a SYN packet. it has sequence number.
    SYN-ACK : the server sends back an acknowledgement to client that it has received
                the packet. the server sends clients sequence number + 1.
    ACK : the client sends the packet to acknowledge that it has received servers packet.
            it has servers sequence number + 1.

behind the scenes, when we write our own app servers using frameworks,
few steps that will happen.
    1) server creates a new socket object. it is in memory and capable of 
        connecting to an address and bind to a port.
    2) bind this object with address and port. so it can run on a 
        specific port and waits/listens for an incoming client connection.
    3) It listens for the incoming client connection.

After these steps our server socket is ready. then 3 way handshake happens,
client will attempt a connection to server.

once the 3 way handshake is completed, client will be getting its own socket object.

once done these two socket objects starts sending and receiving data 
from both the ends.

Summary:
    To send any HTTP request get any HTTP response we need a TCP connection to set up
    
    how this TCP connection sets up is:
    
        that server keeps itself ready,
        how it creates a new socket object, which contains address and the port, on which address and on which Port it is going to start listening to,
        so it will bind to that address and the port, address can be local host of the machine and it will start listening to incoming requests.
    
    then client has to communicate to This Server to send any HTTP request for this communication,
    TCP connection is required
    
    here we just have a socket object ready in place so what will happen is:
    
        client will initiate the three-way handshake, this three-way handshake will be initiated by the client,
        that is to send a synchronization packet,
        get a synchronization acknowledgement packet,
        send the acknowledgement packet back.
    
    once this three-way handshake has been set up that's where this TCP connection will be ready and in place
    
    and once this TCP connection is ready in place then meanwhile:
    
    client will also prepare its own socket object, which will be communicating with this TCP connection
    
    and now over this once these two socket objects are ready, 
    the TCP connection is set in place,
    we are going to start sending up HTTP request and receive HTTP response.