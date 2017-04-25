package com.tencent.mm.ba;

import a.a.a.a.a.b;

public class a {
    protected static final int OPCODE_COMPUTESIZE = 1;
    protected static final int OPCODE_PARSEFROM = 2;
    protected static final int OPCODE_POPULATEBUILDERWITHFIELD = 3;
    protected static final int OPCODE_WRITEFIELDS = 0;
    public static b unknownTagHandler = new a.a.a.a.a.a();

    public byte[] toByteArray() {
        aHs();
        byte[] bArr = new byte[aHr()];
        a.a.a.c.a aVar = new a.a.a.c.a(bArr);
        a(aVar);
        if (aVar.cyK != null) {
            aVar.cyK.write(aVar.pMp);
            aVar.cyK.flush();
        }
        return bArr;
    }

    public static int a(a.a.a.a.a aVar) {
        int i = 0;
        a.a.a.b.a.a aVar2 = aVar.pMj;
        if (aVar2.aGr != aVar2.aGp || aVar2.kJ(false)) {
            aVar2.aGs = aVar2.mH();
            if (aVar2.aGs == 0) {
                throw a.a.a.b.a.b.bQP();
            }
            i = aVar2.aGs;
        } else {
            aVar2.aGs = 0;
        }
        aVar.pMk = i;
        return a.a.a.b.a.cA(aVar.pMk);
    }

    public a aHs() {
        return this;
    }

    public int a(int i, Object... objArr) {
        throw new Error("Cannot use this method");
    }

    public void a(a.a.a.c.a aVar) {
        a(0, aVar);
    }

    public int aHr() {
        int i = 0;
        try {
            i = a(1, new Object[0]);
        } catch (Exception e) {
        }
        return i;
    }

    public a az(byte[] bArr) {
        a(2, bArr);
        return this;
    }

    public boolean a(a.a.a.a.a aVar, a aVar2, int i) {
        return a(3, aVar, aVar2, Integer.valueOf(i)) == 0;
    }
}
