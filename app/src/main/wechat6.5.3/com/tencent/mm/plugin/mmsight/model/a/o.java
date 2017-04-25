package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class o extends p {
    private int hoh = -1;

    public o(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        super(i, i2, i3, i4, i5, i6, i7, z);
    }

    public final int bQ(int i, int i2) {
        this.hoh = i;
        return super.bQ(i, i2);
    }

    protected final void a(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        if (this.hoh >= 0 && byteBuffer != null && bufferInfo != null) {
            long Nj = be.Nj();
            SightVideoJNI.writeH264Data(this.hoh, byteBuffer, bufferInfo.size);
            v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeH264Data used %sms, size: %s", new Object[]{Long.valueOf(be.az(Nj)), Integer.valueOf(bufferInfo.size)});
        }
    }
}
