package com.tencent.mm.be;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.InputStream;

public final class d {
    public byte[] epb;
    public SparseArray<a> neR;

    static class a {
        public final int kCd;
        public final int[] neS;

        public a(int i, int[] iArr) {
            this.kCd = i;
            this.neS = iArr;
        }
    }

    private d(SparseArray<a> sparseArray, byte[] bArr) {
        this.neR = sparseArray;
        this.epb = bArr;
    }

    public static d b(SparseArray<a> sparseArray, InputStream inputStream, int i) {
        try {
            byte[] bArr = new byte[i];
            if (inputStream.read(bArr, 0, bArr.length) != bArr.length) {
                v.e("MicroMsg.language.StringArraysCollection", "[cpan] newPluralsConllection failed. data length no equal.");
            }
            return new d(sparseArray, bArr);
        } catch (Throwable e) {
            v.e("MicroMsg.language.StringArraysCollection", "[cpan] newPluralsConllection failed:%s", be.e(e));
            return null;
        }
    }
}
