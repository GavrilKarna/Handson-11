package latihan4_isp.bad;

// FAT INTERFACE
public interface Document {
    void read();
    void edit(String content);
    void print();
    void calculate(String formula);
    void resize(int width, int height);
}
