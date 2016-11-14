package stick.profecoplus;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by petu on 13/11/16.
 */

public class ProfecoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
    }
}
