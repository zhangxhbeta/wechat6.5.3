package com.tencent.mm.pluginsdk.model;

import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.as.o;
import com.tencent.mm.as.p;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.ez;
import com.tencent.mm.e.a.kw;
import com.tencent.mm.h.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.px;
import com.tencent.mm.protocal.c.py;
import com.tencent.mm.protocal.c.pz;
import com.tencent.mm.protocal.c.qc;
import com.tencent.mm.protocal.c.qe;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.protocal.c.qj;
import com.tencent.mm.protocal.c.qo;
import com.tencent.mm.protocal.c.qp;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.tools.h;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d {
    public static boolean a(bp bpVar, Intent intent) {
        double doubleExtra = intent.getDoubleExtra("kwebmap_slat", 0.0d);
        double doubleExtra2 = intent.getDoubleExtra("kwebmap_lng", 0.0d);
        int intExtra = intent.getIntExtra("kwebmap_scale", 0);
        String ah = be.ah(intent.getStringExtra("Kwebmap_locaion"), SQLiteDatabase.KeyEmpty);
        String stringExtra = intent.getStringExtra("kPoiName");
        intent.getCharSequenceExtra("kRemark");
        intent.getStringArrayListExtra("kTags");
        qc qcVar = new qc();
        qcVar.Je(ah);
        qcVar.k(doubleExtra);
        qcVar.j(doubleExtra2);
        qcVar.uJ(intExtra);
        qcVar.Jf(stringExtra);
        qf qfVar = new qf();
        qg qgVar = new qg();
        String xF = k.xF();
        qgVar.Jn(xF);
        qgVar.Jo(xF);
        qgVar.uN(6);
        qgVar.dV(be.Ni());
        qfVar.b(qcVar);
        qfVar.a(qgVar);
        bpVar.aZd.aZf = qfVar;
        bpVar.aZd.type = 6;
        return true;
    }

    public static boolean a(bp bpVar, int i, String str, String str2, String str3) {
        if (be.kS(str)) {
            v.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
            bpVar.aZd.aZk = 2131232653;
            return false;
        }
        v.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", str2, str3, str, Integer.valueOf(i));
        if (new File(str).length() > ((long) b.sK())) {
            bpVar.aZd.aZk = 2131232747;
            return false;
        }
        qf qfVar = new qf();
        qg qgVar = new qg();
        pw pwVar = new pw();
        pwVar.IK(str);
        pwVar.uG(8);
        pwVar.IG(e.aS(str));
        pwVar.ip(true);
        pwVar.Iw(str2);
        pwVar.Ix(str3);
        qgVar.Jn(k.xF());
        qgVar.Jo(k.xF());
        qgVar.uN(i);
        qgVar.dV(be.Ni());
        qfVar.a(qgVar);
        qfVar.mtR.add(pwVar);
        bpVar.aZd.title = pwVar.title;
        bpVar.aZd.desc = pwVar.title;
        bpVar.aZd.aZf = qfVar;
        bpVar.aZd.type = 8;
        return true;
    }

    public static boolean a(bp bpVar, int i, String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
            bpVar.aZd.aZk = 2131232653;
            return false;
        }
        v.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", str, Integer.valueOf(i));
        qf qfVar = new qf();
        qg qgVar = new qg();
        pw pwVar = new pw();
        pwVar.uG(2);
        pwVar.IK(str);
        pwVar.IJ(g.m((pwVar.toString() + 2 + System.currentTimeMillis()).getBytes()));
        com.tencent.mm.sdk.c.b ezVar = new ez();
        ezVar.bdQ.type = 27;
        ezVar.bdQ.bdS = pwVar;
        a.nhr.z(ezVar);
        String str2 = ezVar.bdR.bdZ;
        com.tencent.mm.sdk.platformtools.d.b(str, 150, 150, CompressFormat.JPEG, 90, str2);
        pwVar.IL(str2);
        qgVar.Jn(k.xF());
        qgVar.Jo(k.xF());
        qgVar.uN(i);
        qgVar.dV(be.Ni());
        qfVar.a(qgVar);
        qfVar.mtR.add(pwVar);
        bpVar.aZd.title = pwVar.title;
        bpVar.aZd.aZf = qfVar;
        bpVar.aZd.type = 2;
        return true;
    }

    public static boolean a(bp bpVar, long j) {
        ak.yW();
        return a(bpVar, c.wJ().ek(j));
    }

    public static boolean a(bp bpVar, at atVar) {
        boolean z = false;
        if (bpVar == null || atVar == null) {
            v.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event or msg is null");
            if (bpVar != null) {
                bpVar.aZd.aZk = 2131232653;
            }
        } else {
            at O = at.O(atVar);
            qf qfVar;
            if (O.bwm()) {
                qfVar = new qf();
                qfVar.a(I(O));
                bpVar.aZd.aZf = qfVar;
                if (O.bwy()) {
                    bpVar.aZd.desc = O.field_content + "\n\n" + O.field_transContent;
                } else {
                    bpVar.aZd.desc = O.field_content;
                }
                bpVar.aZd.type = 1;
                if (h.PC(bpVar.aZd.desc) > b.sG()) {
                    bpVar.aZd.aZk = 2131232745;
                } else {
                    z = true;
                }
            } else if (O.bwb()) {
                qf qfVar2 = new qf();
                qfVar2.a(I(O));
                r5 = new pw();
                a(r5, O);
                if (m.eY(O.field_talker)) {
                    String str = O.field_imgPath;
                    ak.yW();
                    str = com.tencent.mm.sdk.platformtools.h.b(c.wV(), "recbiz_", str, ".rec", 2);
                    if (be.kS(str)) {
                        str = null;
                    } else {
                        new File(str).exists();
                    }
                    r5.IK(str);
                } else {
                    r5.IK(q.iU(O.field_imgPath));
                }
                r5.uG(3);
                r5.ip(true);
                com.tencent.mm.modelvoice.b lC = q.lC(O.field_imgPath);
                if (lC != null) {
                    r5.IG(tu(lC.getFormat()));
                    r5.uF((int) new n(O.field_content).time);
                    r0 = new LinkedList();
                    r0.add(r5);
                    qfVar2.ah(r0);
                    bpVar.aZd.aZf = qfVar2;
                    bpVar.aZd.type = 3;
                    z = true;
                }
            } else if (O.bwl()) {
                z = b(bpVar, O);
            } else if (O.bwj()) {
                com.tencent.mm.ae.d dVar = null;
                if (O.field_msgId > 0) {
                    dVar = com.tencent.mm.ae.n.GH().ai(O.field_msgId);
                }
                if ((dVar == null || dVar.cLu <= 0) && O.field_msgSvrId > 0) {
                    dVar = com.tencent.mm.ae.n.GH().ah(O.field_msgSvrId);
                }
                if (dVar == null) {
                    v.w("MicroMsg.GetFavDataSource", "getImgDataPath: try get imgInfo fail");
                    bpVar.aZd.aZk = 2131232659;
                } else {
                    qf qfVar3 = new qf();
                    qfVar3.a(I(O));
                    r4 = new pw();
                    a(r4, O);
                    r4.uG(2);
                    r4.IK(com.tencent.mm.ae.n.GH().l(com.tencent.mm.ae.e.c(dVar), SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty));
                    if (dVar.Gp()) {
                        dVar = com.tencent.mm.ae.n.GH().fC(dVar.cLE);
                        if (dVar.cyu > dVar.offset) {
                            r4.IK(com.tencent.mm.ae.n.GH().l("SERVERID://" + O.field_msgSvrId, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty));
                        }
                    }
                    r4.IL(com.tencent.mm.ae.n.GH().w(O.field_imgPath, true));
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(r4);
                    qfVar3.ah(linkedList);
                    bpVar.aZd.aZf = qfVar3;
                    bpVar.aZd.type = 2;
                    z = true;
                }
            } else if (O.bwn() || O.bwo()) {
                qfVar = new qf();
                qfVar.a(I(O));
                r4 = new pw();
                a(r4, O);
                com.tencent.mm.as.k.KV();
                r4.IK(o.lc(O.field_imgPath));
                com.tencent.mm.as.k.KV();
                r4.IL(o.ld(O.field_imgPath));
                r4.IG(e.aS(r4.msq));
                com.tencent.mm.as.n lp = p.lp(O.field_imgPath);
                v.i("MicroMsg.GetFavDataSource", "video length is %d", Integer.valueOf(lp.cyu));
                if (lp.cyu > b.sK()) {
                    bpVar.aZd.aZk = 2131232747;
                } else if (O.bwo() && p.lr(lp.getFileName())) {
                    bpVar.aZd.aZk = 2131232652;
                } else {
                    r4.uF(lp.dhK);
                    r0 = new LinkedList();
                    r0.add(r4);
                    qfVar.ah(r0);
                    bpVar.aZd.aZf = qfVar;
                    if (O.bwo()) {
                        bpVar.aZd.type = 16;
                        r4.uG(15);
                    } else {
                        bpVar.aZd.type = 4;
                        r4.uG(4);
                    }
                    com.tencent.mm.as.n lp2 = p.lp(O.field_imgPath);
                    r4.IU(lp2.bnY);
                    ayk com_tencent_mm_protocal_c_ayk = lp2.dhT;
                    if (!(com_tencent_mm_protocal_c_ayk == null || be.kS(com_tencent_mm_protocal_c_ayk.cqm))) {
                        pz pzVar = new pz();
                        pzVar.cqg = com_tencent_mm_protocal_c_ayk.cqg;
                        pzVar.mtD = com_tencent_mm_protocal_c_ayk.mtD;
                        pzVar.cqj = com_tencent_mm_protocal_c_ayk.cqj;
                        pzVar.cqk = com_tencent_mm_protocal_c_ayk.cqk;
                        pzVar.cqi = com_tencent_mm_protocal_c_ayk.cqi;
                        pzVar.cql = com_tencent_mm_protocal_c_ayk.cql;
                        pzVar.cqm = com_tencent_mm_protocal_c_ayk.cqm;
                        pzVar.cqn = com_tencent_mm_protocal_c_ayk.cqn;
                        r4.a(pzVar);
                    }
                    z = true;
                }
            } else if (O.bvZ() || O.bwa()) {
                z = c(bpVar, O);
            } else if (!O.bwk() && O.bvY() && !O.bwq()) {
                qfVar = new qf();
                qfVar.a(I(O));
                String str2 = O.field_content;
                if (str2 != null) {
                    com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(str2);
                    if (dV != null) {
                        bpVar.aZd.aZf = qfVar;
                        qg qgVar = qfVar.mtP;
                        qgVar.Jt(dV.appId);
                        qgVar.Jv(dV.bnR);
                        String w;
                        pw a;
                        qe qeVar;
                        switch (dV.type) {
                            case 1:
                                bpVar.aZd.aZf = qfVar;
                                bpVar.aZd.desc = dV.title;
                                bpVar.aZd.type = 1;
                                z = true;
                                break;
                            case 2:
                                ak.yW();
                                if (!c.isSDCardAvailable()) {
                                    bpVar.aZd.aZk = 2131232665;
                                    break;
                                }
                                com.tencent.mm.pluginsdk.model.app.b Gu = am.Wf().Gu(dV.aXa);
                                r5 = new pw();
                                a(r5, O);
                                if (Gu != null) {
                                    r5.IK(Gu.field_fileFullPath);
                                }
                                w = com.tencent.mm.ae.n.GH().w(O.field_imgPath, true);
                                if (e.aR(w)) {
                                    r5.IL(w);
                                }
                                r5.uG(2);
                                r5.Iw(dV.title);
                                r5.Ix(dV.description);
                                qfVar.mtR.add(r5);
                                bpVar.aZd.type = 2;
                                z = true;
                                break;
                            case 3:
                                qfVar.mtR.add(a(O, dV, 7));
                                bpVar.aZd.type = 7;
                                z = true;
                                break;
                            case 4:
                                a = a(O, dV, 4);
                                qfVar.Jl(a.title);
                                qfVar.Jm(a.desc);
                                qfVar.mtR.add(a);
                                bpVar.aZd.type = 4;
                                z = true;
                                break;
                            case 5:
                                if (dV.url != null && !dV.url.equals(SQLiteDatabase.KeyEmpty)) {
                                    qfVar.mtP.Ju(dV.url);
                                    a = a(O, dV, 5);
                                    qfVar.mtR.add(a);
                                    qfVar.Jl(a.title);
                                    qfVar.Jm(a.desc);
                                    bpVar.aZd.type = 5;
                                    z = true;
                                    break;
                                }
                                bpVar.aZd.aZk = 2131232657;
                                break;
                                break;
                            case 6:
                                ak.yW();
                                if (c.isSDCardAvailable()) {
                                    if (dV.cof == 0 && dV.cob <= b.sK()) {
                                        com.tencent.mm.pluginsdk.model.app.b Gu2 = am.Wf().Gu(dV.aXa);
                                        pw pwVar = new pw();
                                        if (Gu2 != null) {
                                            pwVar.IK(Gu2.field_fileFullPath);
                                            if (new File(Gu2.field_fileFullPath).length() > ((long) b.sK())) {
                                                bpVar.aZd.aZk = 2131232747;
                                                break;
                                            }
                                        }
                                        a(pwVar, O);
                                        pwVar.uG(8);
                                        pwVar.IG(dV.coc);
                                        w = com.tencent.mm.ae.n.GH().w(O.field_imgPath, true);
                                        if (be.kS(w)) {
                                            pwVar.ip(true);
                                        }
                                        if (e.aR(w)) {
                                            pwVar.IL(w);
                                        }
                                        pwVar.Iw(dV.title);
                                        pwVar.Ix(dV.description);
                                        qfVar.mtR.add(pwVar);
                                        bpVar.aZd.desc = dV.title;
                                        bpVar.aZd.type = 8;
                                        z = true;
                                        break;
                                    }
                                    bpVar.aZd.aZk = 2131232747;
                                    break;
                                }
                                bpVar.aZd.aZk = 2131232665;
                                break;
                            case 7:
                                if (dV.aXa != null && dV.aXa.length() != 0) {
                                    ak.yW();
                                    if (!c.isSDCardAvailable()) {
                                        bpVar.aZd.aZk = 2131232665;
                                        break;
                                    }
                                }
                                bpVar.aZd.aZk = 2131232654;
                                bpVar.aZd.aZk = 2131232661;
                                break;
                            case 10:
                                qeVar = new qe();
                                qeVar.Jg(dV.title);
                                qeVar.Jh(dV.description);
                                qeVar.uK(dV.cox);
                                qeVar.Jj(dV.coy);
                                qeVar.Ji(dV.thumburl);
                                bpVar.aZd.title = dV.title;
                                bpVar.aZd.desc = dV.description;
                                bpVar.aZd.type = 10;
                                qfVar.b(qeVar);
                                z = true;
                                break;
                            case 13:
                                qeVar = new qe();
                                qeVar.Jg(dV.title);
                                qeVar.Jh(dV.description);
                                qeVar.uK(dV.coD);
                                qeVar.Jj(dV.coE);
                                qeVar.Ji(dV.thumburl);
                                bpVar.aZd.title = dV.title;
                                bpVar.aZd.desc = dV.description;
                                bpVar.aZd.type = 11;
                                qfVar.b(qeVar);
                                z = true;
                                break;
                            case 19:
                            case 24:
                                bpVar.aZd.aZg = new qo();
                                z = a(bpVar, dV, qfVar, O);
                                break;
                            case 20:
                                qj qjVar = new qj();
                                qjVar.Jw(dV.title);
                                qjVar.Jx(dV.description);
                                qjVar.Jz(dV.coB);
                                qjVar.Jy(dV.thumburl);
                                bpVar.aZd.title = dV.title;
                                bpVar.aZd.desc = dV.description;
                                bpVar.aZd.type = 15;
                                qfVar.b(qjVar);
                                z = true;
                                break;
                            default:
                                bpVar.aZd.aZk = 2131232661;
                                break;
                        }
                    }
                    bpVar.aZd.aZk = 2131232662;
                } else {
                    bpVar.aZd.aZk = 2131232662;
                }
            } else {
                bpVar.aZd.aZk = 2131232661;
            }
            bpVar.aZd.aZh = O.field_content;
        }
        return z;
    }

    private static qg I(at atVar) {
        qg qgVar = new qg();
        if (atVar.field_isSend == 1) {
            qgVar.Jn(k.xF());
            qgVar.Jo(atVar.field_talker);
            if (m.dE(atVar.field_talker)) {
                qgVar.Jq(qgVar.bhM);
            }
        } else {
            qgVar.Jn(atVar.field_talker);
            qgVar.Jo(k.xF());
            if (m.dE(atVar.field_talker)) {
                qgVar.Jq(atVar.field_content != null ? atVar.field_content.substring(0, Math.max(0, atVar.field_content.indexOf(58))) : SQLiteDatabase.KeyEmpty);
                if (!(be.kS(qgVar.mtu) || atVar.bwb())) {
                    atVar.setContent(atVar.field_content.substring(qgVar.mtu.length() + 1));
                    if (atVar.field_content.length() > 0 && '\n' == atVar.field_content.charAt(0)) {
                        atVar.setContent(atVar.field_content.substring(1));
                    }
                    if (atVar.bwu()) {
                        atVar.cK(atVar.field_transContent.substring(qgVar.mtu.length() + 1));
                        if (atVar.field_transContent.length() > 0 && '\n' == atVar.field_transContent.charAt(0)) {
                            atVar.cK(atVar.field_transContent.substring(1));
                        }
                    }
                }
            }
        }
        qgVar.uN(1);
        qgVar.dV(atVar.field_createTime);
        qgVar.Jr(atVar.field_msgSvrId);
        if (atVar.field_msgSvrId > 0) {
            qgVar.Jp(atVar.field_msgSvrId);
        }
        return qgVar;
    }

    private static boolean b(bp bpVar, at atVar) {
        qf qfVar = new qf();
        qfVar.a(I(atVar));
        Map q = bf.q(atVar.field_content, "msg");
        if (q != null) {
            try {
                qc qcVar = new qc();
                qcVar.Je((String) q.get(".msg.location.$label"));
                qcVar.k(Double.parseDouble((String) q.get(".msg.location.$x")));
                qcVar.j(Double.parseDouble((String) q.get(".msg.location.$y")));
                qcVar.uJ(Integer.valueOf((String) q.get(".msg.location.$scale")).intValue());
                qcVar.Jf((String) q.get(".msg.location.$poiname"));
                qfVar.b(qcVar);
                bpVar.aZd.type = 6;
                bpVar.aZd.aZf = qfVar;
                return true;
            } catch (Exception e) {
                v.e("MicroMsg.GetFavDataSource", "parse failed, %s", e.getStackTrace().toString());
            }
        }
        bpVar.aZd.aZk = 2131232662;
        return false;
    }

    private static void a(pw pwVar, at atVar) {
        if (atVar.field_isSend != 1) {
            pwVar.IO(String.valueOf(atVar.field_msgSvrId));
        } else if (m.dE(atVar.field_talker) || atVar.field_talker.equals("filehelper")) {
            pwVar.IO(String.valueOf(atVar.field_msgSvrId));
        } else {
            pwVar.IO(atVar.field_talker + "#" + String.valueOf(atVar.field_msgSvrId));
        }
    }

    public static String tu(int i) {
        if (i == 1) {
            return "speex";
        }
        if (i == 4) {
            return "silk";
        }
        return "amr";
    }

    private static pw a(at atVar, com.tencent.mm.q.a.a aVar, int i) {
        pw pwVar = new pw();
        a(pwVar, atVar);
        pwVar.ID(aVar.cos);
        pwVar.IE(aVar.cot);
        pwVar.IC(aVar.url);
        pwVar.io(true);
        File file = new File(be.ah(com.tencent.mm.ae.n.GH().w(atVar.field_imgPath, true), SQLiteDatabase.KeyEmpty));
        if (file.exists()) {
            pwVar.IL(file.getAbsolutePath());
        } else {
            pwVar.ip(true);
        }
        pwVar.Iw(aVar.title);
        pwVar.Ix(aVar.description);
        pwVar.IV(aVar.canvasPageXml);
        pwVar.uG(i);
        pwVar.IU(aVar.bnY);
        return pwVar;
    }

    private static boolean c(bp bpVar, at atVar) {
        qf qfVar = new qf();
        qg I = I(atVar);
        qfVar.a(I);
        try {
            com.tencent.mm.q.c dZ = com.tencent.mm.q.a.a.dZ(atVar.field_content);
            List list = dZ.cqE;
            I.Jv(dZ.bnR);
            if (list != null && list.size() > bpVar.aZd.aZi) {
                String Be;
                qp qpVar;
                v.i("MicroMsg.GetFavDataSource", "favorite biz msg, index is %d", Integer.valueOf(bpVar.aZd.aZi));
                com.tencent.mm.q.d dVar = (com.tencent.mm.q.d) list.get(bpVar.aZd.aZi);
                I.Ju(dVar.url);
                if (bpVar.aZd.aZi > 0) {
                    I.Jp(SQLiteDatabase.KeyEmpty);
                }
                pw pwVar = new pw();
                pwVar.Iw(dVar.title);
                pwVar.Ix(dVar.cqK);
                a(pwVar, atVar);
                String str = dVar.cqI;
                if (be.kS(str)) {
                    com.tencent.mm.u.h gQ = com.tencent.mm.u.n.Bo().gQ(atVar.field_talker);
                    if (gQ != null) {
                        Be = gQ.Be();
                        if (be.kS(Be)) {
                            pwVar.IL(r.o(Be, atVar.field_type, bpVar.aZd.aZi <= 0 ? "@S" : "@T"));
                            pwVar.ip(false);
                            if (be.kS(pwVar.mss) || !FileOp.aR(pwVar.mss)) {
                                pwVar.IF(Be);
                                pwVar.ip(true);
                                qpVar = new qp();
                                qpVar.JD(Be);
                                qfVar.b(qpVar);
                            }
                        } else {
                            pwVar.ip(true);
                        }
                        pwVar.io(true);
                        pwVar.uG(5);
                        qfVar.mtR.add(pwVar);
                        bpVar.aZd.aZf = qfVar;
                        bpVar.aZd.desc = dVar.title;
                        bpVar.aZd.type = 5;
                        return true;
                    }
                }
                Be = str;
                if (be.kS(Be)) {
                    pwVar.ip(true);
                } else {
                    if (bpVar.aZd.aZi <= 0) {
                    }
                    pwVar.IL(r.o(Be, atVar.field_type, bpVar.aZd.aZi <= 0 ? "@S" : "@T"));
                    pwVar.ip(false);
                    pwVar.IF(Be);
                    pwVar.ip(true);
                    qpVar = new qp();
                    qpVar.JD(Be);
                    qfVar.b(qpVar);
                }
                pwVar.io(true);
                pwVar.uG(5);
                qfVar.mtR.add(pwVar);
                bpVar.aZd.aZf = qfVar;
                bpVar.aZd.desc = dVar.title;
                bpVar.aZd.type = 5;
                return true;
            }
        } catch (Throwable e) {
            v.a("MicroMsg.GetFavDataSource", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.GetFavDataSource", "retransmit app msg error : %s", e.getLocalizedMessage());
        }
        bpVar.aZd.aZk = 2131232662;
        return false;
    }

    private static boolean a(bp bpVar, com.tencent.mm.q.a.a aVar, qf qfVar, at atVar) {
        com.tencent.mm.sdk.c.b kwVar = new kw();
        kwVar.bmf.type = 0;
        kwVar.bmf.bmh = aVar.coC;
        a.nhr.z(kwVar);
        com.tencent.mm.protocal.b.a.c cVar = kwVar.bmg.bmp;
        if (cVar == null) {
            v.w("MicroMsg.GetFavDataSource", "fill favorite event fail, parse record msg null");
            bpVar.aZd.aZk = 2131232662;
            return false;
        }
        qfVar.Jl(cVar.title);
        Iterator it = cVar.cqE.iterator();
        int i = 0;
        while (it.hasNext()) {
            pw pwVar;
            int i2;
            pw pwVar2 = (pw) it.next();
            pw n;
            qo qoVar;
            long j;
            com.tencent.mm.sdk.c.b kwVar2;
            qo qoVar2;
            switch (pwVar2.aKG) {
                case 1:
                    n = n(pwVar2);
                    n.uG(1);
                    n.Ix(pwVar2.desc);
                    qoVar = bpVar.aZd.aZg;
                    qoVar.muc++;
                    pwVar = n;
                    break;
                case 2:
                    j = atVar.field_msgId;
                    n = n(pwVar2);
                    n.uG(2);
                    kwVar2 = new kw();
                    kwVar2.bmf.type = 1;
                    kwVar2.bmf.bdE = pwVar2;
                    kwVar2.bmf.bao = j;
                    a.nhr.z(kwVar2);
                    if (be.kS(kwVar2.bmg.bmq) && be.kS(kwVar2.bmg.bdZ)) {
                        v.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
                    }
                    n.IK(kwVar2.bmg.bmq);
                    n.IL(kwVar2.bmg.bdZ);
                    n.ip(false);
                    n.io(false);
                    qoVar = bpVar.aZd.aZg;
                    qoVar.mud++;
                    pwVar = n;
                    break;
                case 3:
                    j = atVar.field_msgId;
                    n = n(pwVar2);
                    n.uG(3);
                    if (!be.kS(pwVar2.msU)) {
                        kwVar2 = new kw();
                        kwVar2.bmf.type = 1;
                        kwVar2.bmf.bdE = pwVar2;
                        kwVar2.bmf.bao = j;
                        a.nhr.z(kwVar2);
                        if (be.kS(kwVar2.bmg.bmq) && be.kS(kwVar2.bmg.bdZ)) {
                            v.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
                        }
                        n.IK(kwVar2.bmg.bmq);
                        n.uF(pwVar2.duration);
                        n.ip(true);
                        n.io(false);
                        n.IG(pwVar2.msh);
                    }
                    qoVar = bpVar.aZd.aZg;
                    qoVar.mue++;
                    pwVar = n;
                    break;
                case 4:
                case 15:
                    j = atVar.field_msgId;
                    n = n(pwVar2);
                    a(n, pwVar2);
                    if (pwVar2.aKG == 15) {
                        n.uG(15);
                    } else {
                        n.uG(4);
                    }
                    kwVar2 = new kw();
                    kwVar2.bmf.type = 1;
                    kwVar2.bmf.bdE = pwVar2;
                    kwVar2.bmf.bao = j;
                    a.nhr.z(kwVar2);
                    if (be.kS(kwVar2.bmg.bmq) && be.kS(kwVar2.bmg.bdZ)) {
                        v.e("MicroMsg.GetFavDataSource", "cloneVideoItem:not record plugin ? get paths error");
                    }
                    n.io(false);
                    n.IK(kwVar2.bmg.bmq);
                    n.ip(false);
                    n.IL(kwVar2.bmg.bdZ);
                    n.uF(pwVar2.duration);
                    qoVar = bpVar.aZd.aZg;
                    qoVar.muf++;
                    pwVar = n;
                    break;
                case 5:
                    j = atVar.field_msgId;
                    n = n(pwVar2);
                    a(n, pwVar2);
                    n.uG(5);
                    kwVar2 = new kw();
                    kwVar2.bmf.type = 1;
                    kwVar2.bmf.bdE = pwVar2;
                    kwVar2.bmf.bao = j;
                    a.nhr.z(kwVar2);
                    if (be.kS(kwVar2.bmg.bmq) && be.kS(kwVar2.bmg.bdZ)) {
                        v.e("MicroMsg.GetFavDataSource", "cloneUrlItem:not record plugin ? get paths error");
                    }
                    n.IL(kwVar2.bmg.bdZ);
                    n.ip(false);
                    if (!(pwVar2.msM == null || pwVar2.msM.mtc == null)) {
                        qp qpVar = new qp();
                        qpVar.JA(pwVar2.msM.mtc.title);
                        qpVar.JB(pwVar2.msM.mtc.desc);
                        qpVar.JD(pwVar2.msM.mtc.bea);
                        qpVar.uO(pwVar2.msM.mtc.mut);
                        qpVar.JC(pwVar2.msM.mtc.mur);
                        n.msM.a(qpVar);
                    }
                    qoVar = bpVar.aZd.aZg;
                    qoVar.mug++;
                    pwVar = n;
                    break;
                case 6:
                    n = n(pwVar2);
                    n.uG(6);
                    if (!(pwVar2.msM == null || pwVar2.msM.mta == null)) {
                        qc qcVar = new qc();
                        qcVar.Je(pwVar2.msM.mta.label);
                        qcVar.k(pwVar2.msM.mta.lat);
                        qcVar.j(pwVar2.msM.mta.lng);
                        qcVar.uJ(pwVar2.msM.mta.bhu);
                        qcVar.Jf(pwVar2.msM.mta.bkV);
                        n.msM.a(qcVar);
                    }
                    qoVar = bpVar.aZd.aZg;
                    qoVar.muh++;
                    pwVar = n;
                    break;
                case 7:
                    j = atVar.field_msgId;
                    n = n(pwVar2);
                    a(n, pwVar2);
                    n.uG(7);
                    kwVar2 = new kw();
                    kwVar2.bmf.type = 1;
                    kwVar2.bmf.bdE = pwVar2;
                    kwVar2.bmf.bao = j;
                    a.nhr.z(kwVar2);
                    if (be.kS(kwVar2.bmg.bmq) && be.kS(kwVar2.bmg.bdZ)) {
                        v.e("MicroMsg.GetFavDataSource", "cloneMusicItem:not record plugin ? get paths error");
                    }
                    n.IL(kwVar2.bmg.bdZ);
                    n.ip(false);
                    qoVar = bpVar.aZd.aZg;
                    qoVar.mui++;
                    pwVar = n;
                    break;
                case 8:
                    j = atVar.field_msgId;
                    n = n(pwVar2);
                    a(n, pwVar2);
                    n.uG(8);
                    kwVar2 = new kw();
                    kwVar2.bmf.type = 1;
                    kwVar2.bmf.bdE = pwVar2;
                    kwVar2.bmf.bao = j;
                    a.nhr.z(kwVar2);
                    if (be.kS(kwVar2.bmg.bmq) && be.kS(kwVar2.bmg.bdZ)) {
                        v.e("MicroMsg.GetFavDataSource", "cloneFileItem:not record plugin ? get paths error");
                    }
                    n.IK(kwVar2.bmg.bmq);
                    n.IL(kwVar2.bmg.bdZ);
                    n.io(false);
                    n.IG(pwVar2.msh);
                    qoVar = bpVar.aZd.aZg;
                    qoVar.muj++;
                    pwVar = n;
                    break;
                case 10:
                    pwVar2 = a(pwVar2, pwVar2.aKG);
                    qoVar2 = bpVar.aZd.aZg;
                    qoVar2.mul++;
                    pwVar = pwVar2;
                    break;
                case 11:
                    pwVar2 = a(pwVar2, pwVar2.aKG);
                    qoVar2 = bpVar.aZd.aZg;
                    qoVar2.mum++;
                    pwVar = pwVar2;
                    break;
                case 12:
                case 14:
                    n = n(pwVar2);
                    n.uG(14);
                    if (!(pwVar2.msM == null || pwVar2.msM.mtg == null)) {
                        qj qjVar = new qj();
                        qjVar.Jw(pwVar2.msM.mtg.title);
                        qjVar.Jx(pwVar2.msM.mtg.desc);
                        qjVar.Jz(pwVar2.msM.mtg.info);
                        qjVar.Jy(pwVar2.msM.mtg.bea);
                        n.msM.a(qjVar);
                    }
                    qoVar = bpVar.aZd.aZg;
                    qoVar.mup++;
                    pwVar = n;
                    break;
                case 16:
                    n = n(pwVar2);
                    n.uG(16);
                    n.Ix(pwVar2.desc);
                    qoVar = bpVar.aZd.aZg;
                    qoVar.muq++;
                    pwVar = n;
                    break;
                default:
                    pwVar = null;
                    break;
            }
            if (pwVar != null) {
                String format;
                int i3 = i + 1;
                if (atVar.field_isSend != 1) {
                    format = String.format("%d$%d", new Object[]{Long.valueOf(atVar.field_msgSvrId), Integer.valueOf(i)});
                } else if (m.dE(atVar.field_talker) || atVar.field_talker.equals("filehelper")) {
                    format = String.format("%d$%d", new Object[]{Long.valueOf(atVar.field_msgSvrId), Integer.valueOf(i)});
                } else {
                    format = String.format("%s#%d$%d", new Object[]{atVar.field_talker, Long.valueOf(atVar.field_msgSvrId), Integer.valueOf(i)});
                }
                pwVar.IO(format);
                qfVar.mtR.add(pwVar);
                i2 = i3;
            } else {
                i2 = i;
            }
            i = i2;
        }
        if (be.kS(((pw) cVar.cqE.get(0)).msh) || !((pw) cVar.cqE.get(0)).msh.equals(".htm")) {
            bpVar.aZd.type = 14;
        } else {
            bpVar.aZd.type = 18;
        }
        return true;
    }

    private static pw n(pw pwVar) {
        pw pwVar2 = new pw();
        px pxVar = new px();
        py pyVar = new py();
        py pyVar2 = pwVar.msM.msY;
        if (pyVar2.mtq) {
            pyVar.IW(pyVar2.bhM);
        }
        if (pyVar2.mtr) {
            pyVar.IX(pyVar2.toUser);
        }
        if (pyVar2.mtv) {
            pyVar.IZ(pyVar2.mtu);
        }
        pyVar.uI(1);
        pyVar.dS(be.Ni());
        pxVar.c(pyVar);
        pwVar2.a(pxVar);
        pwVar2.IR(pwVar.msO);
        pwVar2.IS(pwVar.msQ);
        pwVar2.ip(true);
        pwVar2.io(true);
        pwVar2.IT(pwVar.msU);
        pwVar2.IH(pwVar.msj);
        pwVar2.II(pwVar.msl);
        pwVar2.dQ(pwVar.msn);
        pwVar2.IM(pwVar.msu);
        pwVar2.IN(pwVar.msw);
        pwVar2.dR(pwVar.msy);
        return pwVar2;
    }

    private static void a(pw pwVar, pw pwVar2) {
        pwVar.ID(pwVar2.msb);
        pwVar.IE(pwVar2.msd);
        pwVar.IC(pwVar2.mrZ);
        pwVar.Iw(pwVar2.title);
        pwVar.Ix(pwVar2.desc);
    }

    private static pw a(pw pwVar, int i) {
        pw n = n(pwVar);
        n.uG(i);
        if (!(pwVar.msM == null || pwVar.msM.mte == null)) {
            qe qeVar = new qe();
            qeVar.Jg(pwVar.msM.mte.title);
            qeVar.Jh(pwVar.msM.mte.desc);
            qeVar.uK(pwVar.msM.mte.type);
            qeVar.Jj(pwVar.msM.mte.info);
            qeVar.Ji(pwVar.msM.mte.bea);
            n.msM.a(qeVar);
        }
        return n;
    }
}
