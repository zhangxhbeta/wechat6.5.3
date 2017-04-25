package com.tencent.mm.plugin.sns.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.oi;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.model.o;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.sns.a.a.j;
import com.tencent.mm.plugin.sns.a.a.j.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ac;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.ah;
import com.tencent.mm.plugin.sns.e.al;
import com.tencent.mm.plugin.sns.e.am;
import com.tencent.mm.plugin.sns.e.am.b;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.ui.FlipView;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qe;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.protocal.c.qj;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import java.net.URLEncoder;
import java.util.Map;

public final class a implements d, e {
    private Activity aXH;
    private ClipboardManager fRJ;
    private p jEA;
    private ac jEK;
    private View kbr;
    private String kbs;
    private azr kbt;
    private int scene;

    public a(Activity activity, int i, ac acVar) {
        this.aXH = activity;
        this.scene = i;
        this.fRJ = (ClipboardManager) activity.getSystemService("clipboard");
        this.jEK = acVar;
    }

    public final void a(View view, String str, azr com_tencent_mm_protocal_c_azr) {
        this.kbr = view;
        this.kbs = str;
        this.kbt = com_tencent_mm_protocal_c_azr;
    }

    private String aYp() {
        if (this.kbr != null && (this.kbr.getTag() instanceof ap) && ((ap) this.kbr.getTag()).aXl()) {
            b AA = am.AA(ad.aSE().Bq(this.kbs).aUq());
            if (AA != null) {
                return AA.bfz;
            }
        }
        return null;
    }

