## Installation

This application can be installed by following commands:

```
cd path/to/source/of/the/project
mvn install
java -jar target/application.jar
```

## Architecture

The architecture of the project maintains Domain-driven principle. The packages contains their corresponding domains. The project calls tasks in following order:

```
Controller -> Service -> Repository -> Repository validate products
```