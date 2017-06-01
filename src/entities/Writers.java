/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Lucas
 */
@Entity
public class Writers implements Serializable {

    @Id
    private int writer_id;
    private String writerName;
    private String writerAbout;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "country_id")
    private Countries writerCountry;

    @ManyToMany(mappedBy = "movieWriters")
    private List<Movies> movie;

    @ManyToMany(mappedBy = "tvSerieWriters")
    private List<TVSeries> tvSeries;

    /*--------------------Constructors-------------------*/
    public Writers() {
    }

    public Writers(int writer_id, String writerName, Countries writerCountry, String writerAbout) {
        this.writer_id = writer_id;
        this.writerName = writerName;
        this.writerAbout = writerAbout;
        this.writerCountry = writerCountry;
    }

    /*--------------------Constructors-------------------*/
    public int getWriter_id() {
        return writer_id;
    }

    public void setWriter_id(int writer_id) {
        this.writer_id = writer_id;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getWriterAbout() {
        return writerAbout;
    }

    public void setWriterAbout(String writerAbout) {
        this.writerAbout = writerAbout;
    }

    public Countries getWriterCountry() {
        return writerCountry;
    }

    public void setWriterCountry(Countries writerCountry) {
        this.writerCountry = writerCountry;
    }

    public List<Movies> getMovie() {
        return movie;
    }

    public void setMovie(List<Movies> movie) {
        this.movie = movie;
    }

    public List<TVSeries> getTvSeries() {
        return tvSeries;
    }

    public void setTvSeries(List<TVSeries> tvSeries) {
        this.tvSeries = tvSeries;
    }

}
