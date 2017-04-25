package com.tencent.mmdb;

import android.annotation.SuppressLint;
import android.net.Uri;
import java.util.Iterator;

public class ContentObservable extends Observable<ContentObserver> {
    public void registerObserver(ContentObserver contentObserver) {
        super.registerObserver(contentObserver);
    }

    @Deprecated
    public void dispatchChange(boolean z) {
        dispatchChange(z, null);
    }

    public void dispatchChange(boolean z, Uri uri) {
        synchronized (this.mObservers) {
            Iterator it = this.mObservers.iterator();
            while (it.hasNext()) {
                ContentObserver contentObserver = (ContentObserver) it.next();
                if (!z || contentObserver.deliverSelfNotifications()) {
                    contentObserver.dispatchChanges(z, uri);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    @Deprecated
    public void notifyChange(boolean z) {
        synchronized (this.mObservers) {
            Iterator it = this.mObservers.iterator();
            while (it.hasNext()) {
                ((ContentObserver) it.next()).onChange(z, null);
            }
        }
    }
}
