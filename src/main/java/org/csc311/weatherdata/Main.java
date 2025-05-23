package org.csc311.weatherdata;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * This class reads data from a csv that contains weather data and analyzes it.
 *
 * @author Jose Hernandez
 */
public class Main {
    /**
     * This method is the entry point to execute a Java program.
     *
     * @param args An array that contains strings of arguments received from command-line.
     */
    public static void main(String[] args) throws IOException {
        List<csvWeatherData> data;
        URL csvFile = Main.class.getClassLoader().getResource("weatherdata.csv");
        if (csvFile != null) {
            Path path = new File(csvFile.getFile()).toPath();
            data = readCSVFile(path);

            int choice = 0;
            Scanner input = new Scanner(System.in);
            do {
                System.out.println("Select one of the following options by entering a number from the list:");
                System.out.println("0- Exit");
                System.out.println("1 - Show average temperature of a month");
                System.out.println("2 - Show days that are above a given temperature");
                System.out.println("3 - Show number of rainy days");
                choice = input.nextInt();
                switch(choice) {
                    case 0 -> System.out.println("Sucessfully exited");
                    case 1 -> {
                        System.out.println("Enter a month as a number from 1 to 12");
                        int month = input.nextInt();
                        monthlyAverageTemperature(month, data);
                    }
                    case 2 -> {
                        System.out.println("Enter a minimum temperature");
                        double minTemp = input.nextDouble();
                        temperaturesAbove(minTemp, data);
                    }
                    case 3 -> {
                        countRainyDays(data);
                    }
                    default -> System.out.println("Invalid choice");
                }
            }
            while (choice != 0);
        }
        else {
            System.out.println("No weather data found");
        }
    }

    /**
     * This is a record containing weather data.
     *
     * @param date The date of the weather data.
     * @param temp The temperature in Celsius of a specific date.
     * @param humidity The humidity of a specific date.
     * @param precipitation The amount of precipitation of a specific date.
     */
    public record csvWeatherData(LocalDate date, double temp, int humidity, double precipitation, String category) {
    }

    /**
     * This method reads weather data from a CSV File, parses it and adds a new csvWeatherData record
     * to a list.
     *
     * @param filePath The path to the CSV file.
     * @return A list containing records of csvWeatherData.
     * @throws IOException Throws exception if the CSV file is not found.
     */
    public static List<csvWeatherData> readCSVFile(Path filePath) throws IOException {
        return Files.lines(filePath)
                .skip(1)
                .map(Main::parseWeatherData)
                .collect(Collectors.toList());
    }

    /**
     * This method parses a line from a CSV file to get weather data.
     *
     * @param data The line where the data from the CSV file will be parsed.
     * @return A new csvWeatherData record.
     */
    public static csvWeatherData parseWeatherData(String data) {
        String[] fields = data.split(",");
        LocalDate date = LocalDate.parse(fields[0]);
        double temperature = Double.parseDouble(fields[1]);
        String category = weatherCategory(temperature);
        int humidity = Integer.parseInt(fields[2]);
        double precipitation = Double.parseDouble(fields[3]);
        return new csvWeatherData(date, temperature, humidity, precipitation, category);
    }

    /**
     * This method categorizes weather data based on the temperature.
     *
     * @param temp The temperature whose category is to be evaluated.
     * @return The category of a weather data.
     */
    public static String weatherCategory(double temp) {
        return switch ((int) temp) {
            case 26, 27, 28, 29, 30, 31, 32, 33, 34, 35 -> "Hot";
            case 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 -> "Warm";
            case -1, -2, -3, -4, -5, -6, -7, -8, -9, -10, -11, -12, -13, -14, -15, -16, -17, -18, -19, -20, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 -> "Cold";
            default -> "Unknown";
        };
    }

    /**
     * This method counts the amount of rainy days based on the weather data from the CSV file where the precipitation
     * value is greater than 0.
     *
     * @param data The list containing records of weather data.
     */
    public static void countRainyDays(List<csvWeatherData> data) {
        int count = 0;
        for (csvWeatherData d : data) {
            if (d.precipitation() > 0) {
                count++;
            }
        }
        String output = """
                [Rainy Days]
                Based on the data from the weatherdata.csv file,
                
                There are %s rainy days in the weatherdata.csv file.
                """.formatted(count);
        System.out.println(output);
    }

