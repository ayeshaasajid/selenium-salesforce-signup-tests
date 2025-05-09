# selenium-salesforce-signup-tests
Automated functional and negative test cases for the Salesforce Developer signup page using Selenium WebDriver and TestNG.
# Selenium Automated Testing - Salesforce Signup Page

Welcome to the Selenium Automated Testing project repository! This repository contains automated test scripts for testing the **Salesforce Developer Signup** page. The tests are written in Java using **Selenium WebDriver** and **TestNG**, with detailed reporting via **ExtentReports**, **TestNG Emailable Report**, and **TestNG HTML Report**.

## Table of Contents

- [Introduction](#introduction)
- [Project Overview](#project-overview)
- [Test Artifacts](#test-artifacts)
- [Technologies Used](#technologies-used)
- [Test Coverage](#test-coverage)
- [Execution Instructions](#execution-instructions)
- [Reports](#reports)
- [Contributing](#contributing)
- [FAQ](#faq)

---

## Introduction

This project focuses on automated testing of the **Salesforce Developer Signup page**. It covers both **functional test cases** (e.g., valid sign-up scenarios) and **negative test cases** (e.g., missing fields, invalid inputs). The goal is to validate the behavior, error handling, and form validations of the signup process.

---

## Project Overview

The Salesforce signup page allows developers to create free accounts to access developer tools. This automation suite helps ensure that the form behaves as expected under different input conditions.

---

## Test Artifacts

This repository includes the following artifacts:

- ✅ **Test Scripts** (Selenium + TestNG)
- 📄 **Extent Report** (Rich HTML report with screenshots)
- 📨 **TestNG Emailable Report**
- 🌐 **TestNG Default HTML Report**
- 🔍 **testng.xml** (Suite configuration file)

---

## Technologies Used

- **Java**
- **Selenium WebDriver**
- **TestNG**
- **ExtentReports**
- **GitHub** (for version control)

---

## Test Coverage

- Functional Test Cases (valid signup)
- Negative Test Cases (invalid email, empty fields, etc.)
- Field validations
- UI element presence check
- Error message verifications

---

## Execution Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/selenium-salesforce-signup-tests.git
   Open the project in IntelliJ IDEA:

2. Launch IntelliJ IDEA.

- Click on File > Open and select the cloned project folder.

3. Manually add required JAR files:

- Download the following libraries from https://mvnrepository.com/:

  -selenium-java

  -testng

  -extent-reports

- Place them in a folder (e.g., lib/)

- Go to File > Project Structure > Modules > Dependencies > + JARs or directories → Add all the JARs.

4. Run the tests:

- Right-click on testng.xml → Run 'testng.xml'

- Or right-click any test class in src/test/java → Run

5. View the reports:

- Open test-output/emailable-report.html for the email-style report.

- Open test-output/ExtentReport.html for the rich ExtentReport.

---

## Reports

After test execution, reports can be found at:

📁 test-output/ – Contains:

index.html – TestNG HTML Report

emailable-report.html – TestNG Emailable Report

📁 reports/ – Contains:

ExtentReport.html – Beautiful graphical test execution report with logs and screenshots

You can open these reports in a browser to review the results.

---

## Contributing
Contributions are welcome! You can improve test coverage, fix bugs, or enhance reporting. Fork the repo, create a branch, and submit a pull request with your changes.

---

## FAQ
Q1: What is the purpose of this automation?
A: To ensure the Salesforce signup form works correctly and handles errors gracefully.

Q2: Can I add more test cases?
A: Yes! Add your test methods in the relevant classes and include them in the testng.xml file.

Q3: Are reports auto-generated?
A: Yes. Running the test suite via TestNG automatically generates TestNG and Extent Reports.



