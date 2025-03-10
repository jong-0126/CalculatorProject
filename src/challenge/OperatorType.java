package challenge;

public enum OperatorType {
    PLUS('+'), MINUS('-'), MULTIPLY('*'), DIVIDE('/');

    private char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }


}
