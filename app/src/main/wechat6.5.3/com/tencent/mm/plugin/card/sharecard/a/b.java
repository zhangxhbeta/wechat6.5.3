package com.tencent.mm.plugin.card.sharecard.a;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mars.smc.SmcLogic.IDKey;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.p;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.i;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.plugin.card.sharecard.model.m;
import com.tencent.mm.plugin.card.sharecard.model.r;
import com.tencent.mm.plugin.card.sharecard.ui.b.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class b {
    private static boolean cwY = false;
    public static boolean eEp = false;
    public a eEo = null;
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
        eEp = false;
    }

    public final void init() {
        if (((l) af.aap().getValue("key_share_card_layout_data")) == null) {
            v.e("MicroMsg.ShareCardDataMgr", "initShareCardLayoutData, data cache is empty!, load data from db!");
            Object acK = j.acK();
            if (TextUtils.isEmpty(acK)) {
                v.e("MicroMsg.ShareCardDataMgr", "initShareCardLayoutData, json is empty");
                return;
            }
            l qF = p.qF(acK);
            if (qF != null) {
                v.i("MicroMsg.ShareCardDataMgr", "load share card layout data success!");
                af.aap().putValue("key_share_card_layout_data", qF);
                a(qF, true);
                return;
            }
            v.e("MicroMsg.ShareCardDataMgr", "load share card layout data fail!");
            return;
        }
        v.i("MicroMsg.ShareCardDataMgr", "the share card layout cache is valid!");
    }

    public static int aaz() {
        int i = 0;
        c aak = af.aak();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where (status=0 OR ").append("status=5) AND ").append("card_type=10");
        Cursor rawQuery = aak.cie.rawQuery("select count(*) from UserCardInfo" + stringBuilder.toString(), null);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        return i;
    }

    public static int aaA() {
        int i = 0;
        c aak = af.aak();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where (status=0 OR ").append("status=5) AND ").append("card_type!=10");
        Cursor rawQuery = aak.cie.rawQuery("select count(*) from UserCardInfo" + stringBuilder.toString(), null);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        return i;
    }

    public final void N(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            v.e("MicroMsg.ShareCardDataMgr", "updateGetShareLayoutData json is empty");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        l qF = p.qF(str);
        l lVar = (l) af.aap().getValue("key_share_card_layout_data");
        if (qF == null) {
            v.e("MicroMsg.ShareCardDataMgr", "updateGetShareLayoutData data == null");
            a(qF, lVar, z);
            af.aap().putValue("key_share_card_layout_data", qF);
            return;
        }
        if (z) {
            j.qx(str);
        }
        a(qF, z);
        a(qF, lVar, z);
        af.aap().putValue("key_share_card_layout_data", qF);
        int i = 0;
        if (qF.eED != null && qF.eED.size() > 0) {
            i = qF.eED.size();
        }
        if (qF.eEE != null && qF.eEE.size() > 0) {
            i += qF.eEE.size();
        }
        if (i > 0) {
            int currentTimeMillis2 = (int) (System.currentTimeMillis() - currentTimeMillis);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(10);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(11);
            iDKey2.SetValue(currentTimeMillis2);
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(281);
            iDKey3.SetKey(12);
            iDKey3.SetValue(i);
            IDKey iDKey4 = new IDKey();
            iDKey4.SetID(281);
            iDKey4.SetKey(14);
            iDKey4.SetValue(currentTimeMillis2 / i);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            arrayList.add(iDKey3);
            arrayList.add(iDKey4);
            g gVar = g.iuh;
            g.d(arrayList, true);
        }
    }

    private void a(l lVar, boolean z) {
        int i = 0;
        if (lVar == null) {
            v.e("MicroMsg.ShareCardDataMgr", "don't parserShareCardListData, data is null");
            return;
        }
        Map hashMap;
        Map hashMap2;
        Map hashMap3;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        m mVar;
        v.i("MicroMsg.ShareCardDataMgr", "parserShareCardListData()");
        Map map = (Map) af.aap().getValue("key_share_card_annoucement_map");
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = map;
        }
        map = (Map) af.aap().getValue("key_share_card_count_map");
        if (map == null) {
            hashMap2 = new HashMap();
        } else {
            hashMap2 = map;
        }
        map = (Map) af.aap().getValue("key_share_card_username_map");
        if (map == null) {
            hashMap3 = new HashMap();
        } else {
            hashMap3 = map;
        }
        ArrayList arrayList4 = (ArrayList) af.aap().getValue("key_share_card_local_city_ids");
        if (arrayList4 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList4;
        }
        arrayList4 = (ArrayList) af.aap().getValue("key_share_card_other_city_ids");
        if (arrayList4 == null) {
            arrayList2 = new ArrayList();
        } else {
            arrayList2 = arrayList4;
        }
        arrayList4 = (ArrayList) af.aap().getValue("key_share_card_other_city_top_info_list");
        if (arrayList4 == null) {
            arrayList3 = new ArrayList();
        } else {
            arrayList3 = arrayList4;
        }
        if (z) {
            arrayList.clear();
            arrayList2.clear();
            arrayList3.clear();
        }
        ArrayList arrayList5 = new ArrayList();
        if (lVar.eED != null && lVar.eED.size() > 0) {
            for (int i2 = 0; i2 < lVar.eED.size(); i2++) {
                mVar = (m) lVar.eED.get(i2);
                if (!TextUtils.isEmpty(mVar.eEN)) {
                    hashMap.put(mVar.eBK, mVar.eEN);
                }
                hashMap2.put(mVar.eBK, Integer.valueOf(af.aas().pZ(mVar.eBK)));
                hashMap3.put(mVar.eBK, r(af.aas().pY(mVar.eBK)));
                if (!arrayList5.contains(mVar.eBK)) {
                    CharSequence qa = af.aas().qa(mVar.eBK);
                    if (!TextUtils.isEmpty(qa) && !arrayList.contains(qa)) {
                        arrayList.add(qa);
                    } else if (!arrayList.contains(mVar.bol)) {
                        arrayList.add(mVar.bol);
                    }
                    arrayList5.add(mVar.eBK);
                    com.tencent.mm.plugin.card.sharecard.model.p pVar = new com.tencent.mm.plugin.card.sharecard.model.p();
                    pVar.eBK = mVar.eBK;
                    pVar.top = mVar.top;
                    arrayList3.add(pVar);
                }
            }
        }
        arrayList5.clear();
        if (lVar.eEE != null && lVar.eEE.size() > 0) {
            while (i < lVar.eEE.size()) {
                mVar = (m) lVar.eEE.get(i);
                if (!TextUtils.isEmpty(mVar.eEN)) {
                    hashMap.put(mVar.eBK, mVar.eEN);
                }
                hashMap2.put(mVar.eBK, Integer.valueOf(af.aas().pZ(mVar.eBK)));
                hashMap3.put(mVar.eBK, r(af.aas().pY(mVar.eBK)));
                if (!arrayList5.contains(mVar.eBK)) {
                    CharSequence qa2 = af.aas().qa(mVar.eBK);
                    if (!TextUtils.isEmpty(qa2) && !arrayList2.contains(qa2)) {
                        arrayList2.add(qa2);
                    } else if (!arrayList2.contains(mVar.bol)) {
                        arrayList2.add(mVar.bol);
                    }
                    arrayList5.add(mVar.eBK);
                    com.tencent.mm.plugin.card.sharecard.model.p pVar2 = new com.tencent.mm.plugin.card.sharecard.model.p();
                    pVar2.eBK = mVar.eBK;
                    pVar2.top = mVar.top;
                    arrayList3.add(pVar2);
                }
                i++;
            }
        }
        af.aap().putValue("key_share_card_annoucement_map", hashMap);
        af.aap().putValue("key_share_card_count_map", hashMap2);
        af.aap().putValue("key_share_card_username_map", hashMap3);
        af.aap().putValue("key_share_card_local_city", lVar.eEF);
        af.aap().putValue("key_share_card_local_city_ids", arrayList);
        af.aap().putValue("key_share_card_other_city_ids", arrayList2);
        af.aap().putValue("key_share_card_other_city_top_info_list", arrayList3);
    }

    private static void a(l lVar, l lVar2, boolean z) {
        if (lVar == null && lVar2 == null) {
            v.e("MicroMsg.ShareCardDataMgr", "don't updateCategoryType(), newData == null && oldData == null");
        } else if (lVar != null && lVar.eEE == null && lVar.eED == null && lVar2 != null && lVar2.eEE == null && lVar2.eED == null) {
            v.e("MicroMsg.ShareCardDataMgr", "don't updateCategoryType(), newData.local_city_list == null && oldData.local_city_list == null");
        } else {
            ArrayList arrayList;
            ArrayList arrayList2;
            int i;
            m mVar;
            v.i("MicroMsg.ShareCardDataMgr", "updateCategoryType()");
            ArrayList arrayList3 = (ArrayList) af.aap().getValue("key_share_card_local_city_category_info_list");
            if (arrayList3 == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = arrayList3;
            }
            arrayList3 = (ArrayList) af.aap().getValue("key_share_card_other_city_category_info_list");
            if (arrayList3 == null) {
                arrayList2 = new ArrayList();
            } else {
                arrayList2 = arrayList3;
            }
            int i2 = 0;
            if (z) {
                af.aas().iZ(10);
                arrayList.clear();
                af.aas().iZ(0);
                arrayList2.clear();
                i = 0;
                i2 = 0;
            } else {
                if (!(lVar2 == null || lVar2.eED == null || lVar2.eED.size() < 0)) {
                    i2 = lVar2.eED.size();
                }
                if (lVar2 == null || lVar2.eEE == null || lVar2.eEE.size() < 0) {
                    i = i2;
                    i2 = 0;
                } else {
                    i = i2;
                    i2 = lVar2.eEE.size();
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            ak.yW();
            long er = com.tencent.mm.model.c.wE().er(Thread.currentThread().getId());
            if (lVar != null && lVar.eED != null && lVar.eED.size() > 0) {
                for (int i3 = 0; i3 < lVar.eED.size(); i3++) {
                    mVar = (m) lVar.eED.get(i3);
                    af.aas().w(mVar.eBK, 10, i3 + i);
                    i iVar = new i();
                    iVar.eBK = mVar.eBK;
                    iVar.eEy = i3 + i;
                    arrayList.add(iVar);
                }
                if (!(z || lVar2 == null || lVar2.eED == null)) {
                    lVar.eED.addAll(lVar2.eED);
                }
            } else if (!(lVar == null || z || lVar2 == null || lVar2.eED == null)) {
                lVar.eED = lVar2.eED;
            }
            af.aap().putValue("key_share_card_local_city_category_info_list", arrayList);
            if (lVar != null && lVar.eEE != null && lVar.eEE.size() > 0) {
                for (int i4 = 0; i4 < lVar.eEE.size(); i4++) {
                    mVar = (m) lVar.eEE.get(i4);
                    af.aas().w(mVar.eBK, 0, i4 + i2);
                    i iVar2 = new i();
                    iVar2.eBK = mVar.eBK;
                    iVar2.eEy = i4 + i2;
                    arrayList2.add(iVar2);
                }
                if (!(z || lVar2 == null || lVar2.eEE == null)) {
                    lVar.eEE.addAll(lVar2.eEE);
                }
            } else if (!(lVar == null || z || lVar2 == null || lVar2.eEE == null)) {
                lVar.eEE = lVar2.eEE;
            }
            af.aap().putValue("key_share_card_other_city_category_info_list", arrayList2);
            ak.yW();
            com.tencent.mm.model.c.wE().es(er);
            v.d("MicroMsg.ShareCardDataMgr", "updateCategoryType  >> updateCategoryInfo use time %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
    }

    public static void aaB() {
        ArrayList arrayList;
        ArrayList arrayList2;
        long currentTimeMillis = System.currentTimeMillis();
        ak.yW();
        long er = com.tencent.mm.model.c.wE().er(Thread.currentThread().getId());
        v.i("MicroMsg.ShareCardDataMgr", "updateShareCardCategory()");
        ArrayList arrayList3 = (ArrayList) af.aap().getValue("key_share_card_local_city_category_info_list");
        if (arrayList3 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList3;
        }
        arrayList3 = (ArrayList) af.aap().getValue("key_share_card_other_city_category_info_list");
        if (arrayList3 == null) {
            arrayList2 = new ArrayList();
        } else {
            arrayList2 = arrayList3;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            i iVar = (i) arrayList.get(i);
            af.aas().w(iVar.eBK, 10, iVar.eEy);
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            iVar = (i) arrayList2.get(i2);
            af.aas().w(iVar.eBK, 0, iVar.eEy);
        }
        ak.yW();
        com.tencent.mm.model.c.wE().es(er);
        v.i("MicroMsg.ShareCardDataMgr", "updateShareCardCategory  >> updateCategoryInfo use time %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    private String r(ArrayList<String> arrayList) {
        return a(this.mContext, (ArrayList) arrayList);
    }

    private static String a(Context context, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            v.e("MicroMsg.ShareCardDataMgr", "getShareUserName， username_list == null || username_list.size() == 0");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < arrayList.size() && i < 2) {
            if (i != 0) {
                stringBuilder.append("、");
            }
            Object et = com.tencent.mm.model.l.et((String) arrayList.get(i));
            String er = com.tencent.mm.model.l.er((String) arrayList.get(i));
            if (TextUtils.isEmpty(et)) {
                stringBuilder.append(er);
            } else {
                stringBuilder.append(et);
            }
            i++;
        }
        if (context == null) {
            v.e("MicroMsg.ShareCardDataMgr", "context == null");
            return "";
        } else if (arrayList.size() == 1 || arrayList.size() == 2) {
            return context.getString(2131231693, new Object[]{stringBuilder.toString()});
        } else {
            return context.getString(2131231676, new Object[]{stringBuilder.toString(), Integer.valueOf(arrayList.size())});
        }
    }

    public static void pS(final String str) {
        v.i("MicroMsg.ShareCardDataMgr", "updateShareUserInfo()");
        if (TextUtils.isEmpty(str)) {
            v.e("MicroMsg.ShareCardDataMgr", "updateShareUserInfo(), card_tp_id is empty");
            return;
        }
        final ac acVar = new ac(Looper.getMainLooper());
        e.a(new Runnable() {
            public final void run() {
                ArrayList arrayList = null;
                v.i("MicroMsg.ShareCardDataMgr", "begin to getShareUserInfo()");
                k aas = af.aas();
                String str = str;
                v.i("MicroMsg.ShareCardInfoStorage", "getShareUserInfo()");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(" where ( status=0) ");
                stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
                stringBuilder.append(" order by share_time desc ");
                Cursor rawQuery = aas.cie.rawQuery("select * from ShareCardInfo" + stringBuilder.toString(), null);
                if (rawQuery == null) {
                    v.i("MicroMsg.ShareCardInfoStorage", "getShareUserInfo(), cursor == null");
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    rawQuery.moveToFirst();
                    while (!rawQuery.isAfterLast()) {
                        ShareCardInfo shareCardInfo = new ShareCardInfo();
                        shareCardInfo.b(rawQuery);
                        r rVar;
                        if (arrayList3.contains(shareCardInfo.field_from_username)) {
                            int i = 0;
                            rVar = null;
                            while (i < arrayList2.size()) {
                                rVar = (r) arrayList2.get(i);
                                if (shareCardInfo.field_from_username != null && shareCardInfo.field_from_username.equals(rVar.eES)) {
                                    break;
                                }
                                i++;
                            }
                            i = 0;
                            rVar.eEU.add(0, shareCardInfo.field_card_id);
                            rVar.eET++;
                            arrayList2.set(i, rVar);
                        } else {
                            rVar = new r();
                            rVar.eBK = shareCardInfo.field_card_tp_id;
                            rVar.eES = shareCardInfo.field_from_username;
                            rVar.eEU = new ArrayList();
                            rVar.eEU.add(shareCardInfo.field_card_id);
                            rVar.eET = 1;
                            arrayList2.add(rVar);
                            arrayList3.add(shareCardInfo.field_from_username);
                        }
                        rawQuery.moveToNext();
                    }
                    rawQuery.close();
                    arrayList = arrayList2;
                }
                v.i("MicroMsg.ShareCardDataMgr", "end to getShareUserInfo(), 1");
                if (arrayList == null || arrayList.size() == 0) {
                    v.e("MicroMsg.ShareCardDataMgr", "getShareUserInfo(), share_user_list is null");
                    return;
                }
                if (arrayList.get(0) != null) {
                    ((r) arrayList.get(0)).eEV = true;
                }
                v.i("MicroMsg.ShareCardDataMgr", "end to getShareUserInfo(), 2");
                acVar.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 eEt;

                    public final void run() {
                        Map map = (Map) af.aap().getValue("key_share_user_info_map");
                        if (map == null) {
                            map = new HashMap();
                        }
                        map.put(str, arrayList);
                        af.aap().putValue("key_share_user_info_map", map);
                    }
                });
            }
        }, "updateShareUserInfo_thread");
    }

    public static ArrayList<String> iV(int i) {
        ArrayList<String> arrayList;
        if (i == 1) {
            arrayList = (ArrayList) af.aap().getValue("key_share_card_local_city_ids");
            if (arrayList != null && arrayList.size() != 0) {
                return arrayList;
            }
            v.e("MicroMsg.ShareCardDataMgr", "getCardIds() ids == null || ids.size() == 0 for showType == " + i);
            return iW(i);
        } else if (i != 2) {
            return null;
        } else {
            arrayList = (ArrayList) af.aap().getValue("key_share_card_other_city_ids");
            if (arrayList != null && arrayList.size() != 0) {
                return arrayList;
            }
            v.e("MicroMsg.ShareCardDataMgr", "getCardIds() ids == null || ids.size() == 0 for showType == " + i);
            return iW(i);
        }
    }

    private static ArrayList<String> iW(int i) {
        l lVar = (l) af.aap().getValue("key_share_card_layout_data");
        if (lVar == null) {
            v.e("MicroMsg.ShareCardDataMgr", "getCardIdsByType() data == null for showType = " + i);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2;
        m mVar;
        CharSequence qa;
        if (i == 1) {
            if (lVar.eED != null && lVar.eED.size() > 0) {
                for (i2 = 0; i2 < lVar.eED.size(); i2++) {
                    mVar = (m) lVar.eED.get(i2);
                    if (!arrayList2.contains(mVar.eBK)) {
                        qa = af.aas().qa(mVar.eBK);
                        if (!TextUtils.isEmpty(qa) && !arrayList.contains(qa)) {
                            arrayList.add(qa);
                        } else if (!arrayList.contains(mVar.bol)) {
                            arrayList.add(mVar.bol);
                        }
                        arrayList2.add(mVar.eBK);
                    }
                }
                af.aap().putValue("key_share_card_local_city_ids", arrayList);
            }
            return arrayList;
        } else if (i != 2) {
            return null;
        } else {
            if (lVar.eEE != null && lVar.eEE.size() > 0) {
                for (i2 = 0; i2 < lVar.eEE.size(); i2++) {
                    mVar = (m) lVar.eEE.get(i2);
                    if (!arrayList2.contains(mVar.eBK)) {
                        qa = af.aas().qa(mVar.eBK);
                        if (!TextUtils.isEmpty(qa) && !arrayList.contains(qa)) {
                            arrayList.add(qa);
                        } else if (!arrayList.contains(mVar.bol)) {
                            arrayList.add(mVar.bol);
                        }
                        arrayList2.add(mVar.eBK);
                    }
                }
                af.aap().putValue("key_share_card_other_city_ids", arrayList);
            }
            return arrayList;
        }
    }

    public static void bf(String str, String str2) {
        if (cwY) {
            v.i("MicroMsg.ShareCardDataMgr", "is isUpdating data, don't do updateCardIdsListByCardId");
            return;
        }
        CharSequence bi;
        v.i("MicroMsg.ShareCardDataMgr", "do updateCardIdsListByCardId");
        cwY = true;
        ArrayList iV = iV(1);
        if (iV != null && iV.contains(str)) {
            iV.remove(str);
            bi = af.aas().bi(str, str2);
            if (!TextUtils.isEmpty(bi)) {
                iV.add(bi);
            }
            af.aap().putValue("key_share_card_local_city_ids", iV);
        }
        iV = iV(2);
        if (iV != null && iV.contains(str)) {
            iV.remove(str);
            bi = af.aas().bi(str, str2);
            if (!TextUtils.isEmpty(bi)) {
                iV.add(bi);
            }
            af.aap().putValue("key_share_card_other_city_ids", iV);
        }
        cwY = false;
    }

    public static void bg(String str, String str2) {
        v.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId card_id:" + str + ", card_tp_id:" + str2);
        ArrayList iV = iV(1);
        if (iV == null || !iV.contains(str)) {
            ArrayList iV2 = iV(2);
            if (iV2 == null || !iV2.contains(str)) {
                l lVar = (l) af.aap().getValue("key_share_card_layout_data");
                if (lVar == null) {
                    v.e("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId data == null");
                    return;
                }
                int pZ = af.aas().pZ(str2);
                int pU = pU(str2);
                v.e("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId realCount:" + pZ + " cacheCount:" + pU);
                if (lVar.eED == null || lVar.eED.size() <= 0 || (pU > 0 && pZ != 1)) {
                    v.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId, not add for local_ids");
                } else {
                    int i = 0;
                    while (i < lVar.eED.size()) {
                        m mVar = (m) lVar.eED.get(i);
                        if (str2 == null || !str2.contains(mVar.eBK)) {
                            i++;
                        } else {
                            iV.add(str);
                            af.aap().putValue("key_share_card_local_city_ids", iV);
                            v.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId add for local ids, card id is " + str);
                            return;
                        }
                    }
                }
                if (iV2 == null || (pU > 0 && pZ != 1)) {
                    v.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId, not add for other_ids");
                    return;
                }
                iV2.add(str);
                af.aap().putValue("key_share_card_other_city_ids", iV2);
                v.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId add for other ids, card id is " + str);
            }
        }
    }

    public static int aaC() {
        if (aaE()) {
            return 1;
        }
        if (!aaD()) {
            return 0;
        }
        if (eEp) {
            return 3;
        }
        return 4;
    }

    public static boolean aaD() {
        ArrayList arrayList = (ArrayList) af.aap().getValue("key_share_card_other_city_ids");
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return true;
    }

    public static boolean aaE() {
        ArrayList arrayList = (ArrayList) af.aap().getValue("key_share_card_local_city_ids");
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return true;
    }

    public static String pT(String str) {
        Map map = (Map) af.aap().getValue("key_share_card_annoucement_map");
        if (map == null) {
            return "";
        }
        return (String) map.get(str);
    }

    public static int pU(String str) {
        Map map = (Map) af.aap().getValue("key_share_card_count_map");
        if (map == null) {
            return 0;
        }
        Integer num = (Integer) map.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static String hU(String str) {
        Map map = (Map) af.aap().getValue("key_share_card_username_map");
        if (map == null) {
            return "";
        }
        return (String) map.get(str);
    }

    public static ArrayList<r> pV(String str) {
        Map map = (Map) af.aap().getValue("key_share_user_info_map");
        if (map == null) {
            map = new HashMap();
        }
        ArrayList<r> arrayList = (ArrayList) map.get(str);
        if (arrayList == null) {
            return new ArrayList();
        }
        return arrayList;
    }

    private static void x(String str, String str2, String str3) {
        Map hashMap;
        ArrayList arrayList;
        Map map = (Map) af.aap().getValue("key_share_user_info_map");
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = map;
        }
        ArrayList arrayList2 = (ArrayList) hashMap.get(str2);
        if (arrayList2 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList2;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            r rVar = (r) arrayList.get(i);
            if (str3 != null && str3.equals(rVar.eES)) {
                rVar.eEV = false;
                rVar.eET--;
                rVar.eEU.remove(str);
                arrayList.set(i, rVar);
            }
        }
        hashMap.put(str2, arrayList);
        af.aap().putValue("key_share_user_info_map", hashMap);
    }

    public static void aaF() {
        v.i("MicroMsg.ShareCardDataMgr", "delelteAllIllegalStatusCard()");
        e.a(new Runnable() {
            public final void run() {
                v.i("MicroMsg.ShareCardDataMgr", "begin to delelteAllIllegalStatusCard()");
                k aas = af.aas();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(" where (status=1 OR ").append("status=2 OR status").append("=3 OR status=4").append(" OR status=6)");
                v.i("MicroMsg.ShareCardInfoStorage", "delelteAllIllegalStatusCard updateRet is " + (aas.cie.dF("ShareCardInfo", new StringBuilder("delete from ShareCardInfo").append(stringBuilder.toString()).toString()) ? 1 : 0));
                v.i("MicroMsg.ShareCardDataMgr", "end to delelteAllIllegalStatusCard()");
            }
        }, "delelteAllIllegalStatusCard");
    }

    public static void K(Context context, String str) {
        Map hashMap;
        v.i("MicroMsg.ShareCardDataMgr", "updateCardCountbyCardTpId() card_tp_id:" + str);
        Map map = (Map) af.aap().getValue("key_share_card_count_map");
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = map;
        }
        map = (Map) af.aap().getValue("key_share_card_username_map");
        if (map == null) {
            map = new HashMap();
        }
        hashMap.put(str, Integer.valueOf(af.aas().pZ(str)));
        map.put(str, a(context, af.aas().pY(str)));
        af.aap().putValue("key_share_card_count_map", hashMap);
        af.aap().putValue("key_share_card_username_map", map);
    }

    public static boolean iX(int i) {
        Integer num = (Integer) af.aap().getValue("key_share_card_show_type");
        if (num == null) {
            return false;
        }
        if (num.intValue() == 0) {
            return false;
        }
        ArrayList arrayList;
        if (i == 0) {
            arrayList = (ArrayList) af.aap().getValue("key_share_card_other_city_ids");
            if (arrayList == null || arrayList.size() == 0) {
                return false;
            }
            return true;
        } else if (i != 10) {
            return false;
        } else {
            arrayList = (ArrayList) af.aap().getValue("key_share_card_local_city_ids");
            if (arrayList == null || arrayList.size() == 0) {
                return false;
            }
            return true;
        }
    }

    public static boolean pW(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ArrayList arrayList = (ArrayList) af.aap().getValue("key_share_card_other_city_top_info_list");
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.card.sharecard.model.p pVar = (com.tencent.mm.plugin.card.sharecard.model.p) it.next();
            if (pVar != null && str.equals(pVar.eBK) && pVar.top == 1) {
                return true;
            }
        }
        return false;
    }

    public static void pX(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList;
            ArrayList arrayList2 = (ArrayList) af.aap().getValue("key_share_card_other_city_top_info_list");
            if (arrayList2 == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = arrayList2;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                com.tencent.mm.plugin.card.sharecard.model.p pVar = (com.tencent.mm.plugin.card.sharecard.model.p) arrayList.get(i);
                if (pVar != null && str.equals(pVar.eBK) && pVar.top == 1) {
                    pVar.eER = true;
                    arrayList.set(i, pVar);
                    af.aap().putValue("key_share_card_other_city_top_info_list", arrayList);
                    return;
                }
            }
        }
    }

    public static String bh(String str, String str2) {
        v.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId()");
        if (str2 != null) {
            ArrayList pV = pV(str2);
            if (pV == null || pV.size() <= 0) {
                v.e("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), shareUserInfoList is null");
                return str;
            }
            r rVar = (r) pV.get(0);
            if (rVar == null || rVar.eEU == null || rVar.eEU.size() <= 0 || str.equals(rVar.eEU.get(0))) {
                v.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), mCardId is first!");
                return str;
            }
            String str3 = (String) rVar.eEU.get(0);
            v.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), mCardId is not first!, reset it");
            return str3;
        }
        v.e("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), card_tp_id is null");
        return str;
    }

    public static boolean aaG() {
        l lVar = (l) af.aap().getValue("key_share_card_layout_data");
        if (lVar == null) {
            return true;
        }
        return lVar.eEG;
    }

    public static boolean aaH() {
        l lVar = (l) af.aap().getValue("key_share_card_layout_data");
        if (lVar == null) {
            return true;
        }
        return lVar.eEH;
    }

    public static void a(Context context, com.tencent.mm.plugin.card.base.b bVar) {
        v.i("MicroMsg.ShareCardDataMgr", "updateShareCardData()");
        v.i("MicroMsg.ShareCardDataMgr", "card id:" + bVar.Zz() + " cardtpid:" + bVar.ZA());
        bf(bVar.Zz(), bVar.ZA());
        if (context != null) {
            K(context, bVar.ZA());
        }
        x(bVar.Zz(), bVar.ZA(), bVar.ZB());
        pS(bVar.ZA());
    }
}
