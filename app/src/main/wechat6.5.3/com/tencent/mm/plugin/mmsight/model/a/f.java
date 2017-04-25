package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class f extends g {
    private int hoh = -1;

    public f(int i, int i2) {
        super(i, i2);
    }

    public final int mZ(int i) {
        this.hoh = i;
        return super.aAt();
    }

    protected final void a(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        if (this.hoh >= 0 && byteBuffer != null && bufferInfo != null && !this.hox) {
            SightVideoJNI.writeAACData(this.hoh, byteBuffer, bufferInfo.size);
        }
    }

    protected final boolean aAs() {
        return true;
    }
}
