//package br.com.guiacistore.textjustify
//
//import android.content.Context
//import android.os.Build
//import android.text.Layout
//import android.text.Spannable
//import android.text.method.LinkMovementMethod
//import android.text.style.ClickableSpan
//import android.text.util.Linkify
//import android.util.AttributeSet
//import android.view.MotionEvent
//import android.view.View
//import android.widget.Toast
//import br.com.guiacistore.fragments.PromocoesDaSpeedNetFragment
//
//import com.uncopt.android.widget.text.justify.JustifiedTextView
//import org.jetbrains.annotations.NotNull
//
//
//class MyJustifiedTextView(@NotNull context: Context, attrs: AttributeSet) : JustifiedTextView(context, attrs) {
//
//    init {
//        if (!isInEditMode) {
//            val activity = context as PromocoesDaSpeedNetFragment
//            typeface = activity.getTypeface()
//        }
//        setOnClickListener { Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show() }
//    }
//
//    override fun onAttachedToWindow() {
//        super.onAttachedToWindow()
//        // setTextIsSelectable doesn't work unless the text view is attached to the window
//        // because it uses the window layout params to check if it can display the handles.
//        if (Build.VERSION.SDK_INT > 10) {
//            setTextIsSelectable(true)
//        }
//    }
//
//    // We want our text to be selectable, but we still want links to be clickable.
//    override fun onTouchEvent(@NotNull event: MotionEvent): Boolean {
//        val text = text as Spannable
//        if (text != null) {
//            if (event.action == MotionEvent.ACTION_DOWN) {
//                val layout = layout
//                if (layout != null) {
//                    // final int pos = getOffsetForPosition(event.getX(), event.getY()); // API >= 14 only
//                    val line = getLineAtCoordinate(layout, event.y)
//                    val pos = getOffsetAtCoordinate(layout, line, event.x)
//                    val links = text.getSpans(pos, pos, ClickableSpan::class.java)
//                    if (links != null && links.size > 0) {
//                        links[0].onClick(this)
//                        return true
//                    }
//                }
//            }
//        }
//        return super.onTouchEvent(event)
//    }
//
//    private fun getLineAtCoordinate(@NotNull layout: Layout, y: Float): Int {
//        val max = height - totalPaddingBottom - 1
//        val v = Math.min(max, Math.max(0, y.toInt() - totalPaddingTop)) + scrollY
//        return layout.getLineForVertical(v)
//    }
//
//    private fun getOffsetAtCoordinate(@NotNull layout: Layout, line: Int, x: Float): Int {
//        val max = width - totalPaddingRight - 1
//        val v = Math.min(max, Math.max(0, x.toInt() - totalPaddingLeft)) + scrollX
//        return layout.getOffsetForHorizontal(line, v.toFloat())
//    }
//
//}