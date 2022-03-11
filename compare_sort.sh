#!/bin/bash
echo "InsertionSort"
java -cp ./bin ram.Ram ./src/test/insertion.ram ./input_tape.in ./output_tape.out 1
echo "BubbleSort"
java -cp ./bin ram.Ram ./src/test/bubbleSort.ram ./input_tape.in ./output_tape.out 1