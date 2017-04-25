package com.tencent.mm.storage;

import com.tencent.mm.j.a;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class ab extends a implements com.tencent.mm.m.a.a<String> {
    public at nuz;

    public final /* bridge */ /* synthetic */ Object getKey() {
        return this.field_username;
    }

    public ab(String str) {
        super(str);
    }

    public final void M(at atVar) {
        ab abVar;
        long j;
        ab abVar2;
        dh(atVar.field_status);
        di(atVar.field_isSend);
        if (atVar.bwo()) {
            abVar = this;
        } else if (atVar.field_status == 1) {
            j = Long.MAX_VALUE;
            abVar2 = this;
            abVar2.s(j);
            if (atVar.bwi()) {
                setContent(atVar.field_content);
            } else {
                setContent(atVar.bwC());
            }
        } else {
            abVar = this;
        }
        abVar2 = abVar;
        j = atVar.field_createTime;
        abVar2.s(j);
        if (atVar.bwi()) {
            setContent(atVar.field_content);
        } else {
            setContent(atVar.bwC());
        }
    }

    public final void bvG() {
        dh(0);
        di(0);
        setContent(SQLiteDatabase.KeyEmpty);
        ct("0");
        df(0);
        do(0);
        u(0);
        dn(0);
        super.cu(SQLiteDatabase.KeyEmpty);
        super.cv(SQLiteDatabase.KeyEmpty);
    }

    private void A(int i, long j) {
        switch (i) {
            case 0:
                df((int) j);
                return;
            case 1:
                dh((int) j);
                return;
            case 2:
                di((int) j);
                return;
            case 3:
                s(j);
                return;
            case 7:
                t(j);
                return;
            case 10:
                dk((int) j);
                return;
            case 12:
                dl((int) j);
                return;
            case 14:
                do((int) j);
                return;
            default:
                return;
        }
    }

    public final void e(int i, byte[] bArr) {
    }

    public final void j(int i, long j) {
        A(i, j);
    }

    public final void k(int i, long j) {
        A(i, j);
    }

    public final void n(int i, String str) {
        switch (i) {
            case 4:
                setUsername(str);
                return;
            case 5:
                setContent(str);
                return;
            case 6:
                ct(str);
                return;
            case 8:
                cu(str);
                return;
            case 9:
                cv(str);
                return;
            case 11:
                cx(str);
                return;
            default:
                return;
        }
    }

    public final void tY() {
    }
}
