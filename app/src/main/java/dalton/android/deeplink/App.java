package dalton.android.deeplink;

import android.app.Application;

/**
 * Created by Dalton on 2017. 1. 30..
 */
public class App extends Application {
    private static App context;

    @Override
    public void onCreate() {
        super.onCreate();
        setContext(this);
    }

    public static void setContext(App context) {
        App.context = context;
    }

    public static App getContext() {
        return App.context;
    }
}