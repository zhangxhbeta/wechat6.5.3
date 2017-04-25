package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.mm.protocal.c.aqq;
import com.tencent.mm.protocal.c.aqs;
import com.tencent.mm.protocal.c.aqt;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;

final class e {
    private static boolean j(String str, Map<String, String> map) {
        if (map.get(str) == null && map.get(str + ".resType") == null && map.get(str + ".subType") == null) {
            return true;
        }
        return false;
    }

    static void e(String str, String str2, Map<String, String> map) {
        if (!j(String.format("%s.%s", new Object[]{str, str2}), map)) {
            int f = f(str, str2, map) | 0;
            int i = 0;
            while (true) {
                i++;
                if (j(String.format("%s.%s%d", new Object[]{str, str2, Integer.valueOf(i)}), map)) {
                    break;
                }
                f |= f(str, str2, map);
            }
            i = b.Hb(str2);
            if (b.tJ(i)) {
                j.q(0, 32);
                if (f == 0) {
                    j.q(0, 33);
                }
            } else if (b.tK(i)) {
                j.q(0, 35);
                if (f == 0) {
                    j.q(0, 36);
                }
            } else if (b.tL(i)) {
                j.q(0, 38);
                if (f == 0) {
                    j.q(0, 39);
                }
            }
        }
    }

    private static boolean f(String str, String str2, Map<String, String> map) {
        String format = String.format("%s.%s.%s", new Object[]{str, str2, "Resource"});
        int Hb = b.Hb(str2);
        if (j(format, map)) {
            return true;
        }
        boolean a = a(Hb, format, map) | 0;
        int i = 0;
        while (true) {
            i++;
            String format2 = String.format("%s.%s.%s%d", new Object[]{str, str2, "Resource", Integer.valueOf(i)});
            if (j(format2, map)) {
                return a;
            }
            a |= a(Hb, format2, map);
        }
    }

    private static boolean a(int i, String str, Map<String, String> map) {
        if (map.get(str + ".resType") == null && map.get(str + ".subType") == null) {
            return true;
        }
        int i2;
        int i3;
        aqq com_tencent_mm_protocal_c_aqq;
        if (b.tL(i)) {
            v.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDelete()");
            i2 = be.getInt((String) map.get(str + ".resType"), -1);
            i3 = be.getInt((String) map.get(str + ".subType"), -1);
            if (-1 == i2 || -1 == i3) {
                return false;
            }
            com_tencent_mm_protocal_c_aqq = new aqq();
            com_tencent_mm_protocal_c_aqq.mNI = i3;
            com_tencent_mm_protocal_c_aqq.mPV = new aqt();
            com_tencent_mm_protocal_c_aqq.mPV.mQe = be.getInt((String) map.get(str + ".resVer"), 0);
            com_tencent_mm_protocal_c_aqq.mPX = (String) map.get(str + ".sampleID");
            com_tencent_mm_protocal_c_aqq.jho = be.getInt((String) map.get(str + ".reportID"), 0);
            com_tencent_mm_protocal_c_aqq.myO = b.DoDelete.bkU;
            b.lDs.a(i2, com_tencent_mm_protocal_c_aqq, true);
            j.q((long) com_tencent_mm_protocal_c_aqq.jho, 40);
            return true;
        } else if (b.tJ(i)) {
            v.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceCache()");
            String str2 = (String) map.get(str + ".CDNUrl");
            int i4 = be.getInt((String) map.get(str + ".subType"), -1);
            int i5 = be.getInt((String) map.get(str + ".resType"), -1);
            String str3 = (String) map.get(str + ".md5");
            int i6 = be.getInt((String) map.get(str + ".priority"), 0);
            if (be.kS(str2) || be.kS(str3) || -1 == i4 || -1 == i5 || i6 < 0) {
                return false;
            }
            int bnT;
            aqq com_tencent_mm_protocal_c_aqq2 = new aqq();
            com_tencent_mm_protocal_c_aqq2.mPV = new aqt();
            if (be.getInt((String) map.get(str + ".fileEncrypt"), 0) > 0) {
                bnT = a.bnT();
            } else {
                bnT = 0;
            }
            if (be.getInt((String) map.get(str + ".fileCompress"), 0) > 0) {
                bnT = a.tH(bnT);
            }
            com_tencent_mm_protocal_c_aqq2.mNI = i4;
            com_tencent_mm_protocal_c_aqq2.mPZ = be.getInt((String) map.get(str + ".networkType"), 2);
            com_tencent_mm_protocal_c_aqq2.mjt = be.getInt((String) map.get(str + ".expireTime"), 1);
            com_tencent_mm_protocal_c_aqq2.mPV.glb = str2;
            com_tencent_mm_protocal_c_aqq2.mPV.mQe = be.getInt((String) map.get(str + ".resVer"), 0);
            com_tencent_mm_protocal_c_aqq2.mPV.mpI = str3;
            com_tencent_mm_protocal_c_aqq2.mPV.mQi = (String) map.get(str + ".originalmd5");
            com_tencent_mm_protocal_c_aqq2.mPV.mQf = bnT;
            com_tencent_mm_protocal_c_aqq2.mPV.mQg = null;
            com_tencent_mm_protocal_c_aqq2.mPV.mQh = null;
            com_tencent_mm_protocal_c_aqq2.mDr = i6;
            com_tencent_mm_protocal_c_aqq2.myO = b.DoCache.bkU;
            com_tencent_mm_protocal_c_aqq2.jho = be.getInt((String) map.get(str + ".reportID"), 0);
            com_tencent_mm_protocal_c_aqq2.mPX = (String) map.get(str + ".sampleID");
            com_tencent_mm_protocal_c_aqq2.mPY = be.getInt((String) map.get(str + ".retryTime"), 3);
            com_tencent_mm_protocal_c_aqq2.mQa = be.getInt((String) map.get(str + ".retryInterval"), 0);
            com_tencent_mm_protocal_c_aqq2.lDw = 0;
            b.lDs.b(i5, com_tencent_mm_protocal_c_aqq2, true);
            j.q((long) com_tencent_mm_protocal_c_aqq2.jho, 34);
            return true;
        } else if (!b.tK(i)) {
            return false;
        } else {
            v.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDecrypt()");
            i2 = be.getInt((String) map.get(str + ".resType"), -1);
            i3 = be.getInt((String) map.get(str + ".subType"), -1);
            if (-1 == i2 || -1 == i3) {
                return false;
            }
            com_tencent_mm_protocal_c_aqq = new aqq();
            com_tencent_mm_protocal_c_aqq.mPW = new aqs();
            com_tencent_mm_protocal_c_aqq.mNI = i3;
            com_tencent_mm_protocal_c_aqq.mPW.mQd = (String) map.get(str + ".resKey");
            com_tencent_mm_protocal_c_aqq.mPW.mQc = be.getInt((String) map.get(str + ".resKeyVersion"), 0);
            com_tencent_mm_protocal_c_aqq.mPX = (String) map.get(str + ".sampleID");
            com_tencent_mm_protocal_c_aqq.jho = be.getInt((String) map.get(str + ".reportID"), 0);
            com_tencent_mm_protocal_c_aqq.myO = b.DoDecrypt.bkU;
            com_tencent_mm_protocal_c_aqq.mPV = new aqt();
            com_tencent_mm_protocal_c_aqq.mPV.mQi = (String) map.get(str + ".originalmd5");
            b.lDs.c(i2, com_tencent_mm_protocal_c_aqq, true);
            j.q((long) com_tencent_mm_protocal_c_aqq.jho, 37);
            return true;
        }
    }
}
