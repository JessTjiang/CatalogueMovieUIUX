package com.jesslyntjiang.android.cataloguemovieuiux.Search;

import org.json.JSONObject;

public class MovieList {
    String judulFilm, deskripsiFilm, tanggalFilm, fotoFilm, ratingFilm, perhitunganRating;

    public MovieList(JSONObject jsonObject){
        try{
            String title = jsonObject.getString("title");
            String overview = jsonObject.getString("overview");
            String release_date = jsonObject.getString("release_date");
            String poster_path = jsonObject.getString("poster_path");
            String vote_count = jsonObject.getString("vote_count");
            String vote_average = jsonObject.getString("vote_average");

            this.judulFilm = title;
            this.deskripsiFilm = overview;
            this.tanggalFilm = release_date;
            this.fotoFilm = poster_path;
            this.ratingFilm = vote_count;
            this.perhitunganRating = vote_average;

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getJudulFilm(){
        return judulFilm;
    }
    public void setJudulFilm(String judulFilm){
        this.judulFilm = judulFilm;
    }

    public String getDeskripsiFilm(){
        return deskripsiFilm;
    }
    public void setDeskripsiFilm(String deskripsiFilm){
        this.deskripsiFilm = deskripsiFilm;
    }

    public String getTanggalFilm(){
        return tanggalFilm;
    }
    public void setTanggalFilm(String tanggalFilm){
        this.tanggalFilm = tanggalFilm;
    }

    public String getFotoFilm(){
        return fotoFilm;
    }
    public void setFotoFilm(String fotoFilm){
        this.fotoFilm = fotoFilm;
    }

    public String getRatingFilm(){
        return ratingFilm;
    }
    public void setRatingFilm(String ratingFilm){
        this.ratingFilm = ratingFilm;
    }

    public String getPerhitunganRating(){
        return perhitunganRating;
    }
    public void setPerhitunganRating(String perhitunganRating){
        this.perhitunganRating= perhitunganRating;
    }

}
