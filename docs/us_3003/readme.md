# US 3003

## 1. Context

*This task is being taken for the first time in Sprint C.*

## 2. Requirements

**US 3003** As Customer, I want to list all my job openings, including job reference, position,
active since, number of applicants.

**Client Acceptance Criteria:**

Q240: US3003 - As Customer, I want to be notied in my application when the state (phase) of my job openings changes.

A240: Sim, para mim faz sentido que o conceito de notificação tenha uma opção de marcar como lida a notificação. Deve
ser possível ver as notificações “já lidas” (algo como ver “todas” ou ver “todas a partir de uma data”).

**NON FUNCTIONAL REQUIREMENTS:**

NFR10(RCOMP) Functionalities related to the Candidate and Customer Apps and to the Follow Up Server part of the system
have very specific technical requirements. It must follow a client-server architecture, where a client application is
used to access a server. Communications between these two components must follow specific protocol described in a
document from RCOMP ("Application Protocol"). Also, the client applications can not access the relational database, they
can only access the server application.

## 3. Analysis

![us3003-NotifiedByPhaseChange-DM.svg](analysis%2Fus3003-NotifiedByPhaseChange-DM.svg)
![us3003-NotifiedByPhaseChange-SSD.svg](analysis%2Fus3003-NotifiedByPhaseChange-SSD.svg)

## 4. Design

For the implementation of this US Customer App must communicate with the Server for it to give the Notification of
when a phase change occurs in the Customer JobOpening.
The Customer will select the option to list his Notifications and a code with the number 8 (CODE DEFINED FOR THIS RCOMP
US), alongside its username will be passed to the Server.
The Server will then search for all not viewed notifications of the put them in DTO format. Then it serializes a list of
DTO and sends it to the client. Finally all the necessary information that should be presented will be passed to the
Customer App that will deserialize the information and then print it to the screen.

### 4.1. Sequence Diagram

![us3003-NotifiedByPhaseChange-SD.svg](design%2Fus3003-NotifiedByPhaseChange-SD.svg)

### 4.3. Tests

