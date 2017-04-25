package com.google.android.gms.c;

public abstract class ay<M extends ay<M>> extends be {
    protected ba aAK;

    private M lq() {
        ay ayVar = (ay) super.lr();
        bc.a(this, ayVar);
        return ayVar;
    }

    public void a(ax axVar) {
        if (this.aAK != null) {
            for (int i = 0; i < this.aAK.size(); i++) {
                this.aAK.cg(i).a(axVar);
            }
        }
    }

    protected final boolean a(aw awVar, int i) {
        int position = awVar.getPosition();
        if (!awVar.bU(i)) {
            return false;
        }
        byte[] bArr;
        bb bbVar;
        int cj = bh.cj(i);
        int position2 = awVar.getPosition() - position;
        if (position2 == 0) {
            bArr = bh.aBe;
        } else {
            bArr = new byte[position2];
            System.arraycopy(awVar.buffer, position + awVar.aAA, bArr, 0, position2);
        }
        bg bgVar = new bg(i, bArr);
        if (this.aAK == null) {
            this.aAK = new ba();
            bbVar = null;
        } else {
            ba baVar = this.aAK;
            position2 = baVar.ch(cj);
            bbVar = (position2 < 0 || baVar.aAQ[position2] == ba.aAN) ? null : baVar.aAQ[position2];
        }
        if (bbVar == null) {
            bb bbVar2 = new bb();
            ba baVar2 = this.aAK;
            int ch = baVar2.ch(cj);
            if (ch >= 0) {
                baVar2.aAQ[ch] = bbVar2;
                bbVar = bbVar2;
            } else {
                ch ^= -1;
                if (ch >= baVar2.hO || baVar2.aAQ[ch] != ba.aAN) {
                    if (baVar2.aAO && baVar2.hO >= baVar2.aAP.length) {
                        baVar2.gc();
                        ch = baVar2.ch(cj) ^ -1;
                    }
                    if (baVar2.hO >= baVar2.aAP.length) {
                        int Q = ba.Q(baVar2.hO + 1);
                        Object obj = new int[Q];
                        Object obj2 = new bb[Q];
                        System.arraycopy(baVar2.aAP, 0, obj, 0, baVar2.aAP.length);
                        System.arraycopy(baVar2.aAQ, 0, obj2, 0, baVar2.aAQ.length);
                        baVar2.aAP = obj;
                        baVar2.aAQ = obj2;
                    }
                    if (baVar2.hO - ch != 0) {
                        System.arraycopy(baVar2.aAP, ch, baVar2.aAP, ch + 1, baVar2.hO - ch);
                        System.arraycopy(baVar2.aAQ, ch, baVar2.aAQ, ch + 1, baVar2.hO - ch);
                    }
                    baVar2.aAP[ch] = cj;
                    baVar2.aAQ[ch] = bbVar2;
                    baVar2.hO++;
                    bbVar = bbVar2;
                } else {
                    baVar2.aAP[ch] = cj;
                    baVar2.aAQ[ch] = bbVar2;
                    bbVar = bbVar2;
                }
            }
        }
        bbVar.aAT.add(bgVar);
        return true;
    }

    protected final boolean a(M m) {
        return (this.aAK == null || this.aAK.isEmpty()) ? m.aAK == null || m.aAK.isEmpty() : this.aAK.equals(m.aAK);
    }

    public /* synthetic */ Object clone() {
        return lq();
    }

    protected int kF() {
        int i = 0;
        if (this.aAK == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.aAK.size()) {
            i2 += this.aAK.cg(i).kF();
            i++;
        }
        return i2;
    }

    protected final int lp() {
        return (this.aAK == null || this.aAK.isEmpty()) ? 0 : this.aAK.hashCode();
    }

    public final /* synthetic */ be lr() {
        return lq();
    }
}
