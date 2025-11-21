package latihan4_isp;

import java.util.*;
import latihan4_isp.good.Readable;
import latihan4_isp.good.Editable;
import latihan4_isp.good.Printable;
import latihan4_isp.good.Resizable;
import latihan4_isp.good.Calculable;

import latihan4_isp.good.PdfDocument;
import latihan4_isp.good.WordDocument;
import latihan4_isp.good.SpreadsheetDocument;
import latihan4_isp.good.ImageDocument;

public class ISPPractice {
    public static void main(String[] args) {
        /*
         * LATIHAN 4: INTERFACE SEGREGATION PRINCIPLE (ISP)
         */

        // ===== PART 1: BAD PRACTICE - Melanggar ISP =====
        System.out.println("=== BAD PRACTICE: Melanggar ISP ===\n");

        System.out.println("--- Testing PDF Document ---");
        latihan4_isp.bad.Document pdf = new latihan4_isp.bad.PdfDocument("Contract.pdf");
        pdf.read();
        pdf.print();

        System.out.println("\nTrying to edit PDF (not supported):");
        try {
            pdf.edit("New content");
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\n--- Testing Image Document ---");
        latihan4_isp.bad.Document image = new latihan4_isp.bad.ImageDocument("Photo.jpg");
        image.read();

        System.out.println("\nTrying to print image (not supported):");
        try {
            image.print();
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\n--- Analisis Masalah ---");
        System.out.println("Document interface terlalu BESAR (FAT INTERFACE):");
        System.out.println("1. read() - semua dokumen butuh ✓");
        System.out.println("2. edit() - hanya Word & Spreadsheet butuh ✗");
        System.out.println("3. print() - PDF, Word, Spreadsheet butuh (Image tidak) ✗");
        System.out.println("4. calculate() - hanya Spreadsheet butuh ✗");
        System.out.println("5. resize() - hanya Image butuh ✗");
        System.out.println("\nPDF & Image dipaksa implement method yang tidak digunakan!");
        System.out.println("Banyak method yang hanya throw UnsupportedOperationException!");
        System.out.println("Interface tidak fleksibel = MELANGGAR ISP!");

        System.out.println("\n" + "=".repeat(70));

        // =====================================================================
        // ===== PART 2: GOOD PRACTICE - Mengikuti ISP ===========================
        // =====================================================================
        System.out.println("\n=== GOOD PRACTICE: Mengikuti ISP ===\n");

        System.out.println("--- Testing PDF Document ---");
        PdfDocument goodPdf = new PdfDocument("Contract.pdf");
        goodPdf.read();
        goodPdf.print();

        System.out.println("\n--- Testing Word Document ---");
        WordDocument word = new WordDocument("Report.docx");
        word.read();
        word.edit("Updated content for report");
        word.print();

        System.out.println("\n--- Testing Spreadsheet Document ---");
        SpreadsheetDocument spreadsheet = new SpreadsheetDocument("Budget.xlsx");
        spreadsheet.read();
        spreadsheet.edit("A1: 1000");
        spreadsheet.calculate("SUM(A1:A10)");
        spreadsheet.print();

        System.out.println("\n--- Testing Image Document ---");
        ImageDocument goodImage = new ImageDocument("Photo.jpg");
        goodImage.read();
        goodImage.resize(800, 600);

        // Polymorphism Example
        System.out.println("\n--- Polymorphic Usage ---");
        Readable readable1 = new PdfDocument("Doc1.pdf");
        Readable readable2 = new ImageDocument("Image1.jpg");
        readable1.read();
        readable2.read();

        System.out.println("\nPrinting all printable documents:");
        List<Printable> printableDocuments = new ArrayList<>();
        printableDocuments.add(new PdfDocument("Doc.pdf"));
        printableDocuments.add(new WordDocument("Report.docx"));
        printableDocuments.add(new SpreadsheetDocument("Data.xlsx"));

        for (Printable doc : printableDocuments) {
            doc.print();
        }

        System.out.println("\n--- Keuntungan Setelah Refactoring ---");
        System.out.println("✓ Focused - Setiap interface punya capability yang jelas dan spesifik");
        System.out.println("✓ Flexible - Class hanya implement capability yang benar-benar dimiliki");
        System.out.println("✓ Type-safe - Compile-time checking, bukan runtime exception");
        System.out.println("✓ Clean - Tidak ada method yang throw UnsupportedOperationException");
        System.out.println("✓ Extensible - Mudah tambah document type baru dengan capability mix & match");
    }
}
