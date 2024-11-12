// import System;

public class Invoice{

    Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity){
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculatePrice(){
        return (marker.price * this.quantity);
    }

    // public void printInvoice(){
    //     System.out.println(String.format("Item:- %s",marker.brand));
    // }

    // public void saveToDB(){
    //     //  Save the data into DB
    // }

    public static void main(String[] arg){
        Invoice invoice = new Invoice(new Marker("Green",2,"Camlin"),8);
        System.out.println(invoice.calculatePrice());
        InvoicePrinter invoicePrinter = new InvoicePrinter(invoice);
        invoicePrinter.print();
        InvoiceDao dao = new DatabaseInvoiceDao();
        dao.save(invoice);


        Bike b = new Bicycle();
        b.turnOnEngine();
        b.accelerate();
        b.showSpeed();


    }
}

class InvoicePrinter{
    private Invoice invoice;

    public InvoicePrinter(Invoice invoice){
        this.invoice = invoice;
    }

    public void print(){
        System.out.println(String.format("Item:- %s",invoice.marker.brand));   
    }
}

interface InvoiceDao{
    public void save(Invoice invoice);
}


class DatabaseInvoiceDao implements InvoiceDao{

    @Override
    public void save(Invoice invoice){
        System.out.println(String.format("Saving into DB: %s", invoice.marker.brand));
    }

}

class FileInvoiceDao implements InvoiceDao{

    @Override
    public void save(Invoice invoice){
        System.out.println(String.format("Savinf File: %s", invoice.marker.brand));
    }
}


class Marker{
     String color;
     int price;
     String brand;

     public Marker(String color, int price, String brand){
        this.color = color;
        this.price = price;
        this.brand = brand;
     }
}

interface Bike{

    void turnOnEngine();
    void accelerate();
    void showSpeed();
}

class Motorcycle implements Bike{

    boolean isStarted;
    int speed=0;

    public void turnOnEngine(){
        isStarted = true;
    }
    public void accelerate(){
        speed += 10;
    }

    public void showSpeed(){
        System.err.println("Speed is : "+speed);
    }
}

class Bicycle implements Bike{

    boolean isStarted;
    int speed =0;
    
    public void turnOnEngine(){ // Here it breaks behaviour of class Motorcycle
        throw new AssertionError("there is no engine");
    }

    public void accelerate(){
        speed+=10;
    }
    public void showSpeed(){
        System.err.println("Speed is : "+speed);
    }
}

interface RestaurantEmployee {
    void washDishes();
    void serveCustomer();
    void cookFood();
}

// class Waiter implements RestaurantEmployee{

//     public void washDishes(){
//         // waiter don't wash dishes
//     }
//     public void serveCustomer(){
        
//     }
//     public void cookFood(){
//         // waiter don't cook food
//     }
// }


interface WaiterInterface {
    void serveCustomer();
    void takeOrder();
}

interface ChefInterface {
    void cookFood();
    void decideMenu();
}

class Waiter implements WaiterInterface{

    public void serveCustomer(){
        System.err.println("Waiter serving customer");
    }
    public void takeOrder(){
        System.err.println("Waiter taking order");
    }
}

interface keyboard{

}
interface Mouse{

}
class WiredKeyboard implements keyboard{

}
class BtKeyboard implements keyboard{
    
}
class WiredMouse implements keyboard{

}
class BtMouse implements keyboard{
    
}
// class MacBook{
//     WiredKeyboard keyboard;
//     WiredMouse mouse;

//     public void MacBook(){
//         keyboard = new WiredKeyboard();
//         mouse = new WiredMouse();
//     }
// }

class MacBook{
    keyboard keyboard;
    Mouse mouse;

    public void MacBook(keyboard keyboard, Mouse mouse){
        this.keyboard = keyboard;
        this.mouse = mouse;
    }
}