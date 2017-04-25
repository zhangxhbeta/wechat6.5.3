package com.tencent.mm.plugin.favorite.b;

import android.database.Cursor;
import com.tencent.mm.plugin.favorite.b.v.a;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class j extends f<i> {
    public static final String[] cic = new String[]{f.a(i.chq, "FavItemInfo")};
    public static final String fKI = ("xml,edittime" + ",ext,favProto" + ",flag,fromUser" + ",id,itemStatus" + ",localId,localSeq" + ",realChatName,sourceCreateTime" + ",sourceId,sourceType" + ",toUser,type" + ",updateSeq,updateTime" + ",tagProto,sessionId" + ",datatotalsize,rowid");
    public d cie;

    public final /* synthetic */ boolean b(c cVar) {
        return c((i) cVar);
    }

    public j(d dVar) {
        super(dVar, i.chq, "FavItemInfo", null);
        this.cie = dVar;
    }

    public final i bB(long j) {
        Cursor query = this.cie.query("FavItemInfo", null, "localId=?", new String[]{String.valueOf(j)}, null, null, null);
        if (query.getCount() != 0) {
            i iVar = new i();
            query.moveToFirst();
            iVar.b(query);
            query.close();
            return iVar;
        }
        v.w("MicroMsg.FavItemInfoStorage", "klem getByLocalId:%d, no data", new Object[]{Long.valueOf(j)});
        query.close();
        return null;
    }

    public final i bC(long j) {
        Cursor rawQuery = this.cie.rawQuery("Select * from FavItemInfo where id = " + j, null);
        if (rawQuery.getCount() != 0) {
            i iVar = new i();
            rawQuery.moveToFirst();
            iVar.b(rawQuery);
            rawQuery.close();
            return iVar;
        }
        v.w("MicroMsg.FavItemInfoStorage", "klem getByFavId:%d, no data", new Object[]{Long.valueOf(j)});
        rawQuery.close();
        return null;
    }

    public final i sQ(String str) {
        Cursor query = this.cie.query("FavItemInfo", null, "sourceId=?", new String[]{str}, null, null, null);
        if (query.getCount() != 0) {
            i iVar = new i();
            query.moveToFirst();
            iVar.b(query);
            query.close();
            return iVar;
        }
        v.w("MicroMsg.FavItemInfoStorage", "klem getBySourceId:%s, no data", new Object[]{str});
        query.close();
        return null;
    }

    public final boolean c(i iVar) {
        Assert.assertTrue(iVar.field_localId > 0);
        if (iVar.field_favProto.mtP != null) {
            qg qgVar = iVar.field_favProto.mtP;
            if (qgVar.aYX <= 0) {
                v.w("MicroMsg.FavItemInfoStorage", "insert::favid %d favlocalid %d type %d, sourceTypeError %d", new Object[]{Integer.valueOf(iVar.field_id), Long.valueOf(iVar.field_localId), Integer.valueOf(iVar.field_type), Integer.valueOf(qgVar.aYX)});
                qgVar.uN(1);
            } else {
                qgVar.uN(qgVar.aYX);
            }
        }
        e(iVar);
        boolean a = a(iVar, false);
        if (a) {
            a(iVar.field_localId, 2, Long.valueOf(iVar.field_localId));
        }
        return a;
    }

    public final boolean a(i iVar, String... strArr) {
        if (iVar.field_favProto.mtP != null) {
            qg qgVar = iVar.field_favProto.mtP;
            if (qgVar.aYX <= 0) {
                v.w("MicroMsg.FavItemInfoStorage", "update::favid %d favlocalid %d type %d, sourceTypeError %d", new Object[]{Integer.valueOf(iVar.field_id), Long.valueOf(iVar.field_localId), Integer.valueOf(iVar.field_type), Integer.valueOf(qgVar.aYX)});
                qgVar.uN(1);
            } else {
                qgVar.uN(qgVar.aYX);
            }
        }
        e(iVar);
        boolean b = super.b(iVar, false, strArr);
        if (b) {
            a(iVar.field_localId, 3, Long.valueOf(iVar.field_localId));
        }
        v.d("MicroMsg.FavItemInfoStorage", "update result[%B]", new Object[]{Boolean.valueOf(b)});
        return b;
    }

    public final boolean k(long j, int i) {
        String str = "select count(updateTime) from FavItemInfo where updateTime < " + j;
        if (i != -1) {
            str = str + " and type = " + i;
        }
        Cursor rawQuery = this.cie.rawQuery(str, null);
        if (rawQuery == null) {
            return true;
        }
        rawQuery.moveToFirst();
        if (rawQuery.getInt(0) == 0) {
            rawQuery.close();
            return true;
        }
        rawQuery.close();
        return false;
    }

    public final LinkedList<Integer> l(long j, int i) {
        LinkedList<Integer> linkedList = new LinkedList();
        String str = "select id from FavItemInfo where updateTime >= " + j;
        if (i != -1) {
            str = str + " and type = " + i;
        }
        Cursor rawQuery = this.cie.rawQuery((str + " and updateSeq > localSeq") + " order by updateTime desc", null);
        if (rawQuery == null) {
            return linkedList;
        }
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            return linkedList;
        }
        while (rawQuery.moveToNext()) {
            linkedList.add(Integer.valueOf(rawQuery.getInt(0)));
        }
        rawQuery.close();
        return linkedList;
    }

    public final List<i> a(long j, int i, Set<Integer> set, a aVar) {
        if (set == null || !set.contains(Integer.valueOf(i))) {
            String str;
            List<i> arrayList = new ArrayList();
            String str2 = "select " + fKI + " from FavItemInfo where updateTime" + " >= " + j;
            if (i != -1) {
                str = str2 + " and type = " + i;
            } else if (set != null) {
                str = str2;
                for (Integer intValue : set) {
                    str = str + " and type != " + intValue.intValue();
                }
            } else {
                str = str2;
            }
            Cursor rawQuery = this.cie.rawQuery((str + " and itemStatus > 0") + " order by updateTime desc", null);
            if (rawQuery == null) {
                return arrayList;
            }
            if (rawQuery.getCount() == 0) {
                rawQuery.close();
                return arrayList;
            }
            while (rawQuery.moveToNext()) {
                i iVar = new i();
                iVar.b(rawQuery);
                if (aVar == null || !aVar.g(iVar)) {
                    arrayList.add(iVar);
                }
            }
            rawQuery.close();
            return arrayList;
        }
        v.w("MicroMsg.FavItemInfoStorage", "getList::block set contains target type, error, do return null");
        return null;
    }

    public final void r(int i, long j) {
        v.d("MicroMsg.FavItemInfoStorage", "setStatus status:%d,localId:%d", new Object[]{Integer.valueOf(i), Long.valueOf(j)});
        this.cie.dF("FavItemInfo", "update FavItemInfo set itemStatus = " + i + " where localId = " + j);
        Lf(String.valueOf(j));
    }

    public final void d(i iVar) {
        String str = "delete from FavItemInfo where localId = " + iVar.field_localId;
        v.i("MicroMsg.FavItemInfoStorage", "delete sql: " + str);
        this.cie.dF("FavItemInfo", str);
        a(iVar.field_localId, 5, Long.valueOf(iVar.field_localId));
    }

    public final List<i> alH() {
        List<i> list = null;
        Cursor rawQuery = this.cie.rawQuery("select " + fKI + " from FavItemInfo where itemStatus" + "=3 or itemStatus" + "=6 or itemStatus" + "=11 or itemStatus" + "=14 or itemStatus" + "=16 or itemStatus" + "=18", null);
        if (rawQuery != null) {
            if (rawQuery.getCount() == 0) {
                rawQuery.close();
            } else {
                list = new LinkedList();
                while (rawQuery.moveToNext()) {
                    i iVar = new i();
                    iVar.b(rawQuery);
                    list.add(iVar);
                }
                rawQuery.close();
            }
        }
        return list;
    }

    public final ArrayList<i> a(List<Long> list, List<i> list2, Set<Integer> set, a aVar) {
        if (list == null || list.size() == 0 || list.size() > 20) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select ").append(fKI).append(" from FavItemInfo where ");
        if (set != null && set.size() > 0) {
            stringBuffer.append("( 1=1");
            for (Integer append : set) {
                stringBuffer.append(" and type != ").append(append);
            }
            stringBuffer.append(") and ");
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                stringBuffer.append("( ");
            }
            if (i == size - 1) {
                stringBuffer.append("localId = ").append(list.get(i)).append(" )");
            } else {
                stringBuffer.append("localId = ").append(list.get(i)).append(" or ");
            }
        }
        stringBuffer.append(" order by updateTime desc");
        v.d("MicroMsg.FavItemInfoStorage", "get list by id list sql %s", new Object[]{stringBuffer.toString()});
        Cursor rawQuery = this.cie.rawQuery(r0, null);
        if (rawQuery == null) {
            return null;
        }
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            return null;
        }
        ArrayList<i> arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            i iVar;
            if (list2 == null || list2.isEmpty()) {
                iVar = new i();
            } else {
                iVar = (i) list2.remove(0);
            }
            iVar.b(rawQuery);
            if (aVar == null || !aVar.g(iVar)) {
                arrayList.add(iVar);
            } else {
                v.w("MicroMsg.FavItemInfoStorage", "id[%d] type[%d] match filter", new Object[]{Integer.valueOf(iVar.field_id), Integer.valueOf(iVar.field_type)});
            }
        }
        rawQuery.close();
        return arrayList;
    }

    public final boolean b(i iVar, String... strArr) {
        if (iVar.field_favProto.mtP != null) {
            qg qgVar = iVar.field_favProto.mtP;
            if (qgVar.aYX <= 0) {
                v.w("MicroMsg.FavItemInfoStorage", "update::favid %d favlocalid %d type %d, sourceTypeError %d", new Object[]{Integer.valueOf(iVar.field_id), Long.valueOf(iVar.field_localId), Integer.valueOf(iVar.field_type), Integer.valueOf(qgVar.aYX)});
                qgVar.uN(1);
            } else {
                qgVar.uN(qgVar.aYX);
            }
        }
        return super.b(iVar, false, strArr);
    }

    public final void alI() {
        v.i("MicroMsg.FavItemInfoStorage", "calDataBaseDataTotalLength");
        String str = "select " + fKI + " from FavItemInfo where ";
        String str2 = "";
        int[] iArr = v.fLD;
        int length = iArr.length;
        int i = 0;
        while (i < length) {
            i++;
            str2 = str2 + iArr[i] + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        str = str + "itemStatus in (" + str2 + ")";
        str2 = "";
        iArr = v.fLC;
        length = iArr.length;
        i = 0;
        while (i < length) {
            i++;
            str2 = str2 + iArr[i] + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        Cursor rawQuery = this.cie.rawQuery(str + " and type in (" + str2 + ")", null);
        if (rawQuery == null) {
            v.e("MicroMsg.FavItemInfoStorage", "calDataBaseDataTotalLength cu = null");
        } else if (rawQuery.getCount() == 0) {
            rawQuery.close();
            v.i("MicroMsg.FavItemInfoStorage", "calDataBaseDataTotalLength cu.getCount() = 0");
        } else {
            while (rawQuery.moveToNext()) {
                i iVar = new i();
                iVar.b(rawQuery);
                if (v.kF(iVar.field_itemStatus)) {
                    long j;
                    if (iVar.field_favProto != null) {
                        Iterator it = iVar.field_favProto.mtR.iterator();
                        j = 0;
                        while (it.hasNext()) {
                            j = ((pw) it.next()).msn + j;
                        }
                    } else {
                        j = 0;
                    }
                    iVar.field_datatotalsize = j;
                    a(iVar, "localId");
                }
            }
            rawQuery.close();
        }
    }

    public static long e(i iVar) {
        for (int i : v.fLC) {
            if (i == iVar.field_type) {
                long j;
                if (iVar.field_favProto != null) {
                    Iterator it = iVar.field_favProto.mtR.iterator();
                    j = 0;
                    while (it.hasNext()) {
                        j = ((pw) it.next()).msn + j;
                    }
                } else {
                    j = 0;
                }
                iVar.field_datatotalsize = j;
                v.i("MicroMsg.FavItemInfoStorage", "calFavItemInfoTotalLength id:%d,length:%d", new Object[]{Integer.valueOf(iVar.field_id), Long.valueOf(j)});
                return j;
            }
        }
        return 0;
    }
}
