package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bg.g;
import com.tencent.mm.pluginsdk.j.b;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.List;

public final class c extends j implements b {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS addr_upload2 ( id int  PRIMARY KEY , md5 text  , peopleid text  , uploadtime long  , realname text  , realnamepyinitial text  , realnamequanpin text  , username text  , nickname text  , nicknamepyinitial text  , nicknamequanpin text  , type int  , moblie text  , email text  , status int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int , lvbuf BLOG , showhead int  ) ", "CREATE INDEX IF NOT EXISTS upload_time_index ON addr_upload2 ( uploadtime ) ", "CREATE INDEX IF NOT EXISTS addr_upload_user_index ON addr_upload2 ( username ) "};
    public final g cuX;

    public c(g gVar) {
        Object obj = null;
        this.cuX = gVar;
        String str = "addr_upload2";
        Cursor rawQuery = gVar.rawQuery("PRAGMA table_info( " + str + " )", null);
        Object obj2 = null;
        while (rawQuery.moveToNext()) {
            int columnIndex = rawQuery.getColumnIndex("name");
            if (columnIndex >= 0) {
                String string = rawQuery.getString(columnIndex);
                if ("lvbuf".equalsIgnoreCase(string)) {
                    obj2 = 1;
                } else if ("showhead".equalsIgnoreCase(string)) {
                    obj = 1;
                }
            }
        }
        rawQuery.close();
        if (obj2 == null) {
            gVar.dF(str, "Alter table " + str + " add lvbuf BLOB ");
        }
        if (obj == null) {
            gVar.dF(str, "Alter table " + str + " add showhead int ");
        }
    }

