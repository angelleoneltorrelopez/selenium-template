

# Description
This project is an automation test designed to demonstrate the use of the Selenium tool to perform automated tests on 
web applications and APIs. In this project, we use TestNG as a framework and Selenium WebDriver to automate interaction 
with a test web application.

# Requirement
- Maven 3.8.6
- Java 11

## Dependencies used
| Name           | Version |
|----------------|---------|
| [Selenium]     | 4.8.1   |
| [Testng]       | 7.7.1   |
| [Rest Assured] | 5.3.0   |

[Selenium]: https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.4.0
[Testng]: https://mvnrepository.com/artifact/org.testng/testng
[Rest Assured]: https://mvnrepository.com/artifact/io.rest-assured/rest-assured

## Supported browsers
| Browser | OS                    |
|---------|-----------------------|
| Chrome  | Windows, Linux, MacOS |
| Firefox | Windows, Linux, MacOS |
| Edge    | Windows, Linux, MacOS |
| Safari  | MacOS                 |



# Instalation
To install, follow the steps below:

1. Clone the repository from GitHub:
    ```bash
    git clone git@github.com:angelleoneltorrelopez/seleniumPractices.git
    ```
2. Install the project dependencies using the package manager:
    ```bash
    mvn install
    ```

# Use
To use the software, follow the steps below:

## Run test suite
Default Chrome browser
```bash
mvn clean verify
```

## Run test suite selecting browser
### Chrome
```bash
mvn clean verify -Dbrowser=chrome
```

### Safari
```bash
mvn clean verify -Dbrowser=safari
```

### Firefox
```bash
mvn clean verify -Dbrowser=firefox
```

### Edge
```bash
mvn clean verify -Dbrowser=edge
```

# Contact
If you have questions or comments about this project, please contact me at angelleoneltorrelopez@gmail.com. 
Thank you for using this software!