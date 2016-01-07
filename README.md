# Sorting algorithms

Java implementations of various sorting algorithms.

## Selection sort

Uses ~N<sup>2</sup>/2 compares and N exchanges to sort an array of length N.

## Insertion sort

Uses ~N<sup>2</sup>/4 compares and ~N<sup>2</sup>/4 exchanges to
sort a randomly ordered array of length N with distinct keys, on average.

## Shell sort

Uses ~N<sup>3/2</sup> compares with the Knuth's increment sequence (3x+1). An
extension of insertion sort that uses long distance exchanges to produce
partially ordered arrays, which can be more efficiently sorted with insertion
sort.

## Examples

Build a jar file:

    $ ./gradlew assemble

Compare average running time using a randomly generated array of 10000 integers
and 50 test repetitions for each algorithm:

    $ java -cp build/libs/sorting.jar Compare 10000 50

    Built-in     0.0043s
    Selection    0.2233s
    Insertion    0.1042s
    InsertionX   0.0651s
    Shell        0.0019s
