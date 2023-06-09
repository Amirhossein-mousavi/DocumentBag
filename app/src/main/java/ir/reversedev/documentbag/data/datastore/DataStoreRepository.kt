package ir.reversedev.documentbag.data.datastore


interface DataStoreRepository {


    // region put and get String
    suspend fun putString(key: String, value: String)
    suspend fun getString(key: String): String?
    // endregion put and get String

    // region put and get Int
    suspend fun putInt(key: String, value: Int)
    suspend fun getInt(key: String): Int?

    // endregion put and get Int

    // region put and get Boolean
    suspend fun putBoolean(key: String, value: Boolean)
    suspend fun getBoolean(key: String): Boolean?

    // endregion put and get Boolean

}