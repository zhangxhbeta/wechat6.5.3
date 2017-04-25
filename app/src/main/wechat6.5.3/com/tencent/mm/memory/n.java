package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class n implements i {
    private static ConcurrentHashMap<Bitmap, Integer> cnF = new ConcurrentHashMap();
    private boolean DEBUG = false;
    public Bitmap bitmap = null;
    private ac cnC = new ac(Looper.getMainLooper());
    private boolean cnD = false;
    private AtomicInteger cnE = new AtomicInteger();
    private boolean cnG = true;
    private Runnable cnH = new Runnable(this) {
        final /* synthetic */ n cnK;

        {
            this.cnK = r1;
        }

        public final void run() {
            this.cnK.wp();
        }
    };
    private int cnI = 0;
    private int cnJ = 0;

    private n(Bitmap bitmap) {
        this.bitmap = bitmap;
        this.cnE.set(1);
        if (this.DEBUG) {
            v.i("MicroMsg.ReleasableBitmap", "bitmap " + bitmap + " " + this.bitmap.hashCode() + " mm: " + hashCode() + " this: " + this + " " + be.bur().toString());
        }
        this.cnD = false;
        getAllocationByteCount();
    }

    public static n f(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new n(bitmap);
    }

    public final Bitmap wm() {
        this.cnG = false;
        return this.bitmap;
    }

    public final void wi() {
        this.cnE.incrementAndGet();
        if (this.DEBUG) {
            v.i("MicroMsg.ReleasableBitmap", "addLiveReference, attachCount:" + this.cnE + " bitmap:" + this.bitmap + " " + this + " " + be.bur().toString());
        }
    }

    public final void wj() {
        if (this.DEBUG) {
            v.i("MicroMsg.ReleasableBitmap", "removeLiveReference, attachCount:" + this.cnE + " bitmap:" + this.bitmap + " " + this + " " + be.bur().toString());
        }
        if (this.cnE.get() > 0) {
            this.cnE.decrementAndGet();
            if (this.cnE.get() >= 0) {
                this.cnC.removeCallbacks(this.cnH);
                this.cnC.postDelayed(this.cnH, 500);
            }
        }
    }

    public final Bitmap wn() {
        if (this.DEBUG) {
            v.i("MicroMsg.ReleasableBitmap", "getBitmapReadOnly " + toString() + " " + be.bur().toString());
        }
        return this.bitmap;
    }

    public final boolean isRecycled() {
        return this.cnD || this.bitmap == null || this.bitmap.isRecycled();
    }

    public final boolean wo() {
        this.cnE.decrementAndGet();
        if (this.DEBUG) {
            v.i("MicroMsg.ReleasableBitmap", "recycle~:" + this.cnD + " isMutable:" + this.cnG + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.cnE + be.bur().toString());
        }
        wp();
        return true;
    }

    private boolean wp() {
        if (this.DEBUG) {
            v.i("MicroMsg.ReleasableBitmap", "recycleImpl~:" + this.cnD + " isMutable:" + this.cnG + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.cnE + be.bur().toString());
        }
        if (this.cnD || this.cnE.get() > 0) {
            return false;
        }
        this.cnD = true;
        if (this.DEBUG) {
            cnF.remove(this.bitmap);
        }
        if (!this.cnG) {
            return true;
        }
        l.wk().e(this.bitmap);
        return true;
    }

    public final int getAllocationByteCount() {
        if (d.dX(19)) {
            if (this.bitmap == null || this.bitmap.isRecycled()) {
                v.i("MicroMsg.ReleasableBitmap", "getByteCount recycle " + this.cnI + " " + toString());
                return this.cnI;
            }
            this.cnI = this.bitmap.getByteCount();
            return this.cnI;
        } else if (this.bitmap == null || this.bitmap.isRecycled()) {
            v.i("MicroMsg.ReleasableBitmap", "getAllocationByteCount recycle " + this.cnJ + " " + toString());
            return this.cnJ;
        } else {
            this.cnJ = this.bitmap.getAllocationByteCount();
            return this.cnJ;
        }
    }

    public final String toString() {
        if (!this.DEBUG) {
            return super.toString();
        }
        String str = super.toString() + " code: " + hashCode() + " attachCount: " + this.cnE;
        if (this.bitmap != null) {
            return str + this.bitmap;
        }
        return str;
    }

    protected final void finalize() {
        if (this.DEBUG) {
            v.i("MicroMsg.ReleasableBitmap", "bitmap finalize " + toString());
        }
    }

    public final String wq() {
        return this + " " + this.bitmap;
    }
}
