package com.tencent.mm.protocal;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.List;

public final class o {
    public String gRG = SQLiteDatabase.KeyEmpty;
    public String host = SQLiteDatabase.KeyEmpty;
    private int port = 80;
    private int type = 0;

    public static class a {
        public final int[] lXa = null;
        public final int[] lXb;
        public final int lXc;
        public final int lXd;

        public a(int[] iArr, int i, int i2) {
            this.lXb = iArr;
            this.lXc = i;
            this.lXd = i2;
        }
    }

    public o(int i, String str, int i2, String str2) {
        this.type = i;
        this.gRG = str;
        this.port = i2;
        this.host = str2;
    }

    public final String toString() {
        return this.type + "," + this.gRG + "," + this.port + "," + this.host;
    }

    private static o It(String str) {
        String[] split = str.split(",");
        if (split.length < 4) {
            return null;
        }
        o oVar = new o();
        try {
            oVar.type = be.getInt(split[0], 0);
            oVar.gRG = be.ma(split[1]);
            oVar.port = be.getInt(split[2], 0);
            oVar.host = be.ma(split[3]);
            return oVar;
        } catch (Throwable e) {
            v.e("MicroMsg.MMBuiltInIP", "exception:%s", be.e(e));
            return null;
        }
    }

    public static String bN(List<o> list) {
        String str = SQLiteDatabase.KeyEmpty;
        String str2 = str;
        for (o oVar : list) {
            str2 = str2 + oVar.toString() + "|";
        }
        return str2;
    }

    public static List<o> Iu(String str) {
        List linkedList = new LinkedList();
        if (!be.kS(str)) {
            try {
                for (String It : str.split("\\|")) {
                    o It2 = It(It);
                    if (It2 != null) {
                        linkedList.add(It2);
                    }
                }
            } catch (Throwable e) {
                v.d("MicroMsg.MMBuiltInIP", "unserialize split failed str[%s]", str);
                v.e("MicroMsg.MMBuiltInIP", "exception:%s", be.e(e));
            }
        }
        return linkedList;
    }

    public static a dv(String str, String str2) {
        v.d("MicroMsg.MMBuiltInIP", "parsing network control params:");
        v.d("MicroMsg.MMBuiltInIP", "ports = " + str);
        v.d("MicroMsg.MMBuiltInIP", "timeouts = " + str2);
        int[] KH = be.KH(str);
        int[] KH2 = be.KH(str2);
        if (KH2 == null || KH2.length < 2) {
            KH2 = new int[]{0, 0};
            v.e("MicroMsg.MMBuiltInIP", "invalid timeouts");
        }
        return new a(KH, (int) (((long) KH2[0]) * 1000), (int) (((long) KH2[1]) * 1000));
    }
}
