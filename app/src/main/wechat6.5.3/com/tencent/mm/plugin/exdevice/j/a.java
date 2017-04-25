package com.tencent.mm.plugin.exdevice.j;

import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.nio.ByteBuffer;
import junit.framework.Assert;

public final class a {
    private final int fGo = 1024;
    private ByteBuffer fGp;
    private ByteBuffer fGq;

    public a(int i) {
        boolean z;
        boolean z2 = true;
        v.d("MicroMsg.exdevice.AutoBuffer", "******AutoBuffer****** capacity = " + i);
        Assert.assertTrue(i >= 0);
        this.fGq = ByteBuffer.allocate(i);
        this.fGp = this.fGq.asReadOnlyBuffer();
        if (this.fGq != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (this.fGp == null) {
            z2 = false;
        }
        Assert.assertTrue(z2);
    }

    public final int getSize() {
        v.d("MicroMsg.exdevice.AutoBuffer", "size = " + this.fGq.position());
        return this.fGq.position();
    }

    public final short readShort() {
        if (getSize() <= 1) {
            throw new IOException("There is only one byte in array");
        }
        short s = this.fGp.getShort();
        v.d("MicroMsg.exdevice.AutoBuffer", "getShort = " + s);
        return s;
    }

    public final void u(byte[] bArr, int i) {
        boolean z;
        boolean z2 = true;
        Assert.assertTrue(true);
        Assert.assertTrue(i >= 0);
        if (bArr.length >= 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (bArr.length >= i + 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (this.fGp.remaining() < i) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        v.d("MicroMsg.exdevice.AutoBuffer", "readByte dstOffset = 0" + " byteCount = " + i);
        this.fGp.get(bArr, 0, i);
    }

    public final void v(byte[] bArr, int i) {
        boolean z = true;
        Assert.assertTrue(true);
        Assert.assertTrue(i >= 0);
        if (bArr == null) {
            z = false;
        }
        Assert.assertTrue(z);
        v.d("MicroMsg.exdevice.AutoBuffer", "writeByte srcOffset = 0" + " byteCount = " + i);
        if (i > this.fGq.remaining()) {
            v.d("MicroMsg.exdevice.AutoBuffer", "byteCount > mWriteStream.remaining() Recalloc");
            v.d("MicroMsg.exdevice.AutoBuffer", "getCapacity = " + this.fGq.capacity());
            ByteBuffer allocate = ByteBuffer.allocate((this.fGq.capacity() + i) + 1024);
            int position = this.fGp.position();
            allocate.put(this.fGq.array());
            allocate.put(bArr, 0, i);
            this.fGq = allocate;
            this.fGp = allocate.asReadOnlyBuffer();
            this.fGp.position(position);
            return;
        }
        this.fGq.put(bArr, 0, i);
    }
}
