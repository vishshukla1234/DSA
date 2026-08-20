import java.util.Stack;

public class RPN {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens) {
            if(token.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                int ans = a+b;
                stack.push(ans);
            } else if(token.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                int ans = b-a;
                stack.push(ans);
            } else if(token.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                int ans = a*b;
                stack.push(ans);
            } else if(token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                int ans = b/a;
                stack.push(ans);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }
}
