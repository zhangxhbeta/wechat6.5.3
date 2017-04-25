package com.tencent.mmdb;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Handler;
import com.tencent.mmdb.IContentObserver.Stub;

public abstract class ContentObserver extends android.database.ContentObserver {
    Handler mHandler;
    private final Object mLock = new Object();
    private Transport mTransport;

    private final class NotificationRunnable implements Runnable {
        private final boolean mSelfChange;
        private final Uri mUri;

        public NotificationRunnable(boolean z, Uri uri) {
            this.mSelfChange = z;
            this.mUri = uri;
        }

        @SuppressLint({"NewApi"})
        public final void run() {
            ContentObserver.this.onChange(this.mSelfChange, this.mUri);
        }
    }

    private static final class Transport extends Stub {
        private ContentObserver mContentObserver;

        public Transport(ContentObserver contentObserver) {
            this.mContentObserver = contentObserver;
        }

        public final void onChange(boolean z, Uri uri) {
            ContentObserver contentObserver = this.mContentObserver;
            if (contentObserver != null) {
                contentObserver.dispatchChanges(z, uri);
            }
        }

        public final void releaseContentObserver() {
            this.mContentObserver = null;
        }
    }

    public ContentObserver(Handler handler) {
        super(handler);
        this.mHandler = handler;
    }

    public IContentObserver getContentObserver() {
        IContentObserver iContentObserver;
        synchronized (this.mLock) {
            if (this.mTransport == null) {
                this.mTransport = new Transport(this);
            }
            iContentObserver = this.mTransport;
        }
        return iContentObserver;
    }

    public IContentObserver releaseContentObserver() {
        IContentObserver iContentObserver;
        synchronized (this.mLock) {
            iContentObserver = this.mTransport;
            if (iContentObserver != null) {
                iContentObserver.releaseContentObserver();
                this.mTransport = null;
            }
        }
        return iContentObserver;
    }

    public boolean deliverSelfNotifications() {
        return false;
    }

    public void onChange(boolean z) {
    }

    public void onChange(boolean z, Uri uri) {
        onChange(z);
    }

    public final void dispatchChanges(boolean z, Uri uri) {
        if (this.mHandler == null) {
            onChange(z, uri);
        } else {
            this.mHandler.post(new NotificationRunnable(z, uri));
        }
    }
}
