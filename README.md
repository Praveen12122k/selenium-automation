# Selenium Login Automation Framework

This repository contains a **Selenium WebDriver automation framework** built using **Java, Maven, and TestNG** following the **Page Object Model (POM)** design pattern. The framework automates login functionality for the sample application:

🔗 [https://the-internet.herokuapp.com/login](https://the-internet.herokuapp.com/login)

---

## 🛠️ Tech Stack

* **Language:** Java 21
* **Automation Tool:** Selenium WebDriver 4.39.0
* **Test Framework:** TestNG 7.11.0
* **Build Tool:** Maven
* **Browser:** Google Chrome
* **Design Pattern:** Page Object Model (POM)
* **IDE:** IntelliJ IDEA

---

## 📁 Project Structure

```
selenium-login-automation
│
├── src/test/java
│   ├── base
│   │   └── basepage.java
│   ├── pages
│   │   └── LoginPage.java
│   └── tests
│       └── ValidLoginTest.java
│
├── pom.xml
└── README.md
```

---

## 🧩 Framework Components

### 1️⃣ Base Page (`basepage.java`)

Responsible for **browser lifecycle management**.

**Responsibilities:**

* Initialize ChromeDriver
* Maximize browser window
* Launch application URL
* Provide explicit wait utility
* Close browser after test execution

```java
public class basepage {
    public WebDriver driver;
    String WebsiteURL = "https://the-internet.herokuapp.com/login";

    public basepage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}
```

---

### 2️⃣ Page Object (`LoginPage.java`)

Encapsulates **locators and actions** related to the Login page.

**Features:**

* Uses `By` locators
* Explicit waits (`WebDriverWait`)
* Methods for interacting with UI elements

**Actions Implemented:**

* Enter username
* Enter password
* Click login button
* Fetch success message
* Fetch error message

---

### 3️⃣ Test Class (`ValidLoginTest.java`)

Contains **TestNG test cases** with proper setup and teardown.

**Annotations Used:**

* `@BeforeMethod` – browser setup
* `@Test` – test execution
* `@AfterMethod` – browser cleanup

---

## ✅ Test Scenarios Covered

### 🔹 Valid Login Test

* Enter valid username and password
* Click login button
* Verify redirection to secure page
* Validate success message

### 🔹 Invalid Login Test

* Enter incorrect username and password
* click on login button
* Verify error message
* Ensure user remains on login page

### 🔹 Empty Fields Test

* Click login without entering credentials
* Validate error message
* Ensure user remains on login page

---

## ▶️ How to Run the Tests

### 1️⃣ Prerequisites

* Java 21 installed
* Maven installed
* Chrome browser installed

### 3️⃣ Run Tests Using Maven

You can also run tests directly from **IntelliJ IDEA** by right-clicking the test class and selecting **Run**.


## ⚠️ Common Issues

### ❌ NoSuchSessionException: invalid session id

**Cause:** Reusing WebDriver after closing the browser.

**Fix:**

* Initialize WebDriver in `@BeforeMethod`
* Close browser in `@AfterMethod`
* Use a fresh browser session for each test


## 🌟 Best Practices Followed

* Page Object Model (POM)
* Explicit waits for stability
* Independent test execution
* Externalized test data (CSV)
* Maven dependency management


