package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mm.ui.base.h.a;
import com.tencent.recovery.b;

public class NoRomSpaceDexUI extends MMActivity {
    protected final int getLayoutId() {
        return 2130904130;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a aVar = new a(this);
        aVar.wm(2131231920);
        aVar.Oq(getString(2131231919));
        aVar.jk(false);
        aVar.wp(2131231917).a(new OnClickListener(this) {
            final /* synthetic */ NoRomSpaceDexUI nGw;

            {
                this.nGw = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                int myPid = Process.myPid();
                b.yH(13);
                Process.killProcess(myPid);
            }
        });
        aVar.RX().show();
    }
}
