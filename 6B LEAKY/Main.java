import java.util.Scanner;

public class Main {
    private int[] q;
    private int f = 0; // front
    private int r = 0; // rear
    private int maxSize; // maximum size of the queue

    public Main(int maxSize) {
        this.maxSize = maxSize;
        q = new int[maxSize];
    }

    public void insert(int n) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter element " + (i + 1) + ": ");
            int ele = in.nextInt();
            if (r >= maxSize) {
                System.out.println("\nQueue is full. Lost Packet: " + ele);
                break;
            } else {
                q[r] = ele;
                r++;
            }
        }
    }

    public void delete() {
        if (f == r) {
            System.out.println("\nQueue empty.");
        } else {
            System.out.println("\nLeaked Packets:");
            for (int i = f; i < r; i++) {
                System.out.print(q[i] + " ");
            }
            System.out.println();
            f = r; // Reset front to rear after deletion
        }
    }

    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);

        System.out.print("Enter the size of the queue: ");
        int size = src.nextInt();
        Main q = new Main(size);

        System.out.print("\nEnter the number of packets to be sent: ");
        int packets = src.nextInt();
        q.insert(packets);

        System.out.println();
        q.delete();

        src.close(); // Close the scanner
    }
}
