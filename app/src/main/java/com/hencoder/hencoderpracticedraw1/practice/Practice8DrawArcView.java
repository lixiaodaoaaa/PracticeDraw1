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

public class Practice8DrawArcView extends View{
    
    
    private int mWidth;
    private int mHeight;
    
    private float rectWidth=150;
    private float rectHeight=50;
    private float marginTop=50.0f;
    
    
    public Practice8DrawArcView(Context context){
        super(context);
    }
    
    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
    }
    
    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
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

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        
        
        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        
        paint.setStyle(Paint.Style.FILL); // 填充模式
        canvas.drawArc(100, 100, 400, 300, -110, 20, true, paint); // 绘制扇形
        canvas.drawArc(100, 100, 400, 300, 20, 140, false, paint); // 绘制弧形
        paint.setStyle(Paint.Style.FILL); // 画线模式
        canvas.drawArc(100, 100, 400, 300, 180, 60, false, paint); // 绘制不封口的弧形
    }
}
