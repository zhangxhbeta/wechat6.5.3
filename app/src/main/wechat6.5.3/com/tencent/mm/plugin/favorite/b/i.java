package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.e.b.av;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.py;
import com.tencent.mm.protocal.c.qc;
import com.tencent.mm.protocal.c.qe;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.protocal.c.qj;
import com.tencent.mm.protocal.c.qn;
import com.tencent.mm.protocal.c.qp;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.Map;

public final class i extends av {
    protected static com.tencent.mm.sdk.h.c.a chq = av.pz();
    private static a fKG = new a() {
        public final void sP(String str) {
            v.d("MicroMsg.FavItemInfo", str);
        }
    };
    private static a fKH = new a() {
        public final void sP(String str) {
            v.e("MicroMsg.FavItemInfo", str);
        }
    };

    private interface a {
        void sP(String str);
    }

    public final /* synthetic */ Object clone() {
        return alG();
    }

    public i() {
        this.field_flag = -1;
        this.field_fromUser = "";
        this.field_toUser = "";
        this.field_id = -1;
        this.field_realChatName = "";
        this.field_sourceType = -1;
        this.field_updateTime = -1;
        this.field_type = -1;
        this.field_updateSeq = -1;
        this.field_xml = "";
        this.field_itemStatus = 0;
        alx();
    }

    private void alx() {
        this.field_favProto = new qf();
        qg qgVar = new qg();
        qgVar.uN(1);
        this.field_favProto.a(qgVar);
        this.field_favProto.b(new qp());
        this.field_favProto.b(new qc());
        this.field_favProto.b(new qe());
        this.field_favProto.b(new qj());
        this.field_favProto.uL(-1);
        this.field_tagProto = new qn();
    }

    protected final com.tencent.mm.sdk.h.c.a tl() {
        return chq;
    }

    public final boolean aly() {
        return (this.field_favProto.mtl & 1) != 0;
    }

    public final boolean alz() {
        return (this.field_favProto.mtl & 2) != 0;
    }

    public final boolean alA() {
        if (this.field_itemStatus == 1 || this.field_itemStatus == 4 || this.field_itemStatus == 9 || this.field_itemStatus == 12 || this.field_itemStatus == 13 || this.field_itemStatus == 15 || this.field_itemStatus == 17) {
            return true;
        }
        return false;
    }

    public final boolean alB() {
        if (this.field_itemStatus == 3 || this.field_itemStatus == 6 || this.field_itemStatus == 11 || this.field_itemStatus == 14 || this.field_itemStatus == 16 || this.field_itemStatus == 18) {
            return true;
        }
        return false;
    }

    public final boolean alC() {
        return this.field_itemStatus == 7;
    }

    public final boolean alD() {
        return this.field_itemStatus == 8;
    }

    public final boolean isDone() {
        return this.field_itemStatus == 10;
    }

    public final boolean alE() {
        if (this.field_itemStatus == 15 || this.field_itemStatus == 16) {
            return true;
        }
        return false;
    }

    public final boolean alF() {
        if (this.field_itemStatus == 12 || this.field_itemStatus == 13 || this.field_itemStatus == 14) {
            return true;
        }
        return false;
    }

