public class ArrayDeque<T> {

    private int _nextFirst;
    private int _nextLast;
    private int _capacity;
    private int _size;
    private T[] _array;

    public ArrayDeque(){
        _capacity = 8;
        _nextFirst = 4;
        _nextLast = 5;
        _array = (T[]) new Object[8];
    }
    
    private void resize(int capacity){
        T[] replace = (T[]) new Object[capacity];
        int index = 0;

        for(int i = (_nextFirst+1) % _capacity; i != _nextLast; i = (i+1) % _capacity){
            replace[index] = _array[i];
            // System.out.print(i + " ");
            // System.out.print(_array[i] + "   ");
            index++;
        }

        // System.out.println(size()+10);
        _nextFirst = capacity-1;
        _nextLast = _size;
        _array = replace;
        _capacity = capacity;

    }

    public void addFirst(T item){

        _array[_nextFirst] = item;
        _nextFirst--;
        if(_nextFirst < 0)  _nextFirst = _capacity-1;
        _size++;
        if(_size == _capacity-2)  resize(_capacity * 2);
    }

    public void addLast(T item){

        _array[_nextLast] = item;
        _nextLast++;
        if(_nextLast == _capacity)  _nextLast = 0; 
        _size++;
        if(_size == _capacity-2)  resize(_capacity * 2);
    }

    public boolean isEmpty(){

        if(_size == 0)  return true;
        return false;
    }

    public int size(){  return _size; }

    public void printDeque(){
        

        // System.out.println(_nextFirst);
        // System.out.println(_nextLast);
        // System.out.println(_size);

        for(int i = (_nextFirst+1) % _capacity; i != _nextLast; i = (i+1) % _capacity){
            // System.out.print(i);
            System.out.println(_array[i]);
        }
    }

    public T removeFirst(){

        int temp = _nextFirst;
        _nextFirst = (_nextFirst+1)%_size;
        _size--;
        if(_size <= _capacity/4)  resize(_capacity / 2);
        return _array[temp];
    }

    public T removeLast(){

        int temp = _nextLast;
        _nextLast = (_nextLast-1);
        if(_nextLast < 0)  _nextLast *= -1;
        _size--;
        if(_size <= _capacity/4)  resize(_capacity / 2);
        return _array[temp];
    }

    public T get(int index){

        return _array[index];
    }

    // public int getCapacity(){  return _capacity;}

    // public static void main(String[] args){
    //     ArrayDeque<Double> a = new ArrayDeque<Double>();
    //     a.addFirst(3.0);
    //     a.addLast(5.0);
    //     // a.printDeque();
    //     a.addFirst(2.0);
    //     a.addFirst(1.0);
    //     a.addFirst(0.0);
    //     a.addFirst(-1.0);
        
    //     a.addFirst(-2.0);
    //     a.addFirst(-3.0);
    //     a.removeLast();
    //     a.removeLast();
    //     a.removeLast();
    //     a.removeLast();
    //     a.removeLast();
    //     a.removeLast();
    //     a.printDeque();
    //     // System.out.println(a.getCapacity());
    // }
}
