import java.util.EmptyStackException;

/**
 * Generic Stack — LIFO using dynamic array (auto-resize)
 */
public class Stack {
    private Object[] data;
    private int top = -1;

    public Stack(int initialCapacity) {
        data = new Object[initialCapacity];
    }

    public void push(Object item) {
        if (top == data.length - 1) resize();
        data[++top] = item;
    }

    public Object pop() {
        if (isEmpty()) throw new EmptyStackException();
        Object item = data[top];
        data[top--] = null;
        return item;
    }

    public Object peek() {
        if (isEmpty()) throw new EmptyStackException();
        return data[top];
    }

    private void resize() {
        Object[] bigger = new Object[data.length * 2];
        System.arraycopy(data, 0, bigger, 0, data.length);
        data = bigger;
    }

    public boolean isEmpty() { return top == -1; }
    public int size()        { return top + 1; }

    // Practical use: check balanced brackets
    public static boolean isBalanced(String expr) {
        Stack s = new Stack(16);
        for (char c : expr.toCharArray()) {
            if ("({[".indexOf(c) >= 0) s.push(c);
            else if (")}]".indexOf(c) >= 0) {
                if (s.isEmpty()) return false;
                char open = (char) s.pop();
                if ((c == ')' && open != '(') || (c == '}' && open != '{') || (c == ']' && open != '['))
                    return false;
            }
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}"));   // true
        System.out.println(isBalanced("{[(])}"));   // false
        System.out.println(isBalanced("((()"));     // false
    }
}
