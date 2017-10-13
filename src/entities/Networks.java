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
 * @author Jociane Franzoni de Lima
 * @author Lucas Penha de Moura
 *
 * ------------------- Trabalho de Conclusão de Curso ---------------------
 * ---------------------- Engenharia de Computação ------------------------
 * ------------- Universidade Tecnológica Federal do Paraná ---------------
 *
 */

@Entity
public class Networks implements Serializable {

    @Id
    private int network_id;
    private String networkName;
    private String networkAbout;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "country_id")
    private Countries networkCountry;

    @ManyToMany(mappedBy = "movieNetworks")
    private List<Movies> movies;

    @ManyToMany(mappedBy = "tvSerieNetworks")
    private List<TVSeries> tvSeries;

    /*--------------------Constructors-------------------*/
    public Networks() {
    }

    public Networks(int network_id, String networkName, Countries networkCountry, String networkAbout) {
        this.network_id = network_id;
        this.networkName = networkName;
        this.networkAbout = networkAbout;
        this.networkCountry = networkCountry;
    }

    /*--------------------Constructors-------------------*/
    public int getNetwork_id() {
        return network_id;
    }

    public void setNetwork_id(int network_id) {
        this.network_id = network_id;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String getNetworkAbout() {
        return networkAbout;
    }

    public void setNetworkAbout(String networkAbout) {
        this.networkAbout = networkAbout;
    }

    public Countries getNetworkCountry() {
        return networkCountry;
    }

    public void setNetworkCountry(Countries networkCountry) {
        this.networkCountry = networkCountry;
    }

    public List<Movies> getMovies() {
        return movies;
    }

    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }

    public List<TVSeries> getTvSeries() {
        return tvSeries;
    }

    public void setTvSeries(List<TVSeries> tvSeries) {
        this.tvSeries = tvSeries;
    }

}
