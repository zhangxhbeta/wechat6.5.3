package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.m.a.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.v;

public final class f implements a<String> {
    public long chr;
    public String field_alias;
    public String field_conRemark;
    public int field_deleteFlag;
    public byte[] field_lvbuff;
    public String field_nickname;
    public String field_remarkDesc;
    public int field_showHead;
    public String field_signature;
    public String field_username;
    public int field_verifyFlag;
    public int field_weiboFlag;
    public CharSequence nnS;

    public final /* bridge */ /* synthetic */ Object getKey() {
        return this.field_username;
    }

    public final void b(Cursor cursor) {
        this.field_username = cursor.getString(0);
        this.field_nickname = cursor.getString(1);
        this.field_alias = cursor.getString(2);
        this.field_conRemark = cursor.getString(3);
        this.field_verifyFlag = cursor.getInt(4);
        this.field_showHead = cursor.getInt(5);
        this.field_weiboFlag = cursor.getInt(6);
        this.chr = cursor.getLong(7);
        this.field_deleteFlag = cursor.getInt(8);
        this.field_lvbuff = cursor.getBlob(9);
        bva();
    }

    private void bva() {
        if (this.field_lvbuff != null) {
            try {
                if (this.field_lvbuff != null && this.field_lvbuff.length != 0) {
                    s sVar = new s();
                    if (sVar.bg(this.field_lvbuff) == 0) {
                        sVar.uW(4);
                        sVar.uW(4);
                        sVar.bsQ();
                        sVar.uW(8);
                        sVar.uW(4);
                        sVar.bsQ();
                        sVar.bsQ();
                        sVar.uW(4);
                        sVar.uW(4);
                        sVar.bsQ();
                        sVar.bsQ();
                        sVar.uW(4);
                        sVar.uW(4);
                        this.field_signature = sVar.getString();
                        sVar.bsQ();
                        sVar.bsQ();
                        sVar.bsQ();
                        sVar.uW(4);
                        sVar.uW(4);
                        sVar.bsQ();
                        sVar.uW(4);
                        sVar.bsQ();
                        sVar.bsQ();
                        sVar.uW(4);
                        sVar.uW(4);
                        if (!sVar.bsR()) {
                            this.field_remarkDesc = sVar.getString();
                        }
                        this.field_lvbuff = null;
                    }
                }
            } catch (Throwable e) {
                v.e("MicroMsg.AddressUIContact", "exception:%s", be.e(e));
            }
        }
    }

    public final void e(int i, byte[] bArr) {
        if (i == 9) {
            this.field_lvbuff = bArr;
        }
    }

    public final void j(int i, long j) {
        z(i, j);
    }

    public final void k(int i, long j) {
        z(i, j);
    }

    private void z(int i, long j) {
        switch (i) {
            case 4:
                this.field_verifyFlag = (int) j;
                return;
            case 5:
                this.field_showHead = (int) j;
                return;
            case 6:
                this.field_weiboFlag = (int) j;
                return;
            case 7:
                this.chr = j;
                return;
            case 8:
                this.field_deleteFlag = (int) j;
                return;
            default:
                return;
        }
    }

    public final void n(int i, String str) {
        switch (i) {
            case 0:
                this.field_username = str;
                return;
            case 1:
                this.field_nickname = str;
                return;
            case 2:
                this.field_alias = str;
                return;
            case 3:
                this.field_conRemark = str;
                return;
            default:
                return;
        }
    }

    public final void tY() {
        bva();
    }
}
