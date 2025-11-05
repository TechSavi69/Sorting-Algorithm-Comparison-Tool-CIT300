import java.util.Scanner;
import java.util.Random;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int[] currentArray = null;
    private static BubbleSort bubbleSort = new BubbleSort();
    private static MergeSort mergeSort = new MergeSort();
    private static QuickSort quickSort = new QuickSort();
    private static PerformanceMetrics metrics = new PerformanceMetrics();
    
    public static void main(String[] args) {
        showMenu();
    }
    
    public static void showMenu() {
        while (true) {
            System.out.println("\n--- Data Sorter: Sorting Algorithm Comparison Tool ---");
            System.out.println("1. Enter numbers manually");
            System.out.println("2. Generate random numbers");
            System.out.println("3. Perform Bubble Sort");
            System.out.println("4. Perform Merge Sort");
            System.out.println("5. Perform Quick Sort");
            System.out.println("6. Compare all algorithms (show performance table)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1:
                        enterNumbersManually();
                        break;
                    case 2:
                        generateRandomNumbers();
                        break;
                    case 3:
                        performBubbleSort();
                        break;
                    case 4:
                        performMergeSort();
                        break;
                    case 5:
                        performQuickSort();
                        break;
                    case 6:
                        compareAllAlgorithms();
                        break;
                    case 7:
                        System.out.println("Exiting... Thank you for using Data Sorter!");
                        return;
                    default:
                        System.out.println("Invalid choice! Please enter 1-7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    private static void enterNumbersManually() {
        System.out.print("Enter numbers separated by spaces: ");
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");
        
        currentArray = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            currentArray[i] = Integer.parseInt(numbers[i].trim());
        }
        
        System.out.println("Array stored successfully!");
        System.out.print("Current array: ");
        PerformanceMetrics.displayArray(currentArray);
    }
    
    private static void generateRandomNumbers() {
        System.out.print("Enter array size: ");
        int size = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter minimum value: ");
        int min = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter maximum value: ");
        int max = Integer.parseInt(scanner.nextLine());
        
        currentArray = PerformanceMetrics.generateRandomArray(size, min, max);
        System.out.println("Random array generated successfully!");
        System.out.print("Current array: ");
        PerformanceMetrics.displayArray(currentArray);
    }
    
    private static void performBubbleSort() {
        if (currentArray == null) {
            System.out.println("Please generate or enter an array first!");
            return;
        }
        
        int[] arrayCopy = currentArray.clone();
        System.out.println("\n--- Bubble Sort ---");
        System.out.print("Original array: ");
        PerformanceMetrics.displayArray(arrayCopy);
        
        metrics.startTimer();
        int[] sortedArray = bubbleSort.sort(arrayCopy);
        metrics.stopTimer();
        
        System.out.print("Sorted array: ");
        PerformanceMetrics.displayArray(sortedArray);
        System.out.println("Time taken: " + metrics.getElapsedTime() + " nanoseconds");
        System.out.println("Steps taken: " + bubbleSort.getStepCount());
    }
    
    private static void performMergeSort() {
        if (currentArray == null) {
            System.out.println("Please generate or enter an array first!");
            return;
        }
        
        int[] arrayCopy = currentArray.clone();
        System.out.println("\n--- Merge Sort ---");
        System.out.print("Original array: ");
        PerformanceMetrics.displayArray(arrayCopy);
        
        metrics.startTimer();
        int[] sortedArray = mergeSort.sort(arrayCopy);
        metrics.stopTimer();
        
        System.out.print("Sorted array: ");
        PerformanceMetrics.displayArray(sortedArray);
        System.out.println("Time taken: " + metrics.getElapsedTime() + " nanoseconds");
        System.out.println("Steps taken: " + mergeSort.getStepCount());
    }
    
    private static void performQuickSort() {
        if (currentArray == null) {
            System.out.println("Please generate or enter an array first!");
            return;
        }
        
        int[] arrayCopy = currentArray.clone();
        System.out.println("\n--- Quick Sort ---");
        System.out.print("Original array: ");
        PerformanceMetrics.displayArray(arrayCopy);
        
        metrics.startTimer();
        int[] sortedArray = quickSort.sort(arrayCopy);
        metrics.stopTimer();
        
        System.out.print("Sorted array: ");
        PerformanceMetrics.displayArray(sortedArray);
        System.out.println("Time taken: " + metrics.getElapsedTime() + " nanoseconds");
        System.out.println("Steps taken: " + quickSort.getStepCount());
    }
    
    private static void compareAllAlgorithms() {
        if (currentArray == null) {
            System.out.println("Please generate or enter an array first!");
            return;
        }
        
        System.out.println("\n--- Algorithm Performance Comparison ---");
        System.out.print("Dataset: ");
        PerformanceMetrics.displayArray(currentArray);
        System.out.println("Dataset size: " + currentArray.length + " elements");
        System.out.println();
        
        // Test Bubble Sort
        int[] bubbleArray = currentArray.clone();
        long bubbleStart = System.nanoTime();
        bubbleSort.sort(bubbleArray);
        long bubbleTime = System.nanoTime() - bubbleStart;
        long bubbleSteps = bubbleSort.getStepCount();
        
        // Test Merge Sort
        int[] mergeArray = currentArray.clone();
        long mergeStart = System.nanoTime();
        mergeSort.sort(mergeArray);
        long mergeTime = System.nanoTime() - mergeStart;
        long mergeSteps = mergeSort.getStepCount();
        
        // Test Quick Sort
        int[] quickArray = currentArray.clone();
        long quickStart = System.nanoTime();
        quickSort.sort(quickArray);
        long quickTime = System.nanoTime() - quickStart;
        long quickSteps = quickSort.getStepCount();
        
        // Display comparison table
        System.out.println("+-----------------+------------------+-----------------+");
        System.out.println("| Algorithm       | Time (ns)        | Steps           |");
        System.out.println("+-----------------+------------------+-----------------+");
        System.out.printf("| Bubble Sort     | %-16d | %-15d |\n", bubbleTime, bubbleSteps);
        System.out.printf("| Merge Sort      | %-16d | %-15d |\n", mergeTime, mergeSteps);
        System.out.printf("| Quick Sort      | %-16d | %-15d |\n", quickTime, quickSteps);
        System.out.println("+-----------------+------------------+-----------------+");
        
        // Determine fastest algorithm
        String fastest = "Bubble Sort";
        long minTime = bubbleTime;
        
        if (mergeTime < minTime) {
            minTime = mergeTime;
            fastest = "Merge Sort";
        }
        if (quickTime < minTime) {
            fastest = "Quick Sort";
        }
        
        System.out.println("Fastest algorithm: " + fastest);
    }
}