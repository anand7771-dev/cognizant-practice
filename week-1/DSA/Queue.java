package dsa;

public class Queue {

    int arr[] = new int[5];
    int front = 0;
    int rear = -1;

    void enqueue(int data) {
        rear++;
        arr[rear] = data;
    }

    void dequeue() {
        System.out.println("Removed: " + arr[front]);
        front++;
    }

    void display() {

        for(int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Queue q = new Queue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        q.dequeue();

        q.display();
    }
}