package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.bf.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.i;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.plugin.gif.MMGIFImageView;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.PasterEditText;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.q;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class c {

    static class AnonymousClass10 implements OnClickListener {
        final /* synthetic */ a lJA;
        final /* synthetic */ o lJB;
        final /* synthetic */ View yO;

        AnonymousClass10(a aVar, View view, o oVar) {
            this.lJA = aVar;
            this.yO = view;
            this.lJB = oVar;
        }

        public final void onClick(View view) {
            if (this.lJA != null) {
                this.lJA.a(true, c.cq(this.yO), c.cr(this.yO));
            }
            this.lJB.dismiss();
            this.lJB.setFocusable(false);
            this.lJB.setTouchable(false);
        }
    }

    static class AnonymousClass6 implements OnDismissListener {
        final /* synthetic */ Bitmap hOY;

        AnonymousClass6(Bitmap bitmap) {
            this.hOY = bitmap;
        }

        public final void onDismiss() {
            if (this.hOY != null && !this.hOY.isRecycled()) {
            }
        }
    }

    static class AnonymousClass8 implements DialogInterface.OnDismissListener {
        final /* synthetic */ Bitmap hOY;

        AnonymousClass8(Bitmap bitmap) {
            this.hOY = bitmap;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            if (this.hOY != null && !this.hOY.isRecycled()) {
                this.hOY.recycle();
            }
        }
    }

    public interface a {
        void a(boolean z, String str, int i);
    }

    public interface b {
        void dP(boolean z);
    }

    public static class c {
        public h iji;
        public final com.tencent.mm.ui.base.h.a lJF;
        private String lJG = null;
        Context mContext;

        public c(Context context) {
            this.mContext = context;
            this.lJF = new com.tencent.mm.ui.base.h.a(this.mContext);
            this.lJF.jk(false);
            this.lJF.jl(false);
            this.lJF.nUn.nRK = new com.tencent.mm.ui.base.h.a.b(this) {
                final /* synthetic */ c lJH;

                {
                    this.lJH = r1;
                }

                public final CharSequence a(CharSequence charSequence, float f) {
                    return g.buU().c(this.lJH.mContext, charSequence, f);
                }
            };
        }

        public final c ba(Object obj) {
            c.a(this.mContext, this.lJF, obj);
            this.lJF.jj(true);
            return this;
        }

        public final c bph() {
            this.lJF.nUn.nSa = 2;
            return this;
        }

        public final c Hw(String str) {
            int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(this.mContext, (int) (14.0f * com.tencent.mm.bd.a.ds(this.mContext)));
            if (!be.kS(str)) {
                this.lJF.K(g.buU().e(this.mContext, str.toString(), fromDPToPix));
            }
            return this;
        }

        public final c Hx(String str) {
            this.lJF.nUn.bdZ = str;
            return this;
        }

        public final c bpi() {
            this.lJF.nUn.nSd = 8;
            return this;
        }

        public final c a(Bitmap bitmap, int i) {
            this.lJF.a(bitmap, true, i);
            this.lJF.jj(false);
            this.lJF.a(new AnonymousClass8(bitmap));
            return this;
        }

        public final c Hy(String str) {
            Context context = this.mContext;
            com.tencent.mm.ui.base.h.a aVar = this.lJF;
            View inflate = q.em(context).inflate(2130903968, null);
            MMGIFImageView mMGIFImageView = (MMGIFImageView) inflate.findViewById(2131758211);
            if (mMGIFImageView == null) {
                v.e("MicroMsg.MMConfirmDialog", "Error , emoji imageView is null !!");
            } else {
                com.tencent.mm.storage.a.c rg = com.tencent.mm.pluginsdk.j.a.bmr().rg(str);
                f bmr = com.tencent.mm.pluginsdk.j.a.bmr();
                ak.yW();
                com.tencent.mm.model.c.wY();
                String bo = bmr.bo(SQLiteDatabase.KeyEmpty, str);
                if (rg == null || (rg.field_reserved4 & com.tencent.mm.storage.a.c.nxh) != com.tencent.mm.storage.a.c.nxh) {
                    mMGIFImageView.uz(bo);
                } else {
                    mMGIFImageView.d(com.tencent.mm.pluginsdk.j.a.bmr().g(rg), SQLiteDatabase.KeyEmpty);
                }
                aVar.cC(inflate);
                aVar.wo(1);
            }
            this.lJF.jj(false);
            return this;
        }

        public final c d(Boolean bool) {
            if (bool.booleanValue()) {
                this.lJF.Or(this.mContext.getString(2131231976));
            }
            return this;
        }

        public final c Hz(String str) {
            this.lJF.Or(str);
            return this;
        }

        public final c tS(int i) {
            this.lJG = this.mContext.getResources().getString(i);
            return this;
        }

        public final c a(a aVar) {
            this.iji = this.lJF.RX();
            c.a(this.mContext, this.iji, this.lJG, null, aVar, aVar);
            return this;
        }
    }

    static /* synthetic */ String cq(View view) {
        EditText editText = (EditText) view.findViewById(2131756405);
        return editText == null ? null : editText.getText().toString();
    }

    static /* synthetic */ int cr(View view) {
        EditText editText = (EditText) view.findViewById(2131756405);
        return editText instanceof PasterEditText ? ((PasterEditText) editText).jOn : 0;
    }

    static void a(Context context, com.tencent.mm.ui.base.h.a aVar, Object obj) {
        if (obj != null) {
            if (obj instanceof String) {
                obj = be.g(((String) obj).split(","));
            } else if (obj instanceof List) {
                List list = (List) obj;
            } else {
                obj = null;
            }
            if (!be.bP(obj)) {
                if (obj.size() == 1) {
                    final String str = (String) obj.get(0);
                    aVar.nUn.title = g.buU().e(context, context.getString(2131234558).toString(), com.tencent.mm.bd.a.fromDPToPix(context, (int) (20.0f * com.tencent.mm.bd.a.ds(context))));
                    String er = l.er(str);
                    int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(context, (int) (14.0f * com.tencent.mm.bd.a.ds(context)));
                    if (m.dE(str)) {
                        CharSequence e = g.buU().e(context, (er + context.getString(2131234863, new Object[]{Integer.valueOf(i.el(str))})).toString(), fromDPToPix);
                        final View inflate = q.em(context).inflate(2130903465, null);
                        GridView gridView = (GridView) inflate.findViewById(2131756611);
                        final List arrayList = new ArrayList();
                        final List ej = i.ej(str);
                        aVar.a(str, e, Boolean.valueOf(true), new com.tencent.mm.ui.base.h.a.a() {
                            public final void bpg() {
                                be.cw(inflate);
                                if (arrayList.size() == 0 && !be.kS(str)) {
                                    ArrayList arrayList = arrayList;
                                    List<String> list = ej;
                                    if (!be.bP(list)) {
                                        for (String er : list) {
                                            arrayList.add(l.er(er));
                                        }
                                    }
                                }
                            }
                        });
                        gridView.setAdapter(new g(context, ej, arrayList));
                        gridView.setSelector(new ColorDrawable(context.getResources().getColor(2131690078)));
                        if (ej != null) {
                            if (ej.size() > 16) {
                                gridView.setLayoutParams(new LayoutParams(-1, com.tencent.mm.bd.a.N(context, 2131493024)));
                                gridView.setPadding(com.tencent.mm.bd.a.N(context, 2131493020), 0, com.tencent.mm.bd.a.N(context, 2131493020), 0);
                            } else {
                                gridView.setPadding(0, 0, 0, com.tencent.mm.bd.a.N(context, 2131493017));
                            }
                        }
                        aVar.nUn.nRY = inflate;
                        return;
                    }
                    aVar.a(str, g.buU().e(context, er.toString(), fromDPToPix), Boolean.valueOf(false), null);
                    return;
                }
                aVar.nUn.nRF = obj;
                aVar.Op(context.getString(2131233904));
            }
        }
    }

    static void a(Context context, final h hVar, String str, String str2, final a aVar, final a aVar2) {
        if (be.kS(str) || str.length() == 0) {
            str = context.getResources().getString(2131231979);
        }
        if (be.kS(str2) || str2.length() == 0) {
            str2 = context.getResources().getString(2131231010);
        }
        hVar.a(str, true, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (aVar != null) {
                    a aVar = aVar;
                    h hVar = hVar;
                    String obj = hVar.kL == null ? null : hVar.kL.getText().toString();
                    hVar = hVar;
                    aVar.a(true, obj, hVar.kL instanceof PasterEditText ? ((PasterEditText) hVar.kL).jOn : 0);
                }
            }
        });
        hVar.b(str2, true, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (aVar2 != null) {
                    aVar2.a(false, null, 0);
                }
            }
        });
    }

    public static h a(k kVar, String str, String str2, String str3, boolean z, String str4, a aVar) {
        if ((str == null || str.length() == 0) && (str3 == null || str3.length() == 0)) {
            v.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            return null;
        }
        View inflate = View.inflate(kVar.nEl, 2130903398, null);
        com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(kVar.nEl);
        aVar2.jk(false);
        aVar2.jl(false);
        a(aVar2, kVar.nEl, str);
        k(inflate, z);
        a(kVar, aVar2, aVar, inflate, str4);
        TextView textView = (TextView) inflate.findViewById(2131756407);
        textView.setText(e.a(kVar.nEl, (CharSequence) str3, textView.getTextSize()));
        inflate.findViewById(2131756408).setVisibility(8);
        int a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(kVar.nEl, 120.0f);
        CdnImageView cdnImageView = (CdnImageView) inflate.findViewById(2131756406);
        if (cdnImageView != null) {
            cdnImageView.G(str2, a, a);
        }
        aVar2.cC(inflate);
        h RX = aVar2.RX();
        RX.show();
        return RX;
    }

    public static h a(k kVar, String str, String str2, boolean z, String str3, a aVar) {
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            v.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(kVar.nEl);
        String string = kVar.nEl.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(kVar.nEl, aVar2, be.g(string.split(",")));
        }
        aVar2.jj(true);
        aVar2.K(new StringBuilder(kVar.nEl.getResources().getString(2131231171)).append(str).toString()).jk(false).jl(false);
        if (z) {
            aVar2.Or(kVar.nEl.getString(2131231976));
        }
        h RX = aVar2.RX();
        a(kVar.nEl, RX, str3, null, aVar, aVar);
        RX.show();
        return RX;
    }

    public static h a(k kVar, String str, String str2, String str3, String str4, String str5, a aVar) {
        if ((str == null || str.length() == 0) && (str3 == null || str3.length() == 0)) {
            v.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            return null;
        }
        View inflate = View.inflate(kVar.nEl, 2130903398, null);
        com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(kVar.nEl);
        aVar2.jk(false);
        aVar2.jl(false);
        a(aVar2, kVar.nEl, str);
        if (inflate != null) {
            EditText editText = (EditText) inflate.findViewById(2131756405);
            if (editText != null) {
                editText.setVisibility(0);
            }
            editText.setText(str4);
        }
        a(kVar, aVar2, aVar, inflate, str5);
        TextView textView = (TextView) inflate.findViewById(2131756407);
        textView.setText(e.a(kVar.nEl, (CharSequence) str3, textView.getTextSize()));
        inflate.findViewById(2131756408).setVisibility(8);
        int a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(kVar.nEl, 120.0f);
        CdnImageView cdnImageView = (CdnImageView) inflate.findViewById(2131756406);
        if (cdnImageView != null) {
            cdnImageView.G(str2, a, a);
        }
        aVar2.cC(inflate);
        h RX = aVar2.RX();
        RX.show();
        return RX;
    }

    public static h a(k kVar, String str, boolean z, a aVar) {
        return a(kVar, str, z, SQLiteDatabase.KeyEmpty, aVar);
    }

    public static h a(k kVar, String str, boolean z, String str2, a aVar) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.MMConfirmDialog", "showDialogItem2 fail, message is empty");
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(kVar.nEl);
        String string = kVar.nEl.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(kVar.nEl, aVar2, be.g(string.split(",")));
        }
        aVar2.jj(true);
        aVar2.K(str).jk(false).jl(false);
        if (z) {
            aVar2.Or(kVar.nEl.getString(2131231976));
        }
        h RX = aVar2.RX();
        a(kVar.nEl, RX, str2, null, aVar, aVar);
        RX.show();
        return RX;
    }

    public static h b(k kVar, String str, boolean z, a aVar) {
        return b(kVar, str, z, SQLiteDatabase.KeyEmpty, aVar);
    }

    public static h b(k kVar, String str, boolean z, String str2, a aVar) {
        if (str == null || !com.tencent.mm.a.e.aR(str)) {
            v.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, img does not exist");
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(kVar.nEl);
        String string = kVar.nEl.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(kVar.nEl, aVar2, be.g(string.split(",")));
        }
        aVar2.jj(true);
        aVar2.jk(false).jl(false);
        if (z) {
            aVar2.Or(kVar.nEl.getString(2131231976));
        }
        if (!be.kS(str)) {
            Bitmap JV = d.JV(str);
            if (JV != null) {
                aVar2.a(JV, true, 3);
                a(aVar2, JV);
                aVar2.jj(false);
            }
        }
        h RX = aVar2.RX();
        a(kVar.nEl, RX, str2, null, aVar, aVar);
        RX.show();
        return RX;
    }

    public static h a(k kVar, byte[] bArr, boolean z, a aVar) {
        return a(kVar, bArr, z, SQLiteDatabase.KeyEmpty, aVar);
    }

    public static h a(k kVar, byte[] bArr, boolean z, String str, a aVar) {
        if (bArr == null || bArr.length == 0) {
            v.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, imgData is null");
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(kVar.nEl);
        String string = kVar.nEl.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(kVar.nEl, aVar2, be.g(string.split(",")));
        }
        aVar2.jj(true);
        aVar2.jk(false).jl(false);
        if (z) {
            aVar2.Or(kVar.nEl.getString(2131231976));
        }
        if (bArr != null && bArr.length > 0) {
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            if (decodeByteArray != null) {
                aVar2.a(decodeByteArray, true, 3);
                a(aVar2, decodeByteArray);
                aVar2.jj(false);
            }
        }
        h RX = aVar2.RX();
        a(kVar.nEl, RX, str, null, aVar, aVar);
        RX.show();
        return RX;
    }

    public static h a(k kVar, String str, String str2, String str3, a aVar) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.MMConfirmDialog", "showDialogItem4 fail, title message both are empty");
            return null;
        }
        View J = J(kVar.nEl, 2130903399);
        com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(kVar.nEl);
        aVar2.jk(false);
        aVar2.jl(false);
        if (J != null) {
            EditText editText = (EditText) J.findViewById(2131756405);
            if (editText != null) {
                editText.setVisibility(0);
                editText.setHint(be.ma(str2));
            }
        }
        a(kVar, aVar2, aVar, J, str3);
        if (!be.kS(null)) {
            a(aVar2, kVar.nEl, null);
        }
        ((TextView) J.findViewById(2131756412)).setVisibility(8);
        TextView textView = (TextView) J.findViewById(2131756407);
        textView.setText(e.a(kVar.nEl, (CharSequence) str, textView.getTextSize()));
        ((TextView) J.findViewById(2131756408)).setVisibility(8);
        int a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(kVar.nEl, 120.0f);
        CdnImageView cdnImageView = (CdnImageView) J.findViewById(2131756406);
        if (cdnImageView != null) {
            if (!be.kS(null)) {
                com.tencent.mm.pluginsdk.ui.a.b.m(cdnImageView, null);
            } else if (be.kS(null)) {
                cdnImageView.setVisibility(8);
            } else {
                cdnImageView.G(null, a, a);
            }
        }
        aVar2.cC(J);
        h RX = aVar2.RX();
        RX.show();
        return RX;
    }

    public static h a(k kVar, int i, String str, boolean z, a aVar) {
        return a(kVar, i, str, z, SQLiteDatabase.KeyEmpty, aVar);
    }

    public static h a(k kVar, int i, String str, boolean z, String str2, a aVar) {
        com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(kVar.nEl);
        String string = kVar.nEl.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(kVar.nEl, aVar2, be.g(string.split(",")));
        }
        aVar2.jj(true);
        if (i == 2131165230) {
            string = kVar.nEl.getResources().getString(2131231063);
        } else if (i == 2131165232) {
            string = kVar.nEl.getResources().getString(2131231095);
        } else if (i == 2131165244) {
            string = kVar.nEl.getResources().getString(2131231176);
        } else {
            string = kVar.nEl.getResources().getString(2131230904);
        }
        aVar2.K(str).jk(false).jl(false);
        if (z) {
            aVar2.Or(kVar.nEl.getString(2131231976));
        }
        h RX = aVar2.RX();
        a(kVar.nEl, RX, str2, null, aVar, aVar);
        RX.show();
        return RX;
    }

    public static h a(k kVar, String str, boolean z, int i, a aVar) {
        return a(kVar, str, z, i, SQLiteDatabase.KeyEmpty, aVar);
    }

    public static h a(k kVar, String str, boolean z, int i, String str2, a aVar) {
        Object g;
        com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(kVar.nEl);
        String string = kVar.nEl.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            g = be.g(string.split(","));
        } else {
            g = null;
        }
        a(kVar.nEl, aVar2, g);
        aVar2.jj(true);
        switch (i) {
            case 1:
                string = kVar.nEl.getResources().getString(2131231176);
                break;
            case 2:
                string = kVar.nEl.getResources().getString(2131231095);
                break;
            default:
                string = kVar.nEl.getResources().getString(2131230904);
                break;
        }
        aVar2.K(new StringBuffer(string).append(str).toString()).jk(false).jl(false);
        if (z) {
            aVar2.Or(kVar.nEl.getString(2131231976));
        }
        h RX = aVar2.RX();
        a(kVar.nEl, RX, str2, null, aVar, aVar);
        RX.show();
        return RX;
    }

    public static h a(k kVar, String str, String str2, String str3, a aVar, a aVar2) {
        com.tencent.mm.ui.base.h.a aVar3 = new com.tencent.mm.ui.base.h.a(kVar.nEl);
        aVar3.a(com.tencent.mm.compatible.f.a.decodeResource(kVar.nEl.getResources(), 2131165475), false, 3);
        aVar3.jk(false);
        aVar3.jl(false);
        aVar3.nUn.nRI = true;
        aVar3.nUn.nRC = str;
        aVar3.wo(17);
        h RX = aVar3.RX();
        a(kVar.nEl, RX, str3, str2, aVar2, aVar);
        RX.wl(kVar.nEl.getResources().getColor(2131689767));
        RX.show();
        return RX;
    }

    public static o b(k kVar, String str, String str2, String str3, String str4, String str5, final a aVar) {
        final View J = J(kVar.nEl, 2130903402);
        final o cp = cp(J);
        a(J, aVar, cp);
        if (be.kS(str2)) {
            v.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
            return null;
        }
        a(J, 2131756412, str2, false, 0);
        NoMeasuredTextView noMeasuredTextView = (NoMeasuredTextView) J.findViewById(2131756407);
        noMeasuredTextView.oaP = true;
        noMeasuredTextView.G(kVar.nEl.getResources().getDimension(2131492967) * com.tencent.mm.bd.a.ds(kVar.nEl));
        noMeasuredTextView.setTextColor(com.tencent.mm.bd.a.M(kVar.nEl, 2131689909));
        if (be.kS(str)) {
            noMeasuredTextView.setText(e.a(kVar.nEl, (CharSequence) str3, noMeasuredTextView.gl.getTextSize()));
        } else {
            noMeasuredTextView.setText(e.a(kVar.nEl, l.er(str), noMeasuredTextView.gl.getTextSize()));
        }
        a(J, 2131756417, str4, true, 8);
        Button button = (Button) J.findViewById(2131756399);
        if (!be.kS(str5)) {
            button.setText(str5);
        }
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (aVar != null) {
                    aVar.a(true, c.cq(J), c.cr(J));
                }
                cp.dismiss();
                cp.setFocusable(false);
                cp.setTouchable(false);
            }
        });
        if (!be.kS(str)) {
            com.tencent.mm.pluginsdk.ui.a.b.m((ImageView) J.findViewById(2131756406), str);
        }
        a(kVar, cp);
        return cp;
    }

    public static o a(k kVar, long j, String str, String str2, String str3, final a aVar) {
        final View J = J(kVar.nEl, 2130903402);
        final o cp = cp(J);
        a(J, aVar, cp);
        if (be.kS(str)) {
            v.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
            return null;
        }
        String str4;
        String str5;
        a(J, 2131756412, str, false, 0);
        NoMeasuredTextView noMeasuredTextView = (NoMeasuredTextView) J.findViewById(2131756407);
        noMeasuredTextView.oaP = true;
        noMeasuredTextView.G(kVar.nEl.getResources().getDimension(2131492967) * com.tencent.mm.bd.a.ds(kVar.nEl));
        noMeasuredTextView.setTextColor(com.tencent.mm.bd.a.M(kVar.nEl, 2131689909));
        com.tencent.mm.modelbiz.a.c Z = u.DA().Z(j);
        String str6;
        if (Z.DN()) {
            str4 = Z.field_chatName;
            str5 = Z.field_headImageUrl;
            str6 = Z.field_brandUserName;
            CharSequence charSequence = str4;
            str4 = str5;
            str5 = str6;
        } else {
            j ig = u.DC().ig(Z.field_bizChatServId);
            if (ig != null) {
                str4 = ig.field_userName;
                str5 = ig.field_headImageUrl;
                str6 = ig.field_brandUserName;
                Object obj = str4;
                str4 = str5;
                str5 = str6;
            } else {
                v.w("MicroMsg.MMConfirmDialog", "showDialogItem8 userInfo is null");
                return null;
            }
        }
        if (charSequence == null) {
            charSequence = str2;
        }
        if (be.kS(charSequence)) {
            noMeasuredTextView.setText(e.a(kVar.nEl, (CharSequence) str2, noMeasuredTextView.gl.getTextSize()));
        } else {
            noMeasuredTextView.setText(e.a(kVar.nEl, charSequence, noMeasuredTextView.gl.getTextSize()));
        }
        a(J, 2131756417, null, true, 8);
        Button button = (Button) J.findViewById(2131756399);
        if (!be.kS(str3)) {
            button.setText(str3);
        }
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (aVar != null) {
                    aVar.a(true, c.cq(J), c.cr(J));
                }
                cp.dismiss();
                cp.setFocusable(false);
                cp.setTouchable(false);
            }
        });
        com.tencent.mm.ae.a.a.c.a aVar2 = new com.tencent.mm.ae.a.a.c.a();
        aVar2.cPv = com.tencent.mm.modelbiz.a.e.ib(str5);
        aVar2.cPs = true;
        aVar2.cPO = true;
        aVar2.cPH = 2131165440;
        com.tencent.mm.ae.a.a.c GU = aVar2.GU();
        if (!be.kS(str4)) {
            n.GL().a(str4, (ImageView) J.findViewById(2131756406), GU);
        }
        a(kVar, cp);
        return cp;
    }

    public static h a(k kVar, String str, View view, String str2, final b bVar) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(kVar.nEl);
        aVar.jk(false);
        aVar.jl(false);
        a(aVar, kVar.nEl, str);
        if (be.kS(str2) || str2.length() == 0) {
            str2 = kVar.nEl.getResources().getString(2131231979);
        }
        aVar.Os(str2).a(new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (bVar != null) {
                    bVar.dP(true);
                }
            }
        });
        aVar.wq(2131231010).b(new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (bVar != null) {
                    bVar.dP(false);
                }
            }
        });
        aVar.cC(view);
        h RX = aVar.RX();
        RX.wk(kVar.nEl.getResources().getColor(2131690123));
        RX.show();
        return RX;
    }

    public static View J(Context context, int i) {
        return ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, null);
    }

    static o cp(View view) {
        return new o(view, -1, -1);
    }

    public static void a(k kVar, com.tencent.mm.ui.base.h.a aVar, final a aVar2, final View view, String str) {
        if (be.kS(str) || str.length() == 0) {
            str = kVar.nEl.getResources().getString(2131231979);
        }
        aVar.Os(str).a(new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (aVar2 != null) {
                    aVar2.a(true, c.cq(view), c.cr(view));
                }
            }
        });
        aVar.wq(2131231010).b(new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (aVar2 != null) {
                    aVar2.a(false, null, 0);
                }
            }
        });
    }

    private static void a(com.tencent.mm.ui.base.h.a aVar, Context context, String str) {
        aVar.Op(str);
        aVar.nUn.lFe = context.getResources().getColor(2131689909);
        aVar.nUn.nRZ = 2;
    }

    static void a(final View view, final a aVar, final o oVar) {
        ((Button) view.findViewById(2131756399)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (aVar != null) {
                    aVar.a(true, c.cq(view), c.cr(view));
                }
                oVar.dismiss();
                oVar.setFocusable(false);
                oVar.setTouchable(false);
            }
        });
        Button button = (Button) view.findViewById(2131756398);
        if (button != null) {
            button.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (aVar != null) {
                        aVar.a(false, null, 0);
                    }
                    oVar.dismiss();
                    oVar.setFocusable(false);
                    oVar.setTouchable(false);
                }
            });
        }
    }

    public static void k(View view, boolean z) {
        if (view != null) {
            EditText editText = (EditText) view.findViewById(2131756405);
            if (editText != null) {
                editText.setVisibility(z ? 0 : 8);
            }
        }
    }

    private static void a(View view, int i, String str, boolean z, int i2) {
        TextView textView = (TextView) view.findViewById(i);
        Assert.assertTrue(textView != null);
        if (z && be.kS(str)) {
            textView.setVisibility(i2);
        } else {
            textView.setText(str);
        }
    }

    static void a(k kVar, o oVar) {
        try {
            if (!kVar.nEl.isFinishing()) {
                oVar.setInputMethodMode(1);
                oVar.setSoftInputMode(16);
                oVar.setFocusable(true);
                oVar.setTouchable(true);
                oVar.showAtLocation(kVar.nEl.getWindow().getDecorView(), 17, 0, 0);
            }
        } catch (Throwable e) {
            v.e("MicroMsg.MMConfirmDialog", "show dialog fail: %s", e.getMessage());
            v.a("MicroMsg.MMConfirmDialog", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static void a(com.tencent.mm.ui.base.h.a aVar, final Bitmap bitmap) {
        aVar.a(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                if (bitmap != null && !bitmap.isRecycled()) {
                }
            }
        });
    }
}
