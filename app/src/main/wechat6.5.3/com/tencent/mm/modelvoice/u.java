package com.tencent.mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.model.j;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class u extends g {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS voiceinfo ( FileName TEXT PRIMARY KEY, User TEXT, MsgId INT, NetOffset INT, FileNowSize INT, TotalLen INT, Status INT, CreateTime INT, LastModifyTime INT, ClientId TEXT, VoiceLength INT, MsgLocalId INT, Human TEXT, reserved1 INT, reserved2 TEXT, MsgSource TEXT, MsgFlag INT, MsgSeq INT, MasterBufId INT )", "CREATE INDEX IF NOT EXISTS voiceinfomsgidindex ON voiceinfo ( MsgId ) ", "CREATE UNIQUE INDEX IF NOT EXISTS voiceinfouniqueindex ON voiceinfo ( FileName )", "DELETE FROM voiceinfo WHERE Status = 99"};
    public com.tencent.mm.bg.g cuX;
    Map<String, a> djP = new HashMap();
    Map<String, l> djQ = new HashMap();
    Map<String, h> djR = new HashMap();

    public u(com.tencent.mm.bg.g gVar) {
        b(gVar);
        this.cuX = gVar;
    }

    private static void b(com.tencent.mm.bg.g gVar) {
        Object obj = null;
        Cursor rawQuery = gVar.rawQuery("PRAGMA table_info(voiceinfo)", null);
        if (rawQuery == null) {
            v.i("MicroMsg.VoiceStorage", "addNewColIfNeed failed, cursor is null.");
            return;
        }
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        while (rawQuery.moveToNext()) {
            int columnIndex = rawQuery.getColumnIndex("name");
            if (columnIndex >= 0) {
                String string = rawQuery.getString(columnIndex);
                if ("MsgSource".equals(string)) {
                    obj4 = 1;
                }
                if ("MsgFlag".equals(string)) {
                    obj3 = 1;
                }
                if ("MsgSeq".equals(string)) {
                    obj2 = 1;
                }
                if ("MasterBufId".equals(string)) {
                    obj = 1;
                }
            }
        }
        rawQuery.close();
        if (obj4 == null) {
            gVar.dF("voiceinfo", "Alter table voiceinfo add MsgSource TEXT");
        }
        if (obj3 == null) {
            gVar.dF("voiceinfo", "Alter table voiceinfo add MsgFlag INT");
        }
        if (obj2 == null) {
            gVar.dF("voiceinfo", "Alter table voiceinfo add MsgSeq INT");
        }
        if (obj == null) {
            gVar.dF("voiceinfo", "Alter table voiceinfo add MasterBufId INT");
        }
    }

    public static String lI(String str) {
        return j.f(str, be.Ni());
    }

    public final boolean b(p pVar) {
        Assert.assertTrue(true);
        ContentValues py = pVar.py();
        if (py.size() <= 0) {
            v.e("MicroMsg.VoiceStorage", "insert falied, no values set");
        } else if (this.cuX.insert("voiceinfo", "FileName", py) != -1) {
            Ls();
            return true;
        }
        return false;
    }

    public final boolean a(String str, p pVar) {
        boolean z;
        Assert.assertTrue(str.length() > 0);
        if (pVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        ContentValues py = pVar.py();
        if (py.size() <= 0) {
            v.e("MicroMsg.VoiceStorage", "update failed, no values set");
        } else {
            if (this.cuX.update("voiceinfo", py, "FileName= ?", new String[]{str}) > 0) {
                Ls();
                return true;
            }
        }
        return false;
    }

    public final p av(long j) {
        p pVar = null;
        Cursor rawQuery = this.cuX.rawQuery("SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId" + " FROM voiceinfo WHERE MsgId=" + j, null);
        if (rawQuery.moveToFirst()) {
            pVar = new p();
            pVar.b(rawQuery);
        }
        rawQuery.close();
        return pVar;
    }

    public final p gx(int i) {
        p pVar = null;
        Cursor rawQuery = this.cuX.rawQuery("SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId" + " FROM voiceinfo WHERE MsgLocalId=" + i, null);
        if (rawQuery.moveToFirst()) {
            pVar = new p();
            pVar.b(rawQuery);
        }
        rawQuery.close();
        return pVar;
    }

    public final p lJ(String str) {
        p pVar = null;
        String str2 = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId" + " FROM voiceinfo WHERE FileName= ?";
        Cursor rawQuery = this.cuX.rawQuery(str2, new String[]{str});
        if (rawQuery.moveToFirst()) {
            pVar = new p();
            pVar.b(rawQuery);
        }
        rawQuery.close();
        return pVar;
    }
}
