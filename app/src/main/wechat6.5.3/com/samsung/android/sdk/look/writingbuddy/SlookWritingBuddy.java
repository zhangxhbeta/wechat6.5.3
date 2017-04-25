package com.samsung.android.sdk.look.writingbuddy;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.samsung.android.sdk.look.Slook;
import com.samsung.android.writingbuddy.WritingBuddyImpl;
import com.samsung.android.writingbuddy.WritingBuddyImpl.OnImageWritingListener;
import com.samsung.android.writingbuddy.WritingBuddyImpl.OnTextWritingListener;

public final class SlookWritingBuddy {
    private static final String TAG = "WritingBuddy";
    public static final int TYPE_EDITOR_NUMBER = 1;
    public static final int TYPE_EDITOR_TEXT = 2;
    private ImageWritingListener mImageWritingListener;
    private View mParentView;
    private Slook mSlook = new Slook();
    private TextWritingListener mTextWritingListener;
    private WritingBuddyImpl mWritingBuddyImpl;

    public interface ImageWritingListener {
        void onImageReceived(Bitmap bitmap);
    }

    public interface TextWritingListener {
        void onTextReceived(CharSequence charSequence);
    }

    public SlookWritingBuddy(ViewGroup viewGroup) {
        if (isSupport(1)) {
            this.mParentView = viewGroup;
            this.mWritingBuddyImpl = new WritingBuddyImpl(viewGroup);
        }
    }

    public SlookWritingBuddy(EditText editText) {
        if (isSupport(1)) {
            this.mParentView = editText;
            this.mWritingBuddyImpl = new WritingBuddyImpl(editText);
        }
    }

    public final void setEditorType(int i) {
        if (isSupport(1)) {
            this.mWritingBuddyImpl.setEditorType(i);
        }
    }

    public final int getEditorType() {
        if (isSupport(1)) {
            return this.mWritingBuddyImpl.getEditorType();
        }
        return 0;
    }

    public final void setTextWritingListener(TextWritingListener textWritingListener) {
        if (isSupport(1)) {
            this.mTextWritingListener = textWritingListener;
            this.mWritingBuddyImpl.setOnTextWritingListener(new OnTextWritingListener() {
                public void onTextReceived(CharSequence charSequence) {
                    SlookWritingBuddy.this.mTextWritingListener.onTextReceived(charSequence);
                }
            });
        }
    }

    public final void setImageWritingListener(ImageWritingListener imageWritingListener) {
        if (isSupport(1)) {
            this.mImageWritingListener = imageWritingListener;
            if (imageWritingListener == null) {
                this.mWritingBuddyImpl.setImageWritingEnabled(false);
                this.mWritingBuddyImpl.setOnImageWritingListener(null);
                return;
            }
            this.mWritingBuddyImpl.setImageWritingEnabled(true);
            this.mWritingBuddyImpl.setOnImageWritingListener(new OnImageWritingListener() {
                public void onImageReceived(Bitmap bitmap) {
                    SlookWritingBuddy.this.mImageWritingListener.onImageReceived(bitmap);
                }
            });
        }
    }

    public final void setEnabled(boolean z) {
        if (!isSupport(1)) {
            return;
        }
        if (this.mParentView == null) {
            throw new IllegalStateException("mParentView is null.");
        } else if (this.mParentView instanceof EditText) {
            this.mParentView.setWritingBuddyEnabled(z);
        } else if (this.mParentView.getWritingBuddy(false) != null) {
            this.mParentView.setWritingBuddyEnabled(z);
        } else {
            throw new IllegalStateException("WritingBuddy was not enabled.");
        }
    }

    public final boolean isEnabled() {
        if (!isSupport(1)) {
            return false;
        }
        if (this.mParentView != null) {
            return this.mParentView.isWritingBuddyEnabled();
        }
        throw new IllegalStateException("mParentView is null.");
    }

    private boolean isSupport(int i) {
        if (this.mSlook.isFeatureEnabled(3)) {
            return true;
        }
        return false;
    }
}
