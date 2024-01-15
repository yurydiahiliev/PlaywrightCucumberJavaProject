# Playwright Cucumber Tests

This repository contains automated tests for your project using Playwright and Cucumber. The tests are written in Java 17 and managed by Gradle 8.4.

## Tech Stack

- **Java 17**: The programming language used for writing the tests.
- **Gradle 8.4**: The build automation tool used for managing the project and running the tests.
- **Playwright** 1.40 with Chrome 120.0

## Getting Started

Follow these instructions to set up and run the tests.

### Clone the Repository

```bash
git clone https://github.com/yurydiahiliev/PlaywrightCucumberJavaProject.git
cd PlaywrightCucumberJavaProject
```

### Running Tests Locally

To run the tests locally, use the following Gradle command for running Gradle task:

```bash
./gradlew cucumber
```

###  Running Tests in Parallel Locally

If you want to run tests in parallel locally, use the following command with the -Dparallel=true flag:

```bash
./gradlew cucumber -Dparallel=true
```

### Github Actions

The tests are automatically executed using GitHub Actions. The workflow configuration is available in .github/workflows/gradle
