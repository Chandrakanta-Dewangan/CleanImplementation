package com.learning.domain.interactor

import com.learning.domain.interactor.base.UseCase
import com.learning.domain.model.Ads
import com.learning.domain.model.OrderType
import com.learning.domain.model.Result
import com.learning.domain.repository.ClassifiedListingRepository
import javax.inject.Inject

class GetAllAdsUseCase @Inject constructor(
    private val repo: ClassifiedListingRepository
) : UseCase<Result<Ads>, GetAllAdsUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<Ads> {
        params!!
        return when (val result = repo.getAllAds()) {
            is Result.Error -> {
                result
            }
            is Result.Success<Ads> -> {
                val sortedList = when (params.orderType) {
                    OrderType.Ascending -> result.data.ads.sortedBy { it.name }
                    OrderType.Descending -> result.data.ads.sortedByDescending { it.name }
                }
                Result.Success(Ads(sortedList))
            }
        }
    }

    data class Params(val orderType: OrderType)
}