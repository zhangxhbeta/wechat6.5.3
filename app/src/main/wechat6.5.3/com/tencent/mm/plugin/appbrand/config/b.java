package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import com.tencent.mm.model.w;

public final class b implements com.tencent.mm.model.w.b {

    private static final class a extends w {
        private a() {
        }

        public final void transfer(int i) {
            if (eH(i)) {
                com.tencent.mm.plugin.appbrand.a.a SY = com.tencent.mm.plugin.appbrand.a.a.SY();
                if (SY != null && SY.ON() != null) {
                    j OO = com.tencent.mm.plugin.appbrand.a.a.OO();
                    if (OO != null && OO.PB()) {
                        ContentValues contentValues = new ContentValues(2);
                        contentValues.put("syncAttrVersion", "");
                        contentValues.put("lastSyncAttrTimeInSecond", Long.valueOf(0));
                        OO.dBf.update("AppBrandWxaAppInfo", contentValues, null, null);
                    }
                }
            }
        }

        public final boolean eH(int i) {
            return i != 0 && i <= 637862655;
        }

        public final String getTag() {
            return "MicroMSg.AppBrandBizAttrDataTransferImpl";
        }
    }

    public final w yE() {
        return new a();
    }
}
