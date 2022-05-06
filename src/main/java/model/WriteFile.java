package model;

import com.google.gson.Gson;
import entity.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {

    public static List<Product> WriteFile(Product product){
        try {
            FileWriter myWriter = new FileWriter("Student.json");

            Gson gson = new Gson();

            myWriter.write(gson.toJson(product));

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
}
