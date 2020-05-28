import org.junit.Test;

public class Sequence {




    @Test
    public void BubbleSort(int[] arrays){

        //临时变量 记录交换的数
        int temp = 0;

        //记录是否进行了交换
        boolean ischange;

        for (int i = 0; i<arrays.length-1 ; i++){
            ischange = false;
            for (int j = 0; j<arrays.length-i-1; j++){
                if (arrays[j]>arrays[j+1]){
                    temp = arrays[j];
                    arrays[j] = arrays[j+1];
                    arrays[j+1] = temp;
                    ischange=true;
                }
                if (ischange == false){
                    break;
                }
            }
        }


        for (int i=0;i<arrays.length;i++){
            System.out.print(arrays[i]+" ");
        }

    }



    @Test
    public void SelectionSort(int[] arrays){

        int temp;
        //记录最大值的下标
        int pos;

        for (int i = 0;i<arrays.length-1;i++){
            pos = 0;
            for (int j=0;j<arrays.length-i-1;j++){
                if (arrays[j]>arrays[pos]){
                 pos = j;
                }
            }
            temp = arrays[pos];
            arrays[pos] = arrays[arrays.length-i-1];
            arrays[arrays.length-i-1] = temp;

        }

        for (int i=0;i<arrays.length;i++){
            System.out.print(arrays[i]+" ");
        }

    }

    @Test
    public void  InsertionSort(int[] arrays){
        int temp;
        int j;
        for (int i=1;i<arrays.length;i++){
            temp = arrays[i];

            j = i-1;
            while (j>=0 && arrays[j]>temp){
                arrays[j+1] = arrays[j];
                j--;
            }
            arrays[j+1] = temp;

        }
        for (int i=0;i<arrays.length;i++){
            System.out.print(arrays[i]+" ");
        }
    }

    @Test
    public void QuickSort(int[] arrays,int L,int R){
        int i = L;
        int j = R;
        int temp;
        int pivot = arrays[(L+R)/2];

        while (i<=j){

            while (pivot>arrays[i]){
                i++;
            }
            while (pivot<arrays[j]){
                j--;
            }

            if (i<=j){
                temp = arrays[j];
                arrays[j] = arrays[i];
                arrays[i] = temp;
                i++;
                j--;
            }

        }
        if (j>L){
            QuickSort(arrays,L,j);
        }

        if (i<R){
            QuickSort(arrays,i,R);
        }


    }


    @Test
    public void MergeSort(int[] arrays, int L,int R){
        int i = L;
        int j = R;
        int M = (R+L)/2;

        if(L==R){
            return;
        }else{

            MergeSort(arrays,L,M);

            MergeSort(arrays,M+1,R);

            merge(arrays,L,M+1,R);
        }

    }

    public void merge(int[] arrays,int L,int M,int R){
        int[] leftarrays = new int[M-L];
        int[] rightarrays = new int[R-M+1];

        for (int i=L;i<M;i++){
            leftarrays[i-L] = arrays[i];
        }

        for (int j=R;j<M;j++){
            leftarrays[j-L] = arrays[j];
        }


        int i = 0,j =0;
        int k = L;
        //⽐较这两个数组的值，哪个⼩，就往数组上放
        while (i < leftarrays.length && j < rightarrays.length) {
            //谁⽐较⼩，谁将元素放⼊⼤数组中,移动指针，继续⽐较下⼀个
            if (leftarrays[i] < rightarrays[j]) {
                arrays[k] = leftarrays[i];
                i++;
                k++;
            } else {
                arrays[k] = rightarrays[j];
                j++;
                k++;
            }
        }
        //如果左边的数组还没⽐较完，右边的数都已经完了，那么将左边的数抄到⼤数组中(剩下的都是⼤数字)
        while (i < leftarrays.length) {
            arrays[k] = leftarrays[i];
            i++;
            k++;
        }
        //如果右边的数组还没⽐较完，左边的数都已经完了，那么将右边的数抄到⼤数组中(剩下的都是⼤数字)
        while (j < rightarrays.length) {
            arrays[k] = rightarrays[j];
            k++;
            j++;
        }
    }

    public static void main(String[] args) {
        int[] arr ={3,2,5,4,9,8};
        Sequence sequence = new Sequence();
        //sequence.BubbleSort(arr);
        //sequence.SelectionSort(arr);
        //sequence.InsertionSort(arr);
        //sequence.QuickSort(arr,0,5);
    }
}
