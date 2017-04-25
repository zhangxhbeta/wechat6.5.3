package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

final class x extends a {
    private static final int CTRL_INDEX = 120;
    private static final String NAME = "getImageInfo";
    private static final Collection<b> dGx;

    private interface b {
        com.tencent.mm.vending.j.a aK(String str, String str2);
    }

    private static final class c {
        public int height;
        public int width;

        private c() {
        }
    }

    private enum e {
        FILE_NOT_FOUND,
        UNKNOWN_FAIL,
        RESOLVED
    }

    private static final class a implements b {
        private a() {
        }

        public final com.tencent.mm.vending.j.a aK(String str, String str2) {
            if (!str2.startsWith("wxfile://")) {
                return null;
            }
            AppBrandLocalMediaObject az = com.tencent.mm.plugin.appbrand.appstorage.c.az(str, str2);
            if (az == null || be.kS(az.cvK) || !com.tencent.mm.a.e.aR(az.cvK)) {
                return com.tencent.mm.vending.j.a.bt(e.FILE_NOT_FOUND);
            }
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(az.cvK, options);
            c cVar = new c();
            cVar.width = options.outWidth;
            cVar.height = options.outHeight;
            return com.tencent.mm.vending.j.a.t(e.RESOLVED, cVar);
        }
    }

    private static final class d implements b {
        private d() {
        }

        public final com.tencent.mm.vending.j.a aK(String str, String str2) {
            WebResourceResponse ar = com.tencent.mm.plugin.appbrand.appcache.b.ar(str, str2);
            if (ar == null || ar.getData() == null) {
                return com.tencent.mm.vending.j.a.bt(e.FILE_NOT_FOUND);
            }
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(ar.getData(), new Rect(), options);
            c cVar = new c();
            cVar.width = options.outWidth;
            cVar.height = options.outHeight;
            return com.tencent.mm.vending.j.a.t(e.RESOLVED, cVar);
        }
    }

    x() {
    }

    public final void a(f fVar, JSONObject jSONObject, int i) {
        final String str = fVar.dzg;
        final String optString = jSONObject.optString("src");
        if (be.kS(optString)) {
            fVar.y(i, c("fail:invalid data", null));
            return;
        }
        final WeakReference weakReference = new WeakReference(fVar);
        final int i2 = i;
        com.tencent.mm.sdk.i.e.b(new Runnable(this) {
            final /* synthetic */ x dGz;

            public final void run() {
                com.tencent.mm.vending.j.a aVar = null;
                for (b aK : x.dGx) {
                    aVar = aK.aK(str, optString);
                    if (aVar != null) {
                        break;
                    }
                }
                com.tencent.mm.vending.j.a aVar2 = aVar;
                if (weakReference.get() != null && ((f) weakReference.get()).ZO) {
                    if (aVar2 != null) {
                        String c;
                        switch ((e) aVar2.get(0)) {
                            case FILE_NOT_FOUND:
                                c = this.dGz.c("fail:file not found", null);
                                break;
                            case RESOLVED:
                                Map hashMap = new HashMap(2);
                                hashMap.put("width", Integer.valueOf(((c) aVar2.get(1)).width));
                                hashMap.put("height", Integer.valueOf(((c) aVar2.get(1)).height));
                                c = this.dGz.c("ok", hashMap);
                                break;
                            default:
                                c = this.dGz.c("fail", null);
                                break;
                        }
                        ((f) weakReference.get()).y(i2, c);
                        return;
                    }
                    ((f) weakReference.get()).y(i2, this.dGz.c("fail:src not support", null));
                }
            }
        }, String.format(Locale.US, "AppBrandJsApiGetImageInfo[%s]", new Object[]{optString}), 10);
    }

    static {
        Collection linkedList = new LinkedList();
        linkedList.add(new a());
        linkedList.add(new d());
        dGx = Collections.unmodifiableCollection(linkedList);
    }
}
