package infyJava.serializableAndDeSerializable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializable {

    public static void main(String[] args) {
        try {
            Terms term1 = readTermsFromFile("src/infyJava/serializableAndDeSerializable/term1.txt", "Term1", "Joye");
            serializeTerm(term1, "JoyeTerm1.dat");
            System.out.println("Term Serialize Successful");
        }
        catch (Exception e){
            System.err.println("Error read or write file"+e.getMessage());
        }
    }

    private static Terms readTermsFromFile(String filName, String termName, String studentName) throws IOException{
        List<Mark> marks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filName))){
            String line ;
            while ((line = br.readLine()) != null){
                String[] parts = line.split(",");
                if (parts.length == 2){
                    String subject = parts[0].trim();
                    double mark = Double.parseDouble(parts[1].trim());
                    marks.add(new Mark(subject, mark));
                }
            }
        }
        return new Terms(termName, studentName, marks);
    }

    public static void serializeTerm( Terms terms, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(terms);
        }
    }
}
