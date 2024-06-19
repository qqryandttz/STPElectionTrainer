class NetworkTopology {

    char[] vertexSwitch;
    int[][] networkTopology;
    Graph graph;

    int Example, ROOTnumber;  //1表示第一台交换机，2为第二台，以此类推
    private int INF = 65535;
    Switch switch11, switch12, switch13, switch14;
    Switch switch21, switch22, switch23, switch24;
    Switch switch31, switch32, switch33, switch34, switch35;

    NetworkTopology(int isExample) {

        Example = isExample;
        if (Example == 1) {

            switch11 = new Switch(11, "SW1-1", "54-89-98-1C-75-C0");
            switch12 = new Switch(12, "SW1-2", "54-89-98-1C-75-C1");
            switch13 = new Switch(13, "SW1-3", "54-89-98-1C-75-C2");
            switch14 = new Switch(14, "SW1-4", "54-89-98-1C-75-C3");
            vertexSwitch = new char[] { 'A', 'B', 'C', 'D' };
            networkTopology = new int[][] {
                    { 0, 4, 4, INF },
                    { 4, 0, INF, 4 },
                    { 4, INF, 0, 4 },
                    { INF, 4, 4, 0 }
            };

        } else if (Example == 2) {

            switch21 = new Switch(21, "SW2-1", "54-89-98-1C-75-C0");
            switch22 = new Switch(22, "SW2-2", "54-89-98-1C-75-C1");
            switch23 = new Switch(23, "SW2-3", "54-89-98-1C-75-C2");
            switch24 = new Switch(24, "SW2-4", "54-89-98-1C-75-C3");
            vertexSwitch = new char[] { 'A', 'B', 'C', 'D' };
            networkTopology = new int[][] {
                    { 0, 4, 4, 4 },
                    { 4, 0, 4, 4 },
                    { 4, 4, 0, INF },
                    { 4, 4, INF, 0 }
            };

        } else if (Example == 3) {

            switch31 = new Switch(31, "SW3-1", "54-89-98-1C-75-C0");
            switch32 = new Switch(32, "SW3-2", "54-89-98-1C-75-C1");
            switch33 = new Switch(33, "SW3-3", "54-89-98-1C-75-C2");
            switch34 = new Switch(34, "SW3-4", "54-89-98-1C-75-C3");
            switch35 = new Switch(35, "SW3-5", "54-89-98-1C-75-C4");
            vertexSwitch = new char[] { 'A', 'B', 'C', 'D', 'E' };
            networkTopology = new int[][] {
                    { 0, INF, 4, 4, INF },
                    { INF, 0, INF, 4, INF },
                    { 4, INF, 0, 4, 4 },
                    { 4, 4, 4, 0, 4 },
                    { INF, INF, 4, 4, 0 }
            };

        }
        graph = new Graph(vertexSwitch, networkTopology);
        graph.showGraph();

    }

}

class Switch {

    int code;
    Boolean visited;

    String name;
    String mac;
    Long pri;
    int intNumber;
    Interface Interface1, Interface2, Interface3, Interface4;

    Switch(int Code, String Name, String MAC) {

        code = Code;
        visited = false;

        name = Name;
        mac = MAC;
        pri = 32768L;

        if (code == 11 || code == 12 || code == 13 || code == 14 ||
                code == 23 || code == 24 || code == 31 || code == 35) {
            intNumber = 2;
        } else if (code == 21 || code == 22 || code == 33) {
            intNumber = 3;
        } else if (code == 34) {
            intNumber = 4;
        } else if (code == 32) {
            intNumber = 1;
        }

        if (code == 11) {
            Interface1 = new Interface(1101);
            Interface2 = new Interface(1102);

        } else if (code == 12) {
            Interface1 = new Interface(1201);
            Interface2 = new Interface(1202);

        } else if (code == 13) {
            Interface1 = new Interface(1301);
            Interface2 = new Interface(1302);

        } else if (code == 14) {
            Interface1 = new Interface(1401);
            Interface2 = new Interface(1402);

        } else if (code == 23) {
            Interface1 = new Interface(2301);
            Interface2 = new Interface(2302);

        } else if (code == 24) {
            Interface1 = new Interface(2401);
            Interface2 = new Interface(2402);

        } else if (code == 31) {
            Interface1 = new Interface(3101);
            Interface2 = new Interface(3102);

        } else if (code == 35) {
            Interface1 = new Interface(3501);
            Interface2 = new Interface(3502);

        } else if (code == 21) {

            Interface1 = new Interface(2101);
            Interface2 = new Interface(2102);
            Interface3 = new Interface(2103);

        } else if (code == 22) {

            Interface1 = new Interface(2201);
            Interface2 = new Interface(2202);
            Interface3 = new Interface(2203);

        } else if (code == 33) {

            Interface1 = new Interface(3301);
            Interface2 = new Interface(3302);
            Interface3 = new Interface(3303);

        } else if (code == 34) {

            Interface1 = new Interface(3401);
            Interface2 = new Interface(3402);
            Interface3 = new Interface(3403);
            Interface4 = new Interface(3404);

        } else if (code == 32) {

            Interface1 = new Interface(3201);
        }

    }

    class Interface {

        int code;
        int cost;
        Boolean state = true;
        Long pri;
        String identity; // 可以为或BDR

        Interface(int acode) {
            code = acode;
            pri = 32768L;
            cost = 4;
        }

    }

}
