package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.e.a.bz;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.emoji.e.h;
import com.tencent.mm.plugin.emoji.e.i;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.protocal.c.nu;
import com.tencent.mm.protocal.c.nv;
import com.tencent.mm.protocal.c.vj;
import com.tencent.mm.protocal.c.vl;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.contact.LabelContainerView;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.widget.f;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class EmojiStoreV2SingleProductUI extends MMActivity implements OnScrollListener, e {
    private View PH;
    private String bZy;
    private int cVh;
    private ProgressDialog eZg;
    private long fdd;
    private String fee;
    private String feg;
    private int fnA = 0;
    private MMPullDownView fnY;
    private boolean foB = false;
    private i foa;
    private String fpA;
    private String fpB;
    private String fpC;
    private String fpD;
    private String fpE;
    private int fpF = 0;
    private PreViewListGridView fpG;
    private d fpH;
    private View fpI;
    private TextView fpJ;
    private View fpK;
    private boolean fpL = true;
    private vj fpM;
    private byte[] fpN;
    private int fpO = -1;
    private String fpP;
    private LabelContainerView fpQ;
    private TextView fpR;
    private MMTagPanel fpS;
    private HashMap<String, Integer> fpT = new HashMap();
    private ArrayList<String> fpU;
    private boolean fpV = false;
    private c fpW = new c<bz>(this) {
        final /* synthetic */ EmojiStoreV2SingleProductUI fpZ;

        {
            this.fpZ = r2;
            this.nhz = bz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (!(this.fpZ.fpH == null || this.fpZ.mHandler == null)) {
                this.fpZ.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass6 fqa;

                    {
                        this.fqa = r1;
                    }

                    public final void run() {
                        this.fqa.fpZ.fpH.notifyDataSetInvalidated();
                    }
                });
            }
            return false;
        }
    };
    private MMPullDownView.e fpX = new MMPullDownView.e(this) {
        final /* synthetic */ EmojiStoreV2SingleProductUI fpZ;

        {
            this.fpZ = r1;
        }

        public final boolean agi() {
            v.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "onBottom");
            this.fpZ.cF(true);
            return true;
        }
    };
    private MMPullDownView.c fpY = new MMPullDownView.c(this) {
        final /* synthetic */ EmojiStoreV2SingleProductUI fpZ;

        {
            this.fpZ = r1;
        }

        public final boolean agv() {
            return false;
        }
    };
    private int fpx;
    private String fpy;
    private int fpz = -1;
    private ac mHandler = new ac(this) {
        final /* synthetic */ EmojiStoreV2SingleProductUI fpZ;

        {
            this.fpZ = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    if (this.fpZ.fpK != null) {
                        this.fpZ.fpK.setVisibility(8);
                        return;
                    }
                    return;
                case 1002:
                    if (this.fpZ.fpK != null) {
                        this.fpZ.fpK.setVisibility(0);
                    }
                    sendEmptyMessage(1003);
                    return;
                case 1004:
                    this.fpZ.NH();
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ void a(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI, String str) {
        emojiStoreV2SingleProductUI.vD(2131232392);
        emojiStoreV2SingleProductUI.V(1001, emojiStoreV2SingleProductUI.fpL);
        if (emojiStoreV2SingleProductUI.fpT == null || !emojiStoreV2SingleProductUI.fpT.containsKey(str)) {
            emojiStoreV2SingleProductUI.fpN = null;
            emojiStoreV2SingleProductUI.fpO = -1;
            emojiStoreV2SingleProductUI.fpP = emojiStoreV2SingleProductUI.getString(2131232414);
            emojiStoreV2SingleProductUI.fpF = 1;
            emojiStoreV2SingleProductUI.fpx = 0;
            emojiStoreV2SingleProductUI.ah(emojiStoreV2SingleProductUI.fpN);
            emojiStoreV2SingleProductUI.rR("");
        } else {
            emojiStoreV2SingleProductUI.fpO = -1;
            emojiStoreV2SingleProductUI.fpP = str;
            emojiStoreV2SingleProductUI.fpF = 4;
            emojiStoreV2SingleProductUI.fpx = ((Integer) emojiStoreV2SingleProductUI.fpT.get(emojiStoreV2SingleProductUI.fpP)).intValue();
            emojiStoreV2SingleProductUI.ah(null);
            emojiStoreV2SingleProductUI.rR(str);
        }
        if (emojiStoreV2SingleProductUI.fpQ != null) {
            emojiStoreV2SingleProductUI.fpQ.setVisibility(8);
        }
    }

    static /* synthetic */ void o(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        f fVar = new f(emojiStoreV2SingleProductUI.nDR.nEl, f.pbS, false);
        fVar.jXn = new n.c(emojiStoreV2SingleProductUI) {
            final /* synthetic */ EmojiStoreV2SingleProductUI fpZ;

            {
                this.fpZ = r1;
            }

            public final void a(l lVar) {
                lVar.a(1001, this.fpZ.getString(2131236669), 2131165344);
                lVar.a(BaseReportManager.MAX_READ_COUNT, this.fpZ.getString(2131236668), 2131165334);
            }
        };
        fVar.jXo = new d(emojiStoreV2SingleProductUI) {
            final /* synthetic */ EmojiStoreV2SingleProductUI fpZ;

            {
                this.fpZ = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case BaseReportManager.MAX_READ_COUNT /*1000*/:
                        ActionBarActivity actionBarActivity = this.fpZ.nDR.nEl;
                        String r = this.fpZ.fpA;
                        String s = this.fpZ.fpC;
                        String t = this.fpZ.fpB;
                        g.aft();
                        com.tencent.mm.plugin.emoji.d.l.a(actionBarActivity, r, s, t, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0", EmojiLogic.a(this.fpZ.fpz, this.fpZ.fpA, this.fpZ.fpC, this.fpZ.fpB, this.fpZ.fpD, this.fpZ.fpF), 12);
                        com.tencent.mm.plugin.report.service.g.iuh.h(13224, new Object[]{Integer.valueOf(2), Integer.valueOf(1), "", Integer.valueOf(this.fpZ.fpz)});
                        return;
                    case 1001:
                        com.tencent.mm.plugin.emoji.d.l.bB(this.fpZ.nDR.nEl);
                        this.fpZ.nDR.nEl.overridePendingTransition(2130968646, 2130968623);
                        com.tencent.mm.plugin.report.service.g.iuh.h(13224, new Object[]{Integer.valueOf(2), Integer.valueOf(2), "", Integer.valueOf(this.fpZ.fpz)});
                        return;
                    default:
                        return;
                }
            }
        };
        fVar.bKh();
        com.tencent.mm.plugin.report.service.g.iuh.h(13224, new Object[]{Integer.valueOf(2), Integer.valueOf(0), "", Integer.valueOf(emojiStoreV2SingleProductUI.fpz)});
    }

    protected final int getLayoutId() {
        return 2130903511;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r10) {
        /*
        r9 = this;
        r8 = 4;
        r7 = 3;
        r6 = 2;
        r1 = 1;
        r2 = 0;
        super.onCreate(r10);
        r0 = r9.getIntent();
        r3 = "uin";
        r0 = r0.getIntExtra(r3, r2);
        r9.fnA = r0;
        r0 = r9.getIntent();
        r3 = "Select_Conv_User";
        r0 = r0.getStringExtra(r3);
        r9.bZy = r0;
        r0 = r9.getIntent();
        r3 = "searchID";
        r4 = 0;
        r4 = r0.getLongExtra(r3, r4);
        r9.fdd = r4;
        r0 = r9.getIntent();
        r3 = "id";
        r0 = r0.getStringExtra(r3);
        r9.feg = r0;
        r0 = r9.getIntent();
        r3 = "tag_id";
        r0 = r0.getStringExtra(r3);
        r3 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r3 != 0) goto L_0x0059;
    L_0x004f:
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x01a3 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x01a3 }
        r9.fpx = r0;	 Catch:{ Exception -> 0x01a3 }
    L_0x0059:
        r0 = r9.getIntent();
        r3 = "tag_desc";
        r0 = r0.getStringExtra(r3);
        r9.fpy = r0;
        r0 = r9.getIntent();
        r3 = "keyword";
        r0 = r0.getStringExtra(r3);
        r9.fee = r0;
        r0 = r9.getIntent();
        r3 = "set_id";
        r0 = r0.getIntExtra(r3, r2);
        r9.fpz = r0;
        r0 = r9.getIntent();
        r3 = "set_title";
        r0 = r0.getStringExtra(r3);
        r9.fpA = r0;
        r0 = r9.getIntent();
        r3 = "set_iconURL";
        r0 = r0.getStringExtra(r3);
        r9.fpB = r0;
        r0 = r9.getIntent();
        r3 = "set_desc";
        r0 = r0.getStringExtra(r3);
        r9.fpC = r0;
        r0 = r9.getIntent();
        r3 = "headurl";
        r0 = r0.getStringExtra(r3);
        r9.fpD = r0;
        r0 = r9.getIntent();
        r3 = "sns_object_data";
        r0 = r0.getStringExtra(r3);
        r9.fpE = r0;
        r0 = r9.getIntent();
        r3 = "pageType";
        r0 = r0.getIntExtra(r3, r2);
        r9.fpF = r0;
        r0 = r9.fpE;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x0106;
    L_0x00d6:
        r0 = r9.fpE;
        r0 = com.tencent.mm.plugin.emoji.model.EmojiLogic.ru(r0);
        r9.fpz = r0;
        r0 = r9.fpE;
        r0 = com.tencent.mm.plugin.emoji.model.EmojiLogic.rv(r0);
        r9.fpA = r0;
        r0 = r9.fpE;
        r0 = com.tencent.mm.plugin.emoji.model.EmojiLogic.rx(r0);
        r9.fpB = r0;
        r0 = r9.fpE;
        r0 = com.tencent.mm.plugin.emoji.model.EmojiLogic.rw(r0);
        r9.fpC = r0;
        r0 = r9.fpE;
        r0 = com.tencent.mm.plugin.emoji.model.EmojiLogic.ry(r0);
        r9.fpD = r0;
        r0 = r9.fpE;
        r0 = com.tencent.mm.plugin.emoji.model.EmojiLogic.rz(r0);
        r9.fpF = r0;
    L_0x0106:
        r0 = r9.fpF;
        switch(r0) {
            case 0: goto L_0x01b0;
            case 1: goto L_0x01f4;
            case 2: goto L_0x01f8;
            case 3: goto L_0x0202;
            case 4: goto L_0x0208;
            case 5: goto L_0x020e;
            case 6: goto L_0x0218;
            default: goto L_0x010b;
        };
    L_0x010b:
        r9.fpV = r1;
    L_0x010d:
        r0 = r9.fpV;
        if (r0 == 0) goto L_0x0134;
    L_0x0111:
        r0 = new android.content.Intent;
        r0.<init>();
        r3 = "rawUrl";
        com.tencent.mm.plugin.emoji.model.g.aft();
        r4 = "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0";
        r0.putExtra(r3, r4);
        r3 = "showShare";
        r0.putExtra(r3, r2);
        r3 = "webview";
        r4 = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
        com.tencent.mm.ay.c.b(r9, r3, r4, r0);
        r9.finish();
    L_0x0134:
        r9.NI();
        r0 = r9.fnA;
        if (r0 != 0) goto L_0x017a;
    L_0x013b:
        r0 = r9.fpF;
        if (r0 != r6) goto L_0x017a;
    L_0x013f:
        r0 = com.tencent.mm.plugin.emoji.model.g.afx();
        r0 = r0.fcn;
        r3 = r9.feg;
        r0 = r0.NI(r3);
        if (r0 == 0) goto L_0x021e;
    L_0x014d:
        r3 = r0.mxZ;
        if (r3 == 0) goto L_0x021e;
    L_0x0151:
        r3 = r0.mxZ;
        r3 = r3.mxS;
        if (r3 == 0) goto L_0x021e;
    L_0x0157:
        r3 = r0.mxZ;
        r3 = r3.gkB;
        r3 = com.tencent.mm.sdk.platformtools.be.kS(r3);
        if (r3 != 0) goto L_0x021e;
    L_0x0161:
        r0 = r0.mxZ;
        r0 = r0.mxS;
        r9.fnA = r0;
        r0 = "MicroMsg.emoji.EmojiStoreV2SingleProductUI";
        r3 = "uin:%s ";
        r1 = new java.lang.Object[r1];
        r4 = r9.fnA;
        r4 = java.lang.Integer.valueOf(r4);
        r1[r2] = r4;
        com.tencent.mm.sdk.platformtools.v.i(r0, r3, r1);
    L_0x017a:
        r0 = r2;
    L_0x017b:
        if (r0 != 0) goto L_0x0221;
    L_0x017d:
        r9.NH();
    L_0x0180:
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.vf();
        r1 = com.tencent.mm.storage.t.a.noM;
        r2 = java.lang.Boolean.valueOf(r2);
        r0.a(r1, r2);
        r0 = com.tencent.mm.model.ak.vy();
        r1 = 821; // 0x335 float:1.15E-42 double:4.056E-321;
        r0.a(r1, r9);
        r0 = com.tencent.mm.model.ak.vy();
        r1 = 239; // 0xef float:3.35E-43 double:1.18E-321;
        r0.a(r1, r9);
        return;
    L_0x01a3:
        r0 = move-exception;
        r3 = "MicroMsg.emoji.EmojiStoreV2SingleProductUI";
        r0 = com.tencent.mm.sdk.platformtools.be.e(r0);
        com.tencent.mm.sdk.platformtools.v.e(r3, r0);
        goto L_0x0059;
    L_0x01b0:
        r0 = r9.fee;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x01c1;
    L_0x01b8:
        r0 = 5;
        r9.fpF = r0;
        r9.fpL = r2;
        r9.cVh = r6;
        goto L_0x010d;
    L_0x01c1:
        r0 = r9.feg;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x01cf;
    L_0x01c9:
        r9.fpF = r6;
        r9.cVh = r1;
        goto L_0x010d;
    L_0x01cf:
        r0 = r9.fnA;
        if (r0 == 0) goto L_0x01d9;
    L_0x01d3:
        r9.fpF = r7;
        r9.cVh = r1;
        goto L_0x010d;
    L_0x01d9:
        r0 = r9.fpx;
        if (r0 == 0) goto L_0x01e3;
    L_0x01dd:
        r9.cVh = r7;
        r9.fpF = r8;
        goto L_0x010d;
    L_0x01e3:
        r0 = r9.fpz;
        if (r0 <= 0) goto L_0x01ee;
    L_0x01e7:
        r0 = 6;
        r9.fpF = r0;
        r9.cVh = r8;
        goto L_0x010d;
    L_0x01ee:
        r9.fpF = r1;
        r9.cVh = r2;
        goto L_0x010d;
    L_0x01f4:
        r9.cVh = r2;
        goto L_0x010d;
    L_0x01f8:
        r0 = r9.feg;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 == 0) goto L_0x010d;
    L_0x0200:
        goto L_0x010b;
    L_0x0202:
        r0 = r9.fnA;
        if (r0 != 0) goto L_0x010d;
    L_0x0206:
        goto L_0x010b;
    L_0x0208:
        r0 = r9.fpx;
        if (r0 != 0) goto L_0x010d;
    L_0x020c:
        goto L_0x010b;
    L_0x020e:
        r0 = r9.fee;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 == 0) goto L_0x010d;
    L_0x0216:
        goto L_0x010b;
    L_0x0218:
        r0 = r9.fpz;
        if (r0 != 0) goto L_0x010d;
    L_0x021c:
        goto L_0x010b;
    L_0x021e:
        r0 = r1;
        goto L_0x017b;
    L_0x0221:
        r0 = r9.feg;
        r1 = new com.tencent.mm.plugin.emoji.e.i;
        r1.<init>(r0);
        r9.foa = r1;
        r0 = com.tencent.mm.model.ak.vy();
        r1 = r9.foa;
        r0.a(r1, r2);
        r0 = 2131231182; // 0x7f0801ce float:1.8078438E38 double:1.0529681104E-314;
        r0 = r9.getString(r0);
        r9.rK(r0);
        goto L_0x0180;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.onCreate(android.os.Bundle):void");
    }

    protected void onResume() {
        super.onResume();
        a.nhr.e(this.fpW);
    }

    protected void onPause() {
        super.onPause();
        a.nhr.f(this.fpW);
    }

    protected void onDestroy() {
        ak.vy().b(239, this);
        ak.vy().b(821, this);
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 2002:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!be.kS(stringExtra)) {
                        v.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", ".." + stringExtra);
                        int i3 = this.fpz;
                        String str = this.fpA;
                        String str2 = this.fpC;
                        String str3 = this.fpB;
                        String str4 = this.fpD;
                        int i4 = this.fpF;
                        g.aft();
                        com.tencent.mm.plugin.emoji.d.l.a(this, stringExtra, 27, i3, str, str2, str3, str4, i4, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
                        break;
                    }
                }
                break;
            case 5001:
                if (i2 == -1) {
                    com.tencent.mm.ui.snackbar.a.f(this, this.nDR.nEl.getString(2131232839));
                    break;
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final void NI() {
        if (this.fpF != 6 || be.kS(this.fpA)) {
            vD(2131232392);
        } else {
            Fd(this.fpA);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreV2SingleProductUI fpZ;

            {
                this.fpZ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.fpZ.fpQ == null || this.fpZ.fpQ.getVisibility() != 0) {
                    this.fpZ.finish();
                } else {
                    this.fpZ.fpQ.setVisibility(8);
                    this.fpZ.V(1001, this.fpZ.fpL);
                    this.fpZ.vD(2131232392);
                }
                return false;
            }
        });
        this.fpH = new d(this.nDR.nEl);
        this.fpH.fqL = new a(this) {
            final /* synthetic */ EmojiStoreV2SingleProductUI fpZ;

            {
                this.fpZ = r1;
            }

            public final void jH(int i) {
                if (this.fpZ.fpG != null && this.fpZ.fpH != null) {
                    nu kk = this.fpZ.fpH.kk(i);
                    if (kk != null) {
                        try {
                            Intent intent = new Intent();
                            intent.putExtra("Select_Conv_User", this.fpZ.bZy);
                            intent.putExtra("extra_object", kk.toByteArray());
                            intent.putExtra("scene", this.fpZ.cVh);
                            intent.putExtra("searchID", this.fpZ.fdd);
                            intent.setClass(this.fpZ.nDR.nEl, EmojiStoreV2SingleProductDialogUI.class);
                            this.fpZ.startActivityForResult(intent, 5001);
                            this.fpZ.overridePendingTransition(2130968641, 2130968642);
                            com.tencent.mm.plugin.report.service.g.iuh.h(12787, new Object[]{Integer.valueOf(this.fpZ.cVh), Integer.valueOf(0), Long.valueOf(this.fpZ.fdd)});
                        } catch (Exception e) {
                        }
                    }
                }
            }
        };
        this.fpG = (PreViewListGridView) findViewById(2131756740);
        this.PH = q.em(this.nDR.nEl).inflate(2130903499, null);
        this.fpI = this.PH.findViewById(2131756711);
        this.fpJ = (TextView) this.PH.findViewById(2131756712);
        this.fpG.addHeaderView(this.PH);
        this.fpK = q.em(this.nDR.nEl).inflate(2130903487, null);
        this.fpG.addFooterView(this.fpK);
        this.fpK.setVisibility(8);
        this.fpG.setAdapter(this.fpH);
        this.fpG.setOnScrollListener(this);
        this.fnY = (MMPullDownView) findViewById(2131756739);
        this.fnY.jr(false);
        this.fnY.nWU = this.fpX;
        this.fnY.nXf = this.fpY;
        this.fnY.jq(false);
        this.fnY.jp(false);
        this.fnY.nXq = true;
        this.fpQ = (LabelContainerView) findViewById(2131755211);
        this.fpR = (TextView) this.fpQ.findViewById(16908310);
        this.fpR.setText(2131233467);
        this.fpS = (MMTagPanel) this.fpQ.findViewById(2131755212);
        this.fpS.gMg = 2130839266;
        this.fpS.gMh = 2131690123;
        this.fpP = getString(2131232414);
        this.fpQ.oGY = new LabelContainerView.a(this) {
            final /* synthetic */ EmojiStoreV2SingleProductUI fpZ;

            {
                this.fpZ = r1;
            }

            public final void aig() {
                if (this.fpZ.fpQ != null) {
                    this.fpZ.fpQ.clearFocus();
                }
                this.fpZ.fpQ.requestFocus();
                this.fpZ.fpQ.setVisibility(8);
                this.fpZ.V(1001, this.fpZ.fpL);
                this.fpZ.vD(2131232392);
            }

            public final void aih() {
                this.fpZ.axg();
            }
        };
        this.fpS.nYp = new MMTagPanel.a(this) {
            final /* synthetic */ EmojiStoreV2SingleProductUI fpZ;

            {
                this.fpZ = r1;
            }

            public final void rS(String str) {
                if (!be.kS(this.fpZ.fpP) && !be.kS(str) && str.equals(this.fpZ.fpP)) {
                    this.fpZ.fpS.aN(this.fpZ.fpP, true);
                }
            }

            public final void rT(String str) {
                EmojiStoreV2SingleProductUI.a(this.fpZ, str);
            }

            public final void rU(String str) {
            }

            public final void f(boolean z, int i) {
            }

            public final void aii() {
            }

            public final void rV(String str) {
            }

            public final void rW(String str) {
            }
        };
        a(1001, 2130837597, new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreV2SingleProductUI fpZ;

            {
                this.fpZ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.fpZ.fpQ != null) {
                    this.fpZ.fpQ.setVisibility(0);
                    Collection arrayList = new ArrayList();
                    arrayList.add(this.fpZ.fpP);
                    this.fpZ.fpS.a(arrayList, this.fpZ.fpU);
                    this.fpZ.vD(2131232410);
                    this.fpZ.V(1001, false);
                    com.tencent.mm.plugin.report.service.g.iuh.Y(12788, "1");
                }
                return false;
            }
        });
        a(1002, 2131165801, new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreV2SingleProductUI fpZ;

            {
                this.fpZ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                v.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "on shard click.");
                EmojiStoreV2SingleProductUI.o(this.fpZ);
                return true;
            }
        });
        V(1001, false);
        V(1002, false);
    }

    public void onBackPressed() {
        if (this.fpQ == null || this.fpQ.getVisibility() != 0) {
            super.onBackPressed();
            return;
        }
        this.fpQ.setVisibility(8);
        V(1001, this.fpL);
        vD(2131232392);
    }

    private void NH() {
        if (this.fpV) {
            v.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "need jeep to update page.");
            return;
        }
        this.fpN = null;
        switch (this.fpF) {
            case 1:
                this.fpM = g.afx().fcn.NJ("0");
                if (this.fpM == null || this.fpM.mxX == null || this.fpH == null) {
                    rK(getString(2131231182));
                } else {
                    a(this.fpM);
                    this.fpH.an(this.fpM.mxX);
                }
                this.fpL = true;
                com.tencent.mm.plugin.report.service.g.iuh.h(12875, new Object[]{Integer.valueOf(0), ""});
                break;
            case 2:
            case 3:
                V(1001, false);
                this.fpL = false;
                com.tencent.mm.plugin.report.service.g.iuh.h(12875, new Object[]{Integer.valueOf(1), this.feg});
                break;
            case 4:
                V(1001, false);
                this.fpP = this.fpy;
                rR(this.fpP);
                this.fpL = false;
                com.tencent.mm.plugin.report.service.g.iuh.h(12875, new Object[]{Integer.valueOf(1), ""});
                break;
            case 5:
                this.fpP = "";
                rR(this.fee);
                this.fpL = false;
                com.tencent.mm.plugin.report.service.g.iuh.h(12875, new Object[]{Integer.valueOf(2), ""});
                break;
            case 6:
                this.fpP = "";
                V(1001, false);
                V(1002, true);
                com.tencent.mm.plugin.report.service.g.iuh.h(12875, new Object[]{Integer.valueOf(3), ""});
                break;
        }
        ah(this.fpN);
    }

    private void rK(String str) {
        if (isFinishing()) {
            v.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[showLoadingDialog] acitivity is finished.");
            return;
        }
        getString(2131231164);
        this.eZg = com.tencent.mm.ui.base.g.a(this, str, true, new OnCancelListener(this) {
            final /* synthetic */ EmojiStoreV2SingleProductUI fpZ;

            {
                this.fpZ = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.fpZ.foa != null) {
                    ak.vy().c(this.fpZ.foa);
                }
            }
        });
    }

    private void agt() {
        if (this.eZg != null && this.eZg.isShowing()) {
            this.eZg.dismiss();
        }
    }

    private void ah(byte[] bArr) {
        this.fpN = null;
        switch (this.fpF) {
            case 1:
                ak.vy().a(new h(1, this.fnA, this.fpx, this.fee, this.fpz, bArr), 0);
                return;
            case 2:
            case 3:
                ak.vy().a(new h(2, this.fnA, this.fpx, this.fee, this.fpz, bArr), 0);
                return;
            case 4:
                ak.vy().a(new h(3, this.fnA, this.fpx, this.fee, this.fpz, bArr), 0);
                return;
            case 5:
                ak.vy().a(new h(4, this.fnA, this.fpx, this.fee, this.fpz, bArr), 0);
                return;
            case 6:
                ak.vy().a(new h(5, this.fnA, this.fpx, this.fee, this.fpz, bArr), 0);
                return;
            default:
                return;
        }
    }

    private void a(vj vjVar) {
        boolean z = false;
        if (vjVar == null || vjVar.mxY == null || vjVar.mxY.size() <= 0) {
            V(1001, false);
            return;
        }
        if (this.fpL) {
            z = true;
        }
        V(1001, z);
        if (this.fpS != null) {
            if (this.fpU == null) {
                this.fpU = new ArrayList();
            } else {
                this.fpU.clear();
            }
            if (this.fpT == null) {
                this.fpT = new HashMap();
            }
            this.fpT.clear();
            this.fpU.add(getString(2131232414));
            Iterator it = vjVar.mxY.iterator();
            while (it.hasNext()) {
                nv nvVar = (nv) it.next();
                if (!(nvVar == null || be.kS(nvVar.mpH))) {
                    this.fpU.add(nvVar.mpH);
                    this.fpT.put(nvVar.mpH, Integer.valueOf(nvVar.mpG));
                }
            }
            Collection arrayList = new ArrayList();
            arrayList.add(this.fpP);
            this.fpS.a(arrayList, this.fpU);
        }
    }

    private void rR(String str) {
        if (this.fpI != null && this.fpJ != null) {
            switch (this.fpF) {
                case 4:
                    if (!be.kS(str)) {
                        this.fpJ.setText(getString(2131232415, new Object[]{str}));
                        this.fpJ.setVisibility(0);
                        this.fpI.setVisibility(0);
                        break;
                    }
                    break;
                case 5:
                    if (!be.kS(str)) {
                        this.fpJ.setText(getString(2131232411, new Object[]{str}));
                        this.fpJ.setVisibility(0);
                        this.fpI.setVisibility(0);
                        break;
                    }
                    break;
            }
            if (be.kS(str)) {
                this.fpJ.setText("");
                this.fpJ.setVisibility(8);
                this.fpI.setVisibility(8);
            }
        }
    }

    private void cF(boolean z) {
        if (!this.foB) {
            ah(this.fpN);
            this.foB = true;
            this.mHandler.sendEmptyMessageDelayed(1002, 200);
        }
    }

    private void D(LinkedList<nu> linkedList) {
        if (this.fpH != null && linkedList != null) {
            if (this.fpO == -1) {
                this.fpH.an(linkedList);
                return;
            }
            d dVar = this.fpH;
            if (dVar.eZk == null) {
                dVar.eZk = new ArrayList();
            }
            dVar.eZk.addAll(linkedList);
            dVar.notifyDataSetChanged();
        }
    }

    private void aif() {
        Toast.makeText(this.nDR.nEl, getString(2131232443), 0).show();
    }

    public final void a(int i, int i2, String str, k kVar) {
        int type = kVar.getType();
        if (type == 821) {
            agt();
            h hVar = (h) kVar;
            vj afK = hVar.afK();
            this.foB = false;
            if (this.fpK != null) {
                this.fpK.setVisibility(8);
                this.mHandler.removeMessages(1002);
                this.mHandler.sendEmptyMessageDelayed(1001, 200);
            }
            int i3 = hVar.cKy;
            if (((i == 0 && i2 == 0) || (i == 4 && (i2 == 2 || i2 == 3))) && ((this.fpN == null || this.fpN.length <= 0) && i3 != 3)) {
                a(afK);
            }
            if (i == 0 || i == 4) {
                this.fpN = hVar.fec;
                if (i2 == 0) {
                    D(afK.mxX);
                    this.fpO = 0;
                    return;
                } else if (i2 == 2) {
                    D(afK.mxX);
                    this.fpO = 2;
                    return;
                } else if (i2 == 3) {
                    this.fpO = -1;
                    D(afK.mxX);
                    return;
                } else {
                    aif();
                    return;
                }
            }
            aif();
        } else if (type == 239) {
            agt();
            if (i2 == 0 && i == 0) {
                vl afL = ((i) kVar).afL();
                if (afL != null && afL.mxZ != null) {
                    this.fnA = afL.mxZ.mxS;
                    if (this.mHandler != null) {
                        this.mHandler.sendEmptyMessage(1004);
                        return;
                    }
                    return;
                }
                return;
            }
            V(1001, false);
            com.tencent.mm.ui.base.g.A(this.nDR.nEl, getString(2131232341), null);
            v.e("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "open single product ui failed.");
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && this.fpO == 2 && !this.foB) {
            v.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "No More List.");
            cF(true);
            v.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
        }
        if (i != 0 && this.fpG != null) {
            this.fpG.aik();
        }
    }

    protected final int NO() {
        return 1;
    }
}
