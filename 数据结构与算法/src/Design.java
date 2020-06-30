public class Design {
    public static void main(String[] args) {

    }
}

//懒汉式 单例模式
class LHan{
    private static LHan lhan;

    private LHan(){

    }

    public static LHan creat(){
        synchronized(LHan.class){//使用同步代码块实现保证线程安全
            if (lhan == null){
                lhan = new LHan();
            }
        }
        return lhan;
    }
}

//饿汉式 单例模式
class EHan{
    private static EHan eHan = new EHan();
    private EHan(){

    }
    public static EHan creat(){
        return eHan;
    }
}

//枚举 单例模式
enum eSingal{
    eSingal;
    public void pr(){
        System.out.println("success");
    }
}
