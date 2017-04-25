package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.SimpleLoginUI;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.io.File;

@a(3)
@JgClassChecked(author = 12, fComment = "checked", lastDate = "20141031", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class ShareScreenImgUI extends MMActivity {
    private ProgressDialog dwR = null;
    String filePath = null;
    private ac handler = new ac(this) {
        final /* synthetic */ ShareScreenImgUI oUK;

        {
            this.oUK = r1;
        }

        public final void handleMessage(Message message) {
            ShareScreenImgUI.a(this.oUK);
            if (be.kS(this.oUK.filePath)) {
                v.e("MicroMsg.ShareScreenImgUI", "launch : fail, filePath is null");
                this.oUK.bIY();
                this.oUK.finish();
                return;
            }
            this.oUK.bJv();
        }
    };
    private Intent intent = null;
    Uri uri = null;

    static /* synthetic */ void a(ShareScreenImgUI shareScreenImgUI) {
        if (shareScreenImgUI.dwR != null && shareScreenImgUI.dwR.isShowing()) {
            shareScreenImgUI.dwR.dismiss();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fd("");
        int a = r.a(getIntent(), "wizard_activity_result_code", 0);
        switch (a) {
            case -1:
            case 0:
                NotifyReceiver.pZ();
                NI();
                return;
            case 1:
                finish();
                return;
            default:
                v.e("MicroMsg.ShareScreenImgUI", "onCreate, should not reach here, resultCode = " + a);
                finish();
                return;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final void NI() {
        this.intent = getIntent();
        if (this.intent == null) {
            v.e("MicroMsg.ShareScreenImgUI", "launch : fail, intent is null");
            bIY();
            finish();
            return;
        }
        v.i("MicroMsg.ShareScreenImgUI", "intent = " + this.intent);
        String action = this.intent.getAction();
        this.uri = this.intent.getData();
        if (be.kS(action)) {
            v.e("MicroMsg.ShareScreenImgUI", "launch : fail, action is null");
            bIY();
            finish();
        } else if (action.equals("android.intent.action.VIEW")) {
            v.i("MicroMsg.ShareScreenImgUI", "send signal: " + action);
            if (this.uri == null || !be.l(this.uri)) {
                v.e("MicroMsg.ShareScreenImgUI", "launch : fail, not accepted: %s", new Object[]{this.uri});
                bIY();
                finish();
                return;
            }
            getString(2131231164);
            this.dwR = g.a(this, getString(2131231182), true, new OnCancelListener(this) {
                final /* synthetic */ ShareScreenImgUI oUK;

                {
                    this.oUK = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            this.filePath = be.d(this, this.uri);
            if (!be.kS(this.filePath)) {
                action = this.filePath;
                DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                boolean a = o.a(action, decodeResultLogger);
                if (!a && decodeResultLogger.getDecodeResult() >= 2000) {
                    com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(action, 3, decodeResultLogger));
                }
                if (a) {
                    bJv();
                    return;
                }
            }
            v.e("MicroMsg.ShareScreenImgUI", "launch : fail, filePath is null");
            bIY();
            finish();
        } else {
            v.e("MicroMsg.ShareScreenImgUI", "launch : fail, uri is null");
            bIY();
            finish();
        }
    }

    private void bJv() {
        int i;
        v.i("MicroMsg.ShareScreenImgUI", "filepath:[%s]", new Object[]{this.filePath});
        Intent intent = getIntent();
        String resolveType = intent.resolveType(this);
        if (resolveType == null || resolveType.length() == 0) {
            v.e("MicroMsg.ShareScreenImgUI", "map : mimeType is null");
            i = -1;
        } else if (resolveType.toLowerCase().contains("image")) {
            i = 0;
        } else {
            v.d("MicroMsg.ShareScreenImgUI", "map : unknown mimetype, send as file");
            i = 3;
        }
        if (i == -1) {
            v.e("MicroMsg.ShareScreenImgUI", "launch, msgType is invalid");
            finish();
            return;
        }
        if (!r.a(getIntent(), "Intro_Switch", false) && ak.uN() && !ak.uG()) {
            intent.setData(this.uri);
            intent.setClass(this, MsgRetransmitUI.class);
            intent.putExtra("Retr_File_Name", this.filePath);
            intent.putExtra("Retr_Msg_Type", i);
            intent.putExtra("Retr_Scene", 1);
            intent.putExtra("Retr_start_where_you_are", false);
            intent.addFlags(67108864);
            startActivity(intent);
        } else if (be.kS(this.filePath)) {
            bIY();
        } else {
            Intent intent2 = new Intent(this, ShareImgUI.class);
            intent2.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.filePath)));
            intent2.addFlags(67108864);
            intent2.setType("image/*");
            intent2.setAction("android.intent.action.SEND");
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), intent2);
        }
        finish();
    }

    private void bIY() {
        Toast.makeText(this, 2131235304, 1).show();
    }
}
