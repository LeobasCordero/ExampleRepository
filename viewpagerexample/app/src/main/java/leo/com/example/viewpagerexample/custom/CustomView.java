package leo.com.example.viewpagerexample.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import leo.com.example.viewpagerexample.Constants.Constant;
import leo.com.example.viewpagerexample.R;

/**
 * Vista Customizada para requerimiento
 */
public class CustomView extends View{

    Paint paintColorStyle;
    String circleText;
    int circleColor;
    int circleTextColor;
    float circleTextSize;


    public CustomView(Context context, AttributeSet attrs) {
        super(context,attrs);

        paintColorStyle = new Paint();
        TypedArray attributeValuesArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomView,
                Constant.ZERO_VALUE, Constant.ZERO_VALUE);
        try{
            circleText = attributeValuesArray.getString(R.styleable.CustomView_circleText);
            circleColor = attributeValuesArray.getInteger(R.styleable.CustomView_circleColor, Constant.ZERO_VALUE);
            circleTextColor = attributeValuesArray.getInteger(R.styleable.CustomView_circleTextColor, Constant.ZERO_VALUE);
            circleTextSize = attributeValuesArray.getFloat(R.styleable.CustomView_circleTextSize, Constant.MEDIUM_SIZE_TEXT);

        }finally{
            attributeValuesArray.recycle();
        }
    }


    @Override
    protected void onDraw(Canvas canvas){
        paintColorStyle.setStyle(Paint.Style.FILL);
        paintColorStyle.setAntiAlias(true);
        paintColorStyle.setColor(circleColor);

        int centerX = this.getMeasuredWidth()/2;
        int centerY = this.getMeasuredHeight()/2;
        canvas.drawCircle(centerX, centerY, Constant.RADIUS, paintColorStyle);

        paintColorStyle.setColor(circleTextColor);
        paintColorStyle.setTextAlign(Paint.Align.CENTER);
        paintColorStyle.setTextSize(circleTextSize);

        canvas.drawText(circleText, centerX, centerY, paintColorStyle);
    }

    public void setCircleText(String circleText) {
        this.circleText = circleText;
        invalidate();
        requestLayout();
    }

    public void setCircleColor(int circleColor) {
        this.circleColor = circleColor;
        invalidate();
        requestLayout();
    }

    public void setCircleTextColor(int circleTextColor) {
        this.circleTextColor = circleTextColor;
        invalidate();
        requestLayout();
    }

    public void setCircleTextSize(float circleTextSize) {
        this.circleTextSize = circleTextSize;
        invalidate();
        requestLayout();
    }
}
