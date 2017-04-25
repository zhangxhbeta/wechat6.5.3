package com.tencent.mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.e.a.fz;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.protocal.c.abt;
import com.tencent.mm.protocal.c.abu;
import com.tencent.mm.protocal.c.ais;
import com.tencent.mm.protocal.c.asa;
import com.tencent.mm.protocal.c.axg;
import com.tencent.mm.protocal.c.ayf;
import com.tencent.mm.protocal.c.mc;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.b;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ab extends c<fz> implements e {
    private ProgressDialog dwR;
    fz fuO;

    public ab() {
        this.nhz = fz.class.getName().hashCode();
    }

    private boolean a(fz fzVar) {
        if (fzVar instanceof fz) {
            this.fuO = fzVar;
            String str = this.fuO.bfx.bfz;
            v.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "action = %s, key = %s", new Object[]{Integer.valueOf(this.fuO.bfx.actionCode), str});
            if (!be.kS(str)) {
                switch (this.fuO.bfx.actionCode) {
                    case am.CTRL_INDEX /*15*/:
                        if (this.fuO.bfx.context != null && (this.fuO.bfx.context instanceof Activity)) {
                            ak.vy().a(540, this);
                            final u uVar = new u(str);
                            ak.vy().a(uVar, 0);
                            Context context = this.fuO.bfx.context;
                            this.fuO.bfx.context.getString(2131231164);
                            this.dwR = g.a(context, this.fuO.bfx.context.getString(2131234767), new OnCancelListener(this) {
                                final /* synthetic */ ab fuQ;

                                public final void onCancel(DialogInterface dialogInterface) {
                                    ak.vy().c(uVar);
                                    if (this.fuQ.fuO.bpT != null) {
                                        this.fuQ.fuO.bfy.ret = 1;
                                        this.fuQ.fuO.bpT.run();
                                    }
                                }
                            });
                            break;
                        }
                    default:
                        break;
                }
            }
        }
        v.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mismatched event");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        if (this.dwR != null && this.dwR.isShowing()) {
            this.dwR.dismiss();
        }
        if (kVar == null) {
            ajo();
        } else if (i == 0 && i2 == 0) {
            v.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[]{Integer.valueOf(kVar.getType())});
            if (kVar.getType() == 540) {
                ak.vy().b(540, this);
                u uVar = (u) kVar;
                asa com_tencent_mm_protocal_c_asa = (uVar.cif == null || uVar.cif.czl.czs == null) ? null : (asa) uVar.cif.czl.czs;
                if (com_tencent_mm_protocal_c_asa == null) {
                    v.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp == null");
                    ajo();
                    return;
                }
                String str2;
                String str3;
                LinkedList linkedList;
                String str4;
                ArrayList arrayList;
                int i3;
                ayf com_tencent_mm_protocal_c_ayf;
                Intent intent;
                Object obj;
                boolean contains;
                ais com_tencent_mm_protocal_c_ais;
                String ma;
                u LX;
                u uVar2;
                axg com_tencent_mm_protocal_c_axg;
                BizInfo ho;
                mc mcVar;
                abt com_tencent_mm_protocal_c_abt = com_tencent_mm_protocal_c_asa.mgm;
                if (com_tencent_mm_protocal_c_abt != null) {
                    v.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "deviceId = %s, deviceType = %s", new Object[]{com_tencent_mm_protocal_c_abt.eez, com_tencent_mm_protocal_c_abt.meq});
                }
                abu com_tencent_mm_protocal_c_abu = com_tencent_mm_protocal_c_asa.mgn;
                if (com_tencent_mm_protocal_c_abu != null) {
                    v.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "AuthKey = %s, BrandName = %s, CloseStrategy = %s, ConnProto = %s, ConnStrategy = %s, Mac = %s", new Object[]{com_tencent_mm_protocal_c_abu.mec, com_tencent_mm_protocal_c_abu.mCM, Integer.valueOf(com_tencent_mm_protocal_c_abu.mCP), com_tencent_mm_protocal_c_abu.mCN, Integer.valueOf(com_tencent_mm_protocal_c_abu.mCO), com_tencent_mm_protocal_c_abu.mfU});
                }
                String str5 = "";
                String str6 = "";
                LinkedList linkedList2 = new LinkedList();
                if (com_tencent_mm_protocal_c_asa.mQR != null) {
                    if (com_tencent_mm_protocal_c_asa.mQR.mcp != null) {
                        str5 = com_tencent_mm_protocal_c_asa.mQR.mcp;
                    }
                    if (com_tencent_mm_protocal_c_asa.mQR.title != null) {
                        str6 = com_tencent_mm_protocal_c_asa.mQR.title;
                    }
                    if (com_tencent_mm_protocal_c_asa.mQR.mcq != null) {
                        str2 = str5;
                        str3 = str6;
                        linkedList = com_tencent_mm_protocal_c_asa.mQR.mcq;
                        str4 = str3;
                        arrayList = new ArrayList();
                        if (linkedList != null && linkedList.size() > 0) {
                            for (i3 = 0; i3 < linkedList.size(); i3++) {
                                com_tencent_mm_protocal_c_ayf = (ayf) linkedList.get(i3);
                                if (com_tencent_mm_protocal_c_ayf.type.contains("text")) {
                                    arrayList.add(com_tencent_mm_protocal_c_ayf.content);
                                }
                            }
                        }
                        v.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp.BindTicket = %s", new Object[]{com_tencent_mm_protocal_c_asa.mfZ});
                        if (com_tencent_mm_protocal_c_asa.mQQ != 1) {
                            intent = new Intent();
                            intent.putExtra("device_scan_mode", "SCAN_CATALOG");
                            obj = (com_tencent_mm_protocal_c_abu.mCN.contains("3") || com_tencent_mm_protocal_c_abu.mCN.contains("1")) ? 1 : null;
                            contains = com_tencent_mm_protocal_c_abu.mCN.contains("4");
                            if (obj == null && contains) {
                                v.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Category connect proto can not be blue&wifi at the same time...");
                                return;
                            }
                            if (obj != null) {
                                intent.putExtra("device_scan_conn_proto", "blue");
                            } else if (contains) {
                                intent.putExtra("device_scan_conn_proto", "wifi");
                            }
                            intent.putExtra("device_id", com_tencent_mm_protocal_c_abt.eez);
                            intent.putExtra("device_type", com_tencent_mm_protocal_c_abt.meq);
                            intent.putExtra("device_title", com_tencent_mm_protocal_c_abu.mCT);
                            intent.putExtra("device_desc", com_tencent_mm_protocal_c_abu.mCU);
                            intent.putExtra("device_icon_url", com_tencent_mm_protocal_c_abu.gnp);
                            intent.putExtra("device_category_id", com_tencent_mm_protocal_c_abu.mCV);
                            intent.putExtra("device_brand_name", com_tencent_mm_protocal_c_abu.mCM);
                            intent.putExtra("bind_ticket", com_tencent_mm_protocal_c_asa.mfZ);
                            intent.putExtra("device_ble_simple_proto", com_tencent_mm_protocal_c_abu.bLh);
                            intent.putExtra("device_airkiss_key", str2);
                            intent.putExtra("device_airkiss_title", str4);
                            intent.putStringArrayListExtra("device_airkiss_steps", arrayList);
                            com.tencent.mm.ay.c.b(this.fuO.bfx.context, "exdevice", ".ui.ExdeviceBindDeviceGuideUI", intent);
                            Xe();
                        }
                        com_tencent_mm_protocal_c_ais = com_tencent_mm_protocal_c_asa.mga;
                        if (com_tencent_mm_protocal_c_ais != null) {
                            v.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mContact == null");
                            ajo();
                            return;
                        }
                        Xe();
                        if (com_tencent_mm_protocal_c_ais != null) {
                            v.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "unable to parse mod contact");
                        } else {
                            str2 = m.a(com_tencent_mm_protocal_c_ais.moM);
                            ma = be.ma(com_tencent_mm_protocal_c_ais.mJd);
                            if (be.kS(str2) || !be.kS(ma)) {
                                v.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact : %s", new Object[]{str2});
                                ak.yW();
                                LX = com.tencent.mm.model.c.wH().LX(str2);
                                if (LX == null && str2.equals(LX.field_encryptUsername)) {
                                    v.w("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "cat's replace user with stranger");
                                } else {
                                    uVar2 = new u(str2);
                                    uVar2.bP(com_tencent_mm_protocal_c_ais.cHh);
                                    uVar2.setType(com_tencent_mm_protocal_c_ais.mnV & com_tencent_mm_protocal_c_ais.mnW);
                                    if (be.kS(ma)) {
                                        uVar2.bY(ma);
                                    } else if (LX != null && ((int) LX.chr) > 0) {
                                        uVar2.bY(LX.field_encryptUsername);
                                    }
                                    uVar2.chr = LX != null ? 0 : (long) ((int) LX.chr);
                                    uVar2.bS(m.a(com_tencent_mm_protocal_c_ais.mEj));
                                    uVar2.bT(m.a(com_tencent_mm_protocal_c_ais.moC));
                                    uVar2.bU(m.a(com_tencent_mm_protocal_c_ais.moD));
                                    uVar2.cV(com_tencent_mm_protocal_c_ais.cHc);
                                    uVar2.cY(com_tencent_mm_protocal_c_ais.mob);
                                    uVar2.bR(m.a(com_tencent_mm_protocal_c_ais.mIX));
                                    uVar2.cZ(com_tencent_mm_protocal_c_ais.mof);
                                    uVar2.da(com_tencent_mm_protocal_c_ais.cHg);
                                    uVar2.cl(RegionCodeDecoder.Y(com_tencent_mm_protocal_c_ais.cHl, com_tencent_mm_protocal_c_ais.cHd, com_tencent_mm_protocal_c_ais.cHe));
                                    uVar2.cf(com_tencent_mm_protocal_c_ais.cHf);
                                    uVar2.cR(com_tencent_mm_protocal_c_ais.mFu);
                                    uVar2.ck(com_tencent_mm_protocal_c_ais.mFv);
                                    uVar2.setSource(com_tencent_mm_protocal_c_ais.mcP);
                                    uVar2.cQ(com_tencent_mm_protocal_c_ais.mFy);
                                    uVar2.bV(com_tencent_mm_protocal_c_ais.mFx);
                                    if (com.tencent.mm.model.m.ft(com_tencent_mm_protocal_c_ais.mFw)) {
                                        uVar2.cj(com_tencent_mm_protocal_c_ais.mFw);
                                    }
                                    uVar2.dc((int) be.Nh());
                                    uVar2.bQ(m.a(com_tencent_mm_protocal_c_ais.mIO));
                                    uVar2.bW(m.a(com_tencent_mm_protocal_c_ais.mIQ));
                                    uVar2.bX(m.a(com_tencent_mm_protocal_c_ais.mIP));
                                    uVar2.cm(com_tencent_mm_protocal_c_ais.mdJ);
                                    uVar2.cn(com_tencent_mm_protocal_c_ais.mJn);
                                    if (!(LX == null || be.ma(LX.bCu).equals(be.ma(com_tencent_mm_protocal_c_ais.mJn)))) {
                                        com.tencent.mm.an.c.HV();
                                        com.tencent.mm.an.c.jy(str2);
                                    }
                                    ak.yW();
                                    com.tencent.mm.model.c.wH().Mb(str2);
                                    if (be.kS(uVar2.field_username)) {
                                        str5 = uVar2.field_username;
                                        n.Bo().a(b.a(str5, com_tencent_mm_protocal_c_ais));
                                        com_tencent_mm_protocal_c_axg = com_tencent_mm_protocal_c_ais.mFA;
                                        if (!(uVar2.field_username.endsWith("@chatroom") || com_tencent_mm_protocal_c_axg == null)) {
                                            v.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsFlag modcontact " + com_tencent_mm_protocal_c_axg.cHn + " " + com_tencent_mm_protocal_c_ais.moM);
                                            v.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBg modcontact " + com_tencent_mm_protocal_c_axg.cHo);
                                            v.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + com_tencent_mm_protocal_c_axg.cHp);
                                            v.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + com_tencent_mm_protocal_c_axg.mUx);
                                            if (j.ak.lyf != null) {
                                                j.ak.lyf.a(uVar2.field_username, com_tencent_mm_protocal_c_axg);
                                            }
                                        }
                                        str6 = com.tencent.mm.model.k.xF();
                                        if (!(str6 == null || str6.equals(str5))) {
                                            ho = com.tencent.mm.modelbiz.u.Dy().ho(str5);
                                            ho.field_username = str5;
                                            ho.field_brandList = com_tencent_mm_protocal_c_ais.cHm;
                                            mcVar = com_tencent_mm_protocal_c_ais.mFB;
                                            if (mcVar != null) {
                                                ho.field_brandFlag = mcVar.cHq;
                                                ho.field_brandInfo = mcVar.cHs;
                                                ho.field_brandIconURL = mcVar.cHt;
                                                ho.field_extInfo = mcVar.cHr;
                                                ho.field_attrSyncVersion = null;
                                                ho.field_incrementUpdateTime = 0;
                                            }
                                            if (!com.tencent.mm.modelbiz.u.Dy().e(ho)) {
                                                com.tencent.mm.modelbiz.u.Dy().d(ho);
                                            }
                                            uVar2.dd(ho.field_type);
                                        }
                                    } else {
                                        v.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "dkinit dealModContactExtInfo failed invalid contact");
                                    }
                                    uVar2.cT(com_tencent_mm_protocal_c_ais.mJm);
                                    if (!(com_tencent_mm_protocal_c_ais.mJi == null || com_tencent_mm_protocal_c_ais.mJi.mck == null)) {
                                        uVar2.co(com_tencent_mm_protocal_c_ais.mJi.mck.mgp);
                                        uVar2.cp(com_tencent_mm_protocal_c_ais.mJi.mck.mgq);
                                        uVar2.cq(com_tencent_mm_protocal_c_ais.mJi.mck.mgr);
                                    }
                                    if (com.tencent.mm.model.m.fn(str2)) {
                                        uVar2.tw();
                                    }
                                    if (uVar2.bvm()) {
                                        uVar2.tz();
                                    }
                                    if (be.kS(ma)) {
                                        ak.yW();
                                        com.tencent.mm.model.c.wH().b(ma, uVar2);
                                    } else {
                                        ak.yW();
                                        com.tencent.mm.model.c.wH().M(uVar2);
                                    }
                                    if (!(LX == null || (LX.field_type & 2048) == (uVar2.field_type & 2048))) {
                                        if ((uVar2.field_type & 2048) == 0) {
                                            ak.yW();
                                            com.tencent.mm.model.c.wK().Ml(uVar2.field_username);
                                        } else {
                                            ak.yW();
                                            com.tencent.mm.model.c.wK().Mm(uVar2.field_username);
                                        }
                                    }
                                }
                            } else {
                                v.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact user is null user:%s enuser:%s", new Object[]{str2, ma});
                            }
                        }
                        str5 = m.a(com_tencent_mm_protocal_c_ais.moM);
                        if (this.fuO != null || this.fuO.bfx == null || this.fuO.bfx.context == null) {
                            v.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "a8KeyRedirectEvent null");
                            return;
                        }
                        ak.yW();
                        u LX2 = com.tencent.mm.model.c.wH().LX(str5);
                        if (LX2 == null) {
                            return;
                        }
                        if (com_tencent_mm_protocal_c_abu.bLg != 0 && com_tencent_mm_protocal_c_abt != null) {
                            v.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to DeviceProfileUI.");
                            Context context = this.fuO.bfx.context;
                            Intent intent2 = new Intent(context, ExdeviceDeviceProfileUI.class);
                            if (!(context instanceof Activity)) {
                                intent2.addFlags(268435456);
                            }
                            intent2.putExtra("device_id", com_tencent_mm_protocal_c_abt.eez);
                            intent2.putExtra("device_type", com_tencent_mm_protocal_c_abt.meq);
                            intent2.putExtra("device_mac", com_tencent_mm_protocal_c_abu.mfU);
                            intent2.putExtra("device_brand_name", com_tencent_mm_protocal_c_abu.mCM);
                            intent2.putExtra("device_alias", com_tencent_mm_protocal_c_abu.cHh);
                            intent2.putExtra("device_desc", com_tencent_mm_protocal_c_abu.mCU);
                            intent2.putExtra("device_title", com_tencent_mm_protocal_c_abu.mCT);
                            intent2.putExtra("device_icon_url", com_tencent_mm_protocal_c_abu.gnp);
                            intent2.putExtra("device_jump_url", com_tencent_mm_protocal_c_abu.gkT);
                            intent2.putExtra("bind_ticket", com_tencent_mm_protocal_c_asa.mfZ);
                            intent2.putExtra("device_has_bound", ac.ajq().bt(LX2.field_username, com_tencent_mm_protocal_c_abt.eez) != null);
                            context.startActivity(intent2);
                            return;
                        } else if (com_tencent_mm_protocal_c_abt != null) {
                            v.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to ContactInfoUI.");
                            intent = new Intent();
                            intent.putExtra("Contact_User", str5);
                            intent.putExtra("KIsHardDevice", true);
                            intent.putExtra("KHardDeviceBindTicket", com_tencent_mm_protocal_c_asa.mfZ);
                            intent.putExtra("device_id", com_tencent_mm_protocal_c_abt.eez);
                            intent.putExtra("device_type", com_tencent_mm_protocal_c_abt.meq);
                            com.tencent.mm.plugin.exdevice.b.fqV.d(intent, this.fuO.bfx.context);
                            return;
                        } else {
                            v.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "cannot jump.");
                            return;
                        }
                    }
                }
                str2 = str5;
                str3 = str6;
                linkedList = linkedList2;
                str4 = str3;
                arrayList = new ArrayList();
                for (i3 = 0; i3 < linkedList.size(); i3++) {
                    com_tencent_mm_protocal_c_ayf = (ayf) linkedList.get(i3);
                    if (com_tencent_mm_protocal_c_ayf.type.contains("text")) {
                        arrayList.add(com_tencent_mm_protocal_c_ayf.content);
                    }
                }
                v.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp.BindTicket = %s", new Object[]{com_tencent_mm_protocal_c_asa.mfZ});
                if (com_tencent_mm_protocal_c_asa.mQQ != 1) {
                    com_tencent_mm_protocal_c_ais = com_tencent_mm_protocal_c_asa.mga;
                    if (com_tencent_mm_protocal_c_ais != null) {
                        Xe();
                        if (com_tencent_mm_protocal_c_ais != null) {
                            str2 = m.a(com_tencent_mm_protocal_c_ais.moM);
                            ma = be.ma(com_tencent_mm_protocal_c_ais.mJd);
                            if (be.kS(str2)) {
                            }
                            v.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact : %s", new Object[]{str2});
                            ak.yW();
                            LX = com.tencent.mm.model.c.wH().LX(str2);
                            if (LX == null) {
                            }
                            uVar2 = new u(str2);
                            uVar2.bP(com_tencent_mm_protocal_c_ais.cHh);
                            uVar2.setType(com_tencent_mm_protocal_c_ais.mnV & com_tencent_mm_protocal_c_ais.mnW);
                            if (be.kS(ma)) {
                                uVar2.bY(LX.field_encryptUsername);
                            } else {
                                uVar2.bY(ma);
                            }
                            if (LX != null) {
                            }
                            uVar2.chr = LX != null ? 0 : (long) ((int) LX.chr);
                            uVar2.bS(m.a(com_tencent_mm_protocal_c_ais.mEj));
                            uVar2.bT(m.a(com_tencent_mm_protocal_c_ais.moC));
                            uVar2.bU(m.a(com_tencent_mm_protocal_c_ais.moD));
                            uVar2.cV(com_tencent_mm_protocal_c_ais.cHc);
                            uVar2.cY(com_tencent_mm_protocal_c_ais.mob);
                            uVar2.bR(m.a(com_tencent_mm_protocal_c_ais.mIX));
                            uVar2.cZ(com_tencent_mm_protocal_c_ais.mof);
                            uVar2.da(com_tencent_mm_protocal_c_ais.cHg);
                            uVar2.cl(RegionCodeDecoder.Y(com_tencent_mm_protocal_c_ais.cHl, com_tencent_mm_protocal_c_ais.cHd, com_tencent_mm_protocal_c_ais.cHe));
                            uVar2.cf(com_tencent_mm_protocal_c_ais.cHf);
                            uVar2.cR(com_tencent_mm_protocal_c_ais.mFu);
                            uVar2.ck(com_tencent_mm_protocal_c_ais.mFv);
                            uVar2.setSource(com_tencent_mm_protocal_c_ais.mcP);
                            uVar2.cQ(com_tencent_mm_protocal_c_ais.mFy);
                            uVar2.bV(com_tencent_mm_protocal_c_ais.mFx);
                            if (com.tencent.mm.model.m.ft(com_tencent_mm_protocal_c_ais.mFw)) {
                                uVar2.cj(com_tencent_mm_protocal_c_ais.mFw);
                            }
                            uVar2.dc((int) be.Nh());
                            uVar2.bQ(m.a(com_tencent_mm_protocal_c_ais.mIO));
                            uVar2.bW(m.a(com_tencent_mm_protocal_c_ais.mIQ));
                            uVar2.bX(m.a(com_tencent_mm_protocal_c_ais.mIP));
                            uVar2.cm(com_tencent_mm_protocal_c_ais.mdJ);
                            uVar2.cn(com_tencent_mm_protocal_c_ais.mJn);
                            com.tencent.mm.an.c.HV();
                            com.tencent.mm.an.c.jy(str2);
                            ak.yW();
                            com.tencent.mm.model.c.wH().Mb(str2);
                            if (be.kS(uVar2.field_username)) {
                                str5 = uVar2.field_username;
                                n.Bo().a(b.a(str5, com_tencent_mm_protocal_c_ais));
                                com_tencent_mm_protocal_c_axg = com_tencent_mm_protocal_c_ais.mFA;
                                v.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsFlag modcontact " + com_tencent_mm_protocal_c_axg.cHn + " " + com_tencent_mm_protocal_c_ais.moM);
                                v.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBg modcontact " + com_tencent_mm_protocal_c_axg.cHo);
                                v.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + com_tencent_mm_protocal_c_axg.cHp);
                                v.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + com_tencent_mm_protocal_c_axg.mUx);
                                if (j.ak.lyf != null) {
                                    j.ak.lyf.a(uVar2.field_username, com_tencent_mm_protocal_c_axg);
                                }
                                str6 = com.tencent.mm.model.k.xF();
                                ho = com.tencent.mm.modelbiz.u.Dy().ho(str5);
                                ho.field_username = str5;
                                ho.field_brandList = com_tencent_mm_protocal_c_ais.cHm;
                                mcVar = com_tencent_mm_protocal_c_ais.mFB;
                                if (mcVar != null) {
                                    ho.field_brandFlag = mcVar.cHq;
                                    ho.field_brandInfo = mcVar.cHs;
                                    ho.field_brandIconURL = mcVar.cHt;
                                    ho.field_extInfo = mcVar.cHr;
                                    ho.field_attrSyncVersion = null;
                                    ho.field_incrementUpdateTime = 0;
                                }
                                if (com.tencent.mm.modelbiz.u.Dy().e(ho)) {
                                    com.tencent.mm.modelbiz.u.Dy().d(ho);
                                }
                                uVar2.dd(ho.field_type);
                            } else {
                                v.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "dkinit dealModContactExtInfo failed invalid contact");
                            }
                            uVar2.cT(com_tencent_mm_protocal_c_ais.mJm);
                            uVar2.co(com_tencent_mm_protocal_c_ais.mJi.mck.mgp);
                            uVar2.cp(com_tencent_mm_protocal_c_ais.mJi.mck.mgq);
                            uVar2.cq(com_tencent_mm_protocal_c_ais.mJi.mck.mgr);
                            if (com.tencent.mm.model.m.fn(str2)) {
                                uVar2.tw();
                            }
                            if (uVar2.bvm()) {
                                uVar2.tz();
                            }
                            if (be.kS(ma)) {
                                ak.yW();
                                com.tencent.mm.model.c.wH().M(uVar2);
                            } else {
                                ak.yW();
                                com.tencent.mm.model.c.wH().b(ma, uVar2);
                            }
                            if ((uVar2.field_type & 2048) == 0) {
                                ak.yW();
                                com.tencent.mm.model.c.wK().Mm(uVar2.field_username);
                            } else {
                                ak.yW();
                                com.tencent.mm.model.c.wK().Ml(uVar2.field_username);
                            }
                        } else {
                            v.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "unable to parse mod contact");
                        }
                        str5 = m.a(com_tencent_mm_protocal_c_ais.moM);
                        if (this.fuO != null) {
                        }
                        v.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "a8KeyRedirectEvent null");
                        return;
                    }
                    v.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mContact == null");
                    ajo();
                    return;
                }
                intent = new Intent();
                intent.putExtra("device_scan_mode", "SCAN_CATALOG");
                if (!com_tencent_mm_protocal_c_abu.mCN.contains("3")) {
                }
                contains = com_tencent_mm_protocal_c_abu.mCN.contains("4");
                if (obj == null) {
                }
                if (obj != null) {
                    intent.putExtra("device_scan_conn_proto", "blue");
                } else if (contains) {
                    intent.putExtra("device_scan_conn_proto", "wifi");
                }
                intent.putExtra("device_id", com_tencent_mm_protocal_c_abt.eez);
                intent.putExtra("device_type", com_tencent_mm_protocal_c_abt.meq);
                intent.putExtra("device_title", com_tencent_mm_protocal_c_abu.mCT);
                intent.putExtra("device_desc", com_tencent_mm_protocal_c_abu.mCU);
                intent.putExtra("device_icon_url", com_tencent_mm_protocal_c_abu.gnp);
                intent.putExtra("device_category_id", com_tencent_mm_protocal_c_abu.mCV);
                intent.putExtra("device_brand_name", com_tencent_mm_protocal_c_abu.mCM);
                intent.putExtra("bind_ticket", com_tencent_mm_protocal_c_asa.mfZ);
                intent.putExtra("device_ble_simple_proto", com_tencent_mm_protocal_c_abu.bLh);
                intent.putExtra("device_airkiss_key", str2);
                intent.putExtra("device_airkiss_title", str4);
                intent.putStringArrayListExtra("device_airkiss_steps", arrayList);
                com.tencent.mm.ay.c.b(this.fuO.bfx.context, "exdevice", ".ui.ExdeviceBindDeviceGuideUI", intent);
                Xe();
            }
        } else {
            v.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[]{Integer.valueOf(kVar.getType())});
            ajo();
        }
    }

    private void ajo() {
        if (this.fuO != null && this.fuO.bpT != null) {
            this.fuO.bfy.ret = 1;
            this.fuO.bpT.run();
        }
    }

    private void Xe() {
        if (this.fuO != null && this.fuO.bpT != null) {
            this.fuO.bfy.ret = 2;
            this.fuO.bpT.run();
        }
    }
}
