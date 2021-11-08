# sudoku-solver-java
Java code for solving sudoku

# Algorithm
1. Find an empty slot
2. If the slot is outside the matrix, return true
3. Iterate numbers 1-9 and check if the num can be placed in the empty slot
4. If valid, assign that num in the above slot
5. Recurse
6. If no numbers can be filled in step num 3, backtrack
