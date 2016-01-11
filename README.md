# Sorting algorithms

Java implementations of various sorting algorithms.

## Selection sort

Uses ~N<sup>2</sup>/2 compares and N exchanges to sort an array of length N.

## Insertion sort

Uses ~N<sup>2</sup>/4 compares and ~N<sup>2</sup>/4 exchanges to
sort a randomly ordered array of length N with distinct keys, on average.

Improved version uses sentinel and half exchanges to reduce data movement.

## Shell sort

Uses ~N<sup>3/2</sup> compares with the Knuth's increment sequence (3x+1). An
extension of insertion sort that uses long distance exchanges to produce
partially ordered arrays, which can be more efficiently sorted with insertion
sort.

## Merge sort

Uses between 1/2 N log N and N log N compares to sort an array of length N.

Improved version uses insertion sort for small subarrays, tests for ordered
array and optimizes time taken to copy temp arrays.

Bottom-up version does not use recursion.

## Examples

Build a jar file:

    $ ./gradlew assemble

Compare average running time using a randomly generated array of 10000 integers
and 50 test repetitions for each algorithm:

    $ java -cp build/libs/sorting.jar Compare 10000 50

    Built-in     0.0042s
    Selection    0.2270s
    Insertion    0.1065s
    InsertionX   0.0668s
    Shell        0.0019s
    Merge        0.0025s
    MergeX       0.0018s
    MergeB       0.0022s

Compare average running time using a randomly generated array of 1000000
integers and 50 test repetitions for each, non-quadratic algorithm:

    $ java -cp build/libs/sorting.jar Compare 1000000 50 noquad

    Built-in     0.2526s
    Shell        0.9120s
    Merge        0.2665s
    MergeX       0.2363s
    MergeB       0.3224s
