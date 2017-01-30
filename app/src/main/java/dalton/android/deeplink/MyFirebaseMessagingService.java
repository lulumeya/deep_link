package dalton.android.deeplink;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Arrays;

import dalton.android.deeplink.util.Util;

import static dalton.android.deeplink.constants.Const.TAG;


/**
 * Created by Dalton on 2017. 1. 30..
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.

        Log.d(TAG, "=== keys ===");
        Log.d(TAG, Arrays.toString(remoteMessage.getData().keySet().toArray()));
        Log.d(TAG, "=== values ===");
        Log.d(TAG, Arrays.toString(remoteMessage.getData().values().toArray()));

        String uri;
        if ((uri = remoteMessage.getData().get("uri")) != null) {
            Util.toast("Launching Uri " + uri);
            Util.handleUri(uri);
        }
    }
}