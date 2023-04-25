# Health Record Management API
This project is a Java-based REST API for managing health records of patients, both in-patient and out-patient. It is built using the Spring Boot framework and supports CRUD (Create, Read, Update, Delete) operations on patient records, medical histories, in-patient records, out-patient records, and clinics.

# Installation
To run the API locally, you will need to have Java 11 or later installed on your machine. Clone the repository and navigate to the root directory of the project. Then, run the following command to start the API:

./mvnw spring-boot:run

This will start the API on port 8080. You can access the API using a web browser or a tool like Postman.

# Usage
The API supports the following endpoints:

/patients: GET (retrieve all patients), POST (create a new patient)
/patients/{id}: GET (retrieve a single patient by ID), PUT (update an existing patient by ID), DELETE (delete a patient by ID)
/histories: GET (retrieve all medical histories), POST (create a new medical history)
/histories/{id}: GET (retrieve a single medical history by ID), PUT (update an existing medical history by ID), DELETE (delete a medical history by ID)
/inpatients: GET (retrieve all in-patients), POST (create a new in-patient record)
/inpatients/{id}: GET (retrieve a single in-patient record by ID), PUT (update an existing in-patient record by ID), DELETE (delete an in-patient record by ID)
/outpatients: GET (retrieve all out-patients), POST (create a new out-patient record)
/outpatients/{id}: GET (retrieve a single out-patient record by ID), PUT (update an existing out-patient record by ID), DELETE (delete an out-patient record by ID)
/clinics: GET (retrieve all clinics), POST (create a new clinic)
/clinics/{id}: GET (retrieve a single clinic by ID), PUT (update an existing clinic by ID), DELETE (delete a clinic by ID)
For example, to retrieve a list of all patients, you can send a GET request to the /patients endpoint.

# Contributing
Contributions to this project are welcome. If you find a bug or have a suggestion for a new feature, please create a new issue in the repository. If you would like to contribute code, please fork the repository and create a new branch for your changes. When you are ready, create a pull request and we will review your changes.
