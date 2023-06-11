package algorithms.leetcode;

public class Priority {

    public static void main(String[] args) {
        Priority priority = new Priority();
        int[] gifts = new int[]{25,64,9,4,100};
        int k = 4;
        System.out.println(priority.pickGifts(gifts, k));
    }

    public long pickGifts(int[] gifts, int k) {
        MaxQueue queue = new MaxQueue(gifts);
        for(int i = 0; i < k; i++) {
            int ct = queue.take();
            int n = calc(ct);
            queue.add(ct - n);
        }
        return queue.sum();
    }
    public int calc(int m) {
        int i = 1;
        for(; i * i <= m; i++) {

        }
        return i - 1;
    }

    class MaxQueue {
        int[] queue;
        int len;
        public MaxQueue(int[] gifts) {
            len = gifts.length + 1;
            queue = new int[len];
            for(int i = 1; i < len; i++) {
                queue[i] = gifts[i - 1];
                swim(i);
            }
        }
        public long sum() {
            long rs = 0;
            for(int i = 1; i < len; i++) {
                rs += queue[i];
            }
            return rs;
        }
        public int take() {
            int rs = queue[1];
            queue[1] = queue[len - 1];
            queue[len - 1] = 0;
            sink(1);
            return rs;
        }
        public boolean add(int n) {
            queue[len - 1] = n;
            swim(len - 1);
            return true;
        }
        public void sink(int k) {
            while(2 * k < len) {
                int j = 2 * k;
                if(j < len - 1 && queue[j] < queue[j + 1]) {
                    j++;
                }
                if(queue[j] < queue[k]) {
                    break;
                }
                queue[j] ^= queue[k];
                queue[k] ^= queue[j];
                queue[j] ^= queue[k];
                k = j;
            }

        }
        public void swim(int k) {
            while(k > 1) {
                if(queue[k / 2] > queue[k]) {
                    break;
                }
                queue[k / 2] ^= queue[k];
                queue[k] ^= queue[k / 2];
                queue[k / 2] ^= queue[k];
                k /= 2;
            }
        }
    }

}
