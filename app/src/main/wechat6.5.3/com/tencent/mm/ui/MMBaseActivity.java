package com.tencent.mm.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.ui.base.a;

@a(3)
public class MMBaseActivity extends Activity {
    public Resources getResources() {
        if (getAssets() == null || aa.getResources() == null) {
            return super.getResources();
        }
        return aa.getResources();
    }

    public Object getSystemService(String str) {
        Object systemService = super.getSystemService(str);
        if (getAssets() == null || !"layout_inflater".equals(str)) {
            return systemService;
        }
        return q.b((LayoutInflater) systemService);
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.platformtools.a.cu(getWindow().getDecorView());
        com.tencent.mm.sdk.platformtools.a.dC(this);
    }
}
