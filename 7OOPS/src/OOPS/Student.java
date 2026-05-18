package OOPS;

public class Student {
    public String name;
    private int rno;
    public double percent;

    public final String school = "OOPSinJava";

    public int getRno(){
        return rno;
    }

    public void setRno(int rno){
        this.rno = rno;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rno=" + rno +
                ", percent=" + percent +
                '}';
    }
}
