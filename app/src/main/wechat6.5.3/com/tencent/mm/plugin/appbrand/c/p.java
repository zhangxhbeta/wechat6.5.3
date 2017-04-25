package com.tencent.mm.plugin.appbrand.c;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.c.a.a;
import org.json.JSONArray;

public final class p implements d {
    public final String getMethod() {
        return "save";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        canvas.save();
        a aVar = fVar.dCm;
        fVar.dCo.push(fVar.dCm);
        fVar.dCm = fVar.dCm.Pt();
        if (fVar.dCm == null) {
            fVar.dCm = aVar;
        }
        aVar = fVar.dCn;
        fVar.dCp.push(fVar.dCn);
        fVar.dCn = fVar.dCn.Pt();
        if (fVar.dCn == null) {
            fVar.dCn = aVar;
        }
        return true;
    }
}
