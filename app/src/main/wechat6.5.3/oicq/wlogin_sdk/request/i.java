package oicq.wlogin_sdk.request;

import android.content.Context;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.security.SecureRandom;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public final class i {
    public static byte[] pNi = new byte[0];
    public long _uin = 0;
    public Context pMF = null;
    public SecureRandom pMX = new SecureRandom();
    public byte[] pMY = util.bRe();
    public byte[] pMZ = null;
    c pNA = null;
    public byte[] pNa = new byte[16];
    public f pNb = new f();
    public g pNc = new g();
    public long pNd = 0;
    public int pNe = 0;
    public long pNf = -1;
    public int pNg = 0;
    byte[] pNh = new byte[0];
    byte[] pNj = new byte[0];
    int pNk = 0;
    byte[] pNl = new byte[0];
    byte[] pNm = new byte[0];
    byte[] pNn = new byte[0];
    byte[] pNo = new byte[0];
    byte[] pNp = new byte[0];
    byte[] pNq = new byte[0];
    int pNr = 0;
    int pNs = 0;
    int pNt = 0;
    int pNu = 0;
    byte[] pNv = new byte[0];
    ErrMsg pNw = new ErrMsg();
    byte[] pNx = new byte[0];
    byte[] pNy = new byte[4];
    byte[] pNz = new byte[0];

    public static long bQV() {
        return System.currentTimeMillis() / 1000;
    }

    public final synchronized int a(long j, long j2, long j3, long j4, long j5, long j6, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, byte[] bArr12, byte[] bArr13, byte[] bArr14, byte[] bArr15, byte[] bArr16, byte[][] bArr17) {
        util.Rc("put siginfo:" + j + "," + j2 + "," + j3 + "," + j4 + "," + j5 + "," + j6 + "," + util.bQ(bArr) + "," + util.bQ(bArr2) + "," + util.bQ(bArr3) + "," + util.bQ(bArr4) + "," + util.bQ(bArr5) + "," + util.bQ(bArr6) + "," + util.bQ(bArr7) + "," + util.bQ(bArr8) + "," + util.bQ(bArr9) + "," + util.bQ(bArr10) + "," + util.bQ(bArr11) + "," + util.bQ(bArr12) + "," + util.bQ(bArr13) + "," + util.bQ(bArr14) + "," + util.bQ(bArr15) + "," + util.bQ(bArr16));
        String str = SQLiteDatabase.KeyEmpty;
        for (int i = 0; i < bArr17.length; i++) {
            str = new StringBuilder(String.valueOf(str)).append(String.format("reserve[%d]: %d ", new Object[]{Integer.valueOf(i), Long.valueOf(util.bQ(bArr17[i]))})).toString();
        }
        util.Rc("reserve:" + str);
        return this.pNA.a(j, j2, j3, j4, j5, j6, bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13, bArr14, bArr15, bArr16, bArr17);
    }

    public final synchronized WloginSigInfo t(long j, long j2) {
        WloginSigInfo t;
        util.eo("get_siginfo", "uin=" + j + "appid=522017402");
        t = this.pNA.t(j, 522017402);
        if (t != null) {
        }
        return t;
    }

    public final synchronized void h(Long l) {
        this.pNA.h(l);
    }
}
