// Step 2: Define Subject Interface
interface Image {
    void display();
}

// Step 3: Implement Real Subject Class
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromServer();
    }

    private void loadImageFromServer() {
        System.out.println("Loading image from server: " + filename);
        // Simulate time-consuming operation
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Step 4: Implement Proxy Class
class ProxyImage implements Image {
    private String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Step 5: Test the Proxy Implementation
public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // Image will be loaded from server
        image1.display();

        // Image will not be loaded from server, cached version will be displayed
        image1.display();

        // Image will be loaded from server
        image2.display();

        // Image will not be loaded from server, cached version will be displayed
        image2.display();
    }
}
