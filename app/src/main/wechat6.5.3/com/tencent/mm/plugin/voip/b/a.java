package com.tencent.mm.plugin.voip.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.protocal.c.axt;
import com.tencent.mm.protocal.c.beg;
import com.tencent.mm.protocal.c.beh;
import com.tencent.mm.protocal.c.bfy;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.BufferedOutputStream;
import java.net.InetAddress;

public final class a {
    public static boolean kzO = false;
    static BufferedOutputStream kzP = null;

    public static int getNetType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 2;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 4;
            }
            if (activeNetworkInfo.getType() != 0) {
                return 2;
            }
            if (activeNetworkInfo.getSubtype() == 1) {
                return 1;
            }
            if (activeNetworkInfo.getSubtype() == 2) {
                return 1;
            }
            if (activeNetworkInfo.getSubtype() == 13) {
                return 5;
            }
            if ((activeNetworkInfo.getSubtype() < 3 || activeNetworkInfo.getSubtype() >= 13) && activeNetworkInfo.getSubtype() <= 13) {
                return 1;
            }
            return 3;
        } catch (Throwable e) {
            v.a("MicroMsg.Voip", e, "", new Object[0]);
            return 2;
        }
    }

    public static boolean bdu() {
        if (kzO || getNetType(aa.getContext()) == 1) {
            return true;
        }
        return false;
    }

    private static void CP(String str) {
        if (kzP != null) {
            try {
                kzP.write(str.getBytes());
            } catch (Throwable e) {
                v.a("MicroMsg.Voip", e, "", new Object[0]);
            }
        }
    }

    public static void bdv() {
        if (kzP != null) {
            try {
                kzP.flush();
            } catch (Throwable e) {
                v.a("MicroMsg.Voip", e, "", new Object[0]);
            }
        }
    }

    public static int aM(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        while (i < 4) {
            i2 |= (bArr[i] & 255) << (i * 8);
            i++;
        }
        return i2;
    }

    public static byte[] rS(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) (i >>> (i2 * 8));
        }
        return bArr;
    }

    public static void cR(String str, String str2) {
        v.e(str, "[" + Thread.currentThread().getId() + "]" + str2);
        CP(str + ":" + str2 + " \n");
    }

    public static void cS(String str, String str2) {
        v.i(str, "[" + Thread.currentThread().getId() + "]" + str2);
        CP(str + ":" + str2 + " \n");
    }

    public static void cT(String str, String str2) {
        v.d(str, "[" + Thread.currentThread().getId() + "]" + str2);
        CP(str + ":" + str2 + " \n");
    }

    public static void cU(String str, String str2) {
        v.w(str, "[" + Thread.currentThread().getId() + "]" + str2);
        CP(str + ":" + str2 + " \n");
    }

    public static void a(byte[] bArr, String str, int i) {
        if (be.bl(bArr)) {
            bArr = new byte[0];
        }
        String str2 = new String(bArr);
        if (i == 4) {
            v.e(str, str2);
        } else if (i == 2) {
            v.i(str, str2);
        } else {
            v.d(str, str2);
        }
        if (str.equals("MicroMsg.v2Core")) {
            CP(str + ":" + str2);
        } else {
            CP(str + ":" + str2 + " \n");
        }
    }

    public static void rT(int i) {
        try {
            Thread.sleep((long) i);
        } catch (Throwable e) {
            v.a("MicroMsg.Voip", e, "", new Object[0]);
        }
    }

    public static int[] a(beh com_tencent_mm_protocal_c_beh) {
        int i;
        v.d("MicroMsg.Voip", "convertSvrAddr: voipAddr.Cnt " + com_tencent_mm_protocal_c_beh.naa);
        if (3 >= com_tencent_mm_protocal_c_beh.naa) {
            i = com_tencent_mm_protocal_c_beh.naa;
        } else {
            i = 3;
        }
        v.d("MicroMsg.Voip", "convertSvrAddr: addrCnt " + i);
        int[] iArr = new int[(i * 2)];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2 * 2] = ((beg) com_tencent_mm_protocal_c_beh.nab.get(i2)).mWf;
            iArr[(i2 * 2) + 1] = ((beg) com_tencent_mm_protocal_c_beh.nab.get(i2)).mNM;
            v.d("MicroMsg.Voip", "convertSvrAddr: ip " + rU(((beg) com_tencent_mm_protocal_c_beh.nab.get(i2)).mWf) + " Port: " + ((beg) com_tencent_mm_protocal_c_beh.nab.get(i2)).mNM);
        }
        return iArr;
    }

    public static int[] a(bfy com_tencent_mm_protocal_c_bfy) {
        int i;
        v.d("MicroMsg.Voip", "convertSpeedTestPara: testID= " + com_tencent_mm_protocal_c_bfy.nbz + " SvrListCnt= " + com_tencent_mm_protocal_c_bfy.nbE);
        if (3 >= com_tencent_mm_protocal_c_bfy.nbE) {
            i = com_tencent_mm_protocal_c_bfy.nbE;
        } else {
            i = 3;
        }
        int[] iArr = new int[(i * 6)];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2 * 6] = ((axt) com_tencent_mm_protocal_c_bfy.nbF.get(i2)).mUM.mWf;
            iArr[(i2 * 6) + 1] = ((axt) com_tencent_mm_protocal_c_bfy.nbF.get(i2)).mUM.mNM;
            iArr[(i2 * 6) + 2] = ((axt) com_tencent_mm_protocal_c_bfy.nbF.get(i2)).mUL;
            iArr[(i2 * 6) + 3] = ((axt) com_tencent_mm_protocal_c_bfy.nbF.get(i2)).mVh;
            iArr[(i2 * 6) + 4] = ((axt) com_tencent_mm_protocal_c_bfy.nbF.get(i2)).mVi;
            iArr[(i2 * 6) + 5] = ((axt) com_tencent_mm_protocal_c_bfy.nbF.get(i2)).mVj;
            v.d("MicroMsg.Voip", "convertSpeedTestPara: ip " + rU(((axt) com_tencent_mm_protocal_c_bfy.nbF.get(i2)).mUM.mWf) + " Port: " + ((axt) com_tencent_mm_protocal_c_bfy.nbF.get(i2)).mUM.mNM + " TestCnt= " + ((axt) com_tencent_mm_protocal_c_bfy.nbF.get(i2)).mUL + " TestGap= " + ((axt) com_tencent_mm_protocal_c_bfy.nbF.get(i2)).mVh + " Timeout= " + ((axt) com_tencent_mm_protocal_c_bfy.nbF.get(i2)).mVi + " PktSize= " + ((axt) com_tencent_mm_protocal_c_bfy.nbF.get(i2)).mVj);
        }
        return iArr;
    }

    private static String rU(int i) {
        try {
            return InetAddress.getByAddress(new byte[]{(byte) ((i >>> 24) & 255), (byte) ((i >>> 16) & 255), (byte) ((i >>> 8) & 255), (byte) (i & 255)}).getHostAddress();
        } catch (Throwable e) {
            v.a("MicroMsg.Voip", e, "", new Object[0]);
            return null;
        }
    }
}
