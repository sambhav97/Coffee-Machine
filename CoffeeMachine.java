package machine;

import java.util.*;

public class CoffeeMachine {

    public static void displayMachine(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water", water);
        System.out.printf("\n%d of milk", milk);
        System.out.printf("\n%d of coffee beans", coffeeBeans);
        System.out.printf("\n%d of disposable cups", disposableCups);
        System.out.printf("\n$%d of money\n", money);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int water = 400;
        int milk = 540;
        int coffeeBeans = 120;
        int disposableCups = 9;
        int money = 550;
        boolean flag = true;

        do {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();
            System.out.println(" ");

            switch (action) {
                case "buy": System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String coffeeType = scanner.nextLine();
                    if (coffeeType.equals("1")) {
                        if (water >= 250 && coffeeBeans >= 16 && disposableCups >= 1) {
                            System.out.println("I have enough resources, making you a coffee!");
                            water -= 250;
                            coffeeBeans -= 16;
                            money += 4;
                            disposableCups -= 1;
                        } else {
                            String s = (water < 250) ? "water" : (coffeeBeans < 16) ? "coffee beans" : "disposable cups";
                            System.out.printf("\nSorry, not enough %s!", s);
                        }
                    } else if (coffeeType.equals("2")) {
                        if (water >= 350 && milk >= 75 && coffeeBeans >= 20 && disposableCups >= 1) {
                            System.out.println("I have enough resources, making you a coffee!");
                            water -= 350;
                            milk -= 75;
                            coffeeBeans -= 20;
                            money += 7;
                            disposableCups -= 1;
                        } else {
                            String s = (water < 350) ? "water" : (milk < 75) ? "milk" : (coffeeBeans < 20) ? "coffee beans" : "disposable cups";
                            System.out.printf("\nSorry, not enough %s!", s);
                        }
                    } else if (coffeeType.equals("3")) {
                        if (water >= 200 && milk >= 100 && coffeeBeans >= 12 && disposableCups >= 1) {
                            System.out.println("I have enough resources, making you a coffee!");
                            water -= 200;
                            milk -= 100;
                            coffeeBeans -= 12;
                            money += 6;
                            disposableCups -= 1;
                        } else {
                            String s = (water < 200) ? "water" : (milk < 100) ? "milk" : (coffeeBeans < 12) ? "coffee beans" : "disposable cups";
                            System.out.printf("\nSorry, not enough %s!", s);
                        }
                    }
                    break;
                case "fill": System.out.println("Write how many ml of water do you want to add:");
                    water += scanner.nextInt();
                    System.out.println("Write how many ml of milk do you want to add:");
                    milk += scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    coffeeBeans += scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    disposableCups += scanner.nextInt();
                    break;
                case "take": System.out.printf("\nI gave you $%d", money);
                    money = 0;
                    break;
                case "remaining": displayMachine(water, milk, coffeeBeans, disposableCups, money);
                    break;
                case "exit": flag = false;
                    break;
            }
        } while (flag);
    }
}
