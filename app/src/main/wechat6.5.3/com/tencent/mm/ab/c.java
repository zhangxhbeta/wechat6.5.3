package com.tencent.mm.ab;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.a.f;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.i;
import com.tencent.mm.model.k;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.protocal.c.ais;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.u;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

final class c implements com.tencent.mm.model.ab.c {
    private f<String, Integer> cKb = new f(200);
    Map<String, com.tencent.mm.model.ab.c.a> cKc = new HashMap();
    Queue<ve> cKd = new LinkedList();
    Queue<a> cKe = new LinkedList();
    long cKf = 0;
    final int cKg = 500;
    final int cKh = 10000;
    ah cKi = new ah(ak.vA().htb.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ c cKk;

        {
            this.cKk = r1;
        }

        public final boolean oU() {
            v.d("MicroMsg.GetContactService", "pusherTry onTimerExpired tryStartNetscene");
            this.cKk.Ge();
            return false;
        }
    }, false);
    final ah cKj = new ah(ak.vA().htb.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ c cKk;

        {
            this.cKk = r1;
        }

        public final boolean oU() {
            if (this.cKk.cKe.isEmpty()) {
                v.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , wait doscene!");
                return false;
            }
            boolean z;
            int size;
            long Ni = be.Ni();
            int i = this.cKk.cxK ? 5 : 15;
            ArrayList arrayList = new ArrayList(i * 2);
            int i2 = 0;
            while (i2 < i) {
                int i3;
                b Gg;
                a aVar = (a) this.cKk.cKe.peek();
                if (aVar == null) {
                    v.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , break and wait doscene!");
                    z = false;
                } else {
                    LinkedList linkedList = aVar.cKp.mxQ;
                    LinkedList linkedList2 = aVar.cKp.mxR;
                    i3 = aVar.cKq;
                    if (linkedList.size() <= i3) {
                        this.cKk.cKe.poll();
                        if (this.cKk.cKe.isEmpty()) {
                            v.d("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is empty break", Integer.valueOf(i3), Integer.valueOf(size));
                            this.cKk.cKf = 0;
                            this.cKk.cKi.ea(0);
                            z = false;
                        } else {
                            v.d("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is not empty continue next", Integer.valueOf(i3), Integer.valueOf(size));
                        }
                    } else {
                        boolean z2;
                        com.tencent.mm.model.ab.c.a aVar2;
                        ais com_tencent_mm_protocal_c_ais = (ais) linkedList.get(i3);
                        int intValue = ((Integer) linkedList2.get(i3)).intValue();
                        final String a = m.a(com_tencent_mm_protocal_c_ais.moM);
                        final String str = com_tencent_mm_protocal_c_ais.cHh;
                        arrayList.add(a);
                        arrayList.add(str);
                        switch (intValue) {
                            case 0:
                                v.i("MicroMsg.GetContactService", "respHandler mod contact: %s %s", a, str);
                                b.drq.a(com_tencent_mm_protocal_c_ais);
                                z2 = true;
                                break;
                            case 1:
                                v.e("MicroMsg.GetContactService", "respHandler getFailed :%d ErrName: %s %s", Integer.valueOf(intValue), a, str);
                                i.eh(a);
                                z2 = false;
                                break;
                            default:
                                v.e("MicroMsg.GetContactService", "respHandler getFailed :%d ErrName: %s %s", Integer.valueOf(intValue), a, str);
                                i.eh(a);
                                z2 = false;
                                break;
                        }
                        final com.tencent.mm.model.ab.c.a aVar3 = (com.tencent.mm.model.ab.c.a) this.cKk.cKc.remove(a);
                        if (be.kS(str)) {
                            aVar2 = null;
                        } else {
                            aVar2 = (com.tencent.mm.model.ab.c.a) this.cKk.cKc.remove(str);
                        }
                        if (!(aVar3 == null && aVar2 == null)) {
                            new ac(Looper.getMainLooper()).post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass3 cKo;

                                public final void run() {
                                    if (aVar3 != null) {
                                        aVar3.p(a, z2);
                                    }
                                    if (aVar2 != null && !be.kS(str)) {
                                        aVar2.p(str, z2);
                                    }
                                }
                            });
                        }
                        aVar.cKq++;
                    }
                    i2++;
                }
                size = arrayList.size();
                if (size > 0) {
                    ak.yW();
                    long er = com.tencent.mm.model.c.wE().er(Thread.currentThread().getId());
                    Gg = d.Gg();
                    for (i3 = 0; i3 < size; i3++) {
                        Gg.iN((String) arrayList.get(i3));
                    }
                    ak.yW();
                    com.tencent.mm.model.c.wE().es(er);
                }
                v.d("MicroMsg.GetContactService", "tryStartNetscene respHandler onTimerExpired netSceneRunning : " + this.cKk.cxK + " ret: " + z + " maxCnt: " + i + " deleteCount: " + size + " take: " + (be.Ni() - Ni) + "ms");
                return z;
            }
            z = true;
            size = arrayList.size();
            if (size > 0) {
                ak.yW();
                long er2 = com.tencent.mm.model.c.wE().er(Thread.currentThread().getId());
                Gg = d.Gg();
                for (i3 = 0; i3 < size; i3++) {
                    Gg.iN((String) arrayList.get(i3));
                }
                ak.yW();
                com.tencent.mm.model.c.wE().es(er2);
            }
            v.d("MicroMsg.GetContactService", "tryStartNetscene respHandler onTimerExpired netSceneRunning : " + this.cKk.cxK + " ret: " + z + " maxCnt: " + i + " deleteCount: " + size + " take: " + (be.Ni() - Ni) + "ms");
            return z;
        }
    }, true);
    boolean cxK = false;
    private long cxV = 0;

    class a {
        String biS;
        final /* synthetic */ c cKk;
        vf cKp;
        int cKq = 0;
        int errCode;
        int errType;

        a(c cVar) {
            this.cKk = cVar;
        }
    }

    c() {
    }

    public final void fD(String str) {
        this.cKc.remove(str);
    }

    public final void I(String str, String str2) {
        v.i("MicroMsg.GetContactService", "add Contact :" + str + " chatroom: " + str2 + " stack:" + be.bur());
        if (U(str, str2)) {
            this.cKi.ea(500);
        }
    }

    public final void a(String str, String str2, com.tencent.mm.model.ab.c.a aVar) {
        v.i("MicroMsg.GetContactService", "getNow :" + str + " chatroom: " + str2 + " stack:" + be.bur());
        if (U(str, str2)) {
            this.cKc.put(str, aVar);
            this.cKi.ea(0);
        }
    }

    private static boolean U(String str, String str2) {
        if (be.kS(str)) {
            return false;
        }
        String xF = k.xF();
        String xG = k.xG();
        if (str.equals(xF) || str.equals(xG)) {
            v.i("MicroMsg.GetContactService", "addToStg username: " + str + " equal to user: " + xF + " alias: " + xG + " ret");
            return false;
        }
        a aVar = new a();
        aVar.username = str;
        aVar.cuV = be.ma(str2);
        aVar.cJZ = be.Ni();
        b Gg = d.Gg();
        aVar.bkU = -1;
        ContentValues contentValues = new ContentValues();
        if ((aVar.bkU & 1) != 0) {
            contentValues.put("username", aVar.getUsername());
        }
        if ((aVar.bkU & 2) != 0) {
            contentValues.put("inserttime", Long.valueOf(aVar.cJZ));
        }
        if ((aVar.bkU & 4) != 0) {
            contentValues.put("type", Integer.valueOf(aVar.type));
        }
        if ((aVar.bkU & 8) != 0) {
            contentValues.put("lastgettime", Integer.valueOf(aVar.cKa));
        }
        if ((aVar.bkU & 16) != 0) {
            contentValues.put("reserved1", Integer.valueOf(aVar.cuT));
        }
        if ((aVar.bkU & 32) != 0) {
            contentValues.put("reserved2", Integer.valueOf(aVar.cHX));
        }
        if ((aVar.bkU & 64) != 0) {
            contentValues.put("reserved3", aVar.zM());
        }
        if ((aVar.bkU & FileUtils.S_IWUSR) != 0) {
            contentValues.put("reserved4", aVar.cuW == null ? SQLiteDatabase.KeyEmpty : aVar.cuW);
        }
        if (((int) Gg.cuX.replace("getcontactinfov2", "username", contentValues)) == -1) {
            return false;
        }
        Gg.Lf(aVar.getUsername());
        return true;
    }

    private void Gd() {
        String[] strArr = new String[]{String.valueOf(this.cKf), "80"};
        Cursor rawQuery = d.Gg().cuX.rawQuery("select getcontactinfov2.username,getcontactinfov2.inserttime,getcontactinfov2.type,getcontactinfov2.lastgettime,getcontactinfov2.reserved1,getcontactinfov2.reserved2,getcontactinfov2.reserved3,getcontactinfov2.reserved4 from getcontactinfov2 where inserttime> ?  order by inserttime asc limit ?", strArr);
        if (rawQuery != null) {
            v.i("MicroMsg.GetContactService", "getFromDb count:%d", Integer.valueOf(rawQuery.getCount()));
            if (rawQuery.getCount() <= 0) {
                rawQuery.close();
                return;
            }
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            LinkedList linkedList3 = new LinkedList();
            LinkedList linkedList4 = linkedList;
            linkedList = linkedList2;
            while (rawQuery.moveToNext()) {
                a aVar = new a();
                aVar.username = rawQuery.getString(0);
                aVar.cJZ = rawQuery.getLong(1);
                aVar.type = rawQuery.getInt(2);
                aVar.cKa = rawQuery.getInt(3);
                aVar.cuT = rawQuery.getInt(4);
                aVar.cHX = rawQuery.getInt(5);
                aVar.cuV = rawQuery.getString(6);
                aVar.cuW = rawQuery.getString(7);
                String username = aVar.getUsername();
                String ma = be.ma(aVar.zM());
                this.cKf = aVar.cJZ;
                int a = be.a((Integer) this.cKb.get(username), 0);
                if (a < 3) {
                    this.cKb.k(username, Integer.valueOf(a + 1));
                    linkedList4.add(new arf().JF(username));
                    linkedList.add(new arf().JF(ma));
                    v.v("MicroMsg.GetContactService", "getFromDb add user:%s room:%s", username, ma);
                    if (linkedList4.size() >= 20 || rawQuery.isLast()) {
                        ve veVar = new ve();
                        veVar.mfO = linkedList4;
                        veVar.mxK = linkedList4.size();
                        veVar.mxO = linkedList;
                        veVar.mxN = linkedList.size();
                        this.cKd.add(veVar);
                        linkedList = new LinkedList();
                        linkedList2 = new LinkedList();
                        v.d("MicroMsg.GetContactService", "getFromDb now reqlist size:%d , this req usr count:%d", Integer.valueOf(this.cKd.size()), Integer.valueOf(veVar.mfO.size()));
                    } else {
                        linkedList2 = linkedList;
                        linkedList = linkedList4;
                    }
                    linkedList4 = linkedList;
                    linkedList = linkedList2;
                } else {
                    linkedList3.add(username);
                    if (this.cKc.containsKey(username)) {
                        com.tencent.mm.model.ab.c.a aVar2 = (com.tencent.mm.model.ab.c.a) this.cKc.get(username);
                        if (aVar2 != null) {
                            aVar2.p(username, false);
                        }
                        this.cKc.remove(username);
                    }
                }
            }
            rawQuery.close();
            for (int i = 0; i < linkedList3.size(); i++) {
                String str = (String) linkedList3.get(i);
                v.w("MicroMsg.GetContactService", "getFromDb try getContact Too much usr:%s; remove from table:%s ", str, Boolean.valueOf(com.tencent.mm.model.m.dE(str)));
                if (com.tencent.mm.model.m.dE(str)) {
                    d.Gg().iN(str);
                }
            }
        }
    }

    final synchronized void Ge() {
        if (b.drq.oD()) {
            v.w("MicroMsg.GetContactService", "tryStartNetscene need init , never get contact");
        } else {
            long Ni = be.Ni();
            if (this.cxK && Ni - this.cxV > 600000) {
                v.w("MicroMsg.GetContactService", "tryStartNetscene Not Callback too long:%d . Force Run Now", Long.valueOf(Ni - this.cxV));
                this.cxK = false;
            }
            if (this.cxK) {
                v.d("MicroMsg.GetContactService", "tryStartNetscene netSceneRunning: " + this.cxK + " ret");
            } else {
                com.tencent.mm.ba.a aVar = (ve) this.cKd.poll();
                if (aVar == null) {
                    Gd();
                    aVar = (ve) this.cKd.poll();
                    if (aVar == null) {
                        v.i("MicroMsg.GetContactService", "tryStartNetscene Not any more contact.");
                    }
                }
                this.cxV = Ni;
                this.cxK = true;
                com.tencent.mm.v.b.a aVar2 = new com.tencent.mm.v.b.a();
                aVar2.czn = aVar;
                aVar2.czo = new vf();
                aVar2.uri = "/cgi-bin/micromsg-bin/getcontact";
                aVar2.czm = 182;
                u.a(aVar2.Bv(), new com.tencent.mm.v.u.a(this) {
                    final /* synthetic */ c cKk;

                    {
                        this.cKk = r1;
                    }

                    public final int a(int i, int i2, String str, com.tencent.mm.v.b bVar, com.tencent.mm.v.k kVar) {
                        if (kVar.getType() == 182) {
                            this.cKk.cxK = false;
                            if (i == 0 && i2 == 0) {
                                if (!this.cKk.cKd.isEmpty() && this.cKk.cKi.btC()) {
                                    this.cKk.cKi.ea(500);
                                }
                                if (bVar != null) {
                                    a aVar = new a(this.cKk);
                                    aVar.errType = i;
                                    aVar.errCode = i2;
                                    aVar.biS = str;
                                    aVar.cKp = (vf) bVar.czl.czs;
                                    this.cKk.cKe.add(aVar);
                                }
                                if (!this.cKk.cKe.isEmpty() && this.cKk.cKj.btC()) {
                                    this.cKk.cKj.ea(50);
                                }
                            } else {
                                v.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd errType:" + i + " errCode:" + i2 + " will retry");
                                this.cKk.cKi.ea(10000);
                            }
                        }
                        return 0;
                    }
                }, true);
            }
        }
    }
}
