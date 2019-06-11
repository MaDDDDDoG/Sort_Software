import java.util.Comparator;

public class ObjectCmp implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        String a = o1.getName();
        String b = o2.getName();

        return a.compareTo(b);
    }
}
