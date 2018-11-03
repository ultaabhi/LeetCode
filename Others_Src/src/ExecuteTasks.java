import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ExecuteTasks {

    static class Tasks{
        int id;
        int pri;
        List<Integer> dep;
        int count;

        public Tasks(int id, int pri, List<Integer> dep){
            this.id = id;
            this.pri = pri;
            this.dep = dep;

        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        //Example
        // Input : [t1,1,[]],[t2,0,[t1,t3]], [t3,0,[]],[t4,2,[]]
        // Output : t3, t1, t2, t4

        Tasks t0 = new Tasks(0,1,new ArrayList<Integer>());
        Tasks t1 = new Tasks(1,0,new ArrayList<Integer>(Arrays.asList(0)));
        Tasks t2 = new Tasks(2,0,new ArrayList<Integer>());
        Tasks t3 = new Tasks(3,2,new ArrayList<Integer>());

        List<Tasks> t = new ArrayList<>();
        t.add(t0);
        t.add(t1);
        t.add(t2);
        t.add(t3);

        List<Integer> res = ExecuteTasks(t);

        System.out.println(res);


    }

    public static List<Integer> ExecuteTasks(List<Tasks> tasks){
        List<Integer> res = new ArrayList<>();

        if(tasks.size() == 0)
            return res;

        int[] inDegree = new int[tasks.size()];

        for(int i = 0; i< tasks.size(); i++){
            Tasks t = tasks.get(i);
            for(int j = 0; j<t.dep.size(); j++){
                inDegree[t.id]++;
            }
        }

        for(int i = 0; i<tasks.size(); i++){
            System.out.println(tasks.get(i).id + ":" + tasks.get(i).count);
        }

        PriorityQueue<Tasks> q = new PriorityQueue<>((a,b) ->  (a.pri - b.pri));

        for(int i = 0; i<tasks.size(); i++){
            if(inDegree[tasks.get(i).id] == 0)
             q.offer(tasks.get(i));
        }

        for(int i = 0; i<inDegree.length; i++){
            System.out.print(inDegree[i]);

        }

        System.out.println();

        while(!q.isEmpty()){
            printQue(q);
            System.out.println();
            Tasks x = q.poll();
            res.add(x.id);

            for(int i = 0; i<tasks.size();i++){
                List<Integer> deptasks = tasks.get(i).dep;
                for(int j = 0; j< deptasks.size(); j++){
                    if(x.id == deptasks.get(j)){
                        inDegree[tasks.get(i).id]--;
                        if(inDegree[tasks.get(i).id] == 0){
                            q.offer(tasks.get(i));

                        }

                    }
                }

            }

        }

        return res;


    }

    private static void printQue(PriorityQueue<Tasks> q) {
        List<Tasks> temp = new ArrayList<>();
        while(!q.isEmpty()){
            Tasks s = q.poll();
            temp.add(s);
            System.out.print(s.id);
        }

        q.addAll(temp);
    }
}
