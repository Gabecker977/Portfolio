package Java;

/**
 * OrderAlgorithm
 */
public class OrderAlgorithm {
    int[] n;
public static void main(String[] args){
    int n[]={10,0,9,28};
    int temp=0;
    for(int i=0;i<n.length-1;i++)
        for(int j=i+1;j<n.length;j++){
            if(n[i]<n[j]){
                temp =n[i];
                n[i]=n[j];
                n[j]=temp;
            }
        }
    
 for(int i=0;i<n.length;i++)
        System.out.println(n[i]);
}
    
}