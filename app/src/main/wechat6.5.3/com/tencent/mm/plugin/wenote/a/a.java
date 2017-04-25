package com.tencent.mm.plugin.wenote.a;

import com.tencent.mm.a.e;
import com.tencent.mm.e.a.iz;
import com.tencent.mm.e.a.jb;
import com.tencent.mm.plugin.wenote.c.b;
import com.tencent.mm.plugin.wenote.c.d;
import com.tencent.mm.plugin.wenote.c.g;
import com.tencent.mm.plugin.wenote.c.m;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public final class a extends c<iz> {
    public a() {
        this.nhz = iz.class.getName().hashCode();
    }

    private static boolean a(iz izVar) {
        if ((izVar.bjq.field_status == 3 || izVar.bjq.field_status == 2) && e.aR(izVar.bjq.field_path) && izVar.bjq.field_path.endsWith("..htm")) {
            g.m(izVar.bjq.field_favLocalId, izVar.bjq.field_path);
        }
        if (b.bma().bmb() != null) {
            d dVar = new d();
            dVar.field_dataId = izVar.bjq.field_dataId;
            dVar.field_favLocalId = izVar.bjq.field_favLocalId;
            dVar.field_offset = izVar.bjq.field_offset;
            dVar.field_totalLen = izVar.bjq.field_totalLen;
            dVar.field_status = izVar.bjq.field_status;
            dVar.field_path = izVar.bjq.field_path;
            dVar.field_localId = izVar.bjq.field_localId;
            boolean z = dVar.field_status == 3 || dVar.field_status == 2;
            if (z && e.aR(dVar.field_path)) {
                String str = (String) b.bma().bmb().lsz.get(dVar.field_dataId);
                if (!be.kS(str)) {
                    v.d("MicroMsg.NotifyWNNoteCdnChangedListener", "on cdn status change,editorId[%s]", new Object[]{str});
                    com.tencent.mm.plugin.wenote.b.g gVar;
                    if (str.equals("WeNoteHtmlFile")) {
                        v.d("MicroMsg.NotifyWNNoteCdnChangedListener", "WNNote:webview reload");
                        if (b.bma().bmb().lty.bjH == -1) {
                            gVar = (com.tencent.mm.plugin.wenote.b.g) com.tencent.mm.plugin.wenote.b.b.ltA.get(Long.toString(b.bma().bmb().lty.bao));
                        } else {
                            gVar = (com.tencent.mm.plugin.wenote.b.g) com.tencent.mm.plugin.wenote.b.b.ltA.get(Long.toString(b.bma().bmb().lty.bjH));
                        }
                        if (gVar != null) {
                            try {
                                gVar.bjD = be.e(new FileInputStream(new File(dVar.field_path)));
                            } catch (Throwable e) {
                                v.a("MicroMsg.NotifyWNNoteCdnChangedListener", e, "", new Object[0]);
                            }
                            jb jbVar = new jb();
                            jbVar.bjB.bjF = b.bma().bmb().blX();
                            jbVar.bjB.bjD = gVar.bjD;
                            jbVar.bjB.type = 0;
                            jbVar.bjB.context = aa.getContext();
                            jbVar.bjB.bjH = dVar.field_favLocalId;
                            jbVar.bjB.bjI = com.tencent.mm.plugin.wenote.b.e.bJ(b.bma().bmb().lty.ipS);
                            com.tencent.mm.sdk.c.a.nhr.z(jbVar);
                        }
                    } else if (b.bma().bmb().lsz.containsValue("WeNoteHtmlFile")) {
                        if (b.bma().bmb().lty.bjH == -1) {
                            gVar = (com.tencent.mm.plugin.wenote.b.g) com.tencent.mm.plugin.wenote.b.b.ltA.get(Long.toString(b.bma().bmb().lty.bao));
                        } else {
                            gVar = (com.tencent.mm.plugin.wenote.b.g) com.tencent.mm.plugin.wenote.b.b.ltA.get(Long.toString(b.bma().bmb().lty.bjH));
                        }
                        if (!(gVar == null || gVar.lun == null)) {
                            Iterator it = gVar.lun.iterator();
                            while (it.hasNext()) {
                                com.tencent.mm.plugin.wenote.c.e eVar = (com.tencent.mm.plugin.wenote.c.e) it.next();
                                if (eVar.lut.equals(str)) {
                                    eVar.luv = true;
                                    eVar.bjG = dVar.field_path;
                                    if (eVar.type == 4) {
                                        m mVar = (m) eVar;
                                        mVar.bjJ = com.tencent.mm.plugin.wenote.b.b.ltI;
                                        mVar.length = (int) g.au((long) ((pw) b.bma().bmb().ltC.get(dVar.field_dataId)).duration);
                                        mVar.luy = g.F(aa.getContext(), mVar.length);
                                    }
                                }
                            }
                        }
                    } else {
                        jb jbVar2 = new jb();
                        jbVar2.bjB.bjt = str;
                        jbVar2.bjB.bjG = dVar.field_path;
                        jbVar2.bjB.type = 1;
                        jbVar2.bjB.bjy = ((com.tencent.mm.plugin.wenote.c.e) b.bma().bmb().ltD.get(str)).type;
                        if (5 != jbVar2.bjB.bjy) {
                            if (jbVar2.bjB.bjy == 4) {
                                jbVar2.bjB.bdX = ((pw) b.bma().bmb().ltC.get(dVar.field_dataId)).duration;
                                ((com.tencent.mm.plugin.wenote.c.e) b.bma().bmb().ltD.get(str)).bjG = dVar.field_path;
                                ((com.tencent.mm.plugin.wenote.c.e) b.bma().bmb().ltD.get(str)).luv = true;
                            }
                            v.i("MicroMsg.NotifyWNNoteCdnChangedListener", "WNNote: publish insertevnet:%s,%s", new Object[]{jbVar2.bjB.bjt, jbVar2.bjB.bjG});
                            com.tencent.mm.sdk.c.a.nhr.z(jbVar2);
                        }
                    }
                    b.bma().bmb().lsz.remove(dVar.field_dataId);
                }
            }
        }
        return false;
    }
}
