import java.util.Comparator;

public class IntCmp implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        int a = Integer.valueOf(o1.getProperty("value"));
        int b = Integer.valueOf(o2.getProperty("value"));

        if(a<b){
            return -1;
        }else if(a==b){
            return 0;
        }else {
            return 1;
        }
    }
}
