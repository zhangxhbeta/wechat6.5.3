package com.tencent.mm.protocal;

import com.tencent.mm.a.g;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class p {

    public static class a extends c implements com.tencent.mm.protocal.l.a {
        public int bdn = 0;
        public int bkU = 0;
        public int cZF = 0;
        public String lXe = SQLiteDatabase.KeyEmpty;
        public byte[] lXf = new byte[0];

        private byte[] brE() {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeInt(this.cZF);
                dataOutputStream.writeShort(this.lXe.getBytes().length);
                dataOutputStream.write(this.lXe.getBytes());
                dataOutputStream.writeShort(this.lXf.length);
                dataOutputStream.write(this.lXf);
                dataOutputStream.close();
            } catch (IOException e) {
                v.e("MicroMsg.MMDirectSend", "direct merge tail failed, err=" + e.getMessage());
            }
            return byteArrayOutputStream.toByteArray();
        }

        private byte[] aW(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeByte(this.bdn);
                dataOutputStream.writeByte(this.bkU);
                dataOutputStream.write(bArr);
                dataOutputStream.close();
            } catch (IOException e) {
                v.e("MicroMsg.MMDirectSend", "direct merge all failed, err=" + e.getMessage());
            }
            return byteArrayOutputStream.toByteArray();
        }

        public final byte[] zf() {
            byte[] brE = brE();
            PByteArray pByteArray = new PByteArray();
            com.tencent.mm.a.c.a(pByteArray, brE, p.Iv(this.lWP));
            return aW(pByteArray.value);
        }

        public final int zg() {
            return 10;
        }

        public final int getCmdId() {
            return 8;
        }

        public final boolean aRf() {
            return true;
        }

        public final boolean Cd() {
            return false;
        }
    }

    public static class b extends d implements com.tencent.mm.protocal.l.b {
        private int bdn;
        private int bkU;
        public String cYw;
        private int cZF;
        public byte[] content;
        public String deviceID;

        public b() {
            this.cYw = SQLiteDatabase.KeyEmpty;
            this.content = new byte[0];
            this.deviceID = SQLiteDatabase.KeyEmpty;
            this.bdn = 0;
            this.bkU = 0;
            this.cZF = 0;
            this.cYw = SQLiteDatabase.KeyEmpty;
            this.content = new byte[0];
        }

        public final int getCmdId() {
            return 8;
        }

        public final boolean aRf() {
            return true;
        }

        private byte[] aX(byte[] bArr) {
            if (bArr == null || bArr.length < 2) {
                v.e("MicroMsg.MMDirectSend", "parse all failed, empty buf");
                return null;
            }
            byte[] bArr2 = new byte[(bArr.length - 2)];
            try {
                InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
                this.bdn = dataInputStream.readByte();
                this.bkU = dataInputStream.readByte();
                dataInputStream.readFully(bArr2);
                v.d("MicroMsg.MMDirectSend", "cmdId:" + this.bdn + ", flag=" + this.bkU + ", tail len=" + bArr2.length);
                byteArrayInputStream.close();
                return bArr2;
            } catch (IOException e) {
                v.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + e.getMessage());
                return bArr2;
            }
        }

        public final int y(byte[] bArr) {
            byte[] Iv = p.Iv(this.deviceID);
            PByteArray pByteArray = new PByteArray();
            if (com.tencent.mm.a.c.b(pByteArray, aX(bArr), Iv) != 0) {
                byte[] bArr2 = new byte[16];
                for (int i = 0; i < 16; i++) {
                    bArr2[i] = (byte) 0;
                }
                if (com.tencent.mm.a.c.b(pByteArray, aX(bArr), bArr2) != 0) {
                    v.e("MicroMsg.MMDirectSend", "decrypting from buffer using key=%s error", be.bk(Iv));
                    return -1;
                }
            }
            byte[] bArr3 = pByteArray.value;
            if (bArr3 == null) {
                v.e("MicroMsg.MMDirectSend", "parse tail failed, empty buf");
                return 0;
            }
            try {
                DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr3));
                this.cZF = dataInputStream.readInt();
                v.d("MicroMsg.MMDirectSend", "seq=" + this.cZF);
                short readShort = dataInputStream.readShort();
                if (readShort < (short) 0) {
                    throw new IOException("sender empty");
                }
                byte[] bArr4 = new byte[readShort];
                dataInputStream.readFully(bArr4);
                this.cYw = new String(bArr4);
                v.d("MicroMsg.MMDirectSend", "recievers len=" + readShort + ", sender=" + this.cYw);
                readShort = dataInputStream.readShort();
                if (readShort < (short) 0) {
                    throw new IOException("content empty");
                }
                this.content = new byte[readShort];
                dataInputStream.readFully(this.content);
                v.d("MicroMsg.MMDirectSend", "content len=" + this.content.length);
                return 0;
            } catch (IOException e) {
                v.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + e.getMessage());
                return 0;
            }
        }
    }

    static /* synthetic */ byte[] Iv(String str) {
        Object obj = new byte[16];
        System.arraycopy(str.getBytes(), 0, obj, 0, 15);
        obj[15] = null;
        v.d("MicroMsg.MMDirectSend", "new direct send: key=%s", be.bk(g.n(obj)));
        return g.n(obj);
    }
}
