package com.tencent.mm.plugin.gai;

import android.content.Context;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public class Plugin implements c {

    public interface a {
        void tT(String str);
    }

    public Plugin() {
        v.i("MicroMsg.Plugin.gai", "gai Plugin!");
        if (!aa.getContext().getSharedPreferences(aa.bti() + "_google_aid", 4).getBoolean("already_report_googleaid", false)) {
            final Context context = aa.getContext();
            final a anonymousClass1 = new a(this) {
                final /* synthetic */ Plugin gdn;

                {
                    this.gdn = r1;
                }

                public final void tT(String str) {
                    aa.getContext().getSharedPreferences(aa.bti() + "_google_aid", 4).edit().putString("getgoogleaid", str).commit();
                    String deviceID = p.getDeviceID(aa.getContext());
                    String androidId = p.getAndroidId();
                    String rL = p.rL();
                    String string = aa.getContext().getSharedPreferences(aa.bti(), 0).getString("installreferer", "");
                    v.i("MicroMsg.Plugin.gai", "Advertisement MAT rsakv logID:%d val:%s", new Object[]{Integer.valueOf(11238), String.format("%s,%s,%s,%s,%s,%s", new Object[]{"", deviceID, androidId, rL, str, string})});
                    g.iuh.a(11238, r0, true, true);
                    aa.getContext().getSharedPreferences(aa.bti() + "_google_aid", 4).edit().putBoolean("already_report_googleaid", true).commit();
                }
            };
            e.a(new Runnable(this) {
                final /* synthetic */ Plugin gdn;

                public final void run() {
                    String str = "";
                    com.google.android.gms.a.a.a.a aVar = null;
                    try {
                        aVar = com.google.android.gms.a.a.a.q(context);
                        v.d("MicroMsg.Plugin.gai", "adInfo: %s", new Object[]{aVar});
                        if (aVar != null) {
                            str = aVar.afa;
                            v.i("MicroMsg.Plugin.gai", "get GoogleAid : [%s]", new Object[]{str});
                        }
                        if (anonymousClass1 != null) {
                            anonymousClass1.tT(str);
                        }
                    } catch (Throwable e) {
                        v.a("MicroMsg.Plugin.gai", e, "AdMatReport:: get Ad Id info error %s", new Object[]{e.getMessage()});
                        v.e("MicroMsg.Plugin.gai", "AdMatReport:: get Ad Id info error %s", new Object[]{e.getMessage()});
                        if (anonymousClass1 != null) {
                            anonymousClass1.tT(str);
                        }
                    } catch (Throwable th) {
                        if (aVar != null) {
                            str = aVar.afa;
                            v.i("MicroMsg.Plugin.gai", "get GoogleAid : [%s]", new Object[]{str});
                        }
                        if (anonymousClass1 != null) {
                            anonymousClass1.tT(str);
                        }
                    }
                }
            }, "Advertisement-MAT-thread");
        }
    }

    public i createApplication() {
        return new com.tencent.mm.plugin.gai.a.a();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ag createSubCore() {
        return new com.tencent.mm.plugin.gai.b.a();
    }
}
