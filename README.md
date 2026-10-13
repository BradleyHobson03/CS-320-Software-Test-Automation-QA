# CS 320: Software Test, Automation, and Quality Assurance

This repository contains my CS 320 portfolio work for Southern New Hampshire University.

## Project One — Contact, Task, and Appointment Services

Project One demonstrates back-end Java services and JUnit tests created from customer requirements.

### Contact Service
The Contact object enforces:
- Contact ID: required, unique at the service level, maximum 10 characters, not updatable
- First name: required, maximum 10 characters
- Last name: required, maximum 10 characters
- Phone: required, exactly 10 digits
- Address: required, maximum 30 characters

The ContactService supports adding, deleting, and updating contacts by contact ID.

### Task Service
The Task object enforces:
- Task ID: required, unique at the service level, maximum 10 characters, not updatable
- Name: required, maximum 20 characters
- Description: required, maximum 50 characters

The TaskService supports adding, deleting, and updating tasks by task ID.

### Appointment Service
The Appointment object enforces:
- Appointment ID: required, unique at the service level, maximum 10 characters, not updatable
- Appointment date: required and cannot be in the past
- Description: required, maximum 50 characters

The AppointmentService supports adding and deleting appointments by appointment ID.

## Testing Approach

The JUnit tests use:
- Requirement-based unit testing
- Positive testing
- Negative testing
- Boundary-value testing
- Duplicate-ID testing
- Missing-record testing
- Validation through service updates

The goal was not only to exercise code, but to trace tests directly to the customer requirements and challenge expected failure conditions.

## Project Two

Project Two contains my summary and reflection on the testing process, including:
- Alignment of tests to requirements
- Test effectiveness and coverage
- Technically sound and efficient testing
- Unit, boundary, positive, negative, integration, system, acceptance, regression, performance, and security testing concepts
- Caution, bias, discipline, and technical debt

## Repository Structure

```text
ProjectOne/
  ContactService/
    Contact.java
    ContactService.java
    ContactTest.java
    ContactServiceTest.java
  TaskService/
    Task.java
    TaskService.java
    TaskTest.java
    TaskServiceTest.java
  AppointmentService/
    Appointment.java
    AppointmentService.java
    AppointmentTest.java
    AppointmentServiceTest.java

ProjectTwo/
  CS320_Project_Two_Summary_Reflections_Bradley_Hobson.docx

CourseWork/
  CS320_Module_Four_Journal_Bradley_Hobson.docx
  CS320_Module_Five_Journal_Bradley_Hobson.docx
  CS320_Project_One_Guidelines_and_Rubric.md
```

## Recovery Note

The course requirements, journals, and Project Two report in this repository were recovered from my prior course work. The original individual Project One `.java` uploads were not available in the archived files, so the Java source and JUnit test files in `ProjectOne` were reconstructed from the documented requirements and my prior testing reflections. They preserve the required behavior and test cases described in those records.
