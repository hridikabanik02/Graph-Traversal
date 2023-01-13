import java.util.ArrayList;
public class Queue{
    ArrayList<Integer> queue = new ArrayList<Integer>();
    int size;
    int front;
    int rear;
    public void enQueue(int data){
        queue.add(rear, data);
        rear++;
        size++;
    }
    public void deQueue(){
        int data = queue.remove(front);
        front++;
        size--;
    }
}
