package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.e.a.kk;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.o;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.product.b.b;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.f;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.product.b.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@a(3)
public class MallProductUI extends MallBaseUI implements j.a {
    private Button fzj;
    private TextView gNg;
    private HtmlTextView hRG;
    private TextView hSD;
    private f hSJ;
    protected c hSa;
    private ListView hTi;
    private a hTj;
    private LinearLayout hTl;
    private LinearLayout hTm;
    private ImageView hTn;
    private TextView hTo;
    private HtmlTextView hTp;
    private RelativeLayout hTq;
    private ListView hTr;
    private k hTs = null;
    private Button hTt;

    static /* synthetic */ void d(MallProductUI mallProductUI) {
        List list = mallProductUI.hSa.hQd;
        if (list != null && list.size() > 0) {
            mallProductUI.hTs.hST = list;
        }
    }

    protected final int getLayoutId() {
        return 2130904194;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        oa(8);
        boolean booleanExtra = getIntent().getBooleanExtra("key_go_finish", false);
        setResult(-1);
        if (booleanExtra) {
            finish();
            return;
        }
        NI();
        com.tencent.mm.plugin.product.a.a.aFW();
        this.hSa = com.tencent.mm.plugin.product.a.a.aFX();
        this.hSJ = new f(this.nDR.nEl, new f.a(this) {
            final /* synthetic */ MallProductUI hTu;

            {
                this.hTu = r1;
            }

            public final void i(int i, int i2, String str) {
                if (i == 0 && i2 == 0) {
                    this.hTu.av();
                    if (this.hTu.fzj != null) {
                        this.hTu.fzj.postDelayed(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 hTv;

                            {
                                this.hTv = r1;
                            }

                            public final void run() {
                                ScrollView scrollView = (ScrollView) this.hTv.hTu.findViewById(2131758644);
                                if (scrollView != null) {
                                    scrollView.pageScroll(33);
                                }
                            }
                        }, 200);
                    }
                } else if (i2 == -10010003) {
                    this.hTu.oa(0);
                    this.hTu.hTl.setVisibility(8);
                    this.hTu.hTm.setVisibility(0);
                    MallProductUI.d(this.hTu);
                } else {
                    this.hTu.xJ(str);
                }
            }
        });
        f fVar = this.hSJ;
        ak.vA().a(new com.tencent.mm.plugin.product.ui.f.AnonymousClass1(fVar, getIntent(), new m()));
        fVar.hRY = true;
        kk kkVar = new kk();
        kkVar.blz.errCode = -1;
        kkVar.bpT = new com.tencent.mm.plugin.product.ui.f.AnonymousClass2(fVar, kkVar);
        com.tencent.mm.sdk.c.a.nhr.a(kkVar, Looper.getMainLooper());
    }

    protected void onResume() {
        super.onResume();
        this.hSJ.onStart();
    }

    protected void onPause() {
        this.hSJ.onStop();
        super.onPause();
    }

    protected final void NI() {
        vD(2131233792);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MallProductUI hTu;

            {
                this.hTu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                f e = this.hTu.hSJ;
                if (!be.kS(e.hSa.hQe)) {
                    ak.vy().a(new f(e.hSa.aGm(), e.hSa.hQe), 0);
                }
                e.hSa.clear();
                this.hTu.finish();
                return true;
            }
        });
        this.hTl = (LinearLayout) findViewById(2131758645);
        this.hTm = (LinearLayout) findViewById(2131758656);
        this.hTn = (ImageView) findViewById(2131758646);
        this.gNg = (TextView) findViewById(2131758647);
        this.hSD = (TextView) findViewById(2131758648);
        this.hTo = (TextView) findViewById(2131758649);
        this.hTo.getPaint().setFlags(16);
        this.hTq = (RelativeLayout) findViewById(2131758653);
        this.hRG = (HtmlTextView) findViewById(2131758654);
        this.hTp = (HtmlTextView) findViewById(2131758651);
        this.hTi = (ListView) findViewById(2131758655);
        this.hTj = new a(this);
        this.hTi.setAdapter(this.hTj);
        this.hTi.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ MallProductUI hTu;

            {
                this.hTu = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b bVar = (b) view.getTag();
                switch (bVar.type) {
                    case 2:
                        m mVar = this.hTu.hSa.hQc;
                        if (mVar.hQG.hQV != null && mVar.hQG.hQV.size() > 0) {
                            ArrayList arrayList = new ArrayList();
                            Iterator it = mVar.hQG.hQV.iterator();
                            while (it.hasNext()) {
                                arrayList.add((String) it.next());
                            }
                            bVar.hRH = arrayList;
                            break;
                        }
                }
                this.hTu.hTj.a(this.hTu, view, i);
            }
        });
        this.hTt = (Button) findViewById(2131758650);
        this.hTt.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallProductUI hTu;

            {
                this.hTu = r1;
            }

            public final void onClick(View view) {
                f e = this.hTu.hSJ;
                e.M(e.gZX, e.hSa.aGf());
            }
        });
        this.hTr = (ListView) findViewById(2131758657);
        this.hTs = new k(this);
        this.hTs.hSM = new OnItemClickListener(this) {
            final /* synthetic */ MallProductUI hTu;

            {
                this.hTu = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                m mVar = (m) view.getTag();
                f e = this.hTu.hSJ;
                if (mVar != null && mVar.hSX != null) {
                    n.a aVar = mVar.hSX;
                    v.i("MicroMsg.MallProductUI", "goProductUI type : " + aVar.type);
                    Intent intent;
                    switch (aVar.type) {
                        case 0:
                            intent = new Intent();
                            intent.putExtra("rawUrl", aVar.url);
                            com.tencent.mm.ay.c.b(e.gZX, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                            return;
                        case 1:
                            String replace = aVar.data.replace("product_id=", "");
                            intent = new Intent();
                            intent.putExtra("key_product_id", replace);
                            intent.putExtra("key_product_scene", 6);
                            com.tencent.mm.ay.c.b(e.gZX, "mall", ".product.ui.MallProductUI", intent);
                            e.gZX.finish();
                            return;
                        default:
                            return;
                    }
                }
            }
        };
        this.hTr.setAdapter(this.hTs);
        this.fzj = (Button) findViewById(2131758652);
        this.fzj.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallProductUI hTu;

            {
                this.hTu = r1;
            }

            public final void onClick(View view) {
                f e = this.hTu.hSJ;
                if (e.hSa.aGj()) {
                    e.gZX.startActivity(new Intent(e.gZX, MallProductSelectSkuUI.class));
                    g.iuh.h(11008, new Object[]{e.hSa.aGf(), e.hSa.hQc.hQC, Integer.valueOf(f.cVh), Integer.valueOf(1)});
                    return;
                }
                s.makeText(e.gZX, 2131233761, 1).show();
            }
        });
        a(0, 2130838681, new OnMenuItemClickListener(this) {
            final /* synthetic */ MallProductUI hTu;

            {
                this.hTu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String[] stringArray = this.hTu.getResources().getStringArray(2131296265);
                List arrayList = new ArrayList();
                for (Object add : stringArray) {
                    arrayList.add(add);
                }
                boolean z = (this.hTu.hSa.aFZ().hRW & 1) > 0;
                v.d("MicroMsg.MallProductConfig", "isShowSellerEntry, ret = " + z);
                if (z) {
                    arrayList.add(this.hTu.getString(2131233774));
                }
                com.tencent.mm.ui.base.g.a(this.hTu.nDR.nEl, null, (String[]) arrayList.toArray(new String[arrayList.size()]), null, false, new com.tencent.mm.ui.base.g.c(this) {
                    final /* synthetic */ AnonymousClass7 hTw;

                    {
                        this.hTw = r1;
                    }

                    public final void gT(int i) {
                        f e;
                        String aGp;
                        Intent intent;
                        switch (i) {
                            case 0:
                                e = this.hTw.hTu.hSJ;
                                aGp = e.hSa.aGp();
                                intent = new Intent();
                                intent.putExtra("Retr_Msg_content", aGp);
                                intent.putExtra("Retr_Msg_Type", 2);
                                if (!be.kS(e.hSa.hQc.aGs())) {
                                    intent.putExtra("Retr_Msg_thumb_path", e.hSa.aGg());
                                }
                                intent.putExtra("Retr_go_to_chattingUI", false);
                                intent.putExtra("Retr_show_success_tips", true);
                                intent.putExtra("Retr_Msg_Type", 2);
                                com.tencent.mm.ay.c.a(e.gZX, ".ui.transmit.MsgRetransmitUI", intent);
                                return;
                            case 1:
                                e = this.hTw.hTu.hSJ;
                                m mVar = e.hSa.hQc;
                                intent = new Intent();
                                intent.putExtra("KContentObjDesc", e.hSa.aGq());
                                intent.putExtra("Ksnsupload_title", mVar.hQG.name);
                                intent.putExtra("Ksnsupload_link", e.hSa.aGh());
                                intent.putExtra("Ksnsupload_imgurl", e.hSa.hQc.aGs());
                                if (!be.kS(e.hSa.hQc.aGs())) {
                                    intent.putExtra("KsnsUpload_imgPath", e.hSa.aGg());
                                }
                                intent.putExtra("Ksnsupload_type", 6);
                                intent.putExtra("KUploadProduct_UserData", e.hSa.a(mVar));
                                intent.putExtra("KUploadProduct_subType", mVar.hQD);
                                aGp = o.fz("scan_product");
                                o.yx().n(aGp, true).l("prePublishId", "scan_product");
                                intent.putExtra("reportSessionId", aGp);
                                com.tencent.mm.ay.c.b(e.gZX, "sns", ".ui.SnsUploadUI", intent);
                                return;
                            case 2:
                                this.hTw.hTu.hSJ.aGw();
                                return;
                            case 3:
                                e = this.hTw.hTu.hSJ;
                                e.L(e.gZX, e.hSa.aGf());
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        });
        iU(false);
        this.hTn.setFocusable(true);
        this.hTn.setFocusableInTouchMode(true);
        this.hTn.requestFocus();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        v.v("MicroMsg.MallProductUI", "onNewIntent");
        setIntent(intent);
    }

    protected final void av() {
        m mVar = this.hSa.hQc;
        if (mVar == null) {
            iU(false);
            return;
        }
        iU(true);
        oa(0);
        this.hTl.setVisibility(0);
        this.hTm.setVisibility(8);
        if (mVar.hQG != null) {
            this.gNg.setText(mVar.hQG.name);
            this.hSD.setText(b.h(mVar.hQG.hQT, mVar.hQG.hQU, mVar.hQG.hNg));
            this.hTo.setText(b.c((double) mVar.hQG.hQS, mVar.hQG.hNg));
        }
        if (this.hSa.aGi() <= 0) {
            this.fzj.setEnabled(false);
            this.fzj.setText(2131233776);
        } else if (this.hSa.hQc.hQF <= 0) {
            this.fzj.setEnabled(false);
            this.fzj.setText(2131233775);
        } else {
            this.fzj.setEnabled(true);
            if (be.kS(mVar.hQL)) {
                this.fzj.setText(2131233763);
            } else {
                this.fzj.setText(mVar.hQL);
            }
        }
        if (mVar.hQG == null || mVar.hQG.hRd == null || mVar.hQG.hRd.size() <= 0) {
            this.hTi.setVisibility(8);
        } else {
            this.hTi.setVisibility(0);
            this.hTj.aV(mVar.hQG.hRd);
            this.hTj.notifyDataSetChanged();
        }
        if (mVar.hQG == null || be.kS(mVar.hQG.hQW)) {
            this.hTq.setVisibility(8);
            this.hRG.setVisibility(8);
        } else {
            this.hTq.setVisibility(0);
            this.hRG.setVisibility(0);
            this.hRG.setText(mVar.hQG.hQW);
        }
        if (be.kS(mVar.hQM)) {
            this.hTp.setVisibility(8);
        } else {
            this.hTp.setVisibility(0);
            this.hTp.setText(mVar.hQM);
        }
        iU(true);
        if (!be.kS(this.hSa.hQk)) {
            this.hTn.setImageBitmap(j.a(new c(this.hSa.hQk)));
            j.a(this);
        }
    }

    public final void k(String str, final Bitmap bitmap) {
        if (str != null && str.equals(this.hSa.hQk)) {
            this.hTn.post(new Runnable(this) {
                final /* synthetic */ MallProductUI hTu;

                public final void run() {
                    this.hTu.hTn.setImageBitmap(bitmap);
                }
            });
        }
    }
}
