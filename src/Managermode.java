import java.io.*;

public class Managermode {
    String title;
    
    public void setTitle(String title) {
        this.title = title;
    }
    public void RegProduct() {
        String fileName = "c:/Soonja's shop/productList.txt";
        
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            
        } catch(Exception e) {
            System.out.println("error");
            System.out.println(e.getMessage());
        }
    }
}
