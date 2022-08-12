public class ArrayDeque<T> {

    private int _nextFirst;
    private int _nextLast;
    private int _capacity;
    private int _size;
    private T[] _array;

    ArrayDeque(){
        _capacity = 8;
        _nextFirst = 4;
        _nextLast = 5;
        _array = (T[]) new Object[8];
    }

    public void resize(int capacity){
        T[] replace = (T[]) new Object(capacity);

        for(int i = (_nextFirst+1) % size; i != __nextLast; (i+1) % _size){
            replace[i] = array[i];
        }

        _array = replace;
    }
    public void addFirst(T item){
        
        if(size == _capacity)  resize(_capacity * 2);

        _array[_nextFirst] = item;
        _nextFirst--;
        if(_nextFirst < 0)  _nextFirst = _capacity-1;
        size++;
    }

    public void addLast(T item){

        if(size == _capacity)  resize(_capacity * 2);

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
        
        for(int i = (_nextFirst+1) % size; i != __nextLast; (i+1) % _size){
            System.out.print(array[i] + " ");
        }
    }

    public T removeFirst(){

        if(size <= _capacity/4)  resize(_capacity * 1/4);

        int temp = _nextFirst;
        _nextFirst = (_nextFirst+1)%size;
        return array[temp];
    }

    public T removeLast(){

        if(size <= _capacity/4)  resize(_capacity * 1/4);

        int temp = _nextLast;
        _nextLast = (_nextLast-1);
        if(_nextLast < 0)  _nextLast *= -1;
        return array[temp];
    }

    public T get(int index){

        return array[index];
    }

    public static void main(String[] args){

    }
}
