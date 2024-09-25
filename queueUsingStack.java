//Time complexity of push() - O(1) because we are directly pushing into the stack
//Time complexity of pop():
//                         Average time - O(1) since the worst case does not happen often
//                         Best case - O(1) happens when reverseStack is not empty
//                         Worst case - O(n) happens when reverseStack is empty
//Time complexity of peek() - Similar to pop()
//Time complexity of isEmpty() - O(1) since it just checks the top element

class MyQueue {

    private Stack<Integer> stack;
    private Stack<Integer> reverseStack;
    public MyQueue() {
        stack = new Stack<>();
        reverseStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        if (reverseStack.isEmpty()) {
            while (!stack.isEmpty()) {
                reverseStack.push(stack.pop());
            }
        }
        return reverseStack.pop();
    }
    
    public int peek() {
        if (reverseStack.isEmpty()) {
            while (!stack.isEmpty()) {
                reverseStack.push(stack.pop());
            }
        }
        return reverseStack.peek(); 
    }
    
    public boolean empty() {
        return reverseStack.isEmpty() && stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */