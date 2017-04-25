package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ay.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@a(7)
public class WalletSendC2CMsgUI extends WalletBaseUI {
    private int cVh;
    private Map<String, String> kYd = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        oa(8);
        this.cVh = getIntent().getIntExtra("key_scene", 0);
        v.i("MicroMsg.WalletSendC2CMsgUI", "scene:" + this.cVh);
        if (this.cVh == 0) {
            gQ(580);
            if (getIntent() == null) {
                v.e("MicroMsg.WalletSendC2CMsgUI", "func[doCheckPayNetscene] intent null");
                setResult(DownloadResult.CODE_UNDEFINED);
                finish();
                return;
            }
            p(new com.tencent.mm.plugin.wallet_core.b.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 6));
        } else if (!DC(null)) {
            v.d("MicroMsg.WalletSendC2CMsgUI", "doSendC2CMsg fail");
            setResult(DownloadResult.CODE_UNDEFINED);
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        gR(580);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        boolean z = false;
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.a) {
                v.i("MicroMsg.WalletSendC2CMsgUI", "Check jsapi suc & Go Select Contact");
                v.i("MicroMsg.WalletSendC2CMsgUI", "doCallSelectConversationUI");
                Map bhA = bhA();
                if (bhA != null && bhA.containsKey("togroup") && "0".equals(bhA.get("togroup"))) {
                    z = true;
                }
                Intent intent = new Intent();
                int i3 = z ? 7 : 3;
                intent.putExtra("select_is_ret", true);
                intent.putExtra("Select_Conv_Type", i3);
                c.a(this, ".ui.transmit.SelectConversationUI", intent, 1);
                return true;
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_index.c.c) {
                v.i("MicroMsg.WalletSendC2CMsgUI", "Send c2c msg suc");
                if (this.cVh == 1) {
                    g.bf(this, getString(2131236468));
                } else {
                    g.bf(this, getString(2131233278));
                    setResult(-1);
                }
                finish();
                return true;
            }
        } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.a) {
            v.e("MicroMsg.WalletSendC2CMsgUI", "Check jsapi fail");
            setResult(DownloadResult.CODE_UNDEFINED);
            finish();
            return true;
        } else if (kVar instanceof com.tencent.mm.plugin.wallet_index.c.c) {
            if (this.cVh == 1) {
                g.bf(this, str);
            } else {
                setResult(DownloadResult.CODE_UNDEFINED);
            }
            finish();
            return true;
        } else {
            setResult(DownloadResult.CODE_UNDEFINED);
            finish();
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            v.d("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = " + intent.toString());
        } else {
            v.e("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = null");
        }
        if (i != 1) {
            v.e("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, unknown requestCode = " + i);
        } else if (i2 != -1 || intent == null) {
            v.e("MicroMsg.WalletSendC2CMsgUI", "cancel select contact fail");
            setResult(0);
            finish();
        } else {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            v.d("MicroMsg.WalletSendC2CMsgUI", "Select user , " + be.ma(stringExtra));
            if (!DC(stringExtra)) {
                v.e("MicroMsg.WalletSendC2CMsgUI", "doSendC2CMsg fail");
                setResult(DownloadResult.CODE_UNDEFINED);
                finish();
            }
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    private boolean DC(String str) {
        String stringExtra;
        String stringExtra2;
        String encode;
        String stringExtra3;
        String stringExtra4;
        String stringExtra5;
        String str2;
        String str3 = null;
        if (this.cVh == 1) {
            str = getIntent().getStringExtra("key_receiver");
            stringExtra = getIntent().getStringExtra("key_sender_des");
            stringExtra2 = getIntent().getStringExtra("key_receiver_des");
            encode = URLEncoder.encode(getIntent().getStringExtra("key_url"));
            stringExtra3 = getIntent().getStringExtra("key_templateid");
            str3 = getIntent().getStringExtra("key_sceneid");
            stringExtra4 = getIntent().getStringExtra("key_receivertitle");
            stringExtra5 = getIntent().getStringExtra("key_sendertitle");
            str2 = str;
        } else {
            Map bhA = bhA();
            if (bhA == null || be.kS(str)) {
                stringExtra3 = null;
                encode = null;
                stringExtra2 = null;
                stringExtra = null;
                stringExtra5 = null;
                stringExtra4 = null;
                str2 = str;
            } else {
                stringExtra4 = URLDecoder.decode(be.ma((String) bhA.get("receivertitle")));
                stringExtra5 = URLDecoder.decode(be.ma((String) bhA.get("sendertitle")));
                stringExtra = URLDecoder.decode(be.ma((String) bhA.get("senderdes")));
                stringExtra2 = URLDecoder.decode(be.ma((String) bhA.get("receiverdes")));
                encode = be.ma((String) bhA.get("url"));
                stringExtra3 = URLDecoder.decode(be.ma((String) bhA.get("templateid")));
                str3 = URLDecoder.decode(be.ma((String) bhA.get("senceid")));
                str2 = str;
            }
        }
        if (be.kS(encode) || be.kS(stringExtra3)) {
            v.w("MicroMsg.WalletSendC2CMsgUI", "url = " + be.kS(encode) + "templateId=" + be.kS(stringExtra3));
            return false;
        }
        v.d("MicroMsg.WalletSendC2CMsgUI", "send c2c msg to" + str2);
        j(new com.tencent.mm.plugin.wallet_index.c.c(str2, stringExtra4, stringExtra5, stringExtra3, stringExtra, stringExtra2, encode, str3));
        return true;
    }

    private Map<String, String> bhA() {
        if (this.kYd == null) {
            String stringExtra = getIntent().getStringExtra("packageExt");
            v.d("MicroMsg.WalletSendC2CMsgUI", "func[getPackageData] packageExt: " + stringExtra);
            if (!be.kS(stringExtra)) {
                String[] split = stringExtra.split("&");
                this.kYd = new HashMap();
                if (split != null && split.length > 0) {
                    for (int i = 0; i < split.length; i++) {
                        if (!be.kS(split[i])) {
                            String[] split2 = split[i].split("=");
                            if (split2.length == 2 && !be.kS(split2[0])) {
                                this.kYd.put(split2[0], split2[1]);
                            }
                        }
                    }
                }
            }
        }
        return this.kYd;
    }
}
