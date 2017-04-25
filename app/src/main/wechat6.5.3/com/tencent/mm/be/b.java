package com.tencent.mm.be;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.InputStream;

public final class b {
    public byte[] epb;
    public SparseArray<a> neM;

    static class a {
        public final int neN;
        public final int[] neO;
        public final int[] neP;

        public a(int i, int[] iArr, int[] iArr2) {
            this.neN = i;
            this.neO = iArr;
            this.neP = iArr2;
        }
    }

    private b(SparseArray<a> sparseArray, byte[] bArr) {
        this.neM = sparseArray;
        this.epb = bArr;
    }

    public static b a(SparseArray<a> sparseArray, InputStream inputStream, int i) {
        try {
            byte[] bArr = new byte[i];
            if (inputStream.read(bArr, 0, bArr.length) != bArr.length) {
                v.e("MicroMsg.language.PluralsCollection", "[cpan] newPluralsConllection failed. data length no equal.");
            }
            return new b(sparseArray, bArr);
        } catch (Throwable e) {
            v.e("MicroMsg.language.PluralsCollection", "[cpan] newPluralsConllection failed:%s", be.e(e));
            return null;
        }
    }

    public final String getQuantityString(int i, int i2, Object... objArr) {
        String str;
        Throwable e;
        try {
            int indexOfKey = this.neM.indexOfKey(i);
            if (indexOfKey < 0) {
                return null;
            }
            a aVar = (a) this.neM.valueAt(indexOfKey);
            int length = aVar.neO.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                int i5;
                if (aVar.neO[i3] == i2) {
                    i5 = i3;
                } else {
                    i5 = i4;
                }
                i3++;
                i4 = i5;
            }
            if (indexOfKey <= this.neM.size() - 1) {
                if (i4 >= length - 1) {
                    str = new String(this.epb, aVar.neP[i4], ((a) this.neM.valueAt(indexOfKey + 1)).neP[0] - aVar.neP[i4]);
                } else {
                    str = new String(this.epb, aVar.neP[i4], aVar.neP[i4 + 1] - aVar.neP[i4]);
                }
            } else if (i4 >= length - 1) {
                str = new String(this.epb, aVar.neP[i4], this.epb.length - aVar.neP[i4]);
            } else {
                str = new String(this.epb, aVar.neP[i4], aVar.neP[i4 + 1] - aVar.neP[i4]);
            }
            try {
                if (be.kS(str) || objArr != null) {
                    return String.format(str, objArr);
                }
                return str;
            } catch (Exception e2) {
                e = e2;
                v.e("MicroMsg.language.PluralsCollection", "[cpan] getString failed. %s", be.e(e));
                return str;
            }
        } catch (Throwable e3) {
            e = e3;
            str = null;
            v.e("MicroMsg.language.PluralsCollection", "[cpan] getString failed. %s", be.e(e));
            return str;
        }
    }
}
