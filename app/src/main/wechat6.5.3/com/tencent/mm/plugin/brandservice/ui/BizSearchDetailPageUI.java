package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.brandservice.ui.base.a;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.hy;
import com.tencent.mm.protocal.c.id;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import java.util.LinkedList;
import java.util.List;

public class BizSearchDetailPageUI extends MMActivity implements b {
    private p exP;
    private BizSearchResultItemContainer exQ;
    private long exR;
    private String exS;
    private int exT;
    private int exU;
    private Runnable exV = new Runnable(this) {
        final /* synthetic */ BizSearchDetailPageUI exW;

        {
            this.exW = r1;
        }

        public final void run() {
            this.exW.exQ.ai(this.exW.exS, this.exW.vI);
            this.exW.vI = 0;
        }
    };
    private int vI;

    protected final int getLayoutId() {
        return 2130903182;
    }

    public final void Oh() {
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BizSearchDetailPageUI exW;

            {
                this.exW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.exW.finish();
                return true;
            }
        });
        Intent intent = getIntent();
        this.exR = intent.getLongExtra("businessType", 0);
        boolean booleanExtra = intent.getBooleanExtra("showEditText", false);
        this.exT = intent.getIntExtra("fromScene", 0);
        this.exU = intent.getIntExtra("addContactScene", 35);
        String stringExtra = intent.getStringExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE);
        String stringExtra2 = intent.getStringExtra("keyword");
        boolean booleanExtra2 = intent.getBooleanExtra("showCatalog", false);
        this.vI = intent.getIntExtra("offset", 0);
        if (this.exR == 0 || be.kS(stringExtra2)) {
            v.e("MicroMsg.BrandService.BizSearchDetailPageUI", "businessType(%d) or queryStr is nil.", new Object[]{Long.valueOf(this.exR)});
            finish();
            return;
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra("result");
        if (byteArrayExtra != null) {
            try {
                hy hyVar = (hy) new hy().az(byteArrayExtra);
                boolean z2 = hyVar != null;
                hy hyVar2 = hyVar;
            } catch (Throwable e) {
                v.a("MicroMsg.BrandService.BizSearchDetailPageUI", e, "", new Object[0]);
                finish();
                return;
            }
        }
        z2 = false;
        hyVar2 = null;
        this.exQ = (BizSearchResultItemContainer) findViewById(2131755638);
        this.exQ.a(new c(this));
        this.exQ.d(this.exR);
        this.exQ.eyv = 1;
        this.exQ.cd(booleanExtra2);
        this.exQ.iI(this.exT);
        BizSearchResultItemContainer bizSearchResultItemContainer = this.exQ;
        int i = this.exU;
        bizSearchResultItemContainer.exU = i;
        bizSearchResultItemContainer.eym.iJ(i);
        bizSearchResultItemContainer = this.exQ;
        c.b anonymousClass3 = new c.b(this) {
            final /* synthetic */ BizSearchDetailPageUI exW;

            {
                this.exW = r1;
            }

            public final void a(c cVar, a aVar, int i, String str, int i2, int i3) {
                if (this.exW.exT == 1 && aVar.type == 5) {
                    id idVar = (id) aVar.data;
                    if (idVar.mjh == null || idVar.mjh.miO == null) {
                        v.e("MicroMsg.BrandService.BizSearchDetailPageUI", "bcdItem.ContactItem == null || bcdItem.ContactItem.ContactItem == null");
                        return;
                    }
                    hy iH = cVar.iH(i3);
                    String str2 = be.ma(this.exW.exS) + "," + i + "," + be.ma(str) + "," + i2 + "," + cVar.eyc + "," + (iH == null ? "" : iH.miU + ",1");
                    g.iuh.Y(10866, str2);
                    v.d("MicroMsg.BrandService.BizSearchDetailPageUI", "report : " + str2);
                    if ((idVar.mjh.miO.mFu & 8) > 0) {
                        g.iuh.Y(10298, str + ",35");
                    }
                }
            }
        };
        if (bizSearchResultItemContainer.eym != null) {
            bizSearchResultItemContainer.eym.a(anonymousClass3);
        }
        if (booleanExtra) {
            this.exP = new p();
            a(this.exP);
            this.exP.kj(false);
            this.exP.clearFocus();
            this.exP.Pw(stringExtra2);
            this.exP.oUs = this;
            this.exQ.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ BizSearchDetailPageUI exW;

                {
                    this.exW = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (this.exW.exP != null) {
                        this.exW.exP.clearFocus();
                    }
                    this.exW.axg();
                    return false;
                }
            });
        } else if (!be.kS(stringExtra)) {
            Fd(stringExtra);
        }
        if (z2) {
            bizSearchResultItemContainer = this.exQ;
            int i2 = this.vI;
            bizSearchResultItemContainer.reset();
            if (hyVar2 == null) {
                v.e("MicroMsg.BrandService.BizSearchResultItemContainer", "setFirst page content failed, content is null.");
                return;
            }
            bizSearchResultItemContainer.eyo.aXp = stringExtra2;
            bizSearchResultItemContainer.d(hyVar2.miQ);
            bizSearchResultItemContainer.eyo.eyf = hyVar2.miR;
            bizSearchResultItemContainer.eyt = i2;
            List linkedList = new LinkedList();
            linkedList.add(hyVar2);
            bizSearchResultItemContainer.eym.c(stringExtra2, linkedList);
            bizSearchResultItemContainer.eyo.offset = i2 + hyVar2.mfb;
            c cVar = bizSearchResultItemContainer.eyo;
            if (bizSearchResultItemContainer.eym.isEmpty()) {
                z = false;
            }
            cVar.eyC = z;
            return;
        }
        ml(stringExtra2);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.exP != null) {
            this.exP.a(this, menu);
        }
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.exP != null) {
            this.exP.a(this, menu);
        }
        return true;
    }

    protected void onPause() {
        super.onPause();
        if (this.exP != null) {
            this.exP.clearFocus();
        }
    }

    public final boolean mk(String str) {
        return false;
    }

    public final void ml(String str) {
        if (!be.kS(str)) {
            String trim = str.trim();
            if (!trim.equals(this.exS)) {
                ad.B(this.exV);
                this.exS = trim;
                ad.g(this.exV, 400);
            }
        }
    }

    public final void Of() {
        finish();
    }

    public final void Og() {
    }
}
