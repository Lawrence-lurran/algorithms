package interviews.ali;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/3/15 10:55 上午
 */
public class SingletonDCL {
    private volatile static SingletonDCL singletonDCL=null;
    private SingletonDCL(){

    }
    public static SingletonDCL getSingletonDCL(){
        if (singletonDCL==null){
            synchronized (SingletonDCL.class){
                if (singletonDCL==null){
                    singletonDCL=new SingletonDCL();
                }
            }
        }
        return singletonDCL;
    }
}
