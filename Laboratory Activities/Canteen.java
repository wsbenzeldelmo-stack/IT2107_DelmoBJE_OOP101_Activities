import java.util.Scanner;

public class Canteen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int totalItems = 0;
        double totalBeforeDiscount = 0;
        double totalDiscount = 0;
        double finalAmount = 0;
        char orderAgain;

        do {
            System.out.println("=====   M E N U   =====");
            System.out.println("1. Burger     - P80.00");
            System.out.println("2. Pizza      - P120.00");
            System.out.println("3. Pasta      - P100.00");
            System.out.println("4. Sandwich   - P70.00");
            System.out.println("5. Milk Tea   - P90.00");

            System.out.print("Enter item number: ");
            int itemNumber = input.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();

            boolean validOrder = itemNumber >= 1 && itemNumber <= 5
                    && quantity >= 1 && quantity <= 10;

            if (validOrder) {
                System.out.print("Are you a student? (Y/N): ");
                char student = input.next().toUpperCase().charAt(0);

                double price;
                switch (itemNumber) {
                    case 1:
                        price = 80;
                        break;
                    case 2:
                        price = 120;
                        break;
                    case 3:
                        price = 100;
                        break;
                    case 4:
                        price = 70;
                        break;
                    default:
                        price = 90;
                        break;
                }

                double subtotal = price * quantity;
                double discountRate;

                if (student == 'Y' && subtotal >= 500) {
                    discountRate = 0.15;
                } else if (student == 'Y') {
                    discountRate = 0.10;
                } else if (subtotal >= 500) {
                    discountRate = 0.05;
                } else {
                    discountRate = 0;
                }

                double discount = subtotal * discountRate;
                double orderTotal = subtotal - discount;

                System.out.printf("\nSubtotal: P%.2f%n", subtotal);
                System.out.printf("Discount: P%.2f%n", discount);
                System.out.printf("Order total: P%.2f%n", orderTotal);

                totalItems += quantity;
                totalBeforeDiscount += subtotal;
                totalDiscount += discount;
                finalAmount += orderTotal;
            } else {
                System.out.println("\nInvalid order! Please enter a valid item and quantity.");
            }

            System.out.print("\nDo you want to order again? (Y/N): ");
            orderAgain = input.next().toUpperCase().charAt(0);
        } while (orderAgain == 'Y');

        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println("Total items: " + totalItems);
        System.out.printf("Total before discount: P%.2f%n", totalBeforeDiscount);
        System.out.printf("Total discount: P%.2f%n", totalDiscount);
        System.out.printf("Final amount: P%.2f%n", finalAmount);
        System.out.println("Thank you for ordering!");

        input.close();
    }
}
