package model;

import com.google.gson.Gson;
import entity.Product;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {

    public static List<Product> WriteFile(List<Product> product){
        try {

            StringBuilder str = new StringBuilder();
            FileOutputStream outputStream = new FileOutputStream("product.json");
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
