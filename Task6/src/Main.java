public class Main {
    public static void main(String[] args) {
        StackWithDynamicArray<Integer> stack = new StackWithDynamicArray<>(Integer.class);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        StackWithLinkedLisT<String> stack1 = new StackWithLinkedLisT<>();
        stack1.push("Marwan");
        stack1.push("Reda");
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        reverse("hsrat");
        System.out.println(checkForBalancedBrackets("<dodsj{(sndkjf)nsj}>"));
        System.out.println(checkForBalancedBrackets("<)>"));

    }

    public static void reverse(String sentence) {
        StackWithLinkedLisT<Character> reverse = new StackWithLinkedLisT<>();
        for (int i = 0; i < sentence.length(); i++) {
            reverse.push(sentence.charAt(i));
        }
        for (int i = 0; i < sentence.length(); i++) {
            System.out.print(reverse.pop());
        }
        System.out.println();

    }

    public static boolean checkForBalancedBrackets(String expression) {
        StackWithLinkedLisT<Character> stack = new StackWithLinkedLisT<>();
        for (int i = 0; i < expression.length(); i++) {
//            if open bracket found
            if (expression.charAt(i) == '<' || expression.charAt(i) == '(' || expression.charAt(i) == '[' ||
                    expression.charAt(i) == '{') {
                stack.push(expression.charAt(i));
            }

//           if close bracket found
            if (expression.charAt(i) == '>') {
//                if stack is not empty
                if (!stack.isEmpty()) {
//                    if matching open bracket is last in stack
                    if (stack.pop() == '<') {
                        continue;
//                        if close bracket doesn't equal it's matching open bracket
                    } else {
                        return false;
                    }
//                    if stack is empty but close bracket found
                } else {
                    return false;
                }
            }

//           if close bracket found
            if (expression.charAt(i) == ')') {
//                if stack is not empty
                if (!stack.isEmpty()) {
//                    if matching open bracket is last in stack
                    if (stack.pop() == '(') {
                        continue;
//                        if close bracket doesn't equal it's matching open bracket
                    } else {
                        return false;
                    }
//                    if stack is empty but close bracket found
                } else {
                    return false;
                }
            }


//           if close bracket found
            if (expression.charAt(i) == ']') {
//                if stack is not empty
                if (!stack.isEmpty()) {
//                    if matching open bracket is last in stack
                    if (stack.pop() == '[') {
                        continue;
//                        if close bracket doesn't equal it's matching open bracket
                    } else {
                        return false;
                    }
//                    if stack is empty but close bracket found
                } else {
                    return false;
                }
            }


            //           if close bracket found
            if (expression.charAt(i) == '}') {
//                if stack is not empty
                if (!stack.isEmpty()) {
//                    if matching open bracket is last in stack
                    if (stack.pop() == '{') {
                        continue;
//                        if close bracket doesn't equal it's matching open bracket
                    } else {
                        return false;
                    }
//                    if stack is empty but close bracket found
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}