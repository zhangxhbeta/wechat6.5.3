package com.tencent.tinker.a.a;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;
import java.util.zip.Adler32;

public final class i {
    static final short[] pAT = new short[0];
    public ByteBuffer hua;
    public final t pAU = new t();
    private final f pAV = new f();
    private final g pAW = new g();
    private final h pAX = new h();
    private final d pAY = new d();
    private final b pAZ = new b();
    private final c pBa = new c();
    private final a pBb = new a();
    private int pBc = 0;
    private byte[] pBd = null;

    private final class a extends AbstractList<f> implements RandomAccess {
        final /* synthetic */ i pBe;

        private a(i iVar) {
            this.pBe = iVar;
        }

        public final /* synthetic */ Object get(int i) {
            i.dI(i, this.pBe.pAU.pBv.size);
            return this.pBe.yP(this.pBe.pAU.pBv.pBP + (i * 32)).bOs();
        }

        public final int size() {
            return this.pBe.pAU.pBv.size;
        }
    }

    private final class b extends AbstractList<n> implements RandomAccess {
        final /* synthetic */ i pBe;

        private b(i iVar) {
            this.pBe = iVar;
        }

        public final /* synthetic */ Object get(int i) {
            i.dI(i, this.pBe.pAU.pBt.size);
            return this.pBe.yP(this.pBe.pAU.pBt.pBP + (i * 8)).bOp();
        }

        public final int size() {
            return this.pBe.pAU.pBt.size;
        }
    }

    private final class c extends AbstractList<p> implements RandomAccess {
        final /* synthetic */ i pBe;

        private c(i iVar) {
            this.pBe = iVar;
        }

        public final /* synthetic */ Object get(int i) {
            i.dI(i, this.pBe.pAU.pBu.size);
            return this.pBe.yP(this.pBe.pAU.pBu.pBP + (i * 8)).bOq();
        }

        public final int size() {
            return this.pBe.pAU.pBu.size;
        }
    }

    private final class d extends AbstractList<r> implements RandomAccess {
        final /* synthetic */ i pBe;

        private d(i iVar) {
            this.pBe = iVar;
        }

        public final /* synthetic */ Object get(int i) {
            i.dI(i, this.pBe.pAU.pBs.size);
            return this.pBe.yP(this.pBe.pAU.pBs.pBP + (i * 12)).bOr();
        }

        public final int size() {
            return this.pBe.pAU.pBs.size;
        }
    }

    private final class f extends AbstractList<String> implements RandomAccess {
        final /* synthetic */ i pBe;

        private f(i iVar) {
            this.pBe = iVar;
        }

        public final /* synthetic */ Object get(int i) {
            return nk(i);
        }

        public final String nk(int i) {
            i.dI(i, this.pBe.pAU.pBq.size);
            return this.pBe.yP(this.pBe.yP(this.pBe.pAU.pBq.pBP + (i * 4)).hua.getInt()).bOn().value;
        }

        public final int size() {
            return this.pBe.pAU.pBq.size;
        }
    }

    private final class g extends AbstractList<Integer> implements RandomAccess {
        final /* synthetic */ i pBe;

        private g(i iVar) {
            this.pBe = iVar;
        }

        public final /* synthetic */ Object get(int i) {
            return Integer.valueOf(this.pBe.yQ(i));
        }

        public final int size() {
            return this.pBe.pAU.pBr.size;
        }
    }

    private final class h extends AbstractList<String> implements RandomAccess {
        final /* synthetic */ i pBe;

        private h(i iVar) {
            this.pBe = iVar;
        }

        public final /* synthetic */ Object get(int i) {
            return this.pBe.pAV.nk(this.pBe.yQ(i));
        }

        public final int size() {
            return this.pBe.pAU.pBr.size;
        }
    }

    public final class e extends com.tencent.tinker.a.a.a.a {
        private final String name;
        final /* synthetic */ i pBe;

        private e(i iVar, String str, ByteBuffer byteBuffer) {
            this.pBe = iVar;
            super(byteBuffer);
            this.name = str;
        }

        public final s bOn() {
            a(this.pBe.pAU.pBC, false);
            return super.bOn();
        }

