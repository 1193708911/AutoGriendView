package supersports.com.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by rocky on 2019/6/18.
 */

public class BackTitleTextView extends AppCompatTextView {
    public static final int DRAW_DEFAULT_WIDTH = 200;
    public static final int DRAW_DEFAULT_HEIGHT = 100;
    private Context mContext;
    private int mWidth = DRAW_DEFAULT_WIDTH;
    private int mHeight = DRAW_DEFAULT_HEIGHT;
    private Paint mDefaultPaint;
    private Path mDefaultPath;


    public BackTitleTextView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public BackTitleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    public BackTitleTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
    }


    private void init() {
        mDefaultPaint = new Paint();
        mDefaultPath = new Path();
        mDefaultPaint.setColor(Color.WHITE);
        mDefaultPaint.setAntiAlias(true);
        mDefaultPaint.setStrokeWidth(1);
        mDefaultPaint.setStyle(Paint.Style.FILL);
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
        mDefaultPaint.setXfermode(porterDuffXfermode);

    }

    /**
     * 设置字体
     */
    public void setDrawText(String text) {
        setText(text);
        invalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = mContext.getResources().getDrawable(R.drawable.drawable_item);
        drawable.draw(canvas);
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
        mDefaultPaint.setXfermode(porterDuffXfermode);
        mWidth=getWidth();
        mDefaultPath.moveTo(mWidth, 0);
        mDefaultPath.lineTo(mWidth, mHeight);
        mDefaultPath.lineTo(mWidth - 20, mHeight);
        canvas.drawPath(mDefaultPath, mDefaultPaint);


    }
}
