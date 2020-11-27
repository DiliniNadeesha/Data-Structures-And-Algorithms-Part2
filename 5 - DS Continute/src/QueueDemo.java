import java.util.Scanner;

public class QueueDemo {

    public static int[] queue = new int[]{};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            printQueue();
            System.out.println("Enter an option: ");
            System.out.println("A. Enqueue");
            System.out.println("B. Dequeue");
            System.out.println("C. Exit");
            System.out.print("> ");
            String option = scanner.next();
            switch (option) {
                case "A":
                    System.out.print("Enter the value: ");
                    int value = scanner.nextInt();
                    enqueue(value);
                    break;
                case "B":
                    dequeue();
                    break;
                case "C":
                    System.exit(0);
                default:
                    System.out.println("Invalid option, please try again");
            }
        }
    }

    public static void printQueue() {
        for (int i = queue.length - 1; i >=0 ; i--) {
            System.out.print("|" + queue[i] + "|");
        }
        System.out.println();
    }

    public static void enqueue(int value) {
        int[] tempQueue = new int[queue.length + 1];
        for (int i = 0; i < queue.length; i++) {
            tempQueue[i] = queue[i];
        }
        tempQueue[tempQueue.length - 1] = value;
        queue = tempQueue;
    }

    public static void dequeue() {
        if (queue.length == 0){
            return;
        }
        int[] tempQueue = new int[queue.length - 1];
        for (int i = 1; i < queue.length; i++) {
            tempQueue[i-1] = queue[i];
        }
        queue = tempQueue;
    }
}
