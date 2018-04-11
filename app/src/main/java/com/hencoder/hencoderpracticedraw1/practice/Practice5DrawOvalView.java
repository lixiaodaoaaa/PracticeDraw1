package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class Practice5DrawOvalView extends View{
    
    
    private int mWidth;
    private int mHeight;
    
    private float rectWidth=150;
    private float rectHeight=50;
    private float marginTop=50.0f;
    
    
    public Practice5DrawOvalView(Context context){
        super(context);
    }
    
    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
    }
    
    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }
    
    
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh){
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth=w;
        mHeight=h;
    }
    
    
    @RequiresApi(api=Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawOval() 方法画椭圆
        
        
        float left=mWidth / 2 - rectWidth / 2;
        float top=marginTop;
        
        float right=left + rectWidth;
        float bottom=marginTop + rectHeight;
    
    
        Paint  paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        
        canvas.drawOval(left,top,right,bottom,paint);
    }
}
