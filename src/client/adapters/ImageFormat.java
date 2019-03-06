package client.adapters;

public enum ImageFormat /*implements Serializable*/ {
    PNG("png"),
    JPG("jpeg");

    private String format;

    ImageFormat(String format) {
        this.format = format;
    }
}
