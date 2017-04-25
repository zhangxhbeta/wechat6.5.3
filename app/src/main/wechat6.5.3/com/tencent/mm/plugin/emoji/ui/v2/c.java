package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.h;
import com.tencent.mm.sdk.platformtools.v;

public class c extends a {
    protected final int getLayoutId() {
        return 2130903500;
    }

    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        v.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onAttach");
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onCreate");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        v.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onCreateView");
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public final void onStart() {
        super.onStart();
        v.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onStart");
    }

    public final void onResume() {
        super.onResume();
        v.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onResume");
        if (this.fns != null) {
            this.fns.aic();
        }
    }

    public final void onPause() {
        super.onPause();
        v.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onPause");
    }

    public final void onStop() {
        super.onStop();
        v.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onStop");
    }

    public final void onDestroyView() {
        super.onDestroyView();
        v.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onResume");
    }

    public final void onDestroy() {
        super.onDestroy();
        v.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onDestroy");
    }

    public final void onDetach() {
        super.onDetach();
        v.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onDestroy");
    }

    public final int agm() {
        return 9;
    }

    public final a age() {
        return new h(this.nDR.nEl);
    }

    public final boolean ahY() {
        return false;
    }

    public final boolean ahZ() {
        return false;
    }
}
