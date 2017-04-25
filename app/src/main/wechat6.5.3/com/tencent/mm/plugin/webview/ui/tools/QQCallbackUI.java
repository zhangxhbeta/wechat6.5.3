package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.ui.MMActivity;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20150202", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class QQCallbackUI extends MMActivity {
    protected final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        finish();
    }
}
