package com.tencent.mm.plugin.brandservice.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.plugin.brandservice.a.g;
import com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.List;

public class SearchOrRecommendBizUI extends MMActivity implements b {
    private BizSearchResultItemContainer exQ;
    private int exT = 0;
    private int exw = 0;
    private ProgressDialog ezA = null;
    private SearchViewNotRealTimeHelper ezB;

    protected final int getLayoutId() {
        return 2130903428;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.exw = getIntent().getIntExtra("intent_extra_entry_flag", 0);
        this.exT = getIntent().getIntExtra("fromScene", 0);
        NI();
        if (g.Yk()) {
            ak.vy().a(456, new e(this) {
                final /* synthetic */ SearchOrRecommendBizUI ezC;

                {
                    this.ezC = r1;
                }

                public final void a(int i, int i2, String str, k kVar) {
                    if (kVar == null) {
                        v.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "NetScene is null.");
                    } else if (kVar.getType() != 456) {
                        v.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "The NetScene is not a RecommendGroupNetScene.");
                    } else {
                        ak.vy().b(456, this);
                        v.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "errType(%d) , errCode(%d) , errMsg(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                        if (i == 0 && i2 == 0) {
                            List Yl = g.Yl();
                            final f fVar = this.ezC.exQ == null ? null : (f) this.ezC.exQ.eym;
                            if (fVar != null && Yl != null && Yl.size() > 0) {
                                int i3;
                                if (fVar.getCount() == 0) {
                                    i3 = 1;
                                } else {
                                    i3 = 0;
                                }
                                fVar.ezw = Yl;
                                if (i3 != 0) {
                                    ad.o(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass1 ezE;

                                        public final void run() {
                                            v.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "Has got recommend groups, so notifyDataSetChanged.");
                                            fVar.notifyDataSetChanged();
                                        }
                                    });
                                }
                            }
                        }
                    }
                }
            });
            ak.vy().a(new g(), 0);
        }
        final String stringExtra = getIntent().getStringExtra("Search_Str");
        if (!be.kS(stringExtra)) {
            new ac(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ SearchOrRecommendBizUI ezC;

                public final void run() {
                    this.ezC.ezB.Pw(stringExtra);
                    this.ezC.ezB.oUE.performClick();
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        u.DG().Ds();
    }

    protected final void NI() {
        vD(2131232215);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SearchOrRecommendBizUI ezC;

            {
                this.ezC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ezC.axg();
                this.ezC.finish();
                return true;
            }
        });
        this.ezB = (SearchViewNotRealTimeHelper) findViewById(2131756534);
        SearchViewNotRealTimeHelper searchViewNotRealTimeHelper = this.ezB;
        searchViewNotRealTimeHelper.ocq.setTextColor(getResources().getColor(2131689909));
        this.ezB.L(getString(2131232215));
        searchViewNotRealTimeHelper = this.ezB;
        searchViewNotRealTimeHelper.ocq.setHintTextColor(getResources().getColor(2131689789));
        this.ezB.ocq.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        searchViewNotRealTimeHelper = this.ezB;
        if (searchViewNotRealTimeHelper.oQr != null) {
            searchViewNotRealTimeHelper.oQr.setVisibility(8);
        }
        this.ezB.oUF = new a(this) {
            final /* synthetic */ SearchOrRecommendBizUI ezC;

            {
                this.ezC = r1;
            }

            public final boolean mk(String str) {
                pA(str);
                return true;
            }

            public final void pA(String str) {
                if (be.kS(str)) {
                    com.tencent.mm.ui.base.g.bf(this.ezC.nDR.nEl, this.ezC.getString(2131232212));
                    return;
                }
                this.ezC.axg();
                this.ezC.exQ.ai(str, 0);
            }

            public final void YC() {
                this.ezC.aJs();
            }

            public final void YD() {
            }
        };
        this.exQ = (BizSearchResultItemContainer) findViewById(2131755638);
        this.exQ.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SearchOrRecommendBizUI ezC;

            {
                this.ezC = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.ezC.ezB.clearFocus();
                this.ezC.axg();
                return false;
            }
        });
        c fVar = new f(this);
        fVar.ezw = g.Yl();
        this.exQ.a(fVar);
        this.exQ.d(1);
        this.exQ.cd(false);
        this.exQ.eyv = 1;
        this.exQ.iI(this.exT);
        this.exQ.eyr = this;
    }

    public final void Yr() {
        ActionBarActivity actionBarActivity = this.nDR.nEl;
        getString(2131231164);
        this.ezA = com.tencent.mm.ui.base.g.a(actionBarActivity, getString(2131232213), true, new OnCancelListener(this) {
            final /* synthetic */ SearchOrRecommendBizUI ezC;

            {
                this.ezC = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                BizSearchResultItemContainer a = this.ezC.exQ;
                ak.vy().c(a.eyq);
                a.eyo.eyB = false;
            }
        });
    }

    public final void Ys() {
        if (this.ezA != null) {
            this.ezA.dismiss();
            this.ezA = null;
        }
    }
}
