public int[] maxset(int[] A) {

        long curSum = 0;
        int curStart = 0, curLength = 0;
        long maxSum = 0;
        int maxStart = 0, maxLength = 0;
        for (int index = 0; index < A.length; index++)
        {
            if (A[index] < 0)
            {
                if ((curSum > maxSum) || ((curSum == maxSum) && (curLength > maxLength)))
                {
                    maxSum = curSum;
                    maxStart = curStart;
                    maxLength = curLength;
                }
                curStart = index + 1;
                curSum = curLength = 0;
            }
            else
            {
                curSum += A[index];
                ++curLength;
            }
        }
        if ((curSum > maxSum) || ((curSum == maxSum) && (curLength > maxLength)))
        {
            maxSum = curSum;
            maxStart = curStart;
            maxLength = curLength;
        }
        int[] result = new int[maxLength];
        for (int i = 0; i < maxLength; i++) {
            result[i] = A[maxStart+i];
        }

        return result;

    }
