package com.learning.assignment.ui.main.details
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.learning.assignment.R
import com.learning.assignment.databinding.DetailsFragmentBinding
import com.learning.assignment.ui.main.base.BaseFragment
import com.learning.data.core.Constants.DATE_PATTERN_DEFAULT_LOCAL
import com.learning.domain.model.Ad
import java.text.SimpleDateFormat
import java.util.*
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs

class AdDetailsFragment : BaseFragment<DetailsFragmentBinding, AdDetailsViewModel>() {
    override fun setupViewBinding(view: View): DetailsFragmentBinding {
        return DetailsFragmentBinding.bind(view)
    }

    override fun setupViewModel(): AdDetailsViewModel {
        val viewModel: AdDetailsViewModel by viewModels()
        return viewModel
    }

    override val layoutId: Int
        get() = R.layout.details_fragment

    override fun onViewCreated(inflater: LayoutInflater, view: View, savedInstanceState: Bundle?) {
        val args: AdDetailsFragmentArgs by navArgs()
        val ad = args.ad
        viewBinding.title.text = ad.name
        viewBinding.price.text = ad.price
        val date = SimpleDateFormat(
            DATE_PATTERN_DEFAULT_LOCAL,
            Locale.US
        ).format(Objects.requireNonNull(ad.createdAt))
        viewBinding.createdTime.text = date
        setImage(ad)
    }

    private fun setImage(ad: Ad) {
        val drawable = CircularProgressDrawable(requireContext())
        drawable.setColorSchemeColors(
            R.color.purple_200,
            R.color.purple_700,
            R.color.purple_500
        )
        drawable.centerRadius = 30f
        drawable.strokeWidth = 5f
        drawable.start()
        Glide.with(requireContext())
            .load(ad.imageUrlsThumbnails[0])
            .placeholder(drawable)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(20)))
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(viewBinding.imageView)
    }
}
