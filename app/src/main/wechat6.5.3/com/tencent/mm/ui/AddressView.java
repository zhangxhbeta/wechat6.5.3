package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.y;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mm.bi.a.b;
import com.tencent.mm.pluginsdk.ui.a.a;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class AddressView extends View implements a, d.a {
    private static final String TAG = "MicroMsg.AddressView";
    public final int AVATAR_LAYOUT_WIDTH;
    public final int AVATAR_PADDING;
    public final int AVATAR_START_POS;
    public final int AVATAR_WIDTH;
    public final int COMMON_PADDING;
    public final int DESCRIPTION_PADDING;
    public final float DESCRIPTION_TEXT_SIZE;
    public final float NAME_TEXT_SIZE;
    public final int TEXT_TOP_PADDING;
    public final int WEIBO_ICON_SIZE;
    Drawable avatarDrawable;
    Context context;
    float density;
    String description;
    private FontMetrics descriptionFontMetrics;
    private TextPaint descriptionPaint;
    CharSequence destNickName;
    private TextPaint displayNamePaint;
    Drawable drawable;
    private FontMetrics fm;
    boolean imageViewHasSetBounds;
    StaticLayout layout;
    boolean nameIsSpanned;
    boolean needInvaildate;
    boolean needInvaliate;
    BitmapDrawable needMask;
    boolean needUpdatePostion;
    CharSequence nickName;
    private int nickNameCurrentTextColor;
    int nickNameHeight;
    private ColorStateList nickNameTextColor;
    int nickNameWidth;
    StaticLayout nickNamelayout;
    int nickWidth;
    float textBaseY;

    public AddressView(Context context) {
        this(context, null, 0);
    }

    public AddressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AddressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.drawable = getResources().getDrawable(2130839175);
        this.needUpdatePostion = true;
        this.AVATAR_LAYOUT_WIDTH = getResources().getDimensionPixelSize(2131493004);
        this.AVATAR_WIDTH = getResources().getDimensionPixelSize(2131493004);
        this.NAME_TEXT_SIZE = (float) com.tencent.mm.bd.a.N(context, 2131493169);
        this.DESCRIPTION_TEXT_SIZE = (float) com.tencent.mm.bd.a.N(context, b.peS);
        this.WEIBO_ICON_SIZE = getResources().getDimensionPixelSize(2131493197);
        this.AVATAR_START_POS = 0;
        this.AVATAR_PADDING = getResources().getDimensionPixelSize(2131492966);
        this.COMMON_PADDING = 0;
        this.DESCRIPTION_PADDING = getResources().getDimensionPixelSize(2131493139) * 2;
        this.TEXT_TOP_PADDING = getResources().getDimensionPixelSize(b.peR);
    }

    public void setNickNameTextColor(ColorStateList colorStateList) {
        this.nickNameTextColor = colorStateList;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        updatePosition();
        if (this.avatarDrawable != null) {
            this.avatarDrawable.draw(canvas);
        }
        if (this.needMask != null) {
            this.needMask.draw(canvas);
        }
        if (this.nameIsSpanned) {
            canvas.save();
            canvas.translate((float) (this.AVATAR_LAYOUT_WIDTH + this.AVATAR_PADDING), (float) ((getHeight() - this.nickNameHeight) / 2));
            this.nickNamelayout.draw(canvas);
            canvas.restore();
        } else if (be.kS(this.description)) {
            if (this.destNickName != null) {
                canvas.drawText(this.destNickName, 0, this.destNickName.length(), (float) (this.AVATAR_LAYOUT_WIDTH + this.AVATAR_PADDING), ((((float) getHeight()) - (this.fm.bottom - this.fm.top)) / 2.0f) - this.fm.top, this.displayNamePaint);
            }
        } else if (this.destNickName != null) {
            Canvas canvas2 = canvas;
            canvas2.drawText(this.destNickName, 0, this.destNickName.length(), (float) (this.AVATAR_LAYOUT_WIDTH + this.AVATAR_PADDING), ((float) this.TEXT_TOP_PADDING) + (((((float) getHeight()) - (this.fm.bottom - this.fm.top)) / 2.0f) - (this.fm.top / 3.0f)), this.displayNamePaint);
            int width = getWidth();
            float measureText = this.descriptionPaint.measureText(this.description);
            String str = this.description;
            if (measureText > ((float) (width - this.DESCRIPTION_PADDING))) {
                int i = 1;
                while (i < this.description.length()) {
                    String substring = this.description.substring(0, i);
                    if (this.descriptionPaint.measureText(substring) >= ((float) (width - this.DESCRIPTION_PADDING))) {
                        str = str + "...";
                        break;
                    } else {
                        i++;
                        str = substring;
                    }
                }
            }
            canvas2 = canvas;
            canvas2.drawText(str, 0, str.length(), (float) (this.AVATAR_LAYOUT_WIDTH + this.AVATAR_PADDING), ((float) this.TEXT_TOP_PADDING) + (((((float) getHeight()) - (this.descriptionFontMetrics.bottom - this.descriptionFontMetrics.top)) / 2.0f) - ((float) ((int) (((double) this.descriptionFontMetrics.top) * 1.7d)))), this.descriptionPaint);
        }
    }

    public void setName(CharSequence charSequence) {
        if (this.nickName == null || !this.nickName.equals(charSequence)) {
            this.needInvaildate = true;
        }
        this.nickName = charSequence;
        this.nameIsSpanned = charSequence instanceof Spanned;
        if (this.displayNamePaint == null) {
            this.displayNamePaint = generateOnePaint();
        }
        if (this.fm == null) {
            this.fm = this.displayNamePaint.getFontMetrics();
        }
    }

    public void setDescription(String str) {
        this.description = str;
        if (this.descriptionPaint == null) {
            this.descriptionPaint = generateDescriptionPaint();
            this.descriptionFontMetrics = this.descriptionPaint.getFontMetrics();
        }
    }

    public float getNickNameSize() {
        return this.NAME_TEXT_SIZE;
    }

    public CharSequence getNickName() {
        return this.nickName;
    }

    public float getDesiredWidth(CharSequence charSequence, TextPaint textPaint) {
        if (charSequence instanceof Spanned) {
            return Layout.getDesiredWidth(charSequence, textPaint);
        }
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void updatePositionFlag() {
        this.needUpdatePostion = true;
        if (this.needInvaildate) {
            invalidate();
            this.needInvaildate = false;
        }
    }

    public void updatePosition() {
        if (this.needUpdatePostion) {
            this.nickNameWidth = (getTextAreaWidth() - getPaddingLeft()) - getPaddingRight();
            if (((int) getDesiredWidth(this.nickName, this.displayNamePaint)) > this.nickNameWidth) {
                this.destNickName = TextUtils.ellipsize(this.nickName, this.displayNamePaint, (float) this.nickNameWidth, TruncateAt.END);
            } else {
                this.destNickName = this.nickName;
                this.nickNameWidth = (int) getDesiredWidth(this.destNickName, this.displayNamePaint);
            }
            if (this.nickName instanceof Spanned) {
                this.nickNamelayout = new StaticLayout(this.destNickName, this.displayNamePaint, getWidth(), Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
                this.nickNameHeight = this.nickNamelayout.getHeight();
            } else {
                this.nickNamelayout = null;
                this.nickNameHeight = ((int) Math.ceil((double) (this.fm.descent - this.fm.top))) + 2;
            }
            updateDrawBounds();
            this.needUpdatePostion = false;
        }
    }

    private void updateDrawableBounds() {
        this.avatarDrawable.setBounds(this.AVATAR_START_POS, (getHeight() - this.AVATAR_WIDTH) / 2, this.AVATAR_START_POS + this.AVATAR_WIDTH, ((getHeight() - this.AVATAR_WIDTH) / 2) + this.AVATAR_WIDTH);
        this.needMask.setBounds((this.AVATAR_START_POS + this.AVATAR_WIDTH) - (this.needMask.getIntrinsicWidth() / 2), ((((getHeight() - this.AVATAR_WIDTH) / 2) + this.AVATAR_WIDTH) - (this.needMask.getIntrinsicHeight() / 2)) - (this.COMMON_PADDING * 2), (this.AVATAR_START_POS + this.AVATAR_WIDTH) + (this.needMask.getIntrinsicWidth() / 2), (((((getHeight() - this.AVATAR_WIDTH) / 2) + this.AVATAR_WIDTH) - (this.needMask.getIntrinsicHeight() / 2)) - (this.COMMON_PADDING * 2)) + this.needMask.getIntrinsicHeight());
    }

    public void updateDrawBounds() {
        updateDrawableBounds();
    }

    public int getTextAreaWidth() {
        return (getMeasuredWidth() - this.AVATAR_LAYOUT_WIDTH) - this.AVATAR_PADDING;
    }

    public int fromDPToPix(Context context, int i) {
        return Math.round(getDensity(context) * ((float) i));
    }

    public float getDensity(Context context) {
        if (context == null) {
            context = getContext();
        }
        if (this.density < 0.0f) {
            this.density = context.getResources().getDisplayMetrics().density;
        }
        return this.density;
    }

    public void setMaskBitmap(Bitmap bitmap) {
        this.needMask = new BitmapDrawable(getResources(), bitmap);
    }

    public void setImageDrawable(Drawable drawable) {
        this.avatarDrawable = drawable;
        if (drawable != null) {
            this.avatarDrawable.setCallback(this);
        }
    }

    public Drawable getDrawable() {
        return this.avatarDrawable;
    }

    public void resumeAvatarLoad() {
        if (this.avatarDrawable != null) {
            ((com.tencent.mm.pluginsdk.ui.a) this.avatarDrawable).boB();
        }
    }

    public void stopAvatarLoad() {
        if (this.avatarDrawable != null) {
            ((com.tencent.mm.pluginsdk.ui.a) this.avatarDrawable).boA();
        }
    }

    public void onScrollStateChanged(boolean z) {
        if (z) {
            stopAvatarLoad();
        } else {
            resumeAvatarLoad();
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidate();
    }

    public static int dip2px(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    protected void drawableStateChanged() {
        updateTextColors();
        super.drawableStateChanged();
    }

    public void updateTextColors() {
        if (this.nickNameTextColor != null) {
            int colorForState = this.nickNameTextColor.getColorForState(getDrawableState(), 0);
            if (colorForState != this.nickNameCurrentTextColor) {
                this.nickNameCurrentTextColor = colorForState;
                if (this.displayNamePaint == null) {
                    this.displayNamePaint = generateOnePaint();
                }
                this.displayNamePaint.setColor(this.nickNameCurrentTextColor);
                return;
            }
            return;
        }
        v.e(TAG, "nickNameTextColor should not be null");
    }

    private TextPaint generateOnePaint() {
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(this.NAME_TEXT_SIZE);
        textPaint.setColor(getResources().getColor(2131689909));
        return textPaint;
    }

    private TextPaint generateDescriptionPaint() {
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(this.DESCRIPTION_TEXT_SIZE);
        textPaint.setColor(getResources().getColor(2131689792));
        return textPaint;
    }

    public void doInvalidate() {
        invalidate();
    }

    @TargetApi(14)
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        Object contentDescription = getContentDescription();
        if (be.kS((String) contentDescription)) {
            contentDescription = this.nickName;
        }
        accessibilityEvent.getText().add(contentDescription);
    }

    private void installAccessibilityDelegate() {
        y.a((View) this, new android.support.v4.view.a(this) {
            final /* synthetic */ AddressView nzv;

            {
                this.nzv = r1;
            }

            public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
                Object contentDescription = this.nzv.getContentDescription();
                if (be.kS((String) contentDescription)) {
                    contentDescription = this.nzv.nickName;
                }
                accessibilityEvent.getText().add(contentDescription);
            }

            public final void a(View view, android.support.v4.view.a.b bVar) {
                super.a(view, bVar);
                CharSequence contentDescription = this.nzv.getContentDescription();
                if (be.kS((String) contentDescription)) {
                    contentDescription = this.nzv.nickName;
                }
                bVar.setText(contentDescription);
            }
        });
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        CharSequence contentDescription = getContentDescription();
        if (be.kS((String) contentDescription)) {
            contentDescription = this.nickName;
        }
        accessibilityNodeInfo.setText(contentDescription);
    }
}
