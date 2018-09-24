package fileBox;

public class DataInfo {

    private String irank;
    private String movieName;
    private String sumBoxOffice;
    private String movieDay;
    private String boxPer;
    private String time;
public DataInfo(){}
public DataInfo(String irank,String movieName,String sumBoxOffice,String movieDay,String boxPer,String time){
    this.irank=irank;
    this.movieName=movieName;
    this.sumBoxOffice=sumBoxOffice;
    this.movieDay=movieDay;
    this.boxPer=boxPer;
    this.time=time;
}
    public String getIrank() {
        return irank;
    }

    public void setIrank(String irank) {
        this.irank = irank;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getSumBoxOffice() {
        return sumBoxOffice;
    }

    public void setSumBoxOffice(String sumBoxOffice) {
        this.sumBoxOffice = sumBoxOffice;
    }

    public String getBoxPer() {
        return boxPer;
    }

    public void setBoxPer(String boxPer) {
        this.boxPer = boxPer;
    }

    public String getMovieDay() {
        return movieDay;
    }

    public void setMovieDay(String movieDay) {
        this.movieDay = movieDay;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

