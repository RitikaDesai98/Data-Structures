import java.util.LinkedList;
import java.util.Queue;
public interface PureQueue<E>{
    int size();
    boolean isEmpty();
    void enqueue(E element);
    E dequeue();
    E front();
}

public class LinkedListPureQueue<E> implements PureQueue<E> {
    protected Object[] data;    //Holds the elements of the queue
    
    //The linkedlist will maintain size, front, and back references for us.
        protected LinkedList<E> list; 
    
        
        //Default constructor.
        public LinkedListPureQueue(){
            list = new LinkedList();    //an empty linked list.
        }
        
        public int size(){
            return list.size();
        }
        
        public boolean isEmpty(){
            return list.isEmpty();
        }
        
        public void enqueue(E element){
            //When an element is added to a queue, it goes in at the end.
            //Like joining a waiting line.
            list.addLast(element);
        }
        
        public E dequeue(){
       //When an element is removed from a queue, it comes from the front.
       //Like your turn after watiting in line.
            return list.removeFirst();
        }
        
        public E front(){
    //Return the element at the front of the queue without removing it.
            return list.getFirst();
        }
    
    }    