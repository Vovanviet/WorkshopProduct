package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entity.Product;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class ReadFileGson {
    public List<Product>products;
    public List<Product> getDataGson(){
        try {
            FileReader reader=new FileReader("product.json");
            Type type=new TypeToken<List<Product>>(){}.getType();
            products=new Gson().fromJson(reader,type);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }
}
