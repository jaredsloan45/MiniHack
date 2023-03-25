public class Node<E> {

    /**
     * A node class contains attributes of an element and reference to its next element
     */
    private E element;
    private Node<E> next;

    /**
     * constructor of a node
     * @param e the element itself
     * @param n reference to the next element
     */
    public Node(E e, Node<E> n){
        element =e;
        next =n;
    }

    /**
     * getters and setters
     * @return the element or reference with generic type
     */
    public E getElement(){return element;}
    public Node<E> getNext(){return next;}
    public void setNext(Node<E> n){next=n;}

}
