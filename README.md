# Selenium Login Automation Framework with Cucumber

This repository contains a **Selenium WebDriver automation framework** built using **Java, Maven, and Cucumber** following the **Page Object Model (POM)** design pattern. The framework automates login functionality for the sample application:

🔗 [https://the-internet.herokuapp.com/login](https://the-internet.herokuapp.com/login)

---
## 🛠️ Tech Stack

- **Language:** Java 21
- **Automation Tool:** Selenium WebDriver 4.39.0
- **Test Framework:** Cucumber 6.11.0 with JUnit
- **Build Tool:** Maven
- **Browser:** Google Chrome
- **Design Pattern:** Page Object Model (POM)
- **IDE:** IntelliJ IDEA

---

## 📁 Project Structure

```

selenium-login-automation
│
├── src/main/java
│   ├── base
│   │   └── basepage.java              # Browser setup and teardown
│   ├── pages
│   │   └── LoginPage.java             # Page Object Model classes
│
├── src/test/java
│   ├── stepdefinitions
│   │   └── LoginSteps.java            # Login Stepdefinitions
│   ├── TestRunner                
│       └── BDDrunner.java             #TestRunner file
│   ├── tests
│       └── LoginTest.java             #TestNG execution
├── src/test/resources
│   ├── features
│   │   └── Login.feature              # Cucumber feature files
│
├── pom.xml
└── README.md

````

---

## 🧩 Framework Components

### 1️⃣ BasePage (`basepage.java`)

- Manages WebDriver lifecycle using WebDriverManager
- Initializes ChromeDriver, maximizes window, and launches the application URL
- Provides method to close the browser after test execution

### 2️⃣ Page Object (`LoginPage.java`)

- Encapsulates locators and methods for interacting with the login page
- Methods include entering username, password, clicking login, and fetching messages

### 3️⃣ Step Definitions (`LoginSteps.java`)

- Implements the Cucumber step definitions corresponding to feature file steps

### 4️⃣ Test Runner (`BDDrunner.java`)

- Configures and runs Cucumber tests with TestNG
- Specifies feature file location, step definitions package, and report generation

---

## ✅ Test Scenarios Covered

- **Valid Login:** User logs in with valid credentials and verifies success
- **Invalid Login:** User logs in with incorrect credentials and verifies error message
- **Empty Fields:** User attempts login without credentials and verifies error message

---

## ▶️ How to Run the Tests

### Prerequisites

- Java 21 installed and configured
- Maven installed and configured
- Chrome browser installed

### Running Tests

1. Import the project into IntelliJ IDEA
2. Run the `BDDrunner.java` class as a TestNG test
