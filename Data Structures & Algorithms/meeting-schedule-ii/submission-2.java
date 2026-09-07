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
class Time {
    int start;
    boolean isStart;

    public Time(int s, boolean start) {
        this.start = s;
        isStart = start;
    }
}
class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<Time> lst = new ArrayList<>();

        for (Interval interval : intervals) {
            Time t = new Time(interval.start, true);
            lst.add(t);
            t = new Time(interval.end, false);
            lst.add(t);
        }

        lst.sort((a,b) -> {
            if (a.start != b.start)
                return a.start - b.start;      
            return !a.isStart ? -1 : 1;            
        });

        int res = 0, meetings = 0;

        for (Time t : lst) {
            if (t.isStart) {
                if (meetings > 0) {
                    meetings--;
                } else {
                    res++;
                }
            } else {
                meetings++;
            }
        }

        return res;
    }
}
