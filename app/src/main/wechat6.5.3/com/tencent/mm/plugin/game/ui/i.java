package com.tencent.mm.plugin.game.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.game.c.ah;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;

public final class i extends BitmapDrawable implements com.tencent.mm.platformtools.j.a {
    private static Bitmap aQs;
    private static ac cnO = new ac(Looper.getMainLooper());
    private Runnable cnQ;
    private Bitmap ezW;
    private String mUrl;

    public static class a {

        static class AnonymousClass1 implements com.tencent.mm.sdk.h.g.a {
            final /* synthetic */ String aSi;
            final /* synthetic */ ImageView fwb;
            final /* synthetic */ float gsD;

            AnonymousClass1(String str, float f, ImageView imageView) {
                this.aSi = str;
                this.gsD = f;
                this.fwb = imageView;
            }

            public final void a(String str, com.tencent.mm.sdk.h.i iVar) {
                if (this.aSi.equals(str)) {
                    Bitmap b = g.b(this.aSi, 1, this.gsD);
                    if (b != null) {
                        this.fwb.setImageBitmap(b);
                        am.bnB().d(this);
                    }
                }
            }
        }
    }

    private i(String str) {
        Bitmap createBitmap;
        if (aQs == null || aQs.isRecycled()) {
            createBitmap = Bitmap.createBitmap(8, 8, Config.ARGB_8888);
            aQs = createBitmap;
        } else {
            createBitmap = aQs;
        }
        this(str, createBitmap);
    }

    private i(String str, Bitmap bitmap) {
        super(bitmap);
        this.cnQ = new Runnable(this) {
            final /* synthetic */ i gsC;

            {
                this.gsC = r1;
            }

            public final void run() {
                this.gsC.invalidateSelf();
            }
        };
        Paint paint = getPaint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        j.a(this);
        setUrl(str);
    }

    public final void k(String str, Bitmap bitmap) {
        if (this.mUrl != null && (this.mUrl.hashCode()).equals(str) && bitmap != null && !bitmap.isRecycled()) {
            v.i("MicroMsg.GameDrawable", "onGerPictureFinish() function has been invoke.");
            this.ezW = bitmap;
            cnO.post(this.cnQ);
        }
    }

    public final void draw(Canvas canvas) {
        if (this.ezW == null || this.ezW.isRecycled()) {
            super.draw(canvas);
            return;
        }
        Rect bounds = getBounds();
        canvas.drawBitmap(this.ezW, new Rect(0, 0, this.ezW.getWidth(), this.ezW.getHeight()), bounds, getPaint());
    }

    public final void setUrl(String str) {
        if (str != null && !str.equals(this.mUrl)) {
            v.i("MicroMsg.GameDrawable", "set a new url for the drawable,url:[%s]", new Object[]{str});
            this.mUrl = str;
            Bitmap a = j.a(new ah(this.mUrl));
            if (!(a == null || a.isRecycled())) {
                this.ezW = a;
            }
            cnO.post(this.cnQ);
        }
    }
}
