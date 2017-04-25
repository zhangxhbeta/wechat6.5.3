package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.brandservice.a.h;
import com.tencent.mm.plugin.brandservice.a.i;
import com.tencent.mm.protocal.c.hy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.List;

public class BizSearchResultItemContainer extends LinearLayout implements e {
    private int cVh = 0;
    int exU;
    private ListView eyl;
    c eym;
    private TextView eyn;
    c eyo;
    private a eyp;
    i eyq;
    b eyr;
    private long[] eys;
    int eyt;
    private boolean eyu;
    int eyv;

    private static class a {
        View eyA;
        View eyy;
        View eyz;

        private a() {
        }

        public final void updateStatus(int i) {
            switch (i) {
                case 1:
                    i(true, false);
                    return;
                case 2:
                    i(false, true);
                    return;
                case 3:
                    i(false, false);
                    return;
                default:
                    i(false, false);
                    return;
            }
        }

        private void i(boolean z, boolean z2) {
            int i;
            int i2 = 0;
            View view = this.eyy;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view.setVisibility(i);
            this.eyz.setVisibility(8);
            View view2 = this.eyA;
            if (!z2) {
                i2 = 8;
            }
            view2.setVisibility(i2);
        }
    }

    public interface b {
        void Yr();

        void Ys();
    }

    private static class c {
        public String aXp;
        public long ext;
        public boolean eyB;
        public boolean eyC;
        public int eyf;
        public int offset;

        private c() {
            this.eyf = 1;
        }
    }

    static /* synthetic */ boolean a(BizSearchResultItemContainer bizSearchResultItemContainer) {
        return (!bizSearchResultItemContainer.eyo.eyC || bizSearchResultItemContainer.eyo.eyf == 0 || bizSearchResultItemContainer.eyo.eyB) ? false : true;
    }

