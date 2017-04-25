package com.tencent.mm.plugin.appbrand.l.d;

import com.tencent.mm.plugin.appbrand.l.c.c;
import com.tencent.mm.plugin.appbrand.l.d.d.a;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.nio.ByteBuffer;

public final class b extends e implements a {
    static final ByteBuffer dUw = ByteBuffer.allocate(0);
    private int aJW;
    private String dUx;

    public b() {
        super(a.CLOSING);
        bC(true);
    }

    public b(byte b) {
        super(a.CLOSING);
        bC(true);
        C(BaseReportManager.MAX_READ_COUNT, "");
    }

    public b(int i, String str) {
        super(a.CLOSING);
        bC(true);
        C(i, str);
    }

    private void C(int i, String str) {
        String str2;
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        if (i == 1015) {
            str2 = "";
            i = 1005;
        }
        if (i != 1005) {
            byte[] oE = com.tencent.mm.plugin.appbrand.l.f.b.oE(str2);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt(i);
            allocate.position(2);
            ByteBuffer allocate2 = ByteBuffer.allocate(oE.length + 2);
            allocate2.put(allocate);
            allocate2.put(oE);
            allocate2.rewind();
            m(allocate2);
        } else if (str2.length() > 0) {
            throw new com.tencent.mm.plugin.appbrand.l.c.b("A close frame must have a closecode if it has a reason");
        }
    }

    public final int Sy() {
        return this.aJW;
    }

    public final String getMessage() {
        return this.dUx;
    }

    public final String toString() {
        return super.toString() + "code: " + this.aJW;
    }

    public final void m(ByteBuffer byteBuffer) {
        super.m(byteBuffer);
        this.aJW = 1005;
        ByteBuffer Sz = super.Sz();
        Sz.mark();
        if (Sz.remaining() >= 2) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.position(2);
            allocate.putShort(Sz.getShort());
            allocate.position(0);
            this.aJW = allocate.getInt();
            if (this.aJW == 1006 || this.aJW == 1015 || this.aJW == 1005 || this.aJW > 4999 || this.aJW < BaseReportManager.MAX_READ_COUNT || this.aJW == 1004) {
                throw new c("closecode must not be sent over the wire: " + this.aJW);
            }
        }
        Sz.reset();
        if (this.aJW == 1005) {
            this.dUx = com.tencent.mm.plugin.appbrand.l.f.b.n(super.Sz());
            return;
        }
        allocate = super.Sz();
        int position = allocate.position();
        try {
            allocate.position(allocate.position() + 2);
            this.dUx = com.tencent.mm.plugin.appbrand.l.f.b.n(allocate);
            allocate.position(position);
        } catch (Throwable e) {
            throw new c(e);
        } catch (Throwable th) {
            allocate.position(position);
        }
    }

    public final ByteBuffer Sz() {
        if (this.aJW == 1005) {
            return dUw;
        }
        return super.Sz();
    }
}
