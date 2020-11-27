public class Student {

    static String myClass ="DEP";

    String id;
    String name;
    int marks;

    public void printDetails(String id){
        System.out.println("Student [id=" + id + ", name=" + this.name + ", marks=" + Student.myClass + "]");
    }

    public static void printGrade(){
        System.out.println(myClass);
    }

}
