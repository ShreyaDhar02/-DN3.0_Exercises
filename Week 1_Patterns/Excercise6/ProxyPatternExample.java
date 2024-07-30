
 interface Image {
    void display();
}

class RealImage implements Image {
    private String url;

    public RealImage(String url) {
        this.url = url;
        loadFromServer();
    }

    private void loadFromServer() {
        System.out.println("Loading image from server: " + url);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + url);
    }
}

class ProxyImage implements Image {
    private String url;
    private RealImage realImage;

    public ProxyImage(String url) {
        this.url = url;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(url);
        }
        realImage.display();
    }
}

public class ProxyPatternExample {
    public static void main(String[] args) {
        // Create proxy images
        Image image1 = new ProxyImage("http://image1.jpg");
        Image image2 = new ProxyImage("http://image2.png");

        // Display images
        image1.display();
        image2.display();
        image1.display(); 
        image2.display(); 
    }
}