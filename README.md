# Spring Boot JPA CRUD Project

This Spring Boot application demonstrates CRUD (Create, Read, Update, Delete) operations using JPA (Java Persistence API). It manages students (`alunos`), evaluations (`avaliacoes`), and enrollments (`matriculas`).

## Features

- **Create**
- **Read**
- **Update**
- **Delete**
## API Endpoints

### Students (`/alunos`)

#### Create a Student

- **POST** `/alunos`
- **Request Body**:

  ```json
  {
      "nome": "Alejandro",
      "cpf": "306.562.330-79",
      "bairro": "Minas Gerais",
      "dataDeNascimento": "09/12/1994"
  }
  ```

#### Get All Students

- **GET** `/alunos`
- **Response**:

  ```json
  [
      {
          "id": 1,
          "nome": "Alejandro",
          "cpf": "306.562.330-79",
          "bairro": "Minas Gerais",
          "dataDeNascimento": "09/12/1994"
      }
  ]
  ```

#### Get Students by Birth Date

- **GET** `/alunos?dataDeNascimento=09/12/1994`
- **Response**:

  ```json
  [
      {
          "id": 1,
          "nome": "Alejandro",
          "cpf": "306.562.330-79",
          "bairro": "Minas Gerais",
          "dataDeNascimento": "09/12/1994"
      }
  ]
  ```

### Evaluations (`/avaliacoes`)

#### Create an Evaluation

- **POST** `/avaliacoes`
- **Request Body**:

  ```json
  {
      "alunoId": 1,
      "peso": "90",
      "altura": "1.81"
  }
  ```

#### Get Evaluations by Student ID

- **GET** `/alunos/avaliacoes/1`
- **Response**:

  ```json
  [
      {
          "id": 1,
          "aluno": {
              "id": 1,
              "nome": "Alejandro",
              "cpf": "306.562.330-79",
              "bairro": "Minas Gerais",
              "dataDeNascimento": "09/12/1994"
          },
          "dataDaAvaliacao": "30/01/2025 12:12:01",
          "peso": 90.0,
          "altura": 1.81
      }
  ]
  ```

### Enrollments (`/matriculas`)

#### Create an Enrollment

- **POST** `/matriculas`
- **Request Body**:

  ```json
  {
      "alunoId": "1"
  }
  ```

#### Get All Enrollments

- **GET** `/matriculas`
- **Response**:

  ```json
  [
      {
          "id": 1,
          "aluno": {
              "id": 1,
              "nome": "Alejandro",
              "cpf": "306.562.330-79",
              "bairro": "Minas Gerais",
              "dataDeNascimento": "09/12/1994"
          },
          "dataDaMatricula": "30/01/2025 12:12:21"
      }
  ]
  ```

#### Get Enrollments by Neighborhood

- **GET** `/matriculas?bairro=Minas Gerais`
- **Response**:

  ```json
  [
      {
          "id": 1,
          "aluno": {
              "id": 1,
              "nome": "Alejandro",
              "cpf": "306.562.330-79",
              "bairro": "Minas Gerais",
              "dataDeNascimento": "09/12/1994"
          },
          "dataDaMatricula": "30/01/2025 12:12:21"
      }
  ]
  ```

5. **Access the API**:

    - The API will be available at `http://localhost:8080`.

## Example Requests

### Create a Student

- **POST** `http://localhost:8080/alunos`
- **Request Body**:

  ```json
  {
      "nome": "Alejandro",
      "cpf": "306.562.330-79",
      "bairro": "Minas Gerais",
      "dataDeNascimento": "09/12/1994"
  }
  ```

### Create an Evaluation

- **POST** `http://localhost:8080/avaliacoes`
- **Request Body**:

  ```json
  {
      "alunoId": 1,
      "peso": "90",
      "altura": "1.81"
  }
  ``` 

### Create an Enrollment

- **Endpoint**: `POST /matriculas`
- **Request Body**:
  ```json
  {
      "alunoId": 1
  }
  ```
    - `alunoId`: The ID of the student to enroll.


- **Response**:
  ```json
  {
      "id": 1,
      "aluno": {
          "id": 1,
          "nome": "Alejandro",
          "cpf": "306.562.330-79",
          "bairro": "Minas Gerais",
          "dataDeNascimento": "09/12/1994"
      },
      "dataDaMatricula": "31/01/2025 18:03:45"
  }
  ```

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6.3 or higher
- PostgreSQL or any other relational database

### Installation

1. **Clone the repository**:

   ```bash
   git clone https://github.com/yourusername/your-repo-name.git
   cd your-repo-name
   ```

2. **Configure the database**:

    - Update the `application.properties` file with your database credentials:

      ```properties
      server.port=8080
 
      spring.datasource.url=jdbc:postgresql://localhost:5432/academia?useTimezone=true&serverTimezone=UTC&useLegacyDate
      spring.datasource.username=postgres
      spring.datasource.password=admin
 
      spring.jpa.show-sql=true
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.properties.hibernate.format_sql=true
 
      logging.level.org.hibernate.type=trace
      ```

3. **Build the project**:

   ```bash
   mvn clean install
   ```

4. **Run the application**:

   ```bash
   mvn spring-boot:run
   ```

