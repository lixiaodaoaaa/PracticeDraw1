package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View{
    
    
    private int mWidth;
    private int mHeight;
    
    private int circleGap=50;
    private float circleRadio=60.0f;
    private int marginTop=10;
    private Paint paint;
    
    public Practice2DrawCircleView(Context context){
        super(context);
        
    }
    
    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        
    }
    
    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }
    
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh){
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth=w;
        mHeight=h;
    }
    
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        
        
        int firstCircleLeft=mWidth / 2 - circleGap - Math.round(circleRadio);
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        
        paint.setColor(Color.BLACK);
        
        canvas.drawCircle(firstCircleLeft, marginTop + Math.round(circleRadio), circleRadio, paint);
        
        Paint paintStroke=new Paint(Paint.ANTI_ALIAS_FLAG);
        paintStroke.setStyle(Paint.Style.STROKE);
        paintStroke.setColor(Color.BLACK);
        
        canvas.drawCircle(firstCircleLeft + circleGap + 2 * Math.round(circleRadio), marginTop + Math.round(circleRadio), circleRadio, paintStroke);
        
        
        Paint paintBlue=new Paint(Paint.ANTI_ALIAS_FLAG);
        paintBlue.setStyle(Paint.Style.FILL);
        paintBlue.setColor(Color.BLUE);
        
        canvas.drawCircle(firstCircleLeft, 2 * marginTop + 3 * Math.round(circleRadio), circleRadio, paintBlue);
    
        Paint paintAll=new Paint(Paint.ANTI_ALIAS_FLAG);
        paintAll.setStrokeWidth(20);
        paintAll.setStyle(Paint.Style.STROKE);
        paintAll.setColor(Color.BLUE);
    
        canvas.drawCircle(firstCircleLeft + circleGap + 2 * Math.round(circleRadio), 2 * marginTop + 3 * Math.round(circleRadio), circleRadio, paintAll);
        
    }
}
