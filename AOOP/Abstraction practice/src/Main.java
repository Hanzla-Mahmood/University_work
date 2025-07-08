abstract class Vehicle{

    int no_of_tyres;
    abstract void start();
        }
        class Car extends Vehicle{
         void start(){
             System.out.println("Starts with kick");
         }

        }
        class Main{
            public static void main(String[] args) {
                Car c = new Car();
                c.start();
            }
        }
