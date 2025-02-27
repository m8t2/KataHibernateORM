package hiber.model;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name = "cars")
public class Car {

    @Column(name = "model")
    String model;

    @Id
    @Column(name = "series")
    Long series;

    public Car(String model, Long series) {
        this.model = model;
        this.series = series;
    }

    public Car() {
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(Long series) {
        this.series = series;
    }

    public Long getSeries() {
        return series;
    }

    public String getModel() {
        return model;
    }
}
