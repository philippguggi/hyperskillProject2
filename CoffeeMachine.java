package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);
    static int amountOfWater = 400;
    static int amountOfMilk = 540;
    static int amountOfBeans = 120;
    static int amountOfCups = 9;
    static int amountOfMoney = 550;

    static void menu() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        switch (scanner.next()) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                remaining();
                break;
            case "exit":
                break;
            default:
                System.out.println("Enter correct command");
                menu();
        }
    }

    static void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(amountOfWater + " ml of water");
        System.out.println(amountOfMilk + " ml of milk");
        System.out.println(amountOfBeans + " g of coffee beans");
        System.out.println(amountOfCups + " of disposable cups");
        System.out.println(amountOfMoney + " € of money");
    }

    static void buy() {
        System.out.println("What do you want do buy?");
        System.out.println("1 - Espresso, 2 - Latte, 3 - Cappuccino, back - to main menu");
        switch (scanner.next()) {
            case "1":
                if (enoughResources(1).equals("I have enough resources, making you a coffee!")) {
                    System.out.println(enoughResources(1));
                    amountOfWater -= 250;
                    amountOfBeans -= 16;
                    amountOfCups -= 1;
                    amountOfWater += 4;
                    System.out.println();
                    menu();
                    break;
                } else {
                    System.out.println(enoughResources(1));
                    System.out.println();
                    menu();
                    break;
                }
            case "2":
                if (enoughResources(2).equals("I have enough resources, making you a coffee!")) {
                    System.out.println(enoughResources(2));
                    amountOfWater -= 350;
                    amountOfMilk -= 75;
                    amountOfBeans -= 20;
                    amountOfCups -= 1;
                    amountOfMoney += 7;
                    System.out.println();
                    menu();
                    break;
                } else {
                    System.out.println(enoughResources(2));
                    System.out.println();
                    menu();
                    break;
                }
            case "3":
                if (enoughResources(3).equals("I have enough resources, making you a coffee!")) {
                    System.out.println(enoughResources(3));
                    amountOfWater -= 200;
                    amountOfMilk -= 100;
                    amountOfBeans -= 12;
                    amountOfCups -= 1;
                    amountOfMoney += 6;
                    System.out.println();
                    menu();
                    break;
                } else {
                    System.out.println(enoughResources(3));
                    System.out.println();
                    menu();
                    break;
                }
            case "back":
                menu();
                break;
            default:
                System.out.println("Enter correct command");
                buy();

        }
    }

    static void fill() {
        System.out.println("Write how many ml of water do you want do add:");
        amountOfWater += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want do add:");
        amountOfMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee do you want do add:");
        amountOfBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want do add:");
        amountOfCups += scanner.nextInt();
    }

    static void take() {
        System.out.println("I gave you $" + amountOfMoney);
        amountOfMoney = 0;
        System.out.println();
        menu();
    }

    static String enoughResources(int coffee) {
        switch (coffee) {
            case 1:
                if (amountOfWater < 250) {
                    return "Sorry, not enough water!";
                } else if (amountOfBeans < 16) {
                    return "Sorry, not enough coffee beans!";
                } else if (amountOfCups == 0) {
                    return "Sorry, not enough cups!";
                } else {
                    return "I have enough resources, making you a coffee!";
                }
            case 2:
                if (amountOfWater < 350) {
                    return "Sorry, not enough water!";
                } else if (amountOfMilk < 75) {
                    return "Sorry, not enough milk!";
                } else if (amountOfBeans < 20) {
                    return "Sorry, not enough coffee beans!";
                } else if (amountOfCups == 0) {
                    return "Sorry, not enough cups!";
                } else {
                    return "I have enough resources, making you a coffee!";
                }
            case 3:
                if (amountOfWater < 200) {
                    return "Sorry, not enough water!";
                } else if (amountOfMilk < 100) {
                    return "Sorry, not enough milk!";
                } else if (amountOfBeans < 12) {
                    return "Sorry, not enough coffee beans!";
                } else if (amountOfCups == 0) {
                    return "Sorry, not enough cups!";
                } else {
                    return "I have enough resources, making you a coffee!";
                }

        }
        return "I have enough resources, making you a coffee!";
    }

    public static void main(String[] args) {
        menu();
    }
}

