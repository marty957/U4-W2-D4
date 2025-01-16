package org.example;


import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.*;
import java.util.stream.Collectors;

public class Main
{
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static Faker fake= new Faker(new Locale("it"));



    public static List<Costumer> listCostumer= new ArrayList<>();
    public static List<Product> listProduct= new ArrayList<Product>();
    public static List<Order> listOrder= new ArrayList<Order>();



    public static void main( String[] args ) {

        createCostumer();
        createProductList();
        createOrderList();

      List <Product> moreExpen=listProduct.stream()
                       .max(Comparator.comparing(Product::getPrice)).stream().toList();



        System.out.println(moreExpen);

        OptionalDouble averagePrice=listProduct.stream().mapToDouble(Product::getPrice).average();
        System.out.println(averagePrice);


     /*   for(int i =0;i<listCostumer.size();i++){
            Costumer costumer=listCostumer.get(i);
            Map<String,Integer> importoTot=  listOrder.stream()
                    .filter(ele -> ele.getCustomer().equals(costumer))
                    .mapToDouble(Order::ge)*/


 Map<String,Double> categories=listProduct.stream().collect(Collectors.groupingBy(Product::getCategory,
         Collectors.summingDouble(Product::getPrice)));


        System.out.println(categories.toString());




    }

    public static void createCostumer(){

        Costumer c1= new Costumer(1,fake.name().fullName(),1);
        Costumer c2= new Costumer(2,fake.name().fullName(),2);
        Costumer c3= new Costumer(3,fake.name().fullName(),3);
        Costumer c4= new Costumer(4,fake.name().fullName(),4);
        Costumer c5= new Costumer(5,fake.name().fullName(),5);
        Costumer c6= new Costumer(6,fake.name().fullName(),6);

        listCostumer.addAll(Arrays.asList(c1,c2,c3,c4,c5,c6));

}
    public static void createProductList() {
        // Books - Baby - Boys
        Product p1 = new Product(1, "Iphone", "Smartphone", 1000);
        Product p2 = new Product(2, "ABC", "Books", 127.15);
        Product p3 = new Product(3, "Pannolini", "Baby", 5.8);
        Product p4 = new Product(4, "Il Signore Degli Anelli", "Books", 31);
        Product p5 = new Product(5, "Spiderman", "Boys", 100);
        Product p6 = new Product(6, "Ciuccio", "Baby", 2);

        listProduct.addAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
    }

    public static void createOrderList(){
        Order o1=new Order(1,listCostumer.get(1));
        Order o2=new Order(2,listCostumer.get(1));
        Order o3=new Order(3,listCostumer.get(2));
        Order o4=new Order(4,listCostumer.get(3));
        Order o5=new Order(5,listCostumer.get(4));
        Order o6=new Order(6,listCostumer.get(5));

        Product p1 = listProduct.get(1);
        Product p2 = listProduct.get(1);
        Product p3 = listProduct.get(2);
        Product p4 = listProduct.get(3);
        Product p5 = listProduct.get(4);
        Product p6 = listProduct.get(5);

        o1.addProduct(p1);
        o1.addProduct(p3);
        o1.addProduct(p5);

        o2.addProduct(p1);
        o2.addProduct(p4);

        o3.addProduct(p2);
        o3.addProduct(p4);
        o3.addProduct(p3);
        o3.addProduct(p6);

        o4.addProduct(p2);
        o4.addProduct(p6);

        o5.addProduct(p1);
        o5.addProduct(p2);
        o5.addProduct(p4);

        listOrder.addAll(Arrays.asList(o1,o2,o3,o4,o5,o6));


    }

}
