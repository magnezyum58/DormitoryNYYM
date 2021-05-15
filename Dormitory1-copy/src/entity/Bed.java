package entity;

public final class Bed {

    private int bedNumber;
    private int studentId;
    private boolean full;

    public Bed() {
        this.full = false;
    }

    public Bed(int bedNumber, int studentId) {
        this.bedNumber = bedNumber;
        this.studentId = studentId;
        this.full = true;
    }
    
    public void addStudent(int studentId){
        this.studentId=studentId;
        this.full=true;
    }
    
    public void removeStudent(){
        this.studentId=0;
        this.full=false;
    } 

    public int getBedNumber() {
        return bedNumber;
    }

    public int getStudentId() {
        return studentId;
    }

    public boolean isFull() {
        return full;
    }
    
}
