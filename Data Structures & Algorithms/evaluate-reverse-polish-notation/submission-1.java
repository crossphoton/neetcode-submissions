class Solution {
    List<String> ops = List.of("+", "-", "*", "/");

    private boolean isOp(String op) {
        return ops.contains(op);
    }

    private int performOp(Integer left, Integer right, String op) {
        switch (op) {
            case("+"):
                return left + right;
            case("-"):
                return left - right;
            case("*"):
                return left * right;
            case("/"):
                return left / right;
            default:
                return 0;
        }
    }

    public int evalRPN(String[] tokens) {
        Stack<String> operands = new Stack<>();
        int index = 0;

        // ["4","13","5","/","+"]

        while(index < tokens.length) {
            if (!isOp(tokens[index])) {
                operands.push(tokens[index++]);
                continue;
            }

            Integer rightOperand = Integer.parseInt(operands.pop());
            Integer leftOperand = Integer.parseInt(operands.pop());
            String op = tokens[index++];

            operands.push(String.valueOf(performOp(leftOperand, rightOperand, op)));
        }

        return Integer.parseInt(operands.pop());
    }
}
