package com.tencent.mm.storage;

import com.tencent.mm.e.b.aa;
import com.tencent.mm.g.a.a.b;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class o extends aa {
    protected static a chq;
    public Map<String, b> cDH = new HashMap();
    private com.tencent.mm.g.a.a.a nnV = new com.tencent.mm.g.a.a.a();
    public com.tencent.mm.g.a.a.a nnW = this.nnV;
    private List<String> nnX = new LinkedList();

    static {
        a aVar = new a();
        aVar.ddU = new Field[18];
        aVar.bXK = new String[19];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "chatroomname";
        aVar.nmd.put("chatroomname", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" chatroomname TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "chatroomname";
        aVar.bXK[1] = "addtime";
        aVar.nmd.put("addtime", "LONG");
        stringBuilder.append(" addtime LONG");
        stringBuilder.append(", ");
        aVar.bXK[2] = "memberlist";
        aVar.nmd.put("memberlist", "TEXT");
        stringBuilder.append(" memberlist TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "displayname";
        aVar.nmd.put("displayname", "TEXT");
        stringBuilder.append(" displayname TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = "chatroomnick";
        aVar.nmd.put("chatroomnick", "TEXT");
        stringBuilder.append(" chatroomnick TEXT");
        stringBuilder.append(", ");
        aVar.bXK[5] = "roomflag";
        aVar.nmd.put("roomflag", "INTEGER");
        stringBuilder.append(" roomflag INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[6] = "roomowner";
        aVar.nmd.put("roomowner", "TEXT");
        stringBuilder.append(" roomowner TEXT");
        stringBuilder.append(", ");
        aVar.bXK[7] = "roomdata";
        aVar.nmd.put("roomdata", "BLOB");
        stringBuilder.append(" roomdata BLOB");
        stringBuilder.append(", ");
        aVar.bXK[8] = "isShowname";
        aVar.nmd.put("isShowname", "INTEGER");
        stringBuilder.append(" isShowname INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[9] = "selfDisplayName";
        aVar.nmd.put("selfDisplayName", "TEXT");
        stringBuilder.append(" selfDisplayName TEXT");
        stringBuilder.append(", ");
        aVar.bXK[10] = "style";
        aVar.nmd.put("style", "INTEGER");
        stringBuilder.append(" style INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[11] = "chatroomdataflag";
        aVar.nmd.put("chatroomdataflag", "INTEGER");
        stringBuilder.append(" chatroomdataflag INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[12] = "modifytime";
        aVar.nmd.put("modifytime", "LONG");
        stringBuilder.append(" modifytime LONG");
        stringBuilder.append(", ");
        aVar.bXK[13] = "chatroomnotice";
        aVar.nmd.put("chatroomnotice", "TEXT");
        stringBuilder.append(" chatroomnotice TEXT");
        stringBuilder.append(", ");
        aVar.bXK[14] = "chatroomVersion";
        aVar.nmd.put("chatroomVersion", "INTEGER");
        stringBuilder.append(" chatroomVersion INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[15] = "chatroomnoticeEditor";
        aVar.nmd.put("chatroomnoticeEditor", "TEXT");
        stringBuilder.append(" chatroomnoticeEditor TEXT");
        stringBuilder.append(", ");
        aVar.bXK[16] = "chatroomnoticePublishTime";
        aVar.nmd.put("chatroomnoticePublishTime", "LONG");
        stringBuilder.append(" chatroomnoticePublishTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[17] = "chatroomLocalVersion";
        aVar.nmd.put("chatroomLocalVersion", "LONG");
        stringBuilder.append(" chatroomLocalVersion LONG");
        aVar.bXK[18] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public final List<String> DM() {
        if (this.nnX == null || this.nnX.size() == 0) {
            this.nnX = LB(this.field_memberlist);
        }
        return this.nnX;
    }

    private void a(com.tencent.mm.g.a.a.a aVar) {
        if (this.field_roomdata == null) {
            aVar = new com.tencent.mm.g.a.a.a();
        }
        Iterator it = aVar.caF.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            this.cDH.put(bVar.userName, bVar);
        }
    }

    public final void bvb() {
        if (!be.bl(this.field_roomdata)) {
            try {
                this.nnW = (com.tencent.mm.g.a.a.a) new com.tencent.mm.g.a.a.a().az(this.field_roomdata);
            } catch (Exception e) {
                this.nnW = new com.tencent.mm.g.a.a.a();
            }
            a(this.nnW);
        }
    }

    public final boolean b(com.tencent.mm.g.a.a.a aVar) {
        return this.nnV.aHr() == aVar.aHr();
    }

    public final b Ly(String str) {
        if (this.cDH.size() <= 0) {
            bvb();
        }
        if (this.cDH.containsKey(str)) {
            return (b) this.cDH.get(str);
        }
        return null;
    }

    public final int bvc() {
        if (b(this.nnW)) {
            bvb();
        }
        return this.nnW.biE;
    }

    public final boolean bvd() {
        if (b(this.nnW)) {
            bvb();
        }
        return this.nnW.biE < this.nnW.caI;
    }

    public static boolean bve() {
        return false;
    }

    public final void ej(int i) {
        this.field_chatroomdataflag = (this.nnW.bkU & -3) | (i & 2);
    }

    public final int bvf() {
        if (b(this.nnW)) {
            bvb();
        }
        return this.nnW.type;
    }

    public final int bvg() {
        if (b(this.nnW)) {
            bvb();
        }
        return this.nnW.caG;
    }

    public final String Lz(String str) {
        b Ly = Ly(str);
        if (Ly == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        return be.ah(Ly.caL, SQLiteDatabase.KeyEmpty);
    }

    public final String er(String str) {
        b Ly = Ly(str);
        if (Ly == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        return be.ah(Ly.caJ, SQLiteDatabase.KeyEmpty);
    }

    public final o iA(boolean z) {
        this.field_isShowname = z ? 1 : 0;
        return this;
    }

    public final boolean bvh() {
        return this.field_isShowname > 0;
    }

    private static int AW(String str) {
        int i = 0;
        try {
            i = be.getInt(str, 0);
        } catch (Exception e) {
            if (str != null) {
                v.e("MicroMsg.ChatRoomMember", "parserInt error " + str);
            }
        }
        return i;
    }

    private static com.tencent.mm.g.a.a.a LA(String str) {
        com.tencent.mm.g.a.a.a aVar = new com.tencent.mm.g.a.a.a();
        if (be.kS(str)) {
            return aVar;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        Map q = bf.q(str, "RoomData");
        if (q == null) {
            v.e("MicroMsg.ChatRoomMember", "parse RoomData failed");
            return null;
        }
        int i = 0;
        while (true) {
            try {
                Object obj;
                Object obj2;
                Object obj3;
                String str2;
                b bVar = new b();
                if (i == 0) {
                    obj = ".RoomData.Member.$UserName";
                    obj2 = ".RoomData.Member.DisplayName";
                    obj3 = ".RoomData.Member.Flag";
                } else if (i != 0) {
                    String str3 = ".RoomData.Member" + i + ".$UserName";
                    String str4 = ".RoomData.Member" + i + ".DisplayName";
                    String str5 = ".RoomData.Member" + i + ".Flag";
                    str2 = str3;
                    str3 = str4;
                    str4 = str5;
                } else {
                    obj3 = null;
                    obj2 = null;
                    obj = null;
                }
                str2 = be.ah((String) q.get(obj), SQLiteDatabase.KeyEmpty);
                if (be.kS(str2)) {
                    aVar.type = AW((String) q.get(".RoomData.Type"));
                    aVar.status = AW((String) q.get(".RoomData.Status"));
                    aVar.caG = AW((String) q.get(".RoomData.MaxCount"));
                    aVar.caH = be.ah((String) q.get(".RoomData.ExtInfo.Upgrader"), SQLiteDatabase.KeyEmpty);
                    return aVar;
                }
                bVar.userName = str2;
                bVar.caJ = be.ah((String) q.get(obj2), SQLiteDatabase.KeyEmpty);
                bVar.caK = AW((String) q.get(obj3));
                aVar.caF.add(bVar);
                i++;
            } catch (Exception e) {
                return aVar;
            }
        }
    }

    public static List<String> LB(String str) {
        List<String> linkedList = new LinkedList();
        if (be.kS(str)) {
            return linkedList;
        }
        String[] split = str.split(";");
        for (Object add : split) {
            linkedList.add(add);
        }
        return linkedList;
    }

    public final o bS(List<String> list) {
        String str;
        if (list == null || list.size() == 0) {
            str = SQLiteDatabase.KeyEmpty;
        } else {
            str = SQLiteDatabase.KeyEmpty;
            for (int i = 0; i < list.size(); i++) {
                str = str + ((String) list.get(i));
                if (i < list.size() - 1) {
                    str = str + ";";
                }
            }
        }
        this.field_memberlist = str;
        return this;
    }

    public final o dK(String str, String str2) {
        return a(str, LA(str2), false);
    }

    public final o a(String str, com.tencent.mm.g.a.a.a aVar, boolean z) {
        this.field_modifytime = System.currentTimeMillis();
        if (!z) {
            int i;
            b bVar = null;
            Iterator it = aVar.caF.iterator();
            while (it.hasNext()) {
                b bVar2 = (b) it.next();
                if (bVar2.userName == null || !bVar2.userName.equals(str)) {
                    bVar2 = bVar;
                }
                bVar = bVar2;
            }
            if (bVar != null) {
                this.field_selfDisplayName = bVar.caJ;
                this.field_isShowname = bVar.caK & 1;
                i = bVar.caK;
            } else {
                i = 0;
            }
            v.d("MicroMsg.ChatRoomMember", "displayName[%s] roomFlag[%d] flag[%d]", this.field_selfDisplayName, Integer.valueOf(this.field_chatroomdataflag), Integer.valueOf(i));
            aVar.bkU = (i & 2) | (aVar.bkU & -3);
            this.field_chatroomdataflag = aVar.bkU;
        }
        try {
            this.field_roomdata = aVar.toByteArray();
            this.nnW = aVar;
        } catch (Throwable e) {
            v.e("MicroMsg.ChatRoomMember", "exception:%s", be.e(e));
        }
        a(aVar);
        return this;
    }
}
