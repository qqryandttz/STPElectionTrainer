class NetworkTopology{

    int[][] networkTopology;
    private int inf = Integer.MAX_VALUE;
    Switch switch11, switch12, switch13, switch14;
    Switch switch21, switch22, switch23, switch24;
    Switch switch31, switch32, switch33, switch34, switch35;

    NetworkTopology(int isExample){

        if(isExample == 1){

            switch11 = new Switch(11, "SW11", "54-89-98-1C-75-C0");
            switch12 = new Switch(12, "SW12", "54-89-98-1C-75-C1");
            switch13 = new Switch(13, "SW13", "54-89-98-1C-75-C2");
            switch14 = new Switch(14, "SW14", "54-89-98-1C-75-C3");
            networkTopology = new int[][]{
                {0,4,4,inf},
                {4,0,inf,4},
                {4,inf,0,4},
                {inf,4,4,0}
            };

        }else if(isExample == 2){

            switch21 = new Switch(21, "SW21", "54-89-98-1C-75-C0");
            switch22 = new Switch(22, "SW22", "54-89-98-1C-75-C1");
            switch23 = new Switch(23, "SW23", "54-89-98-1C-75-C2");
            switch24 = new Switch(24, "SW24", "54-89-98-1C-75-C3");
            networkTopology = new int[][] {
                    { 0, 4, 4, 4 },
                    { 4, 0, 4, 4 },
                    { 4, 4, 0, inf },
                    { 4, 4, inf, 0 }
            };


        }else if(isExample == 3){

            switch31 = new Switch(31, "SW31", "54-89-98-1C-75-C0");
            switch32 = new Switch(32, "SW32", "54-89-98-1C-75-C1");
            switch33 = new Switch(33, "SW33", "54-89-98-1C-75-C2");
            switch34 = new Switch(34, "SW34", "54-89-98-1C-75-C3");
            switch35 = new Switch(35, "SW35", "54-89-98-1C-75-C4");
            networkTopology = new int[][] {
                    { 0, inf, 4, 4 ,inf},
                    { inf, 0, inf, 4, inf },
                    { 4, inf, 0, 4, 4 },
                    { 4, 4, 4 ,0, 4},
                    { inf, inf, 4, 4, 0 }
            };

            
        }

    }

}


class Switch{

    int code;
    String name;
    String mac;
    Long pri;
    int intNumber;

    Switch(int Code, String Name, String MAC){

        code = Code;
        name = Name;
        mac = MAC;
        pri = 32768L;

        if(code == 11 || code == 12 || code == 13 || code == 14 || 
        code == 23 || code == 24 || code == 31 || code == 35){

            intNumber = 2;
            Interface Interface1 = new Interface();
            Interface Interface2 = new Interface();

        }else if(code == 21 || code == 22 || code == 33){

            intNumber = 3;
            Interface Interface1 = new Interface();
            Interface Interface2 = new Interface();
            Interface Interface3 = new Interface();
            

        }else if (code == 34) {

            intNumber = 4;
            Interface Interface1 = new Interface();
            Interface Interface2 = new Interface();
            Interface Interface3 = new Interface();
            Interface Interface4 = new Interface();

        } else if (code == 32) {

            intNumber = 1;
            Interface Interface1 = new Interface();
        }
        

    }

}

class Interface{

    int code;
    String name;
    Boolean state;

    Interface(){

    }

}