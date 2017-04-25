package com.tencent.mm.pluginsdk.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelbiz.j;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.d;
import com.tencent.mm.u.e;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.s;

public final class f {
    private static final Drawable hhb = new ColorDrawable();
    private Activity aXH;
    public o hha;
    private GetHdHeadImageGalleryView hhc;
    private e iJU;
    private String lGA;
    private String lGB;
    private b lGC;
    private int lGD;
    private String username;

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] lGF = new int[a.boz().length];

        static {
            try {
                lGF[a.lGG - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                lGF[a.lGH - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                lGF[a.lGI - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public enum a {
        ;

        public static int[] boz() {
            return (int[]) lGJ.clone();
        }

        static {
            lGG = 1;
            lGH = 2;
            lGI = 3;
            lGJ = new int[]{lGG, lGH, lGI};
        }
    }

    public interface b {
    }

    public f(Activity activity, String str) {
        this(activity, str, null);
    }

    public f(Activity activity, String str, String str2) {
        this(activity, str, str2, a.lGG);
    }

    public f(Activity activity, String str, String str2, int i) {
        this(activity, str, str2, i, (byte) 0);
    }

    private f(Activity activity, String str, String str2, int i, byte b) {
        this.lGA = null;
        this.lGB = null;
        this.aXH = activity;
        this.username = str;
        this.lGB = str2;
        this.lGC = null;
        this.lGD = i;
    }

    public final void boy() {
        View inflate = LayoutInflater.from(this.aXH).inflate(2130903772, null);
        this.hha = new o(inflate, -1, -1);
        switch (AnonymousClass2.lGF[this.lGD - 1]) {
            case 1:
                this.hha.setAnimationStyle(2131558558);
                break;
            case 2:
                this.hha.setAnimationStyle(2131558559);
                break;
            case 3:
                this.hha.setAnimationStyle(2131558557);
                break;
        }
        this.hha.setFocusable(true);
        this.hha.setOutsideTouchable(true);
        this.hha.setBackgroundDrawable(hhb);
        this.hha.showAtLocation(this.aXH.getWindow().getDecorView(), 49, 0, 0);
        this.hhc = (GetHdHeadImageGalleryView) inflate.findViewById(2131755843);
        this.hhc.lGs = this.hha;
        this.hhc.username = this.username;
        ak.yW();
        if (c.isSDCardAvailable()) {
            Bitmap b = !be.kS(this.lGB) ? j.b(this.username, this.lGB, 2130838793) : com.tencent.mm.u.b.a(this.username, true, -1);
            if (b == null) {
                b = BitmapFactory.decodeResource(this.aXH.getResources(), 2130838080);
            }
            if (b == null || b.isRecycled()) {
                v.i("MicroMsg.GetHdHeadImg", "The avatar of %s is not in the cache, use default avatar", new Object[]{this.username});
            } else {
                v.i("MicroMsg.GetHdHeadImg", "The avatar of %s is in the cache", new Object[]{this.username});
                this.hhc.setThumbImage(b);
            }
            if (!be.kS(this.lGA)) {
                this.username = this.lGA;
            }
            n.AX();
            Bitmap gJ = d.gJ(this.username);
            if (gJ == null || gJ.isRecycled()) {
                this.iJU = new e();
                this.iJU.a(this.username, new com.tencent.mm.u.e.b(this) {
                    final /* synthetic */ f lGE;

                    public final int aG(int i, int i2) {
                        this.lGE.iJU.Bb();
                        v.i("MicroMsg.GetHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                        if (i == 0 && i2 == 0) {
                            n.AX();
                            Bitmap gJ = d.gJ(this.lGE.username);
                            if (gJ != null) {
                                f fVar = this.lGE;
                                n.AX();
                                fVar.b(gJ, d.s(this.lGE.username, true));
                            } else {
                                this.lGE.b(b, null);
                            }
                            if (this.lGE.lGC != null) {
                                this.lGE.lGC;
                                this.lGE.username;
                            }
                        } else {
                            this.lGE.b(b, null);
                            if (this.lGE.lGC != null) {
                                this.lGE.lGC;
                                this.lGE.username;
                            }
                        }
                        return 0;
                    }
                });
                return;
            }
            v.i("MicroMsg.GetHdHeadImg", "The HDAvatar of %s is already exists", new Object[]{this.username});
            n.AX();
            b(gJ, d.s(this.username, true));
            return;
        }
        s.ey(this.aXH);
        b(n.AX().aM(this.aXH), null);
    }

    private void b(Bitmap bitmap, String str) {
        try {
            Bitmap createBitmap;
            if (bitmap.getWidth() < 480) {
                float width = (float) (480 / bitmap.getWidth());
                Matrix matrix = new Matrix();
                matrix.postScale(width, width);
                createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } else {
                createBitmap = bitmap;
            }
            v.d("MicroMsg.GetHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(createBitmap.getWidth()), Integer.valueOf(createBitmap.getHeight())});
            this.hhc.B(createBitmap);
            this.hhc.iJV = str;
        } catch (Throwable e) {
            v.a("MicroMsg.GetHdHeadImg", e, "", new Object[0]);
        }
    }
}
