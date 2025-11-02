package TestPackage;

class Student{
    //Required Parameter
    private String name;
    private int age;

    //Optional Parameter
    private String address;
    private String phone;
    private String course;

    //private constructor
    private Student (StudentBuilder builder){
        this.name = builder.name;
        this.age  = builder.age;
        this.address = builder.address;
        this.phone = builder.phone;
        this.course = builder.course;
    }
    //static nexted BUILDER class
    public static class StudentBuilder{
        private String name;
        private int age;
        private String address;
        private String phone;
        private String course ;

        //Constructor for required field
        public StudentBuilder(String name, int age){
            this.name = name;
            this.age = age;
        }
        //Method for optional field

        public StudentBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public StudentBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public StudentBuilder setCourse(String course) {
            this.course = course;
            return this;
        }
        //Build method to return final object
        public  Student build(){
            return new Student(this);
        }

    }
        @Override
        public String toString() {
            return "Student{name ='" + name + "', age " + age +
                        "', address = '" + address + "', phone ='" + phone +
                        "', course '" + course + "'}";
        }
                       
}
public class BuilderDesign {

    public static void main(String[] args) {
        //Building Obj step by step
        Student s1 = new Student.StudentBuilder("Jon", 24).build();
        Student s2 = new Student.StudentBuilder("Bob", 23)
                .setAddress("Toronto")
                .setCourse("Computer Science")
                .build();
        Student s3 = new Student.StudentBuilder("Rajesh", 24)
                .setAddress("Jaipur")
                .setCourse("Mechanical Engineering")
                .setPhone("8989012345")
                .build();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }

}
