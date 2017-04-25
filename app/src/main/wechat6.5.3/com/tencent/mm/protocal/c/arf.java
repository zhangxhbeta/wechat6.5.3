package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class arf extends a {
    public String mQy;
    public boolean mQz;

    protected final /* bridge */ /* synthetic */ a aHs() {
        return this;
    }

    public final /* synthetic */ a az(byte[] bArr) {
        a.a.a.a.a aVar = new a.a.a.a.a(bArr, unknownTagHandler);
        for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
            if (!a(aVar, this, a)) {
                aVar.bQL();
            }
        }
        return this;
    }

    public final arf JF(String str) {
        this.mQy = str;
        this.mQz = true;
        return this;
    }

    public final String toString() {
        return this.mQy;
    }

    public final int aHr() {
        int i = 0;
        if (this.mQz) {
            i = a.a.a.b.b.a.f(1, this.mQy) + 0;
        }
        return i + 0;
    }

    public final byte[] toByteArray() {
        return super.toByteArray();
    }

    public final void a(a.a.a.c.a aVar) {
        if (this.mQz) {
            aVar.e(1, this.mQy);
        }
    }

    public final boolean a(a.a.a.a.a aVar, a aVar2, int i) {
        arf com_tencent_mm_protocal_c_arf = (arf) aVar2;
        switch (i) {
            case 1:
                com_tencent_mm_protocal_c_arf.JF(aVar.pMj.readString());
                return true;
            default:
                return false;
        }
    }
}
