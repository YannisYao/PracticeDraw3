package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice14GetFontMetricsView extends View {
    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    String[] texts = {"A", "a", "J", "j", "Â", "â"};
    int top = 200;
    int bottom = 400;

    public Practice14GetFontMetricsView(Context context) {
        super(context);
    }

    public Practice14GetFontMetricsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice14GetFontMetricsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(20);
        paint1.setColor(Color.parseColor("#E91E63"));
        paint2.setTextSize(160);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(50, top, getWidth() - 50, bottom, paint1);

        // 使用 Paint.getFontMetrics() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让不同的文字的 baseline 对齐
        Paint.FontMetrics fontMetrics   = paint2.getFontMetrics();
        float tempMiddle = (fontMetrics.descent + fontMetrics.ascent)/2;
        float yOffset = -tempMiddle;
        int middle = (top + bottom) / 2;
        for(int i =0 ; i < texts.length;i++){
            canvas.drawText(texts[i], 100+i*100, middle+yOffset, paint2);
        }

        /**
         * 算法原理跟前一个练习类似，采用中心线对齐原理，-(fontMetrics.descent + fontMetrics.ascent)/2 为绘制文字中心线到基准线的距离（为什么是负值请参考前一个练习）
         * 然后我们来处理指定矩形居中的问题，指定矩形中心线为middle，如果让文字的中心线和矩形中心对齐，文字的基准线自然要向下平移-(fontMetrics.descent + fontMetrics.ascent)/2个单位
         */
      /*  canvas.drawText(texts[0], 100, middle, paint2);
        canvas.drawText(texts[1], 200, middle, paint2);
        canvas.drawText(texts[2], 300, middle, paint2);
        canvas.drawText(texts[3], 400, middle, paint2);
        canvas.drawText(texts[4], 500, middle, paint2);
        canvas.drawText(texts[5], 600, middle, paint2);*/
    }
}
