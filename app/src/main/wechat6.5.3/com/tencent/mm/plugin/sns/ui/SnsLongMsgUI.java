package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;

public class SnsLongMsgUI extends MMActivity {
    private Button jyb;

    public void onDestroy() {
        super.onDestroy();
    }

    @TargetApi(17)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vB(8);
        this.jyb = (Button) findViewById(2131757745);
        this.jyb.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsLongMsgUI jQl;

            {
                this.jQl = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(this.jQl, SnsUploadUI.class);
                intent.putExtra("KSnsPostManu", true);
                intent.putExtra("KTouchCameraTime", be.Nh());
                intent.putExtra("sns_comment_type", 1);
                intent.putExtra("Ksnsupload_type", 9);
                this.jQl.startActivity(intent);
                this.jQl.finish();
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        Intent intent = new Intent();
        intent.setClass(this, SnsUploadUI.class);
        intent.putExtra("KSnsPostManu", true);
        intent.putExtra("KTouchCameraTime", be.Nh());
        intent.putExtra("sns_comment_type", 1);
        intent.putExtra("Ksnsupload_type", 9);
        startActivity(intent);
        finish();
        return true;
    }

    protected final int getLayoutId() {
        return 2130903877;
    }
}
