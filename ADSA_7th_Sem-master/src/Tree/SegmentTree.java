package Tree;

public class SegmentTree {
    int [] MinTree;
    int [] MaxTree;
    int n;
    SegmentTree(int [] stkprice){
        n = stkprice.length;
        buildMaxTree(stkprice);
        buildMinTree(stkprice);
    }

    void buildMaxTree(int [] stkprice){
        MaxTree = new int [2*n];

        for(int i=0;i<n;i++){
            MaxTree[i+n] = stkprice[i];
        }

        for(int i= n-1;i>0;i--){
            MaxTree[i] = Math.max(MaxTree[2*i],MaxTree[2*i+1]);
        }
    }

    void buildMinTree(int [] stkprice){

        MinTree = new int [2*n];

        for(int i=0;i<n;i++){
            MinTree[i+n] = stkprice[i];
        }

        for(int i= n-1;i>0;i--){
            MinTree[i] = Math.min(MinTree[2*i],MinTree[2*i+1]);
        }
    }

    int getMaxPrice(int l , int r){
        if(l>r) return -1;
        if(l<0 || r > n-1) return -1;

        l+=n;
        r+=n;
        int max = Integer.MIN_VALUE;
        while(l<=r){

            if(l%2!=0){
                max = Math.max(max,MaxTree[l]);
                l++;
            }
            if(r%2==0){
                max = Math.max(max,MaxTree[r]);
                r--;
            }

            l/=2;
            r/=2;
        }
        return max;
    }

    int getMinPrice(int l , int r){
        if(l>r) return -1;
        if(l<0 || r > n-1) return -1;

        l+=n;
        r+=n;
        int min = Integer.MAX_VALUE;
        while(l<=r){
            if(l%2==1) min = Math.min(min,MinTree[l++]);
            if(r%2==0) min = Math.min(min,MinTree[r--]);
            l/=2;
            r/=2;
        }
        return min;
    }

    public static void main(String[] args) {
        int [] stkprice = {1,2,3,4,5,6};
        SegmentTree tree = new SegmentTree(stkprice);
        System.out.println(tree.getMaxPrice(2,5));
        System.out.println(tree.getMinPrice(0,5));
    }
}