package com.tencent.mm.be;

import android.util.SparseIntArray;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.InputStream;

public final class f {
    SparseIntArray nfc;
    byte[] nfd;

    private f(SparseIntArray sparseIntArray, byte[] bArr) {
        this.nfc = sparseIntArray;
        this.nfd = bArr;
    }

    public static f a(SparseIntArray sparseIntArray, InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        try {
            if (inputStream.read(bArr, 0, bArr.length) != bArr.length) {
                v.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. data length no equal.");
            }
            return new f(sparseIntArray, bArr);
        } catch (Throwable e) {
            v.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. %s", be.e(e));
            return null;
        }
    }

    public final String getString(int i) {
        String str;
        try {
            int indexOfKey = this.nfc.indexOfKey(i);
            if (indexOfKey < 0) {
                return null;
            }
            int valueAt;
            int valueAt2 = this.nfc.valueAt(indexOfKey);
            if (indexOfKey < this.nfc.size() - 1) {
                valueAt = this.nfc.valueAt(indexOfKey + 1) - valueAt2;
            } else {
                valueAt = this.nfd.length - valueAt2;
            }
            str = new String(this.nfd, valueAt2, valueAt, "UTF-8");
            return str;
        } catch (Throwable e) {
            v.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", be.e(e));
            str = null;
        } catch (Throwable e2) {
            v.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", be.e(e2));
            str = null;
        }
    }
}
