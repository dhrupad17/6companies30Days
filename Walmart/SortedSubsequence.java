class SortedSubsequence
{
        public static void find3Numbers(int[] nums)
        {
	if (nums.length < 3){
		System.out.print("No such triplet found");
		return;
	}
	int seq = 1;	
	int min_num = nums[0];
	int max_seq = Integer.MIN_VALUE;	
	int store_min = min_num;
	for (int i = 1; i < nums.length; i++)
	{
		if (nums[i] == min_num)
		continue;
		
		else if (nums[i] < min_num)
		{
		min_num = nums[i];
		continue;
		}
		else if (nums[i] < max_seq) {
		max_seq = nums[i];	
		store_min = min_num;		
		}
		else if (nums[i] > max_seq)
		{
		seq++;
		if (seq == 3)
		{		
			System.out.println("Triplet: " + store_min + ", " + max_seq + ", " + nums[i]);
			return;
		}
		max_seq = nums[i];
		}
	}
	System.out.print("No such triplet found");
	}
	public static void main(String[] args)
	{
		int[] nums = {1,2,1,1,3};
		find3Numbers(nums);
	}
}