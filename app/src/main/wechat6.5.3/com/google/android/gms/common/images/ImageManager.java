package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import com.google.android.gms.c.l;
import com.google.android.gms.c.o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

public final class ImageManager {
    private static final Object anm = new Object();
    private static HashSet<Uri> ann = new HashSet();
    private final ExecutorService ano;
    private final b anp;
    private final l anq;
    private final Map<a, ImageReceiver> anr;
    private final Map<Uri, ImageReceiver> ans;
    private final Map<Uri, Long> ant;
    private final Context mContext;
    private final Handler mHandler;

    private final class ImageReceiver extends ResultReceiver {
        private final ArrayList<a> anu;
        final /* synthetic */ ImageManager anv;
        private final Uri mUri;

        public final void onReceiveResult(int i, Bundle bundle) {
            this.anv.ano.execute(new c(this.anv, this.mUri, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public interface a {
    }

    private final class c implements Runnable {
        final /* synthetic */ ImageManager anv;
        private final ParcelFileDescriptor anw;
        private final Uri mUri;

        public c(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.anv = imageManager;
            this.mUri = uri;
            this.anw = parcelFileDescriptor;
        }

        public final void run() {
            String str = "LoadBitmapFromDiskRunnable can't be executed in the main thread";
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                new StringBuilder("checkNotMainThread: current thread ").append(Thread.currentThread()).append(" IS the main thread ").append(Looper.getMainLooper().getThread()).append("!");
                throw new IllegalStateException(str);
            }
            boolean z = false;
            Bitmap bitmap = null;
            if (this.anw != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.anw.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    new StringBuilder("OOM while loading bitmap for uri: ").append(this.mUri);
                    z = true;
                }
                try {
                    this.anw.close();
                } catch (IOException e2) {
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.anv.mHandler.post(new d(this.anv, this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                new StringBuilder("Latch interrupted while posting ").append(this.mUri);
            }
        }
    }

    private final class d implements Runnable {
        private final CountDownLatch ali;
        final /* synthetic */ ImageManager anv;
        private boolean anx;
        private final Bitmap mBitmap;
        private final Uri mUri;

        public d(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.anv = imageManager;
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.anx = z;
            this.ali = countDownLatch;
        }

        private void a(ImageReceiver imageReceiver, boolean z) {
            ArrayList a = imageReceiver.anu;
            int size = a.size();
            for (int i = 0; i < size; i++) {
                a aVar = (a) a.get(i);
                if (z) {
                    aVar.a(this.anv.mContext, this.mBitmap);
                } else {
                    this.anv.ant.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    aVar.a(this.anv.mContext, this.anv.anq);
                }
                if (!(aVar instanceof com.google.android.gms.common.images.a.b)) {
                    this.anv.anr.remove(aVar);
                }
            }
        }

        public final void run() {
            String str = "OnBitmapLoadedRunnable must be executed in the main thread";
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                new StringBuilder("checkMainThread: current thread ").append(Thread.currentThread()).append(" IS NOT the main thread ").append(Looper.getMainLooper().getThread()).append("!");
                throw new IllegalStateException(str);
            }
            boolean z = this.mBitmap != null;
            if (this.anv.anp != null) {
                if (this.anx) {
                    this.anv.anp.trimToSize(-1);
                    System.gc();
                    this.anx = false;
                    this.anv.mHandler.post(this);
                    return;
                } else if (z) {
                    this.anv.anp.put(new a(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.anv.ans.remove(this.mUri);
            if (imageReceiver != null) {
                a(imageReceiver, z);
            }
            this.ali.countDown();
            synchronized (ImageManager.anm) {
                ImageManager.ann.remove(this.mUri);
            }
        }
    }

    private static final class b extends o<a, Bitmap> {
        protected final /* synthetic */ int W(Object obj) {
            Bitmap bitmap = (Bitmap) obj;
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
    }
}
