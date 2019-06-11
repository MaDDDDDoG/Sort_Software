import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class Quick {
    static private Deque<SwapPair> deque;
    static private Node[] nodes;
    static private Comparator<Node> compa;
    static private int[] index_a;

    static public Deque<SwapPair> sort(Node[] arr, int[] index_arr, int n, Comparator<Node> cmp){
        deque = new LinkedList<>();
        nodes = arr;
        compa = cmp;
        index_a = index_arr;
        QuickSort(0, n-1);

        return deque;
    }

    static private int partition(int l, int h)
    {
        int i = (l - 1);

        for (int j = l; j <= h - 1; j++) {
            if (compa.compare(nodes[index_a[j]], nodes[index_a[h]]) <= 0) { //  nodes[arr[j]] <= nodes[arr[h]]
                i++;

                if(i==j) continue;

                int temp0 = index_a[j];
                int temp1 = index_a[i];
                index_a[i] = temp0;
                index_a[j] = temp1;
                deque.offerLast(new SwapPair(i, j));
            }
        }

        if(h==i+1) return (i+1);

        int temp0 = index_a[i+1];
        int temp1 = index_a[h];
        index_a[h] = temp0;
        index_a[i+1] = temp1;
        deque.offerLast(new SwapPair(i+1, h));

        return (i + 1);
    }

    static private void QuickSort(int l, int h)
    {
        if (l < h) {
            int p = partition(l, h);
            QuickSort(l, p - 1);
            QuickSort(p + 1, h);
        }
    }

}
