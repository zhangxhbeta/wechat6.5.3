package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.Preference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class h extends Preference {
    List<com.tencent.mm.plugin.scanner.a.a.a> hRB = null;
    private Context mContext = null;
    private View mView = null;

    private static final class a implements i {
        private String mPicUrl = null;

        public a(String str) {
            this.mPicUrl = str;
        }

        public final String MU() {
            return com.tencent.mm.plugin.scanner.b.aKP().cr(this.mPicUrl, "@S");
        }

        public final String MV() {
            return this.mPicUrl;
        }

        public final String MW() {
            return this.mPicUrl;
        }

        public final String MX() {
            return this.mPicUrl;
        }

        public final boolean MY() {
            return false;
        }

        public final boolean MZ() {
            return false;
        }

        public final Bitmap a(Bitmap bitmap, com.tencent.mm.platformtools.i.a aVar) {
            if (com.tencent.mm.platformtools.i.a.doT == aVar) {
                try {
                    d.a(bitmap, 100, CompressFormat.PNG, MU(), false);
                } catch (Throwable e) {
                    v.a("MicroMsg.ProductGridPreference", e, "", new Object[0]);
                }
            }
            return bitmap;
        }

        public final void Nb() {
        }

        public final void H(String str, boolean z) {
        }

        public final void a(com.tencent.mm.platformtools.i.a aVar, String str) {
        }

        public final Bitmap Na() {
            if (aa.getContext() == null) {
                return null;
            }
            return BitmapFactory.decodeResource(aa.getContext().getResources(), 2130838791);
        }
    }

    final class b extends BaseAdapter implements com.tencent.mm.platformtools.j.a {
        private LayoutInflater CE = null;
        Map<String, WeakReference<ImageView>> iza = new HashMap();
        private int izd;
        List<com.tencent.mm.plugin.scanner.a.a.a> ize = new ArrayList();
        final /* synthetic */ h izf;

        class a {
            TextView gNg;
            ImageView ixg;
            final /* synthetic */ b izh;

            a(b bVar) {
                this.izh = bVar;
            }
        }

        public b(h hVar) {
            this.izf = hVar;
            this.CE = LayoutInflater.from(hVar.mContext);
            j.a(this);
            this.izd = hVar.mContext.getResources().getColor(2131689780);
        }

        public final int getCount() {
            return this.ize.size();
        }

        public final Object getItem(int i) {
            return this.ize.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = this.CE.inflate(2130904180, viewGroup, false);
                aVar = new a(this);
                aVar.ixg = (ImageView) view.findViewById(2131758590);
                aVar.gNg = (TextView) view.findViewById(2131758591);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            final com.tencent.mm.plugin.scanner.a.a.a aVar2 = (com.tencent.mm.plugin.scanner.a.a.a) this.ize.get(i);
            Bitmap a = j.a(new a(aVar2.iconUrl));
            if (a == null || a.isRecycled()) {
                aVar.ixg.setBackgroundColor(this.izd);
                aVar.ixg.setImageBitmap(null);
            } else {
                aVar.ixg.setImageBitmap(a);
                aVar.ixg.setBackgroundColor(0);
            }
            final String str = aVar2.ivO;
            aVar.ixg.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ b izh;

                public final void onClick(View view) {
                    ak.vy().a(new com.tencent.mm.plugin.scanner.a.h(str, aVar2.ivN, aVar2.type, str, this.izh.getCount(), aVar2.aXx), 0);
                    if (!be.kS(str)) {
                        Intent intent = new Intent();
                        intent.putExtra("key_Product_ID", str);
                        c.b(this.izh.izf.mContext, "scanner", ".ui.ProductUI", intent);
                    }
                }
            });
            aVar.ixg.setTag(aVar2.iconUrl);
            this.iza.put(aVar2.iconUrl, new WeakReference(aVar.ixg));
            aVar.gNg.setText(aVar2.name);
            return view;
        }

        public final void k(String str, final Bitmap bitmap) {
            if (bitmap != null && !bitmap.isRecycled() && !be.kS(str)) {
                v.v("MicroMsg.ProductGridPreference", "On get pic, notifyKey=" + str);
                if (((WeakReference) this.iza.get(str)) != null) {
                    final ImageView imageView = (ImageView) ((WeakReference) this.iza.get(str)).get();
                    if (imageView != null && str.equals((String) imageView.getTag())) {
                        ad.o(new Runnable(this) {
                            final /* synthetic */ b izh;

                            public final void run() {
                                imageView.setImageBitmap(bitmap);
                                imageView.setBackgroundColor(0);
                            }
                        });
                    }
                }
            }
        }
    }

    public h(Context context) {
        super(context);
        this.mContext = context;
        setLayoutResource(2130904179);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        GridView gridView = (GridView) this.mView.findViewById(2131758589);
        b bVar = new b(this);
        gridView.setAdapter(bVar);
        if (this.hRB != null) {
            List list = this.hRB;
            bVar.iza.clear();
            bVar.ize.clear();
            bVar.ize = list;
            bVar.notifyDataSetChanged();
        }
    }
}
