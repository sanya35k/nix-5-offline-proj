package com.nix.hw.exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Application {

    private static final String CURRENT_YEAR = "2021";

    private static final List<Date> dateList = new ArrayList<>();

    private static final String DATE_FORMAT_1 = "dd/mm/yyyy hh:mm:ss";
    private static final String DATE_FORMAT_2 = "mm/dd/yyyy hh:mm:ss";
    private static final String DATE_FORMAT_3 = "dd-mm-yyyy hh:mm:ss";
    private static final String DATE_FORMAT_4 = "mm-dd-yyyy hh:mm:ss";

    private static String currentDatesPrintingFormat = DATE_FORMAT_1;

    private static final String ERROR_MESSAGE = "\nSomething gone wrong, try again";

    public static void launch() {
        while (true) {
            printMainMenu();
            int choice = correctIntInput("\nEnter the number: ");

            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    if (dateList.size()>1)
                        findDiff();
                    else
                        System.out.println("\nThere must be at least two dates");
                    break;
                case 3:
                    if (dateList.size()>0)
                        addTime();
                    else
                        System.out.println("\nThere must be at least one date");
                    break;
                case 4:
                    if (dateList.size()>0)
                        subtractTime();
                    else
                        System.out.println("\nThere must be at least one date");
                    break;
                case 5:
                    chooseDatesPrintingFormat();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }

    private static void create() {
        String dateCreationMenu = "\n1) " + DATE_FORMAT_1 + "\n" +
                                  "2) " + DATE_FORMAT_2 + "\n" +
                                  "3) " + DATE_FORMAT_3 + "\n" +
                                  "4) " + DATE_FORMAT_4 + "\n" +
                                  "5) Back to main menu";
        boolean flag = true;
        do {

            System.out.println(dateCreationMenu);
            int choice = correctIntInput("\nEnter the number: ");

            try {
                switch (choice) {
                    case 1:
                        addDate(DATE_FORMAT_1);
                        break;
                    case 2:
                        addDate(DATE_FORMAT_2);
                        break;
                    case 3:
                        addDate(DATE_FORMAT_3);
                        break;
                    case 4:
                        addDate(DATE_FORMAT_4);
                        break;
                    case 5:
                        flag = false;
                        break;
                }
            } catch (RuntimeException e) {
                System.out.println(ERROR_MESSAGE);
            }
        } while (flag);
    }

    private static void findDiff() {
        String findDiffMenu = "\nChoose dates";
        boolean flag;
        do {
            try {
                System.out.println(findDiffMenu);

                Date date1 = dateList.get(correctIntInput("Enter first date index: "));
                Date date2 = dateList.get(correctIntInput("Enter second date index: "));

                System.out.println(
                        "\nDifference in:" +
                        "\n   seconds: " + date1.findDiffInSec(date2) +
                        "\n   minutes: " + date1.findDiffInMins(date2) +
                        "\n   hours: " + date1.findDiffInHours(date2) +
                        "\n   days: " + date1.findDiffInDays(date2) +
                        "\n   months: " + date1.findDiffInMonths(date2) +
                        "\n   years: " + date1.findDiffInYears(date2)
                );

                flag =true;

            } catch (IndexOutOfBoundsException e) {
                System.out.println(ERROR_MESSAGE);
                flag = false;
            }
        } while (!flag);
    }

    private static void addTime() {
        boolean flag = false;
        do {

            try {
                Date date = null;
                System.out.println("\n1) Choose date\n2) Back");
                int choice = correctIntInput("\nEnter the number: ");
                switch (choice) {
                    case 1:
                        date = dateList.get(correctIntInput("Enter date index: "));
                        break;
                    case 2:
                        flag = true;
                        break;
                }

                if (flag)
                    break;

                System.out.println(
                        "\n1) Add seconds" +
                                "\n2) Add minutes" +
                                "\n3) Add hours" +
                                "\n4) Add days" +
                                "\n5) Add months" +
                                "\n6) Add years" +
                                "\n7) Back"
                );
                choice = correctIntInput("\nEnter the number: ");
                switch (choice) {
                    case 1:
                        date.addSeconds(correctIntInput("\nAdd seconds\nEnter the number: "));
                        System.out.println("\nChanged date: " + date);
                        break;
                    case 2:
                        date.addMinutes(correctIntInput("\nAdd minutes\nEnter the number: "));
                        System.out.println("\nChanged date: " + date);
                        break;
                    case 3:
                        date.addHours(correctIntInput("\nAdd hours\nEnter the number: "));
                        System.out.println("\nChanged date: " + date);
                        break;
                    case 4:
                        date.addDays(correctIntInput("\nAdd days\nEnter the number: "));
                        System.out.println("\nChanged date: " + date);
                        break;
                    case 5:
                        date.addMonths(correctIntInput("\nAdd months\nEnter the number: "));
                        System.out.println("\nChanged date: " + date);
                        break;
                    case 6:
                        date.addYears(correctIntInput("\nAdd years\nEnter the number: "));
                        System.out.println("\nChanged date: " + date);
                        break;
                    case 7:
                        flag = true;
                        break;

                }

            } catch (RuntimeException e) {
                System.out.println(ERROR_MESSAGE);
            }
        } while (!flag);
    }

    private static void subtractTime() {
        boolean flag = false;
        do {

            try {
                Date date = null;
                System.out.println("\n1) Choose date\n2) Back");
                int choice = correctIntInput("\nEnter the number: ");
                switch (choice) {
                    case 1:
                        date = dateList.get(correctIntInput("Enter date index: "));
                        break;
                    case 2:
                        flag = true;
                        break;
                }

                if (flag)
                    break;

                System.out.println(
                        "\n1) Subtract seconds" +
                                "\n2) Subtract minutes" +
                                "\n3) Subtract hours" +
                                "\n4) Subtract days" +
                                "\n5) Subtract months" +
                                "\n6) Subtract years" +
                                "\n7) Back"
                );
                choice = correctIntInput("\nEnter the number: ");
                switch (choice) {
                    case 1:
                        date.subtractSeconds(correctIntInput("\nSubtract seconds\nEnter the number: "));
                        System.out.println("\nChanged date: " + date);
                        break;
                    case 2:
                        date.subtractMinutes(correctIntInput("\nSubtract minutes\nEnter the number: "));
                        System.out.println("\nChanged date: " + date);
                        break;
                    case 3:
                        date.subtractHours(correctIntInput("\nSubtract hours\nEnter the number: "));
                        System.out.println("\nChanged date: " + date);
                        break;
                    case 4:
                        date.subtractDays(correctIntInput("\nSubtract days\nEnter the number: "));
                        System.out.println("\nChanged date: " + date);
                        break;
                    case 5:
                        date.subtractMonths(correctIntInput("\nSubtract months\nEnter the number: "));
                        System.out.println("\nChanged date: " + date);
                        break;
                    case 6:
                        date.subtractYears(correctIntInput("\nSubtract years\nEnter the number: "));
                        System.out.println("\nChanged date: " + date);
                        break;
                    case 7:
                        flag = true;
                        break;

                }

            } catch (RuntimeException e) {
                System.out.println(ERROR_MESSAGE);
            }
        } while (!flag);
    }

    private static void chooseDatesPrintingFormat() {
        String choiceFormatMenu = "\n1) " + DATE_FORMAT_1 + "\n" +
                "2) " + DATE_FORMAT_2 + "\n" +
                "3) " + DATE_FORMAT_3 + "\n" +
                "4) " + DATE_FORMAT_4 + "\n" +
                "5) Back to main menu";
        boolean flag = true;
        do {

            System.out.println(choiceFormatMenu);
            int choice = correctIntInput("Enter the number: ");

            if (choice < 1 || choice > 5)
                continue;

            switch (choice) {
                case 1:
                    currentDatesPrintingFormat = DATE_FORMAT_1;
                    break;
                case 2:
                    currentDatesPrintingFormat = DATE_FORMAT_2;
                    break;
                case 3:
                    currentDatesPrintingFormat = DATE_FORMAT_3;
                    break;
                case 4:
                    currentDatesPrintingFormat = DATE_FORMAT_4;
                    break;
                case 5:
                    break;
            }
            flag = false;

        } while (flag);
    }

    private static void addDate(String dateFormat) {
        System.out.println("\n" + dateFormat);
        String strDate = input("Enter the date: ");
        String separator = String.valueOf(dateFormat.charAt(2));
        int[] intDateParameters = parseDate(strDate, separator);
        Date date = null;

        if (dateFormat.equals(DATE_FORMAT_1) || dateFormat.equals(DATE_FORMAT_3))
            date = new Date(intDateParameters[2],
                                 intDateParameters[1],
                                 intDateParameters[0],
                                 intDateParameters[3],
                                 intDateParameters[4],
                                 intDateParameters[5]);

        else if (dateFormat.equals(DATE_FORMAT_2) || dateFormat.equals(DATE_FORMAT_4))
            date = new Date(intDateParameters[2],
                            intDateParameters[0],
                            intDateParameters[1],
                            intDateParameters[3],
                            intDateParameters[4],
                            intDateParameters[5]);

        System.out.println("created date: " + date);
        dateList.add(date);
        dateList.sort(Date::compareTo);
    }

    private static int[] parseDate(String input, String separator) {
        List<String> dmy;
        List<String> hms;

        int[] date = new int[6];

        input = input.trim();

        dmy = Arrays.asList(input.split(" ")[0].split(separator));

        if (dmy.size() > 1) {
            List<String> finalDmy = dmy;
            dmy.stream()
                    .limit(2)
                    .forEach(i -> {
                        if (i.equals("")) finalDmy.set(finalDmy.indexOf(i), "1");
                    });
            dmy = finalDmy;
            if (dmy.size() == 2) date[2] = Integer.parseInt(CURRENT_YEAR);
        }
        else if (dmy.size() == 1) {
            dmy = Arrays.asList("1", "1", dmy.get(0));
        } else {
            dmy = Arrays.asList("1", "1", CURRENT_YEAR);
        }


        List<String> finalDmy1 = dmy;
        if (finalDmy1.get(2).length()==2) {
            finalDmy1.set(2, "20" + finalDmy1.get(2));
        }
        IntStream
                .range(0, dmy.size())
                .forEach(i -> date[i] = Integer.parseInt(finalDmy1.get(i)));


        if (input.contains(":")) {
            hms = Arrays.asList(input.split(" ")[1].split(":"));
            hms.forEach(i -> {
                if (i.equals("")) hms.set(hms.indexOf(i), "0");
            });
            hms.forEach(i -> date[hms.indexOf(i) + 3] = Integer.parseInt(i));
        }

        return date;
    }

    private static void printMainMenu() {
        String choiceList = "\n1) create new date" +
                      "\n2) find difference" +
                      "\n3) add time" +
                      "\n4) subtract time" +
                      "\n5) choose dates printing format" +
                      "\n6) exit\n";

        System.out.println(choiceList + "\nSorted dates:");
        switch (currentDatesPrintingFormat) {
            case DATE_FORMAT_1:
                IntStream
                        .range(0, dateList.size())
                        .forEach(i -> System.out.println(i + ") " +
                                dateList.get(i).getDay() + "/" +
                                dateList.get(i).getMonth() + "/" +
                                dateList.get(i).getYear() + " " +
                                dateList.get(i).getHour() + ":" +
                                dateList.get(i).getMinute() + ":" +
                                dateList.get(i).getSecond()));
                break;
            case DATE_FORMAT_2:
                IntStream
                        .range(0, dateList.size())
                        .forEach(i -> System.out.println(i + ") " +
                                dateList.get(i).getMonth() + "/" +
                                dateList.get(i).getDay() + "/" +
                                dateList.get(i).getYear() + " " +
                                dateList.get(i).getHour() + ":" +
                                dateList.get(i).getMinute() + ":" +
                                dateList.get(i).getSecond()));
                break;

            case DATE_FORMAT_3:
                IntStream
                        .range(0, dateList.size())
                        .forEach(i -> System.out.println(i + ") " +
                                dateList.get(i).getDay() + "-" +
                                dateList.get(i).getMonth() + "-" +
                                dateList.get(i).getYear() + " " +
                                dateList.get(i).getHour() + ":" +
                                dateList.get(i).getMinute() + ":" +
                                dateList.get(i).getSecond()));
                break;

            case DATE_FORMAT_4:
                IntStream
                        .range(0, dateList.size())
                        .forEach(i -> System.out.println(i + ") " +
                                dateList.get(i).getMonth() + "-" +
                                dateList.get(i).getDay() + "-" +
                                dateList.get(i).getYear() + " " +
                                dateList.get(i).getHour() + ":" +
                                dateList.get(i).getMinute() + ":" +
                                dateList.get(i).getSecond()));
                break;
        }

    }

    private static int correctIntInput(String message) {
        int num;
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.print(message);
                num = Integer.parseInt(reader.readLine());
                break;
            } catch (IOException | NumberFormatException ignored) {
            }
        }
        return num;
    }

    private static String input(String message) {
        String output;
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.print(message);
                output = reader.readLine();
                break;
            } catch (IOException | NumberFormatException ignored) {
            }
        }
        return output;
    }


}