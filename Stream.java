public class Stream {
    Integer id;
    String name;
    Integer streamType;
    Integer streamGenre;
    Long noOfStreams;
    Integer streamerId;
    Long length;
    Long dateAdded;


    public Stream(Integer streamType, Integer id, Integer streamGenre, Long noOfStreams, Integer streamerId, Long length, Long dateAdded, String name) {
        this.streamType = streamType;
        this.id = id;
        this.streamGenre = streamGenre;
        this.noOfStreams = noOfStreams;
        this.streamerId = streamerId;
        this.length = length;
        this.dateAdded = dateAdded;
        this.name = name;
    }

    public void setStreamType(Integer streamType) {
        this.streamType = streamType;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStreamGenre(Integer streamGenre) {
        this.streamGenre = streamGenre;
    }

    public void setNoOfStreams(Long noOfStreams) {
        this.noOfStreams = noOfStreams;
    }

    public void setStreamerId(Integer streamerId) {
        this.streamerId = streamerId;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public void setDateAdded(Long dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStreamerId() {
        return streamerId;
    }

    public Integer getStreamType() {
        return streamType;
    }

    public Integer getId() {
        return id;
    }

    public Integer getStreamGenre() {
        return streamGenre;
    }

    public Long getNoOfStreams() {
        return noOfStreams;
    }

    public Long getLength() {
        return length;
    }

    public Long getDateAdded() {
        return dateAdded;
    }

    public String getName() {
        return name;
    }

    public static Stream getStreamById(Integer id) {
        for (Stream s : ProiectPOO.streamsList)
            if (s.getId().equals(id)) {
                return s;
            }
        return null;
    }


    @Override
    public String toString() {
        return "Stream{" +
                "streamType=" + streamType +
                ", id=" + id +
                ", streamGenre=" + streamGenre +
                ", noOfStreams=" + noOfStreams +
                ", streamerId=" + streamerId +
                ", length=" + length +
                ", dateAdded=" + dateAdded +
                ", name='" + name + '\'' +
                '}';
    }
}
