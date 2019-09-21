package sierra.com.presentation.main

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import sierra.com.domain.model.Beer
import sierra.com.presentation.extensions.displayImage

class BeerViewModel : ViewModel() {

    private val title = MutableLiveData<String>()
    private val body = MutableLiveData<String>()
    private val image = MutableLiveData<String>()

    fun bind(beer: Beer) {
        title.value = beer.name
        body.value = beer.description
        image.value = beer.image_url
    }

    fun getTitle(): MutableLiveData<String> {
        return title
    }

    fun getBody(): MutableLiveData<String> {
        return body
    }

    fun getImage(): MutableLiveData<String> {
        return image
    }

    companion object {

        @BindingAdapter("profileImage")
        @JvmStatic
        fun loadImage(view: ImageView, imageUrl: String) {
            view.displayImage(view.context, imageUrl)
        }
    }
}