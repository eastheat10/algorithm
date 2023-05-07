package fastcampus.datastructure;

import java.util.ArrayList;

public class MyStack<T> {

    private ArrayList<T> stack = new ArrayList<>();

    public void push(T n) {
        stack.add(n);
    }

    public T pop() {
        if(stack.isEmpty()){
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if(stack.isEmpty()){
            return null;
        }
        return stack.get(stack.size() - 1);
    }

    public static void main(String[] args) {
        MyStack<Integer> s = new MyStack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

    }

}
