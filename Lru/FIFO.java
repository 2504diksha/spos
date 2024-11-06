import java.util.*;

public class FIFO {
    static Scanner scanner = new Scanner(System.in);

    public void FIFOImplementation(int pages[], int capacity) {
        int pageFaults = 0;
        Queue<Integer> pageFrame = new LinkedList<>();
        HashSet<Integer> currentSet = new HashSet<>();

        // Table header
        System.out.println("\nPage\tPage Fault\tCurrent Page Frame");
        System.out.println("----------------------------------------");

        for (int page : pages) {
            boolean pageFaultOccurred = false;

            if (!currentSet.contains(page)) {
                if (currentSet.size() == capacity) {
                    int removedPage = pageFrame.poll();
                    currentSet.remove(removedPage);
                }
                currentSet.add(page);
                pageFrame.offer(page);
                pageFaults++;
                pageFaultOccurred = true;
            }

            // Printing the current page, fault status, and current page frame content
            System.out.print(page + "\t" + (pageFaultOccurred ? "Yes" : "No") + "\t\t");
            for (int p : pageFrame) System.out.print(p + " ");
            System.out.println();
        }

        System.out.println("----------------------------------------");
        System.out.println("Page Faults: " + pageFaults);
        int pageHits = pages.length - pageFaults;
        System.out.println("Page Hits: " + pageHits);
        System.out.println("Hit Ratio: " + pageHits + "/" + pages.length + " = " + (double) pageHits / pages.length);
    }

    public static void main(String[] args) {
        FIFO fifo = new FIFO();

        System.out.print("Enter capacity of page frame: ");
        int capacity = scanner.nextInt();

        System.out.print("Enter number of page sequence: ");
        int n = scanner.nextInt();

        int[] pages = new int[n];
        System.out.print("Enter values (space separated): ");
        for (int i = 0; i < n; i++) {
            pages[i] = scanner.nextInt();
        }

        fifo.FIFOImplementation(pages, capacity);
    }
}
