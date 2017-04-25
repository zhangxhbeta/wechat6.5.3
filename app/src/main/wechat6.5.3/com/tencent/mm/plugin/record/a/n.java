package com.tencent.mm.plugin.record.a;

import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.a.e;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.px;
import com.tencent.mm.protocal.c.py;
import com.tencent.mm.protocal.c.qc;
import com.tencent.mm.protocal.c.qe;
import com.tencent.mm.protocal.c.qj;
import com.tencent.mm.protocal.c.qp;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;
import java.util.Map;

public final class n {
    public static void a(Map<String, String> map, c cVar) {
        cVar.cqE.clear();
        List list = cVar.cqE;
        String str = (String) map.get(".recordinfo.datalist.$count");
        if (str == null || str.length() == 0) {
            v.w("MicroMsg.RecordMsgParser", "getDataItem list empty");
            return;
        }
        int i = be.getInt(str, 0);
        int i2 = 0;
        while (i2 < i) {
            pw pwVar = new pw();
            String str2 = ".recordinfo.datalist.dataitem" + (i2 > 0 ? Integer.valueOf(i2) : "");
            pwVar.uG(be.getInt((String) map.get(str2 + ".$datatype"), 0));
            pwVar.IO((String) map.get(str2 + ".$datasourceid"));
            pwVar.uH(be.getInt((String) map.get(str2 + ".$datastatus"), 0));
            pwVar.IG((String) map.get(str2 + ".datafmt"));
            pwVar.Iw((String) map.get(str2 + ".datatitle"));
            pwVar.Ix((String) map.get(str2 + ".datadesc"));
            pwVar.Iy((String) map.get(str2 + ".cdnthumburl"));
            pwVar.Iz((String) map.get(str2 + ".cdnthumbkey"));
            pwVar.uD(be.getInt((String) map.get(str2 + ".thumbwidth"), 0));
            pwVar.uE(be.getInt((String) map.get(str2 + ".thumbheight"), 0));
            pwVar.IA((String) map.get(str2 + ".cdndataurl"));
            pwVar.IB((String) map.get(str2 + ".cdndatakey"));
            str = (String) map.get(str2 + ".duration");
            if (str != null && str.length() > 0) {
                pwVar.uF(be.getInt(str, 0));
            }
            pwVar.ID((String) map.get(str2 + ".streamdataurl"));
            pwVar.IE((String) map.get(str2 + ".streamlowbandurl"));
            pwVar.IC((String) map.get(str2 + ".streamweburl"));
            pwVar.IH((String) map.get(str2 + ".fullmd5"));
            pwVar.II((String) map.get(str2 + ".head256md5"));
            str = (String) map.get(str2 + ".datasize");
            if (!be.kS(str)) {
                pwVar.dQ((long) be.getInt(str, 0));
            }
            pwVar.IF((String) map.get(str2 + ".dataext"));
            pwVar.IM((String) map.get(str2 + ".thumbfullmd5"));
            pwVar.IN((String) map.get(str2 + ".thumbhead256md5"));
            str = (String) map.get(str2 + ".thumbsize");
            if (!be.kS(str)) {
                pwVar.dR((long) be.getInt(str, 0));
            }
            pwVar.IP((String) map.get(str2 + ".streamvideoid"));
            str = (String) map.get(str2 + ".$dataid");
            if (be.kS(str)) {
                str = String.valueOf(i2);
            }
            pwVar.IJ(str);
            str = (String) map.get(str2 + ".$htmlid");
            if (!be.kS(str)) {
                pwVar.IT(str);
            }
            pwVar.IQ((String) map.get(str2 + ".sourcetitle"));
            pwVar.IR((String) map.get(str2 + ".sourcename"));
            pwVar.IS((String) map.get(str2 + ".sourcetime"));
            pwVar.IU((String) map.get(str2 + ".statextstr"));
            px pxVar = new px();
            py pyVar = new py();
            pyVar.uI(be.getInt((String) map.get(str2 + ".$sourcetype"), 0));
            str = (String) map.get(str2 + ".dataitemsource.fromusr");
            if (!be.kS(str)) {
                pyVar.IW(str);
                v.d("MicroMsg.RecordMsgParser", "fromusr %s", new Object[]{pyVar.bhM});
            }
            str = (String) map.get(str2 + ".dataitemsource.realchatname");
            if (!be.kS(str)) {
                pyVar.IZ(str);
                v.d("MicroMsg.RecordMsgParser", "realChatname %s", new Object[]{pyVar.mtu});
            }
            pyVar.Jb((String) map.get(str2 + ".appid"));
            pyVar.Jc((String) map.get(str2 + ".link"));
            pyVar.Jd((String) map.get(str2 + ".brandid"));
            pxVar.c(pyVar);
            String str3 = str2 + ".locitem";
            if (map.containsKey(str3)) {
                qc qcVar = new qc();
                if (!be.kS((String) map.get(str3 + ".label"))) {
                    qcVar.Je((String) map.get(str3 + ".label"));
                }
                if (!be.kS((String) map.get(str3 + ".poiname"))) {
                    qcVar.Jf((String) map.get(str3 + ".poiname"));
                }
                str = (String) map.get(str3 + ".lng");
                if (!be.kS(str)) {
                    qcVar.j(be.getDouble(str, 0.0d));
                }
                str = (String) map.get(str3 + ".lat");
                if (!be.kS(str)) {
                    qcVar.k(be.getDouble(str, 0.0d));
                }
                str = (String) map.get(str3 + ".scale");
                if (!be.kS(str)) {
                    if (str.indexOf(46) != -1) {
                        qcVar.uJ(be.getInt(str.substring(0, str.indexOf(46)), -1));
                    } else {
                        qcVar.uJ(be.getInt(str, -1));
                    }
                }
                pxVar.a(qcVar);
            } else {
                v.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[]{str3});
            }
            str3 = str2 + ".weburlitem";
            if (map.containsKey(str3)) {
                qp qpVar = new qp();
                qpVar.JA((String) map.get(str3 + ".title"));
                qpVar.JB((String) map.get(str3 + ".desc"));
                qpVar.JD((String) map.get(str3 + ".thumburl"));
                qpVar.JC((String) map.get(str3 + ".link"));
                qpVar.uO(be.getInt((String) map.get(str3 + ".opencache"), 0));
                pxVar.a(qpVar);
            } else {
                v.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[]{str3});
            }
            str3 = str2 + ".productitem";
            if (map.containsKey(str3)) {
                qe qeVar = new qe();
                qeVar.Jg((String) map.get(str3 + ".title"));
                qeVar.Jh((String) map.get(str3 + ".desc"));
                qeVar.Ji((String) map.get(str3 + ".thumburl"));
                qeVar.Jj((String) map.get(str3 + ".productinfo"));
                qeVar.uK(be.getInt((String) map.get(str3 + ".$type"), 0));
                pxVar.a(qeVar);
            } else {
                v.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[]{str3});
            }
            str2 = str2 + ".tvitem";
            if (map.containsKey(str2)) {
                qj qjVar = new qj();
                qjVar.Jw((String) map.get(str2 + ".title"));
                qjVar.Jx((String) map.get(str2 + ".desc"));
                qjVar.Jy((String) map.get(str2 + ".thumburl"));
                qjVar.Jz((String) map.get(str2 + ".tvinfo"));
                pxVar.a(qjVar);
            } else {
                v.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[]{str2});
            }
            pwVar.a(pxVar);
            list.add(pwVar);
            i2++;
        }
    }

    public static String ap(List<pw> list) {
        if (list == null || list.size() == 0) {
            v.w("MicroMsg.RecordMsgParser", "klem toXml data list empty");
            return "";
        }
        int size = list.size();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<datalist count='").append(size).append("'>");
        for (int i = 0; i < size; i++) {
            pw pwVar = (pw) list.get(i);
            stringBuffer.append("<dataitem ");
            if (pwVar.msg) {
                stringBuffer.append("datatype='").append(pwVar.aKG).append("'");
            }
            if (pwVar.msJ) {
                stringBuffer.append(" datastatus='").append(pwVar.msI).append("'");
            }
            if (pwVar.msp) {
                stringBuffer.append(" dataid='").append(pwVar.luu).append("'");
            }
            if (pwVar.msV) {
                stringBuffer.append(" htmlid='").append(pwVar.msU).append("'");
            }
            if (pwVar.msB) {
                stringBuffer.append(" datasourceid='").append(pwVar.msA).append("'");
            }
            stringBuffer.append(">");
            if (pwVar.msi) {
                stringBuffer.append("<datafmt>").append(pwVar.msh).append("</datafmt>");
            }
            if (pwVar.mrL) {
                stringBuffer.append("<datatitle>").append(be.KJ(pwVar.title)).append("</datatitle>");
            }
            if (pwVar.mrM) {
                stringBuffer.append("<datadesc>").append(be.KJ(pwVar.desc)).append("</datadesc>");
            }
            if (pwVar.mrN) {
                stringBuffer.append("<cdnthumburl>").append(be.KJ(pwVar.coj)).append("</cdnthumburl>");
            }
            if (pwVar.mrQ) {
                stringBuffer.append("<thumbwidth>").append(pwVar.coo).append("</thumbwidth>");
            }
            if (pwVar.mrR) {
                stringBuffer.append("<thumbheight>").append(pwVar.con).append("</thumbheight>");
            }
            if (pwVar.mrT) {
                stringBuffer.append("<cdndataurl>").append(be.KJ(pwVar.mrS)).append("</cdndataurl>");
            }
            if (pwVar.mrP) {
                stringBuffer.append("<cdnthumbkey>").append(be.KJ(pwVar.mrO)).append("</cdnthumbkey>");
            }
            if (pwVar.mrV) {
                stringBuffer.append("<cdndatakey>").append(be.KJ(pwVar.mrU)).append("</cdndatakey>");
            }
            if (pwVar.mrX) {
                stringBuffer.append("<cdnencryver>").append(pwVar.mrW).append("</cdnencryver>");
            }
            if (pwVar.mrY) {
                stringBuffer.append("<duration>").append(pwVar.duration).append("</duration>");
            }
            if (pwVar.msa) {
                stringBuffer.append("<streamweburl>").append(be.KJ(pwVar.mrZ)).append("</streamweburl>");
            }
            if (pwVar.msc) {
                stringBuffer.append("<streamdataurl>").append(be.KJ(pwVar.msb)).append("</streamdataurl>");
            }
            if (pwVar.mse) {
                stringBuffer.append("<streamlowbandurl>").append(be.KJ(pwVar.msd)).append("</streamlowbandurl>");
            }
            if (pwVar.msf) {
                stringBuffer.append("<dataext>").append(be.KJ(pwVar.aZh)).append("</dataext>");
            }
            if (pwVar.msk) {
                stringBuffer.append("<fullmd5>").append(pwVar.msj).append("</fullmd5>");
            }
            if (pwVar.msm) {
                stringBuffer.append("<head256md5>").append(pwVar.msl).append("</head256md5>");
            }
            if (pwVar.mso) {
                stringBuffer.append("<datasize>").append(pwVar.msn).append("</datasize>");
            }
            if (pwVar.msv) {
                stringBuffer.append("<thumbfullmd5>").append(pwVar.msu).append("</thumbfullmd5>");
            }
            if (pwVar.msx) {
                stringBuffer.append("<thumbhead256md5>").append(pwVar.msw).append("</thumbhead256md5>");
            }
            if (pwVar.msz) {
                stringBuffer.append("<thumbsize>").append(pwVar.msy).append("</thumbsize>");
            }
            if (pwVar.msD) {
                stringBuffer.append("<streamvideoid>").append(be.KJ(pwVar.msC)).append("</streamvideoid>");
            }
            if (pwVar.msL) {
                stringBuffer.append("<sourcetitle>").append(be.KJ(pwVar.msK)).append("</sourcetitle>");
            }
            if (pwVar.msP) {
                stringBuffer.append("<sourcename>").append(be.KJ(pwVar.msO)).append("</sourcename>");
            }
            if (pwVar.msR) {
                stringBuffer.append("<sourcetime>").append(be.KJ(pwVar.msQ)).append("</sourcetime>");
            }
            if (pwVar.msW) {
                stringBuffer.append("<statextstr>").append(be.KJ(pwVar.bnY)).append("</statextstr>");
            }
            px pxVar = pwVar.msM;
            if (pxVar == null || pxVar.msY == null || pxVar.msY.aHr() == 0) {
                v.w("MicroMsg.RecordMsgParser", "klem toXml, data source item empty");
            } else {
                py pyVar = pxVar.msY;
                if (pyVar.mty) {
                    stringBuffer.append("<appid>").append(pyVar.appId).append("</appid>");
                }
                if (pyVar.mtz) {
                    stringBuffer.append("<link>").append(be.KJ(pyVar.cZp)).append("</link>");
                }
                if (pyVar.mtC) {
                    stringBuffer.append("<brandid>").append(be.KJ(pyVar.aWH)).append("</brandid>");
                }
                if (pyVar.mtq && pyVar.mtv) {
                    if (pyVar.bhM.equals(pyVar.mtu)) {
                        stringBuffer.append("<dataitemsource><fromusr>").append(be.KJ(pyVar.bhM)).append("</fromusr></dataitemsource>");
                    } else if (m.dE(pyVar.bhM) || e.hS(pyVar.mtu)) {
                        stringBuffer.append("<dataitemsource><realchatname>").append(be.KJ(pyVar.mtu)).append("</realchatname></dataitemsource>");
                    }
                } else if (pyVar.mtq) {
                    stringBuffer.append("<dataitemsource><fromusr>").append(be.KJ(pyVar.bhM)).append("</fromusr></dataitemsource>");
                } else if (pyVar.mtv) {
                    stringBuffer.append("<dataitemsource><realchatname>").append(be.KJ(pyVar.mtu)).append("</realchatname></dataitemsource>");
                }
            }
            pxVar = pwVar.msM;
            if (pxVar == null || pxVar.mta == null || pxVar.mta.aHr() == 0) {
                v.w("MicroMsg.RecordMsgParser", "klem toXml, loc item empty");
            } else {
                qc qcVar = pxVar.mta;
                stringBuffer.append("<locitem>");
                if (qcVar.mtK) {
                    stringBuffer.append("<label>").append(be.KJ(qcVar.label)).append("</label>");
                }
                if (qcVar.mtI) {
                    stringBuffer.append("<lat>").append(qcVar.lat).append("</lat>");
                }
                if (qcVar.mtH) {
                    stringBuffer.append("<lng>").append(qcVar.lng).append("</lng>");
                }
                if (qcVar.mtJ) {
                    stringBuffer.append("<scale>").append(qcVar.bhu).append("</scale>");
                }
                if (qcVar.mtL) {
                    stringBuffer.append("<poiname>").append(qcVar.bkV).append("</poiname>");
                }
                stringBuffer.append("</locitem>");
            }
            pxVar = pwVar.msM;
            if (pxVar == null || pxVar.mtc == null || pxVar.mtc.aHr() == 0) {
                v.w("MicroMsg.RecordMsgParser", "klem toXml, url item empty");
            } else {
                qp qpVar = pxVar.mtc;
                stringBuffer.append("<weburlitem>");
                if (qpVar.mus) {
                    stringBuffer.append("<link>").append(be.KJ(qpVar.mur)).append("</link>");
                }
                if (qpVar.mrM) {
                    stringBuffer.append("<desc>").append(be.KJ(qpVar.desc)).append("</desc>");
                }
                if (qpVar.mtM) {
                    stringBuffer.append("<thumburl>").append(be.KJ(qpVar.bea)).append("</thumburl>");
                }
                if (qpVar.mrL) {
                    stringBuffer.append("<title>").append(be.KJ(qpVar.title)).append("</title>");
                }
                if (qpVar.muu) {
                    stringBuffer.append("<opencache>").append(qpVar.mut).append("</opencache>");
                }
                if (qpVar.muv) {
                    stringBuffer.append("<contentattr>").append(qpVar.cog).append("</contentattr>");
                }
                stringBuffer.append("</weburlitem>");
            }
            pxVar = pwVar.msM;
            if (pxVar == null || pxVar.mte == null || pxVar.mte.aHr() == 0) {
                v.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
            } else {
                qe qeVar = pxVar.mte;
                stringBuffer.append("<productitem");
                if (qeVar.mtO) {
                    stringBuffer.append(" type='").append(qeVar.type).append("'");
                }
                stringBuffer.append(">");
                if (qeVar.mrL) {
                    stringBuffer.append("<title>").append(be.KJ(qeVar.title)).append("</title>");
                }
                if (qeVar.mrM) {
                    stringBuffer.append("<desc>").append(be.KJ(qeVar.desc)).append("</desc>");
                }
                if (qeVar.mtM) {
                    stringBuffer.append("<thumburl>").append(be.KJ(qeVar.bea)).append("</thumburl>");
                }
                if (qeVar.mtN) {
                    stringBuffer.append("<productinfo>").append(be.KJ(qeVar.info)).append("</productinfo>");
                }
                stringBuffer.append("</productitem>");
            }
            px pxVar2 = pwVar.msM;
            if (pxVar2 == null || pxVar2.mtg == null || pxVar2.mtg.aHr() == 0) {
                v.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
            } else {
                qj qjVar = pxVar2.mtg;
                stringBuffer.append("<tvitem>");
                if (qjVar.mrL) {
                    stringBuffer.append("<title>").append(be.KJ(qjVar.title)).append("</title>");
                }
                if (qjVar.mrM) {
                    stringBuffer.append("<desc>").append(be.KJ(qjVar.desc)).append("</desc>");
                }
                if (qjVar.mtM) {
                    stringBuffer.append("<thumburl>").append(be.KJ(qjVar.bea)).append("</thumburl>");
                }
                if (qjVar.mtN) {
                    stringBuffer.append("<tvinfo>").append(be.KJ(qjVar.info)).append("</tvinfo>");
                }
                stringBuffer.append("</tvitem>");
            }
            stringBuffer.append("</dataitem>");
        }
        stringBuffer.append("</datalist>");
        return stringBuffer.toString();
    }
}
