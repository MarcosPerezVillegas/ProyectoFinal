package marcos.fransisco.proyectofinal.Retrofit.Class

import com.google.gson.annotations.SerializedName

data class ClassPerro (@SerializedName("status")var status:String,
                       @SerializedName("message") var imagenes:List<String>)
