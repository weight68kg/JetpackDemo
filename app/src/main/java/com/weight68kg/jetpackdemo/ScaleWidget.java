package com.weight68kg.jetpackdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.weight68kg.jetpackdemo.R;

public class ScaleWidget extends View {

    /**
     * 起始刻度
     */
    private int startScale = -2;
    /**
     * 终点刻度
     */
    private int endScale = 2;

    /**
     * eg.endScale(2) - startScale(-3) = 5
     */
    private float range = 0;

    /**
     * 刻度尺精度 每整数有多少单位 endScale - startScale = 4 就有4个整数
     */
    private int accuracy = 10;

    /**
     * 当前刻度
     */
    private float current = 0;

    /**
     * 避免画到屏幕外 安全宽度
     */
    private float saveWidth = 0 ;

    /**
     * 刻度线高度（最长）
     */
    private float scaleHeight = 80;

    /**
     * 文字大小
     */
    private float textSize = 45;


    /**
     * 刻度画笔
     */
    private Paint scalePaint;

    /**
     * 刻度文字画笔
     */
    private Paint scaleTextPaint;

    /**
     * 当前设置刻度画笔
     */
    private Paint currentPaint;



    public ScaleWidget(Context context) {
        this(context,null);
    }

    public ScaleWidget(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ScaleWidget(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    public ScaleWidget(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        scalePaint = new Paint();
        scalePaint.setColor(ContextCompat.getColor(context,R.color.colorAccent));
        scalePaint.setStyle(Paint.Style.FILL);
        scalePaint.setStrokeWidth(2);

        scaleTextPaint = new Paint();
        scaleTextPaint.setTextSize(45);
        scaleTextPaint.setTextAlign(Paint.Align.CENTER);

        currentPaint = new Paint();
        currentPaint.setColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
        currentPaint.setStrokeWidth(3);
        currentPaint.setStyle(Paint.Style.STROKE);

        float StartScaleTextWidth = scaleTextPaint.measureText(String.valueOf(endScale));
        float endScaleTextWidth = scaleTextPaint.measureText(String.valueOf(startScale));
        saveWidth = (StartScaleTextWidth + endScaleTextWidth) / 2f;
        range = Math.max(Math.abs(startScale),Math.abs(endScale)) * 2;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = MeasureSpec.getMode(heightMeasureSpec);
        int measureHeight = MeasureSpec.getSize(heightMeasureSpec);
        int measureWidth = MeasureSpec.getSize(widthMeasureSpec);
        float height = textSize + scaleHeight + saveWidth;

        if ( mode == MeasureSpec.EXACTLY){
            if (measureHeight > height){
                height = measureHeight;
            }
        }else{
            MeasureSpec.makeMeasureSpec(heightMeasureSpec, MeasureSpec.EXACTLY);
        }
        setMeasuredDimension(measureWidth, (int) height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawScaleText(canvas);
        drawScale(canvas);

        drawCurrentScale(canvas);
    }

    /**
     * 文字
     * @param canvas
     */
    private void drawScaleText(Canvas canvas){
        float i = ((getWidth()- getPaddingEnd() - getPaddingStart() - saveWidth) / (float)range) ;
        for (int j = startScale; j <= endScale; j++) {
            canvas.drawText(String.valueOf(j),getWidth()/2+i*j,textSize,scaleTextPaint);
        }
    }

    /**
     * 刻度
     * @param canvas
     */
    private void drawScale(Canvas canvas){
        float i = ((getWidth() - getPaddingEnd() - getPaddingStart() - saveWidth ) / (float)(range * accuracy )) ;
        float scaleBottom = scaleHeight + textSize;
        for (int j = startScale * accuracy; j <= endScale * accuracy; j++) {
            if (j % 10 == 0){
                canvas.drawLine(getWidth()/2+i*j,scaleBottom,getWidth()/2+i*j,scaleBottom - scaleHeight,scalePaint);
            }else if (j % 5 == 0){
                canvas.drawLine(getWidth()/2+i*j,scaleBottom,getWidth()/2+i*j,scaleBottom-(scaleHeight*0.75f),scalePaint);
            }else{
                canvas.drawLine(getWidth()/2+i*j,scaleBottom,getWidth()/2+i*j,scaleBottom-(scaleHeight*0.5f),scalePaint);
            }
        }
        canvas.drawLine(getWidth()/2+i*startScale * accuracy,scaleBottom,getWidth()/2+i*endScale * accuracy,scaleBottom,scalePaint);
    }

    /**
     * 当前刻度
     * @param canvas
     */
    private void drawCurrentScale(Canvas canvas){
        float i = ((getWidth() - getPaddingEnd() - getPaddingStart() - saveWidth ) / (float)(range * accuracy )) ;
        float baseCoordinateX = getWidth() / 2 + i * current * accuracy;
        float scaleBottom = textSize + scaleHeight;
        float baseCoordinateY = scaleBottom + 5;
        Path path = new Path();
        path.moveTo(baseCoordinateX,baseCoordinateY);
        path.lineTo(baseCoordinateX - 10,baseCoordinateY-10);
        path.lineTo(baseCoordinateX + 10,baseCoordinateY-10);
        path.lineTo(baseCoordinateX,baseCoordinateY);
        canvas.drawPath(path, currentPaint);
    }


    public void setCurrent(float scale){
        current = scale;
        invalidate();
    }

    public float getCurrent(){
        return current;
    }
}