    public final boolean A(List<String> list) {
        if (list.size() <= 0) {
            return false;
        }
        boolean z;
        bc bcVar = new bc("MicroMsg.AddrUploadStorage", "delete transaction");
        bcVar.addSplit("begin");
        long er = this.cuX.er(Thread.currentThread().getId());
        try {
            for (String str : list) {
                if (str != null && str.length() > 0) {
                    int delete = this.cuX.delete("addr_upload2", "id =?", new String[]{b.iy(str)});
                    v.d("MicroMsg.AddrUploadStorage", "delete addr_upload2 md5 :" + str + ", res:" + delete);
                    if (delete > 0) {
                        b(5, this, str);
                    }
                }
            }
            z = true;
        } catch (Throwable e) {
            v.a("MicroMsg.AddrUploadStorage", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            z = false;
        }
        this.cuX.es(er);
        bcVar.addSplit("end");
        bcVar.dumpToLog();
        return z;
    }

    public final boolean z(List<b> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        boolean z;
        bc bcVar = new bc("MicroMsg.AddrUploadStorage", "transaction");
        bcVar.addSplit("transation begin");
        long er = this.cuX.er(Thread.currentThread().getId());
        for (int i = 0; i < list.size(); i++) {
            b bVar = (b) list.get(i);
            if (bVar != null) {
                Object obj;
                Cursor rawQuery = this.cuX.rawQuery("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where addr_upload2.id = \"" + b.iy(bVar.EB()) + "\"", null);
                if (rawQuery == null) {
                    obj = null;
                } else {
                    try {
                        if (rawQuery.getCount() > 0) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        rawQuery.close();
                    } catch (Exception e) {
                        v.e("MicroMsg.AddrUploadStorage", e.getMessage());
                        z = false;
                    }
                }
                if (obj == null) {
                    bVar.bkU = -1;
                    if (((int) this.cuX.insert("addr_upload2", "id", bVar.py())) == -1) {
                        v.i("MicroMsg.AddrUploadStorage", "batchSet insert failed, num:%s email:%s", bVar.EJ(), bVar.EK());
                        z = true;
                        break;
                    }
                    b(2, this, bVar.EB());
                } else {
                    int iy = b.iy(bVar.EB());
                    ContentValues py = bVar.py();
                    int i2 = 0;
                    if (py.size() > 0) {
                        i2 = this.cuX.update("addr_upload2", py, "id=?", new String[]{String.valueOf(iy)});
                    }
                    if (i2 == 0) {
                        v.i("MicroMsg.AddrUploadStorage", "batchSet update result=0, num:%s email:%s", bVar.EJ(), bVar.EK());
                    } else if (i2 < 0) {
                        v.i("MicroMsg.AddrUploadStorage", "batchSet update failed, num:%s email:%s", bVar.EJ(), bVar.EK());
                        z = true;
                        break;
                    } else {
                        b(3, this, bVar.EB());
                    }
                }
            }
        }
        z = true;
        this.cuX.es(er);
        bcVar.addSplit("transation end");
        bcVar.dumpToLog();
        return z;
    }

    public final boolean B(List<String> list) {
        boolean z;
        bc bcVar = new bc("MicroMsg.AddrUploadStorage", "set uploaded transaction");
        bcVar.addSplit("transation begin");
        long er = this.cuX.er(Thread.currentThread().getId());
        try {
            for (String str : list) {
                if (str != null && str.length() > 0) {
                    b bVar = new b();
                    bVar.bkU = 8;
                    bVar.cGR = be.Nh();
                    ContentValues py = bVar.py();
                    int i = 0;
                    if (py.size() > 0) {
                        i = this.cuX.update("addr_upload2", py, "id=?", new String[]{b.iy(str)});
                    }
                    v.i("MicroMsg.AddrUploadStorage", "local contact uploaded : " + str + ", update result: " + i);
                }
            }
            z = true;
        } catch (Exception e) {
            v.e("MicroMsg.AddrUploadStorage", e.getMessage());
            z = false;
        }
        this.cuX.es(er);
        bcVar.addSplit("transation end");
        bcVar.dumpToLog();
        if (z) {
            b(3, this, null);
        }
        return z;
    }

    public final int a(String str, b bVar) {
        int i = 0;
        ContentValues py = bVar.py();
        if (py.size() > 0) {
            i = this.cuX.update("addr_upload2", py, "id=?", new String[]{b.iy(str)});
        }
        if (i > 0) {
            if (bVar.EB().equals(str)) {
                b(3, this, str);
            } else {
                b(5, this, str);
                b(2, this, bVar.EB());
            }
        }
        return i;
    }

    public final b iA(String str) {
        if (be.kS(str)) {
            return null;
        }
        b bVar = new b();
        Cursor rawQuery = this.cuX.rawQuery("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 where addr_upload2.username=\"" + be.lZ(str) + "\"", null);
        v.d("MicroMsg.AddrUploadStorage", "get addrUpload :" + str + ", resCnt:" + rawQuery.getCount());
        if (rawQuery.getCount() != 0) {
            rawQuery.moveToFirst();
            bVar.b(rawQuery);
        }
        rawQuery.close();
        return bVar;
    }

    public final b ad(long j) {
        b bVar = new b();
        Cursor rawQuery = this.cuX.rawQuery("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 WHERE id=" + Long.toString(j) + ';', null);
        if (rawQuery.moveToFirst()) {
            bVar.b(rawQuery);
        }
        rawQuery.close();
        return bVar;
    }

    public final b iB(String str) {
        b bVar = null;
        if (str != null && str.length() > 0) {
            Cursor rawQuery = this.cuX.rawQuery("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 where addr_upload2.id=\"" + b.iy(str) + "\"", null);
            v.d("MicroMsg.AddrUploadStorage", "get addrUpload :" + str + ", resCnt:" + rawQuery.getCount());
            if (rawQuery.getCount() != 0) {
                rawQuery.moveToFirst();
                bVar = new b();
                bVar.b(rawQuery);
            }
            rawQuery.close();
        }
        return bVar;
    }

    public final List<String[]> EO() {
        Cursor rawQuery = this.cuX.rawQuery("select addr_upload2.moblie , addr_upload2.md5 from addr_upload2 where addr_upload2.type = 0", null);
        List<String[]> linkedList = new LinkedList();
        while (rawQuery.moveToNext()) {
            linkedList.add(new String[]{rawQuery.getString(0), rawQuery.getString(1)});
        }
        rawQuery.close();
        return linkedList;
    }

    public final List<b> iC(String str) {
        v.d("MicroMsg.AddrUploadStorage", "sql : " + str);
        List linkedList = new LinkedList();
        v.d("MicroMsg.AddrUploadStorage", "sql : " + str);
        Cursor rawQuery = this.cuX.rawQuery(str, null);
        rawQuery.moveToFirst();
        if (rawQuery.getCount() <= 0) {
            rawQuery.close();
        } else {
            do {
                b bVar = new b();
                bVar.b(rawQuery);
                linkedList.add(bVar);
            } while (rawQuery.moveToNext());
            rawQuery.close();
        }
        return linkedList;
    }

    protected final boolean EP() {
        if (this.cuX != null && !this.cuX.buA()) {
            return true;
        }
        String str = "MicroMsg.AddrUploadStorage";
        String str2 = "shouldProcessEvent db is close :%s";
        Object[] objArr = new Object[1];
        objArr[0] = this.cuX == null ? "null" : Boolean.valueOf(this.cuX.buA());
        v.w(str, str2, objArr);
        return false;
    }

    public final String iD(String str) {
        b iB = iB(str);
        if (iB != null) {
            return iB.getUsername();
        }
        return null;
    }

    public final String iE(String str) {
        Cursor query;
        Exception e;
        Throwable th;
        if (!be.kS(str)) {
            try {
                query = this.cuX.query("addr_upload2", null, "peopleid=?", new String[]{str}, null, null, null);
                try {
                    if (query.getCount() != 0) {
                        query.moveToFirst();
                        b bVar = new b();
                        bVar.b(query);
                        String username = bVar.getUsername();
                        if (query == null) {
                            return username;
                        }
                        query.close();
                        return username;
                    } else if (query != null) {
                        query.close();
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        v.e("MicroMsg.AddrUploadStorage", "getFriendUsernameBySystemAddrBookPeopleId, error:%s", e.getMessage());
                        if (query != null) {
                            query.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                query = null;
                v.e("MicroMsg.AddrUploadStorage", "getFriendUsernameBySystemAddrBookPeopleId, error:%s", e.getMessage());
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        }
        return null;
    }
}
