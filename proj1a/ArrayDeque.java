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

        if(_size == 0){
            _capacity = 8;
            _nextFirst = 4;
            _nextLast = 5;
            _array = (T[]) new Object[8];
        }
        _array[_nextFirst] = item;
        _nextFirst--;
        if(_nextFirst < 0)  _nextFirst = _capacity-1;
        _size++;
        if(_size == _capacity-2)  resize(_capacity * 2);
    }

    public void addLast(T item){

        if(_size == 0){
            _capacity = 8;
            _nextFirst = 4;
            _nextLast = 5;
            _array = (T[]) new Object[8];
        }
        _array[_nextLast] = item;
        _nextLast = (_nextLast + 1) % _capacity;
        _size++;
        if(_size == _capacity-2)  resize(_capacity * 2);
    }

    public boolean isEmpty(){

        if(_size == 0)  return true;
        return false;
    }

    public int size(){  return _size; }

    public void printDeque(){
        

        System.out.println(_nextFirst);
        System.out.println(_nextLast);
        System.out.println(_size);

        for(int i = (_nextFirst+1) % _capacity; i != _nextLast; i = (i+1) % _capacity){
            // System.out.print(i + " ");
            System.out.println(_array[i]);
        }
    }

    public T removeFirst(){

        if(_size == 0)  return null;
        _nextFirst = (_nextFirst+1)%_capacity;
        T temp = _array[_nextFirst];
        _size--;
        if(_size <= _capacity/4)  resize(_capacity / 2);
        return temp;
    }

    public T removeLast(){

        if(_size == 0)  return null;
        _nextLast = (_nextLast-1);
        if(_nextLast < 0)  _nextLast = _capacity-1;
        T temp = _array[_nextLast];
        _size--;
        if(_size <= _capacity/4)  resize(_capacity / 2);
        return temp;
    }

    public T get(int index){

        index = (index + (_nextFirst+1)) % _capacity;   /*_nextFirst+1 is index 0 becareful */
        return _array[index]; 
    }

    // public int getCapacity(){  return _capacity;}

    // public static void main(String[] args){
    //     ArrayDeque<Double> a = new ArrayDeque<Double>();
    //     a.addFirst(3.0);
    //     a.addLast(4.0);
    //     // a.printDeque();
    //     a.addFirst(2.0);
    //     a.addFirst(1.0);
        
    //     a.addFirst(0.0);
    //     // a.printDeque();
    //     a.addFirst(-1.0);
    //     // a.printDeque();
    //     a.addFirst(-2.0);
    //     // a.printDeque();
    //     a.addFirst(-3.0);
    //     // a.printDeque();
    //     a.addLast(5.0);
    //     // a.printDeque();
    //     // a.printDeque();
    //     System.out.println(a.removeFirst());
    //     // a.printDeque();
    //     System.out.println(a.removeFirst());
    //     // a.printDeque();
    //     System.out.println(a.removeFirst());
    //     // a.printDeque();
    //     System.out.println(a.removeFirst());
    //     // a.printDeque();
    //     // a.printDeque();
    //     System.out.println(a.removeFirst());
    //     // a.printDeque();
    //     System.out.println(a.removeFirst());
    //     a.printDeque();
    //     // System.out.println(a.getCapacity());
    // }
}
