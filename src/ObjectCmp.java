import Sort.Node;

import java.util.Comparator;

public class ObjectCmp implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        int a = Integer.valueOf(o1.getProperty("money"));
        int b = Integer.valueOf(o2.getProperty("money"));

        if(a<b){
            return -1;
        }else if(a==b){
            return 0;
        }else {
            return 1;
        }
    }
}
