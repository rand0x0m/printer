package client.adapters;

public enum DocumentFormat {
    PDF(0),
    DOC(1);

    private int format;

    DocumentFormat(int format) {
        this.format = format;
    }
}
