package bwie.com.shizhan2;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

public class YiChangActivity implements Thread.UncaughtExceptionHandler {
   public static final String TAG="YiChangActivity";
   private static YiChangActivity instance;
   Context context;
    private Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;


    public static synchronized YiChangActivity getInstance()
   {
       if(null == instance)
       {
         instance =   new YiChangActivity();
       }
       return instance;
   }
   public void init(Context context)
   {
       this.context =context;
       defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
      Thread.setDefaultUncaughtExceptionHandler(this);
   }
   private boolean handlerException(Throwable ex)
   {
       if(ex == null)
       {
           return false;
       }
       addCustomInfo();
       new Thread(){
           @Override
           public void run() {
               super.run();
               Looper.prepare();
               Toast.makeText(context,"程序出问题了呢……",Toast.LENGTH_SHORT).show();
               Looper.loop();
           }
       }.start();
     return true;
   }
   private void addCustomInfo()
   {
       Log.i(TAG, "addCustomInfo: 程序出错了...");
   }
    @Override
    public void uncaughtException(Thread t, Throwable e)
    {
        if(!handlerException(e) && defaultUncaughtExceptionHandler !=null)
        {
            defaultUncaughtExceptionHandler.uncaughtException(t,e);
        }else{
            try {
                Thread.sleep(2000);
            }catch (Exception ee)
            {
                Log.e(TAG, "error : ", ee);
            }
        }


    }
}
