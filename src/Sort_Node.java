import java.util.*;

public class Sort_Node {
    static Deque<SwapPair> Inerstion_Sort(Node[] arr, int n, Comparator<Node> cmp){
        Deque<SwapPair> deque = new LinkedList<>();

        for(int i=1;i<n;i++){
            Node key = arr[i];
            int j = i - 1;
            while(j>=0 && cmp.compare(arr[j], key)>0){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;

            deque.offerLast(new SwapPair(i, j+1));
        }

        return deque;
    }
}
