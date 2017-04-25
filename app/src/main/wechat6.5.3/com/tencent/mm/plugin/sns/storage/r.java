package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.pluginsdk.j.q.g;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class r extends f<q> implements g {
    public static final String[] cic = new String[]{f.a(q.chq, "snsTagInfo2")};
    public d cie;

    public r(d dVar) {
        super(dVar, q.chq, "snsTagInfo2", null);
        this.cie = dVar;
    }

    public static String aVh() {
        return "select tagId, tagName, count, rowid from snsTagInfo2";
    }

    public final q df(long j) {
        String stringBuilder = new StringBuilder("select *, rowid from snsTagInfo2 where tagId = ? ").toString();
        Cursor rawQuery = this.cie.rawQuery(stringBuilder, new String[]{String.valueOf(j)});
        q qVar = new q();
        if (rawQuery.getCount() > 0) {
            rawQuery.moveToFirst();
            qVar.b(rawQuery);
        }
        rawQuery.close();
        return qVar;
    }

    public final List<String> dg(long j) {
        q df = df(j);
        if (df.field_memberList == null || df.field_memberList.equals("")) {
            return new ArrayList();
        }
        return be.g(df.field_memberList.split(","));
    }

    public final String dh(long j) {
        return df(j).field_tagName;
    }

    public final List<Long> aVi() {
        Cursor query = this.cie.query("snsTagInfo2", new String[]{"tagId"}, null, null, null, null, null);
        query.moveToFirst();
        List<Long> linkedList = new LinkedList();
        int count = query.getCount();
        for (int i = 0; i < count; i++) {
            linkedList.add(Long.valueOf(query.getLong(0)));
            query.moveToNext();
        }
        query.close();
        return linkedList;
    }

    public final boolean a(q qVar) {
        boolean z = false;
        if (qVar.field_tagId == 0) {
            return false;
        }
        long j = qVar.field_tagId;
        String stringBuilder = new StringBuilder("select *, rowid from snsTagInfo2 where tagId = ? ").toString();
        Cursor rawQuery = this.cie.rawQuery(stringBuilder, new String[]{String.valueOf(j)});
        if (rawQuery.getCount() > 0) {
            z = true;
        }
        rawQuery.close();
        if (z) {
            super.a(qVar);
        } else {
            super.b(qVar);
        }
        return true;
    }

    public final int di(long j) {
        return this.cie.delete("snsTagInfo2", " tagId = ? ", new String[]{String.valueOf(j)});
    }

    public final boolean j(long j, String str) {
        String str2 = "select tagId, tagName, count, rowid from snsTagInfo2 where tagId > 5" + " AND  tagName  =\"" + be.lZ(str) + "\" AND  tagId != " + j;
        v.d("MicroMsg.SnsTagInfoStorage", "isTagNameExist " + str2);
        Cursor rawQuery = this.cie.rawQuery(str2, null);
        int count = rawQuery.getCount();
        rawQuery.close();
        return count > 0;
    }

    public final Cursor getCursor() {
        return this.cie.rawQuery(new StringBuilder("select *, rowid from snsTagInfo2 where tagId > 5").toString(), null);
    }

    public final boolean z(String str, long j) {
        q df = df(5);
        if (be.kS(df.field_memberList)) {
            return false;
        }
        return be.g(df.field_memberList.split(",")).contains(str);
    }

    public final boolean aVj() {
        if (aVi().size() == 0) {
            return false;
        }
        return true;
    }
}
