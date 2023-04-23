package brackets;

import java.util.Scanner;
import java.util.Stack;

public class Brackets {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string of brackets: ");
        String str = sc.nextLine();
        
        if (isBalanced(str)) {
            System.out.println("The entered string has balanced brackets");
        } else {
            System.out.println("The entered string does not have balanced brackets");
        }
    }
    
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}
