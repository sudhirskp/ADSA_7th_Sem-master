package Heap;

public class MaxHeap {
    int size;
    int[] arr;
    int index;

    MaxHeap(int size) {
        this.size = size;
        arr = new int[size];
        this.index = 0;
    }

    int parent(int index) {
        return (index - 1) / 2;
    }

    int left(int index) {
        return 2 * index + 1;
    }

    int right(int index) {
        return 2 * index + 2;
    }

    void insert(int data) {
        if (index >= size) {
            System.out.println("The Heap is Full");
            return;
        }
        arr[index] = data;
        System.out.println("Element Inserted at index " + index + " : " + data);

        int current = index;
        while (current > 0 && arr[current] > arr[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        index++;
    }

    int top() {
        if (index == 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        return arr[0];
    }

    void delete() {
        if (index <= 0) {
            System.out.println("Heap is Empty");
            return;
        }

        System.out.println("Element Deleted from top: " + arr[0]);
        swap(0, index - 1);
        index--;
        heapify(0);
    }

    void heapify(int i) {
        int left = left(i);
        int right = right(i);
        int largest = i;

        if (left < index && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < index && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    void display() {
        for (int i = 0; i < index; i++) {
            System.out.println("Heap Element: " + arr[i]);
        }
        System.out.println();
    }

    void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        MaxHeap obj = new MaxHeap(6);

        obj.insert(10);
        obj.insert(50);
        obj.insert(60);
        obj.insert(90);
        obj.insert(30);
        obj.insert(40);
        obj.display();
        obj.delete();
        obj.display();
    }
}