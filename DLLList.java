package adts;

import interfaces.ListInterface;
import nodes.DLLNode;

public class DLLList<E> implements ListInterface<E>
{
    protected DLLNode<E> head;
    protected DLLNode<E> tail;
    protected DLLNode<E> location;
    protected DLLNode<E> next;
    protected DLLNode<E> previous;
    protected boolean found;
    protected int numElements;

    @Override
    public void add(E element) {
        
    }

    @Override
    public boolean remove(E element) {

        return false;
    }

    // START BELOW
    // Helper class for searching list
    protected void find(E target) {
        found = false;
        previous = null;
        next = null;
        location = head;

        while(location != null) {
            if (location.getData().equals(target)) {
                found = true;
                break;
            } else {
                previous = location;
                location = location.getNext();
                next = location.getNext();
            }
        }
    }

    @Override
    public int size() {
        return numElements;
    }
 
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(E element) {
        find(element);
        return found;
    }

    @Override
    public E get(E element) {
        find(element);
        if(found) {
            return location.getData();
        } else {
            return null;
        }
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > numElements - 1) {
            return null;
        } 
        else {
            DLLNode<E> ptr = head;

            for (int i = 0; i < index; i++) {
                ptr = ptr.getNext();
            }

            return ptr.getData();
        }
    }

    @Override
    public String toString()
    {
        StringBuilder listStr = new StringBuilder("\n----------------------\n");
        DLLNode<E> ptr = head;

        while (ptr != null) {
            listStr.append(ptr.getData() + "\n");
            ptr = ptr.getNext();
        }

        return listStr.toString();
    }

}
