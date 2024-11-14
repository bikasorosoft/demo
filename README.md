# Application - Data Management with Singleton Pattern

## Overview

This Java application demonstrates data management using the singleton design pattern. It leverages a `DataSingleton`
class to load, retrieve, update, and clear data stored in a CSV file. The application reads from
`src/main/resources/data.csv` and provides basic operations on this data.

## Getting Started

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/your-username/your-repo-name.git
    cd your-repo-name
    ```
2. **Run the Application**: Use an IDE or run from the command line:
    ```bash
    mvn exec:java
    ```

## Example CSV Format

The application expects the CSV file to have data in a format that can be parsed by `populate(Path path)`. Customize
this based on your data structure.

## Sample Output

Upon running, the console will show operations like:
