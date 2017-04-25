package com.google.android.gms.c;

import android.text.TextUtils;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.util.HashMap;
import java.util.Map;

public final class al extends af<al> {
    public String azq;
    public int azr;
    public int azs;
    public int azt;
    public int azu;
    public int azv;

    public final /* synthetic */ void a(af afVar) {
        al alVar = (al) afVar;
        if (this.azr != 0) {
            alVar.azr = this.azr;
        }
        if (this.azs != 0) {
            alVar.azs = this.azs;
        }
        if (this.azt != 0) {
            alVar.azt = this.azt;
        }
        if (this.azu != 0) {
            alVar.azu = this.azu;
        }
        if (this.azv != 0) {
            alVar.azv = this.azv;
        }
        if (!TextUtils.isEmpty(this.azq)) {
            alVar.azq = this.azq;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, this.azq);
        hashMap.put("screenColors", Integer.valueOf(this.azr));
        hashMap.put("screenWidth", Integer.valueOf(this.azs));
        hashMap.put("screenHeight", Integer.valueOf(this.azt));
        hashMap.put("viewportWidth", Integer.valueOf(this.azu));
        hashMap.put("viewportHeight", Integer.valueOf(this.azv));
        return af.ac(hashMap);
    }
}
