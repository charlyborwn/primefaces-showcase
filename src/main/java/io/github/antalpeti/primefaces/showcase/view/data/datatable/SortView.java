package io.github.antalpeti.primefaces.showcase.view.data.datatable;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import io.github.antalpeti.primefaces.showcase.domain.Car;
import io.github.antalpeti.primefaces.showcase.service.CarService;

@ManagedBean(name = "datatableSortView")
@ViewScoped
public class SortView implements Serializable {

  private static final long serialVersionUID = 1L;

  private List<Car> cars1;
  private List<Car> cars2;
  private List<Car> cars3;

  @ManagedProperty("#{carService}")
  private CarService service;

  @PostConstruct
  public void init() {
    cars1 = service.createCars(10);
    cars2 = service.createCars(10);
    cars3 = service.createCars(50);
  }

  public List<Car> getCars1() {
    return cars1;
  }

  public List<Car> getCars2() {
    return cars2;
  }

  public List<Car> getCars3() {
    return cars3;
  }

  public void setService(CarService service) {
    this.service = service;
  }
}
