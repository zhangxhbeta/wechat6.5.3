package com.tencent.mm.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.f;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "201400504", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public final class g {

    public interface a {
        void oI(int i);
    }

    public interface b {
        boolean r(CharSequence charSequence);
    }

    public interface c {
        void gT(int i);
    }

    public interface d {
        void bw(int i, int i2);
    }

    public static void a(Context context, Dialog dialog) {
        if (context instanceof MMActivity) {
            ((MMActivity) context).a(dialog);
        }
    }

    public static Toast bd(Context context, String str) {
        return bf(context, str);
    }

    public static Toast be(Context context, String str) {
        return bf(context, str);
    }

    public static Toast bf(Context context, String str) {
        Toast makeText = Toast.makeText(context, str, 0);
        makeText.show();
        return makeText;
    }

    public static h z(Context context, String str, String str2) {
        return A(context, str, str2);
    }

    public static h A(Context context, String str, String str2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.Op(str2);
        aVar.Oq(str);
        aVar.jk(true);
        aVar.wp(2131231107).a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        h RX = aVar.RX();
        RX.show();
        a(context, RX);
        return RX;
    }

    public static h f(Context context, int i, int i2) {
        return A(context, i > 0 ? context.getString(i) : SQLiteDatabase.KeyEmpty, i2 > 0 ? context.getString(i2) : SQLiteDatabase.KeyEmpty);
    }

    public static h a(Context context, int i, int i2, OnClickListener onClickListener) {
        return a(context, i, i2, true, onClickListener);
    }

    public static h a(Context context, int i, int i2, boolean z, OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        if (i2 > 0) {
            aVar.wm(i2);
        }
        aVar.wn(i);
        aVar.wp(2131231107).a(onClickListener);
        aVar.jk(z);
        h RX = aVar.RX();
        RX.show();
        a(context, RX);
        return RX;
    }

    public static h a(Context context, String str, String str2, OnClickListener onClickListener) {
        return a(context, str, str2, true, onClickListener);
    }

    public static h a(Context context, String str, String str2, boolean z, OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.Op(str2);
        aVar.Oq(str);
        aVar.wp(2131231107).a(onClickListener);
        aVar.jk(z);
        h RX = aVar.RX();
        RX.show();
        a(context, RX);
        return RX;
    }

    public static h a(Context context, String str, String str2, String str3, OnClickListener onClickListener) {
        return a(context, str, str2, str3, true, onClickListener);
    }

    public static h a(Context context, String str, String str2, String str3, boolean z, OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.Op(str2);
        aVar.Oq(str);
        aVar.Os(str3).a(onClickListener);
        aVar.jk(z);
        h RX = aVar.RX();
        RX.show();
        a(context, RX);
        return RX;
    }

    public static h a(Context context, String str, String str2, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.Op(str2);
        aVar.Oq(str);
        aVar.wp(2131231107).a(onClickListener);
        aVar.wq(2131231010).b(onClickListener2);
        h RX = aVar.RX();
        RX.show();
        a(context, RX);
        return RX;
    }

    public static h a(Context context, String str, String str2, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.Op(str2);
        aVar.Oq(str);
        aVar.wp(2131231107).a(onClickListener);
        aVar.wq(2131231010).b(onClickListener2);
        aVar.jk(z);
        h RX = aVar.RX();
        RX.show();
        a(context, RX);
        return RX;
    }

    public static h a(Context context, String str, String str2, String str3, String str4, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(context, str, str2, str3, str4, z, onClickListener, onClickListener2, -1);
    }

    public static h a(Context context, String str, String str2, String str3, String str4, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2, int i) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.Op(str2);
        aVar.Oq(str);
        aVar.Os(str3).a(onClickListener);
        aVar.Ot(str4).b(onClickListener2);
        aVar.jk(z);
        h RX = aVar.RX();
        if (i > 0) {
            RX.wk(context.getResources().getColor(i));
        }
        RX.show();
        a(context, RX);
        return RX;
    }

    public static h a(Context context, int i, int i2, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(context, i > 0 ? context.getString(i) : SQLiteDatabase.KeyEmpty, i2 > 0 ? context.getString(i2) : SQLiteDatabase.KeyEmpty, onClickListener, onClickListener2);
    }

    public static h b(Context context, int i, int i2, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(context, i > 0 ? context.getString(i) : SQLiteDatabase.KeyEmpty, i2 > 0 ? context.getString(i2) : SQLiteDatabase.KeyEmpty, false, onClickListener, onClickListener2);
    }

    public static h a(Context context, int i, int i2, int i3, int i4, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(context, i > 0 ? context.getString(i) : SQLiteDatabase.KeyEmpty, i2 > 0 ? context.getString(i2) : SQLiteDatabase.KeyEmpty, context.getString(i3), context.getString(i4), z, onClickListener, onClickListener2);
    }

    public static h a(Context context, int i, int i2, int i3, int i4, OnClickListener onClickListener, OnClickListener onClickListener2, int i5) {
        return a(context, i > 0 ? context.getString(i) : SQLiteDatabase.KeyEmpty, i2 > 0 ? context.getString(i2) : SQLiteDatabase.KeyEmpty, context.getString(i3), context.getString(i4), false, onClickListener, onClickListener2, i5);
    }

    public static h a(Context context, int i, int i2, int i3, int i4, OnClickListener onClickListener, final OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        if (i2 != 0) {
            aVar.wm(i2);
        }
        aVar.wn(i);
        aVar.wp(i3).a(onClickListener);
        aVar.wq(i4).b(onClickListener2);
        aVar.c(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (onClickListener2 != null) {
                    onClickListener2.onClick(dialogInterface, 0);
                }
            }
        });
        h RX = aVar.RX();
        RX.show();
        a(context, RX);
        return RX;
    }

    public static h b(Context context, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.Op(str2);
        aVar.Oq(str);
        aVar.Os(str3).a(onClickListener);
        aVar.Ot(str4).b(onClickListener2);
        h RX = aVar.RX();
        RX.show();
        a(context, RX);
        return RX;
    }

    public static h a(Context context, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2, int i) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.Op(str2);
        aVar.Oq(str);
        aVar.Os(str3).a(onClickListener);
        aVar.Ot(str4).b(onClickListener2);
        h RX = aVar.RX();
        RX.wk(context.getResources().getColor(i));
        RX.show();
        a(context, RX);
        return RX;
    }

    public static h a(Context context, boolean z, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.Op(str2);
        aVar.Oq(str);
        aVar.Os(str3).a(onClickListener);
        aVar.Ot(str4).b(onClickListener2);
        aVar.jk(z);
        h RX = aVar.RX();
        RX.show();
        a(context, RX);
        return RX;
    }

    public static h a(Context context, View view, String str) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.Op(str);
        aVar.cC(view);
        aVar.jk(true);
        h RX = aVar.RX();
        RX.show();
        a(context, RX);
        return RX;
    }

    public static h a(Context context, String str, View view, OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.Op(str);
        aVar.cC(view);
        aVar.wp(2131231107).a(onClickListener);
        h RX = aVar.RX();
        RX.show();
        a(context, RX);
        return RX;
    }

    public static h a(Context context, String str, View view, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(context, true, str, view, str2, str3, onClickListener, onClickListener2);
    }

    public static h a(Context context, boolean z, String str, View view, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(context, z, str, view, str2, str3, onClickListener, onClickListener2, -1);
    }

    public static h a(Context context, boolean z, String str, View view, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2, int i) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.Op(str);
        aVar.cC(view);
        aVar.Os(str2).a(onClickListener);
        aVar.Ot(str3).b(onClickListener2);
        aVar.jk(z);
        h RX = aVar.RX();
        if (i > 0) {
            RX.wk(context.getResources().getColor(i));
        }
        RX.show();
        a(context, RX);
        return RX;
    }

    public static h a(Context context, String str, String str2, View view, OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.Op(str);
        aVar.cC(view);
        aVar.Os(str2).a(onClickListener);
        h RX = aVar.RX();
        RX.show();
        a(context, RX);
        return RX;
    }

    public static h a(Context context, String str, View view, OnClickListener onClickListener, final OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.Op(str);
        aVar.Oq(null);
        aVar.cC(view);
        aVar.wp(2131231107).a(onClickListener);
        aVar.wq(2131231010).b(onClickListener2);
        aVar.c(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (onClickListener2 != null) {
                    onClickListener2.onClick(dialogInterface, 0);
                }
            }
        });
        h RX = aVar.RX();
        RX.show();
        a(context, RX);
        return RX;
    }

    public static h a(final Context context, String str, String str2, String str3, int i, final b bVar) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.jk(false);
        aVar.jl(true);
        aVar.wq(2131231010).b(null);
        aVar.Op(str);
        View inflate = View.inflate(context, 2130903969, null);
        final MMEditText mMEditText = (MMEditText) inflate.findViewById(2131755280);
        if (!be.kS(str2)) {
            mMEditText.PL(str2);
        }
        TextView textView = (TextView) inflate.findViewById(2131757003);
        if (be.kS(str3)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str3);
        }
        aVar.wp(2131231107).a(false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                boolean z = true;
                if (bVar != null) {
                    z = bVar.r(mMEditText.getText().toString().trim());
                }
                if (z) {
                    dialogInterface.dismiss();
                    if (context instanceof MMActivity) {
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass12 nTG;

                            {
                                this.nTG = r1;
                            }

                            public final void run() {
                                ((MMActivity) context).axg();
                            }
                        });
                    }
                }
            }
        });
        if (i > 0) {
            com.tencent.mm.ui.tools.a.c.b(mMEditText).yn(i).a(null);
        }
        aVar.cC(inflate);
        h RX = aVar.RX();
        RX.show();
        a(context, RX);
        if (!(context instanceof MMActivity)) {
            return RX;
        }
        inflate.post(new Runnable() {
            public final void run() {
                ((MMActivity) context).aJs();
            }
        });
        return RX;
    }

    public static h a(Context context, String str, List<String> list, int i, final a aVar) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        if (list.isEmpty()) {
            v.w("MicroMsg.MMAlert", "show switch alert fail");
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(context);
        aVar2.jk(false);
        aVar2.wq(2131231010);
        aVar2.Op(str);
        View inflate = View.inflate(context, 2130903970, null);
        final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(2131758212);
        for (int size = list.size() - 1; size >= 0; size--) {
            TextView textView = (TextView) View.inflate(context, 2130904220, null);
            textView.setText((CharSequence) list.get(size));
            if (size == i) {
                textView.setCompoundDrawablesWithIntrinsicBounds(2131165878, 0, 0, 0);
            }
            if (size == list.size() - 1) {
                context.getResources().getDimensionPixelSize(2131493168);
                textView.setBackgroundResource(2130839259);
            }
            textView.setTag(Integer.valueOf(size));
            linearLayout.addView(textView, 0);
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    for (int i = 0; i < linearLayout.getChildCount(); i++) {
                        TextView textView = (TextView) linearLayout.getChildAt(i);
                        if (textView.getId() != 2131757003) {
                            textView.setCompoundDrawablesWithIntrinsicBounds(2131165881, 0, 0, 0);
                        }
                    }
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(2131165878, 0, 0, 0);
                    final int intValue = ((Integer) view.getTag()).intValue();
                    view.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass14 nTJ;

                        public final void run() {
                            ((Dialog) linearLayout.getTag()).dismiss();
                            if (aVar != null) {
                                aVar.oI(intValue);
                            }
                        }
                    });
                }
            });
        }
        aVar2.cC(inflate);
        Dialog RX = aVar2.RX();
        linearLayout.setTag(RX);
        RX.show();
        a(context, RX);
        return RX;
    }

    public static h a(Context context, String str, String str2, OnClickListener onClickListener, OnCancelListener onCancelListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.Op(str2);
        aVar.Oq(str);
        aVar.wp(2131231107).a(onClickListener);
        aVar.c(onCancelListener);
        h RX = aVar.RX();
        RX.show();
        a(context, RX);
        return RX;
    }

    public static p a(Context context, String str, boolean z, OnCancelListener onCancelListener) {
        return a(context, 0, str, z, onCancelListener);
    }

    public static p a(Context context, String str, OnCancelListener onCancelListener) {
        return a(context, 2, str, true, onCancelListener);
    }

    private static p a(Context context, int i, String str, boolean z, OnCancelListener onCancelListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        w.a(true, null);
        final WeakReference weakReference = new WeakReference(onCancelListener);
        p b = p.b(context, str, z, i, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                OnCancelListener onCancelListener = (OnCancelListener) weakReference.get();
                if (onCancelListener != null) {
                    onCancelListener.onCancel(dialogInterface);
                }
                w.a(false, null);
            }
        });
        a(context, b);
        return b;
    }

    public static Dialog a(Context context, String str, List<String> list, List<Integer> list2, String str2, d dVar) {
        return b(context, str, (List) list, (List) list2, str2, true, dVar);
    }

    public static Dialog a(Context context, String str, List<String> list, List<Integer> list2, String str2, boolean z, d dVar) {
        return b(context, str, (List) list, (List) list2, str2, z, dVar);
    }

    public static Dialog a(Context context, String str, List<String> list, List<Integer> list2, d dVar) {
        return b(context, str, (List) list, (List) list2, null, true, dVar);
    }

    @Deprecated
    private static Dialog b(Context context, final String str, List<String> list, final List<Integer> list2, final String str2, boolean z, final d dVar) {
        if ((list == null || list.size() == 0) && be.kS(str2)) {
            return null;
        }
        if (list == null) {
            list = new ArrayList();
        }
        if (z) {
            l lVar = new l(context);
            lVar.jXn = new com.tencent.mm.ui.base.n.c() {
                public final void a(l lVar) {
                    if (!be.kS(str)) {
                        lVar.setHeaderTitle(str);
                    }
                    for (int i = 0; i < list.size(); i++) {
                        lVar.d(((Integer) list2.get(i)).intValue(), (CharSequence) list.get(i));
                    }
                    if (!be.kS(str2)) {
                        lVar.d(-1, str2);
                    }
                }
            };
            lVar.jXo = new com.tencent.mm.ui.base.n.d() {
                public final void c(MenuItem menuItem, int i) {
                    if (dVar != null) {
                        dVar.bw(i, menuItem.getItemId());
                    }
                }
            };
            lVar.d(null);
            Dialog aXZ = lVar.aXZ();
            a(context, aXZ);
            return aXZ;
        }
        f fVar = new f(context, f.pbS, false);
        fVar.jXn = new com.tencent.mm.ui.base.n.c() {
            public final void a(l lVar) {
                if (!be.kS(str)) {
                    lVar.setHeaderTitle(str);
                }
                for (int i = 0; i < list.size(); i++) {
                    lVar.d(((Integer) list2.get(i)).intValue(), (CharSequence) list.get(i));
                }
                if (!be.kS(str2)) {
                    lVar.d(-1, str2);
                }
            }
        };
        fVar.jXo = new com.tencent.mm.ui.base.n.d() {
            public final void c(MenuItem menuItem, int i) {
                if (dVar != null) {
                    dVar.bw(i, menuItem.getItemId());
                }
            }
        };
        fVar.bKh();
        return null;
    }

    public static Dialog a(Context context, String str, String[] strArr, c cVar) {
        return a(context, str, strArr, null, true, cVar, null);
    }

    public static Dialog a(Context context, String str, String[] strArr, String str2, c cVar) {
        return a(context, str, strArr, str2, true, cVar, null);
    }

    public static Dialog a(Context context, String str, String[] strArr, String str2, boolean z, c cVar) {
        return a(context, str, strArr, str2, z, cVar, null);
    }

    public static Dialog a(Context context, String str, String[] strArr, String str2, c cVar, OnCancelListener onCancelListener) {
        return a(context, str, strArr, str2, true, cVar, onCancelListener);
    }

    @Deprecated
    public static Dialog a(Context context, final String str, String[] strArr, String str2, boolean z, final c cVar, OnCancelListener onCancelListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        if ((strArr == null || strArr.length == 0) && be.kS(str2)) {
            return null;
        }
        final ArrayList arrayList = new ArrayList();
        if (strArr != null && strArr.length > 0) {
            Collections.addAll(arrayList, strArr);
        }
        if (!be.kS(str2)) {
            arrayList.add(str2);
        }
        if (z) {
            l lVar = new l(context);
            lVar.jXn = new com.tencent.mm.ui.base.n.c() {
                public final void a(l lVar) {
                    lVar.setHeaderTitle(str);
                    for (int i = 0; i < arrayList.size(); i++) {
                        lVar.d(i, (CharSequence) arrayList.get(i));
                    }
                }
            };
            lVar.jXo = new com.tencent.mm.ui.base.n.d() {
                public final void c(MenuItem menuItem, int i) {
                    if (cVar != null) {
                        cVar.gT(menuItem.getItemId());
                    }
                }
            };
            lVar.d(onCancelListener);
            Dialog aXZ = lVar.aXZ();
            a(context, aXZ);
            return aXZ;
        }
        f fVar = new f(context, f.pbS, false);
        fVar.jXn = new com.tencent.mm.ui.base.n.c() {
            public final void a(l lVar) {
                lVar.setHeaderTitle(str);
                for (int i = 0; i < arrayList.size(); i++) {
                    lVar.d(i, (CharSequence) arrayList.get(i));
                }
            }
        };
        fVar.jXo = new com.tencent.mm.ui.base.n.d() {
            public final void c(MenuItem menuItem, int i) {
                if (cVar != null) {
                    cVar.gT(menuItem.getItemId());
                }
            }
        };
        fVar.bKh();
        return null;
    }
}
