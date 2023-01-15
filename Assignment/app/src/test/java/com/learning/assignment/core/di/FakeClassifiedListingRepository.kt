package com.learning.assignment.core.di

import com.learning.domain.model.Ads
import com.learning.domain.model.Result
import com.learning.domain.repository.ClassifiedListingRepository
import com.learning.assignment.core.utils.FakeDataGenerator

class FakeClassifiedListingRepository : ClassifiedListingRepository {
    private val ads = Ads(FakeDataGenerator.getFakeAds())
    override suspend fun getAllAds(): Result<Ads> {
        return Result.Success(ads)
    }
}