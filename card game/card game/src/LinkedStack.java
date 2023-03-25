public class LinkedStack<E> implements Stack<E> {
    /**
     * This is an abstract data type that implements stack interface
     */
    private SinglyLinkedList<E> list; // uses singly linked list as the type

    /**
     * constructor of a linked stack
     */
    public LinkedStack(){
        list=new SinglyLinkedList<E>();
    }

    /**
     * this function push an element to the top of the stack
     * @param element the element to be pushed
     */
    @Override
    public void push(E element) {list.addFirst(element);}

    /**
     * this method takes out the first element of the stack
     * @return the first element that was removed
     */
    @Override
    public E pop() {return list.removeFirst();}

    /**
     * This method see the value of the first element in the stack
     * @return the element on the top
     */
    @Override
    public E peek() {return list.first();}

    /**
     * This method return the size of the list
     * @return the size
     */
    @Override
    public int size() {return list.size();}

    /**
     * This method checks overrides the isempty function from a singly linked list to check if the stack is empty
     * @return boolean is the stack is empty
     */
    @Override
    public boolean isEmpty() {return list.isEmpty();}
}

