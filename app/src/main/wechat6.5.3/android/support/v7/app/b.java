package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.y;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.a.a.f;
import android.support.v7.app.a.AnonymousClass2;
import android.support.v7.app.a.AnonymousClass3;
import android.support.v7.app.a.AnonymousClass4;
import android.support.v7.app.a.AnonymousClass5;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public final class b extends i implements DialogInterface {
    private a Fx = new a(getContext(), this, getWindow());

    public static class a {
        public final android.support.v7.app.a.a Fy;
        public int ou;

        public a(Context context) {
            this(context, b.c(context, 0));
        }

        private a(Context context, int i) {
            this.Fy = new android.support.v7.app.a.a(new ContextThemeWrapper(context, b.c(context, i)));
            this.ou = i;
        }
    }

    public b(Context context, int i) {
        super(context, c(context, i));
    }

    static int c(Context context, int i) {
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.support.v7.a.a.a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.Fx.setTitle(charSequence);
    }

    protected final void onCreate(Bundle bundle) {
        int indexOfChild;
        super.onCreate(bundle);
        a aVar = this.Fx;
        int i = (aVar.EN == 0 || aVar.ES != 1) ? aVar.EM : aVar.EN;
        aVar.En.setContentView(i);
        View findViewById = aVar.Eo.findViewById(f.Jo);
        View findViewById2 = findViewById.findViewById(f.JG);
        View findViewById3 = findViewById.findViewById(f.Jg);
        View findViewById4 = findViewById.findViewById(f.Jf);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(f.Jh);
        View inflate = aVar.mView != null ? aVar.mView : aVar.Er != 0 ? LayoutInflater.from(aVar.mContext).inflate(aVar.Er, viewGroup, false) : null;
        Object obj = inflate != null ? 1 : null;
        if (obj == null || !a.aH(inflate)) {
            aVar.Eo.setFlags(131072, 131072);
        }
        if (obj != null) {
            FrameLayout frameLayout = (FrameLayout) aVar.Eo.findViewById(f.custom);
            frameLayout.addView(inflate, new LayoutParams(-1, -1));
            if (aVar.Ew) {
                frameLayout.setPadding(aVar.Es, aVar.Et, aVar.Eu, aVar.Ev);
            }
            if (aVar.Eq != null) {
                ((LinearLayout.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById5 = viewGroup.findViewById(f.JG);
        inflate = viewGroup.findViewById(f.Jg);
        View findViewById6 = viewGroup.findViewById(f.Jf);
        ViewGroup b = a.b(findViewById5, findViewById2);
        ViewGroup b2 = a.b(inflate, findViewById3);
        ViewGroup b3 = a.b(findViewById6, findViewById4);
        aVar.EG = (NestedScrollView) aVar.Eo.findViewById(f.Jr);
        aVar.EG.setFocusable(false);
        aVar.EG.setNestedScrollingEnabled(false);
        aVar.jp = (TextView) b2.findViewById(16908299);
        if (aVar.jp != null) {
            if (aVar.Ep != null) {
                aVar.jp.setText(aVar.Ep);
            } else {
                aVar.jp.setVisibility(8);
                aVar.EG.removeView(aVar.jp);
                if (aVar.Eq != null) {
                    ViewGroup viewGroup2 = (ViewGroup) aVar.EG.getParent();
                    indexOfChild = viewGroup2.indexOfChild(aVar.EG);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(aVar.Eq, indexOfChild, new LayoutParams(-1, -1));
                } else {
                    b2.setVisibility(8);
                }
            }
        }
        indexOfChild = 0;
        aVar.Ex = (Button) b3.findViewById(16908313);
        aVar.Ex.setOnClickListener(aVar.ET);
        if (TextUtils.isEmpty(aVar.Ey)) {
            aVar.Ex.setVisibility(8);
        } else {
            aVar.Ex.setText(aVar.Ey);
            aVar.Ex.setVisibility(0);
            indexOfChild = 1;
        }
        aVar.EA = (Button) b3.findViewById(16908314);
        aVar.EA.setOnClickListener(aVar.ET);
        if (TextUtils.isEmpty(aVar.EB)) {
            aVar.EA.setVisibility(8);
        } else {
            aVar.EA.setText(aVar.EB);
            aVar.EA.setVisibility(0);
            indexOfChild |= 2;
        }
        aVar.ED = (Button) b3.findViewById(16908315);
        aVar.ED.setOnClickListener(aVar.ET);
        if (TextUtils.isEmpty(aVar.EE)) {
            aVar.ED.setVisibility(8);
        } else {
            aVar.ED.setText(aVar.EE);
            aVar.ED.setVisibility(0);
            indexOfChild |= 4;
        }
        if ((indexOfChild != 0 ? 1 : null) == null) {
            b3.setVisibility(8);
        }
        if (aVar.EJ != null) {
            b.addView(aVar.EJ, 0, new LayoutParams(-1, -2));
            aVar.Eo.findViewById(f.JF).setVisibility(8);
        } else {
            aVar.kH = (ImageView) aVar.Eo.findViewById(16908294);
            if ((!TextUtils.isEmpty(aVar.up) ? 1 : null) != null) {
                aVar.EI = (TextView) aVar.Eo.findViewById(f.Je);
                aVar.EI.setText(aVar.up);
                if (aVar.EH != 0) {
                    aVar.kH.setImageResource(aVar.EH);
                } else if (aVar.jP != null) {
                    aVar.kH.setImageDrawable(aVar.jP);
                } else {
                    aVar.EI.setPadding(aVar.kH.getPaddingLeft(), aVar.kH.getPaddingTop(), aVar.kH.getPaddingRight(), aVar.kH.getPaddingBottom());
                    aVar.kH.setVisibility(8);
                }
            } else {
                aVar.Eo.findViewById(f.JF).setVisibility(8);
                aVar.kH.setVisibility(8);
                b.setVisibility(8);
            }
        }
        Object obj2 = (viewGroup == null || viewGroup.getVisibility() == 8) ? null : 1;
        obj = (b == null || b.getVisibility() == 8) ? null : 1;
        Object obj3 = (b3 == null || b3.getVisibility() == 8) ? null : 1;
        if (obj3 == null && b2 != null) {
            findViewById = b2.findViewById(f.JE);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        }
        if (!(obj == null || aVar.EG == null)) {
            aVar.EG.setClipToPadding(true);
        }
        if (obj2 == null) {
            inflate = aVar.Eq != null ? aVar.Eq : aVar.EG;
            if (inflate != null) {
                int i2 = (obj != null ? 1 : 0) | (obj3 != null ? 2 : 0);
                findViewById5 = aVar.Eo.findViewById(f.Jq);
                findViewById = aVar.Eo.findViewById(f.Jp);
                if (VERSION.SDK_INT >= 23) {
                    y.c(inflate, i2, 3);
                    if (findViewById5 != null) {
                        b2.removeView(findViewById5);
                    }
                    if (findViewById != null) {
                        b2.removeView(findViewById);
                    }
                } else {
                    if (findViewById5 != null && (i2 & 1) == 0) {
                        b2.removeView(findViewById5);
                        findViewById5 = null;
                    }
                    if (findViewById != null && (i2 & 2) == 0) {
                        b2.removeView(findViewById);
                        findViewById = null;
                    }
                    if (!(findViewById5 == null && findViewById == null)) {
                        if (aVar.Ep != null) {
                            aVar.EG.Cw = new AnonymousClass2(aVar, findViewById5, findViewById);
                            aVar.EG.post(new AnonymousClass3(aVar, findViewById5, findViewById));
                        } else if (aVar.Eq != null) {
                            aVar.Eq.setOnScrollListener(new AnonymousClass4(aVar, findViewById5, findViewById));
                            aVar.Eq.post(new AnonymousClass5(aVar, findViewById5, findViewById));
                        } else {
                            if (findViewById5 != null) {
                                b2.removeView(findViewById5);
                            }
                            if (findViewById != null) {
                                b2.removeView(findViewById);
                            }
                        }
                    }
                }
            }
        }
        ListView listView = aVar.Eq;
        if (listView != null && aVar.EK != null) {
            listView.setAdapter(aVar.EK);
            int i3 = aVar.EL;
            if (i3 >= 0) {
                listView.setItemChecked(i3, true);
                listView.setSelection(i3);
            }
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        a aVar = this.Fx;
        boolean z = aVar.EG != null && aVar.EG.executeKeyEvent(keyEvent);
        if (z) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        a aVar = this.Fx;
        boolean z = aVar.EG != null && aVar.EG.executeKeyEvent(keyEvent);
        if (z) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }
}
