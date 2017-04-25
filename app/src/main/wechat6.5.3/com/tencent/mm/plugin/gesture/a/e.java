package com.tencent.mm.plugin.gesture.a;

import com.tencent.mm.sdk.platformtools.v;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;

public final class e {
    public long gAZ = -1;
    public long gBa = 0;

    public final byte[] toByteArray() {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeLong(this.gAZ);
            dataOutputStream.writeLong(this.gBa);
            dataOutputStream.close();
        } catch (Throwable e) {
            v.a("MicroMsg.TimeInfo", e, "", new Object[0]);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public final e as(byte[] bArr) {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        try {
            this.gAZ = dataInputStream.readLong();
            this.gBa = dataInputStream.readLong();
            dataInputStream.close();
        } catch (Throwable e) {
            v.a("MicroMsg.TimeInfo", e, "", new Object[0]);
        }
        return this;
    }
}
