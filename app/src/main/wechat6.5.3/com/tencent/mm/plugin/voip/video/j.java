package com.tencent.mm.plugin.voip.video;

import android.os.Looper;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;

public final class j {
    public ArrayList<a> epu = new ArrayList();
    public boolean kCn = false;
    public int kCo = 0;
    public int kCp;
    public int kCq;
    public v2protocal kuB = new v2protocal(new ac(Looper.myLooper()));

    public interface a {
        void a(int[] iArr, boolean z, int i);
    }

    private class b {
        public int kCr;
        public int kCs;
        public int kCt;
        public int kCu;
        final /* synthetic */ j kCv;

        public b(j jVar) {
            this.kCv = jVar;
        }

        public final String toString() {
            return String.format("topLeftX:%d, topLeftY:%d, rightBottomX:%d, rightBottomY:%d", new Object[]{Integer.valueOf(this.kCr), Integer.valueOf(this.kCs), Integer.valueOf(this.kCt), Integer.valueOf(this.kCu)});
        }
    }
}
