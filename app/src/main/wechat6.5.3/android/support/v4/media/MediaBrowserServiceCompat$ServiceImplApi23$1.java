package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.os.ResultReceiver;

class MediaBrowserServiceCompat$ServiceImplApi23$1 extends ResultReceiver {
    protected final void onReceiveResult(int i, Bundle bundle) {
        MediaItem mediaItem = (MediaItem) bundle.getParcelable("media_item");
        if (mediaItem != null) {
            mediaItem.writeToParcel(Parcel.obtain(), 0);
        }
    }
}
