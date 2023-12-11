package ait.bags.model;

class B {
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " вошел в метод B.bar()");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("class B is break");
        }
        System.out.println(name + " пытается вызвать метод A.last()");
        a.last();
    }
    synchronized void last() {
        System.out.println("В методе A.last()");
    }
}