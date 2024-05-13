A stack is a fundamental data structure that follows the Last In First Out (LIFO) principle, meaning that the most recently added item is the first one to be removed. It's like a stack of plates where you can only add or remove plates from the top.

### Operations of Stack:

1. **push(x)**: This operation places an object `x` on the top of the stack.
   
2. **pop()**: This operation removes the object from the top of the stack and returns it.
   
3. **peek()**: This operation returns the object from the top of the stack without removing it.
   
4. **isEmpty()**: This operation reports whether the stack is empty or not.

### Time Complexity:

For a well-implemented stack, all the operations (push, pop, peek, isEmpty) should have a time complexity of O(1), meaning the time it takes to perform these operations does not depend on the number of elements already in the stack. This is crucial for the efficiency of stack-based algorithms.

### Applications of Stack:

1. **Function calls/recursion**: Stack data structure is used to manage function calls in programs. When a function is called, its execution context is pushed onto the call stack, and when the function returns, its context is popped off the stack. This makes it possible for functions to call other functions and return to the original caller.

2. **Undo operation**: Stacks are useful for implementing undo functionality in applications like text editors or image editors. Each action performed by the user can be stored on a stack, and when undo is requested, the last action can be reversed by popping it from the stack.

3. **Balance Parentheses Check**: Stack is commonly used in algorithms that involve checking whether parentheses, braces, and brackets are balanced in expressions or code. The stack helps to keep track of opening and closing symbols, ensuring that they match up correctly.

4. **Reversing a list/collection**: A stack can be employed to reverse the order of elements in a list or collection. By pushing all elements onto a stack and then popping them off, you effectively reverse the order.

Stacks are versatile data structures with a wide range of applications in computer science and software development. Their simplicity and efficiency make them indispensable in many scenarios.


### Implementation of Stack using Array:

#### Overview:
A stack implemented using an array is a straightforward approach where the array serves as the underlying data structure to hold the stack elements. However, there are considerations such as handling overflow when the array is full and determining the optimal strategy for resizing the array.

#### Implementation Details:

1. **Array Size Limitation:**
   - Since arrays have a fixed size, the stack can only hold elements up to the size of the array. Once the number of elements in the stack reaches the array's capacity, further pushes will result in overflow.
   - Overflow occurs when attempting to push an element onto a full stack.

2. **Handling Overflow:**
   - There are different strategies to handle overflow when implementing a stack using an array:
   
   a. **Error/Exception Handling:** 
      - The push operation can check if the array is full before inserting a new element. If the array is full, it can throw an error or raise an exception to indicate overflow. This prevents pushing elements beyond the array's capacity.
   
   b. **Dynamic Array (Resizeable Array):** 
      - Instead of restricting the stack to a fixed-size array, a dynamic array can be used. 
      - When overflow occurs, a new larger array is created.
      - The content of the old array is copied to the new array, and then the new element is pushed onto the resized array.
      - An optimal resizing strategy is to double the size of the old array to ensure efficient memory utilization.
      
3. **Time Complexity Analysis:**
   - **Push Operation:**
     - Best Case: O(1) - When there is space available in the array, pushing an element onto the stack takes constant time.
     - Worst Case: O(n) - In scenarios where overflow occurs and the array needs resizing, copying elements from the old array to the new array takes linear time.
     - Average Case: O(1) - On average, the push operation is constant time if dynamic array resizing is efficiently implemented.

#### Conclusion:
Implementing a stack using an array involves managing the limitations of fixed-size arrays and handling overflow scenarios. The choice between error handling and dynamic array resizing depends on factors such as expected usage patterns and memory constraints. Dynamic arrays offer flexibility but incur additional overhead during resizing operations.

### Average Case Time Complexity Analysis for Push Operation:

#### Mathematical Explanation:
When dynamically resizing the array, if we start with an array of size 1 and double the size with each overflow, the cost of copying elements during resizing can be calculated as follows:

```
1 + 2 + 4 + 8 + ... + n/2 + n
```

This is a geometric series, and the sum can be simplified as:

```
n * (1 + 1/2 + 1/4 + ... + 1/n)
```

The expression in the brackets evaluates to approximately 2 as n approaches infinity. Therefore, the total cost of copying during resizing is proportional to n*2, which simplifies to O(n).

#### Amortized Analysis:
Since the cost of copying for n pushes is O(n), the average cost of each push is O(n)/n = O(1). This is known as amortized constant time complexity.

