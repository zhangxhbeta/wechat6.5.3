package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.mm.e.a.kc;
import com.tencent.mm.e.a.mr;
import com.tencent.mm.e.a.pe;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.ui.impl.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.location.LocationIntent;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;

@a(23)
public class RedirectUI extends Activity {
    private static long bYq = 86400000;
    private long bao;
    private boolean bhY = false;
    private int eKg;
    private double gRK = 0.0d;
    private double gRL = 0.0d;
    private boolean gTV = true;
    private String gUD = "";
    private String gUE = "";
    private int gUF;
    private final int gUG = 1;
    private boolean gUH = false;
    private final int gUI = 0;
    private final int gUJ = 1;
    private final int gUK = 0;
    private final int gUL = 1;
    private final ac handler = new ac();
    private String info = "";
    private int type = 0;
    private int zoom = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(0);
        }
        ak.yW();
        if ((be.ax(Long.valueOf(be.d((Long) c.vf().get(81938, null))).longValue()) * 1000 > bYq ? 1 : 0) != 0) {
            com.tencent.mm.al.c.HL().update();
        }
        this.type = getIntent().getIntExtra("map_view_type", -1);
        if (this.type == -1) {
            finish();
        }
        this.bao = getIntent().getLongExtra("kMsgId", -1);
        this.gUE = getIntent().getStringExtra("map_talker_name");
        v.d("MicroMsg.RedirectUI", "tofutest type: %s", new Object[]{Integer.valueOf(this.type)});
        switch (this.type) {
            case 0:
            case 3:
            case 8:
                this.gUD = getIntent().getStringExtra("map_sender_name");
                this.eKg = getIntent().getIntExtra("view_type_key", 1);
                this.gUF = getIntent().getIntExtra("key_get_location_type", 0);
                h(-1000.0d, -1000.0d);
                return;
            case 1:
            case 2:
            case 7:
            case NetStatusUtil.MOBILE /*9*/:
                this.gRK = getIntent().getDoubleExtra("kwebmap_slat", -1000.0d);
                this.gRL = getIntent().getDoubleExtra("kwebmap_lng", -1000.0d);
                this.zoom = getIntent().getIntExtra("kwebmap_scale", 0);
                this.info = getIntent().getStringExtra("Kwebmap_locaion");
                h(this.gRK, this.gRL);
                return;
            case 6:
                com.tencent.mm.plugin.location.a.a vI = l.awj().vI(this.gUE);
                v.i("MicroMsg.RedirectUI", "resume try to enter trackRoom " + (vI != null));
                if (vI != null) {
                    this.gRK = vI.latitude;
                    this.gRL = vI.longitude;
                    this.info = vI.gRG;
                    v.i("MicroMsg.RedirectUI", "resume lat %f lng %f %s member size %d", new Object[]{Double.valueOf(this.gRK), Double.valueOf(this.gRL), this.info, Integer.valueOf(vI.biC.size())});
                    this.zoom = 0;
                    h(this.gRK, this.gRL);
                    return;
                }
                h(-1000.0d, -1000.0d);
                return;
            default:
                return;
        }
    }

    private void h(double d, double d2) {
        this.bhY = true;
        Intent w = d.w(this);
        switch (this.type) {
            case 0:
            case 3:
            case 8:
                String str = "MicroMsg.RedirectUI";
                StringBuilder stringBuilder = new StringBuilder("view poi      isHidePoiOversea : ");
                boolean z = be.getInt(j.sV().z("ShowConfig", "hidePoiOversea"), 1) == 1;
                v.d("MicroMsg.ConfigListDecoder", "isHidePoiOversea : " + z);
                v.d(str, stringBuilder.append(z).toString());
                w.putExtra("intent_map_key", 2);
                break;
            case 1:
            case 2:
            case 7:
                v.d("MicroMsg.RedirectUI", "view normal");
                w.putExtra("intent_map_key", 4);
                break;
            case 6:
                String stringExtra = getIntent().getStringExtra("fromWhereShare");
                v.d("MicroMsg.RedirectUI", "location resume");
                w.putExtra("intent_map_key", 5);
                if (!be.kS(stringExtra)) {
                    w.putExtra("fromWhereShare", stringExtra);
                    break;
                }
                break;
            case NetStatusUtil.MOBILE /*9*/:
                w.putExtra("intent_map_key", 4);
                break;
            default:
                v.d("MicroMsg.RedirectUI", "view type error");
                w = null;
                break;
        }
        switch (this.type) {
            case 0:
                w.putExtra("location_scene", 1);
                break;
        }
        if (q.dpH) {
            final double d3 = d;
            final double d4 = d2;
            this.handler.postDelayed(new Runnable(this) {
                final /* synthetic */ RedirectUI gUM;

                public final void run() {
                    this.gUM.a(w, d3, d4);
                }
            }, 2000);
            return;
        }
        a(w, d, d2);
    }

    private void a(Intent intent, double d, double d2) {
        if (intent != null) {
            ak.yW();
            intent.putExtra("kimg_path", c.wP());
            intent.putExtra("kPoi_url", be.ah(getIntent().getStringExtra("kPoi_url"), ""));
            intent.putExtra("map_view_type", getIntent().getIntExtra("map_view_type", 0));
            intent.putExtra("kFavInfoLocalId", getIntent().getLongExtra("kFavInfoLocalId", -1));
            intent.putExtra("kFavCanDel", getIntent().getBooleanExtra("kFavCanDel", true));
            intent.putExtra("kFavCanRemark", getIntent().getBooleanExtra("kFavCanRemark", true));
            intent.putExtra("kwebmap_slat", d);
            intent.putExtra("kwebmap_lng", d2);
            intent.putExtra("kPoiName", getIntent().getStringExtra("kPoiName"));
            intent.putExtra("kisUsername", be.ah(getIntent().getStringExtra("kisUsername"), ""));
            intent.putExtra("map_talker_name", this.gUE);
            intent.putExtra("kIs_pick_poi", getIntent().getBooleanExtra("kIs_pick_poi", false));
            intent.putExtra("KFavLocSigleView", getIntent().getBooleanExtra("KFavLocSigleView", false));
            pe peVar = new pe();
            peVar.bqy.bqz = true;
            com.tencent.mm.sdk.c.a.nhr.z(peVar);
            if (this.type == 6) {
                intent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1));
                intent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
                if (this.zoom > 0) {
                    intent.putExtra("kwebmap_scale", this.zoom);
                }
                intent.putExtra("Kwebmap_locaion", this.info);
                intent.putExtra("soso_street_view_url", getIntent().getStringExtra("soso_street_view_url"));
                startActivityForResult(intent, 3);
                return;
            } else if (this.type == 1 || this.type == 2 || this.type == 7 || this.type == 9) {
                intent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1));
                intent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
                intent.putExtra("kTags", getIntent().getStringArrayListExtra("kTags"));
                if (this.zoom > 0) {
                    intent.putExtra("kwebmap_scale", this.zoom);
                }
                intent.putExtra("Kwebmap_locaion", this.info);
                intent.putExtra("soso_street_view_url", getIntent().getStringExtra("soso_street_view_url"));
                startActivityForResult(intent, 3);
                return;
            } else if (this.type == 0) {
                startActivityForResult(intent, 2);
                return;
            } else if (this.type == 3) {
                startActivityForResult(intent, 5);
                return;
            } else if (this.type == 8) {
                startActivityForResult(intent, 6);
                return;
            } else {
                return;
            }
        }
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.RedirectUI", "onAcvityResult requestCode:" + i);
        if (i2 != -1) {
            finish();
        } else if (intent == null) {
            finish();
        } else {
            LocationIntent locationIntent;
            switch (i) {
                case 2:
                    String str = this.gUE;
                    locationIntent = (LocationIntent) intent.getParcelableExtra("KLocationIntent");
                    v.i("MicroMsg.RedirectUI", "locationintent " + locationIntent.Wb());
                    kc kcVar = new kc();
                    kcVar.bkS.bkU = this.gUF;
                    kcVar.bkS.lat = locationIntent.lat;
                    kcVar.bkS.lng = locationIntent.lng;
                    kcVar.bkS.bhu = locationIntent.bhu;
                    kcVar.bkS.label = locationIntent.label;
                    kcVar.bkS.bkV = locationIntent.gUr;
                    com.tencent.mm.sdk.c.a.nhr.z(kcVar);
                    double d = locationIntent.lat;
                    double d2 = locationIntent.lng;
                    int i3 = locationIntent.bhu;
                    String str2 = locationIntent.label;
                    String str3 = locationIntent.gUr;
                    String str4 = locationIntent.lyO;
                    if (str3 == null) {
                        str3 = "";
                    }
                    str3 = "<msg><location x=\"" + d + "\" y=\"" + d2 + "\" scale=\"" + i3 + "\" label=\"" + be.KJ(str2) + "\" poiname=\"" + be.KJ(str3) + "\" infourl=\"" + be.KJ(str4) + "\" maptype=\"0" + "\" /></msg>";
                    v.d("MicroMsg.RedirectUI", "xml " + str3);
                    mr mrVar = new mr();
                    mrVar.boa.bob = str;
                    mrVar.boa.content = str3;
                    mrVar.boa.type = 48;
                    mrVar.boa.flags = 0;
                    com.tencent.mm.sdk.c.a.nhr.z(mrVar);
                    n.a(2004, (float) locationIntent.lng, (float) locationIntent.lat, 0);
                    break;
                case 5:
                    locationIntent = (LocationIntent) intent.getParcelableExtra("KLocationIntent");
                    v.i("MicroMsg.RedirectUI", "locationintent " + locationIntent.Wb());
                    if (locationIntent.lyP == 3) {
                        g.iuh.h(10822, new Object[]{Integer.valueOf(1), locationIntent.gRO, Integer.valueOf(1)});
                    } else {
                        g.iuh.h(10822, new Object[]{Integer.valueOf(1), locationIntent.gRO, Integer.valueOf(0)});
                    }
                    intent.putExtra("kwebmap_slat", locationIntent.lat);
                    intent.putExtra("kwebmap_lng", locationIntent.lng);
                    intent.putExtra("kwebmap_scale", locationIntent.bhu);
                    intent.putExtra("Kwebmap_locaion", locationIntent.label);
                    intent.putExtra("kTags", intent.getStringArrayListExtra("kTags"));
                    intent.putExtra("kPoiName", locationIntent.gUr.equals("") ? "" : locationIntent.gUr);
                    break;
                case 6:
                    locationIntent = (LocationIntent) intent.getParcelableExtra("KLocationIntent");
                    v.i("MicroMsg.RedirectUI", "locationintent " + locationIntent.Wb());
                    if (locationIntent.cJy != null) {
                        v.d("MicroMsg.RedirectUI", "addr: " + locationIntent.cJy.toString());
                    }
                    intent.putExtra("key_pick_addr", locationIntent.cJy);
                    break;
            }
            setResult(i2, intent);
            finish();
        }
    }

    protected void onDestroy() {
        this.gTV = false;
        super.onDestroy();
    }

    public void finish() {
        super.finish();
    }
}
