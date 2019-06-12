import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class test {
    public static void main(String [] argv) throws IOException {
        String[] a = Input.file("C:/Users/E5575G53X/Desktop/A.csv", "Integer");
        for(int i =0;i<a.length;i++)
            System.out.println(a[i]);
    }
}

