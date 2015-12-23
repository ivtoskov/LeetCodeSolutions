class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    // Push element x onto stack.
    public void push(int x) {
        if(q2.isEmpty())
            q1.add(x);
        else
            q2.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        Queue<Integer> e = q1.isEmpty() ? q1 : q2;
        Queue<Integer> f = (q2 == e) ? q1 : q2;
        while(!f.isEmpty()) {
            int elem = f.remove();
            if(!f.isEmpty()) {
                e.add(elem);
            }
        }
    }

    // Get the top element.
    public int top() {
        Queue<Integer> e = q1.isEmpty() ? q1 : q2;
        Queue<Integer> f = (q2 == e) ? q1 : q2;
        int elem = -1;
        while(!f.isEmpty()) {
            elem = f.remove();
            e.add(elem);
        }
        return elem;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
