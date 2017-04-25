package a.a.a.b.a;

import com.tencent.mmdb.FileUtils;
import com.tencent.smtt.sdk.WebView;
import java.io.InputStream;
import java.util.LinkedList;

public final class a {
    public int aGp;
    private int aGq = 0;
    public int aGr;
    public int aGs = 0;
    private int aGt = Integer.MAX_VALUE;
    private int aGw = 67108864;
    public byte[] buffer;
    private InputStream pMn;
    private int pMo = 0;

    public final double readDouble() {
        byte mL = mL();
        byte mL2 = mL();
        return Double.longBitsToDouble(((((((((((long) mL2) & 255) << 8) | (((long) mL) & 255)) | ((((long) mL()) & 255) << 16)) | ((((long) mL()) & 255) << 24)) | ((((long) mL()) & 255) << 32)) | ((((long) mL()) & 255) << 40)) | ((((long) mL()) & 255) << 48)) | ((((long) mL()) & 255) << 56));
    }

    public final float readFloat() {
        return Float.intBitsToFloat((((mL() & WebView.NORMAL_MODE_ALPHA) | ((mL() & WebView.NORMAL_MODE_ALPHA) << 8)) | ((mL() & WebView.NORMAL_MODE_ALPHA) << 16)) | ((mL() & WebView.NORMAL_MODE_ALPHA) << 24));
    }

    public final LinkedList<byte[]> zQ(int i) {
        LinkedList<byte[]> linkedList = new LinkedList();
        int mH = mH();
        try {
            Object obj = new byte[mH];
            System.arraycopy(this.buffer, this.aGr, obj, 0, mH);
            linkedList.add(obj);
            this.aGr = mH + this.aGr;
            mH = this.aGr;
            if (this.aGr == this.aGp) {
                return linkedList;
            }
            int[] zR = zR(mH);
            mH = zR[0];
            while (a.a.a.b.a.cA(mH) == i) {
                this.aGr = zR[1];
                mH = mH();
                obj = new byte[mH];
                System.arraycopy(this.buffer, this.aGr, obj, 0, mH);
                linkedList.add(obj);
                this.aGr = mH + this.aGr;
                if (this.aGr == this.aGp) {
                    break;
                }
                zR = zR(this.aGr);
                mH = zR[0];
            }
            return linkedList;
        } catch (OutOfMemoryError e) {
            throw new OutOfMemoryError("alloc bytes:" + mH);
        }
    }

    public final String readString() {
        int mH = mH();
        if (mH >= this.aGp - this.aGr || mH <= 0) {
            return new String(cs(mH), "UTF-8");
        }
        String str = new String(this.buffer, this.aGr, mH, "UTF-8");
        this.aGr = mH + this.aGr;
        return str;
    }

    private int[] zR(int i) {
        byte b = this.buffer[i];
        int i2 = i + 1;
        if (b >= (byte) 0) {
            return new int[]{b, i2};
        }
        int i3;
        int i4 = b & 127;
        byte b2 = this.buffer[i2];
        if (b2 >= (byte) 0) {
            i3 = i2 + 1;
            i4 |= b2 << 7;
        } else {
            i4 |= (b2 & 127) << 7;
            b2 = this.buffer[i2];
            if (b2 >= (byte) 0) {
                i3 = i2 + 1;
                i4 |= b2 << 14;
            } else {
                i4 |= (b2 & 127) << 14;
                b2 = this.buffer[i2];
                if (b2 >= (byte) 0) {
                    i3 = i2 + 1;
                    i4 |= b2 << 21;
                } else {
                    i4 |= (b2 & 127) << 21;
                    b2 = this.buffer[i2];
                    i4 |= b2 << 28;
                    i3 = i2 + 1;
                    if (b2 < (byte) 0) {
                        for (i4 = 0; i4 < 5; i4++) {
                            if (this.buffer[i3] >= (byte) 0) {
                                i3++;
                                return new int[]{b2, i3};
                            }
                        }
                        throw b.bQO();
                    }
                }
            }
        }
        return new int[]{i4, i3};
    }

    public final int mH() {
        byte mL = mL();
        if (mL >= (byte) 0) {
            return mL;
        }
        int i = mL & 127;
        byte mL2 = mL();
        if (mL2 >= (byte) 0) {
            return i | (mL2 << 7);
        }
        i |= (mL2 & 127) << 7;
        mL2 = mL();
        if (mL2 >= (byte) 0) {
            return i | (mL2 << 14);
        }
        i |= (mL2 & 127) << 14;
        mL2 = mL();
        if (mL2 >= (byte) 0) {
            return i | (mL2 << 21);
        }
        i |= (mL2 & 127) << 21;
        mL2 = mL();
        i |= mL2 << 28;
        if (mL2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (mL() >= (byte) 0) {
                return i;
            }
        }
        throw b.bQO();
    }

