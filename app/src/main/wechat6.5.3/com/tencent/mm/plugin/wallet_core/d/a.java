package com.tencent.mm.plugin.wallet_core.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.e.a.y;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a {
    ArrayList<a> kWK = new ArrayList();
    private c kWL = new c<y>(this) {
        final /* synthetic */ a kWO;

        {
            this.kWO = r2;
            this.nhz = y.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            while (this.kWO.kWK != null && this.kWO.kWK.size() > 0) {
                a aVar = (a) this.kWO.kWK.remove(0);
                if (aVar == null) {
                    break;
                }
                Bankcard bankcard = aVar.kGa;
                ImageView imageView = (ImageView) aVar.kWT.get();
                if (imageView != null) {
                    String str = (String) imageView.getTag(2131755078);
                    if (!be.kS(str) && ((!k.xT() && str.equals(bankcard.field_bankcardType)) || (k.xT() && str.equals(bankcard.field_bankName)))) {
                        d f = bankcard.kND == null ? k.xT() ? com.tencent.mm.plugin.wallet_core.c.b.f(imageView.getContext(), bankcard.field_bankName, false) : com.tencent.mm.plugin.wallet_core.c.b.f(imageView.getContext(), bankcard.field_bankcardType, bankcard.bfF()) : bankcard.kND;
                        a aVar2 = this.kWO;
                        if (f == null || aVar == null || aVar.kWT == null || aVar.kWT.get() == null) {
                            v.e("MicroMsg.BankcardLogoHelper", "bankUrls == null");
                        } else {
                            v.d("MicroMsg.BankcardLogoHelper", "bankLogoUrl = " + f.hGg);
                            imageView = (ImageView) aVar.kWT.get();
                            if (!be.kS(f.hGg)) {
                                imageView.post(new AnonymousClass2(aVar2, imageView, j.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(f.hGg))));
                                j.a(aVar);
                            } else if (f.kNH > 0) {
                                imageView.post(new AnonymousClass3(aVar2, imageView, f));
                            } else {
                                v.e("MicroMsg.BankcardLogoHelper", "bankcard logoUrl == null");
                            }
                        }
                        aVar2 = this.kWO;
                        if (!(f == null || aVar == null || aVar.kWU == null || aVar.kWU.get() == null)) {
                            View view = (View) aVar.kWU.get();
                            view.post(new AnonymousClass4(aVar2, view, f, aVar));
                        }
                        aVar2 = this.kWO;
                        if (!(f == null || aVar == null || aVar.kWU == null || aVar.kWU.get() == null)) {
                            imageView = (ImageView) aVar.kWV.get();
                            if (imageView != null) {
                                imageView.post(new AnonymousClass5(aVar2, f, imageView, aVar));
                            }
                        }
                    }
                }
            }
            return true;
        }
    };
    public LinkedList<String> kWM;
    public LinkedList<Bankcard> kWN;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ ImageView fwb;
        final /* synthetic */ a kWO;
        final /* synthetic */ Bitmap kWP;

        AnonymousClass2(a aVar, ImageView imageView, Bitmap bitmap) {
            this.kWO = aVar;
            this.fwb = imageView;
            this.kWP = bitmap;
        }

        public final void run() {
            this.fwb.setImageBitmap(this.kWP);
        }
    }

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ ImageView fwb;
        final /* synthetic */ a kWO;
        final /* synthetic */ d kWQ;

        AnonymousClass3(a aVar, ImageView imageView, d dVar) {
            this.kWO = aVar;
            this.fwb = imageView;
            this.kWQ = dVar;
        }

        public final void run() {
            this.fwb.setImageResource(this.kWQ.kNH);
        }
    }

    class AnonymousClass4 implements Runnable {
        final /* synthetic */ a kWO;
        final /* synthetic */ d kWQ;
        final /* synthetic */ View kWR;
        final /* synthetic */ a kWS;

        AnonymousClass4(a aVar, View view, d dVar, a aVar2) {
            this.kWO = aVar;
            this.kWR = view;
            this.kWQ = dVar;
            this.kWS = aVar2;
        }

        public final void run() {
            this.kWR.invalidate();
            String str = this.kWQ.kNF;
            int i = "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_bule_bg.9_v2.png".equals(str) ? 2130839495 : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_green_bg.9_v2.png".equals(str) ? 2130839499 : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_hbule_bg.9_v2.png".equals(str) ? 2130839501 : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_purple_bg.9_v2.png".equals(str) ? 2130839504 : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_red_bg.9_v2.png".equals(str) ? 2130839505 : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_yellow_bg.9_v2.png".equals(str) ? 2130839510 : -1;
            if (i != -1) {
                this.kWR.setBackgroundResource(i);
            } else if (!be.kS(this.kWQ.kNF)) {
                Bitmap a = j.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(this.kWQ.kNF));
                j.a(this.kWS);
                if (a != null) {
                    this.kWR.setBackgroundDrawable(com.tencent.mm.plugin.wallet_core.ui.view.b.e(this.kWR.getContext(), a));
                }
            } else if (this.kWQ.kNI > 0) {
                this.kWR.setBackgroundResource(this.kWQ.kNI);
            }
        }
    }

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ ImageView fwb;
        final /* synthetic */ a kWO;
        final /* synthetic */ d kWQ;
        final /* synthetic */ a kWS;

        AnonymousClass5(a aVar, d dVar, ImageView imageView, a aVar2) {
            this.kWO = aVar;
            this.kWQ = dVar;
            this.fwb = imageView;
            this.kWS = aVar2;
        }

        public final void run() {
            if (!be.kS(this.kWQ.kNG)) {
                this.fwb.setImageBitmap(j.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(this.kWQ.kNG)));
                j.a(this.kWS);
            } else if (this.kWQ.kNJ > 0) {
                this.fwb.setImageResource(this.kWQ.kNJ);
            }
        }
    }

    static class a implements com.tencent.mm.platformtools.j.a {
        Bankcard kGa;
        String kVq;
        WeakReference<ImageView> kWT;
        WeakReference<View> kWU = null;
        WeakReference<ImageView> kWV = null;

        a() {
        }

        public final void k(String str, final Bitmap bitmap) {
            v.d("MicroMsg.BankcardLogoHelper", str + ", bitmap = " + (bitmap == null));
            if (TextUtils.isEmpty(this.kVq)) {
                v.e("MicroMsg.BankcardLogoHelper", "mBankcardLogoUrl is empty");
            } else if (this.kWT != null) {
                final ImageView imageView = (ImageView) this.kWT.get();
                if (imageView != null && str != null && str.equals(this.kVq)) {
                    imageView.post(new Runnable(this) {
                        final /* synthetic */ a kWW;

                        public final void run() {
                            imageView.setImageBitmap(bitmap);
                        }
                    });
                    imageView.setTag(2131755078, null);
                }
            }
        }
    }

    public a() {
        com.tencent.mm.sdk.c.a.nhr.e(this.kWL);
    }

    public final void a(Context context, Bankcard bankcard, ImageView imageView) {
        a(context, bankcard, imageView, null, null);
    }

    public final void a(Context context, Bankcard bankcard, ImageView imageView, View view, ImageView imageView2) {
        a aVar = new a();
        aVar.kGa = bankcard;
        if (imageView != null) {
            imageView.setTag(2131755078, bankcard.field_bankcardType);
            aVar.kWT = new WeakReference(imageView);
        }
        if (view != null) {
            aVar.kWU = new WeakReference(view);
        }
        if (imageView2 != null) {
            aVar.kWV = new WeakReference(imageView2);
        }
        this.kWK.add(aVar);
        String str = k.xT() ? bankcard.field_bankName : bankcard.field_bankcardType;
        if (this.kWM != null && this.kWM.contains(str)) {
            v.i("MicroMsg.BankcardLogoHelper", "waiting resp:" + str);
        } else if (a(context, bankcard)) {
            com.tencent.mm.sdk.c.a.nhr.z(new y());
        } else {
            if (this.kWN == null) {
                this.kWN = new LinkedList();
            }
            this.kWN.add(bankcard);
            if (this.kWM == null) {
                b(context, this.kWN);
            }
        }
    }

    public final void destory() {
        com.tencent.mm.sdk.c.a.nhr.f(this.kWL);
        if (this.kWK != null) {
            this.kWK.clear();
            this.kWK = null;
        }
    }

    private static boolean a(Context context, Bankcard bankcard) {
        d f;
        if (k.xT()) {
            f = com.tencent.mm.plugin.wallet_core.c.b.f(context, bankcard.field_bankName, false);
        } else {
            f = com.tencent.mm.plugin.wallet_core.c.b.f(context, bankcard.field_bankcardType, bankcard.bfF());
        }
        if (f == null || f.kNK) {
            return false;
        }
        return true;
    }

    public final void b(final Context context, List<Bankcard> list) {
        if (list != null && list.size() > 0) {
            int size = list.size();
            this.kWM = new LinkedList();
            for (int i = 0; i < size; i++) {
                Bankcard bankcard = (Bankcard) list.get(i);
                if (!a(context, bankcard)) {
                    v.i("MicroMsg.BankcardLogoHelper", bankcard.field_bankcardType + "'s url is null or need update");
                    this.kWM.add(bankcard.field_bankcardType);
                }
            }
            if (this.kWM.size() > 0) {
                v.i("MicroMsg.BankcardLogoHelper", "doScene to get bankcard logo");
                com.tencent.mm.plugin.wallet_core.b.b bVar = new com.tencent.mm.plugin.wallet_core.b.b(this.kWM);
                ak.vy().a(1650, new e(this) {
                    final /* synthetic */ a kWO;

                    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                        ak.vy().b(1650, this);
                        this.kWO.kWM = null;
                        if (this.kWO.kWN != null) {
                            this.kWO.b(context, this.kWO.kWN);
                            this.kWO.kWN = null;
                        }
                    }
                });
                ak.vy().a(bVar, 0);
                return;
            }
            v.i("MicroMsg.BankcardLogoHelper", "use cache bankcard logo data");
            com.tencent.mm.sdk.c.a.nhr.z(new y());
        }
    }
}
