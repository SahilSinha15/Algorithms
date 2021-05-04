import java.util.*;

public class hw7_2 {
    private static int count=-1;
    private static HashMap<String,Integer> hopArray = new HashMap<>();
    private static HashMap<String, Set<String>> graph = new HashMap<>();
    private static int globalMaxHop;
    private static String globalSrc;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nVertices= scan.nextInt();
        Set<String> vertices = new HashSet<>();
        scan.nextLine();
        for(int i=0;i<nVertices;i++){
            String temp = scan.nextLine();
            Set<String> tempSet = new HashSet<>();
            vertices.add(temp);
            graph.put(temp,tempSet);
        }
        int nEdges = scan.nextInt();
        scan.nextLine();
        for(int i=0;i<nEdges;i++){
            String tempStr = scan.nextLine();
            String[] tempArr = tempStr.split(" ");
            (graph.get(tempArr[0])).add(tempArr[1]);
        }
        globalSrc = scan.nextLine();
        globalMaxHop = scan.nextInt();
        Set<String> solution = new HashSet<>();
        for(String s: vertices){
            findHops(globalSrc,s);
        }
        System.out.println(hopArray);

        bfs(graph,globalSrc);


    }

    static void findHops(String source, String destination){
        if(destination==globalSrc){
            hopArray.put(destination,0);
        }
        if(!((graph.get(source)).contains(destination))) {
            for (int i = 0; i < globalMaxHop; i++) {

            }
        }
        else{
            hopArray.put(destination,1);
        }


    }

    static void bfs(HashMap<String, Set<String>> g, String source){
        Queue<String> tempQ = new ArrayDeque<>();
        int tempCount=0;
        HashMap<String,Integer> markArr = new HashMap<>();
        markArr.put(source,++tempCount);
        tempQ.add(source);
        while(!(tempQ.isEmpty())){
            String current = tempQ.peek();
            tempQ.remove();
            System.out.println(current);
            for(int i=0;i<g.get(current).size();i++) {
                Object[] tempArr = g.get(current).toArray();
                String neighbor = String.valueOf(tempArr[i]);
                if (markArr.get(neighbor) == null) {
                    markArr.put(neighbor, ++count);
                    tempQ.add(neighbor);
                }
            }
            }
        System.out.println(markArr);
        }


    }




