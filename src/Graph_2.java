import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Huadan Wang
 * @data 2020/5/6 - 11:49
 */
public class Graph_2 {
    private static ArrayList<String> vertexList;//存储顶点集合
    private int [][] edges;//存储图对应的邻接矩阵
    private int numOfEdges;//表示边的数目
    public static void main(String[] args) {
//        测试一把图是否创建
        int n = 5;//结点的个数
        String Vertexs[] = {"A","B","C","D","E"};
//        创建图对象
        Graph_2 graph= new Graph_2(n);
//        循环添加顶点
        for(String vertex : Vertexs){
            graph.insertVertex(vertex);
        }
        graph.insert_char_Edge("A","B",1);
        graph.insert_char_Edge("A","D",1);
        graph.insert_char_Edge("B","C",1);
        graph.insert_char_Edge("B","D",1);
        graph.insert_char_Edge("D","E",1);
//显示一把邻接矩阵
        graph.showGraph();
    }

    //插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }
    public Graph_2(int n){
                                //        初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
    }
                                    //    显示图对应的矩阵
    public void showGraph(){
        for(int[]link:edges){
            System.out.println(Arrays.toString(link));
        }
    }
    //添加边
    public void insert_char_Edge(String a,String b,int weight){
        int v1 = vertexList.indexOf(a);
        int v2 = vertexList.indexOf(b);
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}

