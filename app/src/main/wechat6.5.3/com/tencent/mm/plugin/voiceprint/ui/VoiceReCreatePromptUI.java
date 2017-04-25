package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.MMActivity;

public class VoiceReCreatePromptUI extends MMActivity implements OnClickListener {
    private View kqs = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nDR.bAj();
        this.kqs = findViewById(2131759669);
        this.kqs.setOnClickListener(this);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130904587;
    }

    public void onClick(View view) {
        startActivity(new Intent(this, VoiceCreateUI.class));
        finish();
    }
}
