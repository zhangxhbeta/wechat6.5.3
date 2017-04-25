package com.tencent.mm.aq;

import com.tencent.mm.a.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.t;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.m;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class c implements e {
    public static int chatType = 0;
    private static final f<Integer, a> cqx = new f(5);
    private static c dam;
    private int cTV = 3;
    public boolean cwY = false;

    public static class a {
        public int bBZ = 0;
        public String dan = "BeiJing;GuangZhou;ShangHai;";
        public int dao = 0;
        public int dap = 2;
        public int daq = 2;
        public int dar = 2;
        public int das = 10240;
        public int dat = 10240000;
        public int dau = 100;
        public int dav = 100;
        public int daw = 100;
        public Random dax = new Random();
        public List<String> day = null;

        public final boolean JQ() {
            ab ym = k.ym();
            v.d("upload", new StringBuilder("  getRegionCode ").append(ym).toString() != null ? ym.bCq : SQLiteDatabase.KeyEmpty);
            String str = ym.bCq;
            if (str == null || str.length() <= 0 || this.day == null || this.day.size() <= 0) {
                return false;
            }
            String[] split = str.split("_");
            if (split == null || split.length <= 0) {
                return false;
            }
            int i = 0;
            while (i < split.length) {
                if (split[i] != null && split[i].length() > 0) {
                    for (String str2 : this.day) {
                        if (str2.trim().toLowerCase().equals(split[i].trim().toLowerCase())) {
                            v.d("upload", "isInRegion");
                            return true;
                        }
                    }
                    continue;
                }
                i++;
            }
            return false;
        }

        public final int JR() {
            switch (c.chatType) {
                case 0:
                    return this.dap;
                case 1:
                    return this.daq;
                case 2:
                    return this.dar;
                default:
                    return this.dap;
            }
        }

        public final int JS() {
            switch (c.chatType) {
                case 0:
                    return this.dau;
                case 1:
                    return this.dav;
                case 2:
                    return this.daw;
                default:
                    return this.dau;
            }
        }

        public static a JT() {
            v.d("upload", "parseFromFile");
            String str = n.HO() + t.HS().aM(1, 9);
            int aQ = com.tencent.mm.a.e.aQ(str);
            if (aQ == -1) {
                v.e("upload", "read file failed " + aQ + str);
                return null;
            }
            byte[] c = com.tencent.mm.a.e.c(str, 0, aQ);
            if (c == null) {
                v.e("upload", "read file failed " + aQ + str);
                return null;
            }
            str = new String(c);
            if (be.kS(str)) {
                return null;
            }
            String substring;
            aQ = str.indexOf(60);
            if (aQ > 0) {
                substring = str.substring(aQ);
            } else {
                substring = str;
            }
            int hashCode = substring.hashCode();
            a aVar = (a) c.cqx.get(Integer.valueOf(hashCode));
            if (aVar != null) {
                return aVar;
            }
            Map q = bf.q(substring, "Config");
            if (q == null) {
                v.e("upload", "parse msg failed");
                return null;
            }
            try {
                a aVar2 = new a();
                int i = 0;
                while (true) {
                    str = (String) q.get(".Config.Item" + (i == 0 ? SQLiteDatabase.KeyEmpty : Integer.valueOf(i)) + ".$key");
                    v.d("upload", "key " + str);
                    if (str != null) {
                        if (str.equals("region")) {
                            aVar2.dan = (String) q.get(".Config.Item" + (i == 0 ? SQLiteDatabase.KeyEmpty : Integer.valueOf(i)));
                            if (aVar2.dan != null && aVar2.dan.length() > 0) {
                                String[] split = aVar2.dan.split(";");
                                aVar2.day = new ArrayList();
                                if (split != null && split.length > 0) {
                                    int i2 = 0;
                                    while (i2 < split.length) {
                                        if (split[i2] != null && split[i2].length() > 0) {
                                            aVar2.day.add(split[i2]);
                                        }
                                        i2++;
                                    }
                                }
                            }
                        } else if (str.equals("sex")) {
                            r7 = new StringBuilder(".Config.Item");
                            if (i == 0) {
                                r0 = SQLiteDatabase.KeyEmpty;
                            } else {
                                r0 = Integer.valueOf(i);
                            }
                            aVar2.bBZ = be.getInt((String) q.get(r7.append(r0).toString()), 0);
                        } else if (str.equals("rate")) {
                            r7 = new StringBuilder(".Config.Item");
                            if (i == 0) {
                                r0 = SQLiteDatabase.KeyEmpty;
                            } else {
                                r0 = Integer.valueOf(i);
                            }
                            aVar2.dao = be.getInt((String) q.get(r7.append(r0).toString()), 0);
                        } else if (str.equals("minsize")) {
                            aVar2.das = be.getInt((String) q.get(".Config.Item" + (i == 0 ? SQLiteDatabase.KeyEmpty : Integer.valueOf(i))), 0);
                        } else if (str.equals("maxsize")) {
                            aVar2.dat = be.getInt((String) q.get(".Config.Item" + (i == 0 ? SQLiteDatabase.KeyEmpty : Integer.valueOf(i))), 0);
                        } else if (str.equals("daycount_single")) {
                            aVar2.dau = be.getInt((String) q.get(".Config.Item" + (i == 0 ? SQLiteDatabase.KeyEmpty : Integer.valueOf(i))), 0);
                        } else if (str.equals("daycount_chatroom")) {
                            aVar2.dav = be.getInt((String) q.get(".Config.Item" + (i == 0 ? SQLiteDatabase.KeyEmpty : Integer.valueOf(i))), 0);
                        } else if (str.equals("daycount_app")) {
                            aVar2.daw = be.getInt((String) q.get(".Config.Item" + (i == 0 ? SQLiteDatabase.KeyEmpty : Integer.valueOf(i))), 0);
                        } else if (str.equals("rate_single")) {
                            aVar2.dap = be.getInt((String) q.get(".Config.Item" + (i == 0 ? SQLiteDatabase.KeyEmpty : Integer.valueOf(i))), 0);
                        } else if (str.equals("rate_chatroom")) {
                            aVar2.daq = be.getInt((String) q.get(".Config.Item" + (i == 0 ? SQLiteDatabase.KeyEmpty : Integer.valueOf(i))), 0);
                        } else if (str.equals("rate_app")) {
                            aVar2.dar = be.getInt((String) q.get(".Config.Item" + (i == 0 ? SQLiteDatabase.KeyEmpty : Integer.valueOf(i))), 0);
                        }
                        i++;
                    } else {
                        v.d("upload", "sex " + aVar2.bBZ);
                        v.d("upload", "rate_single " + aVar2.dap);
                        v.d("upload", "rate_chatroom " + aVar2.daq);
                        v.d("upload", "rate_app " + aVar2.dar);
                        v.d("upload", "rate " + aVar2.dao);
                        v.d("upload", "minsize " + aVar2.das);
                        v.d("upload", "maxsize " + aVar2.dat);
                        v.d("upload", "daycount_single " + aVar2.dau);
                        v.d("upload", "daycount_chatroom " + aVar2.dav);
                        v.d("upload", "daycount_app " + aVar2.daw);
                        v.d("upload", "region " + aVar2.dan);
                        c.cqx.k(Integer.valueOf(hashCode), aVar2);
                        return aVar2;
                    }
                }
            } catch (Throwable e) {
                v.e("upload", "exception:%s", be.e(e));
                return null;
            }
        }
    }

    public static final class b {
        public String cXU = SQLiteDatabase.KeyEmpty;
        public int dad = 0;
        public int dae = 0;
        public int daf = 0;
    }

    public static String getPrefix() {
        switch (chatType) {
            case 0:
                return "single_";
            case 1:
                return "chatroom_";
            case 2:
                return "app_";
            default:
                return "single_";
        }
    }

    public static int ks(String str) {
        int i = 5;
        if (!(str == null || str.length() == 0)) {
            if (str.startsWith("single")) {
            }
            if (str.startsWith("chatroom")) {
                i = 7;
            }
            if (str.startsWith("app")) {
                i = 8;
            }
            v.d("upload", "type " + i);
        }
        return i;
    }

    public static c JM() {
        if (dam == null) {
            dam = new c();
        }
        return dam;
    }

    public final void release() {
        this.cwY = false;
        ak.vy().b(159, (e) this);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (!(kVar instanceof m) || ((m) kVar).BI() != 9) {
            v.d("upload", "another scene");
        } else if (kVar.getType() == 159) {
            if (i == 0 && i2 == 0) {
                ak.yW();
                com.tencent.mm.model.c.vf().set(81944, Long.valueOf(be.Nh()));
            } else {
                int i3 = this.cTV - 1;
                this.cTV = i3;
                if (i3 < 0) {
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(81944, Long.valueOf(((be.Ni() - 86400000) + 3600000) / 1000));
                    this.cTV = 3;
                }
            }
            release();
        }
    }

    public static void JN() {
        ak.yW();
        com.tencent.mm.model.c.vf().set(16646145, Integer.valueOf(0));
    }

    public static void JO() {
        ak.yW();
        Integer valueOf = Integer.valueOf(be.f((Integer) com.tencent.mm.model.c.vf().get(16646145, null)));
        if (valueOf.intValue() < 0) {
            valueOf = Integer.valueOf(0);
        }
        ak.yW();
        com.tencent.mm.model.c.vf().set(16646145, Integer.valueOf(valueOf.intValue() + 1));
    }
}
