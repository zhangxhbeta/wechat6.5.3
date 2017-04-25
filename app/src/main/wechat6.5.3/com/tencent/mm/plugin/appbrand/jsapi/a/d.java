package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import com.tencent.mm.model.o;
import com.tencent.mm.plugin.appbrand.jsapi.br;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.appbrand.widget.input.c;
import com.tencent.mm.plugin.appbrand.widget.input.c.AnonymousClass7;
import com.tencent.mm.plugin.appbrand.widget.input.c.b;
import com.tencent.mm.plugin.appbrand.widget.input.f;
import com.tencent.mm.plugin.appbrand.widget.input.g;
import com.tencent.mm.plugin.appbrand.widget.input.i;
import com.tencent.mm.plugin.appbrand.widget.input.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class d extends a<b> {
    static final int CTRL_INDEX = 1;
    static final String NAME = "showKeyboard";

    private static final class a extends e {
        private static final int CTRL_INDEX = 78;
        private static final String NAME = "onKeyboardValueChange";

        private a() {
        }
    }

    public void a(final h hVar, JSONObject jSONObject, final int i) {
        final String str = hVar.dzg;
        final int hashCode = hVar.hashCode();
        final String optString = jSONObject.optString("inputId", "");
        if (be.kS(optString)) {
            final b bVar = new b();
            if (a(bVar, jSONObject, hVar, i)) {
                final String optString2 = jSONObject.optString("data", Columns.VALUE);
                final WeakReference weakReference = new WeakReference(hVar);
                bVar.dXc = weakReference;
                final c anonymousClass2 = new c(this) {
                    final /* synthetic */ d dKa;

                    public final void e(String str, boolean z, boolean z2) {
                        if (this.dKa.Qs()) {
                            com.tencent.mm.plugin.appbrand.k.a.aD(this);
                        }
                        if (weakReference.get() != null) {
                            try {
                                String jSONObject = new JSONObject().put(Columns.VALUE, str).put("inputId", this.dWK).toString();
                                if (z) {
                                    ((h) weakReference.get()).aP("onKeyboardConfirm", jSONObject);
                                }
                                if (!z2) {
                                    ((h) weakReference.get()).aP("onKeyboardComplete", jSONObject);
                                }
                            } catch (Throwable e) {
                                v.e("MicroMsg.JsApiShowKeyboard", "dispatch input done, exp = %s", new Object[]{be.e(e)});
                            }
                            Qv();
                        }
                    }

                    public final void Qt() {
                        if (weakReference.get() != null) {
                            Map hashMap = new HashMap(1);
                            hashMap.put("inputId", this.dWK);
                            ((h) weakReference.get()).y(i, this.dKa.c("ok", hashMap));
                            a.aM(this.dWK, optString2);
                            String str = this.dWK;
                            h hVar = (h) weakReference.get();
                            if (hVar != null) {
                                o.yx().n("AppBrandJsInput@" + str, true).l("webview_reference", new WeakReference(hVar));
                            }
                        }
                    }

                    public final void Qu() {
                        com.tencent.mm.plugin.appbrand.k.a.aD(this);
                        if (weakReference.get() != null) {
                            ((h) weakReference.get()).y(i, this.dKa.c("fail", null));
                            Qv();
                        }
                    }

                    private void Qv() {
                        if (weakReference.get() != null) {
                            ((h) weakReference.get()).dNn.getView().setFocusable(true);
                            ((h) weakReference.get()).dNn.getView().setFocusableInTouchMode(true);
                        }
                    }
                };
                anonymousClass2.dWB = new c.e(this) {
                    final /* synthetic */ d dKa;

                    public final void nH(String str) {
                        String str2 = anonymousClass2.dWK;
                        if (!be.kS(str2)) {
                            a aVar = new a();
                            Map hashMap = new HashMap();
                            hashMap.put(Columns.VALUE, str);
                            hashMap.put("data", o.yx().n("AppBrandJsInput@" + str2, true).getString("passing_data", ""));
                            hashMap.put("inputId", str2);
                            aVar.aa(str, hashCode).o(hashMap).PX();
                        }
                    }
                };
                a(anonymousClass2);
                com.tencent.mm.plugin.appbrand.k.a.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ d dKa;

                    public final void run() {
                        ((h) weakReference.get()).dNn.getView().setFocusable(false);
                        ((h) weakReference.get()).dNn.getView().setFocusableInTouchMode(false);
                        c cVar = anonymousClass2;
                        b bVar = bVar;
                        com.tencent.mm.plugin.appbrand.k.a.aC(cVar);
                        cVar.dWJ = bVar;
                        cVar.dGH = cVar.dWJ.dXc;
                        if (cVar.dGH == null || cVar.dGH.get() == null || ((h) cVar.dGH.get()).dNn == null) {
                            v.e("MicroMsg.AppBrandInputInvokeHandler", "insertInputImpl, view not ready, return fail");
                            cVar.Qu();
                            return;
                        }
                        boolean z;
                        cVar.dWL = new j(((h) cVar.dGH.get()).getContext());
                        cVar.bG(true);
                        cVar.dWL.addTextChangedListener(new TextWatcher(cVar) {
                            final /* synthetic */ c dWU;

                            {
                                this.dWU = r1;
                            }

                            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                            }

                            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                            }

                            public final void afterTextChanged(Editable editable) {
                                if (this.dWU.dGH != null && this.dWU.dGH.get() != null && this.dWU.dWL != null) {
                                    this.dWU.dWL.post(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass15 fVC;

                                        {
                                            this.fVC = r1;
                                        }

                                        public final void run() {
                                            if (this.fVC.dWU.dWL == null) {
                                                v.e("MicroMsg.AppBrandInputInvokeHandler", "runnable post by afterTextChanged, get null input");
                                                return;
                                            }
                                            if (be.kS((String) this.fVC.dWU.dWL.getTag(2131755012))) {
                                                v.e("MicroMsg.AppBrandInputInvokeHandler", "runnable post by afterTextChanged, get Null Or Nil inputId");
                                            }
                                            String obj = this.fVC.dWU.dWL.getText().toString();
                                            this.fVC.dWU.fnw.removeCallbacks(this.fVC.dWU.fVt);
                                            this.fVC.dWU.fVt.value = obj;
                                            this.fVC.dWU.fnw.postDelayed(this.fVC.dWU.fVt, (long) (this.fVC.dWU.fVu ? br.CTRL_INDEX : 10));
                                            c.i(this.fVC.dWU);
                                        }
                                    });
                                }
                            }
                        });
                        View view = cVar.dWL;
                        int intValue = cVar.dWJ.dXf.intValue();
                        int intValue2 = cVar.dWJ.dXg.intValue();
                        int intValue3 = cVar.dWJ.dXi.intValue();
                        int intValue4 = cVar.dWJ.dXh.intValue();
                        if (view == null || cVar.dGH == null || cVar.dGH.get() == null) {
                            z = false;
                        } else {
                            com.tencent.mm.plugin.appbrand.widget.input.b bVar2 = ((h) cVar.dGH.get()).dOh;
                            z = bVar2 != null && bVar2.a(((h) cVar.dGH.get()).dNn, view, intValue, intValue2, intValue3, intValue4);
                        }
                        if (z) {
                            if (cVar.dWJ.dXy == null || !cVar.dWJ.dXy.booleanValue()) {
                                cVar.dWL.post(new Runnable(cVar) {
                                    final /* synthetic */ c dWU;

                                    {
                                        this.dWU = r1;
                                    }

                                    public final void run() {
                                        if (this.dWU.dWL != null) {
                                            this.dWU.dWL.setSelection(this.dWU.dWL.getText().length());
                                        }
                                    }
                                });
                            }
                            cVar.dWL.post(new Runnable(cVar) {
                                final /* synthetic */ c dWU;

                                {
                                    this.dWU = r1;
                                }

                                public final void run() {
                                    c.i(this.dWU);
                                }
                            });
                            com.tencent.mm.plugin.appbrand.widget.input.d bF;
                            if ("text".equalsIgnoreCase(cVar.dWJ.dWY) || "emoji".equalsIgnoreCase(cVar.dWJ.dWY)) {
                                bF = com.tencent.mm.plugin.appbrand.widget.input.d.bF((View) cVar.dGH.get());
                                if (bF.dXI == null || !(bF.dXI instanceof f)) {
                                    bF.dXI = new f();
                                }
                                bF.dXH = (f) bF.dXI;
                                cVar.SQ();
                                cVar.ST();
                                if (cVar.dWM == null) {
                                    cVar.dWM = new i(((h) cVar.dGH.get()).getContext());
                                    bF.bG(cVar.dWM);
                                }
                                ((f) bF.dXI).dYb = cVar.dWM;
                                cVar.SO();
                                cVar.dWL.setOnFocusChangeListener(new OnFocusChangeListener(cVar) {
                                    final /* synthetic */ c dWU;

                                    {
                                        this.dWU = r1;
                                    }

                                    public final void onFocusChange(View view, boolean z) {
                                        c.b(this.dWU, z);
                                        Object obj = (!z || (this.dWU.dWJ.dXa && !com.tencent.mm.plugin.appbrand.ui.f.dg(this.dWU.dWL))) ? null : 1;
                                        if (obj != null && this.dWU.dWL != null && this.dWU.dWM != null) {
                                            this.dWU.dWL.requestFocus();
                                            this.dWU.dWM.show();
                                        }
                                    }
                                });
                                cVar.dWL.setOnKeyListener(new OnKeyListener(cVar) {
                                    final /* synthetic */ c dWU;

                                    {
                                        this.dWU = r1;
                                    }

                                    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                                        this.dWU.fVu = 67 == i;
                                        if (this.dWU.fVu) {
                                            this.dWU.fnw.removeCallbacks(this.dWU.fVv);
                                            this.dWU.fnw.postDelayed(this.dWU.fVv, 1000);
                                        } else {
                                            this.dWU.fVv.run();
                                        }
                                        return false;
                                    }
                                });
                                com.tencent.mm.plugin.appbrand.widget.input.e.a((h) cVar.dGH.get(), cVar.dWL);
                                i iVar = cVar.dWM;
                                if (!cVar.dWJ.dWZ) {
                                    "emoji".equals(cVar.dWJ.dWY);
                                }
                                iVar.bRJ();
                                cVar.dWL.setRawInputType(1);
                                if (cVar.dWJ.dXw.booleanValue()) {
                                    cVar.dWL.setOnEditorActionListener(null);
                                    cVar.dWL.setImeOptions(0);
                                } else {
                                    int i = (cVar.dWJ.lqI == null ? com.tencent.mm.plugin.appbrand.widget.input.e.a.bRH() : cVar.dWJ.lqI).lqQ;
                                    cVar.dWL.setImeOptions(i);
                                    cVar.dWL.setOnEditorActionListener(new AnonymousClass7(cVar, i));
                                }
                                cVar.dWM.bJ(cVar.dWJ.dXx.booleanValue());
                                cVar.dWM.dYz = cVar.dWL;
                                if (cVar.dWJ.dXw.booleanValue()) {
                                    cVar.dWL.setFocusable(false);
                                    cVar.dWL.setFocusableInTouchMode(false);
                                } else {
                                    cVar.dWL.requestFocus();
                                    cVar.dWM.show();
                                }
                                if (!cVar.dWJ.dXw.booleanValue()) {
                                    cVar.dWL.post(new c(cVar) {
                                        final /* synthetic */ c dWU;

                                        {
                                            this.dWU = r2;
                                        }

                                        public final View SW() {
                                            return this.dWU.dWM;
                                        }
                                    });
                                }
                                ((h) cVar.dGH.get()).a(new h.b(cVar) {
                                    final /* synthetic */ c dWU;

                                    {
                                        this.dWU = r1;
                                    }

                                    public final void onDestroy() {
                                        this.dWU.SR();
                                    }
                                });
                            } else if ("digit".equalsIgnoreCase(cVar.dWJ.dWY) || "number".equalsIgnoreCase(cVar.dWJ.dWY) || "idcard".equalsIgnoreCase(cVar.dWJ.dWY)) {
                                cVar.SS();
                                cVar.SR();
                                c.setNoSystemInputOnEditText(cVar.dWL);
                                bF = com.tencent.mm.plugin.appbrand.widget.input.d.bF((View) cVar.dGH.get());
                                if (cVar.dWN == null) {
                                    cVar.dWN = new g(((h) cVar.dGH.get()).getContext());
                                    bF.bG(cVar.dWN);
                                }
                                cVar.dWL.setOnFocusChangeListener(new OnFocusChangeListener(cVar) {
                                    final /* synthetic */ c dWU;

                                    {
                                        this.dWU = r1;
                                    }

                                    public final void onFocusChange(View view, boolean z) {
                                        if (!(view instanceof j)) {
                                            return;
                                        }
                                        if (z) {
                                            this.dWU.dWL = (j) view;
                                            if (this.dWU.dWN == null) {
                                                this.dWU.SS();
                                                if (this.dWU.dWN != null) {
                                                    this.dWU.dWN.setInputEditText(this.dWU.dWL);
                                                }
                                            }
                                            if (!(this.dWU.dGH == null || this.dWU.dGH.get() == null)) {
                                                e.a((com.tencent.mm.plugin.appbrand.page.h) this.dWU.dGH.get(), this.dWU.dWL);
                                            }
                                            c.a(this.dWU.dWL);
                                            ad.o(new Runnable(this) {
                                                final /* synthetic */ AnonymousClass10 fVA;

                                                {
                                                    this.fVA = r1;
                                                }

                                                public final void run() {
                                                    this.fVA.dWU.SU();
                                                }
                                            });
                                            return;
                                        }
                                        c.q(this.dWU);
                                    }
                                });
                                cVar.SV();
                                cVar.dWN.dYd = new g.b(cVar) {
                                    final /* synthetic */ c dWU;

                                    {
                                        this.dWU = r1;
                                    }

                                    public final void onDone() {
                                        c.q(this.dWU);
                                    }
                                };
                                cVar.dWN.setInputEditText(cVar.dWL);
                                cVar.dWL.requestFocus();
                                cVar.SU();
                                ((h) cVar.dGH.get()).a(new h.b(cVar) {
                                    final /* synthetic */ c dWU;

                                    {
                                        this.dWU = r1;
                                    }

                                    public final void onDestroy() {
                                        this.dWU.ST();
                                    }
                                });
                            }
                            if (!(cVar.dGH == null || cVar.dGH.get() == null)) {
                                ((h) cVar.dGH.get()).a(new h.b(cVar) {
                                    final /* synthetic */ c dWU;

                                    {
                                        this.dWU = r1;
                                    }

                                    public final void onDestroy() {
                                        if (!(this.dWU.dGH == null || this.dWU.dGH.get() == null)) {
                                            if (((com.tencent.mm.plugin.appbrand.page.h) this.dWU.dGH.get()).getContext() != null && (((com.tencent.mm.plugin.appbrand.page.h) this.dWU.dGH.get()).getContext() instanceof MMActivity)) {
                                                ((MMActivity) ((com.tencent.mm.plugin.appbrand.page.h) this.dWU.dGH.get()).getContext()).axg();
                                            }
                                            d bF = d.bF((View) this.dWU.dGH.get());
                                            if (!(bF == null || bF.dXI == null || !(bF.dXI instanceof f))) {
                                                ((f) bF.dXI).dYb = null;
                                            }
                                            e.n((com.tencent.mm.plugin.appbrand.page.h) this.dWU.dGH.get());
                                        }
                                        this.dWU.onDestroy();
                                    }
                                });
                            }
                            cVar.dWK = String.valueOf(com.tencent.mm.plugin.appbrand.jsapi.base.e.a((h) cVar.dGH.get(), cVar.dWL));
                            cVar.dWL.setTag(2131755012, cVar.dWK);
                            cVar.dWL.setOnClickListener(new OnClickListener(cVar) {
                                final /* synthetic */ c dWU;

                                {
                                    this.dWU = r1;
                                }

                                public final void onClick(View view) {
                                    if (this.dWU.dWL != null) {
                                        if (this.dWU.dWL.hasFocus()) {
                                            this.dWU.SZ();
                                        } else if (this.dWU.dWL != null && view == this.dWU.dWL && view.getOnFocusChangeListener() != null) {
                                            this.dWU.dWL.setFocusable(true);
                                            this.dWU.dWL.setFocusableInTouchMode(true);
                                            this.dWU.dWL.requestFocus();
                                        }
                                    }
                                }
                            });
                            com.tencent.mm.plugin.appbrand.widget.input.e.a(cVar.dWK, cVar);
                            cVar.Qt();
                            return;
                        }
                        v.e("MicroMsg.AppBrandInputInvokeHandler", "add custom view into webView failed");
                        cVar.Qu();
                    }
                });
                return;
            }
            return;
        }
        ad.o(new Runnable(this) {
            final /* synthetic */ d dKa;

            public final void run() {
                if (com.tencent.mm.plugin.appbrand.widget.input.e.a(hVar, optString)) {
                    hVar.y(i, this.dKa.c("ok", null));
                } else {
                    hVar.y(i, this.dKa.c("fail:invalid data", null));
                }
            }
        });
    }

    protected void a(c cVar) {
    }

    protected boolean Qs() {
        return true;
    }

    protected boolean a(b bVar, JSONObject jSONObject, h hVar, int i) {
        if (!super.a(bVar, jSONObject, hVar, i)) {
            return false;
        }
        if (!bVar.dXb && bVar.dXg.intValue() <= 0) {
            return false;
        }
        bVar.dWY = jSONObject.optString(Columns.TYPE, "text");
        if (com.tencent.mm.plugin.appbrand.widget.input.e.dXO.contains(bVar.dWY)) {
            bVar.dWZ = jSONObject.optBoolean("password");
            return true;
        }
        hVar.y(i, c("fail:unsupported input type", null));
        return false;
    }
}
