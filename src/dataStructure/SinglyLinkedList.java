package dataStructure;

import Interface_form.List;
import org.w3c.dom.NamedNodeMap;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node<E> search(int index){

        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node<E> x = head;

        for(int i=0;i<index;i++) {
            x = head.next;
        }
        return x;
    }

    public void addFirst(E value){
        Node<E> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        size++;

        if(head.next == null){
            tail = head;
        }
    }

    public void addLast(E value){
        Node<E> newNode = new Node<>(value);

        if(size == 0){
            addFirst(value);
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
    }


    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    @Override
    public void add(int index, E value) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        if(index==0){
            addFirst(value);
            return;
        }

        if (index == size) {
            addLast(value);
            return;
        }

        Node<E> newNode = new Node<>(value);
        Node<E> next_Node  = search(index);
        Node<E> prev_Node  = search(index-1);

        prev_Node.next = null;
        prev_Node.next = newNode;
        newNode.next = next_Node;
        size++;
    }

    public E remove(){
        if(head == null){
            throw new NoSuchElementException();
        }
        E element = head.data;
        head = head.next;

        size--;
        if(size == 0){
            tail = null;
        }
        return element;
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            return remove();
        }

        Node<E> prevNode  = search(index-1);
        Node<E> removeNode = prevNode.next;
        Node<E> nextNode = removeNode.next;
        E element = removeNode.data;

        prevNode.next = nextNode;

        if(prevNode.next == null){
            tail = prevNode;
        }
        
        removeNode.next = null;
        removeNode.data = null;
        size--;

        return element;
    }

    @Override
    public boolean remove(Object value) {
        Node<E> prevNode  = head;
        Node<E> x = head;

        // value 와 일치하는 노드를 찾는다.
        for(;x != null; x=x.next){
            if(value.equals(x.data)){
                break;
            }
            prevNode = x;
        }

        // 일치하는 요소가 없을 경우 false 반환
        if(x==null){
            return false;
        }

        // 만약 삭제하려는 노드가 head라면 기존 remove()를 사용
        if(x.equals(head)){
            remove();
            return true;
        }else{
            prevNode.next = x.next;
            // 만약 삭제했던 노드가 마지막 노드라면 tail을 prevNode로 갱신
            if(prevNode.next == null) {
                tail = prevNode;
            }
            x.data = null;
            x.next = null;
            size--;
            return true;
        }
    }

    @Override
    public E get(int index) {
        return search(index).data;
    }

    @Override
    public void set(int index, Object value) {

    }

    @Override
    public boolean contains(Object value) {
        return false;
    }

    @Override
    public int indexOf(Object value) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }
}
