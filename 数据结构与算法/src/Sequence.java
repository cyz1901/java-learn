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



    public static void main(String[] args) {
        int[] arr ={3,2,5,4,9,8};
        Sequence sequence = new Sequence();
        //sequence.BubbleSort(arr);
        //sequence.SelectionSort(arr);
        sequence.InsertionSort(arr);

    }
}
