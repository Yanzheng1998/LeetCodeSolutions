class Solution(object):
    def canThreePartsEqualSum(self, A):
        """
        :type A: List[int]
        :rtype: bool
        """
        sum_total = sum(A)
        if sum_total%3 != 0:
            return False
        n = len(A)
        sub_sum = sum_total/3
        sum_1 = 0
        sum_2 = 0
        i = 0
        j = n-1
    
        sum_1_equal = False
        sum_2_equal = False
        while i<n:
            sum_1+=A[i] 
            if sum_1 == sub_sum:
                sum_1_equal = True
                break
            i+=1
        print(i)
        while j>0:
            sum_2+=A[j]
            
            if sum_2 == sub_sum:
                sum_2_equal = True
              
                break
            j-=1
        if sum_1_equal is True and sum_2_equal is True and j>i:
            return True
            
        return False
