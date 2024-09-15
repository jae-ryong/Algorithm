package dataStructure;

import Interface_form.List;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {

    // 최소 크기 및 빈 배열
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ARRAY = {};

    // 요소 갯수
    private int size;

    // 요소 담을 배열
    Object[] array;

    public ArrayList() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    public ArrayList(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
    }

    public void resize(){
        int arr_capacity  = this.array.length;

        if(Arrays.equals(array, EMPTY_ARRAY)){
            array = new Object[DEFAULT_CAPACITY];
            return;
        }

        if(size == arr_capacity){
            array = Arrays.copyOf(array, arr_capacity * 2);
            return;
        }

        if(size < arr_capacity/2){
            array = Arrays.copyOf(array, Math.max(arr_capacity/2, DEFAULT_CAPACITY));
            return;
        }
    }


    @Override
    public boolean add(E value) {
        if(size == array.length){
            resize();
        }
        array[size++] = value;
        return true;
    }

    @Override
    public void add(int index, E value) {
        if(index < 0 || index > array.length){
            throw new IndexOutOfBoundsException();
        }
        if(size == index){
            add(value);
        }else {

            if(size == array.length){
                resize();
            }

            for(int i=size; i > index; i--){
                array[i] = array[i-1];
            }

            array[index] = value;
            size++;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public E remove(int index) {
        if(index<0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E value = (E) array[index];
        array[index] = null;
        for(int i=index; i<size-1; i++){
            array[i] = array[i+1];
            array[i+1] = null;
        }
        size--;
        resize();
        return value;
    }

    @Override
    public boolean remove(Object value) {
        int idx = indexOf(value);
        if(idx >= 0){
            remove(idx);
            return true;
        }
        return false;
    }

    @Override
    public E get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        return (E) array[index];
    }

    @Override
    public void set(int index, E value) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        array[index] = value;
    }

    @Override
    public boolean contains(Object value) {
        if(indexOf(value) >=0){
            return true;
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {

        for(int i=0;i<size;i++){
            if(array[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public void clear() {
        for(int i=0; i<size; i++){
            array[i] = null;
        }
        size = 0;
        resize();
    }
}
