package javadatabasetest;

public enum Alphabets {
    ENGLISH("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
    SPANISH("ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"),
    PORTUGUESE("ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚÂÊÔÃÕÇ"),
    GERMAN("ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜß"),
    FRENCH("ABCDEFGHIJKLMNOPQRSTUVWXYZÉÈÊëÀÂïÔÙüŒœ");

    private String alphabet;

    Alphabets(String alphabet){
        this.alphabet = alphabet;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }
}
