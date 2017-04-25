package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;

public final class l implements com.tencent.mm.ui.MMActivity.a {
    com.tencent.mm.modelgeo.c cCR = null;
    com.tencent.mm.modelgeo.b gXm = null;
    int lfB;
    boolean lra = false;
    int lrb;
    e lrc;
    e lrd;
    String lre;
    WeakReference<Context> lrf;
    d lrg;
    com.tencent.mm.modelgeo.b.a lrh = null;
    com.tencent.mm.modelgeo.b.a lri = null;
    com.tencent.mm.modelgeo.a.a lrj = null;
    final Runnable lrk = new Runnable(this) {
        final /* synthetic */ l lrl;

        {
            this.lrl = r1;
        }

        public final void run() {
            if (this.lrl.lrj != null && this.lrl.cCR != null) {
                this.lrl.gXm.a(this.lrl.lrh);
                this.lrl.cCR.c(this.lrl.lrj);
                this.lrl.lrj.a(false, 0.0f, 0.0f, 0, 0.0d, 0.0d);
            }
        }
    };

    interface d {
        void hm(int i);

        void kR(int i);

        void tj(int i);

        void tk(int i);
    }

    private static final class e {
        double latitude;
        double longitude;
        String lrn;

        private e(double d, double d2) {
            this.latitude = d;
            this.longitude = d2;
            this.lrn = null;
        }
    }

    private static abstract class f {
        protected abstract String getPackageName();

        private f() {
        }

