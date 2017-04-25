package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Field;

@TargetApi(14)
public class MMTextureView extends TextureView {
    private Field nYL;

    public MMTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMTextureView(Context context) {
        super(context);
    }

    @TargetApi(14)
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable e) {
            v.a("MicroMsg.MMTextureView", e, "unkown error", new Object[0]);
        }
    }

    public final void bCE() {
        if (d.dX(16)) {
            v.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", Integer.valueOf(VERSION.SDK_INT));
        } else if (d.dY(20)) {
            v.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", Integer.valueOf(VERSION.SDK_INT));
        } else if (p.ceJ.ceg == 2) {
            v.i("MicroMsg.MMTextureView", "do not do sly textureView, config ERROR");
        } else {
            v.i("MicroMsg.MMTextureView", "detect texture problem, sly");
            try {
                if (this.nYL == null) {
                    this.nYL = TextureView.class.getDeclaredField("mSurface");
                    this.nYL.setAccessible(true);
                }
                SurfaceTexture surfaceTexture = (SurfaceTexture) this.nYL.get(this);
                if (surfaceTexture == null) {
                    v.i("MicroMsg.MMTextureView", "detect texture problem, no wrap");
                } else if (surfaceTexture instanceof r) {
                    v.i("MicroMsg.MMTextureView", "detect texture problem, wrapped");
                } else {
                    r rVar = new r();
                    rVar.nYd = surfaceTexture;
                    this.nYL.set(this, rVar);
                    v.i("MicroMsg.MMTextureView", "detect texture problem, wrap");
                }
            } catch (Throwable e) {
                v.a("MicroMsg.MMTextureView", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.e("MicroMsg.MMTextureView", "detect texture problem, NoSuchFieldException");
            } catch (Throwable e2) {
                v.a("MicroMsg.MMTextureView", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.e("MicroMsg.MMTextureView", "detect texture problem, IllegalArgumentException");
            } catch (Throwable e22) {
                v.a("MicroMsg.MMTextureView", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.e("MicroMsg.MMTextureView", "detect texture problem, IllegalAccessException");
            }
        }
    }

    @TargetApi(16)
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        super.setSurfaceTexture(surfaceTexture);
        bCE();
    }
}
