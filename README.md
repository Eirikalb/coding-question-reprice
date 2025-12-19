# Anagram Finder

A Kotlin program that finds all words in a word list that have one or more anagrams.

## Problem Description

The attached file (eventyr.txt) is a word list with one word per line.
The task consists in creating a program in Kotlin that finds all words in the list that have one or
more anagrams (from the same file), and that lists these together with the original word. Note
that not all words have anagrams. You should only find one-word anagrams.

An anagram is a word or phrase that is put together by shuffling the letters of another word or
phrase (http://en.wikipedia.org/wiki/Anagram).

Each line in the result must contain the words that are anagrams of each other.

## Solution

The solution uses a simple and efficient algorithm:

1. Read all words from the file
2. For each word, create a "canonical key" by sorting its characters alphabetically
3. Group words by their canonical key - words with the same key are anagrams
4. Filter to only include groups with 2+ words (i.e., words that have anagrams)
5. Output each group on a single line

### Time Complexity

- O(n * k log k) where n is the number of words and k is the average word length
- The sorting of characters for each word is the dominant operation

### Space Complexity

- O(n * k) for storing the words and their keys in the map

## Prerequisites

- JDK 21
- Gradle 9.x

## Building and Running

### Using Gradle

```bash
gradle run
```

### Using Kotlin compiler directly

```bash
kotlinc src/main/kotlin/AnagramFinder.kt -include-runtime -d anagram.jar
java -jar anagram.jar eventyr.txt
```

## Running Tests

```bash
gradle test
```

## Example Output

```
at ta
bar bra
dem med
dro ord rod
hellestein steinhelle
...
```

## Project Structure

```
├── build.gradle.kts          # Gradle build configuration
├── eventyr.txt               # Input word list
├── src/
│   ├── main/kotlin/
│   │   └── AnagramFinder.kt  # Main application
│   └── test/kotlin/
│       └── AnagramFinderTest.kt  # Unit tests
└── README.md
```
