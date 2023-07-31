public class Array {

    public int[] swap(int one , int two ,int[] arr){
        int store = arr[one];
        arr[one] = arr[two];
        arr[two] = store;
        return arr;
    }

    public int[] sortArray(int[] nums) {
        int i, j , min;
        for (i = 0 ;  i < nums.length ; i++ ) {
             min = i;
              for (j = i ; j < nums.length ; j++){
                  if (nums[min] > nums[j]){
                      swap(i , j , nums);
                  }
              }
            }


        return nums;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{55,33,44,11};
        Array obj = new Array();
        int[] finArr = obj.sortArray(arr);
        for (int i = 0 ; i < finArr.length ; i++){
            System.out.println(finArr[i]);
        }


    }

}
