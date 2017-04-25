package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.j.z;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.d.a;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class b extends h implements a {
    Bitmap eAm;
    private float lFZ;

    private b(String str) {
        super(com.tencent.mm.pluginsdk.ui.a.b.box(), str);
        this.lFZ = 0.5f;
        this.eAm = null;
    }

    public b(String str, float f) {
        this(str);
        this.lFZ = f;
    }

    public final void gM(String str) {
        super.gM(str);
    }

    public final void draw(Canvas canvas) {
        Bitmap bitmap = null;
        z zVar = j.a.lxS;
        if (zVar != null) {
            bitmap = j.a.lxS.vF(this.tag);
        }
        if (bitmap != null) {
            a(canvas, bitmap);
            return;
        }
        if (this.lGL) {
            bitmap = this.hXG.a(this.tag, canvas.getWidth(), canvas.getHeight(), 1);
        } else {
            bitmap = this.hXG.bg(this.tag);
        }
        if (bitmap != null) {
            bitmap = d.a(bitmap, false, this.lFZ * ((float) bitmap.getWidth()));
            if (zVar != null) {
                zVar.n(this.tag, bitmap);
            }
            a(canvas, bitmap);
        } else if (bitmap == null || bitmap.isRecycled()) {
            if (this.eAm == null) {
                try {
                    this.eAm = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(aa.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bd.a.getDensity(null), 0, 0);
                    this.eAm = d.a(this.eAm, false, this.lFZ * ((float) this.eAm.getWidth()));
                } catch (Throwable e) {
                    v.a("MicroMsg.AvatarRoundDrawable", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            }
            a(canvas, this.eAm);
        }
    }

    private void a(Canvas canvas, Bitmap bitmap) {
        Rect bounds = getBounds();
        Rect rect = null;
        if (this.lGQ > 1.0f || this.lGK) {
            int height = (bitmap.getHeight() / 15) / 2;
            int width = (bitmap.getWidth() / 15) / 2;
            rect = new Rect(width, height, bitmap.getWidth() - width, bitmap.getHeight() - height);
        }
        canvas.drawBitmap(bitmap, rect, bounds, cnN);
    }
}
