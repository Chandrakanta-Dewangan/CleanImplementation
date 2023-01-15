package com.learning.domain.repository

import com.learning.domain.model.Ads
import com.learning.domain.model.Result

interface ClassifiedListingRepository {
    suspend fun getAllAds(): Result<Ads>
}