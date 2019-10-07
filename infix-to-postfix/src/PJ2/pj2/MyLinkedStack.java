/**
    A class of stacks whose entries are stored in a chain of nodes.
    Implement all methods in MyLinkedStack class using 
    the inner StackNode class. 

    Main Reference : text book or class notes
    Do not change or add data fields 
    Do not add new methods
    You may access nodes' fields directly, i.e. data and next 
*/

package PJ2;

public class MyLinkedStack<T> implements MyStackInterface<T>
{
   
   // Data fields
   private StackNode top;    // references the first node in the chain
   private int count;  	    // number of data in this stack
  
   public MyLinkedStack()
   {
      // add stataments
       top = null;
       count = 0;
   } // end default constructor
  
   public void push(T newData)
   {
      // add stataments
       StackNode newNode = new StackNode (newData, top);
       top = newNode;
       count += 1;
   } // end push

   public T peek()
   {
      // add stataments
       T temp = null;
       if (top != null){
           temp = top.data;
       }
      return temp;
   } // end peek

   public T pop()
   {
      // add stataments
       T temp = peek();
       if (top != null){
           top = top.next;
           count -= 1;
       }
      return temp;
   } // end pop

   public int size()
   {
      // add stataments
      return count;
   } // end size 

   public boolean empty() 
   {
      // add stataments
      return top == null;
   } // end empty
      	   
   public void clear()
   {
      // add stataments
       top = null;
       count = 0;
   } // end clear

   public String toString()
   {
      // add stataments
       String tempS = "[";
       StackNode newNode = top;
       while (newNode != null){
           tempS += newNode.data.toString();
           tempS += ',';
           tempS += newNode.next;
       }
       tempS += "]";
      // note: data class in stack must implement toString() method
      //       return a list of data in Stack, separate them with ','
      return tempS;
   }


   /****************************************************
	private inner node class
        Do not modify the class!!
        you may access data and next directly
    ***************************************************/

	private class StackNode
	{
	  private T data; // entry in list
	  private StackNode next; // link to next node
	  private StackNode (T dataPortion)
	  {
	    data = dataPortion;
	    next = null; // set next to NULL
	  } // end constructor

	  private StackNode (T dataPortion, StackNode nextStackNode)
	  {
	    data = dataPortion;
	    next = nextStackNode; // set next to refer to nextStackNode
	  } // end constructor
	} // end StackNode


   /****************************************************
      Do not modify: Stack test
   ****************************************************/
   public static void main (String args[])
   {

        System.out.println("\n"+
	"*******************************************************\n"+
        "Sample Expected output:\n"+
	"\n"+
        "OK: stack is empty\n"+
        "Push 3 data: 10, 30, 50\n"+
        "Print stack [50,30,10,]\n"+
        "OK: stack size is 3\n"+
        "OK: peek stack top is 50\n"+
        "OK: stack is not empty\n"+
        "Pop 2 data: 50, 30\n"+
        "Print stack [30,10,]\n"+
        "Print stack [10,]\n"+
        "OK: stack pop data is 30\n"+
        "Clear stack\n"+
        "Print stack []\n"+
	"\n"+
	"*******************************************************");

        System.out.println("\nYour Test output:\n");
	MyStackInterface<Integer> s = new MyLinkedStack<Integer>();
	if (s.empty()) 
            System.out.println("OK: stack is empty");
	else
            System.out.println("Error: stack is not empty");

	s.push(10);
	s.push(30);
	s.push(50);
        System.out.println("Push 3 data: 10, 30, 50");
        System.out.println("Print stack " + s);

	if (s.size() == 3) 
            System.out.println("OK: stack size is 3");
	else
            System.out.println("Error: stack size is " + s.size());

	if (s.peek() == 50) 
            System.out.println("OK: peek stack top is 50");
	else
            System.out.println("Error: peek stack top is " + s.size());

	if (!s.empty()) 
            System.out.println("OK: stack is not empty");
	else
            System.out.println("Error: stack is empty");

        System.out.println("Pop 2 data: 50, 30");
        s.pop();
        System.out.println("Print stack " + s);
	int data=s.pop();
        System.out.println("Print stack " + s);
	if (data == 30) 
            System.out.println("OK: stack pop data is 30");
	else
            System.out.println("Error: stack pop data is " + data);

        System.out.println("Clear stack");
        s.clear();
        System.out.println("Print stack " + s);
   }

} // end Stack
