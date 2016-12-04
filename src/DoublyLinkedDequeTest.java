import student.TestCase;

//-------------------------------------------------------------------------
/**
 * Tests for the {@link DoublyLinkedDeque} class.
 *
 * @author Seth Balodi     <shashwb@vt.edu>
 * @version
 */
public class DoublyLinkedDequeTest
    extends TestCase
{
    //~ Instance/static variables .............................................

    private Deque<String> deque;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Create a new test class
     */
    public DoublyLinkedDequeTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Creates two brand new, empty sets for each test method.
     */
    public void setUp()
    {
        deque = new DoublyLinkedDeque<String>();

    }


    // ----------------------------------------------------------
    /**
     * This method is used to test the EnqueueAtRear method
     */
    public void testEnqueueAtRear()
    {
        deque.enqueueAtRear("rear");
        deque.enqueueAtRear("newRear");
        assertEquals("rear", deque.frontItem());
        assertEquals("newRear", deque.rearItem());
        assertEquals(2, deque.size());
    }

    // ----------------------------------------------------------
    /**
     * This method is used to test the dequeueAtFront method
     */
    public void testDequeueAtFront()
    {
        deque.enqueueAtFront("value");
        deque.enqueueAtFront("value2");
        deque.enqueueAtFront("value3");

        deque.dequeueAtFront();
        assertEquals("value2", deque.frontItem());
    }

    // ----------------------------------------------------------
    /**
     * This method is used to test the enqueueAtFront method
     */
    public void testEnqueueAtFront()
    {
        deque.enqueueAtFront("rear");
        deque.enqueueAtFront("front");
        assertEquals("front", deque.frontItem());
        assertEquals("rear", deque.rearItem());
        assertEquals(2, deque.size());

    }

    // ----------------------------------------------------------
    /**
     * This method is used to test the dequeueAtRear method
     */
    public void testDequeueAtRear()
    {
        deque.enqueueAtFront("rear");
        deque.enqueueAtFront("middle");
        deque.enqueueAtFront("front");
        deque.dequeueAtRear();
        assertEquals("middle", deque.rearItem());
        assertEquals("front", deque.frontItem());
        assertEquals(2, deque.size());
    }

    // ----------------------------------------------------------
    /**
     * This method is used to test the clear method of the DoublyLinkedDeque
     * class
     */
    public void testClear()
    {
        deque.enqueueAtFront("rear");
        deque.enqueueAtFront("middle");
        deque.enqueueAtFront("front");
        deque.clear();
        assertEquals(0, deque.size());
    }

    // ----------------------------------------------------------
    /**
     * This method is used to test the toString method of the DoublyLInkedDeque
     * class
     */
    public void testToString()
    {
        deque.enqueueAtFront("Front 1");
        deque.enqueueAtRear("Front 2");
        deque.enqueueAtRear("Front 3");
        assertEquals("[Front 1, Front 2, Front 3, ]", deque.toString());
    }

}
