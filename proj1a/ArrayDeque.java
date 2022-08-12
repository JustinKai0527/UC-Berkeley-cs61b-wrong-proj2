public class ArrayDeque<T> {
    public int _nextFirst;
    public int _nextLast;
    public int _capacity;
    public int _size;
    public T[] _array;

    ArrayDeque(){
        _capacity = 8;
        _nextFirst = 4;
        _nextLast = 5;
        _array = (T[]) new Object[8];
    }


    public void addFirst(T item){
        
        _array[_nextFirst] = item;
        _nextFirst--;
        if(_nextFirst < 0)  _nextFirst = _capacity-1;
        size++;
    }

    public void addLast(T item){

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
        
        for(int i = (_nextFirst+1) % size; i != __nextLast; (i+1) %size){
            System.out.print(array[i] + " ");
        }
    }

    public T removeFirst(){

        int temp = _nextFirst;
        _nextFirst = (_nextFirst+1)%size;
        return array[temp];
    }

    public T removeLast(){

        int temp = _nextLast;
        _nextLast = (_nextLast-1);
        if(_nextLast < 0)  _nextLast *= -1;
        return array[temp];
    }

    public T get(int index){

        return array[index];
    }

    
}
