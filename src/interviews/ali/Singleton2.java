package interviews.ali;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/3/15 10:51 上午
 */
public class Singleton2 {
    private static Singleton2 singleton2=null;
    private Singleton2(){

    }
    public synchronized Singleton2 getSingleton2(){
        if (singleton2==null){
            singleton2=new Singleton2();
        }
        return singleton2;
    }
}
