package com.learning.data.core.network

import com.learning.data.core.extension.toDate
import com.learning.data.core.network.api.GetAllAdsResponse
import com.learning.data.core.network.api.Result
import com.learning.domain.model.Ad
import com.learning.domain.model.Ads

fun GetAllAdsResponse.toDomain(): Ads = Ads(
    ads = results.toDomain()
)

fun List<Result>.toDomain(): List<Ad> {
    val result = mutableListOf<Ad>()
    this.forEach {
        result.add(it.toDomain())
    }
    return result
}

fun Result.toDomain(): Ad = Ad(
    uid = uid,
    name = name,
    price = price,
    createdAt = createdAt.toDate(),
    imageUrls = imageUrls,
    imageUrlsThumbnails = imageUrlsThumbnails
)