#### Intuitive Explanation:
In the worst case, the time taken for n pushes is O(n). Let's denote this as c*n, where c is a constant representing the time taken for each push operation. The average time complexity can be written as (c*n*d)/n, where d is the time contribution factor for pushing elements before the nth element. As n grows large, d becomes negligible, and the average time complexity approaches O(1), indicating constant time per push operation.

### Java Implementation of Stack using Array:
```java
public class Stack {
    private int[] arr;
    private int top;
    private int capacity;

    public Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (top == capacity - 1) {
            resize(); // Handle overflow by resizing the array
        }
        arr[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    private void resize() {
        int[] newArray = new int[capacity * 2]; // Double the size of the array
        System.arraycopy(arr, 0, newArray, 0, capacity); // Copy elements to the new array
        capacity *= 2; // Update capacity
        arr = newArray; // Assign the new array to the stack
    }
}
```

This Java implementation demonstrates how a stack can be implemented using an array. The `push()` method checks for overflow and dynamically resizes the array if needed. The `resize()` method doubles the size of the array when it becomes full, ensuring efficient memory utilization.

### Conclusion:
The average case time complexity of the push operation in a stack implemented using an array is O(1) due to the amortized analysis, even though the worst-case complexity for resizing the array is O(n). This analysis provides insights into the efficiency of the push operation over a sequence of insertions, making it suitable for various applications.

### Explanation of StackTest Class:

```java
public class StackTest {
    public static void main(String[] args) {
        Stack s = new Stack(); // Create a new stack instance
        s.push(5); // Push 5 onto the stack
        s.push(8); // Push 8 onto the stack
        s.push(9); // Push 9 onto the stack
        System.out.println(s); // Print the stack: [5, 8, 9]
        System.out.println(s.pop()); // Pop the top element of the stack: 9
        System.out.println(s); // Print the stack after pop operation: [5, 8]
        System.out.println(s.peek()); // Peek the top element of the stack: 8
        System.out.println(s); // Print the stack after peek operation: [5, 8]
    }
}
```
This class serves as a test driver for the `Stack` class. It demonstrates the basic usage of a stack by pushing elements onto the stack, popping elements off the stack, and peeking at the top element of the stack.

### Explanation of Stack Class:

```java
class Stack {
    int[] elements; // Array to store stack elements
    int top; // Index of the top element in the stack

    // Default constructor: Creates a stack with default size 16
    public Stack() {
        this(16);
    }

    // Constructor: Creates a stack with specified size
    public Stack(int size) {
        elements = new int[size];
        top = -1; // Initialize top to indicate an empty stack
    }

    // Push operation: Adds an element to the top of the stack
    public void push(int val) {
        if (top == elements.length - 1) {
            extendStack(); // Extend the stack size if it is full
        }
        elements[++top] = val; // Increment top and insert element
    }

    // Pop operation: Removes and returns the top element from the stack
    public int pop() {
        if (top == -1) {
            throw new IllegalStateException("Stack is empty."); // Throw exception if stack is empty
        }
        return elements[top--]; // Decrement top and return the popped element
    }

    // Peek operation: Returns the top element of the stack without removing it
    public int peek() {
        if (top == -1) {
            throw new IllegalStateException("Stack is empty."); // Throw exception if stack is empty
        }
        return elements[top]; // Return the top element
    }

    // isEmpty operation: Checks if the stack is empty
    public boolean isEmpty() {
        return top == -1; // Return true if top is -1 indicating an empty stack
    }

    // Extend stack: Doubles the size of the stack when it is full
    private void extendStack() {
        int[] newStack = new int[elements.length * 2]; // Create a new array with double the size
        for (int i = 0; i < elements.length; i++) {
            newStack[i] = elements[i]; // Copy elements from the old array to the new array
        }
        elements = newStack; // Update the stack reference to point to the new array
    }

    // toString method: Returns a string representation of the stack
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            result.append(elements[i]).append(", "); // Append elements to the result StringBuilder
        }
        if (result.indexOf(",") != -1) {
            result.delete(result.lastIndexOf(","), result.length()); // Remove the trailing comma
        }
        result.append("]"); // Append closing bracket
        return result.toString(); // Return the string representation of the stack
    }
}
```

This class represents a stack data structure implemented using an array. It includes methods for push, pop, peek, and isEmpty operations, as well as a method for dynamically extending the stack size when it becomes full.

#### Summary:
- The `StackTest` class serves as a driver program to test the functionality of the `Stack` class.
- The `Stack` class provides methods for basic stack operations and dynamically resizing the underlying array when necessary.
- Together, these classes demonstrate the usage and implementation of a stack data structure in Java.
