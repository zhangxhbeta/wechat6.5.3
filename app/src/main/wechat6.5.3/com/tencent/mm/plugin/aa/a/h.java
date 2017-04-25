package com.tencent.mm.plugin.aa.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.a.g;
import com.tencent.mm.ae.f;
import com.tencent.mm.ae.n;
import com.tencent.mm.e.a.r;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.aa.a.b.c;
import com.tencent.mm.plugin.aa.b;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.protocal.c.w;
import com.tencent.mm.q.a.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public final class h {
    private static synchronized void aj(String str, String str2) {
        boolean z = true;
        synchronized (h.class) {
            if (!be.kS(str) && m.dE(str2)) {
                a dV = a.dV(str);
                if (!(dV == null || be.kS(dV.cpS))) {
                    c me = b.No().me(dV.cpS);
                    String str3 = "MicroMsg.AAUtil";
                    String str4 = "insertAAMsg, billNo: %s, chatroom: %s, oldRecord: %s, insertMsg: %s, localMsgId: %s";
                    Object[] objArr = new Object[5];
                    objArr[0] = dV.cpS;
                    objArr[1] = str2;
                    objArr[2] = me;
                    if (me == null || !me.field_insertmsg) {
                        z = false;
                    }
                    objArr[3] = Boolean.valueOf(z);
                    objArr[4] = Long.valueOf(me != null ? me.field_localMsgId : 0);
                    v.i(str3, str4, objArr);
                    if (me == null) {
                        v.e("MicroMsg.AAUtil", "insertAAMsg, record is null!!");
                    } else if (!me.field_insertmsg || me.field_localMsgId <= 0) {
                        at atVar = new at();
                        atVar.z(aw.fN(str2));
                        atVar.setType(436207665);
                        atVar.setContent(k.xF() + ":\n" + str);
                        String m = g.m((be.Ni()).getBytes());
                        String iU = n.GH().iU(m);
                        n.GH();
                        m = f.iV(m);
                        com.tencent.mm.ae.a.a GL = n.GL();
                        String str5 = dV.cpC;
                        com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
                        aVar.cPu = iU;
                        aVar.cPs = true;
                        GL.a(str5, null, aVar.GU());
                        atVar.cI(m);
                        atVar.di(1);
                        atVar.cH(str2);
                        atVar.dh(3);
                        atVar.x(aw.e(atVar));
                        v.i("MicroMsg.AAUtil", "finish insert aa msg");
                        a(dV.cpS, true, atVar.field_msgId);
                        r rVar = new r();
                        rVar.aXc.aXd = atVar;
                        rVar.aXc.aXe = dV;
                        com.tencent.mm.sdk.c.a.nhr.z(rVar);
                        com.tencent.mm.q.a aVar2 = new com.tencent.mm.q.a();
                        dV.a(aVar2);
                        aVar2.field_msgId = atVar.field_msgId;
                        am.bnC().b(aVar2);
                    }
                }
            }
        }
    }

    public static synchronized void a(String str, boolean z, long j) {
        synchronized (h.class) {
            if (!be.kS(str)) {
                v.i("MicroMsg.AAUtil", "insertOrUpdateAARecord, billNo: %s, insertMsg: %s", new Object[]{str, Boolean.valueOf(z)});
                c cVar = new c();
                cVar.field_billNo = str;
                cVar.field_insertmsg = z;
                cVar.field_localMsgId = j;
                b.No().a(cVar);
            }
        }
    }

    public static synchronized void ak(String str, String str2) {
        boolean z = true;
        synchronized (h.class) {
            if (!be.kS(str)) {
                a dV = a.dV(str);
                String str3 = "MicroMsg.AAUtil";
                String str4 = "checkIfInsertAAMsg, billNo: %s, appMsgContent: %s";
                Object[] objArr = new Object[2];
                objArr[0] = dV != null ? dV.cpS : "";
                objArr[1] = str.trim().replace(" ", "");
                v.d(str3, str4, objArr);
                if (!(dV == null || be.kS(dV.cpS))) {
                    boolean z2;
                    String str5 = dV.cpS;
                    c me = b.No().me(str5);
                    str4 = "MicroMsg.AAUtil";
                    String str6 = "checkIfInsertAAMsg, record==null: %s, billNo: %s, insertMsg: %s, chatroom: %s, localMsgId: %s";
                    Object[] objArr2 = new Object[5];
                    if (me == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objArr2[0] = Boolean.valueOf(z2);
                    objArr2[1] = str5;
                    if (me == null || !me.field_insertmsg) {
                        z = false;
                    }
                    objArr2[2] = Boolean.valueOf(z);
                    objArr2[3] = str2;
                    objArr2[4] = Long.valueOf(me != null ? me.field_localMsgId : 0);
                    v.i(str4, str6, objArr2);
                    if (me == null) {
                        v.e("MicroMsg.AAUtil", "checkIfInsertAAMsg, record is null, ignore");
                    } else {
                        ak.yW();
                        at ek = com.tencent.mm.model.c.wJ().ek(me.field_localMsgId);
                        if (me.field_insertmsg && me.field_localMsgId > 0 && ek.field_msgId <= 0) {
                            v.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, the oldMsgInfo has deleted, ignore this");
                            b.No().c(me, new String[0]);
                        } else if (!me.field_insertmsg || me.field_localMsgId <= 0) {
                            v.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, insert new aa msg");
                            aj(str, str2);
                        } else {
                            v.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, update aa msg");
                            d(me.field_localMsgId, str);
                        }
                    }
                }
            }
        }
    }

    public static synchronized void p(String str, String str2, String str3) {
        synchronized (h.class) {
            v.i("MicroMsg.AAUtil", "setAARecordAfterLaunchAA, billNo: %s, chatroom: %s, msgContent==null:%s, oldRecord: %s", new Object[]{str, str2, Boolean.valueOf(be.kS(str3)), b.No().me(str)});
            if (b.No().me(str) == null) {
                a(str, false, 0);
            }
            ak(str3, str2);
        }
    }

    public static synchronized void b(String str, String str2, String str3, String str4, String str5) {
        boolean z = true;
        synchronized (h.class) {
            v.d("MicroMsg.AAUtil", "insertPayMsgAfterPaySucc, launcherUsername: %s, billNo: %s, payMsgId: %s", new Object[]{str, str3, str4});
            if (!(be.kS(str) || be.kS(str3) || be.kS(str4))) {
                com.tencent.mm.plugin.aa.a.b.a md = b.Np().md(str4);
                String str6 = "MicroMsg.AAUtil";
                String str7 = "insertPayMsgAfterPaySucc, launcherUsername: %s, chatroom: %s, payMsgId: %s, record: %s, insertmsg: %s";
                Object[] objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = str2;
                objArr[2] = str4;
                objArr[3] = md;
                if (md == null || !md.field_insertmsg) {
                    z = false;
                }
                objArr[4] = Boolean.valueOf(z);
                v.i(str6, str7, objArr);
                if (md == null || !md.field_insertmsg) {
                    String str8 = "weixin://weixinnewaa/opendetail?billno=" + str3 + "&launcherusername=" + str;
                    if (be.kS(str5)) {
                        v.i("MicroMsg.AAUtil", "empty msgxml, insert local msgcontent");
                        if (str.equals(k.xF())) {
                            str5 = aa.getContext().getString(2131234142, new Object[]{str8});
                        } else {
                            String D = l.D(str, str2);
                            str5 = aa.getContext().getString(2131234143, new Object[]{D, str8});
                        }
                    } else {
                        v.d("MicroMsg.AAUtil", "insert msgxml: %s", new Object[]{str5});
                    }
                    a(str5, str2, md, str4);
                }
            }
        }
    }

    public static synchronized void q(String str, String str2, String str3) {
        synchronized (h.class) {
            try {
                if (!(be.kS(str) || be.kS(str2) || be.kS(str3))) {
                    v.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, chatroom: %s, payMsgId: %s", new Object[]{str2, str3});
                    com.tencent.mm.plugin.aa.a.b.a md = b.Np().md(str3);
                    if (md == null || !md.field_insertmsg) {
                        v.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, insert new msg");
                        a(str, str2, md, str3);
                    } else {
                        ak.yW();
                        at ek = com.tencent.mm.model.c.wJ().ek(md.field_msgId);
                        v.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, update old one, msgId: %s, dbMsginfo.id: %s", new Object[]{Long.valueOf(md.field_msgId), Long.valueOf(ek.field_msgId)});
                        ek.setContent(str);
                        ak.yW();
                        com.tencent.mm.model.c.wJ().a(md.field_msgId, ek);
                    }
                }
            } catch (Exception e) {
                v.e("MicroMsg.AAUtil", "checkIfInsertPaySysMsg error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    private static synchronized void a(String str, String str2, com.tencent.mm.plugin.aa.a.b.a aVar, String str3) {
        synchronized (h.class) {
            at atVar = new at();
            atVar.di(0);
            atVar.cH(str2);
            atVar.dh(3);
            atVar.setContent(str);
            atVar.z(aw.h(str2, System.currentTimeMillis() / 1000));
            atVar.setType(10000);
            ak.yW();
            long R = com.tencent.mm.model.c.wJ().R(atVar);
            v.i("MicroMsg.AAUtil", "insertPaySysMsg, inserted msgId: %s", new Object[]{Long.valueOf(R)});
            if (aVar == null) {
                aVar = new com.tencent.mm.plugin.aa.a.b.a();
            }
            if (R > 0) {
                aVar.field_payMsgId = str3;
                aVar.field_chatroom = str2;
                aVar.field_insertmsg = true;
                aVar.field_msgId = R;
                b.Np().a(aVar);
            }
        }
    }

    public static synchronized void d(long j, String str) {
        synchronized (h.class) {
            if (j > 0) {
                if (!be.kS(str)) {
                    a dV = a.dV(str);
                    if (dV == null || be.kS(dV.cpS)) {
                        v.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, parse app msg failed, msgId: %s", new Object[]{Long.valueOf(j)});
                    } else {
                        v.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgId: %s, billNo: %s", new Object[]{Long.valueOf(j), dV.cpS});
                        c me = b.No().me(dV.cpS);
                        if (me != null) {
                            long j2 = me.field_localMsgId;
                            ak.yW();
                            at ek = com.tencent.mm.model.c.wJ().ek(j2);
                            if (ek.field_msgId > 0) {
                                ek.setContent(aw.fL(ek.field_content) + ":\n" + str);
                                ak.yW();
                                com.tencent.mm.model.c.wJ().a(j2, ek);
                                v.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, update success, oldMsgId: %s, billNo: %s", new Object[]{Long.valueOf(j2), me.field_billNo});
                            } else {
                                v.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, cannot find old msg, insert new one, billNo: %s, oldMsgId: %s, newMsgId: %s, needUpdateInfo.msgId: %s", new Object[]{me.field_billNo, Long.valueOf(me.field_localMsgId), Long.valueOf(j), Long.valueOf(ek.field_msgId)});
                            }
                        } else {
                            me = new c();
                            me.field_localMsgId = j;
                            me.field_billNo = dV.cpS;
                            me.field_insertmsg = true;
                            b.No().b(me);
                            v.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, insert new aa record, msgId: %s, billNo: %s", new Object[]{Long.valueOf(j), dV.cpS});
                        }
                    }
                }
            }
            v.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgContent is null or msgId invalid, msgId: %s, %s", new Object[]{Long.valueOf(j), Boolean.valueOf(be.kS(str))});
        }
    }

    public static void e(long j, String str) {
        v.i("MicroMsg.AAUtil", "do update sys msg, %s, %s", new Object[]{Long.valueOf(j), str});
        ak.yW();
        at ek = com.tencent.mm.model.c.wJ().ek(j);
        String mb = mb(str);
        if (!be.kS(mb)) {
            ek.setContent(mb);
        }
        ak.yW();
        com.tencent.mm.model.c.wJ().a(j, ek);
    }

    public static boolean a(Activity activity, w wVar) {
        if (wVar.lZi == 1) {
            v.i("MicroMsg.AAUtil", "need realname verify");
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".ui.LaunchAAUI");
            bundle.putString("realname_verify_process_jump_plugin", "aa");
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, wVar.hcl, wVar.hcm, wVar.hcn, bundle, false, null, 0, 2);
        } else if (wVar.lZi == 2) {
            v.i("MicroMsg.AAUtil", "need upload credit");
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, wVar.hcl, wVar.hco, wVar.hcm, wVar.hcn, false, null);
        } else {
            v.i("MicroMsg.AAUtil", "realnameGuideFlag =  " + wVar.lZi);
            return false;
        }
    }

    private static String mb(String str) {
        UnsupportedEncodingException e;
        String str2 = (String) bf.q(str, "sysmsg").get(".sysmsg.paymsg.appmsgcontent");
        if (be.kS(str2)) {
            v.e("MicroMsg.AAUtil", "empty appmsgcontent!");
            return "";
        }
        String str3 = "";
        try {
            str2 = URLDecoder.decode(str2, "UTF-8");
            try {
                v.d("MicroMsg.AAUtil", "msgContent: %s", new Object[]{str2});
                return str2;
            } catch (UnsupportedEncodingException e2) {
                e = e2;
                v.e("MicroMsg.AAUtil", e.getMessage());
                return str2;
            }
        } catch (UnsupportedEncodingException e3) {
            UnsupportedEncodingException unsupportedEncodingException = e3;
            str2 = str3;
            e = unsupportedEncodingException;
            v.e("MicroMsg.AAUtil", e.getMessage());
            return str2;
        }
    }

    public static double b(String str, String str2, int i, int i2) {
        return new BigDecimal(be.getDouble(str.trim(), 0.0d) == 0.0d ? "0" : str.trim()).divide(new BigDecimal(str2.trim()), i, i2).doubleValue();
    }

    public static List<String> mc(String str) {
        if (be.kS(str)) {
            v.i("MicroMsg.AAUtil", "illegal chatroomName");
            return new ArrayList();
        }
        try {
            List<String> LF = ak.yW().wO().LF(str);
            if (LF == null) {
                return new ArrayList();
            }
            return LF;
        } catch (Exception e) {
            v.e("MicroMsg.AAUtil", "getChatroomMemberList error! %s", new Object[]{e.getMessage()});
            return new ArrayList();
        }
    }
}
