package com.tencent.mm.modelfriend;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.mm.ar.e;
import com.tencent.mm.ar.f;
import com.tencent.mm.ar.l;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class m {
    private static Map<String, String> cHO = null;

    public enum a {
        NO_INIT,
        SET_MOBILE,
        SUCC,
        SUCC_UNLOAD
    }

    public static void EV() {
        ak.yW();
        c.vf().set(12322, Boolean.valueOf(true));
    }

    public static boolean EW() {
        if (ak.yW() != null) {
            ak.yW();
            if (c.vf() != null) {
                ak.yW();
                return be.a((Boolean) c.vf().get(12322, Boolean.valueOf(true)), true);
            }
        }
        v.e("MicroMsg.FriendLogic", "[arthurdan.UploadPhone] Notice!!!! MMCore.getAccStg() is null!!!");
        return false;
    }

    public static boolean EX() {
        v.i("MicroMsg.FriendLogic", "isTipInMobileFriend, state %s", EY().toString());
        if (EY() != a.SUCC) {
            return false;
        }
        ak.yW();
        v.i("MicroMsg.FriendLogic", "USERINFO_UPLOAD_ADDR_LOOK_UP %B", Boolean.valueOf(be.a((Boolean) c.vf().get(12322, Boolean.valueOf(false)), false)));
        if (be.a((Boolean) c.vf().get(12322, Boolean.valueOf(false)), false)) {
            return false;
        }
        return true;
    }

    public static a EY() {
        try {
            ak.yW();
            String str = (String) c.vf().get(4097, SQLiteDatabase.KeyEmpty);
            ak.yW();
            String str2 = (String) c.vf().get(6, SQLiteDatabase.KeyEmpty);
            boolean yj = k.yj();
            v.i("MicroMsg.FriendLogic", "isUpload " + yj + " stat " + k.xJ());
            if (str == null || str.length() <= 0) {
                str = null;
            }
            if (str2 == null || str2.length() <= 0) {
                str2 = null;
            }
            if (str == null && r1 == null) {
                return a.NO_INIT;
            }
            if (str != null && r1 == null) {
                return a.SET_MOBILE;
            }
            if (yj) {
                return a.SUCC;
            }
            return a.SUCC_UNLOAD;
        } catch (Exception e) {
            return a.NO_INIT;
        }
    }

    public static void EZ() {
        ak.yW();
        c.vf().set(4097, SQLiteDatabase.KeyEmpty);
        ak.yW();
        c.vf().set(6, SQLiteDatabase.KeyEmpty);
    }

    public static String Fa() {
        ak.yW();
        return (String) c.vf().get(6, SQLiteDatabase.KeyEmpty);
    }

    public static boolean Fb() {
        if (ak.uz()) {
            int i;
            if (EY() == a.SUCC) {
                i = 1;
            } else {
                boolean z = false;
            }
            if (i == 0) {
                v.i("MicroMsg.FriendLogic", "canSyncAddrBook userBindOpMobile: %b", Boolean.valueOf(false));
                return false;
            }
            if (EW()) {
                return true;
            }
            v.i("MicroMsg.FriendLogic", "canSyncAddrBook isUploadContact: %b", Boolean.valueOf(EW()));
            return false;
        }
        v.i("MicroMsg.FriendLogic", "canSyncAddrBook isAccHasReady: %b", Boolean.valueOf(ak.uz()));
        return false;
    }

    public static Bitmap a(String str, Context context) {
        return com.tencent.mm.pluginsdk.a.b(str, context, false);
    }

    public static boolean a(String str, Context context, byte[] bArr) {
        return com.tencent.mm.pluginsdk.a.b(str, context, bArr);
    }

    public static void Fc() {
        j FL = ah.FL();
        int delete = FL.cuX.delete("addr_upload2", null, null);
        v.d("MicroMsg.AddrUploadStorage", "delete addr_upload2");
        if (delete > 0) {
            FL.b(5, FL, null);
        }
    }

    public static void Fd() {
        HashSet hashSet = new HashSet();
        Iterator it = l.KC().Kv().iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            ak.yW();
            com.tencent.mm.storage.at.a MU = c.wJ().MU(fVar.field_msgContent);
            if (MU != null && (MU.scene == 10 || MU.scene == 11)) {
                hashSet.add(fVar.field_talker);
            }
        }
        v.d("MicroMsg.FriendLogic", "deleteMobileFMessage, delete fmsg and fconv, talker size = " + hashSet.size());
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            e.kE((String) it2.next());
        }
    }

    public static void C(List<String> list) {
        if (list.size() != 0) {
            HashSet hashSet = new HashSet();
            Iterator it = l.KC().Kv().iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                ak.yW();
                com.tencent.mm.storage.at.a MU = c.wJ().MU(fVar.field_msgContent);
                if (MU != null) {
                    String str = MU.nvH;
                    String str2 = MU.nvG;
                    if ((MU.scene == 10 || MU.scene == 11) && (list.contains(str) || list.contains(str2))) {
                        hashSet.add(fVar.field_talker);
                    }
                }
            }
            v.d("MicroMsg.FriendLogic", "deleteMobileFMessage(md5List), delete fmsg and fconv, talker size = " + hashSet.size());
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                e.kE((String) it2.next());
            }
        }
    }

    public static String iI(String str) {
        if (str == null || str.equals(SQLiteDatabase.KeyEmpty)) {
            return SQLiteDatabase.KeyEmpty;
        }
        c FL = ah.FL();
        Cursor rawQuery = FL.cuX.rawQuery("select addr_upload2.realname from addr_upload2 where addr_upload2.id = \"" + b.iy(str) + "\"", null);
        if (rawQuery == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            return SQLiteDatabase.KeyEmpty;
        }
        String str2 = SQLiteDatabase.KeyEmpty;
        if (rawQuery.moveToFirst()) {
            str2 = rawQuery.getString(0);
        }
        rawQuery.close();
        return str2;
    }

    public static void D(List<b> list) {
        if (list == null) {
            v.e("MicroMsg.FriendLogic", "sync address book failed, null info list");
        } else {
            ah.FL().z(list);
        }
    }

    public static void E(List<String> list) {
        if (list == null) {
            v.e("MicroMsg.FriendLogic", "set uploaded mobile contact failed, null info list");
        } else {
            ah.FL().B(list);
        }
    }

    public static List<String> Fe() {
        Cursor rawQuery = ah.FL().cuX.rawQuery("select addr_upload2.md5 from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 1", null);
        List<String> linkedList = new LinkedList();
        while (rawQuery.moveToNext()) {
            linkedList.add(rawQuery.getString(0));
        }
        rawQuery.close();
        return linkedList;
    }

    public static List<String> Ff() {
        Cursor rawQuery = ah.FL().cuX.rawQuery("select addr_upload2.moblie from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 0", null);
        List<String> linkedList = new LinkedList();
        while (rawQuery.moveToNext()) {
            String yt = com.tencent.mm.pluginsdk.a.yt(rawQuery.getString(0));
            if (com.tencent.mm.pluginsdk.a.FY(yt)) {
                linkedList.add(yt);
            }
        }
        rawQuery.close();
        return linkedList;
    }

    public static boolean fp(int i) {
        ad fs = ah.FO().fs(i);
        boolean ft = ah.FQ().ft(i);
        if (fs == null) {
            return false;
        }
        if (fs.cIx == 1 || ft) {
            return true;
        }
        return false;
    }
}
