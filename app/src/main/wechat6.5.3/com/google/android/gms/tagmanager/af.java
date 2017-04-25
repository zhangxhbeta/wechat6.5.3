package com.google.android.gms.tagmanager;

import android.content.SharedPreferences.Editor;

final class af {

    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ Editor aDn;

        AnonymousClass1(Editor editor) {
            this.aDn = editor;
        }

        public final void run() {
            this.aDn.commit();
        }
    }
}
