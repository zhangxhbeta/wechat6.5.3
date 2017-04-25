package com.tencent.mm.plugin.wenote.ui.webview;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.as.u;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.wenote.c.a;
import com.tencent.mm.plugin.wenote.c.n;
import com.tencent.mm.plugin.wenote.ui.WNNoteFavVoiceBaseView;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.k.b;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.f;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONObject;

public class WNNoteFavWebViewUI extends WNNoteWebViewBaseUI implements a {
    private long cLu = -1;
    private ImageButton fQv;
    private int luY = 1;
    private ImageButton luZ;
    private ImageButton lva;
    private ImageButton lvb;
    private LinearLayout lvc;
    private ImageView lvd;
    private TextView lve;
    private WNNoteFavVoiceBaseView lvf;
    private int lvg;
    private boolean lvh = false;
    private String lvi = null;
    private int lvj = -1;
    private boolean lvk = false;
    ac lvl = new ac(this) {
        final /* synthetic */ WNNoteFavWebViewUI lvm;

        {
            this.lvm = r1;
        }

        public final void handleMessage(Message message) {
            this.lvm.lkl.bli();
            sendEmptyMessageDelayed(4112, 250);
        }
    };

    static /* synthetic */ WNNoteFavWebViewUI o(WNNoteFavWebViewUI wNNoteFavWebViewUI) {
        return wNNoteFavWebViewUI;
    }

    protected final MMWebView bkd() {
        return MMWebView.a.eQ(this);
    }

    protected final void aqj() {
        super.aqj();
    }

