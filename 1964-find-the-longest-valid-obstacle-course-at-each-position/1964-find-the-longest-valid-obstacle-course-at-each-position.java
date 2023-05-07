class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int len = 0;
        int tails[] = new int[obstacles.length];
        int res[] = new int[obstacles.length];
        
        for (int i = 0; i < obstacles.length; i++) {
            int num = obstacles[i];
            
            if (len == 0 || num >= tails[len - 1]) { // add equal condition
                tails[len++] = num;
                res[i] = len;
            } else {
                int position = findPositionToReplace(tails, len, num);
                tails[position] = num;
                res[i] = position + 1;
            }
        }
        return res;
    }
    private int findPositionToReplace(int tails[], int res, int num) {
        int left = 0;
        int right = res;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (tails[mid] <= num) { // add equal condition
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}