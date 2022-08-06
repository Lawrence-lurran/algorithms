package interviews.ali;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/3/15 10:48 上午
 */
public class Singleton {
    private static Singleton singleton=new Singleton();
    private Singleton(){

    }
    public static Singleton getSingleton(){
        return singleton;
    }
}
