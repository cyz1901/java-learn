public class SingleFactory {
}


// 饿汉
class SingleEH {
    private static final SingleEH singleEH = new SingleEH();

    private SingleEH() {

    }

    public static SingleEH getInstance() {
        return singleEH;
    }
}

// 懒汉
class SingleLH{
    private static SingleLH singleLH = null;

    private SingleLH(){
        
    }

    public static SingleLH getInstance(){
        if (singleLH == null) {
            singleLH = new SingleLH();
        }
        return singleLH;
    }
    
}

// 饿汉doublecheck
class SingleDoubleCheck{
    private volatile static SingleDoubleCheck singleDoubleCheck = null;

    private SingleDoubleCheck(){

    }

    public static SingleDoubleCheck getInstance(){
        if (singleDoubleCheck == null) {
            synchronized (SingleDoubleCheck.class) {
                if (singleDoubleCheck == null) {
                    singleDoubleCheck = new SingleDoubleCheck();
                }
            }
        }
        return singleDoubleCheck;
    }
}


