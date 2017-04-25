package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mm.a.f;
import com.tencent.mm.a.f.a;
import com.tencent.mm.a.f.b;
import com.tencent.mm.plugin.gallery.model.j;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

final class d {
    private ap cDc = new ap(1, "album-image-gallery-lazy-loader");
    SparseArray<WeakReference<MultiTouchImageView>> ggn = new SparseArray();
    HashMap<String, Integer> ggo = new HashMap();
    SparseArray<String> ggp = new SparseArray();
    SparseArray<Bitmap> ggq = new SparseArray();
    protected f<String, Bitmap> ggr = new f(5, new b<String, Bitmap>(this) {
        final /* synthetic */ d ggv;

        {
            this.ggv = r1;
        }

        public final /* synthetic */ void l(Object obj, Object obj2) {
            Bitmap bitmap = (Bitmap) obj2;
            if (bitmap != null && !bitmap.isRecycled() && this.ggv.ggs.indexOfKey(bitmap.hashCode()) < 0) {
                bitmap.recycle();
            }
        }
    });
    protected SparseIntArray ggs = new SparseIntArray();
    c ggt;
    boolean ggu = false;
    LinkedList<String> sR = new LinkedList();
    private int xe = 0;

    public d(c cVar) {
        this.ggt = cVar;
    }

    final void aqU() {
        this.ggr.a(new a<String, Bitmap>(this) {
            final /* synthetic */ d ggv;

            {
                this.ggv = r1;
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

    final boolean aqV() {
        return this.xe == 0;
    }

    final void lq(int i) {
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
            MultiTouchImageView multiTouchImageView = (MultiTouchImageView) ((WeakReference) this.ggn.get(i)).get();
            String str = (String) this.ggp.get(i);
            if (!(bitmap == null || multiTouchImageView == null)) {
                int hashCode = bitmap.hashCode();
                int indexOfValue = this.ggs.indexOfValue(i);
                if (indexOfValue >= 0) {
                    this.ggs.removeAt(indexOfValue);
                }
                this.ggs.put(hashCode, i);
            }
            this.ggt.gfZ.remove(str);
            if (!(bitmap == null || multiTouchImageView == null)) {
                c.a(multiTouchImageView, bitmap);
            }
            lq(i);
        }
    }

    final void aqW() {
        if (!this.ggu && this.sR.size() != 0) {
            final String str = (String) this.sR.removeLast();
            if (this.ggo.containsKey(str)) {
                this.ggu = true;
                this.cDc.c(new ap.a(this) {
                    final /* synthetic */ d ggv;
                    private Bitmap ggw = null;

                    public final boolean Ba() {
                        this.ggv.ggu = false;
                        if (this.ggv.ggo.containsKey(str)) {
                            int intValue = ((Integer) this.ggv.ggo.get(str)).intValue();
                            if (this.ggv.aqV()) {
                                this.ggv.a(intValue, this.ggw);
                            } else {
                                this.ggv.ggq.put(intValue, this.ggw);
                            }
                        }
                        this.ggv.ggr.k(str, this.ggw);
                        this.ggw = null;
                        this.ggv.aqW();
                        return false;
                    }

                    public final boolean AZ() {
                        if (this.ggv.ggt == null || TextUtils.isEmpty(str)) {
                            return false;
                        }
                        String str = str;
                        long Nj = be.Nj();
                        Bitmap tY = j.tY(str);
                        v.v("MicroMsg.ImageAdapter", "test decode: %d", new Object[]{Long.valueOf(be.az(Nj))});
                        this.ggw = tY;
                        return true;
                    }
                });
            }
        }
    }
}
