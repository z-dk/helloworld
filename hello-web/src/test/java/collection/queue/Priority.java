package collection.queue;

import java.util.PriorityQueue;

public class Priority {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(5);
        priorityQueue.offer(9);
        priorityQueue.offer(3);
        for (Integer integer : priorityQueue) {
            System.out.println(integer);
        }
        // remove
        System.out.println("poll");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }

}