    public final long mI() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte mL = mL();
            j |= ((long) (mL & 127)) << i;
            if ((mL & FileUtils.S_IWUSR) == 0) {
                return j;
            }
        }
        throw b.bQO();
    }

    public a(byte[] bArr, int i) {
        this.buffer = bArr;
        this.aGp = i + 0;
        this.aGr = 0;
        this.pMn = null;
    }

    public final boolean kJ(boolean z) {
        if (this.aGr < this.aGp) {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        } else if (this.pMo + this.aGp != this.aGt) {
            this.pMo += this.aGp;
            this.aGr = 0;
            this.aGp = this.pMn == null ? -1 : this.pMn.read(this.buffer);
            if (this.aGp == -1) {
                this.aGp = 0;
                if (!z) {
                    return false;
                }
                throw b.bQM();
            }
            this.aGp += this.aGq;
            int i = this.pMo + this.aGp;
            if (i > this.aGt) {
                this.aGq = i - this.aGt;
                this.aGp -= this.aGq;
            } else {
                this.aGq = 0;
            }
            i = (this.pMo + this.aGp) + this.aGq;
            if (i <= this.aGw && i >= 0) {
                return true;
            }
            throw b.bQQ();
        } else if (!z) {
            return false;
        } else {
            throw b.bQM();
        }
    }

    private byte mL() {
        if (this.aGr == this.aGp) {
            kJ(true);
        }
        byte[] bArr = this.buffer;
        int i = this.aGr;
        this.aGr = i + 1;
        return bArr[i];
    }

    public final byte[] cs(int i) {
        if (i < 0) {
            throw b.bQN();
        } else if ((this.pMo + this.aGr) + i > this.aGt) {
            ct((this.aGt - this.pMo) - this.aGr);
            throw b.bQM();
        } else if (i <= this.aGp - this.aGr) {
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.aGr, obj, 0, i);
            this.aGr += i;
            return obj;
        } else if (i < 2048) {
            Object obj2 = new byte[i];
            r0 = this.aGp - this.aGr;
            System.arraycopy(this.buffer, this.aGr, obj2, 0, r0);
            this.aGr = this.aGp;
            kJ(true);
            while (i - r0 > this.aGp) {
                System.arraycopy(this.buffer, 0, obj2, r0, this.aGp);
                r0 += this.aGp;
                this.aGr = this.aGp;
                kJ(true);
            }
            System.arraycopy(this.buffer, 0, obj2, r0, i - r0);
            this.aGr = i - r0;
            return obj2;
        } else {
            int read;
            int i2 = this.aGr;
            int i3 = this.aGp;
            this.pMo += this.aGp;
            this.aGr = 0;
            this.aGp = 0;
            r0 = i - (i3 - i2);
            LinkedList linkedList = new LinkedList();
            int i4 = r0;
            while (i4 > 0) {
                Object obj3 = new byte[Math.min(i4, 2048)];
                r0 = 0;
                while (r0 < obj3.length) {
                    read = this.pMn == null ? -1 : this.pMn.read(obj3, r0, obj3.length - r0);
                    if (read == -1) {
                        throw b.bQM();
                    }
                    this.pMo += read;
                    r0 += read;
                }
                r0 = i4 - obj3.length;
                linkedList.add(obj3);
                i4 = r0;
            }
            Object obj4 = new byte[i];
            r0 = i3 - i2;
            System.arraycopy(this.buffer, i2, obj4, 0, r0);
            int i5 = r0;
            for (read = 0; read < linkedList.size(); read++) {
                byte[] bArr = (byte[]) linkedList.get(read);
                System.arraycopy(bArr, 0, obj4, i5, bArr.length);
                i5 += bArr.length;
            }
            return obj4;
        }
    }

    private void ct(int i) {
        if (i < 0) {
            throw b.bQN();
        } else if ((this.pMo + this.aGr) + i > this.aGt) {
            ct((this.aGt - this.pMo) - this.aGr);
            throw b.bQM();
        } else if (i < this.aGp - this.aGr) {
            this.aGr += i;
        } else {
            int i2 = this.aGp - this.aGr;
            this.pMo += i2;
            this.aGr = 0;
            this.aGp = 0;
            int i3 = i2;
            while (i3 < i) {
                i2 = this.pMn == null ? -1 : (int) this.pMn.skip((long) (i - i3));
                if (i2 <= 0) {
                    throw b.bQM();
                }
                i3 += i2;
                this.pMo = i2 + this.pMo;
            }
        }
    }
}
