#!/bin/bash
javac -d ./bin $(find ./src/ram/* | grep .java)
java -cp ./bin ram.Ram $1 ./input_tape.in ./output_tape.out $2