    /**
     * This method calculates the average temperature of a given month.
     *
     * @param monthNumber The month that the average temperature will be calculated.
     * @param data The list containing records of weather data.
     */
    public static void monthlyAverageTemperature(int monthNumber, List<csvWeatherData> data) {
        double sum = 0;
        double average = 0;
        String month = "";
        int count = 0;

        switch (monthNumber) {
            case 1 -> {
                month = "JANUARY";
                for (csvWeatherData fullDate : data) {
                    if (Objects.equals(fullDate.date.getMonth().toString(), month)) {
                        sum += fullDate.temp();
                        count++;
                    }
                }
            }
            case 2 -> {
                month = "FEBRUARY";
                for (csvWeatherData fullDate : data) {
                    if (Objects.equals(fullDate.date.getMonth().toString(), month)) {
                        sum += fullDate.temp();
                        count++;
                    }
                }
            }
            case 3 -> {
                month = "MARCH";
                for (csvWeatherData fullDate : data) {
                    if (Objects.equals(fullDate.date.getMonth().toString(), month)) {
                        sum += fullDate.temp();
                        count++;
                    }
                }
            }
            case 4 -> {
                month = "APRIL";
                for (csvWeatherData fullDate : data) {
                    if (Objects.equals(fullDate.date.getMonth().toString(), month)) {
                        sum += fullDate.temp();
                        count++;
                    }
                }
            }
            case 5 -> {
                month = "MAY";
                for (csvWeatherData fullDate : data) {
                    if (Objects.equals(fullDate.date.getMonth().toString(), month)) {
                        sum += fullDate.temp();
                        count++;
                    }
                }
            }
            case 6 -> {
                month = "JUNE";
                for (csvWeatherData fullDate : data) {
                    if (Objects.equals(fullDate.date.getMonth().toString(), month)) {
                        sum += fullDate.temp();
                        count++;
                    }
                }
            }
            case 7 -> {
                month = "JULY";
                for (csvWeatherData fullDate : data) {
                    if (Objects.equals(fullDate.date.getMonth().toString(), month)) {
                        sum += fullDate.temp();
                        count++;
                    }
                }
            }
            case 8 -> {
                month = "AUGUST";
                for (csvWeatherData fullDate : data) {
                    if (Objects.equals(fullDate.date.getMonth().toString(), month)) {
                        sum += fullDate.temp();
                        count++;
                    }
                }
            }
            case 9 -> {
                month = "SEPTEMBER";
                for (csvWeatherData fullDate : data) {
                    if (Objects.equals(fullDate.date.getMonth().toString(), month)) {
                        sum += fullDate.temp();
                        count++;
                    }
                }
            }
            case 10 -> {
                month = "OCTOBER";
                for (csvWeatherData fullDate : data) {
                    if (Objects.equals(fullDate.date.getMonth().toString(), month)) {
                        sum += fullDate.temp();
                        count++;
                    }
                }
            }
            case 11 -> {
                month = "NOVEMBER";
                for (csvWeatherData fullDate : data) {
                    if (Objects.equals(fullDate.date.getMonth().toString(), month)) {
                        sum += fullDate.temp();
                        count++;
                    }
                }
            }
            case 12 -> {
                month = "DECEMBER";
                for (csvWeatherData fullDate : data) {
                    if (Objects.equals(fullDate.date.getMonth().toString(), month)) {
                        sum += fullDate.temp();
                        count++;
                    }
                }
            }
            default -> {
                System.out.println("Invalid month number");
                return;
            }
        }

        average = sum/count;

        String output = """
                [Average Temperature]
                Based on the data from the weatherdata.csv file,
                
                The average temperature in %s is,
                %f Celsius.
                """.formatted(month,average);
        
        System.out.println(output);
    }

    /**
     * This method shows the dates that are higher than a given temperature.
     *
     * @param tempThreshold The minimum temperature
     * @param data The list containing records of weather data.
     */
    public static void temperaturesAbove(double tempThreshold, List<csvWeatherData> data) {
        StringBuilder dates = new StringBuilder();
        for (csvWeatherData datum : data) {
            if (datum.temp() > tempThreshold) {
                dates.append(datum.date()).append("\n");
            }
        }

        String output = """
                [Temperatures Above]
                Based on the data from the weatherdata.csv file,
                
                The dates with temperatures about %f Celsius are,
                %s
                """.formatted(tempThreshold,dates);

        System.out.println(output);
    }
}