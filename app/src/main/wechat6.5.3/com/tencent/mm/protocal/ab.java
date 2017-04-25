package com.tencent.mm.protocal;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.mm.a.g;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;

public final class ab {

    public static class a extends c implements com.tencent.mm.protocal.l.a {
        public byte[] cRq = new byte[0];
        public byte[] cjG;
        public int lWW;
        public int netType;
        public int uin = 0;

        public final void cW(int i) {
            this.uin = i;
        }

        public final byte[] zf() {
            String str = "MicroMsg.MMSyncCheck";
            String str2 = "toProtoBuf dksynccheck uin:%d keybuf:%d, stack[%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(this.uin);
            objArr[1] = Integer.valueOf(this.cRq == null ? -1 : this.cRq.length);
            objArr[2] = be.bur();
            v.d(str, str2, objArr);
            if (this.uin == 0 || be.bl(this.cRq)) {
                return new byte[0];
            }
            int length = (((this.uin >> 13) & 524287) | (this.cRq.length << 19)) ^ 1442968193;
            int length2 = 1442968193 ^ (((this.cRq.length >> 13) & 524287) | (this.uin << 19));
            Object obj = new byte[(this.cRq.length + 32)];
            v.d("MicroMsg.MMSyncCheck", "dksynccheck uin=[%d/%d], keyBufLen=[%d/%d] outBuf=[%d]", Integer.valueOf(this.uin), Integer.valueOf(length), Integer.valueOf(this.cRq.length), Integer.valueOf(length2), Integer.valueOf(obj.length));
            obj[0] = (byte) ((length >> 24) & WebView.NORMAL_MODE_ALPHA);
            obj[1] = (byte) ((length >> 16) & WebView.NORMAL_MODE_ALPHA);
            obj[2] = (byte) ((length >> 8) & WebView.NORMAL_MODE_ALPHA);
            obj[3] = (byte) (length & WebView.NORMAL_MODE_ALPHA);
            obj[4] = (byte) ((length2 >> 24) & WebView.NORMAL_MODE_ALPHA);
            obj[5] = (byte) ((length2 >> 16) & WebView.NORMAL_MODE_ALPHA);
            obj[6] = (byte) ((length2 >> 8) & WebView.NORMAL_MODE_ALPHA);
            obj[7] = (byte) (length2 & WebView.NORMAL_MODE_ALPHA);
            System.arraycopy(this.cRq, 0, obj, 8, this.cRq.length);
            obj[obj.length - 24] = (byte) ((d.lWh >> 24) & WebView.NORMAL_MODE_ALPHA);
            obj[obj.length - 23] = (byte) ((d.lWh >> 16) & WebView.NORMAL_MODE_ALPHA);
            obj[obj.length - 22] = (byte) ((d.lWh >> 8) & WebView.NORMAL_MODE_ALPHA);
            obj[obj.length - 21] = (byte) (d.lWh & WebView.NORMAL_MODE_ALPHA);
            String locale = Locale.getDefault().toString();
            if (locale.length() > 8) {
                locale = locale.substring(0, 8);
            }
            Object bytes = locale.getBytes();
            System.arraycopy(bytes, 0, obj, obj.length - 20, bytes.length);
            v.d("MicroMsg.MMSyncCheck", "language:%x" + Arrays.toString(bytes));
            obj[obj.length - 12] = null;
            obj[obj.length - 11] = null;
            obj[obj.length - 10] = null;
            obj[obj.length - 9] = 2;
            obj[obj.length - 8] = (byte) ((this.netType >> 24) & WebView.NORMAL_MODE_ALPHA);
            obj[obj.length - 7] = (byte) ((this.netType >> 16) & WebView.NORMAL_MODE_ALPHA);
            obj[obj.length - 6] = (byte) ((this.netType >> 8) & WebView.NORMAL_MODE_ALPHA);
            obj[obj.length - 5] = (byte) (this.netType & WebView.NORMAL_MODE_ALPHA);
            obj[obj.length - 4] = (byte) ((this.lWW >> 24) & WebView.NORMAL_MODE_ALPHA);
            obj[obj.length - 3] = (byte) ((this.lWW >> 16) & WebView.NORMAL_MODE_ALPHA);
            obj[obj.length - 2] = (byte) ((this.lWW >> 8) & WebView.NORMAL_MODE_ALPHA);
            obj[obj.length - 1] = (byte) (this.lWW & WebView.NORMAL_MODE_ALPHA);
            v.d("MicroMsg.MMSyncCheck", "outbuf:%x" + Arrays.toString(obj));
            this.cjG = g.n(obj);
            return obj;
        }

