package com.tencent.mm.model;

import android.database.Cursor;
import android.database.MergeCursor;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bg {
    private d cie;
    private aa cvg;

    public bg(d dVar, aa aaVar) {
        this.cie = dVar;
        this.cvg = aaVar;
    }

    public final Cursor a(String str, String str2, List<String> list, boolean z) {
        return a(str, str2, null, list, false, false, z, 1, null);
    }

    public final Cursor a(String str, String str2, List<String> list, List<String> list2) {
        return a(str, str2, null, list, false, true, true, 2, list2);
    }

    public final Cursor b(String str, String str2, List<String> list, List<String> list2) {
        return a(str, str2, null, list, false, false, true, 2, list2);
    }

    public final Cursor a(String str, String str2, String str3, List<String> list, boolean z, boolean z2, boolean z3, int i, List<String> list2) {
        String str4 = "select * ,rowid from rcontact ";
        if (i == 2) {
            str4 = "select 2, *,rowid from rcontact ";
        }
        str4 = str4 + aa.e(str2, null, list) + aa.Md(str) + aa.bvz();
        v.v("Micro.SimpleSearchConversationModel", str4);
        Cursor rawQuery = this.cie.rawQuery(str4, null);
        if (z3) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (rawQuery.moveToNext()) {
                str4 = rawQuery.getString(rawQuery.getColumnIndex("username"));
                if (str4.endsWith("@chatroom")) {
                    arrayList2.add(str4);
                } else {
                    arrayList.add(str4);
                }
            }
            if (!(list2 == null || list2.size() == 0)) {
                arrayList.addAll(list2);
            }
            if (arrayList.size() != 0) {
                Cursor a = a(str, arrayList, arrayList2, null, list);
                return new MergeCursor(new Cursor[]{rawQuery, a});
            }
        }
        return rawQuery;
    }

    public final Cursor a(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, List<String> list) {
        String str2 = "select * ,rowid from rcontact " + aa.e("@all.contact.android", SQLiteDatabase.KeyEmpty, list) + a(str, (ArrayList) arrayList, (ArrayList) arrayList2, (ArrayList) arrayList3) + aa.bvz();
        v.v("Micro.SimpleSearchConversationModel", "roomsSql " + str2);
        return this.cie.rawQuery(str2, null);
    }

    private static String a(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3) {
        Iterator it;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" and (username in (");
        stringBuffer.append("select chatroomname from chatroom where ");
        if (!(arrayList2 == null || arrayList2.size() == 0)) {
            it = arrayList2.iterator();
            while (it.hasNext()) {
                stringBuffer.append("chatroomname != '" + ((String) it.next()) + "' and ");
            }
        }
        stringBuffer.append("(memberlist like '%" + str + "%'");
        it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(" or memberlist like '%" + ((String) it.next()) + "%'");
        }
        if (!(arrayList3 == null || arrayList3.size() == 0)) {
            it = arrayList3.iterator();
            while (it.hasNext()) {
                stringBuffer.append(" or chatroomname = '" + ((String) it.next()) + "'");
            }
        }
        stringBuffer.append(")))");
        return stringBuffer.toString();
    }
}
