package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.ValueCallback;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.QbSdk;

@a(3)
public class MiniQBReaderUI extends MMActivity {
    private String lTT = Integer.toString(hashCode());
    private int ret = -1;

    protected final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        v.i("MicroMsg.MiniQBReaderUI", "onCreate");
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("file_path");
        String stringExtra2 = intent.getStringExtra("file_ext");
        this.ret = q.a(this, stringExtra, stringExtra2, this.lTT, new ValueCallback<String>(this) {
            final /* synthetic */ MiniQBReaderUI lTU;

            {
                this.lTU = r1;
            }

            public final /* synthetic */ void onReceiveValue(Object obj) {
                v.i("MicroMsg.MiniQBReaderUI", "startMiniQBToLoadUrl, onReceiveValue: %s", (String) obj);
                if ("fileReaderClosed".equals((String) obj)) {
                    this.lTU.finish();
                }
            }
        });
        v.i("MicroMsg.MiniQBReaderUI", "tryOpenByQbSdk , ret:%b", Integer.valueOf(this.ret));
        new StringBuilder("tryOpenByQbSdk , ret:").append(this.ret);
        Intent intent2 = new Intent();
        intent2.setAction("MINIQB_OPEN_RET");
        intent2.putExtra("file_path", stringExtra);
        intent2.putExtra("file_ext", stringExtra2);
        stringExtra2 = "MINIQB_OPEN_RET_VAL";
        if (this.ret != 0) {
            z = false;
        }
        intent2.putExtra(stringExtra2, z);
        sendBroadcast(intent2, "com.tencent.mm.permission.MM_MESSAGE");
        if (this.ret != 0) {
            finish();
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        v.i("MicroMsg.MiniQBReaderUI", "onNewIntent");
    }

    protected void onDestroy() {
        v.i("MicroMsg.MiniQBReaderUI", "onDestroy");
        if (this.ret == 0) {
            try {
                QbSdk.closeFileReader(this);
            } catch (Throwable e) {
                v.a("MicroMsg.MiniQBReaderUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        super.onDestroy();
    }
}
