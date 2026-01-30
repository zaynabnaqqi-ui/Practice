class Student {
   String student_name;
   int marks;
   long student_id;
   public void displayStudentDetails(){
     System.out.println("Details of student is as follows:");
    System.out.println("Student Name: "+ student_name);
    System.out.println("Id: "+ student_id);
    System.out.println("Marks: "+ marks);
    System.out.println();
   }
}
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        s1.student_name = "Zaynab";
        s1.student_id = 123456;
        s1.marks = 92;
        s2.student_name = "Aisha";
        s2.student_id = 123444;
        s2.marks = 45;
        s1.displayStudentDetails();
        s2.displayStudentDetails();
        }
}
