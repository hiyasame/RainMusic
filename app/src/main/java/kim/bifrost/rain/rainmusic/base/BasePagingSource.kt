package kim.bifrost.rain.rainmusic.base

import androidx.paging.PagingSource
import androidx.paging.PagingState

/**
 * kim.bifrost.rain.rainmusic.base.BasePagingSource
 * WanAndroid
 *
 * @author 寒雨
 * @since 2022/1/15 15:12
 **/
open class BasePagingSource<T : Any>(private val getData: suspend (Int) -> List<T>) : PagingSource<Int, T>() {
    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        val pos = params.key ?: 0
        return try {
            // Get data from DataSource
            val pageList = getData(pos)
            // Return data to RecyclerView by LoadResult
            LoadResult.Page(
                pageList,
                if (pos <= 0) null else pos - 1,
                if (pageList.isEmpty()) null else pos + 1
            )
        } catch (exception: Exception) {
            // Return exception by LoadResult
            LoadResult.Error(exception)
        }
    }
}