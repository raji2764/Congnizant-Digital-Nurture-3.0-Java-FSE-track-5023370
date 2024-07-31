// Step 2: Define Document Classes
interface Document {
    void display();
}

// Abstract class for Word documents
abstract class WordDocument implements Document {
    @Override
    public void display() {
        System.out.println("Displaying Word document...");
    }
}

// Abstract class for PDF documents
abstract class PdfDocument implements Document {
    @Override
    public void display() {
        System.out.println("Displaying PDF document...");
    }
}

// Abstract class for Excel documents
abstract class ExcelDocument implements Document {
    @Override
    public void display() {
        System.out.println("Displaying Excel document...");
    }
}

// Step 3: Create Concrete Document Classes
class WordDoc2003 extends WordDocument {
    @Override
    public void display() {
        System.out.println("Displaying Word 2003 document...");
    }
}

class WordDoc2007 extends WordDocument {
    @Override
    public void display() {
        System.out.println("Displaying Word 2007 document...");
    }
}

class PdfDocA4 extends PdfDocument {
    @Override
    public void display() {
        System.out.println("Displaying PDF A4 document...");
    }
}

class PdfDocLetter extends PdfDocument {
    @Override
    public void display() {
        System.out.println("Displaying PDF Letter document...");
    }
}

class ExcelDoc2003 extends ExcelDocument {
    @Override
    public void display() {
        System.out.println("Displaying Excel 2003 document...");
    }
}

class ExcelDoc2007 extends ExcelDocument {
    @Override
    public void display() {
        System.out.println("Displaying Excel 2007 document...");
    }
}

// Step 4: Implement the Factory Method
abstract class DocumentFactory {
    abstract Document createDocument();
}

class WordFactory extends DocumentFactory {
    @Override
    Document createDocument() {
        return new WordDoc2007();
    }
}

class PdfFactory extends DocumentFactory {
    @Override
    Document createDocument() {
        return new PdfDocA4();
    }
}

class ExcelFactory extends DocumentFactory {
    @Override
    Document createDocument() {
        return new ExcelDoc2007();
    }
}

// Step 5: Test the Factory Method Implementation
public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        DocumentFactory factory;

        // Create a Word document
        factory = new WordFactory();
        Document wordDoc = factory.createDocument();
        wordDoc.display();

        // Create a PDF document
        factory = new PdfFactory();
        Document pdfDoc = factory.createDocument();
        pdfDoc.display();

        // Create an Excel document
        factory = new ExcelFactory();
        Document excelDoc = factory.createDocument();
        excelDoc.display();
    }
}