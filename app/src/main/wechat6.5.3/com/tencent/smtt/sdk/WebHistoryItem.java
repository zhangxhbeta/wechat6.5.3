package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem;

public class WebHistoryItem {
    private IX5WebHistoryItem pxH = null;
    private android.webkit.WebHistoryItem pxI = null;

    private WebHistoryItem() {
    }

    static WebHistoryItem a(android.webkit.WebHistoryItem webHistoryItem) {
        if (webHistoryItem == null) {
            return null;
        }
        WebHistoryItem webHistoryItem2 = new WebHistoryItem();
        webHistoryItem2.pxI = webHistoryItem;
        return webHistoryItem2;
    }

    static WebHistoryItem a(IX5WebHistoryItem iX5WebHistoryItem) {
        if (iX5WebHistoryItem == null) {
            return null;
        }
        WebHistoryItem webHistoryItem = new WebHistoryItem();
        webHistoryItem.pxH = iX5WebHistoryItem;
        return webHistoryItem;
    }

    public Bitmap getFavicon() {
        return this.pxH != null ? this.pxH.getFavicon() : this.pxI.getFavicon();
    }

    public String getOriginalUrl() {
        return this.pxH != null ? this.pxH.getOriginalUrl() : this.pxI.getOriginalUrl();
    }

    public String getTitle() {
        return this.pxH != null ? this.pxH.getTitle() : this.pxI.getTitle();
    }

    public String getUrl() {
        return this.pxH != null ? this.pxH.getUrl() : this.pxI.getUrl();
    }
}