    protected final void NI() {
        this.cLu = getIntent().getLongExtra("key_detail_info_id", -1);
        this.lvy = getIntent().getBooleanExtra("edit_status", false);
        this.lvg = 1;
        super.NI();
        if (this.lvy) {
            Fd(getString(2131232755));
            a(new OnMenuItemClickListener(this) {
                final /* synthetic */ WNNoteFavWebViewUI lvm;

                {
                    this.lvm = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.lvm.goBack();
                    return true;
                }
            }, 2130837595);
            a(1, getString(2131232962), new OnMenuItemClickListener(this) {
                final /* synthetic */ WNNoteFavWebViewUI lvm;

                {
                    this.lvm = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.lvm.bmj();
                    this.lvm.bmg();
                    this.lvm.finish();
                    return true;
                }
            }, b.nET);
            U(1, false);
        } else {
            Fd(getString(2131232756));
            iV(true);
            a(new OnMenuItemClickListener(this) {
                final /* synthetic */ WNNoteFavWebViewUI lvm;

                {
                    this.lvm = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.lvm.finish();
                    return true;
                }
            }, 2130837595);
            a(1, 2131235683, 2130838681, new OnMenuItemClickListener(this) {
                final /* synthetic */ WNNoteFavWebViewUI lvm;

                {
                    this.lvm = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    f fVar = new f(this.lvm.nDR.nEl, f.pbS, false);
                    fVar.jXn = new c(this) {
                        final /* synthetic */ AnonymousClass12 lvq;

                        {
                            this.lvq = r1;
                        }

                        public final void a(l lVar) {
                            if (this.lvq.lvm.getIntent().getBooleanExtra("key_detail_can_share_to_friend", true)) {
                                lVar.d(0, this.lvq.lvm.getString(2131232731));
                            }
                            lVar.d(1, this.lvq.lvm.getString(2131232647));
                            lVar.d(2, this.lvq.lvm.nDR.nEl.getString(2131231020));
                        }
                    };
                    fVar.jXo = new d(this) {
                        final /* synthetic */ AnonymousClass12 lvq;

                        {
                            this.lvq = r1;
                        }

                        public final void c(MenuItem menuItem, int i) {
                            Intent intent;
                            switch (menuItem.getItemId()) {
                                case 0:
                                    intent = new Intent();
                                    intent.putExtra("Select_Conv_Type", 3);
                                    intent.putExtra("scene_from", 1);
                                    intent.putExtra("mutil_select_is_ret", true);
                                    intent.putExtra("select_fav_local_id", this.lvq.lvm.cLu);
                                    com.tencent.mm.ay.c.a(this.lvq.lvm, ".ui.transmit.SelectConversationUI", intent, 4096);
                                    return;
                                case 1:
                                    intent = new Intent();
                                    intent.putExtra("key_fav_scene", 2);
                                    intent.putExtra("key_fav_item_id", this.lvq.lvm.cLu);
                                    com.tencent.mm.ay.c.b(this.lvq.lvm.nDR.nEl, "favorite", ".ui.FavTagEditUI", intent);
                                    return;
                                case 2:
                                    g.a(this.lvq.lvm.nDR.nEl, this.lvq.lvm.getString(2131231021), "", new OnClickListener(this) {
                                        final /* synthetic */ AnonymousClass2 lvr;

                                        {
                                            this.lvr = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            this.lvr.lvq.lvm.lvu = g.a(this.lvr.lvq.lvm.nDR.nEl, this.lvr.lvq.lvm.getString(2131231021), false, null);
                                            try {
                                                if (this.lvr.lvq.lvm.liH != null) {
                                                    Bundle bundle = new Bundle();
                                                    bundle.putLong("localId", this.lvr.lvq.lvm.cLu);
                                                    this.lvr.lvq.lvm.liH.i(60, bundle);
                                                }
                                            } catch (RemoteException e) {
                                            }
                                        }
                                    }, null);
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                    fVar.bKh();
                    return false;
                }
            });
        }
        this.lvf = (WNNoteFavVoiceBaseView) findViewById(2131757008);
        this.fQv = (ImageButton) findViewById(2131757009);
        this.luZ = (ImageButton) findViewById(2131760107);
        this.luZ.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WNNoteFavWebViewUI lvm;

            {
                this.lvm = r1;
            }

            public final void onClick(View view) {
                if (this.lvm.lvv.getVisibility() != 0) {
                    if (this.lvm.lvj == -3) {
                        this.lvm.lvk = true;
                        this.lvm.axg();
                    }
                    Intent intent = new Intent();
                    intent.putExtra("max_select_count", 9);
                    intent.putExtra("query_source_type", 4);
                    intent.putExtra("send_btn_string", this.lvm.getString(2131232638));
                    intent.addFlags(67108864);
                    com.tencent.mm.ay.c.b(this.lvm, "gallery", ".ui.GalleryEntryUI", intent, 4097);
                }
            }
        });
        this.lva = (ImageButton) findViewById(2131760108);
        this.lva.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WNNoteFavWebViewUI lvm;

            {
                this.lvm = r1;
            }

            public final void onClick(View view) {
                if (this.lvm.lvv.getVisibility() != 0) {
                    if (this.lvm.lvj == -3) {
                        this.lvm.lvk = true;
                        this.lvm.axg();
                    }
                    v.i("MicroMsg.WNNoteFavWebViewUI", "summerper checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.lvm, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null))});
                    if (com.tencent.mm.pluginsdk.i.a.a(this.lvm, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                        Intent intent = new Intent();
                        intent.putExtra("MMActivity.OverrideExitAnimation", 2130968644);
                        intent.putExtra("MMActivity.OverrideEnterAnimation", 2130968622);
                        intent.putExtra("map_view_type", 3);
                        com.tencent.mm.ay.c.b(this.lvm, "location", ".ui.RedirectUI", intent, 4098);
                    }
                }
            }
        });
        this.lvb = (ImageButton) findViewById(2131760109);
        this.lvb.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WNNoteFavWebViewUI lvm;

            {
                this.lvm = r1;
            }

            public final void onClick(View view) {
                if (this.lvm.lvv.getVisibility() != 0) {
                    if (this.lvm.lvj == -3) {
                        this.lvm.lvk = true;
                        this.lvm.axg();
                    }
                    if (com.tencent.mm.compatible.util.f.sj()) {
                        Intent intent = new Intent(this.lvm, FileExplorerUI.class);
                        intent.putExtra("key_title", this.lvm.getString(2131232702));
                        this.lvm.startActivityForResult(intent, 4099);
                        return;
                    }
                    s.ey(this.lvm.nDR.nEl);
                }
            }
        });
        this.lvd = (ImageView) findViewById(2131760110);
        this.lvd.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WNNoteFavWebViewUI lvm;

