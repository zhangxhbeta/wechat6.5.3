package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.bg.g;
import com.tencent.mm.e.a.pw;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class z extends f<w> implements com.tencent.mm.bg.f.a {
    public static final String[] cic = new String[]{f.a(w.chq, "ContactLabel")};
    private d cie;
    private HashMap<String, int[]> num;
    public HashMap<Integer, ArrayList<String>> nun;

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] nuo = new int[a.bvx().length];

        static {
            try {
                nuo[a.nup - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                nuo[a.nuq - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                nuo[a.nur - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public enum a {
        ;

        public static int[] bvx() {
            return (int[]) nus.clone();
        }

        static {
            nup = 1;
            nuq = 2;
            nur = 3;
            nus = new int[]{nup, nuq, nur};
        }
    }

    public final /* synthetic */ boolean a(c cVar) {
        w wVar = (w) cVar;
        boolean a = super.a(wVar);
        if (a) {
            Lf(a("replace", wVar));
        }
        avF();
        return a;
    }

    public final /* synthetic */ boolean a(c cVar, String[] strArr) {
        return b(true, (w) cVar, strArr);
    }

    public final /* synthetic */ boolean b(c cVar) {
        return a(true, (w) cVar);
    }

    public final /* synthetic */ boolean c(c cVar, String[] strArr) {
        return a(true, (w) cVar, strArr);
    }

    public z(d dVar) {
        this(dVar, w.chq, "ContactLabel");
    }

    private z(d dVar, com.tencent.mm.sdk.h.c.a aVar, String str) {
        super(dVar, aVar, str, null);
        this.num = null;
        this.nun = null;
        this.cie = dVar;
        dVar.dF("ContactLabel", "CREATE INDEX IF NOT EXISTS  contact_label_createtime_index ON ContactLabel ( createTime )");
    }

    public final int a(com.tencent.mm.bg.f fVar) {
        if (fVar != null) {
            this.cie = fVar;
        }
        return 0;
    }

    public final ArrayList<String> bvt() {
        ArrayList<String> arrayList = null;
        long Ni = be.Ni();
        Cursor query = this.cie.query("ContactLabel", new String[]{"labelName"}, null, null, null, null, "createTime ASC ");
        if (query != null) {
            arrayList = new ArrayList();
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            query.close();
            v.i("MicroMsg.Label.ContactLabelStorage", "getAllLabel time:%s count:%s stack:%s", new Object[]{Long.valueOf(be.ay(Ni)), Integer.valueOf(arrayList.size()), be.bur()});
        }
        return arrayList;
    }

    public final ArrayList<w> bvu() {
        ArrayList<w> arrayList = null;
        long Ni = be.Ni();
        Cursor rawQuery = this.cie.rawQuery("select * from ContactLabel order by createTime ASC ", null);
        if (rawQuery != null) {
            arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                w wVar = new w();
                wVar.b(rawQuery);
                arrayList.add(wVar);
            }
            rawQuery.close();
            v.i("MicroMsg.Label.ContactLabelStorage", "getAllContactLable time:%s count:%s stack:%s", new Object[]{Long.valueOf(be.ay(Ni)), Integer.valueOf(arrayList.size()), be.bur()});
        }
        return arrayList;
    }

    public final void avF() {
        v.v("MicroMsg.Label.ContactLabelStorage", "cleanCache %s", new Object[]{be.bur()});
        this.num = null;
        this.nun = null;
    }

    public final void bvv() {
        if (this.num == null || this.nun == null) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            long Ni = be.Ni();
            Cursor rawQuery = this.cie.rawQuery("select username , contactLabelIds from rcontact where (type & " + com.tencent.mm.i.a.tE() + " !=0 ) and ( contactLabelIds != '') ;", null);
            if (rawQuery == null) {
                this.num = hashMap;
                this.nun = hashMap2;
                return;
            }
            while (rawQuery.moveToNext()) {
                String string = rawQuery.getString(0);
                if (!be.kS(string)) {
                    String[] split = be.ma(rawQuery.getString(1)).split(",");
                    if (split != null && split.length > 0) {
                        Object obj = new int[split.length];
                        for (int i = 0; i < split.length; i++) {
                            obj[i] = be.getInt(split[i], -1);
                            if (hashMap2.containsKey(Integer.valueOf(obj[i]))) {
                                ((ArrayList) hashMap2.get(Integer.valueOf(obj[i]))).add(string);
                            } else {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(string);
                                hashMap2.put(Integer.valueOf(obj[i]), arrayList);
                            }
                        }
                        hashMap.put(string, obj);
                    }
                }
            }
            rawQuery.close();
            v.i("MicroMsg.Label.ContactLabelStorage", "checkRebuildCache time:%s user:%s label:%s stack:%s", new Object[]{Long.valueOf(be.ay(Ni)), Integer.valueOf(hashMap.size()), Integer.valueOf(hashMap2.size()), be.bur()});
            this.num = hashMap;
            this.nun = hashMap2;
        }
    }

    public final ArrayList<String> LN(String str) {
        int i = -1;
        long Ni = be.Ni();
        int i2 = be.getInt(str, -1);
        if (i2 == -1) {
            v.e("MicroMsg.Label.ContactLabelStorage", "getUserNameListById  failed id:%s", new Object[]{str});
            return null;
        }
        bvv();
        ArrayList<String> arrayList = (ArrayList) this.nun.get(Integer.valueOf(i2));
        String str2 = "MicroMsg.Label.ContactLabelStorage";
        String str3 = "getUserNameListById time:%s id:%s count:%s stack:%s";
        Object[] objArr = new Object[4];
        objArr[0] = Long.valueOf(be.ay(Ni));
        objArr[1] = str;
        if (arrayList != null) {
            i = arrayList.size();
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = be.bur();
        v.i(str2, str3, objArr);
        return arrayList;
    }

    public final ArrayList<String> k(String str, List<String> list) {
        Exception e;
        Throwable th;
        int i = 0;
        v.d("MicroMsg.Label.ContactLabelStorage", "cpan[query] SQL:%s", new Object[]{"select labelName from ContactLabel where labelName like ? or labelPYFull like ? or labelPYShort like ?  order by createTime ASC "});
        Cursor rawQuery;
        try {
            rawQuery = this.cie.rawQuery("select labelName from ContactLabel where labelName like ? or labelPYFull like ? or labelPYShort like ?  order by createTime ASC ", new String[]{"%" + str + "%", "%" + str + "%", "%" + str + "%"});
            if (rawQuery != null) {
                try {
                    if (rawQuery.moveToFirst()) {
                        ArrayList<String> arrayList = new ArrayList();
                        int count = rawQuery.getCount();
                        while (i < count) {
                            rawQuery.moveToPosition(i);
                            String string = rawQuery.getString(rawQuery.getColumnIndex("labelName"));
                            if (list == null || list.size() <= 0 || !list.contains(string)) {
                                arrayList.add(string);
                            }
                            i++;
                        }
                        if (rawQuery == null) {
                            return arrayList;
                        }
                        rawQuery.close();
                        return arrayList;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        v.w("MicroMsg.Label.ContactLabelStorage", "cpan[query] exception %s", new Object[]{e.toString()});
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        throw th;
                    }
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e3) {
            e = e3;
            rawQuery = null;
            v.w("MicroMsg.Label.ContactLabelStorage", "cpan[query] exception %s", new Object[]{e.toString()});
            if (rawQuery != null) {
                rawQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return null;
    }

    public final ArrayList<String> D(String[] strArr) {
        Exception e;
        Throwable th;
        int i = 0;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        int length = strArr.length;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from ContactLabel where labelID");
        stringBuilder.append(" in ( ");
        for (int i2 = 0; i2 < length; i2++) {
            stringBuilder.append("'" + strArr[i2] + "'");
            if (i2 < length - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(" )");
        v.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrList] SQL:%s", new Object[]{stringBuilder.toString()});
        Cursor rawQuery;
        try {
            rawQuery = this.cie.rawQuery(stringBuilder.toString(), null);
            if (rawQuery != null) {
                try {
                    if (rawQuery.moveToFirst()) {
                        ArrayList<String> arrayList = new ArrayList();
                        int count = rawQuery.getCount();
                        while (i < count) {
                            rawQuery.moveToPosition(i);
                            arrayList.add(rawQuery.getString(rawQuery.getColumnIndex("labelName")));
                            i++;
                        }
                        v.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrList] resut size:%d", new Object[]{Integer.valueOf(count)});
                        if (rawQuery == null) {
                            return arrayList;
                        }
                        rawQuery.close();
                        return arrayList;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        v.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrList] exception:%s", new Object[]{e.toString()});
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        throw th;
                    }
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e3) {
            e = e3;
            rawQuery = null;
            v.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrList] exception:%s", new Object[]{e.toString()});
            if (rawQuery != null) {
                rawQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return null;
    }

    public final ArrayList<String> Y(ArrayList<String> arrayList) {
        Cursor rawQuery;
        Exception e;
        Throwable th;
        int i = 0;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        int size = arrayList.size();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from ContactLabel where labelName");
        stringBuilder.append(" in ( ");
        for (int i2 = 0; i2 < size; i2++) {
            stringBuilder.append("\"" + ((String) arrayList.get(i2)) + "\"");
            if (i2 < size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(" )");
        stringBuilder.append(" and isTemporary=0");
        v.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIDList] SQL:%s", new Object[]{stringBuilder.toString()});
        try {
            rawQuery = this.cie.rawQuery(stringBuilder.toString(), null);
            if (rawQuery != null) {
                try {
                    if (rawQuery.moveToFirst()) {
                        ArrayList<String> arrayList2 = new ArrayList();
                        size = rawQuery.getCount();
                        while (i < size) {
                            rawQuery.moveToPosition(i);
                            arrayList2.add(rawQuery.getString(rawQuery.getColumnIndex("labelID")));
                            i++;
                        }
                        v.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIDList] resut size:%d", new Object[]{Integer.valueOf(size)});
                        if (rawQuery == null) {
                            return arrayList2;
                        }
                        rawQuery.close();
                        return arrayList2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        v.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIDList] exception:%s", new Object[]{e.toString()});
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        throw th;
                    }
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e3) {
            e = e3;
            rawQuery = null;
            v.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIDList] exception:%s", new Object[]{e.toString()});
            if (rawQuery != null) {
                rawQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return null;
    }

    private boolean a(boolean z, w wVar) {
        boolean b = super.b(wVar);
        if (b && z) {
            Lf(a("insert", wVar));
        }
        return b;
    }

    public final boolean hc(String str) {
        int delete;
        v.i("MicroMsg.Label.ContactLabelStorage", "cpan[delete] labelID:%s", new Object[]{str});
        v.d("MicroMsg.Label.ContactLabelStorage", "cpan[query] SQL:%s", new Object[]{"labelID =? "});
        try {
            delete = this.cie.delete("ContactLabel", "labelID =? ", new String[]{str});
        } catch (Exception e) {
            v.w("MicroMsg.Label.ContactLabelStorage", "cpan[delete] exception %s", new Object[]{e.toString()});
            delete = -1;
        }
        if (delete > 0) {
            return true;
        }
        return false;
    }

    public boolean a(boolean z, w wVar, String... strArr) {
        boolean c = super.c(wVar, strArr);
        if (c && z) {
            Lf(a("delete", wVar));
            bvw();
        }
        avF();
        return c;
    }

    public boolean b(boolean z, w wVar, String... strArr) {
        boolean a = super.a(wVar, strArr);
        if (a && z) {
            Lf(a("update", wVar));
        }
        avF();
        return a;
    }

    public final boolean bT(List<w> list) {
        if (list.size() <= 0) {
            v.i("MicroMsg.Label.ContactLabelStorage", "cpan[insertAddLabel] list is null.");
        } else {
            long er;
            g gVar;
            if (this.cie instanceof g) {
                g gVar2 = (g) this.cie;
                er = gVar2.er(Thread.currentThread().getId());
                v.i("MicroMsg.Label.ContactLabelStorage", "begin insertOrUpdateList in a transaction, ticket = %d", new Object[]{Long.valueOf(er)});
                gVar = gVar2;
            } else {
                gVar = null;
                er = -1;
            }
            int size = list.size();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                String c = c((w) list.get(i));
                if (!be.kS(c)) {
                    hc(c);
                }
            }
            if (gVar != null) {
                gVar.es(er);
                v.i("MicroMsg.Label.ContactLabelStorage", "end deleteLocalLabel transaction");
            }
            avF();
        }
        return false;
    }

    public final boolean bU(List<w> list) {
        if (list.size() <= 0) {
            v.i("MicroMsg.Label.ContactLabelStorage", "cpan[insertOrUpdateList] list is null.");
            return false;
        }
        long er;
        g gVar;
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        if (this.cie instanceof g) {
            g gVar2 = (g) this.cie;
            er = gVar2.er(Thread.currentThread().getId());
            v.i("MicroMsg.Label.ContactLabelStorage", "begin insertOrUpdateList in a transaction, ticket = %d", new Object[]{Long.valueOf(er)});
            gVar = gVar2;
        } else {
            gVar = null;
            er = -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            w wVar = (w) list.get(i);
            if (wVar != null) {
                switch (AnonymousClass1.nuo[b(wVar) - 1]) {
                    case 1:
                        break;
                    case 2:
                        b(false, wVar, "labelID");
                        arrayList2.add(wVar);
                        break;
                    case 3:
                        wVar.field_createTime = System.currentTimeMillis();
                        a(false, wVar);
                        arrayList.add(wVar);
                        break;
                    default:
                        v.w("MicroMsg.Label.ContactLabelStorage", "cpan[insertOrUpdateList] unknow result.");
                        break;
                }
            }
        }
        if (gVar != null) {
            gVar.es(er);
            v.i("MicroMsg.Label.ContactLabelStorage", "end insertOrUpdateList transaction");
        }
        if (arrayList.size() > 0) {
            Lf(l("insert", arrayList));
        }
        if (arrayList2.size() > 0) {
            Lf(l("update", arrayList2));
        }
        avF();
        return false;
    }

    public final String vu(String str) {
        Exception e;
        Throwable th;
        Cursor query;
        try {
            query = this.cie.query("ContactLabel", new String[]{"labelName"}, "labelID =?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndex("labelName"));
                        v.i("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrById] label string is %s", new Object[]{string});
                        if (query == null) {
                            return string;
                        }
                        query.close();
                        return string;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        v.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrById] exception %s", new Object[]{e.toString()});
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
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            v.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrById] exception %s", new Object[]{e.toString()});
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
        return null;
    }

    public final String vv(String str) {
        Cursor query;
        Exception e;
        Throwable th;
        try {
            query = this.cie.query("ContactLabel", new String[]{"labelID"}, "labelName =?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndex("labelID"));
                        v.i("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] label id is %s", new Object[]{string});
                        if (query == null) {
                            return string;
                        }
                        query.close();
                        return string;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        v.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] exception %s", new Object[]{e.toString()});
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
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            v.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] exception %s", new Object[]{e.toString()});
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
        return null;
    }

    public final w LO(String str) {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        Cursor query;
        try {
            query = this.cie.query("ContactLabel", new String[]{"labelID", "createTime", "isTemporary", "labelName", "labelPYFull", "labelPYShort"}, "labelName =?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        w wVar = new w();
                        wVar.b(query);
                        if (query == null) {
                            return wVar;
                        }
                        query.close();
                        return wVar;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        v.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] exception %s", new Object[]{e.toString()});
                        if (query != null) {
                            query.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            v.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] exception %s", new Object[]{e.toString()});
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return null;
    }

    public final w LP(String str) {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        Cursor query;
        try {
            query = this.cie.query("ContactLabel", new String[]{"labelID", "createTime", "isTemporary", "labelName", "labelPYFull", "labelPYShort"}, "labelID =?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        w wVar = new w();
                        wVar.b(query);
                        if (query == null) {
                            return wVar;
                        }
                        query.close();
                        return wVar;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        v.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelByID] exception %s", new Object[]{e.toString()});
                        if (query != null) {
                            query.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            v.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelByID] exception %s", new Object[]{e.toString()});
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return null;
    }

    private int b(w wVar) {
        Cursor cursor = null;
        try {
            cursor = this.cie.rawQuery("select * from ContactLabel where labelID=?", new String[]{wVar.field_labelID});
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return a.nur;
            }
            int i;
            if (wVar.field_labelName.equalsIgnoreCase(be.ah(cursor.getString(cursor.getColumnIndex("labelName")), ""))) {
                i = a.nup;
                if (cursor == null) {
                    return i;
                }
                cursor.close();
                return i;
            }
            i = a.nuq;
            if (cursor == null) {
                return i;
            }
            cursor.close();
            return i;
        } catch (Exception e) {
            v.w("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] exception %s", new Object[]{e.toString()});
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private String c(w wVar) {
        Exception e;
        Throwable th;
        String str = null;
        Cursor rawQuery;
        try {
            rawQuery = this.cie.rawQuery("select * from ContactLabel where labelName=? and isTemporary =?", new String[]{wVar.field_labelName, "1"});
            if (rawQuery != null) {
                try {
                    if (rawQuery.moveToFirst()) {
                        boolean equalsIgnoreCase = wVar.field_labelName.equalsIgnoreCase(be.ah(rawQuery.getString(rawQuery.getColumnIndex("labelName")), ""));
                        v.i("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] itemname:%s dbname:%s", new Object[]{wVar.field_labelName, r1});
                        if (equalsIgnoreCase) {
                            str = rawQuery.getString(rawQuery.getColumnIndex("labelID"));
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            return str;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        v.w("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] exception %s", new Object[]{e.toString()});
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        throw th;
                    }
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e3) {
            e = e3;
            rawQuery = null;
            v.w("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] exception %s", new Object[]{e.toString()});
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            rawQuery = null;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    private static String a(String str, w wVar) {
        if (wVar == null) {
            return null;
        }
        List arrayList = new ArrayList();
        arrayList.add(wVar);
        return l(str, arrayList);
    }

    private static String l(String str, List<w> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" ");
        if (list == null || list.size() <= 0) {
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            w wVar = (w) list.get(i);
            if (wVar != null) {
                stringBuilder.append(wVar.field_labelID);
                if (i < size - 1) {
                    stringBuilder.append(" ");
                }
            }
        }
        v.i("MicroMsg.Label.ContactLabelStorage", "cpan[genNotifyString] event:%s", new Object[]{stringBuilder.toString()});
        return stringBuilder.toString();
    }

    private static void bvw() {
        v.i("MicroMsg.Label.ContactLabelStorage", "cpan[publishUpdateSearchIndexEvent]");
        pw pwVar = new pw();
        pwVar.brg.brh = 3000;
        com.tencent.mm.sdk.c.a.nhr.z(pwVar);
    }

    public final boolean bV(List<w> list) {
        if (list == null || list.size() <= 0) {
            v.w("MicroMsg.Label.ContactLabelStorage", "cpan[deleteList] list is null.");
            return false;
        }
        long er;
        g gVar;
        if (this.cie instanceof g) {
            g gVar2 = (g) this.cie;
            er = gVar2.er(Thread.currentThread().getId());
            v.i("MicroMsg.Label.ContactLabelStorage", "begin deleteList in a transaction, ticket = %d", new Object[]{Long.valueOf(er)});
            gVar = gVar2;
        } else {
            gVar = null;
            er = -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(false, (w) list.get(i), "labelID");
        }
        if (gVar != null) {
            gVar.es(er);
            v.i("MicroMsg.Label.ContactLabelStorage", "end insertOrUpdateList transaction");
        }
        Lf(l("delete", list));
        bvw();
        return true;
    }

    public final ArrayList<w> bW(List<w> list) {
        Exception e;
        Throwable th;
        int i = 0;
        if (list.size() <= 0) {
            return null;
        }
        int size = list.size();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from ContactLabel where labelID");
        stringBuilder.append(" not in ( ");
        for (int i2 = 0; i2 < size; i2++) {
            stringBuilder.append("'" + ((w) list.get(i2)).field_labelID + "'");
            if (i2 < size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(" )");
        stringBuilder.append(" and isTemporary=0");
        v.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdListNoInList] SQL:%s", new Object[]{stringBuilder.toString()});
        Cursor rawQuery;
        try {
            rawQuery = this.cie.rawQuery(stringBuilder.toString(), null);
            if (rawQuery != null) {
                try {
                    if (rawQuery.moveToFirst()) {
                        ArrayList<w> arrayList = new ArrayList();
                        size = rawQuery.getCount();
                        while (i < size) {
                            rawQuery.moveToPosition(i);
                            w wVar = new w();
                            wVar.b(rawQuery);
                            arrayList.add(wVar);
                            i++;
                        }
                        v.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdListNoInList] resut size:%d", new Object[]{Integer.valueOf(size)});
                        if (rawQuery == null) {
                            return arrayList;
                        }
                        rawQuery.close();
                        return arrayList;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        v.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdListNoInList] exception:%s", new Object[]{e.toString()});
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        throw th;
                    }
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e3) {
            e = e3;
            rawQuery = null;
            v.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdListNoInList] exception:%s", new Object[]{e.toString()});
            if (rawQuery != null) {
                rawQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return null;
    }
}
