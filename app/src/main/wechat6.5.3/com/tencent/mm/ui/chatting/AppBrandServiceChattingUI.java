package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.TextView;
import com.tencent.mm.e.a.jc;
import com.tencent.mm.e.a.ji;
import com.tencent.mm.e.a.ln;
import com.tencent.mm.e.a.m;
import com.tencent.mm.e.a.rg;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelappbrand.AppBrandExportUrlParams;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.n;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.l;
import com.tencent.mmdb.database.SQLiteDatabase;

public class AppBrandServiceChattingUI extends MMFragmentActivity {
    public p ojM;
    public ac ojN = new ac();

    @SuppressLint({"ValidFragment"})
    public static class a extends com.tencent.mm.ui.chatting.ChattingUI.a {
        private String appId;
        private String dQM;
        private l eyZ;
        private int fromScene;
        private OnCreateContextMenuListener ima;
        private boolean ojQ;
        private c<ji> ojR;
        private AppBrandExportUrlParams pRJ;

        public static class a extends cr {
            public a(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
                super(aVar);
            }

            protected final CharSequence c(CharSequence charSequence, TextView textView) {
                if (!(charSequence instanceof SpannableString)) {
                    return charSequence;
                }
                textView.setText(((SpannableString) charSequence).toString());
                e.h(textView);
                return textView.getText();
            }
        }

        public a(byte b) {
            super(true);
        }

        public final void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.fromScene = getIntExtra("app_brand_chatting_from_scene", 1);
            String str = "app_brand_chatting_export_url_params";
            Parcelable parcelable = null;
            if (this.nAV && bzo() != null) {
                parcelable = bzo().getIntent().getParcelableExtra(str);
            }
            if (parcelable == null && this.oJ != null) {
                parcelable = this.oJ.getParcelable(str);
            }
            this.pRJ = (AppBrandExportUrlParams) parcelable;
            v.d("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate fromScene:%d", Integer.valueOf(this.fromScene));
        }

