# Playwright Cucumber Tests

This repository contains automated tests for your project using Playwright and Cucumber. The tests are written in Java 21 and managed by Gradle 8.4.

## Tech Stack

- **Java 21**: The programming language used for writing the tests.
- **Gradle 8.4**: The build automation tool used for managing the project and running the tests.
- **Playwright** 1.48 with Chrome 130.0

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

Pre-setup Github Actions (for Allure report generation)

- Go to Profile -> Settings -> Developer Settings -> Personal access tokens -> Tokens (classic)
- Generate token with name GITHUB_TOKEN
- Go to Repository -> Settings -> Actions -> General
- In "Workflow permissions" section choose option "Read and write permissions" -> Save
- Go to Repository -> Settings -> Pages
- In "Build and deployment" section choose "Source" option "Deploy from a branch"
- Create branch "gh-pages" if not exists
- Select this branch with "/(root)" -> Save

Github Actions is ready for deploying Allure report after test phase execution

### Selenium Grid 4

For running tests inside Selenium Grid, should be run docker-compose file for Apple Silicon (M1 - M3) in the project root before

To set up and tear down Selenium Grid use the following commands

```bash
docker-compose up -d
docker-compose down
```

To run tests

```bash
SELENIUM_REMOTE_URL=http://localhost:4444 ./gradlew clean cucumber -Dparallel=true
```
