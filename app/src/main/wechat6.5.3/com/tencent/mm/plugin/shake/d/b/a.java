package com.tencent.mm.plugin.shake.d.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.plugin.shake.e.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;

public final class a extends BitmapDrawable implements com.tencent.mm.platformtools.j.a {
    private static final Paint cnN;
    private static Bitmap iQC;
    private int gzU;
    private ImageView iQA;
    private i iQB;
    private String iQz;
    private int type;
    private String username;

    private static class a implements i {
        private String iQz;

        public a(String str) {
            this.iQz = str;
        }

        public final String MU() {
            return a.xK(this.iQz);
        }

        public final String MV() {
            return this.iQz;
        }

        public final String MW() {
            return this.iQz;
        }

        public final String MX() {
            return this.iQz;
        }

        public final boolean MY() {
            return true;
        }

        public final boolean MZ() {
            return false;
        }

        public final Bitmap Na() {
            return BitmapFactory.decodeResource(aa.getContext().getResources(), 2130838791);
        }

        public final Bitmap a(Bitmap bitmap, com.tencent.mm.platformtools.i.a aVar) {
            if (com.tencent.mm.platformtools.i.a.doT == aVar) {
                try {
                    d.a(bitmap, 100, CompressFormat.PNG, a.xK(this.iQz), false);
                } catch (Throwable e) {
                    v.a("MicroMsg.ShakeAvatarDrawable", e, "", new Object[0]);
                    v.w("MicroMsg.ShakeAvatarDrawable", "save bitmap fail");
                }
            }
            v.d("MicroMsg.ShakeAvatarDrawable", "get bitmap, from %s", new Object[]{aVar.toString()});
            return bitmap;
        }

        public final void Nb() {
        }

        public final void H(String str, boolean z) {
        }

        public final void a(com.tencent.mm.platformtools.i.a aVar, String str) {
        }
    }

    static {
        Paint paint = new Paint();
        cnN = paint;
        paint.setAntiAlias(true);
        cnN.setFilterBitmap(true);
    }

    public final void draw(Canvas canvas) {
        v.i("MicroMsg.ShakeAvatarDrawable", "album username[%s], url[%s], type[%d], attr[%s]", new Object[]{this.username, this.iQz, Integer.valueOf(this.type), toString()});
        if (4 == this.type || (k.pq(this.type) && 6 != this.type)) {
            Bitmap a;
            if (4 == this.type) {
                this.iQB = new a(this.iQz);
                a = j.a(this.iQB);
            } else if (!k.pq(this.type) || 6 == this.type) {
                a = null;
            } else {
                this.iQB = new b(this.iQz);
                a = j.a(this.iQB);
            }
            if (a == null || a.isRecycled()) {
                v.i("MicroMsg.ShakeAvatarDrawable", "bm is null or recycled, album url[%s]", new Object[]{this.iQz});
                a = y(this.iQA, this.gzU);
            }
            if (a != null) {
                canvas.drawBitmap(a, null, getBounds(), cnN);
            }
        }
    }

    private static Bitmap y(View view, int i) {
        if (view == null) {
            return iQC;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (iQC == null || iQC.getWidth() != measuredWidth) {
            if (i > 0) {
                try {
                    iQC = d.s(view.getResources().getDrawable(i));
                } catch (Throwable e) {
                    v.a("MicroMsg.ShakeAvatarDrawable", e, "", new Object[0]);
                }
            } else {
                iQC = BackwardSupportUtil.b.a(aa.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bd.a.getDensity(null), 0, 0);
            }
            if (iQC.getWidth() != measuredWidth && measuredWidth > 0 && measuredHeight > 0) {
                iQC = Bitmap.createScaledBitmap(iQC, measuredWidth, measuredHeight, true);
            }
        }
        return iQC;
    }

    public final void k(String str, final Bitmap bitmap) {
        v.i("MicroMsg.ShakeAvatarDrawable", "type[%d] notifyKey[%s] albumUrl[%s]", new Object[]{Integer.valueOf(this.type), str, this.iQz});
        if (this.iQB != null && str.equals(this.iQB.MW())) {
            if (4 == this.type || (k.pq(this.type) && 6 != this.type)) {
                this.iQA.post(new Runnable(this) {
                    final /* synthetic */ a iQD;

                    public final void run() {
                        this.iQD.iQA.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    public static String xK(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath: but url is null");
            return null;
        }
        if (be.kS(com.tencent.mm.plugin.shake.d.a.i.aOs())) {
            v.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath, but save dir is null");
            return null;
        }
        return String.format("%s/%s", new Object[]{com.tencent.mm.plugin.shake.d.a.i.aOs(), g.m(str.getBytes())});
    }
}
