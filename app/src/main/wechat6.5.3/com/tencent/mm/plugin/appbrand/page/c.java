package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import java.util.HashMap;
import java.util.Map;

public final class c extends e {
    private static final int CTRL_INDEX = 49;
    private static final String NAME = "onAppEnterBackground";
    private static c dNf = new c();

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] dHw = new int[b.OG().length];

        static {
            try {
                dHw[b.dyX - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                dHw[b.dyY - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                dHw[b.dyZ - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                dHw[b.dza - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static void nX(String str) {
        Map hashMap = new HashMap();
        Object obj = "hide";
        switch (AnonymousClass1.dHw[com.tencent.mm.plugin.appbrand.c.OF() - 1]) {
            case 1:
                obj = "close";
                break;
            case 2:
                obj = "back";
                break;
            case 3:
                obj = "hide";
                break;
            case 4:
                obj = "hang";
                break;
        }
        hashMap.put("mode", obj);
        dNf.o(hashMap).aa(str, 0).PX();
    }
}
