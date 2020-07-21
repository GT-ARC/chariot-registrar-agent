# CHARIOT Registration Agent

Registration Agent (RA) is designed for the integraiton of the IoT entities in CHARIOT agents world through a registration process.
RA relies on the Registration API and it profits from the Registration Server component of this API. RA receives all registration related messages
over MQTT protocol either sent by an IoT entity agent or a runtime environment (RE), and then forwards to the Knowledge Management Service (KMS).
KMS stores the IoT entity data model incoming with the registration request and send a status message back. 

Thanks to the distributed agent structure, the number of RA can be increased. In order to alleviate the database bottleneck issue, the number of the database can be also 
distributively deployed.
 
## Configuration

As aforementioned RA receives the messages over MQTT, and it requires an MQTT broker address that are used by the agents that intent to register themselves.
For this reason, all mqtt-related configuration written in `resources/entity.xml` file needs to be adapted according to the desired environment requirements.
These parameters are `host, username, password, clientId`. In addition, the interaction with the database should be added as well. `kmsURL` is given to establish the 
communication with the KMS database. A simple example is given below for the RA configuration, in which MQTT broker and KMS database run on the same computer and network.  
 
```xml       
<property name ="host" value="tcp://localhost:1883" />
<property name ="username" value="plbwvpgf" />
<property name ="password" value="mJTPb6z12Bag" />
<property name ="clientId" value="registerAgent" />
<property name="kmsURL" value="http://localhost:8080/v1/"/>
```        
## Usage

- After setting up the aforementioned configuration, you can start RA via `./startRegisterAgent`
- Stop RA via `./stopRegisterAgent`

If the aforementioned scripts cannot be executed on your platform, you should run
`/target/appassembler/bin/startRegistrarAgent` for unix OSes or `/target/appassembler/bin/startRegistrarAgent.bat` for Windows OS

## Contacts

The following persons can answer your questions: 

- Cem Akpolat: [akpolatcem@gmail.com](mailto://akpolatcem@gmail.com)
- Frederic Abraham: [Frederic-Marvin.Abraham@gt-arc.com](mailto://Frederic-Marvin.Abraham@gt-arc.com)



 
