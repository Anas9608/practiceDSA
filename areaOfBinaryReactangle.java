package Practice.DSA.stack;

import java.util.*;

public class  areaOfBinaryReactangle{


/*Complete the function given below*/

    public int maxArea(int M[][], int n, int m) {
        // add code here.
        int maxi = -1;
        
        int[] arr = new int[m];
        for(int i = 0; i < m ; i++){
           arr[i]  = M[0][i];
        }
        int area = histArea(arr,m);
        maxi = Math.max(maxi, area);
        for(int i = 1; i < n ; i++){
            
            for(int j = 0; j < m ; j++){
                if(M[i][j] == 1){
                   arr[j] = arr[j]+M[i][j];
                   
                }
                else arr[j] = 0;
                
                
            }
            maxi = Math.max(maxi, histArea(arr,m));
            
        }
        
        return maxi;
       
    }
    int histArea(int[] arr, int m){
        int maxi = -1;
        
        int[] nslA = nsl(arr, m);
        int[] nsrA = nsr(arr, m);
        
        for(int i = 0 ; i < m ; i++){
            int area = (nsrA[i] - nslA[i] - 1)*arr[i];
            maxi = Math.max(maxi, area);
            
        }
        return maxi;
    }
    int[] nsl(int[] arr, int m){
       
        int[] res = new int[m];
        Stack<pair> stk = new Stack<>();
        for(int i = 0 ; i < m ; i++){
        if(stk.isEmpty()){
            res[i] = -1;
        }
        else{
            if(!stk.isEmpty() && stk.peek().val < arr[i]){
                res[i] = stk.peek().idx;
            }
            else{
                while(!stk.isEmpty() && stk.peek().val >= arr[i]){
                    stk.pop();    
                    }
                    
                    if(stk.isEmpty()) res[i] = -1;
                    else{
                        res[i] = stk.peek().idx;
                    }
                }
            }
            stk.push(new pair(arr[i], i));
            
        }
         return res;
        
        }
       

    
    int[] nsr(int[] arr, int m){
        int[] res = new int[m];
        Stack<pair> stk = new Stack<>();
        for(int i = m-1 ; i >= 0 ;i--){
            if(stk.isEmpty()){
                res[i] = m;
            }
            else{
                if(stk.peek().val < arr[i]){
                    res[i] = stk.peek().idx;
                }
                else{
                    while(!stk.isEmpty() && stk.peek().val >= arr[i]){
                        stk.pop();
                    }
                    if(stk.isEmpty()) res[i] = m;
                    else{
                        
                        res[i] = stk.peek().idx;
                    }
                }
            }
            
            stk.push(new pair(arr[i], i));
        }
        return res;
    }
    
}

class pair{
    int val;
    int idx;
    pair(int val, int idx){
        this.val = val;
        this.idx = idx;
    }
}
    

