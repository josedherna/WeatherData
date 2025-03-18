# Weather Data Analyzer
Weather Data Analyzer is a console based Java program that parses a CSV file (weatherdata.csv) containing weather data (Date, Temperature in Celsius, Humidity, Precipitation) and allows
the user to perform operations such as:
- Displaying the average temperature for a specific month, 
- Displaying the dates with temperatures above a given threshold
- Getting the count of rainy days
# Requirements
Java JDK 18 or above is necessary to run the program.
# Usage
Users will be prompted to enter a number in the console to perform an operation of the program.
- 0- Exit
- 1 - Show average temperature of a month
- 2 - Show days that are above a given temperature
- 3 - Show number of rainy days

The program will continue to run until the user exits it by entering 0 when given the list of choices again.

### Exit
- Stops the program.

### Show Average Temperature of a Month
1. Enter a month into the console as a number from 1 to 12
   - Where 1 represents January and 12 represents December
     
2. The average temperature of the given month will then be displayed

### Show Days That Are Above a Greater Temperature
1. Enter a number into the console
   - This number represents the minimum temperature that the dates' temperature must be higher than
     
2. The dates that have a temperature higher than the provided temperature will then be displayed

### Show Number of Rainy Days
1. The number of rainy days will then be displayed.
