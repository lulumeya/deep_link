package dalton.android.deeplink.util;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import dalton.android.deeplink.App;

import static dalton.android.deeplink.constants.Const.TAG;

/**
 * Created by Dalton on 2017. 1. 30..
 */

public class Util {

    private static Toast toast;

    public static void handleUri(String uri) {
        if (uri != null) {
            try {
                uri = uri.replace("#", "%23");
                uri = uri.replace(" ", "%20");
                Uri parsed = Uri.parse(uri);
                Log.d(TAG, "Launching with: " + parsed);
                Intent intent = new Intent(Intent.ACTION_VIEW, parsed);
                App.getContext().startActivity(intent);
            } catch (Throwable e) {
                // ignore
            }
        }
    }

    public static void toast(final String text) {
        if (toast == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    toast = Toast.makeText(App.getContext(), text, Toast.LENGTH_SHORT);
                    toast.show();
                }
            });
        } else {
            toast.cancel();
            toast.setText(text);
            toast.show();
        }
    }
}