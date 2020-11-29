package src.main.java.rnd;

public class InheritanceTest {

    public static void main(String[] args) {
    //A x=new A();
//    for(int i=0;i<5;i++){
//        A x=new A();
//        x.show();
//    }
        B b =new B();
        b.show();
    }
}

class A{
    int a=100;
    public void show() throws Exception{
        System.out.println(a++);
    }
}
class B extends A{
    public void show(){
        System.out.println(a+9);
    }
}