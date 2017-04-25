package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.bm;
import com.tencent.mm.e.a.cp;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.n;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.protocal.c.arl;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.widget.f;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;

public class i extends a implements e {
    protected long bao = -1;
    private boolean ecK = false;
    private long gWv = 0;
    private String gZJ = "";
    public d gZK = new d(this.aXH);
    n gZL;
    f gZM;
    boolean gZN = false;
    private a gZO = new a(this) {
        final /* synthetic */ i gZP;

        {
            this.gZP = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            if (!z) {
                return false;
            }
            v.d("MicroMsg.ViewMapUI", "onGetLocation flong " + f + " flat " + f2);
            if (((double) f2) == 0.0d && ((double) f) == 0.0d) {
                return true;
            }
            v.d("MicroMsg.ViewMapUI", "myLocation " + this.gZP.gXi.gRK + " " + this.gZP.gXi.gRL);
            if (!this.gZP.gXi.avY()) {
                v.d("MicroMsg.ViewMapUI", "location my show");
                this.gZP.gXi.gRK = (double) f2;
                this.gZP.gXi.gRL = (double) f;
                this.gZP.gXm.a(this.gZP.gXi.gRK, this.gZP.gXi.gRL, this.gZP.gXu, this.gZP.gXi.gRJ);
            }
            return true;
        }
    };

