package com.tencent.mm.modelmulti;

import android.database.Cursor;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.akf;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.protocal.c.la;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public final class r {
    private static ArrayList<bm> cSN = new ArrayList();
    private static ArrayList<u> cSO = new ArrayList();

    static /* synthetic */ void jr(String str) {
        Throwable e;
        int i = 0;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        i++;
                        String[] split = readLine.split("###");
                        if (split == null || split.length != 3) {
                            String str2 = "MicroMsg.TestSyncAddMsg";
                            String str3 = "readMsgFromFile parse line %d failed : len:%d ";
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(i);
                            objArr[1] = Integer.valueOf(split == null ? -1 : split.length);
                            v.e(str2, str3, objArr);
                        } else {
                            bm bmVar = new bm();
                            bmVar.mbV = new arf().JF(k.xF());
                            bmVar.eeO = 2;
                            bmVar.mbY = new are().ba(new byte[0]);
                            bmVar.gll = be.getInt(split[0], 0);
                            bmVar.mbX = be.getInt(split[1], 0);
                            bmVar.mbW = new arf().JF(split[2]);
                            cSN.add(bmVar);
                        }
                    } else {
                        try {
                            bufferedReader.close();
                            return;
                        } catch (Exception e2) {
                            return;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
        } catch (Exception e4) {
            e = e4;
            bufferedReader = null;
            try {
                v.e("MicroMsg.TestSyncAddMsg", "readMsgFromFile failed e:%s", e.getMessage());
                v.a("MicroMsg.TestSyncAddMsg", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                try {
                    bufferedReader.close();
                } catch (Exception e5) {
                }
            } catch (Throwable th) {
                e = th;
                try {
                    bufferedReader.close();
                } catch (Exception e6) {
                }
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            bufferedReader.close();
            throw e;
        }
    }

    static /* synthetic */ void sq() {
        ak.yW();
        Cursor d = c.wH().d(null, null, new ArrayList());
        while (d.moveToNext()) {
            u uVar = new u();
            uVar.b(d);
            cSO.add(uVar);
        }
        d.close();
    }

    public static void aJ(final int i, final int i2) {
        ak.vA().x(new Runnable() {
            public final void run() {
                r.sq();
                r.jr(e.cnj + "/testaddmsg.txt");
                if (r.cSO.size() <= 0 || r.cSN.size() <= 0) {
                    v.e("MicroMsg.TestSyncAddMsg", "syncAddMsg get source failed cmd:%d contact:%d", Integer.valueOf(r.cSN.size()), Integer.valueOf(r.cSO.size()));
                    return;
                }
                new ah(ak.vA().htb.getLooper(), new a(this) {
                    int cSR = i;
                    final /* synthetic */ AnonymousClass1 cSS;

                    {
                        this.cSS = r2;
                    }

                    public final boolean oU() {
                        if (this.cSR <= 0) {
                            return false;
                        }
                        this.cSR--;
                        b bVar = new b();
                        bVar.lXt.mkI = new la();
                        int cW = be.cW(i2, 1);
                        for (int i = 0; i < cW; i++) {
                            bm bmVar = (bm) r.cSN.get(be.cW(r.cSN.size() - 1, 0));
                            bmVar.mbU = new arf().JF(((u) r.cSO.get(be.cW(r.cSO.size() - 1, 0))).field_username);
                            bmVar.hNS = (int) be.Nh();
                            bmVar.mcb = (long) Math.abs(((int) be.Ni()) % 10000000);
                            try {
                                kz kzVar = new kz();
                                kzVar.mnB = new are();
                                kzVar.mnB.ba(bmVar.toByteArray());
                                kzVar.bkM = 5;
                                bVar.lXt.mkI.eeu.add(kzVar);
                                la laVar = bVar.lXt.mkI;
                                laVar.eet++;
                                v.d("MicroMsg.TestSyncAddMsg", "syncAddMsg  loop:%d cnt:[%d,%d] cmdList:%d id:%d u:%s", Integer.valueOf(this.cSR), Integer.valueOf(i), Integer.valueOf(cW), Integer.valueOf(bVar.lXt.mkI.eeu.size()), Long.valueOf(bmVar.mcb), bmVar.mbU.mQy);
                            } catch (Throwable e) {
                                v.d("MicroMsg.TestSyncAddMsg", e.getMessage());
                                v.a("MicroMsg.TestSyncAddMsg", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                            }
                        }
                        bVar.lXt.miR = 0;
                        akf com_tencent_mm_protocal_c_akf = bVar.lXt;
                        ak.yW();
                        com_tencent_mm_protocal_c_akf.mkF = m.H(be.KG(be.ma((String) c.vf().get(8195, new byte[0]))));
                        bVar.lXt.mcj = 0;
                        bVar.lXt.eeO = 0;
                        o.Ho().a(bVar, 0, be.Nh());
                        return true;
                    }
                }, true).ea(3000);
            }
        });
    }
}