        public final u bOo() {
            a(this.pBe.pAU.pBx, false);
            return super.bOo();
        }

        public final n bOp() {
            a(this.pBe.pAU.pBt, false);
            return super.bOp();
        }

        public final p bOq() {
            a(this.pBe.pAU.pBu, false);
            return super.bOq();
        }

        public final r bOr() {
            a(this.pBe.pAU.pBs, false);
            return super.bOr();
        }

        public final f bOs() {
            a(this.pBe.pAU.pBv, false);
            return super.bOs();
        }

        public final g bOt() {
            a(this.pBe.pAU.pBB, false);
            return super.bOt();
        }

        public final h bOu() {
            a(this.pBe.pAU.pBD, false);
            return super.bOu();
        }

        public final e bOv() {
            a(this.pBe.pAU.pBA, false);
            return super.bOv();
        }

        public final a bOw() {
            a(this.pBe.pAU.pBE, false);
            return super.bOw();
        }

        public final b bOx() {
            a(this.pBe.pAU.pBz, false);
            return super.bOx();
        }

        public final c bOy() {
            a(this.pBe.pAU.pBy, false);
            return super.bOy();
        }

        public final d bOz() {
            a(this.pBe.pAU.pBG, false);
            return super.bOz();
        }

        public final k bOA() {
            a(this.pBe.pAU.pBF, false);
            return super.bOA();
        }

        private void a(com.tencent.tinker.a.a.t.a aVar, boolean z) {
            if (!aVar.pBO) {
                return;
            }
            if (z) {
                super.yV((((this.hua.position() + 3) & -4) - this.hua.position()) * 1);
                while ((this.hua.position() & 3) != 0) {
                    this.hua.put((byte) 0);
                }
                if (this.hua.position() > this.pBT) {
                    this.pBT = this.hua.position();
                    return;
                }
                return;
            }
            this.hua.position((this.hua.position() + 3) & -4);
        }

        public final int a(s sVar) {
            a(this.pBe.pAU.pBC, true);
            return super.a(sVar);
        }

        public final int a(u uVar) {
            a(this.pBe.pAU.pBx, true);
            return super.a(uVar);
        }

        public final int a(n nVar) {
            a(this.pBe.pAU.pBt, true);
            return super.a(nVar);
        }

        public final int a(p pVar) {
            a(this.pBe.pAU.pBu, true);
            return super.a(pVar);
        }

        public final int a(r rVar) {
            a(this.pBe.pAU.pBs, true);
            return super.a(rVar);
        }

        public final int a(f fVar) {
            a(this.pBe.pAU.pBv, true);
            return super.a(fVar);
        }

        public final int a(g gVar) {
            a(this.pBe.pAU.pBB, true);
            return super.a(gVar);
        }

        public final int a(h hVar) {
            a(this.pBe.pAU.pBD, true);
            return super.a(hVar);
        }

        public final int a(e eVar) {
            a(this.pBe.pAU.pBA, true);
            return super.a(eVar);
        }

        public final int a(a aVar) {
            a(this.pBe.pAU.pBE, true);
            return super.a(aVar);
        }

        public final int a(b bVar) {
            a(this.pBe.pAU.pBz, true);
            return super.a(bVar);
        }

        public final int a(c cVar) {
            a(this.pBe.pAU.pBy, true);
            return super.a(cVar);
        }

        public final int a(d dVar) {
            a(this.pBe.pAU.pBG, true);
            return super.a(dVar);
        }

        public final int a(k kVar) {
            a(this.pBe.pAU.pBF, true);
            return super.a(kVar);
        }
    }

    public i(int i) {
        this.hua = ByteBuffer.wrap(new byte[i]);
        this.hua.order(ByteOrder.LITTLE_ENDIAN);
        this.pAU.fileSize = i;
    }

