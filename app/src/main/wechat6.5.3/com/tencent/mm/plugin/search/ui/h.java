package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.a.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public final class h implements com.tencent.mm.ui.f.d {
    private static int iIq = 32;
    private ac cnC = new ac(Looper.getMainLooper());
    private ConcurrentHashMap<String, a> iIr;
    private Vector<String> iIs;
    private boolean iIt = true;
    private int iIu = 0;
    private ac[] iIv = new ac[2];
    private ConcurrentHashMap<Long, ByteArrayOutputStream> iIw = null;
    private ConcurrentHashMap<Long, byte[]> iIx = null;
    private ac iIy = null;
    private Set<String> iIz;

    class a {
        Bitmap bitmap;
        String bjG;
        final /* synthetic */ h iIA;

        a(h hVar) {
            this.iIA = hVar;
        }
    }

    class b implements Runnable {
        private String bjG;
        private int height;
        final /* synthetic */ h iIA;
        private boolean iID;
        private c iIE;
        private String iIF;
        private String url;
        private int width;

        public b(h hVar, String str, String str2, String str3, boolean z, int i, int i2, c cVar) {
            this.iIA = hVar;
            this.iIF = str;
            this.url = str2;
            this.bjG = str3;
            this.iIE = cVar;
            this.iID = z;
            this.width = i;
            this.height = i2;
        }

        public final void run() {
            v.d("MicroMsg.FTS.SearchImageLoader", "Start to run load bitmap job %s", new Object[]{this.iIF});
            if (be.kS(this.bjG)) {
                this.bjG = ak.yW();
            }
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap E = h.E(this.bjG, this.width, this.height);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (E != null) {
                v.d("MicroMsg.FTS.SearchImageLoader", "Found image in local %s | localPath %s | use time %d", new Object[]{this.url, this.bjG, Long.valueOf(currentTimeMillis2 - currentTimeMillis)});
                h.a(this.iIA, this.iIF, this.bjG, E);
                this.iIE.ae(this.iIF, true);
                return;
            }
            Bitmap a = this.iIA.b(this.url, this.iID, this.width, this.height);
            long currentTimeMillis3 = System.currentTimeMillis();
            v.d("MicroMsg.FTS.SearchImageLoader", "Get image from net %s | localPath %s | use time %d", new Object[]{this.url, this.bjG, Long.valueOf(currentTimeMillis3 - currentTimeMillis2)});
            if (a != null) {
                h.a(this.iIA, this.iIF, this.bjG, a);
                this.iIE.ae(this.iIF, true);
                return;
            }
            this.iIE.ae(this.iIF, false);
        }
    }

    interface c {
        void ae(String str, boolean z);
    }

    class d implements Runnable {
        final /* synthetic */ h iIA;
        private a iIG;

        public d(h hVar, a aVar) {
            this.iIA = hVar;
            this.iIG = aVar;
        }

        public final void run() {
            v.d("MicroMsg.FTS.SearchImageLoader", "Start to run save bitmap job");
            try {
                if (!new File(this.iIG.bjG).exists()) {
                    if (this.iIG.bitmap == null || this.iIG.bitmap.isRecycled()) {
                        v.d("MicroMsg.FTS.SearchImageLoader", "Save Bitmap is Recycled");
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    com.tencent.mm.sdk.platformtools.d.a(this.iIG.bitmap, 100, CompressFormat.PNG, this.iIG.bjG, false);
                    v.d("MicroMsg.FTS.SearchImageLoader", "Save bitmap use time: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                }
            } catch (Throwable e) {
                v.a("MicroMsg.FTS.SearchImageLoader", e, "", new Object[0]);
            }
        }
    }

    static /* synthetic */ Bitmap E(String str, int i, int i2) {
        if (be.kS(str) || !new File(str).exists()) {
            return null;
        }
        return (i <= 0 || i2 <= 0) ? j.lW(str) : j.i(str, i, i2);
    }

    static /* synthetic */ void a(h hVar, String str, String str2, Bitmap bitmap) {
        if (hVar.iIr.size() > iIq) {
            hVar.zk((String) hVar.iIs.lastElement());
        }
        a aVar = new a(hVar);
        aVar.bjG = str2;
        aVar.bitmap = bitmap;
        hVar.iIr.put(str, aVar);
        if (!new File(aVar.bjG).exists()) {
            hVar.iIy.postDelayed(new d(hVar, aVar), 200);
        }
    }

    public h() {
        int i = 0;
        v.i("MicroMsg.FTS.SearchImageLoader", "create SearchImageLoader");
        if (com.tencent.mm.compatible.util.d.dW(19)) {
            iIq = 64;
        } else {
            iIq = 32;
        }
        this.iIr = new ConcurrentHashMap();
        this.iIs = new Vector();
        this.iIw = new ConcurrentHashMap();
        this.iIx = new ConcurrentHashMap();
        this.iIz = Collections.synchronizedSet(new HashSet());
        while (i < 2) {
            if (this.iIv[i] == null) {
                e.d(new Runnable(this) {
                    final /* synthetic */ h iIA;

                    public final void run() {
                        Looper.prepare();
                        this.iIA.iIv[i] = new ac();
                        Looper.loop();
                    }
                }, "SearchImageLoader_loadImage_handler", 1).start();
            }
            i++;
        }
        e.d(new Runnable(this) {
            final /* synthetic */ h iIA;

            {
                this.iIA = r1;
            }

            public final void run() {
                Looper.prepare();
                this.iIA.iIy = new ac();
                Looper.loop();
            }
        }, "SearchImageLoader_saveImage_handler", 1).start();
    }

    public final void a(final Context context, final ImageView imageView, String str, String str2, boolean z, int i, int i2) {
        String a = a(imageView, str, str2, z, i, i2);
        if (this.iIt) {
            Runnable bVar = new b(this, a, str, str2, z, i, i2, new c(this) {
                final /* synthetic */ h iIA;

                public final void ae(final String str, boolean z) {
                    v.v("MicroMsg.FTS.SearchImageLoader", "LoadBitmapJob finish: %s %b", new Object[]{str, Boolean.valueOf(z)});
                    this.iIA.iIz.remove(str);
                    if (z) {
                        final Bitmap a = this.iIA.jh(str);
                        if (str.equals(imageView.getTag())) {
                            this.iIA.cnC.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass3 iIC;

                                public final void run() {
                                    if (str.equals(imageView.getTag())) {
                                        com.tencent.mm.ui.f.d.a.a(context.getResources(), a, imageView);
                                    }
                                }
                            });
                        }
                    }
                }
            });
            if (this.iIz.add(a)) {
                this.iIu++;
                this.iIu %= 2;
                this.iIv[this.iIu].post(bVar);
                return;
            }
            v.v("MicroMsg.FTS.SearchImageLoader", "cacheKey: %s | runningJobTask: %s", new Object[]{a, this.iIz.toString()});
        }
    }

    public final String a(ImageView imageView, String str, String str2, boolean z, int i, int i2) {
        String b = b(str, str2, z, i, i2);
        imageView.setTag(b);
        v.d("MicroMsg.FTS.SearchImageLoader", "update image view cache key: hashcode=%d | cacheKey=%s", new Object[]{Integer.valueOf(imageView.hashCode()), b});
        return b;
    }

    public final void aMF() {
        v.d("MicroMsg.FTS.SearchImageLoader", "stopLoadImageTask");
        for (int i = 0; i < 2; i++) {
            if (this.iIv[i] != null) {
                this.iIv[i].removeCallbacksAndMessages(null);
            }
        }
    }

    public final void aMG() {
        v.d("MicroMsg.FTS.SearchImageLoader", "stopLoadImage");
        this.iIt = false;
        aMF();
    }

    public final boolean aMH() {
        return this.iIt;
    }

    public final void aMI() {
        v.d("MicroMsg.FTS.SearchImageLoader", "startLoadImage");
        this.iIt = true;
    }

    public final void aMJ() {
        v.d("MicroMsg.FTS.SearchImageLoader", "clearCacheAndTask %s", new Object[]{Integer.valueOf(this.iIr.size())});
        aMF();
        for (Entry key : this.iIr.entrySet()) {
            zk((String) key.getKey());
        }
        this.iIs.clear();
        this.iIz.clear();
    }

    public final void aMK() {
        aMJ();
        v.d("MicroMsg.FTS.SearchImageLoader", "destoryLoader");
        for (int i = 0; i < 2; i++) {
            if (this.iIv[i] != null) {
                this.iIv[i].getLooper().quit();
            }
        }
        for (ByteArrayOutputStream close : this.iIw.values()) {
            try {
                close.close();
            } catch (IOException e) {
            }
        }
        this.iIw.clear();
        this.iIx.clear();
        this.iIy.getLooper().quit();
    }

    public final Bitmap a(String str, String str2, boolean z, int i, int i2) {
        return jh(b(str, str2, z, i, i2));
    }

    private Bitmap jh(String str) {
        a aVar = (a) this.iIr.get(str);
        if (!(aVar == null || aVar.bitmap == null || aVar.bitmap.isRecycled())) {
            this.iIs.remove(str);
            this.iIs.add(0, str);
        }
        return aVar == null ? null : aVar.bitmap;
    }

    private synchronized byte[] getBuffer() {
        byte[] bArr;
        bArr = (byte[]) this.iIx.get(Long.valueOf(Thread.currentThread().getId()));
        if (bArr == null) {
            bArr = new byte[1024];
            this.iIx.put(Long.valueOf(Thread.currentThread().getId()), bArr);
        }
        return bArr;
    }

    private static String b(String str, String str2, boolean z, int i, int i2) {
        return "fts_search_" + g.m((be.ah(str, "null") + be.ah(str2, "null") + z + i + "_" + i2).getBytes());
    }

    private Bitmap b(String str, boolean z, int i, int i2) {
        Throwable e;
        if (be.kS(str)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) this.iIw.get(Long.valueOf(Thread.currentThread().getId()));
        if (byteArrayOutputStream == null) {
            byteArrayOutputStream = new ByteArrayOutputStream(32768);
            this.iIw.put(Long.valueOf(Thread.currentThread().getId()), byteArrayOutputStream);
        }
        byteArrayOutputStream.reset();
        byte[] buffer = getBuffer();
        InputStream h;
        try {
            h = com.tencent.mm.network.b.h(str, 10000, 20000);
            if (h == null) {
                v.w("MicroMsg.FTS.SearchImageLoader", "download %s error, can not open http stream", new Object[]{str});
                if (h != null) {
                    try {
                        h.close();
                    } catch (Throwable e2) {
                        v.a("MicroMsg.FTS.SearchImageLoader", e2, "", new Object[0]);
                    }
                }
                return null;
            }
            Bitmap bc;
            int i3 = 0;
            while (true) {
                try {
                    int read = h.read(buffer);
                    if (read == -1) {
                        break;
                    }
                    i3 += read;
                    byteArrayOutputStream.write(buffer, 0, read);
                } catch (Exception e3) {
                    e2 = e3;
                }
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            if (i <= 0 || i2 <= 0) {
                bc = com.tencent.mm.sdk.platformtools.d.bc(toByteArray);
            } else {
                bc = com.tencent.mm.sdk.platformtools.d.decodeByteArray(toByteArray, i, i2);
            }
            v.d("MicroMsg.FTS.SearchImageLoader", "get url[%s] ok, bufSize[%d], bitmap size %d * %d", new Object[]{str, Integer.valueOf(i3), Integer.valueOf(bc.getWidth()), Integer.valueOf(bc.getHeight())});
            if (z) {
                bc = com.tencent.mm.sdk.platformtools.d.a(bc, true, (float) bc.getWidth());
                if (h == null) {
                    return bc;
                }
                try {
                    h.close();
                    return bc;
                } catch (Throwable e4) {
                    v.a("MicroMsg.FTS.SearchImageLoader", e4, "", new Object[0]);
                    return bc;
                }
            } else if (h == null) {
                return bc;
            } else {
                try {
                    h.close();
                    return bc;
                } catch (Throwable e42) {
                    v.a("MicroMsg.FTS.SearchImageLoader", e42, "", new Object[0]);
                    return bc;
                }
            }
        } catch (Exception e5) {
            e2 = e5;
            h = null;
            try {
                v.a("MicroMsg.FTS.SearchImageLoader", e2, "", new Object[0]);
                v.w("MicroMsg.FTS.SearchImageLoader", "get url:%s failed.", new Object[]{str});
                if (h != null) {
                    try {
                        h.close();
                    } catch (Throwable e22) {
                        v.a("MicroMsg.FTS.SearchImageLoader", e22, "", new Object[0]);
                    }
                }
                return null;
            } catch (Throwable th) {
                e22 = th;
                if (h != null) {
                    try {
                        h.close();
                    } catch (Throwable e422) {
                        v.a("MicroMsg.FTS.SearchImageLoader", e422, "", new Object[0]);
                    }
                }
                throw e22;
            }
        } catch (Throwable th2) {
            e22 = th2;
            h = null;
            if (h != null) {
                h.close();
            }
            throw e22;
        }
    }

    private void zk(String str) {
        a aVar = (a) this.iIr.get(str);
        this.iIs.remove(str);
        this.iIr.remove(str);
        if (aVar != null && aVar.bitmap != null) {
            if (!aVar.bitmap.isRecycled()) {
                v.i("MicroMsg.FTS.SearchImageLoader", "bitmap recycle %s", new Object[]{aVar.bitmap});
                aVar.bitmap.recycle();
            }
            aVar.bitmap = null;
        }
    }
}
