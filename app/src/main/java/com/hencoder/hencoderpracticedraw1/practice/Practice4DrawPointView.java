package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice4DrawPointView extends View{
    
    
    private int mWidth;
    private int mHeight;
    
    private float gap=100.0f;
    
    
    public Practice4DrawPointView(Context context){
        super(context);
    }
    
    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
    }
    
    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
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
        
        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(15);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(Float.parseFloat(String.valueOf(mWidth / 2)) - gap, gap, paint);
        
        
        Paint rectPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        rectPaint.setStrokeWidth(15);
        rectPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(Float.parseFloat(String.valueOf(mWidth / 2)) + gap + 30, gap, rectPaint);
    }
}
