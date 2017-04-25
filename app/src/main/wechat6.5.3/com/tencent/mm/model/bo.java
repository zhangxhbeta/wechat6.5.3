package com.tencent.mm.model;

import android.content.SharedPreferences;
import android.os.Looper;
import android.util.Base64;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.d.w;
import com.tencent.mm.e.a.gz;
import com.tencent.mm.e.a.hb;
import com.tencent.mm.e.a.hd;
import com.tencent.mm.e.a.he;
import com.tencent.mm.e.a.hk;
import com.tencent.mm.e.a.ko;
import com.tencent.mm.e.a.ly;
import com.tencent.mm.e.a.po;
import com.tencent.mm.h.j;
import com.tencent.mm.modelbiz.a.e;
import com.tencent.mm.o.h;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.afl;
import com.tencent.mm.protocal.c.akp;
import com.tencent.mm.protocal.c.akq;
import com.tencent.mm.protocal.c.akr;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.d;
import com.tencent.mm.v.d.c;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class bo implements d {
    private long cvB = -1;
    public a cvC;
    private Map<String, List<b>> cvD = new HashMap();
    private Map<String, List<b>> cvE = new HashMap();

    public interface a {
        void bs(String str);
    }

    public interface b {
        void a(com.tencent.mm.v.d.a aVar);
    }

    public final void a(String str, b bVar, boolean z) {
        if (!be.kS(str) && bVar != null) {
            Map map = z ? this.cvE : this.cvD;
            List list = (List) map.get(str);
            if (list == null) {
                list = new LinkedList();
                map.put(str, list);
            }
            if (!list.contains(bVar)) {
                list.add(bVar);
            }
        }
    }

    public final void b(String str, b bVar, boolean z) {
        if (!be.kS(str) && bVar != null) {
            List list = (List) (z ? this.cvE : this.cvD).get(str);
            if (list != null) {
                list.remove(bVar);
            }
        }
    }

    public final com.tencent.mm.v.d.b b(com.tencent.mm.v.d.a aVar) {
        long j;
        int i;
        bm bmVar = aVar.czu;
        String a;
        switch (bmVar.gll) {
            case CdnLogic.MediaType_FAVORITE_FILE /*10001*/:
                a = m.a(bmVar.mbU);
                m.a(bmVar.mbW);
                a(a, aVar, false);
                g.iuh.Y(10395, String.valueOf(bmVar.mcb));
                return null;
            case CdnLogic.MediaType_FAVORITE_VIDEO /*10002*/:
                String a2 = m.a(bmVar.mbW);
                if (be.kS(a2)) {
                    v.e("MicroMsg.SysCmdMsgExtension", "null msg content");
                    return null;
                }
                Map map;
                String str;
                int indexOf;
                d ax;
                String str2;
                String str3;
                int i2;
                if (a2.startsWith("~SEMI_XML~")) {
                    Map Ks = au.Ks(a2);
                    if (Ks == null) {
                        v.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", a2);
                        return null;
                    }
                    map = Ks;
                    str = "brand_service";
                } else {
                    indexOf = a2.indexOf("<sysmsg");
                    if (indexOf == -1) {
                        v.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg");
                        return null;
                    }
                    Map q = bf.q(a2.substring(indexOf), "sysmsg");
                    if (q == null) {
                        v.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", a2);
                        return null;
                    }
                    map = q;
                    str = (String) q.get(".sysmsg.$type");
                }
                v.d("MicroMsg.SysCmdMsgExtension", "recieve a syscmd_newxml %s subType %s", a2, str);
                if (str != null) {
                    a(str, aVar, true);
                }
                com.tencent.mm.v.d.b bVar = null;
                if (str != null && str.equals("addcontact")) {
                    bmVar.mbW = m.lY((String) map.get(".sysmsg.addcontact.content"));
                    ax = c.ax(Integer.valueOf(1));
                    bVar = ax == null ? null : ax.b(aVar);
                }
                if (str != null && str.equals("dynacfg")) {
                    j.sU().a(a2, map, false);
                    j.sV();
                    if (com.tencent.mm.h.c.sN() == 2) {
                        g.iuh.Y(10879, SQLiteDatabase.KeyEmpty);
                    }
                    v.d("MicroMsg.SysCmdMsgExtension", "Mute_Room_Disable:" + Integer.toString(be.getInt(j.sU().getValue("MuteRoomDisable"), 0)));
                }
                if (str != null && str.equals("dynacfg_split")) {
                    j.sU().a(a2, map, true);
                }
                if (str != null && str.equals("banner")) {
                    a = (String) map.get(".sysmsg.mainframebanner.$type");
                    str2 = (String) map.get(".sysmsg.mainframebanner.showtype");
                    str3 = (String) map.get(".sysmsg.mainframebanner.data");
                    if (a != null && a.length() > 0) {
                        try {
                            av.zh().a(new au(Integer.valueOf(a).intValue(), Integer.valueOf(str2).intValue(), str3));
                        } catch (Exception e) {
                            v.e("MicroMsg.SysCmdMsgExtension", e.toString());
                        }
                    }
                    str2 = (String) map.get(".sysmsg.friendrecommand.touser");
                    if (!(((String) map.get(".sysmsg.friendrecommand.fromuser")) == null || str2 == null)) {
                        try {
                            ak.yW().xt().a(str2, true, null);
                        } catch (Exception e2) {
                            v.e("MicroMsg.SysCmdMsgExtension", e2.toString());
                        }
                    }
                    a = (String) map.get(".sysmsg.banner.securitybanner.chatname");
                    str2 = (String) map.get(".sysmsg.banner.securitybanner.wording");
                    str3 = (String) map.get(".sysmsg.banner.securitybanner.showtype");
                    if (!(be.kS(a) || be.kS(str3))) {
                        try {
                            boolean z;
                            if (str3.equals("1")) {
                                z = true;
                            } else {
                                z = false;
                            }
                            ak.yW().xu().a(a, z, new String[]{str2});
                        } catch (Exception e22) {
                            v.e("MicroMsg.SysCmdMsgExtension", "[oneliang]" + e22.toString());
                        }
                    }
                }
                if (!be.kS(str) && str.equals("midinfo")) {
                    a = (String) map.get(".sysmsg.midinfo.json_buffer");
                    v.i("MicroMsg.SysCmdMsgExtension", "QueryMid time[%s] json[%s]  [%s] ", (String) map.get(".sysmsg.midinfo.time_interval"), a, a2);
                    i2 = be.getInt(str2, 0);
                    if (((long) i2) > 86400 && ((long) i2) < 864000) {
                        ak.yW();
                        c.vf().set(331777, Long.valueOf(be.Nh() + ((long) i2)));
                    }
                    if (!be.kS(a)) {
                        com.tencent.mm.plugin.report.b.c.yJ(a);
                    }
                }
                ab Mh;
                if (str != null && str.equals("revokemsg")) {
                    v.i("MicroMsg.SysCmdMsgExtension", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
                    a = (String) map.get(".sysmsg.revokemsg.session");
                    str3 = (String) map.get(".sysmsg.revokemsg.replacemsg");
                    v.i("MicroMsg.SysCmdMsgExtension", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", (String) map.get(".sysmsg.revokemsg.newmsgid"), str3);
                    long j2 = 0;
                    try {
                        j2 = be.getLong((String) map.get(".sysmsg.revokemsg.newmsgid"), 0);
                        ak.yW();
                        at S = c.wJ().S(a, j2);
                        at O = at.O(S);
                        S.setContent(str3);
                        S.setType(10000);
                        aw.a(S, aVar);
                        ak.yW();
                        c.wJ().a(S.pJ(), S);
                        ak.yW();
                        Mh = c.wK().Mh(S.pN());
                        if (Mh != null && Mh.pH() > 0) {
                            ak.yW();
                            if (Mh.pH() >= c.wJ().P(S)) {
                                Mh.df(Mh.pH() - 1);
                                ak.yW();
                                c.wK().a(Mh, Mh.getUsername());
                            }
                        }
                        if (aVar != null && aVar.czv) {
                            com.tencent.mm.sdk.h.c anVar = new an();
                            anVar.field_originSvrId = j2;
                            if (S.pJ() == 0) {
                                v.i("MicroMsg.SysCmdMsgExtension", "summerbadcr get a revoke but msg id is 0 originSvrId[%d]", Long.valueOf(j2));
                                anVar.field_content = a2;
                                anVar.field_createTime = (long) bmVar.hNS;
                                anVar.field_flag = aw.c(aVar);
                                anVar.field_fromUserName = m.a(bmVar.mbU);
                                anVar.field_toUserName = m.a(bmVar.mbV);
                                anVar.field_newMsgId = bmVar.mcb;
                                v.i("MicroMsg.SysCmdMsgExtension", "summerbadcr insert ret[%b], systemRowid[%d]", Boolean.valueOf(ak.yW().xx().b(anVar)), Long.valueOf(anVar.nmb));
                                return null;
                            }
                            v.i("MicroMsg.SysCmdMsgExtension", "summerbadcr get a revoke and has done delete info,  originSvrId[%d]", Long.valueOf(j2));
                            ak.yW().xx().a(anVar, true, new String[0]);
                            ak.yW();
                            c.wJ().ep(j2);
                        }
                        if (S.pJ() == 0 && (aVar == null || !aVar.czv)) {
                            v.i("MicroMsg.SysCmdMsgExtension", "summer revoke msg id is 0 and svrid[%d]", Long.valueOf(j2));
                            ak.yW();
                            c.wJ().ep(j2);
                        }
                        com.tencent.mm.sdk.c.b lyVar = new ly();
                        lyVar.bnd.bao = S.pJ();
                        lyVar.bnd.bne = str3;
                        lyVar.bnd.bmk = S;
                        lyVar.bnd.bnf = O;
                        lyVar.bnd.bng = j2;
                        com.tencent.mm.sdk.c.a.nhr.z(lyVar);
                    } catch (Throwable e3) {
                        j = j2;
                        v.a("MicroMsg.SysCmdMsgExtension", e3, "[oneliang][revokeMsg] msgId:%d,error:%s", Long.valueOf(j), e3.toString());
                    }
                    return null;
                } else if (str == null || !str.equals("clouddelmsg")) {
                    Object obj;
                    String str4;
                    int i3;
                    if (str != null && str.equals("updatepackage")) {
                        ax = c.ax(Integer.valueOf(-1879048175));
                        if (ax == null) {
                            bVar = null;
                        } else {
                            bVar = ax.b(aVar);
                        }
                    }
                    if (str != null && str.equals("deletepackage")) {
                        ax = c.ax(Integer.valueOf(-1879048174));
                        if (ax == null) {
                            bVar = null;
                        } else {
                            bVar = ax.b(aVar);
                        }
                    }
                    if (str != null && str.equals("abtest")) {
                        ax = c.ax(Integer.valueOf(-1879048184));
                        if (ax == null) {
                            bVar = null;
                        } else {
                            bVar = ax.b(aVar);
                        }
                    }
                    if (str != null && str.equals("delchatroommember")) {
                        str2 = m.a(bmVar.mbU);
                        ak.yW();
                        r4 = c.wJ().S(str2, bmVar.mcb);
                        obj = null;
                        if (r4.pJ() > 0) {
                            obj = 1;
                        }
                        r4.y(bmVar.mcb);
                        if (!(aVar != null && aVar.czv && aVar.czx)) {
                            r4.z(aw.h(str2, (long) bmVar.hNS));
                        }
                        r4.setType(CdnLogic.MediaType_FAVORITE_VIDEO);
                        r4.setContent(a2);
                        r4.di(0);
                        r4.cH(str2);
                        r4.cN(bmVar.mbZ);
                        aw.a(r4, aVar);
                        if (obj == null) {
                            aw.e(r4);
                        } else {
                            ak.yW();
                            c.wJ().b(bmVar.mcb, r4);
                        }
                    }
                    if (!(str == null || !str.equals("WakenPush") || this.cvB == bmVar.mcb)) {
                        this.cvB = bmVar.mcb;
                        v.i("MicroMsg.SysCmdMsgExtension", "dzmonster[subType wakenpush]");
                        com.tencent.mm.v.d.b Ag = new bt(map).Ag();
                        g.iuh.a(405, 31, 1, true);
                        bVar = Ag;
                    }
                    if (str != null && str.equals("DisasterNotice")) {
                        a = (String) map.get(".sysmsg.NoticeId");
                        v.i("MicroMsg.SysCmdMsgExtension", "disaster noticeID:%s, content:%s", a, (String) map.get(".sysmsg.Content"));
                        SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences("disaster_pref", 4);
                        r5 = sharedPreferences.getString("disaster_noticeid_list_key", SQLiteDatabase.KeyEmpty);
                        if (!r5.contains(a)) {
                            String[] split = r5.split(";");
                            if (split == null || split.length <= 10) {
                                str3 = r5;
                            } else {
                                str4 = SQLiteDatabase.KeyEmpty;
                                str3 = str4;
                                for (String str42 : split) {
                                    String[] split2 = str42.split(",");
                                    try {
                                        if (be.ax(be.getLong(split2[0], 0)) < 1296000) {
                                            str3 = str3 + split2[0] + "," + split2[1] + ";";
                                        }
                                    } catch (Exception e4) {
                                        v.e("MicroMsg.SysCmdMsgExtension", "MM_DATA_SYSCMD_NEWXML_DISASTER_NOTICE parseLong error:%s", e4);
                                    }
                                }
                            }
                            v.i("MicroMsg.SysCmdMsgExtension", "update noticeIdList %s -> %s", r5, str3 + be.Nh() + "," + a + ";");
                            sharedPreferences.edit().putString("disaster_noticeid_list_key", str3).commit();
                        }
                        new ac(Looper.getMainLooper()).post(new Runnable(this) {
                            final /* synthetic */ bo cvG;

                            public final void run() {
                                if (this.cvG.cvC != null) {
                                    this.cvG.cvC.bs(a);
                                }
                            }
                        });
                        bmVar.mbW = m.lY(str2);
                        bmVar.gll = 1;
                        ax = c.ax(Integer.valueOf(1));
                        if (ax == null) {
                            bVar = null;
                        } else {
                            bVar = ax.b(aVar);
                        }
                    }
                    String str5;
                    com.tencent.mm.ba.a com_tencent_mm_protocal_c_afl;
                    Object[] objArr;
                    if (str != null && str.equals("EmotionKv")) {
                        a = (String) map.get(".sysmsg.EmotionKv.K");
                        str5 = (String) map.get(".sysmsg.EmotionKv.I");
                        if (a == null) {
                            str2 = SQLiteDatabase.KeyEmpty;
                        } else {
                            str2 = a;
                        }
                        v.i("MicroMsg.SysCmdMsgExtension", "summercck emotionkv pcKeyStr len:%d, content[%s] pcId[%s]", Integer.valueOf(str2.length()), str2, str5);
                        byte[] bytes = ad.brG().brK().getBytes();
                        byte[] bytes2 = ad.brG().brL().getBytes();
                        byte[] bArr = null;
                        try {
                            bArr = ak.vy().uX().BU().BR();
                        } catch (Throwable e32) {
                            v.e("MicroMsg.SysCmdMsgExtension", "DISASTER_NOTICE :%s ", be.e(e32));
                        }
                        if (be.bl(bArr)) {
                            v.e("MicroMsg.SysCmdMsgExtension", "DISASTER_NOTICE  ecdh  is null .");
                            return null;
                        }
                        PByteArray pByteArray = new PByteArray();
                        if (be.kS(str2) || be.bl(bytes2) || be.bl(bytes) || be.bl(bArr)) {
                            String str6 = "MicroMsg.SysCmdMsgExtension";
                            String str7 = "summercck emotionkv param len err pcKeylen:%d, keynlen:%d, keyelen:%d, ecdhlen:%d";
                            Object[] objArr2 = new Object[4];
                            objArr2[0] = Integer.valueOf(str2 == null ? -1 : str2.length());
                            objArr2[1] = Integer.valueOf(bytes2 == null ? -1 : bytes2.length);
                            objArr2[2] = Integer.valueOf(bytes == null ? -1 : bytes.length);
                            objArr2[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                            v.w(str6, str7, objArr2);
                        } else {
                            ak.yW();
                            MMProtocalJni.genClientCheckKVRes(c.ww(), str2, bytes, bytes2, bArr, pByteArray);
                        }
                        byte[] bArr2 = pByteArray.value;
                        com_tencent_mm_protocal_c_afl = new afl();
                        if (pByteArray.value != null) {
                            com_tencent_mm_protocal_c_afl.itR = new String(pByteArray.value);
                        } else {
                            com_tencent_mm_protocal_c_afl.itR = SQLiteDatabase.KeyEmpty;
                        }
                        str3 = "MicroMsg.SysCmdMsgExtension";
                        r5 = "summercck emotionkv res len:%d val len:%d, content[%s]";
                        objArr = new Object[3];
                        objArr[0] = Integer.valueOf(bArr2 == null ? -1 : bArr2.length);
                        objArr[1] = Integer.valueOf(com_tencent_mm_protocal_c_afl.itR.length());
                        objArr[2] = com.tencent.mm.a.g.m(com_tencent_mm_protocal_c_afl.itR.getBytes());
                        v.i(str3, r5, objArr);
                        com_tencent_mm_protocal_c_afl.mFn = str5;
                        ak.yW();
                        c.wG().b(new com.tencent.mm.ak.j.a(59, com_tencent_mm_protocal_c_afl));
                        return null;
                    } else if (str != null && str.equals("globalalert")) {
                        a = (String) map.get(".sysmsg.uuid");
                        i3 = be.getInt((String) map.get(".sysmsg.id"), -1);
                        int i4 = be.getInt((String) map.get(".sysmsg.important"), -1);
                        if (be.kS(a) || i3 < 0 || i4 < 0) {
                            v.i("MicroMsg.SysCmdMsgExtension", "summeralert uuid[%s], id[%d], important[%d] is illegal ret", a, Integer.valueOf(i3), Integer.valueOf(i4));
                            return null;
                        }
                        str2 = (String) map.get(".sysmsg.title");
                        str3 = (String) map.get(".sysmsg.msg");
                        if (be.kS(str2) && be.kS(str3)) {
                            v.i("MicroMsg.SysCmdMsgExtension", "summeralert title[%s], msg[%s] is illegal ret", str2, str3);
                            return null;
                        }
                        r5 = (String) map.get(".sysmsg.btnlist.btn.$title");
                        i = be.getInt((String) map.get(".sysmsg.btnlist.btn.$id"), -1);
                        int i5 = be.getInt((String) map.get(".sysmsg.btnlist.btn.$actiontype"), -1);
                        str42 = (String) map.get(".sysmsg.btnlist.btn");
                        if (be.kS(r5) || i < 0 || i5 < 0) {
                            v.i("MicroMsg.SysCmdMsgExtension", "summeralert first btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal ret", r5, Integer.valueOf(i), Integer.valueOf(i5));
                            return null;
                        }
                        String str8 = (String) map.get(".sysmsg.btnlist.btn1.$title");
                        int i6 = be.getInt((String) map.get(".sysmsg.btnlist.btn1.$id"), -1);
                        int i7 = be.getInt((String) map.get(".sysmsg.btnlist.btn1.$actiontype"), -1);
                        str5 = (String) map.get(".sysmsg.btnlist.btn1");
                        boolean z2 = true;
                        if (be.kS(str8) || i6 < 0 || i7 < 0) {
                            z2 = false;
                            v.i("MicroMsg.SysCmdMsgExtension", "summeralert sec btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal only one btn", r5, Integer.valueOf(i), Integer.valueOf(i5));
                        }
                        com.tencent.mm.sdk.c.b gzVar = new gz();
                        com.tencent.mm.protocal.b.a.b bVar2 = new com.tencent.mm.protocal.b.a.b();
                        gzVar.bgF.bgG = bVar2;
                        bVar2.id = i3;
                        bVar2.title = str2;
                        bVar2.lcr = str3;
                        bVar2.lYu = new LinkedList();
                        com.tencent.mm.protocal.b.a.a aVar2 = new com.tencent.mm.protocal.b.a.a();
                        aVar2.id = i;
                        aVar2.actionType = i5;
                        aVar2.lYs = r5;
                        aVar2.lYt = str42;
                        bVar2.lYu.add(aVar2);
                        if (z2) {
                            com.tencent.mm.protocal.b.a.a aVar3 = new com.tencent.mm.protocal.b.a.a();
                            aVar3.id = i6;
                            aVar3.actionType = i7;
                            aVar3.lYs = str8;
                            aVar3.lYt = str5;
                            bVar2.lYu.add(aVar3);
                        }
                        boolean z3 = com.tencent.mm.sdk.c.a.nhr.z(gzVar);
                        v.i("MicroMsg.SysCmdMsgExtension", "summeralert uuid[%s], id[%d], important[%d], title[%s], msg[%s], twoBtn[%b], publish[%b]", a, Integer.valueOf(i3), Integer.valueOf(i4), str2, str3, Boolean.valueOf(z2), Boolean.valueOf(z3));
                        return null;
                    } else if (str != null && str.equals("yybsigcheck")) {
                        g.iuh.a(322, 14, 1, false);
                        long currentTimeMillis = System.currentTimeMillis();
                        a = (String) map.get(".sysmsg.yybsigcheck.yybsig.nocheckmarket");
                        v.i("MicroMsg.SysCmdMsgExtension", "summertoken newxml nocheckmarket[%s], wording[%s], url[%s]", a, (String) map.get(".sysmsg.yybsigcheck.yybsig.wording"), (String) map.get(".sysmsg.yybsigcheck.yybsig.url"));
                        g gVar = g.iuh;
                        Object[] objArr3 = new Object[2];
                        objArr3[0] = Integer.valueOf(4014);
                        objArr3[1] = String.format("%s|%s|%s", new Object[]{a, str, r12});
                        gVar.h(11098, objArr3);
                        if (be.kS(a)) {
                            v.w("MicroMsg.SysCmdMsgExtension", "summertoken newxml nocheckmarket is nil and return");
                            g.iuh.a(322, 15, 1, false);
                            g gVar2 = g.iuh;
                            Object[] objArr4 = new Object[2];
                            objArr4[0] = Integer.valueOf(4015);
                            objArr4[1] = String.format("%s|%s", new Object[]{str, r12});
                            gVar2.h(11098, objArr4);
                            return null;
                        }
                        String[] split3 = a.split(";");
                        str3 = "MicroMsg.SysCmdMsgExtension";
                        r5 = "summertoken newxml infoStrs len is %d";
                        objArr = new Object[1];
                        objArr[0] = Integer.valueOf(split3 == null ? -1 : split3.length);
                        v.d(str3, r5, objArr);
                        if (split3 == null || split3.length == 0) {
                            g.iuh.a(322, 16, 1, false);
                            g.iuh.h(11098, Integer.valueOf(4016), a);
                            return null;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (String str9 : split3) {
                            if (be.kS(str9)) {
                                v.i("MicroMsg.SysCmdMsgExtension", "summertoken newxml infoStr is nil index:%d, continue", Integer.valueOf(i));
                            } else {
                                String[] split4 = str9.split(",");
                                r5 = "MicroMsg.SysCmdMsgExtension";
                                str42 = "summertoken newxml fields len is %d";
                                Object[] objArr5 = new Object[1];
                                objArr5[0] = Integer.valueOf(split4 == null ? -1 : split4.length);
                                v.d(r5, str42, objArr5);
                                if (split4 == null || split4.length != 3) {
                                    v.i("MicroMsg.SysCmdMsgExtension", "summertoken newxml fields len is invalid index:%d, continue", Integer.valueOf(i));
                                } else {
                                    try {
                                        arrayList.add(new u.c(split4[0], Integer.valueOf(split4[1]).intValue(), split4[2]));
                                    } catch (Exception e5) {
                                        v.w("MicroMsg.SysCmdMsgExtension", "summertoken newxml parse info index:%d, e:%s", Integer.valueOf(i), e5.getMessage());
                                        g.iuh.a(322, 17, 1, false);
                                        g.iuh.h(11098, Integer.valueOf(4017), str9);
                                    }
                                }
                            }
                        }
                        if (arrayList.size() == 0) {
                            v.w("MicroMsg.SysCmdMsgExtension", "summertoken newxml marketList size is 0 and return");
                            g.iuh.a(322, 18, 1, false);
                            gVar = g.iuh;
                            objArr3 = new Object[2];
                            objArr3[0] = Integer.valueOf(4018);
                            objArr3[1] = String.format("%s|%s|%s", new Object[]{a, str, r12});
                            gVar.h(11098, objArr3);
                            return null;
                        }
                        v.i("MicroMsg.SysCmdMsgExtension", "summertoken newxml marketList size[%d], usesSystemApi[%b], containLowerMarket[%b], take[%d]ms", Integer.valueOf(arrayList.size()), Boolean.valueOf(be.getInt(j.sU().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0), Boolean.valueOf(u.a(aa.getContext(), arrayList, be.getInt(j.sU().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0)), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        if (u.a(aa.getContext(), arrayList, be.getInt(j.sU().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0)) {
                            ak.yT().setInt(46, 0);
                            g.iuh.a(322, 19, 1, true);
                            gVar = g.iuh;
                            objArr3 = new Object[2];
                            objArr3[0] = Integer.valueOf(4019);
                            objArr3[1] = String.format("%s|%s|%s", new Object[]{a, str, r12});
                            gVar.h(11098, objArr3);
                        } else {
                            ak.yT().setInt(46, 4);
                            r3 = new hk();
                            r3.bhd.bhe = str;
                            r3.bhd.url = r12;
                            com.tencent.mm.sdk.c.a.nhr.z(r3);
                            g.iuh.a(322, 20, 1, true);
                            gVar = g.iuh;
                            objArr3 = new Object[2];
                            objArr3[0] = Integer.valueOf(4020);
                            objArr3[1] = String.format("%s|%s|%s", new Object[]{a, str, r12});
                            gVar.h(11098, objArr3);
                        }
                        return null;
                    } else if (str == null || !str.equals("qy_status_notify")) {
                        if (str != null && str.equals("qy_chat_update")) {
                            a = (String) map.get(".sysmsg.chat_id");
                            str2 = (String) map.get(".sysmsg.ver");
                            map.get(".sysmsg.brand_username");
                            r4 = com.tencent.mm.modelbiz.u.DA().hR(a);
                            if (r4 == null) {
                                v.i("MicroMsg.SysCmdMsgExtension", "qy_status_notify bizChatInfo == null:%s", a);
                                return null;
                            } else if (r4.field_chatVersion < be.getInt(str2, Integer.MAX_VALUE)) {
                                r4.field_needToUpdate = true;
                                com.tencent.mm.modelbiz.u.DA().b(r4);
                            }
                        }
                        if (str == null || !str.equals("bindmobiletip")) {
                            if (str != null && str.equals("ClientCheckConsistency")) {
                                com_tencent_mm_protocal_c_afl = new akp();
                                com_tencent_mm_protocal_c_afl.cUd = (String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.fullpathfilename");
                                com_tencent_mm_protocal_c_afl.mLz = be.getInt((String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.fileoffset"), 0);
                                com_tencent_mm_protocal_c_afl.mLA = be.getInt((String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.checkbuffersize"), 0);
                                com_tencent_mm_protocal_c_afl.miI = be.getInt((String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.seq"), 0);
                                com_tencent_mm_protocal_c_afl.mLB = bb.c(com_tencent_mm_protocal_c_afl.cUd, (long) com_tencent_mm_protocal_c_afl.mLz, (long) com_tencent_mm_protocal_c_afl.mLA);
                                com_tencent_mm_protocal_c_afl.moo = (int) bb.fV(com_tencent_mm_protocal_c_afl.cUd);
                                com_tencent_mm_protocal_c_afl.mLC = bb.checkMsgLevel() ? 1 : 0;
                                com_tencent_mm_protocal_c_afl.mnk = w.sb();
                                com_tencent_mm_protocal_c_afl.mLD = bb.d(com_tencent_mm_protocal_c_afl.cUd, Integer.valueOf(com_tencent_mm_protocal_c_afl.mLz), Integer.valueOf(com_tencent_mm_protocal_c_afl.mLA), Integer.valueOf(com_tencent_mm_protocal_c_afl.miI), com_tencent_mm_protocal_c_afl.mLB, Integer.valueOf(com_tencent_mm_protocal_c_afl.moo), Integer.valueOf(com_tencent_mm_protocal_c_afl.mLC), Integer.valueOf(com_tencent_mm_protocal_c_afl.mnk));
                                ak.yW();
                                c.wG().b(new com.tencent.mm.ak.j.a(61, com_tencent_mm_protocal_c_afl));
                            }
                            if (str != null && str.equals("ClientCheckHook")) {
                                com_tencent_mm_protocal_c_afl = new akr();
                                com_tencent_mm_protocal_c_afl.miI = be.getInt((String) map.get(".sysmsg.ClientCheckHook.clientcheck.seq"), 0);
                                com_tencent_mm_protocal_c_afl.mLF = bb.zB();
                                com_tencent_mm_protocal_c_afl.mLC = bb.checkMsgLevel() ? 1 : 0;
                                com_tencent_mm_protocal_c_afl.mnk = w.sb();
                                com_tencent_mm_protocal_c_afl.mLD = bb.d(Integer.valueOf(com_tencent_mm_protocal_c_afl.miI), com_tencent_mm_protocal_c_afl.mLF, Integer.valueOf(com_tencent_mm_protocal_c_afl.mLC), Integer.valueOf(com_tencent_mm_protocal_c_afl.mnk));
                                ak.yW();
                                c.wG().b(new com.tencent.mm.ak.j.a(62, com_tencent_mm_protocal_c_afl));
                            }
                            if (str != null && str.equals("ClientCheckGetAppList")) {
                                com_tencent_mm_protocal_c_afl = new akq();
                                com_tencent_mm_protocal_c_afl.miI = be.getInt((String) map.get(".sysmsg.ClientCheckGetAppList.clientcheck.seq"), 0);
                                com_tencent_mm_protocal_c_afl.mLE = bb.zC();
                                com_tencent_mm_protocal_c_afl.mLC = bb.checkMsgLevel() ? 1 : 0;
                                com_tencent_mm_protocal_c_afl.mnk = w.sb();
                                com_tencent_mm_protocal_c_afl.mLD = bb.d(Integer.valueOf(com_tencent_mm_protocal_c_afl.miI), com_tencent_mm_protocal_c_afl.mLE, Integer.valueOf(com_tencent_mm_protocal_c_afl.mLC), Integer.valueOf(com_tencent_mm_protocal_c_afl.mnk));
                                ak.yW();
                                c.wG().b(new com.tencent.mm.ak.j.a(63, com_tencent_mm_protocal_c_afl));
                            }
                            if (str != null && str.equals("ClientCheckGetExtInfo")) {
                                ba.a(be.getInt((String) map.get(".sysmsg.ClientCheckGetExtInfo.ReportContext"), 0), bb.zx());
                            }
                            if (str != null && str.equals("WeChatOut")) {
                                indexOf = -1;
                                if (map.containsKey(".sysmsg.WeChatOut.AccountRedDotType")) {
                                    indexOf = be.getInt((String) map.get(".sysmsg.WeChatOut.AccountRedDotType"), -1);
                                    v.i("MicroMsg.SysCmdMsgExtension", "WeChatOut AccountRedDotType: %d", Integer.valueOf(indexOf));
                                    ak.yW();
                                    c.vf().a(com.tencent.mm.storage.t.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_TYPE_INT, Integer.valueOf(indexOf));
                                }
                                i2 = indexOf;
                                if (map.containsKey(".sysmsg.WeChatOut.AcctRD")) {
                                    v.i("MicroMsg.SysCmdMsgExtension", "WeChatOut AcctRD: %d", Integer.valueOf(be.getInt((String) map.get(".sysmsg.WeChatOut.AcctRD"), 0)));
                                    if (be.getInt((String) map.get(".sysmsg.WeChatOut.AcctRD"), 0) != 0) {
                                        ak.yW();
                                        c.vf().a(com.tencent.mm.storage.t.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_BOOLEAN, Boolean.valueOf(true));
                                        g.iuh.h(13254, Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(-1), Integer.valueOf(-1));
                                    } else {
                                        ak.yW();
                                        c.vf().a(com.tencent.mm.storage.t.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_BOOLEAN, Boolean.valueOf(false));
                                    }
                                }
                                if (map.containsKey(".sysmsg.WeChatOut.TabRD")) {
                                    v.i("MicroMsg.SysCmdMsgExtension", "WeChatOut TabRD: %d", Integer.valueOf(be.getInt((String) map.get(".sysmsg.WeChatOut.TabRD"), 0)));
                                    if (be.getInt((String) map.get(".sysmsg.WeChatOut.TabRD"), 0) != 0) {
                                        ak.yW();
                                        c.vf().a(com.tencent.mm.storage.t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(true));
                                        g.iuh.h(13254, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1));
                                    } else {
                                        ak.yW();
                                        c.vf().a(com.tencent.mm.storage.t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false));
                                    }
                                }
                                if (map.containsKey(".sysmsg.WeChatOut.RechargeRD")) {
                                    v.i("MicroMsg.SysCmdMsgExtension", "WeChatOut RechargeRD: %d", Integer.valueOf(be.getInt((String) map.get(".sysmsg.WeChatOut.RechargeRD"), 0)));
                                    if (be.getInt((String) map.get(".sysmsg.WeChatOut.RechargeRD"), 0) != 0) {
                                        ak.yW();
                                        c.vf().a(com.tencent.mm.storage.t.a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.valueOf(true));
                                        g.iuh.h(13254, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1));
                                    } else {
                                        ak.yW();
                                        c.vf().a(com.tencent.mm.storage.t.a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.valueOf(false));
                                    }
                                }
                                if (map.containsKey(".sysmsg.WeChatOut.RechargeWording")) {
                                    v.i("MicroMsg.SysCmdMsgExtension", "WeChatOut RechargeWording: %s", (String) map.get(".sysmsg.WeChatOut.RechargeWording"));
                                    ak.yW();
                                    c.vf().a(com.tencent.mm.storage.t.a.USERFINO_IPCALL_RECHARGE_STRING, obj);
                                }
                                if (map.containsKey(".sysmsg.WeChatOut.AccountWording")) {
                                    v.i("MicroMsg.SysCmdMsgExtension", "WeChatOut AccountWording: %s", (String) map.get(".sysmsg.WeChatOut.AccountWording"));
                                    ak.yW();
                                    c.vf().a(com.tencent.mm.storage.t.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_STRING, obj);
                                }
                                if (map.containsKey(".sysmsg.WeChatOut.RechargeWordingVersion")) {
                                    v.i("MicroMsg.SysCmdMsgExtension", "WeChatOut RechargeWordingVersion: %d", Integer.valueOf(be.getInt((String) map.get(".sysmsg.WeChatOut.RechargeWordingVersion"), 0)));
                                    ak.yW();
                                    c.vf().a(com.tencent.mm.storage.t.a.USERFINO_IPCALL_REDDOT_RECHARGE_VERSION_INT, Integer.valueOf(indexOf));
                                }
                                if (map.containsKey(".sysmsg.WeChatOut.TabWording")) {
                                    v.i("MicroMsg.SysCmdMsgExtension", "WeChatOut TabWording: %s", (String) map.get(".sysmsg.WeChatOut.TabWording"));
                                    ak.yW();
                                    c.vf().a(com.tencent.mm.storage.t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, obj);
                                }
                                if (map.containsKey(".sysmsg.WeChatOut.AccountActivityWording")) {
                                    v.i("MicroMsg.SysCmdMsgExtension", "WeChatOut AccountActivityWording: %s", (String) map.get(".sysmsg.WeChatOut.AccountActivityWording"));
                                    ak.yW();
                                    c.vf().a(com.tencent.mm.storage.t.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_STRING, obj);
                                }
                                if (map.containsKey(".sysmsg.WeChatOut.AccountActivityWordingClearType")) {
                                    v.i("MicroMsg.SysCmdMsgExtension", "WeChatOut AccountActivityWordingClearType : %d", Integer.valueOf(be.getInt((String) map.get(".sysmsg.WeChatOut.AccountActivityWordingClearType"), 0)));
                                    ak.yW();
                                    c.vf().a(com.tencent.mm.storage.t.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_CLEAR_TYPE_INT, Integer.valueOf(indexOf));
                                }
                                if (map.containsKey(".sysmsg.WeChatOut.AccountActivityWordingVersion")) {
                                    v.i("MicroMsg.SysCmdMsgExtension", "WeChatOut AccountActivityWordingVersion: %d", Integer.valueOf(be.getInt((String) map.get(".sysmsg.WeChatOut.AccountActivityWordingVersion"), 0)));
                                    ak.yW();
                                    c.vf().a(com.tencent.mm.storage.t.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_TYPE_VERSION_INT, Integer.valueOf(indexOf));
                                }
                                if (map.containsKey(".sysmsg.WeChatOut.TabRedDotType")) {
                                    v.i("MicroMsg.SysCmdMsgExtension", "WeChatOut TabRedDotType: %d", Integer.valueOf(be.getInt((String) map.get(".sysmsg.WeChatOut.TabRedDotType"), 0)));
                                    g.iuh.h(13254, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(indexOf));
                                    ak.yW();
                                    c.vf().a(com.tencent.mm.storage.t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_TYPE_INT, Integer.valueOf(indexOf));
                                }
                                indexOf = a2.indexOf("<ActivityInfo>");
                                i2 = a2.indexOf("</ActivityInfo>");
                                if (indexOf > 0 && i2 > 0 && i2 > indexOf) {
                                    v.i("MicroMsg.SysCmdMsgExtension", "WeChatOut ActivityInfo: %s", a2.substring(indexOf, i2 + 15));
                                    r3 = new hb();
                                    r3.bgN.bgO = a;
                                    com.tencent.mm.sdk.c.a.nhr.z(r3);
                                }
                                com.tencent.mm.sdk.c.a.nhr.z(new he());
                                com.tencent.mm.sdk.c.a.nhr.z(new po());
                            }
                            if (str != null && str.equals("WeChatOutMsg")) {
                                com.tencent.mm.sdk.c.b hdVar = new hd();
                                hdVar.bgT.bgU = (long) bmVar.mbT;
                                hdVar.bgT.bgV = map;
                                com.tencent.mm.sdk.c.a.nhr.z(hdVar);
                            }
                            if (!be.kS(str) && str.equals("functionmsg")) {
                                v.d("MicroMsg.SysCmdMsgExtension", "subtype functionmsg");
                                h.up().a(bmVar, map);
                            }
                            if (!be.kS(str) && str.equals("paymsg")) {
                                v.d("MicroMsg.SysCmdMsgExtension", "payMsg, payMsgType: %s, MsgId: %s, fromUsername: %s, toUsername: %s, paymsgid: %s, appMsgContentEncode: %s, ", Integer.valueOf(be.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), 0)), Long.valueOf(bmVar.mcb), (String) map.get(".sysmsg.paymsg.fromusername"), (String) map.get(".sysmsg.paymsg.tousername"), (String) map.get(".sysmsg.paymsg.paymsgid"), (String) map.get(".sysmsg.paymsg.appmsgcontent"));
                                try {
                                    a = URLDecoder.decode((String) map.get(".sysmsg.paymsg.appmsgcontent"), "UTF-8");
                                    if (!be.kS(a)) {
                                        com.tencent.mm.sdk.c.b koVar = new ko();
                                        koVar.blR.type = r7;
                                        koVar.blR.content = a;
                                        koVar.blR.bhM = str2;
                                        koVar.blR.toUser = str3;
                                        koVar.blR.blS = r5;
                                        com.tencent.mm.sdk.c.a.nhr.z(koVar);
                                    }
                                } catch (Throwable e322) {
                                    v.a("MicroMsg.SysCmdMsgExtension", e322, SQLiteDatabase.KeyEmpty, new Object[0]);
                                    v.d("MicroMsg.SysCmdMsgExtension", "pay msg, parse failed: %s", e322.getMessage());
                                }
                            }
                            return bVar;
                        }
                        i2 = be.getInt((String) map.get(".sysmsg.bindmobiletip.forcebind"), 0);
                        str3 = be.ma((String) map.get(".sysmsg.bindmobiletip.deviceid"));
                        Object ma = be.ma((String) map.get(".sysmsg.bindmobiletip.wording"));
                        a = new String(Base64.decode(str3.getBytes(), 0));
                        v.i("MicroMsg.SysCmdMsgExtension", "summerbindmobile forceBind:%d,decodeDeviceId[%s],localDeviceId[%s],woridingStr[%s]", Integer.valueOf(i2), a, new String(com.tencent.mm.ba.b.aT(p.rK().getBytes()).uz(16).getBytes()), ma);
                        if (be.kS(a) || a.equals(r4)) {
                            ak.yW();
                            c.vf().a(com.tencent.mm.storage.t.a.USERINFO_BIND_MOBILE_XML_TIP_BOOLEAN, Boolean.valueOf(true));
                            ak.yW();
                            c.vf().a(com.tencent.mm.storage.t.a.USERINFO_BIND_MOBILE_XML_FORCE_BIND_BOOLEAN, Boolean.valueOf(i2 == 1));
                            ak.yW();
                            c.vf().a(com.tencent.mm.storage.t.a.USERINFO_BIND_MOBILE_XML_WORDING_STRING, ma);
                        }
                        return null;
                    } else {
                        a = (String) map.get(".sysmsg.chat_id");
                        map.get(".sysmsg.last_create_time");
                        str2 = (String) map.get(".sysmsg.brand_username");
                        j = e.ia(a);
                        if (j == -1) {
                            v.i("MicroMsg.SysCmdMsgExtension", "qy_status_notify bizLocalId == -1,%s", a);
                            return null;
                        }
                        indexOf = com.tencent.mm.modelbiz.u.DB().T(j).field_newUnReadCount;
                        com.tencent.mm.modelbiz.u.DB().V(j);
                        r4 = com.tencent.mm.modelbiz.u.DA().Z(j);
                        ak.yW();
                        Mh = c.wK().Mh(str2);
                        if (Mh == null) {
                            v.w("MicroMsg.SysCmdMsgExtension", "qy_status_notify cvs == null:%s", str2);
                            return null;
                        } else if (r4.fe(1)) {
                            if (Mh.pI() <= indexOf) {
                                Mh.dm(0);
                                ak.yW();
                                c.wK().a(Mh, str2);
                                ak.oH().cancelNotification(str2);
                            } else {
                                Mh.dm(Mh.pI() - indexOf);
                                ak.yW();
                                c.wK().a(Mh, str2);
                            }
                            return null;
                        } else {
                            if (Mh.pH() <= indexOf) {
                                ak.yW();
                                c.wK().Mj(str2);
                                ak.oH().cancelNotification(str2);
                            } else {
                                Mh.dl(0);
                                Mh.do(0);
                                Mh.df(Mh.pH() - indexOf);
                                ak.yW();
                                c.wK().a(Mh, str2);
                            }
                            return null;
                        }
                    }
                } else {
                    v.i("MicroMsg.SysCmdMsgExtension", "mm hit MM_DATA_SYSCMD_NEWXML_CLOUD_DEL_MSG");
                    a = (String) map.get(".sysmsg.clouddelmsg.delcommand");
                    str2 = (String) map.get(".sysmsg.clouddelmsg.msgid");
                    str3 = (String) map.get(".sysmsg.clouddelmsg.fromuser");
                    int indexOf2 = a2.indexOf("<msg>");
                    int indexOf3 = a2.indexOf("</msg>");
                    if (indexOf2 == -1 || indexOf3 == -1) {
                        r5 = SQLiteDatabase.KeyEmpty;
                    } else {
                        r5 = au.U(bf.q(a2.substring(indexOf2, indexOf3 + 6), "msg"));
                    }
                    v.i("MicroMsg.SysCmdMsgExtension", "[hakon][clouddelmsg], delcommand:%s, msgid:%s, fromuser:%s, sysmsgcontent:%s", a, str2, str3, r5);
                    try {
                        ak.yW();
                        LinkedList dO = c.wJ().dO(str3, str2);
                        if (dO == null || dO.size() <= 0) {
                            v.e("MicroMsg.SysCmdMsgExtension", "get null by getByBizClientMsgId");
                            return null;
                        }
                        Iterator it = dO.iterator();
                        while (it.hasNext()) {
                            r4 = (at) it.next();
                            if (r4 == null) {
                                v.e("MicroMsg.SysCmdMsgExtension", "[hakon][clouddelmsg], msgInfo == null");
                            } else if (r4.pK() < 0) {
                                v.e("MicroMsg.SysCmdMsgExtension", "[hakon][clouddelmsg], invalid msgInfo.msgId = %s, srvId = %s", Long.valueOf(r4.pJ()), Long.valueOf(r4.pK()));
                            } else {
                                v.i("MicroMsg.SysCmdMsgExtension", "[hakon][clouddelmsg], msgInfo.msgId = %s, srvId = %s", Long.valueOf(r4.pJ()), Long.valueOf(r4.pK()));
                                r7 = be.getInt(a, 0);
                                if (r7 == 1) {
                                    ak.yW();
                                    c.wJ().Z(r4.pN(), r4.pK());
                                } else if (r7 == 2 && (r4.bvZ() || r4.bwa())) {
                                    r4.setContent(r5);
                                    aw.a(r4, aVar);
                                    ak.yW();
                                    c.wJ().b(r4.pK(), r4);
                                    ak.yW();
                                    ab Mh2 = c.wK().Mh(r4.pN());
                                    if (Mh2 != null && Mh2.pH() > 0) {
                                        ak.yW();
                                        if (Mh2.pH() >= c.wJ().P(r4)) {
                                            Mh2.df(Mh2.pH() - 1);
                                            ak.yW();
                                            c.wK().a(Mh2, Mh2.getUsername());
                                        }
                                    }
                                }
                                com.tencent.mm.sdk.c.b lyVar2 = new ly();
                                lyVar2.bnd.bao = r4.pJ();
                                lyVar2.bnd.bne = r5;
                                lyVar2.bnd.bmk = r4;
                                com.tencent.mm.sdk.c.a.nhr.z(lyVar2);
                            }
                        }
                        return null;
                    } catch (Throwable e3222) {
                        v.a("MicroMsg.SysCmdMsgExtension", e3222, "[hakon][clouddelmsg], BizClientMsgId:%d,error:%s", str2, e3222.toString());
                    }
                }
                break;
            default:
                v.w("MicroMsg.SysCmdMsgExtension", "cmdAM msgType is %d, ignore, return now", Integer.valueOf(bmVar.gll));
                return null;
        }
    }

    private void a(String str, com.tencent.mm.v.d.a aVar, boolean z) {
        List<b> list = (List) (z ? this.cvE : this.cvD).get(str);
        if (list == null || list.isEmpty()) {
            v.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
            return;
        }
        v.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", Integer.valueOf(list.size()));
        for (b a : list) {
            a.a(aVar);
        }
    }

    public final void d(at atVar) {
    }
}
