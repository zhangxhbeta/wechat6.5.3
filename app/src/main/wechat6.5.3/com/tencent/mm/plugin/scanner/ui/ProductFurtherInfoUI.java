package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.t;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.ay.c;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.scanner.a.i;
import com.tencent.mm.plugin.scanner.b.n.a.a.b;
import com.tencent.mm.plugin.scanner.b.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.d;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductFurtherInfoUI extends MMPreference {
    protected f ezq;
    private MMPageControlView iyU;
    private com.tencent.mm.plugin.scanner.b.n.a.a iyV;
    private String iyW;
    private ViewPager wO;

    class a extends t implements com.tencent.mm.platformtools.j.a {
        final /* synthetic */ ProductFurtherInfoUI iyX;
        List<String> iyZ = new ArrayList();
        private Map<String, ImageView> iza = new HashMap();
        private int izb;
        private Context mContext;

        public a(ProductFurtherInfoUI productFurtherInfoUI, Context context) {
            this.iyX = productFurtherInfoUI;
            this.mContext = context;
            j.a(this);
            this.izb = this.mContext.getResources().getColor(2131689793);
        }

        private ImageView yR(String str) {
            if (this.iza.containsKey(str)) {
                return (ImageView) this.iza.get(str);
            }
            ImageView imageView = new ImageView(this.mContext);
            imageView.setScaleType(ScaleType.FIT_XY);
            imageView.setLayoutParams(new LayoutParams(-1, -1));
            this.iza.put(str, imageView);
            return imageView;
        }

        public final Object b(ViewGroup viewGroup, int i) {
            String str = (String) this.iyZ.get(i);
            View yR = yR(str);
            Bitmap a = j.a(new o(str));
            if (a == null || a.isRecycled()) {
                yR.setImageBitmap(null);
                yR.setBackgroundColor(this.izb);
            } else {
                yR.setImageBitmap(a);
                yR.setBackgroundColor(0);
            }
            try {
                viewGroup.addView(yR);
            } catch (Exception e) {
                v.e("MicroMsg.ProductFurtherInfoUI", "Add view failed: " + e.getMessage());
            }
            return yR;
        }

        public final void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((ImageView) obj);
            String str = (String) this.iyZ.get(i);
            if (this.iza.containsKey(str)) {
                this.iza.remove(str);
            }
        }

        public final int getCount() {
            return this.iyZ.size();
        }

        public final boolean a(View view, Object obj) {
            return view == obj;
        }

        public final void k(String str, final Bitmap bitmap) {
            if (bitmap != null && !bitmap.isRecycled() && !be.kS(str)) {
                final ImageView yR = yR(str);
                if (yR != null) {
                    ad.o(new Runnable(this) {
                        final /* synthetic */ a izc;

                        public final void run() {
                            yR.setImageBitmap(bitmap);
                            yR.setBackgroundColor(0);
                        }
                    });
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.plugin.scanner.b.n.a aN = i.aN(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
        if (aN == null || aN.iEe == null) {
            v.e("MicroMsg.ProductFurtherInfoUI", "initView(), product or product field detail null -> finish");
            finish();
            return;
        }
        this.iyV = aN.iEe;
        this.iyW = aN.field_feedbackurl;
        NI();
    }

    protected final void NI() {
        int i = 0;
        Fd(getIntent().getStringExtra("key_title"));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ProductFurtherInfoUI iyX;

            {
                this.iyX = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iyX.finish();
                return false;
            }
        });
        a(0, 2130838681, new OnMenuItemClickListener(this) {
            final /* synthetic */ ProductFurtherInfoUI iyX;

            {
                this.iyX = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                List linkedList = new LinkedList();
                List linkedList2 = new LinkedList();
                linkedList.add(this.iyX.getString(2131234782));
                linkedList2.add(Integer.valueOf(0));
                g.a(this.iyX.nDR.nEl, "", linkedList, linkedList2, "", false, new d(this) {
                    final /* synthetic */ AnonymousClass2 iyY;

                    {
                        this.iyY = r1;
                    }

                    public final void bw(int i, int i2) {
                        switch (i2) {
                            case 0:
                                if (!be.kS(this.iyY.iyX.iyW)) {
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", this.iyY.iyX.iyW);
                                    c.b(this.iyY.iyX.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        });
        this.ezq = this.ocZ;
        List arrayList = new ArrayList();
        Iterator it = this.iyV.iEf.iterator();
        while (it.hasNext()) {
            arrayList.add(((com.tencent.mm.plugin.scanner.b.n.a.a.a) it.next()).cZp);
        }
        this.wO = (ViewPager) findViewById(2131758015);
        this.iyU = (MMPageControlView) findViewById(2131755410);
        this.iyU.nWL = 2130904144;
        this.iyU.setVisibility(0);
        this.wO.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ ProductFurtherInfoUI iyX;

            {
                this.iyX = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!(view == null || view.getParent() == null)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                }
                return false;
            }
        });
        this.wO.yk = new e(this) {
            final /* synthetic */ ProductFurtherInfoUI iyX;

            {
                this.iyX = r1;
            }

            public final void a(int i, float f, int i2) {
            }

            public final void W(int i) {
                if (this.iyX.wO.getParent() != null) {
                    this.iyX.wO.getParent().requestDisallowInterceptTouchEvent(true);
                }
                this.iyX.iyU.qw(i);
            }

            public final void X(int i) {
            }
        };
        a aVar = new a(this, this);
        this.wO.a(aVar);
        if (arrayList.size() > 0) {
            aVar.iyZ = arrayList;
            aVar.iyX.iyU.dh(arrayList.size(), 0);
            aVar.notifyDataSetChanged();
            this.wO.setVisibility(0);
        }
        while (i < this.iyV.iEg.size()) {
            b bVar = (b) this.iyV.iEg.get(i);
            Preference preference = new Preference(this);
            preference.setKey(String.valueOf(i));
            preference.setLayoutResource(2130904097);
            preference.setTitle(bVar.title);
            preference.setSummary(bVar.desc);
            this.ezq.a(preference);
            i++;
        }
        this.ezq.notifyDataSetChanged();
    }

    public final int Oo() {
        return 2131099707;
    }

    protected final int getLayoutId() {
        return 2130904176;
    }

    public final int YA() {
        return 2130904177;
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }
}
