//完蛋,不会做,先放着有机会写

public class 存档功能 {
    处理语句 语句处理器;

    boolean 扫描是否存档(){

        语句处理器 = new 处理语句( "resources\\_100文章\\旧矿界.txt");
        if(语句处理器.存档时的进行分析()){
            System.out.println("已读取到存档位置");
            return true;
        }
        System.out.println("未读取到存档");
        return false;
    }

    处理语句 得到语句处理器(){
        return 语句处理器;
    }

    void 关闭语句处理器(){
        ;
    }

    

}
