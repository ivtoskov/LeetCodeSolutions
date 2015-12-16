class MyQueue {
    java.util.Stack<Integer> stack1 = new java.util.Stack<>();
    java.util.Stack<Integer> stack2 = new java.util.Stack<>();
    // Push element x to the back of queue.
    public void push(int x) {
        stack2.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(stack1.empty()) {
            while(!stack2.empty()) {
                stack1.push(stack2.pop());
            }
        }
        stack1.pop();
    }

    // Get the front element.
    public int peek() {
        if(stack1.empty()) {
            while(!stack2.empty()) {
                stack1.push(stack2.pop());
            }
        }
        return stack1.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}
