class Encapsulation{
    private int emp_id;
    public void setEmp_id(int emp_id1){
        emp_id=emp_id1;
    }
    public int getEmp_id(){
        return emp_id;
    }

}
class Main{
    public static void main(String[] args) {
        Encapsulation e = new Encapsulation();
        e.setEmp_id(10);
        System.out.println(e.getEmp_id());
    }
}