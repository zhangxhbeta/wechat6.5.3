package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.as.l;
import com.tencent.mm.as.n;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.backup.f.g;
import com.tencent.mm.plugin.backup.i.a;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class s implements l {
    public final int a(dx dxVar, boolean z, at atVar, String str, LinkedList<g> linkedList) {
        Object obj;
        int i;
        b.Vd().KV();
        String lc = o.lc(atVar.field_imgPath);
        n lp = a.lp(atVar.field_imgPath);
        if (lp == null || lp.status == 199) {
            obj = 1;
        } else {
            obj = null;
        }
        File file = new File(lc);
        if (obj == null || !file.exists()) {
            i = 0;
        } else {
            i = (int) file.length();
        }
        int i2 = 0;
        b.Vd().KV();
        String ld = o.ld(atVar.field_imgPath);
        File file2 = new File(ld);
        if (file2.exists()) {
            i2 = (int) file2.length();
        }
        if (z) {
            return i2 + i;
        }
        int i3 = 0;
        if (i2 != 0) {
            if (atVar.field_type == 62) {
                i3 = g.a(ld, dxVar, linkedList, 13, z, "_thumb", false, null) + 0;
            } else {
                i3 = g.a(ld, dxVar, linkedList, 11, z, "_thumb", false, null) + 0;
            }
        }
        int a = (obj == null || i == 0) ? i3 : atVar.field_type == 62 ? g.a(lc, dxVar, linkedList, 12, z, false, null) + i3 : g.a(lc, dxVar, linkedList, 10, z, false, null) + i3;
        String a2 = a(dxVar, atVar);
        if (a2 == null) {
            return a;
        }
        dxVar.mbW = new arf().JF(a2);
        return a + a2.length();
    }

    public final int a(String str, dx dxVar, at atVar) {
        n nVar = new n();
        nVar.ble = dxVar.mbU.mQy;
        nVar.dhH = atVar.field_createTime;
        nVar.bmL = dxVar.mcb;
        String str2 = dxVar.mbW.mQy;
        v.d("MicroMsg.MMBakItemVideo", "parseVideoMsgXML content:" + str2);
        Map q = bf.q(str2, "msg");
        if (q != null) {
            try {
                nVar.cyu = g.ag((String) q.get(".msg.videomsg.$length"), 0);
                nVar.dhK = g.ag((String) q.get(".msg.videomsg.$playlength"), 0);
                nVar.dhC = (String) q.get(".msg.videomsg.$fromusername");
                int ag = g.ag((String) q.get(".msg.videomsg.$type"), 0);
                v.d("MicroMsg.MMBakItemVideo", "video msg exportType :" + ag);
                if (ag == 44) {
                    ag = 1;
                } else {
                    ag = 0;
                }
                nVar.dhO = ag;
            } catch (Throwable e) {
                v.e("MicroMsg.MMBakItemVideo", "parsing voice msg xml failed");
                v.a("MicroMsg.MMBakItemVideo", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        } else {
            v.e("MicroMsg.MMBakItemVideo", "videomsg paseXml failed:%s", dxVar.mbW.mQy);
            atVar.setContent(dxVar.mbW.mQy);
        }
        if (g.b(dxVar, 10) || g.b(dxVar, 12)) {
            nVar.status = 199;
        } else {
            nVar.status = MMGIFException.D_GIF_ERR_NOT_READABLE;
        }
        String lb = o.lb(nVar.Le());
        atVar.cI(lb);
        nVar.aST = lb;
        if (atVar.field_type != 62) {
            atVar.setType(43);
        }
        atVar.setContent(l.b(nVar.Le(), nVar.dhJ, false));
        nVar.dhL = (int) a.e(atVar);
        nVar.dhI = be.Nh();
        nVar.dhM = 0;
        v.d("MicroMsg.MMBakItemVideo", "Insert fileName[" + nVar.getFileName() + "] size:" + nVar.cyu + " svrid:" + nVar.bmL + " timelen:" + nVar.dhK + " user:" + nVar.Ld() + " human:" + nVar.Le());
        b.Vd().KV().a(nVar);
        b.Vd().KV();
        str2 = o.ld(lb);
        if (atVar.field_type == 62) {
            g.b(dxVar, 13, str2);
            str2 = g.a(dxVar, 12);
        } else {
            g.b(dxVar, 11, str2);
            str2 = g.a(dxVar, 10);
        }
        if (str2 != null) {
            str2 = g.pc(str2);
            b.Vd().KV();
            j.n(str2, o.lc(lb), false);
        }
        return 0;
    }

    private static String a(dx dxVar, at atVar) {
        int i = 62;
        n lp = a.lp(atVar.field_imgPath);
        if (lp == null) {
            return null;
        }
        if (atVar.field_type != 62) {
            if (lp.dhO == 0) {
                i = 44;
            } else {
                i = 43;
            }
        }
        dxVar.efm = i;
        if (be.kS(atVar.field_content)) {
            return null;
        }
        String Le;
        if (a.dE(atVar.field_talker)) {
            Le = lp.Le();
        } else {
            Le = dxVar.mbU.mQy;
        }
        Writer stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            newSerializer.startTag(null, "msg");
            newSerializer.startTag(null, "videomsg");
            newSerializer.attribute(null, "playlength", lp.dhK);
            newSerializer.attribute(null, "length", lp.cyu);
            newSerializer.attribute(null, "type", String.valueOf(i));
            if (!be.kS(Le)) {
                newSerializer.attribute(null, "fromusername", Le);
            }
            newSerializer.endTag(null, "videomsg");
            newSerializer.endTag(null, "msg");
            newSerializer.endDocument();
            stringWriter.flush();
            stringWriter.close();
            String stringBuffer = stringWriter.getBuffer().toString();
            v.d("MicroMsg.MMBakItemVideo", "parseContent xml:" + stringBuffer);
            return stringBuffer;
        } catch (Exception e) {
            v.e("MicroMsg.MMBakItemVideo", "packetVoice xml error: " + e.toString());
            return null;
        }
    }
}
