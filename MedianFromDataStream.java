import java.util.*;
class MedianFinder {
PriorityQueue<Integer> min = new PriorityQueue<Integer>();
PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());
boolean even = true;
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(even){
            min.add(num);
            max.add(min.poll());
        }else{
            max.add(num);
            min.add(max.poll());
        }
        even=!even;
    }
    
    public double findMedian() {
        if(even){
            return (min.peek()+max.peek())/2.0;
        }else{
            return max.peek();
        }
    }
}

