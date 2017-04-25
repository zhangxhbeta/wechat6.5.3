package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import java.util.ArrayList;
import java.util.List;

public class SelectScanModePanel extends LinearLayout {
    private static int iCg = 85;
    private static int iCh = 85;
    private Context context;
    private final int iCi = 0;
    private int iCj = 0;
    protected List<SelectScanModeGrid> iCk;
    private int[] iCl = new int[]{2131234750, 2131234748, 2131234753, 2131234749};
    private int[] iCm = new int[]{2130839069, 2130839062, 2130839072, 2130839075};
    private int[] iCn = new int[]{2130839070, 2130839063, 2130839073, 2130839076};
    private int[] iCo = new int[]{1, 2, 5, 3};
    private OnItemClickListener iCp;
    private int iCq = 0;
    private boolean iCr = false;
    private int iCs;
    private int iCt;
    private MMFlipper iCu;
    private MMDotView iCv;
    a iCw;

    public interface a {
        void oY(int i);
    }

    static /* synthetic */ void c(SelectScanModePanel selectScanModePanel) {
        if (selectScanModePanel.iCp == null) {
            selectScanModePanel.iCp = new OnItemClickListener(selectScanModePanel) {
                final /* synthetic */ SelectScanModePanel iCx;

                {
                    this.iCx = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    boolean z = true;
                    if (adapterView == null || this.iCx.context == null) {
                        boolean z2;
                        String str = "MicroMsg.scanner.SelectScanModePanel";
                        StringBuilder stringBuilder = new StringBuilder("parent == null ? ");
                        if (adapterView == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        StringBuilder append = stringBuilder.append(z2).append(", context == null ? ");
                        if (this.iCx.context != null) {
                            z = false;
                        }
                        v.e(str, append.append(z).toString());
                        return;
                    }
                    b bVar = (b) adapterView.getAdapter().getItem(i);
                    if (bVar == null) {
                        v.e("MicroMsg.scanner.SelectScanModePanel", "clickItem == null");
                        return;
                    }
                    ((com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a) adapterView.getAdapter()).iBZ = i;
                    v.d("MicroMsg.scanner.SelectScanModePanel", "position=[%s], clickItem=[%s]", new Object[]{Integer.valueOf(i), this.iCx.context.getString(bVar.iCb)});
                    if (!(this.iCx.iCw == null || bVar == null)) {
                        this.iCx.iCw.oY(bVar.iCe);
                    }
                    this.iCx.oZ(bVar.iCe);
                }
            };
        }
        selectScanModePanel.iCk = new ArrayList();
        if (selectScanModePanel.iCs != 0 && selectScanModePanel.iCt != 0) {
            selectScanModePanel.iCu.removeAllViews();
            int a = BackwardSupportUtil.b.a(selectScanModePanel.context, 64.0f);
            int i = selectScanModePanel.iCs / a;
            a = selectScanModePanel.iCt / BackwardSupportUtil.b.a(selectScanModePanel.context, 78.0f);
            if (i == 0) {
                i = 1;
            } else if (i > selectScanModePanel.iCo.length) {
                i = selectScanModePanel.iCo.length;
            }
            if (a == 0) {
                a = 1;
            }
            int i2 = i * a;
            selectScanModePanel.iCq = 0;
            a = 5;
            while (a > 0) {
                a -= i2;
                selectScanModePanel.iCq++;
            }
            for (i = 0; i < selectScanModePanel.iCq; i++) {
                List arrayList = new ArrayList();
                int i3 = i * i2;
                a = i3;
                while (a < selectScanModePanel.iCl.length && a < i3 + i2) {
                    arrayList.add(new b(selectScanModePanel.iCl[a], selectScanModePanel.iCm[a], selectScanModePanel.iCn[a], selectScanModePanel.iCo[a]));
                    a++;
                }
                if (arrayList.size() > 0) {
                    SelectScanModeGrid selectScanModeGrid = (SelectScanModeGrid) inflate(selectScanModePanel.context, 2130904335, null);
                    selectScanModeGrid.setNumColumns(i2);
                    ListAdapter aVar = new com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a(selectScanModePanel.context, arrayList);
                    aVar.iBZ = selectScanModePanel.iCj;
                    selectScanModeGrid.setAdapter(aVar);
                    selectScanModePanel.iCu.addView(selectScanModeGrid, new LayoutParams(-1, -1));
                    selectScanModeGrid.setOnItemClickListener(selectScanModePanel.iCp);
                    selectScanModePanel.iCk.add(selectScanModeGrid);
                }
            }
            if (selectScanModePanel.iCk.size() <= 1) {
                selectScanModePanel.iCv.setVisibility(4);
                return;
            }
            selectScanModePanel.iCv.setVisibility(0);
            selectScanModePanel.iCv.wt(selectScanModePanel.iCk.size());
            a = selectScanModePanel.iCu.bBS();
            selectScanModePanel.iCu.wx(a);
            selectScanModePanel.iCv.wu(a);
        }
    }

    public SelectScanModePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        View.inflate(this.context, 2130904337, this);
        this.iCv = (MMDotView) findViewById(2131759053);
        v.v("MicroMsg.scanner.SelectScanModePanel", "AppPanel initFlipper");
        this.iCu = (MMFlipper) findViewById(2131759052);
        View findViewById = findViewById(2131759051);
        LayoutParams layoutParams;
        if (this.context.getResources().getConfiguration().orientation == 2) {
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = BackwardSupportUtil.b.a(this.context, (float) iCh);
            findViewById.setLayoutParams(layoutParams);
        } else {
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = BackwardSupportUtil.b.a(this.context, (float) iCg);
            findViewById.setLayoutParams(layoutParams);
        }
        this.iCu.removeAllViews();
        this.iCu.nUX = new com.tencent.mm.ui.base.MMFlipper.a(this) {
            final /* synthetic */ SelectScanModePanel iCx;

            {
                this.iCx = r1;
            }

            public final void ck(int i, int i2) {
                v.v("MicroMsg.scanner.SelectScanModePanel", "onMeasure width:" + i + " height:" + i2 + " isMeasured:" + this.iCx.iCr);
                if (!this.iCx.iCr && i2 != 0 && i != 0) {
                    this.iCx.iCr = true;
                    this.iCx.iCt = i2;
                    this.iCx.iCs = i;
                    SelectScanModePanel.c(this.iCx);
                }
            }
        };
        this.iCu.nUW = new MMFlipper.b(this) {
            final /* synthetic */ SelectScanModePanel iCx;

            {
                this.iCx = r1;
            }

            public final void pa(int i) {
                this.iCx.iCv.wu(i);
            }
        };
    }

    public final void oZ(int i) {
        for (int i2 = 0; i2 < this.iCo.length; i2++) {
            if (this.iCo[i2] == i) {
                this.iCj = i2;
            }
        }
        if (this.iCk != null) {
            for (int i3 = 0; i3 < this.iCk.size(); i3++) {
                com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a aVar = (com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a) ((SelectScanModeGrid) this.iCk.get(i3)).getAdapter();
                if (aVar != null) {
                    for (int i4 = 0; i4 < aVar.getCount(); i4++) {
                        b bVar = (b) aVar.getItem(i4);
                        if (!(bVar == null || bVar.iCf == null)) {
                            if (bVar.iCe == i) {
                                bVar.iCf.setBackgroundResource(bVar.iCd);
                                if (i3 > 0) {
                                    this.iCu.wx(i3);
                                    this.iCv.wu(i3);
                                }
                            } else {
                                bVar.iCf.setBackgroundResource(bVar.iCc);
                            }
                        }
                    }
                }
            }
        }
    }
}
