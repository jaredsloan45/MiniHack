public class SinglyLinkedList<E> {
    /**
     * these are the attributes for a singly linked list
     */
    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * constructor of the list
     */
    public SinglyLinkedList(){
        head=null;
        tail=null;
        size=0;
    }

    /**
     * find how many elements is stored in the list
     * @return the size
     */
    public int size(){return size;}

    /**
     * this method checks if the list is empty
     * @return boolean of whether the link list is empty
     */
    public boolean isEmpty(){return size==0;}

    /**
     * this method checks the first element stored in the list
     * @return the first element
     */
    public E first() {
        if (isEmpty())
            return null;
        return head.getElement();
    }

    /**
     * this method checks the last element stored in the list
     * @return the last element
     */
    public E last(){
        if(isEmpty())
            return null;
        return tail.getElement();
    }

    /**
     * Given an element the method adds the last element to the first position in the list
     * @param e the element to be added
     */
    public void addFirst(E e){
        Node<E> newest = new Node<E>(e,null);
        newest.setNext(head);
        head=newest;

        if(isEmpty()){
            tail=head;
        }
        size++;
    }

    /**
     * This method adds a given element to the last position of the list
     * @param e the element to be added
     */
    public void addLast(E e){
        Node<E> newest = new Node<E>(e,null);

        if(isEmpty()){
            head=newest;
        }else{
            tail.setNext(newest);
        }
        tail=newest;
        size++;
    }

    /**
     * This method remove the first element of the list
     * @return the first element that was removed
     */
    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        E answer= head.getElement();
        head=head.getNext();
        size--;

        if(size==0)
            tail=null;

        return answer;
    }


}