        public final void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            if (this.fromScene == 2) {
                ak.vy().a(new k(bEn(), 19, getStringExtra("key_temp_session_from")), 0);
                v.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onActivityCreated NetSceneEnterTempSession");
            }
            this.dQM = be.ma(getStringExtra("key_scene_id"));
            this.ojR = new c<ji>(this) {
                final /* synthetic */ a ojS;

                {
                    this.ojS = r2;
                    this.nhz = ji.class.getName().hashCode();
                }

                public final /* synthetic */ boolean a(b bVar) {
                    boolean z = false;
                    ji jiVar = (ji) bVar;
                    if (jiVar.bjM == null || jiVar.bjM.aWH == null) {
                        v.e("MicroMsg.AppBrandServiceChattingUI", "OnWxaOptionsChangedEvent event is empty");
                        return false;
                    }
                    v.d("MicroMsg.AppBrandServiceChattingUI", "OnWxaOptionsChangedEvent username:%s,event.brandId:%s,event.newValue:%d", this.ojS.bhV.field_username, jiVar.bjM.aWH, Integer.valueOf(jiVar.bjM.bjN));
                    if (!jiVar.bjM.aWH.equals(this.ojS.bhV.field_username)) {
                        return true;
                    }
                    a aVar = this.ojS;
                    if ((jiVar.bjM.bjN & 2) > 0) {
                        z = true;
                    }
                    aVar.ojQ = z;
                    this.ojS.nDR.nEl.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 ojT;

                        {
                            this.ojT = r1;
                        }

                        public final void run() {
                            if (this.ojT.ojS.ojQ) {
                                v.d("MicroMsg.AppBrandServiceChattingUI", "OnWxaOptionsChangedEvent refuse:%b, setRejectIcon View.Visible", Boolean.valueOf(this.ojT.ojS.ojQ));
                                this.ojT.ojS.xj(0);
                                return;
                            }
                            v.d("MicroMsg.AppBrandServiceChattingUI", "OnWxaOptionsChangedEvent refuse:%b, setRejectIcon View.GONE", Boolean.valueOf(this.ojT.ojS.ojQ));
                            this.ojT.ojS.xj(8);
                        }
                    });
                    return true;
                }
            };
            com.tencent.mm.sdk.c.a.nhr.e(this.ojR);
        }

        public final void bDK() {
            boolean z;
            super.bDK();
            this.hjH.bpC();
            this.hjH.bpL();
            this.hjH.bpX();
            this.hjH.bqa();
            this.hjH.bpQ();
            this.hjH.bpM();
            this.hjH.bpO();
            this.hjH.bpP();
            this.hjH.bpQ();
            this.hjH.bpM();
            this.hjH.bpZ();
            this.hjH.ahm();
            this.hjH.bpR();
            this.hjH.bpS();
            this.hjH.ii(true);
            this.hjH.ij(true);
            this.hjH.bpT();
            this.hjH.bpU();
            this.hjH.bpV();
            this.hjH.bpP();
            this.hjH.bpW();
            this.hjH.ih(com.tencent.mm.ay.c.brh());
            b mVar = new m();
            mVar.aWJ.aWH = this.bhV.field_username;
            com.tencent.mm.sdk.c.a.nhr.z(mVar);
            if (!mVar.aWK.aWL || (mVar.aWK.aWN & 2) <= 0) {
                z = false;
            } else {
                z = true;
            }
            this.ojQ = z;
            this.appId = mVar.aWK.appId;
            if (this.ojQ) {
                xj(0);
            } else {
                xj(8);
            }
            if (this.fromScene == 2) {
                String str = this.appId;
                String str2 = this.bhV.field_username;
                int i = this.fromScene;
                ak.yW();
                af Mh = com.tencent.mm.model.c.wK().Mh(str2);
                if (Mh == null) {
                    v.e("MicroMsg.AppBrandServiceChattingUI", "cvs:%s is null, error", str2);
                    return;
                }
                int i2 = Mh.field_unReadCount;
                String ma = be.ma(this.dQM);
                v.d("MicroMsg.AppBrandServiceChattingUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", Integer.valueOf(13799), str, Integer.valueOf(i), Integer.valueOf(i2), ma);
                g.iuh.h(13799, str, Integer.valueOf(i), Integer.valueOf(i2), ma, Long.valueOf(be.Nh()));
            }
        }

        protected final void bDL() {
            super.bDL();
            vE(2131230996);
        }

        protected final void bDM() {
            Fd(this.bhV.field_nickname);
            if (this.ojQ) {
                xj(0);
            } else {
                xj(8);
            }
        }

        protected final void bDN() {
            a(0, 2131230965, 2130838681, new n(this) {
                final /* synthetic */ a ojS;

                {
                    this.ojS = r1;
                }

                public final void bfd() {
                    int i;
                    boolean ale = this.ojS.ale();
                    Runnable anonymousClass1 = new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 ojU;

                        {
                            this.ojU = r1;
                        }

                        public final void run() {
                            com.tencent.mm.ui.appbrand.b bVar;
                            if (this.ojU.ojS.fromScene == 2) {
                                if (this.ojU.ojS.ojQ) {
                                    bVar = new com.tencent.mm.ui.appbrand.b(this.ojU.ojS.nDR.nEl, this.ojU.ojS.bhV.field_username, this.ojU.ojS.bhV.field_nickname, this.ojU.ojS.appId, this.ojU.ojS.pRJ, 1, this.ojU.ojS.fromScene, this.ojU.ojS.dQM);
                                } else {
                                    bVar = new com.tencent.mm.ui.appbrand.b(this.ojU.ojS.nDR.nEl, this.ojU.ojS.bhV.field_username, this.ojU.ojS.bhV.field_nickname, this.ojU.ojS.appId, this.ojU.ojS.pRJ, 2, this.ojU.ojS.fromScene, this.ojU.ojS.dQM);
                                }
                            } else if (this.ojU.ojS.ojQ) {
                                bVar = new com.tencent.mm.ui.appbrand.b(this.ojU.ojS.nDR.nEl, this.ojU.ojS.bhV.field_username, this.ojU.ojS.bhV.field_nickname, this.ojU.ojS.appId, this.ojU.ojS.pRJ, 5, this.ojU.ojS.fromScene, this.ojU.ojS.dQM);
                            } else {
                                bVar = new com.tencent.mm.ui.appbrand.b(this.ojU.ojS.nDR.nEl, this.ojU.ojS.bhV.field_username, this.ojU.ojS.bhV.field_nickname, this.ojU.ojS.appId, this.ojU.ojS.pRJ, 6, this.ojU.ojS.fromScene, this.ojU.ojS.dQM);
                            }
                        }
                    };
                    if (ale) {
                        i = 100;
                    } else {
                        i = 0;
                    }
                    ad.g(anonymousClass1, (long) i);
                }
            });
            iU(true);
        }

        protected final void bDO() {
            super.bDO();
            this.ima = new OnCreateContextMenuListener(this) {
                final /* synthetic */ a ojS;

                {
                    this.ojS = r1;
                }

                public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                    v.d("MicroMsg.AppBrandServiceChattingUI", "menuListener onCreateCotextMenuListener");
                    dl dlVar = (dl) view.getTag();
                    if (dlVar != null) {
                        int i = dlVar.position;
                        at atVar = (at) this.ojS.onh.getItem(i);
                        if (atVar == null) {
                            v.e("MicroMsg.AppBrandServiceChattingUI", "msg is null!");
                            return;
                        }
                        if (atVar.bwm()) {
                            contextMenu.add(i, MMGIFException.D_GIF_ERR_READ_FAILED, 0, this.ojS.vN(2131231773));
                        }
                        contextMenu.add(i, 100, 0, view.getContext().getString(2131231829));
                    }
                }
            };
            this.onh.oqh = new cq(this, this, bEn()) {
                final /* synthetic */ a ojS;

                public final void onClick(View view) {
                    v.d("MicroMsg.AppBrandServiceChattingUI", "clickListener ChattingListClickListener onClick");
                    dl dlVar = (dl) view.getTag();
                    bx bxVar = dlVar.bmk;
                    if (bxVar != null) {
                        if (bxVar.bwj()) {
                            super.onClick(view);
                        } else if (dlVar.eKg == 5 && bxVar.field_isSend == 1) {
                            super.onClick(view);
                        }
                    }
                }
            };
            this.onh.oqj = new cs(this, this.onh.ima, this) {
                final /* synthetic */ a ojS;

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final boolean onLongClick(android.view.View r5) {
                    /*
                    r4 = this;
                    r3 = 1;
                    r0 = "MicroMsg.AppBrandServiceChattingUI";
                    r1 = "longClickListener ChattingListClickListener onLongClick";
                    com.tencent.mm.sdk.platformtools.v.d(r0, r1);
                    r0 = r5.getTag();
                    r0 = r0 instanceof com.tencent.mm.ui.chatting.dl;
                    if (r0 == 0) goto L_0x0023;
                L_0x0012:
                    r0 = r5.getTag();
                    r0 = (com.tencent.mm.ui.chatting.dl) r0;
                    r1 = r0.eKg;
                    if (r1 != r3) goto L_0x001d;
                L_0x001c:
                    return r3;
                L_0x001d:
                    r0 = r0.eKg;
                    r1 = 9;
                    if (r0 == r1) goto L_0x001c;
                L_0x0023:
                    r0 = r4.ojS;
                    r0 = r0.eyZ;
                    if (r0 != 0) goto L_0x003b;
                L_0x002b:
                    r0 = r4.ojS;
                    r1 = new com.tencent.mm.ui.tools.l;
                    r2 = r4.ojS;
                    r2 = r2.nDR;
                    r2 = r2.nEl;
                    r1.<init>(r2);
                    r0.eyZ = r1;
                L_0x003b:
                    r0 = r4.ojS;
                    r0 = r0.eyZ;
                    r1 = r4.ojS;
                    r1 = r1.ima;
                    r2 = r4.ojS;
                    r2 = r2.hkn;
                    r0.b(r5, r1, r2);
                    goto L_0x001c;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a.5.onLongClick(android.view.View):boolean");
                }
            };
            this.onh.oql = new a(this);
        }

        public final void openContextMenu(View view) {
            if (this.eyZ == null) {
                this.eyZ = new l(this.nDR.nEl);
            }
            this.eyZ.b(view, this.ima, this.hkn);
        }

        protected final boolean bDP() {
            b rgVar;
            if (this.fromScene == 2) {
                ak.yW();
                ab Mh = com.tencent.mm.model.c.wK().Mh("appbrandcustomerservicemsg");
                if (Mh == null || be.kS(Mh.field_username)) {
                    v.e("MicroMsg.AppBrandServiceChattingUI", "update Unread: can not find SPUSER_APP_BRAND_SERVICE cvs");
                } else {
                    int i = Mh.field_unReadCount;
                    b lVar = new com.tencent.mm.e.a.l();
                    lVar.aWF.aWH = this.bhV.field_username;
                    com.tencent.mm.sdk.c.a.nhr.z(lVar);
                    v.i("MicroMsg.AppBrandServiceChattingUI", "parUnReadCount:%d, unReadCount:%d", Integer.valueOf(i), Integer.valueOf(lVar.aWG.aWI));
                    Mh.df(Math.max(0, i - r2));
                    ak.yW();
                    if (com.tencent.mm.model.c.wK().a(Mh, Mh.field_username, true) == -1) {
                        v.e("MicroMsg.AppBrandServiceChattingUI", "update SPUSER_APP_BRAND_SERVICE cvs unread failed");
                    } else {
                        rgVar = new rg();
                        rgVar.dRK.aWH = this.bhV.field_username;
                        rgVar.dRK.aWI = 0;
                        com.tencent.mm.sdk.c.a.nhr.z(rgVar);
                    }
                }
            } else {
                v.i("MicroMsg.AppBrandServiceChattingUI", "writeOpLogAndMarkRead clear AppBrandKvData username:%s", this.bhV.field_username);
                rgVar = new rg();
                rgVar.dRK.aWH = this.bhV.field_username;
                rgVar.dRK.aWI = 0;
                com.tencent.mm.sdk.c.a.nhr.z(rgVar);
            }
            return super.bDP();
        }

        public final void onDestroy() {
            super.onDestroy();
            com.tencent.mm.sdk.c.a.nhr.f(this.ojR);
        }
    }

    protected void onCreate(Bundle bundle) {
        getWindow().setFormat(-2);
        com.tencent.mm.pluginsdk.e.N(this);
        overridePendingTransition(0, 0);
        super.onCreate(null);
        if (getIntent().getStringExtra("Chat_User") == null) {
            finish();
            v.e("MicroMsg.AppBrandServiceChattingUI", "talker is null !!!");
            return;
        }
        setContentView(2130903374);
        this.ojM = new a((byte) 0);
        Bundle extras = getIntent().getExtras();
        extras.putBoolean("FROM_APP_BRAND_CHATTING_ACTIVITY", true);
        this.ojM.setArguments(extras);
        aS().aW().a(2131755641, this.ojM).commit();
        cU().cV().show();
        if (getIntent().getBooleanExtra("resend_fail_messages", false)) {
            ad.g(new Runnable(this) {
                final /* synthetic */ AppBrandServiceChattingUI ojO;

                {
                    this.ojO = r1;
                }

                public final void run() {
                    com.tencent.mm.ui.base.g.b(this.ojO, this.ojO.getString(2131234092), SQLiteDatabase.KeyEmpty, this.ojO.getString(2131234093), this.ojO.getString(2131231010), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass1 ojP;

                        {
                            this.ojP = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.sdk.c.a.nhr.z(new ln());
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass1 ojP;

                        {
                            this.ojP = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.sdk.c.a.nhr.z(new jc());
                        }
                    });
                }
            }, 500);
            getIntent().putExtra("is_need_resend_sns", false);
        }
        com.tencent.mm.permission.a.MQ().MR();
        this.ojN.post(new Runnable(this) {
            final /* synthetic */ AppBrandServiceChattingUI ojO;

            {
                this.ojO = r1;
            }

            public final void run() {
                if (this.ojO.ojM != null) {
                    com.tencent.mm.pluginsdk.e.a(this.ojO, this.ojO.ojM.nDR.nDX);
                }
            }
        });
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        v.d("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingUI dispatch key event %s", keyEvent);
        if (this.ojM == null || !this.ojM.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }
}
