//Referenced my notes from class to write this code.
public class ListQueue {
    protected Node head;
    protected Node tail;
    protected int size;

    public ListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    public int size(){
        return this.size;
    }

    public String front(){
        if (size == 0){
            return null;
        }
        return head.getElement();
    }

    public void enqueue(String item){
        if (item == null){
            return;
        }

        Node newNode = new Node(item,null);

        if (size == 0){
            head = newNode;
        }
        else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }


    public String dequeue() {
        if (size == 0) {
            return null;
        }
        String ret = head.getElement();
        if (size == 1) {
            head = null;
            tail = null;
        }
        else {
            Node oldHead = head;
            head = head.getNext();
            oldHead.setNext(null);
        }
        size--;
        return ret;
    }

}
