package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Product;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WriteFile {

    public static void WriteFile(List<Product> product){
        try {
            Gson gson=new GsonBuilder().setPrettyPrinting().create();
            Writer writer=Files.newBufferedWriter(Paths.get("product.json"), StandardCharsets.UTF_8);
            gson.toJson(product,writer);
            writer.close();
            System.out.println("Write Success to Json");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
