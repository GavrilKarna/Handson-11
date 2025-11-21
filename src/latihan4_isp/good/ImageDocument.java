package latihan4_isp.good;

// ImageDocument implement Readable, Resizable
public class ImageDocument implements Readable, Resizable {
    private String filename;

    public ImageDocument(String filename) {
        this.filename = filename;
    }

    @Override
    public void read() {
        System.out.println("[ImageDocument] Reading Image: " + filename);
    }

    @Override
    public void resize(int width, int height) {
        System.out.println("[ImageDocument] Resizing Image: " + filename + " to " + width + "x" + height);
    }
}
