import Sort.Node;

import java.util.Comparator;

public class StringCmp implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        String a = o1.getProperty("value");
        String b = o2.getProperty("value");

        return a.compareTo(b);
    }
}
