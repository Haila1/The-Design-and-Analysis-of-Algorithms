# The-Design-and-Analysis-of-Algorithms
 Text formating
In a software systems for document preparation such as MS Word or Latex, one routinely en- counters the balanced lines, with reference to the number of characters that can be put in one line. Where we want to balance empty spaces in lines so we do not have some lines with lots of extra spaces and other lines with small amount of extra spaces.
The input text is a sequence of n words of lengths l1,l2,...,ln. Assume that the length of each word is smaller than the line width, M. The goal is to print this paragraph in a number of lines that hold a maximum of M characters each while minimizing the sum, over all lines (except the last), of the cubes of the numbers of extra space characters at the ends of each line, which is calculated as follow:
Given a line with capacity of M characters, and contains words i through j, where i ≤ j M − j + i − P jk = i l k
Implement a Dynamic Programming algorithm to print an optimized paragraph then analyze the efficiency of your algorithm.
