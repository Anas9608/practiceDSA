import java.util.ArrayList;

public class bsInForest {
    static int find_height(int tree[], int n, int k)
    {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<n ;i++){
            list.add(tree[i]);
        }
        Collections.sort(list);
        
        int i = 0;
        int j = list.get(n-1);
        int sum = 0;
         
        while(i <= j){
            sum = 0;
            int mid = i + (j-i)/2;
            for(int ii = 0 ; ii < n ; ii++){
                if(list.get(ii) > mid){
                    sum += (list.get(ii)-mid);
                }
            }
            if(sum == k) return mid;
            if(sum < k){
                j = mid - 1;
            }
            else{
                i = mid + 1;
            }
        }
        
        return -1;
    }
}
