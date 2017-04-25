package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.mm.plugin.card.model.j.a;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;

public final class c extends f<CardInfo> {
    public static final String[] cic = new String[]{f.a(CardInfo.chq, "UserCardInfo"), "CREATE INDEX IF NOT EXISTS  stickyIndexIndex ON UserCardInfo ( stickyIndex ) "};
    public d cie;

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] eCA = new int[a.aag().length];

        static {
            try {
                eCA[a.eDg - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                eCA[a.eDk - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                eCA[a.eDl - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                eCA[a.eDj - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                eCA[a.eDh - 1] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                eCA[a.eDi - 1] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public c(d dVar) {
        super(dVar, CardInfo.chq, "UserCardInfo", null);
        this.cie = dVar;
    }

    public final Cursor iU(int i) {
        this.cie.dF("UserCardInfo", "update UserCardInfo set stickyIndex=0, stickyEndTime=0 where stickyIndex>0 and (" + be.Nh() + ">stickyEndTime and stickyEndTime" + "<>0)");
        StringBuilder stringBuilder = new StringBuilder("select * from UserCardInfo");
        switch (AnonymousClass1.eCA[i - 1]) {
            case 1:
                stringBuilder.append(" where (status=0 OR ").append("status=5)");
                break;
            case 2:
            case 3:
                stringBuilder.append(" where (status=0 OR ").append("status=5) AND ").append("card_type=10");
                break;
            case 4:
                stringBuilder.append(" where (status=0 OR ").append("status=5) AND ").append("card_type!=10");
                break;
            case 5:
                stringBuilder.append(" where (status=1 OR ").append("status=2 OR status").append("=3 OR status=4").append(" OR status=6)");
                break;
            case 6:
                stringBuilder.append(" where (status=0 OR ").append("status=5) and (block_mask").append("= '1' OR block_mask= '0' ").append(")");
                break;
        }
        stringBuilder.append(" order by stickyIndex desc, status asc , updateTime desc");
        if (i == a.eDl) {
            stringBuilder.append(" LIMIT 3");
        }
        return this.cie.rawQuery(stringBuilder.toString(), null);
    }

    public final CardInfo pQ(String str) {
        CardInfo cardInfo = new CardInfo();
        cardInfo.field_card_id = str;
        return super.b(cardInfo, new String[0]) ? cardInfo : null;
    }
}
