# US 1009

## 1. Context

*This task is being taken for the first time in Sprint B.*

## 2. Requirements

**US 1009** As Customer Manager, I want to select the requirements specification to be used
for a job opening

**Client Acceptance Criteria:**

**Dependencies/References:**

## 3. Analysis

![SSD](analysis/us1009-SelectRequirements-SSD.svg)

## 4. Design

For this US, a UI and Controller class have been created. The UI will ask the user to select a jobOpening (with no
Requirement Specification) and a Plugin (with the REQUIREMENTS_SPECIFICATION type).
With this information, the selected plugin will be then associated with the jobOpening the job opening will then be
persisted in the system.

### 4.1. Sequence Diagram

![SSD](design/us1009-ListBackOfficeUsers-SD.svg)

### 4.2. Class Diagram

### 4.3. Tests

There are no domain classes to make tests for this US