    public final i sM(String str) {
        if (str == null || str.equals("")) {
            v.e("MicroMsg.FavItemInfo", "klem, FavItemInfo xml null");
        } else {
            Map q = bf.q(str, "favitem");
            if (q == null) {
                v.e("MicroMsg.FavItemInfo", "klem, FavItemInfo maps null");
            } else {
                try {
                    alx();
                    qf qfVar = this.field_favProto;
                    qfVar.Jl((String) q.get(".favitem.title"));
                    qfVar.Jm((String) q.get(".favitem.desc"));
                    qfVar.Jk((String) q.get(".favitem.remark"));
                    qfVar.dT(be.getLong((String) q.get(".favitem.remark.$time"), 0));
                    String str2 = (String) q.get(".favitem.edittime");
                    qfVar.uM(be.getInt((String) q.get(".favitem.version"), 0));
                    qfVar.dU(be.getLong(str2, 0));
                    qfVar.uL(be.getInt((String) q.get(".favitem.ctrlflag"), -1));
                    String str3 = ".favitem.source";
                    qg qgVar = qfVar.mtP;
                    qgVar.uN(be.getInt((String) q.get(str3 + ".$sourcetype"), 0));
                    qgVar.Jp((String) q.get(str3 + ".$sourceid"));
                    qgVar.Jn((String) q.get(str3 + ".fromusr"));
                    qgVar.Jo((String) q.get(str3 + ".tousr"));
                    qgVar.Jq((String) q.get(str3 + ".realchatname"));
                    qgVar.dV(be.getLong((String) q.get(str3 + ".createtime"), 0));
                    qgVar.Jr((String) q.get(str3 + ".msgid"));
                    qgVar.Js((String) q.get(str3 + ".eventid"));
                    qgVar.Jt((String) q.get(str3 + ".appid"));
                    qgVar.Ju((String) q.get(str3 + ".link"));
                    qgVar.Jv((String) q.get(str3 + ".brandid"));
                    e.a(q, qfVar);
                    str3 = ".favitem.locitem";
                    qc qcVar = qfVar.mta;
                    if (!be.kS((String) q.get(str3 + ".label"))) {
                        qcVar.Je((String) q.get(str3 + ".label"));
                    }
                    if (!be.kS((String) q.get(str3 + ".poiname"))) {
                        qcVar.Jf((String) q.get(str3 + ".poiname"));
                    }
                    str2 = (String) q.get(str3 + ".lng");
                    if (!be.kS(str2)) {
                        qcVar.j(be.getDouble(str2, 0.0d));
                    }
                    str2 = (String) q.get(str3 + ".lat");
                    if (!be.kS(str2)) {
                        qcVar.k(be.getDouble(str2, 0.0d));
                    }
                    str2 = (String) q.get(str3 + ".scale");
                    if (!be.kS(str2)) {
                        if (str2.indexOf(46) != -1) {
                            qcVar.uJ(be.getInt(str2.substring(0, str2.indexOf(46)), -1));
                        } else {
                            qcVar.uJ(be.getInt(str2, -1));
                        }
                    }
                    str3 = ".favitem.weburlitem";
                    qp qpVar = qfVar.mtc;
                    qpVar.JC((String) q.get(str3 + ".clean_url"));
                    qpVar.JB((String) q.get(str3 + ".pagedesc"));
                    qpVar.JD((String) q.get(str3 + ".pagethumb_url"));
                    qpVar.JA((String) q.get(str3 + ".pagetitle"));
                    qpVar.uO(be.getInt((String) q.get(str3 + ".opencache"), 0));
                    qpVar.uP(be.getInt((String) q.get(str3 + ".contentattr"), 0));
                    qpVar.JE((String) q.get(str3 + ".canvasPageXml"));
                    str3 = ".favitem.productitem";
                    qe qeVar = qfVar.mte;
                    qeVar.Jg((String) q.get(str3 + ".producttitle"));
                    qeVar.Jh((String) q.get(str3 + ".productdesc"));
                    qeVar.Ji((String) q.get(str3 + ".productthumb_url"));
                    qeVar.Jj((String) q.get(str3 + ".productinfo"));
                    qeVar.uK(be.getInt((String) q.get(str3 + ".$type"), 0));
                    str3 = ".favitem.tvitem";
                    qj qjVar = qfVar.mtg;
                    qjVar.Jw((String) q.get(str3 + ".tvtitle"));
                    qjVar.Jx((String) q.get(str3 + ".tvdesc"));
                    qjVar.Jy((String) q.get(str3 + ".tvthumb_url"));
                    qjVar.Jz((String) q.get(str3 + ".tvinfo"));
                    if (this.field_favProto.mtP != null) {
                        qg qgVar2 = this.field_favProto.mtP;
                        this.field_sourceId = qgVar2.mtU;
                        this.field_sourceType = qgVar2.aYX;
                        this.field_fromUser = qgVar2.bhM;
                        this.field_toUser = qgVar2.toUser;
                    }
                    this.field_edittime = this.field_favProto.mtn;
                    q.a(q, this.field_tagProto);
                } catch (Throwable e) {
                    v.a("MicroMsg.FavItemInfo", e, "", new Object[0]);
                    v.e("MicroMsg.FavItemInfo", "klem , FavItemInfo exception:+%s", new Object[]{e.toString()});
                }
            }
        }
        return this;
    }

