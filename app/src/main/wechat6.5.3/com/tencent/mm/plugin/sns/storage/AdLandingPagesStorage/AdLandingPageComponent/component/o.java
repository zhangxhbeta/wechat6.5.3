package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingControlView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.sdk.platformtools.ac;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

public final class o extends j {
    private static final Map<String, Bitmap> jyz = new WeakHashMap();
    ViewPager jyA;
    a jyB;
    AdLandingControlView jyC;
    private int jyD = 0;
    boolean jyE = true;

    static class a extends t {
        int backgroundColor;
        LayoutInflater dY;
        i jyH;
        private int jyI = 600;
        int jyJ = 700;
        int jyK = 250;
        HashMap<String, View> jyL = new HashMap();
        HashMap<String, a> jyM = new HashMap();
        Context mContext;

        public class a {
            final /* synthetic */ a jyO;
            public LinkedList<j> jyS = new LinkedList();

            public a(a aVar) {
                this.jyO = aVar;
            }
        }

        static /* synthetic */ void a(a aVar, final ImageView imageView) {
            Animation animationSet = new AnimationSet(true);
            Animation translateAnimation = new TranslateAnimation(0.0f, -5.0f, 0.0f, 0.0f);
            translateAnimation.setDuration((long) aVar.jyJ);
            translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
            animationSet.addAnimation(translateAnimation);
            translateAnimation = new AlphaAnimation(0.8f, 0.3f);
            translateAnimation.setDuration((long) aVar.jyJ);
            translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
            animationSet.addAnimation(translateAnimation);
            animationSet.setAnimationListener(new AnimationListener(aVar) {
                final /* synthetic */ a jyO;

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    Animation animationSet = new AnimationSet(true);
                    Animation translateAnimation = new TranslateAnimation(-5.0f, 0.0f, 0.0f, 0.0f);
                    translateAnimation.setDuration((long) this.jyO.jyJ);
                    translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                    translateAnimation.setStartTime((long) this.jyO.jyJ);
                    animationSet.addAnimation(translateAnimation);
                    translateAnimation = new AlphaAnimation(0.3f, 0.8f);
                    translateAnimation.setDuration((long) this.jyO.jyJ);
                    translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                    translateAnimation.setStartTime((long) this.jyO.jyJ);
                    animationSet.addAnimation(translateAnimation);
                    animationSet.setAnimationListener(new AnimationListener(this) {
                        final /* synthetic */ AnonymousClass1 jyP;

                        {
                            this.jyP = r1;
                        }

                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            long longValue = new BigInteger((String) imageView.getTag()).longValue();
                            if (longValue >= 3) {
                                Animation alphaAnimation = new AlphaAnimation(0.8f, 0.0f);
                                alphaAnimation.setDuration((long) this.jyP.jyO.jyK);
                                alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                                alphaAnimation.setAnimationListener(new AnimationListener(this) {
                                    final /* synthetic */ AnonymousClass1 jyQ;

                                    {
                                        this.jyQ = r1;
                                    }

                                    public final void onAnimationStart(Animation animation) {
                                    }

                                    public final void onAnimationEnd(Animation animation) {
                                        imageView.setAlpha(0.0f);
                                    }

                                    public final void onAnimationRepeat(Animation animation) {
                                    }
                                });
                                imageView.startAnimation(alphaAnimation);
                                return;
                            }
                            imageView.setTag(String.valueOf(longValue + 1));
                            a.a(this.jyP.jyO, imageView);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    imageView.startAnimation(animationSet);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            imageView.startAnimation(animationSet);
        }

        public a(Context context, LayoutInflater layoutInflater, i iVar, int i) {
            this.mContext = context;
            this.dY = layoutInflater;
            this.jyH = iVar;
            this.backgroundColor = i;
        }

        public final int getCount() {
            return this.jyH.jvw.size();
        }

        public final boolean a(View view, Object obj) {
            return view == ((View) obj);
        }

        public final void d(Object obj) {
        }

        public final Object b(ViewGroup viewGroup, int i) {
            View inflate = this.dY.inflate(2130904429, viewGroup, false);
            WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
            int width = windowManager.getDefaultDisplay().getWidth();
            windowManager.getDefaultDisplay().getHeight();
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(2131759257);
            linearLayout.setBackgroundColor(this.backgroundColor);
            a aVar = (a) this.jyM.get(String.valueOf(i));
            Iterator it;
            j a;
            if (aVar == null || aVar.jyS.size() == 0) {
                a aVar2 = new a(this);
                it = ((h) this.jyH.jvw.get(i)).jvw.iterator();
                while (it.hasNext()) {
                    a = aj.a(this.mContext, (n) it.next(), linearLayout, this.backgroundColor);
                    aVar2.jyS.add(a);
                    linearLayout.addView(a.getView());
                }
                this.jyM.put(String.valueOf(i), aVar2);
            } else {
                it = aVar.jyS.iterator();
                while (it.hasNext()) {
                    a = (j) it.next();
                    if (a.getView().getParent() != null && (a.getView().getParent() instanceof ViewGroup)) {
                        ((ViewGroup) a.getView().getParent()).removeView(a.getView());
                    }
                    linearLayout.addView(a.getView());
                }
            }
            ImageView imageView = (ImageView) inflate.findViewById(2131759258);
            TextView textView = (TextView) inflate.findViewById(2131759259);
            if (this.backgroundColor - -16777216 <= -1 - this.backgroundColor) {
                imageView.setImageDrawable(com.tencent.mm.bd.a.a(this.mContext, 2130838834));
            } else {
                imageView.setImageDrawable(com.tencent.mm.bd.a.a(this.mContext, 2130838837));
            }
            if (this.jyH.jvy == 1) {
                imageView.setVisibility(8);
                textView.setVisibility(8);
            } else {
                if (i == this.jyH.jvw.size() - 1) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setVisibility(0);
                }
                textView.setText((i + 1) + "/" + this.jyH.jvw.size());
            }
            inflate.setLayoutParams(new LayoutParams(width, linearLayout.getMeasuredHeight()));
            inflate.setBackgroundColor(this.backgroundColor);
            viewGroup.addView(inflate);
            viewGroup.setBackgroundColor(this.backgroundColor);
            this.jyL.put(String.valueOf(i), inflate);
            return inflate;
        }

        public final void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public final void qu(int i) {
            View view = (View) this.jyL.get(String.valueOf(i));
            if (view != null) {
                final ImageView imageView = (ImageView) view.findViewById(2131759258);
                if (imageView != null && imageView.getVisibility() == 0) {
                    if (imageView.getTag() == null || !(imageView.getTag() instanceof String) || new BigInteger((String) imageView.getTag()).longValue() < 1) {
                        imageView.setTag("1");
                        Animation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
                        alphaAnimation.setDuration((long) this.jyI);
                        alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                        alphaAnimation.setAnimationListener(new AnimationListener(this) {
                            final /* synthetic */ a jyO;

                            public final void onAnimationStart(Animation animation) {
                            }

                            public final void onAnimationEnd(Animation animation) {
                                new ac().postDelayed(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass2 jyR;

                                    {
                                        this.jyR = r1;
                                    }

                                    public final void run() {
                                        a.a(this.jyR.jyO, imageView);
                                    }
                                }, 200);
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }
                        });
                        imageView.startAnimation(alphaAnimation);
                    }
                }
            }
        }

        public final void qv(int i) {
            for (String str : this.jyM.keySet()) {
                a aVar = (a) this.jyM.get(str);
                if (!(aVar == null || aVar.jyS.size() == 0)) {
                    int i2;
                    j jVar;
                    if (str.equals(String.valueOf(i))) {
                        for (i2 = 0; i2 < aVar.jyS.size(); i2++) {
                            jVar = (j) aVar.jyS.get(i2);
                            if (!jVar.jxY) {
                                jVar.aTO();
                            }
                        }
                    } else {
                        for (i2 = 0; i2 < aVar.jyS.size(); i2++) {
                            jVar = (j) aVar.jyS.get(i2);
                            if (jVar.jxY) {
                                jVar.aTP();
                            }
                        }
                    }
                }
            }
        }
    }

    public o(Context context, i iVar, ViewGroup viewGroup) {
        super(context, iVar, viewGroup);
        this.jyC = new AdLandingControlView(context);
    }

    public final void aTO() {
        this.jyB.qu(this.jyA.xB);
        if (this.jyE) {
            this.jyB.qv(0);
            this.jyE = false;
        } else {
            this.jyB.qv(this.jyD);
        }
        super.aTO();
    }

    public final void aTP() {
        this.jyB.qv(-1);
        super.aTP();
    }

    protected final void aTS() {
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        final a aVar = new a(this.context, layoutInflater, (i) this.jxU, this.backgroundColor);
        this.jyA.yk = new e(this) {
            final /* synthetic */ o jyG;

            public final void a(int i, float f, int i2) {
            }

            public final void W(int i) {
                this.jyG.jyC.qw(i);
                this.jyG.jyD = i;
                if (this.jyG.jxY) {
                    aVar.qu(i);
                    aVar.qv(i);
                }
            }

            public final void X(int i) {
            }
        };
        this.jyA.a(aVar);
        this.jyC.dh(((i) this.jxU).jvw.size(), 0);
        if (((i) this.jxU).jvz) {
            this.jyA.setLayoutParams(new LayoutParams(width, height));
        } else if (((i) this.jxU).jvw.size() > 0) {
            h hVar = (h) ((i) this.jxU).jvw.get(0);
            new LinearLayout(this.context).setOrientation(1);
            int i = 0;
            Iterator it = hVar.jvw.iterator();
            while (it.hasNext()) {
                n nVar = (n) it.next();
                int i2 = (int) (((float) i) + nVar.jvI);
                if (nVar instanceof p) {
                    p pVar = (p) nVar;
                    View inflate = layoutInflater.inflate(2130904428, null);
                    inflate.setBackgroundColor(this.backgroundColor);
                    ((TextView) inflate.findViewById(2131759256)).setText(pVar.jvX);
                    ((TextView) inflate.findViewById(2131759256)).measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    i = ((TextView) inflate.findViewById(2131759256)).getPaddingBottom() + ((i2 + ((TextView) inflate.findViewById(2131759256)).getPaddingTop()) + ((TextView) inflate.findViewById(2131759256)).getHeight());
                } else if (nVar instanceof g) {
                    Button button = (Button) layoutInflater.inflate(2130904420, null).findViewById(2131759239);
                    button.setText(((g) nVar).title);
                    button.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    i = button.getPaddingBottom() + ((button.getPaddingTop() + i2) + button.getHeight());
                } else if (nVar instanceof k) {
                    float f = 0.0f;
                    float f2 = 0.0f;
                    float f3 = nVar.jvI;
                    float f4 = nVar.jvJ;
                    if (nVar instanceof k) {
                        k kVar = (k) nVar;
                        f = kVar.height;
                        f2 = kVar.width;
                    }
                    if (((int) f) == 0 || ((int) f2) == 0) {
                        i = i2 + height;
                    } else {
                        i = (int) (((f * ((float) width)) / f2) + ((float) i2));
                    }
                    i = (int) (((float) ((int) (((float) i) + f3))) + f4);
                } else if (nVar instanceof j) {
                    i = i2 + height;
                } else if (nVar instanceof l) {
                    l lVar = (l) nVar;
                    if (lVar.jvD == 1) {
                        i = i2 + height;
                    } else if (((int) lVar.width) > 0) {
                        i = ((((int) lVar.height) * width) / ((int) lVar.width)) + i2;
                    } else {
                        i = (int) (lVar.height + ((float) i2));
                    }
                } else if (nVar instanceof r) {
                    r rVar = (r) nVar;
                    if (rVar.jwe != 1) {
                        i = i2 + height;
                    } else if (((int) rVar.width) > 0) {
                        i = ((((int) rVar.height) * width) / ((int) rVar.width)) + i2;
                    } else {
                        i = (int) (rVar.height + ((float) i2));
                    }
                } else if (nVar instanceof q) {
                    i = i2 + height;
                } else {
                    i = i2;
                }
                i = (int) (nVar.jvJ + ((float) i));
            }
            this.jyA.setLayoutParams(new LayoutParams(width, i));
        }
        this.jyB = aVar;
    }

    public final View aTM() {
        View view = this.dtW;
        this.jyA = (ViewPager) view.findViewById(2131759260);
        this.jyC = (AdLandingControlView) view.findViewById(2131759261);
        return view;
    }

    protected final int aGY() {
        return 2130904430;
    }

    public final boolean x(JSONObject jSONObject) {
        if (super.x(jSONObject)) {
            return true;
        }
        return false;
    }

    public final LinkedList<JSONObject> aUb() {
        a aVar = this.jyB;
        LinkedList<JSONObject> linkedList = new LinkedList();
        for (String str : aVar.jyM.keySet()) {
            a aVar2 = (a) aVar.jyM.get(str);
            if (!(aVar2 == null || aVar2.jyS.size() == 0)) {
                for (int i = 0; i < aVar2.jyS.size(); i++) {
                    j jVar = (j) aVar2.jyS.get(i);
                    JSONObject jSONObject = new JSONObject();
                    if (jVar.x(jSONObject)) {
                        linkedList.add(jSONObject);
                    }
                }
            }
        }
        return linkedList;
    }
}
