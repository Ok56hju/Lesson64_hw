package ait.bags.model;

public class Dadlock implements Runnable {
    A a = new A();
    B b = new B();
    Dadlock() {
        Thread.currentThread().setName("Главный поток");
        Thread t = new Thread(this, "Соперничающий поток");
        t.start();
        a.foo(b); // получить блокировку для объекта a в этом потоке исполнения
        System.out.println("Назад в главный поток");
    }
    public void run() {
        b.bar(a); // получить блокировку для объекта b в другом потоке исполнения
        System.out.println("Назад в другой поток");
    }
    public static void main(String[] args) {
        new Dadlock();
    }
}
