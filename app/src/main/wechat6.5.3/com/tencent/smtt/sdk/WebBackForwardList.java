package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList;

public class WebBackForwardList {
    private IX5WebBackForwardList pxF = null;
    private android.webkit.WebBackForwardList pxG = null;

    static WebBackForwardList a(android.webkit.WebBackForwardList webBackForwardList) {
        if (webBackForwardList == null) {
            return null;
        }
        WebBackForwardList webBackForwardList2 = new WebBackForwardList();
        webBackForwardList2.pxG = webBackForwardList;
        return webBackForwardList2;
    }

    static WebBackForwardList a(IX5WebBackForwardList iX5WebBackForwardList) {
        if (iX5WebBackForwardList == null) {
            return null;
        }
        WebBackForwardList webBackForwardList = new WebBackForwardList();
        webBackForwardList.pxF = iX5WebBackForwardList;
        return webBackForwardList;
    }

    public int getCurrentIndex() {
        return this.pxF != null ? this.pxF.getCurrentIndex() : this.pxG.getCurrentIndex();
    }

    public WebHistoryItem getCurrentItem() {
        return this.pxF != null ? WebHistoryItem.a(this.pxF.getCurrentItem()) : WebHistoryItem.a(this.pxG.getCurrentItem());
    }

    public WebHistoryItem getItemAtIndex(int i) {
        return this.pxF != null ? WebHistoryItem.a(this.pxF.getItemAtIndex(i)) : WebHistoryItem.a(this.pxG.getItemAtIndex(i));
    }

    public int getSize() {
        return this.pxF != null ? this.pxF.getSize() : this.pxG.getSize();
    }
}
