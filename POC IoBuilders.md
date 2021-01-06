# POC IoBuilders

## Tech

### Tech risks
- Security Risks
    - <ins>Identity Theft:</ins> Establish a multifactor authentication process related to the user identity provided by the KYC process.
    - <ins>Corrupted data:</ins> Use a connection based protocol for all the communications between components to assure the data transfer.
    - <ins>Transaction inconsistency:</ins> If there is parallelism when running different processes, there should be a consensus mechanism to determine the priority between different simultaneous data incorporation, as a blockchain based technology, depends on the layer of the process, the consensus protocol might need to be set in the server side of the system.
    - <ins>Unauthorized transactions:</ins> This should be controlled with the user access control and identity authentication.
    - <ins>Tokenization errors:</ins> This might be a problem when giving a token value to certain assets that may change abruptly like, currency or stocks, for this there should be a real time value update of the assets value. This depends on how the tokenization happens, if it`s an external system there should be no problem.

- Legal risks
    - <ins>Money laundring:</ins> This can´t be prevented but can be mitigated, keeping a record and traceability of all the assets in a blockchain helps to analyze and determine strange behaviour and get to the source of it.
    - <ins>Scams:</ins> I am not really sure whether this is a real risk or not, depending on how the tokens are assigned based on the user´s asset value, this could be a problem, someone might try to over evaluate an asset and trade it for another asset as a way of increasing the value permanently.
    - <ins>License expiration:</ins> This can be easily mitigated by scheduling license renovations and auditing periodically the system.   


## Architecture

 - Design
    - Ionic can be used as a cross platform development framework that would help integrating the web app both into Android and IOS, this allows to use all the features of each operating system.
    Then it should be defined as a client-server based application, helping the user reduce the processing cost of any operation to a simple web request.

    - The application should be self sufficient, meaning that if no internet connection is available the user can see a copy of the data of the last time the device had access to the server. But all the operations done with this wallet have to be consistent with the Blockchain, so it has to be connected in order to perform a transaction.

    - It should implement a tutorial or guided manual to perform each transaction for the first time, so the user is always capable of having a comfortable learning process.

    - The KYC process should be implemented as guided steps for the user to be able to complete it without many issues, this adds the implicit requirement that the process should not be too long or time consuming, we need the user to fulfill it correctly because this will define its identity when performing transactions through the app.    
 
 - Technologies
   - As the diagram shows, Alastria is an identity management consortium based on Ethereum, it can be helpful to manage user credentials to operate in the blockchain network.

   - In the fields of tokenized money or economic assets, I have no knowledge, so I should read a bit about this matter to take an informed decision. I suppose that there is a required process of registering an asset, and a way to calculate that asset equivalent on tokens. I also guess that having in count that values changes as the market flows, this equivalence is not the same always, it depends on the asset itself and the market demand. So there should be a public system accesible to add the value fluctuations to the token calculation (Not really sure about this).

   - As blockchain technology, Ethereum is currently the most supported programmable blockchain with multiple systems based on it, the concept of smart contract allows us to define auto-runnable contracts that will help in the tokenization process, adding a register for each execution to the chain maintaining the traceability of the assets.

   - For the server side of the system, it should be implemented as a modularized web app with intercomunicating components, mainly one for the user application, other to interact with the blockchain and another one used as interface to interact with the acquirer, and bankig tech systems, so this server part should be the union point of the user and the whole tokenization system.


## Team

   - Having that the project will be a base component the team should cover all the possible requirements, web development, systems configuration, database management, legal aspects.
   - The ideal team member should have at least deep knowledge of one of the technologies involved in the project but should also have some basic knowledge of everything else to complete a T-skill scheme, where the team covers all the needs and each one can be helpful for other team members.
   - It shouldn´t be a big team because if there are more than 7-8 members, the decision making process would take a lot of time, and all the events used to share problems, ideas and knowledge will take most of the developement process.

## Culture

   - The main objective is to find whether the product defined in the POC is viable or not, for this matter, the ideal process is to develop an early prototype or MVP that gathers all the basic functionalities outside a real case scenario.
   
   - In order to establish the scope of the prototype, it is best to define the basic behaviours and use this as a test vector to assure that what is built is built correctly and works as expected.
   
   - The system should be built in iterations adding new functionality while cleaning existing ones based on an iteration review and prototype evaluation. This helps deliver a clean product with only the required features and with the expected behaviour without adding complexity to the whole system.

   - The core of the culture should be team oriented in order to persist and enhance teamwork dynamics and cooperation. This means that instead of building a team around each project, the teams should be self managed with some established events to share knowledge, problems, ideas and to improve performance for each iteration the team works together strengthening the bonds and the cooperation.

   - Also the main objective should not be to deliver a perfect product from the beginning but to deliver fast prototypes to fail and correct all the possible issues found in each version. This way we deliver a more accurate and clean product, reducing all the possible waste.

   - Kudos are also a great way of helping the team members feel closer to each other and valued by their teammates, they don´t need to be physical presents ( which can sometimes be compromising) but just celebrate victories or cheer when someone is feling unmotivated.

   - Everyone should know that the project is all itself a learning process, not a demonstration of knowledge but a way of improving the hardskills and the softskills of each individual. So each one has a different point of view that can be valuable for everyone, this is not a fact driven science so there are multiple ways of solving the problems with the same output.

    