    public i(InputStream inputStream, int i) {
        Object obj = -1;
        this.hua = ByteBuffer.wrap(com.tencent.tinker.a.a.b.d.b(inputStream, i));
        this.hua.order(ByteOrder.LITTLE_ENDIAN);
        t tVar = this.pAU;
        com.tencent.tinker.a.a.a.a a = a(tVar.pBp);
        byte[] yW = a.yW(8);
        if (yW.length == 8 && yW[0] == (byte) 100 && yW[1] == (byte) 101 && yW[2] == (byte) 120 && yW[3] == (byte) 10 && yW[7] == (byte) 0) {
            String str = ((char) yW[4]) + ((char) yW[5]) + ((char) yW[6]);
            if (str.equals("036")) {
                obj = 14;
            } else if (str.equals("035")) {
                int i2 = 13;
            }
        }
        if (obj != 13) {
            throw new j("Unexpected magic: " + Arrays.toString(yW));
        }
        tVar.pBI = a.hua.getInt();
        tVar.pBd = a.yW(20);
        tVar.fileSize = a.hua.getInt();
        i2 = a.hua.getInt();
        if (i2 != 112) {
            throw new j("Unexpected header: 0x" + Integer.toHexString(i2));
        }
        i2 = a.hua.getInt();
        if (i2 != 305419896) {
            throw new j("Unexpected endian tag: 0x" + Integer.toHexString(i2));
        }
        tVar.pBJ = a.hua.getInt();
        tVar.pBK = a.hua.getInt();
        tVar.pBw.pBP = a.hua.getInt();
        if (tVar.pBw.pBP == 0) {
            throw new j("Cannot merge dex files that do not contain a map");
        }
        tVar.pBq.size = a.hua.getInt();
        tVar.pBq.pBP = a.hua.getInt();
        tVar.pBr.size = a.hua.getInt();
        tVar.pBr.pBP = a.hua.getInt();
        tVar.pBs.size = a.hua.getInt();
        tVar.pBs.pBP = a.hua.getInt();
        tVar.pBt.size = a.hua.getInt();
        tVar.pBt.pBP = a.hua.getInt();
        tVar.pBu.size = a.hua.getInt();
        tVar.pBu.pBP = a.hua.getInt();
        tVar.pBv.size = a.hua.getInt();
        tVar.pBv.pBP = a.hua.getInt();
        tVar.pBL = a.hua.getInt();
        tVar.pBM = a.hua.getInt();
        tVar.a(yP(tVar.pBw.pBP));
        tVar.bOM();
    }

    private static void dI(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("index:" + i + ", length=" + i2);
        }
    }

    public final e yP(int i) {
        if (i < 0 || i >= this.hua.capacity()) {
            throw new IllegalArgumentException("position=" + i + " length=" + this.hua.capacity());
        }
        ByteBuffer duplicate = this.hua.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        duplicate.position(i);
        duplicate.limit(this.hua.capacity());
        return new e("temp-section", duplicate);
    }

    public final e a(com.tencent.tinker.a.a.t.a aVar) {
        int i = aVar.pBP;
        if (i < 0 || i >= this.hua.capacity()) {
            throw new IllegalArgumentException("position=" + i + " length=" + this.hua.capacity());
        }
        ByteBuffer duplicate = this.hua.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        duplicate.position(i);
        duplicate.limit(i + aVar.pBQ);
        return new e("section", duplicate);
    }

    public final byte[] kE(boolean z) {
        if (this.pBd != null && !z) {
            return this.pBd;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[8192];
            ByteBuffer duplicate = this.hua.duplicate();
            duplicate.limit(duplicate.capacity());
            duplicate.position(32);
            while (duplicate.hasRemaining()) {
                int min = Math.min(8192, duplicate.remaining());
                duplicate.get(bArr, 0, min);
                instance.update(bArr, 0, min);
            }
            byte[] digest = instance.digest();
            this.pBd = digest;
            return digest;
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }

    public final void bOm() {
        yP(12).write(kE(true));
        e yP = yP(8);
        Adler32 adler32 = new Adler32();
        byte[] bArr = new byte[8192];
        ByteBuffer duplicate = this.hua.duplicate();
        duplicate.limit(duplicate.capacity());
        duplicate.position(12);
        while (duplicate.hasRemaining()) {
            int min = Math.min(8192, duplicate.remaining());
            duplicate.get(bArr, 0, min);
            adler32.update(bArr, 0, min);
        }
        yP.writeInt((int) adler32.getValue());
    }

    public final int yQ(int i) {
        dI(i, this.pAU.pBr.size);
        return this.hua.getInt(this.pAU.pBr.pBP + (i * 4));
    }
}
