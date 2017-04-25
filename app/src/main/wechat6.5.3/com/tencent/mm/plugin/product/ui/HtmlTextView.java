package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.Html.TagHandler;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.ad.a;
import java.net.URL;
import org.xml.sax.XMLReader;

public class HtmlTextView extends TextView {
    ImageGetter hRs = new ImageGetter(this) {
        final /* synthetic */ HtmlTextView hRw;

        {
            this.hRw = r1;
        }

        public final Drawable getDrawable(String str) {
            try {
                Drawable createFromStream = Drawable.createFromStream(new URL(str).openStream(), "");
                if (createFromStream == null) {
                    return createFromStream;
                }
                createFromStream.setBounds(0, 0, createFromStream.getIntrinsicWidth(), createFromStream.getIntrinsicHeight());
                return createFromStream;
            } catch (Exception e) {
                return null;
            }
        }
    };
    TagHandler hRt = new TagHandler(this) {
        final /* synthetic */ HtmlTextView hRw;

        {
            this.hRw = r1;
        }

        public final void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
            if (str.equalsIgnoreCase("strike") || str.equals("s")) {
                int length = editable.length();
                if (z) {
                    editable.setSpan(new StrikethroughSpan(), length, length, 17);
                    return;
                }
                Object a = AnonymousClass3.a(editable, StrikethroughSpan.class);
                int spanStart = editable.getSpanStart(a);
                editable.removeSpan(a);
                if (spanStart != length) {
                    editable.setSpan(new StrikethroughSpan(), spanStart, length, 33);
                }
            }
        }

        private static Object a(Editable editable, Class cls) {
            Object[] spans = editable.getSpans(0, editable.length(), cls);
            if (spans.length == 0) {
                return null;
            }
            for (int length = spans.length; length > 0; length--) {
                if (editable.getSpanFlags(spans[length - 1]) == 17) {
                    return spans[length - 1];
                }
            }
            return null;
        }
    };

    public HtmlTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public HtmlTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void setText(final String str) {
        ak.vA().a(new a(this) {
            private volatile Spanned hRu;
            final /* synthetic */ HtmlTextView hRw;

            public final boolean AZ() {
                this.hRu = Html.fromHtml(str, null, this.hRw.hRt);
                return true;
            }

            public final boolean Ba() {
                super.setText(this.hRu, BufferType.SPANNABLE);
                this.hRw.setMovementMethod(LinkMovementMethod.getInstance());
                return true;
            }

            public final String toString() {
                return super.toString() + "|setText";
            }
        });
    }
}