    public BizSearchResultItemContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = View.inflate(getContext(), 2130904313, this);
        this.eyo = new c();
        this.eyp = new a();
        this.eyn = (TextView) inflate.findViewById(2131759011);
        this.eyl = (ListView) inflate.findViewById(2131759012);
    }

    public final void a(c cVar) {
        this.eym = cVar;
        if (this.eym != null) {
            this.eym.iI(this.cVh);
            ListView listView = this.eyl;
            a aVar = this.eyp;
            View inflate = View.inflate(getContext(), 2130903863, null);
            aVar.eyy = inflate.findViewById(2131757704);
            aVar.eyz = inflate.findViewById(2131755942);
            aVar.eyA = inflate.findViewById(2131757705);
            aVar.eyy.setVisibility(8);
            aVar.eyz.setVisibility(8);
            aVar.eyA.setVisibility(8);
            listView.addFooterView(inflate, null, false);
            this.eyl.setAdapter(this.eym);
            this.eyl.setOnScrollListener(new OnScrollListener(this) {
                boolean eyw = false;
                final /* synthetic */ BizSearchResultItemContainer eyx;

                {
                    this.eyx = r2;
                }

                public final void onScrollStateChanged(AbsListView absListView, int i) {
                    if (i == 0 && this.eyw && BizSearchResultItemContainer.a(this.eyx)) {
                        this.eyx.a(this.eyx.eyo.aXp, this.eyx.eyo.offset, this.eyx.eys[this.eyx.eys.length - 1]);
                    }
                }

                public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (i + i2 == i3) {
                        this.eyw = true;
                    } else {
                        this.eyw = false;
                    }
                }
            });
            this.eyl.setOnItemClickListener(this.eym);
            if (this.eyo.ext == 0) {
                d(1);
                return;
            }
            return;
        }
        this.eyl.setAdapter(this.eym);
    }

    private void a(String str, int i, long j) {
        hy hyVar = null;
        this.eyo.eyB = true;
        ak.vy().a(1071, this);
        a aM = this.eym.aM(this.eys[this.eys.length - 1]);
        List list = aM != null ? aM.eyk : null;
        if (list == null || list.size() == 0) {
            v.i("MicroMsg.BrandService.BizSearchResultItemContainer", "Get business content by type failed.(keyword : %s, offset : %s, businessType : %s)", new Object[]{str, Integer.valueOf(i), Long.valueOf(j)});
        } else {
            hyVar = (hy) list.get(list.size() - 1);
        }
        v.d("MicroMsg.BrandService.BizSearchResultItemContainer", "keyword(%s), offset(%d), businessType(%d), searchId(%s).", new Object[]{str, Integer.valueOf(i), Long.valueOf(j), hyVar != null ? hyVar.miU : ""});
        ak.vy().a(new h(str, j, i, this.cVh, r6), 0);
        this.eyp.updateStatus(1);
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 3;
        v.i("MicroMsg.BrandService.BizSearchResultItemContainer", "errType (%d) , errCode (%d) , errMsg (errMsg)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.eyr != null) {
            this.eyr.Ys();
        }
        if (i == 0 && i2 == 0) {
            this.eyu = false;
            if (kVar == null) {
                v.e("MicroMsg.BrandService.BizSearchResultItemContainer", "scene is null.");
                return;
            }
            int i4;
            int i5;
            if (kVar.getType() == 1070) {
                v.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchHomePage.");
                ak.vy().b(1070, this);
                i iVar = (i) kVar;
                List list = iVar.exu == null ? null : iVar.exu.mQS;
                this.eym.c(this.eyo.aXp, list);
                a aM = this.eym.aM(this.eys[this.eys.length - 1]);
                i5 = (aM == null || aM.eyj) ? 0 : aM.eyf;
                if (i5 != 0) {
                    i3 = 2;
                }
                if (list != null && list.size() > 0) {
                    hy hyVar = (hy) list.get(list.size() - 1);
                    if (hyVar != null) {
                        this.eyo.offset = hyVar.mfb + this.eyt;
                    }
                }
                i4 = i3;
                i3 = i5;
            } else if (kVar.getType() == 1071) {
                ak.vy().b(1071, this);
                v.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchDetailPage.");
                hy Ym = ((h) kVar).Ym();
                if (Ym == null || Ym.miT == null) {
                    v.e("MicroMsg.BrandService.BizSearchResultItemContainer", "BusinessContent or itemList is null.");
                }
                i5 = Ym == null ? 0 : Ym.miR;
                if (i5 == 0) {
                    i4 = 3;
                } else {
                    i4 = 2;
                }
                this.eym.a(Ym, true);
                if (Ym != null) {
                    v.d("MicroMsg.BrandService.BizSearchResultItemContainer", "searchId : %s.", new Object[]{Ym.miU});
                    this.eyo.offset = Ym.mfb + this.eyt;
                }
                i3 = i5;
            } else {
                v.e("MicroMsg.BrandService.BizSearchResultItemContainer", "Error type(%d).", new Object[]{Integer.valueOf(kVar.getType())});
                return;
            }
            if (this.eym.isEmpty()) {
                new ac(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ BizSearchResultItemContainer eyx;

                    {
                        this.eyx = r1;
                    }

                    public final void run() {
                        this.eyx.eyn.setVisibility(this.eyx.eym.isEmpty() ? 0 : 8);
                    }
                });
            } else {
                this.eyo.eyC = true;
            }
            this.eyo.eyf = i3;
            this.eyp.updateStatus(i4);
            this.eyo.eyB = false;
            v.v("MicroMsg.BrandService.BizSearchResultItemContainer", "The next load data offset is (%d).", new Object[]{Integer.valueOf(this.eyo.offset)});
            return;
        }
        this.eyo.eyB = false;
        this.eyu = true;
        Toast.makeText(getContext(), getContext().getString(2131232920, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
    }

    final void reset() {
        this.eym.Yq();
        this.eyp.updateStatus(0);
        this.eyo.eyC = false;
        this.eyo.eyB = false;
        this.eyo.offset = 0;
        this.eyo.aXp = null;
        this.eyo.eyf = 1;
    }

    public final void d(long... jArr) {
        this.eys = jArr;
        this.eyo.ext = 0;
        for (int i = 0; i <= 0; i++) {
            c cVar = this.eyo;
            cVar.ext |= jArr[0];
        }
        this.eym.c(jArr);
    }

    public final void ai(String str, int i) {
        if (this.eym.isEmpty()) {
            this.eyn.setVisibility(8);
        }
        if (str != null) {
            String trim = str.trim();
            if (!"".equals(trim)) {
                if ((!trim.equals(this.eyo.aXp) || this.eyu) && !this.eyo.eyB) {
                    reset();
                    this.eyo.eyB = true;
                    this.eyo.aXp = trim;
                    this.eyt = i;
                    if (this.eyv != 1) {
                        ak.vy().a(1070, this);
                        this.eyq = new i(this.eyo.aXp, this.eyo.ext, this.cVh);
                        ak.vy().a(this.eyq, 0);
                    } else if (this.eys.length == 0) {
                        v.i("MicroMsg.BrandService.BizSearchResultItemContainer", "business type size is 0.");
                        return;
                    } else {
                        a(trim, i, this.eys[0]);
                        this.eyp.updateStatus(0);
                    }
                    if (this.eyr != null) {
                        this.eyr.Yr();
                    }
                }
            }
        }
    }

    public final void iI(int i) {
        this.cVh = i;
        this.eym.iI(this.cVh);
    }

    public final void cd(boolean z) {
        this.eym.h(z, false);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
        this.eyl.setOnTouchListener(onTouchListener);
    }
}
