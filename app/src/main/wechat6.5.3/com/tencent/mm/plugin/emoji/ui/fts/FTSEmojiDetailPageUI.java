package com.tencent.mm.plugin.emoji.ui.fts;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.a.g;
import com.tencent.mm.ae.a.c.i;
import com.tencent.mm.ae.n;
import com.tencent.mm.e.a.bz;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.modelsearch.l;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.c.a;
import com.tencent.mm.plugin.gif.MMGIFImageView;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.e;
import java.io.File;

public class FTSEmojiDetailPageUI extends MMActivity implements e {
    private String aZD;
    private String bjG;
    private String bkJ;
    private String designerName;
    private ProgressBar edA;
    private String fde;
    private c ffo;
    private MMGIFImageView fjZ;
    private Button fka;
    private Button fkb;
    private TextView fkc;
    private ImageView fkd;
    private View fke;
    private String fkf;
    private String fkg;
    private String fkh;
    private String fki;
    private String fkj;
    private String fkk;
    private com.tencent.mm.sdk.c.c fkl = new com.tencent.mm.sdk.c.c<bz>(this) {
        final /* synthetic */ FTSEmojiDetailPageUI fko;

        {
            this.fko = r2;
            this.nhz = bz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            bz bzVar = (bz) bVar;
            if (this.fko.ffo != null && bzVar.aZx.aZy.equals(this.fko.ffo.EB())) {
                v.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "emojiDownloadListener callback %s", new Object[]{this.fko.ffo.EB()});
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass5 fkp;

                    {
                        this.fkp = r1;
                    }

                    public final void run() {
                        this.fkp.fko.cA(false);
                    }
                });
            }
            return false;
        }
    };
    private a fkm = new a(this) {
        final /* synthetic */ FTSEmojiDetailPageUI fko;

        {
            this.fko = r1;
        }

        public final void i(c cVar) {
            if (cVar == null || this.fko.ffo == null || !this.fko.ffo.EB().equals(cVar.EB())) {
                v.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "somethings error.");
                return;
            }
            v.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "emojiServiceCallback onDownload %s", new Object[]{this.fko.ffo.EB()});
            ad.o(new Runnable(this) {
                final /* synthetic */ AnonymousClass6 fkq;

                {
                    this.fkq = r1;
                }

                public final void run() {
                    this.fkq.fko.cA(false);
                }
            });
        }
    };
    private i fkn = new i(this) {
        final /* synthetic */ FTSEmojiDetailPageUI fko;

        {
            this.fko = r1;
        }

        public final void a(String str, Bitmap bitmap, Object... objArr) {
            v.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "imageLoaderListener onImageLoadComplete %s", new Object[]{str});
            if (bitmap != null && objArr != null && objArr.length > 0 && objArr[0] != null && (objArr[0] instanceof String) && str.equals(this.fko.ffo.field_encrypturl)) {
                File file = new File(objArr[0].toString());
                if (file.exists()) {
                    this.fko.ffo.field_md5 = g.g(file);
                    FTSEmojiDetailPageUI fTSEmojiDetailPageUI = this.fko;
                    ak.yW();
                    fTSEmojiDetailPageUI.bjG = EmojiLogic.A(com.tencent.mm.model.c.wY(), "", this.fko.ffo.field_md5);
                    FileOp.p(file.getAbsolutePath(), this.fko.bjG);
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass7 fkr;

                        {
                            this.fkr = r1;
                        }

                        public final void run() {
                            this.fkr.fko.cA(false);
                        }
                    });
                }
            }
        }
    };
    private int scene;
    private int type;

    static /* synthetic */ void a(FTSEmojiDetailPageUI fTSEmojiDetailPageUI, String str) {
        l.a(fTSEmojiDetailPageUI.scene, fTSEmojiDetailPageUI.bkJ, fTSEmojiDetailPageUI.fde, 2, 0);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 5);
        intent.putExtra("Retr_Msg_thumb_path", str);
        intent.putExtra("MMActivity.OverrideEnterAnimation", 2130968622);
        com.tencent.mm.ay.c.a(fTSEmojiDetailPageUI, ".ui.transmit.SelectConversationUI", intent, 0);
        fTSEmojiDetailPageUI.overridePendingTransition(2130968646, 2130968623);
    }

    static /* synthetic */ void a(FTSEmojiDetailPageUI fTSEmojiDetailPageUI, String str, String str2, String str3) {
        l.a(fTSEmojiDetailPageUI.scene, fTSEmojiDetailPageUI.bkJ, fTSEmojiDetailPageUI.fde, 1, 0);
        c NF = com.tencent.mm.plugin.emoji.model.g.afx().fch.NF(str);
        ak.yW();
        String A = EmojiLogic.A(com.tencent.mm.model.c.wY(), "", str);
        if (NF == null && com.tencent.mm.a.e.aR(A)) {
            int i = o.JZ(A) ? c.nwT : c.nwS;
            c cVar = new c();
            cVar.field_md5 = str;
            cVar.field_catalog = c.nwM;
            cVar.field_type = i;
            cVar.field_size = com.tencent.mm.a.e.aQ(A);
            cVar.field_temp = 1;
            cVar.field_designerID = str2;
            cVar.field_thumbUrl = str3;
            com.tencent.mm.plugin.emoji.model.g.afx().fch.p(cVar);
            NF = cVar;
        }
        if (NF != null) {
            boolean a = com.tencent.mm.plugin.emoji.model.g.aft().a(fTSEmojiDetailPageUI, NF, 18, k.xF());
            v.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "doAddAction %b", new Object[]{Boolean.valueOf(a)});
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void b(com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI r7) {
        /*
        r6 = 27;
        r2 = 3;
        r1 = 0;
        r3 = r7.scene;
        r4 = r7.bkJ;
        r5 = r7.fde;
        r0 = r7.type;
        switch(r0) {
            case 2: goto L_0x004b;
            case 3: goto L_0x0055;
            case 4: goto L_0x005f;
            default: goto L_0x000f;
        };
    L_0x000f:
        r0 = r1;
    L_0x0010:
        com.tencent.mm.modelsearch.l.a(r3, r4, r5, r2, r0);
        r0 = new android.content.Intent;
        r0.<init>();
        r2 = "preceding_scence";
        r3 = r7.getIntent();
        r4 = "preceding_scence";
        r1 = r3.getIntExtra(r4, r1);
        r0.putExtra(r2, r1);
        r1 = "download_entrance_scene";
        r0.putExtra(r1, r6);
        r1 = "searchID";
        r2 = r7.bkJ;
        r4 = 0;
        r2 = com.tencent.mm.sdk.platformtools.be.getLong(r2, r4);
        r0.putExtra(r1, r2);
        r1 = "docID";
        r2 = r7.fde;
        r0.putExtra(r1, r2);
        r1 = r7.type;
        switch(r1) {
            case 2: goto L_0x0090;
            case 3: goto L_0x0069;
            case 4: goto L_0x00b3;
            default: goto L_0x004a;
        };
    L_0x004a:
        return;
    L_0x004b:
        r0 = r7.aZD;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x000f;
    L_0x0053:
        r0 = 1;
        goto L_0x0010;
    L_0x0055:
        r0 = r7.fkj;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x000f;
    L_0x005d:
        r0 = 2;
        goto L_0x0010;
    L_0x005f:
        r0 = r7.fkh;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x000f;
    L_0x0067:
        r0 = r2;
        goto L_0x0010;
    L_0x0069:
        r1 = com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.class;
        r0.setClass(r7, r1);
        r1 = "extra_scence";
        r0.putExtra(r1, r6);
        r1 = "id";
        r2 = r7.fkj;
        r0.putExtra(r1, r2);
        r1 = "name";
        r2 = r7.designerName;
        r0.putExtra(r1, r2);
        r1 = "headurl";
        r2 = r7.fkk;
        r0.putExtra(r1, r2);
    L_0x008c:
        r7.startActivity(r0);
        goto L_0x004a;
    L_0x0090:
        r1 = com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.class;
        r0.setClass(r7, r1);
        r1 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r0.setFlags(r1);
        r1 = "extra_scence";
        r2 = r7.scene;
        r0.putExtra(r1, r2);
        r1 = "extra_type";
        r2 = r7.type;
        r0.putExtra(r1, r2);
        r1 = "extra_id";
        r2 = r7.aZD;
        r0.putExtra(r1, r2);
        goto L_0x008c;
    L_0x00b3:
        r1 = r7.fkh;
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r1 != 0) goto L_0x004a;
    L_0x00bb:
        r1 = "rawUrl";
        r2 = r7.fkh;
        r0.putExtra(r1, r2);
        r1 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r2 = "webview";
        r3 = ".ui.tools.WebViewUI";
        com.tencent.mm.ay.c.b(r1, r2, r3, r0);
        goto L_0x004a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.b(com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI):void");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fka = (Button) findViewById(2131757168);
        this.fkb = (Button) findViewById(2131757169);
        this.fjZ = (MMGIFImageView) findViewById(2131757167);
        this.edA = (ProgressBar) findViewById(2131755522);
        this.fkc = (TextView) findViewById(2131757171);
        this.fkd = (ImageView) findViewById(2131757172);
        this.fke = findViewById(2131757170);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FTSEmojiDetailPageUI fko;

            {
                this.fko = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.fko.finish();
                return false;
            }
        });
        this.fka.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FTSEmojiDetailPageUI fko;

            {
                this.fko = r1;
            }

            public final void onClick(View view) {
                FTSEmojiDetailPageUI.a(this.fko, this.fko.ffo.EB(), this.fko.ffo.field_designerID, this.fko.ffo.field_thumbUrl);
            }
        });
        this.fkb.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FTSEmojiDetailPageUI fko;

            {
                this.fko = r1;
            }

            public final void onClick(View view) {
                FTSEmojiDetailPageUI.a(this.fko, this.fko.ffo.EB());
            }
        });
        this.fke.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FTSEmojiDetailPageUI fko;

            {
                this.fko = r1;
            }

            public final void onClick(View view) {
                FTSEmojiDetailPageUI.b(this.fko);
            }
        });
        this.type = getIntent().getIntExtra("extra_type", 0);
        this.scene = getIntent().getIntExtra("extra_scence", 0);
        this.ffo = new c();
        this.ffo.field_designerID = getIntent().getStringExtra("id");
        this.ffo.field_name = getIntent().getStringExtra("extra_emoji_name");
        this.ffo.field_aeskey = getIntent().getStringExtra("extra_aeskey");
        this.ffo.field_encrypturl = getIntent().getStringExtra("extra_encrypt_url");
        this.ffo.field_thumbUrl = getIntent().getStringExtra("extra_thumb_url");
        this.ffo.field_md5 = getIntent().getStringExtra("extra_md5");
        this.ffo.field_groupId = getIntent().getStringExtra("extra_product_id");
        this.aZD = this.ffo.field_groupId;
        this.fkg = getIntent().getStringExtra("extra_product_name");
        this.fkf = getIntent().getStringExtra("productUrl");
        this.fkh = getIntent().getStringExtra("extra_article_url");
        this.fki = getIntent().getStringExtra("extra_article_name");
        this.fkj = this.ffo.field_designerID;
        this.designerName = getIntent().getStringExtra("name");
        this.fkk = getIntent().getStringExtra("headurl");
        this.bkJ = getIntent().getStringExtra("searchID");
        this.fde = getIntent().getStringExtra("docID");
        com.tencent.mm.sdk.c.a.nhr.e(this.fkl);
        com.tencent.mm.plugin.emoji.model.g.afr().fcN = this.fkm;
        l.g(this.scene, this.bkJ, this.fde);
        cA(true);
        v.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "localPath=%s", new Object[]{this.bjG});
        l.g(this.scene, this.bkJ, this.fde);
    }

    protected void onResume() {
        super.onResume();
        ahi();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0 && i2 == -1) {
            c cVar;
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            c NF = com.tencent.mm.plugin.emoji.model.g.afx().fch.NF(this.ffo.EB());
            if (NF == null) {
                ak.yW();
                String A = EmojiLogic.A(com.tencent.mm.model.c.wY(), "", this.ffo.EB());
                if (com.tencent.mm.a.e.aR(A)) {
                    NF = com.tencent.mm.plugin.emoji.model.g.afx().fch.a(this.ffo.EB(), "", c.nwM, o.JZ(A) ? c.nwT : c.nwS, com.tencent.mm.a.e.aQ(A), "");
                    NF.field_designerID = this.ffo.field_designerID;
                    NF.field_thumbUrl = this.ffo.field_thumbUrl;
                }
                cVar = NF;
            } else {
                NF.field_designerID = this.ffo.field_designerID;
                NF.field_thumbUrl = this.ffo.field_thumbUrl;
                cVar = NF;
            }
            for (String str : be.g(be.ah(stringExtra, "").split(","))) {
                if (cVar != null) {
                    com.tencent.mm.plugin.emoji.model.g.aft().a(str, cVar, null);
                }
            }
            com.tencent.mm.ui.snackbar.a.f(this, this.nDR.nEl.getString(2131232839));
        }
    }

    private void cA(boolean z) {
        if (z) {
            Fd(this.ffo.getName());
        }
        switch (this.type) {
            case 2:
                n.GL().a(this.fkf, this.fkd);
                this.fkc.setText(this.fkg);
                this.bjG = this.ffo.dR(this.aZD, this.ffo.field_md5);
                break;
            case 3:
                n.GL().a(this.fkk, this.fkd);
                this.fkc.setText(this.designerName);
                this.bjG = this.ffo.dR(this.aZD, this.ffo.field_md5);
                break;
            case 4:
                this.fkd.setVisibility(8);
                if (!be.kS(this.fkh)) {
                    this.fkc.setText(this.fki);
                    break;
                } else {
                    this.fkc.setText(2131234847);
                    break;
                }
        }
        if (FileOp.aR(this.bjG)) {
            this.edA.setVisibility(8);
            this.fjZ.setVisibility(0);
            c NF = com.tencent.mm.plugin.emoji.model.g.afx().fch.NF(this.ffo.EB());
            if (NF == null || (NF.field_reserved4 & c.nxh) != c.nxh) {
                v.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: no decrypt");
                this.fjZ.bN(this.bjG, null);
            } else {
                v.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: decrypt");
                this.fjZ.d(j.a.bmr().g(NF), "");
            }
            ahi();
            NF = com.tencent.mm.plugin.emoji.model.g.afx().fch.NF(this.ffo.EB());
            if (NF == null) {
                NF = this.ffo;
            }
            if (NF.field_catalog == c.nwR || be.kS(NF.field_groupId) || ((!be.kS(NF.field_groupId) && j.a.bmr().rl(NF.field_groupId)) || this.type == 4)) {
                this.fkb.setEnabled(true);
                return;
            }
            String str = this.ffo.field_groupId;
            ak.vy().a(423, this);
            ak.vy().a(new com.tencent.mm.plugin.emoji.e.g(str, (byte) 0), 0);
        } else if (!z) {
        } else {
            if (this.type == 4) {
                File file = new File(getCacheDir(), g.m(this.ffo.field_encrypturl.getBytes()));
                if (file.exists()) {
                    this.ffo.field_md5 = g.g(file);
                    ak.yW();
                    String A = EmojiLogic.A(com.tencent.mm.model.c.wY(), "", this.ffo.field_md5);
                    if (!FileOp.aR(A)) {
                        FileOp.p(file.getAbsolutePath(), A);
                    }
                    this.bjG = A;
                    cA(false);
                    return;
                }
                com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
                aVar.cPs = true;
                aVar.cPu = file.getAbsolutePath();
                aVar.cPT = new Object[]{file.getAbsolutePath()};
                com.tencent.mm.plugin.emoji.model.g.afq().a(this.ffo.field_encrypturl, null, aVar.GU(), this.fkn);
                return;
            }
            this.fjZ.setVisibility(8);
            this.edA.setVisibility(0);
            this.fka.setText(2131232366);
            this.fkb.setText(2131231149);
            this.fka.setEnabled(false);
            this.fkb.setEnabled(false);
            com.tencent.mm.plugin.emoji.model.g.afr().h(this.ffo);
        }
    }

    private void ahi() {
        c NF = com.tencent.mm.plugin.emoji.model.g.afx().fch.NF(this.ffo.EB());
        if (NF == null) {
            NF = this.ffo;
        }
        if (NF == null || NF.field_catalog != com.tencent.mm.storage.a.a.nwL) {
            this.fka.setText(2131232366);
            if (com.tencent.mm.a.e.aR(this.bjG)) {
                this.fka.setEnabled(true);
                return;
            } else {
                this.fka.setEnabled(false);
                return;
            }
        }
        this.fka.setEnabled(false);
        this.fka.setText(2131230902);
    }

    protected final int getLayoutId() {
        return 2130903680;
    }

    protected void onDestroy() {
        com.tencent.mm.sdk.c.a.nhr.f(this.fkl);
        com.tencent.mm.plugin.emoji.model.g.afr().fcN = null;
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (kVar.getType() == 423) {
            ak.vy().b(423, this);
            com.tencent.mm.plugin.emoji.e.g gVar = (com.tencent.mm.plugin.emoji.e.g) kVar;
            if (gVar == null || be.kS(gVar.fdU) || this.ffo == null || be.kS(this.ffo.field_groupId) || !this.ffo.field_groupId.equalsIgnoreCase(gVar.fdU)) {
                v.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "no the same product ID");
            } else if (i == 0 && i2 == 0) {
                this.fkb.setEnabled(true);
            } else {
                this.fkb.setEnabled(false);
            }
        }
    }
}
