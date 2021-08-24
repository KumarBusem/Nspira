package com.busem.nspira.features.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.*
import com.busem.data.models.Repository
import com.busem.data.repositories.DataSourceGithub
import com.busem.data.repositories.RepoPaging
import com.busem.data.repositories.RepoGithub
import com.busem.nspira.common.BaseViewModel
import com.busem.nspira.common.SingleLiveEvent
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val githubRepo: DataSourceGithub = RepoGithub()
) : BaseViewModel() {

    private val _searchTerm by lazy { SingleLiveEvent<String>() }

    private val _repos by lazy { MutableLiveData<List<Repository>>() }
    val repos: LiveData<List<Repository>> by lazy { _repos }


    val listData = Pager(PagingConfig(pageSize = 10)) {
        RepoPaging("kkk")
    }.flow.cachedIn(ioScope)




//    init {
////        searchResults("Android")
//    }

    fun searchResults(searchTerm: String) {
        _searchTerm.postValue(searchTerm)

        ioScope.launch {
            withContext(ioScope.coroutineContext) {
                githubRepo.fetchRepositories(searchTerm)
            }?.let { repos ->
                Log.e("REPOS::", repos.toString())
                _repos.postValue(repos)
                return@let
            } ?: run {
                _repos.postValue(githubRepo.getRepositories())
                return@run
            }
        }

    }

    fun saveSelectedRepo(repo: Repository) {
        repoPrefs.saveRepo(repo)
    }


}