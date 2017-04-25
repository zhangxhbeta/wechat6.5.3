package com.tencent.mm.plugin.label.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.bg.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.AddressView;
import com.tencent.mm.ui.contact.f;
import com.tencent.mm.ui.j;
import java.util.List;

public final class a extends j<f> {
    public static final ColorStateList gQF = com.tencent.mm.bd.a.M(aa.getContext(), 2131690159);
    public static final ColorStateList gQG = com.tencent.mm.bd.a.M(aa.getContext(), 2131689792);
    List<String> gQH;

    protected static class a {
        public AddressView gQK;

        public a(View view) {
            this.gQK = (AddressView) view.findViewById(2131755336);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return mn(i);
    }

    public a(Context context) {
        super(context, new f());
    }

    public final int getCount() {
        return super.getCount();
    }

    public final f mn(int i) {
        if (lB(i)) {
            return (f) asw();
        }
        f fVar;
        if (this.nDJ != null) {
            fVar = (f) this.nDJ.get(Integer.valueOf(i));
            if (fVar != null) {
                return fVar;
            }
        }
        if (i < 0 || !getCursor().moveToPosition(i)) {
            return null;
        }
        fVar = a(null, getCursor());
        if (this.nDJ == null) {
            iQ(true);
        }
        if (this.nDJ == null) {
            return fVar;
        }
        this.nDJ.put(Integer.valueOf(i), fVar);
        return fVar;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CharSequence charSequence = null;
        u uVar = mn(i).euW;
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.context, 2130903420, null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        b.a(aVar.gQK, uVar.field_username);
        if (uVar.field_verifyFlag != 0) {
            String eJ = com.tencent.mm.model.ab.a.csb.eJ(uVar.field_verifyFlag);
            if (eJ != null) {
                aVar.gQK.setMaskBitmap(com.tencent.mm.modelbiz.j.hL(eJ));
            } else {
                aVar.gQK.setMaskBitmap(null);
            }
        } else {
            aVar.gQK.setMaskBitmap(null);
        }
        if (uVar.field_deleteFlag == 1) {
            aVar.gQK.setNickNameTextColor(gQG);
        } else {
            aVar.gQK.setNickNameTextColor(gQF);
        }
        aVar.gQK.updateTextColors();
        CharSequence charSequence2 = uVar.nnS;
        if (charSequence2 == null) {
            try {
                Context context = this.context;
                eJ = uVar.field_username;
                charSequence2 = l.er(uVar.field_username);
                String str = "";
                if (str.length() > 0 && !str.equals(charSequence2)) {
                    StringBuilder stringBuilder = new StringBuilder(32);
                    stringBuilder.append(charSequence2);
                    stringBuilder.append("(");
                    stringBuilder.append(str);
                    stringBuilder.append(")");
                    charSequence2 = stringBuilder.toString();
                }
                charSequence = e.a(context, charSequence2, aVar.gQK.getNickNameSize());
            } catch (Exception e) {
            }
            if (charSequence == null) {
                charSequence = "";
            }
            aVar.gQK.setName(charSequence);
            uVar.nnS = charSequence;
        } else {
            aVar.gQK.setName(charSequence2);
        }
        aVar.gQK.updatePositionFlag();
        return view;
    }

    public final synchronized void Ol() {
        Cursor bxW;
        Object obj = Looper.myLooper() == Looper.getMainLooper() ? 1 : null;
        if (this.gQH == null || this.gQH.size() <= 0) {
            bxW = c.bxW();
        } else {
            ak.yW();
            bxW = com.tencent.mm.model.c.wH().bY(this.gQH);
        }
        if (obj != null) {
            d(bxW);
        } else {
            ad.o(new Runnable(this) {
                final /* synthetic */ a gQJ;

                public final void run() {
                    this.gQJ.d(bxW);
                }
            });
        }
    }

    protected final void Om() {
        Ol();
    }

    private static f a(f fVar, Cursor cursor) {
        if (fVar == null) {
            fVar = new f();
        }
        ak.yW();
        u LS = com.tencent.mm.model.c.wH().LS(u.f(cursor));
        if (LS == null) {
            fVar.euW.b(cursor);
            ak.yW();
            com.tencent.mm.model.c.wH().K(fVar.euW);
        } else {
            fVar.euW = LS;
        }
        return fVar;
    }

    public final void d(Cursor cursor) {
        avc();
        setCursor(cursor);
        notifyDataSetChanged();
    }
}
