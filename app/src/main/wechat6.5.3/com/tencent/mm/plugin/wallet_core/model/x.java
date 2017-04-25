package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.mm.e.b.df;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.alx;
import com.tencent.mm.protocal.c.bgn;
import com.tencent.mm.protocal.c.bgq;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Field;

public final class x extends df {
    public static a chq;
    public String hbY = "";
    private alx kQF = new alx();
    public bgn kQG = null;
    public bgq kQH = null;
    public boolean kQI = false;
    public String kQJ = "";
    public String kQK = "";
    public String kQL = "";
    public String kQM = "";

    static {
        a aVar = new a();
        aVar.ddU = new Field[2];
        aVar.bXK = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "wallet_region";
        aVar.nmd.put("wallet_region", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "wallet_region";
        aVar.bXK[1] = "wallet_grey_item_buf";
        aVar.nmd.put("wallet_grey_item_buf", "BLOB");
        stringBuilder.append(" wallet_grey_item_buf BLOB");
        aVar.bXK[2] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public x() {
        if (this.kQG == null) {
            this.kQG = new bgn();
        }
        if (this.kQH == null) {
            this.kQH = new bgq();
        }
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        this.kQF = new alx();
        try {
            this.kQF = (alx) this.kQF.az(this.field_wallet_grey_item_buf);
            this.kQG = this.kQF.mMI;
            this.kQH = this.kQF.mMJ;
            this.kQI = this.kQF.mMK;
            this.kQM = this.kQF.kQM;
            if (this.kQF.mMG != null) {
                this.kQJ = m.a(this.kQF.mMG.ncb);
                this.kQK = m.a(this.kQF.mMG.ncc);
            }
            if (this.kQF.mMH != null) {
                this.kQL = m.a(this.kQF.mMH.nbZ);
                this.hbY = m.a(this.kQF.mMH.nca);
            }
            v.v("WalletRegionGreyItem", "noticeContent %s", new Object[]{this.kQL});
        } catch (Exception e) {
            v.e("WalletRegionGreyItem", "parser PayIBGGetOverseaWalletRsp error");
        }
        if (this.kQG == null) {
            this.kQG = new bgn();
        }
        if (this.kQH == null) {
            this.kQH = new bgq();
        }
    }
}
