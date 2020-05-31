package LINKEDIN;

public class pgram {
    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        Runnable r = () -> {

            String s = null;
            try {
                s = a.sing();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(s);
            System.out.println("Thread.name " + Thread.currentThread().getName());

        };
        Thread t;
        for (int i = 0; i < 3; i++) {
            t = new Thread(r);
            t.start();
            System.out.println("Thread.name " + Thread.currentThread().getName());
        }

    }
}

class A extends B {
    public  String sing() throws InterruptedException {
        String s = "fa";
        for (int i = 0; i < 5; i++) {
            Thread.sleep(2000);
            s = s.concat(String.valueOf(i));
        }
        return s;
    }

}

class B {
    public String sing() throws InterruptedException {
        return "la";
    }
}