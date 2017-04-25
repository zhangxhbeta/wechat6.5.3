package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.plugin.backup.f.f;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.storage.at;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class j {
    public static String ehZ = "<msg>";
    public static String eia = "</msg>";

    public static String pl(String str) {
        f oZ = b.oZ(str);
        return oZ == null ? null : oZ.ehI;
    }

    public static String a(at atVar, dx dxVar) {
        c NF = b.Vd().We().NF(atVar.field_imgPath);
        if (NF == null) {
            return null;
        }
        f pa = b.pa(NF.EB());
        if (pa == null) {
            pa = new f();
            pa.ehJ = NF.EB();
            pa.ehK = NF.EB();
            pa.ehL = NF.EB();
            pa.ehI = NF.EB();
        }
        Writer stringWriter = new StringWriter();
        try {
            String ah;
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
            newSerializer.startTag(null, "msg");
            newSerializer.startTag(null, "emoji");
            newSerializer.attribute(null, "fromusername", dxVar.mbU.mQy);
            newSerializer.attribute(null, "tousername", dxVar.mbV.mQy);
            newSerializer.attribute(null, "type", NF.field_type);
            newSerializer.attribute(null, "idbuffer", NF.field_svrid == null ? SQLiteDatabase.KeyEmpty : NF.field_svrid);
            newSerializer.attribute(null, "md5", pa.ehJ);
            newSerializer.attribute(null, "len", "1024");
            newSerializer.attribute(null, "androidmd5", pa.ehI);
            newSerializer.attribute(null, "androidlen", "1024");
            newSerializer.attribute(null, "productid", NF.field_groupId);
            newSerializer.endTag(null, "emoji");
            if (NF.bnk()) {
                newSerializer.startTag(null, "gameext");
                Map q = bf.q(NF.pO(), "gameext");
                String ah2 = be.ah((String) q.get(".gameext.$type"), SQLiteDatabase.KeyEmpty);
                ah = be.ah((String) q.get(".gameext.$content"), SQLiteDatabase.KeyEmpty);
                if (ah2.equals(SQLiteDatabase.KeyEmpty) || ah.equals(SQLiteDatabase.KeyEmpty)) {
                    stringWriter.close();
                    return SQLiteDatabase.KeyEmpty;
                }
                newSerializer.attribute(null, "type", ah2);
                newSerializer.attribute(null, "content", ah);
                newSerializer.endTag(null, "gameext");
            }
            newSerializer.endTag(null, "msg");
            newSerializer.endDocument();
            stringWriter.flush();
            stringWriter.close();
            ah = stringWriter.getBuffer().toString();
            try {
                ah = ah.substring(ah.indexOf(ehZ), ah.indexOf(eia) + eia.length());
                v.d("MicroMsg.EmojiConvert", "xml " + ah);
                return ah;
            } catch (Exception e) {
                return SQLiteDatabase.KeyEmpty;
            }
        } catch (Throwable e2) {
            v.a("MicroMsg.EmojiConvert", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
            return SQLiteDatabase.KeyEmpty;
        } catch (Throwable e22) {
            v.a("MicroMsg.EmojiConvert", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
            return SQLiteDatabase.KeyEmpty;
        } catch (Throwable e222) {
            v.a("MicroMsg.EmojiConvert", e222, SQLiteDatabase.KeyEmpty, new Object[0]);
            return SQLiteDatabase.KeyEmpty;
        } catch (Throwable e2222) {
            v.a("MicroMsg.EmojiConvert", e2222, SQLiteDatabase.KeyEmpty, new Object[0]);
            return SQLiteDatabase.KeyEmpty;
        }
    }
}
