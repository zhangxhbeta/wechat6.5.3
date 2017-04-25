package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ay.c;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.CheckCanSubscribeBizUI;

public class WXBizEntryActivity extends AutoLoginActivity {
    private int env;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vB(0);
    }

    protected final int getLayoutId() {
        return 2130903183;
    }

    protected final boolean p(Intent intent) {
        return true;
    }

    protected final void a(a aVar, Intent intent) {
        v.i("MicroMsg.WXBizEntryActivity", "postLogin, loginResult = " + aVar);
        if (getIntent() != null) {
            this.env = getIntent().getIntExtra("key_command_id", 0);
        }
        switch (aVar) {
            case LOGIN_OK:
                v.i("MicroMsg.WXBizEntryActivity", "req type = %d", Integer.valueOf(this.env));
                Intent intent2;
                switch (this.env) {
                    case 7:
                    case 8:
                        intent2 = getIntent();
                        intent2.setClass(this, CheckCanSubscribeBizUI.class);
                        startActivity(intent2);
                        finish();
                        return;
                    case 9:
                        c.a((Context) this, "card", ".ui.CardAddEntranceUI", getIntent(), false);
                        finish();
                        return;
                    case 11:
                        intent2 = getIntent();
                        intent2.putExtra("device_type", 1);
                        c.a((Context) this, "exdevice", ".ui.ExdeviceRankInfoUI", intent2, false);
                        finish();
                        return;
                    case 13:
                        intent2 = getIntent();
                        intent2.putExtra("key_static_from_scene", 100001);
                        c.a((Context) this, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent2, false);
                        finish();
                        return;
                    case 14:
                    case 15:
                        new a(this, getIntent().getStringExtra("key_app_id"), getIntent().getStringExtra("open_id"), new d.a(this) {
                            final /* synthetic */ WXBizEntryActivity enw;

                            {
                                this.enw = r1;
                            }

                            public final void bV(boolean z) {
                                if (z) {
                                    c.a(this.enw, "game", ".ui.CreateOrJoinChatroomUI", this.enw.getIntent(), false);
                                } else {
                                    v.e("MicroMsg.WXBizEntryActivity", "openIdCheck false");
                                }
                                this.enw.finish();
                            }
                        }).WK();
                        return;
                    case 16:
                        c.a((Context) this, "card", ".ui.CardListSelectedUI", getIntent(), false);
                        finish();
                        return;
                    default:
                        return;
                }
            case LOGIN_CANCEL:
            case LOGIN_FAIL:
                v.e("MicroMsg.WXBizEntryActivity", "postLogin fail, loginResult = " + aVar);
                break;
            default:
                v.e("MicroMsg.WXBizEntryActivity", "postLogin, unknown login result = " + aVar);
                break;
        }
        finish();
    }
}
