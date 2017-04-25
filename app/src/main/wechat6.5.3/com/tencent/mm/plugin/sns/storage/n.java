package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.bg.g;
import com.tencent.mm.protocal.c.afi;
import com.tencent.mm.protocal.c.avz;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;

public final class n extends f<m> {
    public static final String[] cic = new String[]{f.a(m.chq, "SnsReportKv")};
    public g cuX;

    public n(g gVar) {
        super(gVar, m.chq, "SnsReportKv", m.btd);
        this.cuX = gVar;
    }

    public final int a(avz com_tencent_mm_protocal_c_avz) {
        avz com_tencent_mm_protocal_c_avz2 = new avz();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < com_tencent_mm_protocal_c_avz.mby.size(); i3++) {
            afi com_tencent_mm_protocal_c_afi = (afi) com_tencent_mm_protocal_c_avz.mby.get(i3);
            if (com_tencent_mm_protocal_c_afi.mFe.lVU.length + i2 > 51200) {
                a(com_tencent_mm_protocal_c_avz2, i2);
                i++;
                com_tencent_mm_protocal_c_avz2.mby.clear();
                i2 = 0;
            } else {
                i2 += com_tencent_mm_protocal_c_afi.mFe.lVU.length;
                com_tencent_mm_protocal_c_avz2.mby.add(com_tencent_mm_protocal_c_afi);
            }
        }
        if (com_tencent_mm_protocal_c_avz2.mby.size() <= 0) {
            return i;
        }
        i++;
        a(com_tencent_mm_protocal_c_avz2, i2);
        return i;
    }

    private int a(avz com_tencent_mm_protocal_c_avz, int i) {
        try {
            byte[] toByteArray = com_tencent_mm_protocal_c_avz.toByteArray();
            m mVar = new m();
            mVar.field_value = toByteArray;
            mVar.field_logtime = System.currentTimeMillis();
            mVar.field_logsize = i;
            mVar.field_offset = 0;
            int insert = (int) this.cuX.insert("SnsReportKv", "", mVar.py());
            v.d("MicroMsg.SnsKvReportStg", "SnsKvReport Insert result " + insert);
            return insert;
        } catch (Exception e) {
            return 0;
        }
    }

    public final avz cu(int i, int i2) {
        Throwable th;
        String str = "select rowid, *  from SnsReportKv";
        StringBuffer stringBuffer = new StringBuffer();
        if (i2 > 0) {
            str = str + " where rowid <= " + i2;
        }
        Cursor rawQuery = this.cuX.rawQuery(str, null);
        avz com_tencent_mm_protocal_c_avz = new avz();
        List<Integer> arrayList = new ArrayList();
        stringBuffer.append("target size " + i + " current maxcolid " + i2);
        if (rawQuery.moveToFirst()) {
            int i3 = 0;
            do {
                m mVar = new m();
                mVar.b(rawQuery);
                int i4 = mVar.field_offset;
                stringBuffer.append("|offset: " + i4);
                avz com_tencent_mm_protocal_c_avz2 = new avz();
                try {
                    com_tencent_mm_protocal_c_avz2.az(mVar.field_value);
                    int i5 = i4;
                    i4 = i3;
                    while (i5 < com_tencent_mm_protocal_c_avz2.mby.size()) {
                        try {
                            afi com_tencent_mm_protocal_c_afi = (afi) com_tencent_mm_protocal_c_avz2.mby.get(i5);
                            if (com_tencent_mm_protocal_c_afi.mFe.lVU.length + i4 > i) {
                                if (i4 == 0) {
                                    arrayList.add(Integer.valueOf(mVar.jBI));
                                    v.i("MicroMsg.SnsKvReportStg", "error by server for the mini size " + i + " vlauesize " + com_tencent_mm_protocal_c_afi.mFe.lVU.length);
                                }
                                i3 = 1;
                                stringBuffer.append("|read end on " + mVar.jBI + " and get size " + i4);
                                if (i3 != 0 || mVar.field_offset > com_tencent_mm_protocal_c_avz2.mby.size()) {
                                    stringBuffer.append("|read full ");
                                    arrayList.add(Integer.valueOf(mVar.jBI));
                                } else {
                                    a((long) mVar.jBI, mVar);
                                    stringBuffer.append("|update new offset " + mVar.field_offset);
                                }
                                if (i3 != 0) {
                                    break;
                                }
                                i3 = i4;
                            } else {
                                mVar.field_offset = i5 + 1;
                                com_tencent_mm_protocal_c_avz.mby.add(com_tencent_mm_protocal_c_afi);
                                i4 += com_tencent_mm_protocal_c_afi.mFe.lVU.length;
                                i5++;
                            }
                        } catch (Throwable e) {
                            Throwable th2 = e;
                            i3 = i4;
                            th = th2;
                        }
                    }
                    i3 = 0;
                    stringBuffer.append("|read end on " + mVar.jBI + " and get size " + i4);
                    if (i3 != 0) {
                    }
                    stringBuffer.append("|read full ");
                    arrayList.add(Integer.valueOf(mVar.jBI));
                    if (i3 != 0) {
                        break;
                    }
                    i3 = i4;
                } catch (Exception e2) {
                    th = e2;
                    v.a("MicroMsg.SnsKvReportStg", th, "", new Object[0]);
                    arrayList.add(Integer.valueOf(mVar.jBI));
                    v.i("MicroMsg.SnsKvReportStg", "error paser then delete " + mVar.jBI);
                    if (!rawQuery.moveToNext()) {
                        v.i("MicroMsg.SnsKvReportStg", "read info " + stringBuffer.toString());
                        rawQuery.close();
                        for (Integer intValue : arrayList) {
                            delete((long) intValue.intValue());
                        }
                        return com_tencent_mm_protocal_c_avz;
                    }
                }
            } while (rawQuery.moveToNext());
            v.i("MicroMsg.SnsKvReportStg", "read info " + stringBuffer.toString());
        }
        rawQuery.close();
        while (r1.hasNext()) {
            delete((long) intValue.intValue());
        }
        return com_tencent_mm_protocal_c_avz;
    }
}
