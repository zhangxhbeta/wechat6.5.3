package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.pointers.PIntArray;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMHorList;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.InputStream;
import java.lang.reflect.Array;

public class FilterImageView extends LinearLayout {
    static c[] oSw = new c[]{new c(new b("原图", "原圖", "Normal"), "icon.png", 0, 0, "MatteOrigin.jpg", 0), new c(new b("LOMO", "LOMO", "LOMO"), "nuowei_mask%02d.jpg", 2, 1, "0004.jpg", 2), new c(new b("麦田", "麥田", "Wheat"), "0062_%02d.jpg", 2, 2, "0062.jpg", 20), new c(new b("玻璃镜", "玻璃鏡", "Glossy"), "habi_mask%02d.jpg", 1, 3, "0005.jpg", 4), new c(new b("拍立得", "拍立得", "Polaroid"), "0063_%02d.jpg", 2, 4, "0063.jpg", 21), new c(new b("湖水", "湖水", "Lake"), "0061_%02d.jpg", 1, 5, "0061.jpg", 19), new c(new b("黄昏", "黃昏", "Twilight"), "0030_mask%01d.jpg", 1, 6, "0030.jpg", 7), new c(new b("黑白", "黑白", "B&W"), "0065_%02d.jpg", 1, 7, "0065.jpg", 22), new c(new b("铜版画", "銅版畫", "Aquatint"), "0032_mask%01d.jpg", 1, 8, "0032.jpg", 9), new c(new b("圆珠笔", "圓珠筆", "Pen"), "0035_mask%01d.jpg", 1, 9, "0035.jpg", 18), new c(new b("海报", "海報", "Poster"), "0036_mask%01d.jpg", 0, 10, "0036.jpg", 17), new c(new b("素描", "素描", "Portrait"), "icon.jpg", 0, 11, "0040.jpg", 12)};
    private Activity bij;
    int jdS = 0;
    int[] oSn;
    View oSo;
    ImageView oSp;
    CropImageView oSq;
    Bitmap oSr;
    private MMHorList oSs;
    private a oSt;
    Runnable oSu;
    Runnable oSv;

    class a extends BaseAdapter {
        int gYI = 0;
        final /* synthetic */ FilterImageView oSx;

        class a {
            TextView eux;
            final /* synthetic */ a oSA;
            ImageView oSy;
            Bitmap oSz;

            a(a aVar) {
                this.oSA = aVar;
            }
        }

        a(FilterImageView filterImageView) {
            this.oSx = filterImageView;
        }

        public final int getCount() {
            return FilterImageView.oSw.length;
        }

