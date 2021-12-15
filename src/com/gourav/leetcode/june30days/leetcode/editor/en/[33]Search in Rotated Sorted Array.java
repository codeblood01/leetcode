public class Solution {

    public int solve(int[] A, int B) {
        return search(A, B);
    }
    int midIndex= -1;
    int result= -1;
    public  int search(int[] nums, int target) {
        findPeakIndex(nums,0,nums.length-1);
        //System.out.println("++++++++"+midIndex);
        if(midIndex==nums.length){
            binarySearch(nums,0,nums.length-1,target,true);
            return result;
        }
        if(midIndex==0){
            binarySearch(nums,0,nums.length-1,target,false);
            return result;
        }
        binarySearch(nums,0,midIndex,target,true);
        // System.out.println("nahi mila");

        if(result!=-1) return result;
            //System.out.println("ye mai hun ______________");
        else {
            //System.out.println("ye mai hun ______________");

            binarySearch(nums,midIndex+1,nums.length-1,target,false);}
        //System.out.println("mai chala hun==========");
        return result;
    }

    public  void findPeakIndex(int[] nums, int left, int right){
        int mid = (left+right)/2;
        if(mid+1>=nums.length) {
            midIndex= mid;
            return;
        }if(mid<=0){
            midIndex= mid;
            return;
        }
        if(nums[mid+1]>nums[mid]){
            findPeakIndex(nums,mid+1,right);
        }if(nums[mid+1]<nums[mid]){
            if(nums[mid-1]<nums[mid]){
                midIndex=mid;
                return;
            }else{
                findPeakIndex(nums,left,mid-1);
            }
        }
        return;
    }
    public  void binarySearch(int[]nums,int left, int right,int target, boolean slope){
        int mid = (left+right)/2;
//          if(mid+1>=right) {
//              if(nums[mid]==target)
//                  result=mid;
//             return;
//         }if(mid<=0){
//              if(nums[mid]==target)
//                  result = mid;

//             return;
//         }
        if(left>right) return;
        if (slope==true){
            if (nums[mid]==target) {
                result = mid;
                return;
            }else{
                if(nums[mid]<target){
                    binarySearch(nums,mid+1,right,target,slope);
                }else{
                    binarySearch(nums,left,mid-1,target,slope);
                }
            }
        }else{
            if (nums[mid]==target) {
                result = mid;
                return;
            }else{
                if(nums[mid]<target){
                    binarySearch(nums,left,mid-1,target,slope);
                }else{
                    binarySearch(nums,mid+1,right,target,slope);
                }
            }

        }
        return;
    }

}
