package com.tencent.mm.memory;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.FileUtils;

public final class c extends a<Bitmap> {
    private static int cnn = 20971520;
    public static final c cno = new c();

    public final /* synthetic */ Object a(Comparable comparable) {
        return e((Integer) comparable);
    }

    public final /* synthetic */ void ar(Object obj) {
        d((Bitmap) obj);
    }

    protected final /* synthetic */ long as(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap == null) {
            return 0;
        }
        return (long) (d.dX(19) ? bitmap.getByteCount() : bitmap.getAllocationByteCount());
    }

    protected final /* synthetic */ Comparable at(Object obj) {
        return c((Bitmap) obj);
    }

    protected final /* synthetic */ Comparable b(Comparable comparable) {
        return d((Integer) comparable);
    }

    public final /* synthetic */ Object b(Integer num) {
        return e(num);
    }

    protected final /* synthetic */ d c(Comparable comparable) {
        return new b(((Integer) comparable).intValue());
    }

    protected final /* synthetic */ Object d(Comparable comparable) {
        return Bitmap.createBitmap(1, ((Integer) comparable).intValue(), k.cnx);
    }

    private c() {
        v.i("MicroMsg.BitmapPool", "BitmapPool %dMB", Integer.valueOf(((ActivityManager) aa.getContext().getSystemService("activity")).getLargeMemoryClass()));
        if (((ActivityManager) aa.getContext().getSystemService("activity")).getLargeMemoryClass() > FileUtils.S_IRUSR) {
            cnn = 20971520;
        } else {
            cnn = 10485760;
        }
        we();
    }

    protected static Integer d(Integer num) {
        return Integer.valueOf(num.intValue() * 4);
    }

    protected final long wa() {
        return (long) cnn;
    }

    protected final long wb() {
        return 1048576;
    }

    public final synchronized Bitmap e(Integer num) {
        Bitmap bitmap;
        bitmap = (Bitmap) super.b(num);
        if (bitmap == null || bitmap.isRecycled() || !bitmap.isMutable()) {
            bitmap = null;
        } else {
            v.d("MicroMsg.BitmapPool", "get stored element: %s, width: %s, height: %s, size: %s, requireSize: %s", bitmap, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), c(bitmap), num);
        }
        return bitmap;
    }

    private static Integer c(Bitmap bitmap) {
        if (bitmap == null) {
            return Integer.valueOf(0);
        }
        int byteCount;
        if (d.dX(19)) {
            byteCount = bitmap.getByteCount();
        } else {
            byteCount = bitmap.getAllocationByteCount();
        }
        return Integer.valueOf(byteCount);
    }

    public final synchronized void d(Bitmap bitmap) {
        if (bitmap != null) {
            if (bitmap.isMutable() && !bitmap.isRecycled()) {
                v.i("MicroMsg.BitmapPool", "release: %s", bitmap);
                super.ar(bitmap);
            }
        }
    }

    public final void wc() {
        super.wc();
    }
}
