package com.tencent.mm.plugin.webview.ui.tools.emojistore;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.v;

public class EmojiStoreSearchWebViewUI extends BaseEmojiStoreSearchWebViewUI {
    protected final void m(int i, Bundle bundle) {
        v.i("MicroMsg.emoji.EmojiStoreSearchWebViewUI", "handleEmojiStoreAction action:%d", new Object[]{Integer.valueOf(i)});
        super.m(i, bundle);
    }
}
