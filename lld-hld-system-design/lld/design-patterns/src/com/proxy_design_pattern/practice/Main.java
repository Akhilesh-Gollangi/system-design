package com.proxy_design_pattern.practice;

public class Main {

    public static void main(String[] args) {
        // problem here  we create object it will take some  time to create object because loadFromdisk
        // has complex logic and operaitons
        Document document = new RealDocument("Ak");
        document.display();
        // From user perspective he will object creation is slow, even though he donot use disply, we are loading
        // To fix we cannot make changes in exisiting code as it is used in many places,lead to breakage

        // we will have a new class DocumentProxy which will create object, but the time of disply
        // it will load this will sort the issue

        DocumentProxy documentProxy = new DocumentProxy("ASA");
        documentProxy.display();

        //in document proxy we load disk when we are dispalyinh actualy lazy loading
    }
}
