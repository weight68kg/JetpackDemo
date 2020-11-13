package com.weight68kg.jetpackdemo.architecture

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit

class UserRepository(
    private val executor: Executor,
    private val userDao: UserDao,
    // Simple in-memory cache. Details omitted for brevity.
    private val userCache: UserCache,
    private val webservice: Webservice
) {


    // ...
    fun getUser(userId: String): LiveData<User> {
        val cached : LiveData<User> = userCache.get(userId)
        if (cached != null) {
            return cached
        }
        val data = MutableLiveData<User>()
        // The LiveData object is currently empty, but it's okay to add it to the
        // cache here because it will pick up the correct data once the query
        // completes.
        userCache.put(userId, data)
        // This implementation is still suboptimal but better than before.
        // A complete implementation also handles error cases.
        webservice.getUser(userId).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                data.value = response.body()
            }

            // Error case is left out for brevity.
            override fun onFailure(call: Call<User>, t: Throwable) {
                TODO()
            }
        })
        return data




        refreshUser(userId)
        // Returns a LiveData object directly from the database.
        return userDao.load(userId)
    }

    private fun refreshUser(userId: String) {
        // Runs in a background thread.
        executor.execute {
            // Check if user data was fetched recently.
            val userExists = userDao.hasUser(FRESH_TIMEOUT)
            if (!userExists) {
                // Refreshes the data.
                val response = webservice.getUser(userId).execute()

                // Check for errors here.

                // Updates the database. The LiveData object automatically
                // refreshes, so we don't need to do anything else here.
                userDao.save(response.body()!!)
            }
        }
    }

    companion object {
        val FRESH_TIMEOUT = TimeUnit.DAYS.toMillis(1)
    }
}