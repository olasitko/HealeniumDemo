# Project Utilizing Healenium

This project leverages Healenium, a self-healing library for Selenium tests, to enhance the stability and resilience of automated tests.

## Configuration

### 1. Starting the Containers

Before running the tests, you need to start the container with the necessary Healenium components. To do this, navigate to the `infra` directory and run Docker Compose:

`cd infra`
`docker-compose up -d`

This will launch the required containers, such as:

*   `postgres-db`: PostgreSQL database for storing pattern selectors, healing information, and reports.
*   `hlm-proxy`: Proxy redirecting client requests to the Selenium server.
*   `hlm-backend`: CRUD service.
*   `selector-imitator`: Converter of healed locators to a convenient format.

Ensure that all containers are in the "Up" and "Running" state.

### 2. Running Tests

Tests can be run locally (using Healenium in Web mode) or remotely (using Healenium with Selenium Grid as the server).

#### Local Tests (Healenium Web)

To run tests locally, use the following command:

`mvn test -Denv=LOCAL`

#### Remote Tests (Healenium with Selenium Grid)

To run tests remotely, use the following command:

`mvn test -Denv=REMOTE`

### 3. Reports

The report can be found [here](http://localhost:7878/healenium/report).

## Healenium Documentation

For detailed information on Healenium, its architecture, configuration, and integration, please refer to the official documentation:

*   [Healenium Documentation](https://healenium.io/docs/overview)

## Additional Information

*   This project utilizes Healenium in the Healenium-Proxy architecture [3].
*   Healenium automatically detects and repairs test failures caused by UI changes, such as element IDs or class names [3].
*   Healenium integrates with test automation frameworks, providing seamless Selenium testing [2].
*   For issues or questions, consult the Healenium documentation or ask a question on the [Healenium GitHub](https://github.com/healenium/healenium) [2].
*   Example of using Healenium with Serenity: [healenium-serenity-example](https://github.com/healenium/healenium-serenity-example) [1].