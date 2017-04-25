package com.tencent.mm.plugin.card.sharecard.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.plugin.card.model.j.a;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;

public final class k extends f<ShareCardInfo> {
    public static final String[] cic = new String[]{f.a(ShareCardInfo.chq, "ShareCardInfo")};
    public d cie;

    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] eCA = new int[a.aag().length];

        static {
            try {
                eCA[a.eDg - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                eCA[a.eDh - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                eCA[a.eDi - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static String iY(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList iV = b.iV(i);
        if (iV == null || iV.size() <= 0) {
            return "";
        }
        stringBuilder.append(" (");
        for (int i2 = 0; i2 < iV.size(); i2++) {
            if (i2 != 0) {
                stringBuilder.append(" OR ");
            }
            stringBuilder.append("card_id").append(" = '" + ((String) iV.get(i2)) + "' ");
        }
        stringBuilder.append(") AND ");
        return stringBuilder.toString();
    }

    public k(d dVar) {
        super(dVar, ShareCardInfo.chq, "ShareCardInfo", null);
        this.cie = dVar;
    }

    public final ArrayList<String> pY(String str) {
        v.i("MicroMsg.ShareCardInfoStorage", new StringBuilder("queryNameByCardtpId(), limit is 99").toString());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        stringBuilder.append(" order by share_time desc ");
        stringBuilder.append(new StringBuilder(" limit 99").toString());
        Cursor rawQuery = this.cie.rawQuery("select ShareCardInfo.from_username from ShareCardInfo" + stringBuilder.toString(), null);
        if (rawQuery == null) {
            v.i("MicroMsg.ShareCardInfoStorage", "queryNameByCardtpId(), cursor == null");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        rawQuery.moveToFirst();
        int columnIndex = rawQuery.getColumnIndex("from_username");
        if (columnIndex == -1) {
            v.i("MicroMsg.ShareCardInfoStorage", "queryNameByCardtpId(), index is wrong");
            return null;
        }
        while (!rawQuery.isAfterLast()) {
            CharSequence string = rawQuery.getString(columnIndex);
            if (TextUtils.isEmpty(string) || arrayList.contains(string)) {
                v.e("MicroMsg.ShareCardInfoStorage", "the field_from_username is empty or username is added!, the card id is " + str);
            } else {
                arrayList.add(string);
            }
            if (arrayList.size() >= 99) {
                break;
            }
            rawQuery.moveToNext();
        }
        rawQuery.close();
        return arrayList;
    }

    public final int pZ(String str) {
        int i = 0;
        v.i("MicroMsg.ShareCardInfoStorage", "getNormalCount()");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        Cursor rawQuery = this.cie.rawQuery("select count(*) from ShareCardInfo" + stringBuilder.toString(), null);
        if (rawQuery == null) {
            v.i("MicroMsg.ShareCardInfoStorage", "getNormalCount(), cursor == null");
        } else {
            if (rawQuery.moveToFirst()) {
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        return i;
    }

    public final String qa(String str) {
        v.i("MicroMsg.ShareCardInfoStorage", "queryCardIdByCardtpId()");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        stringBuilder.append(" order by share_time desc ");
        stringBuilder.append(" limit 1");
        Cursor rawQuery = this.cie.rawQuery("select ShareCardInfo.card_id from ShareCardInfo" + stringBuilder.toString(), null);
        if (rawQuery == null) {
            v.i("MicroMsg.ShareCardInfoStorage", "queryCardIdByCardtpId(), cursor == null");
            return "";
        }
        int columnIndex = rawQuery.getColumnIndex("card_id");
        if (columnIndex == -1) {
            v.i("MicroMsg.ShareCardInfoStorage", "queryCardIdByCardtpId(), index is wrong");
            return "";
        }
        String str2 = "";
        rawQuery.moveToFirst();
        if (!rawQuery.isAfterLast()) {
            str2 = rawQuery.getString(columnIndex);
        }
        rawQuery.close();
        return str2;
    }

    public final String bi(String str, String str2) {
        v.i("MicroMsg.ShareCardInfoStorage", "queryNewCardIdByCardtpId()");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str2 + "' )");
        stringBuilder.append(" order by share_time desc ");
        stringBuilder.append(" limit 2");
        Cursor rawQuery = this.cie.rawQuery("select ShareCardInfo.card_id from ShareCardInfo" + stringBuilder.toString(), null);
        if (rawQuery == null) {
            v.i("MicroMsg.ShareCardInfoStorage", "queryNewCardIdByCardtpId(), cursor == null");
            return "";
        }
        int columnIndex = rawQuery.getColumnIndex("card_id");
        if (columnIndex == -1) {
            v.i("MicroMsg.ShareCardInfoStorage", "queryNewCardIdByCardtpId(), index is wrong");
            return "";
        }
        String str3 = "";
        rawQuery.moveToFirst();
        while (!rawQuery.isAfterLast()) {
            str3 = rawQuery.getString(columnIndex);
            if (str != null && !str.equals(str3)) {
                break;
            }
            rawQuery.moveToNext();
        }
        rawQuery.close();
        return str3;
    }

    public final boolean iZ(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (");
        stringBuilder.append("categoryType").append(" = '" + i + "'");
        stringBuilder.append(")");
        boolean dF = this.cie.dF("ShareCardInfo", "update ShareCardInfo set categoryType = '0' , itemIndex = '0' " + stringBuilder.toString());
        v.i("MicroMsg.ShareCardInfoStorage", "resetCategoryInfo updateRet is " + (dF ? 1 : 0));
        return dF;
    }

    public final boolean w(String str, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        boolean dF = this.cie.dF("ShareCardInfo", "update ShareCardInfo set categoryType = '" + i + "', itemIndex = '" + i2 + "' " + stringBuilder.toString());
        v.i("MicroMsg.ShareCardInfoStorage", "updateCategoryInfo updateRet is " + (dF ? 1 : 0));
        return dF;
    }

    public final void qb(String str) {
        this.cie.dF("ShareCardInfo", "delete from ShareCardInfo where card_id = '" + str + "'");
    }

    public final ShareCardInfo qc(String str) {
        ShareCardInfo shareCardInfo = new ShareCardInfo();
        shareCardInfo.field_card_id = str;
        return super.b(shareCardInfo, new String[0]) ? shareCardInfo : null;
    }
}
