package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.l;
import com.tencent.mm.modelbiz.a.e;
import com.tencent.mm.modelbiz.a.h;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.k;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.q;
import java.util.HashMap;

@a(19)
public class BizChatSelectConversationUI extends MMBaseSelectContactUI implements k {
    private p dwg = null;
    private String ezn = null;
    j ohB;
    private TextView oiD;
    private int scene = 0;

    static /* synthetic */ void a(BizChatSelectConversationUI bizChatSelectConversationUI) {
        bizChatSelectConversationUI.ohB = u.DC().ig(u.DC().ii(bizChatSelectConversationUI.ezn));
        if (bizChatSelectConversationUI.ohB == null || be.kS(bizChatSelectConversationUI.ohB.field_addMemberUrl)) {
            String str = "MicroMsg.BizChatSelectConversationUI";
            String str2 = "field_addMemberUrl:%s";
            Object[] objArr = new Object[1];
            objArr[0] = bizChatSelectConversationUI.ohB != null ? bizChatSelectConversationUI.ohB.field_addMemberUrl : null;
            v.i(str, str2, objArr);
            Toast.makeText(bizChatSelectConversationUI, bizChatSelectConversationUI.getString(2131231495), 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", bizChatSelectConversationUI.ohB.field_addMemberUrl);
        v.i("MicroMsg.BizChatSelectConversationUI", "KRawUrl :%s", bizChatSelectConversationUI.ohB.field_addMemberUrl);
        intent.putExtra("useJs", true);
        c.b(bizChatSelectConversationUI.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent, 1);
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        this.scene = getIntent().getIntExtra("biz_chat_scene", 1);
        bDC();
        String ii = u.DC().ii(this.ezn);
        this.ohB = u.DC().ig(ii);
        String str = "MicroMsg.BizChatSelectConversationUI";
        String str2 = "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s";
        Object[] objArr = new Object[3];
        objArr[0] = this.ezn;
        objArr[1] = ii;
        if (this.ohB == null) {
            z = true;
        }
        objArr[2] = Boolean.valueOf(z);
        v.i(str, str2, objArr);
        if (be.kS(ii) || this.ohB == null || this.ohB.DO() || be.kS(this.ohB.field_addMemberUrl)) {
            u.DE();
            h.a(this.ezn, (k) this);
            getString(2131231164);
            this.dwg = g.a((Context) this, getString(2131231182), true, new OnCancelListener(this) {
                final /* synthetic */ BizChatSelectConversationUI oiE;

                {
                    this.oiE = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.oiE.finish();
                }
            });
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    private void bDC() {
        if (be.kS(this.ezn)) {
            this.ezn = getIntent().getStringExtra("enterprise_biz_name");
            if (be.kS(this.ezn)) {
                v.e("MicroMsg.BizChatSelectConversationUI", "brandUserName is null");
                finish();
            }
        }
    }

    protected final n NL() {
        bDC();
        return new d(this, this.ezn);
    }

    protected final com.tencent.mm.ui.contact.p NM() {
        bDC();
        return new o(this, this.ezn);
    }

    protected final void a(ListView listView, int i) {
        super.a(listView, i);
        if (this.oiD == null) {
            OnClickListener anonymousClass1 = new OnClickListener(this) {
                final /* synthetic */ BizChatSelectConversationUI oiE;

                {
                    this.oiE = r1;
                }

                public final void onClick(View view) {
                    BizChatSelectConversationUI.a(this.oiE);
                }
            };
            CharSequence string = getString(2131234867);
            View inflate = q.em(this).inflate(2130903780, null);
            inflate.setOnClickListener(anonymousClass1);
            TextView textView = (TextView) inflate.findViewById(2131757427);
            textView.setText(string);
            listView.addHeaderView(inflate);
            this.oiD = textView;
        }
        this.oiD.setVisibility(i);
    }

    protected final void ayE() {
        super.ayE();
    }

    public final void gJ(int i) {
        if (i < this.ieb.getHeaderViewsCount()) {
            v.i("MicroMsg.BizChatSelectConversationUI", "Click HeaderView position=%d", Integer.valueOf(i));
        } else if (this.ieb.getAdapter().getItem(i) instanceof a) {
            a aVar = (a) this.ieb.getAdapter().getItem(i);
            if (aVar != null) {
                String str = aVar.username;
                long j = aVar.ezh;
                if (str == null || j == -1) {
                    v.i("MicroMsg.BizChatSelectConversationUI", "onclick err userName:%s,bizChatId:%s", str, Long.valueOf(j));
                    return;
                }
                a(str, j, aVar.dtS);
            }
        } else {
            v.w("MicroMsg.BizChatSelectConversationUI", "Click HeaderView not BizChatConvDataItem");
        }
    }

    private void a(final String str, final long j, CharSequence charSequence) {
        v.i("MicroMsg.BizChatSelectConversationUI", "doClickUser=%s", str);
        if (this.scene == 2) {
            long j2;
            if (getIntent().getBooleanExtra("enterprise_extra_params", true)) {
                j2 = j;
                com.tencent.mm.pluginsdk.ui.applet.c.a(this.nDR, j2, getString(2131234559), String.valueOf(charSequence), getString(2131231149), new com.tencent.mm.pluginsdk.ui.applet.c.a(this) {
                    final /* synthetic */ BizChatSelectConversationUI oiE;

                    public final void a(boolean z, String str, int i) {
                        if (z) {
                            Intent intent = new Intent();
                            intent.putExtra("enterprise_biz_name", str);
                            intent.putExtra("key_biz_chat_id", j);
                            intent.putExtra("key_is_biz_chat", true);
                            this.oiE.setResult(-1, intent);
                            this.oiE.finish();
                        }
                    }
                });
                return;
            }
            j2 = j;
            com.tencent.mm.pluginsdk.ui.applet.c.a(this.nDR, j2, getString(2131234559), String.valueOf(charSequence), getString(2131231149), new com.tencent.mm.pluginsdk.ui.applet.c.a(this) {
                final /* synthetic */ BizChatSelectConversationUI oiE;

                public final void a(boolean z, String str, int i) {
                    if (z) {
                        Intent intent = new Intent();
                        intent.putExtra("enterprise_biz_name", str);
                        intent.putExtra("key_biz_chat_id", j);
                        intent.putExtra("key_is_biz_chat", true);
                        this.oiE.setResult(-1, intent);
                        this.oiE.finish();
                    }
                }
            });
        } else if (this.scene == 1) {
            HashMap hashMap = (HashMap) getIntent().getSerializableExtra("enterprise_extra_params");
            String str2 = (String) hashMap.get(SlookSmartClipMetaTag.TAG_TYPE_TITLE);
            com.tencent.mm.pluginsdk.ui.applet.c.a(this.nDR, str2, (String) hashMap.get("img_url"), (String) hashMap.get("desc"), true, getResources().getString(2131231149), new com.tencent.mm.pluginsdk.ui.applet.c.a(this) {
                final /* synthetic */ BizChatSelectConversationUI oiE;

                public final void a(boolean z, String str, int i) {
                    if (z) {
                        Intent intent = new Intent();
                        intent.putExtra("enterprise_biz_name", str);
                        intent.putExtra("key_biz_chat_id", j);
                        intent.putExtra("key_is_biz_chat", true);
                        if (!be.kS(str)) {
                            intent.putExtra("enterprise_share_append_text", str);
                        }
                        this.oiE.setResult(-1, intent);
                        this.oiE.finish();
                    }
                }
            });
        }
    }

    protected final boolean NJ() {
        return false;
    }

    protected final String NK() {
        return l.er(this.ezn);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    boolean z;
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra != null) {
                        String str;
                        v.i("MicroMsg.BizChatSelectConversationUI", "bundle != null");
                        String string = bundleExtra.getString("enterprise_members");
                        ra raVar = new ra();
                        com.tencent.mm.modelbiz.a.c cVar = new com.tencent.mm.modelbiz.a.c();
                        if (this.ohB != null) {
                            str = this.ohB.field_addMemberUrl;
                        } else {
                            str = null;
                        }
                        cVar.field_addMemberUrl = str;
                        cVar.field_brandUserName = this.ezn;
                        if (!e.a(cVar, string, null, raVar)) {
                            z = false;
                        } else if (cVar.field_bizChatLocalId != -1) {
                            a(this.ezn, cVar.field_bizChatLocalId, cVar.field_chatName);
                            z = true;
                        } else {
                            u.DE();
                            final com.tencent.mm.modelbiz.a.n a = h.a(this.ezn, raVar, (k) this);
                            getString(2131231164);
                            this.dwg = g.a((Context) this, getString(2131230828), true, new OnCancelListener(this) {
                                final /* synthetic */ BizChatSelectConversationUI oiE;

                                public final void onCancel(DialogInterface dialogInterface) {
                                    ak.vy().c(a);
                                }
                            });
                            z = true;
                        }
                    } else {
                        z = false;
                    }
                    if (!z) {
                        Toast.makeText(this, getString(2131234570), 0).show();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, com.tencent.mm.v.k kVar) {
        if (this.dwg != null && this.dwg.isShowing()) {
            this.dwg.dismiss();
            this.dwg = null;
        }
        if (kVar.getType() == 1355) {
            com.tencent.mm.modelbiz.a.c hR = u.DA().hR(((com.tencent.mm.modelbiz.a.n) kVar).DR().moz.muP.mhD);
            if (hR == null) {
                Toast.makeText(aa.getContext(), getString(2131234570), 0).show();
            } else {
                a(this.ezn, hR.field_bizChatLocalId, hR.field_chatName);
            }
        }
    }
}
