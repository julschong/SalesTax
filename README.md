# SalesTaxCalculator

SalesTaxCalculator is a CLI tool that lets users input item, quantity, and price to generate order receipt with Sales Tax and Total Amount printed.

## Installation

Please clone this repo: http://github.com/julschong/SalesTaxCalculator.git

The project's dependencies are managed by Maven using pom.xml in root directory.

To run the program in development in IDE, Open the root directory using IDE and locate ```./src/main/java/Main.java``` and run the main method.

To run executable in the terminal from out directory, cd into ```./out/artifacts/SalesTaxCalculator/SalesTax.jar``` in the terminal and run:

```java -jar SalesTax.jar```

Make sure java is installed and is in the system Path.
The program is tested using openjdk version "11.0.11" 2021-04-20 LTS

## Usage

Once started, the app will enter inifinite loop to ask for user input

User input has 2 kinds:
1. Menu commands
  - exit or quit: exit the program
  - restart: restart with new empty order
  - print: print receipt for current order
  - menu: bring up menu again
  - view: view current order items
2. Add Item
  - Format: {Quantity} {Item Name} at {Unit Price}
  - when this format is detected, the program will add it into current order

## Class Diagram
<img src="https://github.com/julschong/SalesTaxCalculator/blob/master/Sales%20Tax%20Calculator.png" alt="class diagram"/>

## License
[MIT](https://choosealicense.com/licenses/mit/)
