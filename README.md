# ATDev.

## Getting Started

These instructions will help you set up and run the ATDev. project on your local machine for development and testing purposes.

### Prerequisites

Before setting up the project, ensure you have the following installed:

- JDK (Java Development Kit) 8 or later.
- MySQL (relational database management system).
- MySQL Workbench or DBeaver, GUI tool for database (optional)
- Postman or (any tool) for testing APIs.

## Installation

```
git clone https://github.com/HarshJain-26/ATD.git
```

```
cd ATD
```

## Database Setup

1. Create a new database in MySQL:

   - CREATE DATABASE DATABASE_NAME

2. Configure MySQL credentials in application.properties:
   - spring.datasource.url=jdbc:mysql://localhost:3306/DATABASE_NAME
   - spring.datasource.username=your-username
   - spring.datasource.password=your-password
   - spring.jpa.hibernate.ddl-auto=update
   - spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
   - spring.jpa.show-sql=true
   - spring.jpa.properties.hibernate.format_sql=true

## FileSystem setup
   In application.properties

   - file.path=files/

   - This will create a new directory in your project. All newly created files will stored in 'files/' directory.

## Run the Application

```
mvn clean install
```

```
mvn spring-boot:run
```

Once started, the application will be running at http://localhost:8080/ (default)

## Usage

You can interact with the API by sending HTTP requests using tools like Postman or curl. For example:

- If you are using Postman select 'body > raw > JSON'

- http://localhost:8080/api/v1/{endpoint}/

## Endpoints

## CRUD API with DATABASE

1. Save Student Data (POST)

   Endpoint: http://localhost:8080/api/v1/student/

   Method: Post

   - Request Body

   ```
   {
      "studentName" : "Harsh",
      "studentEmail" : "harsh@gmail.com"
      "studentNo" : "1234567890"
      "address": {
         "state": "Maharashtra",
         "city": "Pune",
         "pinCode": "411001"
      }
   }
   ```

   - Response Body

   ```
    {
      "studentId" : 1,
      "studentName" : "Harsh",
      "studentEmail" : "harsh@gmail.com"
      "studentNo" : "1234567890"
      "address": {
         "state": "Maharashtra",
         "city": "Pune",
         "pinCode": "411001"
      }
   }
   ```

2. Get Student Data (Get)

   Endpoint: http://localhost:8080/api/v1/student/{studentId}

   Method: Get

   - Response Body

   ```
   {
      "studentId" : 1,
      "studentName" : "Harsh",
      "studentEmail" : "harsh@gmail.com"
      "studentNo" : "1234567890"
      "address": {
         "state": "Maharashtra",
         "city": "Pune",
         "pinCode": "411001"
      }
   }
   ```

3. Fetch All Students Data (Get)

   Endpoint: http://localhost:8080/api/v1/student/

   Method: Get

   - Response Body

   ```
   [
      {
         "studentId" : 1,
         "studentName" : "Harsh",
         "studentEmail" : "harsh@gmail.com"
         "studentNo" : "1234567890"
         "address": {
            "state": "Maharashtra",
            "city": "Pune",
            "pinCode": "411001"
         },

         "studentId" : 2,
         "studentName" : "XYZ",
         "studentEmail" : "xyz@gmail.com"
         "studentNo" : "1234567890"
         "address": {
            "state": "Maharashtra",
            "city": "Pune",
            "pinCode": "411001"
         },
      }
   ]
   ```

4. Update Student Data (Put)

   Endpoint: http://localhost:8080/api/v1/student/{studentId}

   Method: Put

   - Request Body

   ```
   {
      "studentName" : "Harsh",
      "studentEmail" : "harsh@gmail.com"
      "studentNo" : "1234567890"
      "address": {
         "state": "Maharashtra",
         "city": "Pune",
         "pinCode": "411001"
      }
   }
   ```

   - Response Body

   ```
   {
      "studentId" : 1,
      "studentName" : "Harsh",
      "studentEmail" : "harsh@gmail.com"
      "studentNo" : "1234567890"
      "address": {
         "state": "Maharashtra",
         "city": "Pune",
         "pinCode": "411001"
      }
   }
   ```

5. Delete Student Data (Delete)

   Endpoint: http://localhost:8080/api/v1/student/{studentId}

   Method: Delete

   - Response Body

   ```
   Student Deleted
   ```

### All Endpoints have validations, proper error handling and response.

   Validations -
      
      1. Data should not be empty or null
      2. Student No. should not be less than or greater than 10 digit.
      3. Pincode should not be less than or greater than 6 digit.
      4. Email should be valid email.

## Notes

- Ensure you replace your-username and your-password in application.properties with your actual MySQL credentials.
- The schema will be automatically updated in the database when the application starts (spring.jpa.hibernate.ddl-auto=update).
  
<br>

## CRUD API with FILESYSTEM

1. Upload / Create file (Post)

   Endpoint: http://localhost:8080/api/v1/file/

   Method: Post

   - Request Body
      <p>
      If you are using Postman select 'body > form-data > value (File)'. Select the file from the your local machine.
      </p>

   - Response Body

   ```
   File Uploaded
   ```

   New file will be created in 'files/' directory.

3. Fetch All files (Get)

   Endpoint: http://localhost:8080/api/v1/file/

   Method: Get

   - Response Body

   ```
   [
      file_name1,
      file_name2,
      file_name3,
   ]
   ```

4. View file (Get)

   Endpoint: http://localhost:8080/api/v1/file/{fileName}

   Method: Get

   - Open you favourite browser, hit the above EndPoint.


5. Download file (Get)

   Endpoint: http://localhost:8080/api/v1/file/{fileName}/download

   Method: Get

   - Open you favourite browser, hit the above EndPoint.

6. Delete file (Delete)

   Endpoint: http://localhost:8080/api/v1/file/{fileName}

   Method: Delete

   - Response Body
   
   ```
   File Deleted
   ```

### All above Endpoints have proper error handling and response.

### Author - Harsh Jain
