# SauceDemo QA Automation Project

This project is an automated test suite for the web application [saucedemo.com](https://saucedemo.com/), created as a practice project for learning QA automation using Java, Selenium WebDriver, and TestNG.

## Project Structure

- **Pages**: Contains Page Object Model (POM) classes for each application page (LoginPage, HomePage, CartPage, ProductPage, CheckoutPage). Each class defines elements and methods for interacting with them.
- **Tests**: Contains test classes for different functionalities (LoginTests, HomeTests, CartTests, ProductTests, CheckoutTests). Each test class extends TestBase and uses methods from the Page classes.
- **Base**: Contains the TestBase class, which sets up and tears down the browser, and provides helper methods for login and element handling.

## Technologies
- **Java**
- **Selenium WebDriver**
- **TestNG**
- **WebDriverManager** (for automatic browser driver management)

## How to Run the Tests
1. Clone or download the project.
2. Open the project in IntelliJ IDEA or another Java IDE.
3. Make sure all dependencies from `pom.xml` are installed (Maven build).
4. Run the desired tests from the TestNG test classes (e.g., CartTests, LoginTests).

## Main Functionalities Covered by Tests
- Login with valid and invalid credentials
- Adding and removing products from the cart
- Checking product prices and cart item count
- Checkout process
- Navigation through the application

## Notes
- Tests are written for the Edge browser, but can easily be adapted for Chrome or Firefox.
- All login data and URLs are hardcoded for simplicity.
- The project is educational and serves as practice for basic QA automation principles.

---

