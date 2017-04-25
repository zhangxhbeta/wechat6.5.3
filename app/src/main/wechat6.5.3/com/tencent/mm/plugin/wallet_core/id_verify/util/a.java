package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.wallet_core.ui.g;
import com.tencent.mm.protocal.c.azn;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.c.b;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class a implements e {
    int cVh = -1;
    private a kMD = null;
    WeakReference<MMActivity> kME;
    WeakReference<b> kMF;
    private boolean kMG = false;
    h kMH;

    static class AnonymousClass6 implements OnClickListener {
        final /* synthetic */ int dBa;
        final /* synthetic */ Activity dpq;
        final /* synthetic */ int kMI;
        final /* synthetic */ Bundle kMN;
        final /* synthetic */ int kMO = 0;

        AnonymousClass6(Bundle bundle, int i, int i2, Activity activity, int i3) {
            this.kMN = bundle;
            this.kMI = i2;
            this.dpq = activity;
            this.dBa = i3;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            v.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog click OK");
            Bundle bundle = this.kMN;
            if (this.kMN == null) {
                bundle = new Bundle();
            }
            bundle.putInt("real_name_verify_mode", this.kMO);
            bundle.putInt("entry_scene", this.kMI);
            com.tencent.mm.wallet_core.a.a(this.dpq, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle);
            int i2 = 0;
            if (this.dBa == 1) {
                i2 = 9;
            } else if (this.dBa == 2) {
                i2 = 12;
            }
            com.tencent.mm.wallet_core.ui.e.b(i2, be.Nh(), this.kMI);
            dialogInterface.dismiss();
        }
    }

    public interface a {
        boolean a(int i, int i2, String str, boolean z);
    }

    public final boolean a(MMActivity mMActivity, int i, b bVar, a aVar, int i2) {
        this.kMG = false;
        ak.yW();
        long longValue = ((Long) c.vf().get(com.tencent.mm.storage.t.a.nsD, Long.valueOf(0))).longValue();
        if (longValue > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.wallet_core.ui.e.b(5, be.Nh(), i2);
            if (currentTimeMillis < longValue) {
                v.i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query is not expired. expiredTime = " + longValue);
                return false;
            }
            v.i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query had expired. expiredTime = " + longValue);
        }
        if (mMActivity == null) {
            v.e("MicroMsg.RealnameVerifyUtil", "context is null");
            return false;
        } else if (bVar == null) {
            v.e("MicroMsg.RealnameVerifyUtil", "netmgr is null");
            return false;
        } else {
            this.kME = new WeakReference(mMActivity);
            this.kMF = new WeakReference(bVar);
            this.cVh = i;
            this.kMD = aVar;
            if (i < 0 || aVar == null) {
                boolean z;
                String str = "MicroMsg.RealnameVerifyUtil";
                StringBuilder append = new StringBuilder("scene = ").append(i).append(";callback is null?");
                if (aVar == null) {
                    z = true;
                } else {
                    z = false;
                }
                v.e(str, append.append(z).toString());
                this.kMD = null;
                return false;
            }
            com.tencent.mm.wallet_core.ui.e.b(4, be.Nh(), i2);
            ak.vy().a(385, this);
            bVar.a(new com.tencent.mm.plugin.wallet_core.id_verify.a.e(i, i2), true);
            return true;
        }
    }

    private void axH() {
        if (this.kMF != null && this.kMF.get() != null) {
            ((b) this.kMF.get()).axH();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.a.e) {
            ak.vy().b(385, this);
            axH();
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.wallet_core.id_verify.a.e eVar = (com.tencent.mm.plugin.wallet_core.id_verify.a.e) kVar;
                boolean equals = eVar.kMs.equals("1");
                if (equals) {
                    v.i("MicroMsg.RealnameVerifyUtil", "user had agreed");
                    b(0, i2, str, equals);
                    return;
                }
                b((MMActivity) this.kME.get(), (b) this.kMF.get(), eVar.title, eVar.kMt, eVar.kMu, eVar.kMv, this.kMD, false, eVar.kMw);
                return;
            }
            b(2, i2, str, false);
        } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.a.a) {
            ak.vy().a(385, this);
            axH();
            if (i == 0 && i2 == 0) {
                b(0, i2, str, true);
            } else {
                b(3, i2, str, false);
            }
        }
    }

    public static void a(MMActivity mMActivity, b bVar, String str, String str2, String str3, String str4, a aVar, boolean z, int i) {
        new a().b(mMActivity, bVar, str, str2, str3, str4, aVar, z, i);
    }

    private void b(final MMActivity mMActivity, b bVar, String str, String str2, final String str3, String str4, a aVar, boolean z, int i) {
        this.kME = new WeakReference(mMActivity);
        this.kMF = new WeakReference(bVar);
        this.kMG = z;
        if (this.kME != null && this.kME.get() != null) {
            this.kMD = aVar;
            CharSequence charSequence = str + str2;
            g gVar = new g(mMActivity);
            final int i2 = i;
            gVar.kTx = new com.tencent.mm.plugin.wallet_core.ui.g.a(this) {
                final /* synthetic */ a kMK;

                public final void onClick(View view) {
                    com.tencent.mm.wallet_core.ui.e.b(3, be.Nh(), i2);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str3);
                    intent.putExtra("showShare", false);
                    com.tencent.mm.ay.c.b(mMActivity, "webview", ".ui.tools.WebViewUI", intent);
                }
            };
            charSequence = com.tencent.mm.pluginsdk.ui.d.e.a(mMActivity, charSequence);
            CharSequence spannableString = new SpannableString(charSequence);
            spannableString.setSpan(gVar, charSequence.length() - str2.length(), charSequence.length(), 33);
            View textView = new TextView(mMActivity);
            textView.setText(spannableString);
            textView.setTextSize(0, (float) mMActivity.getResources().getDimensionPixelSize(2131493128));
            textView.setTextColor(mMActivity.getResources().getColorStateList(2131689909));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            com.tencent.mm.wallet_core.ui.e.b(0, be.Nh(), i);
            String string = mMActivity.getString(2131231565);
            i2 = i;
            OnClickListener anonymousClass3 = new OnClickListener(this) {
                final /* synthetic */ a kMK;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.wallet_core.ui.e.b(2, be.Nh(), i2);
                    if (this.kMK.kMF != null && this.kMK.kMF.get() != null) {
                        ak.vy().a(385, this.kMK);
                        ((b) this.kMK.kMF.get()).a(new com.tencent.mm.plugin.wallet_core.id_verify.a.a(this.kMK.cVh), true);
                    }
                }
            };
            i2 = i;
            this.kMH = com.tencent.mm.ui.base.g.a(mMActivity, "", textView, str4, string, anonymousClass3, new OnClickListener(this) {
                final /* synthetic */ a kMK;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.wallet_core.ui.e.b(1, be.Nh(), i2);
                    this.kMK.b(1, -1, "cancel", false);
                }
            });
        }
    }

    final void b(int i, int i2, String str, boolean z) {
        v.i("MicroMsg.RealnameVerifyUtil", "doGetDisclaimerCallback call");
        if (this.kMD != null) {
            ak.yW();
            c.vf().a(com.tencent.mm.storage.t.a.nsE, Integer.valueOf(z ? 0 : 1));
            this.kMD.a(i, i2, str, z);
            if (this.kMH != null) {
                this.kMH.dismiss();
            }
            this.kMG = false;
            if (this.kMH != null) {
                v.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : close mDisclaimerDialog");
                this.kMH = null;
            }
            if (this.kMF != null) {
                v.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mNetSceneMgr");
                this.kMF.clear();
                this.kMF = null;
            }
            if (this.kME != null) {
                v.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mContextReference");
                this.kME.clear();
                this.kME = null;
            }
            v.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear getDisclaimerCallback");
            this.kMD = null;
        }
    }

    private static JSONObject n(k kVar) {
        if (kVar != null && (kVar instanceof com.tencent.mm.wallet_core.e.a.g)) {
            com.tencent.mm.v.b bVar = ((com.tencent.mm.wallet_core.e.a.g) kVar).cif;
            if (bVar != null) {
                azn com_tencent_mm_protocal_c_azn = (azn) bVar.czl.czs;
                if (com_tencent_mm_protocal_c_azn.mDl != null) {
                    try {
                        return new JSONObject(m.b(com_tencent_mm_protocal_c_azn.mDl));
                    } catch (Throwable e) {
                        v.a("MicroMsg.RealnameVerifyUtil", e, "", new Object[0]);
                        return null;
                    }
                }
            }
        }
        return null;
    }

    public static boolean a(Activity activity, int i, k kVar, Bundle bundle, int i2) {
        if (i != 416) {
            v.i("MicroMsg.RealnameVerifyUtil", "don't need realname verify");
            return false;
        }
        v.i("MicroMsg.RealnameVerifyUtil", "need realname verify");
        return a(activity, kVar, bundle, false, null, i2, 2);
    }

    public static boolean a(Activity activity, k kVar, Bundle bundle, boolean z, OnClickListener onClickListener, int i, int i2) {
        String str;
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        JSONObject n = n(kVar);
        if (n != null) {
            if (n.has("real_name_info")) {
                n = n.optJSONObject("real_name_info");
            }
            str2 = n.optString("guide_flag", "0");
            str3 = n.optString("guide_wording");
            str4 = n.optString("left_button_wording", activity.getString(2131231565));
            str5 = n.optString("right_button_wording", activity.getString(2131231107));
            str6 = n.optString("upload_credit_url", "");
            str = str2;
        } else {
            str = str2;
        }
        v.i("MicroMsg.RealnameVerifyUtil", "guide_flag = " + str + ";upload_credit_url=" + str6);
        if ("1".equals(str)) {
            v.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog");
            return a(activity, str3, str4, str5, bundle, z, null, i, i2);
        } else if (!"2".equals(str) || be.kS(str6)) {
            v.e("MicroMsg.RealnameVerifyUtil", "guide_flag=" + str + ";upload_credit_url=null?" + be.kS(str6));
            return false;
        } else {
            v.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog");
            return a(activity, str3, str6, str4, str5, z, null);
        }
    }

    public static boolean a(final Activity activity, String str, String str2, String str3, Bundle bundle, boolean z, OnClickListener onClickListener, int i, int i2) {
        v.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog call");
        if (be.kS(str2)) {
            str2 = activity.getString(2131231010);
        }
        if (be.kS(str3)) {
            return false;
        }
        OnClickListener anonymousClass5;
        if (onClickListener == null) {
            v.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog use default calcel listener");
            final boolean z2 = z;
            final int i3 = i2;
            final int i4 = i;
            anonymousClass5 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (z2) {
                        activity.finish();
                    }
                    dialogInterface.dismiss();
                    int i2 = 0;
                    if (i3 == 1) {
                        i2 = 8;
                    } else if (i3 == 2) {
                        i2 = 11;
                    }
                    com.tencent.mm.wallet_core.ui.e.b(i2, be.Nh(), i4);
                }
            };
        } else {
            anonymousClass5 = onClickListener;
        }
        v.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog show");
        if (i2 == 1) {
            com.tencent.mm.wallet_core.ui.e.b(7, be.Nh(), i);
        } else if (i2 == 2) {
            com.tencent.mm.wallet_core.ui.e.b(10, be.Nh(), i);
        }
        h a = com.tencent.mm.ui.base.g.a(activity, str, "", str3, str2, new AnonymousClass6(bundle, 0, i, activity, i2), anonymousClass5, 2131690123);
        if (a != null) {
            a.setCancelable(false);
        }
        return true;
    }

    public static boolean a(final Activity activity, String str, final String str2, String str3, String str4, final boolean z, OnClickListener onClickListener) {
        String string;
        String string2;
        OnClickListener anonymousClass7;
        if (be.kS(str3)) {
            string = activity.getString(2131231010);
        } else {
            string = str3;
        }
        if (be.kS(str4)) {
            string2 = activity.getString(2131231107);
        } else {
            string2 = str4;
        }
        if (onClickListener == null) {
            v.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog use default calcel listener");
            anonymousClass7 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    v.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click cancel");
                    dialogInterface.dismiss();
                    if (z) {
                        activity.finish();
                    }
                }
            };
        } else {
            anonymousClass7 = onClickListener;
        }
        h a = com.tencent.mm.ui.base.g.a(activity, str, "", string2, string, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                v.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click OK");
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                intent.putExtra("showShare", false);
                com.tencent.mm.ay.c.b(activity, "webview", ".ui.tools.WebViewUI", intent);
                dialogInterface.dismiss();
                if (z) {
                    activity.finish();
                }
            }
        }, anonymousClass7, 2131690123);
        if (a != null) {
            a.setOnCancelListener(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    if (z) {
                        activity.finish();
                    }
                }
            });
            a.setOnDismissListener(new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    if (z) {
                        activity.finish();
                    }
                }
            });
        }
        return true;
    }
}
