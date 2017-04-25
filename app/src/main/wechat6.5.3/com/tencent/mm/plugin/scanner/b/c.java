package com.tencent.mm.plugin.scanner.b;

import android.graphics.Rect;
import c.a;
import com.tencent.mm.sdk.platformtools.v;

public final class c extends a {
    public int height;
    public final byte[] iDa;
    final int iDb;
    final int iDc;
    public int left;
    public int top;
    public int width;

    public c(byte[] bArr, int i, int i2, Rect rect) {
        int i3 = 0;
        super(rect.width(), rect.height());
        v.v("MicroMsg.scanner.PlanarYUVLuminanceSource", "init yuvData.len: %d,  dataW: %d, dataH: %d, left: %d, top: %d, width: %d, height: %d ", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.width()), Integer.valueOf(rect.height())});
        this.iDa = bArr;
        this.iDb = i;
        this.iDc = i2;
        int i4 = (rect.left < 0 || rect.left >= i) ? 0 : rect.left;
        this.left = i4;
        if (rect.top >= 0 && rect.top < i2) {
            i3 = rect.top;
        }
        this.top = i3;
        this.width = this.left + rect.width() > i ? i - this.left : rect.width();
        this.height = this.top + rect.height() > i2 ? i2 - this.top : rect.height();
        if (this.left + this.width > i || this.top + this.height > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
    }

    public final byte[] k(int i, byte[] bArr) {
        if (i < 0 || i >= this.height) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        if (bArr == null || bArr.length < this.width) {
            bArr = new byte[this.width];
        }
        System.arraycopy(this.iDa, ((this.top + i) * this.iDb) + this.left, bArr, 0, this.width);
        return bArr;
    }

    public static void aLO() {
        m aLZ = m.aLZ();
        if (aLZ.iEb != null) {
            aLZ.iEb = null;
        }
        if (aLZ.iEc != null) {
            aLZ.iEc = null;
        }
        System.gc();
    }

    public final byte[] aLP() {
        if (this.width == this.iDb && this.height == this.iDc) {
            return this.iDa;
        }
        try {
            int i = this.width * this.height;
            m aLZ = m.aLZ();
            if (aLZ.iEb == null) {
                aLZ.iEb = new byte[i];
            } else if (aLZ.iEb.length != i) {
                aLZ.iEb = null;
                aLZ.iEb = new byte[i];
            }
            byte[] bArr = aLZ.iEb;
            int i2 = (this.top * this.iDb) + this.left;
            if (this.width == this.iDb) {
                System.arraycopy(this.iDa, i2, bArr, 0, i);
                return bArr;
            }
            Object obj = this.iDa;
            for (int i3 = 0; i3 < this.height; i3++) {
                System.arraycopy(obj, i2, bArr, this.width * i3, this.width);
                i2 += this.iDb;
            }
            return bArr;
        } catch (Exception e) {
            v.e("MicroMsg.scanner.PlanarYUVLuminanceSource", " yuvData.len:" + this.iDa.length + " dataWidth:" + this.iDb + " dataHeight:" + this.iDc + " left:" + this.left + " top:" + this.top + " width:" + this.width + " height:" + this.height + " tStr:" + e.toString());
            return null;
        }
    }

    public final byte[] aLQ() {
        if (this.width == this.iDb && this.height == this.iDc) {
            return this.iDa;
        }
        try {
            int i = this.width * this.height;
            byte[] bArr = new byte[i];
            int i2 = (this.top * this.iDb) + this.left;
            if (this.width == this.iDb) {
                System.arraycopy(this.iDa, i2, bArr, 0, i);
                return bArr;
            }
            Object obj = this.iDa;
            for (int i3 = 0; i3 < this.height; i3++) {
                System.arraycopy(obj, i2, bArr, this.width * i3, this.width);
                i2 += this.iDb;
            }
            return bArr;
        } catch (Exception e) {
            v.e("MicroMsg.scanner.PlanarYUVLuminanceSource", " yuvData.len:" + this.iDa.length + " dataWidth:" + this.iDb + " dataHeight:" + this.iDc + " left:" + this.left + " top:" + this.top + " width:" + this.width + " height:" + this.height + " tStr:" + e.toString());
            return null;
        }
    }
}