        public final Object getItem(int i) {
            return FilterImageView.oSw[i];
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            c cVar = (c) getItem(i);
            if (view == null || !(view.getTag() instanceof a)) {
                view = View.inflate(this.oSx.bij, 2130903634, null);
                a aVar2 = new a(this);
                aVar2.eux = (TextView) view.findViewById(2131757019);
                aVar2.oSy = (ImageView) view.findViewById(2131757018);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
                if (aVar.oSz != null) {
                    v.i("MicroMsg.FilterView", "recycle bitmap:%s", aVar.oSz.toString());
                    aVar.oSz.recycle();
                }
            }
            TextView textView = aVar.eux;
            b bVar = cVar.oSD;
            String bsY = u.bsY();
            CharSequence charSequence = bsY.equals("zh_CN") ? bVar.oBi : (bsY.equals("zh_TW") || bsY.equals("zh_HK")) ? bVar.oSB : bVar.oSC;
            textView.setText(charSequence);
            try {
                InputStream open = this.oSx.bij.getAssets().open("filter/" + cVar.bll);
                aVar.oSz = d.decodeStream(open);
                open.close();
                aVar.oSy.setImageBitmap(aVar.oSz);
            } catch (Throwable e) {
                v.a("MicroMsg.FilterView", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
            view.setLayoutParams(new LayoutParams(-2, -2));
            if (i == this.gYI) {
                view.findViewById(2131757018).setBackgroundResource(2130837826);
            } else {
                view.findViewById(2131757018).setBackgroundResource(2130837827);
            }
            return view;
        }
    }

    static class b {
        String oBi;
        String oSB;
        String oSC;

        b(String str, String str2, String str3) {
            this.oBi = str;
            this.oSB = str2;
            this.oSC = str3;
        }
    }

    static class c {
        String bll;
        b oSD;
        String oSE;
        int oSF;
        int oSG;
        int oSH;

        c(b bVar, String str, int i, int i2, String str2, int i3) {
            this.oSD = bVar;
            this.oSE = str;
            this.oSF = i;
            this.oSG = i2;
            this.bll = str2;
            this.oSH = i3;
        }
    }

    static /* synthetic */ boolean a(FilterImageView filterImageView, String str, int i, int i2) {
        if (i2 == 0) {
            filterImageView.oSr.setPixels(filterImageView.oSn, 0, filterImageView.oSr.getWidth(), 0, 0, filterImageView.oSr.getWidth(), filterImageView.oSr.getHeight());
            filterImageView.oSq.invalidate();
            return true;
        }
        int width = filterImageView.oSr.getWidth() * filterImageView.oSr.getHeight();
        v.d("MicroMsg.FilterView", "len:" + width + "  maskCount:" + i);
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i, width});
        for (int i3 = 0; i3 < i; i3++) {
            InputStream open = filterImageView.bij.getAssets().open("filter/" + String.format(str, new Object[]{Integer.valueOf(i3)}));
            byte[] bArr = new byte[width];
            open.read(bArr);
            Bitmap bc = d.bc(bArr);
            open.close();
            if (bc == null) {
                return false;
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bc, filterImageView.oSr.getWidth(), filterImageView.oSr.getHeight(), true);
            if (bc != createScaledBitmap) {
                v.i("MicroMsg.FilterView", "recycle bitmap:%s", bc.toString());
                bc.recycle();
            }
            if (createScaledBitmap == null) {
                return false;
            }
            createScaledBitmap.getPixels(iArr[i3], 0, createScaledBitmap.getWidth(), 0, 0, createScaledBitmap.getWidth(), createScaledBitmap.getHeight());
            v.i("MicroMsg.FilterView", "recycle bitmap:%s", createScaledBitmap.toString());
            createScaledBitmap.recycle();
        }
        PIntArray pIntArray = new PIntArray();
        v.e("MicroMsg.FilterView", "src.len:" + filterImageView.oSn.length);
        for (int i4 = 0; i4 < iArr.length; i4++) {
            v.e("MicroMsg.FilterView", "mask[" + i4 + "].len:" + iArr[i4].length);
        }
        v.e("MicroMsg.FilterView", "before filter");
        ImgFilter.FilterInt(i2, filterImageView.oSn, iArr, i, filterImageView.oSr.getWidth(), filterImageView.oSr.getHeight(), pIntArray);
        v.e("MicroMsg.FilterView", "after filter");
        filterImageView.oSr.setPixels(pIntArray.value, 0, filterImageView.oSr.getWidth(), 0, 0, filterImageView.oSr.getWidth(), filterImageView.oSr.getHeight());
        filterImageView.oSq.invalidate();
        return true;
    }

    public FilterImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bij = (Activity) context;
        View inflate = View.inflate(this.bij, 2130903442, this);
        this.oSq = (CropImageView) inflate.findViewById(2131756552);
        this.oSp = (ImageView) inflate.findViewById(2131756555);
        this.oSo = inflate.findViewById(2131756554);
        this.oSq.setOnTouchListener(null);
        this.oSs = (MMHorList) inflate.findViewById(2131756556);
        this.oSt = new a(this);
        this.oSs.setAdapter(this.oSt);
        this.oSs.invalidate();
        this.oSs.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ FilterImageView oSx;

            {
                this.oSx = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                a a = this.oSx.oSt;
                a.gYI = i;
                a.notifyDataSetChanged();
                try {
                    this.oSx.jdS = FilterImageView.oSw[i].oSH;
                    FilterImageView.a(this.oSx, FilterImageView.oSw[i].oSE, FilterImageView.oSw[i].oSF, FilterImageView.oSw[i].oSG);
                } catch (Throwable e) {
                    v.e("MicroMsg.FilterView", e.toString());
                    v.a("MicroMsg.FilterView", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                } catch (Throwable e2) {
                    v.e("MicroMsg.FilterView", e2.toString());
                    v.a("MicroMsg.FilterView", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            }
        });
    }

    public final void cm(String str, int i) {
        v.i("MicroMsg.FilterView", "filePath before fiterBmp:" + str);
        if (this.oSr == null || this.oSr.isRecycled()) {
            this.oSr = d.b(d.b(str, 480, 480, false), (float) i);
        }
        v.d("MicroMsg.FilterView", "filterBmp w:" + this.oSr.getWidth() + " h:" + this.oSr.getHeight());
        this.oSn = new int[(this.oSr.getWidth() * this.oSr.getHeight())];
        this.oSr.getPixels(this.oSn, 0, this.oSr.getWidth(), 0, 0, this.oSr.getWidth(), this.oSr.getHeight());
        this.oSq.setImageBitmap(this.oSr);
    }

    public void setVisibility(int i) {
        if (i == 0) {
            this.oSt.notifyDataSetChanged();
            this.oSs.invalidate();
        }
        super.setVisibility(i);
    }
}
