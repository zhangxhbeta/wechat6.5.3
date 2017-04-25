package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.e.a.ez;
import com.tencent.mm.e.a.pd;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.location.a.a;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.MyLocationButton;
import com.tencent.mm.plugin.location.ui.NewMyLocationButton;
import com.tencent.mm.plugin.location.ui.f;
import com.tencent.mm.plugin.location.ui.l;
import com.tencent.mm.plugin.location.ui.l.1;
import com.tencent.mm.plugin.location.ui.l.2;
import com.tencent.mm.plugin.location.ui.l.3;
import com.tencent.mm.plugin.location.ui.l.9;
import com.tencent.mm.plugin.location.ui.m;
import com.tencent.mm.plugin.location.ui.n;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.d.e;
import java.util.ArrayList;

public final class h extends i {
    MyLocationButton gZb;
    m gZd;
    l gZf;
    private Button gZr;
    private NewMyLocationButton gZs;
    private f gZt;
    private View gZu;
    private boolean gZv = false;

    static /* synthetic */ void a(h hVar) {
        v.i("MicroMsg.TrackMapUI", "onShare");
        d.w(hVar.aXH);
        Intent intent = hVar.aXH.getIntent();
        intent.putExtra("intent_map_key", 5);
        intent.putExtra("kwebmap_scale", hVar.gXj.gUq.getZoomLevel());
        a vI = com.tencent.mm.plugin.location.model.l.awj().vI(hVar.gTc);
        if (vI != null && vI.biC.size() > 0) {
            intent.putExtra("kwebmap_slat", vI.latitude);
            intent.putExtra("kwebmap_lng", vI.longitude);
            intent.putExtra("Kwebmap_locaion", vI.gRG);
            intent.putExtra("fromWhereShare", "fromTrackButton");
        }
        hVar.aXH.startActivity(intent);
        hVar.aXH.finish();
    }

