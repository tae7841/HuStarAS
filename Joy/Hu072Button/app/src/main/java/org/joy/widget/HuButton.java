package org.joy.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.PaintDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatButton;

public class HuButton extends AppCompatButton {
    private static final String TAG = "HuStar";

    public HuButton(Context context) {
        super(context);
        init(context);
    }

    public HuButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        setAllCaps(false);
        setTextSize((float) 24);
        setTextColor(Color.BLACK);

        // setBackgroundColor(Color.CYAN);
        // to make corners round
        this.setBackgroundResource(R.drawable.tag_rounded_corners);
        GradientDrawable drawable = (GradientDrawable) this.getBackground();
        drawable.setColor(Color.CYAN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw called");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent called");
        GradientDrawable drawable;
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                this.setBackgroundResource(R.drawable.tag_rounded_corners);
                drawable = (GradientDrawable) this.getBackground();
                drawable.setColor(Color.YELLOW);
                break;
            case MotionEvent.ACTION_OUTSIDE:
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                this.setBackgroundResource(R.drawable.tag_rounded_corners);
                drawable = (GradientDrawable) this.getBackground();
                drawable.setColor(Color.CYAN);
                break;
            default: break;
        }
        invalidate();
        return true;
    }
}
