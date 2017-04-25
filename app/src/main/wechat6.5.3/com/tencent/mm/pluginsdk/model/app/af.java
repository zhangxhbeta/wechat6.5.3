package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.protocal.c.ao;
import com.tencent.mm.protocal.c.apd;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.protocal.c.zk;
import com.tencent.mm.protocal.c.zl;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.b.b;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;
import java.util.LinkedList;

public final class af extends v {
    LinkedList<f> lAR;
    private LinkedList<f> lAS;
    private LinkedList<String> lAT;
    private int lAU;

    public af(String str, LinkedList<String> linkedList) {
        v.i("MicroMsg.NetSceneGetSuggestionAppList", "offset: 0" + ", limit = 20, lang = " + str + "installedApp list size: " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            v.i("MicroMsg.NetSceneGetSuggestionAppList", "install id:[%s]", (String) it.next());
        }
        this.lAU = 3;
        a aVar = new a();
        aVar.czn = new zk();
        aVar.czo = new zl();
        aVar.uri = "/cgi-bin/micromsg-bin/getsuggestionapplist";
        aVar.czm = 409;
        aVar.czp = 0;
        aVar.czq = 0;
        this.fut = aVar.Bv();
        zk zkVar = (zk) this.fut.czk.czs;
        zkVar.mAW = 3;
        zkVar.gmn = 0;
        zkVar.gmo = 20;
        zkVar.glC = str;
        LinkedList ag = ag(linkedList);
        zkVar.mAX = ag.size();
        zkVar.glQ = ag;
        this.lAR = new LinkedList();
        this.lAS = new LinkedList();
        this.lAT = new LinkedList();
        this.lAT.addAll(linkedList);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            zl zlVar = (zl) this.fut.czl.czs;
            if (zlVar == null) {
                v.e("MicroMsg.NetSceneGetSuggestionAppList", "resp == null");
                return;
            }
            v.v("MicroMsg.NetSceneGetSuggestionAppList", "suggestion app count = %s, appType = %s, ", Integer.valueOf(zlVar.mAY), Integer.valueOf(this.lAU));
            i bmv = j.a.lxJ.bmv();
            b(bmv, zlVar.mAZ);
            a(bmv, zlVar.gmZ);
            return;
        }
        v.e("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + i2 + ", errCode = " + i3);
    }