    public final void sN(String str) {
        a aVar = fKG;
        aVar.sP("----dump favitem from[" + str + "] beg----");
        aVar.sP("type: " + this.field_type);
        aVar.sP("favId: " + this.field_id);
        aVar.sP("localId: " + this.field_localId);
        aVar.sP("itemStatus: " + this.field_itemStatus);
        aVar.sP("localSeq: " + this.field_localSeq);
        aVar.sP("updateSeq: " + this.field_updateSeq);
        aVar.sP("ctrlFlag: " + this.field_flag);
        aVar.sP("sourceId: " + this.field_sourceId);
        aVar.sP("sourceType: " + this.field_sourceType);
        aVar.sP("sourceCreateTime: " + this.field_sourceCreateTime);
        aVar.sP("updateTime: " + this.field_updateTime);
        aVar.sP("editTime: " + this.field_edittime);
        aVar.sP("fromuser: " + this.field_fromUser);
        aVar.sP("toUser: " + this.field_toUser);
        aVar.sP("realChatName: " + this.field_realChatName);
        if (this.field_favProto != null) {
            aVar.sP("remarktime: " + this.field_favProto.mtj);
            aVar.sP("dataitemCount: " + this.field_favProto.mtR.size());
            if (this.field_favProto.mtP != null) {
                aVar.sP(" ----source item----");
                qg qgVar = this.field_favProto.mtP;
                aVar.sP("  sourceType: " + qgVar.aYX);
                aVar.sP("  fromUser: " + qgVar.bhM);
                aVar.sP("  toUser: " + qgVar.toUser);
                aVar.sP("  sourceId: " + qgVar.mtU);
                aVar.sP("  realChatName: " + qgVar.mtu);
                aVar.sP("  createTime: " + qgVar.dhH);
                aVar.sP("  msgId: " + qgVar.blm);
                aVar.sP("  eventId: " + qgVar.bqi);
                aVar.sP("  appId: " + qgVar.appId);
                aVar.sP("  link: " + qgVar.cZp);
                aVar.sP("  mediaId: " + qgVar.mtA);
                aVar.sP("  brandId: " + qgVar.aWH);
            }
            Iterator it = this.field_favProto.mtR.iterator();
            int i = 0;
            while (it.hasNext()) {
                pw pwVar = (pw) it.next();
                int i2 = i + 1;
                aVar.sP(" ----data item " + i + "----");
                aVar.sP("  dataId: " + pwVar.luu);
                aVar.sP("  dataType: " + pwVar.aKG);
                aVar.sP("  dataSouceId: " + pwVar.msA);
                aVar.sP("  svrDataStatus: " + pwVar.msI);
                aVar.sP("  cdnThumbUrl: " + pwVar.coj);
                aVar.sP("  cdnThumbKey: " + pwVar.mrO);
                aVar.sP("  cdnDataUrl: " + pwVar.mrS);
                aVar.sP("  cdnDataKey: " + pwVar.mrU);
                aVar.sP("  cdnEncryVer: " + pwVar.mrW);
                aVar.sP("  fullmd5: " + pwVar.msj);
                aVar.sP("  head256md5: " + pwVar.msl);
                aVar.sP("  fullsize: " + pwVar.msn);
                aVar.sP("  thumbMd5: " + pwVar.msu);
                aVar.sP("  thumbHead256md5: " + pwVar.msw);
                aVar.sP("  thumbfullsize: " + pwVar.msy);
                aVar.sP("  duration: " + pwVar.duration);
                aVar.sP("  datafmt: " + pwVar.msh);
                aVar.sP("  streamWebUrl: " + pwVar.mrZ);
                aVar.sP("  streamDataUrl: " + pwVar.msb);
                aVar.sP("  streamLowBandUrl: " + pwVar.msd);
                aVar.sP("  ext: " + pwVar.aZh);
                if (pwVar.msM != null) {
                    aVar.sP("  remarktime: " + pwVar.msM.mtj);
                    aVar.sP("  ctrlflag: " + pwVar.msM.mtl);
                    aVar.sP("  edittime: " + pwVar.msM.mtn);
                    if (pwVar.msM.msY != null) {
                        aVar.sP("   ----data source item----");
                        py pyVar = pwVar.msM.msY;
                        aVar.sP("    sourceType: " + pyVar.aYX);
                        aVar.sP("    fromUser: " + pyVar.bhM);
                        aVar.sP("    toUser: " + pyVar.toUser);
                        aVar.sP("    realChatName: " + pyVar.mtu);
                        aVar.sP("    createTime: " + pyVar.dhH);
                        aVar.sP("    msgId: " + pyVar.blm);
                        aVar.sP("    eventId: " + pyVar.bqi);
                        aVar.sP("    appId: " + pyVar.appId);
                        aVar.sP("    link: " + pyVar.cZp);
                        aVar.sP("    mediaId: " + pyVar.mtA);
                        aVar.sP("    brandId: " + pyVar.aWH);
                    }
                    a("  ", aVar, pwVar.msM.mta);
                    a("  ", aVar, pwVar.msM.mtc);
                    a("  ", aVar, pwVar.msM.mte);
                    a("  ", aVar, pwVar.msM.mtg);
                }
                i = i2;
            }
            a("", aVar, this.field_favProto.mta);
            a("", aVar, this.field_favProto.mtc);
            a("", aVar, this.field_favProto.mte);
            a("", aVar, this.field_favProto.mtg);
        }
        aVar.sP("----dump favitem end----");
    }

