package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

public class h {
    public byte[] cGJ = new byte[0];
    ac cnC;
    volatile boolean lTk = false;
    private HandlerThread lTl = com.tencent.mm.sdk.i.e.Lg("ImageEngine_handlerThread" + System.currentTimeMillis());
    private ac lTm;
    public HashMap<String, ImageView> lTn = new HashMap();
    public HashMap<ImageView, String> lTo = new HashMap();
    c<String, Bitmap> lTp;
    private SparseArray<Bitmap> lTq;
    a<e> lTr;
    a<b> lTs;
    private boolean lTt = true;
    private com.tencent.mm.platformtools.j.a lTu = new com.tencent.mm.platformtools.j.a(this) {
        final /* synthetic */ h lTv;

        {
            this.lTv = r1;
        }

        public final void k(String str, final Bitmap bitmap) {
            boolean z = false;
            String str2 = "MicroMsg.ImageEngine";
            String str3 = "on get picture finish, notifyKey[%s], bitmap is null[%B]";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (bitmap == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            v.v(str2, str3, objArr);
            if (bitmap != null) {
                this.lTv.lTp.put(str, bitmap);
                final ImageView imageView = (ImageView) this.lTv.lTn.get(str);
                if (imageView != null) {
                    this.lTv.lTo.remove(imageView);
                    this.lTv.cnC.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass6 lTz;

                        public final void run() {
                            d.b(imageView, bitmap);
                        }
                    });
                }
                this.lTv.lTn.remove(str);
            }
        }
    };

    private abstract class a<T> {
        private ac handler;
        final int lTA = Math.max(1, 16);
        LinkedList<T> lTB = new LinkedList();
        final /* synthetic */ h lTv;

        protected abstract T bqR();

        public a(final h hVar, int i, Looper looper) {
            this.lTv = hVar;
            this.handler = new ac(this, looper) {
                final /* synthetic */ a lTD;

                public final void handleMessage(Message message) {
                    a aVar = this.lTD;
                    Object obj = message.obj;
                    if (obj != null && aVar.lTB.size() < aVar.lTA) {
                        aVar.lTB.add(obj);
                    }
                }
            };
        }

        public final T bqS() {
            if (this.lTB.isEmpty()) {
                return bqR();
            }
            return this.lTB.removeFirst();
        }

        public final void B(T t) {
            this.handler.sendMessage(this.handler.obtainMessage(1, t));
        }
    }

    private class b implements Runnable {
        private int fQm;
        private int gVE;
        private String[] lTE;
        private String lTF;
        final /* synthetic */ h lTv;
        private String url;

        private b(h hVar) {
            this.lTv = hVar;
        }

        private Bitmap HX(String str) {
            if (str == null) {
                return null;
            }
            if (this.fQm <= 0 || this.gVE <= 0) {
                return j.lW(str);
            }
            String str2 = str + "_" + this.gVE + "_" + this.fQm;
            Bitmap i = j.i(str2, this.gVE, this.fQm);
            if (i != null) {
                return i;
            }
            int JQ = ExifHelper.JQ(str);
            if (90 == JQ || 270 == JQ) {
                i = com.tencent.mm.sdk.platformtools.d.b(str, this.gVE, this.fQm, true);
            } else {
                i = com.tencent.mm.sdk.platformtools.d.b(str, this.fQm, this.gVE, true);
            }
            if (i == null) {
                return i;
            }
            i = com.tencent.mm.sdk.platformtools.d.b(i, (float) JQ);
            try {
                com.tencent.mm.sdk.platformtools.d.a(i, 100, CompressFormat.PNG, str2, false);
                return i;
            } catch (Throwable e) {
                v.a("MicroMsg.ImageEngine", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                return i;
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r6 = this;
            r2 = 0;
            r0 = r6.lTv;
            r0 = r0.lTk;
            if (r0 == 0) goto L_0x0011;
        L_0x0007:
            r0 = "MicroMsg.ImageEngine";
            r1 = "on load image jog, isQuit, return";
            com.tencent.mm.sdk.platformtools.v.w(r0, r1);
        L_0x0010:
            return;
        L_0x0011:
            r0 = r6.lTv;
            r1 = r0.cGJ;
            monitor-enter(r1);
            r0 = r6.lTv;	 Catch:{ all -> 0x0035 }
            r0 = r0.lTn;	 Catch:{ all -> 0x0035 }
            r3 = r6.lTF;	 Catch:{ all -> 0x0035 }
            r0 = r0.get(r3);	 Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x0038;
        L_0x0022:
            r0 = "MicroMsg.ImageEngine";
            r2 = "check before decode, no match wait to render view, renderKey is %s, return";
            r3 = 1;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0035 }
            r4 = 0;
            r5 = r6.lTF;	 Catch:{ all -> 0x0035 }
            r3[r4] = r5;	 Catch:{ all -> 0x0035 }
            com.tencent.mm.sdk.platformtools.v.w(r0, r2, r3);	 Catch:{ all -> 0x0035 }
            monitor-exit(r1);	 Catch:{ all -> 0x0035 }
            goto L_0x0010;
        L_0x0035:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0035 }
            throw r0;
        L_0x0038:
            monitor-exit(r1);	 Catch:{ all -> 0x0035 }
            r0 = 0;
            r1 = r6.lTE;
            if (r1 == 0) goto L_0x0059;
        L_0x003e:
            r1 = r2;
        L_0x003f:
            r3 = r6.lTE;
            r3 = r3.length;
            if (r1 >= r3) goto L_0x0059;
        L_0x0044:
            if (r1 != 0) goto L_0x00c5;
        L_0x0046:
            r0 = r6.lTE;
            r0 = r0[r2];
            r0 = r6.HX(r0);
            if (r0 == 0) goto L_0x00f2;
        L_0x0050:
            r1 = r6.lTv;
            r1 = r1.lTp;
            r2 = r6.lTF;
            r1.put(r2, r0);
        L_0x0059:
            if (r0 != 0) goto L_0x0080;
        L_0x005b:
            r1 = r6.url;
            r1 = com.tencent.mm.sdk.platformtools.be.kS(r1);
            if (r1 != 0) goto L_0x0080;
        L_0x0063:
            r0 = r6.lTv;
            r1 = r6.lTF;
            r2 = r6.url;
            r3 = r6.gVE;
            r4 = r6.fQm;
            r0 = r0.d(r1, r2, r3, r4);
            r0 = com.tencent.mm.platformtools.j.a(r0);
            if (r0 == 0) goto L_0x0080;
        L_0x0077:
            r1 = r6.lTv;
            r1 = r1.lTp;
            r2 = r6.lTF;
            r1.put(r2, r0);
        L_0x0080:
            r2 = r0;
            if (r2 == 0) goto L_0x00bc;
        L_0x0083:
            r0 = r6.lTv;
            r3 = r0.cGJ;
            monitor-enter(r3);
            r0 = r6.lTv;	 Catch:{ all -> 0x00f6 }
            r0 = r0.lTn;	 Catch:{ all -> 0x00f6 }
            r1 = r6.lTF;	 Catch:{ all -> 0x00f6 }
            r0 = r0.get(r1);	 Catch:{ all -> 0x00f6 }
            r0 = (android.widget.ImageView) r0;	 Catch:{ all -> 0x00f6 }
            if (r0 == 0) goto L_0x00b2;
        L_0x0096:
            r1 = r6.lTv;	 Catch:{ all -> 0x00f6 }
            r1 = r1.lTo;	 Catch:{ all -> 0x00f6 }
            r1.remove(r0);	 Catch:{ all -> 0x00f6 }
            r1 = r6.lTv;	 Catch:{ all -> 0x00f6 }
            r1 = r1.lTr;	 Catch:{ all -> 0x00f6 }
            r1 = r1.bqS();	 Catch:{ all -> 0x00f6 }
            r1 = (com.tencent.mm.pluginsdk.ui.tools.h.e) r1;	 Catch:{ all -> 0x00f6 }
            r1.bdF = r0;	 Catch:{ all -> 0x00f6 }
            r1.ggw = r2;	 Catch:{ all -> 0x00f6 }
            r0 = r6.lTv;	 Catch:{ all -> 0x00f6 }
            r0 = r0.cnC;	 Catch:{ all -> 0x00f6 }
            r0.post(r1);	 Catch:{ all -> 0x00f6 }
        L_0x00b2:
            r0 = r6.lTv;	 Catch:{ all -> 0x00f6 }
            r0 = r0.lTn;	 Catch:{ all -> 0x00f6 }
            r1 = r6.lTF;	 Catch:{ all -> 0x00f6 }
            r0.remove(r1);	 Catch:{ all -> 0x00f6 }
            monitor-exit(r3);	 Catch:{ all -> 0x00f6 }
        L_0x00bc:
            r0 = r6.lTv;
            r0 = r0.lTs;
            r0.B(r6);
            goto L_0x0010;
        L_0x00c5:
            r0 = r6.lTE;
            r0 = r0[r1];
            r3 = r6.url;
            r4 = r6.gVE;
            r5 = r6.fQm;
            r3 = com.tencent.mm.pluginsdk.ui.tools.h.l(r0, r3, r4, r5);
            r0 = r6.lTv;
            r0 = r0.lTp;
            r0 = r0.get(r3);
            r0 = (android.graphics.Bitmap) r0;
            if (r0 != 0) goto L_0x00e7;
        L_0x00df:
            r0 = r6.lTE;
            r0 = r0[r1];
            r0 = r6.HX(r0);
        L_0x00e7:
            if (r0 == 0) goto L_0x00f2;
        L_0x00e9:
            r1 = r6.lTv;
            r1 = r1.lTp;
            r1.put(r3, r0);
            goto L_0x0059;
        L_0x00f2:
            r1 = r1 + 1;
            goto L_0x003f;
        L_0x00f6:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x00f6 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.tools.h.b.run():void");
        }
    }

    private abstract class c<K, V> {
        private HashMap<K, a> iMC = new HashMap();
        private final int lTA;
        private a lTG = new a(this);
        private a lTH = new a(this);
        private int lTI = 0;
        final /* synthetic */ h lTv;

        private class a {
            public V dTk;
            public a lTJ = this.lTG;
            public a lTK = this.lTH;
            public K lTL;
            final /* synthetic */ c lTM;

            public a(c cVar) {
                this(cVar, null, null, (byte) 0);
            }

            public a(c cVar, K k, V v) {
                this(cVar, k, v, (byte) 0);
            }

            private a(c cVar, a aVar, V v, byte b) {
                this.lTM = cVar;
                this.lTJ = null;
                this.lTK = null;
                this.lTL = aVar;
                this.dTk = v;
            }
        }

        protected abstract void bb(V v);

        public c(h hVar, int i) {
            this.lTv = hVar;
            this.lTA = Math.max(1, i);
        }

        private void a(a aVar) {
            aVar.lTK = this.lTG.lTK;
            aVar.lTK.lTJ = aVar;
            this.lTG.lTK = aVar;
            aVar.lTJ = this.lTG;
        }

        private static void b(a aVar) {
            aVar.lTJ.lTK = aVar.lTK;
            aVar.lTK.lTJ = aVar.lTJ;
            aVar.lTK = null;
            aVar.lTJ = null;
        }

        public final void clear() {
            while (this.lTI > 0) {
                a aVar = this.lTH.lTJ;
                b(aVar);
                this.iMC.remove(aVar.lTL);
                bb(aVar.dTk);
                this.lTI--;
            }
        }

        public final V put(K k, V v) {
            synchronized (this) {
                a aVar = (a) this.iMC.get(k);
                if (aVar != null) {
                    b(aVar);
                    V v2 = aVar.dTk;
                    aVar.dTk = v;
                    a(aVar);
                    return v2;
                }
                aVar = new a(this, k, v);
                a(aVar);
                this.iMC.put(k, aVar);
                this.lTI++;
                while (this.lTA < this.lTI) {
                    aVar = this.lTH.lTJ;
                    b(aVar);
                    this.iMC.remove(aVar.lTL);
                    bb(aVar.dTk);
                    this.lTI--;
                }
                return null;
            }
        }

        public final V get(K k) {
            V v;
            synchronized (this) {
                a aVar = (a) this.iMC.get(k);
                if (aVar != null) {
                    b(aVar);
                    a(aVar);
                    v = aVar.dTk;
                } else {
                    v = null;
                }
            }
            return v;
        }

        public String toString() {
            String stringBuilder;
            synchronized (this) {
                StringBuilder stringBuilder2 = new StringBuilder();
                for (a aVar = this.lTG.lTK; aVar != this.lTH; aVar = aVar.lTK) {
                    stringBuilder2.append("[key:").append(aVar.lTL).append(", value:").append(aVar.dTk).append("]");
                }
                stringBuilder = stringBuilder2.toString();
            }
            return stringBuilder;
        }
    }

    public static class d extends Drawable {
        static final Paint lTN = new Paint(6);
        WeakReference<Bitmap> lTO = new WeakReference(null);
        private boolean lTP = false;
        private boolean lTQ = false;
        final Rect tG = new Rect();

        public static void b(ImageView imageView, Bitmap bitmap) {
            boolean z;
            boolean z2 = true;
            Drawable dVar = imageView.getDrawable() instanceof d ? (d) imageView.getDrawable() : new d();
            dVar.lTO = new WeakReference(bitmap);
            if (imageView.getScaleType() == ScaleType.FIT_XY) {
                z = true;
            } else {
                z = false;
            }
            dVar.lTP = z;
            if (imageView.getScaleType() != ScaleType.CENTER_CROP) {
                z2 = false;
            }
            dVar.lTQ = z2;
            imageView.setImageDrawable(dVar);
            imageView.postInvalidate();
        }

        public static void c(ImageView imageView) {
            b(imageView, null);
        }

        public final void draw(Canvas canvas) {
            Object obj;
            Bitmap bitmap = (Bitmap) this.lTO.get();
            if (bitmap == null || bitmap.isRecycled()) {
                obj = null;
            } else {
                copyBounds(this.tG);
                canvas.drawBitmap(bitmap, null, this.tG, lTN);
                obj = 1;
            }
            if (obj == null) {
            }
        }

        public final void setAlpha(int i) {
        }

        public final void setColorFilter(ColorFilter colorFilter) {
        }

        public final int getOpacity() {
            return 0;
        }
    }

    private class e implements Runnable {
        ImageView bdF;
        Bitmap ggw;
        final /* synthetic */ h lTv;

        private e(h hVar) {
            this.lTv = hVar;
        }

        public final void run() {
            if (this.bdF != null) {
                if (this.ggw == null || !this.ggw.isRecycled()) {
                    d.b(this.bdF, this.ggw);
                } else {
                    d.c(this.bdF);
                }
            }
            this.bdF = null;
            this.ggw = null;
            this.lTv.lTr.B(this);
        }
    }

    public h(int i) {
        this.lTl.start();
        this.lTm = new ac(this.lTl.getLooper());
        this.cnC = new ac(Looper.getMainLooper());
        this.lTr = new a<e>(this, this.lTl.getLooper()) {
            final /* synthetic */ h lTv;

            protected final /* synthetic */ Object bqR() {
                return new e();
            }
        };
        this.lTs = new a<b>(this, Looper.getMainLooper()) {
            final /* synthetic */ h lTv;

            protected final /* synthetic */ Object bqR() {
                return new b();
            }
        };
        this.lTq = new SparseArray();
        this.lTp = new c<String, Bitmap>(this, i) {
            final /* synthetic */ h lTv;

            protected final /* synthetic */ void bb(Object obj) {
                Bitmap bitmap = (Bitmap) obj;
                if (bitmap != null) {
                    v.i("MicroMsg.ImageEngine", "recycle bitmap:%s", bitmap.toString());
                    bitmap.recycle();
                }
            }
        };
        j.b(this.lTu);
    }

    public final void destory() {
        v.d("MicroMsg.ImageEngine", "do destory");
        this.lTk = true;
        this.lTl.quit();
        j.c(this.lTu);
        final SparseArray sparseArray = this.lTq;
        final c cVar = this.lTp;
        this.lTq = new SparseArray();
        this.lTp = new c<String, Bitmap>(this) {
            final /* synthetic */ h lTv;

            {
                this.lTv = r2;
            }

            protected final /* bridge */ /* synthetic */ void bb(Object obj) {
            }
        };
        com.tencent.mm.sdk.i.e.a(new Runnable(this) {
            final /* synthetic */ h lTv;

            public final void run() {
                v.i("MicroMsg.ImageEngine", "begin do recycled");
                for (int i = 0; i < sparseArray.size(); i++) {
                    Bitmap bitmap = (Bitmap) sparseArray.valueAt(i);
                    if (bitmap != null) {
                        v.d("MicroMsg.ImageEngine", "recycled def bmp %s", bitmap.toString());
                        bitmap.recycle();
                    }
                }
                sparseArray.clear();
                v.i("MicroMsg.ImageEngine", "clear drawable cache");
                cVar.clear();
                v.i("MicroMsg.ImageEngine", "end do recycled");
            }
        }, "ImageEngine_destroy_" + System.currentTimeMillis());
    }

    public i d(String str, String str2, int i, int i2) {
        return null;
    }

    private void a(ImageView imageView, int i) {
        if (i == 0) {
            d.c(imageView);
            return;
        }
        Bitmap bitmap = (Bitmap) this.lTq.get(i);
        if (bitmap == null) {
            bitmap = com.tencent.mm.compatible.f.a.decodeResource(imageView.getResources(), i);
            this.lTq.put(i, bitmap);
        }
        d.b(imageView, bitmap);
    }

    static String l(String str, String str2, int i, int i2) {
        return be.ah(str, "null") + "_" + be.ah(str2, "null") + "_" + i + "_" + i2;
    }

    public final void a(ImageView imageView, String[] strArr, String str, int i, int i2, int i3) {
        int i4 = 0;
        if (!this.lTt) {
            return;
        }
        if (this.lTk) {
            v.w("MicroMsg.ImageEngine", "on attach, isQuit, return");
        } else if (imageView == null) {
            v.w("MicroMsg.ImageEngine", "attach from file path fail, imageview is null");
        } else if ((strArr == null || strArr.length <= 0) && be.kS(str)) {
            v.w("MicroMsg.ImageEngine", "attach from file path fail, path and url are null or empty");
            a(imageView, i);
        } else {
            String str2 = (strArr == null || strArr.length <= 0) ? null : strArr[0];
            String l = l(str2, str, i2, i3);
            synchronized (this.cGJ) {
                str2 = (String) this.lTo.get(imageView);
                if (str2 != null) {
                    this.lTn.remove(str2);
                }
                this.lTo.put(imageView, l);
            }
            Bitmap bitmap = (Bitmap) this.lTp.get(l);
            if (bitmap == null || bitmap.isRecycled()) {
                v.v("MicroMsg.ImageEngine", "get first render bmp fail, key[%s]", l);
                if (strArr != null && strArr.length > 1) {
                    for (int i5 = 1; i5 < strArr.length; i5++) {
                        bitmap = (Bitmap) this.lTp.get(l(strArr[i5], str, i2, i3));
                        String str3 = "MicroMsg.ImageEngine";
                        String str4 = "get next render bmp, key[%s], result[%B]";
                        Object[] objArr = new Object[2];
                        objArr[0] = l;
                        objArr[1] = Boolean.valueOf(bitmap != null);
                        v.v(str3, str4, objArr);
                        if (bitmap != null) {
                            d.b(imageView, bitmap);
                            i4 = 1;
                            break;
                        }
                    }
                }
                if (i4 == 0) {
                    v.v("MicroMsg.ImageEngine", "use default res to render");
                    a(imageView, i);
                }
                synchronized (this.cGJ) {
                    this.lTn.put(l, imageView);
                }
                b bVar = (b) this.lTs.bqS();
                bVar.lTE = strArr;
                bVar.url = str;
                bVar.lTF = l;
                bVar.gVE = i2;
                bVar.fQm = i3;
                this.lTm.postAtFrontOfQueueV2(bVar);
                return;
            }
            d.b(imageView, bitmap);
        }
    }
}
