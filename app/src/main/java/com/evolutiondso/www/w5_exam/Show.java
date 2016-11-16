package com.evolutiondso.www.w5_exam;

import com.evolutiondso.www.w5_exam.entities.ResultAPI;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Albrtx on 15/11/2016.
 */

public interface Show {

//    public List<SearchResult> getSearchResults() {
  //      return searchResults;
    //}

    /**
     *
    // * @param searchResults
     *     The search_results
     */
    @GET("search_results?client_id=3092nxybyb0otqw18e8nh5nty&locale=en-US&currency=USD&_format=for_search_results_with_minimal_pricing&_limit=10")
    Call<ResultAPI> retrieveListings(@Query("location") String location);
}
