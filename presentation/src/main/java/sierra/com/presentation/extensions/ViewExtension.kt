package sierra.com.presentation.extensions

import android.content.Context
import android.content.ContextWrapper
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import sierra.com.presentation.di.module.GlideApp
import java.util.*

fun View.getParentActivity(): AppCompatActivity? {
    var context = this.context
    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        }
        context = context.baseContext
    }
    return null
}

fun ImageView.displayImage(context: Context?, url: String?) {
    context ?: run { return }
    url ?: run { return }
    GlideApp.with(context)
        .load(url)
        .thumbnail(0.1f)
        .error(getColor())
        .placeholder(android.R.color.darker_gray)
        .transition(DrawableTransitionOptions.withCrossFade())
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}

private fun getColor(): Int {
    val list = listOf(
        android.R.color.holo_blue_dark,
        android.R.color.holo_green_dark,
        android.R.color.holo_orange_dark,
        android.R.color.holo_red_dark,
        android.R.color.holo_purple
    )
    return list[Random().nextInt(list.size)]
}