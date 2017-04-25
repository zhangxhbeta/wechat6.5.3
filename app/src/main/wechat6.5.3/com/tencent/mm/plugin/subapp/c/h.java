package com.tencent.mm.plugin.subapp.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import java.io.File;
import junit.framework.Assert;

public final class h {
    public static String as(String str, boolean z) {
        ak.yW();
        String b = com.tencent.mm.sdk.platformtools.h.b(c.wV(), "recbiz_", str, ".rec", 2);
        if (be.kS(b)) {
            return null;
        }
        return (z || !new File(b).exists()) ? b : b;
    }

    public static boolean lG(String str) {
        if (str == null) {
            return false;
        }
        g Ct = Ct(str);
        if (Ct == null) {
            v.d("MicroMsg.VoiceRemindLogic", "cancel null record : " + str);
            return true;
        }
        v.d("MicroMsg.VoiceRemindLogic", "cancel record : " + str + " LocalId:" + Ct.field_msglocalid);
        if (Ct.field_msglocalid != 0) {
            ak.yW();
            c.wJ().em((long) Ct.field_msglocalid);
        }
        if (str == null) {
            return false;
        }
        d.aZv().hc(str);
        lD(str);
        return new File(as(str, false)).delete();
    }

    static void lD(String str) {
        d.aZv().lD(as(str, false));
    }

    public static g Ct(String str) {
        k aZv = d.aZv();
        g gVar = null;
        String str2 = "SELECT filename, user, msgid, offset, filenowsize, totallen, status, createtime, lastmodifytime, clientid, voicelenght, msglocalid, human, voiceformat, nettimes, reserved1, reserved2" + " FROM VoiceRemindInfo WHERE filename= ?";
        Cursor rawQuery = aZv.cie.rawQuery(str2, new String[]{str});
        if (rawQuery.moveToFirst()) {
            gVar = new g();
            gVar.b(rawQuery);
        }
        rawQuery.close();
        return gVar;
    }

    public static boolean lh(String str) {
        boolean z = false;
        if (str != null) {
            g Ct = Ct(str);
            if (Ct == null) {
                v.e("MicroMsg.VoiceRemindLogic", "Set error failed file:" + str);
            } else {
                Ct.field_status = 98;
                Ct.field_lastmodifytime = System.currentTimeMillis() / 1000;
                Ct.bkU = 320;
                z = a(Ct);
                v.d("MicroMsg.VoiceRemindLogic", "setError file:" + str + " msgid:" + Ct.field_msglocalid + " old stat:" + Ct.field_status);
                if (Ct.field_msglocalid == 0 || be.kS(Ct.field_user)) {
                    v.e("MicroMsg.VoiceRemindLogic", "setError failed msg id:" + Ct.field_msglocalid + " user:" + Ct.field_user);
                } else {
                    ak.yW();
                    at ek = c.wJ().ek((long) Ct.field_msglocalid);
                    ek.x((long) Ct.field_msglocalid);
                    ek.dh(5);
                    ek.cH(Ct.field_user);
                    ek.setContent(f.b(Ct.field_human, -1, true));
                    ak.yW();
                    c.wJ().a(ek.field_msgId, ek);
                }
            }
        }
        return z;
    }

    static boolean a(g gVar) {
        if (gVar == null || gVar.bkU == -1) {
            return false;
        }
        k aZv = d.aZv();
        Assert.assertTrue(gVar.field_filename.length() > 0);
        Assert.assertTrue(gVar != null);
        ContentValues py = gVar.py();
        if (py.size() <= 0) {
            v.e("MicroMsg.VoiceRemindStorage", "update failed, no values set");
            return false;
        }
        if (aZv.cie.update("VoiceRemindInfo", py, "filename= ?", new String[]{r4}) <= 0) {
            return false;
        }
        aZv.Ls();
        return true;
    }

    public static c Cu(String str) {
        k aZv = d.aZv();
        String as = as(str, false);
        if (aZv.kfT.get(as) == null) {
            aZv.kfT.put(as, new c(as));
        }
        return (c) aZv.kfT.get(as);
    }
}
