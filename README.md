
# Data Sorter – Sorting Algorithm Comparison Tool

*A small Java project for the Data Structures & Algorithms course (semester project).*
This repository contains a console-based sorting comparison application that demonstrates algorithm efficiency, time measurement, and performance comparison among common sorting techniques. The code is intentionally compact for learning, demonstration, and extension.

---

## Table of Contents

* Project Overview
* Features
* Tech Stack
* Project Structure
* How to Compile & Run (Windows PowerShell)
* Members]
* Notes & Next Steps]

---

## Project Overview

This project implements **Bubble Sort**, **Merge Sort**, and **Quick Sort** to compare their performance on various datasets.
It allows users to enter custom numbers or generate random datasets, sort them using different algorithms, and observe differences in execution time and step counts.

It is written in plain Java and requires a JDK to compile and run.

---

## Features

✅ Manual or random data input
✅ Implementation of **Bubble Sort**, **Merge Sort**, and **Quick Sort**
✅ Step count tracking and execution time measurement
✅ Comparison table showing performance results
✅ Menu-driven, user-friendly console interface
✅ Input validation and clear output formatting

---

## Tech Stack

* **Java (JDK 8+ recommended)**
* **No external libraries required**
* Works on any standard console environment

---

## Project Structure

Top-level files and purpose:

| File                             | Description                                             |
| -------------------------------- | ------------------------------------------------------- |
| `README.md`                      | This file                                               |
| `src/DataSorter.java`            | Main entry point; handles menu and user interface       |
| `src/BubbleSort.java`            | Implements Bubble Sort with step count tracking         |
| `src/MergeSort.java`             | Implements Merge Sort with performance measurement      |
| `src/QuickSort.java`             | Implements Quick Sort with performance measurement      |
| `src/DataGenerator.java`         | Handles random data generation and utility methods      |
| `src/PerformanceComparator.java` | Compares algorithm results and displays a summary table |

All source files are inside the `src` folder (default package).

---

## How to Compile & Run (Windows PowerShell)

Open PowerShell and run the following commands from the project root (where this README.md sits):

```bash
# Change to the project directory
cd "E:\IT\DSA\Data-Sorter-Tool"

# Create an output directory for compiled classes
if (-not (Test-Path -Path .\bin)) { New-Item -ItemType Directory -Path .\bin | Out-Null }

# Compile all Java sources into the bin folder
javac -d bin src\*.java

# Run the program
java -cp bin DataSorter
```

**Notes:**

* Ensure you have a **JDK** installed and accessible via your system PATH.

  * Check using `javac -version` and `java -version`.
* If using an IDE (Eclipse/IntelliJ), import it as a **plain Java project** and run the `DataSorter` class.

---

## Example Menu

```
--- Data Sorter: Sorting Algorithm Comparison Tool ---
1. Enter numbers manually
2. Generate random numbers
3. Perform Bubble Sort
4. Perform Merge Sort
5. Perform Quick Sort
6. Compare all algorithms (show performance table)
7. Exit
Enter your choice:
```

---

## Members

| Member        | ID                                               | Task                                                               |
| ------------- | ------------------------------------------------ | ------------------------------------------------------------------ |
| **Member 01** | 22UG3-0073 - J. A. C. N. Senarathna              | Implement Bubble Sort with step count tracking                     |
| **Member 02** | 22UG3-0713 - A. B. Sanduni Kawshalya Adahasingha | Implement Merge Sort and integrate performance measurement         |
| **Member 03** | 22UG3-0069 - W. J. S. Savinda Perera             | Implement Quick Sort and integrate performance measurement         |
| **Member 04** | 22UG3-0812 - E. K. Udayangi Udeshika             | Develop data generation, comparison table, and main user interface |

---

## Notes & Next Steps

This README focuses on getting started quickly.
Suggested improvements:

* Add graphical performance charts (optional for advanced users)
* Include unit tests for sorting functions
* Add input/output file support
* Provide Javadoc comments and generate API docs

---

📅 **Updated on:** 2025-11-07

