package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entity.Product;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFileGson {
    public List<Product>products;
    public List<Product> getDataGson(){
        try {
            Gson gson=new Gson();
            Reader reader= Files.newBufferedReader(Paths.get("product.json"), StandardCharsets.UTF_8);
            products=gson.fromJson(reader,new TypeToken<List<Product>>(){}.getType());
            reader.close();
           return products;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
}
