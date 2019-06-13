import Sort.Inspector;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Input {
    static public String[] file(String path, String type) throws IOException {
        if(type.equals("Object")) return new String[0]; // no object

        List<String> arr = new ArrayList<>();

        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        while (br.ready()) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ",");
            for(int i=0;i<8 && st.hasMoreTokens();i++){
                if(type.equals("Integer"))
                    arr.add(Inspector.check_int(st.nextToken()));
                else if(type.equals("Double"))
                    arr.add(Inspector.check_double(st.nextToken()));
                else if(type.equals("String"))
                    arr.add(Inspector.check_string(st.nextToken()));
            }
        }
        fr.close();

        String[] temp = new String[arr.size()];
        for(int i=0;i<arr.size();i++) temp[i] = arr.get(i);

        return temp;
    }

    static public String[] random_generate(String type){
        if(type.equals("Object")) return new String[0]; //no object

        int max = 8, min = 1;
        int n = (int) (Math.random() * (max - min + 1) + min);

        String[] arr = new String[n];

        for(int i=0;i<n;i++){
            if(type.equals("Integer"))
                arr[i] = String.valueOf((int)(Math.random() * (100 - 0 + 1) + 0));
            else if(type.equals("Double"))
                arr[i] = String.valueOf(Math.random() * 100);
            else if(type.equals("String"))
                arr[i] = String.valueOf((char)(int)(Math.random() * (127 - 0 + 1) + 0));
        }

        return arr;
    }
}
