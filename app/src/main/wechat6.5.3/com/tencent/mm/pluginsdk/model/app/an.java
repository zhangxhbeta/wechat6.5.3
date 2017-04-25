package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.protocal.c.agw;
import com.tencent.mm.protocal.c.agx;
import com.tencent.mm.protocal.c.zl;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class an implements s, e {
    private static an lBA;
    public String cUi;
    public boolean lBB = false;
    public boolean lBC = false;
    private List<String> lBD = new LinkedList();
    public long lBE;
    private final int lBF = 20;
    public int lBG = 0;
    public long lBH;

    private an() {
    }

    public static an bnG() {
        if (lBA == null) {
            lBA = new an();
        }
        return lBA;
    }

    public final void a(int i, int i2, String str, v vVar) {
        if (ak.uz()) {
            this.lBB = false;
            v.d("MicroMsg.SuggestionAppListLogic", "Suggestion onSceneEnd errType=%s errCode=%s", Integer.valueOf(i), Integer.valueOf(i2));
            if (vVar == null) {
                v.e("MicroMsg.SuggestionAppListLogic", "scene == null");
            } else if (i == 0 && i2 == 0) {
                switch (vVar.getType()) {
                    case 4:
                        v.d("MicroMsg.SuggestionAppListLogic", "get suggestion appList, AppCount = %s", Integer.valueOf(((zl) ((af) vVar).fut.czl.czs).mAY));
                        LinkedList linkedList = r13.lAR;
                        if (linkedList == null || linkedList.size() <= 0) {
                            v.w("MicroMsg.SuggestionAppListLogic", "empty suggestAppList");
                            return;
                        } else if (aa.getContext() == null || a.lxJ == null) {
                            v.e("MicroMsg.SuggestionAppListLogic", "wrong environment");
                            return;
                        } else {
                            f fVar;
                            LinkedList linkedList2 = new LinkedList();
                            Iterator it = linkedList.iterator();
                            while (it.hasNext()) {
                                fVar = (f) it.next();
                                String str2 = "MicroMsg.SuggestionAppListLogic";
                                String str3 = "suggestion appName=%s, packageName=%s, signature [%s], introUrl [%s], has iconUrl [%s]";
                                Object[] objArr = new Object[5];
                                objArr[0] = fVar.field_appName;
                                objArr[1] = fVar.field_packageName;
                                objArr[2] = fVar.field_signature;
                                objArr[3] = fVar.bxw;
                                objArr[4] = Boolean.valueOf(fVar.bxv != null);
                                v.d(str2, str3, objArr);
                                linkedList2.add(fVar.field_appId);
                            }
                            a.lxJ.ae(linkedList2);
                            List<f> dh = g.dh(aa.getContext());
                            if (dh.size() > 0) {
                                i bmv = a.lxJ.bmv();
                                for (f fVar2 : dh) {
                                    if (fVar2.field_appId != null) {
                                        Object obj;
                                        Iterator it2 = linkedList.iterator();
                                        while (it2.hasNext()) {
                                            fVar = (f) it2.next();
                                            if (fVar.field_appId != null && fVar2.field_appId.equals(fVar.field_appId)) {
                                                obj = 1;
                                                if (obj != null) {
                                                    if (g.a(aa.getContext(), fVar2)) {
                                                        fVar2.field_status = 4;
                                                    } else {
                                                        fVar2.field_status = 1;
                                                    }
                                                    bmv.a(fVar2, new String[0]);
                                                }
                                            }
                                        }
                                        obj = null;
                                        if (obj != null) {
                                            if (g.a(aa.getContext(), fVar2)) {
                                                fVar2.field_status = 4;
                                            } else {
                                                fVar2.field_status = 1;
                                            }
                                            bmv.a(fVar2, new String[0]);
                                        }
                                    }
                                }
                            }
                            ak.yW();
                            c.vf().setLong(352275, System.currentTimeMillis());
                            this.lBE = System.currentTimeMillis();
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    public final void dj(Context context) {
        if (!ak.uz() || context == null) {
            return;
        }
        if (this.lBC) {
            v.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
            return;
        }
        this.lBC = true;
        if (this.cUi == null) {
            this.cUi = u.d(context.getSharedPreferences(aa.bti(), 0));
        }
        v.i("MicroMsg.SuggestionAppListLogic", "getServiceAppListImmediately");
        bC(this.cUi, this.lBG);
    }

    public static void bC(String str, int i) {
        v.i("MicroMsg.SuggestionAppListLogic", "get service app, offset = %d, lang = %s", Integer.valueOf(i), str);
        ak.vy().a(new ae(i, str), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (ak.uz()) {
            this.lBC = false;
            if (kVar == null) {
                v.e("MicroMsg.SuggestionAppListLogic", "scene == null");
                this.lBG = 0;
                this.lBD.clear();
                return;
            } else if (i == 0 && i2 == 0) {
                v.i("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                ae aeVar = (ae) kVar;
                agw com_tencent_mm_protocal_c_agw = (aeVar.cif == null || aeVar.cif.czl.czs == null) ? null : (agw) aeVar.cif.czl.czs;
                if (com_tencent_mm_protocal_c_agw == null) {
                    v.e("MicroMsg.SuggestionAppListLogic", "resp == null");
                    this.lBG = 0;
                    this.lBD.clear();
                    return;
                } else if (com_tencent_mm_protocal_c_agw.mGs == null || com_tencent_mm_protocal_c_agw.mGs.size() <= 0) {
                    v.e("MicroMsg.SuggestionAppListLogic", "Service_appinfo empty");
                    a(a.lxJ.bmv(), this.lBD);
                    this.lBG = 0;
                    this.lBD.clear();
                    ak.yW();
                    c.vf().setLong(352276, System.currentTimeMillis());
                    this.lBH = System.currentTimeMillis();
                    return;
                } else {
                    v.i("MicroMsg.SuggestionAppListLogic", "offset = %d, count = %s", Integer.valueOf(this.lBG), Integer.valueOf(com_tencent_mm_protocal_c_agw.mGs.size()));
                    i bmv = a.lxJ.bmv();
                    List linkedList = new LinkedList();
                    Iterator it = com_tencent_mm_protocal_c_agw.mGs.iterator();
                    while (it.hasNext()) {
                        agx com_tencent_mm_protocal_c_agx = (agx) it.next();
                        v.v("MicroMsg.SuggestionAppListLogic", "service info: %s, %s, %s, %s, %s, %s", com_tencent_mm_protocal_c_agx.mlK, Integer.valueOf(com_tencent_mm_protocal_c_agx.mGx), Integer.valueOf(com_tencent_mm_protocal_c_agx.mGB), Integer.valueOf(com_tencent_mm_protocal_c_agx.mGA), Integer.valueOf(com_tencent_mm_protocal_c_agx.mGy), com_tencent_mm_protocal_c_agx.bmJ);
                        if (!be.kS(com_tencent_mm_protocal_c_agx.bmJ)) {
                            if (f.lAp.equals(com_tencent_mm_protocal_c_agx.bmJ)) {
                                com_tencent_mm_protocal_c_agx.mGy = (com_tencent_mm_protocal_c_agx.mGy ^ 253) ^ -1;
                                v.d("MicroMsg.SuggestionAppListLogic", "aa change: %s", Integer.valueOf(com_tencent_mm_protocal_c_agx.mGy));
                            }
                            this.lBD.add(com_tencent_mm_protocal_c_agx.bmJ);
                            f aC = g.aC(com_tencent_mm_protocal_c_agx.bmJ, true);
                            if (aC != null) {
                                Object obj = aC.field_serviceAppInfoFlag != com_tencent_mm_protocal_c_agx.mGy ? 1 : aC.field_serviceAppType != com_tencent_mm_protocal_c_agx.mGx ? 1 : aC.bxJ != com_tencent_mm_protocal_c_agx.mGA ? 1 : aC.field_serviceShowFlag != com_tencent_mm_protocal_c_agx.mGB ? 1 : !be.ma(aC.field_appName).equals(be.ma(com_tencent_mm_protocal_c_agx.mlK)) ? 1 : !be.ma(aC.field_appName_en).equals(be.ma(com_tencent_mm_protocal_c_agx.mGt)) ? 1 : !be.ma(aC.field_appName_tw).equals(be.ma(com_tencent_mm_protocal_c_agx.mGu)) ? 1 : !be.ma(aC.field_appName_hk).equals(be.ma(com_tencent_mm_protocal_c_agx.mGF)) ? 1 : !be.ma(aC.bxH).equals(be.ma(com_tencent_mm_protocal_c_agx.mGw)) ? 1 : !be.ma(aC.bxG).equals(be.ma(com_tencent_mm_protocal_c_agx.mGv)) ? 1 : !be.ma(aC.bxI).equals(be.ma(com_tencent_mm_protocal_c_agx.mGz)) ? 1 : null;
                                if (obj != null) {
                                    String str2 = aC.bxH;
                                    String str3 = aC.bxG;
                                    a(aC, com_tencent_mm_protocal_c_agx);
                                    boolean a = bmv.a(aC, new String[0]);
                                    if (!be.ma(str2).equals(be.ma(com_tencent_mm_protocal_c_agx.mGw))) {
                                        v.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_list" + be.ma(com_tencent_mm_protocal_c_agx.mGw));
                                        am.bnz().bz(aC.field_appId, 5);
                                    }
                                    if (!be.ma(str3).equals(be.ma(com_tencent_mm_protocal_c_agx.mGv))) {
                                        v.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_panel" + be.ma(com_tencent_mm_protocal_c_agx.mGv));
                                        am.bnz().bz(aC.field_appId, 4);
                                    }
                                    v.i("MicroMsg.SuggestionAppListLogic", "update app: AppID = %s, ret = %s", com_tencent_mm_protocal_c_agx.bmJ, Boolean.valueOf(a));
                                }
                            } else {
                                aC = new f();
                                aC.field_appId = com_tencent_mm_protocal_c_agx.bmJ;
                                a(aC, com_tencent_mm_protocal_c_agx);
                                boolean m = bmv.m(aC);
                                v.i("MicroMsg.SuggestionAppListLogic", "insert app: AppID = %s, ret = %s", com_tencent_mm_protocal_c_agx.bmJ, Boolean.valueOf(m));
                            }
                            if (be.kS(aC.field_openId)) {
                                linkedList.add(com_tencent_mm_protocal_c_agx.bmJ);
                            }
                        }
                    }
                    if (linkedList.size() > 0) {
                        v.d("MicroMsg.SuggestionAppListLogic", "needGetOpenIdList %d", Integer.valueOf(linkedList.size()));
                        am.bnF().bK(linkedList);
                    }
                    if (com_tencent_mm_protocal_c_agw.mGs.size() == 20) {
                        this.lBG += 20;
                        bC(this.cUi, this.lBG);
                    } else {
                        a(bmv, this.lBD);
                        this.lBG = 0;
                        this.lBD.clear();
                    }
                    ak.yW();
                    c.vf().setLong(352276, System.currentTimeMillis());
                    this.lBH = System.currentTimeMillis();
                    return;
                }
            } else {
                v.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                this.lBG = 0;
                this.lBD.clear();
                return;
            }
        }
        v.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd account not ready");
        this.lBG = 0;
        this.lBD.clear();
    }

    private static void a(i iVar, List<String> list) {
        if (iVar != null && list != null && list.size() > 0) {
            v.d("MicroMsg.SuggestionAppListLogic", "removeExpiredServiceApp");
            List<f> arrayList = new ArrayList();
            if (a.lxJ == null) {
                v.e("MicroMsg.AppInfoLogic", "getAllServices, getISubCorePluginBase() == null");
            } else {
                Cursor bmw = a.lxJ.bmw();
                if (bmw != null) {
                    while (bmw.moveToNext()) {
                        f fVar = new f();
                        fVar.b(bmw);
                        if (!be.kS(fVar.field_openId)) {
                            arrayList.add(fVar);
                        }
                    }
                    bmw.close();
                }
            }
            v.d("MicroMsg.SuggestionAppListLogic", "oldList %d", Integer.valueOf(arrayList.size()));
            if (arrayList.size() > 0) {
                for (f fVar2 : arrayList) {
                    if (fVar2.field_appId != null) {
                        int i;
                        for (String equals : list) {
                            if (fVar2.field_appId.equals(equals)) {
                                i = 1;
                                break;
                            }
                        }
                        i = 0;
                        if (i == 0) {
                            boolean b = iVar.b(fVar2, new String[0]);
                            v.d("MicroMsg.SuggestionAppListLogic", "delete old service : %s, %s", fVar2.field_appId, Boolean.valueOf(b));
                        }
                    }
                }
            }
        }
    }

    private static void a(f fVar, agx com_tencent_mm_protocal_c_agx) {
        fVar.field_appName = com_tencent_mm_protocal_c_agx.mlK;
        fVar.field_appName_en = com_tencent_mm_protocal_c_agx.mGt;
        fVar.field_appName_tw = com_tencent_mm_protocal_c_agx.mGu;
        fVar.field_appName_hk = com_tencent_mm_protocal_c_agx.mGF;
        fVar.bxG = com_tencent_mm_protocal_c_agx.mGv;
        fVar.bwK = true;
        fVar.bxH = com_tencent_mm_protocal_c_agx.mGw;
        fVar.bwK = true;
        fVar.bxI = com_tencent_mm_protocal_c_agx.mGz;
        fVar.bwK = true;
        fVar.field_serviceAppInfoFlag = com_tencent_mm_protocal_c_agx.mGy;
        fVar.field_serviceAppType = com_tencent_mm_protocal_c_agx.mGx;
        fVar.bxJ = com_tencent_mm_protocal_c_agx.mGA;
        fVar.bwK = true;
        fVar.field_serviceShowFlag = com_tencent_mm_protocal_c_agx.mGB;
    }
}
