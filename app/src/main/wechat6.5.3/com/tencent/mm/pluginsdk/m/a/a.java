package com.tencent.mm.pluginsdk.m.a;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class a {
    public static final String[] lFj = new String[]{"LDPI", "HDPI", "MDPI"};
    public String cvP;
    public String cvQ;
    public String desc;
    public String id;
    public String lFb;
    public boolean lFc;
    public boolean lFd;
    public int lFe;
    public Rect lFf;
    public int lFg;
    public Rect lFh;
    public Map<String, String> lFi;
    public String platform;
    public String title;
    public String url;

    public enum a {
        ASSET,
        DOWNLOAD,
        ERROR
    }

    private a(String str, String str2, String str3, boolean z, boolean z2) {
        this.id = str;
        this.platform = str2;
        this.lFb = str3;
        this.lFc = z;
        this.lFd = z2;
    }

    private boolean MM() {
        long Ni = be.Ni();
        long j = Long.MAX_VALUE;
        long j2 = 0;
        try {
            if (this.cvQ != null) {
                j = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.cvQ).getTime();
            }
            if (this.cvP != null) {
                j2 = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.cvP).getTime();
            }
            v.d("MicroMsg.PushMessage", "CHECKTIME : [" + j2 + "," + j + "]");
            if (j <= Ni || j2 > Ni) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    public final String toString() {
        return "ad.id=" + this.id + ", platform=" + this.platform + ", device=" + this.lFb + (this.lFc ? ", closable" : SQLiteDatabase.KeyEmpty) + (this.lFd ? ", trans-closable" : SQLiteDatabase.KeyEmpty);
    }

    public static String Hm(String str) {
        a Hn = Hn(str);
        if (Hn == a.ASSET) {
            return str;
        }
        if (Hn != a.DOWNLOAD) {
            return null;
        }
        String str2;
        if (str == null) {
            str2 = null;
        } else {
            int lastIndexOf = str.lastIndexOf("/");
            str2 = (lastIndexOf < 0 || lastIndexOf >= str.length() - 1) ? null : str.substring(lastIndexOf + 1);
        }
        if (str2 == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        return stringBuilder.append(c.wP()).append(str2).toString();
    }

    public static a Hn(String str) {
        if (str.indexOf("tips/") == 0) {
            return a.ASSET;
        }
        if (str.indexOf("weixin://") == 0) {
            return a.DOWNLOAD;
        }
        return a.ERROR;
    }

    public static ArrayList<a> aR(Context context, String str) {
        if (str == null || str.length() < 0) {
            return null;
        }
        HashSet hashSet;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        String str2 = displayMetrics.heightPixels + "x" + displayMetrics.widthPixels;
        if (str2 == null) {
            hashSet = null;
        } else {
            HashSet hashSet2 = new HashSet();
            hashSet2.add(str2);
            str2 = b.dD(context);
            v.d("MicroMsg.PushMessage", "getDisplaySizeType :" + str2);
            if (str2 != null) {
                String[] split = str2.split("_");
                str2 = (split == null || split.length < 2) ? null : split[0];
                hashSet2.add(str2 + "_L");
                hashSet2.add(str2 + "_P");
            }
            hashSet = hashSet2;
        }
        if (hashSet == null || hashSet.size() <= 0) {
            return null;
        }
        Map q = bf.q(str, "tips");
        if (q == null) {
            return null;
        }
        ArrayList<a> arrayList = new ArrayList();
        int i = 0;
        while (true) {
            String str3 = ".tips.tip" + (i > 0 ? Integer.valueOf(i) : SQLiteDatabase.KeyEmpty);
            if (q.get(str3) == null) {
                break;
            }
            String str4 = (String) q.get(str3 + ".$id");
            v.d("MicroMsg.PushMessage", "parseMessages id:" + str4);
            String str5 = (String) q.get(str3 + ".$platform");
            if (str5.equals("android")) {
                a aVar = new a(str4, str5, (String) q.get(str3 + ".$device"), be.b(Boolean.valueOf((String) q.get(str3 + ".$enableclose"))), be.b(Boolean.valueOf((String) q.get(str3 + ".$transparentclose"))));
                int i2 = be.getInt((String) q.get(str3 + ".title.$x"), 0);
                int i3 = be.getInt((String) q.get(str3 + ".title.$y"), 0);
                int i4 = be.getInt((String) q.get(str3 + ".title.$width"), 0);
                int i5 = be.getInt((String) q.get(str3 + ".title.$font"), 0);
                int KD = be.KD((String) q.get(str3 + ".title.$color"));
                aVar.title = (String) q.get(str3 + ".title");
                aVar.lFe = KD;
                aVar.lFf = new Rect(i2, i3, i4 + i2, i5 + i3);
                i2 = be.getInt((String) q.get(str3 + ".description.$x"), 0);
                i3 = be.getInt((String) q.get(str3 + ".description.$y"), 0);
                i4 = be.getInt((String) q.get(str3 + ".description.$width"), 0);
                i5 = be.getInt((String) q.get(str3 + ".description.$font"), 0);
                KD = be.KD((String) q.get(str3 + ".description.$color"));
                aVar.desc = (String) q.get(str3 + ".description");
                aVar.lFg = KD;
                aVar.lFh = new Rect(i2, i3, i4 + i2, i5 + i3);
                aVar.url = (String) q.get(str3 + ".url");
                aVar.cvP = (String) q.get(str3 + ".time.start");
                aVar.cvQ = (String) q.get(str3 + ".time.end");
                v.d("MicroMsg.PushMessage", "parseMessages id:" + aVar.id + " start:" + aVar.cvP + " end:" + aVar.cvQ);
                Map hashMap = new HashMap();
                i3 = 0;
                while (true) {
                    str5 = str3 + ".images.image" + (i3 > 0 ? Integer.valueOf(i3) : SQLiteDatabase.KeyEmpty);
                    str4 = (String) q.get(str5);
                    v.d("MicroMsg.PushMessage", " img res:" + str4);
                    if (str4 == null) {
                        break;
                    }
                    str5 = (String) q.get(str5 + ".$type");
                    if (hashSet.contains(str5)) {
                        hashMap.put(str5, str4);
                    }
                    i3++;
                }
                if (hashMap.size() > 0) {
                    aVar.lFi = hashMap;
                }
                v.d("MicroMsg.PushMessage", "msgid :" + aVar.id);
                arrayList.add(aVar);
            }
            i++;
        }
        v.d("MicroMsg.PushMessage", "msgs size: " + arrayList.size());
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    public static void bon() {
        ak.yW();
        c.vf().set(8193, SQLiteDatabase.KeyEmpty);
        ak.yW();
        c.vf().set(8449, Long.valueOf(0));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.pluginsdk.m.a.a dk(android.content.Context r10) {
        /*
        r2 = 1;
        r3 = 0;
        r1 = 0;
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.vf();
        r4 = 8449; // 0x2101 float:1.184E-41 double:4.1744E-320;
        r0 = r0.get(r4, r1);
        r0 = com.tencent.mm.sdk.platformtools.be.n(r0, r3);
        r4 = (long) r0;
        r6 = com.tencent.mm.sdk.platformtools.be.Nh();
        r6 = r6 - r4;
        r8 = 0;
        r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x002c;
    L_0x0020:
        r4 = 86400; // 0x15180 float:1.21072E-40 double:4.26873E-319;
        r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r0 < 0) goto L_0x002c;
    L_0x0027:
        bon();
    L_0x002a:
        r0 = r1;
    L_0x002b:
        return r0;
    L_0x002c:
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.vf();
        r4 = 8193; // 0x2001 float:1.1481E-41 double:4.048E-320;
        r0 = r0.get(r4, r1);
        r0 = (java.lang.String) r0;
        r4 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r4 != 0) goto L_0x002a;
    L_0x0041:
        r4 = "id=\"setavatar\"";
        r4 = r0.contains(r4);
        if (r4 == 0) goto L_0x004e;
    L_0x004a:
        bon();
        goto L_0x002a;
    L_0x004e:
        r4 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r4 != 0) goto L_0x0081;
    L_0x0054:
        r0 = aR(r10, r0);
        if (r0 == 0) goto L_0x0060;
    L_0x005a:
        r4 = r0.size();
        if (r4 == r2) goto L_0x0067;
    L_0x0060:
        r0 = r1;
    L_0x0061:
        if (r0 != 0) goto L_0x002b;
    L_0x0063:
        bon();
        goto L_0x002a;
    L_0x0067:
        r0 = r0.get(r3);
        r0 = (com.tencent.mm.pluginsdk.m.a.a) r0;
        r4 = r0.lFi;
        if (r4 == 0) goto L_0x0083;
    L_0x0071:
        r4 = r0.lFi;
        r4 = r4.size();
        if (r4 <= 0) goto L_0x0083;
    L_0x0079:
        if (r2 == 0) goto L_0x0081;
    L_0x007b:
        r2 = r0.MM();
        if (r2 != 0) goto L_0x0061;
    L_0x0081:
        r0 = r1;
        goto L_0x0061;
    L_0x0083:
        r2 = r3;
        goto L_0x0079;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.m.a.a.dk(android.content.Context):com.tencent.mm.pluginsdk.m.a.a");
    }
}
