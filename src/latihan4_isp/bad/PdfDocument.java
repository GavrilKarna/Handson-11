package latihan4_isp.bad;

public class PdfDocument implements Document {
    private String filename;

    public PdfDocument(String filename) {
        this.filename = filename;
    }

    @Override
    public void read() {
        System.out.println("[PDF] Reading document: " + filename);
    }

    @Override
    public void print() {
        System.out.println("[PDF] Printing document: " + filename);
    }

    @Override
    public void edit(String content) {
        throw new UnsupportedOperationException("PDF documents cannot be edited");
    }

    @Override
    public void calculate(String formula) {
        throw new UnsupportedOperationException("PDF documents cannot calculate");
    }

    @Override
    public void resize(int width, int height) {
        throw new UnsupportedOperationException("PDF documents cannot be resized");
    }
}