    private static void a(String str, a aVar, qj qjVar) {
        if (qjVar != null) {
            aVar.sP(str + " ----tv item----");
            aVar.sP(str + "  title: " + qjVar.title);
            aVar.sP(str + "  desc: " + qjVar.desc);
            aVar.sP(str + "  thumbUrl: " + qjVar.bea);
        }
    }

    private static void a(String str, a aVar, qe qeVar) {
        if (qeVar != null) {
            aVar.sP(str + " ----product item----");
            aVar.sP(str + "  title: " + qeVar.title);
            aVar.sP(str + "  desc: " + qeVar.desc);
            aVar.sP(str + "  thumbUrl: " + qeVar.bea);
            aVar.sP(str + "  type: " + qeVar.type);
        }
    }

    private static void a(String str, a aVar, qc qcVar) {
        if (qcVar != null) {
            aVar.sP(str + " ----loc item----");
            aVar.sP(str + "  lng: " + qcVar.lng);
            aVar.sP(str + "  lat: " + qcVar.lat);
            aVar.sP(str + "  scale: " + qcVar.bhu);
            aVar.sP(str + "  label: " + qcVar.label);
            aVar.sP(str + "  poiname: " + qcVar.bkV);
        }
    }

    private static void a(String str, a aVar, qp qpVar) {
        if (qpVar != null) {
            aVar.sP(str + " ----url item----");
            aVar.sP(str + "  title: " + qpVar.title);
            aVar.sP(str + "  desc: " + qpVar.desc);
            aVar.sP(str + "  cleanUrl: " + qpVar.mur);
            aVar.sP(str + "  thumbUrl: " + qpVar.bea);
            aVar.sP(str + "  opencache: " + qpVar.mut);
        }
    }

    public final boolean sO(String str) {
        if (be.kS(str)) {
            return false;
        }
        Iterator it = this.field_tagProto.mub.iterator();
        while (it.hasNext()) {
            if (str.equals((String) it.next())) {
                return false;
            }
        }
        this.field_tagProto.mub.add(str);
        return true;
    }