    public h(Activity activity) {
        super(activity);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    final void axf() {
        super.axf();
        if (this.aXH.getIntent().getBooleanExtra("KFavLocSigleView", false) && this.aXH.getIntent().getBooleanExtra("kFavCanRemark", false)) {
            this.gZv = true;
        }
        v.d("MicroMsg.TrackMapUI", "oldVer %s", new Object[]{Boolean.valueOf(this.gZv)});
        ((TextView) findViewById(2131758190)).setText(2131233526);
        findViewById(2131758192).setVisibility(8);
        if (!this.gZv) {
            ViewStub viewStub = (ViewStub) findViewById(2131757410);
            viewStub.setOnInflateListener(new OnInflateListener(this) {
                final /* synthetic */ h gZw;

                {
                    this.gZw = r1;
                }

                public final void onInflate(ViewStub viewStub, View view) {
                    view.findViewById(2131758450).setOnTouchListener(new OnTouchListener(this) {
                        final /* synthetic */ AnonymousClass1 gZx;

                        {
                            this.gZx = r1;
                        }

                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            return true;
                        }
                    });
                }
            });
            this.gZu = viewStub.inflate();
            findViewById(2131757409).setVisibility(8);
        }
        this.gZd = new m(this.aXH, this.gXj.gUq, false);
        this.gZd.gWs = false;
        this.gZd.gWt = false;
        m mVar = this.gZd;
        mVar.gWq = true;
        if (mVar.gWj != null) {
            mVar.gWj.c(null);
            mVar.gWj.b(null);
            mVar.gWj.axt();
        }
        this.gZd.gWn = false;
        this.gZf = new l(this.aXH, new l.a(this) {
            final /* synthetic */ h gZw;

            {
                this.gZw = r1;
            }

            public final void dX(boolean z) {
                if (com.tencent.mm.plugin.location.model.l.awj().bY(this.gZw.gTc, k.xF()) || z || this.gZw.d(this.gZw.gXh)) {
                    h.a(this.gZw);
                    return;
                }
                l lVar = this.gZw.gZf;
                if (lVar.gWf == null) {
                    lVar.gWf = g.a(lVar.mContext, lVar.BE.getString(2131233524), "", false, new 9(lVar), new 2(lVar));
                }
            }

            public final void awW() {
            }

            public final void mt(int i) {
            }

            public final void awX() {
            }

            public final void awY() {
                h.a(this.gZw);
            }
        });
        if (this.gZv) {
            boolean z;
            this.gZr = (Button) findViewById(2131757413);
            this.gZr.setVisibility(0);
            this.gZr.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ h gZw;

                {
                    this.gZw = r1;
                }

                public final void onClick(View view) {
                    boolean z = j.a.lxQ != null && j.a.lxQ.vJ(this.gZw.gTc);
                    boolean z2;
                    if (j.a.lxG == null || !j.a.lxG.CB(this.gZw.gTc)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (z || !r2) {
                        l lVar = this.gZw.gZf;
                        if (!l.mr(67589)) {
                            g.a(lVar.mContext, lVar.BE.getString(2131233543), "", false, new 1(lVar), new 3(lVar));
                            l.ms(67589);
                            return;
                        } else if (lVar.gWe != null) {
                            lVar.gWe.dX(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    pd pdVar = new pd();
                    pdVar.bqt.bqv = true;
                    com.tencent.mm.sdk.c.a.nhr.z(pdVar);
                    if (this.gZw.gTc.equals(pdVar.bqu.bqx)) {
                        g.a(this.gZw.aXH, this.gZw.getString(2131232450), "", this.gZw.getString(2131233285), false, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass4 gZy;

                            {
                                this.gZy = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    } else {
                        g.a(this.gZw.aXH, this.gZw.getString(2131232451), "", this.gZw.getString(2131233285), false, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass4 gZy;

                            {
                                this.gZy = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    }
                }
            });
            this.gZr.setEnabled(true);
            if (this.type == 2) {
                z = false;
            } else if (this.type == 3) {
                z = false;
            } else if (this.type == 7) {
                z = false;
            } else if (this.type == 9) {
                z = false;
            } else if (this.bao != -1) {
                ak.yW();
                at ek = c.wJ().ek(this.bao);
                z = (com.tencent.mm.model.m.eD(ek.field_talker) || com.tencent.mm.model.m.fk(ek.field_talker) || u.LH(ek.field_talker) || u.LJ(ek.field_talker) || u.ew(ek.field_talker)) ? false : true;
            } else {
                z = true;
            }
            if (!z) {
                this.gZr.setVisibility(8);
            }
        } else {
            findViewById(2131757413).setVisibility(8);
        }
        this.gXj.gXy.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ h gZw;

            {
                this.gZw = r1;
            }

            public final void onClick(View view) {
                this.gZw.axe();
                this.gZw.axg();
                this.gZw.aXH.finish();
            }
        });
        final String stringExtra;
        if (this.gZv) {
            this.gZb = (MyLocationButton) findViewById(2131757409);
            this.gZb.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ h gZw;

                {
                    this.gZw = r1;
                }

                public final void onClick(View view) {
                    v.d("MicroMsg.TrackMapUI", "newpoi my position ", new Object[]{this.gZw.gZb});
                    this.gZw.gZd.a(this.gZw.gXj.gUq);
                }
            });
            if (this.type == 2 && this.aXH.getIntent().getBooleanExtra("kFavCanRemark", true)) {
                ((MarginLayoutParams) this.gZb.getLayoutParams()).bottomMargin = com.tencent.mm.bd.a.fromDPToPix(this.aXH, 80);
            }
            stringExtra = this.aXH.getIntent().getStringExtra("kPoi_url");
            if (be.kS(stringExtra)) {
                this.gXj.gXF.setVisibility(8);
            } else {
                this.gXj.gXF.setVisibility(0);
                this.gXj.gXF.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ h gZw;

                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setClass(this.gZw.aXH, e.class);
                        v.d("MicroMsg.TrackMapUI", "click url %s", new Object[]{stringExtra});
                        intent.putExtra("rawUrl", stringExtra);
                        intent.putExtra("showShare", false);
                        com.tencent.mm.ay.c.a(this.gZw.aXH, "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                    }
                });
            }
        } else {
            this.gZs = (NewMyLocationButton) this.gZu.findViewById(2131758449);
            this.gZs.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ h gZw;

                {
                    this.gZw = r1;
                }

                public final void onClick(View view) {
                    this.gZw.gZd.a(this.gZw.gXj.gUq);
                }
            });
            stringExtra = this.aXH.getIntent().getStringExtra("kPoi_url");
            if (be.kS(stringExtra)) {
                this.gXj.gXF.setVisibility(8);
            } else {
                this.gXj.gXF.setVisibility(0);
                this.gXj.gXF.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ h gZw;

                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setClass(this.gZw.aXH, e.class);
                        v.d("MicroMsg.TrackMapUI", "click url %s", new Object[]{stringExtra});
                        intent.putExtra("rawUrl", stringExtra);
                        intent.putExtra("showShare", false);
                        com.tencent.mm.ay.c.a(this.gZw.aXH, "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                    }
                });
            }
        }
        if (!this.gZv) {
            n nVar = this.gZL;
            if (nVar.gUp != null && nVar.gWW == null) {
                nVar.gWW = (ImageView) nVar.gUp.findViewById(2131757713);
            }
            nVar.gWW.setImageResource(2130838479);
            this.gZL.gWY.setVisibility(4);
            this.gZt = new f(this.gXj.gUq, this.aXH);
            if (this.gXh.avZ()) {
                if (!(this.gUr == null || this.gUr.equals(""))) {
                    this.gZt.gUr = this.gUr;
                }
                this.gZt.setText(this.gZL.gTN + this.gXh.gRM);
            }
            OnClickListener anonymousClass2 = new OnClickListener(this) {
                final /* synthetic */ h gZw;

                {
                    this.gZw = r1;
                }

                public final void onClick(View view) {
                    v.d("MicroMsg.TrackMapUI", "newpoi old go back onclick");
                    this.gZw.gXo = 0;
                    this.gZw.axr();
                    this.gZw.axy();
                }
            };
            f fVar = this.gZt;
            fVar.gUu.setOnClickListener(anonymousClass2);
            fVar.gUu.setVisibility(0);
        }
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            keyEvent.getAction();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public final void axp() {
        super.axp();
    }

    public final void axq() {
        super.axq();
    }

    public final void axs() {
        super.axs();
        v.i("MicroMsg.TrackMapUI", "onDown");
    }

    public final boolean d(LocationInfo locationInfo) {
        a vI = com.tencent.mm.plugin.location.model.l.awj().vI(this.gTc);
        v.i("MicroMsg.TrackMapUI", "resume try to enter trackRoom " + (vI != null));
        if (vI == null) {
            return true;
        }
        if (!be.kS(vI.gRG) && !be.kS(locationInfo.gRM) && !vI.gRG.equals(locationInfo.gRM)) {
            return false;
        }
        if (Math.abs(vI.latitude - locationInfo.gRK) >= 0.001d || Math.abs(vI.longitude - locationInfo.gRL) >= 0.001d) {
            return false;
        }
        return true;
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.gZd != null) {
            this.gZd.destroy();
        }
    }

    public final void onResume() {
        super.onResume();
        if (this.gZd != null) {
            this.gZd.onResume();
        }
        if (this.type == 2) {
            ez ezVar = new ez();
            ezVar.bdQ.aZa = this.aXH.getIntent().getLongExtra("kFavInfoLocalId", -1);
            ezVar.bdQ.type = 4;
            com.tencent.mm.sdk.c.a.nhr.z(ezVar);
            if (ezVar.bdR.bdY != null) {
                if (this.gXp == null) {
                    this.gXp = new ArrayList();
                } else {
                    this.gXp.clear();
                }
                this.gXp.addAll(ezVar.bdR.bdY);
                axb();
            }
        }
    }

    public final void onPause() {
        super.onPause();
        if (this.gZd != null) {
            this.gZd.onPause();
        }
    }
}
