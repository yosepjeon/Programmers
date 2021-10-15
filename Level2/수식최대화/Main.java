package Level2.수식최대화;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        String expression = "100-200*300-500+20";
//        String expression = "50*6-3*2";
//        String expression = "100-200";
        String expression = "1-1+1-1+1";

        Solution solution = new Solution();

        System.out.println(solution.solution(expression));
    }
}

class Solution {

    public long solution(String expression) {
        long answer = 0;
//        System.out.println(expression);

        char[] operators = {'+', '-', '*'};

        char[] carr = expression.toCharArray();
        List<String> exp = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (char c : carr) {
            if (c == '+' || c == '-' || c == '*') {
                exp.add(sb.toString());
                exp.add(String.valueOf(c));
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        exp.add(sb.toString());
//        System.out.println("exp");
//        System.out.println(exp);

        int count = 0;
        boolean[] isVisited = new boolean[3];
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            Map<String, Integer> operatorsMap = new HashMap<>();
            operatorsMap.putIfAbsent(String.valueOf(operators[i]), 0);
            isVisited[i] = true;

            for (int j = 0; j < 3; j++) {
                if (isVisited[j]) continue;
                isVisited[j] = true;
                operatorsMap.putIfAbsent(String.valueOf(operators[j]), 1);

                for (int k = 0; k < 3; k++) {
                    if (isVisited[k]) continue;
                    isVisited[k] = true;
                    operatorsMap.putIfAbsent(String.valueOf(operators[k]), 2);
                    long result = calculate(exp, operatorsMap);
                    max = result > max ? result : max;
                    count++;
                    operatorsMap.remove(String.valueOf(operators[k]));
                    isVisited[k] = false;
                }

                operatorsMap.remove(String.valueOf(operators[j]));
                isVisited[j] = false;
            }
            isVisited[i] = false;
        }

        answer = max;
        return answer;
    }

    public Long calculate(List<String> expression, Map<String, Integer> operatorsMap) {
        List<String> prefixExpression = createPrefixExpression(expression, operatorsMap);
//        System.out.println(prefixExpression);

        Stack<Long> stack = new Stack<>();
        for (String element : prefixExpression) {
            if (element.equals("+")) {
                long number1 = stack.pop();
                long number2 = stack.pop();
                long result=  number2 + number1;
                stack.push(result);
            } else if (element.equals("-")) {
                long number1 = stack.pop();
                long number2 = stack.pop();
                long result = number2 - number1;
                stack.push(result);
            } else if (element.equals("*")) {
                long number1 = stack.pop();
                long number2 = stack.pop();
                long result = number2 * number1;
                stack.push(result);
            } else {
                stack.push(Long.valueOf(element));
            }
        }

        return Math.abs(stack.pop());
    }

    public List<String> createPrefixExpression(List<String> expression, Map<String, Integer> operatorsMap) {
        Stack<String> stack = new Stack<>();
        List<String> prefixExpression = new ArrayList<>();

        for (String element : expression) {
            if (element.equals("+") || element.equals("-") || element.equals("*")) {
                if (stack.isEmpty()) {
                    stack.push(element);
                } else {
                    if (operatorsMap.get(stack.peek()) < operatorsMap.get(element)) {
                        stack.push(element);
                    } else {
                        while (!stack.isEmpty() && operatorsMap.get(stack.peek()) >= operatorsMap.get(element)) {
                            prefixExpression.add(stack.pop());
                        }

                        stack.push(element);
                    }
                }

            } else {
                prefixExpression.add(element);
            }
        }

//        System.out.println(operatorsMap);
//        System.out.println(stack.size());
        while(!stack.isEmpty()) {
            prefixExpression.add(stack.pop());
        }

        return prefixExpression;
    }
}
