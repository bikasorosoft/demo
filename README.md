# Application - Data Management with Singleton Pattern

## Overview

This Java application demonstrates reading data from csv file using the singleton design pattern. The application reads
from `src/main/resources/data.csv` and provides basic operations on this data (populates, retrieve, update, and clear
data).

## Getting Started

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/bikasorosoft/demo.git
    unzip it
    cd demo
    ```
2. **Run the Application**: Use an IDE or run from the command line:
    ```bash
    mvn package exec:java
    ```

## CSV Data Format

The application reads data in CSV format. It expects the CSV file to have data in a format that can be parsed by
`populate(Path path)`. All fields are mandatory. Ensure that your CSV file is structured with the following columns:

| Column     | Description                              |
|------------|------------------------------------------|
| Username   | The user's unique username               |
| Identifier | A unique numeric identifier for the user |
| First name | The user's first name                    |
| Last name  | The user's last name                     |
