package com.tencent.mm.u;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.a.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.h.h;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public final class d {
    private static int cyb = 150;
    private static int cyc = 150;
    static final Map<String, Integer> cyd;
    private static a cyh = new a(cyc);
    private h<a, String> cye = new h<a, String>(this) {
        final /* synthetic */ d cyi;

        {
            this.cyi = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((a) obj).gM((String) obj2);
        }
    };
    private Vector<WeakReference<a>> cyf = new Vector();
    private final a cyg = new a(this) {
        final /* synthetic */ d cyi;

        {
            this.cyi = r1;
        }

        public final void gM(String str) {
            Collection vector = new Vector();
            v.d("MicroMsg.AvatarStorage", "notifyChanged user:%s clonesize:%d watchers:%d", str, Integer.valueOf(this.cyi.cyf.size()), Integer.valueOf(this.cyi.cyf.size()));
            Vector vector2 = new Vector();
            synchronized (this.cyi.cyf) {
                for (int i = 0; i < this.cyi.cyf.size(); i++) {
                    WeakReference weakReference = (WeakReference) this.cyi.cyf.get(i);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            vector2.add(aVar);
                        } else {
                            vector.add(weakReference);
                        }
                    }
                }
                this.cyi.cyf.removeAll(vector);
            }
            for (int i2 = 0; i2 < vector2.size(); i2++) {
                ((a) vector2.get(i2)).gM(str);
            }
        }
    };

    public interface a {
        void gM(String str);
    }

    public static class b {
        public static boolean gN(String str) {
            Bitmap gO = gO(str);
            if (gO == null || gO.isRecycled()) {
                return false;
            }
            OutputStream outputStream = null;
            try {
                outputStream = FileOp.gt(str);
                gO.compress(CompressFormat.PNG, 100, outputStream);
                FileOp.deleteFile(str + ".bm");
                if (outputStream == null) {
                    return true;
                }
                try {
                    outputStream.close();
                    return true;
                } catch (IOException e) {
                    return true;
                }
            } catch (Throwable e2) {
                v.a("MicroMsg.AvatarStorage", e2, "Cannot write avatar file: %s", str);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e3) {
                    }
                }
                return false;
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                    }
                }
            }
        }

        public static Bitmap gO(String str) {
            InputStream openRead;
            Exception e;
            OutOfMemoryError e2;
            String str2 = str + ".bm";
            ReadableByteChannel newChannel;
            try {
                if (FileOp.aR(str2)) {
                    int jP = (int) FileOp.jP(str2);
                    if (jP <= 0 || !(jP == 36864 || jP == 36880)) {
                        dd(str);
                        v.e("MicroMsg.AvatarStorage", "SmallBM get bm invalid size:%d file:%s", Integer.valueOf(jP), str2);
                        return null;
                    }
                    openRead = FileOp.openRead(str2);
                    try {
                        newChannel = Channels.newChannel(openRead);
                        try {
                            boolean z;
                            Buffer allocateDirect = ByteBuffer.allocateDirect(36864);
                            newChannel.read(allocateDirect);
                            allocateDirect.position(0);
                            if (jP == 36880) {
                                ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(16);
                                newChannel.read(allocateDirect2);
                                if (allocateDirect2.getLong(0) != 1) {
                                    v.e("MicroMsg.AvatarStorage", "SmallBM get bm header invalid flag:%d size:%d file:%s", Long.valueOf(allocateDirect2.getLong(0)), Integer.valueOf(jP), str2);
                                    newChannel.close();
                                    openRead.close();
                                    dd(str);
                                    return null;
                                }
                                z = false;
                            } else {
                                z = true;
                            }
                            v.d("MicroMsg.AvatarStorage", "SmallBM get bm size:%d shouldRemoveCorner:%b file:%s", Integer.valueOf(jP), Boolean.valueOf(z), str2);
                            newChannel.close();
                            openRead.close();
                            Bitmap createBitmap = Bitmap.createBitmap(96, 96, Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(allocateDirect);
                            if (!z) {
                                return createBitmap;
                            }
                            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 9, 9, 78, 78);
                            v.i("MicroMsg.AvatarStorage", "recycle bitmap:%s", createBitmap.toString());
                            createBitmap.recycle();
                            return createBitmap2;
                        } catch (Exception e3) {
                            e = e3;
                            v.e("MicroMsg.AvatarStorage", "SmallBM get exception e:%s file:%s", e.getMessage(), str2);
                            if (newChannel != null) {
                                try {
                                    newChannel.close();
                                } catch (Exception e4) {
                                    return null;
                                }
                            }
                            if (openRead != null) {
                                return null;
                            }
                            openRead.close();
                            return null;
                        } catch (OutOfMemoryError e5) {
                            e2 = e5;
                            v.e("MicroMsg.AvatarStorage", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str2);
                            if (newChannel != null) {
                                newChannel.close();
                            }
                            if (openRead != null) {
                                return null;
                            }
                            openRead.close();
                            return null;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        newChannel = null;
                        v.e("MicroMsg.AvatarStorage", "SmallBM get exception e:%s file:%s", e.getMessage(), str2);
                        if (newChannel != null) {
                            newChannel.close();
                        }
                        if (openRead != null) {
                            return null;
                        }
                        openRead.close();
                        return null;
                    } catch (OutOfMemoryError e7) {
                        e2 = e7;
                        newChannel = null;
                        v.e("MicroMsg.AvatarStorage", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str2);
                        if (newChannel != null) {
                            newChannel.close();
                        }
                        if (openRead != null) {
                            return null;
                        }
                        openRead.close();
                        return null;
                    }
                }
                v.w("MicroMsg.AvatarStorage", "SmallBM get bm file not exsit:%s", str2);
                return null;
            } catch (Exception e8) {
                e = e8;
                newChannel = null;
                openRead = null;
                v.e("MicroMsg.AvatarStorage", "SmallBM get exception e:%s file:%s", e.getMessage(), str2);
                if (newChannel != null) {
                    newChannel.close();
                }
                if (openRead != null) {
                    return null;
                }
                openRead.close();
                return null;
            } catch (OutOfMemoryError e9) {
                e2 = e9;
                newChannel = null;
                openRead = null;
                v.e("MicroMsg.AvatarStorage", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str2);
                if (newChannel != null) {
                    newChannel.close();
                }
                if (openRead != null) {
                    return null;
                }
                openRead.close();
                return null;
            }
        }

        static boolean dd(String str) {
            FileOp.deleteFile(str + ".bm");
            FileOp.deleteFile(str);
            return true;
        }
    }

    static {
        Map hashMap = new HashMap();
        cyd = hashMap;
        hashMap.put("voipapp", Integer.valueOf(2131165467));
        cyd.put("qqmail", Integer.valueOf(2131165460));
        cyd.put("fmessage", Integer.valueOf(2131165447));
        cyd.put("qmessage", Integer.valueOf(2131165457));
        cyd.put("qqsync", Integer.valueOf(2131165461));
        cyd.put("floatbottle", Integer.valueOf(2131165441));
        cyd.put("lbsapp", Integer.valueOf(2131165454));
        cyd.put("shakeapp", Integer.valueOf(2131165464));
        cyd.put("medianote", Integer.valueOf(2131165452));
        cyd.put("qqfriend", Integer.valueOf(2131165459));
        cyd.put("masssendapp", Integer.valueOf(2131165451));
        cyd.put("feedsapp", Integer.valueOf(2131165446));
        cyd.put("facebookapp", Integer.valueOf(2131165445));
        cyd.put("newsapp", Integer.valueOf(2131165462));
        cyd.put("helper_entry", Integer.valueOf(2131165456));
        cyd.put("voicevoipapp", Integer.valueOf(2131165466));
        cyd.put("voiceinputapp", Integer.valueOf(2131165465));
        cyd.put("officialaccounts", Integer.valueOf(2131165442));
        cyd.put("service_officialaccounts", Integer.valueOf(2131165463));
        cyd.put("googlecontact", Integer.valueOf(2131165448));
        cyd.put("linkedinplugin", Integer.valueOf(2131165450));
        cyd.put("notifymessage", Integer.valueOf(2131165455));
        cyd.put("appbrandcustomerservicemsg", Integer.valueOf(2131165439));
    }

    public static void a(Context context, ImageView imageView, int i) {
        try {
            imageView.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.compatible.f.a.decodeResource(context.getResources(), i), true, 1.0f));
        } catch (Throwable e) {
            v.e("MicroMsg.AvatarStorage", "exception:%s", be.e(e));
        }
    }

    public d() {
        reset();
        this.cye.a(this.cyg, null);
    }

    public final void a(a aVar) {
        synchronized (this.cyf) {
            this.cyf.add(new WeakReference(aVar));
        }
    }

    public final void b(a aVar) {
        synchronized (this.cyf) {
            this.cyf.remove(c(aVar));
        }
    }

    private WeakReference<a> c(a aVar) {
        synchronized (this.cyf) {
            for (int i = 0; i < this.cyf.size(); i++) {
                WeakReference<a> weakReference = (WeakReference) this.cyf.get(i);
                if (weakReference != null) {
                    a aVar2 = (a) weakReference.get();
                    if (aVar2 != null && aVar2.equals(aVar)) {
                        return weakReference;
                    }
                }
            }
            return null;
        }
    }

    @Deprecated
    public final void d(a aVar) {
        this.cye.a(aVar, Looper.getMainLooper());
    }

    @Deprecated
    public final void e(a aVar) {
        this.cye.remove(aVar);
    }

    public static void reset() {
        if (cyh == null) {
            cyh = new a(cyc);
        }
    }

    public static Bitmap gH(String str) {
        if (be.kS(str)) {
            return null;
        }
        a aVar = cyh;
        Bitmap bitmap = aVar.cxI != null ? (Bitmap) aVar.cxI.get(str) : (Bitmap) com.tencent.mm.cache.a.a.x("avatar_cache", str);
        if (bitmap == null) {
            return null;
        }
        if (!bitmap.isRecycled()) {
            return bitmap;
        }
        aVar = cyh;
        if (aVar.cxI != null) {
            aVar.cxI.remove(str);
        } else {
            com.tencent.mm.cache.a.a.y("avatar_cache", str);
        }
        return null;
    }

    public final void c(String str, Bitmap bitmap) {
        a aVar = cyh;
        if (aVar.cxI != null) {
            aVar.cxI.k(str, bitmap);
        } else {
            com.tencent.mm.cache.a.a.a("avatar_cache", str, (Object) bitmap);
        }
        this.cye.bg(str);
        this.cye.Ls();
        v.d("MicroMsg.AvatarStorage", "setToCache %s", str);
    }

    public final Bitmap aM(Context context) {
        context.getResources();
        Bitmap gH = gH("I_AM_NO_SDCARD_USER_NAME");
        if (i(gH) || gH == null) {
            return gH;
        }
        v.i("MicroMsg.AvatarStorage", "not cached, recycled=%b, reload=%s", Boolean.valueOf(gH.isRecycled()), "I_AM_NO_SDCARD_USER_NAME");
        gH = com.tencent.mm.sdk.platformtools.d.a(gH, true, 1.0f);
        c("I_AM_NO_SDCARD_USER_NAME", gH);
        return gH;
    }

    public static String s(String str, boolean z) {
        if (be.kS(str)) {
            return null;
        }
        ak.yW();
        String a = com.tencent.mm.sdk.platformtools.h.a(c.wR(), "user_" + (z ? "hd_" : SQLiteDatabase.KeyEmpty), g.m(str.getBytes()), ".png", 1, false);
        if (a == null) {
            return null;
        }
        return !FileOp.jS(new File(a).getParent()) ? null : a;
    }

    public static boolean t(String str, boolean z) {
        String s = s(str, z);
        v.i("MicroMsg.AvatarStorage", "Removed avatar: %s, hd: %b, path: %s", str, Boolean.valueOf(z), s);
        boolean deleteFile = FileOp.deleteFile(s);
        if (z) {
            return deleteFile;
        }
        return deleteFile | b.dd(s);
    }

    public static Bitmap gI(String str) {
        return gL(s(str, false));
    }

    public static Bitmap f(String str, byte[] bArr) {
        Throwable e;
        Bitmap a = com.tencent.mm.sdk.platformtools.d.a(bArr, 96, 96, 0, 0, 1);
        if (i(a)) {
            int width = a.getWidth();
            int height = a.getHeight();
            if (width != height) {
                if (width > height) {
                    a = Bitmap.createBitmap(a, (width - height) / 2, 0, height, height);
                } else {
                    a = Bitmap.createBitmap(a, 0, (height - width) / 2, width, width);
                }
            }
            OutputStream gt;
            try {
                gt = FileOp.gt(s(str, false));
                try {
                    gt.write(bArr, 0, bArr.length);
                    if (gt != null) {
                        try {
                            gt.close();
                        } catch (IOException e2) {
                        }
                    }
                    v.i("MicroMsg.AvatarStorage", "Saved avatar: %s", str);
                    return a;
                } catch (IOException e3) {
                    e = e3;
                    try {
                        v.a("MicroMsg.AvatarStorage", e, "Failed to save avatar: %s", str);
                        if (gt != null) {
                            try {
                                gt.close();
                            } catch (IOException e4) {
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (gt != null) {
                            try {
                                gt.close();
                            } catch (IOException e5) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                gt = null;
                v.a("MicroMsg.AvatarStorage", e, "Failed to save avatar: %s", str);
                if (gt != null) {
                    gt.close();
                }
                return null;
            } catch (Throwable th2) {
                e = th2;
                gt = null;
                if (gt != null) {
                    gt.close();
                }
                throw e;
            }
        }
        v.e("MicroMsg.AvatarStorage", "Failed to decode avatar: %s", str);
        return null;
    }

    public final boolean g(String str, byte[] bArr) {
        Bitmap f = f(str, bArr);
        if (!i(f)) {
            return false;
        }
        c(str, f);
        return true;
    }

    public final boolean O(String str, String str2) {
        int i = 96;
        try {
            int i2;
            Options JS = com.tencent.mm.sdk.platformtools.d.JS(str);
            int i3 = JS.outWidth;
            int i4 = JS.outHeight;
            if (i4 < i3) {
                i2 = (i3 * 96) / i4;
            } else {
                i = (i4 * 96) / i3;
                i2 = 96;
            }
            v.d("MicroMsg.AvatarStorage", "inJustDecodeBounds old [w:%d h:%d]  new [w:%d h:%d] corner:%d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(1));
            Options options = new Options();
            options.inPreferredConfig = Config.ARGB_8888;
            options.inSampleSize = Math.min(i3 / i2, i4 / i);
            Bitmap a = com.tencent.mm.sdk.platformtools.d.a(str, options, 0, 0, 1);
            a.recycle();
            return d(str2, a);
        } catch (Throwable e) {
            v.e("MicroMsg.AvatarStorage", "exception:%s", be.e(e));
            return false;
        }
    }

    boolean d(String str, Bitmap bitmap) {
        Throwable e;
        OutputStream outputStream;
        if (!i(bitmap)) {
            return false;
        }
        Bitmap bitmap2;
        if (bitmap.getWidth() == 96 && bitmap.getHeight() == 96) {
            bitmap2 = bitmap;
        } else {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (width != height) {
                    if (width > height) {
                        bitmap2 = Bitmap.createBitmap(bitmap, (width - height) / 2, 0, height, height);
                    } else {
                        bitmap2 = Bitmap.createBitmap(bitmap, 0, (height - width) / 2, width, width);
                    }
                    bitmap2 = Bitmap.createScaledBitmap(bitmap2, 96, 96, true);
                } else {
                    bitmap2 = Bitmap.createScaledBitmap(bitmap, 96, 96, true);
                }
            } catch (OutOfMemoryError e2) {
                v.e("MicroMsg.AvatarStorage", "kevin updateAvatar fail  %s ", str);
                if (i(bitmap)) {
                    v.i("MicroMsg.AvatarStorage", "recycle bitmap:%s", bitmap.toString());
                    bitmap.recycle();
                }
                return false;
            }
        }
        if (!(bitmap2 == null || bitmap2 == bitmap)) {
            v.i("MicroMsg.AvatarStorage", "recycle bitmap:%s", bitmap.toString());
            bitmap.recycle();
            bitmap = bitmap2;
        }
        OutputStream outputStream2 = null;
        try {
            outputStream2 = FileOp.gt(s(str, false));
            try {
                bitmap.compress(CompressFormat.PNG, 100, outputStream2);
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e3) {
                    }
                }
                c(str, bitmap);
                return true;
            } catch (IOException e4) {
                e = e4;
                outputStream = outputStream2;
                try {
                    v.a("MicroMsg.AvatarStorage", e, "Failed to save avatar: %s", str);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    e = th;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                outputStream = outputStream2;
                if (outputStream != null) {
                    outputStream.close();
                }
                throw e;
            }
        } catch (IOException e7) {
            e = e7;
            outputStream = outputStream2;
            v.a("MicroMsg.AvatarStorage", e, "Failed to save avatar: %s", str);
            if (outputStream != null) {
                outputStream.close();
            }
            return false;
        } catch (Throwable th3) {
            e = th3;
            outputStream = outputStream2;
            if (outputStream != null) {
                outputStream.close();
            }
            throw e;
        }
    }

    public static Bitmap gJ(String str) {
        v.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s", str);
        if (be.kS(str)) {
            return null;
        }
        return com.tencent.mm.sdk.platformtools.d.a(s(str, true), 480, 480, null, 0, 0, 1);
    }

    public static Bitmap gK(String str) {
        Bitmap decodeResource;
        int i = 0;
        if (cyd.containsKey(str)) {
            i = ((Integer) cyd.get(str)).intValue();
        }
        if (i != 0) {
            n.Bn();
            decodeResource = com.tencent.mm.compatible.f.a.decodeResource(n.getContext().getResources(), i);
        } else {
            decodeResource = null;
        }
        return com.tencent.mm.sdk.platformtools.d.a(decodeResource, true, 1.0f, true);
    }

    private static boolean i(Bitmap bitmap) {
        return (bitmap == null || bitmap.isRecycled()) ? false : true;
    }

    public static Bitmap gL(String str) {
        Bitmap a = FileOp.aR(str) ? com.tencent.mm.sdk.platformtools.d.a(str, null, 0, 0, 1) : null;
        if (a == null) {
            a = b.gO(str);
        }
        if (i(a)) {
            int width = a.getWidth();
            int height = a.getHeight();
            if (width != height) {
                if (width > height) {
                    a = Bitmap.createBitmap(a, (width - height) / 2, 0, height, height);
                } else {
                    a = Bitmap.createBitmap(a, 0, (height - width) / 2, width, width);
                }
            }
        }
        return i(a) ? a : null;
    }
}
