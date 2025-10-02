# Online Book Store API Test Automation

[Maven Build and Test](https://github.com/alpiysl/avengaOnlineBookStore/actions/workflows/maven-test.yml)

A comprehensive REST API test automation framework for the Online Book Store application, built with Java, TestNG, RestAssured, and ExtentReports.

## Table of Contents

- [Overview](#overview)
- [Technologies & Tools](#technologies--tools)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Running Tests](#running-tests)
- [Test Reports](#test-reports)
- [CI/CD Pipeline](#cicd-pipeline)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)

## Overview

This project provides automated API testing for the Fake REST API (Online Book Store) hosted at `https://fakerestapi.azurewebsites.net`. The framework tests CRUD operations for three main entities:

- **Activities**
- **Authors**
- **Books**

## Technologies & Tools

| Technology    | Version     | Purpose                       |
| ------------- | ----------- | ----------------------------- |
| Java          | 18          | Programming Language          |
| Maven         | 3.x         | Build & Dependency Management |
| TestNG        | 7.11.0      | Test Framework                |
| RestAssured   | 5.5.6       | API Testing Library           |
| ExtentReports | 5.0.9       | Test Reporting                |
| JavaFaker     | 1.0.2       | Test Data Generation          |
| Lombok        | 1.18.38     | Code Generation               |
| JSON          | 20250517    | JSON Processing               |
| Log4j         | 3.0.0-beta2 | Logging                       |

## Project Structure

```
AVENGA_OnlineBookStore/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org/
│   │           ├── Activities/       # Activity entity models
│   │           ├── Authors/          # Author entity models
│   │           ├── Books/            # Book entity models
│   │           ├── Endpoints/        # API endpoint definitions
│   │           ├── Reporter/         # ExtentReport configuration
│   │           └── Utils/            # Utility classes (RestUtils, FakerDataUtil, TimeUtil)
│   └── test/
│       ├── java/
│       │   ├── testActivities.java   # Activity API tests
│       │   ├── testAuthors.java      # Author API tests
│       │   └── testBooks.java        # Book API tests
│       └── test.xml                  # TestNG suite configuration
├── .github/
│   └── workflows/
│       └── maven-test.yml            # GitHub Actions CI/CD pipeline
├── pom.xml                           # Maven configuration
└── README.md                         # Project documentation
```

## Prerequisites

Before running this project, ensure you have the following installed:

- **Java Development Kit (JDK) 18** or higher
- **Apache Maven 3.6+**
- **Git** (for cloning the repository)
- An IDE (IntelliJ IDEA, Eclipse, or VS Code recommended)

## Installation & Setup

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/AVENGA_OnlineBookStore.git
cd AVENGA_OnlineBookStore
```

### 2. Install Dependencies

```bash
mvn clean install
```

## Running Tests

### Run All Tests

```bash
mvn test
```

### Run Specific Test Suite

```bash
mvn test -DsuiteXmlFile=src/test/test.xml
```

### Test Execution Order

Tests are executed with priorities to ensure proper data flow:

#### Activities Tests (`testActivities.java`)

1. **GET** - Retrieve all activities
2. **POST** - Create a new activity
3. **GET_ID** - Retrieve specific activity by ID
4. **PUT** - Update the activity
5. **DELETE** - Delete the activity

#### Authors Tests (`testAuthors.java`)

Same pattern: GET → POST → GET_ID → PUT → DELETE

#### Books Tests (`testBooks.java`)

Same pattern: GET → POST → GET_ID → PUT → DELETE

## Test Reports

### ExtentReports

After test execution, an HTML report is automatically generated in the `extent-reports/` directory.

#### Report Features:

- Test execution summary (Pass/Fail/Skip)
- Timestamp for each test
- Detailed request/response information
- Request headers and body
- Response status and body
- Exception stack traces for failed tests

#### Sample Report Screenshot

![Extent Report Screenshot](docs/extent-report-screenshot.png)

_The report shows detailed test execution with timestamps, status, and comprehensive API request/response details._

## CI/CD Pipeline

### GitHub Actions Workflow

The project includes an automated CI/CD pipeline that runs on every push to the `master` branch.

#### Workflow Steps:

1. **Checkout Code** - Clones the repository
2. **Set up JDK 18** - Configures Java environment
3. **Build with Maven** - Compiles the project (`mvn clean compile`)
4. **Run Tests** - Executes all tests (`mvn test`)
5. **Rename Report with Timestamp** - Adds timestamp to the report file
6. **Upload Extent Report** - Saves HTML report as artifact
7. **Upload TestNG Results** - Saves TestNG reports as artifact

#### Accessing Reports from GitHub Actions

1. Go to the **Actions** tab in your repository
2. Click on the latest workflow run
3. Scroll down to **Artifacts** section
4. Download `extent-report-{run-number}.zip`
5. Extract and open the HTML file in your browser

#### Workflow Configuration

The workflow file is located at `.github/workflows/maven-test.yml` and is triggered by:

- Push to `master` branch
- Pull requests to `master` branch
- Manual workflow dispatch

## API Endpoints

Base URL: `https://fakerestapi.azurewebsites.net/api/v1/`

## Key Features

### 1. **Data Generation**

- Uses JavaFaker to generate realistic test data
- Random IDs, titles, and boolean values
- ISO 8601 formatted timestamps

### 2. **Comprehensive Logging**

- Request/response logging in ExtentReports
- Color-coded test results (Green = Pass, Red = Fail)
- Detailed exception stack traces
- API endpoint, method, headers, and body logging

### 3. **Modular Design**

- Separate utility classes for REST operations
- Entity-specific model classes
- Centralized endpoint management
- Reusable test methods

### 4. **Robust Error Handling**

- Automatic test failure reporting
- Stack trace capture and formatting
- Continue-on-error in CI/CD pipeline
