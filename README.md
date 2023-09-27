RMIFileServerProject/
|-- src/
|   |-- FileServer.java          (RMI server interface)
|   |-- FileServerImpl.java      (RMI server implementation)
|   |-- FileServerServer.java    (RMI server main)
|   |-- FileServerClient.java    (RMI client main)
|-- server_files/                (Directory to store uploaded files)
|-- build/                       (Directory for compiled class files)
|-- lib/                         (Directory for any external libraries, if needed)
|-- README.md                    (Project documentation)


javac -d build src/*.java
java -classpath build FileServerServer
java -classpath build FileServerClient
