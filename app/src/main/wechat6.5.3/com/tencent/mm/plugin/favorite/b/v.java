package com.tencent.mm.plugin.favorite.b;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.a.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.i;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.storage.u;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class v {
    private static long fLA = 0;
    public static List<Integer> fLB = new LinkedList();
    public static final int[] fLC = new int[]{2, 3, 4, 8, 14, 16, 18};
    public static final int[] fLD = new int[]{10, 8, 7};
    private static Map<String, Integer> fLE;
    private static Map<Long, Long> fLy = new HashMap();
    private static Map<Long, Long> fLz = new HashMap();

    public interface a {
        boolean g(i iVar);
    }

    static {
        fLE = new HashMap();
        Map hashMap = new HashMap();
        fLE = hashMap;
        hashMap.put("avi", Integer.valueOf(2131165244));
        fLE.put("m4v", Integer.valueOf(2131165244));
        fLE.put("vob", Integer.valueOf(2131165244));
        fLE.put("mpeg", Integer.valueOf(2131165244));
        fLE.put("mpe", Integer.valueOf(2131165244));
        fLE.put("asx", Integer.valueOf(2131165244));
        fLE.put("asf", Integer.valueOf(2131165244));
        fLE.put("f4v", Integer.valueOf(2131165244));
        fLE.put("flv", Integer.valueOf(2131165244));
        fLE.put("mkv", Integer.valueOf(2131165244));
        fLE.put("wmv", Integer.valueOf(2131165244));
        fLE.put("wm", Integer.valueOf(2131165244));
        fLE.put("3gp", Integer.valueOf(2131165244));
        fLE.put("mp4", Integer.valueOf(2131165244));
        fLE.put("rmvb", Integer.valueOf(2131165244));
        fLE.put("rm", Integer.valueOf(2131165244));
        fLE.put("ra", Integer.valueOf(2131165244));
        fLE.put("ram", Integer.valueOf(2131165244));
        fLE.put("mp3pro", Integer.valueOf(2131165232));
        fLE.put("vqf", Integer.valueOf(2131165232));
        fLE.put("cd", Integer.valueOf(2131165232));
        fLE.put("md", Integer.valueOf(2131165232));
        fLE.put("mod", Integer.valueOf(2131165232));
        fLE.put("vorbis", Integer.valueOf(2131165232));
        fLE.put("au", Integer.valueOf(2131165232));
        fLE.put("amr", Integer.valueOf(2131165232));
        fLE.put("silk", Integer.valueOf(2131165232));
        fLE.put("wma", Integer.valueOf(2131165232));
        fLE.put("mmf", Integer.valueOf(2131165232));
        fLE.put("mid", Integer.valueOf(2131165232));
        fLE.put("midi", Integer.valueOf(2131165232));
        fLE.put("mp3", Integer.valueOf(2131165232));
        fLE.put("aac", Integer.valueOf(2131165232));
        fLE.put("ape", Integer.valueOf(2131165232));
        fLE.put("aiff", Integer.valueOf(2131165232));
        fLE.put("aif", Integer.valueOf(2131165232));
        fLE.put("jfif", Integer.valueOf(2130837647));
        fLE.put("tiff", Integer.valueOf(2130837647));
        fLE.put("tif", Integer.valueOf(2130837647));
        fLE.put("jpe", Integer.valueOf(2130837647));
        fLE.put("dib", Integer.valueOf(2130837647));
        fLE.put("jpeg", Integer.valueOf(2130837647));
        fLE.put("jpg", Integer.valueOf(2130837647));
        fLE.put("png", Integer.valueOf(2130837647));
        fLE.put("bmp", Integer.valueOf(2130837647));
        fLE.put("gif", Integer.valueOf(2130837647));
        fLE.put("rar", Integer.valueOf(2131165522));
        fLE.put("zip", Integer.valueOf(2131165522));
        fLE.put("7z", Integer.valueOf(2131165522));
        fLE.put("iso", Integer.valueOf(2131165522));
        fLE.put("cab", Integer.valueOf(2131165522));
        fLE.put("doc", Integer.valueOf(2131165520));
        fLE.put("docx", Integer.valueOf(2131165520));
        fLE.put("ppt", Integer.valueOf(2131165514));
        fLE.put("pptx", Integer.valueOf(2131165514));
        fLE.put("xls", Integer.valueOf(2131165521));
        fLE.put("xlsx", Integer.valueOf(2131165521));
        fLE.put("txt", Integer.valueOf(2131165516));
        fLE.put("rtf", Integer.valueOf(2131165516));
        fLE.put("pdf", Integer.valueOf(2131165513));
        fLE.put("unknown", Integer.valueOf(2131165517));
    }

    public static void bF(long j) {
        if (!fLy.containsKey(Long.valueOf(j))) {
            fLy.put(Long.valueOf(j), Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static long bG(long j) {
        Long l = (Long) fLy.get(Long.valueOf(j));
        return l == null ? -1 : System.currentTimeMillis() - l.longValue();
    }

    public static void bH(long j) {
        if (!fLz.containsKey(Long.valueOf(j))) {
            fLz.put(Long.valueOf(j), Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static int bD(int i, int i2) {
        if (i2 == -401) {
            return -4;
        }
        if (i == 4) {
            return -2;
        }
        return -1;
    }

    public static long k(i iVar) {
        if (iVar == null) {
            return 0;
        }
        Iterator it = iVar.field_favProto.mtR.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = (int) (((pw) it.next()).msn + ((long) i));
        }
        return (long) i;
    }

    public static String alP() {
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        return stringBuilder.append(c.xq()).append("favorite/").toString();
    }

    public static String alQ() {
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        return stringBuilder.append(c.xq()).append("favorite/web/").toString();
    }

    public static String alR() {
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        return stringBuilder.append(c.xq()).append("favorite/voice/").toString();
    }

    public static String alS() {
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        return stringBuilder.append(c.xq()).append("favorite/music/").toString();
    }

    public static pw a(i iVar, String str) {
        if (be.kS(str) || iVar == null || iVar.field_favProto.mtR.size() == 0) {
            return null;
        }
        Iterator it = iVar.field_favProto.mtR.iterator();
        while (it.hasNext()) {
            pw pwVar = (pw) it.next();
            if (pwVar.luu.equals(str)) {
                return pwVar;
            }
        }
        return null;
    }

    public static List<i> b(long j, int i, Set<Integer> set, a aVar) {
        if (j != 0) {
            return h.alu().a(j, i, (Set) set, aVar);
        }
        j alu = h.alu();
        if (set == null || !set.contains(Integer.valueOf(i))) {
            String str;
            List<i> arrayList = new ArrayList();
            String str2 = "select " + j.fKI + " from FavItemInfo where itemStatus" + " > 0";
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
            Cursor rawQuery = alu.cie.rawQuery(str + " order by updateTime desc limit 20", null);
            if (rawQuery == null) {
                return arrayList;
            }
            if (rawQuery.getCount() != 0) {
                while (rawQuery.moveToNext()) {
                    i iVar = new i();
                    iVar.b(rawQuery);
                    if (aVar == null || !aVar.g(iVar)) {
                        arrayList.add(iVar);
                    } else {
                        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavItemInfoStorage", "id[%d] type[%d] match filter", new Object[]{Integer.valueOf(iVar.field_id), Integer.valueOf(iVar.field_type)});
                    }
                }
            }
            rawQuery.close();
            return arrayList;
        }
        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavItemInfoStorage", "getFirstPageList::block set contains target type, error, do return null");
        return null;
    }

    public static long m(long j, int i) {
        long j2;
        long j3;
        j alu = h.alu();
        String str;
        Cursor rawQuery;
        if (j == 0) {
            str = "select updateTime from (select * from FavItemInfo";
            if (i != -1) {
                str = str + " where type = " + i;
            }
            rawQuery = alu.cie.rawQuery((str + " order by updateTime desc limit 20") + ") where updateSeq > localSeq", null);
            if (rawQuery == null) {
                j2 = 0;
            } else if (rawQuery.getCount() == 0) {
                rawQuery.close();
                j2 = 0;
            } else {
                rawQuery.moveToLast();
                j2 = rawQuery.getLong(0);
                rawQuery.close();
            }
        } else {
            str = "select updateTime from (select * from FavItemInfo where updateTime < " + j;
            if (i != -1) {
                str = str + " and type = " + i;
            }
            rawQuery = alu.cie.rawQuery((str + " order by updateTime desc limit 20") + ") where updateSeq > localSeq", null);
            if (rawQuery == null) {
                j2 = 0;
            } else if (rawQuery.getCount() == 0) {
                rawQuery.close();
                j2 = 0;
            } else {
                rawQuery.moveToLast();
                j2 = rawQuery.getLong(0);
                rawQuery.close();
            }
        }
        j alu2 = h.alu();
        String str2;
        Cursor rawQuery2;
        if (j == 0) {
            str2 = "select updateTime from FavItemInfo where itemStatus > 0";
            if (i != -1) {
                str2 = str2 + " and type = " + i;
            }
            rawQuery2 = alu2.cie.rawQuery(str2 + " order by updateTime desc limit 20", null);
            if (rawQuery2 == null) {
                j3 = 0;
            } else if (rawQuery2.getCount() == 0) {
                rawQuery2.close();
                j3 = 0;
            } else {
                rawQuery2.moveToLast();
                j3 = rawQuery2.getLong(0);
                rawQuery2.close();
            }
        } else {
            str2 = "select updateTime from FavItemInfo where updateTime < " + j;
            if (i != -1) {
                str2 = str2 + " and type = " + i;
            }
            rawQuery2 = alu2.cie.rawQuery((str2 + " and itemStatus > 0") + " order by updateTime desc limit 20", null);
            if (rawQuery2 == null || rawQuery2.getCount() <= 0) {
                j3 = j;
            } else {
                rawQuery2.moveToLast();
                j3 = rawQuery2.getLong(0);
            }
            if (rawQuery2 != null) {
                rawQuery2.close();
            }
        }
        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.FavoriteLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j)});
        if (j2 == 0) {
            return j3;
        }
        LinkedList l = h.alu().l(j2, i);
        if (l.size() > 0) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j)});
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "klem, tryStartBatchGet, need batch get idList size:%d", new Object[]{Integer.valueOf(l.size())});
            if (!ak.vy().a(new z(l), 0)) {
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavoriteLogic", "do scene BatchGetFav fail");
                z.amg();
            }
        }
        if (j3 == 0) {
            return j2;
        }
        return j2 < j3 ? j2 : j3;
    }

    public static void startSync() {
        ak.vy().a(new ab(), 0);
    }

    public static String sV(String str) {
        if (be.kS(str)) {
            return null;
        }
        File file = new File(alQ() + g.m(str.getBytes()));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static boolean c(pw pwVar) {
        return new File(f(pwVar)).exists();
    }

    public static boolean d(pw pwVar) {
        return o.JZ(f(pwVar));
    }

    public static boolean alT() {
        return z.amh() > 0;
    }

    public static void l(i iVar) {
        if (iVar.alB()) {
            switch (iVar.field_itemStatus) {
                case 3:
                    iVar.field_itemStatus = 1;
                    h.alu().a(iVar, "localId");
                    h.all().run();
                    return;
                case 6:
                    if (h.alp().by(iVar.field_localId).size() == 0) {
                        iVar.field_itemStatus = 9;
                        h.alu().a(iVar, "localId");
                        ak.vy().a(new x(iVar), 0);
                        return;
                    }
                    iVar.field_itemStatus = 4;
                    h.alp().a(iVar);
                    h.alu().a(iVar, "localId");
                    for (a aVar : h.alp().by(iVar.field_localId)) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "force upload favItem[last failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[]{Integer.valueOf(iVar.field_id), Long.valueOf(iVar.field_localId), aVar.field_dataId, Integer.valueOf(aVar.field_dataType), Integer.valueOf(aVar.field_totalLen)});
                        h.alo().tc(aVar.field_dataId);
                    }
                    h.alo().run();
                    return;
                case 11:
                    iVar.field_itemStatus = 9;
                    h.alu().a(iVar, "localId");
                    h.alk().run();
                    return;
                case an.CTRL_INDEX /*14*/:
                    h.alu().r(12, iVar.field_localId);
                    h.alk().run();
                    return;
                case 16:
                    h.alu().r(15, iVar.field_localId);
                    h.alp().a(iVar);
                    for (a aVar2 : h.alp().by(iVar.field_localId)) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "force upload favItem[last mod failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[]{Integer.valueOf(iVar.field_id), Long.valueOf(iVar.field_localId), aVar2.field_dataId, Integer.valueOf(aVar2.field_dataType), Integer.valueOf(aVar2.field_totalLen)});
                        h.alo().tc(aVar2.field_dataId);
                    }
                    h.alo().run();
                    return;
                case 18:
                    h.alu().r(17, iVar.field_localId);
                    h.alm().run();
                    return;
                default:
                    return;
            }
        }
        com.tencent.mm.sdk.platformtools.v.f("MicroMsg.FavoriteLogic", "restartItemUpload status not upload failed!");
    }

    public static void m(i iVar) {
        if (iVar != null) {
            if (iVar.field_itemStatus == 8 || iVar.field_itemStatus == 10) {
                iVar.field_itemStatus = 7;
                List<pw> list = iVar.field_favProto.mtR;
                if (list.size() != 0) {
                    for (pw pwVar : list) {
                        a(iVar, pwVar, true);
                        b(iVar, pwVar, true);
                    }
                    return;
                }
                return;
            }
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.FavoriteLogic", "status not download failed or done!");
        }
    }

    public static void a(i iVar, pw pwVar, boolean z) {
        if (!be.kS(pwVar.luu)) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "restart cdndata download, favId %d, favLocalId %d, dataId %s", new Object[]{Integer.valueOf(iVar.field_id), Long.valueOf(iVar.field_localId), pwVar.luu});
            a sL = h.alp().sL(pwVar.luu);
            if (sL != null && sL.field_status == 3) {
                h.alp().b(sL, "dataId");
                sL = null;
            }
            if (sL == null || sL.field_type != 1 || iVar.alA() || iVar.alB()) {
                File file = new File(f(pwVar));
                if (!be.kS(pwVar.mrU) && !be.kS(pwVar.mrS) && !file.exists() && !iVar.alA() && !iVar.alB()) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "klem big img not exist, start download.");
                    long currentTimeMillis = System.currentTimeMillis();
                    a(pwVar, iVar, 1, true);
                    if (z) {
                        h.alo().tc(pwVar.luu);
                    }
                    h.alo().run();
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "insert cdn item use %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    return;
                }
                return;
            }
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "klem data not download completed.");
            sL.field_status = 1;
            h.alp().a(sL, "dataId");
            if (z) {
                h.alo().tc(pwVar.luu);
            }
            h.alo().run();
        }
    }

    public static void b(i iVar, pw pwVar, boolean z) {
        if (!be.kS(pwVar.luu)) {
            String sX = sX(pwVar.luu);
            a sL = h.alp().sL(sX);
            if (sL != null && sL.field_status == 3) {
                h.alp().b(sL, "dataId");
                sL = null;
            }
            if (sL == null || sL.field_type != 1 || iVar.alA() || iVar.alB()) {
                File file = new File(g(pwVar));
                if (!be.kS(pwVar.mrO) && !be.kS(pwVar.coj) && !file.exists() && !iVar.alA() && !iVar.alB()) {
                    a(pwVar, iVar, 1);
                    h.alo().tc(sX);
                    h.alo().run();
                    return;
                }
                return;
            }
            sL.field_status = 1;
            h.alp().a(sL, "dataId");
            h.alo().tc(sX);
            h.alo().run();
        }
    }

    public static void e(pw pwVar) {
        a sL = h.alp().sL(pwVar.luu);
        if (!(sL == null || sL.field_status == 3)) {
            sL.field_status = 2;
            h.alp().a(sL, "dataId");
            h.alo().pauseDownload(pwVar.luu);
        }
        sL = h.alp().sL(sX(pwVar.luu));
        if (sL != null && sL.field_status != 3) {
            sL.field_status = 2;
            h.alp().a(sL, "dataId");
            h.alo().pauseDownload(sX(pwVar.luu));
        }
    }

    public static pw n(i iVar) {
        if (iVar == null) {
            return new pw();
        }
        if (iVar.field_favProto.mtR.size() == 0) {
            return new pw();
        }
        return (pw) iVar.field_favProto.mtR.get(0);
    }

    public static float au(long j) {
        float f = 60.0f;
        float f2 = 1.0f;
        float f3 = ((float) j) / 1000.0f;
        if (f3 >= 1.0f) {
            f2 = f3;
        }
        if (f2 <= 60.0f) {
            f = f2;
        }
        return (float) Math.round(f);
    }

    public static void o(i iVar) {
        if (iVar.alA()) {
            com.tencent.mm.sdk.platformtools.v.v("MicroMsg.FavoriteLogic", "pauseItemUpload, itemStatu:%d", new Object[]{Integer.valueOf(iVar.field_itemStatus)});
            Iterator it = iVar.field_favProto.mtR.iterator();
            while (it.hasNext()) {
                pw pwVar = (pw) it.next();
                a sL = h.alp().sL(pwVar.luu);
                if (!(sL == null || sL.field_status == 3)) {
                    sL.field_status = 2;
                    h.alp().a(sL, "dataId");
                    h.alo().td(pwVar.luu);
                }
                sL = h.alp().sL(sX(pwVar.luu));
                if (!(sL == null || sL.field_status == 3)) {
                    sL.field_status = 2;
                    h.alp().a(sL, "dataId");
                    h.alo().td(sX(pwVar.luu));
                }
            }
            i bB = h.alu().bB(iVar.field_localId);
            com.tencent.mm.sdk.platformtools.v.v("MicroMsg.FavoriteLogic", "pauseItemUpload, after pause data itemStatu:%d", new Object[]{Integer.valueOf(bB.field_itemStatus)});
            switch (bB.field_itemStatus) {
                case 1:
                    h.alu().r(3, bB.field_localId);
                    com.tencent.mm.sdk.platformtools.v.v("MicroMsg.FavoriteLogic", "pauseItemUpload, final itemStatu:%d", new Object[]{Integer.valueOf(3)});
                    return;
                case 4:
                    h.alu().r(6, bB.field_localId);
                    com.tencent.mm.sdk.platformtools.v.v("MicroMsg.FavoriteLogic", "pauseItemUpload, final itemStatu:%d", new Object[]{Integer.valueOf(6)});
                    return;
                case 9:
                    h.alu().r(11, bB.field_localId);
                    com.tencent.mm.sdk.platformtools.v.v("MicroMsg.FavoriteLogic", "pauseItemUpload, final itemStatu:%d", new Object[]{Integer.valueOf(11)});
                    return;
                case 12:
                    h.alu().r(14, bB.field_localId);
                    com.tencent.mm.sdk.platformtools.v.v("MicroMsg.FavoriteLogic", "pauseItemUpload, final itemStatu:%d", new Object[]{Integer.valueOf(14)});
                    return;
                case am.CTRL_INDEX /*15*/:
                    h.alu().r(16, bB.field_localId);
                    com.tencent.mm.sdk.platformtools.v.v("MicroMsg.FavoriteLogic", "pauseItemUpload, final itemStatu:%d", new Object[]{Integer.valueOf(16)});
                    return;
                case 17:
                    h.alu().r(18, bB.field_localId);
                    com.tencent.mm.sdk.platformtools.v.v("MicroMsg.FavoriteLogic", "pauseItemUpload, final itemStatu:%d", new Object[]{Integer.valueOf(18)});
                    return;
                default:
                    return;
            }
        }
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.FavoriteLogic", "pauseItemUpload, not uploading");
    }

    public static String aw(String str, int i) {
        return g.m((str + i + System.currentTimeMillis()).getBytes());
    }

    public static String f(pw pwVar) {
        if (pwVar == null) {
            return "";
        }
        String str = pwVar.luu;
        if (be.kS(str) || !ak.uz()) {
            return "";
        }
        File sW = sW(str);
        if (pwVar.msh != null && pwVar.msh.trim().length() > 0) {
            str = str + "." + pwVar.msh;
        }
        return new File(sW, str).getAbsolutePath();
    }

    public static String g(pw pwVar) {
        if (pwVar == null || be.kS(pwVar.luu)) {
            return "";
        }
        String sX = sX(pwVar.luu);
        return new File(sW(sX), sX).getAbsolutePath();
    }

    private static File sW(String str) {
        int hashCode = str.hashCode() & 255;
        r3 = new Object[3];
        ak.yW();
        r3[0] = c.xq();
        r3[1] = "favorite";
        r3[2] = Integer.valueOf(hashCode);
        File file = new File(String.format("%s/%s/%d/", r3));
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        return file;
    }

    public static String sX(String str) {
        return str + "_t";
    }

    public static boolean sY(String str) {
        if (be.kS(str)) {
            return false;
        }
        return str.endsWith("_t");
    }

    public static boolean a(long j, Runnable runnable) {
        return a(h.alu().bB(j), true, runnable);
    }

    public static boolean a(i iVar, Runnable runnable) {
        return a(iVar, true, null);
    }

    public static boolean a(final i iVar, final boolean z, final Runnable runnable) {
        if (iVar == null) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavoriteLogic", "delete fav item fail, item is null");
            ad.o(runnable);
            return false;
        }
        if (Looper.myLooper() == ak.vA().htb.getLooper()) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "delete favItem id %d, localId %d, needBatchDel %B, do directly", new Object[]{Integer.valueOf(iVar.field_id), Long.valueOf(iVar.field_localId), Boolean.valueOf(z)});
            a(iVar, z);
            ad.o(runnable);
        } else {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "delete favItem id %d, localId %d, needBatchDel %B, post to worker", new Object[]{Integer.valueOf(iVar.field_id), Long.valueOf(iVar.field_localId), Boolean.valueOf(z)});
            ak.vA().x(new Runnable() {
                public final void run() {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "delete favItem id %d, localId %d, needBatchDel %B, do on worker thread", new Object[]{Integer.valueOf(iVar.field_id), Long.valueOf(iVar.field_localId), Boolean.valueOf(z)});
                    v.a(iVar, z);
                    ad.o(runnable);
                }
            });
        }
        return true;
    }

    private static void a(i iVar, boolean z) {
        p(iVar);
        h.alt().bD(iVar.field_localId);
        h.alu().d(iVar);
        h.alp().bA(iVar.field_localId);
        h.aln().i(iVar);
        if (z) {
            Set alV = alV();
            alV.add(iVar.field_id);
            e(alV);
            alU();
        }
    }

    public static boolean as(List<i> list) {
        if (list == null || list.isEmpty()) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavoriteLogic", "delete fav item fail, item is null");
            return false;
        }
        Set alV = alV();
        for (i iVar : list) {
            p(iVar);
            h.alt().bD(iVar.field_localId);
            h.alu().d(iVar);
            h.alp().bA(iVar.field_localId);
            h.aln().i(iVar);
            alV.add(iVar.field_id);
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteLogic", "delete id %d", new Object[]{Integer.valueOf(iVar.field_id)});
        }
        e(alV);
        alU();
        return true;
    }

    public static void at(List<Integer> list) {
        if (list.size() == 0) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.FavoriteLogic", "setDeleted list null");
            return;
        }
        Set alV = alV();
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "setDeleted before del:%s", new Object[]{alV.toString()});
        for (Integer num : list) {
            boolean remove = alV.remove(num.toString());
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "setDeleted id:%d, ret:%b", new Object[]{num, Boolean.valueOf(remove)});
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "setDeleted after del:%s", new Object[]{alV.toString()});
        e(alV);
    }

    public static void alU() {
        Set<String> alV = alV();
        if (alV.size() == 0) {
            com.tencent.mm.sdk.platformtools.v.v("MicroMsg.FavoriteLogic", "doBatchDel no item to delete");
            return;
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "doBatchDel idList:%s", new Object[]{alV.toString()});
        LinkedList linkedList = new LinkedList();
        for (String str : alV) {
            try {
                linkedList.add(Integer.valueOf(be.getInt(str, 0)));
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.v.a("MicroMsg.FavoriteLogic", e, "", new Object[0]);
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.FavoriteLogic", "doBatchDel parseInt error:%s", new Object[]{e.getMessage()});
            }
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "doBatchDel after parse, total size %d", new Object[]{Integer.valueOf(linkedList.size())});
        if (linkedList.size() > 0) {
            ak.vy().a(new y(linkedList), 0);
        }
    }

    private static void e(Set<String> set) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : set) {
            stringBuffer.append(append).append(",");
        }
        Object obj = "";
        if (stringBuffer.length() > 0) {
            obj = stringBuffer.substring(0, stringBuffer.length() - 1);
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "set need del IDs: %s", new Object[]{obj});
        ak.yW();
        c.vf().set(225282, obj);
    }

    private static Set<String> alV() {
        ak.yW();
        String str = (String) c.vf().get(225282, "");
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "get need del IDs: %s", new Object[]{str});
        Set<String> hashSet = new HashSet();
        if (be.kS(str)) {
            return hashSet;
        }
        String[] split = str.split(",");
        if (split == null || split.length == 0) {
            return hashSet;
        }
        for (Object add : split) {
            hashSet.add(add);
        }
        return hashSet;
    }

    private static void p(i iVar) {
        List list = iVar.field_favProto.mtR;
        for (int i = 0; i < list.size(); i++) {
            b.deleteFile(g((pw) list.get(i)));
            b.deleteFile(f((pw) list.get(i)));
        }
    }

    public static void a(pw pwVar, i iVar, int i, boolean z) {
        if (i == 1 && (pwVar.msn <= 0 || be.kS(pwVar.mrU) || be.kS(pwVar.mrS))) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.FavoriteLogic", "insertCdnDataInfo, type recv, cdndataurl must not be null!");
        } else if (i == 0 && be.kS(f(pwVar))) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.FavoriteLogic", "insertCdnDataInfo, type send, path must not be null!");
        } else if (h.alp().sL(pwVar.luu) != null) {
            com.tencent.mm.sdk.platformtools.v.v("MicroMsg.FavoriteLogic", "cdn info exist, id[%s], return", new Object[]{pwVar.luu});
        } else {
            Object obj;
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "insert cdn data info, fav local id[%d] fav id[%d]", new Object[]{Long.valueOf(iVar.field_localId), Integer.valueOf(iVar.field_id)});
            a aVar = new a();
            aVar.field_dataId = pwVar.luu;
            aVar.field_totalLen = (int) pwVar.msn;
            aVar.field_type = i;
            aVar.field_favLocalId = iVar.field_localId;
            aVar.field_cdnKey = pwVar.mrU;
            aVar.field_cdnUrl = pwVar.mrS;
            aVar.field_path = f(pwVar);
            if (pwVar.aKG == 3) {
                String str = pwVar.msh;
                int i2 = (be.kS(str) || !str.equals("speex")) ? (be.kS(str) || !str.equals("silk")) ? -2 : -4 : -3;
                aVar.field_dataType = i2;
            } else {
                aVar.field_dataType = pwVar.aKG;
            }
            aVar.field_modifyTime = be.Ni();
            boolean isWifi = com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext());
            if (i == 0) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "can auto upload, force %B, isWifi %B, dataType %d, totalLen %d", new Object[]{Boolean.valueOf(z), Boolean.valueOf(isWifi), Integer.valueOf(aVar.field_dataType), Integer.valueOf(aVar.field_totalLen)});
                if (z) {
                    obj = 1;
                } else if (isWifi) {
                    obj = 1;
                } else if (aVar.field_dataType == 8 || aVar.field_dataType == 4 || aVar.field_dataType == 15) {
                    if (((long) aVar.field_totalLen) <= amc()) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "match max auto upload, max size %d", new Object[]{Long.valueOf(amc())});
                        obj = 1;
                    } else {
                        obj = null;
                    }
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    aVar.field_status = 1;
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "insertCdnDataInfo upload status traning");
                } else {
                    aVar.field_status = 4;
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "insertCdnDataInfo upload status pause");
                }
            }
            if (i == 1) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "can auto download, force %B, isWifi %B, dataType %d, totalLen %d", new Object[]{Boolean.valueOf(z), Boolean.valueOf(isWifi), Integer.valueOf(aVar.field_dataType), Integer.valueOf(aVar.field_totalLen)});
                if (z) {
                    obj = 1;
                } else if (isWifi) {
                    obj = 1;
                } else if (aVar.field_dataType == 8 || aVar.field_dataType == 4 || aVar.field_dataType == 15) {
                    if (((long) aVar.field_totalLen) <= amb()) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "match max auto download, max size %d", new Object[]{Long.valueOf(amb())});
                        obj = 1;
                    } else {
                        obj = null;
                    }
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    aVar.field_status = 1;
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "insertCdnDataInfo download status traning");
                } else {
                    aVar.field_status = 4;
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "insertCdnDataInfo download status pause");
                }
            }
            h.alp().a(aVar);
            if (i == 1) {
                com.tencent.mm.plugin.favorite.c.c.f(aVar);
            } else {
                com.tencent.mm.plugin.favorite.c.c.e(aVar);
            }
        }
    }

    public static void a(pw pwVar, i iVar, int i) {
        if (i == 1 && (pwVar.msy <= 0 || be.kS(pwVar.mrO) || be.kS(pwVar.coj))) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.FavoriteLogic", "insertCdnThumbInfo, type recv, cdndataurl must not be null!");
        } else if (i == 0 && be.kS(g(pwVar))) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.FavoriteLogic", "insertCdnThumbInfo, type send, path must not be null!");
        } else {
            String sX = sX(pwVar.luu);
            if (h.alp().sL(sX) != null) {
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavoriteLogic", "cdn info exist, id[%s], return", new Object[]{sX});
                return;
            }
            com.tencent.mm.sdk.platformtools.v.v("MicroMsg.FavoriteLogic", "insert cdn thumb info, fav local id[%d] fav id[%d]", new Object[]{Long.valueOf(iVar.field_localId), Integer.valueOf(iVar.field_id)});
            a aVar = new a();
            aVar.field_cdnKey = pwVar.mrO;
            aVar.field_cdnUrl = pwVar.coj;
            aVar.field_dataId = sX;
            aVar.field_favLocalId = iVar.field_localId;
            aVar.field_totalLen = (int) pwVar.msy;
            aVar.field_type = i;
            aVar.field_status = 1;
            aVar.field_path = g(pwVar);
            aVar.field_modifyTime = be.Ni();
            h.alp().a(aVar);
            if (i == 1) {
                com.tencent.mm.plugin.favorite.c.c.f(aVar);
            } else {
                com.tencent.mm.plugin.favorite.c.c.e(aVar);
            }
        }
    }

    private static void q(i iVar) {
        int i;
        m mVar;
        m bE = h.alt().bE(iVar.field_localId);
        if (bE == null) {
            bE = new m();
            bE.field_localId = iVar.field_localId;
            i = 1;
            mVar = bE;
        } else {
            i = 0;
            mVar = bE;
        }
        mVar.field_tagContent = "";
        for (String str : iVar.field_tagProto.mua) {
            mVar.field_tagContent += " " + str;
        }
        for (String str2 : iVar.field_tagProto.mub) {
            mVar.field_tagContent += " " + str2;
            h.aln().sS(str2);
        }
        mVar.field_content = "";
        mVar.field_time = iVar.field_updateTime;
        mVar.field_type = iVar.field_type;
        if (i != 0) {
            h.alt().b(mVar);
            return;
        }
        h.alt().a(mVar, new String[]{"localId"});
    }

    public static void r(i iVar) {
        int i;
        m mVar;
        m bE = h.alt().bE(iVar.field_localId);
        if (bE == null) {
            bE = new m();
            bE.field_localId = iVar.field_localId;
            i = 1;
            mVar = bE;
        } else {
            i = 0;
            mVar = bE;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (iVar.field_favProto.title != null) {
            stringBuffer.append(iVar.field_favProto.title);
        }
        if (iVar.field_favProto.desc != null) {
            stringBuffer.append(iVar.field_favProto.desc);
        }
        if (iVar.field_favProto.mtP != null) {
            qg qgVar = iVar.field_favProto.mtP;
            if (!be.kS(qgVar.bhM)) {
                stringBuffer.append(qgVar.bhM);
                ak.yW();
                u LX = c.wH().LX(qgVar.bhM);
                if (LX != null) {
                    stringBuffer.append(LX.field_nickname).append(LX.field_conRemark);
                }
                ak.yW();
                LX = c.wH().LX(qgVar.toUser);
                if (LX != null) {
                    stringBuffer.append(LX.field_nickname).append(LX.field_conRemark);
                }
                stringBuffer.append(qgVar.mtu);
            }
        }
        LinkedList linkedList = iVar.field_favProto.mtR;
        mVar.field_subtype = 0;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            pw pwVar = (pw) it.next();
            if (pwVar.desc != null) {
                stringBuffer.append(pwVar.desc);
            }
            if (pwVar.title != null) {
                stringBuffer.append(pwVar.title);
            }
            int i2 = pwVar.aKG;
            mVar.field_subtype = m.kD(i2) | mVar.field_subtype;
        }
        if (iVar.field_favProto.mtc != null) {
            if (iVar.field_favProto.mtc.desc != null) {
                stringBuffer.append(iVar.field_favProto.mtc.desc);
            }
            if (iVar.field_favProto.mtc.title != null) {
                stringBuffer.append(iVar.field_favProto.mtc.title);
            }
        }
        if (iVar.field_favProto.mte != null) {
            if (iVar.field_favProto.mte.desc != null) {
                stringBuffer.append(iVar.field_favProto.mte.desc);
            }
            if (iVar.field_favProto.mte.title != null) {
                stringBuffer.append(iVar.field_favProto.mte.title);
            }
        }
        mVar.field_tagContent = "";
        for (String str : iVar.field_tagProto.mua) {
            mVar.field_tagContent += " " + str;
            stringBuffer.append(str);
        }
        for (String str2 : iVar.field_tagProto.mub) {
            mVar.field_tagContent += " " + str2;
            stringBuffer.append(str2);
            h.aln().sS(str2);
        }
        mVar.field_content = stringBuffer.toString();
        mVar.field_time = iVar.field_updateTime;
        mVar.field_type = iVar.field_type;
        if (i != 0) {
            h.alt().b(mVar);
            return;
        }
        h.alt().a(mVar, new String[]{"localId"});
    }

    public static ArrayList<i> a(List<String> list, List<String> list2, List<Integer> list3, List<i> list4, Set<Integer> set, a aVar) {
        String str;
        n alt = h.alt();
        ArrayList arrayList = new ArrayList();
        String str2 = "select localId from FavSearchInfo";
        String str3 = " 1=1 ";
        if (!(list == null || list.isEmpty())) {
            str = str3;
            for (String str32 : list) {
                str = str + " and content like '%" + str32 + "%'";
            }
            str32 = str;
        }
        if (!(list2 == null || list2.isEmpty())) {
            str = str32;
            for (String str322 : list2) {
                str = str + " and tagContent like '%" + str322 + "%'";
            }
            str322 = str;
        }
        str322 = str2 + " where " + str322;
        if (!(list3 == null || list3.isEmpty())) {
            str322 = str322 + " and ((1=1 ";
            str = str322;
            for (Integer intValue : list3) {
                str = str + " and type = " + intValue.intValue();
            }
            str322 = str + ") or (1=1";
            str = str322;
            for (Integer intValue2 : list3) {
                str = str + " and subtype & " + m.kD(intValue2.intValue()) + " != 0";
            }
            str322 = str + "))";
        }
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavSearchStorage", "search id sql {%s}", new Object[]{str322 + " order by time desc"});
        Cursor rawQuery = alt.cie.rawQuery(str322, null);
        if (rawQuery == null) {
            List list5 = arrayList;
        } else {
            if (rawQuery.getCount() != 0) {
                while (rawQuery.moveToNext()) {
                    arrayList.add(Long.valueOf(rawQuery.getLong(0)));
                }
            }
            rawQuery.close();
            Object obj = arrayList;
        }
        ArrayList<i> arrayList2 = new ArrayList();
        if (list5.size() == 0) {
            return arrayList2;
        }
        int i = 0;
        while (true) {
            int size = i + 20 < list5.size() ? i + 20 : list5.size();
            com.tencent.mm.sdk.platformtools.v.v("MicroMsg.FavoriteLogic", "start:%d  end:%d listSize:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(size), Integer.valueOf(list5.size())});
            Collection a = h.alu().a(list5.subList(i, size), (List) list4, (Set) set, aVar);
            if (a != null && a.size() > 0) {
                arrayList2.addAll(a);
            }
            if (size >= list5.size()) {
                return arrayList2;
            }
            i = size;
        }
    }

    public static int sZ(String str) {
        if (!be.kS(str) && str.equals("speex")) {
            return 1;
        }
        if (be.kS(str) || !str.equals("silk")) {
            return 0;
        }
        return 2;
    }

    public static void bI(long j) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "setUsedCapacity:%d", new Object[]{Long.valueOf(j)});
        ak.yW();
        c.vf().a(com.tencent.mm.storage.t.a.nqR, Long.valueOf(j));
    }

    public static void bJ(long j) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "setTotalCapacity:%d", new Object[]{Long.valueOf(j)});
        ak.yW();
        c.vf().a(com.tencent.mm.storage.t.a.nqS, Long.valueOf(j));
    }

    public static long alW() {
        long alX = alX() - alY();
        if (alX < 0) {
            return 1024;
        }
        return alX;
    }

    private static long alX() {
        ak.yW();
        return ((Long) c.vf().get(com.tencent.mm.storage.t.a.nqS, Long.valueOf(0))).longValue();
    }

    public static long alY() {
        ak.yW();
        return ((Long) c.vf().get(com.tencent.mm.storage.t.a.nqR, Long.valueOf(0))).longValue();
    }

    public static boolean alZ() {
        if (alX() != 0 && alW() < 10485760) {
            return true;
        }
        return false;
    }

    public static boolean ama() {
        if (alX() != 0 && alW() < 52428800) {
            return true;
        }
        return false;
    }

    public static long amb() {
        return aa.getContext().getSharedPreferences(aa.bti(), 0).getLong("fav_mx_auto_download_size", 26214400);
    }

    public static void bK(long j) {
        aa.getContext().getSharedPreferences(aa.bti(), 0).edit().putLong("fav_mx_auto_download_size", j).commit();
    }

    public static long amc() {
        long j = aa.getContext().getSharedPreferences(aa.bti(), 0).getLong("fav_mx_auto_upload_size", 0);
        if (j == 0) {
            return 26214400;
        }
        return j;
    }

    public static void bL(long j) {
        aa.getContext().getSharedPreferences(aa.bti(), 0).edit().putLong("fav_mx_auto_upload_size", j).commit();
    }

    public static void bM(long j) {
        aa.getContext().getSharedPreferences(aa.bti(), 0).edit().putLong("fav_mx_file_size", j).commit();
    }

    public static String N(float f) {
        if (f < 1024.0f) {
            return String.format("%.1fB", new Object[]{Float.valueOf(f)});
        } else if (f < 1048576.0f) {
            return String.format("%.1fKB", new Object[]{Float.valueOf(f / 1024.0f)});
        } else if (f < 1.07374182E9f) {
            return String.format("%.1fMB", new Object[]{Float.valueOf((f / 1024.0f) / 1024.0f)});
        } else {
            return String.format("%.1fGB", new Object[]{Float.valueOf(((f / 1024.0f) / 1024.0f) / 1024.0f)});
        }
    }

    public static void a(List<i> list, String[] strArr) {
        if (list != null && !list.isEmpty() && strArr != null && strArr.length > 0) {
            List<i> linkedList = new LinkedList();
            for (i iVar : list) {
                int i = 0;
                for (String sO : strArr) {
                    i |= iVar.sO(sO);
                }
                if (i != 0) {
                    h.alu().a(iVar, "localId");
                    q(iVar);
                    linkedList.add(iVar);
                }
            }
            for (i iVar2 : linkedList) {
                w.a(iVar2, 3);
            }
        }
    }

    public static void a(i iVar, Collection<String> collection, int i) {
        if (iVar != null) {
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteLogic", "mod tags %s", new Object[]{collection});
            Set hashSet = new HashSet();
            hashSet.addAll(iVar.field_tagProto.mub);
            iVar.field_tagProto.mub.clear();
            if (!(collection == null || collection.isEmpty())) {
                iVar.field_tagProto.mub.addAll(collection);
                hashSet.removeAll(collection);
            }
            h.alu().a(iVar, "localId");
            q(iVar);
            h.aln().d(hashSet);
            w.a(iVar, i);
        }
    }

    public static String a(Context context, List<String> list) {
        if (context == null || list == null || list.isEmpty()) {
            return "";
        }
        String str = (String) list.get(0);
        String string = context.getResources().getString(2131232743);
        int i = 1;
        while (i < list.size()) {
            String str2 = str + string + ((String) list.get(i));
            i++;
            str = str2;
        }
        return str;
    }

    public static String w(Context context, int i) {
        if (context == null) {
            return "";
        }
        switch (i) {
            case 1:
                return context.getString(2131232733);
            case 2:
                return context.getString(2131232735);
            case 3:
                return context.getString(2131232740);
            case 4:
                return context.getString(2131232739);
            case 5:
                return context.getString(2131232738);
            case 6:
                return context.getString(2131232736);
            case 7:
                return context.getString(2131232737);
            case 8:
                return context.getString(2131232734);
            default:
                return "";
        }
    }

    public static Integer Q(Context context, String str) {
        if (context == null) {
            return Integer.valueOf(-1);
        }
        if (context.getString(2131232735).equals(str)) {
            return Integer.valueOf(2);
        }
        if (context.getString(2131232737).equals(str)) {
            return Integer.valueOf(7);
        }
        if (context.getString(2131232736).equals(str)) {
            return Integer.valueOf(6);
        }
        if (context.getString(2131232733).equals(str)) {
            return Integer.valueOf(1);
        }
        if (context.getString(2131232739).equals(str)) {
            return Integer.valueOf(4);
        }
        if (context.getString(2131232738).equals(str)) {
            return Integer.valueOf(5);
        }
        if (context.getString(2131232740).equals(str)) {
            return Integer.valueOf(3);
        }
        if (context.getString(2131232734).equals(str)) {
            return Integer.valueOf(8);
        }
        return Integer.valueOf(-1);
    }

    public static String et(String str) {
        ak.yW();
        u LX = c.wH().LX(str);
        if (LX == null) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavoriteLogic", "wtf get contact null, username %s", new Object[]{str});
            return "";
        }
        String tU = LX.tU();
        if (!m.dE(tU)) {
            return tU;
        }
        List ej = i.ej(str);
        String xF = k.xF();
        if (ej == null || ej.isEmpty()) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavoriteLogic", "get members from username error, content empty");
            return tU;
        }
        ej.remove(xF);
        ej.add(0, xF);
        return i.b(ej, 3);
    }

    public static int ta(String str) {
        Integer num = (Integer) fLE.get(str);
        if (num == null) {
            return ((Integer) fLE.get("unknown")).intValue();
        }
        return num.intValue();
    }

    public static void bN(long j) {
        fLA = j;
    }

    public static void amd() {
        if (0 >= fLA) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "addTagWhenAddToFav,try to add tag ,but favLocalId is null, return");
            return;
        }
        i bB = h.alu().bB(fLA);
        fLA = 0;
        if (bB == null) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "addTagWhenAddToFav,try to add tag ,but iteminfo is null, return");
            return;
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "addTagWhenAddToFav ,go on");
        Intent intent = new Intent();
        intent.putExtra("key_fav_scene", 5);
        intent.putExtra("key_fav_item_id", bB.field_localId);
        com.tencent.mm.ay.c.b(aa.getContext(), "favorite", ".ui.FavTagEditUI", intent);
    }

    public static boolean s(i iVar) {
        if (iVar == null) {
            return false;
        }
        if (iVar.field_itemStatus == 8 || iVar.field_itemStatus == 10 || iVar.field_itemStatus == 7) {
            return true;
        }
        return false;
    }

    public static List<i> a(List<i> list, a aVar) {
        i iVar;
        j alu = h.alu();
        if (list != null) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavItemInfoStorage", "getCleanList,recycleList size=" + list.size());
        } else {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavItemInfoStorage", "getCleanList,recycleList size=0");
        }
        ak.yW();
        if (!((Boolean) c.vf().get(com.tencent.mm.storage.t.a.nqQ, Boolean.valueOf(false))).booleanValue()) {
            alu.alI();
            ak.yW();
            c.vf().a(com.tencent.mm.storage.t.a.nqQ, Boolean.valueOf(true));
        }
        List<i> arrayList = new ArrayList();
        if (!(list == null || list.size() == 0)) {
            arrayList.addAll(list);
        }
        String str = "select " + j.fKI + " from FavItemInfo where ";
        String str2 = "";
        int[] iArr = fLC;
        int length = iArr.length;
        int i = 0;
        while (i < length) {
            i++;
            str2 = str2 + iArr[i] + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        str = str + "type in (" + str2 + ")";
        str2 = "";
        iArr = fLD;
        length = iArr.length;
        i = 0;
        while (i < length) {
            i++;
            str2 = str2 + iArr[i] + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        String str3 = str + " and itemStatus in (" + str2 + ")";
        i iVar2;
        if (list == null || list.size() == 0) {
            str2 = str3;
            iVar2 = null;
        } else {
            iVar = (i) list.get(list.size() - 1);
            i iVar3;
            if (iVar.field_datatotalsize != 0) {
                iVar3 = iVar;
                str2 = str3 + " and datatotalsize <= " + iVar.field_datatotalsize;
                iVar2 = iVar3;
            } else {
                iVar3 = iVar;
                str2 = str3;
                iVar2 = iVar3;
            }
        }
        Cursor rawQuery = alu.cie.rawQuery(str2 + " and datatotalsize > 0 order by datatotalsize desc limit 20", null);
        if (rawQuery == null) {
            return arrayList;
        }
        if (rawQuery.getCount() != 0) {
            while (rawQuery.moveToNext()) {
                i iVar4 = new i();
                iVar4.b(rawQuery);
                if (aVar == null || !aVar.g(iVar4)) {
                    boolean z;
                    if (!(list == null || r1 == null || iVar4.field_datatotalsize != r1.field_datatotalsize)) {
                        for (i iVar5 : list) {
                            if (iVar5.field_id == iVar4.field_id) {
                                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavItemInfoStorage", "same fav id ,ignore");
                                z = true;
                                break;
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                        arrayList.add(iVar4);
                    }
                } else {
                    com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavItemInfoStorage", "id[%d] type[%d] match filter", new Object[]{Integer.valueOf(iVar4.field_id), Integer.valueOf(iVar4.field_type)});
                }
            }
        }
        rawQuery.close();
        return arrayList;
    }

    public static boolean kF(int i) {
        for (int i2 : fLD) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean kG(int i) {
        for (int i2 : fLC) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static i tb(String str) {
        i iVar = new i();
        iVar.field_localId = -1;
        iVar.field_id = -1;
        iVar.field_xml = str;
        iVar.field_type = 18;
        iVar.sM(str);
        return iVar;
    }

    public static void h(pw pwVar) {
        if (!be.kS(pwVar.luu)) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "restart cdndata download, dataId %s", new Object[]{pwVar.luu});
            a sL = h.alp().sL(pwVar.luu);
            if (sL != null && (sL.field_status == 3 || sL.field_status == 4)) {
                h.alp().b(sL, "dataId");
                sL = null;
            }
            if (sL == null || sL.field_type != 1) {
                File file = new File(f(pwVar));
                if (!be.kS(pwVar.mrU) && !be.kS(pwVar.mrS) && !file.exists()) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "klem big img not exist, start download.");
                    long currentTimeMillis = System.currentTimeMillis();
                    i iVar = new i();
                    iVar.field_localId = -1;
                    iVar.field_id = -1;
                    iVar.field_type = 18;
                    a(pwVar, iVar, 1, true);
                    h.alo().tc(pwVar.luu);
                    h.alo().run();
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "insert cdn item use %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    return;
                }
                return;
            }
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "klem data not download completed.");
            sL.field_status = 1;
            h.alp().a(sL, "dataId");
            h.alo().tc(pwVar.luu);
            h.alo().run();
        }
    }

    public static boolean t(i iVar) {
        if (iVar == null) {
            return false;
        }
        pw n = n(iVar);
        if (n == null) {
            return false;
        }
        int aOM;
        int i;
        boolean a;
        long Nj = be.Nj();
        com.tencent.mm.plugin.sight.base.a zD = d.zD(f(n));
        if (zD != null) {
            aOM = zD.aOM();
            i = n.duration;
            if (i <= 0 || Math.abs(i - aOM) >= 2) {
                n.uF(aOM);
                a = h.alu().a(iVar, "localId");
            } else {
                a = false;
            }
        } else {
            a = false;
            i = 0;
            aOM = 0;
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteLogic", "repair video duration[%d TO %d] %b cost time %d", new Object[]{Integer.valueOf(i), Integer.valueOf(aOM), Boolean.valueOf(a), Long.valueOf(be.az(Nj))});
        return a;
    }

    public static void a(ad adVar) {
        if (adVar.BD() != null && adVar.BD().ze() != null && adVar.BD().ze().lWU == -435) {
            i bC = h.alu().bC((long) adVar.fMa);
            if (bC != null && bC.field_favProto != null && bC.field_favProto.mtR != null) {
                bC.field_favProto.uM(bC.field_favProto.version + 2);
                bC.field_itemStatus = 1;
                h.alu().a(bC, "localId");
                h.all().run();
            }
        }
    }
}
