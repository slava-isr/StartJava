public class Calculator {

    private int firstNumber;
    private int secondNumber;
    private String operator;

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double calculate() {
        return switch (operator) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> (double) firstNumber / secondNumber;
            case "%" -> firstNumber % secondNumber;
            case "^" -> pow(firstNumber, secondNumber);
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }

    private double pow(int firstNumber, int secondNumber) {
        int result = firstNumber;
        int tempSecondNumber = secondNumber < 0 ? -secondNumber : secondNumber;
        for (int i = 1; i < tempSecondNumber; i++) {
            result *= firstNumber;
        }
        return secondNumber < 0 ? 1. / result : result;
    }
}