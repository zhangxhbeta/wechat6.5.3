package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import java.util.HashSet;
import java.util.Set;

public final class b {
    public static final Set<String> log = new HashSet<String>() {
        {
            add("application/msword");
            add("application/vnd.ms-powerpoint");
            add("application/vnd.ms-excel");
            add("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            add("application/vnd.openxmlformats-officedocument.presentationml.presentation");
            add("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            add("application/kswps");
            add("application/kset");
            add("application/ksdps");
            add("application/pdf");
            add("text/plain");
        }
    };
}
