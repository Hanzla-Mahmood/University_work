abstract class Animal{
    protected int legs;
    protected Animal(int legs ){
         this.legs= legs ;
    }
    abstract void eat();
    void walk(){
        System.out.println("Animals walk by using legs");
    }
}
class spider extends Animal{
     spider(){
         super(8);
         System.out.println("All the spiders have legs"+legs);
        }
        void eat(){
            System.out.println("I am EAT Method");
        }
    }
    interface pet{

    }
class Cat extends Animal {
    String name;

    public Cat(String name) {
        super(4);
        this.name = name;
    }


    public String getName(String name){
        return  name;
    }

    //
    public Cat() {
        this("Fluffy");//calling previous constructor using this keyword and giving name
    }

    void eat() {
        System.out.println("I am EAT Method");
    }
}

 class Fish extends Animal {
   Fish(){
       super(0);
   }
   public void eat(){
       System.out.println("Fish can't walk and don't have 4 legs ");

   }
}
class Main{
    public static void main(String[] args) {
        Fish d = new Fish();
        d.eat();
        Cat c = new Cat("Fluffy");
        System.out.println(c.getName("Fluffly"));
        Animal a = new Fish();
        a.walk();
        Animal e = new spider();
        e.eat();
    }
}