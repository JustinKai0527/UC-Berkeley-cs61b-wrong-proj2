public class ArrayDeque<T> {

    private int _nextFirst;
    private int _nextLast;
    private int _capacity;
    private int _size;
    public T[] _array;

    ArrayDeque(){
        _capacity = 8;
        _nextFirst = 4;
        _nextLast = 5;
        _array = (T[]) new Object[8];
    }

    public void resize(int capacity){
        T[] replace = (T[]) new Object[capacity];

        for(int i = (_nextFirst+1) % _capacity; i != _nextLast; i = (i+1) % _capacity){
            replace[i] = _array[i];
        }

        _array = replace;
    }
    public void addFirst(T item){
        
        if(_size == _capacity)  resize(_capacity * 2);

        _array[_nextFirst] = item;
        _nextFirst--;
        if(_nextFirst < 0)  _nextFirst = _capacity-1;
        _size++;
    }

    public void addLast(T item){

        if(_size == _capacity)  resize(_capacity * 2);

        _array[_nextLast] = item;
        _nextLast++;
        if(_nextLast == _capacity)  _nextLast = 0; 
        _size++;
    }

    public boolean isEmpty(){

        if(_size == 0)  return true;
        return false;
    }

    public int size(){  return _size; }

    public void printDeque(){
        

        System.out.println(_nextFirst);
        System.out.println(_nextLast);
        System.out.println(_capacity);

        for(int i = (_nextFirst+1) % _capacity; i != _nextLast; i = (i+1) % _capacity){
            // System.out.print(i);
            System.out.println(_array[i]);
        }
    }

    public T removeFirst(){

        if(_size <= _capacity/4)  resize(_capacity * 1/4);

        int temp = _nextFirst;
        _nextFirst = (_nextFirst+1)%_size;
        return _array[temp];
    }

    public T removeLast(){

        if(_size <= _capacity/4)  resize(_capacity * 1/4);

        int temp = _nextLast;
        _nextLast = (_nextLast-1);
        if(_nextLast < 0)  _nextLast *= -1;
        return _array[temp];
    }

    public T get(int index){

        return _array[index];
    }

    // public static void main(String[] args){
    //     ArrayDeque<Double> a = new ArrayDeque<Double>();
    //     a.addFirst(3.0);
    //     a.addLast(5.0);
    //     a.printDeque();
    //     a.addFirst(2.0);
    //     a.addFirst(1.0);
    //     a.addFirst(0.0);
    //     a.addFirst(-1.0);
    //     a.printDeque();
    // }
}