    static /* synthetic */ void a(i iVar) {
        if (iVar.gZN) {
            r.a(new com.tencent.mm.pluginsdk.ui.tools.e());
            Intent intent = new Intent();
            intent.putExtra("show_bottom", false);
            intent.putExtra("jsapi_args_appid", "wx751a1acca5688ba3");
            intent.putExtra("rawUrl", iVar.gZJ);
            intent.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, 2131234753);
            intent.putExtra("webview_bg_color_rsID", 2131689547);
            c.b(iVar.aXH, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }

    public i(Activity activity) {
        super(activity);
        ak.vy().a(424, this);
    }

    public boolean axh() {
        if (this.gZM == null || !this.gZM.isShowing()) {
            axw();
            this.gZM.bKh();
        } else {
            this.gZM.bKi();
        }
        return true;
    }

    final void axw() {
        this.gZM = new f(this.aXH, f.pbS, false);
        this.gZM.jXn = new com.tencent.mm.ui.base.n.c(this) {
            final /* synthetic */ i gZP;

            {
                this.gZP = r1;
            }

            public final void a(l lVar) {
                if (this.gZP.gZN) {
                    lVar.a(0, this.gZP.getString(2131233546), 0);
                }
                lVar.a(1, this.gZP.getString(2131230722), 0);
                lVar.a(2, this.gZP.getString(2131233529), 0);
                if (this.gZP.type == 1) {
                    lVar.a(3, this.gZP.getString(2131234180), 0);
                } else if (this.gZP.type == 2 && this.gZP.aXH.getIntent().getBooleanExtra("kFavCanDel", true)) {
                    lVar.a(5, this.gZP.getString(2131232647), 0);
                    lVar.a(4, this.gZP.getString(2131231020), 0);
                }
                cp cpVar = new cp();
                cpVar.bay.bao = this.gZP.bao;
                com.tencent.mm.sdk.c.a.nhr.z(cpVar);
                if (cpVar.baz.aZW || g.l(aa.getContext(), 4)) {
                    lVar.a(6, this.gZP.getString(2131232303), 0);
                }
            }
        };
        this.gZM.jXo = new com.tencent.mm.ui.base.n.d(this) {
            final /* synthetic */ i gZP;

            {
                this.gZP = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                Intent intent;
                switch (menuItem.getItemId()) {
                    case 0:
                        i.a(this.gZP);
                        return;
                    case 1:
                        intent = new Intent();
                        intent.putExtra("Retr_Msg_content", com.tencent.mm.plugin.location.model.e.a(this.gZP.gXh));
                        intent.putExtra("Retr_Msg_Type", 9);
                        c.a(this.gZP.aXH, ".ui.transmit.MsgRetransmitUI", intent);
                        return;
                    case 2:
                        this.gZP.gXo = 0;
                        this.gZP.axy();
                        return;
                    case 3:
                        this.gZP.axx();
                        return;
                    case 4:
                        com.tencent.mm.ui.base.g.a(this.gZP.aXH, this.gZP.aXH.getString(2131231021), "", new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass2 gZQ;

                            {
                                this.gZQ = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                long longExtra = this.gZQ.gZP.aXH.getIntent().getLongExtra("kFavInfoLocalId", -1);
                                bm bmVar = new bm();
                                bmVar.aYY.aZa = longExtra;
                                com.tencent.mm.sdk.c.a.nhr.z(bmVar);
                                v.d("MicroMsg.ViewMapUI", "do del fav voice, local id %d, result %B", new Object[]{Long.valueOf(longExtra), Boolean.valueOf(be.a(Boolean.valueOf(bmVar.aYZ.aYN), false))});
                                if (be.a(Boolean.valueOf(bmVar.aYZ.aYN), false)) {
                                    this.gZQ.gZP.aXH.finish();
                                }
                            }
                        }, null);
                        return;
                    case 5:
                        long longExtra = this.gZP.aXH.getIntent().getLongExtra("kFavInfoLocalId", -1);
                        Intent intent2 = new Intent();
                        intent2.putExtra("key_fav_item_id", longExtra);
                        intent2.putExtra("key_fav_scene", 2);
                        c.b(this.gZP.aXH, "favorite", ".ui.FavTagEditUI", intent2);
                        return;
                    case 6:
                        intent = new Intent();
                        intent.putExtra("Retr_Msg_content", com.tencent.mm.plugin.location.model.e.a(this.gZP.gXh));
                        intent.putExtra("Retr_Msg_Id", this.gZP.bao);
                        c.a(this.gZP.aXH, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    void axf() {
        this.gXj.gXB.setEnabled(true);
        this.gXj.gXw.setVisibility(8);
        c(this.gXh);
        this.gXj.gUq.getIController().setZoom(this.zoom);
        this.gXj.gXz.setEnabled(true);
        this.gZJ = this.aXH.getIntent().getStringExtra("soso_street_view_url");
        if (!be.kS(this.gZJ) && (u.bsW() || u.bsV())) {
            this.gZN = true;
        } else if (u.bsW() || u.bsV()) {
            this.gZN = false;
            try {
                arl com_tencent_mm_protocal_c_arl = (arl) new x((float) this.gXh.gRL, (float) this.gXh.gRK, this.bao).cif.czk.czs;
                x xVar = new x(com_tencent_mm_protocal_c_arl);
                ak.vy().a(new x(com_tencent_mm_protocal_c_arl), 0);
            } catch (Exception e) {
                v.e("MicroMsg.ViewMapUI", e.toString());
            }
        }
        this.gXj.gXz.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ i gZP;

            {
                this.gZP = r1;
            }

            public final void onClick(View view) {
                this.gZP.axw();
                this.gZP.gZM.bKh();
            }
        });
        this.gZL = new n(this.gXj.gUq, this.aXH);
        n nVar = this.gZL;
        if (nVar.gWW != null) {
            nVar.gWW.setOnClickListener(new View.OnClickListener(nVar) {
                final /* synthetic */ n gXb;

                {
                    this.gXb = r1;
                }

                public final void onClick(View view) {
                    if (this.gXb.gWX == null) {
                        return;
                    }
                    if (this.gXb.gWX.getVisibility() == 0) {
                        this.gXb.gWX.setVisibility(4);
                        this.gXb.isVisible = false;
                        return;
                    }
                    this.gXb.gWX.setVisibility(0);
                    this.gXb.isVisible = true;
                }
            });
            nVar.gWX.setVisibility(0);
        }
        a(this.gZL);
        this.gZL.b(this.gXh);
        this.gZL.vU("");
        if (!com.tencent.mm.plugin.location.model.e.f(this.gXh.gRK, this.gXh.gRL)) {
            v.d("MicroMsg.ViewMapUI", "isValidLatLng %f %f", new Object[]{Double.valueOf(this.gXh.gRK), Double.valueOf(this.gXh.gRL)});
            nVar = this.gZL;
            nVar.gUo = false;
            nVar.gUp.setVisibility(8);
        }
        if (2 == this.type) {
            v.i("MicroMsg.ViewMapUI", "location id %s", new Object[]{this.gXh.gRJ});
            if (this.aXH.getIntent().getBooleanExtra("kFavCanRemark", true)) {
                axc();
            }
            if (!be.kS(this.gXh.gRM)) {
                this.gXj.gXx.setVisibility(0);
            }
        }
        this.gXl.put(this.gXh.gRJ, this.gZL);
        if (this.gXh.avZ()) {
            if (!(this.gUr == null || this.gUr.equals(""))) {
                this.gZL.gUr = this.gUr;
            }
            this.gZL.setText(this.gZL.gTN + this.gXh.gRM);
        } else if (com.tencent.mm.plugin.location.model.e.f(this.gXh.gRK, this.gXh.gRL)) {
            this.gXm.a(this.gXh.gRK, this.gXh.gRL, this.gXu, this.gXh.gRJ);
        }
        this.gXj.gXC = this.gZL.gXa;
        this.gXj.gXC.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ i gZP;

            {
                this.gZP = r1;
            }

            public final void onClick(View view) {
                this.gZP.gXo = 0;
                this.gZP.axr();
                this.gZP.axy();
            }
        });
        this.gXj.gXC.setVisibility(0);
    }

    protected void axr() {
    }

    public void onResume() {
        super.onResume();
        v.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
        if (this.gXt != null) {
            this.gXt.a(this.gZO);
        }
    }

    public void onPause() {
        v.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
        if (this.gXt != null) {
            this.gXt.c(this.gZO);
        }
        super.onPause();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        double doubleExtra = this.aXH.getIntent().getDoubleExtra("kwebmap_slat", 0.0d);
        double doubleExtra2 = this.aXH.getIntent().getDoubleExtra("kwebmap_lng", 0.0d);
        v.i("MicroMsg.ViewMapUI", "start dslat " + doubleExtra + " " + doubleExtra2);
        this.zoom = this.aXH.getIntent().getIntExtra("kwebmap_scale", 15);
        if (this.zoom <= 0) {
            this.zoom = 15;
        }
        this.gUr = this.aXH.getIntent().getStringExtra("kPoiName");
        String stringExtra = this.aXH.getIntent().getStringExtra("Kwebmap_locaion");
        v.d("MicroMsg.ViewMapUI", "view " + doubleExtra + " " + doubleExtra2);
        LocationInfo locationInfo = this.gXh;
        locationInfo.gRK = doubleExtra;
        locationInfo.gRL = doubleExtra2;
        locationInfo.gRM = stringExtra;
        locationInfo.zoom = this.zoom;
        locationInfo.bkV = this.gUr;
        this.bao = this.aXH.getIntent().getLongExtra("kMsgId", -1);
        this.gTc = this.aXH.getIntent().getStringExtra("map_talker_name");
        NI();
    }

    protected void axe() {
        Intent intent = new Intent();
        intent.putExtra("kopenGmapNums", this.gXg.gTT);
        intent.putExtra("kopenOthersNums", this.gXg.gTU);
        intent.putExtra("kopenreportType", this.gXg.cTZ);
        intent.putExtra("kRemark", axd());
        intent.putExtra("soso_street_view_url", this.gZJ);
        this.aXH.setResult(-1, intent);
    }

    protected final void axx() {
        v.d("MicroMsg.ViewMapUI", "directlyFavorite lat %s, long %s, scale", new Object[]{Double.valueOf(this.gXh.gRK), Double.valueOf(this.gXh.gRL)});
        Intent intent = new Intent();
        intent.putExtra("kfavorite", true);
        intent.putExtra("kopenGmapNums", this.gXg.gTT);
        intent.putExtra("kopenOthersNums", this.gXg.gTU);
        intent.putExtra("kopenreportType", this.gXg.cTZ);
        intent.putExtra("kRemark", axd());
        intent.putExtra("kwebmap_slat", this.gXh.gRK);
        intent.putExtra("kwebmap_lng", this.gXh.gRL);
        intent.putExtra("Kwebmap_locaion", this.gXh.gRM);
        intent.putExtra("kPoiName", this.gUr);
        this.aXH.setResult(-1, intent);
        this.aXH.getIntent().getIntExtra("MMActivity.OverrideEnterAnimation", -1);
        this.aXH.getIntent().getIntExtra("MMActivity.OverrideExitAnimation", -1);
        this.aXH.finish();
    }

    protected final void axy() {
        com.tencent.mm.plugin.report.service.g.iuh.h(12809, new Object[]{Integer.valueOf(3), ""});
        v.d("MicroMsg.ViewMapUI", "locationLine, locationInfo.slat=%f, locationInfo.slong=%f, myLocation.slat=%f, myLocation.slong=%f", new Object[]{Double.valueOf(this.gXh.gRK), Double.valueOf(this.gXh.gRL), Double.valueOf(this.gXi.gRK), Double.valueOf(this.gXi.gRL)});
        if (this.gXi.avY()) {
            this.gXg.a(this.gXh, this.gXi, this.gXo);
            return;
        }
        this.gXn = true;
        this.handler.postDelayed(new Runnable(this) {
            final /* synthetic */ i gZP;

            {
                this.gZP = r1;
            }

            public final void run() {
                if (this.gZP.gXn) {
                    if (this.gZP.dwR != null) {
                        this.gZP.dwR.dismiss();
                    }
                    this.gZP.gXg.a(this.gZP.gXh, this.gZP.gXi, this.gZP.gXo);
                }
                this.gZP.gXn = false;
            }
        }, 10000);
        Context context = this.aXH;
        getString(2131231164);
        this.dwR = com.tencent.mm.ui.base.g.a(context, getString(2131235420), true, new OnCancelListener(this) {
            final /* synthetic */ i gZP;

            {
                this.gZP = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.gZP.gXn = false;
            }
        });
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 4098:
            case 4099:
                com.tencent.mm.plugin.location.ui.d dVar = this.gXg;
                Intent b;
                String charSequence;
                switch (i) {
                    case 4098:
                        Bundle bundleExtra;
                        ArrayList parcelableArrayList;
                        LocationInfo locationInfo;
                        LocationInfo locationInfo2;
                        if (-1 == i2 && intent != null) {
                            String stringExtra = intent.getStringExtra("selectpkg");
                            bundleExtra = intent.getBundleExtra("transferback");
                            boolean booleanExtra = intent.getBooleanExtra("isalways", false);
                            parcelableArrayList = bundleExtra.getParcelableArrayList("locations");
                            locationInfo = (LocationInfo) parcelableArrayList.get(0);
                            locationInfo2 = (LocationInfo) parcelableArrayList.get(1);
                            if ("com.tencent.map".equals(stringExtra)) {
                                if (booleanExtra) {
                                    com.tencent.mm.plugin.report.service.g.iuh.h(11091, new Object[]{Integer.valueOf(4), Integer.valueOf(2)});
                                } else {
                                    com.tencent.mm.plugin.report.service.g.iuh.h(11091, new Object[]{Integer.valueOf(4), Integer.valueOf(1)});
                                }
                            } else if (booleanExtra) {
                                com.tencent.mm.plugin.report.service.g.iuh.h(11091, new Object[]{Integer.valueOf(5), Integer.valueOf(2)});
                            } else {
                                com.tencent.mm.plugin.report.service.g.iuh.h(11091, new Object[]{Integer.valueOf(5), Integer.valueOf(1)});
                            }
                            PackageManager packageManager = dVar.context.getPackageManager();
                            Intent b2;
                            if ("com.google.android.apps.maps".equals(stringExtra)) {
                                b = com.tencent.mm.plugin.location.ui.d.b(locationInfo, locationInfo2, false);
                                b2 = !be.m(dVar.context, b) ? com.tencent.mm.plugin.location.ui.d.b(locationInfo, locationInfo2, true) : b;
                                com.tencent.mm.plugin.report.service.g.iuh.h(10997, new Object[]{"4", "", Integer.valueOf(0), Integer.valueOf(0)});
                                dVar.context.startActivity(b2);
                                return;
                            } else if ("com.baidu.BaiduMap".equals(stringExtra)) {
                                b = com.tencent.mm.plugin.location.ui.d.a(locationInfo, locationInfo2, false);
                                b2 = !be.m(dVar.context, b) ? com.tencent.mm.plugin.location.ui.d.a(locationInfo, locationInfo2, true) : b;
                                charSequence = com.tencent.mm.plugin.location.model.e.ag(dVar.context, "com.baidu.BaiduMap").applicationInfo.loadLabel(packageManager).toString();
                                com.tencent.mm.plugin.report.service.g.iuh.h(10997, new Object[]{"5", charSequence, Integer.valueOf(0), Integer.valueOf(0)});
                                dVar.context.startActivity(b2);
                                return;
                            } else if ("com.tencent.map".equals(stringExtra)) {
                                b = com.tencent.mm.plugin.location.ui.d.a(dVar.context, locationInfo, locationInfo2, false);
                                b2 = !be.m(dVar.context, b) ? com.tencent.mm.plugin.location.ui.d.a(dVar.context, locationInfo, locationInfo2, true) : b;
                                com.tencent.mm.plugin.report.service.g.iuh.h(10997, new Object[]{"2", "", Integer.valueOf(0), Integer.valueOf(0)});
                                dVar.context.startActivity(b2);
                                return;
                            } else if ("com.autonavi.minimap".equals(stringExtra)) {
                                r6 = com.tencent.mm.plugin.location.model.e.ag(dVar.context, stringExtra);
                                if (r6 != null) {
                                    b = com.tencent.mm.plugin.location.ui.d.a(dVar.context, locationInfo, locationInfo2, false, stringExtra);
                                    b2 = !be.m(dVar.context, b) ? com.tencent.mm.plugin.location.ui.d.a(dVar.context, locationInfo, locationInfo2, true, stringExtra) : b;
                                    charSequence = r6.applicationInfo.loadLabel(packageManager).toString();
                                    com.tencent.mm.plugin.report.service.g.iuh.h(10997, new Object[]{"5", charSequence, Integer.valueOf(0), Integer.valueOf(0)});
                                    dVar.context.startActivity(b2);
                                    return;
                                }
                                return;
                            } else if ("com.sogou.map.android.maps".equals(stringExtra)) {
                                r6 = com.tencent.mm.plugin.location.model.e.ag(dVar.context, stringExtra);
                                if (r6 != null) {
                                    b = com.tencent.mm.plugin.location.ui.d.a(dVar.context, locationInfo, locationInfo2, false, stringExtra);
                                    b2 = !be.m(dVar.context, b) ? com.tencent.mm.plugin.location.ui.d.a(dVar.context, locationInfo, locationInfo2, true, stringExtra) : b;
                                    charSequence = r6.applicationInfo.loadLabel(packageManager).toString();
                                    com.tencent.mm.plugin.report.service.g.iuh.h(10997, new Object[]{"5", charSequence, Integer.valueOf(0), Integer.valueOf(0)});
                                    dVar.context.startActivity(b2);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        } else if (4097 == i2) {
                            if (intent.getBooleanExtra("isalways", false)) {
                                com.tencent.mm.plugin.report.service.g.iuh.h(11091, new Object[]{Integer.valueOf(6), Integer.valueOf(2)});
                            } else {
                                com.tencent.mm.plugin.report.service.g.iuh.h(11091, new Object[]{Integer.valueOf(6), Integer.valueOf(1)});
                            }
                            parcelableArrayList = intent.getBundleExtra("transferback").getParcelableArrayList("locations");
                            locationInfo = (LocationInfo) parcelableArrayList.get(0);
                            locationInfo2 = (LocationInfo) parcelableArrayList.get(1);
                            Parcelable intent2 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=" + (be.kS(locationInfo.gRN) ? "zh-cn" : locationInfo.gRN), new Object[]{Double.valueOf(locationInfo2.gRK), Double.valueOf(locationInfo2.gRL), Double.valueOf(locationInfo.gRK), Double.valueOf(locationInfo.gRL)})));
                            bundleExtra = new Bundle();
                            bundleExtra.putParcelable("targetintent", intent2);
                            b = new Intent();
                            b.setClass(dVar.context, AppChooserUI.class);
                            b.putExtra("type", 1);
                            b.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, dVar.context.getResources().getString(2131233527));
                            b.putExtra("targetintent", intent2);
                            b.putExtra("transferback", bundleExtra);
                            b.putExtra("scene", 6);
                            ((Activity) dVar.context).startActivityForResult(b, 4099);
                            return;
                        } else {
                            return;
                        }
                    case 4099:
                        if (-1 == i2 && intent != null) {
                            charSequence = intent.getStringExtra("selectpkg");
                            b = new Intent((Intent) intent.getBundleExtra("transferback").getParcelable("targetintent"));
                            b.setPackage(charSequence);
                            b.addFlags(524288);
                            dVar.context.startActivity(b);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            default:
                return;
        }
    }

    public void onDestroy() {
        this.gZK.release();
        this.handler = null;
        ak.vy().b(424, this);
        super.onDestroy();
    }

    protected final String NK() {
        return getString(2131233536);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.gpD = motionEvent.getX();
                this.euH = motionEvent.getY();
                this.gWv = System.currentTimeMillis();
                this.ecK = false;
                axs();
                break;
            case 1:
                if (!this.ecK) {
                    System.currentTimeMillis();
                }
                axq();
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.gpD) > 10.0f || Math.abs(motionEvent.getY() - this.euH) > 10.0f) {
                    this.ecK = true;
                    axp();
                    break;
                }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void axp() {
        if (this.gZL != null) {
            this.gZL.ea(false);
        }
    }

    public void axq() {
        if (this.gZL != null) {
            this.gZL.ea(true);
        }
    }

    public void axs() {
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.d("MicroMsg.ViewMapUI", "onScene end %d %d %d", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        if (kVar.getType() != 424) {
            v.e("MicroMsg.ViewMapUI", "msg failed.errtype:%d, errcode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (i2 == 0 && i == 0) {
            String ki = x.ki(((x) kVar).Jw().mii);
            v.d("MicroMsg.ViewMapUI", "getUrl success! url is %s", new Object[]{ki});
            this.gZJ = ki;
            if (!be.kS(ki)) {
                this.gZN = true;
            }
            if (this.type == 9 && !be.kS(ki)) {
                TextView textView = (TextView) findViewById(2131757411);
                textView.setVisibility(0);
                textView.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ i gZP;

                    {
                        this.gZP = r1;
                    }

                    public final void onClick(View view) {
                        i.a(this.gZP);
                    }
                });
            }
        }
    }
}
