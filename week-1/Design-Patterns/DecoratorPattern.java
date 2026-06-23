package designpatterns;

interface Coffee {
    String getName();

    int getPrice();
}

class BasicCoffee implements Coffee {

    public String getName() {
        return "Coffee";
    }

    public int getPrice() {
        return 30;
    }
}

class Milk implements Coffee {

    Coffee coffee;

    Milk(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getName() {
        return coffee.getName() + " + Milk";
    }

    public int getPrice() {
        return coffee.getPrice() + 10;
    }
}

class Sugar implements Coffee {

    Coffee coffee;

    Sugar(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getName() {
        return coffee.getName() + " + Sugar";
    }

    public int getPrice() {
        return coffee.getPrice() + 5;
    }
}

public class DecoratorPattern {

    public static void main(String[] args) {

        Coffee coffee = new BasicCoffee();

        System.out.println(coffee.getName());
        System.out.println("Price = " + coffee.getPrice());

        coffee = new Milk(coffee);
        coffee = new Sugar(coffee);

        System.out.println(coffee.getName());
        System.out.println("Price = " + coffee.getPrice());
    }
}