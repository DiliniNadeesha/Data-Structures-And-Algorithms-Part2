import java.util.Scanner;

public class StackDemo {

    public static int[] stack = new int[0];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            printStack();
            System.out.println("Enter an option: ");
            System.out.println("A. Push");
            System.out.println("B. Pop");
            System.out.println("C. Exit");
            System.out.print("> ");
            String option = scanner.next();
            switch (option) {
                case "A":
                    System.out.print("Enter the value: ");
                    int value = scanner.nextInt();
                    push(value);
                    break;
                case "B":
                    pop();
                    break;
                case "C":
                    System.exit(0);
                default:
                    System.out.println("Invalid option, please try again");
            }
        }
    }

    public static void push(int value){
        int[] tempStack = new int[stack.length + 1];
        for (int i = 0; i < stack.length; i++) {
            tempStack[i] = stack[i];
        }
        tempStack[tempStack.length - 1] = value;
        stack = tempStack;
    }

    public static void pop(){
        if (stack.length == 0){
            return;
        }
        int[] tempStack = new int[stack.length - 1];
        for (int i = 0; i < stack.length -1; i++) {
            tempStack[i] = stack[i];
        }
        stack = tempStack;
    }

    public static void printStack(){
        for (int i = stack.length-1; i >=0; i--) {
            System.out.println("----");
            System.out.println("|" + stack[i] + "|");
        }
    }

}
