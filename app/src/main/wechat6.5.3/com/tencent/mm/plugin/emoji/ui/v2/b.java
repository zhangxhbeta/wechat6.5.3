package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.g;
import com.tencent.mm.sdk.platformtools.v;

public class b extends a {
    protected final int getLayoutId() {
        return 2130903498;
    }

    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        v.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onAttach");
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onCreate");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        v.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onCreateView");
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public final void onActivityCreated(Bundle bundle) {
        v.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onActivityCreated");
        super.onActivityCreated(bundle);
    }

    public final void onStart() {
        super.onStart();
        v.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onStart");
    }

    public final void onResume() {
        super.onResume();
        v.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onResume");
    }

    public final void onPause() {
        super.onPause();
        v.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onPause");
    }

    public final void onStop() {
        super.onStop();
        v.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onStop");
    }

    public final void onDestroyView() {
        super.onDestroyView();
        v.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onResume");
    }

    public final void onDestroy() {
        super.onDestroy();
        v.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onDestroy");
    }

    public final void onDetach() {
        super.onDetach();
        v.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onDestroy");
    }

    public final int agm() {
        return 5;
    }

    public final a age() {
        return new g(this.nDR.nEl);
    }

    public final boolean ahY() {
        return true;
    }

    public final boolean ahZ() {
        return true;
    }
}
