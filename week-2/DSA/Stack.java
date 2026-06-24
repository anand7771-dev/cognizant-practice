package dsa;

public class Stack {

    int arr[] = new int[5];
    int top = -1;

    void push(int data) {
        top++;
        arr[top] = data;
    }

    void pop() {
        System.out.println("Removed: " + arr[top]);
        top--;
    }

    void peek() {
        System.out.println("Top Element: " + arr[top]);
    }

    public static void main(String[] args) {

        Stack s = new Stack();

        s.push(10);
        s.push(20);
        s.push(30);

        s.peek();

        s.pop();

        s.peek();
    }
}