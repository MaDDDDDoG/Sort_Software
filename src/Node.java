import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Node {
    private String[] property;
    private String object;
    static private String class_name;
    static private HashMap<String, Integer> item_index;
    static private HashMap<String, String> item_type;
    static private int property_size;

    public Node(String name, List<String> property){
        object = name;
        this.property = new String[property_size];

        for(int i=0;i<property_size;i++){
            this.property[i] = property.get(i);
        }
    }

    static public void initialize_Node(String name, List<String> item_n, List<String> item_t){
        class_name = name;
        property_size = item_n.size();
        item_index = new HashMap<>();
        item_type = new HashMap<>();

        for(int i=0;i<property_size;i++){
            item_index.put(item_n.get(i), i);
            item_type.put(item_n.get(i), item_t.get(i));
        }
    }
}
