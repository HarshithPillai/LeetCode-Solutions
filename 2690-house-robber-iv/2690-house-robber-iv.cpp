class Solution {
public:
    int help(vector<int>& nums, int mid, int k) {

        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] <= mid) {
                count++;
                i++;
            }
        }
        return count >= k;
    }

    int minCapability(vector<int>& nums, int k) {
        int low = nums[0];
        int high = nums[0];

        for (int i = 0; i < nums.size(); i++) {
            low = min(nums[i], low);
            high = max(nums[i], high);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (help(nums, mid, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
};