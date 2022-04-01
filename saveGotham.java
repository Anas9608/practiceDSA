package Practice.DSA.stack;

import java.util.Stack;

public class saveGotham {
    public static int save_gotham (int arr[], int n) {
        //Complete the function
        int sum = 0 ;
        int max = 1000000001;
        int[] ngrA = ngr(arr,n);
        for(int i = 0 ; i < n ; i++){
            sum  = (sum%max + ngrA[i]%max)%max;
        }
        return sum;
    }
    
    static int[] ngr(int[] arr, int n){
        Stack<Integer> stk = new Stack<Integer>();
        int[] res = new int[n];
        for(int i = n-1; i >= 0 ; i--){
            if(stk.isEmpty()){
                res[i] = 0;
            }
            else{
                if(!stk.isEmpty() && stk.peek() > arr[i]){
                    res[i] = stk.peek();
                }
                else{
                    while(!stk.isEmpty() && stk.peek() <= arr[i]){
                        stk.pop();
                    }
                    if(stk.isEmpty()) res[i] = 0;
                    else if(stk.peek() > arr[i]){
                        res[i] = stk.peek();
                    }
                }
            }
            stk.push(arr[i]);
        }
        return res;
    }
    
}
