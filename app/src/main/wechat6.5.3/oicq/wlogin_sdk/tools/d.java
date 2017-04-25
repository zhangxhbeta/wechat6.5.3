package oicq.wlogin_sdk.tools;

import com.tencent.smtt.sdk.WebView;

public final class d {
    public static byte[] b(byte[] bArr, int i, byte[] bArr2) {
        int i2;
        int i3;
        Object obj = new byte[i];
        System.arraycopy(bArr, 0, obj, 0, i);
        a aVar = new a();
        int length = obj.length;
        aVar.plain = new byte[8];
        aVar.prePlain = new byte[8];
        aVar.pos = 1;
        aVar.padding = 0;
        aVar.preCrypt = 0;
        aVar.crypt = 0;
        aVar.key = bArr2;
        aVar.header = true;
        aVar.pos = (length + 10) % 8;
        if (aVar.pos != 0) {
            aVar.pos = 8 - aVar.pos;
        }
        aVar.out = new byte[((aVar.pos + length) + 10)];
        aVar.plain[0] = (byte) ((aVar.random.nextInt() & 248) | aVar.pos);
        for (i2 = 1; i2 <= aVar.pos; i2++) {
            aVar.plain[i2] = (byte) (aVar.random.nextInt() & WebView.NORMAL_MODE_ALPHA);
        }
        aVar.pos++;
        for (i2 = 0; i2 < 8; i2++) {
            aVar.prePlain[i2] = (byte) 0;
        }
        aVar.padding = 1;
        while (aVar.padding <= 2) {
            if (aVar.pos < 8) {
                byte[] bArr3 = aVar.plain;
                i3 = aVar.pos;
                aVar.pos = i3 + 1;
                bArr3[i3] = (byte) (aVar.random.nextInt() & WebView.NORMAL_MODE_ALPHA);
                aVar.padding++;
            }
            if (aVar.pos == 8) {
                aVar.encrypt8Bytes();
            }
        }
        i3 = length;
        length = 0;
        while (i3 > 0) {
            if (aVar.pos < 8) {
                byte[] bArr4 = aVar.plain;
                int i4 = aVar.pos;
                aVar.pos = i4 + 1;
                i2 = length + 1;
                bArr4[i4] = obj[length];
                length = i3 - 1;
            } else {
                i2 = length;
                length = i3;
            }
            if (aVar.pos == 8) {
                aVar.encrypt8Bytes();
            }
            i3 = length;
            length = i2;
        }
        aVar.padding = 1;
        while (aVar.padding <= 7) {
            if (aVar.pos < 8) {
                bArr3 = aVar.plain;
                int i5 = aVar.pos;
                aVar.pos = i5 + 1;
                bArr3[i5] = (byte) 0;
                aVar.padding++;
            }
            if (aVar.pos == 8) {
                aVar.encrypt8Bytes();
            }
        }
        return aVar.out;
    }

    public static byte[] decrypt(byte[] bArr, int i, int i2, byte[] bArr2) {
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        a aVar = new a();
        int length = obj.length;
        aVar.preCrypt = 0;
        aVar.crypt = 0;
        aVar.key = bArr2;
        byte[] bArr3 = new byte[8];
        if (length % 8 != 0 || length < 16) {
            return null;
        }
        aVar.prePlain = aVar.decipher(obj, 0);
        aVar.pos = aVar.prePlain[0] & 7;
        int i3 = (length - aVar.pos) - 10;
        if (i3 < 0) {
            return null;
        }
        int i4;
        for (i4 = 0; i4 < 8; i4++) {
            bArr3[i4] = (byte) 0;
        }
        aVar.out = new byte[i3];
        aVar.preCrypt = 0;
        aVar.crypt = 8;
        aVar.contextStart = 8;
        aVar.pos++;
        aVar.padding = 1;
        while (aVar.padding <= 2) {
            if (aVar.pos < 8) {
                aVar.pos++;
                aVar.padding++;
            }
            if (aVar.pos == 8) {
                if (!aVar.decrypt8Bytes(obj, 0, length)) {
                    return null;
                }
                bArr3 = obj;
            }
        }
        i4 = i3;
        byte[] bArr4 = bArr3;
        int i5 = 0;
        while (i4 != 0) {
            if (aVar.pos < 8) {
                aVar.out[i5] = (byte) (bArr4[(aVar.preCrypt + 0) + aVar.pos] ^ aVar.prePlain[aVar.pos]);
                i5++;
                i4--;
                aVar.pos++;
            }
            if (aVar.pos == 8) {
                aVar.preCrypt = aVar.crypt - 8;
                if (!aVar.decrypt8Bytes(obj, 0, length)) {
                    return null;
                }
                bArr4 = obj;
            }
        }
        aVar.padding = 1;
        bArr3 = bArr4;
        while (aVar.padding < 8) {
            if (aVar.pos < 8) {
                if ((bArr3[(aVar.preCrypt + 0) + aVar.pos] ^ aVar.prePlain[aVar.pos]) != 0) {
                    return null;
                }
                aVar.pos++;
            }
            if (aVar.pos == 8) {
                aVar.preCrypt = aVar.crypt;
                if (!aVar.decrypt8Bytes(obj, 0, length)) {
                    return null;
                }
                bArr3 = obj;
            }
            aVar.padding++;
        }
        return aVar.out;
    }
}
