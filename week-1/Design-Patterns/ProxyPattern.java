package designpatterns;

interface Image {
    void display();
}

class RealImage implements Image {

    String name;

    RealImage(String name) {
        this.name = name;
        System.out.println("Loading " + name);
    }

    public void display() {
        System.out.println("Showing " + name);
    }
}

class ProxyImage implements Image {

    String name;
    RealImage image;

    ProxyImage(String name) {
        this.name = name;
    }

    public void display() {

        if (image == null) {
            image = new RealImage(name);
        }

        image.display();
    }
}

public class ProxyPattern {

    public static void main(String[] args) {

        Image img = new ProxyImage("photo.jpg");

        img.display();

        img.display();
    }
}