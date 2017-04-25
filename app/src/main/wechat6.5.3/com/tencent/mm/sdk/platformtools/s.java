package com.tencent.mm.sdk.platformtools;

import com.tencent.mmdb.database.SQLiteDatabase;
import java.nio.ByteBuffer;

public final class s {
    private ByteBuffer nii;
    private boolean nij;

    public final int bg(byte[] bArr) {
        boolean z = (bArr == null || bArr.length == 0) ? true : bArr[0] != (byte) 123 ? true : bArr[bArr.length + -1] != (byte) 125 ? true : false;
        if (z) {
            this.nii = null;
            return -1;
        }
        this.nii = ByteBuffer.wrap(bArr);
        this.nii.position(1);
        this.nij = false;
        return 0;
    }

    public final int getInt() {
        if (!this.nij) {
            return this.nii.getInt();
        }
        throw new Exception("Buffer For Build");
    }

    public final long getLong() {
        if (!this.nij) {
            return this.nii.getLong();
        }
        throw new Exception("Buffer For Build");
    }

    public final byte[] getBuffer() {
        if (this.nij) {
            throw new Exception("Buffer For Build");
        }
        short s = this.nii.getShort();
        if (s > (short) 2048) {
            this.nii = null;
            throw new Exception("Buffer String Length Error");
        } else if (s == (short) 0) {
            return new byte[0];
        } else {
            byte[] bArr = new byte[s];
            this.nii.get(bArr, 0, s);
            return bArr;
        }
    }

    public final String getString() {
        if (this.nij) {
            throw new Exception("Buffer For Build");
        }
        short s = this.nii.getShort();
        if (s > (short) 2048) {
            this.nii = null;
            throw new Exception("Buffer String Length Error");
        } else if (s == (short) 0) {
            return SQLiteDatabase.KeyEmpty;
        } else {
            byte[] bArr = new byte[s];
            this.nii.get(bArr, 0, s);
            return new String(bArr, "UTF-8");
        }
    }

    public final void uW(int i) {
        this.nii.position(this.nii.position() + i);
    }

    public final void bsQ() {
        if (this.nij) {
            throw new Exception("Buffer For Build");
        }
        short s = this.nii.getShort();
        if (s > (short) 2048) {
            this.nii = null;
            throw new Exception("Buffer String Length Error");
        } else if (s != (short) 0) {
            this.nii.position(s + this.nii.position());
        }
    }

    public final boolean bsR() {
        return this.nii.limit() - this.nii.position() <= 1;
    }

    public final int bsS() {
        this.nii = ByteBuffer.allocate(4096);
        this.nii.put((byte) 123);
        this.nij = true;
        return 0;
    }

    private int uX(int i) {
        if (this.nii.limit() - this.nii.position() <= i) {
            ByteBuffer allocate = ByteBuffer.allocate(this.nii.limit() + 4096);
            allocate.put(this.nii.array(), 0, this.nii.position());
            this.nii = allocate;
        }
        return 0;
    }

    public final int uY(int i) {
        if (this.nij) {
            uX(4);
            this.nii.putInt(i);
            return 0;
        }
        throw new Exception("Buffer For Parse");
    }

    public final int dY(long j) {
        if (this.nij) {
            uX(8);
            this.nii.putLong(j);
            return 0;
        }
        throw new Exception("Buffer For Parse");
    }

    public final int bh(byte[] bArr) {
        if (this.nij) {
            byte[] bArr2 = null;
            if (bArr != null) {
                bArr2 = bArr;
            }
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            if (bArr2.length > 2048) {
                throw new Exception("Buffer String Length Error");
            }
            uX(bArr2.length + 2);
            this.nii.putShort((short) bArr2.length);
            if (bArr2.length > 0) {
                this.nii.put(bArr2);
            }
            return 0;
        }
        throw new Exception("Buffer For Parse");
    }

    public final int Kc(String str) {
        if (this.nij) {
            byte[] bArr = null;
            if (str != null) {
                bArr = str.getBytes();
            }
            if (bArr == null) {
                bArr = new byte[0];
            }
            if (bArr.length > 2048) {
                throw new Exception("Buffer String Length Error");
            }
            uX(bArr.length + 2);
            this.nii.putShort((short) bArr.length);
            if (bArr.length > 0) {
                this.nii.put(bArr);
            }
            return 0;
        }
        throw new Exception("Buffer For Parse");
    }

    public final byte[] bsT() {
        if (this.nij) {
            uX(1);
            this.nii.put((byte) 125);
            Object obj = new byte[this.nii.position()];
            System.arraycopy(this.nii.array(), 0, obj, 0, obj.length);
            return obj;
        }
        throw new Exception("Buffer For Parse");
    }
}
