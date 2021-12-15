public class Solution {

    public int solve(int[] A, int B) {
        if(A.length < 2) return A[0]==B?0:-1;
        return search(A, B);
    }
    int midIndex= -1;
    int result= -1;
    public  int search(int[] nums, int target) {
        if(nums.length < 2) return nums[0]==target?0:-1;
        findPeakIndex(nums,0,nums.length-1);
        System.out.println("++++++++"+midIndex);
        if(midIndex==-1)
        {
            binarySearch(nums,0,nums.length-1,target,true);
        }
        if(midIndex!=-1)
        binarySearch(nums,0,midIndex,target,true);

        if(result!=-1) return result;
            //System.out.println("ye mai hun ______________");
        else {
            //System.out.println("ye mai hun ______________");

            binarySearch(nums,midIndex+1,nums.length-1,target,true);}
        //System.out.println("mai chala hun==========");
        return result;
    }

    public  void findPeakIndex(int[] nums, int left, int right){
        int mid = (left+right)/2;
       if(left>right) return;
        if(nums[mid]<nums[0]){
            findPeakIndex(nums,left,mid-1);
        }if(nums[mid]>=nums[0]){
            if(mid==nums.length-1){
                return;
            }
            if(nums[mid+1]<nums[mid]){
                midIndex=mid;
                return;
            }else{
                findPeakIndex(nums,mid+1,right);
            }
        }
        return;
    }
    public  void binarySearch(int[]nums,int left, int right,int target, boolean slope){
        int mid = (left+right)/2;
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
