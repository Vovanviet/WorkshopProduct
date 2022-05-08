package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Product;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WriteFile {

    public static List<Product> WriteFile(List<Product> product){
        try {

//            StringBuilder str = new StringBuilder();
//            FileOutputStream outputStream = new FileOutputStream("product.json");
//            for(Product product1: product){
//                str.append(product1.toString());
//            }
//
//            byte[] strToBytes = str.toString().getBytes();
//            outputStream.write(strToBytes);
//
//            outputStream.close();
//            System.out.println("Successfully wrote to the file");
            Gson gson=new GsonBuilder().setPrettyPrinting().create();
            Writer writer=Files.newBufferedWriter(Paths.get("product.json"), StandardCharsets.UTF_8);
            gson.toJson(product,writer);
            writer.close();
            System.out.println("Success");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return null;
    }
}
