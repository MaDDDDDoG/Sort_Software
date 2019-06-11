import java.util.Comparator;

public class DoubleCmp implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        double a = Double.valueOf(o1.getProperty("value"));
        double b = Double.valueOf(o2.getProperty("value"));

        if(a<b){
            return -1;
        }else if(a==b){
            return 0;
        }else {
            return 1;
        }
    }
}