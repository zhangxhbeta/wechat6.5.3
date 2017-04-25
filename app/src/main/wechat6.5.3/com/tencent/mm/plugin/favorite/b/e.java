package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.px;
import com.tencent.mm.protocal.c.py;
import com.tencent.mm.protocal.c.pz;
import com.tencent.mm.protocal.c.qc;
import com.tencent.mm.protocal.c.qe;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.protocal.c.qj;
import com.tencent.mm.protocal.c.qp;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;
import java.util.Map;

public final class e {
    public static void a(Map<String, String> map, qf qfVar) {
        qfVar.mtR.clear();
        List list = qfVar.mtR;
        String str = (String) map.get(".favitem.datalist.$count");
        if (str == null || str.length() == 0) {
            v.v("MicroMsg.FavDataItemParser", "klem getDataItem list empty");
            return;
        }
        int i = be.getInt(str, 0);
        int i2 = 0;
        while (i2 < i) {
            pw pwVar = new pw();
            String str2 = ".favitem.datalist.dataitem" + (i2 > 0 ? Integer.valueOf(i2) : "");
            pwVar.uG(be.getInt((String) map.get(str2 + ".$datatype"), 0));
            pwVar.IO((String) map.get(str2 + ".$datasourceid"));
            pwVar.uH(be.getInt((String) map.get(str2 + ".$datastatus"), 0));
            pwVar.IG((String) map.get(str2 + ".datafmt"));
            pwVar.Iw((String) map.get(str2 + ".datatitle"));
            pwVar.Ix((String) map.get(str2 + ".datadesc"));
            pwVar.Iy((String) map.get(str2 + ".cdn_thumburl"));
            pwVar.Iz((String) map.get(str2 + ".cdn_thumbkey"));
            pwVar.uD(be.getInt((String) map.get(str2 + ".thumb_width"), 0));
            pwVar.uE(be.getInt((String) map.get(str2 + ".thumb_height"), 0));
            pwVar.IA((String) map.get(str2 + ".cdn_dataurl"));
            pwVar.IB((String) map.get(str2 + ".cdn_datakey"));
            str = (String) map.get(str2 + ".duration");
            if (str != null && str.length() > 0) {
                pwVar.uF(be.getInt(str, 0));
            }
            pwVar.ID((String) map.get(str2 + ".stream_dataurl"));
            pwVar.IE((String) map.get(str2 + ".stream_lowbandurl"));
            pwVar.IC((String) map.get(str2 + ".stream_weburl"));
            pwVar.IV((String) map.get(str2 + ".canvasPageXml"));
            pwVar.IH((String) map.get(str2 + ".fullmd5"));
            pwVar.II((String) map.get(str2 + ".head256md5"));
            str = (String) map.get(str2 + ".fullsize");
            if (!be.kS(str)) {
                pwVar.dQ((long) be.getInt(str, 0));
            }
            pwVar.IF((String) map.get(str2 + ".dataext"));
            pwVar.IM((String) map.get(str2 + ".thumbfullmd5"));
            pwVar.IN((String) map.get(str2 + ".thumbhead256md5"));
            str = (String) map.get(str2 + ".thumbfullsize");
            if (!be.kS(str)) {
                pwVar.dR((long) be.getInt(str, 0));
            }
            pwVar.IP((String) map.get(str2 + ".stream_videoid"));
            str = (String) map.get(str2 + ".$dataid");
            if (be.kS(str) || str.length() < 32) {
                str = v.aw(pwVar.toString(), pwVar.aKG);
            }
            pwVar.IJ(str);
            pwVar.IQ((String) map.get(str2 + ".datasrctitle"));
            pwVar.IR((String) map.get(str2 + ".datasrcname"));
            pwVar.IS((String) map.get(str2 + ".datasrctime"));
            pwVar.IU((String) map.get(str2 + ".statextstr"));
            pwVar.IT((String) map.get(str2 + ".$htmlid"));
            pz pzVar = new pz();
            pzVar.cqg = be.ah((String) map.get(str2 + ".streamvideo.streamvideourl"), "");
            pzVar.mtD = be.KL((String) map.get(str2 + ".streamvideo.streamvideototaltime"));
            pzVar.cqi = be.ah((String) map.get(str2 + ".streamvideo.streamvideotitle"), "");
            pzVar.cqj = be.ah((String) map.get(str2 + ".streamvideo.streamvideowording"), "");
            pzVar.cqk = be.ah((String) map.get(str2 + ".streamvideo.streamvideoweburl"), "");
            pzVar.cqm = be.ah((String) map.get(str2 + ".streamvideo.streamvideoaduxinfo"), "");
            pzVar.cqn = be.ah((String) map.get(str2 + ".streamvideo.streamvideopublishid"), "");
            pwVar.a(pzVar);
            px pxVar = new px();
            String str3 = str2 + ".dataitemsource";
            if (map.containsKey(str3)) {
                py pyVar = new py();
                pyVar.uI(be.getInt((String) map.get(str3 + ".$sourcetype"), 0));
                pyVar.IY((String) map.get(str3 + ".$sourceid"));
                pyVar.IW((String) map.get(str3 + ".fromusr"));
                pyVar.IX((String) map.get(str3 + ".tousr"));
                pyVar.IZ((String) map.get(str3 + ".realchatname"));
                pyVar.dS(be.getLong((String) map.get(str3 + ".createtime"), 0));
                pyVar.Ja((String) map.get(str3 + ".msgid"));
                pyVar.bqi = (String) map.get(str3 + ".eventid");
                pyVar.mtx = true;
                pyVar.Jb((String) map.get(str3 + ".appid"));
                pyVar.Jc((String) map.get(str3 + ".link"));
                pyVar.Jd((String) map.get(str3 + ".brandid"));
                pxVar.c(pyVar);
            } else {
                v.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[]{str3});
            }
            str3 = str2 + ".locitem";
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
                v.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[]{str3});
            }
            str3 = str2 + ".weburlitem";
            if (map.containsKey(str3)) {
                qp qpVar = new qp();
                qpVar.JC((String) map.get(str3 + ".clean_url"));
                qpVar.JB((String) map.get(str3 + ".pagedesc"));
                qpVar.JD((String) map.get(str3 + ".pagethumb_url"));
                qpVar.JA((String) map.get(str3 + ".pagetitle"));
                qpVar.uO(be.getInt((String) map.get(str3 + ".opencache"), 0));
                qpVar.uP(be.getInt((String) map.get(str3 + ".contentattr"), 0));
                qpVar.JE((String) map.get(str3 + ".canvasPageXml"));
                pxVar.a(qpVar);
            } else {
                v.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[]{str3});
            }
            str3 = str2 + ".productitem";
            if (map.containsKey(str3)) {
                qe qeVar = new qe();
                qeVar.Jg((String) map.get(str3 + ".producttitle"));
                qeVar.Jh((String) map.get(str3 + ".productdesc"));
                qeVar.Ji((String) map.get(str3 + ".productthumb_url"));
                qeVar.Jj((String) map.get(str3 + ".productinfo"));
                qeVar.uK(be.getInt((String) map.get(str3 + ".$type"), 0));
                pxVar.a(qeVar);
            } else {
                v.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[]{str3});
            }
            str2 = str2 + ".tvitem";
            if (map.containsKey(str2)) {
                qj qjVar = new qj();
                qjVar.Jw((String) map.get(str2 + ".tvtitle"));
                qjVar.Jx((String) map.get(str2 + ".tvdesc"));
                qjVar.Jy((String) map.get(str2 + ".tvthumb_url"));
                qjVar.Jz((String) map.get(str2 + ".tvinfo"));
                pxVar.a(qjVar);
            } else {
                v.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[]{str2});
            }
            pwVar.a(pxVar);
            list.add(pwVar);
            i2++;
        }
    }

    public static String ap(List<pw> list) {
        if (list == null || list.size() == 0) {
            v.v("MicroMsg.FavDataItemParser", "klem toXml data list empty");
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
                stringBuffer.append(" htmlid='").append(be.KJ(pwVar.msU)).append("'");
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
                stringBuffer.append("<cdn_thumburl>").append(be.KJ(pwVar.coj)).append("</cdn_thumburl>");
            }
            if (pwVar.mrQ) {
                stringBuffer.append("<thumb_width>").append(pwVar.coo).append("</thumb_width>");
            }
            if (pwVar.mrR) {
                stringBuffer.append("<thumb_height>").append(pwVar.con).append("</thumb_height>");
            }
            if (pwVar.mrT) {
                stringBuffer.append("<cdn_dataurl>").append(be.KJ(pwVar.mrS)).append("</cdn_dataurl>");
            }
            if (pwVar.mrP) {
                stringBuffer.append("<cdn_thumbkey>").append(be.KJ(pwVar.mrO)).append("</cdn_thumbkey>");
            }
            if (pwVar.mrV) {
                stringBuffer.append("<cdn_datakey>").append(be.KJ(pwVar.mrU)).append("</cdn_datakey>");
            }
            if (pwVar.mrX) {
                stringBuffer.append("<cdn_encryver>").append(pwVar.mrW).append("</cdn_encryver>");
            }
            if (pwVar.mrY) {
                stringBuffer.append("<duration>").append(pwVar.duration).append("</duration>");
            }
            if (pwVar.msa) {
                stringBuffer.append("<stream_weburl>").append(be.KJ(pwVar.mrZ)).append("</stream_weburl>");
            }
            if (pwVar.msc) {
                stringBuffer.append("<stream_dataurl>").append(be.KJ(pwVar.msb)).append("</stream_dataurl>");
            }
            if (pwVar.mse) {
                stringBuffer.append("<stream_lowbandurl>").append(be.KJ(pwVar.msd)).append("</stream_lowbandurl>");
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
                stringBuffer.append("<fullsize>").append(pwVar.msn).append("</fullsize>");
            }
            if (pwVar.msv) {
                stringBuffer.append("<thumbfullmd5>").append(pwVar.msu).append("</thumbfullmd5>");
            }
            if (pwVar.msx) {
                stringBuffer.append("<thumbhead256md5>").append(pwVar.msw).append("</thumbhead256md5>");
            }
            if (pwVar.msz) {
                stringBuffer.append("<thumbfullsize>").append(pwVar.msy).append("</thumbfullsize>");
            }
            if (pwVar.msD) {
                stringBuffer.append("<stream_videoid>").append(be.KJ(pwVar.msC)).append("</stream_videoid>");
            }
            if (pwVar.msL) {
                stringBuffer.append("<datasrctitle>").append(be.KJ(pwVar.msK)).append("</datasrctitle>");
            }
            if (pwVar.msP) {
                stringBuffer.append("<datasrcname>").append(be.KJ(pwVar.msO)).append("</datasrcname>");
            }
            if (pwVar.msR) {
                stringBuffer.append("<datasrctime>").append(be.KJ(pwVar.msQ)).append("</datasrctime>");
            }
            if (pwVar.msX && (pwVar.msM == null || pwVar.msM.mtc == null || pwVar.msM.mtc.aHr() == 0)) {
                stringBuffer.append("<canvasPageXml>").append(be.KJ(pwVar.canvasPageXml)).append("</canvasPageXml>");
            }
            if (pwVar.msW) {
                stringBuffer.append("<statextstr>").append(be.KJ(pwVar.bnY)).append("</statextstr>");
            }
            pz pzVar = pwVar.msS;
            if (pzVar != null) {
                stringBuffer.append("<streamvideo>");
                stringBuffer.append("<streamvideourl>").append(be.KJ(pzVar.cqg)).append("</streamvideourl>");
                stringBuffer.append("<streamvideototaltime>").append(pzVar.mtD).append("</streamvideototaltime>");
                stringBuffer.append("<streamvideotitle>").append(be.KJ(pzVar.cqi)).append("</streamvideotitle>");
                stringBuffer.append("<streamvideowording>").append(be.KJ(pzVar.cqj)).append("</streamvideowording>");
                stringBuffer.append("<streamvideoweburl>").append(be.KJ(pzVar.cqk)).append("</streamvideoweburl>");
                stringBuffer.append("<streamvideoaduxinfo>").append(be.KJ(pzVar.cqm)).append("</streamvideoaduxinfo>");
                stringBuffer.append("<streamvideopublishid>").append(be.KJ(pzVar.cqn)).append("</streamvideopublishid>");
                stringBuffer.append("</streamvideo>");
            }
            px pxVar = pwVar.msM;
            if (pxVar == null || pxVar.msY == null || pxVar.msY.aHr() == 0) {
                v.v("MicroMsg.FavDataItemParser", "klem toXml, data source item empty");
            } else {
                py pyVar = pxVar.msY;
                stringBuffer.append("<dataitemsource");
                if (pyVar.mtp) {
                    stringBuffer.append(" sourcetype='").append(pyVar.aYX).append("'");
                }
                if (pyVar.mtt) {
                    stringBuffer.append(" sourceid='").append(pyVar.mts).append("'");
                }
                stringBuffer.append(">");
                if (pyVar.mtq) {
                    stringBuffer.append("<fromusr>").append(be.KJ(pyVar.bhM)).append("</fromusr>");
                }
                if (pyVar.mtr) {
                    stringBuffer.append("<tousr>").append(be.KJ(pyVar.toUser)).append("</tousr>");
                }
                if (pyVar.mtv) {
                    stringBuffer.append("<realchatname>").append(be.KJ(pyVar.mtu)).append("</realchatname>");
                }
                if (pyVar.mtw) {
                    stringBuffer.append("<msgid>").append(pyVar.blm).append("</msgid>");
                }
                if (pyVar.mtx) {
                    stringBuffer.append("<eventid>").append(pyVar.bqi).append("</eventid>");
                }
                if (pyVar.mty) {
                    stringBuffer.append("<appid>").append(pyVar.appId).append("</appid>");
                }
                if (pyVar.mtz) {
                    stringBuffer.append("<link>").append(be.KJ(pyVar.cZp)).append("</link>");
                }
                if (pyVar.mtC) {
                    stringBuffer.append("<brandid>").append(be.KJ(pyVar.aWH)).append("</brandid>");
                }
                stringBuffer.append("</dataitemsource>");
            }
            pxVar = pwVar.msM;
            if (pxVar == null || pxVar.mta == null || pxVar.mta.aHr() == 0) {
                v.v("MicroMsg.FavDataItemParser", "klem toXml, loc item empty");
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
                v.v("MicroMsg.FavDataItemParser", "klem toXml, url item empty");
            } else {
                qp qpVar = pxVar.mtc;
                stringBuffer.append("<weburlitem>");
                if (qpVar.mus) {
                    stringBuffer.append("<clean_url>").append(be.KJ(qpVar.mur)).append("</clean_url>");
                }
                if (qpVar.mrM) {
                    stringBuffer.append("<pagedesc>").append(be.KJ(qpVar.desc)).append("</pagedesc>");
                }
                if (qpVar.mtM) {
                    stringBuffer.append("<pagethumb_url>").append(be.KJ(qpVar.bea)).append("</pagethumb_url>");
                }
                if (qpVar.mrL) {
                    stringBuffer.append("<pagetitle>").append(be.KJ(qpVar.title)).append("</pagetitle>");
                }
                if (qpVar.muu) {
                    stringBuffer.append("<opencache>").append(qpVar.mut).append("</opencache>");
                }
                if (qpVar.muv) {
                    stringBuffer.append("<contentattr>").append(qpVar.cog).append("</contentattr>");
                }
                if (qpVar.msX) {
                    stringBuffer.append("<canvasPageXml>").append(be.KJ(qpVar.canvasPageXml)).append("</canvasPageXml>");
                }
                stringBuffer.append("</weburlitem>");
            }
            pxVar = pwVar.msM;
            if (pxVar == null || pxVar.mte == null || pxVar.mte.aHr() == 0) {
                v.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
            } else {
                qe qeVar = pxVar.mte;
                stringBuffer.append("<productitem");
                if (qeVar.mtO) {
                    stringBuffer.append(" type='").append(qeVar.type).append("'");
                }
                stringBuffer.append(">");
                if (qeVar.mrL) {
                    stringBuffer.append("<producttitle>").append(be.KJ(qeVar.title)).append("</producttitle>");
                }
                if (qeVar.mrM) {
                    stringBuffer.append("<productdesc>").append(be.KJ(qeVar.desc)).append("</productdesc>");
                }
                if (qeVar.mtM) {
                    stringBuffer.append("<productthumb_url>").append(be.KJ(qeVar.bea)).append("</productthumb_url>");
                }
                if (qeVar.mtN) {
                    stringBuffer.append("<productinfo>").append(be.KJ(qeVar.info)).append("</productinfo>");
                }
                stringBuffer.append("</productitem>");
            }
            px pxVar2 = pwVar.msM;
            if (pxVar2 == null || pxVar2.mtg == null || pxVar2.mtg.aHr() == 0) {
                v.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
            } else {
                qj qjVar = pxVar2.mtg;
                stringBuffer.append("<tvitem>");
                if (qjVar.mrL) {
                    stringBuffer.append("<tvtitle>").append(be.KJ(qjVar.title)).append("</tvtitle>");
                }
                if (qjVar.mrM) {
                    stringBuffer.append("<tvdesc>").append(be.KJ(qjVar.desc)).append("</tvdesc>");
                }
                if (qjVar.mtM) {
                    stringBuffer.append("<tvthumb_url>").append(be.KJ(qjVar.bea)).append("</tvthumb_url>");
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