    public static String b(i iVar) {
        String str;
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("<favitem");
        stringBuffer2.append(" type='").append(iVar.field_type).append("'");
        stringBuffer2.append(">");
        qf qfVar = iVar.field_favProto;
        StringBuilder stringBuilder = new StringBuilder();
        if (!be.kS(qfVar.title)) {
            stringBuilder.append("<title>").append(be.KJ(qfVar.title)).append("</title>");
        }
        if (!be.kS(qfVar.desc)) {
            stringBuilder.append("<desc>").append(be.KJ(qfVar.desc)).append("</desc>");
        }
        if (qfVar.mtn > 0) {
            stringBuilder.append("<edittime>").append(qfVar.mtn).append("</edittime>");
        }
        if (!be.kS(qfVar.gxy)) {
            stringBuilder.append("<remark ");
            if (qfVar.mtj > 0) {
                stringBuilder.append(" time ='").append(qfVar.mtj).append("'");
            }
            stringBuilder.append(">").append(be.KJ(qfVar.gxy)).append("</remark>");
        }
        if (qfVar.mtm) {
            stringBuilder.append("<ctrlflag>").append(qfVar.mtl).append("</ctrlflag>");
        }
        if (qfVar.mtT) {
            stringBuilder.append("<version>").append(qfVar.version).append("</version>");
        } else if (iVar.field_type == 18) {
            stringBuilder.append("<version>1</version>");
        }
        qg qgVar = qfVar.mtP;
        if (qgVar == null || qgVar.aHr() == 0) {
            v.w("MicroMsg.FavSourceItemParser", "klem toXml, source item empty");
            str = "";
        } else {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("<source");
            if (qgVar.mtp) {
                stringBuffer3.append(" sourcetype='").append(qgVar.aYX).append("'");
            }
            if (qgVar.mtV) {
                stringBuffer3.append(" sourceid='").append(qgVar.mtU).append("'");
            }
            stringBuffer3.append(">");
            if (qgVar.mtq) {
                stringBuffer3.append("<fromusr>").append(be.KJ(qgVar.bhM)).append("</fromusr>");
            }
            if (qgVar.mtr) {
                stringBuffer3.append("<tousr>").append(be.KJ(qgVar.toUser)).append("</tousr>");
            }
            if (qgVar.mtv) {
                stringBuffer3.append("<realchatname>").append(be.KJ(qgVar.mtu)).append("</realchatname>");
            }
            if (qgVar.mtw) {
                stringBuffer3.append("<msgid>").append(qgVar.blm).append("</msgid>");
            }
            if (qgVar.mtx) {
                stringBuffer3.append("<eventid>").append(qgVar.bqi).append("</eventid>");
            }
            if (qgVar.mty) {
                stringBuffer3.append("<appid>").append(qgVar.appId).append("</appid>");
            }
            if (qgVar.mtz) {
                stringBuffer3.append("<link>").append(be.KJ(qgVar.cZp)).append("</link>");
            }
            if (qgVar.mtC) {
                stringBuffer3.append("<brandid>").append(be.KJ(qgVar.aWH)).append("</brandid>");
            }
            stringBuffer3.append("</source>");
            str = stringBuffer3.toString();
        }
        stringBuilder.append(str);
        stringBuilder.append(e.ap(qfVar.mtR));
        qc qcVar = iVar.field_favProto.mta;
        if (qcVar == null || qcVar.aHr() == 0) {
            v.d("MicroMsg.FavLocItemParser", "klem toXml, loc item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
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
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        qp qpVar = iVar.field_favProto.mtc;
        if (qpVar == null || qpVar.aHr() == 0) {
            v.d("MicroMsg.FavUrlItemParser", "klem toXml, url item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
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
                stringBuffer.append("<canvasPageXml>").append(qpVar.canvasPageXml).append("</canvasPageXml>");
            }
            stringBuffer.append("</weburlitem>");
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        qe qeVar = iVar.field_favProto.mte;
        if (qeVar == null || qeVar.aHr() == 0) {
            v.d("MicroMsg.FavProductItemParser", "klem toXml, product item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
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
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        qj qjVar = iVar.field_favProto.mtg;
        if (qjVar == null || qjVar.aHr() == 0) {
            v.d("MicroMsg.FavTVItemParser", "klem toXml, product item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
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
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        stringBuffer2.append(stringBuilder.toString());
        stringBuffer2.append(q.a(iVar.field_tagProto));
        stringBuffer2.append("</favitem>");
        return stringBuffer2.toString();
    }

    public final i alG() {
        i iVar = new i();
        iVar.field_favProto = this.field_favProto;
        iVar.field_sourceId = this.field_sourceId;
        iVar.field_edittime = this.field_edittime;
        iVar.field_ext = this.field_ext;
        iVar.field_flag = this.field_flag;
        iVar.field_fromUser = this.field_fromUser;
        iVar.field_id = this.field_id;
        iVar.field_itemStatus = this.field_itemStatus;
        iVar.field_localId = this.field_localId;
        iVar.field_localSeq = this.field_localSeq;
        iVar.field_realChatName = this.field_realChatName;
        iVar.field_tagProto = this.field_tagProto;
        iVar.field_sourceCreateTime = this.field_sourceCreateTime;
        iVar.field_updateSeq = this.field_updateSeq;
        iVar.field_toUser = this.field_toUser;
        iVar.field_updateTime = this.field_updateTime;
        iVar.field_type = this.field_type;
        iVar.field_xml = this.field_xml;
        iVar.field_datatotalsize = this.field_datatotalsize;
        return iVar;
    }
}
