package oicq.wlogin_sdk.tools;

import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

final class a {
    int contextStart;
    int crypt;
    boolean header = true;
    byte[] key;
    byte[] out;
    int padding;
    byte[] plain;
    int pos;
    int preCrypt;
    byte[] prePlain;
    Random random = new Random();

    a() {
    }

    private static long m(byte[] bArr, int i) {
        long j = 0;
        int i2 = i + 4;
        while (i < i2) {
            j = (j << 8) | ((long) (bArr[i] & WebView.NORMAL_MODE_ALPHA));
            i++;
        }
        return (j >>> 32) | (4294967295L & j);
    }

    private byte[] encipher(byte[] bArr) {
        int i = 16;
        try {
            long m = m(bArr, 0);
            long m2 = m(bArr, 4);
            long m3 = m(this.key, 0);
            long m4 = m(this.key, 4);
            long m5 = m(this.key, 8);
            long m6 = m(this.key, 12);
            long j = 0;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) m);
                    dataOutputStream.writeInt((int) m2);
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                j = (j + 2654435769L) & 4294967295L;
                m = (m + ((((m2 << 4) + m3) ^ (m2 + j)) ^ ((m2 >>> 5) + m4))) & 4294967295L;
                m2 = (m2 + ((((m << 4) + m5) ^ (m + j)) ^ ((m >>> 5) + m6))) & 4294967295L;
                i = i2;
            }
        } catch (IOException e) {
            return null;
        }
    }

    byte[] decipher(byte[] bArr, int i) {
        int i2 = 16;
        try {
            long m = m(bArr, 0);
            long m2 = m(bArr, 4);
            long m3 = m(this.key, 0);
            long m4 = m(this.key, 4);
            long m5 = m(this.key, 8);
            long m6 = m(this.key, 12);
            long j = 3816266640L;
            while (true) {
                int i3 = i2 - 1;
                if (i2 <= 0) {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) m);
                    dataOutputStream.writeInt((int) m2);
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                m2 = (m2 - ((((m << 4) + m5) ^ (m + j)) ^ ((m >>> 5) + m6))) & 4294967295L;
                m = (m - ((((m2 << 4) + m3) ^ (m2 + j)) ^ ((m2 >>> 5) + m4))) & 4294967295L;
                j = (j - 2654435769L) & 4294967295L;
                i2 = i3;
            }
        } catch (IOException e) {
            return null;
        }
    }

    final void encrypt8Bytes() {
        this.pos = 0;
        while (this.pos < 8) {
            byte[] bArr;
            int i;
            if (this.header) {
                bArr = this.plain;
                i = this.pos;
                bArr[i] = (byte) (bArr[i] ^ this.prePlain[this.pos]);
            } else {
                bArr = this.plain;
                i = this.pos;
                bArr[i] = (byte) (bArr[i] ^ this.out[this.preCrypt + this.pos]);
            }
            this.pos++;
        }
        System.arraycopy(encipher(this.plain), 0, this.out, this.crypt, 8);
        this.pos = 0;
        while (this.pos < 8) {
            bArr = this.out;
            i = this.crypt + this.pos;
            bArr[i] = (byte) (bArr[i] ^ this.prePlain[this.pos]);
            this.pos++;
        }
        System.arraycopy(this.plain, 0, this.prePlain, 0, 8);
        this.preCrypt = this.crypt;
        this.crypt += 8;
        this.pos = 0;
        this.header = false;
    }

    boolean decrypt8Bytes(byte[] bArr, int i, int i2) {
        this.pos = 0;
        while (this.pos < 8) {
            if (this.contextStart + this.pos >= i2) {
                return true;
            }
            byte[] bArr2 = this.prePlain;
            int i3 = this.pos;
            bArr2[i3] = (byte) (bArr2[i3] ^ bArr[(this.crypt + 0) + this.pos]);
            this.pos++;
        }
        this.prePlain = decipher(this.prePlain, 0);
        if (this.prePlain == null) {
            return false;
        }
        this.contextStart += 8;
        this.crypt += 8;
        this.pos = 0;
        return true;
    }
}
