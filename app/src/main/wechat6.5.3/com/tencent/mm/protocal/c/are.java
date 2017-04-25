package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class are extends a {
    public int mQu;
    private boolean mQv;
    public b mQw;
    public boolean mQx;

    protected final /* synthetic */ a aHs() {
        return brM();
    }

    public final /* synthetic */ a az(byte[] bArr) {
        return bb(bArr);
    }

    private are uQ(int i) {
        this.mQu = i;
        this.mQv = true;
        return this;
    }

    public final are ba(byte[] bArr) {
        b aT = b.aT(bArr);
        c(aT);
        uQ(aT.lVU.length);
        return this;
    }

    public final are z(byte[] bArr, int i) {
        b f = b.f(bArr, 0, i);
        c(f);
        uQ(f.lVU.length);
        return this;
    }

    public final are c(b bVar) {
        if (bVar == null) {
            ba(null);
        }
        this.mQw = bVar;
        this.mQx = true;
        uQ(this.mQw.lVU.length);
        return this;
    }

    public final String toString() {
        Object stringBuilder = new StringBuilder(String.valueOf(SQLiteDatabase.KeyEmpty + getClass().getName() + "(")).append("iLen = ").append(this.mQu).append("   ").toString();
        if (this.mQx) {
            stringBuilder = new StringBuilder(String.valueOf(stringBuilder)).append("Buffer = ").append(this.mQw).append("   ").toString();
        }
        return new StringBuilder(String.valueOf(stringBuilder)).append(")").toString();
    }

    private are brM() {
        if (this.mQv) {
            return this;
        }
        throw new a.a.a.b("Not all required fields were included (false = not included in message),  iLen:" + this.mQv);
    }

    public final int aHr() {
        int dS = a.a.a.a.dS(1, this.mQu) + 0;
        if (this.mQx) {
            dS += a.a.a.a.a(2, this.mQw);
        }
        return dS + 0;
    }

    public final byte[] toByteArray() {
        brM();
        return super.toByteArray();
    }

    public final void a(a.a.a.c.a aVar) {
        aVar.dV(1, this.mQu);
        if (this.mQx) {
            aVar.b(2, this.mQw);
        }
    }

    public final boolean a(a.a.a.a.a aVar, a aVar2, int i) {
        are com_tencent_mm_protocal_c_are = (are) aVar2;
        switch (i) {
            case 1:
                com_tencent_mm_protocal_c_are.uQ(aVar.pMj.mH());
                return true;
            case 2:
                com_tencent_mm_protocal_c_are.c(aVar.bQK());
                return true;
            default:
                return false;
        }
    }

    public final are bb(byte[] bArr) {
        a.a.a.a.a aVar = new a.a.a.a.a(bArr, unknownTagHandler);
        for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
            if (!a(aVar, this, a)) {
                aVar.bQL();
            }
        }
        return brM();
    }
}
