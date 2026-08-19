import java.util.Scanner;

public class TripPlanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    
        System.out.println("Welcome to TripPlanner!");
        System.out.println("Let's get your road trip details ready.");

        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Hello, " + name + "! Let's plan your road trip.\n");

        // Get trip data from the user
        System.out.print("Enter the total distance to drive (in km): ");
        int distanceKm = scanner.nextInt();

        System.out.print("Enter the car's speed (in mph): ");
        int carSpeed = scanner.nextInt();

        System.out.print("Enter the car's fuel efficiency (in MPG): ");
        double fuelEfficiency = scanner.nextDouble();

        System.out.print("Enter the current gas price (per gallon, $): ");
        double gasPrice = scanner.nextDouble();

        //the calculations
        final double KM_TO_MILES = 0.621371;
        double distanceMiles = distanceKm * KM_TO_MILES;

        // Total fuel needed (gallons) 
        double totalFuelNeeded = distanceMiles / fuelEfficiency;

        // Total trip cost
        double totalTripCost = totalFuelNeeded * gasPrice;

        // Estimated driving time, assuming an average driving speed of 60 mph
        double drivingTimeHours = distanceMiles / carSpeed;

        // Convert decimal hours into whole hours and minutes using
        // casting (double -> int) and the remainder operator (%).
        int totalMinutes = (int) Math.round(drivingTimeHours * 60);
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;

        String summary = "\n===== Trip Summary for " + name + " =====" +
                "\nDistance:\t\t" + distanceKm + " km (" + String.format("%.1f", distanceMiles) + " miles)" +
                "\nCar Speed:\t\t" + carSpeed + " mph" +
                "\nFuel Efficiency:\t" + fuelEfficiency + " MPG" +
                "\nGas Price:\t\t$" + String.format("%.2f", gasPrice) + " per gallon" +
                "\n" +
                "\nTotal Fuel Needed:\t" + String.format("%.2f", totalFuelNeeded) + " gallons" +
                "\nTotal Trip Cost:\t$" + String.format("%.2f", totalTripCost) +
                "\nEstimated Time:\t\t" + hours + " hours and " + minutes + " minutes" +
                "\n=====================================\n";

        System.out.println(summary);

        scanner.close();
    }
}