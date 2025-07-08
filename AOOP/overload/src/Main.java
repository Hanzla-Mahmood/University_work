class A {
    int show(int a, float b) {
        System.out.println("method " + a + b);

    }

    float show(float c, int d) {
        System.out.println("method overloading" + c + d);
    }
}
class Main{
    public static void main(String[] args) {
        A over =new A();
        over.show(11,8.8f);
        over.show(2.44f,1);
    }
}


