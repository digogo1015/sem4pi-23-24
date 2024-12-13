# US G003

## 1. Context

*This task is being taken for the first time in this Sprint.*

## 2. Requirements

**US G003** As Project Manager, I want the team to configure the project structure to facilitate/accelerate the
development of upcoming user stories.

**References:**

*The structure of the project must support the envisioned architecture, such as presented in Chapter 4 of the project
description, including support for adopted technologies (e.g., ANTLR).*

"The Backoffice app is used by admins, customer managers and operators. Both the Candidate and Customer apps follow a
specific design, as described by NFR10. They connect to a server (Follow Up Server) using a specific protocol (NFR10).
Only the server is able to connect directly to the database. It is important to note that the client apps receive
notifications originating from the server. The Applications Email Bot is outside of the scope of this project. It is
assumed to exist and to behave as described in Section 2.2.3. The files produced by the Applications Email Bot are to be
further processed by the Applications File Bot, which results are to be imported in the Backoffice by the Operator. The
plugins (i.e., Job Requirements Specification and Interview Model) support the language automations described in Section
2.2.4. They are developed by a Language Engineer and deployed and configured in the Backoffice to be used for interviews
and requirements verifications. It is important to note that these are the base applications expected for the solution.
Other applications can be included in the solution to meet all requirements(functional and non-functional)."

## 3. Observations

Packages were created for the various apps that will developed in future USs. 