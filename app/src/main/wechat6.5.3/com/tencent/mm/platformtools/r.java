package com.tencent.mm.platformtools;

import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public final class r {
    public int contextStart;
    public int crypt;
    private boolean header = true;
    public byte[] key;
    public byte[] out;
    public int padding;
    private byte[] plain;
    public int pos;
    public int preCrypt;
    public byte[] prePlain;
    private Random random = new Random();

    private static long m(byte[] bArr, int i) {
        long j = 0;
        int i2 = i + 4;
        while (i < i2) {
            j = (j << 8) | ((long) (bArr[i] & WebView.NORMAL_MODE_ALPHA));
            i++;
        }
        return j & 4294967295L;
    }

    public final byte[] encrypt(byte[] bArr, byte[] bArr2) {
        int i;
        int i2;
        int length = bArr.length;
        this.plain = new byte[8];
        this.prePlain = new byte[8];
        this.pos = 1;
        this.padding = 0;
        this.preCrypt = 0;
        this.crypt = 0;
        this.key = bArr2;
        this.header = true;
        this.pos = (length + 10) % 8;
        if (this.pos != 0) {
            this.pos = 8 - this.pos;
        }
        this.out = new byte[((this.pos + length) + 10)];
        this.plain[0] = (byte) ((this.random.nextInt() & 248) | this.pos);
        for (i = 1; i <= this.pos; i++) {
            this.plain[i] = (byte) (this.random.nextInt() & WebView.NORMAL_MODE_ALPHA);
        }
        this.pos++;
        for (i = 0; i < 8; i++) {
            this.prePlain[i] = (byte) 0;
        }
        this.padding = 1;
        while (this.padding <= 2) {
            if (this.pos < 8) {
                byte[] bArr3 = this.plain;
                i2 = this.pos;
                this.pos = i2 + 1;
                bArr3[i2] = (byte) (this.random.nextInt() & WebView.NORMAL_MODE_ALPHA);
                this.padding++;
            }
            if (this.pos == 8) {
                encrypt8Bytes();
            }
        }
        i2 = length;
        length = 0;
        while (i2 > 0) {
            if (this.pos < 8) {
                byte[] bArr4 = this.plain;
                int i3 = this.pos;
                this.pos = i3 + 1;
                i = length + 1;
                bArr4[i3] = bArr[length];
                length = i2 - 1;
            } else {
                i = length;
                length = i2;
            }
            if (this.pos == 8) {
                encrypt8Bytes();
                i2 = length;
                length = i;
            } else {
                i2 = length;
                length = i;
            }
        }
        this.padding = 1;
        while (this.padding <= 7) {
            if (this.pos < 8) {
                bArr3 = this.plain;
                int i4 = this.pos;
                this.pos = i4 + 1;
                bArr3[i4] = (byte) 0;
                this.padding++;
            }
            if (this.pos == 8) {
                encrypt8Bytes();
            }
        }
        return this.out;
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
                if (i > 0) {
                    j = (j + 2654435769L) & 4294967295L;
                    m = (m + ((((m2 << 4) + m3) ^ (m2 + j)) ^ ((m2 >>> 5) + m4))) & 4294967295L;
                    m2 = (m2 + ((((m << 4) + m5) ^ (m + j)) ^ ((m >>> 5) + m6))) & 4294967295L;
                    i = i2;
                } else {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) m);
                    dataOutputStream.writeInt((int) m2);
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            return null;
        }
    }

    public final byte[] decipher(byte[] bArr, int i) {
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
                if (i2 > 0) {
                    m2 = (m2 - ((((m << 4) + m5) ^ (m + j)) ^ ((m >>> 5) + m6))) & 4294967295L;
                    m = (m - ((((m2 << 4) + m3) ^ (m2 + j)) ^ ((m2 >>> 5) + m4))) & 4294967295L;
                    j = (j - 2654435769L) & 4294967295L;
                    i2 = i3;
                } else {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) m);
                    dataOutputStream.writeInt((int) m2);
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            return null;
        }
    }

    private void encrypt8Bytes() {
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

    public final boolean decrypt8Bytes(byte[] bArr, int i, int i2) {
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
