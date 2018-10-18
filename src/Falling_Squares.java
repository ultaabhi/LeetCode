import java.util.ArrayList;
import java.util.List;

class Falling_Squares {
    private static class Interval {
        int start, end, height;

        public  Interval(int start, int end, int height) {
            this.start = start;
            this.end = end;
            this.height = height;
        }
    }

    public static List<Integer> fallingSquares(int[][] positions) {
        List<Interval> intervals = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int h = 0;
        for (int[] pos : positions) {
            Interval cur = new Interval(pos[0], pos[0] + pos[1] - 1, pos[1]);
            h = Math.max(h, getHeight(intervals, cur));
            res.add(h);
        }
        return res;
    }

    private static int getHeight(List<Interval> intervals, Interval cur) {
        int preMaxHeight = 0;
        for (Interval i : intervals) {
            // Interval i does not intersect with cur
            if (i.end < cur.start) continue;
            if (i.start > cur.end) continue;
            // find the max height beneath cur
            preMaxHeight = Math.max(preMaxHeight, i.height);
        }
        cur.height += preMaxHeight;
        intervals.add(cur);
        return cur.height;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2},
                {2,3},
                {6,1}
        };

        List<Integer> res = fallingSquares(arr);

        System.out.println(res);

    }
}