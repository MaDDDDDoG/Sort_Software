package Sort;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class Selection {
    static public Deque<SwapPair> sort(Node[] arr, int[] index_arr, int n, Comparator<Node> cmp){
        Deque<SwapPair> deque = new LinkedList<>();

        for(int i=0;i<n-1;i++){
            int min = i;
            for(int j=i+1;j<n;j++){
                if(cmp.compare(arr[index_arr[min]], arr[index_arr[j]]) > 0)
                    min = j;
            }

            if(min==i) continue;  // does not swap

            int temp0 = index_arr[min];
            int temp1 = index_arr[i];
            index_arr[i] = temp0;
            index_arr[min] = temp1;

            deque.offerLast(new SwapPair(i, min));
        }

        return deque;
    }
}

