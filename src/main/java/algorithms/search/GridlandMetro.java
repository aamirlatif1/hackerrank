package algorithms.search;

import java.util.*;

public class GridlandMetro {

    private static int freeCells(List<int[]> row, long m){
        int i = 0;
        row.sort((o1, o2) -> o1[0] - o2[0]);
        Stack<int[]> stack = new Stack<>();
        stack.push(row.get(i));
        i++;
        while (i < row.size()){
            if(stack.peek()[1] <= row.get(i)[0]){
                stack.push(row.get(i));
            } else if(row.get(i)[1] > stack.peek()[1]){
                stack.peek()[1] = row.get(i)[1];
            }
            i++;
        }
        List<int[]> trackList = new LinkedList<>();
        while (!stack.isEmpty()){
            trackList.add(0, stack.pop());
        }
        int count = 0;
        int le = 0;
        for (int[] track : trackList) {
            if(track[0] - le > 0){
                count += (track[0] - le -1);
            }
            le = track[1];
        }
        if(m - row.get(row.size()-1)[1] > 0){
            count += (m - row.get(row.size()-1)[1]);
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long m = in.nextLong();
        int k = in.nextInt();
        SortedSet<Integer> tracks = new TreeSet<>();
        Map<Integer, List<int[]>> tm = new HashMap<>();
        for(int i = 0; i < k; i++){
            int value = in.nextInt();
            tracks.add(value);
            int[] track = new int[2];
            track[0] = in.nextInt();
            track[1] = in.nextInt();
            if(tm.containsKey(value)) {
                tm.get(value).add(track);
            } else{
                List<int[]> list = new ArrayList<>();
                list.add(track);
                tm.put(value, list);
            }
        }

        int i = 0;
        int lampposts = 0;
        for (int ti : tracks) {
            lampposts += m * (ti-i-1);
            List<int[]> trackList = tm.get(ti);
            lampposts += freeCells(trackList, m);
            i = ti;
        }
        lampposts += m * (n - tracks.last());
        System.out.println(lampposts);


    }
}
