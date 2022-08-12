public class LinkedListDeque<T> {
    private class Node{
        T _item;
        Node next;
        Node prev;

        /*Constructor */
        Node(T item){
            _item = item;
        }
        Node(){}
    }

    private int size = 0;
    private Node head;

    public LinkedListDeque(){

        head = new Node();
        head.next = head;
        head.prev = head;
    }

    /*methods */
    public void addFirst(T item){
        size ++;
        Node temp = new Node(item);
        temp.next = head.next;
        head.next.prev = temp;
        head.next = temp;
        temp.prev = head;
        
    }

    public void addLast(T item){
        size ++;
        Node temp = new Node(item);
        temp.prev = head.prev;
        head.prev.next = temp;
        temp.next = head;
        head.prev = temp;
    }

    public boolean isEmpty(){
        // System.out.println(size);
        // System.out.println((size == 0));
        return (size == 0);
    }

    public void printDeque(){
        Node cur = head.next;
        
        while(cur != head){
            System.out.print(cur._item + " ");
            cur = cur.next;
        }
    }

    public int size(){  return size;}

    public T removeFirst(){
        size--;
        T ITEM = head.next._item;
        head.next = head.next.next;
        head.next.prev = head;
        return ITEM;
    }

    public T removeLast(){
        size--;
        T ITEM = head.prev._item;
        head.prev = head.prev.prev;
        head.prev.next = head;
        return ITEM;
    }

    public T get(int index){
        Node cur = head.next;
        int count = 0;
        while(count != index){
            cur = cur.next;
            count++;
        }
        return cur._item;
    }

    private T recursive(Node cur, int index){
        if(index == 0)  return cur._item;
        return recursive(cur.next,index-1);
    }
    public T getRecursive(int index){
        return recursive(head.next, index);
    }
    // public static void main(String[] args){

    // }
}