            {
                this.lvm = r1;
            }

            public final void onClick(View view) {
                if (this.lvm.lvv.getVisibility() != 0) {
                    v.i("MicroMsg.WNNoteFavWebViewUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.lvm, "android.permission.RECORD_AUDIO", 80, null, null)), be.bur()});
                    if (!com.tencent.mm.pluginsdk.i.a.a(this.lvm, "android.permission.RECORD_AUDIO", 80, null, null)) {
                        return;
                    }
                    if (this.lvm.lkl == null) {
                        v.e("MicroMsg.WNNoteFavWebViewUI", "wenote_h5_footer_voice jsapi=null");
                        return;
                    }
                    if (this.lvm.lvj != -3) {
                        this.lvm.lkl.blj();
                    }
                    if (!this.lvm.lvh) {
                        if (!com.tencent.mm.compatible.util.f.sj()) {
                            s.ey(this.lvm.nDR.nEl);
                            return;
                        } else if (u.bj(this.lvm.nDR.nEl) || com.tencent.mm.ah.a.aT(this.lvm.nDR.nEl)) {
                            return;
                        }
                    }
                    if (!this.lvm.lvh) {
                        this.lvm.lvh = true;
                        this.lvm.lvc.setVisibility(0);
                        this.lvm.lvd.setVisibility(8);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(Columns.TYPE, 4);
                            jSONObject.put("downloaded", false);
                            jSONObject.put("placeHolder", this.lvm.getString(2131232760));
                        } catch (Throwable e) {
                            v.a("MicroMsg.WNNoteFavWebViewUI", e, "", new Object[0]);
                        }
                        this.lvm.I(jSONObject);
                        n.bmd().a(this.lvm, this.lvm.lvg - 1, this.lvm.lve, WNNoteFavWebViewUI.o(this.lvm));
                        this.lvm.lkl.bli();
                    }
                }
            }
        });
        this.lvc = (LinearLayout) findViewById(2131760111);
        this.lve = (TextView) findViewById(2131760112);
        this.lvc.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WNNoteFavWebViewUI lvm;

            {
                this.lvm = r1;
            }

            public final void onClick(View view) {
                if (this.lvm.lvv.getVisibility() != 0) {
                    this.lvm.bmj();
                }
            }
        });
        getWindow().setSoftInputMode(16);
    }

    protected final void a(WebViewKeyboardLinearLayout webViewKeyboardLinearLayout, int i) {
        super.a(webViewKeyboardLinearLayout, i);
        v.i("MicroMsg.WNNoteFavWebViewUI", "onKeyBoardStateChange, state = " + i);
        this.lvj = i;
        if (i != -2) {
            return;
        }
        if (this.lvk || this.lvA) {
            this.lvA = false;
        } else if (this.lkl != null) {
            this.lkl.blj();
        }
    }

    public void finish() {
        super.finish();
    }

    public void onBackPressed() {
        if (this.lvy) {
            goBack();
        } else {
            super.onBackPressed();
        }
    }

    public void onStart() {
        if (!this.lvy && this.lvx) {
            this.lvx = false;
            this.lvv.setVisibility(0);
        }
        super.onStart();
    }

    protected final void n(int i, Bundle bundle) {
        super.n(i, bundle);
        String string;
        switch (i) {
            case p.CTRL_INDEX /*28*/:
                bundle.getString("fts_key_json_data");
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ WNNoteFavWebViewUI lvm;

                    {
                        this.lvm = r1;
                    }

                    public final void run() {
                        if (this.lvm.lkl != null) {
                            this.lvm.lkl.hG(true);
                        }
                    }
                });
                return;
            case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                final JSONObject jSONObject = new JSONObject();
                try {
                    boolean z = bundle.getBoolean("downloaded");
                    jSONObject.put("localEditorId", bundle.getString("localEditorId"));
                    jSONObject.put("downloaded", bundle.getString("downloaded"));
                    if (z) {
                        jSONObject.put("length", bundle.getInt("length"));
                        jSONObject.put("lengthStr", bundle.getString("lengthStr"));
                        jSONObject.put("iconPath", bundle.getString("iconPath"));
                        jSONObject.put("localPath", bundle.getString("localPath"));
                    } else {
                        jSONObject.put("placeHolder", bundle.getString("placeHolder"));
                    }
                } catch (Throwable e) {
                    v.a("MicroMsg.WNNoteFavWebViewUI", e, "", new Object[0]);
                }
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ WNNoteFavWebViewUI lvm;

                    public final void run() {
                        if (this.lvm.lkl != null) {
                            this.lvm.lkl.G(jSONObject);
                        }
                    }
                });
                return;
            case 41:
                this.lkl.hH(true);
                return;
            case 42:
                if (bundle.getBoolean("showVKB", false)) {
                    aJs();
                    return;
                }
                string = bundle.getString("maxhtmlid");
                if (be.kS(string)) {
                    v.e("MicroMsg.WNNoteFavWebViewUI", "maxhtmlid is null");
                    return;
                } else if (7 < string.length()) {
                    string = string.substring(7, string.length());
                    if (string.matches("[0-9]+")) {
                        this.luY = be.getInt(string, 0);
                        this.luY++;
                        return;
                    }
                    return;
                } else {
                    return;
                }
            case 43:
                if (!this.lvy) {
                    bmi();
                    return;
                }
                return;
            case JsApiGetMusicPlayerState.CTRL_INDEX /*46*/:
                int i2 = bundle.getInt("operation_type");
                bundle.getInt("event.data.type");
                switch (i2) {
                    case 1:
                    case 2:
                        return;
                    case 3:
                        try {
                            I(new JSONObject(bundle.getString("jsonobjstr")));
                            return;
                        } catch (Throwable e2) {
                            v.a("MicroMsg.WNNoteFavWebViewUI", e2, "", new Object[0]);
                            return;
                        }
                    case 4:
                        string = bundle.getString("jsonobjstr");
                        try {
                            a(new JSONObject(string), bundle.getInt("updateEditorId"));
                            return;
                        } catch (Throwable e22) {
                            v.a("MicroMsg.WNNoteFavWebViewUI", e22, "", new Object[0]);
                            return;
                        }
                    case 5:
                        string = bundle.getString("htmlStr", "");
                        if (this.lvy) {
                            this.lvi = string;
                            this.handler.post(new Runnable(this) {
                                final /* synthetic */ WNNoteFavWebViewUI lvm;

                                {
                                    this.lvm = r1;
                                }

                                public final void run() {
                                    if (be.kS(this.lvm.lvi)) {
                                        v.w("MicroMsg.WNNoteFavWebViewUI", "input is empty!!");
                                        this.lvm.U(1, false);
                                        return;
                                    }
                                    this.lvm.U(1, true);
                                }
                            });
                            return;
                        }
                        return;
                    case 6:
                        this.lkl.bli();
                        if (this.lvk) {
                            this.lkl.hH(true);
                            aJs();
                            this.lvk = false;
                            return;
                        }
                        this.lkl.blj();
                        return;
                    case 7:
                        this.lkl.bli();
                        return;
                    default:
                        return;
                }
            default:
                return;
        }
    }

    protected void onDestroy() {
        this.lvl.removeMessages(4112);
        n.bmd().bme();
        super.onDestroy();
    }

    public final void bmg() {
        this.lvl.removeMessages(4112);
        this.handler.post(new Runnable(this) {
            final /* synthetic */ WNNoteFavWebViewUI lvm;

            {
                this.lvm = r1;
            }

            public final void run() {
                if (this.lvm.lkl != null) {
                    this.lvm.lkl.hG(true);
                }
            }
        });
    }

    public final void bmh() {
        this.lvl.removeMessages(4112);
        this.handler.post(new Runnable(this) {
            final /* synthetic */ WNNoteFavWebViewUI lvm;

            {
                this.lvm = r1;
            }

            public final void run() {
                if (this.lvm.lkl != null) {
                    this.lvm.lkl.hG(false);
                }
            }
        });
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onActivityResult(int r11, int r12, android.content.Intent r13) {
        /*
        r10 = this;
        r2 = 2;
        r8 = 0;
        r1 = 0;
        r4 = 1;
        r3 = 0;
        super.onActivityResult(r11, r12, r13);
        r0 = "MicroMsg.WNNoteFavWebViewUI";
        r5 = "onActivityResult reqCode: %d, retCod: %d";
        r6 = new java.lang.Object[r2];
        r7 = java.lang.Integer.valueOf(r11);
        r6[r3] = r7;
        r7 = java.lang.Integer.valueOf(r12);
        r6[r4] = r7;
        com.tencent.mm.sdk.platformtools.v.i(r0, r5, r6);
        r0 = -1;
        if (r12 == r0) goto L_0x002d;
    L_0x0023:
        r0 = r10.lvk;
        if (r0 == 0) goto L_0x002c;
    L_0x0027:
        r10.aJs();
        r10.lvk = r3;
    L_0x002c:
        return;
    L_0x002d:
        switch(r11) {
            case 4096: goto L_0x0044;
            case 4097: goto L_0x00e4;
            case 4098: goto L_0x0113;
            case 4099: goto L_0x0175;
            case 4100: goto L_0x00a8;
            default: goto L_0x0030;
        };
    L_0x0030:
        r0 = r2;
    L_0x0031:
        if (r0 == 0) goto L_0x002c;
    L_0x0033:
        if (r4 != r0) goto L_0x01c8;
    L_0x0035:
        r0 = r10.nDR;
        r0 = r0.nEl;
        r1 = 2131232652; // 0x7f08078c float:1.808142E38 double:1.0529688366E-314;
        r1 = r10.getString(r1);
        com.tencent.mm.ui.base.g.bf(r0, r1);
        goto L_0x002c;
    L_0x0044:
        if (r13 != 0) goto L_0x005a;
    L_0x0046:
        r5 = r1;
    L_0x0047:
        if (r13 != 0) goto L_0x0063;
    L_0x0049:
        r0 = r1;
    L_0x004a:
        r6 = com.tencent.mm.sdk.platformtools.be.kS(r5);
        if (r6 == 0) goto L_0x006b;
    L_0x0050:
        r0 = "MicroMsg.WNNoteFavWebViewUI";
        r1 = "want to send record msg, but toUser is null";
        com.tencent.mm.sdk.platformtools.v.w(r0, r1);
        goto L_0x002c;
    L_0x005a:
        r0 = "Select_Conv_User";
        r0 = r13.getStringExtra(r0);
        r5 = r0;
        goto L_0x0047;
    L_0x0063:
        r0 = "custom_send_text";
        r0 = r13.getStringExtra(r0);
        goto L_0x004a;
    L_0x006b:
        r6 = r10.nDR;
        r6 = r6.nEl;
        r7 = 2131232670; // 0x7f08079e float:1.8081456E38 double:1.0529688455E-314;
        r7 = r10.getString(r7);
        r1 = com.tencent.mm.ui.base.g.a(r6, r7, r3, r1);
        r10.lvu = r1;
        r1 = r10.liH;
        if (r1 == 0) goto L_0x0030;
    L_0x0080:
        r1 = new android.os.Bundle;
        r1.<init>();
        r6 = "username";
        r1.putString(r6, r5);
        r5 = "customText";
        r1.putString(r5, r0);
        r0 = r10.liH;	 Catch:{ RemoteException -> 0x009a }
        r5 = 62;
        r0.i(r5, r1);	 Catch:{ RemoteException -> 0x009a }
        r0 = r2;
        goto L_0x0031;
    L_0x009a:
        r0 = move-exception;
        r1 = "MicroMsg.WNNoteFavWebViewUI";
        r5 = "";
        r3 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.v.a(r1, r0, r5, r3);
        r0 = r2;
        goto L_0x0031;
    L_0x00a8:
        r0 = "voicepath";
        r0 = r13.getStringExtra(r0);
        r1 = "voiceduration";
        r1 = r13.getIntExtra(r1, r3);
        r2 = r10.liH;
        if (r2 == 0) goto L_0x00e1;
    L_0x00ba:
        r2 = new android.os.Bundle;
        r2.<init>();
        r5 = "voicepath";
        r2.putString(r5, r0);
        r0 = "duration";
        r2.putInt(r0, r1);
        r0 = r10.liH;	 Catch:{ RemoteException -> 0x00d5 }
        r1 = 64;
        r0.i(r1, r2);	 Catch:{ RemoteException -> 0x00d5 }
        r0 = r3;
        goto L_0x0031;
    L_0x00d5:
        r0 = move-exception;
        r1 = "MicroMsg.WNNoteFavWebViewUI";
        r2 = "";
        r5 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r5);
    L_0x00e1:
        r0 = r3;
        goto L_0x0031;
    L_0x00e4:
        r0 = "CropImage_OutputPath_List";
        r0 = r13.getStringArrayListExtra(r0);
        if (r0 == 0) goto L_0x00f3;
    L_0x00ed:
        r1 = r0.size();
        if (r1 != 0) goto L_0x00fe;
    L_0x00f3:
        r0 = "MicroMsg.WNNoteFavWebViewUI";
        r1 = "onActivityResult pathList is null or nil";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        goto L_0x002c;
    L_0x00fe:
        r1 = r0.size();
        if (r1 <= r4) goto L_0x0106;
    L_0x0104:
        r10.lvk = r3;
    L_0x0106:
        r1 = r10.handler;
        r2 = new com.tencent.mm.plugin.wenote.ui.webview.WNNoteFavWebViewUI$6;
        r2.<init>(r10, r0);
        r1.post(r2);
        r0 = r3;
        goto L_0x0031;
    L_0x0113:
        r0 = O(r13);
        r1 = new android.os.Bundle;
        r1.<init>();
        r2 = "latitude";
        r5 = "kwebmap_slat";
        r6 = r13.getDoubleExtra(r5, r8);
        r5 = (float) r6;
        r6 = (double) r5;
        r1.putDouble(r2, r6);
        r2 = "longtitude";
        r5 = "kwebmap_lng";
        r6 = r13.getDoubleExtra(r5, r8);
        r5 = (float) r6;
        r6 = (double) r5;
        r1.putDouble(r2, r6);
        r2 = "scale";
        r5 = "kwebmap_scale";
        r5 = r13.getIntExtra(r5, r3);
        r1.putInt(r2, r5);
        r2 = "loclabel";
        r5 = "Kwebmap_locaion";
        r5 = r13.getStringExtra(r5);
        r6 = "";
        r5 = com.tencent.mm.sdk.platformtools.be.ah(r5, r6);
        r1.putString(r2, r5);
        r2 = "locpoiname";
        r5 = "kPoiName";
        r5 = r13.getStringExtra(r5);
        r1.putString(r2, r5);
        r2 = r10.handler;
        r5 = new com.tencent.mm.plugin.wenote.ui.webview.WNNoteFavWebViewUI$7;
        r5.<init>(r10, r1, r0);
        r2.post(r5);
        r0 = r3;
        goto L_0x0031;
    L_0x0175:
        r0 = "choosed_file_path";
        r0 = r13.getStringExtra(r0);
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r1 == 0) goto L_0x0185;
    L_0x0182:
        r0 = r4;
        goto L_0x0031;
    L_0x0185:
        r1 = new java.io.File;
        r1.<init>(r0);
        r5 = r1.exists();
        if (r5 != 0) goto L_0x0193;
    L_0x0190:
        r0 = r4;
        goto L_0x0031;
    L_0x0193:
        r6 = r1.length();
        r8 = 26214400; // 0x1900000 float:5.2897246E-38 double:1.29516345E-316;
        r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r1 < 0) goto L_0x01a1;
    L_0x019e:
        r0 = 3;
        goto L_0x0031;
    L_0x01a1:
        r1 = r10.liH;
        if (r1 == 0) goto L_0x0030;
    L_0x01a5:
        r1 = new android.os.Bundle;
        r1.<init>();
        r5 = "path";
        r1.putString(r5, r0);
        r0 = r10.liH;	 Catch:{ RemoteException -> 0x01ba }
        r5 = 67;
        r0.i(r5, r1);	 Catch:{ RemoteException -> 0x01ba }
        r0 = r2;
        goto L_0x0031;
    L_0x01ba:
        r0 = move-exception;
        r1 = "MicroMsg.WNNoteFavWebViewUI";
        r5 = "";
        r3 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.v.a(r1, r0, r5, r3);
        goto L_0x0030;
    L_0x01c8:
        r1 = 3;
        if (r1 != r0) goto L_0x002c;
    L_0x01cb:
        r0 = r10.nDR;
        r0 = r0.nEl;
        r1 = 2131232747; // 0x7f0807eb float:1.8081612E38 double:1.0529688836E-314;
        r1 = r10.getString(r1);
        r0 = android.widget.Toast.makeText(r0, r1, r4);
        r0.show();
        goto L_0x002c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.ui.webview.WNNoteFavWebViewUI.onActivityResult(int, int, android.content.Intent):void");
    }

    private void d(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("localEditorId", str);
        } catch (Throwable e) {
            v.a("MicroMsg.WNNoteFavWebViewUI", e, "", new Object[0]);
        }
        this.lkl.G(jSONObject);
        final String jSONObject2 = jSONObject.toString();
        this.handler.post(new Runnable(this) {
            final /* synthetic */ WNNoteFavWebViewUI lvm;

            public final void run() {
                if (this.lvm.liH != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("insertJsonString", jSONObject2);
                    try {
                        this.lvm.liH.i(53, bundle);
                    } catch (Throwable e) {
                        v.a("MicroMsg.WNNoteFavWebViewUI", e, "", new Object[0]);
                    }
                }
            }
        });
    }

    private void a(JSONObject jSONObject, int i) {
        d(jSONObject, "WeNote_" + Integer.toString(i));
    }

    private void I(JSONObject jSONObject) {
        if (!this.lvy) {
            bmi();
        }
        StringBuilder stringBuilder = new StringBuilder("WeNote_");
        int i = this.lvg;
        this.lvg = i + 1;
        d(jSONObject, stringBuilder.append(Integer.toString(i)).toString());
    }

    private void bmi() {
        if (!this.lvy) {
            this.lvy = true;
        }
        if (this.luY > 1) {
            this.lvg = this.luY;
        }
        this.lvz = true;
        Fd(getString(2131232755));
        a(new OnMenuItemClickListener(this) {
            final /* synthetic */ WNNoteFavWebViewUI lvm;

            {
                this.lvm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lvm.goBack();
                return true;
            }
        }, 2130837595);
        a(1, getString(2131232962), new OnMenuItemClickListener(this) {
            final /* synthetic */ WNNoteFavWebViewUI lvm;

            {
                this.lvm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lvm.bmj();
                this.lvm.bmh();
                this.lvm.finish();
                return true;
            }
        }, b.nET);
        U(1, false);
        this.igd.setOnLongClickListener(this.llD);
    }

    public final void bmj() {
        if (this.lvh) {
            this.lvh = false;
            this.lvc.setVisibility(8);
            this.lvd.setVisibility(0);
            n.bmd().bme();
            n bmd = n.bmd();
            String str = e.aR(bmd.path) ? bmd.path : "";
            JSONObject jSONObject = new JSONObject();
            if (!be.kS(str)) {
                int i = (int) n.bmd().dfS;
                int au = (int) com.tencent.mm.au.a.au((long) i);
                try {
                    jSONObject.put("downloaded", true);
                    jSONObject.put("length", i);
                    jSONObject.put("lengthStr", com.tencent.mm.au.a.s(this.nDR.nEl, au).toString());
                    jSONObject.put("iconPath", com.tencent.mm.bj.a.bLM() + "/fav_fileicon_recording.png");
                    jSONObject.put("localPath", str);
                } catch (Throwable e) {
                    v.a("MicroMsg.WNNoteFavWebViewUI", e, "", new Object[0]);
                }
            }
            try {
                jSONObject.put(Columns.TYPE, 4);
            } catch (Throwable e2) {
                v.a("MicroMsg.WNNoteFavWebViewUI", e2, "", new Object[0]);
            }
            a(jSONObject, n.bmd().luB);
            this.lkl.bli();
        }
    }

    private void goBack() {
        axg();
        if (be.kS(this.lvi)) {
            finish();
        } else {
            g.b(this.nDR.nEl, getString(2131234726), "", getString(2131231559), getString(2131231560), new OnClickListener(this) {
                final /* synthetic */ WNNoteFavWebViewUI lvm;

                {
                    this.lvm = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.lvm.bmj();
                    WNNoteFavWebViewUI wNNoteFavWebViewUI = this.lvm;
                    if (wNNoteFavWebViewUI.lvz) {
                        wNNoteFavWebViewUI.bmh();
                    } else {
                        wNNoteFavWebViewUI.bmg();
                    }
                    this.lvm.finish();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ WNNoteFavWebViewUI lvm;

                {
                    this.lvm = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.lvm.setResult(0);
                    this.lvm.finish();
                }
            });
        }
    }

    private static String O(Intent intent) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Columns.TYPE, 3);
            jSONObject.put("downloaded", true);
            jSONObject.put("poiName", intent.getStringExtra("kPoiName"));
            jSONObject.put("address", be.ah(intent.getStringExtra("Kwebmap_locaion"), ""));
            jSONObject.put("lat", (double) ((float) intent.getDoubleExtra("kwebmap_slat", 0.0d)));
            jSONObject.put("lng", (double) ((float) intent.getDoubleExtra("kwebmap_lng", 0.0d)));
            jSONObject.put("scale", intent.getIntExtra("kwebmap_scale", 0));
        } catch (Throwable e) {
            v.a("MicroMsg.WNNoteFavWebViewUI", e, "", new Object[0]);
        }
        return jSONObject.toString();
    }

    public final void blZ() {
        bmj();
    }

    public final void Fd(String str) {
        if (this.lvy) {
            super.Fd(getString(2131232755));
        } else {
            super.Fd(getString(2131232756));
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.WNNoteFavWebViewUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 80:
                if (iArr[0] != 0) {
                    g.a(this, getString(2131234163), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                        final /* synthetic */ WNNoteFavWebViewUI lvm;

                        {
                            this.lvm = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.lvm.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ WNNoteFavWebViewUI lvm;

                        {
                            this.lvm = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }
}
