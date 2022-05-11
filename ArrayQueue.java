//referenced my notes from class to write this code
public class ArrayQueue implements Queue {
    protected int capacity;
    public static final int CAPACITY = 10; // setting limit of array to 10

    protected String[] Q;
    protected int head;
    protected int tail;
    protected int size;

    public ArrayQueue() {
        capacity = CAPACITY;
        Q = new String[capacity];
        head = -1;
        tail = -1;
        size = 0;
    }

    public ArrayQueue(int capacity){
        if (capacity <= 0) {
            return;
        }
        this.capacity = capacity;
        Q = new String[capacity];
        head = -1;
        tail = -1;
        size = 0;
    }

    public int size() {
        return size;
    }

    public String front() {
        if (size == 0) {
            return null;
        }
        return Q[head];
    }

    public void enqueue(String item){
        if (size == capacity) {
            return;
        }
        if (size == 0) {
            Q[0] = item;
            head = 0;
            tail = 0;
        }
        else {
            tail = (tail + 1) % capacity;
            Q[tail] = item;
        }
        size++;
    }

    public String dequeue(){
        if (size == 0) {
            return null;
        }
        String ret = Q[head];
        Q[head] = null; //freeing up the memory space by making this garbage
        if (size == 1) {
            head = -1;
            tail = -1;
        }
        else {
            head = (head + 1) % capacity;
        }
        size--;
        return ret;
    }
}