    private void a(i iVar, LinkedList<ao> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                Object obj;
                ao aoVar = (ao) it.next();
                f aC = g.aC(aoVar.gkz, true);
                if (aC != null) {
                    a(aC, aoVar);
                    iVar.a(aC, new String[0]);
                    obj = aC;
                } else {
                    aC = new f();
                    aC.field_appId = aoVar.gkz;
                    a(aC, aoVar);
                    iVar.m(aC);
                    f fVar = aC;
                }
                this.lAS.add(obj);
            }
        }
    }

    private void b(i iVar, LinkedList<apd> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                apd com_tencent_mm_protocal_c_apd = (apd) it.next();
                if (be.kS(com_tencent_mm_protocal_c_apd.gkz)) {
                    v.e("MicroMsg.NetSceneGetSuggestionAppList", "error appinfo, the appid is null");
                } else {
                    Object obj;
                    boolean z = true;
                    boolean z2 = false;
                    f aC = g.aC(com_tencent_mm_protocal_c_apd.gkz, true);
                    String str;
                    String str2;
                    Object[] objArr;
                    if (aC != null) {
                        boolean z3;
                        a(aC, com_tencent_mm_protocal_c_apd);
                        if (this.lAU == 3) {
                            aC.field_status = 5;
                            if (be.kS(aC.bxw) || be.kS(aC.bxv)) {
                                str = "MicroMsg.NetSceneGetSuggestionAppList";
                                str2 = "wrong suggestion params1, has IntroUrl %s, has IconUrl %s";
                                objArr = new Object[2];
                                objArr[0] = Boolean.valueOf(aC.bxw != null);
                                objArr[1] = Boolean.valueOf(aC.bxv != null);
                                v.e(str, str2, objArr);
                                z2 = false;
                                z3 = false;
                                v.i("MicroMsg.NetSceneGetSuggestionAppList", "update appinfo: AppID = %s, ret = %s, needAddToList = %s", com_tencent_mm_protocal_c_apd.gkz, Boolean.valueOf(z3), Boolean.valueOf(z2));
                                obj = aC;
                            }
                        }
                        z3 = iVar.a(aC, new String[0]);
                        z2 = true;
                        v.i("MicroMsg.NetSceneGetSuggestionAppList", "update appinfo: AppID = %s, ret = %s, needAddToList = %s", com_tencent_mm_protocal_c_apd.gkz, Boolean.valueOf(z3), Boolean.valueOf(z2));
                        obj = aC;
                    } else {
                        f fVar;
                        aC = new f();
                        aC.field_appId = com_tencent_mm_protocal_c_apd.gkz;
                        a(aC, com_tencent_mm_protocal_c_apd);
                        if (this.lAU == 3) {
                            aC.field_status = 5;
                            if (be.kS(aC.bxw) || be.kS(aC.bxv)) {
                                str = "MicroMsg.NetSceneGetSuggestionAppList";
                                str2 = "wrong suggestion params2, has IntroUrl %s, has IconUrl %s";
                                objArr = new Object[2];
                                objArr[0] = Boolean.valueOf(aC.bxw != null);
                                objArr[1] = Boolean.valueOf(aC.bxv != null);
                                v.e(str, str2, objArr);
                                z = false;
                                v.i("MicroMsg.NetSceneGetSuggestionAppList", "insert appinfo: AppID = %s, ret = %s, needAddToList = %s", com_tencent_mm_protocal_c_apd.gkz, Boolean.valueOf(z2), Boolean.valueOf(z));
                                fVar = aC;
                                z2 = z;
                            }
                        }
                        z2 = iVar.m(aC);
                        v.i("MicroMsg.NetSceneGetSuggestionAppList", "insert appinfo: AppID = %s, ret = %s, needAddToList = %s", com_tencent_mm_protocal_c_apd.gkz, Boolean.valueOf(z2), Boolean.valueOf(z));
                        fVar = aC;
                        z2 = z;
                    }
                    if (!(!z2 || this.lAT.contains(com_tencent_mm_protocal_c_apd.gkz) || this.lAR.contains(obj))) {
                        this.lAR.add(obj);
                    }
                }
            }
        }
    }

    private static LinkedList<arf> ag(LinkedList<String> linkedList) {
        LinkedList<arf> linkedList2 = new LinkedList();
        if (linkedList == null) {
            return linkedList2;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!be.kS(str)) {
                linkedList2.add(m.lY(str));
            }
        }
        return linkedList2;
    }

    private static void a(f fVar, apd com_tencent_mm_protocal_c_apd) {
        fVar.bE(com_tencent_mm_protocal_c_apd.maU);
        fVar.field_appIconUrl = com_tencent_mm_protocal_c_apd.maV;
        fVar.bD(com_tencent_mm_protocal_c_apd.mOF);
        fVar.field_appName = com_tencent_mm_protocal_c_apd.hNZ;
        fVar.bF(com_tencent_mm_protocal_c_apd.maW);
        fVar.field_appType = com_tencent_mm_protocal_c_apd.mdQ;
        fVar.bH(com_tencent_mm_protocal_c_apd.gle);
        fVar.field_packageName = com_tencent_mm_protocal_c_apd.maX;
        fVar.bI(com_tencent_mm_protocal_c_apd.maY);
        if (!be.kS(com_tencent_mm_protocal_c_apd.maY)) {
            v.i("MicroMsg.NetSceneGetSuggestionAppList", "google play download url is : %s, download flag is %d", com_tencent_mm_protocal_c_apd.maY, Integer.valueOf(com_tencent_mm_protocal_c_apd.mOP));
            fVar.cN(com_tencent_mm_protocal_c_apd.mOP);
        }
        fVar.bJ(com_tencent_mm_protocal_c_apd.mOM);
        fVar.bK(com_tencent_mm_protocal_c_apd.mON);
        a(fVar, com_tencent_mm_protocal_c_apd.maZ);
        if (!be.kS(fVar.field_appType)) {
            if (fVar.field_appType.startsWith("1") || fVar.field_appType.startsWith("6")) {
                if (!fVar.field_appType.endsWith(",")) {
                    fVar.field_appType += ",";
                }
                fVar.field_appType = "," + fVar.field_appType;
            }
        }
    }

    private static void a(f fVar, bjk com_tencent_mm_protocal_c_bjk) {
        v.v("MicroMsg.NetSceneGetSuggestionAppList", "dealYYBDownloadInfos, appId = %s", fVar.field_appId);
        if (com_tencent_mm_protocal_c_bjk != null) {
            fVar.cN(com_tencent_mm_protocal_c_bjk.ndR);
            fVar.bN(com_tencent_mm_protocal_c_bjk.mhw);
            fVar.bO(com_tencent_mm_protocal_c_bjk.gop);
            fVar.bL(com_tencent_mm_protocal_c_bjk.ndS);
            fVar.bM(com_tencent_mm_protocal_c_bjk.gor);
            fVar.bxC = com_tencent_mm_protocal_c_bjk.gos;
            fVar.bwK = true;
            fVar.cO(com_tencent_mm_protocal_c_bjk.got);
            v.i("MicroMsg.NetSceneGetSuggestionAppList", "get yyb download infos:[%d],[%s],[%s],[%s],[%s],[%s],[%d]", Integer.valueOf(com_tencent_mm_protocal_c_bjk.ndR), com_tencent_mm_protocal_c_bjk.mhw, com_tencent_mm_protocal_c_bjk.gop, com_tencent_mm_protocal_c_bjk.ndS, com_tencent_mm_protocal_c_bjk.gor, com_tencent_mm_protocal_c_bjk.gos, Integer.valueOf(com_tencent_mm_protocal_c_bjk.got));
        }
    }

    private static void a(f fVar, ao aoVar) {
        fVar.bE(aoVar.maU);
        fVar.bH(aoVar.gle);
        fVar.bF(aoVar.maW);
        fVar.field_appName = aoVar.hNZ;
        fVar.field_appIconUrl = aoVar.maV;
        fVar.bI(aoVar.maY);
        fVar.bxE = aoVar.mba;
        fVar.bwK = true;
        a(fVar, aoVar.maZ);
    }

    public final byte[] arW() {
        try {
            return ((b) this.fut.Bx()).zf();
        } catch (Throwable e) {
            v.e("MicroMsg.NetSceneGetSuggestionAppList", e.getMessage());
            v.a("MicroMsg.NetSceneGetSuggestionAppList", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return null;
        }
    }

    public final void ap(byte[] bArr) {
        if (bArr == null) {
            v.e("MicroMsg.NetSceneGetSuggestionAppList", "buf is null");
            return;
        }
        try {
            this.fut.czl.y(bArr);
        } catch (Throwable e) {
            v.e("MicroMsg.NetSceneGetSuggestionAppList", e.getMessage());
            v.a("MicroMsg.NetSceneGetSuggestionAppList", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public final int getType() {
        return 4;
    }
}
