# US 3002

## 1. Context

*This task is being taken for the first time in Sprint C.*

## 2. Requirements

**US 3002** As Customer, I want to list all my job openings, including job reference, position,
active since, number of applicants.

**Client Acceptance Criteria:**

Q34: US3002, lista job openings, position o que é?

A34: Nessa US quando referimos “position” tem o mesmo significado que “title or function” na secção 2.2.2.

Q172: US3002 - Job Openings Clarifications - You stated that one of the this to show in the listing of job
openings is "active since". You've clarified that an active job opening is the one where its recruitment process is
on-going. Are the job openings listed in this funcionality only the ones with recruitment process on-going? Or also the
ones without recruitment processes, the ones with processes that haven't yet started or have ended?

A172: In the context of this US, “active since” means the date from the start of the process, the “application” phase (
since that date, candidates can apply). This functionality should include all the “active” job openings.

**NON FUNCTIONAL REQUIREMENTS:**

NFR10(RCOMP) Functionalities related to the Candidate and Customer Apps and to the Follow Up Server part of the system
have very specific technical requirements. It must follow a client-server architecture, where a client application is
used to access a server. Communications between these two components must follow specific protocol described in a
document from RCOMP ("Application Protocol"). Also, the client applications can not access the relational database, they
can only access the server application.

## 3. Analysis

![us3002-ListCustomerJobOpenings-DM.svg](analysis%2Fus3002-ListCustomerJobOpenings-DM.svg)
![us3002-ListCustomerJobOpenings-SSD.svg](analysis%2Fus3002-ListCustomerJobOpenings-SSD.svg)

## 4. Design

For the implementation of this US Customer App must communicate with the Server for it to give the JobOpenings of the
Customer.
The Customer will select the option to list his JObOpenings and a code with the number 7 (CODE DEFINED FOR THIS RCOMP
US), alongside its username will be passed to the Server.
The Server will then get the Customer object and will search for jobOpenings that have this Customer associated to them
and put them in DTO format. Then it serializes a list of DTO and sends it to the client.
Finally all the necessary information that should be presented will be passed to the Customer App that will deserialize
the information and then print it to the screen.

### 4.1. Sequence Diagram

![us3002-ListCustomerJobOpenings-SD.svg](design%2Fus3002-ListCustomerJobOpenings-SD.svg)

### 4.3. Tests

There are no Domain Classes to be tested in this US