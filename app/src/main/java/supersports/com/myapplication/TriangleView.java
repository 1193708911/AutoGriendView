package supersports.com.myapplication;
 
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
 
/**
 * @author Mr Huang 2018/5/28
 * @version 1.0
 */
public class TriangleView extends View {


    /**
     * 此处是固定死了的默认宽度，这个宽度是三角的宽度，也就是说画一条底边的宽度
     */
    private int width=100;
    /**
     * 此处是固定死了的默认高度，这个高度是三角的高度，也就是画一条直线的高度，也就是Y轴
     */
    private int height=300;
    /**
     * 此处是默认的填充背景颜色
     */
    private int color=0xFFFFFFFF;
    /**
     * 这个是三角形的方位，朝上，朝下，朝左，朝右
     */
    private final int top=0;
    private final int bottom=1;
    private final int left=2;
    private final int right=3;

    public void setWidth(int width) {
        this.width = width;
        invalidate();
    }

    public void setHeight(int height) {
        this.height = height;
        invalidate();
    }
 
    public void setColor(int color) {
 
        this.color = color;
 
        requestLayout();
 
        invalidate();
 
    }
 
 
 
    /**
     * 此处给了一个默认的方位是朝上
     */
    private int derection=top;
 
    /**
     * 此处加一个样式，是用来判断是用空心的还是实心的
     */
    private int style=0;
 
    /**
     * 此处实例化了一个画笔，也就是调用了系统的图形库函数
     */
    private Paint mPaint=new Paint();
 
    /**
     * 这个构造器是默认用java动态写的
     * @param context
     */
    public TriangleView(Context context) {
        super(context);
    }
 
    /**
     * 这个构造器是和xml映射上了，在控件的xml属性里面可以写属性
     * @param context
     * @param attrs 这个就是xml进行解析的
     */
    public TriangleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
 
        /**
         * 解析attrs里面的属性
         */
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.TriangleView);
 
        /**
         * 获取xml里面的三角宽度，默认值是50
         */
        width= (int) typedArray.getDimension(R.styleable.TriangleView_triangleview_width,width);
        /**
         * 获取xml里面的三角高度，默认值是50
         */
        height= (int) typedArray.getDimension(R.styleable.TriangleView_triangleview_height,height);
        /**
         * 获取xml里面的三角颜色值
         */
        color=typedArray.getColor(R.styleable.TriangleView_triangleview_color,color);
        /**
         * 获取xml里面的三角方位
         */
        derection=typedArray.getInt(R.styleable.TriangleView_triangleview_direction,derection);
        /**
         * 获取xml里面的三角的样式，是实心还是空心
         */
        style=typedArray.getInt(R.styleable.TriangleView_triangleview_style,style);
    }
 
    public TriangleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
 
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TriangleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
 
    /**
     * 计算View控件的宽高，这里设置了控件的绝对宽高，也就是自带的宽高被截取了，相当于在正方形里面进行画的
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
 
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
 
        setMeasuredDimension(width,height);
    }
 
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
 
        /**
         * 对画笔进行着色
         */
        mPaint.setColor(color);
 
        /**
         * 是否有齿
         */
        mPaint.setAntiAlias(true);
 
        /**
         * 设置画出来的样式是空心还是实心
         */
        if (style==0){
            mPaint.setStyle(Paint.Style.FILL);
        }else {
            mPaint.setStyle(Paint.Style.STROKE);
        }
        /**
         * 路径
         */
        Path path=new Path();
 
        /**
         * 判断方位，下面是画的算法
         */
        switch (derection){
            case top:
 
                path.moveTo(width,0);
 
                path.lineTo(width,height);
 
                path.lineTo(width-20,height);
 
                break;
 
            case bottom:
 
                path.moveTo(0, 0);
 
                path.lineTo(width / 2, height);
 
                path.lineTo(width, 0);
 
 
 
                break;
 
            case left:
 
                path.moveTo(0, 0);
 
                path.lineTo(0, height);
 
                path.lineTo(width, height / 2);
 
                break;
 
            case right:
 
                path.moveTo(0, height / 2);
 
                path.lineTo(width, height);
 
                path.lineTo(width, 0);
 
                break;
        }
 
        path.close();
 
        /**
         * 在画布上画
         */
        canvas.drawPath(path,mPaint);
 
    }
}

