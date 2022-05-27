package marcos.fransisco.proyectofinal.Retrofit.Class

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIServicio {
    @GET
    suspend fun getPerrosXRaza(@Url url:String): Response<ClassPerro>
}