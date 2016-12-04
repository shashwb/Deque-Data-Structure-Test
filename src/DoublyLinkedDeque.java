// -------------------------------------------------------------------------
/**
 * A deque implemented using a doubly-linked chain with sentinel nodes at each
 * end.
 *
 * @param <T>
 *            The type of elements contained in the deque.
 * @author Seth Balodi <shashwb@vt.edu>
 * @version (2014.21.03)
 */
public class DoublyLinkedDeque<T>
    implements Deque<T>
{
    // ~ Instance/static variables .............................................

    // A reference to the sentinel node at the beginning of the deque.
    private Node<T> head;

    // A reference to the sentinel node at the end of the deque.
    private Node<T> tail;

    // The number of elements in the deque.
    private int     size;


    // ~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Construct the stack.
     */
    public DoublyLinkedDeque()
    {
        size = 0;
        head = new Node<T>(null);
        tail = new Node<T>(null);

        head.join(tail);

    }


    // ~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Insert a new item at the rear (the tail) of the deque.
     *
     * @param value
     *            the item to insert.
     * @postcondition [new-contents] == [old-contents] * [value]
     */
    public void enqueueAtRear(T value)
    {
        Node<T> node = new Node<T>(value);
        Node<T> lastNode = tail.previous();

        lastNode.split();
        lastNode.join(node);
        node.join(tail);
        size++;

    }


    // ----------------------------------------------------------
    /**
     * Remove the item at the front (the head) of the deque.
     *
     * @return The item that was removed
     * @precondition |[old-contents]| > 0
     * @postcondition [old-contents] == [result] * [new-contents]
     */
    public T dequeueAtFront()
    {

        T itemToBeReturned = head.next().data();
        Node<T> front = head.next();
        Node<T> frontNext = head.next().next();
        head.split();
        front.split();
        head.join(frontNext);
        size--;
        return itemToBeReturned;
    }


    // ----------------------------------------------------------
    /**
     * Insert a new item at the front (the head) of the deque.
     *
     * @param value
     *            the item to insert.
     * @postcondition [new-contents] = [value] * [old-contents]
     */
    public void enqueueAtFront(T value)
    {
        Node<T> newNode = new Node<T>(value);
        Node<T> front = head.split();
        head.join(newNode);
        newNode.join(front);
        size++;

    }


    // ----------------------------------------------------------
    /**
     * Remove the item at the rear (the tail) of the deque.
     *
     * @return The item that was removed
     * @precondition |[old-contents]| > 0
     * @postcondition [old-contents] = [new-contents] * [result]
     */
    public T dequeueAtRear()
    {
        T itemToBeReturned = tail.previous().data();
        Node<T> rear = tail.previous();
        Node<T> rearPrev = tail.previous().previous();

        rear.split();
        rearPrev.split();
        rearPrev.join(tail);
        size--;
        return itemToBeReturned;

    }


    // ----------------------------------------------------------
    /**
     * Get the item at the front (the head) of the deque. Does not alter the
     * deque.
     *
     * @return the item at the front of the deque.
     * @precondition |[contents]| > 0
     * @postcondition [new-contents] == [old-contents] and [contents] = [result]
     *                * [rest-of-items]
     */
    public T frontItem()
    {
        return head.next().data();
    }


    // ----------------------------------------------------------
    /**
     * Get the item at the rear (the tail) of the deque. Does not alter the
     * deque.
     *
     * @return the item at the rear of the deque.
     * @precondition |[contents]| > 0
     * @postcondition [new-contents] == [old-contents] and [contents] =
     *                [rest-of-items] * [result]
     */
    public T rearItem()
    {
        return tail.previous().data();
    }


    // ----------------------------------------------------------
    /**
     * Get the number of items in this deque. Does not alter the deque.
     *
     * @return The number of items this deque contains.
     * @postcondition result = |[contents]|
     */
    public int size()
    {
        return size;
    }


    // ----------------------------------------------------------
    /**
     * Empty the deque.
     *
     * @postcondition [new-contents] = []
     */
    public void clear()
    {
        head.split();
        tail.previous().split();
        head.join(tail);
        size = 0;
    }


    // ----------------------------------------------------------
    /**
     * Returns a string representation of this deque. A deque's string
     * representation is written as a comma-separated list of its contents (in
     * front-to-rear order) surrounded by square brackets, like this:
     *
     * <pre>
     * [52, 14, 12, 119, 73, 80, 35]
     * </pre>
     * <p>
     * An empty deque is simply <code>[]</code>.
     * </p>
     *
     * @return a string representation of the deque
     */
    public String toString()
    {
        Node<T> currentNode = head.next();
        String answerString = "";
        while (currentNode != tail)
        {
            answerString = answerString + currentNode.data().toString() + ", ";
            currentNode = currentNode.next();
        }

        answerString = "[" + answerString + "]";
        return answerString;
    }
}
