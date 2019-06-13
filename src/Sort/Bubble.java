package Sort;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class Bubble {
    static public Deque<SwapPair> sort(Node[] arr, int[] index_arr, int n, Comparator<Node> cmp){
        Deque<SwapPair> deque = new LinkedList<>();

        int i, j;
        for(i=0;i<n-1;i++){
            for(j=0;j<n-1-i;j++){
                if(cmp.compare(arr[index_arr[j]], arr[index_arr[j+1]])>0){
                    int tempj0 = index_arr[j];
                    int tempj1 = index_arr[j+1];
                    index_arr[j] = tempj1;
                    index_arr[j+1] = tempj0;

                    deque.offerLast(new SwapPair(j, j+1));
                }
            }
        }

        return deque;
    }
}
