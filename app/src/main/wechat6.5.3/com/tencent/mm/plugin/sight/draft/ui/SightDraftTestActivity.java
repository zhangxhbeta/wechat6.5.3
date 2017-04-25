package com.tencent.mm.plugin.sight.draft.ui;

import android.app.Activity;
import android.os.Bundle;

public class SightDraftTestActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SightDraftContainerView sightDraftContainerView = new SightDraftContainerView(this);
        setContentView(sightDraftContainerView);
        sightDraftContainerView.aPG();
    }
}
