package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bg.g;
import com.tencent.mm.e.a.ns;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.pluginsdk.j.q.d;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class l extends f<k> implements d {
    public static final String[] btd = new String[]{"CREATE INDEX IF NOT EXISTS serverSnsNameIndex ON SnsInfo ( snsId )", "CREATE INDEX IF NOT EXISTS serverSnsTimeHeadIndex ON SnsInfo ( head )", "DROP INDEX IF EXISTS serverSnsTimeIndex", "DROP INDEX IF EXISTS serverSnsTimeSourceTypeIndex", "CREATE INDEX IF NOT EXISTS snsMultiIndex1 ON SnsInfo ( createTime,snsId,sourceType,type)", "CREATE INDEX IF NOT EXISTS snsMultiIndex2 ON SnsInfo ( sourceType,type,userName)", "CREATE INDEX IF NOT EXISTS snsLocalflagIndex ON SnsInfo ( localFlag )"};
    public static final String[] cic = new String[]{f.a(k.chq, "SnsInfo")};
    private static String[] jBW = new String[]{"snsId", "userName", "localFlag", "createTime", "head", "localPrivate", Columns.TYPE, "sourceType", "likeFlag", "pravited", "stringSeq", "content", "attrBuf", "postBuf", "rowid"};
    public static String jBX;
    public static String jBY = " order by SnsInfo.createTime desc ,snsId desc";
    public static String jBZ = " order by SnsInfo.createTime asc ,snsId asc";
    private static String jCa = " order by SnsInfo.createTime asc ,snsId asc";
    private static String jCb = " order by SnsInfo.head desc ,SnsInfo.createTime desc ";
    private static String jCc = " order by SnsInfo.head desc ,snsId desc";
    public static String jCd;
    public static String jCe;
    protected static String jCf;
    protected static String jCg = " (sourceType & 2 != 0 ) and type < 21";
    private static String jCh;
    private static String jCi;
    private static String jCj;
    private static ArrayList<Integer> jCk = br(Arrays.asList(new Integer[]{Integer.valueOf(16), Integer.valueOf(32), Integer.valueOf(2), Integer.valueOf(8), Integer.valueOf(64), Integer.valueOf(128)}));
    private static ArrayList<Integer> jCl = br(Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(8)}));
    public com.tencent.mm.sdk.h.d cie;
    public boolean jBU;
    private int jBV;

    public final /* synthetic */ boolean a(long j, c cVar) {
        return b(j, (k) cVar);
    }

    public final /* synthetic */ boolean a(c cVar) {
        return z((k) cVar);
    }

    static {
        int i;
        jBX = "";
        jCd = null;
        jCe = null;
        jCf = " (sourceType & 2 != 0 ) ";
        jCh = null;
        jCi = null;
        jCj = null;
        jBX = "select ";
        for (i = 0; i < jBW.length; i++) {
            if (i < jBW.length - 1) {
                jBX += " " + jBW[i] + ",";
            } else {
                jBX += " " + jBW[i] + " ";
            }
        }
        v.i("MicroMsg.SnsInfoStorage", "TIMELINE_SELECT_BEGIN " + jBX);
        List arrayList = new ArrayList();
        Iterator it = jCk.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 16) != 0 && (i & 32) == 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        jCd = e(arrayList, "localFlag");
        v.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", new Object[]{jCd});
        arrayList.clear();
        it = jCk.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 32) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        jCe = e(arrayList, "localFlag");
        v.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", new Object[]{jCe});
        arrayList.clear();
        it = jCk.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 64) == 0 && (i & 32) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        jCj = e(arrayList, "localFlag");
        arrayList.clear();
        it = jCl.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 8) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        jCi = e(arrayList, "sourceType");
        v.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", new Object[]{jCi});
        arrayList.clear();
        it = jCl.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 2) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        jCf = e(arrayList, "sourceType");
        v.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", new Object[]{jCf});
        arrayList.clear();
        it = jCl.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 4) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        jCh = e(arrayList, "sourceType");
        v.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", new Object[]{jCh});
    }

    private static boolean aUU() {
        ns nsVar = new ns();
        a.nhr.z(nsVar);
        return nsVar.boM.boN;
    }

    public static String aUV() {
        if (aUU()) {
            return " (sourceType & 2 != 0 ) and type < 21";
        }
        return " (sourceType & 2 != 0 ) ";
    }

    private static String e(List<Integer> list, String str) {
        StringBuilder stringBuilder = new StringBuilder("(");
        stringBuilder.append(str + " in (");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            stringBuilder.append(it.next());
            if (it.hasNext()) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(")");
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private static ArrayList<Integer> br(List<Integer> list) {
        ArrayList arrayList = new ArrayList(list);
        Collection hashSet = new HashSet();
        ArrayList<Integer> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            Collection arrayList3 = new ArrayList();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                arrayList3.add(Integer.valueOf(((Integer) it2.next()).intValue() | num.intValue()));
            }
            hashSet.addAll(new HashSet(arrayList3));
            hashSet.add(num);
        }
        hashSet.add(Integer.valueOf(0));
        arrayList2.addAll(hashSet);
        return arrayList2;
    }

    public l(com.tencent.mm.sdk.h.d dVar) {
        boolean z;
        boolean z2 = true;
        super(dVar, k.chq, "SnsInfo", btd);
        this.cie = dVar;
        Cursor rawQuery = this.cie.rawQuery("select count(*) from SnsInfo where snsId > 0;", null);
        if (rawQuery == null || !rawQuery.moveToFirst() || rawQuery.getInt(0) <= 0) {
            rawQuery.close();
            z = false;
        } else {
            v.i("MicroMsg.SnsInfoStorage", "exsits snsId > 0  ,count is %d", new Object[]{Integer.valueOf(rawQuery.getInt(0))});
            rawQuery.close();
            z = true;
        }
        if (z) {
            z2 = false;
        }
        this.jBU = z2;
        this.jBV = 0;
        if (this.jBU) {
            v.i("MicroMsg.SnsInfoStorage", "all sndId < 0 ,so optimalizeForSnsId");
            return;
        }
        jBY = " order by SnsInfo.createTime desc ,case when snsId < 0 then 0 else 1 end ,  snsId desc";
        jBZ = " order by SnsInfo.createTime asc ,case when snsId < 0 then 0 else 1 end ,  snsId asc";
        jCb = " order by SnsInfo.head desc ,SnsInfo.createTime desc ";
        jCc = " order by SnsInfo.head desc ,case when snsId < 0 then 0 else 1 end ,  snsId desc";
    }

    public final int y(k kVar) {
        v.d("MicroMsg.SnsInfoStorage", "SnsInfo Insert");
        if (kVar == null) {
            return -1;
        }
        int insert = (int) this.cie.insert("SnsInfo", "", kVar.py());
        v.d("MicroMsg.SnsInfoStorage", "SnsInfo Insert result " + insert);
        return insert;
    }

    public final void c(String str, boolean z, String str2) {
        String str3 = ao(str, z) + " AND  (snsId != 0  ) ";
        if (By(str2)) {
            str3 = str3 + " AND " + BC(str2);
        }
        g(z, str3);
    }

    public final void g(boolean z, String str) {
        String str2 = "UPDATE SnsInfo SET sourceType = sourceType & " + ((z ? 4 : 8) ^ -1) + str;
        v.d("MicroMsg.SnsInfoStorage", "updateFilterUserName sql " + str2);
        this.cie.dF("SnsInfo", str2);
    }

    public final void aUW() {
        Bx(" where " + aUV() + " AND  (snsId != 0  ) ");
    }

    public final void Bw(String str) {
        if (By(str)) {
            Bx(" where " + BC(str) + " and " + aUV() + " and  (snsId != 0  ) ");
        }
    }

    public void Bx(String str) {
        String str2 = "UPDATE SnsInfo SET sourceType = sourceType & -3" + str;
        v.d("MicroMsg.SnsInfoStorage", "updateFilterTimeLine sql " + str2);
        this.cie.dF("SnsInfo", str2);
    }

    public final boolean cW(long j) {
        Cursor rawQuery = this.cie.rawQuery("select *,rowid from SnsInfo  where SnsInfo.snsId=" + j, null);
        int count = rawQuery.getCount();
        rawQuery.close();
        return count > 0;
    }

    public final boolean a(long j, k kVar) {
        if (cW(j)) {
            return b(j, kVar);
        }
        return y(kVar) != -1;
    }

    public static boolean By(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        return true;
    }

    public final String Bz(String str) {
        if (str == null || str.equals("")) {
            return " ";
        }
        if (this.jBU) {
            return " (snsId >= " + BA(be.lZ(str)) + " ) ";
        }
        return " (stringSeq >=\"" + be.lZ(str) + "\"  ) ";
    }

    public static long BA(String str) {
        v.i("MicroMsg.SnsInfoStorage", "seq %s to snsId %d ", new Object[]{str, Long.valueOf(new BigInteger(str).longValue())});
        return new BigInteger(str).longValue();
    }

    public final String BB(String str) {
        if (str == null || str.equals("")) {
            return " ";
        }
        if (this.jBU) {
            return " (snsId > " + BA(be.lZ(str)) + " ) ";
        }
        return " (stringSeq >\"" + be.lZ(str) + "\"  ) ";
    }

    public final String BC(String str) {
        if (str == null || str.equals("")) {
            return " ";
        }
        if (this.jBU) {
            return " (snsId < " + BA(be.lZ(str)) + " ) ";
        }
        return " (stringSeq <\"" + be.lZ(str) + "\"  ) ";
    }

    public static String ao(String str, boolean z) {
        String str2 = "";
        if (z) {
            return str2 + " WHERE " + jCh;
        }
        return (str2 + " WHERE SnsInfo.userName=\"" + be.lZ(str) + "\"") + " AND " + jCi;
    }

    public static String d(boolean z, String str, boolean z2) {
        return ("select *,rowid from SnsInfo " + ao(str, z2)) + " AND type in ( 1,2 , 3 , 4 , 18 , 5 , 12 , 9 , 14 , 15 , 13 , 21 , 25)";
    }

    public final long d(long j, int i, boolean z) {
        return c(aUY(), j, i, z);
    }

    public final long a(long j, int i, String str, boolean z) {
        return c(d(false, str, z), j, i, false);
    }

    private long c(String str, long j, int i, boolean z) {
        String str2;
        if (j != 0) {
            str2 = str + " AND SnsInfo.stringSeq < '" + i.zT(i.cE(j)) + "'";
        } else {
            str2 = str;
        }
        if (z) {
            str2 = str2 + " AND  (snsId != 0 ) ";
        }
        Cursor rawQuery = this.cie.rawQuery((str2 + jBY) + " limit " + i, null);
        if (rawQuery.moveToLast()) {
            k kVar = new k();
            kVar.b(rawQuery);
            rawQuery.close();
            return kVar.field_snsId;
        }
        rawQuery.close();
        return 0;
    }

    public static String aUX() {
        return "select *,rowid from SnsInfo  where " + " (sourceType & 2 != 0 ) ";
    }

    public static String aUY() {
        return "select *,rowid from SnsInfo  where " + aUV();
    }

    public static String aUZ() {
        return "select *,rowid from SnsInfo  where " + (aUU() ? jCg : jCf);
    }

    public static String qE(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select snsId from SnsInfo  where ").append(aUV()).append(" limit 3");
        return stringBuilder.toString();
    }

    public final Cursor a(boolean z, String str, int i, boolean z2, String str2) {
        String d = d(z, str, z2);
        if (By(str2)) {
            d = d + " AND " + Bz(str2);
        }
        if (z2) {
            d = d + jCb;
        } else {
            d = d + jCc;
        }
        if (i > 0) {
            d = d + " LIMIT " + i;
        }
        v.d("MicroMsg.SnsInfoStorage", "getCursorByUserName in gallery " + d);
        return this.cie.rawQuery(d, null);
    }

    public final Cursor BD(String str) {
        String aUY = aUY();
        if (By(str)) {
            aUY = aUY + " AND " + Bz(str);
        }
        aUY = aUY + jBY;
        v.d("MicroMsg.SnsInfoStorage", "getCursorForTimeLine " + aUY);
        return this.cie.rawQuery(aUY, null);
    }

    public final List<k> ap(String str, boolean z) {
        Cursor rawQuery = this.cie.rawQuery("select *,rowid from SnsInfo " + ao(str, z) + " AND type = 4", null);
        List<k> arrayList = new ArrayList();
        while (rawQuery != null && rawQuery.moveToNext()) {
            k kVar = new k();
            kVar.b(rawQuery);
            arrayList.add(kVar);
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return arrayList;
    }

    public final int BE(String str) {
        String aUY = aUY();
        if (By(str)) {
            aUY = aUY + " AND " + Bz(str);
        }
        String str2 = (aUY + " AND  (snsId != 0 ) ") + jBZ + " limit 1";
        Cursor rawQuery = this.cie.rawQuery(str2, null);
        int i = 0;
        if (rawQuery.moveToFirst()) {
            k kVar = new k();
            kVar.b(rawQuery);
            i = kVar.field_createTime;
        }
        rawQuery.close();
        v.i("MicroMsg.SnsInfoStorage", "getLastTime " + str2 + " createtime " + i);
        return i;
    }

    public final Cursor aX(String str, int i) {
        String str2 = (jBX + " from SnsInfo where ") + aUV();
        if (By(str)) {
            str2 = str2 + " AND " + Bz(str);
        }
        str2 = (((str2 + " AND createTime >= " + i) + " UNION ") + jBX + " from AdSnsInfo where createTime" + " > " + i) + jBY;
        v.d("MicroMsg.SnsInfoStorage", "getAdCursorForTimeLine " + str2 + " limtiSeq: " + str);
        return this.cie.rawQuery(str2, null);
    }

    public final void dc(long j) {
        int i;
        aa.getContext().getSharedPreferences(aa.bti(), 0).edit().putLong("check_trim_time", 0).commit();
        g wE = ad.wE();
        long er = wE.er(Thread.currentThread().getId());
        for (i = 0; ((long) i) < j; i++) {
            wE.dF("SnsInfo", "INSERT INTO SnsInfo VALUES(-69999999991777434909,'miaochanchan',2,1402026897,20140606,0,2,2,0,0,'0',X'0A143131373631303534303431393332313136373037120C6D69616F6368616E6368616E18002091F7C49C052A36E8A681E6849FE8B0A2E8BF99E4BBBDE5B7A5EFBC8CE8AEA9E68891E4B88DE4BC9AE69C89E5A29EE882A5E79A84E8BFB9E8B1A1E3808232180D0000000015000000001A0022002A0032003800480050003A0A0A0012001A0022002A0042080A0010021A0022004A0052005A006000680272007A2408001200180022002A0032003A080A0012001A00220042004A040800100052040A001200',X'08E3E5A48CEA8AEA9BA301120C6D69616F6368616E6368616E1A09E88B97E7B1B3E7B1B32091F7C49C052A04080012003000380040005000580068007000800101880100900100A00101B00100B80100',NULL);");
        }
        for (i = 0; ((long) i) < 20000; i++) {
            wE.dF("snsExtInfo3", String.format("INSERT INTO snsExtInfo3 VALUES('zeustest%d','afd',2,1402026897,'d', 0,1, 1, 1, 1, 'a', 'a', NULL);", new Object[]{Integer.valueOf(i)}));
        }
        for (i = 0; ((long) i) < 20000; i++) {
            wE.dF("snsComment", String.format("INSERT INTO snsComment VALUES(-69999999991777434909,0,2,1402026897,'d', 2,1, 'a', 'b', 1, NULL);", new Object[0]));
        }
        wE.es(er);
    }

    public final ArrayList<Long> aVa() {
        ArrayList<Long> arrayList = new ArrayList();
        Cursor query = this.cie.query("SnsInfo", new String[]{"*", "rowid"}, "createTime >=? AND " + jCj, new String[]{String.valueOf(((int) (System.currentTimeMillis() / 1000)) - 172800)}, null, null, "createTime ASC");
        try {
            if (query.moveToFirst()) {
                while (!query.isAfterLast()) {
                    k kVar = new k();
                    kVar.b(query);
                    if (kVar.jBI != -1 && kVar.field_userName.equals(k.xF())) {
                        arrayList.add(Long.valueOf((long) kVar.jBI));
                        v.d("MicroMsg.SnsInfoStorage", "getAllNeedResendSns, add snsInfo: " + kVar.aUL());
                    }
                    query.moveToNext();
                }
            }
            query.close();
            v.d("MicroMsg.SnsInfoStorage", "getAllNeedResendSns, resendList.size:%d", new Object[]{Integer.valueOf(arrayList.size())});
            return arrayList;
        } catch (Throwable th) {
            query.close();
        }
    }

    public final boolean qF(int i) {
        return qG(i) != null;
    }

    public final boolean z(k kVar) {
        if (kVar.qC(32)) {
            return ad.aSF().a(kVar.aUS());
        }
        boolean z = this.cie.replace("SnsInfo", "", kVar.py()) > 0;
        v.d("MicroMsg.SnsInfoStorage", "SnsInfo replace result " + z);
        return z;
    }

    public final k dd(long j) {
        k kVar = new k();
        Cursor rawQuery = this.cie.rawQuery("select *,rowid from SnsInfo  where SnsInfo.snsId=" + j + " limit 1", null);
        if (rawQuery.moveToFirst()) {
            kVar.b(rawQuery);
            rawQuery.close();
            return kVar;
        }
        rawQuery.close();
        return null;
    }

    public final k Bp(String str) {
        if (s.zG(str)) {
            return dd(s.BK(str));
        }
        c cV = ad.aSF().cV(s.BK(str));
        if (cV != null) {
            return cV.aUr();
        }
        return null;
    }

    public final k qG(int i) {
        k kVar = new k();
        Cursor rawQuery = this.cie.rawQuery("select *,rowid from SnsInfo  where SnsInfo.rowid=" + i, null);
        if (rawQuery.getCount() != 0) {
            rawQuery.moveToFirst();
            kVar.b(rawQuery);
            rawQuery.close();
            return kVar;
        }
        rawQuery.close();
        return null;
    }

    public final k Bq(String str) {
        if (s.zG(str)) {
            return qG(s.BL(str));
        }
        c qB = ad.aSF().qB(s.BL(str));
        if (qB != null) {
            return qB.aUr();
        }
        return null;
    }

    public final boolean b(long j, k kVar) {
        ContentValues py = kVar.py();
        py.remove("rowid");
        if (this.cie.update("SnsInfo", py, "snsId=?", new String[]{String.valueOf(j)}) > 0) {
            return true;
        }
        return false;
    }

    public final boolean a(String str, k kVar) {
        if (s.zG(str)) {
            return b(s.BK(str), kVar);
        }
        return ad.aSF().b(s.BK(str), kVar.aUS());
    }

    public final int b(int i, k kVar) {
        ContentValues py = kVar.py();
        py.remove("rowid");
        return this.cie.update("SnsInfo", py, "rowid=?", new String[]{String.valueOf(i)});
    }

    public final boolean delete(long j) {
        int delete = this.cie.delete("SnsInfo", "snsId=?", new String[]{String.valueOf(j)});
        v.d("MicroMsg.SnsInfoStorage", "del msg " + j + " res " + delete);
        if (delete > 0) {
            return true;
        }
        return false;
    }

    public final boolean qH(int i) {
        if (this.cie.delete("SnsInfo", "rowid=?", new String[]{String.valueOf(i)}) > 0) {
            return true;
        }
        return false;
    }
}
