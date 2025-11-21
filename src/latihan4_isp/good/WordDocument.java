package latihan4_isp.good;

public class WordDocument implements Readable, Editable, Printable {
    private String filename;

    public WordDocument(String filename) {
        this.filename = filename;
    }

    @Override
    public void read() {
        System.out.println("[WordDocument] Reading Word: " + filename);
    }

    @Override
    public void edit(String content) {
        System.out.println("[WordDocument] Editing Word: " + filename + " with content: " + content);
    }

    @Override
    public void print() {
        System.out.println("[WordDocument] Printing Word: " + filename);
    }
}
