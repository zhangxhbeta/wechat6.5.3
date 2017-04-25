package com.tencent.mm.plugin.clean.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.clean.b.b;
import com.tencent.mm.plugin.clean.b.d;
import com.tencent.mm.plugin.clean.b.e;
import com.tencent.mm.plugin.clean.b.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.gridviewheaders.GridHeadersGridView;
import com.tencent.mm.ui.widget.MMAutoAdjustTextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CleanChattingDetailUI extends MMActivity implements g {
    private ProgressDialog dwR;
    private GridHeadersGridView eVB;
    private b eVC;
    private b eVD;
    MMAutoAdjustTextView eVE;
    private Button eVF;
    private e eVG;
    private View edu;
    CheckBox edw;
    private int index;

    static /* synthetic */ void b(CleanChattingDetailUI cleanChattingDetailUI) {
        if (d.adN() != null) {
            Object arrayList = new ArrayList();
            arrayList.addAll(cleanChattingDetailUI.eVC.edo);
            Collections.sort(arrayList);
            Collections.reverse(arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                arrayList2.add(cleanChattingDetailUI.eVD.eUn.get(intValue));
                cleanChattingDetailUI.eVD.eUn.remove(intValue);
            }
            if (!cleanChattingDetailUI.eVD.adF()) {
                d.Tu().remove(cleanChattingDetailUI.index);
                v.i("MicroMsg.CleanChattingDetailUI", "Delete username=%s", new Object[]{cleanChattingDetailUI.eVD.username});
            }
            cleanChattingDetailUI.eVC.adV();
            cleanChattingDetailUI.eVC.notifyDataSetChanged();
            if (cleanChattingDetailUI.eVG != null) {
                cleanChattingDetailUI.eVG.adU();
            }
            cleanChattingDetailUI.eVG = new e(d.adN(), cleanChattingDetailUI, arrayList2);
            cleanChattingDetailUI.eVG.start();
            cleanChattingDetailUI.dwR.show();
            cleanChattingDetailUI.dwR.setMessage(cleanChattingDetailUI.getString(2131231932, new Object[]{"0%"}));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.adS();
        this.index = getIntent().getIntExtra("key_position", -1);
        if (this.index < 0) {
            finish();
        } else if (d.Tu() == null) {
            finish();
        } else {
            this.edu = findViewById(2131755528);
            this.edw = (CheckBox) findViewById(2131755526);
            this.eVE = (MMAutoAdjustTextView) findViewById(2131756337);
            this.eVF = (Button) findViewById(2131756336);
            jx(0);
            this.eVD = (b) d.Tu().get(this.index);
            if (m.dE(this.eVD.username)) {
                Fd(l.D(this.eVD.username, this.eVD.username));
            } else {
                Fd(l.er(this.eVD.username));
            }
            this.eVB = (GridHeadersGridView) findViewById(2131756335);
            this.eVB.setNumColumns(3);
            this.eVC = new b(this, this.eVD.eUn);
            this.eVB.oWc = this.eVC.eVp;
            this.eVB.setOnItemClickListener(this.eVC.ezi);
            this.eVB.setOnScrollListener(this.eVC.eVr);
            this.eVB.setAdapter(this.eVC);
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ CleanChattingDetailUI eVH;

                {
                    this.eVH = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.eVH.finish();
                    return false;
                }
            });
            this.edu.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ CleanChattingDetailUI eVH;

                {
                    this.eVH = r1;
                }

                public final void onClick(View view) {
                    b a = this.eVH.eVC;
                    if (a.edo.size() == a.eVm.size()) {
                        a.edo.clear();
                    } else {
                        for (int i = 0; i < a.eVm.size(); i++) {
                            a.edo.add(Integer.valueOf(i));
                        }
                    }
                    a.adW();
                    this.eVH.eVC.notifyDataSetChanged();
                }
            });
            this.eVF.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ CleanChattingDetailUI eVH;

                {
                    this.eVH = r1;
                }

                public final void onClick(View view) {
                    com.tencent.mm.ui.base.g.b(this.eVH, this.eVH.getString(2131231972), "", this.eVH.getString(2131232277), this.eVH.getString(2131231565), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass3 eVI;

                        {
                            this.eVI = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            CleanChattingDetailUI.b(this.eVI.eVH);
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass3 eVI;

                        {
                            this.eVI = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
            });
            getString(2131231164);
            this.dwR = com.tencent.mm.ui.base.g.a(this, getString(2131231926), false, new OnCancelListener(this) {
                final /* synthetic */ CleanChattingDetailUI eVH;

                {
                    this.eVH = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            this.dwR.dismiss();
        }
    }

    protected final int getLayoutId() {
        return 2130903379;
    }

    public final void jx(int i) {
        this.eVF.setEnabled(i > 0);
    }

    protected void onDestroy() {
        if (this.dwR.isShowing()) {
            this.dwR.dismiss();
        }
        if (this.eVG != null) {
            this.eVG.adU();
        }
        d.adT();
        d.adR();
        super.onDestroy();
    }

    public final void bv(int i, int i2) {
        this.dwR.setMessage(getString(2131231932, new Object[]{((i * 100) / i2) + "%"}));
    }

    public final void aR(long j) {
        this.dwR.dismiss();
        d.aQ(d.adP() + j);
        d.aP(d.adO() - j);
        com.tencent.mm.ui.base.g.a(this, getString(2131231927, new Object[]{be.aw(j)}), "", new DialogInterface.OnClickListener(this) {
            final /* synthetic */ CleanChattingDetailUI eVH;

            {
                this.eVH = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (this.eVH.eVD.eUn.size() == 0) {
                    this.eVH.finish();
                }
            }
        });
    }
}
