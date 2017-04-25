package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.m;
import android.support.v4.view.ViewPager.e;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.emoji.ui.EmojiMineUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.mogic.WxViewPager;
import java.util.HashMap;

public class EmojiStoreV2UI extends MMActivity {
    private boolean fqA = true;
    private boolean fqB = false;
    private HashMap<Integer, a> fqv = new HashMap();
    EmojiStoreV2TabView fqw;
    private EmojiStoreV2ViewPager fqx;
    private a fqy;
    private int fqz = 0;

    class a extends m implements e, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView.a {
        private boolean fqA = false;
        final /* synthetic */ EmojiStoreV2UI fqC;
        private WxViewPager fqD;

        public final /* synthetic */ Fragment I(int i) {
            return kj(i);
        }

        public a(EmojiStoreV2UI emojiStoreV2UI, FragmentActivity fragmentActivity, WxViewPager wxViewPager, boolean z) {
            this.fqC = emojiStoreV2UI;
            super(fragmentActivity.aS());
            this.fqA = z;
            this.fqD = wxViewPager;
            this.fqD.a(this);
            this.fqD.b(this);
            this.fqD.Z(emojiStoreV2UI.fqz);
            d.dX(11);
            if (emojiStoreV2UI.fqw != null) {
                emojiStoreV2UI.fqw.fqs = this;
            }
        }

        public final a kj(int i) {
            return this.fqC.ki(i);
        }

        public final int getCount() {
            if (this.fqA) {
                return 2;
            }
            return 1;
        }

        public final void a(int i, float f, int i2) {
            if (this.fqC.fqw != null) {
                this.fqC.fqw.f(i, f);
            }
        }

        public final void W(int i) {
            v.d("MicroMsg.emoji.EmojiStoreV2UI", "onPageSelected :%d", new Object[]{Integer.valueOf(i)});
            this.fqC.fqz = i;
            if (this.fqC.fqw != null) {
                this.fqC.fqw.kg(i);
            }
            if (this.fqC.fqz == 1 && !this.fqC.fqB) {
                g.iuh.h(12090, new Object[0]);
                EmojiStoreV2UI emojiStoreV2UI = this.fqC;
                ak.yW();
                c.vf().a(com.tencent.mm.storage.t.a.noJ, Boolean.valueOf(false));
                if (emojiStoreV2UI.fqw != null) {
                    emojiStoreV2UI.fqw.cH(false);
                }
                this.fqC.fqB = true;
            }
        }

        public final void X(int i) {
            v.d("MicroMsg.emoji.EmojiStoreV2UI", "onPageScrollStateChanged state:%d", new Object[]{Integer.valueOf(i)});
            if (i == 0 && this.fqC.ki(this.fqC.fqz) != null) {
                a ki = this.fqC.ki(this.fqC.fqz);
                if (ki.Eq != null && ki.fcY != null && ki.ahZ()) {
                    ki.fcY.acO();
                }
            }
        }

        public final void kh(int i) {
            if (i != this.fqC.fqz) {
                this.fqD.k(i, false);
            }
            this.fqC.fqz = i;
        }
    }

