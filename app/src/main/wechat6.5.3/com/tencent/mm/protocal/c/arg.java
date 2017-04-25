package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class arg extends a {
    public int mQA;
    private boolean mQB;

    protected final /* synthetic */ a aHs() {
        return brN();
    }

    public final /* synthetic */ a az(byte[] bArr) {
        a.a.a.a.a aVar = new a.a.a.a.a(bArr, unknownTagHandler);
        for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
            if (!a(aVar, this, a)) {
                aVar.bQL();
            }
        }
        return brN();
    }

    public final arg uR(int i) {
        this.mQA = i;
        this.mQB = true;
        return this;
    }

    public final String toString() {
        return new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(SQLiteDatabase.KeyEmpty + getClass().getName() + "(")).append("uiVal = ").append(this.mQA).append("   ").toString())).append(")").toString();
    }

    private arg brN() {
        if (this.mQB) {
            return this;
        }
        throw new b("Not all required fields were included (false = not included in message),  uiVal:" + this.mQB);
    }

    public final int aHr() {
        return (a.a.a.a.dS(1, this.mQA) + 0) + 0;
    }

    public final byte[] toByteArray() {
        brN();
        return super.toByteArray();
    }

    public final void a(a.a.a.c.a aVar) {
        aVar.dV(1, this.mQA);
    }

    public final boolean a(a.a.a.a.a aVar, a aVar2, int i) {
        arg com_tencent_mm_protocal_c_arg = (arg) aVar2;
        switch (i) {
            case 1:
                com_tencent_mm_protocal_c_arg.uR(aVar.pMj.mH());
                return true;
            default:
                return false;
        }
    }
}
