package com.tencent.mm.plugin.brandservice.ui.base;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelbiz.j;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class d extends BitmapDrawable implements com.tencent.mm.modelbiz.j.a.a {
    private static Bitmap aQs;
    private static ac cnO = new ac(Looper.getMainLooper());
    private static int ezX = 200;
    private Runnable cnQ;
    private String dRA;
    private Bitmap ezW;
    private Runnable ezY;
    private String mUrl;

    public static class a {
        public static void a(ImageView imageView, String str, String str2) {
            Bitmap decodeResource = BitmapFactory.decodeResource(aa.getContext().getResources(), 2130837790);
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof d)) {
                drawable = (decodeResource == null || decodeResource.isRecycled()) ? new d(str, str2) : new d(str, str2, decodeResource);
                imageView.setImageDrawable(drawable);
                return;
            }
            ((d) drawable).bc(str, str2);
        }
    }

    private d(String str, String str2) {
        if (aQs == null || aQs.isRecycled()) {
            aQs = Bitmap.createBitmap(200, 200, Config.ARGB_8888);
        }
        this(str, str2, aQs);
    }

    private d(String str, String str2, Bitmap bitmap) {
        super(bitmap);
        this.cnQ = new Runnable(this) {
            final /* synthetic */ d ezZ;

            {
                this.ezZ = r1;
            }

            public final void run() {
                this.ezZ.invalidateSelf();
            }
        };
        this.ezY = new Runnable(this) {
            final /* synthetic */ d ezZ;

            {
                this.ezZ = r1;
            }

            public final void run() {
                Bitmap b = j.b(this.ezZ.dRA, this.ezZ.mUrl, 0);
                if (b != null && !b.isRecycled()) {
                    d.cnO.post(this.ezZ.cnQ);
                }
            }
        };
        Paint paint = getPaint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        u.DG().a(this);
        bc(str, str2);
    }

    public final void hO(String str) {
        if (this.dRA != null && this.dRA.equals(str)) {
            cnO.postDelayed(this.cnQ, (long) ezX);
        }
    }

    public final void draw(Canvas canvas) {
        this.ezW = j.hM(this.dRA);
        if (this.ezW == null || this.ezW.isRecycled()) {
            ak.vA().f(this.ezY, (long) ezX);
            super.draw(canvas);
            return;
        }
        Rect bounds = getBounds();
        canvas.drawBitmap(this.ezW, new Rect(0, 0, this.ezW.getWidth(), this.ezW.getHeight()), bounds, getPaint());
    }

    public final void bc(String str, String str2) {
        if (be.kS(str)) {
            v.w("MicroMsg.BrandAvatarDrawable", "The username is null or nil.");
        }
        this.dRA = str;
        if (str2 == this.mUrl) {
            return;
        }
        if (str2 == null || !(str2 == null || str2.equals(this.mUrl))) {
            v.i("MicroMsg.BrandAvatarDrawable", "set a new url for the drawable, url:[%s]", new Object[]{str2});
            this.mUrl = str2;
            cnO.post(this.cnQ);
        }
    }
}
