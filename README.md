# LSEGcodingChallengeJanuary



A lightshow at events is formed of a large display of one million lights in a 1000x1000 grid.
Customers provide instructions on how they want the lights to be turned on during the event.

The lights are numbered from 0 to 999 in each direction, identified by a pair of coordinates.
All lights start turned off.

The program reads a sequence of instructions from the attached input file,
then calculates how many lights are on at the end.

There are three types of instructions: "turn on", "turn off", and "toggle", followed by a coordinate
range.

The code is written in Java, including unit tests with JUnit5, and doesn't use the Spring Framework. 

It reads the input file in the res directory, and prints the number of lights on at the end.