        protected void a(Context context, e eVar, e eVar2, String str) {
            if (context != null) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + eVar2.latitude + "," + eVar2.longitude));
                intent.setPackage(getPackageName());
                intent.addFlags(268435456);
                context.startActivity(intent);
            }
        }
    }

    private static final class a extends f {
        private a() {
            super();
        }

        protected final void a(Context context, e eVar, e eVar2, String str) {
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                return;
            }
            String format = String.format("baidumap://map/direction?destination=%f,%f&mode=driving", new Object[]{Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude)});
            if (eVar != null) {
                format = format + String.format("origin=%f,%f", new Object[]{Double.valueOf(eVar.latitude), Double.valueOf(eVar.longitude)});
            }
            v.d("MicroMsg.OpenMapNavigator", "url " + format);
            try {
                context.startActivity(Intent.parseUri(format + "&src=webapp.car.carroutelistmappg.weixindrivenav", 0));
            } catch (Throwable e) {
                v.a("MicroMsg.OpenMapNavigator", e, "", new Object[0]);
            }
        }

        protected final String getPackageName() {
            return com.tencent.mm.pluginsdk.model.a.a.lyY.getPackage();
        }
    }

    private static final class b extends f {
        private b() {
            super();
        }

        protected final void a(Context context, e eVar, e eVar2, String str) {
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                return;
            }
            String str2 = "android.intent.action.VIEW";
            Intent intent = new Intent(str2, Uri.parse(String.format("androidamap://navi?sourceApplication=%s&lat=%f&lon=%f&dev=1&style=2", new Object[]{"MicroMessager", Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude)})));
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setPackage(com.tencent.mm.pluginsdk.model.a.a.lyZ.getPackage());
            context.startActivity(intent);
        }

        protected final String getPackageName() {
            return com.tencent.mm.pluginsdk.model.a.a.lyZ.getPackage();
        }
    }

    private static final class c extends f {
        private c() {
            super();
        }

        protected final void a(Context context, e eVar, e eVar2, String str) {
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                return;
            }
            String format = String.format("http://maps.google.com/maps?f=d&daddr=%f,%f", new Object[]{Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude)});
            if (eVar != null) {
                format = format + String.format("&saddr=%f,%f", new Object[]{Double.valueOf(eVar.latitude), Double.valueOf(eVar.longitude)});
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            context.startActivity(intent);
        }

        protected final String getPackageName() {
            return com.tencent.mm.pluginsdk.model.a.a.lyW.getPackage();
        }
    }

    private static final class g extends f {
        private g() {
            super();
        }

        protected final void a(Context context, e eVar, e eVar2, String str) {
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                return;
            }
            String format = String.format("wechatnav://type=nav&tocoord=%f,%f", new Object[]{Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude)});
            if (eVar != null) {
                format = format + String.format("&fromcoord=%f,%f", new Object[]{Double.valueOf(eVar.latitude), Double.valueOf(eVar.longitude)});
                if (!be.kS(eVar.lrn)) {
                    format = format + String.format("&from=%s", new Object[]{URLEncoder.encode(eVar.lrn)});
                }
            } else {
                format = format + String.format("&from=%s", new Object[]{"我的位置"});
            }
            if (be.kS(str)) {
                if (be.kS(eVar2.lrn)) {
                    str = "目的地";
                } else {
                    str = eVar2.lrn;
                }
            }
            String str2 = "android.intent.action.VIEW";
            Intent intent = new Intent(str2, Uri.parse(format + String.format("&to=%s", new Object[]{str})));
            intent.setPackage(com.tencent.mm.pluginsdk.model.a.a.lyX.getPackage());
            context.startActivity(intent);
        }

        protected final String getPackageName() {
            return com.tencent.mm.pluginsdk.model.a.a.lyX.getPackage();
        }
    }

    private static final class h extends f {
        private h() {
            super();
        }

        protected final void a(Context context, e eVar, e eVar2, String str) {
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                return;
            }
            String format = String.format("sosomap://type=nav&tocoord=%f,%f", new Object[]{Double.valueOf(eVar2.longitude), Double.valueOf(eVar2.latitude)});
            if (eVar != null) {
                format = format + String.format("fromcoord=%f,%f", new Object[]{Double.valueOf(eVar.longitude), Double.valueOf(eVar.latitude)});
                if (!be.kS(eVar.lrn)) {
                    format = format + String.format("&from=%s", new Object[]{URLEncoder.encode(eVar.lrn)});
                }
            }
            if (be.kS(str)) {
                if (be.kS(eVar2.lrn)) {
                    str = "地图选点";
                } else {
                    str = eVar2.lrn;
                }
            }
            format = format + String.format("&to=%s", new Object[]{URLEncoder.encode(str)});
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(format + "&referer=wx_client"));
            intent.setPackage(com.tencent.mm.pluginsdk.model.a.a.lyV.getPackage());
            context.startActivity(intent);
        }

        protected final String getPackageName() {
            return com.tencent.mm.pluginsdk.model.a.a.lyV.getPackage();
        }
    }

    public final void a(int i, int i2, Intent intent) {
        Context context = (Context) this.lrf.get();
        if (!(this.lrg == null || context == null)) {
            if (!this.lra) {
                v.e("MicroMsg.OpenMapNavigator", "onActivityResult called without msgId attached...");
            } else if (i != 33) {
                v.e("MicroMsg.OpenMapNavigator", "onActivityResult, mismatched request_code = %d", new Object[]{Integer.valueOf(i)});
                this.lrg.kR(this.lfB);
            } else if (i2 == 4097 || i2 == 0) {
                this.lrg.tj(this.lfB);
            } else if (i2 == -1) {
                String stringExtra = intent.getStringExtra("selectpkg");
                if (be.kS(stringExtra)) {
                    v.e("MicroMsg.OpenMapNavigator", "onActivityResult, get null packageName");
                    this.lrg.kR(this.lfB);
                } else {
                    f cVar = com.tencent.mm.pluginsdk.model.a.a.lyW.getPackage().equals(stringExtra) ? new c() : com.tencent.mm.pluginsdk.model.a.a.lyY.getPackage().equals(stringExtra) ? new a() : com.tencent.mm.pluginsdk.model.a.a.lyX.getPackage().equals(stringExtra) ? new g() : com.tencent.mm.pluginsdk.model.a.a.lyZ.getPackage().equals(stringExtra) ? new b() : new h();
                    cVar.a(context, this.lrc, this.lrd, this.lre);
                    this.lrg.hm(this.lfB);
                }
            } else {
                v.e("MicroMsg.OpenMapNavigator", "onActivityResult, not support result_code = %d", new Object[]{Integer.valueOf(i2)});
                this.lrg.kR(this.lfB);
            }
        }
        if (this.lra && this.lrg != null) {
            this.lrg.tk(this.lfB);
        }
        this.lra = false;
        this.lrb = com.tencent.mm.pluginsdk.model.a.a.lyV.aJW;
        this.lrc = null;
        this.lrd = null;
        this.lrf = null;
        this.lrg = null;
        this.lre = null;
        this.lrh = null;
        this.lri = null;
        if (!(this.cCR == null || this.lrj == null)) {
            this.cCR.c(this.lrj);
        }
        this.cCR = null;
        this.lrj = null;
        if (this.gXm != null) {
            if (this.lrh != null) {
                this.gXm.a(this.lrh);
            }
            if (this.lri != null) {
                this.gXm.a(this.lri);
            }
        }
        this.gXm = null;
        this.lrh = null;
        this.lri = null;
    }

    l() {
    }

    final void blG() {
        Context context = null;
        this.lrj = null;
        this.lrh = null;
        this.lri = null;
        if (this.lrf != null) {
            context = (Context) this.lrf.get();
        }
        if (context != null) {
            Intent intent = new Intent(context, AppChooserUI.class);
            ArrayList arrayList = new ArrayList(5);
            arrayList.add(com.tencent.mm.pluginsdk.model.a.a.lyV.getPackage());
            arrayList.add(com.tencent.mm.pluginsdk.model.a.a.lyW.getPackage());
            arrayList.add(com.tencent.mm.pluginsdk.model.a.a.lyX.getPackage());
            arrayList.add(com.tencent.mm.pluginsdk.model.a.a.lyY.getPackage());
            arrayList.add(com.tencent.mm.pluginsdk.model.a.a.lyZ.getPackage());
            intent.putStringArrayListExtra("targetwhitelist", arrayList);
            Parcelable intent2 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[]{Double.valueOf(this.lrd.latitude), Double.valueOf(this.lrd.longitude)})));
            intent.putExtra("targetintent", intent2);
            Bundle bundle = new Bundle(2);
            bundle.putInt("key_map_app", this.lrb);
            bundle.putParcelable("key_target_intent", intent2);
            intent.putExtra("key_recommend_params", bundle);
            intent.putExtra(Columns.TYPE, 2);
            intent.putExtra("title", context.getString(2131233527));
            ((MMActivity) context).a(this, intent, 33);
        }
    }
}
