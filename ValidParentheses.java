// https://leetcode.com/problems/valid-parentheses/

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> testStack = new Stack<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                testStack.push(c);
            else {
                switch (c) {
                    case ')':
                        if (testStack.empty() || testStack.pop() != '(') return false;
                        break;
                    case '}':
                        if (testStack.empty() || testStack.pop() != '{') return false;
                        break;
                    case ']':
                        if (testStack.empty() || testStack.pop() != '[') return false;
                        break;
                }
            }
        }
        if (!testStack.empty()) return false;
        return true;
    }
}
