package com.tencent.mm.plugin.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.bd.a;
import com.tencent.mm.e.a.gx;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class MMGIFImageView extends ImageView {
    public String eZd;
    public int gDc;
    private int gDd;
    private boolean gDe;
    private int gDf;
    private int gDg;
    public float mDensity;

    public MMGIFImageView(Context context) {
        this(context, null);
    }

    public MMGIFImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMGIFImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gDc = 2130838153;
        this.gDd = 2130838794;
        this.gDe = true;
        this.mDensity = 0.0f;
        this.gDf = 0;
        this.gDg = 0;
    }

    public void setImageResource(int i) {
        a(getResources(), i, true);
    }

    public void setBackgroundResource(int i) {
        a(getResources(), i, false);
    }

    public final void uz(String str) {
        bN(str, null);
    }

    public final void bM(String str, String str2) {
        bN(str, str2);
    }

    public final void d(byte[] bArr, String str) {
        try {
            Drawable aVar;
            if (be.kS(str)) {
                aVar = new a(bArr);
            } else {
                this.eZd = str;
                aVar = b.atw().o(this.eZd, bArr);
            }
            setImageDrawable(aVar);
        } catch (MMGIFException e) {
            a(e);
            if (e.getErrorCode() == MMGIFException.D_GIF_ERR_NOT_GIF_FILE) {
                Bitmap bc = d.bc(bArr);
                if (bc != null) {
                    setImageBitmap(bc);
                    return;
                }
                v.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", bArr.toString());
                init();
                return;
            }
            v.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", e.toString());
            init();
        } catch (IOException e2) {
            v.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", e2.toString());
            init();
        }
    }

    public final void a(InputStream inputStream, String str) {
        Drawable drawable = null;
        try {
            if (be.kS(str)) {
                drawable = new a(inputStream);
            } else {
                this.eZd = str;
                b atw = b.atw();
                String str2 = this.eZd;
                if (inputStream != null) {
                    v.d("MicroMsg.GIF.MMGIFDrawableCacheMgr", "stream key:%s", str2);
                    if (atw.gCQ.get(str2) != null) {
                        drawable = (a) ((WeakReference) atw.gCQ.get(str2)).get();
                    }
                    if (drawable == null) {
                        drawable = new a(inputStream);
                        atw.gCQ.put(str2, new WeakReference(drawable));
                    }
                }
            }
            setImageDrawable(drawable);
        } catch (MMGIFException e) {
            a(e);
            if (e.getErrorCode() == MMGIFException.D_GIF_ERR_NOT_GIF_FILE) {
                Bitmap a = d.a(inputStream, atx());
                if (a != null) {
                    setImageBitmap(a);
                    return;
                }
                v.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failedbitmap is null. bytes %s");
                init();
                return;
            }
            v.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", e.toString());
            init();
        } catch (IOException e2) {
            v.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", e2.toString());
            init();
        }
    }

    private float atx() {
        if (this.mDensity == 0.0f) {
            return a.getDensity(aa.getContext());
        }
        return this.mDensity;
    }

    private void a(Resources resources, int i, boolean z) {
        Drawable drawable = null;
        try {
            if (be.kS(null)) {
                drawable = new a(resources, i);
            } else {
                this.eZd = null;
                b atw = b.atw();
                if (atw.gCQ.get(null) != null) {
                    drawable = (a) ((WeakReference) atw.gCQ.get(null)).get();
                }
                if (drawable == null) {
                    drawable = new a(resources, i);
                    atw.gCQ.put(null, new WeakReference(drawable));
                }
            }
            if (z) {
                setImageDrawable(drawable);
            } else {
                setBackgroundDrawable(drawable);
            }
        } catch (IOException e) {
            v.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFResource failed. %s" + e.toString());
            if (z) {
                super.setImageResource(i);
            } else {
                super.setBackgroundResource(i);
            }
        }
    }

    public final void a(String str, int i, e eVar) {
        try {
            Drawable aVar = new a(str);
            setImageDrawable(aVar);
            aVar.gCE = i;
            aVar.gCG = eVar;
            return;
        } catch (MMGIFException e) {
            try {
                a(e);
                if (e.getErrorCode() == MMGIFException.D_GIF_ERR_NOT_GIF_FILE) {
                    Bitmap decodeStream = d.decodeStream(new FileInputStream(str));
                    if (decodeStream != null) {
                        decodeStream.setDensity((int) atx());
                        setImageBitmap(decodeStream);
                        return;
                    }
                    v.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed bitmap is null. show default and delete file. path:%s", str);
                    init();
                    b.deleteFile(str);
                    return;
                }
            } catch (FileNotFoundException e2) {
                v.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + e2.toString());
            }
            v.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + e.toString());
        } catch (IOException e3) {
            v.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + e3.toString());
        }
        init();
    }

    public final void bN(String str, String str2) {
        try {
            Drawable aVar;
            if (be.kS(str2)) {
                aVar = new a(str);
            } else {
                this.eZd = str2;
                aVar = b.atw().bL(this.eZd, str);
            }
            setImageDrawable(aVar);
        } catch (MMGIFException e) {
            try {
                a(e);
                if (e.getErrorCode() == MMGIFException.D_GIF_ERR_NOT_GIF_FILE) {
                    Bitmap a = d.a(new FileInputStream(str), atx());
                    if (a != null) {
                        a.setDensity(240);
                        setImageBitmap(a);
                        return;
                    }
                    v.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failedbitmap is null. show default and delete file. path %s", str);
                    init();
                    b.deleteFile(str);
                    return;
                }
            } catch (Throwable e2) {
                v.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed1. %s", be.e(e2));
            }
            init();
        } catch (Throwable e22) {
            v.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed3. %s", be.e(e22));
            b.deleteFile(str);
            init();
        }
    }

    public final void init() {
        ak.yW();
        this.gDe = c.isSDCardAvailable();
        if (this.gDe) {
            if (this.gDc > 0) {
                super.setImageResource(this.gDc);
            }
        } else if (this.gDd > 0) {
            super.setImageResource(this.gDd);
        }
    }

    public final int getIntrinsicWidth() {
        int intrinsicWidth = getDrawable() == null ? 0 : getDrawable().getIntrinsicWidth();
        return intrinsicWidth == 0 ? this.gDf : intrinsicWidth;
    }

    public final int getIntrinsicHeight() {
        int intrinsicHeight = getDrawable() == null ? 0 : getDrawable().getIntrinsicHeight();
        return intrinsicHeight == 0 ? this.gDg : intrinsicHeight;
    }

    public final void resume() {
        if (getDrawable() != null && (getDrawable() instanceof a)) {
            a aVar = (a) getDrawable();
            if (!aVar.gCn) {
                aVar.gCm = true;
                aVar.e(aVar.gCI, 0);
            }
        }
    }

    public static void a(MMGIFException mMGIFException) {
        com.tencent.mm.sdk.c.b gxVar = new gx();
        gxVar.bgB.errorCode = mMGIFException.getErrorCode();
        com.tencent.mm.sdk.c.a.nhr.z(gxVar);
    }
}
