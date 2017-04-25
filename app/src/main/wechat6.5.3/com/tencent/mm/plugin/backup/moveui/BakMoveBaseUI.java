package com.tencent.mm.plugin.backup.moveui;

import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ui.MMActivity;

public class BakMoveBaseUI extends MMActivity {
    protected TextView elH;
    protected TextView elI;
    protected ProgressBar elJ;
    protected TextView elK;
    protected Button elL;
    private WakeLock wakeLock;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.elH = (TextView) findViewById(2131755516);
        this.elI = (TextView) findViewById(2131755517);
        this.elJ = (ProgressBar) findViewById(2131755518);
        this.elK = (TextView) findViewById(2131755519);
        this.elL = (Button) findViewById(2131755514);
        this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(26, "My Lock");
    }

    public void onResume() {
        super.onResume();
        this.wakeLock.acquire();
    }

    public void onPause() {
        super.onPause();
        this.wakeLock.release();
    }

    protected final int getLayoutId() {
        return 2130903150;
    }
}
