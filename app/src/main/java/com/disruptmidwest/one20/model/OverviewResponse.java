package com.disruptmidwest.one20.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jeta on 11/10/17.
 */

public class OverviewResponse {

        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("copyright")
        @Expose
        private String copyright;
        @SerializedName("num_results")
        @Expose
        private int numResults;
        @SerializedName("results")
        @Expose
        private Results results;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public int getNumResults() {
            return numResults;
        }

        public void setNumResults(int numResults) {
            this.numResults = numResults;
        }

        public Results getResults() {
            return results;
        }

        public void setResults(Results results) {
            this.results = results;
        }


}
