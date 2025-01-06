# Test Automation Framework for OrangeHRM Login and Dashboard

## Overview
This repository contains a Test Automation Framework for testing the Login and Dashboard functionality of the OrangeHRM application. The framework is built using Selenium, Cucumber, and BDD principles, ensuring maintainability, reusability, and scalability of test scripts. Test reports are generated using the Maven Cucumber Reporting plugin.

---

## Project Structure

### Source Code
- **`src/main/java/org.assessments.frameworkFunctions`**: Contains reusable Selenium utility and framework functions.
- **`src/main/java/org.assessments.pages`**: Contains Page Object Models (POMs) and functionalities for the application.

### Test Code
- **`src/test/java`**:
    - **`runners`**: Contains Cucumber test runners.
    - **`hooks`**: Defines pre- and post-conditions for test execution.
    - **`stepDefinitions`**: Implements the step definitions for the feature files.
- **`src/test/resources`**:
    - **`features`**: Contains Cucumber feature files defining extensive functional tests for the Login and Dashboard pages.

### Reports
- **`target/cucumber-report-html`**: Stores the generated HTML reports after test execution.

---

## Prerequisites

1. **Java Development Kit (JDK)**: Ensure JDK 8 or above is installed.
2. **Apache Maven**: Install Maven to manage dependencies and build the project.
3. **WebDriver**: Ensure the appropriate WebDriver (e.g., ChromeDriver) is set up and added to the system PATH.
4. **Git**: Clone the repository using Git.

---

## Setting Up Locally

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```

2. **Install Dependencies**
   Execute the following command in the root directory:
   ```bash
   mvn clean install
   ```

3. **Configure WebDriver**
   Ensure the required WebDriver (e.g., ChromeDriver) is installed and available in your system PATH.

4. **Run Tests**
   Use the following command to run the tests:
   ```bash
   mvn clean test
   ```

---

## Generating Reports

After running the tests, the HTML report can be found at:
`target/cucumber-report-html/cucumber-html-reports.html`

To regenerate the report:
```bash
mvn verify
```

---


## Features and Test Scenarios

### **Login Page**
- Positive scenarios:
    - Verify login with valid credentials.
- Negative scenarios:
    - Invalid username/password.
    - Empty fields.
- UI validations:
    - Elements are displayed.

### **Dashboard Page**
- Positive scenarios:
    - Verify the presence of widgets and navigation menu modules.
    - Navigation to modules like Admin and PIM.
- Negative scenarios:
    - Accessing the dashboard without login.
    - Logout functionality verification.
- UI validations:
    - Responsiveness and interactivity of widgets and modules.

---

## Design Choices

1. **Modular Framework**:
    - **Reusable Utilities**: Common functions (e.g., browser actions, waits) are abstracted in `frameworkFunctions` for easy reuse.
    - **Page Object Model (POM)**: Organized code for each page, improving readability and maintainability.

2. **BDD Approach**:
    - Defined feature files for better collaboration and understanding of test cases.
3. **Scalability**:
    - The framework supports adding new pages and test cases without major structural changes.
4. **Cucumber Reporting**:
    - Integrated `maven-cucumber-reporting` for detailed HTML reports with test results.

5. **Hooks**:
    - Managed preconditions (e.g., browser setup) and postconditions (e.g., teardown) in `hooks` for cleaner code.

---

## Improvements
Given more time, the following enhancements can be made:

1. **Additional Test Scenarios**:
    - Add tests for edge cases and more complex workflows.

2. **Integration with CI/CD**:
    - Set up continuous integration pipelines using tools like Jenkins or GitHub Actions.

3. **Cross-Browser Testing**:
    - Extend the framework to support multiple browsers using tools like Selenium Grid.

4. **Parallel Execution**:
    - Optimize test execution time by running tests in parallel.
   
5. **Data-Driven Testing**:
   - Use external files (e.g., Excel, CSV) for test data management.

---
