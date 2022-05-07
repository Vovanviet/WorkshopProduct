package view;

import controller.ProductController;
import entity.Product;
import model.ReadFileGson;
import model.WriteFile;

import java.util.List;
import java.util.Scanner;

public class ProductConsole {
    private final Scanner sc;

    public ProductConsole() {
        this.sc = new Scanner(System.in);
    }

    int main(){
        System.out.println("--------Product Management---------");
        System.out.println("1.Create Product");
        System.out.println("2.Search Product");
        System.out.println("3.Delete Product");
        System.out.println("4.Display All Product");
        System.out.println("5.Write to Json");
        System.out.println("6.Read from Json");
        System.out.println("7.Update Product");
        System.out.println("8.Exit");
        System.out.println("Your choice:");
        int choice=readInt(1,8);
        return choice;
    }
    public int readInt(int min , int max){
        int choice;
        while (true){
            try {
                choice=Integer.parseInt(sc.next());
                if (choice>=min&&choice<=max)break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return choice;
    }
    public void start(){
        while (true){
            int choice=main();
            switch (choice){
                case 1:
                    createProduct();
                    break;
                case 2:
                    searchProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    getAll();
                    break;
                case 5:
                    WriteFile();
                    break;
                case 6:
                    ReadFile();
                    break;
                case 7:
                    updateProduct();
                    break;
                case 8:
                    System.out.println("Pai Pai");
                    System.exit(8);
                default:
                    throw new AssertionError();
            }
        }
    }
    private void createProduct(){
        System.out.println("Enter product name:");
        String newName= sc.next();
        System.out.println("Enter description product:");
        String newDesc= sc.next();
        System.out.println("Enter price:");
        Double newPrice= sc.nextDouble();
        Product product=new Product(newName,newDesc,newPrice);
        ProductController productController=new ProductController();
        productController.createProduct(product);
    }
    private void deleteProduct(){
        System.out.println("Enter name product:");
        String proName= sc.next();
//        Product product=new Product(proName);
        ProductController productController=new ProductController();
        productController.deleteProduct(proName);
    }
    private void searchProduct(){
        System.out.println("Enter name product:");
        String proName= sc.next();
        ProductController productController=new ProductController();
        productController.searchProduct(proName);
    }
    private void updateProduct(){
        System.out.println("Enter product name:");
        String newName= sc.next();
        System.out.println("Enter description product:");
        String newDesc= sc.next();
        System.out.println("Enter price:");
        Double newPrice= Double.parseDouble(sc.next());
        Product product=new Product();
        product.setProName(newName);
        product.setProDesc(newDesc);
        product.setPrice(newPrice);
        ProductController productController=new ProductController();
        productController.updateProduct(product);
    }
    private void getAll(){
        ProductController productController=new ProductController();
        productController.getAllProduct();
    }
    private void WriteFile(){
//        System.out.println("Enter product name:");
//        String newName= sc.next();
//
//        System.out.println("Enter description product:");
//        String newDesc= sc.next();
//        System.out.println("Enter price:");
//        Double newPrice= sc.nextDouble();
//        Product product=new Product(newName,newDesc,newPrice);
        ProductController productController=new ProductController();
        List<Product> products= productController.getAllProduct();
        WriteFile.WriteFile(products);
    }
    private void ReadFile(){
        ReadFileGson readFileGson=new ReadFileGson();
        readFileGson.getDataGson();
        System.out.println(readFileGson);
    }

}
