// Document.java
abstract class Document {
    private String name;

    public Document(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void open();
    public abstract void save();
    public abstract void close();
}

// WordDocument.java
class WordDocument extends Document {
    public WordDocument(String name) {
        super(name);
    }

    @Override
    public void open() {
        System.out.println("Opening Word document: " + getName());
    }

    @Override
    public void save() {
        System.out.println("Saving Word document: " + getName());
    }

    @Override
    public void close() {
        System.out.println("Closing Word document: " + getName());
    }
}

// PdfDocument.java
class PdfDocument extends Document {
    public PdfDocument(String name) {
        super(name);
    }

    @Override
    public void open() {
        System.out.println("Opening PDF document: " + getName());
    }

    @Override
    public void save() {
        System.out.println("Saving PDF document: " + getName());
    }

    @Override
    public void close() {
        System.out.println("Closing PDF document: " + getName());
    }
}

// ExcelDocument.java
 class ExcelDocument extends Document {
    public ExcelDocument(String name) {
        super(name);
    }

    @Override
    public void open() {
        System.out.println("Opening Excel document: " + getName());
    }

    @Override
    public void save() {
        System.out.println("Saving Excel document: " + getName());
    }

    @Override
    public void close() {
        System.out.println("Closing Excel document: " + getName());
    }
}

// DocumentFactory.java
abstract class DocumentFactory {
    public abstract Document createDocument(String name);
}

// WordDocumentFactory.java
class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument(String name) {
        return new WordDocument(name);
    }
}

// PdfDocumentFactory.java
class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument(String name) {
        return new PdfDocument(name);
    }
}

// ExcelDocumentFactory.java
class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument(String name) {
        return new ExcelDocument(name);
    }
}
// DocumentFactoryTest.java
public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument("Word Document");
        wordDoc.open();
        wordDoc.save();
        wordDoc.close();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument("PDF Document");
        pdfDoc.open();
        pdfDoc.save();
        pdfDoc.close();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument("Excel Document");
        excelDoc.open();
        excelDoc.save();
        excelDoc.close();
    }
}
