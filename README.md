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

## Quick sort

Uses ~2 N log N compares on average to sort an array of length N with distinct
keys and ~N<sup>2</sup>/2 compares in the worst case (very unlikely due to
random shuffling).

Improved version uses insertion sort for small subarrays, median of small
sample as a partitioning item and fast 3-way partitioning.

3-way version partitions the array into three parts to reduce the time of sort
for arrays with large number of duplicates.

## Heap sort

Uses fewer than 2N log N + 2N compares and half that many exchanges to sort N
items. The 2N term covers the cost of heap construction.

## Examples

Build a jar file:

    $ ./gradlew assemble

Compare average running time using a randomly generated array of 10000 integers
(ranged 1 to 10000) and 50 trials for each algorithm:

    $ java -cp build/libs/sorting.jar Compare -i 10000 -t 50

    Built-in     0.0047s
    Selection    0.2227s
    Insertion    0.1040s
    InsertionX   0.0653s
    Shell        0.0020s
    Merge        0.0025s
    MergeX       0.0019s
    MergeB       0.0025s
    Quick        0.0020s
    QuickX       0.0022s
    Quick3       0.0020s
    Heap         0.0018s

Compare average running time using a randomly generated array of 1000000
integers (ranged 1 to 1000000) and 50 trials for each, non-quadratic algorithm:

    $ java -cp build/libs/sorting.jar Compare -i 1000000 -t 50 -nq

    Built-in     0.2591s
    Shell        0.8473s
    Merge        0.2610s
    MergeX       0.2393s
    MergeB       0.3207s
    Quick        0.3479s
    QuickX       0.2251s
    Quick3       0.4726s
    Heap         0.5648s

Compare average running time using a randomly generated array of 10000000
integers (ranged 1 to 1000) and 50 trials for each, non-quadratic algorithm:

    $ java -cp build/libs/sorting.jar Compare -i 10000000 -b 1000 -t 50 -nq

    Built-in     2.0912s
    Shell        10.5695s
    Merge        2.9541s
    MergeX       2.6615s
    MergeB       3.5806s
    Quick        4.6508s
    QuickX       1.8853s
    Quick3       5.0418s
    Heap         6.2105s