    public final void c(MenuItem menuItem, int i) {
        if (this.kbr != null) {
            CharSequence aYp;
            bp bpVar;
            k Bq;
            com.tencent.mm.plugin.sns.ui.am amVar;
            String str;
            k Bq2;
            aib a;
            String str2;
            String str3;
            bp bpVar2;
            k Bq3;
            azr com_tencent_mm_protocal_c_azr;
            qf qfVar;
            qg qgVar;
            com.tencent.mm.plugin.sns.ui.k kVar;
            Context context;
            Intent intent;
            switch (menuItem.getItemId()) {
                case 0:
                    aYp = aYp();
                    if (be.kS(aYp)) {
                        aYp = this.kbt.mWn;
                    }
                    this.fRJ.setText(aYp);
                    g.bf(this.aXH, this.aXH.getString(2131231016));
                    return;
                case 1:
                    aYp = aYp();
                    if (be.kS(aYp)) {
                        aYp = this.kbt.mWn;
                    }
                    this.jEK.aSj().cH(this.kbs, this.kbt.gID);
                    bpVar = new bp();
                    com.tencent.mm.plugin.sns.j.a.a(bpVar, this.kbs, aYp);
                    bpVar.aZd.aXH = this.aXH;
                    bpVar.aZd.aZl = 30;
                    com.tencent.mm.sdk.c.a.nhr.z(bpVar);
                    return;
                case 2:
                    this.jEK.aSj().cH(this.kbs, this.kbt.gID);
                    bpVar = new bp();
                    Bq = f.Bq(this.kbs);
                    if (Bq.qC(32) && Bq.aUm().jun) {
                        Ch(this.kbs);
                        return;
                    }
                    amVar = (com.tencent.mm.plugin.sns.ui.am) this.kbr.getTag();
                    str = this.kbs;
                    int i2 = amVar.index;
                    if (s.BN(str) || i2 < 0) {
                        v.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
                        bpVar.aZd.aZk = 2131232653;
                    } else if (ad.aSn()) {
                        v.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                        bpVar.aZd.aZk = 2131232667;
                    } else {
                        Bq2 = ad.aSE().Bq(str);
                        if (Bq2 == null) {
                            v.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                            bpVar.aZd.aZk = 2131232654;
                        } else {
                            a = ah.a(Bq2, i2);
                            if (a == null) {
                                v.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, media obj is null");
                                bpVar.aZd.aZk = 2131232654;
                            } else {
                                com.tencent.mm.plugin.sns.j.a.a(bpVar, Bq2, a.gID);
                            }
                        }
                    }
                    bpVar.aZd.aXH = this.aXH;
                    bpVar.aZd.aZl = 31;
                    com.tencent.mm.sdk.c.a.nhr.z(bpVar);
                    return;
                case 3:
                    this.jEK.aSj().cH(this.kbs, this.kbt.gID);
                    str2 = this.kbt.mWq.glb;
                    str3 = this.kbt.mWp.gID;
                    str3 = as.Cg(str2);
                    if (be.kS(str3)) {
                        v.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
                        return;
                    }
                    bpVar2 = new bp();
                    Bq2 = f.Bq(this.kbs);
                    if (Bq2 != null) {
                        String fz = o.fz(Bq2.field_snsId);
                        o.b n = o.yx().n(fz, true);
                        n.l("prePublishId", "sns_" + i.cE(Bq2.field_snsId));
                        n.l("preUsername", Bq2.field_userName);
                        n.l("preChatName", "");
                        n.l("url", str3);
                        n.l("preMsgIndex", Integer.valueOf(0));
                        n.l("sendAppMsgScene", Integer.valueOf(1));
                        n.l("adExtStr", Bq2.aUp().jGu);
                        bpVar2.aZd.aZj = fz;
                    }
                    Bq2 = ad.aSE().Bq(this.kbs);
                    if (Bq2 != null && this.kbt.mWq.mol == 18) {
                        j.a(j.d.AdUrl, c.Fav, j.e.Samll, 0, Bq2);
                    }
                    if (be.kS(this.kbt.jYp)) {
                        com.tencent.mm.plugin.sns.j.a.a(bpVar2, str3, this.kbs);
                        bpVar2.aZd.aXH = this.aXH;
                        bpVar2.aZd.aZl = 28;
                        com.tencent.mm.sdk.c.a.nhr.z(bpVar2);
                        if (bpVar2.aZe.ret == 0) {
                            long Nh = be.Nh();
                            if (!be.kS(str3)) {
                                v.d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), str3, Long.valueOf(Nh), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1)});
                                str2 = "";
                                try {
                                    str2 = URLEncoder.encode(str3, "UTF-8");
                                } catch (Throwable e) {
                                    v.a("MicroMsg.TimeLineMMMenuItemSelectedListener", e, "", new Object[0]);
                                }
                                com.tencent.mm.plugin.report.service.g.iuh.h(13378, new Object[]{str2, Long.valueOf(Nh), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1)});
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    Ch(Bq2.aUL());
                    return;
                case 4:
                    this.jEK.aSj().cH(this.kbs, this.kbt.gID);
                    Bq3 = ad.aSE().Bq(this.kbs);
                    if (this.kbt.mWq.mom.size() != 0) {
                        a = (aib) this.kbt.mWq.mom.get(0);
                        if (Bq3 == null || a == null) {
                            v.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite music fail, snsinfo or mediaobj is null");
                            return;
                        }
                        bp bpVar3 = new bp();
                        com.tencent.mm.plugin.sns.j.a.a(bpVar3, Bq3, a);
                        bpVar3.aZd.aXH = this.aXH;
                        bpVar3.aZd.aZl = 25;
                        com.tencent.mm.sdk.c.a.nhr.z(bpVar3);
                        return;
                    }
                    return;
                case 5:
                    this.jEK.aSj().cH(this.kbs, this.kbt.gID);
                    if (this.kbt != null) {
                        bpVar = new bp();
                        com_tencent_mm_protocal_c_azr = this.kbt;
                        if (com_tencent_mm_protocal_c_azr == null) {
                            v.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                            bpVar.aZd.aZk = 2131232653;
                        } else {
                            qfVar = new qf();
                            qgVar = new qg();
                            qe qeVar = new qe();
                            qgVar.Jn(com_tencent_mm_protocal_c_azr.gln);
                            qgVar.Jo(com.tencent.mm.model.k.xF());
                            qgVar.uN(2);
                            qgVar.dV(be.Ni());
                            if (com_tencent_mm_protocal_c_azr.mWp != null) {
                                qgVar.Jt(com_tencent_mm_protocal_c_azr.mWp.gID);
                            }
                            if (com_tencent_mm_protocal_c_azr.mWq != null) {
                                qeVar.Jg(com_tencent_mm_protocal_c_azr.mWq.aXz);
                                qeVar.Jh(com_tencent_mm_protocal_c_azr.mWq.gkC);
                                if (!(com_tencent_mm_protocal_c_azr.mWq.mom == null || com_tencent_mm_protocal_c_azr.mWq.mom.isEmpty())) {
                                    a = (aib) com_tencent_mm_protocal_c_azr.mWq.mom.get(0);
                                    qeVar.uK(a.aYp);
                                    qeVar.Jj(a.jFe);
                                    qeVar.Ji(a.mHP);
                                }
                            }
                            bpVar.aZd.title = qeVar.title;
                            bpVar.aZd.desc = qeVar.desc;
                            bpVar.aZd.aZf = qfVar;
                            bpVar.aZd.type = 10;
                            qfVar.a(qgVar);
                            qfVar.b(qeVar);
                        }
                        bpVar.aZd.aXH = this.aXH;
                        bpVar.aZd.aZl = 26;
                        com.tencent.mm.sdk.c.a.nhr.z(bpVar);
                        return;
                    }
                    return;
                case 7:
                    com.tencent.mm.plugin.sns.e.p pVar;
                    str = ad.aSE().Bq(this.kbs).aUq();
                    kVar = (com.tencent.mm.plugin.sns.ui.k) this.kbr.getTag();
                    com.tencent.mm.plugin.sns.e.p pVar2;
                    if (s.BJ(str)) {
                        pVar2 = new com.tencent.mm.plugin.sns.e.p(s.BK(str), 6, kVar.jkg);
                        ak.vy().a(pVar2, 0);
                        pVar = pVar2;
                    } else {
                        pVar2 = new com.tencent.mm.plugin.sns.e.p(s.BK(str), 4, kVar.jkg);
                        ak.vy().a(pVar2, 0);
                        pVar = pVar2;
                    }
                    context = this.aXH;
                    this.aXH.getString(2131231164);
                    this.jEA = g.a(context, this.aXH.getString(2131235388), true, new OnCancelListener(this) {
                        final /* synthetic */ a kbu;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ak.vy().c(pVar);
                        }
                    });
                    return;
                case 8:
                    Bq = ad.aSE().Bq(this.kbs);
                    if (Bq != null) {
                        com.tencent.mm.plugin.sns.abtest.a.b(Bq);
                        intent = new Intent();
                        intent.putExtra("sns_permission_snsinfo_svr_id", Bq.field_snsId);
                        intent.putExtra("sns_permission_userName", Bq.field_userName);
                        intent.putExtra("sns_permission_anim", true);
                        intent.setClass(this.aXH, SnsPermissionUI.class);
                        this.aXH.startActivityForResult(intent, 11);
                        return;
                    }
                    return;
                case 9:
                    this.jEK.aSj().cH(this.kbs, this.kbt.gID);
                    if (this.kbt != null) {
                        bpVar = new bp();
                        com_tencent_mm_protocal_c_azr = this.kbt;
                        if (com_tencent_mm_protocal_c_azr == null) {
                            v.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                            bpVar.aZd.aZk = 2131232653;
                        } else {
                            qfVar = new qf();
                            qgVar = new qg();
                            qj qjVar = new qj();
                            qgVar.Jn(com_tencent_mm_protocal_c_azr.gln);
                            qgVar.Jo(com.tencent.mm.model.k.xF());
                            qgVar.uN(8);
                            qgVar.dV(be.Ni());
                            if (com_tencent_mm_protocal_c_azr.mWp != null) {
                                qgVar.Jt(com_tencent_mm_protocal_c_azr.mWp.gID);
                            }
                            if (com_tencent_mm_protocal_c_azr.mWq != null) {
                                qjVar.Jw(com_tencent_mm_protocal_c_azr.mWq.aXz);
                                qjVar.Jx(com_tencent_mm_protocal_c_azr.mWq.gkC);
                                if (!(com_tencent_mm_protocal_c_azr.mWq.mom == null || com_tencent_mm_protocal_c_azr.mWq.mom.isEmpty())) {
                                    a = (aib) com_tencent_mm_protocal_c_azr.mWq.mom.get(0);
                                    qjVar.Jz(a.jFe);
                                    qjVar.Jy(a.mHP);
                                }
                            }
                            bpVar.aZd.title = qjVar.title;
                            bpVar.aZd.desc = qjVar.desc;
                            bpVar.aZd.aZf = qfVar;
                            bpVar.aZd.type = 15;
                            qfVar.a(qgVar);
                            qfVar.b(qjVar);
                        }
                        bpVar.aZd.aXH = this.aXH;
                        bpVar.aZd.aZl = 27;
                        com.tencent.mm.sdk.c.a.nhr.z(bpVar);
                        return;
                    }
                    return;
                case 10:
                    this.jEK.aSj().cH(this.kbs, this.kbt.gID);
                    Bq = f.Bq(this.kbs);
                    if (Bq.qC(32) && Bq.aUm().jun) {
                        Ch(this.kbs);
                        return;
                    }
                    k Bq4 = ad.aSE().Bq(this.kbs);
                    if (Bq4 != null) {
                        if (Bq4.qC(32)) {
                            j.a(j.d.Sight, c.Fav, j.e.Samll, 0, Bq4);
                            ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(Bq4.aUQ(), 11, this.scene == 0 ? 1 : 2, "", 2), 0);
                        }
                        bpVar2 = new bp();
                        com.tencent.mm.plugin.sns.j.a.a(bpVar2, Bq4);
                        bpVar2.aZd.aXH = this.aXH;
                        bpVar2.aZd.aZl = 29;
                        com.tencent.mm.sdk.c.a.nhr.z(bpVar2);
                        return;
                    }
                    return;
                case 11:
                    if (this.kbr.getTag() instanceof com.tencent.mm.plugin.sns.ui.k) {
                        this.fRJ.setText(((com.tencent.mm.plugin.sns.ui.k) this.kbr.getTag()).hQP);
                        g.bf(this.aXH, this.aXH.getString(2131231016));
                        return;
                    }
                    return;
                case 12:
                    a = (aib) this.kbt.mWq.mom.get(0);
                    str2 = al.cA(ad.xh(), a.gID) + i.c(a);
                    intent = new Intent();
                    intent.putExtra("Select_Conv_Type", 3);
                    intent.putExtra("select_is_ret", true);
                    intent.putExtra("mutil_select_is_ret", true);
                    intent.putExtra("image_path", str2);
                    intent.putExtra("Retr_Msg_Type", 11);
                    com.tencent.mm.ay.c.a(this.aXH, ".ui.transmit.SelectConversationUI", intent, 15);
                    return;
                case com.tencent.mm.plugin.appbrand.jsapi.as.CTRL_INDEX /*13*/:
                    com.tencent.mm.plugin.sns.abtest.a.a(this.aXH, ad.aSE().Bq(this.kbs));
                    return;
                case an.CTRL_INDEX /*14*/:
                    Bq3 = ad.aSE().Bq(this.kbs);
                    if (Bq3 != null) {
                        com.tencent.mm.modelsns.a gh;
                        if (this.scene == 0) {
                            gh = com.tencent.mm.modelsns.a.gh(714);
                        } else {
                            gh = com.tencent.mm.modelsns.a.gi(714);
                        }
                        gh.kj(i.g(Bq3)).gk(Bq3.field_type).bg(Bq3.qC(32)).kj(Bq3.aUR());
                        gh.JF();
                    }
                    am.o(Bq3);
                    return;
                case com.tencent.mm.plugin.appbrand.jsapi.am.CTRL_INDEX /*15*/:
                    if (this.kbr.getTag() instanceof com.tencent.mm.plugin.sns.ui.k) {
                        kVar = (com.tencent.mm.plugin.sns.ui.k) this.kbr.getTag();
                        Bq2 = ad.aSE().Bp(kVar.jEU);
                        if (Bq2 != null) {
                            com.tencent.mm.modelsns.a gh2 = this.scene == 0 ? com.tencent.mm.modelsns.a.gh(715) : com.tencent.mm.modelsns.a.gi(715);
                            gh2.kj(i.g(Bq2)).gk(Bq2.field_type).bg(Bq2.qC(32)).kj(Bq2.aUR());
                            if (kVar.jkg != null) {
                                gh2.kj(kVar.jkg.mSN == 0 ? kVar.jkg.mSQ : kVar.jkg.mSN);
                            } else {
                                gh2.kj("");
                            }
                            gh2.JF();
                        }
                        am.a((com.tencent.mm.plugin.sns.ui.k) this.kbr.getTag());
                        return;
                    }
                    return;
                case 16:
                    am.p(ad.aSE().Bq(this.kbs));
                    return;
                case 17:
                    if (this.kbr.getTag() instanceof com.tencent.mm.plugin.sns.ui.k) {
                        am.b((com.tencent.mm.plugin.sns.ui.k) this.kbr.getTag());
                        return;
                    }
                    return;
                case 18:
                    context = this.aXH;
                    Bq2 = ad.aSE().Bq(this.kbs);
                    if (Bq2 != null) {
                        Intent intent2 = new Intent();
                        if (Bq2.aUp().mWq.mol == 1) {
                            amVar = (com.tencent.mm.plugin.sns.ui.am) this.kbr.getTag();
                            aib a2 = ah.a(Bq2, amVar.index);
                            if (a2 == null) {
                                v.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "send photo fail, mediaObj is null");
                                return;
                            } else {
                                intent2.putExtra("sns_send_data_ui_image_path", FlipView.f(al.cA(ad.xh(), a2.gID) + i.k(a2), context));
                                intent2.putExtra("sns_send_data_ui_image_position", amVar.index);
                            }
                        } else if ((Bq2.aUp().mWq.mol == 4 || Bq2.aUp().mWq.mol == 15 || Bq2.aUp().mWq.mol == 3) && ((aib) Bq2.aUp().mWq.mom.get(0)) == null) {
                            v.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mediaObj is null, send failed!");
                            return;
                        }
                        intent2.putExtra("exdevice_open_scene_type", 1);
                        intent2.putExtra("sns_local_id", this.kbs);
                        intent2.putExtra("sns_send_data_ui_activity", true);
                        com.tencent.mm.ay.c.a(this.aXH, ".ui.chatting.ChattingSendDataToDeviceUI", intent2);
                        return;
                    }
                    return;
                case 19:
                    Bq = ad.aSE().Bq(this.kbs);
                    if (Bq == null) {
                        v.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but sns info is null.");
                        return;
                    } else if (Bq.qC(32)) {
                        v.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but it is ad");
                        return;
                    } else {
                        a = (aib) Bq.aUp().mWq.mom.get(0);
                        if (a == null) {
                            v.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute paly video but media is null");
                            return;
                        }
                        str = al.cA(ad.xh(), a.gID);
                        str3 = "";
                        if (FileOp.aR(str + i.i(a))) {
                            str3 = str + i.c(a);
                        }
                        if (FileOp.aR(str + i.o(a))) {
                            str3 = str + i.m(a);
                        }
                        Intent intent3 = new Intent();
                        intent3.setClass(this.aXH, SnsOnlineVideoActivity.class);
                        intent3.putExtra("intent_thumbpath", str3);
                        intent3.putExtra("intent_localid", this.kbs);
                        intent3.putExtra("intent_from_scene", this.scene);
                        intent3.putExtra("intent_ismute", true);
                        if (this.kbr != null) {
                            int[] iArr = new int[2];
                            this.kbr.getLocationInWindow(iArr);
                            int width = this.kbr.getWidth();
                            int height = this.kbr.getHeight();
                            intent3.putExtra("img_gallery_left", iArr[0]);
                            intent3.putExtra("img_gallery_top", iArr[1]);
                            intent3.putExtra("img_gallery_width", width);
                            intent3.putExtra("img_gallery_height", height);
                        }
                        this.aXH.startActivity(intent3);
                        this.aXH.overridePendingTransition(0, 0);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private void Ch(String str) {
        k Bq = ad.aSE().Bq(str);
        if (Bq != null) {
            String w;
            if (Bq.qC(32)) {
                Bq.aUo();
                com.tencent.mm.plugin.sns.storage.c aUS = Bq.aUS();
                w = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(Bq);
                if (!be.kS(w)) {
                    aUS.field_adxml = w;
                }
                w = aUS.field_adxml;
            } else {
                w = Bq.aUp().jYp;
            }
            Map q = bf.q(w, "adxml");
            if (q == null) {
                return;
            }
            if (q.containsKey(".adxml.adCanvasInfo")) {
                String fz = o.fz(Bq.field_snsId);
                String ah = be.ah((String) q.get(".adxml.adCanvasInfo.shareTitle"), "");
                String ah2 = be.ah((String) q.get(".adxml.adCanvasInfo.shareWebUrl"), "");
                String ah3 = be.ah((String) q.get(".adxml.adCanvasInfo.shareDesc"), "");
                bp bpVar = new bp();
                oi oiVar = new oi();
                oiVar.bpn.bpp = str;
                oiVar.bpn.bpq = bpVar;
                oiVar.bpn.url = ah2;
                com.tencent.mm.sdk.c.a.nhr.z(oiVar);
                if (oiVar.bpo.aYN) {
                    bpVar.aZd.aZj = fz;
                    bpVar.aZd.title = ah;
                    bpVar.aZd.desc = ah3;
                    qf qfVar = bpVar.aZd.aZf;
                    if (!(qfVar == null || qfVar.mtR == null || qfVar.mtR.size() <= 0 || qfVar.mtR.get(0) == null)) {
                        ((pw) qfVar.mtR.get(0)).IV(w);
                        if (be.kS(((pw) qfVar.mtR.get(0)).title)) {
                            ((pw) qfVar.mtR.get(0)).Iw(bpVar.aZd.title);
                        }
                        if (be.kS(((pw) qfVar.mtR.get(0)).desc)) {
                            ((pw) qfVar.mtR.get(0)).Ix(bpVar.aZd.desc);
                        }
                    }
                    bpVar.aZd.aXH = this.aXH;
                    bpVar.aZd.aZl = 28;
                    com.tencent.mm.sdk.c.a.nhr.z(bpVar);
                    return;
                }
                if (bpVar.aZd.aZk == 0) {
                    bpVar.aZd.aZk = 2131232661;
                }
                g.f(this.aXH, bpVar.aZd.aZk, 0);
                return;
            }
            g.f(this.aXH, 2131232662, 0);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 15) {
                k Bq = ad.aSE().Bq(this.kbs);
                aib com_tencent_mm_protocal_c_aib = (aib) this.kbt.mWq.mom.get(0);
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                String str = al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.c(com_tencent_mm_protocal_c_aib);
                for (String str2 : be.g(stringExtra.split(","))) {
                    String str3;
                    if (Bq.qC(32)) {
                        c cVar;
                        int el;
                        str3 = al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.i(com_tencent_mm_protocal_c_aib);
                        azr aUp = Bq.aUp();
                        com.tencent.mm.plugin.sns.storage.b aUm = Bq.aUm();
                        ayk com_tencent_mm_protocal_c_ayk = new ayk();
                        com_tencent_mm_protocal_c_ayk.mtD = com_tencent_mm_protocal_c_aib.jZD;
                        com_tencent_mm_protocal_c_ayk.cqg = com_tencent_mm_protocal_c_aib.mHW;
                        if (aUp.mWq.mol == 15) {
                            com_tencent_mm_protocal_c_ayk.cqm = Bq.aUo().jpt;
                            com_tencent_mm_protocal_c_ayk.cqn = aUp.gID;
                        } else {
                            com_tencent_mm_protocal_c_ayk.cqm = aUp.mWv.cqm;
                            com_tencent_mm_protocal_c_ayk.cqn = aUp.mWv.cqn;
                        }
                        com_tencent_mm_protocal_c_ayk.cqi = aUp.mWn;
                        com_tencent_mm_protocal_c_ayk.cql = be.kS(com_tencent_mm_protocal_c_aib.mHZ) ? com_tencent_mm_protocal_c_aib.mHP : com_tencent_mm_protocal_c_aib.mHZ;
                        if (aUm != null && aUm.juw == 0) {
                            com_tencent_mm_protocal_c_ayk.cqk = aUm.juy;
                            com_tencent_mm_protocal_c_ayk.cqj = aUm.jux;
                        }
                        v.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[]{str2, str3, str, com_tencent_mm_protocal_c_aib.mHW, Integer.valueOf(com_tencent_mm_protocal_c_aib.jZD), Integer.valueOf(i.zZ(str3))});
                        com.tencent.mm.pluginsdk.j.a.bmt().a(this.aXH, str2, str3, str, 43, r7, com_tencent_mm_protocal_c_ayk, false, false, aUp.jGu);
                        com.tencent.mm.pluginsdk.j.a.bmt().df(stringExtra2, str2);
                        ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(Bq.aUQ(), 12, this.scene == 0 ? 1 : 2, "", 2), 0);
                        boolean dE = m.dE(str2);
                        j.d dVar = j.d.Sight;
                        if (dE) {
                            cVar = c.Chatroom;
                        } else {
                            cVar = c.Chat;
                        }
                        j.e eVar = j.e.Samll;
                        if (dE) {
                            el = com.tencent.mm.model.i.el(str2);
                        } else {
                            el = 0;
                        }
                        j.a(dVar, cVar, eVar, el, Bq);
                        return;
                    }
                    str3 = al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.i(com_tencent_mm_protocal_c_aib);
                    v.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[]{str2, str3, str, com_tencent_mm_protocal_c_aib.mHW, Integer.valueOf(com_tencent_mm_protocal_c_aib.jZD), Integer.valueOf(i.zZ(str3))});
                    com.tencent.mm.pluginsdk.j.a.bmt().a(this.aXH, str2, str3, str, 43, r7, this.kbt.jGu);
                    com.tencent.mm.pluginsdk.j.a.bmt().df(stringExtra2, str2);
                }
                com.tencent.mm.ui.snackbar.a.f(this.aXH, this.aXH.getString(2131233278));
            }
        } else if (i == 15) {
            k Bq2 = ad.aSE().Bq(this.kbs);
            if (Bq2 == null) {
                v.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "menuitemselected and snsinfo is null %s", new Object[]{this.kbs});
            } else {
                ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(Bq2.aUQ(), 13, this.scene == 0 ? 1 : 2, "", 2), 0);
            }
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "onSceneEnd");
        if (this.jEA != null && this.jEA.isShowing()) {
            this.jEA.dismiss();
        }
    }
}