        public final int zg() {
            return 0;
        }

        public final int getCmdId() {
            return 205;
        }

        public final boolean aRf() {
            return true;
        }

        public final boolean Cd() {
            return false;
        }
    }

    public static class b extends d implements com.tencent.mm.protocal.l.b {
        private String blq = null;
        public byte[] cjG = null;
        public long lXy = 7;
        private byte[] lXz;

        @TargetApi(9)
        public final String brF() {
            if (this.cjG == null) {
                return SQLiteDatabase.KeyEmpty;
            }
            if (this.blq == null) {
                byte[] aesDecrypt = MMProtocalJni.aesDecrypt(this.lXz, this.cjG);
                if (be.bl(aesDecrypt)) {
                    return SQLiteDatabase.KeyEmpty;
                }
                if (VERSION.SDK_INT >= 9) {
                    this.blq = new String(aesDecrypt, Charset.forName("UTF-8"));
                } else {
                    this.blq = new String(aesDecrypt);
                }
            }
            return this.blq;
        }

        public final int y(byte[] bArr) {
            int i;
            if (bArr == null || bArr.length < 12) {
                String str = "MicroMsg.MMSyncCheck";
                StringBuilder stringBuilder = new StringBuilder("dksynccheck err resp buf:");
                if (bArr == null) {
                    i = -1;
                } else {
                    i = bArr.length;
                }
                v.e(str, stringBuilder.append(i).toString());
                return -1;
            }
            this.lXy = (long) ((((bArr[3] & WebView.NORMAL_MODE_ALPHA) | ((bArr[2] & WebView.NORMAL_MODE_ALPHA) << 8)) | ((bArr[1] & WebView.NORMAL_MODE_ALPHA) << 16)) | ((bArr[0] & WebView.NORMAL_MODE_ALPHA) << 24));
            i = (((bArr[7] & WebView.NORMAL_MODE_ALPHA) | ((bArr[6] & WebView.NORMAL_MODE_ALPHA) << 8)) | ((bArr[5] & WebView.NORMAL_MODE_ALPHA) << 16)) | ((bArr[4] & WebView.NORMAL_MODE_ALPHA) << 24);
            int i2 = (((bArr[11] & WebView.NORMAL_MODE_ALPHA) | ((bArr[10] & WebView.NORMAL_MODE_ALPHA) << 8)) | ((bArr[9] & WebView.NORMAL_MODE_ALPHA) << 16)) | ((bArr[8] & WebView.NORMAL_MODE_ALPHA) << 24);
            v.d("MicroMsg.MMSyncCheck", " fromProtoBuf oreh synccheck resp selector:%d, redCode:%d, keyLen:%d", Long.valueOf(this.lXy), Integer.valueOf(i), Integer.valueOf(i2));
            if (i != -3002) {
                this.blq = SQLiteDatabase.KeyEmpty;
                return i;
            } else if (i2 == bArr.length - 12 || i2 == (bArr.length - 12) - 16) {
                if (i2 == (bArr.length - 12) - 16) {
                    this.cjG = new byte[16];
                    System.arraycopy(bArr, bArr.length - 16, this.cjG, 0, 16);
                }
                this.lXz = new byte[i2];
                System.arraycopy(bArr, 12, this.lXz, 0, i2);
                return i;
            } else {
                v.e("MicroMsg.MMSyncCheck", " the key len is invalid keyLen:%d, bufLen:%d", Integer.valueOf(i2), Integer.valueOf(bArr.length));
                return -1;
            }
        }

        public final int getCmdId() {
            return 1000000205;
        }

        public final boolean aRf() {
            return true;
        }
    }
}
