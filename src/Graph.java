import java.util.Arrays;

class t {
    public static void main(String[] args) {
        char[] vertex = { 'A', 'B', 'C', 'D' };
        int INF = 65535;
        int[][] matrix = new int[][] {
                { 0, 4, 19, INF },
                { 19, 0, INF, 4 },
                { 19, INF, 0, 19 },
                { INF, 4, 4, 0 },
        };
        Graph graph = new Graph(vertex, matrix);
        graph.showGraph();
        graph.dsj(0);
        graph.showDsj();
    }
}

class Graph {
    char[] vertex;
    int[][] matrix;
    VisitedVertex vv;

    Graph(char[] Vertex, int[][] Matrix) {
        vertex = Vertex;
        matrix = Matrix;
    }

    void showGraph() {
        for (int[] Link : matrix) {
            System.out.println(Arrays.toString(Link));
        }
    }

    /**
     * 算法实现
     * 
     * @param index
     */
    void dsj(int index) {
        // System.out.println(vertex.length);
        vv = new VisitedVertex(vertex.length, index);
        update(index); // 更新index顶点到周围顶点的距离和周围顶点的前驱顶点
        for (int j = 1; j < vertex.length; j++) {
            index = vv.updateArr(); // 选择并返回新的访问结点
            update(index);
        }
    }

    void showDsj() {
        vv.show();
    }

    /**
     * 更新index下标顶点到周围顶点的距离
     * 同时更新周围顶点的前驱结点
     * 
     * @param index
     */
    void update(int index) {
        int len = 0;
        // 更新matrix[index]行
        for (int j = 0; j < matrix[index].length; j++) {
            // 出发顶点到index顶点的距离 + 从index顶点到j顶点的距离之和
            len = vv.getDis(index) + matrix[index][j];
            // 更新的前提：j没有访问过，且我们得到的len小于出发顶点到j的距离
            if (!vv.in(j) && len < vv.getDis(j)) {
                vv.updatePre(j, index);
                vv.updateDis(j, len);
            }
        }
    }
}

class VisitedVertex {

    int[] already_arr;
    int[] pre_visited;
    int[] dis;
    int INF = 65535;

    /**
     * 
     * @param length 顶点个数
     * @param index  当前出发顶点对应的下标
     */
    VisitedVertex(int length, int index) {

        already_arr = new int[length];
        pre_visited = new int[length];
        dis = new int[length];
        Arrays.fill(dis, INF);
        already_arr[index] = 1;
        dis[index] = 0;
    }

    /**
     * index顶点是否被访问
     * 
     * @param index
     * @return
     */
    boolean in(int index) {
        return already_arr[index] == 1;
    }

    /**
     * 更新出发顶点和index的距离，即dis数组
     * 
     * @param index  被更新的点
     * @param length 距离的大小，在更新前要进行比较，只有比原来小才更新
     */
    void updateDis(int index, int length) {
        dis[index] = length;
    }

    /**
     * 更新pre顶点的前驱顶点为index顶点
     * 
     * @param pre
     * @param index
     */
    void updatePre(int pre, int index) {
        pre_visited[pre] = index;
    }

    /**
     * index离出发顶点的距离
     * 
     * @param index
     * @return
     */
    int getDis(int index) {
        return dis[index];
    }

    /**
     * 继续选择访问下一个顶点,并更新当前顶点已经被访问过
     * 
     * @return 下一个顶点的下标
     */
    int updateArr() {
        int min = 65535, index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min) {
                min = dis[i];
                index = i;
            }
        }
        already_arr[index] = 1;
        return index;
    }

    /**
     * 输出最后结果，即三个数组
     */
    void show() {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("访问数组：");
        for (int i : already_arr) {
            System.out.print(i + " ");
        }
        System.err.println();
        System.out.print("上一个路径顶点：");
        for (int i : pre_visited) {
            System.out.print(i + " ");
        }
        System.err.println();
        System.out.print("最短距离：");
        for (int i : dis) {
            System.out.print(i + " ");
        }

    }
}