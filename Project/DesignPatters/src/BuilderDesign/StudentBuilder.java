package BuilderDesign;

class Student{
    //required field
    private String name;
    private int age;

    //optional parameters
    private String address;
    private String phone;
    private String course;

    //
    private Student(StudentBuilder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
        this.phone = builder.phone;
        this.course = builder.course;
    }


    //static nesteed class builder
    public class StudentBuilder {

        private String name;
        private int age;
        private String address;
        private String course;
        private String phone;


        //constructor for required field
        public StudentBuilder(String name, int age){
            this.name = name;
            this.age = age;
        }

        //method for optional fields
        public StudentBuilder setAddress(String address){
            this.address = address;
            return this;
        }

        public StudentBuilder setPhone(String phone){
            this.phone = phone;
            return  this;
        }

        public StudentBuilder setCourse(String course){
            this.course  = course;
            return this;
        }

        public Student build(){
            return  new Student(this);
        }
    }

    @Override
    public String toString(){
        return "Student{name="+name+" ', age = "+age+" ,address = "+address+" , phone = "+phone+", course = "+course;
    }

    public static void main(String[] args) {

    }
}

