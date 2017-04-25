package com.tencent.mm.model;

import android.os.SystemClock;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.aqi;
import com.tencent.mm.protocal.c.aqj;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import com.tencent.mm.v.u;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public final class ba {

    public static final class a {
        private static long ctO = -1;

        private static void save() {
            Throwable th;
            g.vx();
            File file = new File(g.vw().cachePath, ba.fS("!#?'8/f((6(1$\u001f2*>(s826"));
            if (!file.exists()) {
                file.getParentFile().mkdirs();
            }
            DataOutputStream dataOutputStream = null;
            DataOutputStream dataOutputStream2;
            try {
                dataOutputStream2 = new DataOutputStream(new FileOutputStream(file));
                try {
                    dataOutputStream2.writeLong(ctO);
                    v.i("MicroMsg.NormalMsgReporter", "normsg stat save done.");
                    try {
                        dataOutputStream2.close();
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    try {
                        v.e("MicroMsg.NormalMsgReporter", "normsg stat save failed.");
                        if (dataOutputStream2 != null) {
                            try {
                                dataOutputStream2.close();
                            } catch (Exception e3) {
                            }
                        }
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        dataOutputStream = dataOutputStream2;
                        th = th3;
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e5) {
                dataOutputStream2 = null;
                v.e("MicroMsg.NormalMsgReporter", "normsg stat save failed.");
                if (dataOutputStream2 != null) {
                    dataOutputStream2.close();
                }
            } catch (Throwable th4) {
                th = th4;
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                throw th;
            }
        }

        public static boolean zv() {
            DataInputStream dataInputStream;
            long elapsedRealtime;
            Throwable th;
            if (ctO == -1) {
                g.vx();
                try {
                    dataInputStream = new DataInputStream(new FileInputStream(new File(g.vw().cachePath, ba.fS("!#?'8/f((6(1$\u001f2*>(s826"))));
                    try {
                        ctO = dataInputStream.readLong();
                        v.i("MicroMsg.NormalMsgReporter", "normsg stat load done.");
                        try {
                            dataInputStream.close();
                        } catch (Exception e) {
                        }
                    } catch (Exception e2) {
                        try {
                            ctO = 0;
                            v.e("MicroMsg.NormalMsgReporter", "normsg stat load failed, use default.");
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (Exception e3) {
                                }
                            }
                            elapsedRealtime = SystemClock.elapsedRealtime();
                            if (elapsedRealtime >= ctO) {
                                ctO = 0;
                                save();
                                return false;
                            } else if (elapsedRealtime - ctO > 86400000) {
                                return false;
                            } else {
                                ctO = elapsedRealtime;
                                save();
                                return true;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (Exception e4) {
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Exception e5) {
                    dataInputStream = null;
                    ctO = 0;
                    v.e("MicroMsg.NormalMsgReporter", "normsg stat load failed, use default.");
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    elapsedRealtime = SystemClock.elapsedRealtime();
                    if (elapsedRealtime >= ctO) {
                        ctO = 0;
                        save();
                        return false;
                    } else if (elapsedRealtime - ctO > 86400000) {
                        return false;
                    } else {
                        ctO = elapsedRealtime;
                        save();
                        return true;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    dataInputStream = null;
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    throw th;
                }
            }
            elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime >= ctO) {
                ctO = 0;
                save();
                return false;
            } else if (elapsedRealtime - ctO > 86400000) {
                return false;
            } else {
                ctO = elapsedRealtime;
                save();
                return true;
            }
        }
    }

    public static final class b {
        public Object ctP;
        public Object ctQ;
        public Object ctR;
        public Object ctS;
        public Object ctT;
        public Object ctU;
        public Object ctV;
        public Object ctW;
        public Object ctX;
        public Object ctY;
        public Object ctZ;
        public Object cuA;
        public Object cuB;
        public Object cuC;
        public Object cuD;
        public Object cuE;
        public Object cua;
        public Object cub;
        public Object cuc;
        public Object cud;
        public Object cue;
        public Object cuf;
        public Object cug;
        public Object cuh;
        public Object cui;
        public Object cuj;
        public Object cuk;
        public Object cul;
        public Object cum;
        public Object cun;
        public Object cuo;
        public Object cup;
        public Object cuq;
        public Object cur;
        public Object cus;
        public Object cut;
        public Object cuu;
        public Object cuv;
        public Object cuw;
        public Object cux;
        public Object cuy;
        public Object cuz;
    }

    public static void a(final int i, b bVar) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.uri = fS("Q\u001e\u001b\u0012W\u001b\u0011\u0019Y\u0018\u001d\u0010\u0000\u001e\u001d\u001c\t@\u000e\u0002\u0004F\u001a\u0002\u0016\n\u0016\u0017\u0001\r\t:0)?3?:3");
        aVar.czm = 771;
        aVar.czn = new aqi();
        aVar.czo = new aqj();
        com.tencent.mm.v.b Bv = aVar.Bv();
        aqi com_tencent_mm_protocal_c_aqi = (aqi) Bv.czk.czs;
        com_tencent_mm_protocal_c_aqi.mPH = i;
        com_tencent_mm_protocal_c_aqi.mPG = a(bVar);
        com.tencent.mm.plugin.report.b.itm.a(416, 0, 1, false);
        u.a(Bv, new com.tencent.mm.v.u.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.v.b bVar, k kVar) {
                if (i == 0 && i2 == 0) {
                    v.d("MicroMsg.NormalMsgReporter", "cgireport succ, ctx: %d", Integer.valueOf(i));
                    com.tencent.mm.plugin.report.b.itm.a(416, 1, 1, false);
                } else {
                    v.d("MicroMsg.NormalMsgReporter", "cgireport failed, ctx: %d, err: %d:%d %s", Integer.valueOf(i), Integer.valueOf(i), Integer.valueOf(i2), str);
                    com.tencent.mm.plugin.report.b.itm.a(416, 2, 1, false);
                }
                return 0;
            }
        }, false);
    }

    public static String a(b bVar) {
        r3 = new Object[42][];
        r3[0] = new Object[]{"\u001d$\u001b>\"8\u001e2?\u0010.<6", bVar.ctP};
        r3[1] = new Object[]{"\u001c!4\u00180 24", bVar.ctQ};
        r3[2] = new Object[]{"\u001e'\u001104\u0013>019>.><", bVar.ctR};
        r3[3] = new Object[]{"\u000194\u001c4%?i", bVar.ctS};
        r3[4] = new Object[]{"\u000194\u001c4%?j", bVar.ctT};
        r3[5] = new Object[]{"\u000194\u001c4%?k", bVar.ctU};
        r3[6] = new Object[]{"\u0013#'\u0006 %?7?", bVar.ctV};
        r3[7] = new Object[]{"\u00011%?8\u0012\"\f>*", bVar.ctW};
        r3[8] = new Object[]{"\u001e!\u000119\u00002*", bVar.ctX};
        r3[9] = new Object[]{"\u0014\u0013\u001a\u0011", bVar.ctY};
        r3[10] = new Object[]{"\u0011=6';>2\u0010\u001c", bVar.ctZ};
        r3[11] = new Object[]{"\u00029?93\u00061)384", bVar.cua};
        r3[12] = new Object[]{"\u00038>82\u0019:>>4", bVar.cub};
        r3[13] = new Object[]{"\u0016&\"\u0013> 6\u001f2+1,", bVar.cuc};
        r3[14] = new Object[]{"\u001f/+\u0011\u000f", bVar.cud};
        r3[15] = new Object[]{"\u001c,(\b>.", bVar.cue};
        r3[16] = new Object[]{"\u0013#'\u00061%?84", bVar.cuf};
        r3[17] = new Object[]{"\r80=\u0017\u0018\u001b", bVar.cug};
        r3[18] = new Object[]{"\u0011!%\u001134 .(<+", bVar.cuh};
        r3[19] = new Object[]{"\u000e\r\u0016\u001c", bVar.cui};
        r3[20] = new Object[]{"\f,\u00144=7", bVar.cuj};
        r3[21] = new Object[]{"\u001e\f\r\u0010\u001c", bVar.cuk};
        r3[22] = new Object[]{"\u001f\r\u0012\u00124?7", bVar.cul};
        r3[23] = new Object[]{"\u000e6;\u0015;4=", bVar.cum};
        r3[24] = new Object[]{"\u001c(57>\u001f\b", bVar.cun};
        r3[25] = new Object[]{"\u0011%8:3\u0016:;)<", bVar.cuo};
        r3[26] = new Object[]{"\u0014 =?6\u0013?0*13:><*", bVar.cup};
        r3[27] = new Object[]{"\u0011%8:3\u0016';5<", bVar.cuq};
        r3[28] = new Object[]{"\u0010$9;2\u00111-3:=", bVar.cur};
        r3[29] = new Object[]{"\u001c(57>\u0011\u000f", bVar.cus};
        r3[30] = new Object[]{"\u0017#><5\u0002!39+<,", bVar.cut};
        r3[31] = new Object[]{"\u0019 \u000309\"\u00137.", bVar.cuu};
        r3[32] = new Object[]{"\u001879%730((,:*", bVar.cuv};
        r3[33] = new Object[]{"\u0001:<:0\u0018\"5", bVar.cuw};
        r3[34] = new Object[]{"\u00108(\u000f#)=", bVar.cux};
        r3[35] = new Object[]{"\u00153'5\u000798,", bVar.cuy};
        r3[36] = new Object[]{"\u00182!\u0011!'\u00062?", bVar.cuz};
        r3[37] = new Object[]{"\u001c6%\u000098'\u000e4>:6/", bVar.cuA};
        r3[38] = new Object[]{"\u00044\"$?::\u00185==", bVar.cuB};
        r3[39] = new Object[]{"\u000b#89+'+\"\u0005)%01\r/>:8.\u0015;4=", bVar.cuC};
        r3[40] = new Object[]{"\u001f-,\u0015;4=", bVar.cuD};
        r3[41] = new Object[]{"\u0005\u0006\u001a?#,\u0002.!''!\u0002.*<+", bVar.cuE};
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<st>");
        for (int i = 0; i < 42; i++) {
            Object[] objArr = r3[i];
            String fT = fT(fS((String) objArr[0]));
            stringBuilder.append('<').append(fT).append('>').append(fT(String.valueOf(objArr[1]))).append('<').append('/').append(fT).append('>');
        }
        stringBuilder.append("</st>");
        return stringBuilder.toString();
    }

    private static String fS(String str) {
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            stringBuilder.append((char) ((str.charAt(i) ^ -89) ^ ((byte) (((i + 1) ^ length) ^ -1))));
        }
        return stringBuilder.toString();
    }

    private static String fT(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\"':
                    stringBuilder.append("&quot;");
                    break;
                case '&':
                    stringBuilder.append("&amp;");
                    break;
                case '\'':
                    stringBuilder.append("&apos;");
                    break;
                case ',':
                    stringBuilder.append("&#").append(charAt).append(';');
                    break;
                case '<':
                    stringBuilder.append("&lt;");
                    break;
                case '>':
                    stringBuilder.append("&gt;");
                    break;
                default:
                    if (charAt <= '~') {
                        stringBuilder.append(charAt);
                        break;
                    }
                    stringBuilder.append("&#").append(charAt).append(';');
                    break;
            }
        }
        return stringBuilder.toString();
    }
}
