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

    public boolean setOperator(String operator) {
        this.operator = operator;
        return switch (operator) {
            case "+", "-", "*", "/", "^", "%" -> true;
            default -> false;
        };
    }

    public double calculate() {
        return switch (operator) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> divide(firstNumber, secondNumber);
            case "%" -> firstNumber % secondNumber;
            case "^" -> pow(firstNumber, secondNumber);
            default -> throw new IllegalStateException("Неизвестный оператор: " + operator);
        };
    }

    private double divide(int firstNumber, int secondNumber) {
        if (getSecondNumber() == 0) {
            System.out.println("Ошибка: деление на ноль запрещено");
        }
        return (double) firstNumber / secondNumber;
    }

    private double pow(int firstNumber, int secondNumber) {
        int result = firstNumber;
        for (int i = 1; i < Math.abs(secondNumber); i++) {
            result *= firstNumber;
        }
        return secondNumber < 0 ? 1. / result : result;
    }
}