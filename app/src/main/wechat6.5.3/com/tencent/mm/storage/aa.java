package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bg.c;
import com.tencent.mm.bg.g;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.m.a.e;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.h.h;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class aa extends j implements aq {
    public static final String[] btd = new String[]{"CREATE UNIQUE INDEX IF NOT EXISTS  contact_username_unique_index ON rcontact ( username )", "CREATE INDEX IF NOT EXISTS  contact_alias_index ON rcontact ( alias )", "CREATE INDEX IF NOT EXISTS  en_username_unique_index ON rcontact ( encryptUsername )", "CREATE UNIQUE INDEX IF NOT EXISTS  bottle_username_unique_index ON bottlecontact ( username )", "CREATE INDEX IF NOT EXISTS type_verifyFlag_index ON rcontact ( type,verifyFlag ) "};
    public static final String[] cic = new String[]{f.a(u.chq, "rcontact"), f.a(u.chq, "bottlecontact"), f.a(v.chq, "ContactCmdBuf"), "CREATE TABLE IF NOT EXISTS contact ( contactID INTEGER PRIMARY KEY, sex INT, type INT, showHead INT, username VARCHAR(40), nickname VARCHAR(40), pyInitial VARCHAR(40), quanPin VARCHAR(60), reserved TEXT );", "CREATE TABLE IF NOT EXISTS contact_ext ( username VARCHAR(40), Uin INTEGER DEFAULT 0, Email VARCHAR(128), Mobile VARCHAR(40), ShowFlag INTEGER DEFAULT 0 , ConType INTEGER DEFAULT 0 , ConRemark TEXT, ConRemark_PYShort TEXT, ConRemark_PYFull TEXT, ConQQMBlog TEXT, ConSMBlog TEXT, DomainList TEXT, reserved1 INT DEFAULT 0 , reserved2 INT DEFAULT 0 , reserved3 INT DEFAULT 0 , reserved4 INT DEFAULT 0 , reserved5 INT DEFAULT 0 , reserved6 TEXT, reserved7 TEXT, reserved8 TEXT, reserved9 TEXT, reserved10 TEXT, weiboflag  INT DEFAULT 0 ,weibonickname TEXT  );"};
    public static String nuw = "showHead = 32";
    public static String nux = "type & 64 !=0 ";
    public final h<a, u> cBg = new h<a, u>(this) {
        final /* synthetic */ aa nuy;

        {
            this.nuy = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((a) obj).a(this.nuy, (u) obj2);
        }
    };
    public d cie;
    private d nut;
    public final com.tencent.mm.a.f<String, u> nuu = new com.tencent.mm.a.f(200);
    public final com.tencent.mm.a.f<String, Integer> nuv = new com.tencent.mm.a.f(400);

    public interface a {
        void a(aa aaVar, u uVar);
    }

    private static String LQ(String str) {
        return "select *,rowid from " + LR(str) + " ";
    }

    public static String LR(String str) {
        if (u.ew(str)) {
            return "bottlecontact";
        }
        return "rcontact";
    }

    public aa(g gVar) {
        int i = 1;
        int i2 = 0;
        Cursor rawQuery = gVar.rawQuery("PRAGMA table_info( contact_ext )", null);
        int i3 = 0;
        int i4 = 0;
        while (rawQuery.moveToNext() && (i4 == 0 || i3 == 0)) {
            int columnIndex = rawQuery.getColumnIndex("name");
            if (columnIndex >= 0) {
                String string = rawQuery.getString(columnIndex);
                if ("weiboNickname".equalsIgnoreCase(string)) {
                    i3 = 1;
                } else if ("weiboFlag".equalsIgnoreCase(string)) {
                    i4 = 1;
                }
            }
        }
        rawQuery.close();
        if (i4 == 0) {
            gVar.dF("contact_ext", "Alter table contact_ext add weiboFlag INT DEFAULT 0 ");
        }
        if (i3 == 0) {
            gVar.dF("contact_ext", "Alter table contact_ext add weiboNickname INT DEFAULT 0 ");
        }
        Cursor rawQuery2 = gVar.rawQuery("PRAGMA table_info( rcontact )", null);
        while (rawQuery2.moveToNext()) {
            i4 = rawQuery2.getColumnIndex("name");
            if (i4 >= 0) {
                if ("verifyFlag".equalsIgnoreCase(rawQuery2.getString(i4))) {
                    break;
                }
            }
        }
        i = 0;
        rawQuery2.close();
        if (i == 0) {
            gVar.dF("rcontact", "Alter table rcontact add verifyFlag INT DEFAULT 0 ");
        }
        for (String dF : f.a(com.tencent.mm.i.a.chq, "bottlecontact", (d) gVar)) {
            gVar.dF("bottlecontact", dF);
        }
        for (String dF2 : f.a(com.tencent.mm.i.a.chq, "rcontact", (d) gVar)) {
            gVar.dF("rcontact", dF2);
        }
        String[] strArr = btd;
        i = strArr.length;
        while (i2 < i) {
            gVar.dF("rcontact", strArr[i2]);
            i2++;
        }
        this.cie = gVar;
        this.nut = gVar;
    }

    public final void a(a aVar) {
        this.cBg.a(aVar, null);
    }

    public final void b(a aVar) {
        if (this.cBg != null) {
            this.cBg.remove(aVar);
        }
    }

    public final u LS(String str) {
        u uVar = (u) this.nuu.get(str);
        return uVar != null ? uVar : null;
    }

    public final void K(u uVar) {
        if (uVar != null && uVar.field_username != null && uVar.field_type != 0) {
            this.nuu.k(uVar.field_username, uVar);
            this.nuv.k(uVar.field_username, Integer.valueOf(uVar.field_type));
        }
    }

    private void zk(String str) {
        if (!be.kS(str)) {
            this.nuu.remove(str);
            this.nuv.remove(str);
        }
    }

    public final boolean LT(String str) {
        if (be.kS(str) || (str.contains("@") && !str.endsWith("@stranger"))) {
            return false;
        }
        Integer num = (Integer) this.nuv.get(str);
        if (num != null) {
            return com.tencent.mm.i.a.ei(num.intValue());
        }
        ab LX = LX(str);
        if (LX == null || !(LX.field_username.equals(str) || str.equals(LX.field_encryptUsername))) {
            this.nuv.k(str, Integer.valueOf(0));
            return false;
        }
        this.nuv.k(str, Integer.valueOf(LX.field_type));
        return com.tencent.mm.i.a.ei(LX.field_type);
    }

    public final boolean L(u uVar) {
        if (LZ(uVar.field_username)) {
            if (a(uVar.field_username, uVar) == 0) {
                return true;
            }
            return false;
        } else if (O(uVar) < 0) {
            return false;
        } else {
            return true;
        }
    }

    public final u LU(String str) {
        if (be.kS(str)) {
            return null;
        }
        u uVar = new u();
        Cursor rawQuery = this.cie.rawQuery("select *,rowid from rcontact where alias=" + g.dM(str), null);
        if (rawQuery.getCount() != 0) {
            rawQuery.moveToFirst();
            uVar.b(rawQuery);
            K(uVar);
        }
        rawQuery.close();
        uVar.bvr();
        return uVar;
    }

    public final Cursor a(String str, String str2, List<String> list, List<String> list2, boolean z, boolean z2) {
        String str3 = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff from rcontact " + e(str, str2, list) + cb(list2) + bvz();
        v.v("MicroMsg.ContactStorage", str3);
        if (!z) {
            return this.cie.aH(str3, true);
        }
        com.tencent.mm.m.a.g[] gVarArr = new com.tencent.mm.m.a.g[2];
        String str4 = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff from rcontact " + g(list, z2) + bvA();
        v.v("MicroMsg.ContactStorage", "favourSql " + str3);
        Cursor aH = this.cie.aH(str4, true);
        Cursor aH2 = this.cie.aH(str3, true);
        if (!(aH instanceof com.tencent.mm.m.a.g) || !(aH2 instanceof com.tencent.mm.m.a.g)) {
            return c.bxW();
        }
        gVarArr[0] = (com.tencent.mm.m.a.g) aH;
        gVarArr[1] = (com.tencent.mm.m.a.g) aH2;
        return new e(gVarArr);
    }

    public final Cursor bX(List<String> list) {
        boolean z;
        int i = 0;
        if (list.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        String str = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff from rcontact  where ";
        while (i < list.size()) {
            if (i != list.size() - 1) {
                str = str + "username = '" + ((String) list.get(i)) + "' OR ";
            } else {
                str = str + "username = '" + ((String) list.get(i)) + "'";
            }
            i++;
        }
        return this.cie.rawQuery(str + bvz(), null);
    }

    public final u LV(String str) {
        if (be.kS(str)) {
            return null;
        }
        if (u.ew(str)) {
            str = u.LM(str);
        }
        u LS = LS(str);
        if (LS != null) {
            LS.bvr();
            return LS;
        }
        LS = new u();
        Cursor rawQuery = this.cie.rawQuery(LQ(str) + " where username=" + g.dM(str), null);
        if (rawQuery.getCount() != 0) {
            rawQuery.moveToFirst();
            LS.b(rawQuery);
            K(LS);
        }
        rawQuery.close();
        LS.bvr();
        return LS;
    }

    public final u LW(String str) {
        if (be.kS(str)) {
            return null;
        }
        if (u.ew(str)) {
            str = u.LM(str);
        }
        u LS = LS(str);
        if (LS != null) {
            return LS;
        }
        LS = new u();
        Cursor rawQuery = this.cie.rawQuery(LQ(str) + " where username=" + g.dM(str) + " or encryptUsername=" + g.dM(str), null);
        if (rawQuery.getCount() != 0) {
            rawQuery.moveToFirst();
            LS.b(rawQuery);
            K(LS);
        }
        rawQuery.close();
        return LS;
    }

    public final u LX(String str) {
        if (be.kS(str)) {
            return null;
        }
        if (u.ew(str)) {
            str = u.LM(str);
        }
        u LS = LS(str);
        if (LS != null) {
            return LS;
        }
        LS = new u();
        Cursor rawQuery = this.cie.rawQuery(LQ(str) + " where username=" + g.dM(str) + " or encryptUsername=" + g.dM(str), null);
        if (rawQuery.getCount() != 0) {
            rawQuery.moveToFirst();
            LS.b(rawQuery);
            LS.bvr();
            K(LS);
        }
        rawQuery.close();
        return LS;
    }

    public final u eg(long j) {
        u uVar = null;
        if (j > 0) {
            Cursor rawQuery = this.cie.rawQuery("select * ,rowid from rcontact  where rowid=" + j, null);
            if (rawQuery.getCount() != 0) {
                uVar = new u();
                rawQuery.moveToFirst();
                uVar.b(rawQuery);
                K(uVar);
            }
            rawQuery.close();
            if (uVar != null) {
                uVar.bvr();
            }
        }
        return uVar;
    }

    public final long LY(String str) {
        com.tencent.mm.i.a LX = LX(str);
        if (LX == null || LX.chr <= 0) {
            return -1;
        }
        return (long) ((int) LX.chr);
    }

    public final boolean LZ(String str) {
        ab LX = LX(str);
        if (LX == null || be.kS(LX.field_username) || !LX.field_username.equals(str)) {
            return false;
        }
        return true;
    }

    public final boolean M(u uVar) {
        Assert.assertTrue("contact NULL !", uVar != null);
        if (!P(uVar)) {
            return true;
        }
        uVar.cP(uVar.tm());
        this.cBg.bg(uVar);
        this.cBg.Ls();
        v.d("MicroMsg.ContactStorage", "replace : username=%s, showHead=%d, verifyFlag=%d", uVar.field_username, Integer.valueOf(uVar.field_showHead), Integer.valueOf(uVar.field_verifyFlag));
        ContentValues py = uVar.py();
        if (((int) uVar.chr) > 0) {
            py.put("rowid", Integer.valueOf((int) uVar.chr));
        }
        boolean z = this.cie.replace(LR(uVar.field_username), com.tencent.mm.i.a.chq.nmc, py) > 0;
        zk(uVar.field_username);
        if (!be.kS(uVar.field_encryptUsername)) {
            zk(uVar.field_encryptUsername);
        }
        if (!z) {
            return false;
        }
        b(4, this, uVar.field_username);
        return true;
    }

    public final boolean N(u uVar) {
        return O(uVar) > 0;
    }

    public final int O(u uVar) {
        if (be.ma(uVar.field_username).length() <= 0) {
            v.e("MicroMsg.ContactStorage", "FATAL ERROR, invalid contact, empty username");
            return -1;
        }
        uVar.cP(uVar.tm());
        this.cBg.bg(uVar);
        this.cBg.Ls();
        v.d("MicroMsg.ContactStorage", "insert : username=%s, showHead=%d, verifyFlag=%d", uVar.field_username, Integer.valueOf(uVar.field_showHead), Integer.valueOf(uVar.field_verifyFlag));
        int insert = (int) this.cie.insert(LR(uVar.field_username), com.tencent.mm.i.a.chq.nmc, uVar.py());
        if (insert != -1) {
            uVar.chr = (long) insert;
            K(uVar);
            b(2, this, uVar.field_username);
            return insert;
        }
        v.e("MicroMsg.ContactStorage", "insert failed: username=" + uVar.field_username);
        return -1;
    }

    public final byte[] Ma(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.ContactStorage", "getCmdbuf failed user is null");
            return null;
        }
        v vVar = new v();
        Cursor query = this.cie.query("ContactCmdBuf", null, "username=?", new String[]{str}, null, null, null);
        if (query.getCount() != 0) {
            query.moveToFirst();
            vVar.b(query);
        }
        query.close();
        String str2 = "MicroMsg.ContactStorage";
        String str3 = "getCmdbuf user:%s buf:%d";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(vVar.field_cmdbuf == null ? -1 : vVar.field_cmdbuf.length);
        v.d(str2, str3, objArr);
        return vVar.field_cmdbuf;
    }

    public final int Mb(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.ContactStorage", "delCmdBuf failed user is null");
            return -1;
        }
        v.d("MicroMsg.ContactStorage", "delCmdBuf user:%s ret:%d", str, Integer.valueOf(this.cie.delete("ContactCmdBuf", "username=?", new String[]{str})));
        return this.cie.delete("ContactCmdBuf", "username=?", new String[]{str});
    }

    public final int Mc(String str) {
        Assert.assertTrue(str.length() > 0);
        if (u.ew(str)) {
            str = u.LM(str);
        }
        zk(str);
        u uVar = new u(str);
        uVar.setType(0);
        uVar.setUsername("fake_" + be.Ni());
        uVar.bY("fake_" + be.Ni());
        int update = this.cie.update(LR(str), uVar.py(), "username=?", new String[]{str});
        Mb(str);
        v.w("MicroMsg.ContactStorage", "delete (because the fucking talker id , dk just mark it  disappear .) user:%s res:%s %s", str, Integer.valueOf(update), be.bur());
        if (update != 0) {
            b(5, this, str);
        }
        return update;
    }

    public final int a(String str, u uVar) {
        int i = 0;
        v.d("MicroMsg.ContactStorage", "begin to update contact : " + str);
        if (!P(uVar)) {
            return 1;
        }
        if (u.ew(str)) {
            str = u.LM(str);
        }
        uVar.cP(uVar.tm());
        this.cBg.bg(uVar);
        this.cBg.Ls();
        v.d("MicroMsg.ContactStorage", "update : username=%s, showHead=%d, verifyFlag=%d", uVar.field_username, Integer.valueOf(uVar.field_showHead), Integer.valueOf(uVar.field_verifyFlag));
        ContentValues py = uVar.py();
        if (((int) uVar.chr) > 0) {
            py.put("rowid", Integer.valueOf((int) uVar.chr));
        }
        if (py.size() > 0) {
            i = this.cie.update(LR(str), py, "username=?", new String[]{str});
        }
        zk(str);
        if (!be.kS(uVar.field_encryptUsername)) {
            zk(uVar.field_encryptUsername);
        }
        if (i == 0) {
            return i;
        }
        b(4, this, str);
        return i;
    }

    public final int b(String str, u uVar) {
        int i = 0;
        if (be.kS(str) || uVar == null || be.kS(uVar.field_username)) {
            v.e("MicroMsg.ContactStorage", "update : wrong input!");
            return 0;
        }
        v.d("MicroMsg.ContactStorage", "updateEncryptUser contact: " + uVar.field_username + " enUsername: " + str);
        if (!P(uVar)) {
            return 1;
        }
        if (u.ew(uVar.field_username)) {
            uVar.setUsername(u.LM(uVar.field_username));
        }
        uVar.cP(uVar.tm());
        this.cBg.bg(uVar);
        this.cBg.Ls();
        v.d("MicroMsg.ContactStorage", "update : oldUsername=%s, username=%s, showHead=%d, verifyFlag=%d", str, uVar.field_username, Integer.valueOf(uVar.field_showHead), Integer.valueOf(uVar.field_verifyFlag));
        ContentValues py = uVar.py();
        u uVar2;
        if (uVar.chr <= 0) {
            uVar2 = new u(str);
            uVar2.setType(0);
            uVar2.setUsername("fake_" + be.Ni());
            uVar2.bY("fake_" + be.Ni());
            v.d("MicroMsg.ContactStorage", "newContact.contactId <= 0 | delete " + LR(str) + " user :" + str + ", res:" + this.cie.update(LR(str), uVar2.py(), "username=?", new String[]{str}));
            if (py.size() > 0) {
                i = (int) this.cie.replace(LR(uVar.field_username), com.tencent.mm.i.a.chq.nmc, py);
            }
        } else if (!str.equals(uVar.field_username)) {
            uVar2 = new u(str);
            uVar2.setType(0);
            uVar2.setUsername("fake_" + be.Ni());
            uVar2.bY("fake_" + be.Ni());
            v.d("MicroMsg.ContactStorage", "delete " + LR(str) + " user :" + str + ", res:" + this.cie.update(LR(str), uVar2.py(), "username=?", new String[]{str}));
            if (py.size() > 0) {
                i = this.cie.update(LR(uVar.field_username), py, "rowid=?", new String[]{uVar.chr});
            }
        } else if (py.size() > 0) {
            v.i("MicroMsg.ContactStorage", "summercontact en equal username[%s], result1[%d], contactId[%d]", uVar.field_username, Integer.valueOf(this.cie.update(LR(uVar.field_username), py, "rowid=?", new String[]{uVar.chr})), Long.valueOf(uVar.chr));
            i = r1;
        }
        zk(uVar.field_username);
        if (!be.kS(uVar.field_encryptUsername)) {
            zk(uVar.field_encryptUsername);
        }
        b(3, this, str);
        b(3, this, uVar.field_username);
        return i;
    }

    public final Cursor bY(List<String> list) {
        boolean z;
        int i = 0;
        if (list.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        String str = "select * ,rowid from rcontact  where ";
        while (i < list.size()) {
            if (i != list.size() - 1) {
                str = str + "username = '" + ((String) list.get(i)) + "' OR ";
            } else {
                str = str + "username = '" + ((String) list.get(i)) + "'";
            }
            i++;
        }
        return this.cie.rawQuery(str + bvz(), null);
    }

    public final Cursor bZ(List<String> list) {
        boolean z;
        int i = 0;
        if (list.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        String str = "select * ,rowid from rcontact  where (";
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (i2 != list.size() - 1) {
                str = str + "username = '" + ((String) list.get(i2)) + "' OR ";
            } else {
                str = str + "username = '" + ((String) list.get(i2)) + "'";
            }
        }
        str = str + ") order by case username ";
        while (i < list.size()) {
            str = str + " when '" + ((String) list.get(i)) + "' then " + i;
            i++;
        }
        str = str + " end";
        v.d("MicroMsg.ContactStorage", "getCursorByNamesInListOrder sql:" + str);
        return this.cie.rawQuery(str, null);
    }

    public final Cursor ca(List<String> list) {
        int i = 0;
        Assert.assertTrue(list.size() > 0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select username, alias").append(", nickname, conRemark");
        stringBuilder.append(" from rcontact where ");
        while (i < list.size()) {
            if (i != 0) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("username = '").append((String) list.get(i)).append("'");
            i++;
        }
        return this.cie.rawQuery(stringBuilder.toString(), null);
    }

    public static String cb(List<String> list) {
        if (list == null || list.size() == 0) {
            return SQLiteDatabase.KeyEmpty;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : list) {
            stringBuilder.append(" or username = '").append(append).append("'");
        }
        return stringBuilder.toString();
    }

    public final Cursor a(String str, String str2, List<String> list, boolean z, boolean z2) {
        String str3 = "select * ,rowid from rcontact " + e(str, str2, list) + cb(null) + bvz();
        v.v("MicroMsg.ContactStorage", str3);
        return this.cie.rawQuery(str3, null);
    }

    public static String cc(List<String> list) {
        String cb = cb(list);
        int indexOf = cb.indexOf("or");
        if (indexOf <= 2) {
            return cb.substring(indexOf + 2);
        }
        return cb;
    }

    public final Cursor f(List<String> list, boolean z) {
        String str = "select * ,rowid from rcontact  where " + cc(list);
        if (z) {
            str = str + " " + bvz();
        }
        v.d("MicroMsg.ContactStorage", "sql " + str);
        return this.cie.rawQuery(str, null);
    }

    public final Cursor cd(List<String> list) {
        String str = "select * ,rowid from rcontact " + g(list, false) + bvA();
        v.v("MicroMsg.ContactStorage", "favourSql " + str);
        return this.cie.rawQuery(str, null);
    }

    public final Cursor c(String str, String str2, List<String> list) {
        return a(str, str2, (List) list, false, false);
    }

    public final Cursor d(String str, String str2, List<String> list) {
        String str3 = "select * ,rowid from rcontact " + e(str, str2, list) + bvz();
        v.v("MicroMsg.ContactStorage", str3);
        return this.cie.rawQuery(str3, null);
    }

    public final int bvy() {
        int i = 0;
        String str = "select count(rowid) from rcontact " + e("@biz.contact", null, null);
        v.v("MicroMsg.ContactStorage", str);
        Cursor rawQuery = this.cie.rawQuery(str, null);
        if (rawQuery.getCount() > 0) {
            rawQuery.moveToLast();
            i = rawQuery.getInt(0);
        }
        rawQuery.close();
        return i;
    }

    public final List<String> ce(List<String> list) {
        if (list.isEmpty()) {
            v.w("MicroMsg.ContactStorage", "getFilterList: but white list is empty");
            return new LinkedList();
        }
        long Nj = be.Nj();
        List<String> linkedList = new LinkedList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("username='").append((String) list.get(0)).append("'");
        for (int i = 1; i < list.size(); i++) {
            stringBuilder.append(" or username='").append((String) list.get(i)).append("'");
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("showHead asc, ");
        stringBuilder2.append("pyInitial asc, ");
        stringBuilder2.append("quanPin asc, ");
        stringBuilder2.append("nickname asc, ");
        stringBuilder2.append("username asc ");
        v.i("MicroMsg.ContactStorage", "getFilterList: sql is %s", String.format("select %s from %s where (%s) and (%s & %d != 0)  order by %s", new Object[]{"username", "rcontact", stringBuilder.toString(), "type", Integer.valueOf(com.tencent.mm.i.a.tE()), stringBuilder2.toString()}));
        Cursor rawQuery = this.cie.rawQuery(r0, null);
        if (rawQuery != null) {
            rawQuery.moveToFirst();
            while (!rawQuery.isAfterLast()) {
                linkedList.add(rawQuery.getString(0));
                rawQuery.moveToNext();
            }
            rawQuery.close();
        }
        v.i("MicroMsg.ContactStorage", "getFilerList: use time[%d ms] whiteList[%s], usernameList[%s]", Long.valueOf(be.az(Nj)), list, linkedList.toString());
        return linkedList;
    }

    public final int[] b(String str, String str2, String[] strArr, List<String> list) {
        String str3 = "select distinct showHead from rcontact " + e(str, str2, list) + E(strArr) + bvz();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.cie.rawQuery(str3, null);
        v.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowHeadDistinct db.rawQuery last" + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = rawQuery.getCount() >= 0 ? rawQuery.getCount() : 0;
        v.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowHeadDistinct  cu.getCount() last" + (System.currentTimeMillis() - currentTimeMillis));
        int[] iArr = new int[count];
        if (rawQuery.getCount() > 0) {
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        return iArr;
    }

    public final int[] b(String str, String str2, String str3, List<String> list) {
        String str4 = "select distinct showHead from rcontact " + e(str, str2, list) + Md(str3) + bvz();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.cie.rawQuery(str4, null);
        v.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = rawQuery.getCount() >= 0 ? rawQuery.getCount() : 0;
        v.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis));
        int[] iArr = new int[count];
        if (rawQuery.getCount() > 0) {
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        return iArr;
    }

    public final int[] cf(List<String> list) {
        String str = "select distinct showHead from rcontact  where (" + cc(list) + ") " + bvz();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.cie.rawQuery(str, null);
        v.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = rawQuery.getCount() >= 0 ? rawQuery.getCount() : 0;
        v.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis));
        int[] iArr = new int[count];
        if (rawQuery.getCount() > 0) {
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        return iArr;
    }

    public final int[] c(String str, String str2, String str3, List<String> list) {
        int[] iArr = null;
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.cie.rawQuery(("select count(*) from rcontact " + e(str, str2, list) + Md(str3)) + " group by showHead", null);
        v.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = rawQuery.getCount();
        v.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis));
        if (count > 0) {
            iArr = new int[count];
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        return iArr;
    }

    public final int[] cg(List<String> list) {
        int[] iArr = null;
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.cie.rawQuery(("select count(*) from rcontact " + "where " + cc(list)) + " group by showHead", null);
        v.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = rawQuery.getCount();
        v.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis));
        if (count > 0) {
            iArr = new int[count];
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        return iArr;
    }

    public final Cursor a(String[] strArr, String str, List<String> list) {
        String str2 = "select * ,rowid from rcontact " + e(str, null, list) + E(strArr);
        if (strArr != null && strArr.length > 0) {
            String str3 = str2 + " order by 1=1 ";
            int length = strArr.length;
            str2 = str3;
            int i = 0;
            while (i < length) {
                i++;
                str2 = str2 + ",username='" + strArr[i] + "' desc";
            }
        }
        v.v("MicroMsg.ContactStorage", "getSearchCursorByArrOrder sql : " + str2);
        return this.cie.rawQuery(str2, null);
    }

    public final Cursor a(String[] strArr, String str, String str2, List<String> list, List<String> list2) {
        String str3 = "select * ,rowid from rcontact " + e(str, str2, list2) + E(strArr) + m(str2, list) + bvz();
        v.i("MicroMsg.ContactStorage", str3);
        return this.cie.rawQuery(str3, null);
    }

    private static String m(String str, List<String> list) {
        if (str == null || str.equals(SQLiteDatabase.KeyEmpty)) {
            return SQLiteDatabase.KeyEmpty;
        }
        String str2 = " and (";
        if (!(list == null || list.size() == 0)) {
            String str3 = str2;
            for (String str22 : list) {
                str3 = str3 + "username = '" + str22 + "' or ";
            }
            str22 = str3;
        }
        return (((((((str22 + "conRemark like '%" + str + "%' or ") + "conRemarkPYFull like '%" + str + "%' or ") + "conRemarkPYShort like '%" + str + "%' or ") + "alias like '%" + str + "%' or ") + "username like '%" + str + "%' or ") + "nickname like '%" + str + "%' or ") + "pyInitial like '%" + str + "%' or ") + "quanPin like '%" + str + "%' )";
    }

    public static String E(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return SQLiteDatabase.KeyEmpty;
        }
        String str = " and (";
        int i = 0;
        while (i < strArr.length) {
            if (i > 0) {
                str = str + " or ";
            }
            String str2 = str + "username = '" + strArr[i] + "' ";
            i++;
            str = str2;
        }
        return str + " )";
    }

    public static String Md(String str) {
        if (str == null || str.equals(SQLiteDatabase.KeyEmpty)) {
            return SQLiteDatabase.KeyEmpty;
        }
        return (((((((" and (" + "conRemark like '%" + str + "%' or ") + "conRemarkPYFull like '%" + str + "%' or ") + "conRemarkPYShort like '%" + str + "%' or ") + "alias like '%" + str + "%' or ") + "username like '%" + str + "%' or ") + "nickname like '%" + str + "%' or ") + "pyInitial like '%" + str + "%' or ") + "quanPin like '%" + str + "%' )";
    }

    public static String bvz() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" order by showHead asc, ");
        stringBuffer.append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" case when length(conRemark) > 0 then upper(conRemark) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" upper(quanPin) asc, ");
        stringBuffer.append(" upper(nickname) asc, ");
        stringBuffer.append(" upper(username) asc ");
        return stringBuffer.toString();
    }

    public static String bvA() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" order by case when verifyFlag & " + u.bvo() + " != 0 then 0 else 1 end , showHead asc, ");
        stringBuffer.append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" case when length(conRemark) > 0 then upper(conRemark) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" upper(quanPin) asc, ");
        stringBuffer.append(" upper(nickname) asc, ");
        stringBuffer.append(" upper(username) asc ");
        return stringBuffer.toString();
    }

    private static String C(boolean z, boolean z2) {
        String str = "type & " + com.tencent.mm.i.a.tE() + "!=0";
        if (z) {
            str = str + " or type & " + com.tencent.mm.i.a.tG() + "!=0";
        }
        str = ((" where (" + str + ")") + " and type & " + com.tencent.mm.i.a.tH() + "=0 ") + " and type & " + com.tencent.mm.i.a.tF() + " =0 ";
        if (z2) {
            return str;
        }
        return str + " and verifyFlag & " + u.bvo() + " =0 ";
    }

    public static String bvB() {
        return (" where (" + ("type & " + com.tencent.mm.i.a.tE() + "!=0") + ") and ") + "type & " + com.tencent.mm.i.a.tH() + "=0  ";
    }

    public static String bvC() {
        return "( (" + ("type & " + com.tencent.mm.i.a.tE() + "!=0") + ") and type & " + com.tencent.mm.i.a.tF() + "=0 and username like '%" + "@chatroom')";
    }

    public static String bvD() {
        return "type & " + com.tencent.mm.i.a.tF() + "=0 and username like '%" + "@chatroom'";
    }

    private static String bvE() {
        return "( (" + ("type & " + com.tencent.mm.i.a.tE() + "!=0") + ") and type & " + com.tencent.mm.i.a.tF() + "=0 and username like '%" + "@talkroom')";
    }

    public static String g(List<String> list, boolean z) {
        String str = C(false, z) + " AND " + nux;
        String str2 = SQLiteDatabase.KeyEmpty;
        if (list != null && list.size() > 0) {
            String str3 = str2;
            for (String str22 : list) {
                str3 = str3 + " AND username != '" + str22 + "'";
            }
            str22 = str3;
        }
        return str + str22;
    }

    public static String e(String str, String str2, List<String> list) {
        String str3;
        String str4;
        boolean z = true;
        String str5 = SQLiteDatabase.KeyEmpty;
        if (str == null || str.equals("@all.android")) {
            str3 = str5 + C(true, false);
        } else if (str.equals("@all.contact.android")) {
            str3 = str5 + bvB();
        } else if (str.equals("@all.chatroom.contact")) {
            str3 = str5 + ((" where (" + ("(type & " + com.tencent.mm.i.a.tE() + "!=0 and username like '%@chatroom" + "')") + ") and ") + "type & " + com.tencent.mm.i.a.tH() + "=0 ");
        } else if (str.equals("@all.contact.without.chatroom")) {
            r2 = new StringBuilder().append(str5);
            r3 = C(false, false);
            if (r3 == null || r3.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = r2.append(r3 + " and ( username not like '%@%'" + (" or (" + bvE() + ')') + ")").toString();
        } else if (str.equals("@black.android")) {
            str3 = str5 + (" where type & " + com.tencent.mm.i.a.tF() + "!=0");
        } else if (str.equals("@t.qq.com")) {
            str3 = str5 + (" where username like '%" + "@t.qq.com" + "'");
        } else if (str.equals("@domain.android")) {
            r2 = new StringBuilder().append(str5);
            r3 = C(true, false);
            if (r3 == null || r3.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = r2.append(r3 + " and domainList like '%" + str2 + "%'").toString();
        } else if (str.equals("@micromsg.qq.com")) {
            r2 = new StringBuilder().append(str5);
            r3 = C(false, false);
            if (r3 == null || r3.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str4 = " or (" + bvC() + ')';
            str3 = r2.append(r3 + " and ( username not like '%@%'" + str4 + (" or (" + bvE() + ')') + ")").toString();
        } else if (str.equals("@micromsg.no.verify.biz.qq.com")) {
            r2 = new StringBuilder().append(str5);
            r3 = (((" where (" + ("type & " + com.tencent.mm.i.a.tE() + " !=0 ") + ") and ") + "type & " + com.tencent.mm.i.a.tH() + " =0 and ") + "type & " + com.tencent.mm.i.a.tF() + " =0 and ") + "verifyFlag & " + u.bvo() + " =0";
            if (r3 == null || r3.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = r2.append(r3 + " and ( username not like '%@%'" + (" or (" + bvC() + ')') + ")").toString();
        } else if (str.equals("@micromsg.with.all.biz.qq.com")) {
            r2 = new StringBuilder().append(str5);
            r3 = ((" where (" + ("type & " + com.tencent.mm.i.a.tE() + " !=0 ") + ") and ") + "type & " + com.tencent.mm.i.a.tH() + " =0 and ") + "type & " + com.tencent.mm.i.a.tF() + " =0";
            if (r3 == null || r3.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = r2.append(r3 + " and ( username not like '%@%'" + (" or (" + bvC() + ')') + ")").toString();
        } else if (str.equals("@qqim")) {
            r2 = new StringBuilder().append(str5);
            r3 = "@qqim";
            String C = C(false, false);
            if (C == null || C.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = r2.append(C + " and username like '%" + r3 + "'").toString();
        } else if (str.equals("@all.chatroom")) {
            str3 = str5 + (" where (" + (((("type & " + com.tencent.mm.i.a.tE() + " !=0") + " or type & 2 !=0") + " or type & 4 !=0") + " or 1") + ") ");
        } else if (str.equals("@verify.contact")) {
            str3 = str5 + (" where (" + (("type & " + com.tencent.mm.i.a.tE() + " != 0 and ") + "verifyFlag & " + u.bvn() + " != 0") + ") ");
        } else if (str.equals("@biz.contact")) {
            str3 = str5 + (" where (" + (("type & " + com.tencent.mm.i.a.tE() + " != 0 and ") + "verifyFlag & " + u.bvo() + " != 0") + ") ");
        } else if (str.equals("@all.weixin.android")) {
            str3 = str5 + (" where (" + ("type & " + com.tencent.mm.i.a.tE() + " != 0 or  (username not like '%" + "@qqim' and username not like '%" + "@qr' and username not like '%" + "@bottle' and username not like '%" + "@fb' and username not like '%" + "@google' and username not like '%" + "@t.qq.com' and username not like '%" + "@t.sina.com' and username not like '%" + "@t.sina.com')") + ") ");
        } else {
            v.d("MicroMsg.ContactStorage", "unknow role type");
            str3 = str5 + C(false, false);
        }
        str4 = SQLiteDatabase.KeyEmpty;
        if (list != null && list.size() > 0) {
            str5 = str4;
            for (String str42 : list) {
                str5 = str5 + " and username != '" + str42 + "'";
            }
            str42 = str5;
        }
        return str3 + str42;
    }

    public static String j(String str, String[] strArr) {
        String str2 = " and ( 1 != 1 ";
        for (Object obj : strArr) {
            if ("@all.android".equals(obj)) {
                str2 = str2 + " or 1 = 1";
            } else if ("@micromsg.qq.com".equals(obj)) {
                str2 = str2 + " or " + str + " not like '%@%'";
            } else if ("@chatroom".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@chatroom'";
            } else if ("@talkroom".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@talkroom'";
            } else if ("@t.qq.com".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@t.qq.com'";
            } else if ("@qqim".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@qqim'";
            } else if ("@chatroom_exclusive".equals(obj)) {
                str2 = str2 + " or " + str + "not like %@chatroom";
            } else if ("@app".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@app'";
            }
        }
        return str2 + " ) ";
    }

    public final int b(String[] strArr, String... strArr2) {
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select count(username) from rcontact where ");
        stringBuilder.append("type & ").append(com.tencent.mm.i.a.tE()).append(" !=0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.i.a.tH()).append(" =0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.i.a.tF()).append(" =0 and ");
        stringBuilder.append("verifyFlag & 8").append(" = 0 and ");
        stringBuilder.append("( username not like '%@%')");
        if (strArr != null && strArr.length > 0) {
            for (String append : strArr) {
                stringBuilder.append(" and rcontact.username").append(" != '").append(append).append("'");
            }
        }
        for (i = 0; i < 4; i++) {
            stringBuilder.append(" and rcontact.username").append(" != '").append(strArr2[i]).append("'");
        }
        stringBuilder.append(" or username = 'weixin").append("'");
        Cursor rawQuery = this.cie.rawQuery(stringBuilder.toString(), null);
        if (rawQuery != null) {
            rawQuery.moveToFirst();
            i = rawQuery.getInt(0);
            rawQuery.close();
        } else {
            i = 0;
        }
        v.d("MicroMsg.ContactStorage", "getNormalContactCount, sql:%s, result:%d", r2, Integer.valueOf(i));
        return i;
    }

    public final Cursor bvF() {
        return this.cie.rawQuery("select * ,rowid from rcontact  where rowid = -1", null);
    }

    protected final boolean EP() {
        if (this.cie != null && !this.cie.buA()) {
            return true;
        }
        String str = "MicroMsg.ContactStorage";
        String str2 = "shouldProcessEvent db is close :%s";
        Object[] objArr = new Object[1];
        objArr[0] = this.cie == null ? "null" : Boolean.valueOf(this.cie.buA());
        v.w(str, str2, objArr);
        return false;
    }

    private static boolean P(u uVar) {
        boolean z = false;
        if (uVar != null) {
            int i = uVar.versionCode;
            if (i > 0) {
                z = true;
            }
            v.d("MicroMsg.ContactStorage", "it need to update contact: " + z + " version code : " + i + " user: " + uVar.field_username);
        }
        return z;
    }
}
