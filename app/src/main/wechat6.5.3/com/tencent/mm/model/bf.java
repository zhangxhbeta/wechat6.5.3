package com.tencent.mm.model;

import com.tencent.mm.a.e;
import com.tencent.mm.ba.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.ajj;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class bf {
    public int bBZ = 0;
    public int bCi = 0;
    public String bCj = SQLiteDatabase.KeyEmpty;
    public String bCo = SQLiteDatabase.KeyEmpty;
    public String bfd = SQLiteDatabase.KeyEmpty;
    private String cvc = SQLiteDatabase.KeyEmpty;
    private String cvd = SQLiteDatabase.KeyEmpty;
    public String cve = SQLiteDatabase.KeyEmpty;
    public String cvf = SQLiteDatabase.KeyEmpty;

    private static class a {
        public static boolean L(String str, String str2) {
            if (be.kS(str)) {
                return true;
            }
            String decode = decode(encode(str));
            if (be.kS(decode) || !decode.equals(str2)) {
                return true;
            }
            return false;
        }

        private static String encode(String str) {
            char[] toCharArray = str.toCharArray();
            String str2 = SQLiteDatabase.KeyEmpty;
            try {
                int length = toCharArray.length;
                String str3 = str2;
                int i = 0;
                while (i < length) {
                    char c = toCharArray[i];
                    i++;
                    str3 = str3 + String.format("%02x", new Object[]{Integer.valueOf(c)});
                }
                return str3;
            } catch (Exception e) {
                return SQLiteDatabase.KeyEmpty;
            }
        }

        private static String decode(String str) {
            String str2 = SQLiteDatabase.KeyEmpty;
            if (be.kS(str) || str.length() % 2 != 0) {
                return SQLiteDatabase.KeyEmpty;
            }
            String str3 = str2;
            int i = 0;
            while (i < str.length()) {
                try {
                    String str4 = str3 + ((char) Integer.parseInt(str.substring(i, i + 2), 16));
                    i += 2;
                    str3 = str4;
                } catch (Exception e) {
                    return SQLiteDatabase.KeyEmpty;
                }
            }
            return str3;
        }
    }

    public static bf zO() {
        bf bfVar = new bf();
        bfVar.bCi = 1;
        bfVar.bBZ = be.a((Integer) g.vw().vf().get(12290, null), 0);
        bfVar.cvc = (String) g.vw().vf().get(12293, null);
        bfVar.cvd = (String) g.vw().vf().get(12292, null);
        bfVar.bCj = (String) g.vw().vf().get(12291, null);
        bfVar.bCo = (String) g.vw().vf().get(12307, null);
        bfVar.bfd = (String) g.vw().vf().get(12324, null);
        bfVar.cvf = (String) g.vw().vf().get(12325, null);
        bfVar.cve = (String) g.vw().vf().get(12326, null);
        return bfVar;
    }

    public static bf zP() {
        if (be.a((Integer) g.vw().vf().get(12289, null), 0) == 0) {
            return null;
        }
        return zO();
    }

    public static ajj a(bf bfVar) {
        g.vw().vf().set(12289, Integer.valueOf(bfVar.bCi));
        g.vw().vf().set(12290, Integer.valueOf(bfVar.bBZ));
        if (a.L((String) g.vw().vf().get(12293, null), bfVar.getProvince())) {
            g.vw().vf().set(12293, bfVar.getProvince());
        }
        if (a.L((String) g.vw().vf().get(12292, null), bfVar.getCity())) {
            g.vw().vf().set(12292, bfVar.getCity());
        }
        if (a.L((String) g.vw().vf().get(12291, null), bfVar.bCj)) {
            g.vw().vf().set(12291, bfVar.bCj);
        }
        if (a.L((String) g.vw().vf().get(12307, null), bfVar.bCo)) {
            g.vw().vf().set(12307, bfVar.bCo);
        }
        if (a.L((String) g.vw().vf().get(12324, null), bfVar.bfd)) {
            g.vw().vf().set(12324, bfVar.bfd);
        }
        if (a.L((String) g.vw().vf().get(12325, null), bfVar.cvf)) {
            g.vw().vf().set(12325, bfVar.cvf);
        }
        if (a.L((String) g.vw().vf().get(12326, null), bfVar.cve)) {
            g.vw().vf().set(12326, bfVar.cve);
        }
        ajj com_tencent_mm_protocal_c_ajj = new ajj();
        com_tencent_mm_protocal_c_ajj.mJH = FileUtils.S_IWUSR;
        com_tencent_mm_protocal_c_ajj.moM = new arf().JF(SQLiteDatabase.KeyEmpty);
        com_tencent_mm_protocal_c_ajj.mEj = new arf().JF(SQLiteDatabase.KeyEmpty);
        com_tencent_mm_protocal_c_ajj.mar = 0;
        com_tencent_mm_protocal_c_ajj.mJI = new arf().JF(SQLiteDatabase.KeyEmpty);
        com_tencent_mm_protocal_c_ajj.mJJ = new arf().JF(SQLiteDatabase.KeyEmpty);
        com_tencent_mm_protocal_c_ajj.eeO = 0;
        byte[] c = e.c(SQLiteDatabase.KeyEmpty, 0, -1);
        com_tencent_mm_protocal_c_ajj.mJF = new b(c == null ? new byte[0] : c);
        com_tencent_mm_protocal_c_ajj.mJE = c == null ? 0 : c.length;
        com_tencent_mm_protocal_c_ajj.cHc = bfVar.bBZ;
        com_tencent_mm_protocal_c_ajj.cHg = bfVar.bCi;
        com_tencent_mm_protocal_c_ajj.cHf = be.ma(bfVar.bCj);
        com_tencent_mm_protocal_c_ajj.cHe = be.ma(bfVar.cve);
        com_tencent_mm_protocal_c_ajj.cHd = be.ma(bfVar.cvf);
        com_tencent_mm_protocal_c_ajj.mau = 0;
        com_tencent_mm_protocal_c_ajj.mFw = be.ma(bfVar.bCo);
        com_tencent_mm_protocal_c_ajj.mJO = 0;
        com_tencent_mm_protocal_c_ajj.cHh = SQLiteDatabase.KeyEmpty;
        com_tencent_mm_protocal_c_ajj.mFy = 0;
        com_tencent_mm_protocal_c_ajj.mFx = SQLiteDatabase.KeyEmpty;
        com_tencent_mm_protocal_c_ajj.cHl = be.ma(bfVar.bfd);
        return com_tencent_mm_protocal_c_ajj;
    }

    public final String getCity() {
        if (!be.kS(this.bfd)) {
            if (be.kS(this.cvf)) {
                this.cvd = SQLiteDatabase.KeyEmpty;
            } else if (be.kS(this.cve)) {
                this.cvd = RegionCodeDecoder.bxc().dP(this.bfd, this.cvf);
            } else {
                this.cvd = RegionCodeDecoder.bxc().Z(this.bfd, this.cvf, this.cve);
            }
        }
        if (be.kS(this.cvd)) {
            return be.ma(this.cve);
        }
        return this.cvd;
    }

    public final String getProvince() {
        if (!be.kS(this.bfd)) {
            if (be.kS(this.cvf) || be.kS(this.cve) || !RegionCodeDecoder.Nn(this.bfd)) {
                this.cvc = RegionCodeDecoder.bxc().No(this.bfd);
            } else {
                this.cvc = RegionCodeDecoder.bxc().dP(this.bfd, this.cvf);
            }
        }
        return be.kS(this.cvc) ? be.ma(this.cvf) : this.cvc;
    }
}
