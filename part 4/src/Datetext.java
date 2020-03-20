import java.time.LocalDate;
import java.util.Date;

public class Datetext {
    public static void main(String[] args) {
        Date date = null;//创建一个对象变量 并显式赋值为null
        date = new Date();//用新构造的对象初始化这个对象变量 对象变量储存的是这个新对象的引用
        System.out.println(date.toString());

        LocalDate newdate = LocalDate.now();//使用静态工厂方法来构造对象
        LocalDate aThousandDaysLater = newdate.plusDays(1000);//访问器方法生成新的对象 而不改变原来的对象
        int year = aThousandDaysLater .getYear();
        int month = aThousandDaysLater.getMonthValue();
        int day = aThousandDaysLater.getDayOfMonth();
        System.out.println(year);


    }
}
