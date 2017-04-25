package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.j.a;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.k.AnonymousClass1;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.j;

public final class c extends j<ShareCardInfo> {
    private final String TAG = "MicroMsg.ShareCardAdatper";
    long beginTime = 0;
    private int eFV = 0;
    com.tencent.mm.plugin.card.base.c eFW;
    int eFX = -1;
    long endTime = 0;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (ShareCardInfo) obj;
        if (obj == null) {
            obj = new ShareCardInfo();
        }
        if (cursor.isClosed()) {
            v.e("MicroMsg.ShareCardAdatper", "cursor is closed!");
        } else {
            obj.b(cursor);
        }
        return obj;
    }

    public c(Context context) {
        super(context, new ShareCardInfo());
        iQ(true);
        this.eFW = new j(context, this);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.eFW.a(i, view, (ShareCardInfo) getItem(i));
    }

    public final void Ol() {
        Cursor rawQuery;
        this.beginTime = System.currentTimeMillis();
        if (this.eFX == -1) {
            k aas = af.aas();
            int i = a.eDg;
            StringBuilder stringBuilder = new StringBuilder();
            switch (AnonymousClass1.eCA[i - 1]) {
                case 1:
                    stringBuilder.append(" where (status=0 OR ").append("status=5)");
                    break;
                case 2:
                    stringBuilder.append(" where (status=1 OR ").append("status=2 OR status").append("=3 OR status=4").append(" OR status=6)");
                    break;
                case 3:
                    stringBuilder.append(" where (status=0 OR ").append("status=5) and (block_mask").append("= '1' OR block_mask= '0' ").append(")");
                    break;
            }
            rawQuery = aas.cie.rawQuery("select * from ShareCardInfo" + stringBuilder.toString() + " order by status asc , share_time" + " desc", null);
        } else {
            k aas2 = af.aas();
            int i2 = this.eFX;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(" where ( status=0) ");
            String str = "";
            switch (i2) {
                case 1:
                    stringBuilder2.append(" AND ");
                    stringBuilder2.append(" (");
                    stringBuilder2.append(k.iY(1));
                    stringBuilder2.append(" categoryType= '10' ");
                    stringBuilder2.append(") ");
                    str = " order by categoryType desc , itemIndex asc";
                    break;
                case 2:
                    stringBuilder2.append(" AND (");
                    stringBuilder2.append(" (");
                    stringBuilder2.append(k.iY(1));
                    stringBuilder2.append(" categoryType= '10' ");
                    stringBuilder2.append(") ");
                    stringBuilder2.append(" OR (");
                    stringBuilder2.append(k.iY(2));
                    stringBuilder2.append(" categoryType= '0' ");
                    stringBuilder2.append(") ");
                    stringBuilder2.append(" )");
                    str = " order by categoryType desc , itemIndex asc";
                    break;
                case 3:
                    stringBuilder2.append(" AND ");
                    stringBuilder2.append(" (");
                    stringBuilder2.append(k.iY(2));
                    stringBuilder2.append(" categoryType= '0' ");
                    stringBuilder2.append(") ");
                    str = " order by categoryType desc , itemIndex asc";
                    break;
                case 4:
                    stringBuilder2.append(" AND 1 != 1 ");
                    break;
            }
            rawQuery = aas2.cie.rawQuery("select * from ShareCardInfo" + stringBuilder2.toString() + str, null);
        }
        if (rawQuery != null) {
            this.eFV = rawQuery.getCount();
            v.i("MicroMsg.ShareCardAdatper", "resetCursor showType %s, card count:%s", new Object[]{Integer.valueOf(this.eFX), Integer.valueOf(this.eFV)});
        } else {
            v.e("MicroMsg.ShareCardAdatper", "resetCursor cursor is null, showType %s", new Object[]{Integer.valueOf(this.eFX)});
        }
        setCursor(rawQuery);
        this.endTime = System.currentTimeMillis();
        notifyDataSetChanged();
    }

    protected final void Om() {
        avc();
        Ol();
    }
}
