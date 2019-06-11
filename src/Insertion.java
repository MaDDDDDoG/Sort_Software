import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class Insertion {
    static public Deque<SwapPair> sort(Node[] arr, int[] index_arr, int n, Comparator<Node> cmp){
        Deque<SwapPair> deque = new LinkedList<>();

        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0 && cmp.compare(arr[index_arr[j]], arr[index_arr[j+1]]) > 0;j--){
                int tempj0 = index_arr[j];
                int tempj1 = index_arr[j+1];
                index_arr[j] = tempj1;
                index_arr[j+1] = tempj0;
                deque.offerLast(new SwapPair(j, j+1));
            }
        }

        return deque;
    }
}
