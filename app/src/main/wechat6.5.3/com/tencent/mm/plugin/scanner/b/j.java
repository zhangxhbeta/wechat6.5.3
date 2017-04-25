package com.tencent.mm.plugin.scanner.b;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class j {
    public static boolean aLX() {
        c Ls = com.tencent.mm.model.c.c.Au().Ls("100027");
        if (Ls.isValid()) {
            Map buX = Ls.buX();
            if (buX == null) {
                v.e("MicroMsg.ScanHistoryUtil", "shouldShowHistoryList args == null");
                return false;
            } else if (buX.containsKey("showEntrance") && "1".equals(buX.get("showEntrance"))) {
                return true;
            } else {
                v.e("MicroMsg.ScanHistoryUtil", "not contain the showEntrance key or the value is not 1");
                return false;
            }
        }
        v.e("MicroMsg.ScanHistoryUtil", "shouldShowHistoryList item.isValid is false");
        return false;
    }
}
