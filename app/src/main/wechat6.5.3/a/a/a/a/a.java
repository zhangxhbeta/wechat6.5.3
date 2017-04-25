package a.a.a.a;

import a.a.a.a.a.b;
import java.util.LinkedList;

public final class a {
    public final a.a.a.b.a.a pMj;
    public int pMk = 0;
    private final b unknownTagHandler;

    public a(byte[] bArr, b bVar) {
        this.pMj = new a.a.a.b.a.a(bArr, bArr.length);
        this.unknownTagHandler = bVar;
    }

    public final int bQG() {
        return this.pMj.mH();
    }

    public final LinkedList<Integer> bQH() {
        a.a.a.b.a.a aVar = this.pMj;
        LinkedList<Integer> linkedList = new LinkedList();
        while (aVar.aGr < aVar.aGp) {
            linkedList.add(Integer.valueOf(aVar.mH()));
        }
        return linkedList;
    }

    public final String bQI() {
        return this.pMj.readString();
    }

    public final boolean bQJ() {
        return this.pMj.mH() != 0;
    }

    public final com.tencent.mm.ba.b bQK() {
        a.a.a.b.a.a aVar = this.pMj;
        int mH = aVar.mH();
        if (mH >= aVar.aGp - aVar.aGr || mH <= 0) {
            return com.tencent.mm.ba.b.aT(aVar.cs(mH));
        }
        com.tencent.mm.ba.b f = com.tencent.mm.ba.b.f(aVar.buffer, aVar.aGr, mH);
        aVar.aGr = mH + aVar.aGr;
        return f;
    }

    public final void bQL() {
        int cz = a.a.a.b.a.cz(this.pMk);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FieldNumber: ").append(a.a.a.b.a.cA(this.pMk)).append(" - ");
        switch (cz) {
            case 0:
                stringBuffer.append("varint (long, int or boolean) value: ").append(this.pMj.mI());
                return;
            case 1:
                stringBuffer.append("double value: ").append(Double.toString(this.pMj.readDouble()));
                return;
            case 2:
                stringBuffer.append("Length delimited (String or ByteString) value: ").append(this.pMj.readString());
                return;
            case 5:
                stringBuffer.append("float value: ").append(Float.toString(this.pMj.readFloat()));
                return;
            default:
                return;
        }
    }

    public final LinkedList<byte[]> zQ(int i) {
        return this.pMj.zQ(i);
    }
}
