package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.ay.c;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ay;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.SimpleLoginUI;
import com.tencent.mm.ui.base.a;
import java.io.File;

@a(3)
@JgClassChecked(author = 12, fComment = "checked", lastDate = "20141031", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class ShareScreenToTimeLineUI extends MMActivity {
    String filePath = null;
    Uri uri = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fd("");
        int a = r.a(getIntent(), "wizard_activity_result_code", 0);
        switch (a) {
            case -1:
            case 0:
                NotifyReceiver.pZ();
                ak.vy().a(new ay(new ay.a(this) {
                    final /* synthetic */ ShareScreenToTimeLineUI oUL;

                    {
                        this.oUL = r1;
                    }

                    public final void a(e eVar) {
                    }
                }), 0);
                NI();
                return;
            case 1:
                finish();
                return;
            default:
                v.e("MicroMsg.ShareScreenToTimeLineUI", "onCreate, should not reach here, resultCode = " + a);
                finish();
                return;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final void NI() {
        Intent intent = getIntent();
        if (intent == null) {
            v.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, intent is null");
            bIY();
            finish();
            return;
        }
        String action = intent.getAction();
        this.uri = intent.getData();
        if (be.kS(action)) {
            v.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, action is null");
            bIY();
            finish();
            return;
        }
        String g = r.g(intent, "Kdescription");
        String resolveType = getIntent().resolveType(this);
        if (be.kS(resolveType)) {
            bIY();
            finish();
        } else if (!resolveType.contains("image")) {
            bIY();
            finish();
        } else if (action.equals("android.intent.action.VIEW")) {
            v.i("MicroMsg.ShareScreenToTimeLineUI", "send signal: " + action);
            if (be.l(this.uri)) {
                this.filePath = be.d(this, this.uri);
                if (!be.kS(this.filePath) && be.KX(this.filePath)) {
                    String str = this.filePath;
                    DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                    boolean a = o.a(str, decodeResultLogger);
                    if (!a && decodeResultLogger.getDecodeResult() >= 2000) {
                        g.iuh.Y(12712, KVStatHelper.getKVStatString(str, 4, decodeResultLogger));
                    }
                    if (a) {
                        dZ(this.filePath, g);
                        return;
                    }
                    bIY();
                    finish();
                    return;
                } else if (r.a(intent, "Ksnsupload_empty_img", false)) {
                    dZ(this.filePath, g);
                    return;
                } else {
                    bIY();
                    finish();
                    return;
                }
            }
            v.e("MicroMsg.ShareScreenToTimeLineUI", "fail, not accepted: %s", new Object[]{this.uri});
            bIY();
            finish();
        } else {
            v.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, uri is null");
            bIY();
            finish();
        }
    }

    private void dZ(String str, String str2) {
        Intent intent = new Intent();
        if (!be.kS(str)) {
            intent.putExtra("sns_kemdia_path", str);
            intent.putExtra("KFilterId", -1);
        }
        if (!be.kS(str2)) {
            intent.putExtra("Kdescription", str2);
        }
        if (ak.uN() && !ak.uG()) {
            intent.putExtra("K_go_to_SnsTimeLineUI", true);
            c.b(this, "sns", ".ui.SnsUploadUI", intent);
        } else if (be.kS(str)) {
            bIY();
        } else {
            intent = new Intent(this, ShareToTimeLineUI.class);
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
            intent.addFlags(32768).addFlags(268435456);
            intent.setType("image/*");
            intent.setAction("android.intent.action.SEND");
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), intent);
        }
        finish();
    }

    private void bIY() {
        Toast.makeText(this, 2131235306, 1).show();
    }
}
