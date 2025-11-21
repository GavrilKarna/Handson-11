package latihan4_isp.bad;

public class WordDocument implements Document {
    private String filename;

    public WordDocument(String filename) {
        this.filename = filename;
    }

    @Override
    public void read() {
        System.out.println("[WORD] Reading document: " + filename);
    }

    @Override
    public void edit(String content) {
        System.out.println("[WORD] Editing document: " + filename);
    }

    @Override
    public void print() {
        System.out.println("[WORD] Printing document: " + filename);
    }

    @Override
    public void calculate(String formula) {
        throw new UnsupportedOperationException("Word documents cannot calculate");
    }

    @Override
    public void resize(int width, int height) {
        throw new UnsupportedOperationException("Word documents cannot be resized");
    }
}
