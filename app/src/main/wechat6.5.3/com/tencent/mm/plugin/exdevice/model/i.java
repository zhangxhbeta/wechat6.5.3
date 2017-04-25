package com.tencent.mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.tencent.mm.e.b.bk;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.protocal.c.abt;
import com.tencent.mm.protocal.c.abu;
import com.tencent.mm.protocal.c.ajb;
import com.tencent.mm.protocal.c.tu;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public enum i implements e {
    ;
    
    private ProgressDialog dwR;
    private boolean fuk;
    public a ful;

    public interface a {
        void cN(boolean z);
    }

    private i(String str) {
        this.fuk = false;
        SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences("exdevice_pref", 0);
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        if (sharedPreferences.getLong(stringBuilder.append(c.ww()).toString(), 0) != 0) {
            v.i("MicroMsg.exdevice.GetBoundDeviceLogic", "this user has get bound device, last time is %d", new Object[]{Long.valueOf(sharedPreferences.getLong(stringBuilder.append(c.ww()).toString(), 0))});
            return;
        }
        v.i("MicroMsg.exdevice.GetBoundDeviceLogic", "the user has not get bound device yet");
    }

    public final void a(Context context, final a aVar) {
        v.i("MicroMsg.exdevice.GetBoundDeviceLogic", "startGetBoundHardDevices");
        if (this.fuk) {
            if (this.ful == null) {
                this.ful = aVar;
            }
            v.i("MicroMsg.exdevice.GetBoundDeviceLogic", "getting bound device now, just leave");
            return;
        }
        final o oVar = new o();
        if (!(context == null || !(context instanceof Activity) || ((Activity) context).isFinishing())) {
            if (this.dwR != null && this.dwR.isShowing()) {
                this.dwR.dismiss();
            }
            context.getString(2131231164);
            this.dwR = g.a(context, context.getString(2131234767), new OnCancelListener(this) {
                final /* synthetic */ i fup;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(oVar);
                    this.fup.dwR.dismiss();
                    this.fup.fuk = false;
                    if (aVar != null) {
                        aVar.cN(false);
                    }
                }
            });
        }
        this.ful = aVar;
        ak.vy().a(oVar, 0);
    }

    public final boolean cO(boolean z) {
        if (this.fuk) {
            v.i("MicroMsg.exdevice.GetBoundDeviceLogic", "Getting bound device now, just leave");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences("exdevice_pref", 0);
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        long j = sharedPreferences.getLong(stringBuilder.append(c.ww()).toString(), 0);
        if (z || currentTimeMillis - j >= 86400000) {
            return true;
        }
        v.i("MicroMsg.exdevice.GetBoundDeviceLogic", "GetBoundHardDevices not now pp");
        return false;
    }

    public static void ba(long j) {
        v.i("MicroMsg.exdevice.GetBoundDeviceLogic", "update get bound hard device time : %d", new Object[]{Long.valueOf(j)});
        Editor edit = aa.getContext().getSharedPreferences("exdevice_pref", 0).edit();
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        edit.putLong(stringBuilder.append(c.ww()).toString(), j).commit();
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.exdevice.GetBoundDeviceLogic", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        this.fuk = false;
        if (kVar != null && i2 == 0 && i == 0) {
            v.i("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s", new Object[]{Integer.valueOf(kVar.getType())});
            if (kVar.getType() == 539) {
                if (i == 0 && i2 == 0) {
                    o oVar = (o) kVar;
                    final tu tuVar = (oVar.cif == null || oVar.cif.czl.czs == null) ? null : (tu) oVar.cif.czl.czs;
                    if (tuVar == null || tuVar.mwQ == null) {
                        if (this.ful != null) {
                            this.ful.cN(false);
                        }
                        if (this.dwR != null && this.dwR.isShowing()) {
                            this.dwR.dismiss();
                            return;
                        }
                        return;
                    }
                    ak.vA().x(new Runnable(this) {
                        final /* synthetic */ i fup;

                        public final void run() {
                            i.ba(be.Ni());
                            com.tencent.mm.plugin.exdevice.h.c ajq = ac.ajq();
                            List<b> linkedList = new LinkedList();
                            Cursor Kp = ajq.Kp();
                            Iterator it;
                            abt com_tencent_mm_protocal_c_abt;
                            Object obj;
                            Iterator it2;
                            Object obj2;
                            ajb com_tencent_mm_protocal_c_ajb;
                            abu com_tencent_mm_protocal_c_abu;
                            abt com_tencent_mm_protocal_c_abt2;
                            bk sq;
                            b bVar;
                            boolean b;
                            if (Kp == null || !Kp.moveToFirst()) {
                                if (Kp != null) {
                                    Kp.close();
                                }
                                for (b bVar2 : linkedList) {
                                    it = tuVar.mwQ.iterator();
                                    while (it.hasNext()) {
                                        com_tencent_mm_protocal_c_abt = ((ajb) it.next()).mgm;
                                        if (!bVar2.field_deviceType.equals(com_tencent_mm_protocal_c_abt.meq) && bVar2.field_deviceID.equals(com_tencent_mm_protocal_c_abt.eez)) {
                                            obj = 1;
                                            break;
                                        }
                                    }
                                    obj = null;
                                    if (obj == null) {
                                        v.d("MicroMsg.exdevice.GetBoundDeviceLogic", "delete deviceId %s, deviceType %s ", new Object[]{bVar2.field_deviceID, bVar2.field_deviceType});
                                        i.g(bVar2);
                                        ac.ajq().bu(bVar2.field_deviceID, bVar2.field_deviceType);
                                        ac.ajB();
                                        e.Q(bVar2.field_deviceID, false);
                                    }
                                }
                                it2 = tuVar.mwQ.iterator();
                                obj2 = null;
                                while (it2.hasNext()) {
                                    com_tencent_mm_protocal_c_ajb = (ajb) it2.next();
                                    com_tencent_mm_protocal_c_abu = com_tencent_mm_protocal_c_ajb.mgn;
                                    com_tencent_mm_protocal_c_abt2 = com_tencent_mm_protocal_c_ajb.mgm;
                                    if (!(com_tencent_mm_protocal_c_abt2 == null || com_tencent_mm_protocal_c_abu == null || be.kS(com_tencent_mm_protocal_c_abt2.eez))) {
                                        v.i("MicroMsg.exdevice.GetBoundDeviceLogic", "ModHardDevice deviceId = %s, deviceType = %s, BindFlag = %s", new Object[]{com_tencent_mm_protocal_c_abt2.eez, com_tencent_mm_protocal_c_abt2.meq, Integer.valueOf(com_tencent_mm_protocal_c_ajb.mJz)});
                                        sq = ac.ajq().sq(com_tencent_mm_protocal_c_abt2.eez);
                                        if (2 != com_tencent_mm_protocal_c_ajb.mJz) {
                                            v.w("MicroMsg.exdevice.GetBoundDeviceLogic", "This Device is unbind, Just leave. deviceId = %s, mac = %s, brandName = %s", new Object[]{com_tencent_mm_protocal_c_abt2.eez, com_tencent_mm_protocal_c_abu.mfU, com_tencent_mm_protocal_c_abu.mCM});
                                            if (sq != null) {
                                                i.g(sq);
                                                ac.ajq().bu(sq.field_deviceID, sq.field_deviceType);
                                                ac.ajB();
                                                e.Q(sq.field_deviceID, false);
                                            }
                                        } else {
                                            bVar = new b();
                                            bVar.field_deviceID = com_tencent_mm_protocal_c_abt2.eez;
                                            bVar.field_deviceType = com_tencent_mm_protocal_c_abt2.meq;
                                            bVar.field_connProto = com_tencent_mm_protocal_c_abu.mCN;
                                            bVar.field_connStrategy = com_tencent_mm_protocal_c_abu.mCO;
                                            bVar.field_closeStrategy = com_tencent_mm_protocal_c_abu.mCP;
                                            if (!(com_tencent_mm_protocal_c_abu.bLg != 2 || sq == null || sq.bLc == null)) {
                                                com_tencent_mm_protocal_c_abu.cHh = sq.bLc;
                                            }
                                            bVar.bP(com_tencent_mm_protocal_c_abu.cHh);
                                            bVar.cC(com_tencent_mm_protocal_c_abu.mCV);
                                            bVar.cB(com_tencent_mm_protocal_c_abu.mCU);
                                            bVar.cA(com_tencent_mm_protocal_c_abu.mCT);
                                            bVar.dp(com_tencent_mm_protocal_c_abu.mCW);
                                            bVar.cy(com_tencent_mm_protocal_c_abu.gnp);
                                            bVar.cz(com_tencent_mm_protocal_c_abu.gkT);
                                            bVar.dq(com_tencent_mm_protocal_c_abu.bLg);
                                            bVar.w(com_tencent_mm_protocal_c_abu.bLh);
                                            bVar.cD(com_tencent_mm_protocal_c_abu.bLi);
                                            bVar.cE(com_tencent_mm_protocal_c_abu.bLj);
                                            bVar.cF(com_tencent_mm_protocal_c_abu.bLk);
                                            bVar.cG(com_tencent_mm_protocal_c_abu.bLl);
                                            bVar.field_url = "";
                                            bVar.field_mac = com.tencent.mm.plugin.exdevice.j.b.sE(com.tencent.mm.plugin.exdevice.j.b.sF(com_tencent_mm_protocal_c_abu.mfU));
                                            bVar.field_md5Str = com.tencent.mm.a.g.m(new String(com_tencent_mm_protocal_c_abt2.meq + com_tencent_mm_protocal_c_abt2.eez).getBytes());
                                            bVar.field_authKey = com_tencent_mm_protocal_c_abu.mec;
                                            bVar.field_brandName = com_tencent_mm_protocal_c_abu.mCM;
                                            if (bVar.field_mac == 0) {
                                                bVar.field_mac = System.currentTimeMillis();
                                            }
                                            if (sq == null) {
                                                b = ac.ajq().b(bVar);
                                                if (b) {
                                                    ac.ajB();
                                                    e.Q(bVar.field_deviceID, true);
                                                }
                                            } else {
                                                b = ac.ajq().h(bVar) == 0;
                                            }
                                            v.i("MicroMsg.exdevice.GetBoundDeviceLogic", "insert HardDeviceInfo %s, brandName = %s, deviceID = %s, deviceType = %s, connProto = %s, connStrategy = %s, closeStrategy = %s, mac = %s", new Object[]{Boolean.valueOf(b), bVar.field_brandName, bVar.field_deviceID, com_tencent_mm_protocal_c_abt2.meq, bVar.field_connProto, Integer.valueOf(bVar.field_connStrategy), Integer.valueOf(bVar.field_closeStrategy), Long.valueOf(bVar.field_mac)});
                                            if (obj2 == null || bVar.field_connProto == null || !bVar.field_connProto.contains("6")) {
                                                obj = obj2;
                                            } else {
                                                ak.yW();
                                                u LX = c.wH().LX(bVar.field_brandName);
                                                if (LX == null || !com.tencent.mm.i.a.ei(LX.field_type)) {
                                                    v.w("MicroMsg.exdevice.GetBoundDeviceLogic", "[hakon][step]%s is step device but not contact", new Object[]{bVar.field_brandName});
                                                } else {
                                                    v.w("MicroMsg.exdevice.GetBoundDeviceLogic", "[hakon][step]%s NeedStepCounter", new Object[]{bVar.field_brandName});
                                                    com.tencent.mm.plugin.exdevice.devicestep.c.cI(true);
                                                    obj = 1;
                                                }
                                            }
                                            obj2 = obj;
                                        }
                                    }
                                }
                            }
                            do {
                                b bVar3 = new b();
                                bVar3.b(Kp);
                                linkedList.add(bVar3);
                            } while (Kp.moveToNext());
                            if (Kp != null) {
                                Kp.close();
                            }
                            for (b bVar22 : linkedList) {
                                it = tuVar.mwQ.iterator();
                                while (it.hasNext()) {
                                    com_tencent_mm_protocal_c_abt = ((ajb) it.next()).mgm;
                                    if (!bVar22.field_deviceType.equals(com_tencent_mm_protocal_c_abt.meq)) {
                                    }
                                }
                                obj = null;
                                if (obj == null) {
                                    v.d("MicroMsg.exdevice.GetBoundDeviceLogic", "delete deviceId %s, deviceType %s ", new Object[]{bVar22.field_deviceID, bVar22.field_deviceType});
                                    i.g(bVar22);
                                    ac.ajq().bu(bVar22.field_deviceID, bVar22.field_deviceType);
                                    ac.ajB();
                                    e.Q(bVar22.field_deviceID, false);
                                }
                            }
                            it2 = tuVar.mwQ.iterator();
                            obj2 = null;
                            while (it2.hasNext()) {
                                com_tencent_mm_protocal_c_ajb = (ajb) it2.next();
                                com_tencent_mm_protocal_c_abu = com_tencent_mm_protocal_c_ajb.mgn;
                                com_tencent_mm_protocal_c_abt2 = com_tencent_mm_protocal_c_ajb.mgm;
                                v.i("MicroMsg.exdevice.GetBoundDeviceLogic", "ModHardDevice deviceId = %s, deviceType = %s, BindFlag = %s", new Object[]{com_tencent_mm_protocal_c_abt2.eez, com_tencent_mm_protocal_c_abt2.meq, Integer.valueOf(com_tencent_mm_protocal_c_ajb.mJz)});
                                sq = ac.ajq().sq(com_tencent_mm_protocal_c_abt2.eez);
                                if (2 != com_tencent_mm_protocal_c_ajb.mJz) {
                                    bVar = new b();
                                    bVar.field_deviceID = com_tencent_mm_protocal_c_abt2.eez;
                                    bVar.field_deviceType = com_tencent_mm_protocal_c_abt2.meq;
                                    bVar.field_connProto = com_tencent_mm_protocal_c_abu.mCN;
                                    bVar.field_connStrategy = com_tencent_mm_protocal_c_abu.mCO;
                                    bVar.field_closeStrategy = com_tencent_mm_protocal_c_abu.mCP;
                                    com_tencent_mm_protocal_c_abu.cHh = sq.bLc;
                                    bVar.bP(com_tencent_mm_protocal_c_abu.cHh);
                                    bVar.cC(com_tencent_mm_protocal_c_abu.mCV);
                                    bVar.cB(com_tencent_mm_protocal_c_abu.mCU);
                                    bVar.cA(com_tencent_mm_protocal_c_abu.mCT);
                                    bVar.dp(com_tencent_mm_protocal_c_abu.mCW);
                                    bVar.cy(com_tencent_mm_protocal_c_abu.gnp);
                                    bVar.cz(com_tencent_mm_protocal_c_abu.gkT);
                                    bVar.dq(com_tencent_mm_protocal_c_abu.bLg);
                                    bVar.w(com_tencent_mm_protocal_c_abu.bLh);
                                    bVar.cD(com_tencent_mm_protocal_c_abu.bLi);
                                    bVar.cE(com_tencent_mm_protocal_c_abu.bLj);
                                    bVar.cF(com_tencent_mm_protocal_c_abu.bLk);
                                    bVar.cG(com_tencent_mm_protocal_c_abu.bLl);
                                    bVar.field_url = "";
                                    bVar.field_mac = com.tencent.mm.plugin.exdevice.j.b.sE(com.tencent.mm.plugin.exdevice.j.b.sF(com_tencent_mm_protocal_c_abu.mfU));
                                    bVar.field_md5Str = com.tencent.mm.a.g.m(new String(com_tencent_mm_protocal_c_abt2.meq + com_tencent_mm_protocal_c_abt2.eez).getBytes());
                                    bVar.field_authKey = com_tencent_mm_protocal_c_abu.mec;
                                    bVar.field_brandName = com_tencent_mm_protocal_c_abu.mCM;
                                    if (bVar.field_mac == 0) {
                                        bVar.field_mac = System.currentTimeMillis();
                                    }
                                    if (sq == null) {
                                        b = ac.ajq().b(bVar);
                                        if (b) {
                                            ac.ajB();
                                            e.Q(bVar.field_deviceID, true);
                                        }
                                    } else if (ac.ajq().h(bVar) == 0) {
                                    }
                                    v.i("MicroMsg.exdevice.GetBoundDeviceLogic", "insert HardDeviceInfo %s, brandName = %s, deviceID = %s, deviceType = %s, connProto = %s, connStrategy = %s, closeStrategy = %s, mac = %s", new Object[]{Boolean.valueOf(b), bVar.field_brandName, bVar.field_deviceID, com_tencent_mm_protocal_c_abt2.meq, bVar.field_connProto, Integer.valueOf(bVar.field_connStrategy), Integer.valueOf(bVar.field_closeStrategy), Long.valueOf(bVar.field_mac)});
                                    if (obj2 == null) {
                                    }
                                    obj = obj2;
                                    obj2 = obj;
                                } else {
                                    v.w("MicroMsg.exdevice.GetBoundDeviceLogic", "This Device is unbind, Just leave. deviceId = %s, mac = %s, brandName = %s", new Object[]{com_tencent_mm_protocal_c_abt2.eez, com_tencent_mm_protocal_c_abu.mfU, com_tencent_mm_protocal_c_abu.mCM});
                                    if (sq != null) {
                                        i.g(sq);
                                        ac.ajq().bu(sq.field_deviceID, sq.field_deviceType);
                                        ac.ajB();
                                        e.Q(sq.field_deviceID, false);
                                    }
                                }
                            }
                        }
                    });
                    if (this.ful != null) {
                        this.ful.cN(true);
                    }
                } else {
                    v.e("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s, %s, %s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
                    if (this.ful != null) {
                        this.ful.cN(false);
                    }
                    if (this.dwR != null && this.dwR.isShowing()) {
                        this.dwR.dismiss();
                        return;
                    }
                    return;
                }
            }
            if (this.dwR != null && this.dwR.isShowing()) {
                this.dwR.dismiss();
                return;
            }
            return;
        }
        v.e("MicroMsg.exdevice.GetBoundDeviceLogic", "do scene failed : %d, %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
    }
}
