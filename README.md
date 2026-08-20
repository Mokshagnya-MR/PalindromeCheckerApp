# Palindrome Checker App

A simple Java console application scaffold for checking whether a given string, word, or number is a palindrome.

## Current Status

This project is in early development. At present, the application:

- Boots a console entry point (`PalindromeCheckerApp.java`)
- Displays a formatted welcome banner with app name and version
- Establishes the base structure for the palindrome-checking logic to be added next

```
===========================================
        Palindrome Checker Application
              Version: 1.0.0
===========================================
Application started successfully!
```

## Planned Features

- Accept user input (string or number) via console
- Normalize input (case-insensitive, ignore spaces/punctuation)
- Check whether the input reads the same forwards and backwards
- Report the result back to the user
- Optionally support batch checking of multiple inputs

## Tech Stack

- **Language:** Java
- **Build/IDE:** IntelliJ IDEA project (`.iml`, `.idea/`)

## Getting Started

### Prerequisites

- JDK 8 or later
- IntelliJ IDEA (recommended) or any Java-compatible IDE

### Run

```bash
cd src
javac PalindromeCheckerApp.java
java PalindromeChecker
```

## Project Structure

```
PalindromeCheckerApp/
├── src/
│   └── PalindromeCheckerApp.java
├── Palindrome Checker App.iml
└── .gitignore
```

## Roadmap

- [ ] Implement core palindrome-checking algorithm
- [ ] Add input handling and validation
- [ ] Add unit tests
- [ ] Support numeric palindromes
- [ ] Add a simple UI (Swing or console menu)

## License

No license specified.
