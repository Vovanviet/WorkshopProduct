package model;

import com.google.gson.Gson;
import entity.Product;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {

    public static List<Product> WriteFile(List<Product> product){
//        try {
//            FileWriter myWriter = new FileWriter("Student.json");
//
//            Gson gson = new Gson();
//
//            myWriter.write(gson.toJson(product));
//
//            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
        try {
//            FileWriter myWrite=new FileWriter("Student.json");
//                myWrite.write(String.valueOf(students));
//                myWrite.close();
//            System.out.println("Successfully wrote to the file");
////
            StringBuilder str = new StringBuilder();
            FileOutputStream outputStream = new FileOutputStream("Student.json");
            for(Product product1: product){
                str.append(product1.toString());
            }

            byte[] strToBytes = str.toString().getBytes();
            outputStream.write(strToBytes);

            outputStream.close();
            System.out.println("Successfully wrote to the file");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
}
