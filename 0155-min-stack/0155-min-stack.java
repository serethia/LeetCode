class MinStack {
    static List<Integer> stack;
    static int i;

    public MinStack() {
        stack = new ArrayList<>();
        i = 0;
    }

    public void push(int val) {
        stack.add(val);
        i++;
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.remove(i - 1);
            i--;
        }
    }

    public int top() {
        return stack.get(i - 1);
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int n : stack) {
            min = Math.min(min, n);
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */