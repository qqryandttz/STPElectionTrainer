//图的顶点类型
class Vertex {
    public char value; // 顶点值
    public boolean visited; // 顶点是否被访问过

    public Vertex(char v) {
        value = v;
        visited = false;
    }
}

// 存储边的两个顶点及边的权值
class Edge {
    public int u; // 顶点
    public int v; // 顶点
    public int w; // 权值

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}


// 有权无向图
public class Graph {
    private Vertex[] vertexList; // 存放顶点
    private int[][] mGraph; // 用矩阵表示边
    private MyStack stack; // 栈
    private MyQueue queue; // 队列
    private int size; // 当前顶点数
    private int[] distance; // 记录到起点的距离
    private int[] path; // 记录最短路径经过的顶点
    // 比如path[w]=v，表示从起点到顶点w需要先经过w的父顶点v
    private int[][] dist; // dist[i][j]记录i到j的最短距离
    private int[][] prev; // prev[i][j]=k表示i到j的最短路径会经过顶点k
    // 并查集中指向父顶点的数组
    int[] parent;

    public Graph(int maxSize) {
        vertexList = new Vertex[maxSize];
        mGraph = new int[maxSize][maxSize];
        stack = new MyStack(maxSize);
        queue = new MyQueue(maxSize);
        size = -1;
        distance = new int[maxSize];
        path = new int[maxSize];
        dist = new int[maxSize][maxSize];
        prev = new int[maxSize][maxSize];
        parent = new int[vertexList.length];
        init(); // 初始化为没有边的图
    }

    // 初始化为没有边的图
    public void init() {
        for (int i = 0; i < mGraph.length; i++) {
            for (int j = 0; j < mGraph[i].length; j++) {
                if (i == j) {
                    mGraph[i][j] = 0; // 自己到自己的权重为0
                } else {
                    // 还没有边的时候，权重初始化为无穷大
                    mGraph[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }

    // 添加顶点
    public boolean addVertex(char v) {
        if (size == vertexList.length) {
            System.out.println("满了，无法添加顶点");
            return false;
        }
        vertexList[++size] = new Vertex(v);
        return true;
    }

    // 添加边
    public boolean addEdge(int start, int end, int weight) {
        if (start < 0 || start >= mGraph.length || end < 0 || end >= mGraph.length) {
            System.out.println("输入的顶点序号不符合要求");
            return false;
        }
        mGraph[start][end] = weight;
        mGraph[end][start] = weight;
        return true;
    }


    // 深度优先搜索depthFirstSearch，有点类似于树的先序遍历
    public void DFS() {
        System.out.print(vertexList[0].value + " "); // 访问第一个顶点
        vertexList[0].visited = true; // 表示第一个顶点已经访问过了
        stack.push(0); // 将第一个顶点入栈
        // 当栈中还有元素
        while (!stack.isEmpty()) {
            // 找到栈当前顶点邻接且未被访问的顶点
            int v = getUnvisitedVertex(stack.peek());
            // 如果当前顶点值为-1，则表示没有邻接且未被访问顶点，那么出栈顶点
            if (v == -1) {
                stack.pop();
            } else { // 否则访问下一个邻接顶点
                vertexList[v].visited = true;
                System.out.print(vertexList[v].value + " ");
                stack.push(v);
            }
        }

        // 恢复visited为false，方便下次访问
        for (int i = 0; i < vertexList.length; i++) {
            vertexList[i].visited = false;
        }

    }

    // 找到与某一顶点邻接且未被访问的顶点
    public int getUnvisitedVertex(int v) {
        for (int i = 0; i < mGraph.length; i++) {
            // v顶点与i顶点相邻（邻接矩阵值为1）且未被访问 wasVisited==false
            if (v != i && mGraph[v][i] < Integer.MAX_VALUE && vertexList[i].visited == false) {
                return i;
            }
        }
        return -1;
    }

    // 广度优先搜索breadthFirstSearch，有点类似于树的层次遍历
    public void BFS() {
        System.out.print(vertexList[0].value + " "); // 访问第一个顶点
        vertexList[0].visited = true; // 标志已经访问过了
        queue.add(0); // 将第一个顶点入队
        // 当队列不为空
        while (!queue.isEmpty()) {
            // 寻找当前顶点没有访问的邻接点
            int v = getUnvisitedVertex(queue.peek());
            if (v != -1) {
                System.out.print(vertexList[v].value + " ");
                vertexList[v].visited = true;
                queue.add(v);
            } else {
                queue.remove();
            }
        }

        // 恢复visited为false，方便下次访问
        for (int i = 0; i < vertexList.length; i++) {
            vertexList[i].visited = false;
        }
    }



    // Dijkstra解决单源最短路径问题
    // 它的主要特点是以起始点为中心向外层层扩展(广度优先搜索思想)，直到扩展到终点为止
    // s表示的是以第几个顶点为起点，从0开始
    public void dijkstra(int s) {
        // 初始化距离和路径
        for (int i = 0; i < vertexList.length; i++) {
            distance[i] = Integer.MAX_VALUE; // 到起点的距离设置为无穷大
            path[i] = -1; // 到起点的路径初始化为-1
        }
        distance[s] = 0; // 到起点本身的距离为0
        // 每次取最小值，其实可以用最小堆来实现，这里就直接比较了
        // 进行n次循环
        for (int i = 0; i < vertexList.length; i++) {
            int k = 0; // 记录最小路径的顶点序号
            int min = Integer.MAX_VALUE;
            // 从未被访问过的顶点中找一个距离最小的顶点
            for (int j = 0; j < vertexList.length; j++) {
                // 如果还没有访问过，并且比当前值要小
                if (vertexList[j].visited == false && distance[j] < min) {
                    vertexList[j].visited = true; // 设置为已访问
                    min = distance[j]; // 更新最小值
                    k = j; // 记录最小路径的顶点序号
                }
            }
            // 修正当前最短路径和前驱顶点
            // 即，当已知"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
            for (int j = 0; j < vertexList.length; j++) {
                // 找顶点k的邻接点j，并更新它的邻接点到起点的最短路径
                int tmp = (mGraph[k][j] == Integer.MAX_VALUE ? Integer.MAX_VALUE : (min + mGraph[k][j]));
                // min + mGraph[k][j]就表示顶点k的最短路径加上<k,j>边的权重，即为顶点j可能的最短路径
                if (vertexList[j].visited == false && (tmp < distance[j])) {
                    distance[j] = tmp; // 更新顶点j到起点的最短路径
                    path[j] = k; // 设置它的父顶点为k
                }
            }
        }

        // 打印Dijkstra最短路径的结果
        printDijkstra(s);

        // 恢复visited为false，方便下次访问
        for (int i = 0; i < vertexList.length; i++) {
            vertexList[i].visited = false;
        }
    }

    // 打印Dijkstra最短路径的结果
    public void printDijkstra(int s) {
        // 利用栈后进先出的特性，将路径逆序
        MyStack st = new MyStack(vertexList.length);
        System.out.printf("dijkstra(%c): \n", vertexList[s].value);
        for (int i = 0; i < vertexList.length; i++) {
            System.out.printf("  shortest(%c, %c)=%d 路径为：", vertexList[s].value, vertexList[i].value, distance[i]);
            // 这里可以用一个栈来存储顶点，然后出栈就是顺序输出了，而不是反向输出
            // 打印路径
            st.push(i); // 终点
            int tmp = path[i];
            while (tmp != -1) {
                st.push(tmp);
                tmp = path[tmp];
            }
            while (!st.isEmpty()) {
                System.out.printf("%c-->", vertexList[st.pop()].value);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        g.addVertex('F');
        g.addVertex('G');

        // 下面是边的关系，有边的值为权重，无边的值为无穷大
        // int matrix[][] = {
        // /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
        // /*A*/ { 0, 12, INF, INF, INF, 16, 14},
        // /*B*/ { 12, 0, 10, INF, INF, 7, INF},
        // /*C*/ { INF, 10, 0, 3, 5, 6, INF},
        // /*D*/ { INF, INF, 3, 0, 4, INF, INF},
        // /*E*/ { INF, INF, 5, 4, 0, 2, 8},
        // /*F*/ { 16, 7, 6, INF, 2, 0, 9},
        // /*G*/ { 14, INF, INF, INF, 8, 9, 0}};
        g.addEdge(0, 1, 12); // AB相连
        g.addEdge(0, 5, 16); // AF
        g.addEdge(0, 6, 14); // AG
        g.addEdge(1, 2, 10); // BC相连
        g.addEdge(1, 5, 7); // BF
        g.addEdge(2, 3, 3); // CD相连
        g.addEdge(2, 4, 5); // CE相连
        g.addEdge(2, 5, 6); // CF
        g.addEdge(3, 4, 4); // DE
        g.addEdge(4, 5, 2); // EF
        g.addEdge(4, 6, 8); // EG
        g.addEdge(5, 6, 9); // FG

        // 深度优先访问
        System.out.println("深度优先：");
        g.DFS();
        System.out.println();
        // 广度优先搜索
        System.out.println("广度优先：");
        g.BFS();
        System.out.println();

        // Dijkstra算法
        g.dijkstra(3);
        System.out.println("路径：");
        for (int i = 0; i < g.vertexList.length; i++) {
            System.out.print(g.path[i] + " ");
        }

    }

}


