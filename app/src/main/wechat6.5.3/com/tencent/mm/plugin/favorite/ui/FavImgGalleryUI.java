package com.tencent.mm.plugin.favorite.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.b.v;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.base.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class FavImgGalleryUI extends MMActivity implements OnItemSelectedListener, com.tencent.mm.plugin.favorite.b.b.a {
    private MMGestureGallery eIS;
    private l eIV;
    private ArrayList<d> eVm;
    private a fNA;
    private n.d fNB = new n.d(this) {
        final /* synthetic */ FavImgGalleryUI fNC;

        {
            this.fNC = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            String f = v.f(this.fNC.fNA.kH(this.fNC.fNz).bdE);
            if (e.aR(f)) {
                switch (menuItem.getItemId()) {
                    case 0:
                        if (o.JZ(f)) {
                            Intent intent = new Intent();
                            intent.putExtra("Select_Conv_Type", 3);
                            intent.putExtra("select_is_ret", true);
                            c.a(this.fNC, ".ui.transmit.SelectConversationUI", intent, 1);
                            return;
                        }
                        com.tencent.mm.plugin.favorite.c.e(f, this.fNC);
                        g.iuh.h(10651, new Object[]{Integer.valueOf(r0.fPW.field_type), Integer.valueOf(1)});
                        return;
                    case 1:
                        com.tencent.mm.plugin.favorite.c.d(f, this.fNC);
                        g.iuh.h(10651, new Object[]{Integer.valueOf(r0.fPW.field_type), Integer.valueOf(0)});
                        return;
                    case 2:
                        com.tencent.mm.plugin.favorite.c.a(f, this.fNC.getString(2131232725), this.fNC);
                        return;
                    default:
                        return;
                }
            }
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavoriteImgDetailUI", "file not exists");
        }
    };
    private int fNz = 0;

    private class a extends BaseAdapter {
        final /* synthetic */ FavImgGalleryUI fNC;
        SparseBooleanArray fNH;

        private a(FavImgGalleryUI favImgGalleryUI) {
            this.fNC = favImgGalleryUI;
            this.fNH = new SparseBooleanArray();
        }

        public final /* synthetic */ Object getItem(int i) {
            return kH(i);
        }

        public final int getCount() {
            return this.fNC.eVm.size();
        }

        public final d kH(int i) {
            if (i < this.fNC.eVm.size()) {
                return (d) this.fNC.eVm.get(i);
            }
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavoriteImgDetailUI", "get item fail, position %d error", new Object[]{Integer.valueOf(i)});
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                b bVar2 = new b();
                view = View.inflate(this.fNC.nDR.nEl, 2130903597, null);
                bVar2.fNI = view.findViewById(2131755053);
                bVar2.fNJ = (MultiTouchImageView) view.findViewById(2131755052);
                bVar2.elJ = (ProgressBar) view.findViewById(2131756219);
                bVar2.fNK = (ImageView) view.findViewById(2131755457);
                bVar2.fNL = (TextView) view.findViewById(2131756941);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            view.setLayoutParams(new LayoutParams(-1, -1));
            d kH = kH(i);
            boolean z = this.fNH.get(i, true);
            this.fNH.put(i, false);
            Bitmap a = com.tencent.mm.plugin.favorite.c.g.a(kH.bdE, kH.fPW, z);
            if (kH.fPW != null) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteImgDetailUI", "index %d item favid %d, localid %d, itemStatus %d", new Object[]{Integer.valueOf(i), Integer.valueOf(kH.fPW.field_id), Long.valueOf(kH.fPW.field_localId), Integer.valueOf(kH.fPW.field_itemStatus)});
            }
            if (kH.bdE != null) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteImgDetailUI", "item dataId %s, item data url %s, key %s, fullsize %d, thumb url %s, key %s, thumb size %d", new Object[]{kH.bdE.luu, kH.bdE.mrS, kH.bdE.mrU, Long.valueOf(kH.bdE.msn), kH.bdE.coj, kH.bdE.mrO, Long.valueOf(kH.bdE.msy)});
            }
            if (a == null) {
                this.fNC.iT(false);
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavoriteImgDetailUI", "get big image fail");
                com.tencent.mm.plugin.favorite.b.a sL = h.alp().sL(kH.bdE != null ? kH.bdE.luu : "");
                if (sL == null) {
                    bVar.elJ.setVisibility(8);
                    bVar.fNL.setVisibility(8);
                    bVar.fNK.setVisibility(8);
                    bVar.fNI.setVisibility(0);
                    b(bVar, a(kH), "");
                } else {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteImgDetailUI", "fav cdnInfo status %d", new Object[]{Integer.valueOf(sL.field_status)});
                    bVar.elJ.setVisibility(0);
                    bVar.fNL.setVisibility(0);
                    bVar.fNK.setVisibility(0);
                    bVar.fNI.setVisibility(8);
                    bVar.fNK.setImageBitmap(a(kH));
                    int i2 = sL.field_totalLen > 0 ? ((sL.field_offset * 100) / sL.field_totalLen) - 1 : 0;
                    if (i2 < 0) {
                        i2 = 0;
                    }
                    bVar.elJ.setProgress(i2);
                    bVar.fNL.setText(this.fNC.getString(2131232891, new Object[]{Integer.valueOf(i2)}));
                }
            } else {
                this.fNC.iT(true);
                if (o.JZ(v.f(kH.bdE))) {
                    a(bVar, a, v.f(kH.bdE));
                } else {
                    a(bVar, a, "");
                }
            }
            return view;
        }

        private void a(b bVar, Bitmap bitmap, String str) {
            bVar.elJ.setVisibility(8);
            bVar.fNL.setVisibility(8);
            bVar.fNK.setVisibility(8);
            bVar.fNI.setVisibility(0);
            b(bVar, bitmap, str);
        }

        private Bitmap a(d dVar) {
            if (dVar != null) {
                Bitmap a = com.tencent.mm.plugin.favorite.c.g.a(dVar.bdE, dVar.fPW);
                if (a != null) {
                    return a;
                }
            }
            return com.tencent.mm.compatible.f.a.decodeResource(this.fNC.getResources(), 2131165477);
        }

        private void b(b bVar, Bitmap bitmap, String str) {
            k.h(bVar.fNJ, bitmap.getWidth(), bitmap.getHeight());
            int width = bVar.fNJ.getWidth();
            int height = bVar.fNJ.getHeight();
            Matrix matrix = new Matrix();
            matrix.reset();
            float width2 = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
            float height2 = ((float) bitmap.getHeight()) / ((float) bitmap.getWidth());
            com.tencent.mm.sdk.platformtools.v.v("MicroMsg.FavoriteImgDetailUI", "whDiv is " + width2 + " hwDiv is " + height2);
            if (height2 >= 2.0f && bitmap.getHeight() >= 480) {
                height2 = ((float) width) / ((float) bitmap.getWidth());
                if (((double) (((float) bitmap.getWidth()) / ((float) width))) > 1.0d) {
                    matrix.postScale(height2, height2);
                    bitmap.getHeight();
                    matrix.postTranslate((((float) width) - (height2 * ((float) bitmap.getWidth()))) / 2.0f, 0.0f);
                } else {
                    matrix.postScale(1.0f, 1.0f);
                    matrix.postTranslate((float) ((width - bitmap.getWidth()) / 2), 0.0f);
                }
            } else if (width2 < 2.0f || bitmap.getWidth() < 480) {
                width2 = ((float) width) / ((float) bitmap.getWidth());
                height2 = ((float) height) / ((float) bitmap.getHeight());
                if (width2 >= height2) {
                    width2 = height2;
                }
                height2 = ((float) bitmap.getWidth()) / ((float) width);
                float height3 = ((float) bitmap.getHeight()) / ((float) height);
                if (height2 <= height3) {
                    height2 = height3;
                }
                if (((double) height2) > 1.0d) {
                    matrix.postScale(width2, width2);
                } else {
                    width2 = 1.0f;
                }
                matrix.postTranslate((((float) width) - (((float) bitmap.getWidth()) * width2)) / 2.0f, (((float) height) - (width2 * ((float) bitmap.getHeight()))) / 2.0f);
            } else {
                width2 = ((float) bitmap.getHeight()) / 480.0f;
                height2 = 480.0f / ((float) bitmap.getHeight());
                if (((double) width2) > 1.0d) {
                    matrix.postScale(width2, height2);
                    matrix.postTranslate(0.0f, (float) ((height - 480) / 2));
                } else {
                    matrix.postScale(1.0f, 1.0f);
                    width2 = (float) ((height - bitmap.getHeight()) / 2);
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteImgDetailUI", " offsety " + width2);
                    matrix.postTranslate(0.0f, width2);
                }
            }
            bVar.fNJ.setImageMatrix(matrix);
            bVar.fNJ.di(bitmap.getWidth(), bitmap.getHeight());
            bVar.fNJ.oad = true;
            if (be.kS(str)) {
                bVar.fNJ.setImageBitmap(bitmap);
                return;
            }
            try {
                com.tencent.mm.plugin.gif.a aVar = new com.tencent.mm.plugin.gif.a(str);
                MultiTouchImageView multiTouchImageView = bVar.fNJ;
                multiTouchImageView.oak = true;
                multiTouchImageView.oal = aVar;
                multiTouchImageView.setImageDrawable(multiTouchImageView.oal);
                multiTouchImageView = bVar.fNJ;
                int dv = com.tencent.mm.bd.a.dv(this.fNC.nDR.nEl);
                multiTouchImageView.fEU = com.tencent.mm.bd.a.dw(this.fNC.nDR.nEl);
                multiTouchImageView.fET = dv;
                bVar.fNJ.di(aVar.getIntrinsicWidth(), aVar.getIntrinsicHeight());
                MultiTouchImageView multiTouchImageView2 = bVar.fNJ;
                if (multiTouchImageView2.oak && multiTouchImageView2.oal != null) {
                    multiTouchImageView2.oal.start();
                }
                bVar.fNJ.bCR();
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.FavoriteImgDetailUI", be.e(e));
                bVar.fNJ.setImageBitmap(bitmap);
            }
        }
    }

    private class b {
        ProgressBar elJ;
        final /* synthetic */ FavImgGalleryUI fNC;
        View fNI;
        MultiTouchImageView fNJ;
        ImageView fNK;
        TextView fNL;

        private b(FavImgGalleryUI favImgGalleryUI) {
            this.fNC = favImgGalleryUI;
        }
    }

    static /* synthetic */ void b(FavImgGalleryUI favImgGalleryUI) {
        final List arrayList = new ArrayList();
        final List arrayList2 = new ArrayList();
        d kH = favImgGalleryUI.fNA.kH(favImgGalleryUI.fNz);
        if (kH.fPW != null && kH.fPW.aly()) {
            arrayList.add(Integer.valueOf(0));
            arrayList2.add(favImgGalleryUI.getString(2131232731));
        }
        if (kH.fPW != null && kH.fPW.alz()) {
            arrayList.add(Integer.valueOf(1));
            arrayList2.add(favImgGalleryUI.getString(2131232704));
        }
        arrayList.add(Integer.valueOf(2));
        arrayList2.add(favImgGalleryUI.getString(2131232726));
        if (favImgGalleryUI.eIV == null) {
            favImgGalleryUI.eIV = new l(favImgGalleryUI.nDR.nEl);
        }
        favImgGalleryUI.eIV.jXn = new n.c(favImgGalleryUI) {
            final /* synthetic */ FavImgGalleryUI fNC;

            public final void a(com.tencent.mm.ui.base.l lVar) {
                lVar.setHeaderTitle("");
                for (int i = 0; i < arrayList.size(); i++) {
                    lVar.d(((Integer) arrayList.get(i)).intValue(), (CharSequence) arrayList2.get(i));
                }
            }
        };
        favImgGalleryUI.eIV.jXo = favImgGalleryUI.fNB;
        favImgGalleryUI.eIV.d(new OnCancelListener(favImgGalleryUI) {
            final /* synthetic */ FavImgGalleryUI fNC;

            {
                this.fNC = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.fNC.eIV = null;
            }
        });
        com.tencent.mm.ui.base.g.a(favImgGalleryUI.nDR.nEl, favImgGalleryUI.eIV.aXZ());
    }

    protected final int getLayoutId() {
        return 2130903598;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(1024, 1024);
        }
        this.eIS = (MMGestureGallery) findViewById(2131755843);
        this.eIS.setVerticalFadingEdgeEnabled(false);
        this.eIS.setHorizontalFadingEdgeEnabled(false);
        this.eIS.setOnItemSelectedListener(this);
        this.eIS.oTm = new f(this) {
            final /* synthetic */ FavImgGalleryUI fNC;

            {
                this.fNC = r1;
            }

            public final void abF() {
                this.fNC.finish();
            }
        };
        this.eIS.oTn = new MMGestureGallery.c(this) {
            final /* synthetic */ FavImgGalleryUI fNC;

            {
                this.fNC = r1;
            }

            public final void amC() {
                if (!this.fNC.isFinishing() && !this.fNC.nDT) {
                    FavImgGalleryUI.b(this.fNC);
                }
            }
        };
        iR(true);
        this.eVm = new ArrayList();
        this.fNA = new a();
        this.eIS.setAdapter(this.fNA);
        amB();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FavImgGalleryUI fNC;

            {
                this.fNC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.fNC.finish();
                return true;
            }
        });
    }

    private void amB() {
        long longExtra = getIntent().getLongExtra("key_detail_info_id", -1);
        String stringExtra = getIntent().getStringExtra("key_detail_data_id");
        boolean booleanExtra = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
        String stringExtra2 = getIntent().getStringExtra("fav_note_xml");
        List arrayList = new ArrayList();
        i bB = h.alu().bB(longExtra);
        String str = "MicroMsg.FavoriteImgDetailUI";
        String str2 = "show one fav info, local id is %d, get from db ok ? %B";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(longExtra);
        objArr[1] = Boolean.valueOf(bB != null);
        com.tencent.mm.sdk.platformtools.v.i(str, str2, objArr);
        if (booleanExtra) {
            Object tb = v.tb(stringExtra2);
        } else {
            i iVar = bB;
        }
        if (tb != null) {
            arrayList.add(tb);
        }
        this.eVm.clear();
        int i = -1;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            iVar = (i) arrayList.get(i2);
            int size2 = iVar.field_favProto.mtR.size();
            int i3 = 0;
            while (i3 < size2) {
                int size3;
                pw pwVar = (pw) iVar.field_favProto.mtR.get(i3);
                if ((pwVar.aKG != 8 || o.JZ(v.f(pwVar))) && (pwVar.aKG == 2 || pwVar.aKG == 8)) {
                    this.eVm.add(new d(iVar, pwVar));
                    if (stringExtra != null && stringExtra.equals(pwVar.luu)) {
                        size3 = this.eVm.size() - 1;
                        i3++;
                        i = size3;
                    }
                }
                size3 = i;
                i3++;
                i = size3;
            }
            if (stringExtra == null && iVar.field_localId == longExtra) {
                i = this.eVm.size() - 1;
            }
        }
        getIntent().removeExtra("key_detail_info_id");
        getIntent().removeExtra("key_detail_data_id");
        this.fNA.notifyDataSetChanged();
        this.eIS.post(new Runnable(this) {
            final /* synthetic */ FavImgGalleryUI fNC;

            public final void run() {
                if (i != -1) {
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteImgDetailUI", "match selection %d", new Object[]{Integer.valueOf(i)});
                    this.fNC.eIS.setSelection(i);
                    this.fNC.fNz = i;
                } else if (this.fNC.fNz - 1 >= 0 && this.fNC.fNz - 1 < this.fNC.eVm.size()) {
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteImgDetailUI", "adjust selection %d, list size %d", new Object[]{Integer.valueOf(this.fNC.fNz - 1), Integer.valueOf(this.fNC.eVm.size())});
                    this.fNC.eIS.setSelection(this.fNC.fNz - 1);
                    this.fNC.fNz = this.fNC.fNz - 1;
                } else if (this.fNC.eVm.size() > 0) {
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteImgDetailUI", "adjust selection fail, set selection 0, list size %d", new Object[]{Integer.valueOf(this.fNC.eVm.size())});
                    this.fNC.eIS.setSelection(0);
                    this.fNC.fNz = 0;
                } else {
                    com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavoriteImgDetailUI", "data list size %d, empty, finish", new Object[]{Integer.valueOf(this.fNC.eVm.size())});
                    this.fNC.finish();
                }
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        h.alp().a((com.tencent.mm.plugin.favorite.b.b.a) this);
    }

    protected void onPause() {
        super.onPause();
        h.alp().b((com.tencent.mm.plugin.favorite.b.b.a) this);
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.fNz = i;
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteImgDetailUI", "pos:" + i);
        if (view instanceof MultiTouchImageView) {
            ((MultiTouchImageView) view).bCO();
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public final void b(final com.tencent.mm.plugin.favorite.b.a aVar) {
        if (aVar != null) {
            com.tencent.mm.sdk.platformtools.v.v("MicroMsg.FavoriteImgDetailUI", "on cdn status changed, status:%d", new Object[]{Integer.valueOf(aVar.field_status)});
            d kH = this.fNA.kH(this.fNz);
            if (kH != null && be.ah(aVar.field_dataId, "").equals(kH.bdE.luu)) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ FavImgGalleryUI fNC;

                    public final void run() {
                        View selectedView = this.fNC.eIS.getSelectedView();
                        if (selectedView != null) {
                            b bVar = (b) selectedView.getTag();
                            int i = aVar.field_totalLen > 0 ? ((aVar.field_offset * 100) / aVar.field_totalLen) - 1 : 0;
                            if (i < 0) {
                                i = 0;
                            }
                            bVar.elJ.setProgress(i);
                            bVar.fNL.setText(this.fNC.getString(2131232891, new Object[]{Integer.valueOf(i)}));
                            if (i >= 100 || aVar.isFinished()) {
                                this.fNC.fNA.notifyDataSetChanged();
                            }
                        }
                    }
                });
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (1 == i) {
            if (-1 == i2) {
                d kH = this.fNA.kH(this.fNz);
                if (kH == null) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteImgDetailUI", "dataItem is null.");
                    return;
                }
                com.tencent.mm.plugin.favorite.b.o oVar = new com.tencent.mm.plugin.favorite.b.o();
                if (com.tencent.mm.plugin.favorite.b.o.h(kH.fPW)) {
                    com.tencent.mm.ui.base.g.bf(this.nDR.nEl, getString(2131230745));
                    return;
                }
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteImgDetailUI", "select %s for sending", new Object[]{intent.getStringExtra("Select_Conv_User")});
                final p a = com.tencent.mm.ui.base.g.a(this.nDR.nEl, getString(2131232670), false, null);
                com.tencent.mm.plugin.favorite.b.p.a(this.nDR.nEl, r1, kH.fPW, kH.bdE, new Runnable(this) {
                    final /* synthetic */ FavImgGalleryUI fNC;

                    public final void run() {
                        a.dismiss();
                        com.tencent.mm.ui.snackbar.a.f(this.fNC, this.fNC.getString(2131232839));
                    }
                });
            } else {
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
