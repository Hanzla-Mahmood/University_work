class Encapsulation{
    private int Area ;
    public void setArea(int emp_id1){

        Area=emp_id1;
    }
    public int getEmp_id(){
        return Area;
    }

}
class Main{
    public static void main(String[] args) {
        Encapsulation e = new Encapsulation();
        e.setArea(10*10);
        System.out.println("Area is-"+e.getEmp_id());
    }
}