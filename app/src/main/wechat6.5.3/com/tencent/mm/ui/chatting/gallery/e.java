package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.widget.ImageView;
import com.tencent.mm.a.f;
import com.tencent.mm.a.f.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

final class e implements android.support.v4.view.ViewPager.e {
    private static int mScreenHeight = 0;
    private static int mScreenWidth = 0;
    private static long oBn = 0;
    private ap cDc = new ap(1, "chatting-image-gallery-lazy-loader");
    private ac cnC = new ac();
    private int dWm = -1;
    SparseArray<WeakReference<ImageView>> ggn = new SparseArray();
    HashMap<String, Integer> ggo = new HashMap();
    SparseArray<String> ggp = new SparseArray();
    SparseArray<Bitmap> ggq = new SparseArray();
    protected f<String, Bitmap> ggr = new f(5, new b<String, Bitmap>(this) {
        final /* synthetic */ e oBp;

        {
            this.oBp = r1;
        }

        public final /* synthetic */ void l(Object obj, Object obj2) {
            Bitmap bitmap = (Bitmap) obj2;
            v.i("MicroMsg.ImageGalleryLazyLoader", "preRemoveCallback %s", (String) obj);
            if (bitmap != null && !bitmap.isRecycled() && this.oBp.ggs.indexOfKey(bitmap.hashCode()) < 0) {
                if (this.oBp.oBo.contains(Integer.valueOf(bitmap.hashCode()))) {
                    this.oBp.oBo.remove(Integer.valueOf(bitmap.hashCode()));
                    return;
                }
                v.i("MicroMsg.ImageGalleryLazyLoader", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
            }
        }
    });
    protected SparseIntArray ggs = new SparseIntArray();
    private boolean ggu = false;
    a oBl;
    protected f<Integer, Bitmap> oBm = new f(40, new b<Integer, Bitmap>(this) {
        final /* synthetic */ e oBp;

        {
            this.oBp = r1;
        }

        public final /* synthetic */ void l(Object obj, Object obj2) {
            Bitmap bitmap = (Bitmap) obj2;
            if (bitmap != null && !bitmap.isRecycled()) {
                v.i("MicroMsg.ImageGalleryLazyLoader", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
            }
        }
    });
    private LinkedList<Integer> oBo = new LinkedList();
    private LinkedList<String> sR = new LinkedList();
    private int xe = 0;

    public interface a {
        Bitmap Pb(String str);

        void c(ImageView imageView, Bitmap bitmap);

        Bitmap xH(int i);
    }

    protected final void s(String str, Bitmap bitmap) {
        int i;
        if (bitmap != null) {
            long width = (long) (bitmap.getWidth() * bitmap.getHeight());
            if (mScreenHeight == 0 || mScreenWidth == 0) {
                mScreenWidth = aa.getContext().getResources().getDisplayMetrics().widthPixels;
                mScreenHeight = aa.getContext().getResources().getDisplayMetrics().heightPixels;
                oBn = ((long) mScreenWidth) * oBn;
            }
            if (width > oBn * 2) {
                i = 1;
                if (i == 0) {
                    v.i("MicroMsg.ImageGalleryLazyLoader", "file %s too big to cache");
                }
                this.ggr.k(str, bitmap);
                if (a.oBu.ggr.aI(str)) {
                    v.i("MicroMsg.ImageGalleryLazyLoader", "update origCache and preload cache");
                    try {
                        a.oBu.ggr.k(str, bitmap);
                        return;
                    } catch (Throwable e) {
                        v.a("MicroMsg.ImageGalleryLazyLoader", e, "update preload cache failed", new Object[0]);
                        return;
                    }
                }
                return;
            }
        }
        i = 0;
        if (i == 0) {
            this.ggr.k(str, bitmap);
            if (a.oBu.ggr.aI(str)) {
                v.i("MicroMsg.ImageGalleryLazyLoader", "update origCache and preload cache");
                a.oBu.ggr.k(str, bitmap);
                return;
            }
            return;
        }
        v.i("MicroMsg.ImageGalleryLazyLoader", "file %s too big to cache");
    }

    public final void Y(Map<String, Bitmap> map) {
        for (String str : map.keySet()) {
            Bitmap bitmap = (Bitmap) map.get(str);
            if (bitmap != null) {
                this.ggr.put(str, bitmap);
                this.oBo.push(Integer.valueOf(bitmap.hashCode()));
                v.i("MicroMsg.ImageGalleryLazyLoader", "we got one cache from preload : %s %s", str, Integer.valueOf(bitmap.hashCode()));
            } else {
                v.e("MicroMsg.ImageGalleryLazyLoader", "we got one null cache from preload");
            }
        }
    }

    public e(a aVar) {
        this.oBl = aVar;
    }

    final void aqU() {
        this.oBm.a(new com.tencent.mm.a.f.a<Integer, Bitmap>(this) {
            final /* synthetic */ e oBp;

            {
                this.oBp = r1;
            }
        });
        this.ggr.a(new com.tencent.mm.a.f.a<String, Bitmap>(this) {
            final /* synthetic */ e oBp;

            {
                this.oBp = r1;
            }
        });
    }

    public final void X(int i) {
        int i2 = 0;
        this.xe = i;
        if (aqV()) {
            int[] iArr = new int[this.ggq.size()];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr[i3] = this.ggq.keyAt(i3);
            }
            while (i2 < iArr.length) {
                int i4 = iArr[i2];
                a(i4, (Bitmap) this.ggq.get(i4));
                i2++;
            }
        }
    }

    public final void W(int i) {
        if (((d) this.oBl).ozG.ozI.ozW) {
            if (this.dWm == -1) {
                int i2 = 0;
                while (true) {
                    if (i2 != 0) {
                        if (i + i2 > i + 3 && i - i2 < Math.max(i - 3, 0)) {
                            break;
                        }
                        if (i + i2 <= i + 3) {
                            lr(i + i2);
                        }
                        if (i - i2 >= Math.max(i - 3, 0)) {
                            lr(i - i2);
                        }
                    } else {
                        lr(i);
                    }
                    i2++;
                }
            } else if (this.dWm > i) {
                lr(Math.max(i - 3, 0));
            } else if (this.dWm < i) {
                lr(i + 3);
            }
            this.dWm = i;
        }
    }

    private void lr(final int i) {
        if (!this.oBm.aI(Integer.valueOf(i))) {
            ak.vA().f(new Runnable(this) {
                final /* synthetic */ e oBp;

                public final void run() {
                    if (this.oBp.oBl == null) {
                        v.e("MicroMsg.ImageGalleryLazyLoader", "loader is null!");
                        return;
                    }
                    final Bitmap xH = this.oBp.oBl.xH(i);
                    if (xH != null) {
                        this.oBp.cnC.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass5 oBr;

                            public final void run() {
                                this.oBr.oBp.oBm.put(Integer.valueOf(i), xH);
                            }
                        });
                    }
                }
            }, 300);
        }
    }

    private boolean aqV() {
        return this.xe == 0;
    }

    private void lq(int i) {
        if (this.ggp.get(i) != null) {
            String str = (String) this.ggp.get(i);
            this.ggn.remove(i);
            this.ggp.remove(i);
            this.ggo.remove(str);
            this.ggq.remove(i);
        }
    }

    private void a(int i, Bitmap bitmap) {
        if (this.ggn.get(i) != null) {
            ImageView imageView = (ImageView) ((WeakReference) this.ggn.get(i)).get();
            this.ggp.get(i);
            this.oBl.c(imageView, bitmap);
            lq(i);
        }
    }

    public final boolean b(ImageView imageView, int i) {
        v.i("MicroMsg.ImageGalleryLazyLoader", "loadThumb position %s", Integer.valueOf(i));
        Bitmap bitmap = (Bitmap) this.oBm.get(Integer.valueOf(i));
        if (bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        this.oBl.c(imageView, bitmap);
        return true;
    }

    public final void s(ImageView imageView, String str) {
        if (!this.sR.contains(str)) {
            int hashCode = imageView.hashCode();
            lq(hashCode);
            this.ggo.put(str, Integer.valueOf(hashCode));
            this.ggp.put(hashCode, str);
            this.ggn.put(hashCode, new WeakReference(imageView));
            this.sR.add(str);
            aqW();
        }
    }

    private void aqW() {
        if (!this.ggu && this.sR.size() != 0) {
            final String str = (String) this.sR.removeLast();
            if (this.ggo.containsKey(str)) {
                this.ggu = true;
                this.cDc.c(new com.tencent.mm.sdk.platformtools.ap.a(this) {
                    private Bitmap ggw = null;
                    final /* synthetic */ e oBp;

                    public final boolean Ba() {
                        int intValue;
                        this.oBp.ggu = false;
                        if (this.oBp.ggo.containsKey(str)) {
                            intValue = ((Integer) this.oBp.ggo.get(str)).intValue();
                            if (this.oBp.aqV()) {
                                this.oBp.a(intValue, this.ggw);
                            } else {
                                this.oBp.ggq.put(intValue, this.ggw);
                            }
                        }
                        this.oBp.s(str, this.ggw);
                        String str = "MicroMsg.ImageGalleryLazyLoader";
                        String str2 = "bmp size : %s";
                        Object[] objArr = new Object[1];
                        Bitmap bitmap = this.ggw;
                        if (bitmap == null || bitmap.isRecycled()) {
                            intValue = 0;
                        } else {
                            intValue = VERSION.SDK_INT >= 12 ? bitmap.getByteCount() : bitmap.getRowBytes() * bitmap.getHeight();
                            if (intValue < 0) {
                                throw new IllegalStateException("Negative size: " + bitmap);
                            }
                        }
                        objArr[0] = Integer.valueOf(intValue);
                        v.i(str, str2, objArr);
                        this.ggw = null;
                        this.oBp.aqW();
                        return false;
                    }

                    public final boolean AZ() {
                        if (this.oBp.oBl == null || TextUtils.isEmpty(str)) {
                            return false;
                        }
                        try {
                            this.ggw = this.oBp.oBl.Pb(str);
                            return true;
                        } catch (Exception e) {
                            v.w("MicroMsg.ImageGalleryLazyLoader", "try to load Bmp fail: %s", e.getMessage());
                            this.ggw = null;
                            return false;
                        }
                    }
                });
            }
        }
    }

    public final void a(int i, float f, int i2) {
    }
}
