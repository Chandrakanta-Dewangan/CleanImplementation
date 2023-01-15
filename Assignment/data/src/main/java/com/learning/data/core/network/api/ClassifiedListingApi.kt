package com.learning.data.core.network.api

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Headers

//https://ey3f2y0nre.execute-api.us-east-1.amazonaws.com/default/dynamodb-writer
interface ClassifiedListingApi {
    @GET("default/dynamodb-writer")
    @Headers("Content-type: application/json")
    suspend fun getAllAds(): GetAllAdsResponse
}

/*{
    "results":[
    {
        "created_at":"2019-02-24 04:04:17.566515",
        "price":"AED 5",
        "name":"Notebook",
        "uid":"4878bf592579410fba52941d00b62f94",
        "image_ids":[
        "9355183956e3445e89735d877b798689"
        ],
        "image_urls":[
        "https://demo-app-photos-45687895456123.s3.amazonaws.com/9355183956e3445e89735d877b798689?AWSAccessKeyId=ASIASV3YI6A4RQHLMNML&Signature=%2F9dJtohxUDo39AkBevlPzDFNHL4%3D&x-amz-security-token=IQoJb3JpZ2luX2VjEAYaCXVzLWVhc3QtMSJGMEQCIGYjx00%2B6iyulxGRdVgLGhXkKmpKypWKKeNl2uLHyOIDAiAtW78tF7TmhUEKWJLML7DCHOVfdytnBe%2FvPXAufwMgzSryAggfEAQaDDE4NDM5ODk2Njg0MSIMdLu26Stl1IeoX%2Bw%2FKs8CTc%2FFBgxJQd57a6GqtyXrB1GdCb9160C0auV2sD59ewM1ZUp5CuIFBCe5rwW8PYnUTDqT3NzesW7U9fPYVRDrXVAu%2FRrHBmNPUjYe%2B923Soy94hciUOtcI6DyyDIEdmB%2BvqcoctcerjdnOQ%2FaqjcjE1L6wO%2BzVpBCYN9ozl%2FM6CCGChJNF1ma1jBnCaAS%2BYtFuhwX1gMGhdvowTcq52rmtvYvi2e%2F6p3NiQiFYnh92PHsFFsIPYXTIjs1xqjCPLnw9D59rFBp58q2Wnjs%2F4MHpSitnlzh2x8Sml16ZRrbqYB8H%2FnJYOt%2BimWpk7EnIkQWir66naOiLfLRzPTcUo5EnL28RD6HMEMwem8ydMR9YeuJG3a3%2BysqBa1q4EZwKkzImd3lx6yIl8BRlcdXs0%2F2bpEV003nfUfJ4grClIW6ed%2FzqNkNLdpGP9nRo%2B8SzWUwsYqKnAY6nwHrfHf1dUNvOQEbERYEveQMef0LmdpvkEdqooc5%2FOAjf%2BjOsuUd461kgDsKIyiWieVXyobVO%2FFwJC1bvbHjZTl9CUEnYZebTMBKisMeI1%2BZ9VL3u0RBu%2BpIQcbRZYdCOmBRm7s3Rc8TwU5i1zwLWpSTHXH0qisJEsD%2BVi7M%2BbdZ0xXMUb3zWny3H4Ct6aDUFF3AEwfZNoJ6pt%2FDGKEtIBs%3D&Expires=1669501764"
        ],
        "image_urls_thumbnails":[
        "https://demo-app-photos-45687895456123.s3.amazonaws.com/9355183956e3445e89735d877b798689-thumbnail?AWSAccessKeyId=ASIASV3YI6A4RQHLMNML&Signature=7LRt4HB33HaMyev5mRM8niX7yhc%3D&x-amz-security-token=IQoJb3JpZ2luX2VjEAYaCXVzLWVhc3QtMSJGMEQCIGYjx00%2B6iyulxGRdVgLGhXkKmpKypWKKeNl2uLHyOIDAiAtW78tF7TmhUEKWJLML7DCHOVfdytnBe%2FvPXAufwMgzSryAggfEAQaDDE4NDM5ODk2Njg0MSIMdLu26Stl1IeoX%2Bw%2FKs8CTc%2FFBgxJQd57a6GqtyXrB1GdCb9160C0auV2sD59ewM1ZUp5CuIFBCe5rwW8PYnUTDqT3NzesW7U9fPYVRDrXVAu%2FRrHBmNPUjYe%2B923Soy94hciUOtcI6DyyDIEdmB%2BvqcoctcerjdnOQ%2FaqjcjE1L6wO%2BzVpBCYN9ozl%2FM6CCGChJNF1ma1jBnCaAS%2BYtFuhwX1gMGhdvowTcq52rmtvYvi2e%2F6p3NiQiFYnh92PHsFFsIPYXTIjs1xqjCPLnw9D59rFBp58q2Wnjs%2F4MHpSitnlzh2x8Sml16ZRrbqYB8H%2FnJYOt%2BimWpk7EnIkQWir66naOiLfLRzPTcUo5EnL28RD6HMEMwem8ydMR9YeuJG3a3%2BysqBa1q4EZwKkzImd3lx6yIl8BRlcdXs0%2F2bpEV003nfUfJ4grClIW6ed%2FzqNkNLdpGP9nRo%2B8SzWUwsYqKnAY6nwHrfHf1dUNvOQEbERYEveQMef0LmdpvkEdqooc5%2FOAjf%2BjOsuUd461kgDsKIyiWieVXyobVO%2FFwJC1bvbHjZTl9CUEnYZebTMBKisMeI1%2BZ9VL3u0RBu%2BpIQcbRZYdCOmBRm7s3Rc8TwU5i1zwLWpSTHXH0qisJEsD%2BVi7M%2BbdZ0xXMUb3zWny3H4Ct6aDUFF3AEwfZNoJ6pt%2FDGKEtIBs%3D&Expires=1669501764"
        ]
    },
    {
    },
    {
    },
    ],
"pagination":{
"key":null
}
 */
data class GetAllAdsResponse(
    @SerializedName("pagination") val pagination: Pagination,
    @SerializedName("results") val results: List<Result>
)

data class Pagination(
    @SerializedName("key") val key: Any
)

data class Result(
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("image_ids") val imageIds: List<String>,
    @SerializedName("image_urls") val imageUrls: List<String>,
    @SerializedName("image_urls_thumbnails") val imageUrlsThumbnails: List<String>,
    @SerializedName("name") val name: String,
    @SerializedName("price") val price: String,
    @SerializedName("uid") val uid: String
)