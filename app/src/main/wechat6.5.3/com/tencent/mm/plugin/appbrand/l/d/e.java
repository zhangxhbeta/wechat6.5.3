package com.tencent.mm.plugin.appbrand.l.d;

import com.tencent.mm.plugin.appbrand.l.d.d.a;
import com.tencent.mm.plugin.appbrand.l.f.b;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class e implements c {
    protected static byte[] dUF = new byte[0];
    protected boolean dUG;
    protected a dUH;
    private ByteBuffer dUI;
    protected boolean dUJ;

    public e(a aVar) {
        this.dUH = aVar;
        this.dUI = ByteBuffer.wrap(dUF);
    }

    public e(d dVar) {
        this.dUG = dVar.SA();
        this.dUH = dVar.SC();
        this.dUI = dVar.Sz();
        this.dUJ = dVar.SB();
    }

    public final boolean SA() {
        return this.dUG;
    }

    public final a SC() {
        return this.dUH;
    }

    public final boolean SB() {
        return this.dUJ;
    }

    public ByteBuffer Sz() {
        return this.dUI;
    }

    public final void bC(boolean z) {
        this.dUG = z;
    }

    public final void a(a aVar) {
        this.dUH = aVar;
    }

    public void m(ByteBuffer byteBuffer) {
        this.dUI = byteBuffer;
    }

    public final void bD(boolean z) {
        this.dUJ = z;
    }

    public final void e(d dVar) {
        ByteBuffer Sz = dVar.Sz();
        if (this.dUI == null) {
            this.dUI = ByteBuffer.allocate(Sz.remaining());
            Sz.mark();
            this.dUI.put(Sz);
            Sz.reset();
        } else {
            Sz.mark();
            this.dUI.position(this.dUI.limit());
            this.dUI.limit(this.dUI.capacity());
            if (Sz.remaining() > this.dUI.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(Sz.remaining() + this.dUI.capacity());
                this.dUI.flip();
                allocate.put(this.dUI);
                allocate.put(Sz);
                this.dUI = allocate;
            } else {
                this.dUI.put(Sz);
            }
            this.dUI.rewind();
            Sz.reset();
        }
        this.dUG = dVar.SA();
    }

    public String toString() {
        return "Framedata{ optcode:" + this.dUH + ", fin:" + this.dUG + ", payloadlength:[pos:" + this.dUI.position() + ", len:" + this.dUI.remaining() + "], payload:" + Arrays.toString(b.oE(new String(this.dUI.array()))) + "}";
    }
}