    static /* synthetic */ void a(EmojiStoreV2UI emojiStoreV2UI) {
        Intent intent = new Intent();
        String Er = com.tencent.mm.z.a.Er();
        if (be.kS(Er)) {
            v.e("MicroMsg.emoji.EmojiStoreV2UI", "load emojiStore Template Path error");
            return;
        }
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("showkeyboard", true);
        int i = emojiStoreV2UI.fqz == 0 ? 0 : 1;
        intent.putExtra("sence", i);
        intent.putExtra("rawUrl", "file://" + Er + "/index.html?lang=" + u.dJ(emojiStoreV2UI.nDR.nEl) + "&scene=" + i + "&clientType=1&version=" + com.tencent.mm.z.a.Et());
        com.tencent.mm.ay.c.b(emojiStoreV2UI.nDR.nEl, "webview", ".ui.tools.emojistore.EmojiStoreSearchWebViewUI", intent);
        g.iuh.h(13054, new Object[]{Integer.valueOf(i), Integer.valueOf(0), ""});
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        String value = j.sU().getValue("ShowPersonalEmotion");
        v.i("MicroMsg.emoji.EmojiStoreV2UI", "get dynamic config value:%s", new Object[]{value});
        if (be.kS(value) || be.KL(value) != 1) {
            this.fqA = false;
        } else {
            this.fqA = true;
        }
        if (this.fqA) {
            this.fqz = getIntent().getIntExtra("emoji_tab", 0);
        }
        NI();
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ EmojiStoreV2UI fqC;

            {
                this.fqC = r1;
            }

            public final void run() {
                com.tencent.mm.p.c.us().s(262147, false);
                com.tencent.mm.p.c.us().s(262149, false);
                com.tencent.mm.p.c.us().az(262147, 266244);
                com.tencent.mm.p.c.us().az(262149, 266244);
                ak.yW();
                c.vf().set(208899, Boolean.valueOf(false));
                ak.yW();
                c.vf().set(208913, Boolean.valueOf(false));
            }
        });
        ak.yW();
        boolean booleanValue = ((Boolean) c.vf().get(com.tencent.mm.storage.t.a.noJ, Boolean.valueOf(false))).booleanValue();
        if (this.fqw != null) {
            this.fqw.cH(booleanValue);
        }
        g.iuh.a(406, 0, 1, false);
        g.iuh.a(406, 2, System.currentTimeMillis() - currentTimeMillis, false);
    }

    protected void onResume() {
        super.onResume();
        Looper.myQueue().addIdleHandler(new IdleHandler(this) {
            final /* synthetic */ EmojiStoreV2UI fqC;

            {
                this.fqC = r1;
            }

            public final boolean queueIdle() {
                v.i("MicroMsg.emoji.EmojiStoreV2UI", "now try to activity the tools process");
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(com.tencent.mm.ui.d.d.nzM, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                this.fqC.sendBroadcast(intent);
                return false;
            }
        });
    }

    protected final int getLayoutId() {
        return 2130903514;
    }

    protected final void NI() {
        a(0, 2131165207, new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreV2UI fqC;

            {
                this.fqC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                EmojiStoreV2UI.a(this.fqC);
                return false;
            }
        });
        a(1, 2131165208, new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreV2UI fqC;

            {
                this.fqC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.putExtra("10931", 1);
                intent.setClass(this.fqC, EmojiMineUI.class);
                this.fqC.startActivity(intent);
                return false;
            }
        });
        this.fqw = (EmojiStoreV2TabView) findViewById(2131756744);
        this.fqx = (EmojiStoreV2ViewPager) findViewById(2131756745);
        this.fqx.yb(0);
        this.fqy = new a(this, this, this.fqx, this.fqA);
        if (this.fqA) {
            this.fqw.setVisibility(0);
        } else {
            this.fqw.setVisibility(8);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.fqv != null) {
            this.fqv.clear();
        }
    }

    public final a ki(int i) {
        a aVar = null;
        if (i < 0) {
            return null;
        }
        if (this.fqv.containsKey(Integer.valueOf(i))) {
            return (a) this.fqv.get(Integer.valueOf(i));
        }
        switch (i) {
            case 0:
                aVar = (a) Fragment.a(this, b.class.getName(), null);
                break;
            case 1:
                aVar = (a) Fragment.a(this, c.class.getName(), null);
                break;
            default:
                v.w("MicroMsg.emoji.EmojiStoreV2UI", "create fragment failed.");
                break;
        }
        v.d("MicroMsg.emoji.EmojiStoreV2UI", "create fragment index:%d", new Object[]{Integer.valueOf(i)});
        if (aVar != null) {
            aVar.a(this);
        }
        this.fqv.put(Integer.valueOf(i), aVar);
        return aVar;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        v.d("MicroMsg.emoji.EmojiStoreV2UI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        if (this.fqy != null && this.fqy.kj(this.fqz) != null) {
            this.fqy.kj(this.fqz).onActivityResult(i, i2, intent);
        }
    }

    protected final int NO() {
        return 1;
    }
}
