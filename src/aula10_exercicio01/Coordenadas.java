package aula10_exercicio01;
  

public class Coordenadas {
    private int Lat;
    private int Long;
    private String data_hora;
    private String Desc;

    public Coordenadas(int Lat, int Long, String data_hora, String Desc) {
        this.Lat = Lat;
        this.Long = Long;
        this.data_hora = data_hora;
        this.Desc = Desc;
    }

    public Coordenadas() {
    }

    public int getLat() {
        return Lat;
    }

    public void setLat(int Lat) {
        this.Lat = Lat;
    }

    public int getLong() {
        return Long;
    }

    public void setLong(int Long) {
        this.Long = Long;
    }

    public String getData_hora() {
        return data_hora;
    }

    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

    @Override
    public String toString() {
        return Lat + " - " + Long;
    }
    
    
    
}
