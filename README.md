# **QuizApp - Spring Boot Microservices**  
A **Spring Boot**-based microservices backend for a Quiz Application, designed to manage questions, create quizzes, and evaluate responses.  

## **⚒ Tech Stack**  
- **Java 17+**  
- **Spring Boot** (REST API)  
- **Spring Data JPA** (ORM for database interaction)  
- **MySQL** (Relational Database)  
- **Lombok** (Reduces boilerplate code)  
- **Maven** (Dependency management)  

---

## **📂 Project Structure**  
```
QuizApp/
│—— src/main/java/com/kunal/QuizApp/
│   ├—— Controller/
│   │   ├—— QuestionsController.java  # Handles question-related APIs
│   │   └—— QuizController.java       # Handles quiz-related APIs
│   ├—— Model/
│   │   ├—— Questions.java            # Entity for storing quiz questions
│   │   ├—— QuestionWrapper.java      # Wrapper class for quizzes
│   │   └—— Response.java             # Stores user responses
│   ├—— Repo/
│   │   └—— QuestionsRepo.java        # Repository for questions
│   ├—— Service/
│   │   ├—— QuestionService.java      # Business logic for questions
│   │   └—— QuizService.java          # Business logic for quizzes
│—— src/main/resources/
│   └—— application.properties        # Database configuration
│—— pom.xml                           # Project dependencies
│—— README.md                         # Project documentation
```

---

## **🔧 Database Configuration (MySQL)**
Configure MySQL in `src/main/resources/application.properties`:
```
spring.datasource.url=jdbc:mysql://localhost:3306/quizdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```
🔹 Replace `yourpassword` with your actual MySQL password.  
🔹 Ensure MySQL server is running and database **quizdb** is created.  

---

## **🚀 API Endpoints**  

### **1️⃣ Question Management Service**  
🔹 **Get all questions**  
`GET /question/allquestions`  

🔹 **Get questions by category**  
`GET /question/allquestions/{category}`  

🔹 **Add a new question**  
`POST /question/addQuestion`  
```json
{
  "question": "What is the size of int in Java?",
  "option1": "6 bytes",
  "option2": "4 bytes",
  "option3": "8 bytes",
  "option4": "Size depends on OS",
  "rightAnswer": "4 bytes",
  "difficultyLevel": "Easy",
  "category": "Java"
}
```

🔹 **Update a question**  
`POST /question/updateQuestion/{id}`  

🔹 **Delete a question**  
`DELETE /question/delete/{id}`  

---

### **2️⃣ Quiz Management Service**  
🔹 **Create a quiz**  
`POST /quiz/create?category=Java&noQ=5&title=JavaQuiz`  

🔹 **Get quiz questions**  
`GET /quiz/get/{id}`  

🔹 **Submit quiz responses**  
`POST /quiz/submit/{id}`  
```json
[
  { "questionId": 1, "answer": "4 bytes" },
  { "questionId": 2, "answer": "8 bytes" }
]
```

---

## **🚀 How to Run Locally**  
1️⃣ **Clone the Repository**  
```bash
git clone https://github.com/your-username/QuizApp.git
cd QuizApp
```

2️⃣ **Install Dependencies & Build the Project**  
```bash
mvn clean install
```

3️⃣ **Start MySQL Database & Configure**  
- Ensure MySQL is running  
- Create a database:  
```sql
CREATE DATABASE quizdb;
```
- Update `application.properties` with **your credentials**  

4️⃣ **Run the Spring Boot Application**  
```bash
mvn spring-boot:run
```

5️⃣ **Test APIs via Postman or Browser**  

---

## **🌟 Future Enhancements**  
🔹 User authentication using JWT (Spring Security)  
🔹 Frontend (React/Angular) Integration  
🔹 Timer-based quizzes  

---

Let me know if you want any modifications! 🚀

