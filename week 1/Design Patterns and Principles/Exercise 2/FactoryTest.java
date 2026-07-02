public class FactoryTest {

    public static void main(String[] args) {

        DocumentFactory word = new WordFactory();
        Document d1 = word.createDocument();
        d1.open();

        DocumentFactory pdf = new PdfFactory();
        Document d2 = pdf.createDocument();
        d2.open();

        DocumentFactory excel = new ExcelFactory();
        Document d3 = excel.createDocument();
        d3.open();

    }

}