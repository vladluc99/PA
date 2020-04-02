public class Token {
    private int value;

    public Token(int value) {
        this.value = value;
    }

    public boolean isBlank() {
        return this.value == 0;
    }

    public int getValue() {
        return value;
    }



}
