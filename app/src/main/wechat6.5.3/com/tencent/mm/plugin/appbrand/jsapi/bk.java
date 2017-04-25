package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.o;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.appcache.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import org.json.JSONObject;

public final class bk extends a {
    public static final int CTRL_INDEX = 74;
    public static final String NAME = "shareTimeline";
    private static boolean dIl = false;

    public final void a(f fVar, JSONObject jSONObject, int i) {
        if (dIl) {
            dIl = false;
            if (jSONObject != null) {
                AppBrandSysConfig mr = a.mr(fVar.dzg);
                final MMActivity nt = d.nt(fVar.dzg);
                if (nt == null) {
                    fVar.y(i, c("fail", null));
                    return;
                }
                String str;
                try {
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        str = (String) keys.next();
                        v.i("MicroMsg.JsApiShareTimeline", "%s, %s", new Object[]{str, jSONObject.get(str)});
                    }
                } catch (Throwable e) {
                    v.a("MicroMsg.JsApiShareTimeline", e, "", new Object[0]);
                }
                final String optString = jSONObject.optString("path");
                final String str2 = fVar.dzg;
                str = jSONObject.optString("desc");
                String optString2 = jSONObject.optString("title");
                String str3 = mr.aWH;
                String optString3 = jSONObject.optString("imgUrl");
                String mI = g.mI(fVar.dzg);
                String str4 = mr.dDo;
                v.i("MicroMsg.JsApiShareTimeline", "doSendMessage, title = %s, description = %s ,username = %s , path = %s ,thumbIconUrl = %s", new Object[]{optString2, str, str3, optString, optString3});
                v.i("MicroMsg.JsApiShareTimeline", "doTimeline, errorUrl:[%s]", new Object[]{mI});
                v.i("MicroMsg.JsApiShareTimeline", "doTimeline, init intent");
                Intent intent = new Intent();
                intent.putExtra("Ksnsupload_link", mI);
                intent.putExtra("Ksnsupload_title", optString2);
                intent.putExtra("Ksnsupload_contentattribute", 0);
                if (s.ds(optString3, "http://") || s.ds(optString3, "https://")) {
                    intent.putExtra("Ksnsupload_imgurl", optString3);
                } else {
                    WebResourceResponse ar = b.ar(str2, optString3);
                    if (ar != null) {
                        Bitmap decodeStream = BitmapFactory.decodeStream(ar.getData());
                        if (decodeStream == null || decodeStream.isRecycled()) {
                            v.e("MicroMsg.JsApiShareTimeline", "thumb image is null");
                        } else {
                            v.i("MicroMsg.JsApiShareTimeline", "thumb image is not null");
                            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            decodeStream.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                            intent.putExtra("Ksnsupload_imgbuf", byteArrayOutputStream.toByteArray());
                        }
                    } else {
                        v.e("MicroMsg.JsApiShareTimeline", "iconBmp thumb image is null too");
                    }
                }
                intent.putExtra("ksnsis_appbrand", true);
                intent.putExtra("Ksnsupload_source", 1);
                intent.putExtra("Ksnsupload_type", 1);
                intent.putExtra("KsnsUpload_BrandUsername", str3);
                intent.putExtra("KsnsUpload_BrandPath", optString);
                v.d("MicroMsg.JsApiShareTimeline", "report, appId : %s, path: %s", new Object[]{str2, optString});
                str = o.fz("wxapp_" + str2 + optString);
                o.yx().n(str, true).l("prePublishId", "wxapp_" + str2 + optString);
                intent.putExtra("reportSessionId", str);
                v.i("MicroMsg.JsApiShareTimeline", "doTimeline, start activity");
                if (nt instanceof MMActivity) {
                    intent.putExtra("need_result", true);
                    final f fVar2 = fVar;
                    final int i2 = i;
                    nt.nDS = new MMActivity.a(this) {
                        final /* synthetic */ bk dIw;

                        public final void a(int i, int i2, Intent intent) {
                            if (i != 0) {
                                return;
                            }
                            if (i2 == -1) {
                                com.tencent.mm.ui.base.g.bf(nt, nt.getResources().getString(2131231155));
                                com.tencent.mm.plugin.appbrand.report.a.a(str2, optString, 3, "", be.Nh(), 1, i2);
                                v.i("MicroMsg.JsApiShareTimeline", "result is success");
                                fVar2.y(i2, this.dIw.c("success", null));
                                return;
                            }
                            v.i("MicroMsg.JsApiShareTimeline", "result is cancel");
                            fVar2.y(i2, this.dIw.c("cancel", null));
                            com.tencent.mm.plugin.appbrand.report.a.a(str2, optString, 3, "", be.Nh(), 3, i2);
                        }
                    };
                    c.a(nt, "sns", ".ui.SnsUploadUI", intent, 0, false);
                    return;
                }
                return;
            }
            v.i("MicroMsg.JsApiShareTimeline", "data is null");
            fVar.y(i, c("fail", null));
            return;
        }
        fVar.y(i, c("fail", null));
    }

    public static void Ql() {
        dIl = true;
    }
}
