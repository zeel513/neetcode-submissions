/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> (a.start - b.start));
        Queue<Interval> pq = new PriorityQueue<>((a,b) -> (a.end - b.end));
        for(Interval curr: intervals) {
            if(pq.isEmpty()) {
                pq.add(curr);
                continue;
            }
            if(pq.peek().end > curr.start) {
                pq.add(curr);
            } else {
                pq.poll();
                pq.add(curr);
            }
        }

        return pq.size();
    }
}
