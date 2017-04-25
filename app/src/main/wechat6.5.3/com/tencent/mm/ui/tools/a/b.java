package com.tencent.mm.ui.tools.a;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.qq.taf.jce.JceStruct;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class b extends a {
    private int QW = 2048;
    private int Zx = 2048;
    public int hO = JceStruct.JCE_MAX_STRING_LENGTH;
    private String hgx;
    public int oWu = 0;
    public int oWv = 0;
    public int oWw = 0;
    private a oWx;

    public interface a {
        void a(b bVar);

        void agF();
    }

    private b(String str) {
        this.hgx = str;
    }

    public static b PE(String str) {
        return new b(str);
    }

    public final b ym(int i) {
        this.Zx = i;
        this.QW = i;
        return this;
    }

    public final void a(a aVar) {
        this.oWx = aVar;
        bqC();
    }

    protected final int QH() {
        boolean z;
        if (be.kS(this.hgx)) {
            v.w("MicroMsg.ImageBoundaryCheck", "dz[check image but path is null or nil]");
        }
        this.oWu = e.aQ(this.hgx);
        String str = this.hgx;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        this.oWv = options.outWidth;
        this.oWw = options.outHeight;
        if (this.oWu <= this.hO) {
            if (!(this.oWu < 0)) {
                z = true;
                if (this.oWv > this.Zx || this.oWw > this.QW) {
                    v.d("MicroMsg.ImageBoundaryCheck", "dz[over width or height] width = %d, height = %d", new Object[]{Integer.valueOf(this.oWv), Integer.valueOf(this.oWw)});
                    z = false;
                }
                if (z) {
                    return 1;
                }
                v.i("MicroMsg.ImageBoundaryCheck", "dz[status ok]");
                return 0;
            }
        }
        v.d("MicroMsg.ImageBoundaryCheck", "dz[over size] size = %d", new Object[]{Integer.valueOf(this.oWu)});
        z = false;
        v.d("MicroMsg.ImageBoundaryCheck", "dz[over width or height] width = %d, height = %d", new Object[]{Integer.valueOf(this.oWv), Integer.valueOf(this.oWw)});
        z = false;
        if (z) {
            return 1;
        }
        v.i("MicroMsg.ImageBoundaryCheck", "dz[status ok]");
        return 0;
    }

    protected final void bqC() {
        if (this.oWx == null) {
            v.w("MicroMsg.ImageBoundaryCheck", "dz[callback is null]");
            return;
        }
        switch (QH()) {
            case 0:
                this.oWx.a(this);
                return;
            case 1:
                this.oWx.agF();
                return;
            default:
                return;
        }
    }
}
