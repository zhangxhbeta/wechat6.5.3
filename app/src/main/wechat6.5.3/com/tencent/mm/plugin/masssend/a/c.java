package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;
import com.tencent.mm.a.e;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class c {
    private LinkedList<d> hjx;

    public final void azb() {
        a aVar = null;
        boolean azd = azd();
        ak.yW();
        boolean booleanValue = ((Boolean) com.tencent.mm.model.c.vf().get(102408, Boolean.valueOf(false))).booleanValue();
        boolean z = (k.xQ() & 65536) == 0;
        v.d("MicroMsg.MassSendService", "hadSetTop is %B", new Object[]{Boolean.valueOf(booleanValue)});
        if (z && !booleanValue && azd) {
            v.d("MicroMsg.MassSendService", "set top conversation");
            ak.yW();
            if (com.tencent.mm.model.c.wK().Mh("masssendapp") == null) {
                ak.yW();
                if (com.tencent.mm.model.c.wK().Mh("masssendapp") == null) {
                    ab abVar = new ab();
                    abVar.setUsername("masssendapp");
                    abVar.setContent(aa.getContext().getResources().getString(2131232084));
                    abVar.s(be.Ni() + 2000);
                    abVar.di(0);
                    abVar.df(0);
                    ak.yW();
                    com.tencent.mm.model.c.wK().d(abVar);
                }
            } else {
                String string;
                Cursor rawQuery = h.azf().cuX.rawQuery("select * from massendinfo ORDER BY createtime DESC  limit 1", null);
                if (rawQuery != null) {
                    if (rawQuery.getCount() <= 0) {
                        rawQuery.close();
                    } else {
                        a aVar2;
                        if (rawQuery.moveToFirst()) {
                            aVar2 = new a();
                            aVar2.b(rawQuery);
                        } else {
                            aVar2 = null;
                        }
                        rawQuery.close();
                        aVar = aVar2;
                    }
                }
                if (aVar == null) {
                    string = aa.getContext().getResources().getString(2131232084);
                } else {
                    h.azf();
                    string = b.a(aVar);
                }
                ab abVar2 = new ab();
                abVar2.setUsername("masssendapp");
                abVar2.setContent(string);
                abVar2.s(be.Ni() + 2000);
                abVar2.di(0);
                abVar2.df(0);
                ak.yW();
                com.tencent.mm.model.c.wK().a(abVar2, "masssendapp", true);
            }
            g.iuh.Y(10425, "");
            ak.yW();
            com.tencent.mm.model.c.vf().set(102409, Long.valueOf(be.Ni()));
            ak.yW();
            com.tencent.mm.model.c.vf().set(102408, Boolean.valueOf(true));
        } else if (!azd) {
            ak.yW();
            com.tencent.mm.model.c.vf().set(102408, Boolean.valueOf(false));
        }
    }

    public static void ch(long j) {
        ak.yW();
        com.tencent.mm.model.c.vf().set(102409, Long.valueOf(j));
    }

    private static String azc() {
        if (!ak.uz()) {
            return "";
        }
        r1 = new Object[2];
        ak.yW();
        r1[0] = com.tencent.mm.model.c.xp();
        r1[1] = u.bsY();
        v.d("MicroMsg.MassSendService", "config file path is %s", new Object[]{String.format("%s/masssend_%s.ini", r1)});
        return String.format("%s/masssend_%s.ini", r1);
    }

    private boolean azd() {
        if (this.hjx == null) {
            String azc = azc();
            byte[] d = e.d(azc, 0, -1);
            if (d == null) {
                return false;
            }
            try {
                this.hjx = ((e) new e().az(d)).hjy;
            } catch (Exception e) {
                b.deleteFile(azc);
                return false;
            }
        }
        if (this.hjx == null) {
            v.w("MicroMsg.MassSendService", "info list is empty");
            return false;
        }
        v.i("MicroMsg.MassSendService", "info list[%s]", new Object[]{this.hjx.toString()});
        long Nh = be.Nh();
        Iterator it = this.hjx.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (((long) dVar.aPR) <= Nh && Nh <= ((long) dVar.end)) {
                return true;
            }
        }
        return false;
    }

    public final void wl(String str) {
        if (!be.kS(str)) {
            Map q = bf.q(str, "Festivals");
            if (q != null) {
                e eVar = new e();
                int i = 0;
                while (true) {
                    String str2 = ".Festivals.Festival" + (i == 0 ? "" : String.valueOf(i));
                    if (!q.containsKey(str2)) {
                        break;
                    }
                    d dVar = new d();
                    dVar.aPR = be.KC((String) q.get(str2 + ".StartTime"));
                    dVar.end = be.KC((String) q.get(str2 + ".EndTime")) + 86400000;
                    eVar.hjy.add(dVar);
                    i++;
                }
                eVar.count = eVar.hjy.size();
                this.hjx = eVar.hjy;
                try {
                    byte[] toByteArray = eVar.toByteArray();
                    String azc = azc();
                    if (be.kS(azc)) {
                        v.w("MicroMsg.MassSendService", "mass send config file path is null, return");
                        return;
                    }
                    File file = new File(azc);
                    if (file.exists()) {
                        int i2;
                        if (com.tencent.mm.a.g.g(file).equals(com.tencent.mm.a.g.m(toByteArray))) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        if (i2 != 0) {
                            ak.yW();
                            com.tencent.mm.model.c.vf().set(102408, Boolean.valueOf(false));
                        }
                    } else {
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(102408, Boolean.valueOf(false));
                    }
                    v.d("MicroMsg.MassSendService", "save to config file : %s", new Object[]{eVar.toString()});
                    e.b(azc, toByteArray, toByteArray.length);
                } catch (Throwable e) {
                    v.a("MicroMsg.MassSendService", e, "", new Object[0]);
                }
            }
        }
    }
}
