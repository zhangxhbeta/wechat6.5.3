package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.a.e;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.backup.f.g;
import com.tencent.mm.plugin.backup.i.a;
import com.tencent.mm.protocal.c.are;
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

public final class t implements l {
    byte[] ejJ = new byte[]{(byte) 35, (byte) 33, (byte) 65, (byte) 77, (byte) 82, (byte) 10, (byte) 2, (byte) 35, (byte) 33};
    byte[] ejK = new byte[]{(byte) 35, (byte) 33, (byte) 65, (byte) 77, (byte) 82, (byte) 10, (byte) 35, (byte) 33};

    public final int a(dx dxVar, boolean z, at atVar, String str, LinkedList<g> linkedList) {
        String iU = a.iU(atVar.field_imgPath);
        File file = new File(iU);
        if (!file.exists()) {
            return 0;
        }
        int length = (int) file.length();
        if (z) {
            return length;
        }
        int a = g.a(iU, dxVar, linkedList, 9, z, false, null);
        String a2 = a(atVar, length);
        if (a2 == null) {
            return 0;
        }
        dxVar.mbW = new arf().JF(a2);
        int length2 = a + a2.length();
        return length == 0 ? length2 : length2;
    }

    public final int a(String str, dx dxVar, at atVar) {
        String a;
        String str2 = dxVar.mbW.mQy;
        if (a.dE(dxVar.mbU.mQy)) {
            int fK = a.fK(str2);
            if (fK != -1 && fK + 2 < str2.length()) {
                str2 = str2.substring(fK + 2);
            }
            v.v("MicroMsg.MMBakItemVoice", "chatroom voicemsg, new content=" + str2);
        }
        Map q = bf.q(str2, "msg");
        if (q != null) {
            try {
                atVar.setContent(n.b((String) q.get(".msg.voicemsg.$fromusername"), (long) g.ag((String) q.get(".msg.voicemsg.$voicelength"), 0), g.ag((String) q.get(".msg.voicemsg.$isPlayed"), 1) == 1));
            } catch (Throwable e) {
                v.e("MicroMsg.MMBakItemVoice", "parsing voice msg xml failed");
                v.a("MicroMsg.MMBakItemVoice", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        } else {
            v.e("MicroMsg.MMBakItemVoice", "voicemsg paseXml failed:%s", dxVar.mbW.mQy);
            atVar.setContent(dxVar.mbW.mQy);
        }
        str2 = u.lI(dxVar.mbU.mQy);
        atVar.cI(str2);
        a.e(atVar);
        str2 = a.iU(str2);
        if (dxVar.meV == 9) {
            Object obj = dxVar.meT.mQw.lVU;
            Object obj2;
            if (e(this.ejJ, obj)) {
                obj2 = new byte[(obj.length - 6)];
                System.arraycopy(obj, 6, obj2, 0, obj.length - 6);
                dxVar.meU = obj.length - 6;
                dxVar.meT = new are().ba(obj2);
            } else if (e(this.ejK, obj)) {
                obj2 = new byte[(obj.length - 6)];
                System.arraycopy(obj, 6, obj2, 0, obj.length - 6);
                dxVar.meU = obj.length - 6;
                dxVar.meT = new are().ba(obj2);
            }
            if (!g.b(dxVar, 9, str2)) {
                a = g.a(dxVar, 9);
                if (a != null) {
                    a = g.pc(a);
                    v.d("MicroMsg.MMBakItemVoice", "recover Frome Sdcard" + a);
                    j.n(a, str2, false);
                }
            }
            return 0;
        }
        a = g.a(dxVar, 9);
        if (!be.kS(a)) {
            a = g.pc(a);
            if (e.aR(a)) {
                byte[] d = e.d(a, 0, 9);
                if (e(this.ejJ, d)) {
                    d = e.d(a, 6, -1);
                    b.deleteFile(a);
                    e.b(a, d, d.length);
                } else if (e(this.ejK, d)) {
                    d = e.d(a, 6, -1);
                    b.deleteFile(a);
                    e.b(a, d, d.length);
                }
            }
        }
        if (g.b(dxVar, 9, str2)) {
            a = g.a(dxVar, 9);
            if (a != null) {
                a = g.pc(a);
                v.d("MicroMsg.MMBakItemVoice", "recover Frome Sdcard" + a);
                j.n(a, str2, false);
            }
        }
        return 0;
    }

    private static boolean e(byte[] bArr, byte[] bArr2) {
        if (be.bl(bArr2)) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static String a(at atVar, int i) {
        String str = null;
        if (!be.kS(atVar.field_content)) {
            n nVar = new n(atVar.field_content);
            Writer stringWriter = new StringWriter();
            try {
                XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
                newSerializer.setOutput(stringWriter);
                newSerializer.startTag(null, "msg");
                newSerializer.startTag(null, "voicemsg");
                newSerializer.attribute(null, "length", String.valueOf(i));
                newSerializer.attribute(null, "endflag", "1");
                newSerializer.attribute(null, "cancelflag", "0");
                newSerializer.attribute(null, "voicelength", nVar.time);
                if (!be.kS(nVar.dhC)) {
                    newSerializer.attribute(null, "fromusername", nVar.dhC);
                }
                newSerializer.attribute(null, "isPlayed", nVar.dhD ? "1" : "0");
                newSerializer.endTag(null, "voicemsg");
                newSerializer.endTag(null, "msg");
                newSerializer.endDocument();
                stringWriter.flush();
                stringWriter.close();
                str = stringWriter.getBuffer().toString();
                if (a.dE(atVar.field_talker)) {
                    str = nVar.dhC + ":\n" + str;
                }
                v.i("MicroMsg.MMBakItemVoice", "parseContent xml:" + str);
            } catch (Exception e) {
                v.e("MicroMsg.MMBakItemVoice", "packetVoice xml error: " + e.toString());
            }
        }
        return str;
    }
}
