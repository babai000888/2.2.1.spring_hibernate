package hiber.model;

import javax.persistence.*;

    @Entity
    public class Car {

        @Id
        @GeneratedValue
        private Long id;

        private String model;
        private int series;

        @OneToOne
        @JoinColumn(name = "id")
        private User user;

        public Car() {}

        public Car(String model, int series) {
            this.model = model;
            this.series = series;
        }


        public Long getId() {
        return id;
    }
        public void setId(Long id) {
        this.id = id;
    }
        public String getModel() {
        return model;
    }
        public void setModel(String model) {
        this.model = model;
    }
        public int getSeries() {
        return series;
    }
        public void setSeries(int series) {
        this.series = series;
    }

        @Override
        public String toString() {
            return "\nCar{" +
                    "id=" + id +
                    ", model='" + model + '\'' +
                    ", series=" + series;
        }
    }
